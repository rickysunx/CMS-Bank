/*
 * 创建日期 2005-9-16
 *
 * @author 孙锐
 */
package nc.ui.lowcost.card;

import java.awt.LayoutManager;
import java.util.*;

import nc.ui.fa.UserDefRefModelOBjDeptdoc;
import nc.ui.pub.*;
import nc.ui.pub.beans.*;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.pub.LCTools;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;
import nc.vo.sm.UserVO;
import nc.ui.sm.user.UserBO_Client;
/**
 * @author 孙锐
 *
 */
public class CardPanel extends UIPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5969541416098783665L;
	private UILabel lblCode = null;
	private UILabel lblName = null;
	private UILabel lblType = null;
	private UITextField txtCode = null;
	private UITextField txtName = null;
	private UIRefPane refType = null;
	private UILabel lblManageDept = null;
	private UIRefPane refManageDept = null;
	private UILabel lblUseDept = null;
	private UIRefPane refUseDept = null;
	private UILabel lblStatus = null;
	private UILabel lblBuyDate = null;
	private UILabel lblAddDate = null;
	private UILabel lblTallyDate = null;
	private UILabel lblCancelDate = null;
	private UITextField txtAddDate = null;
	private UITextField txtStatus = null;
	private UITextField txtTallyDate = null;
	private UITextField txtCancelDate = null;
	private UILabel lblPrice = null;
	private UILabel lblNumber = null;
	public UILabel lblSum = null;
	private UILabel lblRemark = null;
	private UITextField txtPrice = null;
	private UITextField txtNumber = null;
	private UITextField txtSum = null;
	private UITextField txtRemark = null;
	
	private CardUI m_CardUI = null;
	private UIRefPane refBuyDate = null;
	
	private CardVO m_CurrentVO = null;
	private CardVO m_BrowseStateVO = null;
	private UILabel UILabel = null;
	private UIRefPane refUser = null;
	
	public Boolean m_bAutoCode = null;
	public Boolean m_bShowManageDept = null;
	
	//增加的代码
	private UILabel inputPsn = null;
	private UITextField inputPsnText = null;
	//private UIRefPane inputPsnRefPane = null;
    /**
     * 
     */
    public CardPanel() {
        super();
		initialize();
    }

    /**
     * @param p0
     */
    public CardPanel(LayoutManager p0) {
        super(p0);
		initialize();
    }

    public CardPanel(CardUI cardUI){
        super();
        m_CardUI = cardUI;
        initialize();
    }
    
    /**
     * @param p0
     * @param p1
     */
    public CardPanel(LayoutManager p0, boolean p1) {
        super(p0, p1);
		initialize();
    }

    /**
     * @param p0
     */
    public CardPanel(boolean p0) {
        super(p0);
		initialize();
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        UILabel = new UILabel();
        lblCode = new UILabel();
        lblRemark = new UILabel();
        lblSum = new UILabel();
        lblNumber = new UILabel();
        lblPrice = new UILabel();
        lblCancelDate = new UILabel();
        lblTallyDate = new UILabel();
        lblAddDate = new UILabel();
        lblBuyDate = new UILabel();
        lblStatus = new UILabel();
        lblUseDept = new UILabel();
        lblManageDept = new UILabel();
        lblType = new UILabel();
        lblName = new UILabel();
        inputPsn = new UILabel();
        this.setLayout(null);
        this.setSize(674, 250);
        inputPsn.setBounds(458, 168, 52, 22);
        inputPsn.setText("录入人");
        lblCode.setText("物品编码");
        lblCode.setBounds(17, 16, 52, 22);
        lblName.setBounds(241, 16, 52, 22);
        lblName.setText("物品名称");
        lblType.setBounds(458, 16, 52, 22);
        lblType.setText("物品类别");
        lblManageDept.setBounds(241, 168, 52, 22);
        lblManageDept.setText("管理部门");
        lblUseDept.setBounds(241, 54, 52, 22);
        lblUseDept.setText("使用部门");
        lblStatus.setBounds(459, 54, 52, 22);
        lblStatus.setText("物品状态");
        lblBuyDate.setBounds(17, 92, 52, 22);
        lblBuyDate.setText("购买时间");
        lblAddDate.setBounds(241, 92, 52, 22);
        lblAddDate.setText("增加时间");
        lblTallyDate.setBounds(458, 92, 52, 22);
        lblTallyDate.setText("记账时间");
        lblCancelDate.setBounds(17, 130, 52, 22);
        lblCancelDate.setText("核销时间");
        lblPrice.setBounds(241, 130, 52, 22);
        lblPrice.setText("单价");
        lblNumber.setBounds(458, 130, 52, 22);
        lblNumber.setText("数量");
        lblSum.setBounds(17, 168, 52, 22);
        lblSum.setText("金额");
        lblRemark.setBounds(16, 203, 52, 22);
        lblRemark.setText("备注");
        UILabel.setBounds(17, 54, 52, 22);
        UILabel.setText("使用人");
        this.add(lblCode, null);
        this.add(lblName, null);
        this.add(lblType, null);
        this.add(getTxtCode(), null);
        this.add(getTxtName(), null);
        this.add(getRefType(), null);
        this.add(lblManageDept, null);
        this.add(getRefManageDept(), null);
        this.add(lblUseDept, null);
        this.add(getRefUseDept(), null);
        this.add(lblStatus, null);
        this.add(lblBuyDate, null);
        this.add(lblAddDate, null);
        this.add(lblTallyDate, null);
        this.add(lblCancelDate, null);
        this.add(getTxtAddDate(), null);
        this.add(getTxtStatus(), null);
        this.add(getTxtTallyDate(), null);
        this.add(getTxtCancelDate(), null);
        this.add(lblPrice, null);
        this.add(lblNumber, null);
        this.add(lblSum, null);
        this.add(lblRemark, null);
        this.add(getTxtPrice(), null);
        this.add(getTxtNumber(), null);
        this.add(getTxtSum(), null);
        this.add(getTxtRemark(), null);
        this.add(getRefBuyDate(), null);
        this.add(UILabel, null);
        this.add(getRefUser(), null);
        this.add(inputPsn);
        //this.add(getInputPsnRefPane());
        this.add(getInputPsnText());
        lblManageDept.setVisible(getIfManageDept());		
	}
	/**
	 * This method initializes UITextField	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtCode() {
		if (txtCode == null) {
			txtCode = new UITextField();
			txtCode.setBounds(76, 16, 132, 22);
			txtCode.setMaxLength(5000);
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
			txtName.setBounds(299, 16, 132, 22);
			txtName.setMaxLength(5000);
		}
		return txtName;
	}
	/**
	 * This method initializes UIRefPane	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	public UIRefPane getRefType() {
		if (refType == null) {
			refType = new UIRefPane();
			//refType.setRefModel(new LcTypeRefModel());
			//ryh 20060427 带权限的物品类别
			nc.ui.fa.UserDefRefModelOBjType dmUse = new nc.ui.fa.UserDefRefModelOBjType(getCardUI().getEvn().getCorporation().getPk_corp());
			refType.setRefModel(dmUse);
			refType.setBounds(522, 16, 132, 22);
		}
		return refType;
	}
	/**
	 * This method initializes UIRefPane1	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	private UIRefPane getRefManageDept() {
		if (refManageDept == null) {
			refManageDept = new UIRefPane();
			//refManageDept.setRefModel(new DeptRefModel(getCardUI().getEvn().getCorporation().getPk_corp()));
//			ryh 20060427 带权限的物品管理部门
			UserDefRefModelOBjDeptdoc dmUse = new nc.ui.fa.UserDefRefModelOBjDeptdoc(getCardUI().getEvn().getCorporation().getPk_corp(), false);
			refManageDept.setRefModel(dmUse);
			refManageDept.setBounds(299, 168, 132, 22);
			refManageDept.setVisible(getIfManageDept());
		}
		return refManageDept;
	}
	/**
	 * This method initializes UIRefPane2	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	public UIRefPane getRefUseDept() {
		if (refUseDept == null) {
			refUseDept = new UIRefPane();
			//refUseDept.setRefModel(new DeptRefModel(getCardUI().getEvn().getCorporation().getPk_corp()));
//			ryh 20060427 带权限的物品使用部门
			UserDefRefModelOBjDeptdoc dmUse = new nc.ui.fa.UserDefRefModelOBjDeptdoc(getCardUI().getEvn().getCorporation().getPk_corp(), true);
			refUseDept.setRefModel(dmUse);
            refUseDept.setBounds(299, 54, 132, 22);
		}
		return refUseDept;
	}
	/**
	 * This method initializes UITextField22	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtAddDate() {
		if (txtAddDate == null) {
			txtAddDate = new UITextField();
			txtAddDate.setBounds(299, 92, 132, 22);
		}
		return txtAddDate;
	}
	/**
	 * This method initializes UITextField21	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	public UITextField getTxtStatus() {
		if (txtStatus == null) {
			txtStatus = new UITextField();
			txtStatus.setBounds(522, 54, 132, 22);
		}
		return txtStatus;
	}
	/**
	 * This method initializes UITextField23	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtTallyDate() {
		if (txtTallyDate == null) {
			txtTallyDate = new UITextField();
			txtTallyDate.setBounds(522, 92, 132, 22);
		}
		return txtTallyDate;
	}
	/**
	 * This method initializes UITextField24	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtCancelDate() {
		if (txtCancelDate == null) {
			txtCancelDate = new UITextField();
			txtCancelDate.setBounds(76, 130, 132, 22);
		}
		return txtCancelDate;
	}
	/**
	 * This method initializes UITextField25	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	public UITextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new UITextField();
			txtPrice.setBounds(299, 130, 132, 22);
			txtPrice.setTextType("TextDbl");
			txtPrice.setNumPoint(2);
			txtPrice.setMaxLength(5000);
			txtPrice.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusLost(java.awt.event.FocusEvent e) {    
					calcSum();
				}
			});
		}
		return txtPrice;
	}
	/**
	 * This method initializes UITextField26	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	public UITextField getTxtNumber() {
		if (txtNumber == null) {
			txtNumber = new UITextField();
			txtNumber.setBounds(522, 130, 132, 22);
			
			txtNumber.setMaxLength(5000);
			txtNumber.setTextType("TextDbl");
			txtNumber.setNumPoint(0);
			txtNumber.addFocusListener(new java.awt.event.FocusAdapter() { 
				public void focusLost(java.awt.event.FocusEvent e) {    
					calcSum();
				}
			});
		}
		return txtNumber;
	}
	/**
	 * This method initializes UITextField27	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	public UITextField getTxtSum() {
		if (txtSum == null) {
			txtSum = new UITextField();
			txtSum.setBounds(76, 168, 132, 22);
			txtSum.setTextType("TextDbl");
			txtSum.setNumPoint(2);
			txtSum.setMaxLength(5000);
		}
		return txtSum;
	}
	/**
	 * This method initializes UITextField28	
	 * 	
	 * @return nc.ui.pub.beans.UITextField	
	 */    
	private UITextField getTxtRemark() {
		if (txtRemark == null) {
			txtRemark = new UITextField();
			txtRemark.setBounds(77, 203, 577, 22);
			txtRemark.setMaxLength(5000);
		}
		return txtRemark;
	}
	
	public CardUI getCardUI() {
	    return m_CardUI;
	}
	
	public void setBrowseState() throws Exception {
        getTxtCode().setEnabled(false);
        getTxtName().setEnabled(false);
        getRefType().setEnabled(false);
        getRefManageDept().setEnabled(false);
        getRefUseDept().setEnabled(false);
        getTxtStatus().setEnabled(false);
        getRefBuyDate().setEnabled(false);
        getTxtAddDate().setEnabled(false);
        getTxtTallyDate().setEnabled(false);
        getTxtCancelDate().setEnabled(false);
        getTxtPrice().setEnabled(false);
        getTxtNumber().setEnabled(false);
        getTxtSum().setEnabled(false);
        getTxtRemark().setEnabled(false);	
        getRefUser().setEnabled(false);
        //getInputPsnRefPane().setEnabled(false);
       
	}
	
	public void setEditState() throws Exception {
		getInputPsnText().setText(ClientEnvironment.getInstance().getUser().getUserName());
        getTxtCode().setEnabled(false);
        getTxtName().setEnabled(true);
        getRefType().setEnabled(true);
        getRefManageDept().setEnabled(true);
        getRefUseDept().setEnabled(true);
        getTxtStatus().setEnabled(false);
        getRefBuyDate().setEnabled(true);
        getTxtAddDate().setEnabled(true);
        getTxtTallyDate().setEnabled(false);
        getTxtCancelDate().setEnabled(false);
        getTxtPrice().setEnabled(true);
        getTxtNumber().setEnabled(true);
        getTxtSum().setEnabled(false);
        getTxtRemark().setEnabled(true);	
        getRefUser().setEnabled(true);
	}
	
	public void setAddState() throws Exception {
	    getTxtCode().setEnabled(!getIfAutoCode());
        getTxtName().setEnabled(true);
        getRefType().setEnabled(true);
        getRefManageDept().setEnabled(true);
        getRefUseDept().setEnabled(true);
        getTxtStatus().setEnabled(false);
        getRefBuyDate().setEnabled(true);
        getTxtAddDate().setEnabled(false);
        getTxtTallyDate().setEnabled(false);
        getTxtCancelDate().setEnabled(false);
        getTxtPrice().setEnabled(true);
        getTxtNumber().setEnabled(true);
        getTxtSum().setEnabled(false);
        getTxtRemark().setEnabled(true);
        getRefUser().setEnabled(true);
        CardVO vo = new CardVO();
        //getInputPsnRefPane().setPK(ClientEnvironment.getInstance().getUser().getPrimaryKey());
        //getInputPsnRefPane().setName(ClientEnvironment.getInstance().getUser().getUserCode());
        vo.setAdddate(new UFDate(new Date()));
        getInputPsnText().setText(ClientEnvironment.getInstance().getUser().getUserName());
        setCurrentVO(vo);       
	}
	/**
	 * This method initializes UIRefPane	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	private UIRefPane getRefBuyDate() {
		if (refBuyDate == null) {
			refBuyDate = new UIRefPane(m_CardUI);
			refBuyDate.setBounds(76, 92, 132, 22);
			refBuyDate.setRefNodeName("日历");
		}
		return refBuyDate;
	}
	
	public void setCurrentVO (CardVO vo) throws Exception{
	    m_CurrentVO = vo;
	    if(vo==null){
	        getTxtCode().setText(null);
	        getTxtName().setText(null);
	        getRefType().setPK(null);
	        getRefManageDept().setPK(null);
	        getRefUseDept().setPK(null);
	        getTxtStatus().setText(null);
	        getRefBuyDate().setPK(null);
	        getTxtAddDate().setText(null);
	        getTxtTallyDate().setText(null);
	        getTxtCancelDate().setText(null);
	        getTxtPrice().setText(null);
	        getTxtNumber().setText(null);
	        getTxtSum().setText(null);
	        getTxtRemark().setText(null);
	        getRefUser().setText(null);
	        //getInputPsnRefPane().setText(null);
	        getInputPsnText().setText(null);
	    } else {
	        getTxtCode().setText(vo.getLccode());
	        getTxtName().setText(vo.getLcname());
	        getRefType().setPK(vo.getPk_lctype());
	        getRefManageDept().setPK(vo.getPk_managedept());
	        getRefUseDept().setPK(vo.getPk_usedept());
	        getTxtStatus().setText(vo.getCardStatus());
	        getRefBuyDate().setPK(vo.getBuydate());
	        getTxtAddDate().setText(getToString(vo.getAdddate()));
	        getTxtTallyDate().setText(getToString(vo.getTallydate()));
	        getTxtCancelDate().setText(getToString(vo.getCanceldate()));
	        getTxtPrice().setText(NumFormate.getPrecisionData(vo.getPrice(),2));
	        getTxtNumber().setText(vo.getNumber()==null?null:vo.getNumber().toString());
	        getTxtSum().setText(NumFormate.getPrecisionData((!(vo.getPrice()!=null && vo.getNumber()!=null))?new UFDouble(0):new UFDouble(((vo.getPrice().doubleValue()*vo.getNumber().doubleValue()))),2));
	        getTxtRemark().setText(vo.getRemark());
	        getRefUser().setPK(vo.getDef1());
	        //getInputPsnRefPane().setPK(vo.getDef3());
	        if(vo.getDef3()!=null&&vo.getDef3().length()>0){
	        	UserVO user = UserBO_Client.findUserByPrimaryKey(vo.getDef3());
	        	getInputPsnText().setText(user.getUserName());
	    	}
	    }
	}
	
	public String getToString(Object obj){
	    if(obj==null){
	        return null;
	    } else {
	        return obj.toString();
	    }
	}
	
	public String SaveAdd() throws Exception {
	    CardVO vo = new CardVO();
	    if(getTxtCode().getText()!=null&&getTxtCode().getText().length()>0)
	    	vo.setLccode(getTxtCode().getText());
	    else
	    	vo.setLccode(null);
	    vo.setLcname(getTxtName().getText());
	    vo.setPk_lctype(getRefType().getRefPK());
	    vo.setPk_managedept(getRefManageDept().getRefPK());
	    vo.setPk_usedept(getRefUseDept().getRefPK());
	    vo.setBuydate(new UFDate(getRefBuyDate().getRefPK()));
	    vo.setPrice(new UFDouble(getTxtPrice().getText()));
	    vo.setNumber(new UFDouble(getTxtNumber().getText()));
	    vo.setAdddate(m_CardUI.getEvn().getDate());
	    vo.setTallyflag(new UFBoolean(false));
	    vo.setCancelflag(new UFBoolean(false));
	    vo.setRemark(getTxtRemark().getText());
	    vo.setDef1(getRefUser().getRefPK());
	    //vo.setDef3(getInputPsnRefPane().getRefPK());
	    //String def3 = ClientEnvironment.getInstance().getUser().getPrimaryKey();
	    String def3 = m_CardUI.getEvn().getUser().getPrimaryKey();
	    vo.setDef3(def3);
	    //校验输入
	    if(!getIfAutoCode()){
		    if(vo.getLccode()==null || vo.getLccode().trim().length()==0){
		        throw new Exception("物品编码不能为空");
		    }
	    }
	    if(vo.getLcname()==null || vo.getLcname().trim().length()==0){
	        throw new Exception("物品名称不能为空");
	    }
	    if(vo.getPk_lctype()==null){
	        throw new Exception("物品类别不能为空");
	    }
//	    if(vo.getPk_managedept()==null){
//	        throw new Exception("管理部门不能为空");
//	    }
	    if(vo.getPk_usedept()==null){
	        throw new Exception("使用部门不能为空");
	    }
//	    if(vo.getBuydate()==null || vo.getBuydate().toString().trim().length()==0){
//	        throw new Exception("购买日期不能为空");
//	    }
	    if(getTxtPrice().getText().trim().length()==0){
	        throw new Exception("单价不能为空");
	    }
	    if(getTxtNumber().getText().trim().length()==0){
	        throw new Exception("数量不能为空");
	    }
//	    if(getInputPsnRefPane().getRefName().trim().length()<=0)
//	    	throw new Exception("录入人不能为空");
	    
	    String key = CardBO_Client.insert(vo);
	    return key;
	}
	
	public void SaveEdit() throws Exception {
	    CardVO vo = (CardVO)m_CurrentVO.clone();
	    vo.setLccode(getTxtCode().getText());
	    vo.setLcname(getTxtName().getText());
	    vo.setPk_lctype(getRefType().getRefPK());
	    vo.setPk_managedept(getRefManageDept().getRefPK());
	    vo.setPk_usedept(getRefUseDept().getRefPK());
	    vo.setBuydate(new UFDate(getRefBuyDate().getRefPK()));
	    if(getTxtAddDate().getText()==null ||getTxtAddDate().getText().trim().length()==0){
	        throw new Exception ("增加日期不能为空");
	    }
        if(!UFDate.isAllowDate(getTxtAddDate().getText())) {
            throw new Exception ("增加日期不是合法的日期");
        }
        vo.setAdddate(new UFDate(getTxtAddDate().getText()));
	    vo.setPrice(new UFDouble(getTxtPrice().getText()));
	    vo.setNumber(new UFDouble(getTxtNumber().getText()));
	    vo.setRemark(getTxtRemark().getText());
	    vo.setDef1(getRefUser().getRefPK());
	    String def3 = ClientEnvironment.getInstance().getUser().getPrimaryKey();
	    vo.setDef3(def3);
	    //校验输入
//	    if(vo.getLccode()==null || vo.getLccode().trim().length()==0){
//	        throw new Exception("物品编码不能为空");
//	    }
	    if(vo.getLcname()==null || vo.getLcname().trim().length()==0){
	        throw new Exception("物品名称不能为空");
	    }
	    if(vo.getPk_lctype()==null){
	        throw new Exception("物品类别不能为空");
	    }
//	    if(vo.getPk_managedept()==null){
//	        throw new Exception("管理部门不能为空");
//	    }
	    if(vo.getPk_usedept()==null){
	        throw new Exception("使用部门不能为空");
	    }
//	    if(vo.getBuydate()==null || vo.getBuydate().toString().trim().length()==0){
//	        throw new Exception("购买日期不能为空");
//	    }
	    if(getTxtPrice().getText().trim().length()==0){
	        throw new Exception("单价不能为空");
	    }
	    if(getTxtNumber().getText().trim().length()==0){
	        throw new Exception("数量不能为空");
	    }
	    
	    CardBO_Client.update(vo);
	}
	
	public void onMyCanel() throws Exception {
	    setCurrentVO(m_BrowseStateVO);
	    if(m_BrowseStateVO!=null && m_BrowseStateVO.getDef3()!=null&&m_BrowseStateVO.getDef3().length()>0)
	    	getInputPsnText().setText(UserBO_Client.findUserByPrimaryKey(m_BrowseStateVO.getDef3()).getUserName());
	    else
	    	getInputPsnText().setText(null);
	}
	
	public void setBrowseStateVO (CardVO vo) {
	    m_BrowseStateVO = vo;
	}
	
	public void calcSum() {
	    try {
	        UFDouble price = new UFDouble(getTxtPrice().getText());
	        UFDouble number = new UFDouble(getTxtNumber().getText());
	        getTxtSum().setText(NumFormate.getPrecisionData(new UFDouble(price.doubleValue()*number.doubleValue()),2));
	    } catch (Exception e) {
	        getTxtSum().setText("0.00");
	    }
	    
	}
	/**
	 * This method initializes UIRefPane	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	public UIRefPane getRefUser() {
		if (refUser == null) {
			refUser = new UIRefPane();
			refUser.setBounds(76, 54, 132, 22);
			refUser.setRefNodeName("人员档案");
		}
		return refUser;
	}
	
	public void setTallyState() throws Exception {
        getTxtCode().setEnabled(false);
        getTxtName().setEnabled(true);
        getRefType().setEnabled(true);
        getRefManageDept().setEnabled(true);
        getRefUseDept().setEnabled(false);
        getTxtStatus().setEnabled(false);
        getRefBuyDate().setEnabled(true);
        getTxtAddDate().setEnabled(false);
        getTxtTallyDate().setEnabled(false);
        getTxtCancelDate().setEnabled(false);
        getTxtPrice().setEnabled(false);
        getTxtNumber().setEnabled(false);
        getTxtSum().setEnabled(false);
        getTxtRemark().setEnabled(true);	
        getRefUser().setEnabled(true);
        //getInputPsnRefPane().setEnabled(true);
        getInputPsnText().setText(ClientEnvironment.getInstance().getUser().getUserName());
	}
	
	public boolean getIfAutoCode() {
	    if(m_bAutoCode==null){
		    String strIfAutoCode = LCTools.getParam(null,"LC10");
		    if(strIfAutoCode==null || strIfAutoCode.equals("N")){
		        m_bAutoCode = new Boolean(false);
		    } else {
		        m_bAutoCode = new Boolean(true);
		    }
	    } 
	    return m_bAutoCode.booleanValue();
	}
	
	public boolean getIfManageDept() {
	    if(m_bShowManageDept==null){
	        String strIfManageDept = LCTools.getParam(null,"LC20");
	        if(strIfManageDept==null || strIfManageDept.equals("N")){
	            m_bShowManageDept = new Boolean(false);
	        } else {
	            m_bShowManageDept = new Boolean(true);
	        }
	    }
	    return m_bShowManageDept.booleanValue();
	}
	
	/*public UIRefPane getInputPsnRefPane(){
		if(inputPsnRefPane == null){
			inputPsnRefPane = new UIRefPane();
			inputPsnRefPane.setBounds(522,168,132,22);
			inputPsnRefPane.setRefNodeName("人员档案");
			inputPsnRefPane.setEditable(false);
			inputPsnRefPane.setEnabled(false);
		}
		return inputPsnRefPane;
	}*/
	
	public UITextField getInputPsnText(){
		if(this.inputPsnText == null){
			inputPsnText = new UITextField();
			inputPsnText.setBounds(522,168,132,22);
			inputPsnText.setEditable(false);
		}
		return inputPsnText;
	}
 }
