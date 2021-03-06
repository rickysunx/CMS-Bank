package nc.bs.lowcost.subj;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class SubjBO_wrapper extends SubjBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7248837812659322592L;
	private static final String className = "nc.bs.lowcost.subj.SubjBO";
/**
 * SubjBO_wrapper 构造子注解。
 */
public SubjBO_wrapper() {
	super();
}
public void delete(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
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
public java.lang.String insert(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
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
public void update(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
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
public nc.vo.lowcost.subj.SubjVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
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
	return (nc.vo.lowcost.subj.SubjVO) o;
}
public nc.vo.lowcost.subj.SubjVO[] queryByVO(nc.vo.lowcost.subj.SubjVO p0,java.lang.Boolean p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1};
	beforeCallMethod(className,"queryByVO",params);
	try {
		o = super.queryByVO(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryByVO",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
public nc.vo.lowcost.subj.SubjVO[] queryAll(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryAll",params);
	try {
		o = super.queryAll(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryAll",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
public java.lang.String[] insertArray(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"insertArray",params);
	try {
		o = super.insertArray(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"insertArray",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (java.lang.String[]) o;
}
public void saveAll(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"saveAll",params);
	try {
		super.saveAll(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"saveAll",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public nc.vo.lowcost.subj.SubjVO[] queryAllByCorp(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryAllByCorp",params);
	try {
		o = super.queryAllByCorp(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryAllByCorp",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
public nc.vo.lowcost.subj.SubjVO[] queryAllVO() throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	beforeCallMethod(className,"queryAllVO",null);
	try {
		o = super.queryAllVO();
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryAllVO",null,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
}
