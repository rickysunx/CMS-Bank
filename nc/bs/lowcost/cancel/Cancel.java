package nc.bs.lowcost.cancel;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public interface Cancel extends javax.ejb.EJBObject {

	void delete(nc.vo.lowcost.cancel.CancelVO p0) throws java.rmi.RemoteException;
	java.lang.String insert(nc.vo.lowcost.cancel.CancelVO p0) throws java.rmi.RemoteException;
	void update(nc.vo.lowcost.cancel.CancelVO p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.cancel.CancelVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException;

}
