/*
 * 创建日期 2005-10-9
 *
 * @author 孙锐
 */
package nc.ui.lowcost.report;

import nc.ui.lowcost.card.*;

import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.*;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UICheckBox;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.ValueChangedEvent;

import nc.ui.sm.user.UserBO_Client;

import nc.vo.lowcost.pub.LCTools;

import java.awt.*;

import java.util.Vector;


/**
 * @author 孙锐
 *
 */
public class LowCostQueryDlg extends UIDialog implements ValueChangedListener {
    /**
     *
     */
    private static final long serialVersionUID = -2397006414487364906L;
    private UIPanel UIPanel = null;
    private UILabel UILabel = null;
    private UILabel UILabel1 = null;
    private UIRefPane refManageDept = null;
    private UILabel UILabel2 = null;
    private UIRefPane refUseDept = null;
    private UILabel UILabel3 = null;
    private UIRefPane refLcType = null;
    private UILabel UILabel4 = null;
    private UIButton btnOk = null;
    private UIButton btnCancel = null;
    private UIRefPane refCorp = null;
    private UICheckBox chkNotTally = null;
    private UICheckBox chkTallied = null;
    private UICheckBox chkCancelled = null;
    private UILabel UILabel5 = null;
    private UIRefPane UIRefPane = null;
    private UILabel UILabel6 = null;
    private UIRefPane UIRefPane1 = null;
    private UILabel UILabel7 = null;
    private UIRefPane UIRefPane2 = null;
    private UILabel UILabel8 = null;
    private UIRefPane UIRefPane3 = null;

    /**
     *
     */

    //增加的代码
    private UILabel inputPsn = null;
    private UILabel totalPrice = null;
    private UIRefPane inputPsnRefPane = null;
    private UILabel UILabel9 = null;
    private UITextField UITextField = null;
    private UITextField UITextField1 = null;
    private UILabel item = null;
    private UIRefPane itemPane = null;

    public LowCostQueryDlg() {
        super();
        initialize();
    }

    /**
     * @param parent
     */
    public LowCostQueryDlg(Container parent) {
        super(parent);
        initialize();
    }

    /**
     * @param parent
     * @param title
     */
    public LowCostQueryDlg(Container parent, String title) {
        super(parent, title);
        initialize();
    }

    /**
     * @param owner
     */
    public LowCostQueryDlg(Frame owner) {
        super(owner);
        initialize();
    }

    /**
     * @param owner
     * @param title
     */
    public LowCostQueryDlg(Frame owner, String title) {
        super(owner, title);
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setContentPane(getUIPanel());
        this.setTitle("查询");
        this.setSize(456, 362);

        onRefCorpChange();
    }

