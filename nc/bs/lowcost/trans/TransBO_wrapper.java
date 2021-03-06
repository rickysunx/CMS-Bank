package nc.bs.lowcost.trans;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class TransBO_wrapper extends TransBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4796509441719940123L;
	private static final String className = "nc.bs.lowcost.trans.TransBO";
/**
 * TransBO_wrapper 构造子注解。
 */
public TransBO_wrapper() {
	super();
}
public void delete(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"delete",params);
	try {
		super.delete(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"delete",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public java.lang.String insert(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"insert",params);
	try {
		o = super.insert(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"insert",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (java.lang.String) o;
}
public void update(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"update",params);
	try {
		super.update(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"update",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public nc.vo.lowcost.trans.TransVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"findByPrimaryKey",params);
	try {
		o = super.findByPrimaryKey(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"findByPrimaryKey",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.lowcost.trans.TransVO) o;
}
}
