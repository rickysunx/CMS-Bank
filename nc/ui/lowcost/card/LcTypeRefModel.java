/*
 * 创建日期 2005-9-19
 *
 * @author 孙锐
 */
package nc.ui.lowcost.card;


import nc.ui.bd.ref.*;

/**
 * @author 孙锐
 *
 */
public class LcTypeRefModel extends DefaultRefTreeModel {

    /**
     * 
     */
    public LcTypeRefModel() {
        super();
        // TODO 自动生成构造函数存根
    	setRefTitle("物品类别参照");
    	setFieldCode(new String[]{"lctypecode","lctypename","pk_lctype","pk_parent"});
    	
    	setFieldName(new String[]{"类别编码","类别名称","主键","父主键"});
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
        // TODO 自动生成构造函数存根
    }

}
