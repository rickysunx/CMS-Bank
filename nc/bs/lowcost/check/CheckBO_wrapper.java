package nc.bs.lowcost.check;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class CheckBO_wrapper extends CheckBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3027395554556532432L;
	private static final String className = "nc.bs.lowcost.check.CheckBO";
/**
 * CheckBO_wrapper ������ע�⡣
 */
public CheckBO_wrapper() {
	super();
}
public nc.vo.lowcost.check.CheckVO[] doCheck(nc.vo.lowcost.check.CheckVO[] p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"doCheck",params);
	try {
		o = super.doCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doCheck",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
public nc.vo.lowcost.check.CheckVO[] queryCheck(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryCheck",params);
	try {
		o = super.queryCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryCheck",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
public nc.vo.lowcost.check.CheckVO[] doTypeCorpCheck(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"doTypeCorpCheck",params);
	try {
		o = super.doTypeCorpCheck(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doTypeCorpCheck",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.check.CheckVO[]) o;
}
}
