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
public class _TallyHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements TallyHome {
/**
 * _TallyHome_stub_ ������ע�⡣
 */
public _TallyHome_stub_() {
super();
}

public Tally create() throws java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Tally_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Tally) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
