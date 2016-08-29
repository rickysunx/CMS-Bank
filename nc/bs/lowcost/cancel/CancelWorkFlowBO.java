/*
 * 创建日期 2005-10-12
 *
 * @author 孙锐
 */
package nc.bs.lowcost.cancel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nc.bs.lowcost.card.CardDMO;
import nc.bs.pub.BusinessObject;
import nc.bs.pub.SuperDMO;
import nc.vo.lowcost.cancel.CancelHeaderVO;
import nc.vo.lowcost.cancel.*;
import nc.vo.lowcost.card.CardVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.trade.pub.IBDACTION;

/**
 * @author 孙锐
 *
 */
public class CancelWorkFlowBO extends BusinessObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7579979610598287500L;
	/**
     * 
     */
    public CancelWorkFlowBO() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.BusinessObject#ejbCreate()
     */
    public void ejbCreate() throws RemoteException {

    }
    /**
     * 此处插入方法说明。
     * 创建日期：(2005-7-2 22:47:06)
     * @return nc.vo.cc.workflow.CCPlanAdjustVO
     * @param vo nc.vo.cc.workflow.CCPlanAdjustVO
     * @exception java.sql.SQLException 异常说明。
     */
    public AggregatedValueObject approveCancel(nc.vo.lowcost.cancel.CancelVO vo) throws java.rmi.RemoteException
    {
    	try
    	{
    	    System.out.println("----sunrui test----:in approveCancel()");
    		//int m = 8;
    		CancelHeaderVO hvo = (CancelHeaderVO) vo.getParentVO();
    		CancelItemVO [] ivos = (CancelItemVO[]) vo .getChildrenVO();
    		CardDMO cdmo = new CardDMO();
    		String pk_cards = "''";
    		for (int i = 0; i < ivos.length; i++) {
    		    CardVO cvo = cdmo.findByPrimaryKey(ivos[i].getPk_lccard());
    		    if(cvo.getCancelflag()!=null && cvo.getCancelflag().booleanValue()){
    		        throw new Exception ("第"+(i+1)+"行物品已经核销，不能再次核销");
    		    }
    		    
                pk_cards += ",'" + ivos[i].getPk_lccard() + "'";
            }
    		cdmo.UpdateCancelFlag(pk_cards,hvo.getCheckdate().toString(),"Y");
    		return vo;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw new java.rmi.RemoteException(e.getMessage());
    	}
    }
    /**
     * 此处插入方法说明。
     * 创建日期：(2005-7-2 22:47:06)
     * @return nc.vo.cc.workflow.CCPlanCancelVO
     * @param vo nc.vo.cc.workflow.CCPlanCancelVO
     * @exception java.sql.SQLException 异常说明。
     */
    public ArrayList deleteCancel(nc.vo.lowcost.cancel.CancelVO vo) throws  java.rmi.RemoteException
    {
    	try
    	{
    	    //ArrayList array = new ArrayList();
    	    SuperDMO dmo = new SuperDMO();
    		CancelHeaderVO hvo = (CancelHeaderVO)vo.getParentVO();
    		CancelItemVO [] ivos = (CancelItemVO [])vo.getChildrenVO();
    		if(!(hvo.getCheckflag()==null && (hvo.getPk_checker()==null||hvo.getPk_checker().trim().length()==0))){
    		    throw new Exception ("单据已经审核或在审核中,不能删除");
    		}
    	    dmo.delete(hvo);
    	    dmo.deleteArray(ivos);    	    
    		return null;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw new java.rmi.RemoteException(e.getMessage());
    	}
    }
    /**
     * 此处插入方法说明。
     * 创建日期：(2005-7-2 22:47:06)
     * @return nc.vo.cc.workflow.CCPlanCancelVO
     * @param vo nc.vo.cc.workflow.CCPlanCancelVO
     * @exception java.sql.SQLException 异常说明。
     */
    public ArrayList editCancel(nc.vo.lowcost.cancel.CancelVO vo) throws java.rmi.RemoteException
    {
    	try
    	{
    		ArrayList array = new ArrayList();
    		return array;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw new java.rmi.RemoteException(e.getMessage());
    	}
    }

    /**
     * 此处插入方法说明。
     * 创建日期：(2005-7-2 22:47:06)
     * @return nc.vo.cc.workflow.CCPlanCancelVO
     * @param vo nc.vo.cc.workflow.CCPlanCancelVO
     * @exception java.sql.SQLException 异常说明。
     */
    public ArrayList saveCancel(nc.vo.lowcost.cancel.CancelVO vo) throws java.rmi.RemoteException
    {
    	try
    	{
    	    System.out.println("----sunrui test----:in saveCancel()");
    	    (new CancelBusiCheck()).check(IBDACTION.SAVE,vo,null);
    		ArrayList array = new ArrayList();
    		CancelHeaderVO hvo = (CancelHeaderVO)vo.getParentVO();
    		CancelItemVO [] ivos = (CancelItemVO [])vo.getChildrenVO();
    		SuperDMO dmo = new SuperDMO();
    		if(hvo.getPk_cancel()==null || hvo.getPk_cancel().trim().length()==0){
    		    String pk_cancel = dmo.insert(hvo);
    		    hvo.setPk_cancel(pk_cancel);
    		    for (int i = 0; i < ivos.length; i++) {
                    ivos[i].setPk_cancel(pk_cancel);
                }
    		    dmo.insertArray(ivos);
    		} else {
    		    dmo.update(hvo);
    		    if(ivos!=null){
	    		    for (int i = 0; i < ivos.length; i++) {
	                    if(ivos[i].getPk_cancel_m()==null || ivos[i].getPk_cancel_m().trim().length()==0){
	                        ivos[i].setPk_cancel(hvo.getPk_cancel());
	                        dmo.insert(ivos[i]);
	                    } else {
	                        dmo.update(ivos[i]);
	                    }
	                }
    		    }    		    
    		    //dmo.deleteByWhereClause(CancelItemVO.class," pk_cancel = '" + hvo.getPk_cancel() + "' ");
    		    //dmo.insertArray(ivos);
    		}
    		array.add(0,hvo.getPk_cancel());
    		array.add(1,vo);
    		return array;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw new java.rmi.RemoteException(e.getMessage());
    	}
    }
    /**
     * 此处插入方法说明。
     * 创建日期：(2005-7-2 22:47:06)
     * @return nc.vo.cc.workflow.CCPlanCancelVO
     * @param vo nc.vo.cc.workflow.CCPlanCancelVO
     * @exception java.sql.SQLException 异常说明。
     */
    public AggregatedValueObject unapproveCancel(nc.vo.lowcost.cancel.CancelVO vo) throws  java.rmi.RemoteException
    {
    	try
    	{
    		//ArrayList array = new ArrayList();
    		CancelHeaderVO hvo = (CancelHeaderVO) vo.getParentVO();
    		CancelItemVO [] ivos = (CancelItemVO[]) vo .getChildrenVO();
    		if(hvo.getTallyflag()!=null && hvo.getTallyflag().equals("Y")){
    		    throw new Exception ("已经记账的单据不能进行反审核");
    		}
    		CardDMO cdmo = new CardDMO();
    		String pk_cards = "''";
    		for (int i = 0; i < ivos.length; i++) {
                pk_cards += ",'" + ivos[i].getPk_lccard() + "'";
            }
    		//cdmo.UpdateCancelFlag(pk_cards,"null","null");
    		cdmo.UpdateCancelFlag(pk_cards,hvo.getCheckdate().toString(),"N");
    		return vo;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw new java.rmi.RemoteException(e.getMessage());
    	}
    }
}
