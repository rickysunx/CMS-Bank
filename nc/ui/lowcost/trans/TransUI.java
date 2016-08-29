/*
 * 创建日期 2005-9-23
 *
 * @author 孙锐
 */
package nc.ui.lowcost.trans;

import nc.ui.bd.CorpBO_Client;
import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.bd.b06.PsndocBO_Client;
import nc.ui.ep.dj.DJZBBO_Client;
import nc.ui.lowcost.card.CardBO_Client;
import nc.ui.lowcost.type.TypeBO_Client;
import nc.ui.pub.ButtonObject;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.bsdelegate.BDBusinessDelegator;
import nc.ui.trade.bsdelegate.BusinessDelegator;
import nc.ui.trade.manage.BillManageUI;
import nc.ui.trade.manage.ManageEventHandler;
import nc.vo.bd.CorpVO;
import nc.vo.bd.b04.DeptdocVO;
import nc.vo.ep.dj.DJZBHeaderVO;
import nc.vo.ep.dj.DJZBVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.lowcost.type.TypeVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class TransUI extends BillManageUI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1118799943870731161L;
	/**
     * 
     */
    
    public ButtonObject m_btnAddBatch = new ButtonObject("批量增加","批量增加",2);
    
    public TransUI() {
        super();
    }

    /**
     * @param useBillSource
     */
    public TransUI(Boolean useBillSource) {
        super(useBillSource);
    }

    /**
     * @param pk_corp
     * @param pk_billType
     * @param pk_busitype
     * @param operater
     * @param billId
     */
    public TransUI(String pk_corp, String pk_billType, String pk_busitype,
            String operater, String billId) {
        super(pk_corp, pk_billType, pk_busitype, operater, billId);        
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#createController()
     */
    protected AbstractManageController createController() {
        return new TransController();
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#setBodySpecialData(nc.vo.pub.CircularlyAccessibleValueObject[])
     */
    public void setBodySpecialData(CircularlyAccessibleValueObject[] vos)
            throws Exception {
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#setHeadSpecialData(nc.vo.pub.CircularlyAccessibleValueObject, int)
     */
    protected void setHeadSpecialData(CircularlyAccessibleValueObject vo,
            int intRow) throws Exception {
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#setTotalHeadSpecialData(nc.vo.pub.CircularlyAccessibleValueObject[])
     */
    protected void setTotalHeadSpecialData(CircularlyAccessibleValueObject[] vos)
            throws Exception {
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.base.AbstractBillUI#initSelfData()
     */
    protected void initSelfData() {
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.base.AbstractBillUI#setDefaultData()
     */
    public void setDefaultData() throws Exception {
        getBillCardPanel().setTailItem("makername",getClientEnvironment().getUser().getUserName());
        getBillCardPanel().setTailItem("pk_maker",getClientEnvironment().getUser().getPrimaryKey());
        getBillCardPanel().setTailItem("makedate",getClientEnvironment().getDate().toString());
        getBillCardPanel().setHeadItem("tallyflag","N");
        DJZBVO vo = new DJZBVO();
        DJZBHeaderVO header = new DJZBHeaderVO();
        header.setDjlxbm("L1");
        header.setDwbm(getClientEnvironment().getCorporation().getPk_corp());
        vo.setParentVO(header);
        String djbh = DJZBBO_Client.getDjbh(vo);
        getBillCardPanel().setHeadItem("transcode",djbh);
        getBillCardPanel().getHeadItem("transcode").setEnabled(false);
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.base.AbstractBillUI#createBusinessDelegator()
     */
    protected BusinessDelegator createBusinessDelegator() {
        //return super.createBusinessDelegator();
        return new BDBusinessDelegator();
    }
    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#createEventHandler()
     */
    protected ManageEventHandler createEventHandler() {
        return new TransEventHandler(this,getUIControl());
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.base.AbstractBillUI#setCardUIData(nc.vo.pub.AggregatedValueObject)
     */
    public void setCardUIData(AggregatedValueObject vo) throws Exception {
        super.setCardUIData(vo);
    }
    /* （非 Javadoc）
     * @see nc.ui.pub.bill.BillEditListener#afterEdit(nc.ui.pub.bill.BillEditEvent)
     */
    public void afterEdit(BillEditEvent e) {
        System.out.println("-------sunrui test--------:in afterEdit");
        if(e.getKey()!=null && (e.getKey().equals("pk_lccard")||e.getKey().equals("lccard"))){
            try {
                String pk_card = (String) getBillCardPanel().getBodyValueAt(e.getRow(),"pk_lccard");
                CardVO cvo = CardBO_Client.findByPrimaryKey(pk_card);
                getBillCardPanel().setBodyValueAt(cvo.getPk_usedept(),e.getRow(),"pk_deptfrom");
                getBillCardPanel().setBodyValueAt(NumFormate.getPrecisionData(cvo.getPrice(),2),e.getRow(),"price");
                getBillCardPanel().setBodyValueAt(NumFormate.getPrecisionData(cvo.getNumber(),0),e.getRow(),"lcnumber");
                getBillCardPanel().setBodyValueAt(NumFormate.getPrecisionData(new UFDouble(cvo.getPrice().doubleValue()*cvo.getNumber().doubleValue()),2),e.getRow(),"totalsum");
                TypeVO tvo = TypeBO_Client.findByPrimaryKey(cvo.getPk_lctype());
                getBillCardPanel().setBodyValueAt(tvo.getLctypecode() + " " + tvo.getLctypename(),e.getRow(),"lctype");
                DeptdocVO dcvo = DeptdocBO_Client.findByPrimaryKey(cvo.getPk_usedept());
                getBillCardPanel().setBodyValueAt(dcvo.getDeptname(),e.getRow(),"deptfrom");
                CorpVO cpvo = CorpBO_Client.findByPrimaryKey(dcvo.getPk_corp());
                getBillCardPanel().setBodyValueAt(cpvo.getUnitcode() + " " + cpvo.getUnitname(),e.getRow(),"corpfrom");
                nc.vo.bd.b06.PsndocVO psnvo = PsndocBO_Client.findByPrimaryKey(cvo.m_def1);
                getBillCardPanel().setBodyValueAt(psnvo.getPsnname(), e.getRow(), "user");
                getBillCardPanel().setBodyValueAt(cvo.m_def1, e.getRow(), "def2");
            } catch (Exception ex){
                System.out.println("在afterEdit中发生错误"+ex.getMessage());
                ex.printStackTrace();
            }
        }
//        if(e.getKey()!=null && (e.getKey().equals("pk_corpto")||e.getKey().equals("corpto"))){
//            try {
//                Object objRef = getBillCardPanel().getBillModel().getItemByKey("deptto").getComponent();
//                String pk_corpto = (String) getBillCardPanel().getBodyValueAt(e.getRow(),"pk_corpto");
//                if(objRef instanceof UIRefPane){
//                    UIRefPane refPane = (UIRefPane) objRef;
//                    Object objRefModel = refPane.getRefModel();
//                    DeptRefModel refModel = (DeptRefModel) refPane.getRefModel();
//                    refModel.clearData();
//                    refModel.setCorp(pk_corpto);
//                }               
//            } catch (Exception ex) {
//                System.out.println("在afterEdit中发生错误"+ex.getMessage());
//                ex.printStackTrace();                
//            }
//        }        
//        if(e.getKey()!=null && (e.getKey().equals("pk_deptto")||e.getKey().equals("deptto"))){
//            try {
//                String pk_deptdoc = (String) getBillCardPanel().getBodyValueAt(e.getRow(),"pk_deptto");
//                DeptdocVO dcvo = DeptdocBO_Client.findByPrimaryKey(pk_deptdoc);
//                CorpVO cpvo = CorpBO_Client.findByPrimaryKey(dcvo.getPk_corp());
//                getBillCardPanel().setBodyValueAt(cpvo.getUnitname(),e.getRow(),"corpto");                
//            } catch (Exception ex) {
//                
//            }
//        }
        super.afterEdit(e);
    }
    /* （非 Javadoc）
     * @see nc.ui.pub.bill.BillEditListener2#beforeEdit(nc.ui.pub.bill.BillEditEvent)
     */
    public boolean beforeEdit(BillEditEvent e) {
        System.out.println("----------before edit---------");
        if(e.getKey()!=null && (e.getKey().equals("deptto"))){
            try {
                Object objRef = getBillCardPanel().getBillModel().getItemByKey("deptto").getComponent();
                String pk_corpto = (String) getBillCardPanel().getBodyValueAt(e.getRow(),"pk_corpto");
                if(objRef instanceof UIRefPane){
                    UIRefPane refPane = (UIRefPane) objRef;
                    //Object objRefModel = refPane.getRefModel();
                    DeptRefModel refModel = (DeptRefModel) refPane.getRefModel();
                    refModel.clearData();
                    refModel.setCorp(pk_corpto);
                }               
            } catch (Exception ex) {
                System.out.println("在afterEdit中发生错误"+ex.getMessage());
                ex.printStackTrace();                
            }
        }
        if(e.getKey()!=null&&(e.getKey().equals("userto"))){
        	try{
        		Object obj = null;
        		obj = getBillCardPanel().getBillModel().getItemByKey("userto").getComponent();
        		String pk_corpto = (String)getBillCardPanel().getBodyValueAt(e.getRow(), "pk_corpto");
        		if(obj instanceof UIRefPane){
        			UIRefPane ref = (UIRefPane)obj;
        			//Object objRefModel0 = ref.getRefModel();
        			PsnRefModel refModel0 = (PsnRefModel)ref.getRefModel();
        			refModel0.clearData();
        			refModel0.setCorp(pk_corpto);
        		}
        	}catch(Exception e0){
        		e0.printStackTrace();
        	}
        }
        return super.beforeEdit(e);
    }
    /* （非 Javadoc）
     * @see nc.ui.trade.base.AbstractBillUI#getUserObject()
     */
    public Object getUserObject() {
        return new TransGetCheck();
    }
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#setButtons(nc.ui.pub.ButtonObject[])
     */
    protected void setButtons(ButtonObject[] buttons) {
        if(buttons!=null && buttons.length>5){
            ButtonObject [] childbtns = buttons[4].getChildButtonGroup();
            ButtonObject [] newChildBtns = new ButtonObject[3];
            newChildBtns[0] = childbtns[0];
            newChildBtns[1] = childbtns[1];
            newChildBtns[2] = m_btnAddBatch;
            m_btnAddBatch.setTag("150");
            buttons[4].setChildButtonGroup(newChildBtns);
        }
        super.setButtons(buttons);
    }
    
    

    
}
