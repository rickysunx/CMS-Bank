package nc.ui.lowcost.tally;

import nc.bs.lowcost.tally.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _TallylogHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements TallylogHome {
/**
 * _TallylogHome_stub_ ������ע�⡣
 */
public _TallylogHome_stub_() {
super();
}

public Tallylog create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Tallylog_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Tallylog) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
