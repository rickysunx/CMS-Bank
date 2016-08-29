package nc.bs.lowcost.subj;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _SubjHome_Local_ extends nc.bs.mw.naming.HomeBase implements SubjHome {
/**
 * _SubjHome_Local_ 构造子注解。
 */
public _SubjHome_Local_() {
super();
}
protected Object _createNewObject() throws java.rmi.RemoteException {
return createEjb(_Subj_Local_.class,SubjBO_wrapper.class,nc.ui.lowcost.subj._Subj_stub_.class.getName()); 
}

public Object _R_dispatch_R_(int methodId, Object[] params) throws Exception {
	setRegisterEjbToSystem(true);
	switch (methodId) {
		 case _Subj_Method_Const_Local_.HOME_create:
			return create();
	}
	return super._R_dispatch_R_(methodId, params);
}
public Subj create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	if (isStatelessSessBean()) {
		synchronized (this) {
			Object o = 
				ftechStateLessEjbObject(
					_Subj_Local_.class, 
					nc.ui.lowcost.subj._Subj_stub_.class.getName()); 
			if (o != null) {
				return (Subj) o;
			}
		}
	}
	_Subj_Local_ rl = (_Subj_Local_) _createNewObject(); 
	SubjBO bean = (SubjBO) rl.getEjb();
	bean.ejbCreate();
	return rl;
}
}
