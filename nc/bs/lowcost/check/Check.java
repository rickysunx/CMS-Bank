package nc.bs.lowcost.check;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public interface Check extends javax.ejb.EJBObject {

	nc.vo.lowcost.check.CheckVO[] doCheck(nc.vo.lowcost.check.CheckVO[] p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.check.CheckVO[] queryCheck(java.lang.String p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.check.CheckVO[] doTypeCorpCheck(java.lang.String p0) throws java.rmi.RemoteException;

}