    /**
     * This method initializes UIPanel
     *
     * @return nc.ui.pub.beans.UIPanel
     */
    private UIPanel getUIPanel() {
        if (UIPanel == null) {
            UILabel9 = new UILabel();
            UILabel9.setBounds(new java.awt.Rectangle(256, 252, 32, 22));
            UILabel9.setText("\u81f3");
            UILabel8 = new UILabel();
            UILabel7 = new UILabel();
            UILabel6 = new UILabel();
            UILabel5 = new UILabel();
            UILabel4 = new UILabel();
            UILabel3 = new UILabel();
            UILabel2 = new UILabel();
            UILabel1 = new UILabel();
            item = new UILabel();
            UILabel = new UILabel();
            inputPsn = new UILabel();
            totalPrice = new UILabel();
            UIPanel = new UIPanel();
            UIPanel.setLayout(null);
            UILabel.setBounds(13, 12, 57, 23);
            UILabel.setText("组织机构");
            UILabel1.setBounds(299, 89, 56, 22);
            UILabel1.setText("管理部门");
            UILabel2.setBounds(13, 47, 57, 22);
            UILabel2.setText("使用部门");
            UILabel3.setBounds(229, 47, 56, 22);
            UILabel3.setText("物品类别");
            UILabel4.setBounds(13, 83, 57, 22);
            UILabel4.setText("物品状态");
            inputPsn.setBounds(16, 220, 57, 22);
            inputPsn.setText("录入人");
            totalPrice.setBounds(16, 252, 57, 22);
            totalPrice.setText("金额");
            item.setBounds(15, 116, 65, 23);
            item.setText("物品");
            UIPanel.add(UILabel, null);
            UIPanel.add(UILabel1, null);
            UIPanel.add(getRefManageDept(), null);
            UIPanel.add(UILabel2, null);
            UIPanel.add(getRefUseDept(), null);
            UIPanel.add(UILabel3, null);
            UIPanel.add(getRefLcType(), null);
            UIPanel.add(UILabel4, null);
            UIPanel.add(getBtnOk(), null);
            UIPanel.add(getBtnCancel(), null);
            UIPanel.add(getRefCorp(), null);
            UIPanel.add(getChkNotTally(), null);
            UIPanel.add(getChkTallied(), null);
            UIPanel.add(getChkCancelled(), null);
            UILabel1.setVisible(false);
            UILabel5.setBounds(15, 156, 65, 23);
            UILabel5.setText("购买时间从");
            UILabel6.setBounds(256, 156, 30, 21);
            UILabel6.setText("至");
            UILabel7.setBounds(16, 189, 66, 21);
            UILabel7.setText("增加时间从");
            UILabel8.setBounds(256, 186, 32, 22);
            UILabel8.setText("至");
            UIPanel.add(UILabel5, null);
            UIPanel.add(getUIRefPane(), null);
            UIPanel.add(UILabel6, null);
            UIPanel.add(getUIRefPane1(), null);
            UIPanel.add(UILabel7, null);
            UIPanel.add(getUIRefPane2(), null);
            UIPanel.add(UILabel8, null);
            UIPanel.add(getUIRefPane3(), null);
            UIPanel.add(totalPrice);
            UIPanel.add(inputPsn);
            UIPanel.add(getInputPsnRefPane());
            UIPanel.add(UILabel9, null);
            UIPanel.add(getUITextField(), null);
            UIPanel.add(getUITextField1(), null);
            UIPanel.add(item, null);
            UIPanel.add(getItemPane(), null);
        }

        return UIPanel;
    }

