/*
 * �������� 2005-9-23
 *
 * @author ����
 */
package nc.ui.lowcost.trans;

import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.UIButton;
import nc.ui.pub.beans.UIComboBox;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UILabel;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UIRefPane;

import nc.ui.trade.query.INormalQuery;

import java.awt.Container;
import java.awt.Frame;


/**
 * @author ����
 *
 */
public class TransQueryDlg extends UIDialog implements INormalQuery {
    /**
     *
     */
    private static final long serialVersionUID = 6948744440898029938L;
    private UIPanel UIPanel = null;
    private UIButton btnOk = null;
    private UIButton btnCancel = null;
    private UILabel lblMakeDate = null;
    private UIRefPane refMakeDateStart = null;
    private UILabel lblMakeDate2 = null;
    private UIRefPane refMakeDateEnd = null;
    private UILabel lblCheckDate = null;
    private UIRefPane refCheckDateStart = null;
    private UILabel lblCheckDate2 = null;
    private UIRefPane refCheckDateEnd = null;
    private UILabel UILabel4 = null;
    private UIComboBox cbStatus = null;
    private UILabel UILabel5 = null;
    private UIComboBox cbTallyStatus = null;
    private UILabel UILabel6 = null;
    private UIRefPane refMaker = null;
    private UILabel UILabel7 = null;
    private UIRefPane refChecker = null;
    private UILabel UILabel = null;
    private UIRefPane UIRefPane = null;

    /**
     *
     */
    public TransQueryDlg() {
        super();
        initialize();
    }

    /**
     * @param parent
     */
    public TransQueryDlg(Container parent) {
        super(parent);
        initialize();
    }

    /**
     * @param parent
     * @param title
     */
    public TransQueryDlg(Container parent, String title) {
        super(parent, title);
        initialize();
    }

    /**
     * @param owner
     */
    public TransQueryDlg(Frame owner) {
        super(owner);
        initialize();
    }

    /**
     * @param owner
     * @param title
     */
    public TransQueryDlg(Frame owner, String title) {
        super(owner, title);
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setTitle("��ѡ���ѯ����");
        this.setContentPane(getUIPanel());
        this.setSize(498, 260);
        getRefMaker().setRefModel(new UserRefModel());
        getRefChecker().setRefModel(new UserRefModel());
        getUIRefPane().setRefModel(new LcCardRefModel());
    }

    /* ���� Javadoc��
     * @see nc.ui.trade.query.INormalQuery#checkCondition()
     */
    public String checkCondition() {
        return null;
    }

