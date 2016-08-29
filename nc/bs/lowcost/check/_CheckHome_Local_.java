package nc.bs.lowcost.check;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public class _CheckHome_Local_ extends nc.bs.mw.naming.HomeBase implements CheckHome {
/**
 * _CheckHome_Local_ 构造子注解。
 */
public _CheckHome_Local_() {
super();
}
protected Object _createNewObject() throws java.rmi.RemoteException {
return createEjb(_Check_Local_.class,CheckBO_wrapper.class,nc.ui.lowcost.check._Check_stub_.class.getName()); 
}

public Object _R_dispatch_R_(int methodId, Object[] params) throws Exception {
	setRegisterEjbToSystem(true);
	switch (methodId) {
		 case _Check_Method_Const_Local_.HOME_create:
			return create();
	}
	return super._R_dispatch_R_(methodId, params);
}
public Check create() throws java.rmi.RemoteException{
	if (isStatelessSessBean()) {
		synchronized (this) {
			Object o = 
				ftechStateLessEjbObject(
					_Check_Local_.class, 
					nc.ui.lowcost.check._Check_stub_.class.getName()); 
			if (o != null) {
				return (Check) o;
			}
		}
	}
	_Check_Local_ rl = (_Check_Local_) _createNewObject(); 
	CheckBO bean = (CheckBO) rl.getEjb();
	bean.ejbCreate();
	return rl;
}
}
