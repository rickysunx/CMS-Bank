/*
 * 创建日期 2006-5-25
 *
 * @author 孙锐
 */
package nc.ui.lowcost.subj;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;

import java.awt.BorderLayout;
import nc.ui.pub.beans.UIPanel;
import java.awt.FlowLayout;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UILabel;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillModel;
import nc.ui.pub.bill.BillScrollPane;
import nc.vo.lowcost.subj.SubjVO;
/**
 * @author 孙锐
 *
 */
public class LctypeSubjUI extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8318342873286174843L;
	private UIPanel UIPanel1 = null;
	private UIPanel UIPanel2 = null;
	private UILabel UILabel = null;
	private UIRefPane refCorp = null;
	private BillScrollPane billTable = null;
	
	public ButtonObject m_btnEdit = new ButtonObject("修改","修改",2);
	public ButtonObject m_btnSave = new ButtonObject("保存","保存",2);
	public ButtonObject m_btnCancel = new ButtonObject("取消","取消",2);
	public ButtonObject m_btnRefresh = new ButtonObject("刷新","刷新",2);
	
	public ButtonObject [] m_btns = new ButtonObject [] {
	        m_btnEdit,m_btnSave,m_btnCancel,m_btnRefresh
	};
	
	public String m_currCorp = null;
    /**
     * 
     */
    public LctypeSubjUI() {
        super();
		initialize();
        // TODO 自动生成构造函数存根
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(478, 225);
        this.add(getUIPanel1(), java.awt.BorderLayout.NORTH);
        this.add(getUIPanel2(), java.awt.BorderLayout.CENTER);
		setButtons(m_btns);
		initTable();
		setBrowseState();
	}
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        // TODO 自动生成方法存根
        return "类别科目对照表";
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        // TODO 自动生成方法存根
        try {
            if(bo==m_btnEdit){
                onEdit();
            }
            if(bo==m_btnSave){
                onSave();
            }
            if(bo==m_btnCancel){
                onMyCancel();
            }
            if(bo==m_btnRefresh){
                onRefresh();
            }
        } catch (Exception e){
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"出错",e.getMessage());
        }
    }

    public void onSave() throws Exception {
		if (getBillTable().getTable().isEditing()) {
		    getBillTable().getTable().editingStopped(new javax.swing.event.ChangeEvent(this));
		}
		
		SubjVO [] svos = (SubjVO[]) getBillTable().getTableModel().getBodyValueVOs("nc.vo.lowcost.subj.SubjVO");
		
		SubjBO_Client.saveAll(svos);
		onRefresh();
		setBrowseState();
    }
    
    public void onEdit() throws Exception {
        setEditState();
    }
    
    public void onMyCancel() throws Exception {
        onRefresh();
        setBrowseState();
        
    }
    
    public void onRefresh() throws Exception {
        String pk_corp = getRefCorp().getRefPK();
        m_currCorp = pk_corp;
        SubjVO [] vos = SubjBO_Client.queryAllByCorp(pk_corp);
        refreshTable(vos);
    }
    
    public void refreshTable(SubjVO [] vos) throws Exception {
        getBillTable().getTableModel().setBodyDataVO(vos);
        getBillTable().getTableModel().execLoadFormula();
    }
	/**
	 * This method initializes UIPanel1	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel1() {
		if (UIPanel1 == null) {
			UILabel = new UILabel();
			FlowLayout flowLayout1 = new FlowLayout();
			UIPanel1 = new UIPanel();
			UIPanel1.setLayout(flowLayout1);
			UIPanel1.setPreferredSize(new java.awt.Dimension(10,35));
			flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
			UILabel.setText("选择机构");
			UIPanel1.add(UILabel, null);
			UIPanel1.add(getRefCorp(), null);
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
			UIPanel2.add(getBillTable(), java.awt.BorderLayout.CENTER);
		}
		return UIPanel2;
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
			refCorp.setRefNodeName("权限公司目录");
			refCorp.addValueChangedListener(new nc.ui.pub.beans.ValueChangedListener() { 
				public void valueChanged(nc.ui.pub.beans.ValueChangedEvent e) {    
					System.out.println("Ref  valueChanged()"); // TODO Auto-generated Event stub valueChanged()
				    try {
				        onRefresh();
				    } catch (Exception ex){
				        ex.printStackTrace();
				        MessageDialog.showErrorDlg(LctypeSubjUI.this,"出错",ex.getMessage());
				    }
				}
			});
		}
		return refCorp;
	}
	/**
	 * This method initializes billScrollPane	
	 * 	
	 * @return nc.ui.pub.bill.BillScrollPane	
	 */    
	private BillScrollPane getBillTable() {
		if (billTable == null) {
			billTable = new BillScrollPane();
		}
		return billTable;
	}
    public void initTable() {
        String [] names = {"主键","公司主键","类别主键","类别编码","类别名称","大机记账科目"};
        String [] keys = {"pk_subj","pk_corp","pk_lctype","lctypecode","lctypename","bank_kmbm"};
        
        boolean [] bShow = {false,false,false,true,true,true};
        
        BillModel model = new BillModel();
        
        BillItem [] items = new BillItem[names.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new BillItem();
	        items[i].setName(names[i]);
	        items[i].setKey(keys[i]);
	        items[i].setWidth(200);
	        items[i].setEdit(false);
	        items[i].setShow(bShow[i]); 
	        items[i].setDataType(BillItem.STRING);
	        items[i].setPos(BillItem.BODY);
	        items[i].setLength(5000);
        }
        
        items[2].setLoadFormula(new String [] {"lctypecode->getColValue(lc_type,lctypecode,pk_lctype,pk_lctype)"});
        items[3].setLoadFormula(new String [] {"lctypename->getColValue(lc_type,lctypename,pk_lctype,pk_lctype)"});
        
	    //加载
	    model.setBodyItems(items);
		getBillTable().setTableModel(model);
		getBillTable().setRowNOShow(true);
		getBillTable().getTable().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    public void setBrowseState() {
        m_btnEdit.setEnabled(true);
        m_btnSave.setEnabled(false);
        m_btnCancel.setEnabled(false);
        m_btnRefresh.setEnabled(true);
        
        updateButtons();
        
        BillItem[] items = getBillTable().getTableModel().getBodyItems();
        for (int i = 0; i < items.length; i++) {
            items[i].setEdit(false);
        }
        
    }
    
    public void setEditState() {
        m_btnEdit.setEnabled(false);
        m_btnSave.setEnabled(true);
        m_btnCancel.setEnabled(true);
        m_btnRefresh.setEnabled(false);
        
        updateButtons();
        
        BillItem[] items = getBillTable().getTableModel().getBodyItems();
        
        for (int i = 0; i < items.length; i++) {
            if(items[i].getKey().equals("bank_kmbm")){
                items[i].setEdit(true);
            } else {
                items[i].setEdit(false);
            }
        }
        
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
