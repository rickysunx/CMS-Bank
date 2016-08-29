/*
 * 创建日期 2006-6-10
 *
 * @author 孙锐
 */
package nc.ui.lowcost.check;

import java.awt.BorderLayout;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.UITablePane;
import nc.vo.lowcost.check.CheckVO;
import nc.vo.lowcost.tool.NumFormate;

import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UILabel;
import java.awt.FlowLayout;
import nc.ui.pub.beans.UIRefPane;
/**
 * @author 孙锐
 *
 */
public class CheckUITypeCorpUI extends ToftPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4676122386748232498L;

	private UITablePane MainTable = null;
	
	public ButtonObject m_btnCheck = new ButtonObject("对账","对账",2);
	public ButtonObject [] m_btns = new ButtonObject [] {
	        m_btnCheck
	};
	private UIPanel UIPanel = null;
	private UILabel UILabel = null;
	private UIRefPane refCorp = null;
    /**
     * 
     */
    public CheckUITypeCorpUI() {
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
        this.setSize(371, 173);
        this.add(getUIPanel(), java.awt.BorderLayout.NORTH);
        this.add(getMainTable(), java.awt.BorderLayout.CENTER);
		setButtons(m_btns);	
	}
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "对账";
    }

    public void onButtonClicked(ButtonObject bo) {
        try {
	        if(bo==m_btnCheck){
	            onCheck();
	        }
        } catch (Exception e){
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"出错",e.getMessage());
        }
    }

    
    public void onCheck() throws Exception {
        String pk_corp = getRefCorp().getRefPK();
        if(pk_corp==null){
            throw new Exception ("请选择机构");
        }
        CheckVO [] vos = CheckBO_Client.doTypeCorpCheck(pk_corp);
        if(vos==null || vos.length==0){
            vos = new CheckVO[0];
        }
        String [] header = new String [] {
                "账号","NC余额","核心余额","备注"
        };
        Object [][] obj = new Object [vos.length][];
        for (int i = 0; i < vos.length; i++) {
            obj[i] = new Object [6];
            obj[i][0] = vos[i].getAcctCode();
            obj[i][1] = NumFormate.getPrecisionData(vos[i].getNcValue(),2);
            obj[i][2] = NumFormate.getPrecisionData(vos[i].getBankValue(),2);
            obj[i][3] = vos[i].getChkInf();
        }
        ReadOnlyTableModel tm = new ReadOnlyTableModel(obj,header);
        
        UITable table = new UITable(tm);
        getMainTable().setTable(table);
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
	/**
	 * This method initializes UIPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel() {
		if (UIPanel == null) {
			UILabel = new UILabel();
			FlowLayout flowLayout1 = new FlowLayout();
			UIPanel = new UIPanel();
			UIPanel.setLayout(flowLayout1);
			UIPanel.setPreferredSize(new java.awt.Dimension(10,35));
			UILabel.setText("选择机构");
			flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
			UIPanel.add(UILabel, null);
			UIPanel.add(getRefCorp(), null);
		}
		return UIPanel;
	}
	/**
	 * This method initializes UIRefPane	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	private UIRefPane getRefCorp() {
		if (refCorp == null) {
			refCorp = new UIRefPane();
			refCorp.setPreferredSize(new java.awt.Dimension(200,22));
			refCorp.setName("refCorp");
			refCorp.setRefNodeName("权限公司目录");
		}
		return refCorp;
	}
}
