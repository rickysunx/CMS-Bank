package nc.bs.pub.action;

import nc.bs.pub.compiler.AbstractCompiler2;
import nc.vo.pub.compiler.PfParameterVO;
import java.util.*;
import java.rmi.RemoteException;
/**
 * 备注：低值易耗品调拨单的删除
单据动作执行中的动态执行类的动态执行类。
 *
 * 创建日期：(2005-10-12)
 * @author：平台脚本生成
 */
public class N_L1_DELETE extends AbstractCompiler2 {
private java.util.Hashtable m_methodReturnHas=new java.util.Hashtable();
private Hashtable m_keyHas=null;
/**
 * N_L1_DELETE 构造子注解。
 */
public N_L1_DELETE() {
	super();
}
/*
* 备注：平台编写规则类
* 接口执行类
*/
public Object runComClass(PfParameterVO vo) throws java.rmi.RemoteException {
try{
	super.m_tmpVo=vo;
	//####本脚本必须含有返回值,返回DLG和PNL的组件不允许有返回值####
	Object retObj=null;
	retObj=runClass("nc.bs.lowcost.trans.TranWorkFlowBO","deleteTrans","nc.vo.lowcost.trans.TransVO:L1",vo,m_keyHas,m_methodReturnHas);
	if (retObj != null) {
		m_methodReturnHas.put("deleteTrans",retObj);
	}
	return retObj;
} catch (Exception ex) {
	if (ex instanceof RemoteException)
		throw (RemoteException) ex;
	else 
		throw new RemoteException("Remote Call", ex);
}
}
/*
* 备注：平台编写原始脚本
*/
public String getCodeRemark(){
	return "	//####本脚本必须含有返回值,返回DLG和PNL的组件不允许有返回值####\n	Object retObj=null;\n	retObj=runClassCom@\"nc.bs.lowcost.trans.TranWorkFlowBO\",\"deleteTrans\",\"nc.vo.lowcost.trans.TransVO:L1\"@;\n	return retObj;\n";}
/*
* 备注：设置脚本变量的HAS
*/
private void setParameter(String key,Object val)	{
	if (m_keyHas==null){
		m_keyHas=new Hashtable();
	}
	if (val!=null)	{
		m_keyHas.put(key,val);
	}
}
}
