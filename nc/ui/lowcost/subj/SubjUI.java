/*
 * 创建日期 2006-2-7
 *
 * @author 孙锐
 */
package nc.ui.lowcost.subj;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;

import java.awt.BorderLayout;

import nc.ui.pub.beans.MessageDialog;
import nc.vo.lowcost.subj.SubjVO;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillModel;
import nc.ui.pub.bill.BillScrollPane;
/**
 * @author 孙锐
 *
 */
public class SubjUI extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3190187598263216569L;

	private BillScrollPane billTable = null;
	
	public ButtonObject m_btnEdit = new ButtonObject("修改","修改",2);
	public ButtonObject m_btnSave = new ButtonObject("保存","保存",2);
	public ButtonObject m_btnCancel = new ButtonObject("取消","取消",2);
	public ButtonObject m_btnRefresh = new ButtonObject("刷新","刷新",2);
	
	public ButtonObject [] m_btns = new ButtonObject [] {
	        m_btnEdit,m_btnSave,m_btnCancel,m_btnRefresh
	};
	
    /**
     * 
     */
    public SubjUI() {
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
        this.setSize(357, 222);
        this.add(getBillTable(), java.awt.BorderLayout.CENTER);
        setButtons(m_btns);
        initTable();
        setBrowseState();
        try {
            onRefresh();
        } catch (Exception e){
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"初始化数据错误",e.getMessage());
        }
	}
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "科目对照表";
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
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
    
    public void initTable() {
        String [] names = {"主键","公司主键","公司编码","公司名称","大机记账科目"};
        String [] keys = {"pk_subj","pk_corp","unitcode","unitname","bank_kmbm"};
        
        boolean [] bShow = {false,false,true,true,true};
        
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
        
        items[2].setLoadFormula(new String [] {"unitcode->getColValue(bd_corp,unitcode,pk_corp,pk_corp)"});
        items[3].setLoadFormula(new String [] {"unitname->getColValue(bd_corp,unitname,pk_corp,pk_corp)"});
        
	    //加载
	    model.setBodyItems(items);
		getBillTable().setTableModel(model);
		getBillTable().setRowNOShow(true);
		getBillTable().getTable().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    public void refreshTable(SubjVO [] vos) throws Exception {
        getBillTable().getTableModel().setBodyDataVO(vos);
        getBillTable().getTableModel().execLoadFormula();
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
        SubjVO [] vos = SubjBO_Client.queryAllVO();
        refreshTable(vos);
        
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
 }
