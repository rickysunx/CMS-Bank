package nc.ui.lowcost.card;

import java.io.Serializable;

import nc.ui.bd.ref.DefaultRefModel;
import nc.ui.pub.ClientEnvironment;

public class ItemRefModel extends DefaultRefModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 193687307234848507L;

	public ItemRefModel() {
		super();
        setRefTitle("��Ʒ����");
        setFieldCode(new String[] { "lccode", "lcname","pk_lccard"});
        setFieldName(new String[] { "��Ʒ����", "��Ʒ����", "��Ʒ����"});
        //setHiddenFieldCode(new String[] { "pk_lccard" });
        setPkFieldCode("pk_lccard");
        setTableName("lc_card");
        setOrderPart("lccode");
        //setDefaultFieldCount(4);
        setWherePart(" pk_usedept in (select pk_deptdoc from bd_deptdoc where pk_corp='"+ClientEnvironment.getInstance().getCorporation().getPk_corp()+"') ");
	}

	public ItemRefModel(String refNodeName) {
		super(refNodeName);
	}
}
