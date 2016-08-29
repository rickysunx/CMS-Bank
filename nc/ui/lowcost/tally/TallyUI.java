/*
 * �������� 2005-10-9
 *
 * @author ����
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
 * @author ����
 *
 */
public class TallyUI extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4534764120137355522L;
	private UIScrollPane UIScrollPane = null;
	private UITextArea txtInf = null;
	
	private ButtonObject m_btnTally = new ButtonObject("����","����",2);
	public ButtonObject m_btnCheck = new ButtonObject ("����","����",2);
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
    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "����";
    }

    /* ���� Javadoc��
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
            MessageDialog.showErrorDlg(this,"����",e.getMessage());
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
			txtInf.setText("�ϴμ������ڣ�\n\n\n���˱��棺\n����������ֵ�׺�Ʒ���˹���  Ԫ��\n���κ�����ֵ�׺�Ʒ���˹���   Ԫ��\n���ε�����ֵ�׺�Ʒ���˹���  �ʡ�");
			txtInf.setEditable(false);
			txtInf.setBackground(new java.awt.Color(231,232,234));
			txtInf.setForeground(java.awt.Color.black);
		}
		return txtInf;
	}
	
	public void onTally() throws Exception {
	    if(MessageDialog.showYesNoDlg(this,"�Ƿ����","�Ƿ�Ҫ���м��ˣ�")==MessageDialog.ID_YES){
	        TallylogVO tlvo = new TallylogVO();
	        tlvo.setPk_corp(getClientEnvironment().getCorporation().getPrimaryKey());
	        tlvo.setPk_user(getClientEnvironment().getUser().getPrimaryKey());
	        tlvo.setTallydate(getClientEnvironment().getDate());
	        TallylogVO retvo = TallylogBO_Client.doTally(tlvo);
	        String report = "";
	        report += "�ϴμ���ʱ�䣺" + ((retvo.getTallydate()==null)?"�޼��˼�¼":(retvo.getTallydate().toString())) + "\n\n\n";
	        report += "���˱��棺\n";
	        report += "����������ֵ�׺�Ʒ���˹���" + ((retvo.getNewsum()==null)?"0.00":(NumFormate.getPrecisionData(retvo.getNewsum(),2))) + "Ԫ\n";
	        report += "���κ�����ֵ�׺�Ʒ���˹���" + ((retvo.getCancelsum()==null)?"0.00":(NumFormate.getPrecisionData(retvo.getCancelsum(),2))) + "Ԫ\n";
	        report += "���ε�����ֵ�׺�Ʒ���˹���" + ((retvo.getTranssum()==null)?"0":(NumFormate.getPrecisionData(retvo.getTranssum(),0))) + "��\n";
	        getTxtInf().setText(report);
	    }
	}
	
	public void onCheck() throws Exception {
	    MessageDialog.showHintDlg(this,"���˽��",TallylogBO_Client.doCheck());
	}
}
