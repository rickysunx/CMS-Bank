/*
 * �������� 2005-9-19
 *
 * @author ����
 */
package nc.ui.lowcost.card;


import nc.ui.bd.ref.*;

/**
 * @author ����
 *
 */
public class LcTypeRefModel extends DefaultRefTreeModel {

    /**
     * 
     */
    public LcTypeRefModel() {
        super();
        // TODO �Զ����ɹ��캯�����
    	setRefTitle("��Ʒ������");
    	setFieldCode(new String[]{"lctypecode","lctypename","pk_lctype","pk_parent"});
    	
    	setFieldName(new String[]{"������","�������","����","������"});
    	setPkFieldCode("pk_lctype");
    	setTableName("lc_type");
    	setOrderPart("lctypecode"); 
    	setFatherField("pk_parent");
    	setNotLeafSelectedEnabled(false);
    }

    /**
     * @param refNodeName
     */
    public LcTypeRefModel(String refNodeName) {
        super(refNodeName);
        // TODO �Զ����ɹ��캯�����
    }

}
