package nc.bs.lowcost.tally;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _TallyHome_Local_ extends nc.bs.mw.naming.HomeBase implements TallyHome {
/**
 * _TallyHome_Local_ ������ע�⡣
 */
public _TallyHome_Local_() {
super();
}
protected Object _createNewObject() throws java.rmi.RemoteException {
return createEjb(_Tally_Local_.class,TallyBO_wrapper.class,nc.ui.lowcost.tally._Tally_stub_.class.getName()); 
}

public Object _R_dispatch_R_(int methodId, Object[] params) throws Exception {
	setRegisterEjbToSystem(true);
	switch (methodId) {
		 case _Tally_Method_Const_Local_.HOME_create:
			return create();
	}
	return super._R_dispatch_R_(methodId, params);
}
public Tally create() throws java.rmi.RemoteException{
	if (isStatelessSessBean()) {
		synchronized (this) {
			Object o = 
				ftechStateLessEjbObject(
					_Tally_Local_.class, 
					nc.ui.lowcost.tally._Tally_stub_.class.getName()); 
			if (o != null) {
				return (Tally) o;
			}
		}
	}
	_Tally_Local_ rl = (_Tally_Local_) _createNewObject(); 
	TallyBO bean = (TallyBO) rl.getEjb();
	bean.ejbCreate();
	return rl;
}
}
