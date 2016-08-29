/*
 * 创建日期 2005-10-9
 *
 * @author 孙锐
 */
package nc.ui.lowcost.tally;

import java.awt.BorderLayout;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIScrollPane;
import nc.ui.pub.beans.UITextArea;
import nc.vo.lowcost.tally.TallylogVO;
import nc.vo.lowcost.tool.NumFormate;
/**
 * @author 孙锐
 *
 */
public class TallyUI extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4534764120137355522L;
	private UIScrollPane UIScrollPane = null;
	private UITextArea txtInf = null;
	
	private ButtonObject m_btnTally = new ButtonObject("记账","记账",2);
	public ButtonObject m_btnCheck = new ButtonObject ("对账","对账",2);
	private ButtonObject [] m_btns = new ButtonObject [] {
	        m_btnTally,m_btnCheck
	};
    /**
     * 
     */
    public TallyUI() {
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
        this.setSize(439, 260);
        this.add(getUIScrollPane(), java.awt.BorderLayout.CENTER);
		
        setButtons(m_btns);
	}
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "记账";
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        try {
            if(bo==m_btnTally){
                onTally();
            }
            if(bo==m_btnCheck){
                onCheck();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"出错",e.getMessage());
        }
    }

	/**
	 * This method initializes UIScrollPane	
	 * 	
	 * @return nc.ui.pub.beans.UIScrollPane	
	 */    
	private UIScrollPane getUIScrollPane() {
		if (UIScrollPane == null) {
			UIScrollPane = new UIScrollPane();
			UIScrollPane.setViewportView(getTxtInf());
		}
		return UIScrollPane;
	}
	/**
	 * This method initializes UITextArea	
	 * 	
	 * @return nc.ui.pub.beans.UITextArea	
	 */    
	private UITextArea getTxtInf() {
		if (txtInf == null) {
			txtInf = new UITextArea();
			txtInf.setEnabled(true);
			txtInf.setText("上次记账日期：\n\n\n记账报告：\n本次新增低值易耗品记账共计  元；\n本次核销低值易耗品记账共计   元；\n本次调拨低值易耗品记账共计  笔。");
			txtInf.setEditable(false);
			txtInf.setBackground(new java.awt.Color(231,232,234));
			txtInf.setForeground(java.awt.Color.black);
		}
		return txtInf;
	}
	
	public void onTally() throws Exception {
	    if(MessageDialog.showYesNoDlg(this,"是否记账","是否要进行记账？")==MessageDialog.ID_YES){
	        TallylogVO tlvo = new TallylogVO();
	        tlvo.setPk_corp(getClientEnvironment().getCorporation().getPrimaryKey());
	        tlvo.setPk_user(getClientEnvironment().getUser().getPrimaryKey());
	        tlvo.setTallydate(getClientEnvironment().getDate());
	        TallylogVO retvo = TallylogBO_Client.doTally(tlvo);
	        String report = "";
	        report += "上次记账时间：" + ((retvo.getTallydate()==null)?"无记账记录":(retvo.getTallydate().toString())) + "\n\n\n";
	        report += "记账报告：\n";
	        report += "本次新增低值易耗品记账共计" + ((retvo.getNewsum()==null)?"0.00":(NumFormate.getPrecisionData(retvo.getNewsum(),2))) + "元\n";
	        report += "本次核销低值易耗品记账共计" + ((retvo.getCancelsum()==null)?"0.00":(NumFormate.getPrecisionData(retvo.getCancelsum(),2))) + "元\n";
	        report += "本次调拨低值易耗品记账共计" + ((retvo.getTranssum()==null)?"0":(NumFormate.getPrecisionData(retvo.getTranssum(),0))) + "笔\n";
	        getTxtInf().setText(report);
	    }
	}
	
	public void onCheck() throws Exception {
	    MessageDialog.showHintDlg(this,"对账结果",TallylogBO_Client.doCheck());
	}
}
