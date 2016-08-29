/*
 * �������� 2005-10-8
 *
 * @author ����
 */
package nc.bs.lowcost.cancel;

import nc.bs.trade.business.IBDBusiCheck;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.trade.pub.IBDACTION;

/**
 * @author ����
 *
 */
public class CancelBusiCheck implements IBDACTION, IBDBusiCheck {

    /**
     * 
     */
    public CancelBusiCheck() {
        super();
    }

    /* ���� Javadoc��
     * @see nc.bs.trade.business.IBDBusiCheck#check(int, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    public void check(int intBdAction, AggregatedValueObject vo, Object userObj) throws Exception {
        if(intBdAction==SAVE){
            onCheckSave(vo);
        }
    }

    private void onCheckSave(AggregatedValueObject vo) throws Exception {
        String pk_pvo = vo.getParentVO().getPrimaryKey();
        if(pk_pvo==null || pk_pvo.trim().length()==0){
//            //��������
//	        BillIsUnique check = new BillIsUnique();
//	        ArrayList unilist = new ArrayList();
//	        unilist.add(new String [] {"cancelcode",""});
//	        try {
//	            check.checkBillIsUnique(vo,unilist);
//	        } catch (Exception e) {
//	            throw new Exception("�ú����������Ѿ�����");
//	        }
        }        
    }
    /* ���� Javadoc��
     * @see nc.bs.trade.business.IBDBusiCheck#dealAfter(int, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    public void dealAfter(int intBdAction, AggregatedValueObject billVo, Object userObj) throws Exception {        
    }

}