    /* ���� Javadoc��
     * @see nc.ui.trade.query.INormalQuery#getWhereSql()
     */
    public String getWhereSql() {
        String makeDateStart = getRefMakeDateStart().getRefPK();
        String makeDateEnd = getRefMakeDateEnd().getRefPK();
        String checkDateStart = getRefCheckDateStart().getRefPK();
        String checkDateEnd = getRefCheckDateEnd().getRefPK();
        String status = (String) getCbStatus().getSelectedItem();
        String tallyStatus = (String) getCbTallyStatus().getSelectedItem();
        String pk_maker = getRefMaker().getRefPK();
        String pk_checker = getRefChecker().getRefPK();
        String pk_lc = getUIRefPane().getRefPK(); //��Ʒ����

        String whereSql = " 1=1 ";

        if ((makeDateStart != null) && (makeDateStart.trim().length() != 0)) {
            whereSql += (" and makedate >= '" + makeDateStart + "' ");
        }

        if ((makeDateEnd != null) && (makeDateEnd.trim().length() != 0)) {
            whereSql += (" and makedate <= '" + makeDateEnd + "' ");
        }

        if ((checkDateStart != null) && (checkDateStart.trim().length() != 0)) {
            whereSql += (" and checkdate >= '" + checkDateStart + "' ");
        }

        if ((checkDateEnd != null) && (checkDateEnd.trim().length() != 0)) {
            whereSql += (" and checkdate <= '" + checkDateEnd + "' ");
        }

        //���״̬
        if ((status != null) && (!status.equals(""))) {
            if (status.equals("δ���")) {
                whereSql += " and checkflag is null and pk_checker is null ";
            }

            if (status.equals("�����")) {
                whereSql += " and checkflag is null and pk_checker is not null ";
            }

            if (status.equals("���ͨ��")) {
                whereSql += " and checkflag = 'Y' ";
            }

            if (status.equals("���δͨ��")) {
                whereSql += " and checkflag = 'N' ";
            }
        }

        //����״̬
        if ((tallyStatus != null) && (!tallyStatus.equals(""))) {
            if (tallyStatus.equals("δ����")) {
                whereSql += " and tallyflag = 'N' ";
            }

            if (tallyStatus.equals("�Ѽ���")) {
                whereSql += " and tallyflag = 'Y' ";
            }
        }

        if (pk_maker != null) {
            whereSql += (" and pk_maker = '" + pk_maker + "' ");
        }

        if (pk_checker != null) {
            whereSql += (" and pk_checker = '" + pk_checker + "' ");
        }

        //��˾�޶�
        try {
            String pk_corp = ClientEnvironment.getInstance().getCorporation()
                                              .getPrimaryKey();
            whereSql += (" and pk_trans in ( select pk_trans from lc_trans where pk_trans in (select pk_trans from lc_trans_m where pk_deptfrom in (select pk_deptdoc from bd_deptdoc where pk_corp = '" +
            pk_corp + "')))");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //��Ʒ�޶�
        if ((pk_lc != null)) {
            whereSql += (" and pk_trans in (select pk_trans from lc_trans_m where pk_lccard = '" +
            pk_lc + "')");
        }

        System.out.println("TransQueryDlg WhereSQL:" + whereSql);

        return whereSql;
    }

    /**
     * This method initializes UIPanel
     *
     * @return nc.ui.pub.beans.UIPanel
     */
    private UIPanel getUIPanel() {
        if (UIPanel == null) {
            UILabel = new UILabel();
            UILabel7 = new UILabel();
            UILabel6 = new UILabel();
            UILabel5 = new UILabel();
            UILabel4 = new UILabel();
            lblCheckDate2 = new UILabel();
            lblCheckDate = new UILabel();
            lblMakeDate2 = new UILabel();
            lblMakeDate = new UILabel();
            UIPanel = new UIPanel();
            UIPanel.setLayout(null);
            lblMakeDate.setBounds(20, 16, 57, 21);
            lblMakeDate.setText("�Ƶ�����");
            lblMakeDate2.setBounds(250, 16, 19, 20);
            lblMakeDate2.setText("��");
            lblCheckDate.setBounds(20, 55, 57, 22);
            lblCheckDate.setText("�������");
            lblCheckDate2.setBounds(250, 55, 19, 22);
            lblCheckDate2.setText("��");
            UILabel4.setBounds(20, 98, 57, 22);
            UILabel4.setText("����״̬");
            UILabel5.setBounds(248, 97, 55, 22);
            UILabel5.setText("����״̬");
            UILabel6.setBounds(20, 137, 57, 22);
            UILabel6.setText("�Ƶ���");
            UILabel7.setBounds(248, 137, 55, 22);
            UILabel7.setText("�����");
            UILabel.setBounds(19, 174, 61, 23);
            UILabel.setText("��Ʒ");
            UIPanel.add(getBtnOk(), null);
            UIPanel.add(getBtnCancel(), null);
            UIPanel.add(lblMakeDate, null);
            UIPanel.add(getRefMakeDateStart(), null);
            UIPanel.add(lblMakeDate2, null);
            UIPanel.add(getRefMakeDateEnd(), null);
            UIPanel.add(lblCheckDate, null);
            UIPanel.add(getRefCheckDateStart(), null);
            UIPanel.add(lblCheckDate2, null);
            UIPanel.add(getRefCheckDateEnd(), null);
            UIPanel.add(UILabel4, null);
            UIPanel.add(getCbStatus(), null);
            UIPanel.add(UILabel5, null);
            UIPanel.add(getCbTallyStatus(), null);
            UIPanel.add(UILabel6, null);
            UIPanel.add(getRefMaker(), null);
            UIPanel.add(UILabel7, null);
            UIPanel.add(getRefChecker(), null);
            UIPanel.add(UILabel, null);
            UIPanel.add(getUIRefPane(), null);
        }

        return UIPanel;
    }

    /**
     * This method initializes UIButton
     *
     * @return nc.ui.pub.beans.UIButton
     */
    private UIButton getBtnOk() {
        if (btnOk == null) {
            btnOk = new UIButton();
            btnOk.setBounds(118, 201, 83, 22);
            btnOk.setText("ȷ��");
            btnOk.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        closeOK();
                    }
                });
        }

        return btnOk;
    }

    /**
     * This method initializes UIButton
     *
     * @return nc.ui.pub.beans.UIButton
     */
    private UIButton getBtnCancel() {
        if (btnCancel == null) {
            btnCancel = new UIButton();
            btnCancel.setBounds(280, 202, 93, 22);
            btnCancel.setText("ȡ��");
            btnCancel.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        closeCancel();
                    }
                });
        }

        return btnCancel;
    }

    /**
     * This method initializes UIRefPane
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefMakeDateStart() {
        if (refMakeDateStart == null) {
            refMakeDateStart = new UIRefPane();
            refMakeDateStart.setBounds(91, 16, 149, 23);
            refMakeDateStart.setRefNodeName("����");
        }

        return refMakeDateStart;
    }

    /**
     * This method initializes UIRefPane1
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefMakeDateEnd() {
        if (refMakeDateEnd == null) {
            refMakeDateEnd = new UIRefPane();
            refMakeDateEnd.setBounds(285, 16, 153, 23);
            refMakeDateEnd.setRefNodeName("����");
        }

        return refMakeDateEnd;
    }

    /**
     * This method initializes UIRefPane2
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefCheckDateStart() {
        if (refCheckDateStart == null) {
            refCheckDateStart = new UIRefPane();
            refCheckDateStart.setBounds(91, 55, 149, 23);
            refCheckDateStart.setRefNodeName("����");
        }

        return refCheckDateStart;
    }

    /**
     * This method initializes UIRefPane3
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefCheckDateEnd() {
        if (refCheckDateEnd == null) {
            refCheckDateEnd = new UIRefPane();
            refCheckDateEnd.setBounds(285, 55, 153, 23);
            refCheckDateEnd.setRefNodeName("����");
        }

        return refCheckDateEnd;
    }

    /**
     * This method initializes UIComboBox
     *
     * @return nc.ui.pub.beans.UIComboBox
     */
    private UIComboBox getCbStatus() {
        if (cbStatus == null) {
            cbStatus = new UIComboBox();
            cbStatus.setBounds(91, 98, 148, 23);
            cbStatus.addItem("");
            cbStatus.addItem("δ���");
            cbStatus.addItem("�����");
            cbStatus.addItem("���ͨ��");
            cbStatus.addItem("���δͨ��");
        }

        return cbStatus;
    }

    /**
     * This method initializes UIComboBox1
     *
     * @return nc.ui.pub.beans.UIComboBox
     */
    private UIComboBox getCbTallyStatus() {
        if (cbTallyStatus == null) {
            cbTallyStatus = new UIComboBox();
            cbTallyStatus.setBounds(311, 97, 148, 23);
            cbTallyStatus.addItem("");
            cbTallyStatus.addItem("δ����");
            cbTallyStatus.addItem("�Ѽ���");
        }

        return cbTallyStatus;
    }

    /**
     * This method initializes UIRefPane4
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefMaker() {
        if (refMaker == null) {
            refMaker = new UIRefPane();
            refMaker.setBounds(91, 137, 148, 23);
        }

        return refMaker;
    }

    /**
     * This method initializes UIRefPane5
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefChecker() {
        if (refChecker == null) {
            refChecker = new UIRefPane();
            refChecker.setBounds(311, 137, 148, 23);
        }

        return refChecker;
    }

    /**
     * This method initializes UIRefPane
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getUIRefPane() {
        if (UIRefPane == null) {
            UIRefPane = new UIRefPane();
            UIRefPane.setBounds(91, 172, 148, 22);
        }

        return UIRefPane;
    }
}
