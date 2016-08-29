package nc.bs.lowcost.tally;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class TallyBO_wrapper extends TallyBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4849730925896127835L;
	private static final String className = "nc.bs.lowcost.tally.TallyBO";
/**
 * TallyBO_wrapper 构造子注解。
 */
public TallyBO_wrapper() {
	super();
}
public nc.vo.lowcost.tally.TallylogVO doTally(nc.vo.pub.lang.UFDate p0,java.lang.String p1,java.lang.String p2,nc.vo.lowcost.tally.TallyCorpVO[] p3) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1,
p2,
p3};
	beforeCallMethod(className,"doTally",params);
	try {
		o = super.doTally(p0,p1,p2,p3);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doTally",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.lowcost.tally.TallylogVO doUnTally(nc.vo.pub.lang.UFDate p0,nc.vo.lowcost.tally.TallyCorpVO[] p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1};
	beforeCallMethod(className,"doUnTally",params);
	try {
		o = super.doUnTally(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doUnTally",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.pub.lang.UFDate queryLastTallyDate() throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	beforeCallMethod(className,"queryLastTallyDate",null);
	try {
		o = super.queryLastTallyDate();
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryLastTallyDate",null,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.pub.lang.UFDate) o;
}
}
