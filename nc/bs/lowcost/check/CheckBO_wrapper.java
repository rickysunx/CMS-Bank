package nc.bs.lowcost.check;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class CheckBO_wrapper extends CheckBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3027395554556532432L;
	private static final String className = "nc.bs.lowcost.check.CheckBO";
/**
 * CheckBO_wrapper 构造子注解。
 */
public CheckBO_wrapper() {
	super();
}
public nc.vo.lowcost.check.CheckVO[] doCheck(nc.vo.lowcost.check.CheckVO[] p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"doCheck",params);
	try {
		o = super.doCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doCheck",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
public nc.vo.lowcost.check.CheckVO[] queryCheck(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryCheck",params);
	try {
		o = super.queryCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryCheck",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
public nc.vo.lowcost.check.CheckVO[] doTypeCorpCheck(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"doTypeCorpCheck",params);
	try {
		o = super.doTypeCorpCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doTypeCorpCheck",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
}
