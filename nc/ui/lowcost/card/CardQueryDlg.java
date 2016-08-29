/*
 * 创建日期 2005-9-19
 *
 * @author 孙锐
 */
package nc.ui.lowcost.card;

import java.awt.Container;
import java.awt.Frame;
import java.util.Vector;

import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.fa.UserDefRefModelOBjDeptdoc;
import nc.ui.pub.beans.UIDialog;

import nc.ui.pub.beans.*;
import nc.vo.bd.b04.DeptdocVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.pub.LCTools;
import nc.vo.lowcost.type.TypeVO;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;
import nc.vo.sm.UserVO;
import nc.ui.pub.beans.UILabel;
import nc.ui.pub.beans.UICheckBox;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.beans.ValueChangedEvent;
import nc.ui.sm.user.UserBO_Client;
import nc.ui.lowcost.type.*;
/**
 * @author 孙锐
 *
 */
public class CardQueryDlg extends UIDialog implements ValueChangedListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2413879794270842696L;
	private UIPanel MainPanel = null;
	private UILabel lblManageDept = null;
	private UIRefPane refManageDept = null;
	private UILabel lblUseDept = null;
	private UIRefPane refUseDept = null;
	private UILabel lblType = null;
	private UIRefPane refType = null;
	private UILabel lblStatus = null;
	private UIComboBox cbStatus = null;
	private UIButton btnOk = null;
	private UIButton btnCancel = null;
	
	public CardVO m_CondVO = null;
	public CardVO[] m_CondVOs = null;
	
	private UILabel UILabel = null;
	private UICheckBox UICheckBox = null;
	
	//修改代码
	private UILabel to1 = null;
	private UILabel to2 = null;
	private UILabel to3 = null;
	private UILabel singlePrice = null;
	private UILabel amount = null;
	private UILabel addTime = null;
	private UILabel buyTime = null;
	private UILabel destroyTime = null;
	private UILabel remark = null;
	private UILabel user = null;
	private UILabel inputpsn = null;
	private UILabel totalprice = null;
	private UILabel item = null;
	
	private UIRefPane addTimePaneStart = null;
	private UIRefPane buyTimePaneStart = null;
	private UIRefPane destroyPaneStart = null;
	private UIRefPane addTimePaneEnd = null;
	private UIRefPane buyTimePaneEnd = null;
	private UIRefPane destroyPaneEnd = null;
