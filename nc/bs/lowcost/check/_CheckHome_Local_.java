package nc.bs.lowcost.check;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _CheckHome_Local_ extends nc.bs.mw.naming.HomeBase implements CheckHome {
/**
 * _CheckHome_Local_ ������ע�⡣
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
