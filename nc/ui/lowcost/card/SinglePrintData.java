/**
 * 
 */
package nc.ui.lowcost.card;

import java.io.Serializable;

import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.pub.lang.UFDouble;


/**
 * @author Administrator
 *
 */
public class SinglePrintData implements Serializable, nc.ui.pub.print.IDataSource {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5434623334818177744L;

	private CardVO[] vo = null;
	/**
	 * 
	 */
	public SinglePrintData(CardVO[] vo) {
		super();
		this.vo=vo;
	}
	
	public SinglePrintData(){
		super();
	}

	public String[] getAllDataItemNames() {
		return new String[] {"物品编码", "物品名称", "物品类别", "使用人", "使用部门", "物品状态", "购买时间", "增加时间", "记账时间", 
				"核销时间", "单价", "数量", "金额", "备注", "录入人"};
	}

	public String[] getAllDataItemExpress() {
		return new String[] {"wpbm", "wpmc", "type", "user", "dept", "status", "buytime", "addtime", "jztime", "hxtime",
				"price", "amount", "totleprice", "remark", "inputpsn"};
	}

	public String[] getDependentItemExpressByExpress(String itemName) {
		return null;
	}

	public String[] getItemValuesByExpress(String itemExpress) {
		String[] str = new String[vo.length];
		for(int i = 0; i < str.length; i++){
			if(itemExpress.equals("wpbm"))
				str[i] = vo[i].getLccode();
			else if(itemExpress.equals("wpmc"))
				str[i] = vo[i].getLcname();
			else if(itemExpress.equals("type"))
				str[i] = vo[i].getType();
			else if(itemExpress.equals("user")){
				if(vo[i].getUser()!=null&&vo[i].getUser().length()>0)
					str[i] = vo[i].getUser();
				else
					str[i] = " ";
			}
			else if(itemExpress.equals("dept"))
				str[i] = vo[i].dep;
			else if(itemExpress.equals("status"))
				str[i] = vo[i].getM_status();
			else if(itemExpress.equals("buytime")){
				if(vo[i].getBuydate()!=null&&vo[i].getBuydate().toString().length()>0)
					str[i] = vo[i].getBuydate().toString();
				else
					str[i] = " ";
			}
			else if(itemExpress.equals("addtime"))
				str[i] = vo[i].getAdddate().toString();
			else if(itemExpress.equals("jztime")){
				if(vo[i].getTallydate()!=null&&vo[i].getTallydate().toString().length()>0)
					str[i] = vo[i].getTallydate().toString();
				else
					str[i] = " ";
			}
			else if(itemExpress.equals("hxtime")){
				if(vo[i].getCanceldate()!=null&&vo[i].getCanceldate().toString().length()>0)
					str[i] = vo[i].getCanceldate().toString();
				else
					str[i] = " ";
			}
			else if(itemExpress.equals("price")){
				UFDouble temp = vo[i].getPrice();
				str[i] = NumFormate.getPrecisionData((Object)temp,2).trim();
			}
			else if(itemExpress.equals("amount")){
				UFDouble temp = vo[i].getNumber();
				str[i] = NumFormate.getPrecisionData(temp, 0).trim();
			}
			else if(itemExpress.equals("totleprice")){
				double temp = vo[i].getNumber().doubleValue() * vo[i].getPrice().doubleValue();
				str[i] = NumFormate.getPrecisionData(new UFDouble(temp), 2).trim();
			}
			else if(itemExpress.equals("remark")){
				if(vo[i].getRemark()!=null&&vo[i].getRemark().length()>0)
					str[i] = vo[i].getRemark();
				else
					str[i] = " ";
			}
			else if(itemExpress.equals("inputpsn"))
				str[i] = vo[i].psn;
		}
		return str;
	}

	public String getModuleName() {
		return "209002";
	}

	public boolean isNumber(String itemExpress) {
		return (itemExpress.equals("price")||itemExpress.equals("totleprice")||itemExpress.equals("amount"));
	}

}
