/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product.                              *
\***************************************************************/

package nc.bs.lowcost.cancel;

import java.rmi.*;
import nc.bs.pub.*;
import nc.vo.lowcost.cancel.*;
/**
 * Cancel��BO��
 *
 * �������ڣ�(2005-10-7)
 * @author��
 */
public class CancelBO extends BusinessObject {

/**
	 * 
	 */
	private static final long serialVersionUID = 8945802334661944227L;
/**
 * CancelBO ������ע�⡣
 */
public CancelBO() {
	super();
}
/**
 * EJB�淶��Ҫ��ķ�����
 *
 * �������ڣ�(2005-10-7)
 */
public void ejbCreate() {}
/**
 * ͨ���������VO����
 *
 * �������ڣ�(2005-10-7)
 * @return nc.vo.lowcost.cancel.CancelVO
 * @param key String
 * @exception java.rmi.RemoteException �쳣˵����
 */
public CancelVO findByPrimaryKey(String key) throws java.rmi.RemoteException {

	CancelVO cancel = null;
	try {
		CancelDMO dmo = new CancelDMO();
		cancel = dmo.findByPrimaryKey(key);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CancelBean::findByPrimaryKey(CancelPK) Exception!", e);
	}
	return cancel;
}
/**
 * �����ݿ��в���һ��VO����
 *
 * �������ڣ�(2005-10-7)
 * @param cancel nc.vo.lowcost.cancel.CancelVO
 * @return java.lang.String  ������VO����������ַ�����
 * @exception java.rmi.RemoteException �쳣˵����
 */
public String insert(CancelVO cancel) throws RemoteException {

	try {
		CancelDMO dmo = new CancelDMO();
		String key = dmo.insert(cancel);
		return key;
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CancelBO::insert(CancelVO) Exception!", e);
	}
}
/**
 * �������������ݿ���ɾ��һ��VO����
 *
 * �������ڣ�(2005-10-7)
 * @param key String
 * @exception java.rmi.RemoteException �쳣˵����
 */
public void delete(CancelVO vo) throws java.rmi.RemoteException {

	try {
		CancelDMO dmo = new CancelDMO();
		dmo.delete(vo);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CancelBO::delete(CancelPK) Exception!", e);
	}
}
/**
 * ��VO���������ֵ�������ݿ⡣
 *
 * �������ڣ�(2005-10-7)
 * @param cancel nc.vo.lowcost.cancel.CancelVO
 * @exception java.rmi.RemoteException �쳣˵����
 */
public void update(CancelVO cancel) throws java.rmi.RemoteException {

	try {
		CancelDMO dmo = new CancelDMO();
		dmo.update(cancel);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CancelBO::update(CancelVO) Exception!", e);
	}
}
}