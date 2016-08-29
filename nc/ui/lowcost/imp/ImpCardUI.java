/*
 * �������� 2005-12-9
 *
 * @author ����
 */
package nc.ui.lowcost.imp;

import nc.ui.lowcost.card.CardBO_Client;
import nc.ui.pub.ButtonObject;
import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.ToftPanel;

import nc.ui.pub.beans.UITablePane;
import java.awt.BorderLayout;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIFileChooser;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.UITextField;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;

import nc.ui.pub.beans.UIButton;
import nc.ui.pub.beans.UILabel;
import nc.vo.lowcost.card.CardVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;
/**
 * @author ����
 *
 */
public class ImpCardUI extends ToftPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8579768093885040789L;
	public ButtonObject m_btnLoad = new ButtonObject("��ȡ");
    public ButtonObject m_btnImport = new ButtonObject("����");
    
    public ButtonObject [] m_btns = new ButtonObject [] {
            m_btnLoad,m_btnImport
    };
    
    public String [][] data = null;
	private UIPanel UIPanel = null;
	private UIPanel UIPanel1 = null;
	private UITextField txtFileName = null;
	private UIButton UIButton = null;
	private UITablePane MainTable = null;
	private UILabel UILabel1 = null;
	
	public String [] colNames = {
	        "��Ʒ����","��Ʒ���","��������","������","ʹ�ò���","����ʱ��","����","����","ʹ����","��ע"
	};
    /**
     * 
     */
    public ImpCardUI() {
        super();
		initialize();
        // TODO �Զ����ɹ��캯�����
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(538, 257);
        this.add(getUIPanel(), java.awt.BorderLayout.NORTH);
        this.add(getUIPanel1(), java.awt.BorderLayout.CENTER);
		setButtons(m_btns);	
		
		UITable table = new UITable(new Object[0][colNames.length],colNames);
		MainTable.setTable(table);
	}
    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        // TODO �Զ����ɷ������
        return "��ֵ�׺�Ʒ����";
    }

    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        // TODO �Զ����ɷ������
        try {
            if(bo==m_btnImport){
                onImport();
                MessageDialog.showHintDlg(this,"�ɹ�","����ɹ�");
            }
            if(bo==m_btnLoad){
                onLoad();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"����",e.getMessage());
        }
    }

	/**
	 * This method initializes UIPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel() {
		if (UIPanel == null) {
			UILabel1 = new UILabel();
			FlowLayout flowLayout1 = new FlowLayout();
			UIPanel = new UIPanel();
			UIPanel.setLayout(flowLayout1);
			UIPanel.setPreferredSize(new java.awt.Dimension(10,40));
			flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
			UILabel1.setText("�ļ���");
			UIPanel.add(UILabel1, null);
			UIPanel.add(getTxtFileName(), null);
			UIPanel.add(getUIButton(), null);
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
			UIPanel1.add(getMainTable(), java.awt.BorderLayout.CENTER);
		}
		return UIPanel1;
	}
	/**
	 * This method initializes UITextField	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtFileName() {
		if (txtFileName == null) {
			txtFileName = new UITextField();
			txtFileName.setPreferredSize(new java.awt.Dimension(250,22));
			txtFileName.setMaxLength(10000);
		}
		return txtFileName;
	}
	/**
	 * This method initializes UIButton	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getUIButton() {
		if (UIButton == null) {
			UIButton = new UIButton();
			UIButton.setPreferredSize(new java.awt.Dimension(80,22));
			UIButton.setText("���");
			UIButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					onBrowse();
				}
			});
		}
		return UIButton;
	}
	
	public void onBrowse() {
	    UIFileChooser fc = new UIFileChooser();
	    fc.setMultiSelectionEnabled(false);
		if(fc.showOpenDialog(this) == UIFileChooser.APPROVE_OPTION) {
			txtFileName.setText(fc.getSelectedFile().getPath());
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
	
	public void onImport() throws Exception {
	    if(data==null){
	        throw new Exception ("û������");
	    }
	    CardVO [] cvos = new CardVO [data.length];
	    for (int i = 0; i < cvos.length; i++) {
		    CardVO vo = new CardVO();
		    //vo.setLccode(getTxtCode().getText());
		    vo.setLcname(data[i][0]);
		    vo.setPk_lctype(data[i][1]);
		    vo.setPk_managedept(data[i][3]);
		    vo.setPk_usedept(data[i][4]);
		    vo.setBuydate(new UFDate(data[i][5]));
		    vo.setPrice(new UFDouble(data[i][6].trim()));
		    vo.setNumber(new UFDouble(data[i][7].trim()));
		    vo.setAdddate(ClientEnvironment.getInstance().getDate());
		    vo.setTallyflag(new UFBoolean(false));
		    vo.setCancelflag(new UFBoolean(false));
		    vo.setRemark(data[i][9]);
		    vo.setDef1(data[i][8]);
		    vo.setDef5(data[i][2]);
		    //У������
		    if(vo.getLcname()==null || vo.getLcname().trim().length()==0){
		        throw new Exception("��Ʒ���Ʋ���Ϊ��");
		    }
		    if(vo.getPk_lctype()==null){
		        throw new Exception("��Ʒ�����Ϊ��");
		    }
//		    if(vo.getPk_managedept()==null){
//		        throw new Exception("�����Ų���Ϊ��");
//		    }
		    if(vo.getPk_usedept()==null){
		        throw new Exception("ʹ�ò��Ų���Ϊ��");
		    }
//		    if(vo.getBuydate()==null || vo.getBuydate().toString().trim().length()==0){
//		        throw new Exception("�������ڲ���Ϊ��");
//		    }
		    if(data[i][6].trim().length()==0){
		        throw new Exception("���۲���Ϊ��");
		    }
		    if(data[i][7].trim().length()==0){
		        throw new Exception("��������Ϊ��");
		    }
		    cvos[i]=vo;
        }
	    CardBO_Client.insertArray(cvos);
	    
	    
	    
	}
	public void onLoad() throws Exception {
	    String strFileName = txtFileName.getText();
	    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(strFileName)));
	    
	    String strLine = null;
	    String [][] strData = null;
	    Vector vLines = new Vector();
	    while((strLine=br.readLine())!=null){
	        
	        if(strLine.trim().length()==0){
	            continue;
	        }
	        
	        String [] cols = split(strLine,"\t");
	        vLines.add(cols);
	    }
	    
	    if(vLines.size()>0){
	        strData = new String [vLines.size()][];
	        vLines.copyInto(strData);
	    } else {
	        throw new Exception("�ļ�Ϊ��");
	    }
	    
	    String [] fileHeads = strData[0];
	    HashMap hmHeads = new HashMap();
	    for (int i = 0; i < fileHeads.length; i++) {
            hmHeads.put(fileHeads[i],new Integer(i));
        }
	    
	    String [][] tabledata = new String [strData.length-1][colNames.length];
	    
	    for (int i = 0; i < tabledata.length; i++) {
            for (int j = 0; j < tabledata[i].length; j++) {
                if(!hmHeads.containsKey(colNames[j])){
                    throw new Exception ("û���ҵ������ֶΣ�"+colNames[j]);
                }
                int fileColIndex = ((Integer)hmHeads.get(colNames[j])).intValue();
                tabledata[i][j] = strData[i+1][fileColIndex];
            }
        }
	    
	    ReadOnlyTableModel model = new ReadOnlyTableModel(tabledata,colNames);
	    UITable table = new UITable(model);
	    MainTable.setTable(table);
	    data = tabledata;
	    
	}
	
    public String [] split(String str,String sp){
        Vector v = new Vector();
        String [] strs = null;
        if(str==null) return null;
        if(sp==null) return new String [] {str};
        StringBuffer sb = new StringBuffer();
        String chr = null;
        for (int i = 0; i < str.length(); i++) {
            chr = str.substring(i,i+1);
            if(chr.equals(sp)){
                v.add(sb.toString());
                sb = new StringBuffer();
            } else {
                sb.append(chr);
                if(i==(str.length()-1)){
                    v.add(sb.toString());
                }
            }
        }
        if(v.size()>0){
            strs = new String [v.size()];
            v.copyInto(strs);
        }
        return strs;
    }
 }
