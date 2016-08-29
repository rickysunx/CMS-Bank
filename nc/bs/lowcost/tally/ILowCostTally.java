/*
 * 创建日期 2006-2-8
 *
 * @author 孙锐
 */
package nc.bs.lowcost.tally;

import nc.vo.lowcost.cancel.CancelVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.trans.TransVO;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public interface ILowCostTally {
    public void doTallyTrade(CardVO [] cards,TransVO [] trans,CancelVO [] cancels) throws Exception;
    public void doCorpTallyTrade(UFDate date,String pk_corp,UFDouble newSum,UFDouble cancelSum) throws Exception;
    public void doUnTallyTrade(UFDate date) throws Exception;
    
    public CardVO [] doTallyCard(CardVO [] cards) throws Exception;
    public TransVO [] doTallyTrans(TransVO [] trans) throws Exception;
    public CancelVO [] doTallyCancel(CancelVO [] cancels) throws Exception;
    
    public CardVO [] undoTallyCard(CardVO [] cards) throws Exception;
    public TransVO [] undoTallyTrans(TransVO [] trans) throws Exception;
    public CancelVO [] undoTallyCancel(CancelVO [] cancels) throws Exception;
    
    
}
