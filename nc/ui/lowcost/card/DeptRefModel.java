/*
 * �������� 2005-9-19
 *
 * @author ����
 */
package nc.ui.lowcost.card;


import nc.ui.bd.ref.DefaultRefTreeModel;

/**
 * @author ����
 *
 */
public class DeptRefModel extends DefaultRefTreeModel {

    /**
     * 
     */
    public DeptRefModel(String pk_corp) {
        super();
    	setRefTitle("���Ų���");
    	setFieldCode(new String[]{"DEPTCODE","DEPTNAME","PK_DEPTDOC","pk_fathedept"});
    	
    	setFieldName(new String[]{"���ű���","��������","����","������"});
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
