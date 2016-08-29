package nc.bs.lowcost.card;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class CardBO_wrapper extends CardBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8891393253740206158L;
	private static final String className = "nc.bs.lowcost.card.CardBO";
/**
 * CardBO_wrapper 构造子注解。
 */
public CardBO_wrapper() {
	super();
}
public void check(nc.vo.lowcost.card.CardVO[] p0,java.lang.String p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0,
p1};
	beforeCallMethod(className,"check",params);
	try {
		super.check(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"check",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public void copy(nc.vo.lowcost.card.CardVO p0,int p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0,
(new Integer(p1))};
	beforeCallMethod(className,"copy",params);
	try {
		super.copy(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"copy",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public void delete(nc.vo.lowcost.card.CardVO p0) throws java.rmi.RemoteException{
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
public java.lang.String insert(nc.vo.lowcost.card.CardVO p0) throws java.rmi.RemoteException{
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
public void update(nc.vo.lowcost.card.CardVO p0) throws java.rmi.RemoteException{
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
public nc.vo.lowcost.card.CardVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
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
	return (nc.vo.lowcost.card.CardVO) o;
}
public nc.vo.lowcost.card.CardVO[] queryByVO(nc.vo.lowcost.card.CardVO p0,java.lang.Boolean p1) throws java.rmi.RemoteException{
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
		return (nc.vo.lowcost.card.CardVO[]) o;
}
public nc.vo.lowcost.card.CardVO[] queryAll(java.lang.String p0) throws java.rmi.RemoteException{
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
		return (nc.vo.lowcost.card.CardVO[]) o;
}
public java.lang.String[] insertArray(nc.vo.lowcost.card.CardVO[] p0) throws java.rmi.RemoteException{
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
public nc.vo.lowcost.card.CardVO[] queryByCondVO(nc.vo.lowcost.card.CardVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryByCondVO",params);
	try {
		o = super.queryByCondVO(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryByCondVO",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.card.CardVO[]) o;
}
public java.util.Vector getControlPks(java.lang.String p0,java.lang.String p1,java.lang.String p2) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1,
p2};
	beforeCallMethod(className,"getControlPks",params);
	try {
		o = super.getControlPks(p0,p1,p2);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"getControlPks",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (java.util.Vector) o;
}
public boolean isControl(java.lang.String p0,java.lang.String p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1};
	beforeCallMethod(className,"isControl",params);
	try {
		o = (new Boolean(super.isControl(p0,p1)));
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"isControl",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ((Boolean) o).booleanValue();
}
public nc.vo.lowcost.card.CardVO[] queryByWhereSqlAndWithUseDept(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryByWhereSqlAndWithUseDept",params);
	try {
		o = super.queryByWhereSqlAndWithUseDept(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryByWhereSqlAndWithUseDept",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.card.CardVO[]) o;
}
public java.lang.String getLcCode(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"getLcCode",params);
	try {
		o = super.getLcCode(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"getLcCode",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (java.lang.String) o;
}
}
