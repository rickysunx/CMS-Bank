package nc.ui.lowcost.cancel;

import nc.bs.lowcost.cancel.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _CancelHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements CancelHome {
/**
 * _CancelHome_stub_ ������ע�⡣
 */
public _CancelHome_stub_() {
super();
}

public Cancel create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Cancel_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Cancel) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
