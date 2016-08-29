/*
 * �������� 2006-2-8
 *
 * @author ����
 */
package nc.ui.lowcost.tally;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.ToftPanel;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UILabel;
import nc.ui.pub.beans.UIListToList;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UIScrollPane;
import nc.ui.pub.beans.UITextArea;
import nc.ui.sm.user.UserBO_Client;
import nc.vo.bd.CorpVO;
import nc.vo.lowcost.tally.TallyCorpVO;
import nc.vo.lowcost.tally.TallylogVO;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;
/**
 * @author ����
 *
 */
public class TallyUI2 extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -717229358919356869L;
	private UIPanel UIPanel = null;
	private UIPanel UIPanel1 = null;
	private UIPanel UIPanel2 = null;
	private UILabel txtDate = null;
	private UIScrollPane UIScrollPane = null;
	private UITextArea txtInf = null;
	private UIListToList lstCorp = null;
	
	public ButtonObject m_btnTally = new ButtonObject("����","����",2);
	public ButtonObject m_btnUnTally = new ButtonObject("������","������",2);
	public ButtonObject m_btnCheck = new ButtonObject("����","����",2);
	
//	public ButtonObject [] m_btns = new ButtonObject [] {
//	        m_btnTally,m_btnUnTally,m_btnCheck
//	};
	public ButtonObject[] m_btns = new ButtonObject[] {m_btnTally, m_btnUnTally};
	
	public UFDate lastTallyDate = null;
    /**
     * 
     */
    public TallyUI2() {
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
        this.setSize(540, 270);
        this.add(getUIPanel(), java.awt.BorderLayout.NORTH);
        this.add(getUIPanel1(), java.awt.BorderLayout.CENTER);
        this.add(getUIPanel2(), java.awt.BorderLayout.SOUTH);
		setButtons(m_btns);
		try {
		    initCorp();
		    //��ʼ���ϴμ���ʱ��
		    initLastTallyDate();
		} catch (Exception e) {
		    e.printStackTrace();
		    MessageDialog.showErrorDlg(this,"����",e.getMessage());
		}
		
	}
	
	public void initLastTallyDate () throws Exception {
	    UFDate date = TallyBO_Client.queryLastTallyDate();
	    setLastTallyDate(date);
	    setButtonState();
	}
	
    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "����";
    }
    
    public void initCorp () throws Exception {
        String pk_user = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        CorpVO [] cvos = UserBO_Client.queryAllCorpsByUserPK(pk_user);
        Vector v = new Vector();
        for(int k=0; k<cvos.length; k++){
        	if(!cvos[k].getIsseal().booleanValue())
        		v.add(cvos[k]);
        }
        cvos = new CorpVO[v.size()];
        v.copyInto(cvos);
        TallyCorpVO [] vos = convertCorpVO2TallyCorpVO(cvos);
        if(vos!=null){
            lstCorp.setLeftData(vos);
        }
    }
    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        try {
	        if(bo==m_btnTally) {
	            onTally();
	        }
	        if(bo==m_btnUnTally){
	            onUnTally();
	        }
	        if(bo==m_btnCheck) {
	            onCheck();
	        }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"����",e.getMessage());
        }

    }
    
    public void onTally() throws Exception {
        Object [] objs = lstCorp.getRightData();
        TallyCorpVO [] vos = null;
        if(objs!=null) {
            vos = new TallyCorpVO [objs.length];
            for (int i = 0; i < objs.length; i++) {
                vos[i] = (TallyCorpVO) objs[i];
            }
        }
        if(vos==null) {
            throw new Exception ("��ѡ����Ҫ���м��˲����Ļ�����");
        }
        UFDate date = ClientEnvironment.getInstance().getDate();
        //String pk_corp = ClientEnvironment.getInstance().getCorporation().getPrimaryKey();
        String pk_user = ClientEnvironment.getInstance().getUser().getPrimaryKey();
        TallylogVO vo = new TallylogVO();
        vo.setNewsum(new UFDouble(0.0f));
        vo.setCancelsum(new UFDouble(0.0f));
        vo.setTranssum(new UFDouble(0.0f));
        
        String report = "";
        report += "���˱��棺\n";
        
        for (int i = 0; i < vos.length; i++) {
            try {
	            TallylogVO vo1 = TallyBO_Client.doTally(date,vos[i].getPk_corp(),pk_user,new TallyCorpVO [] {vos[i]});
	            vo.setNewsum(vo.getNewsum().add(vo1.getNewsum()));
	            vo.setCancelsum(vo.getCancelsum().add(vo1.getCancelsum()));
	            vo.setTranssum(vo.getTranssum().add(vo1.getTranssum()));
	            //report += vo1.m_def5;
            } catch (Exception e){
                e.printStackTrace();
                report += "����[" + vos[i].getUnitname() + "]" + "���˳���������Ϣ��" + e.getMessage() + "\n";
            }
        }
        

        report += "����������ֵ�׺�Ʒ���˹���" + NumFormate.getPrecisionData(vo.getNewsum(),2) + "Ԫ\n";
        report += "���κ�����ֵ�׺�Ʒ���˹���" + NumFormate.getPrecisionData(vo.getCancelsum(),2) + "Ԫ\n";
        report += "���ε�����ֵ�׺�Ʒ���˹���" + NumFormate.getPrecisionData(vo.getTranssum(),0) + "��";
        txtInf.setText(report);
        
        initLastTallyDate();
        
    }
    
    public void onCheck() throws Exception {
	    MessageDialog.showHintDlg(this,"���˽��",TallylogBO_Client.doCheck());
    }
    
    public void onUnTally() throws Exception {
        Object [] objs = lstCorp.getRightData();
        TallyCorpVO [] vos = null;
        
        TallylogVO vo = new TallylogVO();
        vo.setNewsum(new UFDouble(0.0f));
        vo.setCancelsum(new UFDouble(0.0f));
        vo.setTranssum(new UFDouble(0.0f));
        String report = "�����˱��棺\n";
       
        if(objs!=null) {
            vos = new TallyCorpVO [objs.length];
            for (int i = 0; i < objs.length; i++) {
                vos[i] = (TallyCorpVO) objs[i];
            }
        }
        if(vos==null) {
            throw new Exception ("��ѡ����Ҫ���з����˲����Ļ�����");
        }
        
        UFDate date = ClientEnvironment.getInstance().getDate();
        
        for (int i = 0; i < vos.length; i++) {
			try {
		        vo = TallyBO_Client.doUnTally(date, new TallyCorpVO[]{vos[i]});
		        //report += vo1.m_def5;
	        } catch (Exception e){
	            e.printStackTrace();
	            report += /*"����[" + vos[i].getUnitname() + "]" + */"�����˳���������Ϣ��" + e.getMessage() + "\n";
	        }
        }
        
        report += "����������ֵ�׺�Ʒ�����˹���" + NumFormate.getPrecisionData(vo.getNewsum(),2) + "Ԫ\n";
        report += "���κ�����ֵ�׺�Ʒ�����˹���" + NumFormate.getPrecisionData(vo.getCancelsum(),2) + "Ԫ\n";
        report += "���ε�����ֵ�׺�Ʒ�����˹���" + NumFormate.getPrecisionData(vo.getTranssum(),0) + "��";
        txtInf.setText(report);
        //txtInf.setText(date + "�������˳ɹ���");
        initLastTallyDate();
    }
	/**
	 * This method initializes UIPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel() {
		if (UIPanel == null) {
			txtDate = new UILabel();
			FlowLayout flowLayout1 = new FlowLayout();
			UIPanel = new UIPanel();
			UIPanel.setLayout(flowLayout1);
			UIPanel.setPreferredSize(new java.awt.Dimension(10,40));
			txtDate.setText("�ϴμ������ڣ�2006��01��01��");
			txtDate.setPreferredSize(new java.awt.Dimension(200,22));
			flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
			flowLayout1.setVgap(8);
			UIPanel.add(txtDate, null);
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
			UIPanel1.setLayout(new BorderLayout());
			UIPanel1.add(getLstCorp(), java.awt.BorderLayout.CENTER);
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
			UIPanel2.add(getUIScrollPane(), java.awt.BorderLayout.CENTER);
			UIPanel2.setPreferredSize(new java.awt.Dimension(10,100));
		}
		return UIPanel2;
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
			txtInf.setText("");
			txtInf.setEditable(false);
			txtInf.setBackground(new java.awt.Color(204,204,204));
			txtInf.setForeground(java.awt.Color.black);
		}
		return txtInf;
	}
	/**
	 * This method initializes UIListToList	
	 * 	
	 * @return nc.ui.pub.beans.UIListToList	
	 */    
	private UIListToList getLstCorp() {
		if (lstCorp == null) {
			lstCorp = new UIListToList();
			lstCorp.setLeftText("��ѡ����");
			lstCorp.setDisplayTitle(true);
			lstCorp.setRightText("��ѡ����");
		}
		return lstCorp;
	}
	
	public void setLastTallyDate (UFDate date) {
	    if(date!=null) {
	        String strDate = date.getYear() + "��" + date.getStrMonth() + "��" + date.getStrDay() + "��";
	        txtDate.setText("�ϴμ������ڣ�" + strDate);
	        lastTallyDate = date;
	    } else {
	        txtDate.setText("�ϴμ������ڣ�");
	        lastTallyDate = null;
	    }
	}
	
	public void setButtonState () {
	    UFDate todayDate = ClientEnvironment.getInstance().getDate();
	    if(lastTallyDate!=null && lastTallyDate.equals(todayDate)){
	        m_btnUnTally.setEnabled(true);
	    } else {
	        m_btnUnTally.setEnabled(false);
	    }
	    updateButtons();
	}
	
	public TallyCorpVO [] convertCorpVO2TallyCorpVO (CorpVO [] cvos){
	    TallyCorpVO [] vos = null;
	    if(cvos!=null) {
	        vos = new TallyCorpVO[cvos.length];
	        for (int i = 0; i < vos.length; i++) {
	            vos[i] = new TallyCorpVO();
                vos[i].setPk_corp(cvos[i].getPk_corp());
                vos[i].setUnitcode(cvos[i].getUnitcode());
                vos[i].setUnitname(cvos[i].getUnitname());
            }
	    }
	    return vos;
	}
	
}
