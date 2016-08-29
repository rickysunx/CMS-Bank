/*
 * 创建日期 2006-2-19
 *
 * @author 孙锐
 */
package nc.bs.lowcost.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.naming.NamingException;



import nc.bs.mw.sql.UFConnection;
import nc.bs.pub.DataManageObject;
import nc.bs.pub.SystemException;
import nc.vo.lowcost.check.CheckVO;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class CheckDMO extends DataManageObject {

    /**
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public CheckDMO() throws NamingException, SystemException {
        super();
        // TODO 自动生成构造函数存根
    }

    /**
     * @param dbName
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public CheckDMO(String dbName) throws NamingException, SystemException {
        super(dbName);
        // TODO 自动生成构造函数存根
    }
    public boolean isDB2 (Connection con) throws SQLException {
        try {
    	    UFConnection ufcon = (UFConnection)con;
    	    if(ufcon.getDatabaseType()==UFConnection.DB2){
    	        return true;
    	    }
        } catch(Exception e){
            throw new SQLException(e.getMessage());
        }
        return false;
    }
    public UFDouble getLcBalance(String pk_corp) throws SQLException {
        UFDouble LcBalance = new UFDouble(0.0f);
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select sum(\"number\"*price) from lc_card where tallyflag = 'Y' and (cancelflag is null or cancelflag = 'N') and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp = '" + pk_corp + "') ";
        String sqldb2 = "select sum(number*price) from lc_card where tallyflag = 'Y' and (cancelflag is null or cancelflag = 'N') and pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp = '" + pk_corp + "') ";
        try {
            con = getConnection();
            if(isDB2(con)){
                stmt = con.prepareStatement(sqldb2);
            } else {
                stmt = con.prepareStatement(sql);
            }
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Object obj = rs.getObject(1);
                if(obj!=null){
                    String str = obj.toString();
                    if(str!=null&&str.length()>0){
                        LcBalance = new UFDouble(str);
                    }
                }
            } else {
                
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
        return LcBalance;
    }
    
    public CheckVO [] queryCheck (String pk_user) throws SQLException {
        CheckVO [] vos = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select a.pk_corp,a.bank_kmbm,b.unitcode,b.unitname from lc_subj a left join bd_corp b on a.pk_corp = b.pk_corp " +
        		"where a.bank_kmbm is not null and a.pk_corp in (select pk_corp from bd_corp) " +
        		"and a.pk_corp in (select pk_corp from sm_userandcorp where userid ='" + pk_user + "')";
        
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Vector v = new Vector();
            while(rs.next()){
                CheckVO vo = new CheckVO();
                String pk_corp = rs.getString(1);
                String bank_kmbm = rs.getString(2);
                String unitcode = rs.getString(3);
                String unitname = rs.getString(4);
                
                if(bank_kmbm!=null && bank_kmbm.trim().length()>0){
                    vo.setPk_corp(pk_corp);
                    vo.setAcctCode(bank_kmbm);
                    vo.setUnitcode(unitcode);
                    vo.setUnitname(unitname);
                    v.add(vo);
                }
            }
            if(v.size()>0){
                vos = new CheckVO[v.size()];
                v.copyInto(vos);
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
        return vos;
    }

    public String [] getBankKmbm (String pk_corp) throws Exception {
        String [] bank_kmbms = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select distinct bank_kmbm from lc_subj where pk_corp = ? and bank_kmbm <> '#' and bank_kmbm is not null";
        
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1,pk_corp);
            ResultSet rs = stmt.executeQuery();
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString(1));
            }
            if(v.size()>0){
                bank_kmbms = new String [v.size()];
                v.copyInto(bank_kmbms);
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
        return bank_kmbms;
    }
    
    public CheckVO [] queryNcCardByType(String pk_corp) throws Exception {
        CheckVO [] vos = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select sum(\"number\" * price), b.bank_kmbm " +
        		"from  lc_subj b left join lc_card a on b.pk_lctype = a.pk_lctype " +
        		"where b.pk_corp = ? and "+
        		"a.pk_usedept in "+
        		"(select pk_deptdoc from bd_deptdoc where pk_corp = ?) and "+
        		"b.bank_kmbm <> '#' and "+
        		"tallyflag = 'Y' and (cancelflag = 'N' or cancelflag is null) "+
        		"group by b.bank_kmbm ";
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1,pk_corp);
            stmt.setString(2,pk_corp);
            ResultSet rs = stmt.executeQuery();
            Vector v = new Vector();
            while(rs.next()){
                CheckVO vo = new CheckVO();
                Object objJe = rs.getObject(1);
                UFDouble je = (objJe==null)?(new UFDouble(0.0f)):(new UFDouble(objJe.toString()));
                vo.setAcctCode(rs.getString(2));
                vo.setNcValue(je);
                v.add(vo);
            }
            if(v.size()>0){
                vos = new CheckVO[v.size()];
                v.copyInto(vos);
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
        return vos;
    }
    
    public CheckVO [] queryCorpTypeCheckVO(String pk_corp) throws Exception {
        CheckVO [] vos = null;
        String [] acctCodes = getBankKmbm(pk_corp);
        CheckVO [] ncCheckVOs = queryNcCardByType(pk_corp);
        HashMap hmNcCheckVOs = new HashMap();
        if(ncCheckVOs!=null){
            for (int i = 0; i < ncCheckVOs.length; i++) {
                hmNcCheckVOs.put(ncCheckVOs[i].getAcctCode(),ncCheckVOs[i]);
            }
        }
        if(acctCodes!=null){
            vos = new CheckVO[acctCodes.length];
            for (int i = 0; i < acctCodes.length; i++) {
                CheckVO vo = new CheckVO();
                vo.setAcctCode(acctCodes[i]);
                Object objNcCheckVO = hmNcCheckVOs.get(acctCodes[i]);
                if(objNcCheckVO!=null){
                    CheckVO ncVO = (CheckVO) objNcCheckVO;
                    vo.setNcValue(ncVO.getNcValue());
                }
                vos[i] = vo;
            }
        }
        return vos;
    }
}
