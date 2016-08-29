package nc.bs.lowcost.subj;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _Subj_Local_ extends nc.bs.mw.naming.BeanBase	 implements Subj {
/**
 * _Subj_Local_ 构造子注解。
 */
public _Subj_Local_() {
super();
}
private SubjBO _getBeanObject() throws java.rmi.RemoteException {
return (SubjBO) getEjb(); 
}

public Object _R_dispatch_R_(int methodId, Object[] params) throws Exception {
	setLastCallTime(System.currentTimeMillis());
	switch (methodId) {
		 case _Subj_Method_Const_Local_.METHOD_delete$SubjVO_p0:
			delete((nc.vo.lowcost.subj.SubjVO) params[0]);
			return null;
		 case _Subj_Method_Const_Local_.METHOD_insert$SubjVO_p0:
			return insert((nc.vo.lowcost.subj.SubjVO) params[0]);
		 case _Subj_Method_Const_Local_.METHOD_update$SubjVO_p0:
			update((nc.vo.lowcost.subj.SubjVO) params[0]);
			return null;
		 case _Subj_Method_Const_Local_.METHOD_findByPrimaryKey$String_p0:
			return findByPrimaryKey((java.lang.String) params[0]);
		 case _Subj_Method_Const_Local_.METHOD_queryByVO$SubjVO_p0$Boolean_p1:
			return queryByVO((nc.vo.lowcost.subj.SubjVO) params[0],(java.lang.Boolean) params[1]);
		 case _Subj_Method_Const_Local_.METHOD_queryAll$String_p0:
			return queryAll((java.lang.String) params[0]);
		 case _Subj_Method_Const_Local_.METHOD_insertArray$SubjVOS_p0:
			return insertArray((nc.vo.lowcost.subj.SubjVO[]) params[0]);
		 case _Subj_Method_Const_Local_.METHOD_saveAll$SubjVOS_p0:
			saveAll((nc.vo.lowcost.subj.SubjVO[]) params[0]);
			return null;
		 case _Subj_Method_Const_Local_.METHOD_queryAllByCorp$String_p0:
			return queryAllByCorp((java.lang.String) params[0]);
		 case _Subj_Method_Const_Local_.METHOD_queryAllVO:
			return queryAllVO();
	}
	return null;
	}
public void delete(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_delete$SubjVO_p0);
	Exception er = null;
	try {
		_getBeanObject().delete(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_delete$SubjVO_p0, er);
	return ;
}
public java.lang.String insert(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_insert$SubjVO_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().insert(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_insert$SubjVO_p0, er);
	return (java.lang.String) o;
}
public void update(nc.vo.lowcost.subj.SubjVO p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_update$SubjVO_p0);
	Exception er = null;
	try {
		_getBeanObject().update(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_update$SubjVO_p0, er);
	return ;
}
public nc.vo.lowcost.subj.SubjVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_findByPrimaryKey$String_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().findByPrimaryKey(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_findByPrimaryKey$String_p0, er);
	return (nc.vo.lowcost.subj.SubjVO) o;
}
public nc.vo.lowcost.subj.SubjVO[] queryByVO(nc.vo.lowcost.subj.SubjVO p0,java.lang.Boolean p1) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_queryByVO$SubjVO_p0$Boolean_p1);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().queryByVO(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_queryByVO$SubjVO_p0$Boolean_p1, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
public nc.vo.lowcost.subj.SubjVO[] queryAll(java.lang.String p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_queryAll$String_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().queryAll(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_queryAll$String_p0, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
public java.lang.String[] insertArray(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_insertArray$SubjVOS_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().insertArray(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_insertArray$SubjVOS_p0, er);
	if(o == null)
		return null;
	else
		return (java.lang.String[]) o;
}
public void saveAll(nc.vo.lowcost.subj.SubjVO[] p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_saveAll$SubjVOS_p0);
	Exception er = null;
	try {
		_getBeanObject().saveAll(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_saveAll$SubjVOS_p0, er);
	return ;
}
public nc.vo.lowcost.subj.SubjVO[] queryAllByCorp(java.lang.String p0) throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_queryAllByCorp$String_p0);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().queryAllByCorp(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_queryAllByCorp$String_p0, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
public nc.vo.lowcost.subj.SubjVO[] queryAllVO() throws java.rmi.RemoteException{
	beforeCallMethod(_Subj_Method_Const_Local_.METHOD_queryAllVO);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().queryAllVO();
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Subj_Method_Const_Local_.METHOD_queryAllVO, er);
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.subj.SubjVO[]) o;
}
}
