package nc.ui.lowcost.check;

import nc.bs.lowcost.check.*;

/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _Check_stub_ extends nc.bs.mw.naming.RemoteBeanBase implements Check {
/**
 * _Check_stub_ 构造子注解。
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
