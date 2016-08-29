package nc.ui.lowcost.report;

/**
 * �˴���������˵����
 * �������ڣ�(7/26/2004 5:10:27 ����)
 * @author��Administrator
 */
import nc.ui.bd.ref.DefaultRefModel;
import nc.vo.bd.CorpVO;
import nc.ui.pub.ClientEnvironment;
import nc.ui.sm.user.UserBO_Client;

public class CorpRefModel extends DefaultRefModel {
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

private void initModel() {
	try {
		setFieldCode(new String[] { "unitcode", "unitname", "pk_corp" });
		setFieldName(new String[] { "����", "����", "����" });
		setRefTitle("��֯����");
		setPkFieldCode("pk_corp");
		setTableName("bd_corp");
		try {
		    
		    CorpVO [] cvos = UserBO_Client.queryAllCorpsByUserPK(ClientEnvironment.getInstance().getUser().getPrimaryKey());
		    if(cvos!=null && cvos.length>0){
			    StringBuffer sb = new StringBuffer();
			    for (int i = 0; i < cvos.length; i++) {
	                sb.append("'" + cvos[i].getPrimaryKey() + "'");
	                if(i < cvos.length-1){
	                    sb.append(",");
	                }
	            }
			    String whereSql = " pk_corp in (" + sb.toString() + ") ";
			    whereSql += "and (isseal like 'N') ";
			    setWherePart(whereSql);
		    } else {
		        setWherePart(" 1<>1 ");
		    }
		} catch (Exception e){
		    throw new Exception("��ѯ�û������Ĺ�˾ʱ����" + e.getMessage());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
