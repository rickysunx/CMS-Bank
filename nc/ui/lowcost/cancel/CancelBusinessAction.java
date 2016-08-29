/*
 * �������� 2005-10-8
 *
 * @author ����
 */
package nc.ui.lowcost.cancel;

import java.util.ArrayList;

import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.pf.PfUtilClient;
import nc.ui.trade.base.AbstractBillUI;
import nc.ui.trade.businessaction.BusinessAction;
import nc.vo.lowcost.cancel.CancelHeaderVO;
import nc.vo.lowcost.pub.LCTools;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.trade.pub.IBillStatus;
import nc.vo.trade.pub.IExAggVO;

/**
 * @author ����
 *
 */
public class CancelBusinessAction extends BusinessAction {

    /**
     * 
     */
    public CancelBusinessAction() {
        super();
    }

    /**
     * @param ui
     */
    public CancelBusinessAction(AbstractBillUI ui) {
        super(ui);
    }


    /* ���� Javadoc��
     * @see nc.ui.trade.businessaction.IBusinessController#save(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object, nc.vo.pub.AggregatedValueObject)
     */
    public AggregatedValueObject save(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj,
            AggregatedValueObject checkVo) throws Exception {
        ((CancelHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((CancelHeaderVO) (checkVo.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((CancelHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        ((CancelHeaderVO)(checkVo.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
    	setBillStatus(billVO);
    	ArrayList retAry =
    		(ArrayList) PfUtilClient.processAction(
    			getUI(),
    			"SAVE",
    			billType,
    			billDate,
    			billVO,
    			userObj,
    			null,
    			checkVo);
    	AggregatedValueObject retVo=(AggregatedValueObject)retAry.get(1);
    	//((CancelHeaderVO)(retVo.getParentVO())).setPk_checker(null);
    	return fillUIData(retVo,checkVo);
    }
    /**
    * ����״̬��
    * �������ڣ�(2003-9-27 14:14:15)
    * @param billvo nc.vo.pub.AggregatedValueObject
    */
    private void setBillStatus(AggregatedValueObject billvo)
    {
        //int m = 8;
    	Integer billstatus =
    		(Integer) billvo.getParentVO().getAttributeValue(
    			getUI().getBillField().getField_BillStatus());

    	if (billstatus == null || billstatus.intValue() == IBillStatus.NOPASS)
    	{
    		billvo.getParentVO().setAttributeValue(
    			getUI().getBillField().getField_CheckMan(),
    			null);
    		billvo.getParentVO().setAttributeValue(
    			getUI().getBillField().getField_CheckDate(),
    			null);
    		billvo.getParentVO().setAttributeValue(
    			getUI().getBillField().getField_CheckNote(),
    			null);
    		billvo.getParentVO().setAttributeValue(
    			getUI().getBillField().getField_BillStatus(),
    			new Integer(IBillStatus.FREE));
    	}

    }
    /**
     * ���ݷ��ص����ݽ���ƥ�����ݡ�
     * �������ڣ�(2004-2-27 22:08:03)
     * @param retVo nc.vo.pub.AggregatedValueObject
     * @param oldVo nc.vo.pub.AggregatedValueObject
     */
    private AggregatedValueObject fillUIData(
    	AggregatedValueObject retVo,
    	AggregatedValueObject oldVo)
    	throws Exception {
    	if (oldVo instanceof IExAggVO)
    	{
    		IExAggVO exAggVo = (IExAggVO) oldVo;
    		IExAggVO exNewAggVo = (IExAggVO) retVo;
    		exAggVo.setParentVO(exNewAggVo.getParentVO());
    		for (int i = 0; i < exAggVo.getTableCodes().length; i++)
    		{
    			//Vector v = new Vector();
    			String tableCode = exAggVo.getTableCodes()[i];
    			SuperVO[] items = (SuperVO[]) exAggVo.getTableVO(tableCode);
    			SuperVO[] newitems = (SuperVO[]) exNewAggVo.getTableVO(tableCode);
    			if (items != null)
    				fillUITotalVO(items, newitems);

    			////SuperVO[] vos = null;
    			////if (v.size() > 0)
    			////{
    			////vos =
    			////(SuperVO[]) java.lang.reflect.Array.newInstance(v.get(0).getClass(), v.size());
    			////v.copyInto(vos);
    			////}
    			//exNewAggVo.setTableVO(tableCode, items);
    		}
    		return oldVo;
    	}
    	if (retVo.getChildrenVO() == null || retVo.getChildrenVO().length == 0)
    		retVo.setChildrenVO(oldVo.getChildrenVO());
    	return retVo;
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.businessaction.IBusinessController#approve(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject approve(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
        //�������˺��Ƶ����Ƿ�һ��
        
        ((CancelHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        ((CancelHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((CancelHeaderVO) (billVO.getParentVO())).setPk_checker(ClientEnvironment.getInstance().getUser().getPrimaryKey());
        
        String pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        String strAllowedSame = LCTools.getParam(pk_corp,"LC16");
        if(strAllowedSame!=null && strAllowedSame.equals("N")){
            CancelHeaderVO hvo = (CancelHeaderVO)billVO.getParentVO();
            if(hvo.getPk_checker()!=null && (hvo.getPk_checker().equals(hvo.getPk_maker()))){
                throw new Exception ("�Ƶ���������˲�������ͬһ����");
            }
        }
        
        AggregatedValueObject retVO = super.approve(billVO, billType, billDate, userObj);
        
        

        
        return retVO;
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.businessaction.IBusinessController#delete(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject delete(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
    	String operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
    	CancelHeaderVO vo = (CancelHeaderVO) billVO.getParentVO();
    	String maker = vo.getPk_maker();
    	if(maker.equals(operator))
    		return super.delete(billVO, billType, billDate, userObj);
    	else{
    		MessageDialog.showErrorDlg(super.getUI(), "����", "��ǰ��¼�û������޸ģ����ò�ͬ�û���¼��");
    		return null;
    	}
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.businessaction.IBusinessController#edit(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject edit(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
        ((CancelHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((CancelHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        CancelHeaderVO hvo = (CancelHeaderVO)(billVO.getParentVO());
        if(hvo.getPk_checker()!=null && hvo.getPk_checker().trim().length()>0){
            throw new Exception("���������������л��Ѿ������ɹ������ܽ����޸ģ�");
        }
        AggregatedValueObject retVO = super.edit(billVO, billType, billDate, userObj);
        return retVO;
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.businessaction.IBusinessController#unapprove(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject unapprove(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
        
        String currOperator = ((CancelHeaderVO)(billVO.getParentVO())).getPk_checker();
        if(currOperator!=null && (!currOperator.equals(ClientEnvironment.getInstance().getUser().getPrimaryKey()))){
            throw new Exception ("��û�з����Ȩ�ޣ��õ��Ѿ��������������ˡ�");
        }
        if(((CancelHeaderVO)(billVO.getParentVO())).m_checkflag!=null){
	        if(((CancelHeaderVO)(billVO.getParentVO())).m_tallyflag!=null && ((CancelHeaderVO)(billVO.getParentVO())).m_tallyflag.booleanValue()){
	            throw new Exception ("�Ѽ��˵ĵ��ݲ��ܱ������");
	        }
        }
        
        ((CancelHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        ((CancelHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        return super.unapprove(billVO, billType, billDate, userObj);
    }
}
