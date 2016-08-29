package nc.bs.lowcost.cancel;


/**
 * 类的功能、用途、现存BUG，以及其它别人可能感兴趣的介绍。
 * 作者：@author
 * @version 最后修改日期
 * @see 需要参见的其它类
 * @since 从产品的那一个版本，此类被添加进来。（可选）
 * @deprecated该类从产品的那一个版本后，已经被其它类替换。（可选）
 */
public interface Cancel extends javax.ejb.EJBObject {

	void delete(nc.vo.lowcost.cancel.CancelVO p0) throws java.rmi.RemoteException;
	java.lang.String insert(nc.vo.lowcost.cancel.CancelVO p0) throws java.rmi.RemoteException;
	void update(nc.vo.lowcost.cancel.CancelVO p0) throws java.rmi.RemoteException;
	nc.vo.lowcost.cancel.CancelVO findByPrimaryKey(java.lang.String p0) throws java.rmi.RemoteException;

}
