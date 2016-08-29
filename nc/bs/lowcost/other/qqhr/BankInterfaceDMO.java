/*
 * 创建日期 2006-2-10
 *
 * @author 孙锐
 */
package nc.bs.lowcost.other.qqhr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import nc.bs.lowcost.tally.ILowCostBalCheck;
import nc.bs.lowcost.tally.ILowCostTally;
import nc.bs.pub.DataManageObject;
import nc.bs.pub.SystemException;
import nc.bs.qqhr.expvoucher.VoucherDealDMO;
import nc.vo.lowcost.cancel.CancelHeaderVO;
import nc.vo.lowcost.cancel.CancelVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.lowcost.trans.TransVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class BankInterfaceDMO extends DataManageObject implements ILowCostBalCheck,ILowCostTally {

    /**
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public BankInterfaceDMO() throws NamingException, SystemException {
        super();
    }

    /**
     * @param dbName
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public BankInterfaceDMO(String dbName) throws NamingException,
            SystemException {
        super(dbName);
    }

    /* （非 Javadoc）
     * @see nc.bs.lowcost.tally.ILowCostBalCheck#getAccountBalance(java.lang.String)
     */
    public UFDouble getAccountBalance(String acctCode) throws Exception {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.lowcost.tally.ILowCostTally#doTallyTrade(nc.vo.lowcost.card.CardVO[], nc.vo.lowcost.trans.TransVO[], nc.vo.lowcost.cancel.CancelVO[])
     */
    public void doTallyTrade(CardVO[] cards, TransVO[] trans, CancelVO[] cancels) throws Exception {
        
    }

    /* （非 Javadoc）
     * @see nc.bs.lowcost.tally.ILowCostTally#doUnTallyTrade(nc.vo.pub.lang.UFDate)
     */
    public void doUnTallyTrade(UFDate date) throws Exception {
        
    }

    /* （非 Javadoc）
     * @see nc.bs.lowcost.tally.ILowCostTally#doCorpTallyTrade(java.lang.String, nc.vo.pub.lang.UFDouble)
     */
    public String getAccByCorp (String pk_corp) throws SQLException {
        String acc = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select bank_kmbm from lc_subj where pk_corp = '" + pk_corp + "'";
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                acc = rs.getString(1);
            } else {
                throw new SQLException("根据公司主键查不到账号！");
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
        return acc;
    }



    /* （非 Javadoc）
     * @see nc.bs.lowcost.tally.ILowCostTally#doCorpTallyTrade(nc.vo.pub.lang.UFDate, java.lang.String, nc.vo.pub.lang.UFDouble, nc.vo.pub.lang.UFDouble)
     */
    public void doCorpTallyTrade(UFDate date, String pk_corp, UFDouble newSum, UFDouble cancelSum) throws Exception {
        // TODO 自动生成方法存根
    	
//    	if(true){
//    		System.err.println("-----已调用接口-----");
//    		
//    		return;
//    	}
        
        System.out.println("=====调用齐齐哈尔接口====");
        System.out.println("日期："+date);
        System.out.println("公司主键："+pk_corp);
        System.out.println("新增金额："+newSum);
        System.out.println("核销金额："+cancelSum);
        
        
        String acc = getAccByCorp(pk_corp);
        if(newSum.compareTo(new UFDouble(0.0f))>0){
            System.out.println("=====调用齐齐哈尔接口====,新增卡片");
            (new VoucherDealDMO()).doLowCostTrade(pk_corp,acc,"RMB","2",newSum);
        }
        if(cancelSum.compareTo(new UFDouble(0.0f))>0){
            System.out.println("=====调用齐齐哈尔接口====,核销卡片");
            (new VoucherDealDMO()).doLowCostTrade(pk_corp,acc,"RMB","1",cancelSum);
        }
        
        System.out.println("=====调用齐齐哈尔接口====,完成");
    }

	/* (non-Javadoc)
	 * @see nc.bs.lowcost.tally.ILowCostTally#doTallyCard(nc.vo.lowcost.card.CardVO[])
	 */
	public CardVO[] doTallyCard(CardVO[] cards) throws Exception {
	
		if(cards!=null){
			for (int i = 0; i < cards.length; i++) {
				cards[i].setTallyflag(new UFBoolean(true));
			}
		}
		
		return cards;
	}

	/* (non-Javadoc)
	 * @see nc.bs.lowcost.tally.ILowCostTally#doTallyTrans(nc.vo.lowcost.trans.TransVO[])
	 */
	public TransVO[] doTallyTrans(TransVO[] trans) throws Exception {
		if(trans!=null){
			for (int i = 0; i < trans.length; i++) {
				TransHeaderVO headerVO = (TransHeaderVO)trans[i].getParentVO();
				headerVO.setTallyflag(new UFBoolean(true));
			}
		}
		return trans;
	}

	/* (non-Javadoc)
	 * @see nc.bs.lowcost.tally.ILowCostTally#doTallyCancel(nc.vo.lowcost.cancel.CancelVO[])
	 */
	public CancelVO[] doTallyCancel(CancelVO[] cancels) throws Exception {
		if(cancels!=null){
			for (int i = 0; i < cancels.length; i++) {
				CancelHeaderVO headerVO = (CancelHeaderVO)cancels[i].getParentVO();
				headerVO.setTallyflag(new UFBoolean(true));
			}
		}
		
		return cancels;
	}

	/* (non-Javadoc)
	 * @see nc.bs.lowcost.tally.ILowCostTally#undoTallyCard(nc.vo.lowcost.card.CardVO[])
	 */
	public CardVO[] undoTallyCard(CardVO[] cards) throws Exception {
		if(cards!=null){
			for (int i = 0; i < cards.length; i++) {
				cards[i].setTallyflag(new UFBoolean(false));
			}
		}
		return cards;
	}

	/* (non-Javadoc)
	 * @see nc.bs.lowcost.tally.ILowCostTally#undoTallyTrans(nc.vo.lowcost.trans.TransVO[])
	 */
	public TransVO[] undoTallyTrans(TransVO[] trans) throws Exception {
		if(trans!=null){
			for (int i = 0; i < trans.length; i++) {
				TransHeaderVO headerVO = (TransHeaderVO) trans[i].getParentVO();
				headerVO.setTallyflag(new UFBoolean(false));
			}
		}
		return trans;
	}

	/* (non-Javadoc)
	 * @see nc.bs.lowcost.tally.ILowCostTally#undoTallyCancel(nc.vo.lowcost.cancel.CancelVO[])
	 */
	public CancelVO[] undoTallyCancel(CancelVO[] cancels) throws Exception {
		if(cancels!=null){
			for (int i = 0; i < cancels.length; i++) {
				CancelHeaderVO headerVO = (CancelHeaderVO)cancels[i].getParentVO();
				headerVO.setTallyflag(new UFBoolean(false));
			}
		}
		return cancels;
	}

}
