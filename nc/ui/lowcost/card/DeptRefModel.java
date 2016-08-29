/*
 * 创建日期 2005-9-19
 *
 * @author 孙锐
 */
package nc.ui.lowcost.card;


import nc.ui.bd.ref.DefaultRefTreeModel;

/**
 * @author 孙锐
 *
 */
public class DeptRefModel extends DefaultRefTreeModel {

    /**
     * 
     */
    public DeptRefModel(String pk_corp) {
        super();
    	setRefTitle("部门参照");
    	setFieldCode(new String[]{"DEPTCODE","DEPTNAME","PK_DEPTDOC","pk_fathedept"});
    	
    	setFieldName(new String[]{"部门编码","部门名称","主键","父主键"});
    	setPkFieldCode("PK_DEPTDOC");
    	setTableName("bd_deptdoc");
    	setFatherField("pk_fathedept");
    	setOrderPart("DEPTCODE");  
    	setWherePart(" pk_corp='" + pk_corp + "' ");
    }

    /**
     * @param refNodeName
     */


}
