package nc.ui.lowcost.check;

import nc.bs.lowcost.check.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _CheckHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements CheckHome {
/**
 * _CheckHome_stub_ ������ע�⡣
 */
public _CheckHome_stub_() {
super();
}

public Check create() throws java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Check_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Check) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
