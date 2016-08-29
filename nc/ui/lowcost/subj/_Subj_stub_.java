package nc.ui.lowcost.subj;

import nc.bs.lowcost.subj.*;

/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _Subj_stub_ extends nc.bs.mw.naming.RemoteBeanBase implements Subj {
/**
 * _Subj_stub_ 构造子注解。
 */
public _Subj_stub_() {
super();
}

public void delete(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		remoteCall(_Subj_Method_Const_Local_.METHOD_delete$SubjVO_p0, params);
		return ; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public java.lang.String insert(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		return (java.lang.String) remoteCall(_Subj_Method_Const_Local_.METHOD_insert$SubjVO_p0, params); 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public void update(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		remoteCall(_Subj_Method_Const_Local_.METHOD_update$SubjVO_p0, params);
		return ; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.subj.SubjVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		return (nc.vo.lowcost.subj.SubjVO) remoteCall(_Subj_Method_Const_Local_.METHOD_findByPrimaryKey$String_p0, params); 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.subj.SubjVO[] queryByVO(nc.vo.lowcost.subj.SubjVO p0,java.lang.Boolean p1) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0,
p1};
		Object o = remoteCall(_Subj_Method_Const_Local_.METHOD_queryByVO$SubjVO_p0$Boolean_p1, params); 
		if(o == null)
			return null;
		else
			return (nc.vo.lowcost.subj.SubjVO[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.subj.SubjVO[] queryAll(java.lang.String p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		Object o = remoteCall(_Subj_Method_Const_Local_.METHOD_queryAll$String_p0, params); 
		if(o == null)
			return null;
		else
			return (nc.vo.lowcost.subj.SubjVO[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public java.lang.String[] insertArray(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		Object o = remoteCall(_Subj_Method_Const_Local_.METHOD_insertArray$SubjVOS_p0, params); 
		if(o == null)
			return null;
		else
			return (java.lang.String[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public void saveAll(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		remoteCall(_Subj_Method_Const_Local_.METHOD_saveAll$SubjVOS_p0, params);
		return ; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.subj.SubjVO[] queryAllByCorp(java.lang.String p0) throws java.rmi.RemoteException{
	checkRemoved();
	try {
		Object[] params = new Object[]{p0};
		Object o = remoteCall(_Subj_Method_Const_Local_.METHOD_queryAllByCorp$String_p0, params); 
		if(o == null)
			return null;
		else
			return (nc.vo.lowcost.subj.SubjVO[]) o; 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
public nc.vo.lowcost.subj.SubjVO[] queryAllVO() throws java.rmi.RemoteException{
	checkRemoved();
	try {
		if(remoteCall(_Subj_Method_Const_Local_.METHOD_queryAllVO, null) == null)
			return null;
		else
			return (nc.vo.lowcost.subj.SubjVO[]) remoteCall(_Subj_Method_Const_Local_.METHOD_queryAllVO, null); 
	} catch (java.rmi.RemoteException re) {
		throw re;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("remote call", e);
	}
}
}
