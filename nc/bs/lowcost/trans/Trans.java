package nc.bs.lowcost.trans;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public interface Trans extends javax.ejb.EJBObject {

	void delete(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException;
	java.lang.String insert(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException;
	void update(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.trans.TransVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException;

}
