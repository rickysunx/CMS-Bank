/*
 * 创建日期 2006-2-15
 *
 * @author 孙锐
 */
package nc.ui.lowcost.card;

import java.awt.Container;
import java.awt.Frame;

import nc.ui.pub.beans.UIDialog;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UILabel;
import nc.ui.pub.beans.UITextField;
import nc.ui.pub.beans.UIButton;
/**
 * @author 孙锐
 *
 */
public class CardCopyDlg extends UIDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5042653082612272378L;
	private UIPanel UIPanel = null;
	private UILabel UILabel = null;
	private UITextField txtNum = null;
	private UILabel UILabel1 = null;
	private UIButton btnOK = null;
	private UIButton btnCancel = null;
    /**
     * 
     */
    public CardCopyDlg() {
        super();
		initialize();
    }

    /**
     * @param parent
     */
    public CardCopyDlg(Container parent) {
        super(parent);
		initialize();
    }

    /**
     * @param parent
     * @param title
     */
    public CardCopyDlg(Container parent, String title) {
        super(parent, title);
		initialize();
    }

    /**
     * @param owner
     */
    public CardCopyDlg(Frame owner) {
        super(owner);
		initialize();
    }

    /**
     * @param owner
     * @param title
     */
    public CardCopyDlg(Frame owner, String title) {
        super(owner, title);
		initialize();
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setTitle("复制卡片");
        this.setContentPane(getUIPanel());
        this.setSize(331, 156);
			
	}
	/**
	 * This method initializes UIPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel() {
		if (UIPanel == null) {
			UILabel1 = new UILabel();
			UILabel = new UILabel();
			UIPanel = new UIPanel();
			UIPanel.setLayout(null);
			UILabel.setBounds(46, 30, 57, 22);
			UILabel.setText("复制数量");
			UILabel1.setBounds(203, 30, 25, 20);
			UILabel1.setText("张");
			UIPanel.add(UILabel, null);
			UIPanel.add(getTxtNum(), null);
			UIPanel.add(UILabel1, null);
			UIPanel.add(getBtnOK(), null);
			UIPanel.add(getBtnCancel(), null);
		}
		return UIPanel;
	}
	/**
	 * This method initializes UITextField	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtNum() {
		if (txtNum == null) {
			txtNum = new UITextField();
			txtNum.setBounds(119, 30, 68, 21);
			txtNum.setAllowAlphabetic(false);
			txtNum.setAllowOtherCharacter(false);
			txtNum.setMinValue(0.0D);
			txtNum.setMaxValue(100.0D);
			txtNum.setTextType("TextInt");
		}
		return txtNum;
	}
	/**
	 * This method initializes UIButton	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new UIButton();
			btnOK.setBounds(46, 79, 94, 22);
			btnOK.setText("确定");
			btnOK.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("actionPerformed()"); // 
				    
				    onOK();
				}
			});
		}
		return btnOK;
	}
	
	public void onOK() {
	    try {
		    String strCopyCount = txtNum.getText();
		    if(strCopyCount==null){
		        throw new Exception ("请输入您要复制的卡片数量");
		    }
		    try {
		        int nCount = Integer.parseInt(strCopyCount);
		    } catch (Exception e){
		        throw new Exception ("您输入的不为数字，请重新输入");
		    }
		    closeOK();
	    } catch (Exception e){
	        e.printStackTrace();
	        MessageDialog.showErrorDlg(this,"错误",e.getMessage());
	    }
	}
	/**
	 * This method initializes UIButton1	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new UIButton();
			btnCancel.setBounds(170, 79, 94, 22);
			btnCancel.setText("取消");
			btnCancel.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("actionPerformed()"); // 
				    closeCancel();
				}
			});
		}
		return btnCancel;
	}
	
	public int getCopyCount () {
	    String strCopyCount = txtNum.getText();
	    if(strCopyCount==null||strCopyCount.trim().length()==0){
	        return 0;
	    } else {
	        return Integer.parseInt(strCopyCount);
	    }
	}
}
