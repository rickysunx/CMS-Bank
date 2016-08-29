/*
 * 创建日期 2006-2-20
 *
 * @author 孙锐
 */
package nc.ui.lowcost.check;

import java.awt.Container;
import java.awt.Frame;

import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.UIDialog;

import nc.ui.pub.beans.UIPanel;
import java.awt.BorderLayout;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIListToList;
import nc.ui.pub.beans.UIButton;
import nc.vo.lowcost.check.CheckVO;
/**
 * @author 孙锐
 *
 */
public class CheckDlg extends UIDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2354751148595341767L;
	private UIPanel UIPanel = null;
	private UIPanel UIPanel1 = null;
	private UIPanel UIPanel2 = null;
	private UIListToList lstCorp = null;
	private UIButton UIButton = null;
	private UIButton UIButton1 = null;
    /**
     * 
     */
    public CheckDlg() {
        super();
		initialize();
    }

    /**
     * @param parent
     */
    public CheckDlg(Container parent) {
        super(parent);
		initialize();
    }

    /**
     * @param parent
     * @param title
     */
    public CheckDlg(Container parent, String title) {
        super(parent, title);
		initialize();
    }

    /**
     * @param owner
     */
    public CheckDlg(Frame owner) {
        super(owner);
		initialize();
    }

    /**
     * @param owner
     * @param title
     */
    public CheckDlg(Frame owner, String title) {
        super(owner, title);
		initialize();
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setTitle("请选择公司");
        this.setContentPane(getUIPanel());
        this.setSize(491, 299);
		initCorp();
	}
	/**
	 * This method initializes UIPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel() {
		if (UIPanel == null) {
			UIPanel = new UIPanel();
			UIPanel.setLayout(new BorderLayout());
			UIPanel.add(getUIPanel1(), java.awt.BorderLayout.SOUTH);
			UIPanel.add(getUIPanel2(), java.awt.BorderLayout.CENTER);
		}
		return UIPanel;
	}
	/**
	 * This method initializes UIPanel1	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel1() {
		if (UIPanel1 == null) {
			UIPanel1 = new UIPanel();
			UIPanel1.setLayout(null);
			UIPanel1.setPreferredSize(new java.awt.Dimension(10,50));
			UIPanel1.add(getUIButton(), null);
			UIPanel1.add(getUIButton1(), null);
		}
		return UIPanel1;
	}
	/**
	 * This method initializes UIPanel2	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel2() {
		if (UIPanel2 == null) {
			UIPanel2 = new UIPanel();
			UIPanel2.setLayout(new BorderLayout());
			UIPanel2.add(getLstCorp(), java.awt.BorderLayout.CENTER);
		}
		return UIPanel2;
	}
	/**
	 * This method initializes UIListToList	
	 * 	
	 * @return nc.ui.pub.beans.UIListToList	
	 */    
	private UIListToList getLstCorp() {
		if (lstCorp == null) {
			lstCorp = new UIListToList();
			lstCorp.setDisplayTitle(true);
			lstCorp.setLeftText("待选机构");
			lstCorp.setRightText("已选机构");
		}
		return lstCorp;
	}
	/**
	 * This method initializes UIButton	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getUIButton() {
		if (UIButton == null) {
			UIButton = new UIButton();
			UIButton.setBounds(117, 13, 95, 22);
			UIButton.setText("确定");
			UIButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("actionPerformed()"); // 
				    onOK();
				}
			});
		}
		return UIButton;
	}
	
	public void onOK() {
	    try {
	        Object [] obj = getLstCorp().getRightData();
	        if(obj==null){
	            throw new Exception ("请选择要进行对账的机构");
	        }
	        closeOK();
	    } catch (Exception e) {
	        e.printStackTrace();
	        MessageDialog.showErrorDlg(this,"出错",e.getMessage());
	    }
	}
	
	/**
	 * This method initializes UIButton1	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getUIButton1() {
		if (UIButton1 == null) {
			UIButton1 = new UIButton();
			UIButton1.setBounds(267, 13, 109, 22);
			UIButton1.setText("取消");
			UIButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("actionPerformed()"); // 
				    closeCancel();
				}
			});
		}
		return UIButton1;
	}
	
	public void initCorp () {
	    try {
	        String pk_user = ClientEnvironment.getInstance().getUser().getPrimaryKey();
	        CheckVO [] vos = CheckBO_Client.queryCheck(pk_user);
	        getLstCorp().setLeftData(vos);
	    } catch (Exception e){
	        e.printStackTrace();
	        MessageDialog.showErrorDlg(this,"出错",e.getMessage());
	    }
	}
	
	public CheckVO [] getSelectedVOs() {
	    CheckVO [] vos = null;
	    try {
	        Object [] obj = getLstCorp().getRightData();
		    if(obj!=null){
		        vos = new CheckVO[obj.length];
		        for (int i = 0; i < obj.length; i++) {
                    vos [i] = (CheckVO) obj[i];
                }
		    }
	    } catch (Exception e){
	        e.printStackTrace();
	        
	    }
	    return vos;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
