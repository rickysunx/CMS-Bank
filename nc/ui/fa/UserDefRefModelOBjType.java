/*
 * Created on 2006-4-26
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package nc.ui.fa;

/**
 * @author Administrator
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UserDefRefModelOBjType extends FaRefTreeModel {
	private String m_sPk_corp = null;
    
	private boolean m_isUseDept=true;

	private boolean m_bSealShow=true;

/**
 * DeptdocRefModel ������ע�⡣
 */
public UserDefRefModelOBjType() {
	super();

	setRefNodeName(getRefNodeName());
}

public UserDefRefModelOBjType(String spk_corp) {
	super();
	m_sPk_corp = spk_corp;
	setRefNodeName(getRefNodeName());
}
/**
 * DeptdocRefModel ������ע�⡣
 */

/**
 * �˴����뷽��˵����
 * �������ڣ�(2004-02-11 10:42:11)
 * @return java.lang.String
 */
public java.lang.String getM_sPk_corp() {
	return m_sPk_corp;
}
	public String[] getMnecodes(){
	  return new String[]{"remcode"};
	}
	public String getPk_corp() {
	  return 	m_sPk_corp;
	}
/**
 * �����ֶ���
 * @return java.lang.String
 */
public String getPkFieldCode() {
    return "pk_lctype ";
}
public java.lang.String getRefNodeName() {
	
	  return "��ֵ�׺�Ʒ���";	
	
	
}
/**
 * ���ձ���
 * �������ڣ�(01-4-4 0:57:23)
 * @return java.lang.String
 */
public String getRefTitle() {
    return "��ֵ�׺�Ʒ������";
}
/**
 * �������ݿ�������ͼ��
 * �������ڣ�(01-4-4 0:57:23)
 * @return java.lang.String
 */
public String getTableName() {
    return "lc_type";
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(2002-7-2 13:41:48)
 * @author���ܺ���
 */
public String getWherePart() {
   return " 1=1 ";
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(2004-02-11 10:42:11)
 * @param newM_sPk_corp java.lang.String
 */
public void setM_sPk_corp(java.lang.String newM_sPk_corp) {
	m_sPk_corp = newM_sPk_corp;
}
	public void setSealedDataShow(boolean b){
	  m_bSealShow=b;	
	}
}
