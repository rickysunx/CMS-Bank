package nc.ui.lowcost.type;

import nc.bs.lowcost.type.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _TypeHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements TypeHome {
/**
 * _TypeHome_stub_ ������ע�⡣
 */
public _TypeHome_stub_() {
super();
}

public Type create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Type_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Type) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
