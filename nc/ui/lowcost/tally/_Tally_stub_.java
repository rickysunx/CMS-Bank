package nc.ui.lowcost.tally;

import nc.bs.lowcost.tally.*;

/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _Tally_stub_ extends nc.bs.mw.naming.RemoteBeanBase implements Tally {
/**
 * _Tally_stub_ ������ע�⡣
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
