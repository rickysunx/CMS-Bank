package nc.bs.lowcost.check;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _Check_Local_ extends nc.bs.mw.naming.BeanBase	 implements Check {
/**
 * _Check_Local_ 构造子注解。
 */
public _Check_Local_() {
super();
}
private CheckBO _getBeanObject() throws java.rmi.RemoteException {
return (CheckBO) getEjb(); 
}

public Object _R_dispatch_R_(int methodId, Object[] params) throws Exception {
	setLastCallTime(System.currentTimeMillis());
	switch (methodId) {
		 case _Check_Method_Const_Local_.METHOD_doCheck$CheckVOS_p0:
			return doCheck((nc.vo.lowcost.check.CheckVO[]) params[0]);
		 case _Check_Method_Const_Local_.METHOD_queryCheck$String_p0:
			return queryCheck((java.lang.String) params[0]);
		 case _Check_Method_Const_Local_.METHOD_doTypeCorpCheck$String_p0:
			return doTypeCorpCheck((java.lang.String) params[0]);
	}
	return null;
	}
public nc.vo.lowcost.check.CheckVO[] doCheck(nc.vo.lowcost.check.CheckVO[] p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Check_Method_Const_Local_.METHOD_doCheck$CheckVOS_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().doCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Check_Method_Const_Local_.METHOD_doCheck$CheckVOS_p0, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
public nc.vo.lowcost.check.CheckVO[] queryCheck(java.lang.String p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Check_Method_Const_Local_.METHOD_queryCheck$String_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().queryCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Check_Method_Const_Local_.METHOD_queryCheck$String_p0, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
public nc.vo.lowcost.check.CheckVO[] doTypeCorpCheck(java.lang.String p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Check_Method_Const_Local_.METHOD_doTypeCorpCheck$String_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().doTypeCorpCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Check_Method_Const_Local_.METHOD_doTypeCorpCheck$String_p0, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
}
