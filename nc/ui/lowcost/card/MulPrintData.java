/**
 * 
 */
package nc.ui.lowcost.card;

import java.io.Serializable;

import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.bd.b06.PsndocBO_Client;
import nc.ui.lowcost.type.TypeBO_Client;
import nc.ui.pub.print.IDataSource2;
import nc.ui.sm.user.UserBO_Client;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.lowcost.type.TypeVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDouble;

/**
 * @author Administrator
 *
 */
public class MulPrintData implements Serializable, IDataSource2 {
	CardVO cards = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6295982032405456672L;

	/**
	 * 
	 */
	public MulPrintData() {
		super();
	}
	
	public MulPrintData(CardVO vo){
		cards = vo;
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource2#getExpressType(java.lang.String)
	 */
	public int getExpressType(String express) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource2#getLineCount()
	 */
	public int getLineCount() {
		return 9;
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getAllDataItemNames()
	 */
	public String[] getAllDataItemNames() {
		return new String[] {"物品编码", "物品名称", "物品类别", "使用人", "使用部门", "物品状态", "购买时间", "增加时间", "记账时间", 
				"核销时间", "单价", "数量", "金额", "备注", "录入人"};
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getAllDataItemExpress()
	 */
	public String[] getAllDataItemExpress() {
		return new String[] {"wpbm", "wpmc", "type", "user", "dept", "status", "buytime", "addtime", "jztime", "hxtime",
				"price", "amount", "totleprice", "remark", "inputpsn"};
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getDependentItemExpressByExpress(java.lang.String)
	 */
	public String[] getDependentItemExpressByExpress(String itemName) {
		return null;
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getItemValuesByExpress(java.lang.String)
	 */
	public String[] getItemValuesByExpress(String itemExpress) {
		String[] str = new String[1];
		
		if(itemExpress.equals("wpbm"))
			str[0] = cards.getLccode();
		else if(itemExpress.equals("wpmc"))
			str[0] = cards.getLcname();
		else if(itemExpress.equals("type")){
			String typepk = cards.getPk_lctype();
			if(typepk!=null&&typepk.length()>0){
				try {
					TypeVO vo = TypeBO_Client.findByPrimaryKey(typepk);
					str[0] = vo.getLctypename();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if(itemExpress.equals("user")){
			if(cards.getDef1()!=null&&cards.getDef1().length()>0){
				try {
					str[0] = (PsndocBO_Client.findByPrimaryKey(cards.getDef1())).getPsnname();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("dept")){
			if(cards.getPk_usedept()!=null&&cards.getPk_usedept().length()>0){
				try {
					str[0] = (DeptdocBO_Client.findByPrimaryKey(cards.getPk_usedept())).getDeptname();
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		}
		else if(itemExpress.equals("status")){
			if(cards.getTallyflag().equals(new UFBoolean(false))||cards.getTallyflag()==null)
				str[0] = "未记账";
			else{
				if(cards.getCancelflag()==null || cards.getCancelflag().equals(new UFBoolean(false))){
	                str[0] = "已记帐";
	            } else {
	                str[0] = "已核销";
	            }
			}
		}
			//str[0] = cards.getStatus();
		else if(itemExpress.equals("buytime")){
			if(cards.getBuydate()!=null&&cards.getBuydate().toString().length()>0)		
				str[0] = cards.getBuydate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("addtime"))
			str[0] = cards.getAdddate().toString();
		else if(itemExpress.equals("jztime")){
			if(cards.getTallydate()!=null&cards.getTallydate().toString().length()>0)
				str[0] = cards.getTallydate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("hxtime")){
			if(cards.getCanceldate()!=null&&cards.getCanceldate().toString().length()>0)
				str[0] = cards.getCanceldate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("price")){
			//str[0] = cards.getPrice().toString();
			UFDouble temp = cards.getPrice();
			str[0] = NumFormate.getPrecisionData((Object)temp,2).trim();
		}
		else if(itemExpress.equals("amount")){
			//str[0] = cards.getNumber().toString();
			UFDouble temp = cards.getNumber();
			str[0] = NumFormate.getPrecisionData(temp, 0).trim();
		}
		else if(itemExpress.equals("totleprice")){
			//str[0] = Double.toString(cards.getNumber().doubleValue() * cards.getPrice().doubleValue());
			double temp = cards.getNumber().doubleValue() * cards.getPrice().doubleValue();
			str[0] = NumFormate.getPrecisionData(new UFDouble(temp), 2).trim();
		}
		else if(itemExpress.equals("remark")){
			if(cards.getRemark()!=null&&cards.getRemark().length()>0)
				str[0] = cards.getRemark();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("inputpsn")){
			if(cards.psn!=null&&cards.psn.length()>0){
				try {
					str[0] = (UserBO_Client.findUserByPrimaryKey(cards.psn)).getUserName();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			//str[0] = cards.psn;
		}		
		return str;
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getModuleName()
	 */
	public String getModuleName() {
		return "209002";
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#isNumber(java.lang.String)
	 */
	public boolean isNumber(String itemExpress) {
		return (itemExpress.equals("price")||itemExpress.equals("totleprice")||itemExpress.equals("amount"));
	}

}
