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
public class _Check_stub_ extends nc.bs.mw.naming.RemoteBeanBase implements Check {
/**
 * _Check_stub_ ������ע�⡣
 */
public _Check_stub_() {
super();
}

public nc.vo.lowcost.check.CheckVO[] doCheck(nc.vo.lowcost.check.CheckVO[] p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		Object o = remoteCall(_Check_Method_Const_Local_.METHOD_doCheck$CheckVOS_p0, params); 
		if(o == null)
			return null;
		else
			return (nc.vo.lowcost.check.CheckVO[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.check.CheckVO[] queryCheck(java.lang.String p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		Object o = remoteCall(_Check_Method_Const_Local_.METHOD_queryCheck$String_p0, params); 
		if(o == null)
			return null;
		else
			return (nc.vo.lowcost.check.CheckVO[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.check.CheckVO[] doTypeCorpCheck(java.lang.String p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		Object o = remoteCall(_Check_Method_Const_Local_.METHOD_doTypeCorpCheck$String_p0, params); 
		if(o == null)
			return null;
		else
			return (nc.vo.lowcost.check.CheckVO[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
}
