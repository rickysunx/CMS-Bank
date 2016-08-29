package nc.ui.fa;

/**
 * �˴���������˵����
 * �������ڣ�(2001-8-24 16:14:10)
 * @author������
 */
public class FaRefTreeModel extends nc.ui.bd.ref.AbstractRefTreeModel {
	private String m_strChildField = null;
	private String m_strCodingRule = null;
	private String m_strEndField = null;
	private String m_strFatherField = null;
	private String[] m_strFieldCode = null;
	private String[] m_strFieldName = null;
	private String m_strPkFieldCode = null;
	private String m_strRefTitle = null;
	private String m_strTableName = null;
	//


/**
 * DefaultRefTreeModel ������ע�⡣
 */
public FaRefTreeModel() {
	super();
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(2001-8-14 21:14:35)
 * @param refNodeName java.lang.String
 */
public FaRefTreeModel(String refNodeName) {
	setRefNodeName(refNodeName);
}
/**
 * ָʾ���¼���ϵ�������ֶΡ�
 * �������ڣ�(2001-8-11 14:43:58)
 * @return java.lang.String
 */
public String getChildField() {
	return m_strChildField;
}
/**
 * ָʾ�������2212��ʽ�������Ϊ�ձ�ʾ�������¼���ϵ������
 
 * @return java.lang.String
 */
public String getCodingRule() {
	return m_strCodingRule;
}
/**
 * ָʾĩ����־�ֶΡ�
 * �������ڣ�(2001-8-11 14:43:58)
 * @return java.lang.String
 */
public String getEndField() {
	return m_strEndField;
}
/**
 * ָʾ���¼���ϵ�������ֶΡ�
 * �������ڣ�(2001-8-11 14:43:58)
 * @return java.lang.String
 */
public String getFatherField() {
	return m_strFatherField;
}
/**
 * ��ʾ�ֶ��б�
 * �������ڣ�(01-4-4 0:57:23)
 * @return java.lang.String
 */
public java.lang.String[] getFieldCode() {

  if((getRefNodeName().equals("��Ƭʹ�ò���"))||(getRefNodeName().equals("��Ʒʹ�ò���"))
  ||(getRefNodeName().equals("��Ʒ������"))){
	return new String[]{ "deptcode" , "deptname" , "remcode" , "pk_deptdoc" , "pk_fathedept","def1","def2","def3","def4","def5"};
  }	
  if((getRefNodeName().equals("��ֵ�׺�Ʒ���"))){
  		return new String[]{ "lctypecode" , "lctypename","pk_lctype","pk_parent"};
  	  }	
	return m_strFieldCode;
}
/**
 * ��ʾ�ֶ�������
 * �������ڣ�(01-4-4 0:57:23)
 * @return java.lang.String
 */
public java.lang.String[] getFieldName() {
    if ((getRefNodeName().equals("��Ƭʹ�ò���"))||(getRefNodeName().equals("��Ʒʹ�ò���"))
	||(getRefNodeName().equals("��Ʒ������"))){
        return new String[] {
            "���ű���",
            "��������",
            "������",
            "��������",
            "�ϼ���������",
            "�Զ�����1",
            "�Զ�����2",
            "�Զ�����3",
            "�Զ�����4",
            "�Զ�����5" };
    }
    if ((getRefNodeName().equals("��ֵ�׺�Ʒ���"))){
    	        return new String[] {
    	            "������",
    	            "�������",
					"�������",
					"�ϼ��������"};
    	    }
    return m_strFieldName;
}
/**
 * �����ֶ���
 * @return java.lang.String
 */
public String getPkFieldCode() {
	return m_strPkFieldCode;
}
/**
 * ���ձ���
 * �������ڣ�(01-4-4 0:57:23)
 * @return java.lang.String
 */
public String getRefTitle() {
	return m_strRefTitle;
}
/**
 * �������ݿ�������ͼ��
 * �������ڣ�(01-4-4 0:57:23)
 * @return java.lang.String
 */
public String getTableName() {
	return m_strTableName;
}
/**
 * ָʾ���¼���ϵ�������ֶΡ�
 * �������ڣ�(2001-8-11 14:43:58)
 */
public void setChildField(String strChildField) {
	m_strChildField = strChildField;
}
/**
 * ָʾ�������2212��ʽ�������Ϊ�ձ�ʾ�������¼���ϵ������
 */
public void setCodingRule(String strCodingRule) {
    m_strCodingRule = strCodingRule;
}
/**
 * ָʾĩ����־�ֶΡ�
 * �������ڣ�(2001-8-11 14:43:58)
 */
public void setEndField(String strEndField) {
    m_strEndField = strEndField;
}
/**
 * ָʾ���¼���ϵ�������ֶΡ�
 * �������ڣ�(2001-8-11 14:43:58)
 */
public void setFatherField(String strFatherField) {
	m_strFatherField = strFatherField;
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(01-3-22 13:22:29)
 * @param newFieldCode java.lang.String[]
 */
public void setFieldCode(java.lang.String[] newFieldCode) {
	getHtCodeIndex().clear();
	m_strFieldCode = newFieldCode;
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(01-3-22 13:22:29)
 * @param newFieldName java.lang.String[]
 */
public void setFieldName(java.lang.String[] newFieldName) {
	m_strFieldName = newFieldName;
}
/**
 * �����ֶ���
 */
public void setPkFieldCode(String strPkFieldCode) {
	m_strPkFieldCode = strPkFieldCode;
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(2001-8-14 10:23:02)
 * @param newRefNodeName java.lang.String
 */
public void setRefNodeName(String newRefNodeName) {
	newRefNodeName = nc.ui.pub.langset.ISNConvert.big5ToGb(newRefNodeName);
	super.setRefNodeName(newRefNodeName);
	if (newRefNodeName == null || newRefNodeName.trim().length() == 0)
		return;
	clearModelData();
	setFieldName(null);
	setRefTitle(newRefNodeName);
	setRootName(newRefNodeName);
	if (newRefNodeName.equals("��˾Ŀ¼")) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "unitcode", "unitname", "fathercorp" });
		setFieldName(new String[] { "��˾����", "��˾����" });
		setHiddenFieldCode(new String[] { "pk_corp" });
		setPkFieldCode("pk_corp");
		setRefCodeField("unitcode");
		setRefNameField("unitname");
		setTableName("bd_corp");
		setFatherField("fathercorp");
		setChildField("pk_corp");
		setWherePart(" (isseal is null or isseal<>'Y') and ishasaccount='Y' ");
		//
	} else if (newRefNodeName.equals("�������")) {
		//*��������������Ӧ����
		setFieldCode(
			new String[] {
				"invclasscode",
				"invclassname",
				"invclasslev",
				"endflag",
				"pk_invcl" });
		setFieldName(new String[] { "�������", "�������" });
		setPkFieldCode("pk_invcl");
		setRefCodeField("invclasscode");
		setRefNameField("invclassname");
		setTableName("bd_invcl");
		setCodingRule(nc.ui.bd.ref.UFRefManage.getCodeRuleFromPara("BD101"));
		//sxj 2003-02-20
		setWherePart(" pk_corp='" + getPk_corp() + "' or pk_corp= '" + "0001" + "'");
		//
	} else if (newRefNodeName.equals("��������")) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "areaclcode", "areaclname" });
		setFieldName(new String[] { "�����������", "������������" });
		setHiddenFieldCode(new String[] { "pk_areacl", "pk_fatherarea" });
		setPkFieldCode("pk_areacl");
		setRefCodeField("areaclcode");
		setRefNameField("areaclname");
		setTableName("bd_areacl");
		setFatherField("pk_fatherarea");
		setChildField("pk_areacl");
		//sxj 2003-02-20
		setWherePart(" pk_corp='" + getPk_corp() + "' or pk_corp= '" + "0001" + "'");

	} else if (newRefNodeName.equals("��Ա���")) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "psnclasscode", "psnclassname" });
		setFieldName(new String[] { "��Ա�������", "��Ա��������" });
		setHiddenFieldCode(new String[] { "pk_psncl", "pk_psncl1" });
		setPkFieldCode("pk_psncl");
		setRefCodeField("psnclasscode");
		setRefNameField("psnclassname");
		setTableName("bd_psncl");
		setFatherField("pk_psncl1");
		setChildField("pk_psncl");
		setWherePart(
			" pk_corp='"
				+ getPk_corp()
				+ "' or pk_corp= '"
				+ "0001"
				+ "' or pk_corp is null");

	} else if (newRefNodeName.equals("���ŵ���")||newRefNodeName.equals("��Ƭʹ�ò���")||newRefNodeName.equals("��Ƭ������")
			||(newRefNodeName.equals("��Ʒʹ�ò���"))||(newRefNodeName.equals("��Ʒ������"))) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "deptcode", "deptname","remcode" });
		setFieldName(new String[] { "���ű���", "��������" ,"������"});
		setHiddenFieldCode(new String[] { "pk_deptdoc", "pk_fathedept" });
		setPkFieldCode("pk_deptdoc");
		setRefCodeField("deptcode");
		setRefNameField("deptname");
		setTableName("bd_deptdoc");
		setFatherField("pk_fathedept");
		setChildField("pk_deptdoc");
		setWherePart(
			"( pk_corp='"
				+ getPk_corp()
				+ "' or pk_corp= '"
				+ "0001"
				+ "' or pk_corp is null) and canceled <>'Y'");
		//sxj 2003-06-12 �޸����Ͳ��Ų���Sql ����Bug���޷���Canceled<>'Y'���ˡ�

	} else if (newRefNodeName.equals("��ƿ�Ŀ")) {
		setFieldCode(new String[] { "bd_accsubj.subjcode", "bd_accsubj.subjname","bd_accsubj.engsubjname" });
		setFieldName(new String[] { "��Ŀ����", "��Ŀ����","Ӣ������" });
		setTableName("bd_accsubj INNER JOIN bd_subjtype ON bd_accsubj.pk_subjtype = bd_subjtype.pk_subjtype");

		setHiddenFieldCode(new String[] { "bd_accsubj.pk_accsubj","bd_accsubj.remcode" });
		//���ڻ�ƿ�Ŀ��Ҫ������������ΪID������OID
		setPkFieldCode("bd_accsubj.pk_accsubj");
		setWherePart(
			" bd_accsubj.pk_corp='" + getPk_corp() + "' and sealflag is null ");
		setDefaultFieldCount(3);
		setCodingRule(nc.ui.bd.ref.UFRefManage.getCodeRuleFromPara("BD601"));
		setBlurFields(new String[]{"bd_accsubj.subjcode",
				"bd_accsubj.subjname",
				"bd_accsubj.remcode"});
		//setMnecode(new String[]{"bd_accsubj.remcode"}); //sxj add
	} //sxj 2003-02-25
	else if (newRefNodeName.equals("�ֽ�������Ŀ")) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "cfitemcode", "cfitemname" });
		setFieldName(new String[] { "�ֽ�������Ŀ����", "�ֽ�������Ŀ����" });
		setHiddenFieldCode(new String[] { "pk_cashflow", "fathernode" });
		setPkFieldCode("pk_cashflow");
		setRefCodeField("cfitemcode");
		setRefNameField("cfitemname");
		setTableName("bd_cashflow");
		setFatherField("fathernode");
		setChildField("pk_cashflow");
		setWherePart(
			" pk_corp='" + getPk_corp() + "' or pk_corp= '0001' or pk_corp is null");
	} else if (newRefNodeName.equals("�շ����")) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "rdcode", "rdname" });
		setFieldName(new String[] { "�շ�������", "�շ��������" });
		setHiddenFieldCode(new String[] { "pk_rdcl", "pk_frdcl" });
		setPkFieldCode("pk_rdcl");
		setRefCodeField("rdcode");
		setRefNameField("rdname");
		setTableName("bd_rdcl");
		setFatherField("pk_frdcl");
		setChildField("pk_rdcl");
		setWherePart(
			" pk_corp='" + getPk_corp() + "' or pk_corp= '0001' or pk_corp is null");
	}else if(newRefNodeName.equals("��ֵ�׺�Ʒ���")) {
		//*��������������Ӧ����
		setFieldCode(new String[] { "lctypecode", "lctypename" });
		setFieldName(new String[] { "������", "�������" });
		setHiddenFieldCode(new String[] {"pk_lctype", "pk_parent" });
		setPkFieldCode("pk_lctype");
		setRefCodeField("lctypecode");
		setRefNameField("lctypename");
		setTableName("lc_type");
		setFatherField("pk_parent");
		setChildField("pk_lctype");
		setWherePart(
			" 1=1 ");
	} 

}
/**
 * �˴����뷽��˵����
 * �������ڣ�(2001-8-14 10:23:02)
 * @param nodeName java.lang.String
 */
public void setRefNodeName(String nodeName, String pk_corp) {
	setPk_corp(pk_corp);
	setRefNodeName(nodeName);
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(01-3-22 13:22:29)
 * @param newRefTitle java.lang.String
 */
public void setRefTitle(java.lang.String newRefTitle) {
	m_strRefTitle = newRefTitle;
}
/**
 * �˴����뷽��˵����
 * �������ڣ�(01-3-22 13:22:29)
 * @param newTableName java.lang.String
 */
public void setTableName(java.lang.String newTableName) {
	m_strTableName = newTableName;
}
}
