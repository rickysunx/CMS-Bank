package nc.bs.lowcost.trans;


/**
 * ��Ĺ��ܡ���;���ִ�BUG���Լ��������˿��ܸ���Ȥ�Ľ��ܡ�
 * ���ߣ�@author
 * @version ����޸�����
 * @see ��Ҫ�μ���������
 * @since �Ӳ�Ʒ����һ���汾�����౻��ӽ���������ѡ��
 * @deprecated����Ӳ�Ʒ����һ���汾���Ѿ����������滻������ѡ��
 */
public class TransBO_wrapper extends TransBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4796509441719940123L;
	private static final String className = "nc.bs.lowcost.trans.TransBO";
/**
 * TransBO_wrapper ������ע�⡣
 */
public TransBO_wrapper() {
	super();
}
public void delete(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException{
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
public java.lang.String insert(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException{
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
public void update(nc.vo.lowcost.trans.TransVO p0) throws java.rmi.RemoteException{
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
public nc.vo.lowcost.trans.TransVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException{
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
	return (nc.vo.lowcost.trans.TransVO) o;
}
}
