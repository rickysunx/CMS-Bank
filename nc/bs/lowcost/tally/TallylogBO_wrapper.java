package nc.bs.lowcost.tally;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class TallylogBO_wrapper extends TallylogBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1141453769398664547L;
	private static final String className = "nc.bs.lowcost.tally.TallylogBO";
/**
 * TallylogBO_wrapper ������ע�⡣
 */
public TallylogBO_wrapper() {
	super();
}
public void delete(nc.vo.lowcost.tally.TallylogVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"delete",params);
	try {
		super.delete(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"delete",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public java.lang.String insert(nc.vo.lowcost.tally.TallylogVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"insert",params);
	try {
		o = super.insert(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"insert",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (java.lang.String) o;
}
public void update(nc.vo.lowcost.tally.TallylogVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"update",params);
	try {
		super.update(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"update",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return ;
}
public nc.vo.lowcost.tally.TallylogVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"findByPrimaryKey",params);
	try {
		o = super.findByPrimaryKey(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"findByPrimaryKey",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (nc.vo.lowcost.tally.TallylogVO) o;
}
public nc.vo.lowcost.tally.TallylogVO[] queryByVO(nc.vo.lowcost.tally.TallylogVO p0,java.lang.Boolean p1) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0,
p1};
	beforeCallMethod(className,"queryByVO",params);
	try {
		o = super.queryByVO(p0,p1);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryByVO",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.tally.TallylogVO[]) o;
}
public nc.vo.lowcost.tally.TallylogVO[] queryAll(java.lang.String p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"queryAll",params);
	try {
		o = super.queryAll(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"queryAll",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (nc.vo.lowcost.tally.TallylogVO[]) o;
}
public java.lang.String[] insertArray(nc.vo.lowcost.tally.TallylogVO[] p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"insertArray",params);
	try {
		o = super.insertArray(p0);
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"insertArray",params,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	if(o == null)
		return null;
	else
		return (java.lang.String[]) o;
}
public nc.vo.lowcost.tally.TallylogVO doTally(nc.vo.lowcost.tally.TallylogVO p0) throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	Object[] params = new Object[]{p0};
	beforeCallMethod(className,"doTally",params);
	try {
		o = super.doTally(p0);
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
public java.lang.String doCheck() throws java.rmi.RemoteException{
	Exception er = null;
	Object o = null;
	beforeCallMethod(className,"doCheck",null);
	try {
		o = super.doCheck();
	} catch (Exception e) {
		er = e;
	}
	afterCallMethod(className,"doCheck",null,er);
	if(er != null){
		if(er instanceof java.rmi.RemoteException)
			throw (java.rmi.RemoteException) er;
	}
	return (java.lang.String) o;
}
}
