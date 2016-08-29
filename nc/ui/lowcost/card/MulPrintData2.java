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
public class MulPrintData2 implements IDataSource2, Serializable {
	CardVO[] cards = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7170234378536151659L;

	/**
	 * 
	 */
	public MulPrintData2() {
		super();
	}
	public MulPrintData2(CardVO[] vos){
		cards = vos;
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
		return 19;
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getAllDataItemNames()
	 */
	public String[] getAllDataItemNames() {
		return new String[] {"物品编码", "物品名称", "物品类别", "使用人", "使用部门", "物品状态", "购买时间", "增加时间", "记账时间", 
				"核销时间", "单价", "数量", "金额", "备注", "录入人",
				"物品编码1", "物品名称1", "物品类别1", "使用人1", "使用部门1", "物品状态1", "购买时间1", "增加时间1", "记账时间1", 
				"核销时间1", "单价1", "数量1", "金额1", "备注1", "录入人1"};
	}

	/* (non-Javadoc)
	 * @see nc.ui.pub.print.IDataSource#getAllDataItemExpress()
	 */
	public String[] getAllDataItemExpress() {
		return new String[] {"wpbm", "wpmc", "type", "user", "dept", "status", "buytime", "addtime", "jztime", "hxtime",
				"price", "amount", "totleprice", "remark", "inputpsn",
				"wpbm1", "wpmc1", "type1", "user1", "dept1", "status1", "buytime1", "addtime1", "jztime1", "hxtime1",
				"price1", "amount1", "totleprice1", "remark1", "inputpsn1"};
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
			if(cards[0].getLccode()!=null)
				str[0] = cards[0].getLccode();
			else
				str[0] = " ";
		else if(itemExpress.equals("wpmc"))
			if(cards[0].getLcname()!=null)
				str[0] = cards[0].getLcname();
			else
				str[0] = " ";
		else if(itemExpress.equals("type")){
			String typepk = cards[0].getPk_lctype();
			if(typepk!=null&&typepk.length()>0){
				try {
					TypeVO vo = TypeBO_Client.findByPrimaryKey(typepk);
					str[0] = vo.getLctypename();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("user")){
			if(cards[0].getDef1()!=null&&cards[0].getDef1().length()>0){
				try {
					str[0] = (PsndocBO_Client.findByPrimaryKey(cards[0].getDef1())).getPsnname();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("dept")){
			if(cards[0].getPk_usedept()!=null&&cards[0].getPk_usedept().length()>0){
				try {
					str[0] = (DeptdocBO_Client.findByPrimaryKey(cards[0].getPk_usedept())).getDeptname();
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("status")){
			if(cards[0].getTallyflag().equals(new UFBoolean(false))||cards[0].getTallyflag()==null)
				str[0] = "未记账";
			else{
				if(cards[0].getCancelflag()==null || cards[0].getCancelflag().equals(new UFBoolean(false))){
	                str[0] = "已记帐";
	            } else {
	                str[0] = "已核销";
	            }
			}
		}
			//str[0] = cards[0].getStatus();
		else if(itemExpress.equals("buytime")){
			if(cards[0].getBuydate()!=null&&cards[0].getBuydate().toString().length()>0)		
				str[0] = cards[0].getBuydate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("addtime"))
			if(cards[0].getAdddate()!=null)
				str[0] = cards[0].getAdddate().toString();
			else
				str[0] = " ";
		else if(itemExpress.equals("jztime")){
			if(cards[0].getTallydate()!=null&&cards[0].getTallydate().toString().length()>0)
				str[0] = cards[0].getTallydate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("hxtime")){
			if(cards[0].getCanceldate()!=null&&cards[0].getCanceldate().toString().length()>0)
				str[0] = cards[0].getCanceldate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("price")){
			//str[0] = cards[0].getPrice().toString();
			if(cards[0].getPrice()!=null){
				UFDouble temp = cards[0].getPrice();
				str[0] = NumFormate.getPrecisionData((Object)temp,2).trim();
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("amount")){
			//str[0] = cards[0].getNumber().toString();
			if(cards[0].getNumber()!=null){
				UFDouble temp = cards[0].getNumber();
				str[0] = NumFormate.getPrecisionData(temp, 0).trim();
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("totleprice")){
			//str[0] = Double.toString(cards[0].getNumber().doubleValue() * cards[0].getPrice().doubleValue());
			if(cards[0].getNumber()!=null&&cards[0].getPrice()!=null){
				double temp = cards[0].getNumber().doubleValue() * cards[0].getPrice().doubleValue();
				str[0] = NumFormate.getPrecisionData(new UFDouble(temp), 2).trim();
			}else{
				str[0] = " ";
			}
		}
		else if(itemExpress.equals("remark")){
			if(cards[0].getRemark()!=null&&cards[0].getRemark().length()>0)
				str[0] = cards[0].getRemark();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("inputpsn")){
			if(cards[0].psn!=null&&cards[0].psn.length()>0){
				try {
					str[0] = (UserBO_Client.findUserByPrimaryKey(cards[0].psn)).getUserName();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}else{
				str[0] = " ";
			}
		}
		
		if(itemExpress.equals("wpbm1"))
			if(cards[1].getLccode()!=null)
				str[0] = cards[1].getLccode();
			else
				str[0] = " ";
		else if(itemExpress.equals("wpmc1"))
			if(cards[1].getLcname()!=null)
				str[0] = cards[1].getLcname();
			else
				str[0] = " ";
		else if(itemExpress.equals("type1")){
			String typepk = cards[1].getPk_lctype();
			if(typepk!=null&&typepk.length()>0){
				try {
					TypeVO vo = TypeBO_Client.findByPrimaryKey(typepk);
					str[0] = vo.getLctypename();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("user1")){
			if(cards[1].getDef1()!=null&&cards[1].getDef1().length()>0){
				try {
					str[0] = (PsndocBO_Client.findByPrimaryKey(cards[1].getDef1())).getPsnname();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("dept1")){
			if(cards[1].getPk_usedept()!=null&&cards[1].getPk_usedept().length()>0){
				try {
					str[0] = (DeptdocBO_Client.findByPrimaryKey(cards[1].getPk_usedept())).getDeptname();
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("status1")){
			if(cards[1].getTallyflag()!=null){
			if(cards[1].getTallyflag().equals(new UFBoolean(false)))
				str[0] = "未记账";
			else{
				if(cards[1].getCancelflag()!=null){
				if(cards[1].getCancelflag().equals(new UFBoolean(false))){
	                str[0] = "已记帐";
	            } else {
	                str[0] = "已核销";
	            }
			}else
				str[0] = " ";
			}
			}else
				str[0] = " ";
		}
			//str[0] = cards[1].getStatus();
		else if(itemExpress.equals("buytime1")){
			if(cards[1].getBuydate()!=null&&cards[1].getBuydate().toString().length()>0)		
				str[0] = cards[1].getBuydate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("addtime1"))
			if(cards[1].getAdddate()!=null)
				str[0] = cards[1].getAdddate().toString();
			else
				str[0] = " ";
		else if(itemExpress.equals("jztime1")){
			if(cards[1].getTallydate()!=null&&cards[1].getTallydate().toString().length()>0)
				str[0] = cards[1].getTallydate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("hxtime1")){
			if(cards[1].getCanceldate()!=null&&cards[1].getCanceldate().toString().length()>0)
				str[0] = cards[1].getCanceldate().toString();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("price1")){
			//str[0] = cards[1].getPrice().toString();
			if(cards[1].getPrice()!=null){
				UFDouble temp = cards[1].getPrice();
				str[0] = NumFormate.getPrecisionData((Object)temp,2).trim();
			}else
				str[0] = " ";
		}
		else if(itemExpress.equals("amount1")){
			//str[0] = cards[1].getNumber().toString();
			if(cards[1].getNumber()!=null){
				UFDouble temp = cards[1].getNumber();
				str[0] = NumFormate.getPrecisionData(temp, 0).trim();
			}else{
				str[0] = " ";
			}
		}
		else if(itemExpress.equals("totleprice1")){
			//str[0] = Double.toString(cards[1].getNumber().doubleValue() * cards[1].getPrice().doubleValue());
			if(cards[1].getNumber()!=null&&cards[1].getPrice()!=null){
				double temp = cards[1].getNumber().doubleValue() * cards[1].getPrice().doubleValue();
				str[0] = NumFormate.getPrecisionData(new UFDouble(temp), 2).trim();
			}else{
				str[0] = " ";
			}
		}
		else if(itemExpress.equals("remark1")){
			if(cards[1].getRemark()!=null&&cards[1].getRemark().length()>0)
				str[0] = cards[1].getRemark();
			else
				str[0] = " ";
		}
		else if(itemExpress.equals("inputpsn1")){
			if(cards[1].psn!=null&&cards[1].psn.length()>0){
				try {
					str[0] = (UserBO_Client.findUserByPrimaryKey(cards[1].psn)).getUserName();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}else
				str[0] = " ";
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
		return (itemExpress.equals("price")||itemExpress.equals("totleprice")||itemExpress.equals("amount")
				||itemExpress.equals("price1")||itemExpress.equals("totleprice1")||itemExpress.equals("amount1"));
	}

}
