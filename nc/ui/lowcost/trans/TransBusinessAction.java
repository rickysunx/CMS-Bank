/*
 * 创建日期 2005-10-8
 *
 * @author 孙锐
 */
package nc.ui.lowcost.trans;

import java.util.ArrayList;
import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.pf.PfUtilClient;
import nc.ui.trade.base.AbstractBillUI;
import nc.ui.trade.businessaction.BusinessAction;
import nc.vo.lowcost.pub.LCTools;
import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.trade.pub.IBillStatus;
import nc.vo.trade.pub.IExAggVO;

/**
 * @author 孙锐
 *
 */
public class TransBusinessAction extends BusinessAction {
    /**
     * 
     */
    public TransBusinessAction() {
        super();
    }

    /**
     * @param ui
     */
    public TransBusinessAction(AbstractBillUI ui) {
        super(ui);
    }


    /* （非 Javadoc）
     * @see nc.ui.trade.businessaction.IBusinessController#save(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object, nc.vo.pub.AggregatedValueObject)
     */
    public AggregatedValueObject save(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj,
            AggregatedValueObject checkVo) throws Exception {
        ((TransHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((TransHeaderVO) (checkVo.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((TransHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        ((TransHeaderVO)(checkVo.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
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
    	 //return super.save(billVO,billType,billDate,userObj,checkVo);
    	//((TransHeaderVO)(retVo.getParentVO())).setPk_checker(null);
    	return fillUIData(retVo,checkVo);
    }
    /**
    * 设置状态。
    * 创建日期：(2003-9-27 14:14:15)
    * @param billvo nc.vo.pub.AggregatedValueObject
    */
    private void setBillStatus(AggregatedValueObject billvo)
    {
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
     * 根据返回的数据进行匹配数据。
     * 创建日期：(2004-2-27 22:08:03)
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
    /* （非 Javadoc）
     * @see nc.ui.trade.businessaction.IBusinessController#approve(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject approve(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
        ((TransHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        ((TransHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((TransHeaderVO) (billVO.getParentVO())).setPk_checker(ClientEnvironment.getInstance().getUser().getPrimaryKey());
        
        //检查审核人和制单人是否一致
        String pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        String strAllowedSame = LCTools.getParam(pk_corp,"LC16");
        if(strAllowedSame!=null && strAllowedSame.equals("N")){
            TransHeaderVO hvo = (TransHeaderVO)billVO.getParentVO();
            if(hvo.getPk_checker()!=null && (hvo.getPk_checker().equals(hvo.getPk_maker()))){
                throw new Exception ("制单人与审核人不允许是同一个人");
            }
        }
        
        AggregatedValueObject retVO = super.approve(billVO, billType, billDate, userObj);        
        return retVO;
    }
    /* （非 Javadoc）
     * @see nc.ui.trade.businessaction.IBusinessController#delete(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject delete(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
    	String operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
    	TransHeaderVO vo = (TransHeaderVO) billVO.getParentVO();
    	String maker = vo.getPk_maker();
    	if(maker.equals(operator))
    		return super.delete(billVO, billType, billDate, userObj);
    	else{
    		MessageDialog.showErrorDlg(super.getUI(), "出错", "当前登录用户不能修改！请用不同用户登录！");
    		//super.delete(null,billType,null,userObj);
    		return null;
    	}
    }
    
	/* （非 Javadoc）
     * @see nc.ui.trade.businessaction.IBusinessController#edit(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject edit(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
        ((TransHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        ((TransHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        TransHeaderVO hvo = (TransHeaderVO)(billVO.getParentVO());
        if(hvo.getPk_checker()!=null && hvo.getPk_checker().trim().length()>0){
            throw new Exception("调拨单正在审批中或已经审批成功，不能进行修改！");
        }
        AggregatedValueObject retVO = super.edit(billVO, billType, billDate, userObj);
        return retVO;
    }
    /* （非 Javadoc）
     * @see nc.ui.trade.businessaction.IBusinessController#unapprove(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.Object)
     */
    public AggregatedValueObject unapprove(AggregatedValueObject billVO,
            String billType, String billDate, Object userObj) throws Exception {
        System.out.println("--------------执行了前台反审核--------------");
        String currOperator = ((TransHeaderVO)(billVO.getParentVO())).getPk_checker();
        if(currOperator!=null && (!currOperator.equals(ClientEnvironment.getInstance().getUser().getPrimaryKey()))){
            throw new Exception ("您没有反审核权限，该单已经被其他审核人审核。");
        }
        if(((TransHeaderVO)(billVO.getParentVO())).m_checkflag!=null){
	        if(((TransHeaderVO)(billVO.getParentVO())).m_tallyflag!=null && ((TransHeaderVO)(billVO.getParentVO())).m_tallyflag.booleanValue()){
	            throw new Exception ("已记账的单据不能被反审核");
	        }
        }
        ((TransHeaderVO)(billVO.getParentVO())).m_pk_operator = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        ((TransHeaderVO) (billVO.getParentVO())).m_pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        return super.unapprove(billVO, billType, billDate, userObj);
    }
}
