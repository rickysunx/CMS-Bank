/*
 * 物品类别定义界面
 * 创建日期 2005-9-14
 *
 * @author 孙锐
 */
package nc.ui.lowcost.type;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;

import nc.ui.pub.beans.UISplitPane;
import java.awt.BorderLayout;
import java.util.*;

import javax.swing.tree.*;

import nc.ui.pub.beans.*;
import nc.vo.lowcost.type.TypeVO;
import nc.ui.pub.beans.UIScrollPane;
import nc.ui.pub.beans.UITree;
/**
 * @author 孙锐
 *
 */
public class TypeUI extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4907240584934368004L;
	private UISplitPane UISplitPane = null;
	private UITree UITree = null;
	private UIPanel UIPanel = null;
	private UILabel lblCode = null;
	private UITextField txtCode = null;
	private UILabel lblName = null;
	private UITextField txtName = null;
	
	private ButtonObject m_boAdd = new ButtonObject("增加","增加",2);
	private ButtonObject m_boEdit = new ButtonObject("修改","修改",2);
	private ButtonObject m_boDel = new ButtonObject("删除","删除",2);
	private ButtonObject m_boSave = new ButtonObject("保存","保存",2);
	private ButtonObject m_boCancel = new ButtonObject("取消","取消",2);
	
	private ButtonObject [] m_btns = new ButtonObject [] {
	        m_boAdd,m_boEdit,m_boDel,m_boSave,m_boCancel
	};
	
	private String m_RootNodeName = "低值易耗品类别";
	private final int ADD_STATE = 1;
	private final int EDIT_STATE = 2;
	private final int BROWSE_STATE = 0;
	
	private int m_CurrentState = 0;
	
	private String m_parentLcTypePk = null;
	private TypeVO m_selectedVO = null;
	
	private UIScrollPane UIScrollPane3 = null;
    public TypeUI() {
        super();
		initialize();
    }
    private UIPanel m_LeftPanel=null;

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(566, 369);
        this.add(getUISplitPane(), java.awt.BorderLayout.CENTER);
		
        setButtons(m_btns);
        showPanelObject(false);
        setBrowseState();
        refreshTreeData();
	}
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "低值易耗品类别定义";
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        try {
	        if(bo==m_boAdd){
	            onAdd();
	        }
	        if(bo==m_boEdit){
	            onEdit();
	        }
	        if(bo==m_boDel){
	            onDel();
	        }
	        if(bo==m_boSave){
	            onSave();
	        }
	        if(bo==m_boCancel){
	            onMyCancel();
	        }
        } catch (Exception e) {
            MessageDialog.showErrorDlg(this,"错误",e.getMessage());
        }
    }

	/**
	 * This method initializes UISplitPane	
	 * 	
	 * @return nc.ui.pub.beans.UISplitPane	
	 */    
	private UISplitPane getUISplitPane() {
		if (UISplitPane == null) {
			UISplitPane = new UISplitPane();
			UISplitPane.setDividerLocation(150);
			UISplitPane.setDividerSize(3);
			UISplitPane.setLeftComponent(getUILeftPanel());
			UISplitPane.setRightComponent(getUIPanel());
		}
		return UISplitPane;
	}
	/**
	 * This method initializes UITree	
	 * 	
	 * @return nc.ui.pub.beans.UITree	
	 */    
	private UITree getUITree() {
		if (UITree == null) {
			UITree = new UITree();
			UITree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() { 
				public void valueChanged(javax.swing.event.TreeSelectionEvent e) {    
					onTreeSelect();
				}
			});
		}
		return UITree;
	}
	/**
	 * This method initializes UIPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getUIPanel() {
		if (UIPanel == null) {
			lblCode = new UILabel();
			lblName = new UILabel();
			UIPanel = new UIPanel();
			UIPanel.setLayout(null);
			lblCode.setText("物品类别编码");
			lblCode.setPreferredSize(new java.awt.Dimension(52,25));
			lblCode.setLocation(15, 14);
			lblCode.setSize(80, 27);
			lblName.setBounds(15, 46, 80, 22);
			lblName.setText("物品类别名称");
			UIPanel.add(lblCode, null);
			UIPanel.add(lblName, null);
			UIPanel.add(getTxtName(), null);
			UIPanel.add(getTxtCode(), null);
		}
		return UIPanel;
	}
	
	private UIPanel getUILeftPanel() {
		if (m_LeftPanel == null) {
			m_LeftPanel = new UIPanel();
			m_LeftPanel.setLayout(new BorderLayout());
			m_LeftPanel.add(getUIScrollPane3(), java.awt.BorderLayout.CENTER);
		}
		return m_LeftPanel;
	}
	/**
	 * This method initializes UITextField	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtCode() {
		if (txtCode == null) {
			txtCode = new UITextField();
			txtCode.setBounds(104, 14, 193, 22);
		}
		return txtCode;
	}
	/**
	 * This method initializes UITextField1	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtName() {
		if (txtName == null) {
			txtName = new UITextField();
			txtName.setBounds(104, 46, 193, 22);
		}
		return txtName;
	}
	
	//是否显示右面板中的对象
	private void showPanelObject(boolean bShow){
	    getTxtCode().setVisible(bShow);
	    getTxtName().setVisible(bShow);
	    lblCode.setVisible(bShow);
	    lblName.setVisible(bShow);
	}
	
	//设置右面板中的对象是否可编辑
	private void setPanelObjectEditable(boolean bEditable){
	    getTxtCode().setEditable(false);
	    getTxtName().setEditable(bEditable);
	}
	
	//设置状态为浏览状态
	private void setBrowseState(){
	    setPanelObjectEditable(false);
	    getUITree().setEnabled(true);
	    
	    m_boAdd.setEnabled(true);
	    m_boEdit.setEnabled(true);
	    m_boDel.setEnabled(true);
	    m_boSave.setEnabled(false);
	    m_boCancel.setEnabled(false);
	    updateButtons();
	    
	}
	
	//设置状态为编辑(新增或修改)状态
	private void setEditState(){
	    setPanelObjectEditable(true);
	    getUITree().setEnabled(false);
	    
	    m_boAdd.setEnabled(false);
	    m_boEdit.setEnabled(false);
	    m_boDel.setEnabled(false);
	    m_boSave.setEnabled(true);
	    m_boCancel.setEnabled(true);
	    updateButtons();
	}
	
	//刷新树
	private void refreshTreeData() {
	    try {
	        TypeVO [] vos = TypeBO_Client.queryAll(null);
	        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(m_RootNodeName);
	        HashMap hmvos = new HashMap();
	        
	        if(vos!=null){
	            for (int i = 0; i < vos.length; i++) {
                    Vector group = (Vector) hmvos.get(vos[i].getPk_parent());
                    if(group==null){
        				group = new Vector();
        				group.add(vos[i]);
        				hmvos.put(vos[i].getPk_parent(),group);                    
                    } else {
        				group.add(vos[i]);
                    }
                }
	            
	            scanTreeNode(rootNode,hmvos);
	            
	        }
    	DefaultTreeModel model = new DefaultTreeModel(rootNode);
    	getUITree().setModel(model);    
    	
	    } catch (Exception e) {
	        MessageDialog.showErrorDlg(this,"错误",e.getMessage());
	    }
	}
	
	//遍历树节点
	private void scanTreeNode(DefaultMutableTreeNode rootNode, HashMap hmvos) throws Exception {
		String parentID = null;
		if(rootNode!=null && (!rootNode.getUserObject().equals(m_RootNodeName))){
		    TypeVO fvo = (TypeVO) rootNode.getUserObject();
			parentID = fvo.getPk_lctype();
		}
		
		Vector v = (Vector) hmvos.get(parentID);
		if(v!=null && v.size() > 0){
		    TypeVO [] vos = new TypeVO [v.size()];
			v.copyInto(vos);
			for (int i = 0; i < vos.length; i++){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(vos[i]);
				scanTreeNode(node,hmvos);
				rootNode.add(node);
			}
		}    
	}
	
	//获得选定的树节点
	private Object getTreeSelectedNode() {
	    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)getUITree().getLastSelectedPathComponent();
	    if(selectedNode==null){
	        return null;
	    } else {
	        return selectedNode.getUserObject();
	    }
	}
	
	//增加事件
	private void onAdd() throws Exception {
	    Object selectedNode = getTreeSelectedNode();
	    //校验是否选择了节点
	    if(selectedNode == null){
	        throw new Exception("请选择您要增加的类别的父节点");
	    }
	    String parentLcTypePk = null;
	    if(!selectedNode.equals(m_RootNodeName)){
	        TypeVO tvo = (TypeVO) selectedNode;
	        parentLcTypePk = tvo.getPk_lctype();
	        m_selectedVO = tvo;
	    } else {
	        m_selectedVO = null;
	    }
	    m_parentLcTypePk = parentLcTypePk;
	    showPanelObject(true);
	    getTxtCode().setText(getNewCode(m_selectedVO));
	    getTxtName().setText(null);
	    setEditState();
	    m_CurrentState = ADD_STATE;
	}
	
	//修改事件
	private void onEdit() throws Exception {
	    Object selectedNode = getTreeSelectedNode();
	    if(selectedNode==null || selectedNode.equals(m_RootNodeName)){
	        throw new Exception("请选择您要编辑的有效节点！");
	    }
	    m_selectedVO = (TypeVO) getTreeSelectedNode();
	    setEditState();
	    m_CurrentState = EDIT_STATE;
	}
	
	//删除事件
	private void onDel() throws Exception {
	    Object selectedNode = getTreeSelectedNode();
	    if(selectedNode==null || selectedNode.equals(m_RootNodeName)){
	        throw new Exception("请选择您要删除的有效节点！");
	    }
	    TypeVO vo = (TypeVO) selectedNode;
	    //校验是否为末级节点
	    if(!TypeBO_Client.isTailNode(vo)){
	        throw new Exception("非末级低值易耗品类别不允许删除！");
	    }
	    
	    //校验是否已经被引用
	    if(TypeBO_Client.isReffed(vo.getPk_lctype())){
	        throw new Exception("已经被引用的低值易耗品类别不允许删除!");
	    }
	    
	    if(MessageDialog.showYesNoDlg(this,"询问","是否真的要删除本节点？")==MessageDialog.ID_YES){
	        
		    // 删除
		    TypeBO_Client.delete(vo);
		    refreshTreeData();
	    }
	}
	
	//保存事件
	private void onSave() throws Exception {
	    if(m_CurrentState == ADD_STATE) {
	        onAddSave();
	    }
	    if(m_CurrentState == EDIT_STATE) {
	        onEditSave();
	    }
	}
	
	//新增保存
	private void onAddSave() throws Exception {
	    String code = getTxtCode().getText();
	    String name = getTxtName().getText();
	    //校验是否为空
	    if(code==null || name==null || code.trim().length()==0 || name.trim().length()==0){
	        throw new Exception("低值易耗品类别的编码或名称不允许为空！");
	    }
	    //校验是否有重复的编码和名称
	    TypeBO_Client.checkCodeAndName(code,name);
	    //生成新增vo
	    TypeVO vo = new TypeVO();
	    vo.setLctypecode(code);
	    vo.setLctypename(name);
	    vo.setPk_parent(m_parentLcTypePk);
	    TypeBO_Client.insert(vo);
	    refreshTreeData();
	    setBrowseState();
	    m_CurrentState = BROWSE_STATE;
	}
	
	//修改保存
	private void onEditSave() throws Exception {
	    String code = getTxtCode().getText();
	    String name = getTxtName().getText();
	    //校验是否为空
	    if(code==null || name==null || code.trim().length()==0 || name.trim().length()==0){
	        throw new Exception("低值易耗品类别的编码或名称不允许为空！");
	    }
	    //校验是否有重复的编码和名称
	    TypeBO_Client.checkCodeAndName(code,name,m_selectedVO);
	    TypeVO tvo = (TypeVO)m_selectedVO.clone();
	    tvo.setLctypecode(code);
	    tvo.setLctypename(name);
	    TypeBO_Client.update(tvo);
	    refreshTreeData();
	    setBrowseState();
	    m_CurrentState = BROWSE_STATE;	    
	}
	
	//取消事件
	private void onMyCancel() throws Exception {
	    setBrowseState();
	    m_CurrentState = BROWSE_STATE;
	    onTreeSelect();
	}
	
	//树节点事件
	private void onTreeSelect() {
	    Object selectedNode = getTreeSelectedNode();
	    if(selectedNode==null || selectedNode.equals(m_RootNodeName)){
	        showPanelObject(false);
	    } else {
	        TypeVO vo = (TypeVO) selectedNode;
	        getTxtCode().setText(vo.getLctypecode());
	        getTxtName().setText(vo.getLctypename());
	        showPanelObject(true);
	    }
	}
	
	//获取新物品类别的编码
	private String getNewCode (TypeVO parentVO) throws Exception{
	    String newCode = null;
	    try {
	        newCode = TypeBO_Client.getNewCode(parentVO);
	    } catch (Exception e) {
	        throw new Exception("未能正确生成编码：" + e.getMessage());
	    }
	    return newCode;
	}
	/**
	 * This method initializes UIScrollPane3	
	 * 	
	 * @return nc.ui.pub.beans.UIScrollPane	
	 */    
	private UIScrollPane getUIScrollPane3() {
		if (UIScrollPane3 == null) {
			UIScrollPane3 = new UIScrollPane();
			UIScrollPane3.setBounds(302, 5, 10, 10);
			UIScrollPane3.setViewportView(getUITree());
			
			
		}
		return UIScrollPane3;
	}

  }
