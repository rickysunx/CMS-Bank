/*
 * �������� 2005-9-30
 *
 * @author ����
 */
package nc.bs.lowcost.trans;

import nc.bs.trade.business.IBDBusiCheck;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.trade.pub.IBDACTION;

/**
 * @author ����
 *
 */
public class TransBusiCheck implements IBDACTION, IBDBusiCheck {

    /**
     * 
     */
    public TransBusiCheck() {
        super();
    }

    /* ���� Javadoc��
     * @see nc.bs.trade.business.IBDBusiCheck#check(int, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    public void check(int intBdAction, AggregatedValueObject vo, Object userObj)
            throws Exception {
        //int m = 8;
        if(intBdAction==SAVE){
            onCheckSave(vo);
        }
    }

    /* ���� Javadoc��
     * @see nc.bs.trade.business.IBDBusiCheck#dealAfter(int, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    
    private void onCheckSave(AggregatedValueObject vo) throws Exception {
        String pk_pvo = vo.getParentVO().getPrimaryKey();
        if(pk_pvo==null || pk_pvo.trim().length()==0){
            //��������
//	        BillIsUnique check = new BillIsUnique();
//	        ArrayList unilist = new ArrayList();
//	        unilist.add(new String [] {"transcode","pk_corp"});
//	        try {
//	            check.checkBillIsUnique(vo,unilist);
//	        } catch (Exception e) {
//	            throw new Exception("�õ����������Ѿ�����");
//	        }
        }
    }
    
    public void dealAfter(int intBdAction, AggregatedValueObject billVo,
            Object userObj) throws Exception {
    }

}
