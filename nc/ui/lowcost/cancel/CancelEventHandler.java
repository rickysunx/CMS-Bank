/*
 * �������� 2005-10-7
 *
 * @author ����
 */
package nc.ui.lowcost.cancel;

import nc.ui.lowcost.trans.LcCardRefModel;
import nc.ui.pub.ButtonObject;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.businessaction.IBusinessController;
import nc.ui.trade.button.IBillButton;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.ui.trade.manage.ManageEventHandler;
import nc.ui.trade.query.INormalQuery;
import nc.vo.pub.SuperVO;

/**
 * @author ����
 *
 */
public class CancelEventHandler extends ManageEventHandler {

    /**
     * @param billUI
     * @param control
     */
    public CancelEventHandler(BillManageUI billUI, IControllerBase control) {
        super(billUI, control);
    }

    /* ���� Javadoc��
     * @see nc.ui.trade.handler.EventHandler#getQueryUI()
     */
    protected UIDialog getQueryUI() throws Exception {
        return new CancelQueryDlg(getBillUI());
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.bill.BillEventHandler#onBoEdit()
     */
    protected void onBoEdit() throws Exception {
    	String operator = getBillCardPanelWrapper().getBillCardPanel().getOperator();
        String pk_maker = getBillCardPanelWrapper().getBillCardPanel().getTailItem("pk_maker").getValue();
        
        if(pk_maker.equals(operator)){
        	super.onBoEdit();
        	getBillCardPanelWrapper().getBillCardPanel().getHeadItem("cancelcode").setEnabled(false);
        }else{
        	MessageDialog.showErrorDlg(null, "����", "��ǰ��¼�û������޸ģ����ò�ͬ�û���¼��");
        }
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.handler.EventHandler#createBusinessAction()
     */
    protected IBusinessController createBusinessAction() {
        return new CancelBusinessAction(getBillUI());
        //return super.createBusinessAction();
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.bill.BillEventHandler#onBoAudit()
     */
    public void onBoAudit() throws Exception {
        super.onBoAudit();
        onBoRefresh();
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.bill.BillEventHandler#onBoCancelAudit()
     */
    protected void onBoCancelAudit() throws Exception {
        // TODO �Զ����ɷ������
        super.onBoCancelAudit();
        onBoRefresh();
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.bill.BillEventHandler#onBoSave()
     */
    protected void onBoSave() throws Exception {
        super.onBoSave();
        onBoRefresh();
    }
    /* ���� Javadoc��
     * @see nc.ui.trade.bill.BillEventHandler#onBoQuery()
     */
    protected void onBoQuery() throws Exception {
		UIDialog querydialog = getQueryUI();

		if (querydialog.showModal() == UIDialog.ID_OK) {
			INormalQuery query = (INormalQuery) querydialog;

			String strWhere = query.getWhereSql();
			if (strWhere == null)
				strWhere = "1=1";

			if (getButtonManager().getButton(IBillButton.Busitype) != null) {
				if (getBillIsUseBusiCode().booleanValue())
					//ҵ�����ͱ���
					strWhere = "(" + strWhere + ") and "
							+ getBillField().getField_BusiCode() + "='"
							+ getBillUI().getBusicode() + "'";

				else
					//ҵ������
					strWhere = "(" + strWhere + ") and "
							+ getBillField().getField_Busitype() + "='"
							+ getBillUI().getBusinessType() + "'";

			}

			strWhere = "(" + strWhere + ") and (isnull(dr,0)=0)";

			strWhere += " order by lc_cancel.cancelcode";
			
			if (getHeadCondition() != null)
				strWhere = strWhere + " and " + getHeadCondition();

			SuperVO[] queryVos = getBusiDelegator().queryHeadAllData(
					Class.forName(getUIController().getBillVoName()[1]),
					getUIController().getBillType(), strWhere);

			//��ջ�������
			getBufferData().clear();
			if (queryVos != null && queryVos.length != 0) {
				//�������ݵ�Buffer
				addDataToBuffer(queryVos);
				
				getBillUI().setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
				getBillUI().setBillOperate(IBillOperate.OP_NOTEDIT);
				getBufferData().setCurrentRow(0);
			} else {
				getBillUI().setListHeadData(queryVos);
				getBillUI().setBillOperate(IBillOperate.OP_INIT);
				getBufferData().setCurrentRow(-1);
				getBillUI().showHintMessage("û�в鵽�κ���������������!");
			}

		}
    }

	protected void onBoDel() throws Exception {
		String operator = getBillCardPanelWrapper().getBillCardPanel().getOperator();
        String pk_maker = getBillCardPanelWrapper().getBillCardPanel().getTailItem("pk_maker").getValue();
        if(pk_maker.equals(operator))
			super.onBoDel();
		else
			MessageDialog.showErrorDlg(getBillUI(), "����", "��ǰ��¼�û������޸ģ����ò�ͬ�û���¼��");
	}
    /* ���� Javadoc��
     * @see nc.ui.trade.bill.BillEventHandler#onButton(nc.ui.pub.ButtonObject)
     */
    public void onButton(ButtonObject bo) {
        // TODO �Զ����ɷ������
        super.onButton(bo);
        if(bo.getName().equals("��������")){
            LcCardRefModel refModel = new LcCardRefModel();
            UIRefPane rp = new UIRefPane();
            rp.setRefModel(refModel);
            rp.setMultiSelectedEnabled(true);
            rp.onButtonClicked();
            String [] pk_lccards = rp.getRefPKs();
            BillCardPanel cp = getBillCardPanelWrapper().getBillCardPanel();
            if(pk_lccards!=null && pk_lccards.length>0){
                for (int i = 0; i < pk_lccards.length; i++) {
                    cp.addLine();
                    int n = cp.getBillModel().getRowCount()-1;
                    cp.setBodyValueAt(pk_lccards[i],n,"pk_lccard");
                    cp.getBillTable().editCellAt(n,0);
                }
            }
        }
    }
}
