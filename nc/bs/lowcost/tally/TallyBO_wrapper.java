package nc.bs.lowcost.tally;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class TallyBO_wrapper extends TallyBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4849730925896127835L;
	private static final String className = "nc.bs.lowcost.tally.TallyBO";
/**
 * TallyBO_wrapper ������ע�⡣
 */
public TallyBO_wrapper() {
	super();
}
public nc.vo.lowcost.tally.TallylogVO doTally(nc.vo.pub.lang.UFDate p0,java.lang.String p1,java.lang.String p2,nc.vo.lowcost.tally.TallyCorpVO[] p3) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1,
p2,
p3};
	beforeCallMethod(className,"doTally",params);
	try {
		o = super.doTally(p0,p1,p2,p3);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doTally",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.lowcost.tally.TallylogVO doUnTally(nc.vo.pub.lang.UFDate p0,nc.vo.lowcost.tally.TallyCorpVO[] p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1};
	beforeCallMethod(className,"doUnTally",params);
	try {
		o = super.doUnTally(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doUnTally",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.pub.lang.UFDate queryLastTallyDate() throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	beforeCallMethod(className,"queryLastTallyDate",null);
	try {
		o = super.queryLastTallyDate();
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryLastTallyDate",null,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.pub.lang.UFDate) o;
}
}
