package nc.bs.lowcost.subj;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _SubjHome_Local_ extends nc.bs.mw.naming.HomeBase implements SubjHome {
/**
 * _SubjHome_Local_ ������ע�⡣
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