    /**
     * This method initializes UIRefPane
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefManageDept() {
        if (refManageDept == null) {
            refManageDept = new MyRefPane();
            refManageDept.setBounds(361, 90, 144, 22);
            refManageDept.setRefModel(new DeptRefModel());
            refManageDept.setMultiSelectedEnabled(true);
            refManageDept.setVisible(false);
        }

        return refManageDept;
    }

    private UIRefPane getItemPane() {
        if (this.itemPane == null) {
            itemPane = new MyRefPane();
            itemPane.addValueChangedListener(this);
            itemPane.setRefModel(new ItemRefModel());
            itemPane.setBounds(93, 116, 144, 23);
            itemPane.setMultiSelectedEnabled(true);
            itemPane.setAutoCheck(false);
        }

        return itemPane;
    }

    private UIRefPane getInputPsnRefPane() {
        if (inputPsnRefPane == null) {
            inputPsnRefPane = new UIRefPane();
            inputPsnRefPane.setRefModel(new InputPsnRefModel());
            inputPsnRefPane.setBounds(93, 220, 133, 21);
            inputPsnRefPane.setMultiSelectedEnabled(false);
            inputPsnRefPane.setVisible(true);
        }

        return inputPsnRefPane;
    }

    /**
     * This method initializes UIRefPane1
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefUseDept() {
        if (refUseDept == null) {
            refUseDept = new MyRefPane();
            refUseDept.setBounds(76, 47, 144, 22);
            refUseDept.setName("refUseDept");
            refUseDept.setRefModel(new DeptRefModel());
            refUseDept.setMultiSelectedEnabled(true);
        }

        return refUseDept;
    }

    /**
     * This method initializes UIRefPane2
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefLcType() {
        if (refLcType == null) {
            refLcType = new UIRefPane();
            refLcType.setBounds(297, 47, 144, 22);
            refLcType.setName("refLcType");

            //refLcType.setRefModel(new LcTypeRefModel());
            nc.ui.fa.UserDefRefModelOBjType dmUse = new nc.ui.fa.UserDefRefModelOBjType(ClientEnvironment.getInstance()
                                                                                                         .getCorporation()
                                                                                                         .getPrimaryKey());
            refLcType.setRefModel(dmUse);
            refLcType.setMultiSelectedEnabled(true);
            refLcType.setAutoCheck(false);
        }

        return refLcType;
    }

    /**
     * This method initializes UIButton
     *
     * @return nc.ui.pub.beans.UIButton
     */
    private UIButton getBtnOk() {
        if (btnOk == null) {
            btnOk = new UIButton();
            btnOk.setBounds(120, 294, 70, 22);
            btnOk.setText("确定");
            btnOk.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        closeOK();
                    }
                });
        }

        return btnOk;
    }

    /**
     * This method initializes UIButton1
     *
     * @return nc.ui.pub.beans.UIButton
     */
    private UIButton getBtnCancel() {
        if (btnCancel == null) {
            btnCancel = new UIButton();
            btnCancel.setBounds(240, 294, 70, 22);
            btnCancel.setText("取消");
            btnCancel.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        closeCancel();
                    }
                });
        }

        return btnCancel;
    }

    public void onRefCorpChange() {
        String[] pk_corps = refCorp.getRefPKs();

        if ((pk_corps == null) || (pk_corps.length == 0)) {
            getRefUseDept().setEnabled(false);
            getRefManageDept().setEnabled(false);
        } else {
            if (pk_corps.length > 1) {
                getRefUseDept().setEnabled(false);
                getRefManageDept().setEnabled(false);
            } else {
                getRefUseDept().setEnabled(true);
                getRefManageDept().setEnabled(true);

                String pk_corp = pk_corps[0];
                ((DeptRefModel) getRefUseDept().getRefModel()).setCorp(pk_corp);

                try {
                    boolean iscont = CardBO_Client.isControl("1001",
                            "bd_deptdoc_物品使用部门");

                    if (iscont) {
                        Vector vv = new Vector();
                        vv = CardBO_Client.getControlPks(pk_corp,
                                getClientEnvironment().getUser().getPrimaryKey(),
                                "bd_deptdoc_物品使用部门");

                        if ((vv != null) && (vv.size() > 0)) {
                            String tmp = "";

                            for (int i = 0; i < vv.size(); i++) {
                                tmp = tmp + "'" + vv.get(i).toString().trim() +
                                    "'";

                                if (i < (vv.size() - 1)) {
                                    tmp = tmp + ",";
                                }
                            }

                            ((DeptRefModel) getRefUseDept().getRefModel()).setWherePart(
                                " pk_deptdoc in (" + tmp + ")");
                        } else {
                            ((DeptRefModel) getRefUseDept().getRefModel()).setWherePart(
                                " 1<>1 ");
                        }
                    }
                } catch (Exception e1) {
                }

                ((DeptRefModel) getRefUseDept().getRefModel()).reloadData();
                ((DeptRefModel) getRefManageDept().getRefModel()).setCorp(pk_corp);

                try {
                    String isUseManageDept = LCTools.getParam(null, "LC20");

                    if (isUseManageDept.equals("Y")) //启用了管理部门
                     {
                        boolean iscont = CardBO_Client.isControl(pk_corp,
                                "bd_deptdoc_物品管理部门");

                        if (iscont) {
                            Vector vv1 = new Vector();
                            vv1 = CardBO_Client.getControlPks(pk_corp,
                                    getClientEnvironment().getUser()
                                        .getPrimaryKey(), "bd_deptdoc_物品管理部门");

                            if ((vv1 != null) && (vv1.size() > 0)) {
                                String tmp = "";

                                for (int i = 0; i < vv1.size(); i++) {
                                    tmp = tmp + "'" +
                                        vv1.get(i).toString().trim() + "'";

                                    if (i < (vv1.size() - 1)) {
                                        tmp = tmp + ",";
                                    }
                                }

                                ((DeptRefModel) getRefManageDept().getRefModel()).setWherePart(
                                    " pk_deptdoc in (" + tmp + ")");
                            }
                        }
                    }
                } catch (Exception e1) {
                }

                ((DeptRefModel) getRefManageDept().getRefModel()).reloadData();
            }
        }
    }

    /**
     * This method initializes UIRefPane
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getRefCorp() {
        if (refCorp == null) {
            refCorp = new MyRefPane();
            refCorp.setBounds(76, 12, 364, 22);
            //refCorp.setRefModel(new CorpRefModel());
            //refCorp.setRefType(1);
            refCorp.setRefNodeName("权限公司目录");
            refCorp.setMultiSelectedEnabled(true);
            refCorp.setButtonFireEvent(true);
            refCorp.setPK(getClientEnvironment().getCorporation().getPk_corp());
            refCorp.addValueChangedListener(new nc.ui.pub.beans.ValueChangedListener() {
                    public void valueChanged(
                        nc.ui.pub.beans.ValueChangedEvent e) {
                        onRefCorpChange();
                    }
                });
        }

        return refCorp;
    }

    /**
     * This method initializes UICheckBox
     *
     * @return nc.ui.pub.beans.UICheckBox
     */
    private UICheckBox getChkNotTally() {
        if (chkNotTally == null) {
            chkNotTally = new UICheckBox();
            chkNotTally.setBounds(76, 83, 62, 22);
            chkNotTally.setText("未记账");
        }

        return chkNotTally;
    }

    /**
     * This method initializes chkTallied
     *
     * @return nc.ui.pub.beans.UICheckBox
     */
    private UICheckBox getChkTallied() {
        if (chkTallied == null) {
            chkTallied = new UICheckBox();
            chkTallied.setBounds(150, 83, 62, 22);
            chkTallied.setText("已记账");
            chkTallied.setSelected(true);
        }

        return chkTallied;
    }

    /**
     * This method initializes chkCancelled
     *
     * @return nc.ui.pub.beans.UICheckBox
     */
    private UICheckBox getChkCancelled() {
        if (chkCancelled == null) {
            chkCancelled = new UICheckBox();
            chkCancelled.setBounds(223, 83, 62, 22);
            chkCancelled.setText("已核销");
        }

        return chkCancelled;
    }

    public String getWhereSql() {
        String temp = getItemPane().getText();
        String whereSql = "";
        String[] pk_corps = getRefCorp().getRefPKs();

        String[] refPk = getItemPane().getRefPKs();

        if ((temp != null) && (temp.length() > 0)) {
            if ((refPk != null) && (refPk.length > 0)) {
                whereSql += " pk_lccard in (";

                for (int i = 0; i < refPk.length; i++) {
                    whereSql += ("'" + refPk[i] + "'");

                    if (i != (refPk.length - 1)) {
                        whereSql += ", ";
                    }
                }

                whereSql += ") ";
            } else {
                MessageDialog.showErrorDlg(this, "错误", "物品编码不正确！");
                whereSql += (" lccode like '" + temp + "' ");
            }

            //whereSql += " and lccode like ''";
            return whereSql;
        }

        if ((pk_corps != null) && (pk_corps.length > 0)) {
            if (pk_corps.length > 1) {
                //选择多个公司
                log("选择了多个公司");
                whereSql += " b.pk_corp in (";

                for (int i = 0; i < pk_corps.length; i++) {
                    whereSql += ("'" + pk_corps[i] + "'");

                    if (i < (pk_corps.length - 1)) {
                        whereSql += ",";
                    }
                }

                whereSql += ") and ";
            } else {
                //仅选择一个公司,获取选择的部门信息
                log("选择了一个公司");
                whereSql += (" b.pk_corp='" + pk_corps[0] + "' and ");

                //部门限定
                String[] pk_usedepts = getRefUseDept().getRefPKs();

                if ((pk_usedepts != null) && (pk_usedepts.length > 0)) {
                    whereSql += " a.pk_usedept in (";

                    for (int i = 0; i < pk_usedepts.length; i++) {
                        whereSql += ("'" + pk_usedepts[i] + "'");

                        if (i < (pk_usedepts.length - 1)) {
                            whereSql += ",";
                        }
                    }

                    whereSql += ") and ";

                    //ryh 20060516 add
                } else { //没选使用部门

                    try {
                        boolean iscont = CardBO_Client.isControl(pk_corps[0],
                                "bd_deptdoc_物品使用部门");

                        if (iscont) {
                            Vector vv = new Vector();
                            vv = CardBO_Client.getControlPks(pk_corps[0],
                                    getClientEnvironment().getUser()
                                        .getPrimaryKey(), "bd_deptdoc_物品使用部门");

                            if ((vv != null) && (vv.size() > 0)) {
                                String tmp = "";

                                for (int i = 0; i < vv.size(); i++) {
                                    tmp = tmp + "'" +
                                        vv.get(i).toString().trim() + "'";

                                    if (i < (vv.size() - 1)) {
                                        tmp = tmp + ",";
                                    }
                                }

                                whereSql += (" a.pk_usedept in (" + tmp +
                                ") and ");
                            }
                        }
                    } catch (Exception e1) {
                    }
                }

                // add end
                String[] pk_managedepts = getRefManageDept().getRefPKs();

                if ((pk_managedepts != null) && (pk_managedepts.length > 0)) {
                    whereSql += " a.pk_managedept in (";

                    for (int i = 0; i < pk_managedepts.length; i++) {
                        whereSql += ("'" + pk_managedepts[i] + "'");

                        if (i < (pk_managedepts.length - 1)) {
                            whereSql += ",";
                        }
                    }

                    whereSql += ") and ";

                    //ryh 20060516 add
                } else {
                    String isUseManageDept = LCTools.getParam(null, "LC20");

                    if ((isUseManageDept != null) &&
                            (!isUseManageDept.equals("")) &&
                            (isUseManageDept.equals("Y"))) //启用了管理部门
                     {
                        try {
                            boolean iscont = CardBO_Client.isControl(pk_corps[0],
                                    "bd_deptdoc_物品管理部门");

                            if (iscont) {
                                Vector vv2 = new Vector();
                                vv2 = CardBO_Client.getControlPks(pk_corps[0],
                                        getClientEnvironment().getUser()
                                            .getPrimaryKey(),
                                        "bd_deptdoc_物品管理部门");

                                if ((vv2 != null) && (vv2.size() > 0)) {
                                    String tmp = "";

                                    for (int i = 0; i < vv2.size(); i++) {
                                        tmp = tmp + "'" +
                                            vv2.get(i).toString().trim() + "'";

                                        if (i < (vv2.size() - 1)) {
                                            tmp = tmp + ",";
                                        }
                                    }

                                    whereSql += (" a.pk_managedept in (" + tmp +
                                    ") and ");
                                }
                            }
                        } catch (Exception e1) {
                        }
                    }
                }

                // add end
            }
        } else {
            //没有选择公司,使用默认公司
            log("没有选择公司");
            whereSql += (" b.pk_corp='" +
            ClientEnvironment.getInstance().getCorporation().getPrimaryKey() +
            "' and ");

            String[] pk_usedepts = getRefUseDept().getRefPKs();

            if ((pk_usedepts != null) && (pk_usedepts.length > 0)) {
                whereSql += " a.pk_usedept in (";

                for (int i = 0; i < pk_usedepts.length; i++) {
                    whereSql += ("'" + pk_usedepts[i] + "'");

                    if (i < (pk_usedepts.length - 1)) {
                        whereSql += ",";
                    }
                }

                whereSql += ") and ";
            }
            //ryh 20060516 add
            else { //没选使用部门

                try {
                    boolean iscont = CardBO_Client.isControl(ClientEnvironment.getInstance()
                                                                              .getCorporation()
                                                                              .getPrimaryKey(),
                            "bd_deptdoc_物品使用部门");

                    if (iscont) {
                        Vector vv3 = new Vector();
                        vv3 = CardBO_Client.getControlPks(ClientEnvironment.getInstance()
                                                                           .getCorporation()
                                                                           .getPrimaryKey(),
                                getClientEnvironment().getUser().getPrimaryKey(),
                                "bd_deptdoc_物品使用部门");

                        if ((vv3 != null) && (vv3.size() > 0)) {
                            String tmp = "";

                            for (int i = 0; i < vv3.size(); i++) {
                                tmp = tmp + "'" + vv3.get(i).toString().trim() +
                                    "'";

                                if (i < (vv3.size() - 1)) {
                                    tmp = tmp + ",";
                                }
                            }

                            whereSql += (" a.pk_usedept in (" + tmp + ") and ");
                        }
                    }
                } catch (Exception e1) {
                }
            }

            String[] pk_managedepts = getRefManageDept().getRefPKs();

            if ((pk_managedepts != null) && (pk_managedepts.length > 0)) {
                whereSql += " a.pk_managedept in (";

                for (int i = 0; i < pk_managedepts.length; i++) {
                    whereSql += ("'" + pk_managedepts[i] + "'");

                    if (i < (pk_managedepts.length - 1)) {
                        whereSql += ",";
                    }
                }

                whereSql += ") and ";
            } else {
                String isUseManageDept = LCTools.getParam(null, "LC20");

                if (isUseManageDept.equals("Y")) //启用了管理部门  
                 {
                    try {
                        boolean iscont = CardBO_Client.isControl(ClientEnvironment.getInstance()
                                                                                  .getCorporation()
                                                                                  .getPrimaryKey(),
                                "bd_deptdoc_物品管理部门");

                        if (iscont) {
                            Vector vv3 = new Vector();
                            vv3 = CardBO_Client.getControlPks(ClientEnvironment.getInstance()
                                                                               .getCorporation()
                                                                               .getPrimaryKey(),
                                    getClientEnvironment().getUser()
                                        .getPrimaryKey(), "bd_deptdoc_物品管理部门");

                            if ((vv3 != null) && (vv3.size() > 0)) {
                                String tmp = "";

                                for (int i = 0; i < vv3.size(); i++) {
                                    tmp = tmp + "'" +
                                        vv3.get(i).toString().trim() + "'";

                                    if (i < (vv3.size() - 1)) {
                                        tmp = tmp + ",";
                                    }
                                }

                                whereSql += (" a.pk_managedept in (" + tmp +
                                ") and ");
                            }
                        }
                    } catch (Exception e1) {
                    }
                }
            }
        }

        //物品类别
        //String lccode = (String) getRefLcType().getRefValue("lc");
        Object[] lccodes = (Object[]) getRefLcType().getRefValues("lctypecode");

        if ((lccodes != null) && (lccodes.length > 0)) {
            whereSql += " ( ";

            for (int i = 0; i < lccodes.length; i++) {
                whereSql += ("pk_lctype in (select pk_lctype from lc_type where lctypecode like '" +
                lccodes[i] + "%') ");

                if (i < (lccodes.length - 1)) {
                    whereSql += " or ";
                }
            }

            whereSql += ") and ";
        } else {
            try {
                boolean iscont = CardBO_Client.isControl(ClientEnvironment.getInstance()
                                                                          .getCorporation()
                                                                          .getPrimaryKey(),
                        "lc_type_低值易耗品类别");

                if (iscont) {
                    Vector vv3 = new Vector();
                    vv3 = CardBO_Client.getControlPks(ClientEnvironment.getInstance()
                                                                       .getCorporation()
                                                                       .getPrimaryKey(),
                            getClientEnvironment().getUser().getPrimaryKey(),
                            "lc_type_低值易耗品类别");

                    if ((vv3 != null) && (vv3.size() > 0)) {
                        String tmp = "";

                        for (int i = 0; i < vv3.size(); i++) {
                            tmp = tmp + "'" + vv3.get(i).toString().trim() +
                                "'";

                            if (i < (vv3.size() - 1)) {
                                tmp = tmp + ",";
                            }
                        }

                        whereSql += (" pk_lctype in (" + tmp + ") and ");
                    }
                }
            } catch (Exception e1) {
            }
        }

        //购买时间和增加时间
        String buyDateStart = getUIRefPane().getRefPK();
        String buyDateEnd = getUIRefPane1().getRefPK();
        String addDateStart = getUIRefPane2().getRefPK();
        String addDateEnd = getUIRefPane3().getRefPK();

        if ((buyDateStart != null) && (buyDateStart.trim().length() != 0)) {
            whereSql += ("  buydate >= '" + buyDateStart + "' and ");
        }

        if ((buyDateEnd != null) && (buyDateEnd.trim().length() != 0)) {
            whereSql += ("  buydate <= '" + buyDateEnd + "' and ");
        }

        if ((addDateStart != null) && (addDateStart.trim().length() != 0)) {
            whereSql += ("  adddate >= '" + addDateStart + "' and ");
        }

        if ((addDateEnd != null) && (addDateEnd.trim().length() != 0)) {
            whereSql += ("  adddate <= '" + addDateEnd + "' and ");
        }

        //录入人
        if ((getInputPsnRefPane().getText() != null) &&
                (getInputPsnRefPane().getText().trim().length() > 0)) {
            if ((getInputPsnRefPane().getRefPK() != null) &&
                    (getInputPsnRefPane().getRefPK().length() > 0)) {
                whereSql += (" a.def3 like '" +
                getInputPsnRefPane().getRefPK() + "' and ");
            } else {
                try {
                    whereSql += (" a.def3 like '" +
                    (UserBO_Client.queryUsersByCondition(" user_code like '" +
                        getInputPsnRefPane().getText().trim() + "' "))[0].getPrimaryKey() +
                    "' and ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //金额
        if (((getUITextField().getText() != null) &&
                (getUITextField().getText().trim().length() > 0)) ||
                ((getUITextField1().getText() != null) &&
                (getUITextField1().getText().trim().length() > 0))) {
            if ((getUITextField1().getText() == null) ||
                    (getUITextField1().getText().trim().length() <= 0)) {
                whereSql += (" (a.\"number\"*a.price) >=" +
                getUITextField().getText().trim() + " and ");
            } else if ((getUITextField().getText() == null) ||
                    (getUITextField().getText().trim().length() <= 0)) {
                whereSql += (" (a.\"number\"*a.price) <=" +
                getUITextField1().getText().trim() + " and ");
            } else {
                whereSql += (" (a.\"number\"*a.price) between " +
                getUITextField().getText().trim() + " and " +
                getUITextField1().getText().trim() + " and ");
            }
        }

        //状态
        /*
         *            tallyflag      cancelflag
         * 未记账      'N' or null
         * 已记账          'Y'         'N' or null
         * 已核销           /             'Y'
         */
        whereSql += " ( ";

        if (getChkNotTally().isSelected()) {
            whereSql += " (tallyflag='N' or tallyflag is null) or ";
        }

        if (getChkTallied().isSelected()) {
            whereSql += " (tallyflag='Y' and (cancelflag='N' or cancelflag is null)) or ";
        }

        if (getChkCancelled().isSelected()) {
            whereSql += " (cancelflag='Y') or ";
        }

        whereSql += " 1<>1 ) and ";

        whereSql += " 1=1 ";
        log("从查询对话框得到的 Where SQL 语句:" + whereSql);

        return whereSql;
    }

    public void log(String str) {
        System.out.println("----sunrui log----:" + str);
    }

    /**
     * This method initializes UIRefPane
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getUIRefPane() {
        if (UIRefPane == null) {
            UIRefPane = new UIRefPane();
            UIRefPane.setBounds(91, 156, 135, 23);
            UIRefPane.setRefNodeName("日历");
        }

        return UIRefPane;
    }

    /**
     * This method initializes UIRefPane1
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getUIRefPane1() {
        if (UIRefPane1 == null) {
            UIRefPane1 = new UIRefPane();
            UIRefPane1.setBounds(304, 156, 135, 21);
            UIRefPane1.setRefNodeName("日历");
        }

        return UIRefPane1;
    }

    /**
     * This method initializes UIRefPane2
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getUIRefPane2() {
        if (UIRefPane2 == null) {
            UIRefPane2 = new UIRefPane();
            UIRefPane2.setBounds(93, 188, 134, 21);
            UIRefPane2.setRefNodeName("日历");
        }

        return UIRefPane2;
    }

    /**
     * This method initializes UIRefPane3
     *
     * @return nc.ui.pub.beans.UIRefPane
     */
    private UIRefPane getUIRefPane3() {
        if (UIRefPane3 == null) {
            UIRefPane3 = new UIRefPane();
            UIRefPane3.setBounds(305, 188, 133, 21);
            UIRefPane3.setRefNodeName("日历");
        }

        return UIRefPane3;
    }

    /**
     * This method initializes UITextField
     *
     * @return nc.ui.pub.beans.UITextField
     */
    private UITextField getUITextField() {
        if (UITextField == null) {
            UITextField = new UITextField();
            UITextField.setBounds(new java.awt.Rectangle(93, 252, 137, 21));
            UITextField.setAllowAlphabetic(false);
            UITextField.setAllowNumeric(true);
        }

        return UITextField;
    }

    /**
     * This method initializes UITextField1
     *
     * @return nc.ui.pub.beans.UITextField
     */
    private UITextField getUITextField1() {
        if (UITextField1 == null) {
            UITextField1 = new UITextField();
            UITextField1.setBounds(new java.awt.Rectangle(305, 252, 137, 21));
            UITextField1.setAllowAlphabetic(false);
            UITextField1.setAllowNumeric(true);
        }

        return UITextField1;
    }

    public void valueChanged(ValueChangedEvent event) {
        //if(getItemPane().getText()!=null&&getItemPane().getText().length()>0)
        //clearOther();
    }

    private void clearOther() {
        getRefCorp().setText(null);
        getRefLcType().setText(null);
        getChkCancelled().setSelected(false);
        getChkNotTally().setSelected(false);
        getChkTallied().setSelected(false);
        getUITextField().setText(null);
        getUITextField1().setText(null);
        getInputPsnRefPane().setText(null);
        getUIRefPane().setText(null);
        getUIRefPane1().setText(null);
        getUIRefPane2().setText(null);
        getUIRefPane3().setText(null);
    }
} //  @jve:decl-index=0:visual-constraint="10,10"
