/*
 * 创建日期 2006-2-15
 *
 * @author 孙锐
 */
package nc.bs.lowcost.tally;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.naming.NamingException;

import nc.bs.mw.sql.UFConnection;
import nc.bs.pub.DataManageObject;
import nc.bs.pub.SystemException;
import nc.vo.lowcost.cancel.CancelHeaderVO;
import nc.vo.lowcost.cancel.CancelItemVO;
import nc.vo.lowcost.cancel.CancelVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tally.TallyCorpVO;
import nc.vo.lowcost.tally.TallylogVO;
import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.lowcost.trans.TransItemVO;
import nc.vo.lowcost.trans.TransVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;
import nc.bs.lowcost.trans.TransDMO;
import nc.bs.lowcost.cancel.CancelDMO;

/**
 * @author 孙锐
 *
 */
public class TallyDMO extends DataManageObject {

    /**
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public TallyDMO() throws NamingException, SystemException {
        super();
    }

    
    /**
     * @param dbName
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public TallyDMO(String dbName) throws NamingException, SystemException {
        super(dbName);
    }
    
    public void deleteTallyLog(String pk_corp,UFDate date) throws Exception {
    	
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "delete from lc_tallylog where tallydate = '" + date + "' and pk_corp = '" +pk_corp+"'";
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
        }
    	
    }
    
    public UFDate queryLastTallyDate() throws SQLException {
        UFDate lastDate = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select max(tallydate) from lc_tallylog";
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Object obj = rs.getObject(1);
                if(obj!=null){
                    lastDate = new UFDate(obj.toString());
                }
            }
        } finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}          
        }
        return lastDate;
    }
    
    public TallylogVO doUnTally(UFDate date,TallyCorpVO [] tallyCorps) throws SQLException {
    	TallylogVO result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        
        String sqlCorps = "";
        if(tallyCorps!=null){
            for (int i = 0; i < tallyCorps.length; i++) {
                sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
                if(i!=(tallyCorps.length-1)) {
                    sqlCorps += ",";
                }
            }
        }
        
        String sqlQueryTally = "select newsum, cancelsum, transsum from lc_tallylog where tallydate = '" + date + "' and pk_corp in (" + sqlCorps + ")";// and ts = (select max(ts) as ts from lc_tallylog)";
        String sqlCard = "update lc_card set tallyflag = 'N',tallydate = null where tallydate = '" + date + "' and tallyflag = 'Y' and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))" ;
        String sqlTrans = "update lc_trans set tallyflag = 'N',tallydate = null where tallydate = '" + date + "' and tallyflag = 'Y' and pk_trans in (select pk_trans from lc_trans_m where pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + ")))" ;
        String sqlCancel = "update lc_cancel set tallyflag = 'N',tallydate = null where tallydate = '" + date + "' and tallyflag = 'Y' and pk_cancel in (select pk_cancel from lc_cancel_m where pk_lccard in (select pk_lccard from lc_card where pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))))";
        String sqlDelete = "delete from lc_tallylog where tallydate = '" + date + "' and pk_corp in (" + sqlCorps + ")";
        try {
        	con = getConnection();
        	stmt = con.prepareStatement(sqlQueryTally);
        	ResultSet rs = stmt.executeQuery();
        	double newsum = 0.0f, cancelsum = 0.0f, transsum = 0.0f;
        	while(rs.next()){
        		newsum += rs.getDouble(1);
        		cancelsum += rs.getDouble(2);
        		transsum += rs.getDouble(3);
        	}
        	stmt.close();
        	result = new TallylogVO();
        	result.setNewsum(new UFDouble(newsum));
        	result.setCancelsum(new UFDouble(cancelsum));
        	result.setTranssum(new UFDouble(transsum));
        	
            stmt = con.prepareStatement(sqlTrans);
            stmt.executeUpdate();
            stmt.close();
            
            stmt = con.prepareStatement(sqlCancel);
            stmt.executeUpdate();
            stmt.close();
            
            stmt = con.prepareStatement(sqlCard);
            stmt.executeUpdate();
            stmt.close();
            
            stmt = con.prepareStatement(sqlDelete);
            stmt.executeUpdate();  
            stmt.close();
        } finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}          
        }
        
        return result;
    }
    
    public TallylogVO doTally(UFDate date,String pk_corp,String pk_user,TallyCorpVO[] tallyCorps) throws SQLException {
        
        TallylogVO retvo = new TallylogVO();
        retvo.setNewsum(new UFDouble(0.0f));
        retvo.setCancelsum(new UFDouble(0.0f));
        retvo.setTranssum(new UFDouble(0.0f));
    	Connection con = null;
    	PreparedStatement stmt = null;
    	
        String sqlCorps = "";
        if(tallyCorps!=null){
            for (int i = 0; i < tallyCorps.length; i++) {
                sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
                if(i!=(tallyCorps.length-1)) {
                    sqlCorps += ",";
                }
            }
        }
        
		String sqlCardQuery = "select sum(price*\"number\") from lc_card where (tallyflag is null or tallyflag = 'N') and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";// and def2 is not null";
		String sqlCardUpdate = "update lc_card set tallyflag = 'Y',tallydate = '" + date + "' where (tallyflag is null or tallyflag like 'N' or tallydate is null) and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";// and def2 is not null";
		String sqlCancelQuery = "select sum(price*\"number\") from lc_cancel_m cm,lc_cancel c,lc_card card where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard and c.dr=0 and (c.tallyflag is null or c.tallyflag = 'N') and c.checkflag = 'Y' and card.pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
		String sqlCancelUpdate = "update lc_cancel set tallyflag = 'Y',tallydate = '" + date + "' where (tallyflag is null or tallyflag = 'N') and checkflag='Y' and pk_cancel in (select pk_cancel from lc_cancel_m where pk_lccard in (select pk_lccard from lc_card where pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))))";
		String sqlTransQuery = "select count(*) from lc_trans_m tm,lc_trans t where tm.pk_trans=t.pk_trans and t.dr=0 and (t.tallyflag is null or t.tallyflag = 'N') and t.checkflag = 'Y' and tm.pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
		String sqlTransUpdate = "update lc_trans  set tallyflag = 'Y',tallydate = '" + date + "' where (tallyflag is null or tallyflag = 'N') and checkflag = 'Y' and pk_trans in (select pk_trans from lc_trans_m where pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + ")))";
		
        try {
            con = getConnection();
            if(isDB2(con)){
        		sqlCardQuery = "select sum(price*number) from lc_card where (tallyflag is null or tallyflag = 'N') and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))"; // and def2 is not null";
        		sqlCardUpdate = "update lc_card set tallyflag = 'Y',tallydate = '" + date + "' where (tallyflag is null or tallyflag = 'N') and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))"; // and def2 is not null";
        		sqlCancelQuery = "select sum(price*number) from lc_cancel_m cm,lc_cancel c,lc_card card where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard and c.dr=0 and (c.tallyflag is null or c.tallyflag = 'N') and c.checkflag = 'Y' and card.pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
        	    sqlCancelUpdate = "update lc_cancel set tallyflag = 'Y',tallydate = '" + date + "' where (tallyflag is null or tallyflag = 'N') and checkflag='Y' and pk_cancel in (select pk_cancel from lc_cancel_m where pk_lccard in (select pk_lccard from lc_card where pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))))";
        		sqlTransQuery = "select count(*) from lc_trans_m tm,lc_trans t where tm.pk_trans=t.pk_trans and t.dr=0 and (t.tallyflag is null or t.tallyflag = 'N') and t.checkflag = 'Y' and tm.pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
        		sqlTransUpdate = "update lc_trans  set tallyflag = 'Y',tallydate = '" + date + "' where (tallyflag is null or tallyflag = 'N') and checkflag = 'Y' and pk_trans in (select pk_trans from lc_trans_m where pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + ")))";
        		
            }
            
    		//卡片统计
    		stmt = con.prepareStatement(sqlCardQuery);
    		ResultSet rs = stmt.executeQuery();
    		if(rs.next()){
    		    Object objNewSum = rs.getObject(1);
    		    UFDouble newSum = null;
    		    if(objNewSum!=null){
    			    if(objNewSum instanceof Integer){
    			        newSum = new UFDouble(((Integer)objNewSum).intValue());
    			    }
    			    if(objNewSum instanceof BigDecimal){
    			        newSum = new UFDouble((BigDecimal)objNewSum);
    			    }
    		        retvo.setNewsum(newSum);
    		    }
    		}
    		stmt.close();
    		//卡片更新
    		stmt = con.prepareStatement(sqlCardUpdate);
    		stmt.executeUpdate();
    		stmt.close();
    		
    		//调拨统计
    		stmt = con.prepareStatement(sqlTransQuery);
    		ResultSet rs1 = stmt.executeQuery();
    		if(rs1.next()){
    		    Object objTransSum = rs1.getObject(1);
    		    UFDouble transSum = null;
    		    if(objTransSum!=null){
    			    if(objTransSum instanceof Integer){
    			        transSum = new UFDouble(((Integer)objTransSum).intValue());
    			    }
    			    if(objTransSum instanceof BigDecimal){
    			        transSum = new UFDouble((BigDecimal)objTransSum);
    			    }
    		        retvo.setTranssum(transSum);		    
    		    }
    		}
    		
    		//调拨更新
    		stmt = con.prepareStatement(sqlTransUpdate);
    		stmt.executeUpdate();
    		stmt.close();
    		
    		//核销统计
    		stmt = con.prepareStatement(sqlCancelQuery);
    		ResultSet rs2 = stmt.executeQuery();
    		if(rs2.next()){
    		    Object objCancelSum = rs2.getObject(1);
    		    UFDouble cancelSum = null;
    		    if(objCancelSum!=null){
    			    if(objCancelSum instanceof Integer){
    			        cancelSum = new UFDouble(((Integer)objCancelSum).intValue());
    			    }
    			    if(objCancelSum instanceof BigDecimal){
    			        cancelSum = new UFDouble((BigDecimal)objCancelSum);
    			    }
    		        retvo.setCancelsum(cancelSum);		    
    		    }
    		}		
    		//核销更新
    		stmt = con.prepareStatement(sqlCancelUpdate);
    		stmt.executeUpdate();
    		
    		TallylogVO logVO = (TallylogVO) retvo.clone();
    		logVO.setTallydate(date);
    		logVO.setPk_corp(pk_corp);
    		logVO.setPk_user(pk_user);
    		try {
    		    (new TallylogDMO()).insert(logVO);
    		} catch(Exception e) {
    		    throw new SQLException (e.getMessage());
    		}
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        } finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}          
        }
        return retvo;
    }
    
    public CardVO [] findTallyCard(TallyCorpVO [] tallyCorps) throws SQLException{
    	CardVO cards[] = null;
    	Vector v = new Vector();
    	String sqlCorps = "";
    	String strSql = null;
    	Connection con = null;
    	PreparedStatement stmt = null;
    	try {
    		con = getConnection();
            if (tallyCorps != null) {
				for (int i = 0; i < tallyCorps.length; i++) {
					sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
					if (i != (tallyCorps.length - 1)) {
						sqlCorps += ",";
					}
				}
			}
			if (isDB2(con)) {
				strSql = "select pk_lccard, lccode, lcname, pk_lctype, pk_managedept, pk_usedept, tallyflag, cancelflag, buydate, adddate, tallydate, canceldate, price, number, remark, def1, def2, def3, def4, def5 from lc_card";
			} else {
				strSql = "select pk_lccard, lccode, lcname, pk_lctype, pk_managedept, pk_usedept, tallyflag, cancelflag, buydate, adddate, tallydate, canceldate, price, \"number\", remark, def1, def2, def3, def4, def5 from lc_card";
			}
			strSql += " where (tallyflag='N' or tallyflag is null) and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in ("
					+ sqlCorps + ")) ";
			
			stmt = con.prepareStatement(strSql);
            ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CardVO card = new CardVO();
				// pk_lccard :
				String pk_lccard = rs.getString(1);
				card.setPk_lccard(pk_lccard == null ? null : pk_lccard.trim());
				// lccode :
				String lccode = rs.getString(2);
				card.setLccode(lccode == null ? null : lccode.trim());
				// lcname :
				String lcname = rs.getString(3);
				card.setLcname(lcname == null ? null : lcname.trim());
				// pk_lctype :
				String pk_lctype = rs.getString(4);
				card.setPk_lctype(pk_lctype == null ? null : pk_lctype.trim());
				// pk_managedept :
				String pk_managedept = rs.getString(5);
				card.setPk_managedept(pk_managedept == null ? null
						: pk_managedept.trim());
				// pk_usedept :
				String pk_usedept = rs.getString(6);
				card.setPk_usedept(pk_usedept == null ? null : pk_usedept
						.trim());
				// tallyflag :
				String tallyflag = rs.getString(7);
				card.setTallyflag(tallyflag == null ? null : new UFBoolean(
						tallyflag.trim()));
				// cancelflag :
				String cancelflag = rs.getString(8);
				card.setCancelflag(cancelflag == null ? null : new UFBoolean(
						cancelflag.trim()));
				// buydate :
				String buydate = rs.getString(9);
				card.setBuydate(buydate == null ? null : new UFDate(buydate.trim()));
    			// adddate :
    			String adddate = rs.getString(10);
    			card.setAdddate(adddate == null ? null : new UFDate(adddate.trim()));
    			// tallydate :
    			String tallydate = rs.getString(11);
    			card.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
    			// canceldate :
    			String canceldate = rs.getString(12);
    			card.setCanceldate(canceldate == null ? null : new UFDate(canceldate.trim()));
    			// price :
    			BigDecimal price = (BigDecimal)rs.getObject(13);
    			card.setPrice(price == null ? null : new UFDouble(price));
    			// number :
    			BigDecimal number = (BigDecimal)rs.getObject(14);
    			card.setNumber(number == null ? null : new UFDouble(number));
    			// remark :
    			String remark = rs.getString(15);
    			card.setRemark(remark == null ? null : remark.trim());
    			// def1 :
    			String def1 = rs.getString(16);
    			card.setDef1(def1 == null ? null : def1.trim());
    			// def2 :
    			String def2 = rs.getString(17);
    			card.setDef2(def2 == null ? null : def2.trim());
    			// def3 :
    			String def3 = rs.getString(18);
    			card.setDef3(def3 == null ? null : def3.trim());
    			// def4 :
    			String def4 = rs.getString(19);
    			card.setDef4(def4 == null ? null : def4.trim());
    			// def5 :
    			String def5 = rs.getString(20);
    			card.setDef5(def5 == null ? null : def5.trim());

    			v.addElement(card);
    		}
    	}
    	finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
    	}
    	cards = new CardVO[v.size()];
    	if (v.size() > 0) {
    		v.copyInto(cards);
    	}
    	return cards;
    }
    
    public CardVO[] findUntallyCard(TallyCorpVO [] tallyCorps, UFDate date) throws SQLException{
    	CardVO[] cards = null;
    	Vector v = new Vector();
    	String sqlCorps = "";
    	String strSql = null;
    	Connection con = null;
    	PreparedStatement stmt = null;
    	try{
    		con = getConnection();
            if (tallyCorps != null) {
				for (int i = 0; i < tallyCorps.length; i++) {
					sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
					if (i != (tallyCorps.length - 1)) {
						sqlCorps += ",";
					}
				}
			}
			if (isDB2(con)) {
				strSql = "select pk_lccard, lccode, lcname, pk_lctype, pk_managedept, pk_usedept, tallyflag, cancelflag, buydate, adddate, tallydate, canceldate, price, number, remark, def1, def2, def3, def4, def5 from lc_card";
			} else {
				strSql = "select pk_lccard, lccode, lcname, pk_lctype, pk_managedept, pk_usedept, tallyflag, cancelflag, buydate, adddate, tallydate, canceldate, price, \"number\", remark, def1, def2, def3, def4, def5 from lc_card";
			}
			;strSql += " where tallyflag='Y' and tallydate like '"+ date +"' and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in ("
					+ sqlCorps + ")) ";
			
			stmt = con.prepareStatement(strSql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
				CardVO card = new CardVO();
				// pk_lccard :
				String pk_lccard = rs.getString(1);
				card.setPk_lccard(pk_lccard == null ? null : pk_lccard.trim());
				// lccode :
				String lccode = rs.getString(2);
				card.setLccode(lccode == null ? null : lccode.trim());
				// lcname :
				String lcname = rs.getString(3);
				card.setLcname(lcname == null ? null : lcname.trim());
				// pk_lctype :
				String pk_lctype = rs.getString(4);
				card.setPk_lctype(pk_lctype == null ? null : pk_lctype.trim());
				// pk_managedept :
				String pk_managedept = rs.getString(5);
				card.setPk_managedept(pk_managedept == null ? null
						: pk_managedept.trim());
				// pk_usedept :
				String pk_usedept = rs.getString(6);
				card.setPk_usedept(pk_usedept == null ? null : pk_usedept
						.trim());
				// tallyflag :
				String tallyflag = rs.getString(7);
				card.setTallyflag(tallyflag == null ? null : new UFBoolean(
						tallyflag.trim()));
				// cancelflag :
				String cancelflag = rs.getString(8);
				card.setCancelflag(cancelflag == null ? null : new UFBoolean(
						cancelflag.trim()));
				// buydate :
				String buydate = rs.getString(9);
				card.setBuydate(buydate == null ? null : new UFDate(buydate.trim()));
    			// adddate :
    			String adddate = rs.getString(10);
    			card.setAdddate(adddate == null ? null : new UFDate(adddate.trim()));
    			// tallydate :
    			String tallydate = rs.getString(11);
    			card.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
    			// canceldate :
    			String canceldate = rs.getString(12);
    			card.setCanceldate(canceldate == null ? null : new UFDate(canceldate.trim()));
    			// price :
    			BigDecimal price = (BigDecimal)rs.getObject(13);
    			card.setPrice(price == null ? null : new UFDouble(price));
    			// number :
    			BigDecimal number = (BigDecimal)rs.getObject(14);
    			card.setNumber(number == null ? null : new UFDouble(number));
    			// remark :
    			String remark = rs.getString(15);
    			card.setRemark(remark == null ? null : remark.trim());
    			// def1 :
    			String def1 = rs.getString(16);
    			card.setDef1(def1 == null ? null : def1.trim());
    			// def2 :
    			String def2 = rs.getString(17);
    			card.setDef2(def2 == null ? null : def2.trim());
    			// def3 :
    			String def3 = rs.getString(18);
    			card.setDef3(def3 == null ? null : def3.trim());
    			// def4 :
    			String def4 = rs.getString(19);
    			card.setDef4(def4 == null ? null : def4.trim());
    			// def5 :
    			String def5 = rs.getString(20);
    			card.setDef5(def5 == null ? null : def5.trim());

    			v.addElement(card);
    		}
    	}finally{
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
    	}
    	cards = new CardVO[v.size()];
    	if (v.size() > 0) {
    		v.copyInto(cards);
    	}
		return cards;    	
    }
    
    
    public TransVO[] findTallyTrans(TallyCorpVO [] tallyCorps) throws SQLException {

    	TransVO[] vos = null;
    	TransHeaderVO[] headers = findHeaderTrans(tallyCorps);
    	TransItemVO[] items = null;
    	if ((headers != null)&&(headers.length>0)) {
    		vos = new TransVO[headers.length];
    		for(int i=0;i<headers.length;i++)
    		{ 
    			try {
					items = (new TransDMO()).findItemsForHeader(headers[i].getPk_trans());
				} catch (Exception e) {
					
				} 
				vos[i] = new TransVO();
				vos[i].setParentVO(headers[i]);
    		 	vos[i].setChildrenVO(items);
    		 }
    		}
    	
    	return vos;
    }
    
    public TransVO[] findUntallyTrans(TallyCorpVO[] tallyCorps, UFDate date) throws SQLException {
    	TransVO[] vos = null;
    	TransItemVO[] items = null;
    	TransHeaderVO[] headers = findHeaderTrans(tallyCorps);
    	if ((headers != null)&&(headers.length>0)) {
    		vos = new TransVO[headers.length];
    		for(int i=0;i<headers.length;i++)
    		{ 
    			try {
					items = (new TransDMO()).findItemsForHeader(headers[i].getPk_trans());
				} catch (Exception e) {
					
				} 
				vos[i] = new TransVO();
				vos[i].setParentVO(headers[i]);
    		 	vos[i].setChildrenVO(items);
    		 }
    		}
    	return vos;
    }
    
    public CancelVO [] findTallyCancel (TallyCorpVO [] tallyCorps) throws SQLException {

    	CancelVO [] vos = null;
    	CancelHeaderVO[] headers = findHeaderCancel(tallyCorps);
    	CancelItemVO[] items = null;
    	if ((headers != null)&&(headers.length>0)) {
    		vos = new CancelVO [headers.length];
    		for(int i=0;i<headers.length;i++)
    		{ 
    			try {
					items = (new CancelDMO()).findItemsForHeader(headers[i].getPk_cancel());
				} catch (Exception e) {
					
				} 
    		 	vos[i] = new CancelVO();
				vos[i].setParentVO(headers[i]);
    		 	vos[i].setChildrenVO(items);
    		 }
    		}
    	
    	return vos;
    }
    
    public CancelVO[] findUntallyCancel(TallyCorpVO[] tallyCorps, UFDate date) throws SQLException{    
    	CancelVO [] vos = null;
    	CancelHeaderVO[] headers = findHeaderCancel1(tallyCorps, date);
    	CancelItemVO[] items = null;
    	if ((headers != null)&&(headers.length>0)) {
    		vos = new CancelVO [headers.length];
    		for(int i=0;i<headers.length;i++)
    		{ 
    			try {
					items = (new CancelDMO()).findItemsForHeader(headers[i].getPk_cancel());
				} catch (Exception e) {}		
    		 	vos[i] = new CancelVO();
				vos[i].setParentVO(headers[i]);
    		 	vos[i].setChildrenVO(items);
    		 }
    	}    	
    	return vos;
    }
    
    public CancelHeaderVO[] findHeaderCancel1(TallyCorpVO [] tallyCorps, UFDate date) throws SQLException{
    	CancelHeaderVO[] cancelHeaders = null; 
    	Vector v = new Vector();
    	String sqlCorps = "";
         if(tallyCorps!=null){
             for (int i = 0; i < tallyCorps.length; i++) {
                 sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
                 if(i!=(tallyCorps.length-1)) {
                     sqlCorps += ",";
                 }
             }
         }
    	String sql = "select distinct c.cancelcode, c.cancelreason, c.pk_maker, c.makedate, c.pk_checker, c.checkdate, c.checkflag, c.tallyflag, c.tallydate, c.def1, c.def2, c.def3, c.def4, c.def5,c.pk_cancel  " +
    			" from lc_cancel c,lc_card card,lc_cancel_m cm" +
    			" where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard and c.dr=0 " +
    			" and c.tallyflag = 'Y' and c.tallydate = '"+ date +"' and c.checkflag = 'Y' and card.pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
    	
    	
    	Connection con = null;
    	PreparedStatement stmt = null;
    	try {
    		con = getConnection();
    		stmt = con.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		//
    		while (rs.next()) {
    			CancelHeaderVO cancelHeader = new CancelHeaderVO();
    			// cancelcode :
    			String cancelcode = rs.getString(1);
    			cancelHeader.setCancelcode(cancelcode == null ? null : cancelcode.trim());
    			// cancelreason :
    			String cancelreason = rs.getString(2);
    			cancelHeader.setCancelreason(cancelreason == null ? null : cancelreason.trim());
    			// pk_maker :
    			String pk_maker = rs.getString(3);
    			cancelHeader.setPk_maker(pk_maker == null ? null : pk_maker.trim());
    			// makedate :
    			String makedate = rs.getString(4);
    			cancelHeader.setMakedate(makedate == null ? null : new UFDate(makedate.trim()));
    			// pk_checker :
    			String pk_checker = rs.getString(5);
    			cancelHeader.setPk_checker(pk_checker == null ? null : pk_checker.trim());
    			// checkdate :
    			String checkdate = rs.getString(6);
    			cancelHeader.setCheckdate(checkdate == null ? null : new UFDate(checkdate.trim()));
    			// checkflag :
    			String checkflag = rs.getString(7);
    			cancelHeader.setCheckflag(checkflag == null ? null : new UFBoolean(checkflag.trim()));
    			// tallyflag :
    			String tallyflag = rs.getString(8);
    			cancelHeader.setTallyflag(tallyflag == null ? null : new UFBoolean(tallyflag.trim()));
    			// tallydate :
    			String tallydate = rs.getString(9);
    			cancelHeader.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
    			// def1 :
    			String def1 = rs.getString(10);
    			cancelHeader.setDef1(def1 == null ? null : def1.trim());
    			// def2 :
    			String def2 = rs.getString(11);
    			cancelHeader.setDef2(def2 == null ? null : def2.trim());
    			// def3 :
    			String def3 = rs.getString(12);
    			cancelHeader.setDef3(def3 == null ? null : def3.trim());
    			// def4 :
    			String def4 = rs.getString(13);
    			cancelHeader.setDef4(def4 == null ? null : def4.trim());
    			// def5 :
    			String def5 = rs.getString(14);
    			cancelHeader.setDef5(def5 == null ? null : def5.trim());
                // pk_cancel :
    			String pk_cancel = rs.getString(15);
    			cancelHeader.setPk_cancel(pk_cancel == null ? null : pk_cancel.trim());
    			
    			v.addElement(cancelHeader);
    		}
    	}
    	finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
    	}

    	cancelHeaders = new CancelHeaderVO[v.size()];
    	if (v.size() > 0) {
    		v.copyInto(cancelHeaders);
    	}
    	
    	return cancelHeaders;
    }
    
    public CancelHeaderVO[] findHeaderCancel(TallyCorpVO [] tallyCorps) throws SQLException {

    	CancelHeaderVO[] cancelHeaders = null; 
    	Vector v = new Vector();
    	String sqlCorps = "";
         if(tallyCorps!=null){
             for (int i = 0; i < tallyCorps.length; i++) {
                 sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
                 if(i!=(tallyCorps.length-1)) {
                     sqlCorps += ",";
                 }
             }
         }
    	String sql = "select distinct c.cancelcode, c.cancelreason, c.pk_maker, c.makedate, c.pk_checker, c.checkdate, c.checkflag, c.tallyflag, c.tallydate, c.def1, c.def2, c.def3, c.def4, c.def5,c.pk_cancel  " +
    			" from lc_cancel c,lc_card card,lc_cancel_m cm" +
    			" where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard and c.dr=0 " +
    			" and (c.tallyflag is null or c.tallyflag = 'N') and c.checkflag = 'Y' and card.pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
    	
    	
    	Connection con = null;
    	PreparedStatement stmt = null;
    	try {
    		con = getConnection();
    		stmt = con.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		//
    		while (rs.next()) {
    			CancelHeaderVO cancelHeader = new CancelHeaderVO();
    			// cancelcode :
    			String cancelcode = rs.getString(1);
    			cancelHeader.setCancelcode(cancelcode == null ? null : cancelcode.trim());
    			// cancelreason :
    			String cancelreason = rs.getString(2);
    			cancelHeader.setCancelreason(cancelreason == null ? null : cancelreason.trim());
    			// pk_maker :
    			String pk_maker = rs.getString(3);
    			cancelHeader.setPk_maker(pk_maker == null ? null : pk_maker.trim());
    			// makedate :
    			String makedate = rs.getString(4);
    			cancelHeader.setMakedate(makedate == null ? null : new UFDate(makedate.trim()));
    			// pk_checker :
    			String pk_checker = rs.getString(5);
    			cancelHeader.setPk_checker(pk_checker == null ? null : pk_checker.trim());
    			// checkdate :
    			String checkdate = rs.getString(6);
    			cancelHeader.setCheckdate(checkdate == null ? null : new UFDate(checkdate.trim()));
    			// checkflag :
    			String checkflag = rs.getString(7);
    			cancelHeader.setCheckflag(checkflag == null ? null : new UFBoolean(checkflag.trim()));
    			// tallyflag :
    			String tallyflag = rs.getString(8);
    			cancelHeader.setTallyflag(tallyflag == null ? null : new UFBoolean(tallyflag.trim()));
    			// tallydate :
    			String tallydate = rs.getString(9);
    			cancelHeader.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
    			// def1 :
    			String def1 = rs.getString(10);
    			cancelHeader.setDef1(def1 == null ? null : def1.trim());
    			// def2 :
    			String def2 = rs.getString(11);
    			cancelHeader.setDef2(def2 == null ? null : def2.trim());
    			// def3 :
    			String def3 = rs.getString(12);
    			cancelHeader.setDef3(def3 == null ? null : def3.trim());
    			// def4 :
    			String def4 = rs.getString(13);
    			cancelHeader.setDef4(def4 == null ? null : def4.trim());
    			// def5 :
    			String def5 = rs.getString(14);
    			cancelHeader.setDef5(def5 == null ? null : def5.trim());
                // pk_cancel :
    			String pk_cancel = rs.getString(15);
    			cancelHeader.setPk_cancel(pk_cancel == null ? null : pk_cancel.trim());
    			
    			v.addElement(cancelHeader);
    		}
    	}
    	finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
    	}

    	cancelHeaders = new CancelHeaderVO[v.size()];
    	if (v.size() > 0) {
    		v.copyInto(cancelHeaders);
    	}
    	
    	return cancelHeaders;
    }
    
    public TransHeaderVO[] findHeaderTrans1(TallyCorpVO[] tallyCorps, UFDate date) throws SQLException{
    	TransHeaderVO[] transHeaders = null; 
    	Vector v = new Vector();
    	String sqlCorps = "";
         if(tallyCorps!=null){
             for (int i = 0; i < tallyCorps.length; i++) {
                 sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
                 if(i!=(tallyCorps.length-1)) {
                     sqlCorps += ",";
                 }
             }
         }
    	String sql = "select distinct t.transcode, t.transreason, t.pk_maker, t.makedate, t.pk_checker, t.checkdate, t.checkflag, t.tallyflag, t.tallydate, t.def1, t.def2, t.def3, t.def4, t.def5, t.pk_trans from lc_trans t ,lc_trans_m tm " +
    			" where  tm.pk_trans=t.pk_trans and t.tallyflag = 'Y' and t.tallydate = '" + date + "' and t.checkflag = 'Y' and t.dr=0 and tm.pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
    	
    	Connection con = null;
    	PreparedStatement stmt = null;
    	try {
    		con = getConnection();
    		stmt = con.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		//
    		while (rs.next()) {
    			TransHeaderVO transHeader = new TransHeaderVO();
    			// transcode :
    			String transcode = rs.getString(1);
    			transHeader.setTranscode(transcode == null ? null : transcode.trim());
    			// transreason :
    			String transreason = rs.getString(2);
    			transHeader.setTransreason(transreason == null ? null : transreason.trim());
    			// pk_maker :
    			String pk_maker = rs.getString(3);
    			transHeader.setPk_maker(pk_maker == null ? null : pk_maker.trim());
    			// makedate :
    			String makedate = rs.getString(4);
    			transHeader.setMakedate(makedate == null ? null : new UFDate(makedate.trim()));
    			// pk_checker :
    			String pk_checker = rs.getString(5);
    			transHeader.setPk_checker(pk_checker == null ? null : pk_checker.trim());
    			// checkdate :
    			String checkdate = rs.getString(6);
    			transHeader.setCheckdate(checkdate == null ? null : new UFDate(checkdate.trim()));
    			// checkflag :
    			String checkflag = rs.getString(7);
    			transHeader.setCheckflag(checkflag == null ? null : new UFBoolean(checkflag.trim()));
    			// tallyflag :
    			String tallyflag = rs.getString(8);
    			transHeader.setTallyflag(tallyflag == null ? null : new UFBoolean(tallyflag.trim()));
    			// tallydate :
    			String tallydate = rs.getString(9);
    			transHeader.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
    			// def1 :
    			String def1 = rs.getString(10);
    			transHeader.setDef1(def1 == null ? null : def1.trim());
    			// def2 :
    			String def2 = rs.getString(11);
    			transHeader.setDef2(def2 == null ? null : def2.trim());
    			// def3 :
    			String def3 = rs.getString(12);
    			transHeader.setDef3(def3 == null ? null : def3.trim());
    			// def4 :
    			String def4 = rs.getString(13);
    			transHeader.setDef4(def4 == null ? null : def4.trim());
    			// def5 :
    			String def5 = rs.getString(14);
    			transHeader.setDef5(def5 == null ? null : def5.trim());
               // pk_trans :
    			String pk_trans = rs.getString(15);
    			transHeader.setPk_trans(pk_trans == null ? null : pk_trans.trim());
    			
    			v.addElement(transHeader);
    		}
    	}
    	finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
    	}

    	transHeaders = new TransHeaderVO[v.size()];
    	if (v.size() > 0) {
    		v.copyInto(transHeaders);
    	}
    	return transHeaders;
    }
    
    
    public TransHeaderVO[] findHeaderTrans(TallyCorpVO [] tallyCorps) throws SQLException {

    	TransHeaderVO[] transHeaders = null; 
    	Vector v = new Vector();
    	String sqlCorps = "";
         if(tallyCorps!=null){
             for (int i = 0; i < tallyCorps.length; i++) {
                 sqlCorps += "'" + tallyCorps[i].getPk_corp() + "'";
                 if(i!=(tallyCorps.length-1)) {
                     sqlCorps += ",";
                 }
             }
         }
    	String sql = "select distinct t.transcode, t.transreason, t.pk_maker, t.makedate, t.pk_checker, t.checkdate, t.checkflag, t.tallyflag, t.tallydate, t.def1, t.def2, t.def3, t.def4, t.def5, t.pk_trans from lc_trans t ,lc_trans_m tm " +
    			" where  tm.pk_trans=t.pk_trans and ( t.tallyflag is null or t.tallyflag = 'N') and t.checkflag = 'Y' and t.dr=0 and tm.pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp in (" + sqlCorps + "))";
    	
    	Connection con = null;
    	PreparedStatement stmt = null;
    	try {
    		con = getConnection();
    		stmt = con.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		//
    		while (rs.next()) {
    			TransHeaderVO transHeader = new TransHeaderVO();
    			// transcode :
    			String transcode = rs.getString(1);
    			transHeader.setTranscode(transcode == null ? null : transcode.trim());
    			// transreason :
    			String transreason = rs.getString(2);
    			transHeader.setTransreason(transreason == null ? null : transreason.trim());
    			// pk_maker :
    			String pk_maker = rs.getString(3);
    			transHeader.setPk_maker(pk_maker == null ? null : pk_maker.trim());
    			// makedate :
    			String makedate = rs.getString(4);
    			transHeader.setMakedate(makedate == null ? null : new UFDate(makedate.trim()));
    			// pk_checker :
    			String pk_checker = rs.getString(5);
    			transHeader.setPk_checker(pk_checker == null ? null : pk_checker.trim());
    			// checkdate :
    			String checkdate = rs.getString(6);
    			transHeader.setCheckdate(checkdate == null ? null : new UFDate(checkdate.trim()));
    			// checkflag :
    			String checkflag = rs.getString(7);
    			transHeader.setCheckflag(checkflag == null ? null : new UFBoolean(checkflag.trim()));
    			// tallyflag :
    			String tallyflag = rs.getString(8);
    			transHeader.setTallyflag(tallyflag == null ? null : new UFBoolean(tallyflag.trim()));
    			// tallydate :
    			String tallydate = rs.getString(9);
    			transHeader.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
    			// def1 :
    			String def1 = rs.getString(10);
    			transHeader.setDef1(def1 == null ? null : def1.trim());
    			// def2 :
    			String def2 = rs.getString(11);
    			transHeader.setDef2(def2 == null ? null : def2.trim());
    			// def3 :
    			String def3 = rs.getString(12);
    			transHeader.setDef3(def3 == null ? null : def3.trim());
    			// def4 :
    			String def4 = rs.getString(13);
    			transHeader.setDef4(def4 == null ? null : def4.trim());
    			// def5 :
    			String def5 = rs.getString(14);
    			transHeader.setDef5(def5 == null ? null : def5.trim());
               // pk_trans :
    			String pk_trans = rs.getString(15);
    			transHeader.setPk_trans(pk_trans == null ? null : pk_trans.trim());
    			
    			v.addElement(transHeader);
    		}
    	}
    	finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
    	}

    	transHeaders = new TransHeaderVO[v.size()];
    	if (v.size() > 0) {
    		v.copyInto(transHeaders);
    	}
    	return transHeaders;
    }
    
    public boolean isDB2 (Connection con) throws SQLException {
        try {
    	    UFConnection ufcon = (UFConnection)con;
    	    if(ufcon.getDatabaseType()==UFConnection.DB2) {
    	        return true;
    	    }
        } catch(Exception e){
            throw new SQLException(e.getMessage());
        }
        return false;
    }
    
    public TallylogVO updateCard1(CardVO[] cardvos, UFDate date) throws SQLException{
    	TallylogVO retvo = new TallylogVO();
    	retvo.m_def5="";
    	Vector v = null;
    	Connection con = getConnection();
		PreparedStatement stmt = null;
		String updatesql = "";
    	if((cardvos!=null)&&(cardvos.length>0))
    	{
    	   v =  new Vector();
    	   for (int i=0; i<cardvos.length; i++)
    	   {
    	    
    	   	   if(!cardvos[i].getTallyflag().booleanValue()){
    	     	 v.addElement(cardvos[i].getPk_lccard());//存主键
    	       }else{
    	         retvo.m_def5 += "卡片" + cardvos[i].getLccode() + "反记账出错："+cardvos[i].getDef5() + "\n";
    	         System.out.println("卡片管理中的"+cardvos[i].getLccode()+"_"+cardvos[i].getLcname()+"反记帐失败");
    	       }
    	     
    	   }
    	   //修改数据库
    	   if((v!=null)&&(v.size()>0))
    	   {
				String pksql = "";
				for (int t = 0; t < v.size(); t++) {
					pksql = pksql + "'" + v.get(t).toString() + "'";
					if (t < v.size() - 1) {
						pksql = pksql + ",";
					}
				}
		     
				String sumsql = "select sum(price*\"number\") from lc_card where tallyflag = 'Y' and tallydate = '" + date + "' and pk_lccard in ("+pksql+")";
				if(isDB2(con)){
					sumsql = "select sum(price*number) from lc_card where tallyflag = 'Y' and tallydate = '" + date + "' and pk_lccard in ("+pksql+")";	
				}
	         
	    		stmt = con.prepareStatement(sumsql);
	    		ResultSet rs = stmt.executeQuery();
	    		if(rs.next()){
	    		    Object objNewSum = rs.getObject(1);
	    		    UFDouble newSum = null;
	    		    if(objNewSum!=null){
	    			    if(objNewSum instanceof Integer){
	    			        newSum = new UFDouble(((Integer)objNewSum).intValue());
	    			    }
	    			    if(objNewSum instanceof BigDecimal){
	    			        newSum = new UFDouble((BigDecimal)objNewSum);
	    			    }
	    		        retvo.setNewsum(newSum);
	    		    }
	    		}
	    		stmt.close();
	    		
	    		updatesql = "update lc_card set tallyflag = 'N',tallydate = null where pk_lccard in ("+pksql+")";
			    con = getConnection();
			    stmt = con.prepareStatement(updatesql);
		    	stmt.executeUpdate();	
		    	stmt.close();
			}
    	}
    	return retvo;
    }
    
    public TallylogVO updateCard (CardVO[] cardvos,UFDate date) throws SQLException{
    	
    	TallylogVO retvo = new TallylogVO();
    	retvo.m_def5="";
    	Vector v = null;
    	Connection con = null;
		PreparedStatement stmt = null;
		String updatesql = "";
    	if((cardvos!=null)&&(cardvos.length>0))
    	{
    	   v =  new Vector();
    	   for (int i=0; i<cardvos.length; i++)
    	   {
    	    
    	   	   if(cardvos[i].getTallyflag().booleanValue())//记帐成功
    	       {
    	     	 v.addElement(cardvos[i].getPk_lccard());//存主键
    	       }else{
    	         retvo.m_def5 += "卡片" + cardvos[i].getLccode() + "记账出错："+cardvos[i].getDef5() + "\n";
    	         System.out.println("卡片管理中的"+cardvos[i].getLccode()+"_"+cardvos[i].getLcname()+"记帐失败");
    	       }
    	     
    	   }
    	   //修改数据库
    	   if((v!=null)&&(v.size()>0))
    	   {
				String pksql = "";
				for (int t = 0; t < v.size(); t++) {
					pksql = pksql + "'" + v.get(t).toString() + "'";
					if (t < v.size() - 1) {
						pksql = pksql + ",";
					}
				}
		     updatesql = "update lc_card set tallyflag = 'Y',tallydate = '" + date + "' where pk_lccard in ("+pksql+")";
		     con = getConnection();
		     stmt = con.prepareStatement(updatesql);
	    	 stmt.executeUpdate();
	    	 stmt.close();
	    	 String sumsql = "select sum(price*\"number\") from lc_card where tallyflag = 'Y' and tallydate = '" + date + "' and pk_lccard in ("+pksql+")";
	         if(isDB2(con)){
	         	sumsql = "select sum(price*number) from lc_card where tallyflag = 'Y' and tallydate = '" + date + "' and pk_lccard in ("+pksql+")";	
	         }
	         
            //卡片统计
	    		stmt = con.prepareStatement(sumsql);
	    		ResultSet rs = stmt.executeQuery();
	    		if(rs.next()){
	    		    Object objNewSum = rs.getObject(1);
	    		    UFDouble newSum = null;
	    		    if(objNewSum!=null){
	    			    if(objNewSum instanceof Integer){
	    			        newSum = new UFDouble(((Integer)objNewSum).intValue());
	    			    }
	    			    if(objNewSum instanceof BigDecimal){
	    			        newSum = new UFDouble((BigDecimal)objNewSum);
	    			    }
	    		        retvo.setNewsum(newSum);
	    		    }
	    		}
	         
			}
    	}
    	return retvo;
    }
    
    public TallylogVO updateTrans1(TransVO[] tranvos, UFDate date) throws SQLException{
    	TallylogVO retvo = new TallylogVO();
    	retvo.m_def5 = "";
    	Vector v = null;
    	Connection con = getConnection();
		PreparedStatement stmt = null;
		String updatesql = "";
		if((tranvos!=null)&&(tranvos.length>0)){
			v =  new Vector();
	    	for (int i=0; i<tranvos.length; i++){
	    		TransHeaderVO headvo = (TransHeaderVO)tranvos[i].getParentVO();
	    	   	if(!headvo.getTallyflag().booleanValue()){
	    	     	  v.addElement(headvo.getPk_trans());//存主键
	    	    }else{
	    	          retvo.m_def5 += "调拨单[" + headvo.getTranscode() + "]出错："+headvo.m_def5 + "\n";
	    	          System.out.println("调拨中的"+headvo.getTranscode()+"反记帐失败");
	    	    } 	
	    	}
	    	if((v!=null)&&(v.size()>0)){
	    		String pksql = "";
				for (int t = 0; t < v.size(); t++) {
					pksql = pksql + "'" + v.get(t).toString() + "'";
					if (t < v.size() - 1) {
						pksql = pksql + ",";
					}
				}
				updatesql = "update lc_trans  set tallyflag = 'N',tallydate = null where pk_trans in ("+pksql+")";
		    	String sumsql = "select count(*) from lc_trans where tallyflag = 'Y' and tallydate = '" + date + "' and pk_trans in ("+pksql+")";
		    	
		    	con = getConnection();
		    	stmt = con.prepareStatement(sumsql);
	    		ResultSet rs1 = stmt.executeQuery();
	    		if(rs1.next()){
	    		    Object objTransSum = rs1.getObject(1);
	    		    UFDouble transSum = null;
	    		    if(objTransSum!=null){
	    			    if(objTransSum instanceof Integer){
	    			        transSum = new UFDouble(((Integer)objTransSum).intValue());
	    			    }
	    			    if(objTransSum instanceof BigDecimal){
	    			        transSum = new UFDouble((BigDecimal)objTransSum);
	    			    }
	    		        retvo.setTranssum(transSum);		    
	    		    }
	    		}
	    		stmt.close();
	    		
	    		stmt = con.prepareStatement(updatesql);
	    		stmt.executeUpdate();
	    		stmt.close();
	    	}
		}		
		return retvo;
    }
    
    public TallylogVO updateTrans (TransVO[] tranvos,UFDate date) throws SQLException{
    	TallylogVO retvo = new TallylogVO();
    	retvo.m_def5 = "";
    	Vector v = null;
    	Connection con = null;
		PreparedStatement stmt = null;
		String updatesql = "";
    	if((tranvos!=null)&&(tranvos.length>0))
    	{
    	   v =  new Vector();
    	   for (int i=0; i<tranvos.length; i++)
    	   {
    	   	TransHeaderVO headvo = (TransHeaderVO)tranvos[i].getParentVO();
    	   	 
    	   	   if(headvo.getTallyflag().booleanValue())//记帐成功
    	        {
    	     	  v.addElement(headvo.getPk_trans());//存主键
    	        }else{
    	          retvo.m_def5 += "调拨单[" + headvo.getTranscode() + "]出错："+headvo.m_def5 + "\n";
    	          System.out.println("调拨中的"+headvo.getTranscode()+"记帐失败");
    	        }
    	   	
    	   }
    	   //修改数据库
    	   if((v!=null)&&(v.size()>0))
    	   {
				String pksql = "";
				for (int t = 0; t < v.size(); t++) {
					pksql = pksql + "'" + v.get(t).toString() + "'";
					if (t < v.size() - 1) {
						pksql = pksql + ",";
					}
				}
		     updatesql = "update lc_trans  set tallyflag = 'Y',tallydate = '" + date + "' where pk_trans in ("+pksql+")";
		     con = getConnection();
		     stmt = con.prepareStatement(updatesql);
	    	 stmt.executeUpdate();
	    	 stmt.close();
	    	 String sumsql = "select count(*) from lc_trans where tallyflag = 'Y' and tallydate = '" + date + "' and pk_trans in ("+pksql+")";
	         
            //调拨统计
	    		stmt = con.prepareStatement(sumsql);
	    		ResultSet rs1 = stmt.executeQuery();
	    		if(rs1.next()){
	    		    Object objTransSum = rs1.getObject(1);
	    		    UFDouble transSum = null;
	    		    if(objTransSum!=null){
	    			    if(objTransSum instanceof Integer){
	    			        transSum = new UFDouble(((Integer)objTransSum).intValue());
	    			    }
	    			    if(objTransSum instanceof BigDecimal){
	    			        transSum = new UFDouble((BigDecimal)objTransSum);
	    			    }
	    		        retvo.setTranssum(transSum);		    
	    		    }
	    		}
	    	
			}
    	}
    	return retvo;   	
    }
    
    public TallylogVO updateCancel1(CancelVO[] cancelvos,UFDate date) throws SQLException{
    	TallylogVO retvo = new TallylogVO();
    	retvo.m_def5 = "";
    	Connection con = getConnection();
    	PreparedStatement stmt = null;
    	Vector v = null;
    	if((cancelvos!=null)&&(cancelvos.length>0)){
    		v =  new Vector();
    		for (int i=0; i<cancelvos.length; i++){
     	   		CancelHeaderVO headvo = (CancelHeaderVO)cancelvos[i].getParentVO();     	   
     	   		if(!headvo.getTallyflag().booleanValue()){
     	   			v.addElement(headvo.getPk_cancel());//存主键
     	   		}else{
     	   			retvo.m_def5 += "核销单[" + headvo.getCancelcode()+ "]反记账出错："+headvo.m_def5 + "\n";
     	   			System.out.println("核销中的"+headvo.getCancelcode()+"反记帐失败");
     	        }    	   		
     	   	}
    		if((v!=null)&&(v.size()>0)){
    			String pksql = "";
 				for (int t = 0; t < v.size(); t++) {
 					pksql = pksql + "'" + v.get(t).toString() + "'";
 					if (t < v.size() - 1) {
 						pksql = pksql + ",";
 					}
 				}
 				String sumsql = "select sum(price*\"number\") from lc_cancel_m cm,lc_cancel c,lc_card card where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard " +
					"and c.tallyflag = 'Y' and c.tallydate = '" + date + "' and c.pk_cancel in ("+pksql+")";
 				String updatesql = "update lc_cancel set tallyflag = 'N',tallydate = null where  pk_cancel in ("+pksql+")";
 				
 				con = getConnection();		
 				if(isDB2(con)){
 					sumsql = "select sum(price*number) from lc_cancel_m cm,lc_cancel c,lc_card card where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard " +
 						"and c.tallyflag = 'Y' and c.tallydate = '" + date + "' and c.pk_cancel in ("+pksql+")";
 				}	         
 	    		stmt = con.prepareStatement(sumsql);
 	    		ResultSet rs2 = stmt.executeQuery();
 	    		if(rs2.next()){
 	    		    Object objCancelSum = rs2.getObject(1);
 	    		    UFDouble cancelSum = null;
 	    		    if(objCancelSum!=null){
 	    			    if(objCancelSum instanceof Integer){
 	    			        cancelSum = new UFDouble(((Integer)objCancelSum).intValue());
 	    			    }
 	    			    if(objCancelSum instanceof BigDecimal){
 	    			        cancelSum = new UFDouble((BigDecimal)objCancelSum);
 	    			    }
 	    		        retvo.setCancelsum(cancelSum);		    
 	    		    }
 	    		}	
 	    		stmt.close();
 	    		
 	    		stmt = con.prepareStatement(updatesql);
 	    		stmt.executeUpdate();
 	    		stmt.close();
 			}
    	}
    	
    	return retvo;
    }
    
    public TallylogVO updateCancel (CancelVO[] cancelvos,UFDate date) throws SQLException{


    	TallylogVO retvo = new TallylogVO();
    	retvo.m_def5 = "";
    	Vector v = null;
    	Connection con = null;
		PreparedStatement stmt = null;
		String updatesql = "";
    	if((cancelvos!=null)&&(cancelvos.length>0))
    	{
    	   v =  new Vector();
    	   for (int i=0; i<cancelvos.length; i++)
    	   {
    	   	CancelHeaderVO headvo = (CancelHeaderVO)cancelvos[i].getParentVO();
    	   
    	   	   if(headvo.getTallyflag().booleanValue())//记帐成功
    	       {
    	     	 v.addElement(headvo.getPk_cancel());//存主键
    	       }else{
    	         retvo.m_def5 += "核销单[" + headvo.getCancelcode()+ "]记账出错："+headvo.m_def5 + "\n";
    	         System.out.println("核销中的"+headvo.getCancelcode()+"记帐失败");
    	       }
    	   
    	   }
    	   //修改数据库
    	   if((v!=null)&&(v.size()>0))
    	   {
				String pksql = "";
				for (int t = 0; t < v.size(); t++) {
					pksql = pksql + "'" + v.get(t).toString() + "'";
					if (t < v.size() - 1) {
						pksql = pksql + ",";
					}
				}
		     updatesql = "update lc_cancel set tallyflag = 'Y',tallydate = '" + date + "' where  pk_cancel in ("+pksql+")";
		     con = getConnection();
		     stmt = con.prepareStatement(updatesql);
	    	 stmt.executeUpdate();
	    	 stmt.close();
	    	 String sumsql = "select sum(price*\"number\") from lc_cancel_m cm,lc_cancel c,lc_card card where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard " +
	    	 		"and c.tallyflag = 'Y' and c.tallydate = '" + date + "' and c.pk_cancel in ("+pksql+")";
	    		
	    	 if(isDB2(con)){
	    	 	sumsql = "select sum(price*number) from lc_cancel_m cm,lc_cancel c,lc_card card where c.pk_cancel=cm.pk_cancel and cm.pk_lccard=card.pk_lccard " +
    	 		"and c.tallyflag = 'Y' and c.tallydate = '" + date + "' and c.pk_cancel in ("+pksql+")";
    		 }
	         
            //核销统计
	    		stmt = con.prepareStatement(sumsql);
	    		ResultSet rs2 = stmt.executeQuery();
	    		if(rs2.next()){
	    		    Object objCancelSum = rs2.getObject(1);
	    		    UFDouble cancelSum = null;
	    		    if(objCancelSum!=null){
	    			    if(objCancelSum instanceof Integer){
	    			        cancelSum = new UFDouble(((Integer)objCancelSum).intValue());
	    			    }
	    			    if(objCancelSum instanceof BigDecimal){
	    			        cancelSum = new UFDouble((BigDecimal)objCancelSum);
	    			    }
	    		        retvo.setCancelsum(cancelSum);		    
	    		    }
	    		}	
	    	
			}
    	}
    return retvo;
    	
    }

}
