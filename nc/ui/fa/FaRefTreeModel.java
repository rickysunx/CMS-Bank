package nc.ui.fa;

/**
 * 此处插入类型说明。
 * 创建日期：(2001-8-24 16:14:10)
 * @author：张扬
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
 * DefaultRefTreeModel 构造子注解。
 */
public FaRefTreeModel() {
	super();
}
/**
 * 此处插入方法说明。
 * 创建日期：(2001-8-14 21:14:35)
 * @param refNodeName java.lang.String
 */
public FaRefTreeModel(String refNodeName) {
	setRefNodeName(refNodeName);
}
/**
 * 指示上下级关系－－子字段。
 * 创建日期：(2001-8-11 14:43:58)
 * @return java.lang.String
 */
public String getChildField() {
	return m_strChildField;
}
/**
 * 指示编码规则（2212形式）。如果为空表示采用上下级关系构造树
 
 * @return java.lang.String
 */
public String getCodingRule() {
	return m_strCodingRule;
}
/**
 * 指示末级标志字段。
 * 创建日期：(2001-8-11 14:43:58)
 * @return java.lang.String
 */
public String getEndField() {
	return m_strEndField;
}
/**
 * 指示上下级关系－－父字段。
 * 创建日期：(2001-8-11 14:43:58)
 * @return java.lang.String
 */
public String getFatherField() {
	return m_strFatherField;
}
/**
 * 显示字段列表
 * 创建日期：(01-4-4 0:57:23)
 * @return java.lang.String
 */
public java.lang.String[] getFieldCode() {

  if((getRefNodeName().equals("卡片使用部门"))||(getRefNodeName().equals("物品使用部门"))
  ||(getRefNodeName().equals("物品管理部门"))){
	return new String[]{ "deptcode" , "deptname" , "remcode" , "pk_deptdoc" , "pk_fathedept","def1","def2","def3","def4","def5"};
  }	
  if((getRefNodeName().equals("低值易耗品类别"))){
  		return new String[]{ "lctypecode" , "lctypename","pk_lctype","pk_parent"};
  	  }	
	return m_strFieldCode;
}
/**
 * 显示字段中文名
 * 创建日期：(01-4-4 0:57:23)
 * @return java.lang.String
 */
public java.lang.String[] getFieldName() {
    if ((getRefNodeName().equals("卡片使用部门"))||(getRefNodeName().equals("物品使用部门"))
	||(getRefNodeName().equals("物品管理部门"))){
        return new String[] {
            "部门编码",
            "部门名称",
            "助记码",
            "部门主键",
            "上级部门主键",
            "自定义项1",
            "自定义项2",
            "自定义项3",
            "自定义项4",
            "自定义项5" };
    }
    if ((getRefNodeName().equals("低值易耗品类别"))){
    	        return new String[] {
    	            "类别编码",
    	            "类别名称",
					"类别主键",
					"上级类别主键"};
    	    }
    return m_strFieldName;
}
/**
 * 主键字段名
 * @return java.lang.String
 */
public String getPkFieldCode() {
	return m_strPkFieldCode;
}
/**
 * 参照标题
 * 创建日期：(01-4-4 0:57:23)
 * @return java.lang.String
 */
public String getRefTitle() {
	return m_strRefTitle;
}
/**
 * 参照数据库表或者视图名
 * 创建日期：(01-4-4 0:57:23)
 * @return java.lang.String
 */
public String getTableName() {
	return m_strTableName;
}
/**
 * 指示上下级关系－－子字段。
 * 创建日期：(2001-8-11 14:43:58)
 */
public void setChildField(String strChildField) {
	m_strChildField = strChildField;
}
/**
 * 指示编码规则（2212形式）。如果为空表示采用上下级关系构造树
 */
public void setCodingRule(String strCodingRule) {
    m_strCodingRule = strCodingRule;
}
/**
 * 指示末级标志字段。
 * 创建日期：(2001-8-11 14:43:58)
 */
public void setEndField(String strEndField) {
    m_strEndField = strEndField;
}
/**
 * 指示上下级关系－－父字段。
 * 创建日期：(2001-8-11 14:43:58)
 */
public void setFatherField(String strFatherField) {
	m_strFatherField = strFatherField;
}
/**
 * 此处插入方法说明。
 * 创建日期：(01-3-22 13:22:29)
 * @param newFieldCode java.lang.String[]
 */
public void setFieldCode(java.lang.String[] newFieldCode) {
	getHtCodeIndex().clear();
	m_strFieldCode = newFieldCode;
}
/**
 * 此处插入方法说明。
 * 创建日期：(01-3-22 13:22:29)
 * @param newFieldName java.lang.String[]
 */
public void setFieldName(java.lang.String[] newFieldName) {
	m_strFieldName = newFieldName;
}
/**
 * 主键字段名
 */
