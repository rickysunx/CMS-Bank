package nc.bs.lowcost.subj;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public interface Subj extends javax.ejb.EJBObject {

	void delete(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException;
	java.lang.String insert(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException;
	void update(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.subj.SubjVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.subj.SubjVO[] queryByVO(nc.vo.lowcost.subj.SubjVO p0,java.lang.Boolean p1) throws java.rmi.RemoteException;
	nc.vo.lowcost.subj.SubjVO[] queryAll(java.lang.String p0) throws java.rmi.RemoteException;
	java.lang.String[] insertArray(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException;
	void saveAll(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.subj.SubjVO[] queryAllByCorp(java.lang.String p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.subj.SubjVO[] queryAllVO() throws java.rmi.RemoteException;

}
