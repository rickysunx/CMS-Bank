package nc.bs.lowcost.tally;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class _Tally_Local_ extends nc.bs.mw.naming.BeanBase	 implements Tally {
/**
 * _Tally_Local_ ������ע�⡣
 */
public _Tally_Local_() {
super();
}
private TallyBO _getBeanObject() throws java.rmi.RemoteException {
return (TallyBO) getEjb(); 
}

public Object _R_dispatch_R_(int methodId, Object[] params) throws Exception {
	setLastCallTime(System.currentTimeMillis());
	switch (methodId) {
		 case _Tally_Method_Const_Local_.METHOD_doTally$UFDate_p0$String_p1$String_p2$TallyCorpVOS_p3:
			return doTally((nc.vo.pub.lang.UFDate) params[0],(java.lang.String) params[1],(java.lang.String) params[2],(nc.vo.lowcost.tally.TallyCorpVO[]) params[3]);
		 case _Tally_Method_Const_Local_.METHOD_doUnTally$UFDate_p0$TallyCorpVOS_p1:
			return doUnTally((nc.vo.pub.lang.UFDate) params[0],(nc.vo.lowcost.tally.TallyCorpVO[]) params[1]);
		 case _Tally_Method_Const_Local_.METHOD_queryLastTallyDate:
			return queryLastTallyDate();
	}
	return null;
	}
public nc.vo.lowcost.tally.TallylogVO doTally(nc.vo.pub.lang.UFDate p0,java.lang.String p1,java.lang.String p2,nc.vo.lowcost.tally.TallyCorpVO[] p3) throws java.rmi.RemoteException{
	beforeCallMethod(_Tally_Method_Const_Local_.METHOD_doTally$UFDate_p0$String_p1$String_p2$TallyCorpVOS_p3);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().doTally(p0,p1,p2,p3);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Tally_Method_Const_Local_.METHOD_doTally$UFDate_p0$String_p1$String_p2$TallyCorpVOS_p3, er);
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.lowcost.tally.TallylogVO doUnTally(nc.vo.pub.lang.UFDate p0,nc.vo.lowcost.tally.TallyCorpVO[] p1) throws java.rmi.RemoteException{
	beforeCallMethod(_Tally_Method_Const_Local_.METHOD_doUnTally$UFDate_p0$TallyCorpVOS_p1);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().doUnTally(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Tally_Method_Const_Local_.METHOD_doUnTally$UFDate_p0$TallyCorpVOS_p1, er);
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.pub.lang.UFDate queryLastTallyDate() throws java.rmi.RemoteException{
	beforeCallMethod(_Tally_Method_Const_Local_.METHOD_queryLastTallyDate);
	Exception er = null;
	Object o = null;
	try {
		o = _getBeanObject().queryLastTallyDate();
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(_Tally_Method_Const_Local_.METHOD_queryLastTallyDate, er);
	return (nc.vo.pub.lang.UFDate) o;
}
}
