package nc.ui.lowcost.tally;

import nc.bs.lowcost.tally.*;

/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _Tally_stub_ extends nc.bs.mw.naming.RemoteBeanBase implements Tally {
/**
 * _Tally_stub_ 构造子注解。
 */
public _Tally_stub_() {
super();
}

public nc.vo.lowcost.tally.TallylogVO doTally(nc.vo.pub.lang.UFDate p0,java.lang.String p1,java.lang.String p2,nc.vo.lowcost.tally.TallyCorpVO[] p3) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0,
p1,
p2,
p3};
		return (nc.vo.lowcost.tally.TallylogVO) remoteCall(_Tally_Method_Const_Local_.METHOD_doTally$UFDate_p0$String_p1$String_p2$TallyCorpVOS_p3, params); 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.tally.TallylogVO doUnTally(nc.vo.pub.lang.UFDate p0,nc.vo.lowcost.tally.TallyCorpVO[] p1) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0,
p1};
		return (nc.vo.lowcost.tally.TallylogVO) remoteCall(_Tally_Method_Const_Local_.METHOD_doUnTally$UFDate_p0$TallyCorpVOS_p1, params); 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.pub.lang.UFDate queryLastTallyDate() throws java.rmi.RemoteException{
	checkRemoved();
	try {
		return (nc.vo.pub.lang.UFDate) remoteCall(_Tally_Method_Const_Local_.METHOD_queryLastTallyDate, null); 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
}
