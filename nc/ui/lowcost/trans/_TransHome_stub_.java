package nc.ui.lowcost.trans;

import nc.bs.lowcost.trans.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _TransHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements TransHome {
/**
 * _TransHome_stub_ ������ע�⡣
 */
public _TransHome_stub_() {
super();
}

public Trans create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Trans_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Trans) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
