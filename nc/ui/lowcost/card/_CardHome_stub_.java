package nc.ui.lowcost.card;

import nc.bs.lowcost.card.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _CardHome_stub_ extends nc.bs.mw.naming.RemoteHomeBase implements CardHome {
/**
 * _CardHome_stub_ ������ע�⡣
 */
public _CardHome_stub_() {
super();
}

public Card create() throws javax.ejb.CreateException,java.rmi.RemoteException{
	try {
		nc.bs.mw.naming.RemoteBeanBase t = (nc.bs.mw.naming.RemoteBeanBase) remoteCall(_Card_Method_Const_Local_.HOME_create, null); 
		t.setEJBHome(this);
		return (Card) t;
	} catch (Exception e) {
		throw new java.rmi.RemoteException("create", e);
	}
}
}
