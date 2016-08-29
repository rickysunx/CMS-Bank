package nc.ui.lowcost.trans;

/**
 * �˴���������˵����
 * �������ڣ�(7/26/2004 5:10:27 ����)
 * @author��Administrator
 */
import nc.ui.bd.ref.DefaultRefTreeModel;

public class CorpRefModel extends DefaultRefTreeModel {
/**
 * CorpRefModel ������ע�⡣
 */
public CorpRefModel() {
	super();
	initModel();
}
/**
 * CorpRefModel ������ע�⡣
 * @param refNodeName java.lang.String
 */
public CorpRefModel(String refNodeName) {
	super(refNodeName);
	initModel();
}
//private String[] getCorpWithChildren() throws Exception{
//	CorpVO[] corps = CorpBO_Client.getAllChildCorp(getPk_corp());
//	int count = corps == null ? 0 : corps.length;
//	String[] corpIDs = new String[count + 1];
//	for (int i = 0; i < count; i++) {
//		corpIDs[i] = corps[i].getPk_corp();
//	}
//	corpIDs[count] = getPk_corp();
//	return corpIDs;
//}
private void initModel() {
	try {
		setFieldCode(new String[] { "unitcode", "unitname", "pk_corp", "fathercorp" });
		setFieldName(new String[] { "����", "����", "����", "���������" });
		setRefTitle("��֯����");
		setRootName("��֯����");
		setFatherField("fathercorp");
		setChildField("pk_corp");
		setPkFieldCode("pk_corp");
		setTableName("bd_corp");
		//String[] corpPks = getCorpWithChildren();
		setWherePart(" pk_corp in (select pk_corp from sm_createcorp where funccode = '2090') ");
		//setWherePart("pk_corp in(" + mergeCorps(corpPks) + ") and isnull(dr,0)=0");
		//setBlurFields(new String[] { "unitcode" });
		clearData();
		System.out.println("clearData");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//private String mergeCorps(String[] corpPks) {
//	if (corpPks == null || corpPks.length <= 0) {
//		return "'0001'";
//	}
//	StringBuffer sb = new StringBuffer();
//	for (int i = 0; i < corpPks.length; i++) {
//		sb.append("'" + corpPks[i] + "'");
//		if (i < corpPks.length - 1) {
//			sb.append(",");
//		}
//	}
//	return sb.toString();
//}
}