public void setPkFieldCode(String strPkFieldCode) {
	m_strPkFieldCode = strPkFieldCode;
}
/**
 * 此处插入方法说明。
 * 创建日期：(2001-8-14 10:23:02)
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
	if (newRefNodeName.equals("公司目录")) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "unitcode", "unitname", "fathercorp" });
		setFieldName(new String[] { "公司编码", "公司名称" });
		setHiddenFieldCode(new String[] { "pk_corp" });
		setPkFieldCode("pk_corp");
		setRefCodeField("unitcode");
		setRefNameField("unitname");
		setTableName("bd_corp");
		setFatherField("fathercorp");
		setChildField("pk_corp");
		setWherePart(" (isseal is null or isseal<>'Y') and ishasaccount='Y' ");
		//
	} else if (newRefNodeName.equals("存货分类")) {
		//*根据需求设置相应参数
		setFieldCode(
			new String[] {
				"invclasscode",
				"invclassname",
				"invclasslev",
				"endflag",
				"pk_invcl" });
		setFieldName(new String[] { "存货编码", "存货名称" });
		setPkFieldCode("pk_invcl");
		setRefCodeField("invclasscode");
		setRefNameField("invclassname");
		setTableName("bd_invcl");
		setCodingRule(nc.ui.bd.ref.UFRefManage.getCodeRuleFromPara("BD101"));
		//sxj 2003-02-20
		setWherePart(" pk_corp='" + getPk_corp() + "' or pk_corp= '" + "0001" + "'");
		//
	} else if (newRefNodeName.equals("地区分类")) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "areaclcode", "areaclname" });
		setFieldName(new String[] { "地区分类编码", "地区分类名称" });
		setHiddenFieldCode(new String[] { "pk_areacl", "pk_fatherarea" });
		setPkFieldCode("pk_areacl");
		setRefCodeField("areaclcode");
		setRefNameField("areaclname");
		setTableName("bd_areacl");
		setFatherField("pk_fatherarea");
		setChildField("pk_areacl");
		//sxj 2003-02-20
		setWherePart(" pk_corp='" + getPk_corp() + "' or pk_corp= '" + "0001" + "'");

	} else if (newRefNodeName.equals("人员类别")) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "psnclasscode", "psnclassname" });
		setFieldName(new String[] { "人员分类编码", "人员分类名称" });
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

	} else if (newRefNodeName.equals("部门档案")||newRefNodeName.equals("卡片使用部门")||newRefNodeName.equals("卡片管理部门")
			||(newRefNodeName.equals("物品使用部门"))||(newRefNodeName.equals("物品管理部门"))) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "deptcode", "deptname","remcode" });
		setFieldName(new String[] { "部门编码", "部门名称" ,"助记码"});
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
		//sxj 2003-06-12 修改树型部门参照Sql 语句的Bug，无法按Canceled<>'Y'过滤。

	} else if (newRefNodeName.equals("会计科目")) {
		setFieldCode(new String[] { "bd_accsubj.subjcode", "bd_accsubj.subjname","bd_accsubj.engsubjname" });
		setFieldName(new String[] { "科目编码", "科目名称","英文名称" });
		setTableName("bd_accsubj INNER JOIN bd_subjtype ON bd_accsubj.pk_subjtype = bd_subjtype.pk_subjtype");

		setHiddenFieldCode(new String[] { "bd_accsubj.pk_accsubj","bd_accsubj.remcode" });
		//对于会计科目，要重新设置主键为ID而不是OID
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
	else if (newRefNodeName.equals("现金流量项目")) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "cfitemcode", "cfitemname" });
		setFieldName(new String[] { "现金流量项目编码", "现金流量项目名称" });
		setHiddenFieldCode(new String[] { "pk_cashflow", "fathernode" });
		setPkFieldCode("pk_cashflow");
		setRefCodeField("cfitemcode");
		setRefNameField("cfitemname");
		setTableName("bd_cashflow");
		setFatherField("fathernode");
		setChildField("pk_cashflow");
		setWherePart(
			" pk_corp='" + getPk_corp() + "' or pk_corp= '0001' or pk_corp is null");
	} else if (newRefNodeName.equals("收发类别")) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "rdcode", "rdname" });
		setFieldName(new String[] { "收发类别编码", "收发类别名称" });
		setHiddenFieldCode(new String[] { "pk_rdcl", "pk_frdcl" });
		setPkFieldCode("pk_rdcl");
		setRefCodeField("rdcode");
		setRefNameField("rdname");
		setTableName("bd_rdcl");
		setFatherField("pk_frdcl");
		setChildField("pk_rdcl");
		setWherePart(
			" pk_corp='" + getPk_corp() + "' or pk_corp= '0001' or pk_corp is null");
	}else if(newRefNodeName.equals("低值易耗品类别")) {
		//*根据需求设置相应参数
		setFieldCode(new String[] { "lctypecode", "lctypename" });
		setFieldName(new String[] { "类别编码", "类别名称" });
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
 * 此处插入方法说明。
 * 创建日期：(2001-8-14 10:23:02)
 * @param nodeName java.lang.String
 */
public void setRefNodeName(String nodeName, String pk_corp) {
	setPk_corp(pk_corp);
	setRefNodeName(nodeName);
}
/**
 * 此处插入方法说明。
 * 创建日期：(01-3-22 13:22:29)
 * @param newRefTitle java.lang.String
 */
public void setRefTitle(java.lang.String newRefTitle) {
	m_strRefTitle = newRefTitle;
}
/**
 * 此处插入方法说明。
 * 创建日期：(01-3-22 13:22:29)
 * @param newTableName java.lang.String
 */
public void setTableName(java.lang.String newTableName) {
	m_strTableName = newTableName;
}
}
