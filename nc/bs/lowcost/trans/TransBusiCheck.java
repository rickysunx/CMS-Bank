/*
 * 创建日期 2005-9-30
 *
 * @author 孙锐
 */
package nc.bs.lowcost.trans;

import nc.bs.trade.business.IBDBusiCheck;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.trade.pub.IBDACTION;

/**
 * @author 孙锐
 *
 */
public class TransBusiCheck implements IBDACTION, IBDBusiCheck {

    /**
     * 
     */
    public TransBusiCheck() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.bs.trade.business.IBDBusiCheck#check(int, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    public void check(int intBdAction, AggregatedValueObject vo, Object userObj)
            throws Exception {
        //int m = 8;
        if(intBdAction==SAVE){
            onCheckSave(vo);
        }
    }

    /* （非 Javadoc）
     * @see nc.bs.trade.business.IBDBusiCheck#dealAfter(int, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    
    private void onCheckSave(AggregatedValueObject vo) throws Exception {
        String pk_pvo = vo.getParentVO().getPrimaryKey();
        if(pk_pvo==null || pk_pvo.trim().length()==0){
            //新增保存
//	        BillIsUnique check = new BillIsUnique();
//	        ArrayList unilist = new ArrayList();
//	        unilist.add(new String [] {"transcode","pk_corp"});
//	        try {
//	            check.checkBillIsUnique(vo,unilist);
//	        } catch (Exception e) {
//	            throw new Exception("该调拨单编码已经存在");
//	        }
        }
    }
    
    public void dealAfter(int intBdAction, AggregatedValueObject billVo,
            Object userObj) throws Exception {
    }

}
