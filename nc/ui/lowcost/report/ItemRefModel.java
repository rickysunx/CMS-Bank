package nc.ui.lowcost.report;

import java.io.Serializable;

import nc.ui.bd.ref.DefaultRefModel;
import nc.ui.pub.ClientEnvironment;

public class ItemRefModel extends DefaultRefModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 193687307234848507L;
	private String pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
	public ItemRefModel() {
		super();
        setRefTitle("物品参照");
        setFieldCode(new String[] { "lccode", "lcname","pk_lccard"});
        setFieldName(new String[] { "物品编码", "物品名称", "物品主键"});
        //setHiddenFieldCode(new String[] { "pk_lccard" });
        setPkFieldCode("pk_lccard");
        setTableName("lc_card");
        setOrderPart("lccode");
        //setDefaultFieldCount(4);
        setWherePart(" pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp='" + pk_corp + "') ");
	}

	public ItemRefModel(String refNodeName) {
		super(refNodeName);
	}

	public void setPkCorp(String pk_corp){
		this.pk_corp = pk_corp;
	}
}
