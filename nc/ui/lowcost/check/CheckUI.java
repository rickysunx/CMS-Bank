/**
 * 创建日期 2006-2-19
 *
 * @author 孙锐
 */
package nc.ui.lowcost.check;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.UITablePane;

import nc.vo.lowcost.check.CheckVO;
import nc.vo.lowcost.tool.NumFormate;

import java.awt.BorderLayout;

public class CheckUI extends ToftPanel {
    /**
     *
     */
    private static final long serialVersionUID = -383301091693608110L;
    private UITablePane MainTable = null;
    public ButtonObject m_btnCheck = new ButtonObject("对账", "对账", 2);
    public ButtonObject[] m_btns = new ButtonObject[] { m_btnCheck };

    /**
     *
     */
    public CheckUI() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(375, 196);
        this.add(getMainTable(), java.awt.BorderLayout.CENTER);
        setButtons(m_btns);
    }

    /*(非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "对账";
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        try {
            if (bo == m_btnCheck) {
                onCheck();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this, "出错", e.getMessage());
        }
    }

    public void onCheck() throws Exception {
        CheckDlg dlg = new CheckDlg(this);

        if (dlg.showModal() == UIDialog.ID_OK) {
            CheckVO[] vos = CheckBO_Client.doCheck(dlg.getSelectedVOs());

            String[] header = new String[] {
                    "账号", "机构编码", "机构名称", "NC余额", "核心余额", "备注"
                };
            Object[][] obj = new Object[vos.length][];

            for (int i = 0; i < vos.length; i++) {
                obj[i] = new Object[6];
                obj[i][0] = vos[i].getAcctCode();
                obj[i][1] = vos[i].getUnitcode();
                obj[i][2] = vos[i].getUnitname();
                obj[i][3] = NumFormate.getPrecisionData(vos[i].getNcValue(), 2);
                obj[i][4] = NumFormate.getPrecisionData(vos[i].getBankValue(), 2);
                obj[i][5] = vos[i].getChkInf();
            }

            ReadOnlyTableModel tm = new ReadOnlyTableModel(obj, header);

            UITable table = new UITable(tm);
            getMainTable().setTable(table);
        }
    }

    /**
     * This method initializes UITablePane
     *
     * @return nc.ui.pub.beans.UITablePane
     */
    private UITablePane getMainTable() {
        if (MainTable == null) {
            MainTable = new UITablePane();
        }

        return MainTable;
    }
}