//	private UIRefPane PsnRef = null;
	private UIRefPane userRef = null;
	private InputPsnRefModel inputPsn = null;
	
	private UITextField singlePriceStart = null;

	private UITextField amountStart = null;
	private UITextField remarkText = null;
	private UITextField totalPriceStart = null;
	private UITextField totalPriceEnd = null;
	private UILabel UILabel1 = null;
	private UIRefPane newPane = null;
	private UIRefPane itemRefPane = null;
	
	private String whereSql = null;
	public int flag = 0;
    /**
     * 
     */
    public CardQueryDlg() {
        super();
		initialize();
    }

    /**
     * @param parent
     */
    public CardQueryDlg(Container parent) {
        super(parent);
		initialize();
    }

    /**
     * @param parent
     * @param title
     */
    public CardQueryDlg(Container parent, String title) {
        super(parent, title);
		initialize();
    }

    /**
     * @param owner
     */
    public CardQueryDlg(Frame owner) {
        super(owner);
		initialize();
    }

    /**
     * @param owner
     * @param title
     */
    public CardQueryDlg(Frame owner, String title) {
        super(owner, title);
		initialize();
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setContentPane(getMainPanel());
        this.setTitle("物品卡片查询");
        this.setBounds(new java.awt.Rectangle(0,0,485,480));
	}
	/**
	 * This method initializes MainPanel	
	 * 	
	 * @return nc.ui.pub.beans.UIPanel	
	 */    
	private UIPanel getMainPanel() {
		if (MainPanel == null) {
			UILabel1 = new UILabel();
			UILabel1.setBounds(new java.awt.Rectangle(250,324,22,22));
			UILabel1.setText("\u81f3");
			UILabel = new UILabel();
			lblStatus = new UILabel();
			lblType = new UILabel();
			lblUseDept = new UILabel();
			lblManageDept = new UILabel();
			to1 = new UILabel();
			to2 = new UILabel();
			to3 = new UILabel("至");
			amount = new UILabel();
			singlePrice = new UILabel();
			addTime = new UILabel();
			buyTime = new UILabel();
			destroyTime = new UILabel(); 
			remark = new UILabel();
			user = new UILabel();
			totalprice = new UILabel();
			inputpsn = new UILabel();
			item = new UILabel();
			MainPanel = new UIPanel();
			MainPanel.setLayout(null);
			MainPanel.setSize(new java.awt.Dimension(504,236));
			lblManageDept.setText("管理部门");
			lblManageDept.setBounds(new java.awt.Rectangle(355,420,56,22));
			lblUseDept.setBounds(15, 12, 56, 22);
			lblUseDept.setText("使用部门");
			lblType.setBounds(15, 51, 56, 22);
			lblType.setText("物品类别");
			lblStatus.setBounds(248, 51, 56, 22);
			lblStatus.setText("物品状态");
			to1.setBounds(250, 168, 22, 22);
			to1.setText("至");
			to2.setBounds(250, 207, 22, 22);
			to2.setText("至");
			to3.setBounds(250,246,22,22);
			singlePrice.setBounds(15, 129, 56, 22);
			singlePrice.setText("单价");
			amount.setBounds(250, 129, 35, 22);
			amount.setText("数量");
			buyTime.setBounds(15, 168, 56, 22);
			buyTime.setText("购买时间");
			addTime.setBounds(15, 207, 56, 22);
			addTime.setText("增加时间");
			destroyTime.setBounds(15, 246, 56, 22);
			destroyTime.setText("核销时间");
			remark.setBounds(15, 285, 56, 22);
			remark.setText("备注");
			totalprice.setBounds(15, 324, 56, 22);
			totalprice.setText("金额");
			user.setBounds(15, 363, 56, 22);
			user.setText("使用人");
			inputpsn.setBounds(248, 363, 56, 22);
			inputpsn.setText("录入人");
			item.setBounds(15, 90, 56, 22);
			item.setText("物品");
			MainPanel.add(lblManageDept, null);
			MainPanel.add(getRefManageDept(), null);
			MainPanel.add(lblUseDept, null);
			MainPanel.add(getRefUseDept(), null);
			MainPanel.add(lblType, null);
			MainPanel.add(getRefType(), null);
			MainPanel.add(lblStatus, null);
			MainPanel.add(getCbStatus(), null);
			MainPanel.add(getBtnOk(), null);
			MainPanel.add(getBtnCancel(), null);
			MainPanel.add(to1, null);
			MainPanel.add(to2, null);
			MainPanel.add(to3, null);
			MainPanel.add(singlePrice, null);
			MainPanel.add(amount, null);
			MainPanel.add(addTime, null);
			MainPanel.add(buyTime, null);
			MainPanel.add(destroyTime, null);
			MainPanel.add(remark, null);
			MainPanel.add(getSinglePriceStart(), null);
			MainPanel.add(getTotalPriceEnd(), null);
			MainPanel.add(getAmountStart(), null);
			MainPanel.add(getRemarkText(), null);
			
			lblManageDept.setVisible(false);
			UILabel.setBounds(332, 12, 80, 22);
			UILabel.setText("是否包含下级");
			MainPanel.add(UILabel, null);
			MainPanel.add(getUICheckBox(), null);
			MainPanel.add(getBuyTimePaneStart(), null);
			MainPanel.add(getAddTimePaneStart(), null);
			MainPanel.add(getDestroyTimePaneStart(), null);
			MainPanel.add(getBuyTimePaneEnd(), null);
			MainPanel.add(getAddTimePaneEnd(), null);
			MainPanel.add(getDestroyTimePaneEnd(), null);
			MainPanel.add(user, null);
			MainPanel.add(inputpsn, null);
			MainPanel.add(totalprice, null);
			MainPanel.add(getTotalPriceStart());
			MainPanel.add(UILabel1, null);
			//MainPanel.add(getRefPsn(), null);
			MainPanel.add(getInputPsn(), null);
			MainPanel.add(getRefUser(), null);
			MainPanel.add(item, null);
			MainPanel.add(getItemRefPane());
		}
		return MainPanel;
	}
	/**
	 * This method initializes refManageDept	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	public UIRefPane getRefManageDept() {
		if (refManageDept == null) {
			refManageDept = new UIRefPane();
			//refManageDept.setRefModel(new DeptRefModel(getClientEnvironment().getCorporation().getPk_corp()));
			//ryh 20060427 带权限的物品管理部门
			UserDefRefModelOBjDeptdoc dmUse = new nc.ui.fa.UserDefRefModelOBjDeptdoc(getClientEnvironment().getCorporation().getPk_corp(), false);
			refManageDept.setRefModel(dmUse);
			refManageDept.setMultiSelectedEnabled(true);
			refManageDept.setVisible(false);
			refManageDept.setBounds(new java.awt.Rectangle(355,392,136,22));
		}
		return refManageDept;
	}
	/**
	 * This method initializes refUseDept
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	public UIRefPane getRefUseDept() {
		if (refUseDept == null) {
			refUseDept = new MyRefPane();
			
			//refUseDept.setRefModel(new DeptRefModel(getClientEnvironment().getCorporation().getPk_corp()));
			//ryh 20060427 带权限控制的物品使用部门
			UserDefRefModelOBjDeptdoc dmUse = new nc.ui.fa.UserDefRefModelOBjDeptdoc(getClientEnvironment().getCorporation().getPk_corp(), true);
			refUseDept.setRefModel(dmUse);
			refUseDept.setBounds(83, 12, 230, 22);
			refUseDept.setMultiSelectedEnabled(true);
		}
		return refUseDept;
	}
	/**
	 * This method initializes refType	
	 * 	
	 * @return nc.ui.pub.beans.UIRefPane	
	 */    
	public UIRefPane getRefType() {
		if (refType == null) {
			refType = new UIRefPane();
			//refType.setRefModel(new LcTypeRefModel());
//			ryh 20060427 带权限的物品类别
			nc.ui.fa.UserDefRefModelOBjType dmUse = new nc.ui.fa.UserDefRefModelOBjType(getClientEnvironment().getCorporation().getPk_corp());
			refType.setRefModel(dmUse);
			refType.setBounds(83, 51, 136, 22);
			refType.setMultiSelectedEnabled(true);
			refType.setAutoCheck(false);
		}
		return refType;
	}
	/**
	 * This method initializes UIComboBox	
	 * 	
	 * @return nc.ui.pub.beans.UIComboBox	
	 */    
	private UIComboBox getCbStatus() {
		if (cbStatus == null) {
			cbStatus = new UIComboBox();
			cbStatus.addItem("");
			cbStatus.addItem("未记账");
			cbStatus.addItem("已记账");
			cbStatus.addItem("已核销");
			cbStatus.setBounds(312, 51, 136, 22);
		}
		return cbStatus;
	}
	/**
	 * This method initializes btnOk	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new UIButton();
			btnOk.setText("确定");
			btnOk.setBounds(new java.awt.Rectangle(130,420,70,22));
			btnOk.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					onOk();
				}
			});
		}
		return btnOk;
	}
	/**
	 * This method initializes btnCancel	
	 * 	
	 * @return nc.ui.pub.beans.UIButton	
	 */    
	private UIButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new UIButton();
			btnCancel.setText("取消");
			btnCancel.setBounds(new java.awt.Rectangle(270,420,70,22));
			btnCancel.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					closeCancel();
				}
			});
		}
		return btnCancel;
	}
	
	public CardVO getCondVO() {
	    return m_CondVO;
	}
	
	public CardVO[] getCondVOs(){
		return m_CondVOs;
	}
	
	private void onOk() {
		flag = 0;
		if(getRefUseDept().getText()!=null&&getRefUseDept().getText().length()>0&&getRefUseDept().getRefPKs()!=null&&getRefUseDept().getRefPKs().length>1)
			flag = 1;
		if(getRefType().getText()!=null&&getRefType().getText().length()>0&&getRefType().getRefPKs()!=null&&getRefType().getRefPKs().length>1)
			flag = 1;
		if(getItemRefPane().getText()!=null&&getItemRefPane().getText().length()>0&&getItemRefPane().getRefPKs()!=null&&getItemRefPane().getRefPKs().length>1)
			flag = 1;
			
			
		if(flag==1){
			whereSql = "";
			if(getItemRefPane().getText()!=null&&getItemRefPane().getText().length()>0){
				//if(getClientEnvironment().getCorporation().getPk_corp()!=null)
					//whereSql += "pk_corp = '"+getClientEnvironment().getCorporation().getPk_corp()+"' and ";
				if(getItemRefPane().getRefPKs()!=null&&getItemRefPane().getRefPKs().length>0){
					String[] temp = getItemRefPane().getRefPKs();
					whereSql += "pk_lccard in (";
					for(int i=0; i<temp.length; i++){						
						whereSql += "'" + temp[i] + "'";
						if(i<temp.length-1)
							whereSql += ",";
					}
					whereSql += ") ";
				}
				else
					whereSql += "lccode like '"+getItemRefPane().getText().trim()+"' ";
			}else{
				if(getClientEnvironment().getCorporation().getPk_corp()!=null)
					whereSql += "pk_corp like '"+getClientEnvironment().getCorporation().getPk_corp()+"' and ";
				if(getRefManageDept().getRefPK()!=null)
					whereSql += "pk_managedept like '" + getRefManageDept().getRefPK() + "' and ";
				else{
					String isUseManageDept = LCTools.getParam(null,"LC20");
					if((isUseManageDept!=null)&&(!isUseManageDept.equals(""))&&(isUseManageDept.equals("Y")))//启用了管理部门
					{
					try {
						if(CardBO_Client.isControl(getClientEnvironment().getCorporation().getPk_corp(),"bd_deptdoc_物品管理部门"))//权限控制了
						{
						    Vector man_v = new Vector();
							man_v = CardBO_Client.getControlPks(getClientEnvironment().getCorporation().getPk_corp(),getClientEnvironment().getUser().getPrimaryKey(),"bd_deptdoc_物品管理部门")	;
							if((man_v!=null)&&(man_v.size()>0))
							{
							  String tmp = "";
							  for(int i=0;i<man_v.size();i++)
							  {
							     tmp = tmp + "'"+man_v.get(i).toString().trim()+"'";
							     if(i<man_v.size()-1)
							     {
							     tmp = tmp + ",";	
							     }
							  }
							whereSql += "pk_managedept in ("+tmp+") and ";
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
				}
				
				if(getRefUseDept().getRefPKs()!=null){
					if(!getUICheckBox().isSelected()){
						whereSql += "pk_usedept in (";
						String[] temp = getRefUseDept().getRefPKs();
						for(int i=0; i<temp.length; i++){
							whereSql += "'" + temp[i] + "'";
							if(i<temp.length-1)
								whereSql += ",";
						}
						whereSql += ") and ";
					}else{
						String[] temp = getRefUseDept().getRefPKs();
						Vector v = new Vector();
						try{
							for(int i=0; i<temp.length; i++){
					    	 DeptdocVO[] deptvos = DeptdocBO_Client.queryAllchildern(temp[i]);
					    	 if((deptvos == null)||(deptvos.length<=0))//没找到下级，查本级
					    	 {
					    		 whereSql += "pk_usedept in (";
									String[] temps = getRefUseDept().getRefPKs();
									for(int j=0; j<temps.length; j++){
										whereSql += "'" + temps[j] + "'";
										if(j<temps.length-1)
											whereSql += ",";
									}
									whereSql += ") and ";
					    	 }else{//找到下级
					    		  for(int l = 0; l<deptvos.length; l++){
					    			  v.add(deptvos[l]);
					    		  }
					    	 }
							}
							if(v!=null&&v.size()>0){
					    	   String tmp = "";
					    	 	for(int k=0; k<v.size(); k++)
					    	   {
					    	   	  tmp = tmp + "'"+((DeptdocVO)v.get(k)).getPk_deptdoc()+"'";//deptvos[k].getPk_deptdoc()+"'";
					    	   	  if(k<v.size()-1)
					    	   	  {
					    	   	  tmp = tmp + ",";	
					    	   	  }
					    	   }
					    	 	whereSql += "pk_usedept in (";
								String[] temps = getRefUseDept().getRefPKs();
								for(int j=0; j<temps.length; j++){
									whereSql += "'" + temps[j] + "'";
									if(j<temps.length-1)
										whereSql += ",";
								}
								whereSql += ","+tmp+") and ";
					    	 	//whereSql += " and pk_usedept in ('" + condVO.getPk_usedept() + "',"+tmp+" ) ";
							}
							
					    	}catch(Exception e)
							{
					    	  System.out.println("找下级部门发生异常");
							}
					}
				}else{
					try {
						if(CardBO_Client.isControl(getClientEnvironment().getCorporation().getPk_corp(),"bd_deptdoc_物品使用部门")){
						    Vector use_v = new Vector();
						    use_v = CardBO_Client.getControlPks(getClientEnvironment().getCorporation().getPk_corp(),getClientEnvironment().getUser().getPrimaryKey(),"bd_deptdoc_物品使用部门")	;
							if((use_v!=null)&&(use_v.size()>0))
							{
							  String tmp = "";
							  for(int i=0;i<use_v.size();i++)
							  {
							     tmp = tmp + "'"+use_v.get(i).toString().trim()+"'";
							     if(i<use_v.size()-1)
							     {
							     tmp = tmp + ",";	
							     }
							  }
							whereSql += " pk_usedept in ("+tmp+") and ";
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if(getRefType().getRefPKs()!=null&&getRefType().getText()!=null&&getRefType().getText().length()>0){
					Vector v = new Vector();
					TypeVO[] vo = null;
					String[] temp = getRefType().getRefPKs();
					String[] lctypecode = null;
					try{
						for(int i=0; i<temp.length; i++){							
							v.add(TypeBO_Client.findByPrimaryKey(temp[i]));
						}
						vo = new TypeVO[v.size()];
						v.copyInto(vo);
					}catch(Exception e){
						e.printStackTrace();
					}
					lctypecode = new String[vo.length];
					for(int j=0; j<lctypecode.length; j++){
						lctypecode[j] = vo[j].getLctypecode();
					}
//					whereSql += "pk_lctype in (select pk_lctype from lc_type where lctypecode in(select pk_lctype from" +
//							" lc_type where lctypecode like ";
//					for(int i=0; i<lctypecode.length; i++){
//						whereSql += "'" + lctypecode[i] + "%'";
//						if(i<lctypecode.length-1)
//							whereSql += " OR lctypecode like ";
//					}
//					whereSql += ")) and ";
					whereSql += "pk_lctype in (select pk_lctype from lc_type where lctypecode like ";
					for(int i=0; i<lctypecode.length; i++){
						whereSql += "'"+lctypecode[i]+"%'";
						if(i<lctypecode.length-1)
							whereSql += " or lctypecode like ";
					}
					whereSql += ") and ";
				}else{
					//物品类别权限控制
				}
				
				if(getSinglePriceStart().getText()!=null&&getSinglePriceStart().getText().trim().length()>0)
					whereSql += "price=" + getSinglePriceStart().getText().trim() + " and ";
				if(getAmountStart().getText()!=null&&getAmountStart().getText().trim().length()>0)
					whereSql += "number=" + getAmountStart().getText().trim() + " and ";
				
				if((getAddTimePaneStart().getRefName()!=null&&getAddTimePaneStart().getRefName().length()>0)||
						(getAddTimePaneEnd().getRefName()!=null&&getAddTimePaneEnd().getRefName().length()>0)){
					if(getAddTimePaneEnd().getRefName()==null||getAddTimePaneEnd().getRefName().length()<=0)
						whereSql += "adddate>= '" + getAddTimePaneStart().getRefName() + "' and ";
					else if(getAddTimePaneStart().getRefName() == null || getAddTimePaneStart().getRefName().length()<=0)
						whereSql += "adddate<= '" + getAddTimePaneEnd().getRefName() + "' and ";
					else
						whereSql += "adddate>= '" + getAddTimePaneStart().getRefName() + "' and adddate<= '" + getAddTimePaneEnd().getRefName() + "' and ";
				}
				if((getBuyTimePaneStart().getRefName()!=null&&getBuyTimePaneStart().getRefName().length()>0)||
						(getBuyTimePaneEnd().getRefName()!=null&&getBuyTimePaneEnd().getRefName().length()>0)){
					if(getBuyTimePaneEnd().getRefName()==null||getBuyTimePaneEnd().getRefName().length()<=0)
						whereSql += "buydate>= '" + getBuyTimePaneStart().getRefName() + "' and ";
					else if(getBuyTimePaneStart().getRefName() == null || getBuyTimePaneStart().getRefName().length()<=0)
						whereSql += "buydate<= '" + getBuyTimePaneEnd().getRefName() + "' and ";
					else
						whereSql += "buydate>= '" + getBuyTimePaneStart().getRefName() + "' and buydate<= '" + getBuyTimePaneEnd().getRefName() + "' and ";
				}
				if((getDestroyTimePaneStart().getRefName()!=null&&getDestroyTimePaneStart().getRefName().length()>0)||
						(getDestroyTimePaneEnd().getRefName()!=null&&getDestroyTimePaneEnd().getRefName().length()>0)){
					if(getDestroyTimePaneEnd().getRefName()==null||getDestroyTimePaneEnd().getRefName().length()<=0)
						whereSql += "canceldate>= '" + getDestroyTimePaneStart().getRefName() + "' and ";
					else if(getDestroyTimePaneStart().getRefName()==null||getDestroyTimePaneStart().getRefName().length()<=0)
						whereSql += "canceldate<= '" + getDestroyTimePaneEnd().getRefName() + "' and ";
					else
						whereSql += "canceldate>= '" +getDestroyTimePaneStart().getRefName()+"' and canceldate<= ' "+getDestroyTimePaneEnd().getRefName()+"' and ";
				}
				
				if(getRemarkText().getText()!=null&&getRemarkText().getText().length()>0)
					whereSql += "remark like '%" + getRemarkText().getText().trim() + "%' and ";
				
				if((getTotalPriceStart().getText()!=null&&getTotalPriceStart().getText().trim().length()>0)||
						(getTotalPriceEnd().getText()!=null&&getTotalPriceEnd().getText().trim().length()>0)){
					if(getTotalPriceEnd().getText()==null||getTotalPriceEnd().getText().trim().length()<=0)
						whereSql += "(number*price) >="+getTotalPriceStart().getText().trim()+" and ";
					else if(getTotalPriceStart().getText()==null||getTotalPriceStart().getText().trim().length()<=0)
						whereSql += "(number*price) <="+getTotalPriceEnd().getText().trim()+" and ";
					else
						whereSql += "(number*price) between " + getTotalPriceStart().getText().trim() +
									" and " + getTotalPriceEnd().getText().trim() + " and ";
				}
				
				if(getRefUser().getRefPK()!=null&&getRefUser().getRefPK().length()>0)
					whereSql += "a.def1 like '" + getRefUser().getRefPK() + "' and ";
				if(getInputPsn().getText()!=null&getInputPsn().getText().trim().length()>0){
					if(getInputPsn().getRefPK()!=null&&getInputPsn().getRefPK().length()>0)
						whereSql += "a.def3 like '" + getInputPsn().getRefPK() + "' and ";
					else
						try {
							whereSql += "a.def3 like '" + (UserBO_Client.queryUsersByCondition(" user_code like '"+getInputPsn().getText().trim()+"' "))[0].getPrimaryKey() + "' and ";
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
				
				String str = (String) getCbStatus().getSelectedItem();
				if(str!=null&&!str.equals("")){
					if(str.equals("未记账")){
				        whereSql += " (tallyflag='N' or tallyflag is null) and ";
				    }
				    if(str.equals("已记账")){
				        whereSql += " tallyflag='Y' and (cancelflag='N' or cancelflag is null) and ";
				    }
				    if(str.equals("已核销")){
				        whereSql += " cancelflag='Y' and ";
				    }
				}
			}
			if(whereSql.endsWith("and")||whereSql.endsWith("and ")||whereSql.endsWith("and  ")){
				int index = whereSql.lastIndexOf("and");
				char[] temp = new char[index];
				whereSql.getChars(0,index,temp,0);
				whereSql = String.copyValueOf(temp);
				whereSql += " ";
			}
			closeOK();
		}else{
			try {
	        	m_CondVO = new CardVO();
	        	m_CondVO.setPk_managedept(getRefManageDept().getRefPK());
	        	m_CondVO.setPk_usedept(getRefUseDept().getRefPK());
	        	m_CondVO.setPk_lctype(getRefType().getRefPK());
	        	m_CondVO.setPk_corp(getClientEnvironment().getCorporation().getPk_corp());
	        	m_CondVO.setLoginuser(getClientEnvironment().getUser().getPrimaryKey());
	        	Object objCbSelected = getCbStatus().getSelectedItem();
	        	m_CondVO.setM_status((String)objCbSelected);
	        	m_CondVO.setInclusub(getUICheckBox().isSelected());
	        
	        //增加修改的代码
	        	m_CondVO.setRemark(getRemarkText().getText().trim());
	        	Double temp = null;
	        	String str = null;
	        	str = getSinglePriceStart().getText().trim();
	        	if(str!=null&&!str.equals("")){
	        		temp = Double.valueOf(str);
	        		m_CondVO.setPricestart(new UFDouble(temp.doubleValue()));
	        	}
	        	str = getAmountStart().getText().trim();
	        	if(str!=null&&!str.equals("")){
	        		temp = Double.valueOf(str);
	        		m_CondVO.setAmountstart(new UFDouble(temp.doubleValue()));
	        	}
	        
	        	UFDate date = null;
	        	date = new UFDate(getBuyTimePaneStart().getRefName());
	        	m_CondVO.setBuydate(date);
	        	date = new UFDate(getAddTimePaneStart().getRefName());
	        	m_CondVO.setAdddate(date);
	        	date = new UFDate(getDestroyTimePaneStart().getRefName());
	        	m_CondVO.setCanceldate(date);
	        	date = new UFDate(getBuyTimePaneEnd().getRefName());
	        	m_CondVO.setBuyDateEnd(date);
	        	date = new UFDate(getAddTimePaneEnd().getRefName());
	        	m_CondVO.setAddDateEnd(date);
	        	date = new UFDate(getDestroyTimePaneEnd().getRefName());
	        	m_CondVO.setDestroyEnd(date);
	        	m_CondVO.setDef1(getRefUser().getRefPK());
	        	if(getInputPsn().getText()!=null&&getInputPsn().getText().trim().length()>0){
	        		if(getInputPsn().getRefPK()!=null&&getInputPsn().getRefPK().length()>0)
	        			m_CondVO.setDef3(getInputPsn().getRefPK());
	        		else{
	        			UserVO[] uservo = UserBO_Client.queryUsersByCondition(" user_code like '"+getInputPsn().getText().trim()+"' ");
	        			m_CondVO.setDef3(uservo[0].getPrimaryKey());
	        		}
	        	}else
	        		m_CondVO.setDef3(null);
	        	m_CondVO.setTotalpricestart(getTotalPriceStart().getText().trim());
	        	m_CondVO.setTotalpriceend(getTotalPriceEnd().getText().trim());
	        	if(getItemRefPane().getRefCode()!=null&&getItemRefPane().getRefCode().length()>0)
	        		m_CondVO.setLccode(getItemRefPane().getRefCode());
	        	else
	        		m_CondVO.setLccode(getItemRefPane().getText().trim());
	        
	        	closeOK();
	    	} catch (Exception e) {
	        	MessageDialog.showErrorDlg(this,"出错",e.getMessage());
	    	}
		}
	}
	/**
	 * This method initializes UICheckBox	
	 * 	
	 * @return nc.ui.pub.beans.UICheckBox	
	 */    
	private UICheckBox getUICheckBox() {
		if (UICheckBox == null) {
			UICheckBox = new UICheckBox();
			UICheckBox.setBounds(418, 12, 29, 21);
		}
		return UICheckBox;
	}
	
	//修改代码
	private UIRefPane getAddTimePaneStart() {
		if (addTimePaneStart == null) {
			addTimePaneStart = new UIRefPane();
			addTimePaneStart.setRefNodeName("日历");
			addTimePaneStart.setBounds(new java.awt.Rectangle(83,207,149,23));
		}
		return addTimePaneStart;
	}
	private UIRefPane getAddTimePaneEnd(){
		if(addTimePaneEnd == null){
			addTimePaneEnd = new UIRefPane();
			addTimePaneEnd.setRefNodeName("日历");
			addTimePaneEnd.setBounds(new java.awt.Rectangle(284,207,149,23));
		}
		return addTimePaneEnd;
	}
	private UIRefPane getBuyTimePaneStart() {
		if (buyTimePaneStart == null) {
			buyTimePaneStart = new UIRefPane();
			buyTimePaneStart.setRefNodeName("日历");
			buyTimePaneStart.setBounds(new java.awt.Rectangle(83,168,149,23));
		}
		return buyTimePaneStart;
	}
	private UIRefPane getBuyTimePaneEnd() {
		if (buyTimePaneEnd == null) {
			buyTimePaneEnd = new UIRefPane();
			buyTimePaneEnd.setRefNodeName("日历");
			buyTimePaneEnd.setBounds(new java.awt.Rectangle(284,168,149,23));
		}
		return buyTimePaneEnd;
	}
	private UIRefPane getDestroyTimePaneStart() {
		if (destroyPaneStart == null) {
			destroyPaneStart = new UIRefPane();
			destroyPaneStart.setRefNodeName("日历");
			destroyPaneStart.setBounds(new java.awt.Rectangle(83,246,149,23));
		}
		return destroyPaneStart;
	}
	private UIRefPane getDestroyTimePaneEnd(){
		if(this.destroyPaneEnd == null){
			destroyPaneEnd = new UIRefPane();
			destroyPaneEnd.setRefNodeName("日历");
			destroyPaneEnd.setBounds(new java.awt.Rectangle(284,246,149,23));
		}
		return this.destroyPaneEnd;
	}
	private UITextField getSinglePriceStart(){
		if(singlePriceStart == null){
			singlePriceStart = new UITextField();
			singlePriceStart.setBounds(83, 129, 149, 23);
		}
		return singlePriceStart;
	}
	
	private UITextField getAmountStart(){
		if(amountStart == null){
			amountStart = new UITextField();
			amountStart.setBounds(284, 129, 149, 23);
		}
		return amountStart;
	}
	
	private UITextField getRemarkText(){
		if(this.remarkText == null){
			remarkText = new UITextField();
			remarkText.setBounds(83, 285, 350, 23);
		}
		return remarkText;
	}
	private UITextField getTotalPriceStart(){
		if(this.totalPriceStart == null){
			totalPriceStart = new UITextField();
			totalPriceStart.setBounds(83, 324, 149, 23);
			totalPriceStart.setAllowAlphabetic(false);
			totalPriceStart.setAllowNumeric(true);
		}
		return totalPriceStart;
	}
	private UITextField getTotalPriceEnd(){
		if(this.totalPriceEnd == null){
			totalPriceEnd = new UITextField();
			totalPriceEnd.setBounds(284, 324, 149, 23);
			totalPriceEnd.setAllowAlphabetic(false);
			totalPriceEnd.setAllowNumeric(true);
			//totalPriceEnd.addActionListener((ActionListener) this);
			//totalPriceEnd.addKeyListener(this);
		}
		return totalPriceEnd;
	}
	
//	private UIRefPane getRefPsn(){
//		if(this.PsnRef == null){
//			PsnRef = new UIRefPane();
//			PsnRef.setBounds(312, 363, 136, 22);
//			PsnRef.setRefNodeName("人员档案");
//		}
//		return PsnRef;
//	}
	private UIRefPane getRefUser(){
		if(userRef == null){
			userRef = new UIRefPane();
			userRef.setBounds(83, 363, 136, 22);
			userRef.setRefNodeName("人员档案");
			//userRef.addValueChangedListener(this);
		}
		return userRef;
	}
	private UIRefPane getInputPsn(){
		if(inputPsn == null){
			newPane = new UIRefPane();
			inputPsn = new InputPsnRefModel();
			newPane.setRefModel(new InputPsnRefModel());
			newPane.setBounds(312, 363, 136, 22);
			newPane.setAutoCheck(false);
			//newPane.addValueChangedListener(this);
		}
		return newPane;
	}
	public UIRefPane getItemRefPane(){
		if(itemRefPane == null){
			itemRefPane = new MyRefPane();
			itemRefPane.setRefModel(new ItemRefModel());
			itemRefPane.setBounds(83, 90, 136, 22);
			itemRefPane.addValueChangedListener(this);
			itemRefPane.setAutoCheck(false);
			itemRefPane.setMultiSelectedEnabled(true);
		}
		return itemRefPane;
	}

	public String getWhereSql() {
		return whereSql;
	}

	public void valueChanged(ValueChangedEvent event) {
		//if(getItemRefPane().getText()!=null&&getItemRefPane().getText().trim().length()>0)
			//clearOther();
	}
	
//	private void clearOther(){
//		getRefUseDept().setText(null);
//		//getRefUseDept().setSelectedData(null);
//		getRefType().setText(null);
//		getCbStatus().setSelectedIndex(0);
//		getSinglePriceStart().setText(null);
//		getAmountStart().setText(null);
//		getBuyTimePaneStart().setText(null);
//		getBuyTimePaneEnd().setText(null);
//		getAddTimePaneEnd().setText(null);
//		getAddTimePaneStart().setText(null);
//		getDestroyTimePaneStart().setText(null);
//		getDestroyTimePaneEnd().setText(null);
//		getRemarkText().setText(null);
//		getTotalPriceEnd().setText(null);
//		getTotalPriceStart().setText(null);
//		getInputPsn().setText(null);
//		getRefUser().setText(null);
//	}
 }