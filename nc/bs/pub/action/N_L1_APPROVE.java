package nc.bs.pub.action;

import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.lowcost.trans.TransVO;
import nc.bs.pub.compiler.AbstractCompiler2;
import nc.vo.pub.compiler.PfParameterVO;
import java.util.*;
import nc.vo.pub.lang.UFDate;
import java.rmi.RemoteException;
/**
 * ��ע����ֵ�׺�Ʒ�����������
���ݶ���ִ���еĶ�ִ̬����Ķ�ִ̬���ࡣ
 *
 * �������ڣ�(2005-10-12)
 * @author��ƽ̨�ű�����
 */
public class N_L1_APPROVE extends AbstractCompiler2 {
private java.util.Hashtable m_methodReturnHas=new java.util.Hashtable();
private Hashtable m_keyHas=null;
/**
 * N_L1_APPROVE ������ע�⡣
 */
public N_L1_APPROVE() {
	super();
}
/*
* ��ע��ƽ̨��д������
* �ӿ�ִ����
*/
public Object runComClass(PfParameterVO vo) throws java.rmi.RemoteException {
try{
	super.m_tmpVo=vo;
	//####���ű����뺬�з���ֵ,����DLG��PNL������������з���ֵ####
	Object retObj=null;
	Object m_sysflowObj= procActionFlow(vo);
	if (m_sysflowObj!=null){
		return m_sysflowObj;
	}
	TransVO transVO = (TransVO)vo.m_preValueVo;
	TransHeaderVO hVO = (TransHeaderVO)transVO.getParentVO();
	hVO.setPk_checker(vo.m_operator);
	hVO.setCheckdate(new UFDate(vo.m_currentDate));
	
	retObj=runClass("nc.bs.lowcost.trans.TranWorkFlowBO","approveTrans","nc.vo.lowcost.trans.TransVO:L1",vo,m_keyHas,m_methodReturnHas);
	if (retObj != null) {
		m_methodReturnHas.put("approveTrans",retObj);
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
* ��ע��ƽ̨��дԭʼ�ű�
*/
public String getCodeRemark(){
	return "	//####���ű����뺬�з���ֵ,����DLG��PNL������������з���ֵ####\n	Object retObj=null;\n	retObj=runClassCom@\"nc.bs.lowcost.trans.TranWorkFlowBO\",\"approveTrans\",\"nc.vo.lowcost.trans.TransVO:L1\"@;\n	return retObj;\n";}
/*
* ��ע�����ýű�������HAS
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
