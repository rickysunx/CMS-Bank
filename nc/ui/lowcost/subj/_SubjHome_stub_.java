package nc.ui.lowcost.subj;

import nc.bs.lowcost.subj.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _SubjHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements SubjHome {
/**
 * _SubjHome_stub_ ������ע�⡣
 */
public _SubjHome_stub_() {
super();
}

public Subj create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Subj_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Subj) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
