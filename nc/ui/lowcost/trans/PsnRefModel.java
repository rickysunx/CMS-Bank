/**
 * 
 */
package nc.ui.lowcost.trans;

import java.io.Serializable;

import nc.ui.bd.ref.DefaultRefModel;
import nc.ui.pub.ClientEnvironment;

/**
 * @author Administrator
 *
 */
public class PsnRefModel extends DefaultRefModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1346780464600492246L;

	/**
	 * 
	 */
	public PsnRefModel() {
		super();
		System.out.println("��ʼ��Ա��");
		String pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();		
		setRefTitle("ʹ���˲���");
		setFieldCode(new String[]{"psncode","psnname"});
    	setFieldName(new String[]{"ʹ���˱���","ʹ��������"});
    	setHiddenFieldCode(new String []{"pk_psndoc"/*,"pk_fathedept"*/});
    	setPkFieldCode("pk_psndoc");
    	setTableName("bd_psndoc");
    	setOrderPart("psncode");  
    	setWherePart(" pk_corp='" + pk_corp + "' ");
	}

	/**
	 * @param refNodeName
	 */
	public PsnRefModel(String refNodeName) {
		super(refNodeName);
	}

	public void setCorp(String pk_corp){
		 System.out.println("----ʹ���˲��ղ���----");
	     setWherePart(" pk_corp='" + pk_corp + "' ");
	}
}
