/*
 * 创建日期 2005-10-7
 *
 * @author 孙锐
 */
package nc.ui.lowcost.cancel;

import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.ep.dj.DJZBBO_Client;
import nc.ui.lowcost.card.CardBO_Client;
import nc.ui.lowcost.type.TypeBO_Client;
import nc.ui.pub.ButtonObject;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.BillManageUI;
import nc.ui.trade.manage.ManageEventHandler;
import nc.vo.bd.b04.DeptdocVO;
import nc.vo.ep.dj.DJZBHeaderVO;
import nc.vo.ep.dj.DJZBVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.lowcost.type.TypeVO;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class CancelUI extends BillManageUI {

    public ButtonObject m_btnAddBatch = new ButtonObject("批量增加","批量增加",2);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2104498998544243892L;
	/**
     * 
     */
    public CancelUI() {
        super();
    }

    /**
     * @param useBillSource
     */
    public CancelUI(Boolean useBillSource) {
        super(useBillSource);
    }

    /**
     * @param pk_corp
     * @param pk_billType
     * @param pk_busitype
     * @param operater
     * @param billId
     */
    public CancelUI(String pk_corp, String pk_billType, String pk_busitype,
            String operater, String billId) {
        super(pk_corp, pk_billType, pk_busitype, operater, billId);
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#createController()
     */
    protected AbstractManageController createController() {
        return new CancelController();
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
        
        DJZBVO vo = new DJZBVO();
        DJZBHeaderVO header = new DJZBHeaderVO();
        header.setDjlxbm("L2");
        header.setDwbm(getClientEnvironment().getCorporation().getPk_corp());
        vo.setParentVO(header);
        String djbh = DJZBBO_Client.getDjbh(vo);
        getBillCardPanel().setHeadItem("cancelcode",djbh);
        getBillCardPanel().getHeadItem("cancelcode").setEnabled(false);
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.bill.BillEditListener#afterEdit(nc.ui.pub.bill.BillEditEvent)
     */
    public void afterEdit(BillEditEvent e) {
        System.out.println("-------sunrui test--------:in afterEdit");
        if(e.getKey()!=null && (e.getKey().equals("pk_lccard")||e.getKey().equals("lccard")) ){
            try {
                String pk_lccard = (String)getBillCardPanel().getBodyValueAt(e.getRow(),"pk_lccard");
                CardVO cvo = CardBO_Client.findByPrimaryKey(pk_lccard);
                getBillCardPanel().setBodyValueAt(cvo.getPk_usedept(),e.getRow(),"usedept");
                getBillCardPanel().setBodyValueAt(NumFormate.getPrecisionData(cvo.getPrice(),2),e.getRow(),"price");
                getBillCardPanel().setBodyValueAt(NumFormate.getPrecisionData(cvo.getNumber(),0),e.getRow(),"lcnumber");
                getBillCardPanel().setBodyValueAt(NumFormate.getPrecisionData(new UFDouble(cvo.getPrice().doubleValue()*cvo.getNumber().doubleValue()),2),e.getRow(),"totalsum");
                TypeVO tvo = TypeBO_Client.findByPrimaryKey(cvo.getPk_lctype());
                getBillCardPanel().setBodyValueAt(tvo.getLctypename(),e.getRow(),"lctype");
                DeptdocVO dcvo = DeptdocBO_Client.findByPrimaryKey(cvo.getPk_usedept());
                getBillCardPanel().setBodyValueAt(dcvo.getDeptname(),e.getRow(),"usedept");
//                CorpVO cpvo = CorpBO_Client.findByPrimaryKey(dcvo.getPk_corp());
//                getBillCardPanel().setBodyValueAt(cpvo.getUnitcode() + " " + cpvo.getUnitname(),e.getRow(),"corpfrom");
            } catch (Exception ex){
                
            }
        }
    }
    /* （非 Javadoc）
     * @see nc.ui.trade.manage.BillManageUI#createEventHandler()
     */
    protected ManageEventHandler createEventHandler() {
        return new CancelEventHandler(this,getUIControl());
    }
    /* （非 Javadoc）
     * @see nc.ui.trade.base.AbstractBillUI#getUserObject()
     */
    public Object getUserObject() {
        return new CancelGetCheck();
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
