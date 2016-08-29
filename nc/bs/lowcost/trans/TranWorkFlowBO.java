/*
 * 创建日期 2005-10-12
 *
 * @author 孙锐
 */
package nc.bs.lowcost.trans;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nc.bs.lowcost.card.CardDMO;
import nc.bs.pub.BusinessObject;
import nc.bs.pub.SuperDMO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.lowcost.trans.TransItemVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.trade.pub.IBDACTION;

/**
 * @author 孙锐
 *
 */
public class TranWorkFlowBO extends BusinessObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6349576578784866027L;
	/**
     * 
     */
    public TranWorkFlowBO() {
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
    public AggregatedValueObject approveTrans(nc.vo.lowcost.trans.TransVO vo) throws java.rmi.RemoteException
    {
    	try
    	{
    	    System.out.println("----sunrui test----:in approveTrans()");
    		TransHeaderVO header = (TransHeaderVO) vo.getParentVO();
    		TransItemVO [] ivos = (TransItemVO []) vo.getChildrenVO();
    		CardDMO cdmo = new CardDMO();
    		for (int i = 0; i < ivos.length; i++) {
    		    //检查物品是否核销
    		    CardVO cvo = (new CardDMO()).findByPrimaryKey(ivos[i].getPk_lccard());
    		    if(cvo.getCancelflag()!=null && cvo.getCancelflag().equals("Y")){
    		        throw new Exception ("第" + (i+1) + "行，物品[" + cvo.getLcname() + "已经核销，不能进行调拨" );
    		    }
    		    
    		    cdmo.UpdateUseDept(ivos[i].getPk_lccard(),ivos[i].getPk_deptto());
    		    cdmo.UpdateUser(ivos[i].getPk_lccard(), ivos[i].getDef1());
            }
    		
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
     * @return nc.vo.cc.workflow.CCPlanTransVO
     * @param vo nc.vo.cc.workflow.CCPlanTransVO
     * @exception java.sql.SQLException 异常说明。
     */
    public ArrayList deleteTrans(nc.vo.lowcost.trans.TransVO vo) throws  java.rmi.RemoteException
    {
    	try
    	{
    	    //ArrayList array = new ArrayList();
    	    SuperDMO dmo = new SuperDMO();
    		TransHeaderVO hvo = (TransHeaderVO)vo.getParentVO();
    		TransItemVO [] ivos = (TransItemVO [])vo.getChildrenVO();
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
     * @return nc.vo.cc.workflow.CCPlanTransVO
     * @param vo nc.vo.cc.workflow.CCPlanTransVO
     * @exception java.sql.SQLException 异常说明。
     */
    public ArrayList editTrans(nc.vo.lowcost.trans.TransVO vo) throws java.rmi.RemoteException
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
     * @return nc.vo.cc.workflow.CCPlanTransVO
     * @param vo nc.vo.cc.workflow.CCPlanTransVO
     * @exception java.sql.SQLException 异常说明。
     */
    public ArrayList saveTrans(nc.vo.lowcost.trans.TransVO vo) throws java.rmi.RemoteException
    {
    	try
    	{
    	    System.out.println("----sunrui test----:in saveTrans()");
    	    (new TransBusiCheck()).check(IBDACTION.SAVE,vo,null);
    		ArrayList array = new ArrayList();
    		TransHeaderVO hvo = (TransHeaderVO)vo.getParentVO();
    		TransItemVO [] ivos = (TransItemVO [])vo.getChildrenVO();
    		SuperDMO dmo = new SuperDMO();
    		if(hvo.getPk_trans()==null || hvo.getPk_trans().trim().length()==0){
    		    String pk_trans = dmo.insert(hvo);
    		    hvo.setPk_trans(pk_trans);
    		    for (int i = 0; i < ivos.length; i++) {
                    ivos[i].setPk_trans(pk_trans);
                }
    		    dmo.insertArray(ivos);
    		} else {
    		    dmo.update(hvo);
    		    if(ivos!=null){
	    		    for (int i = 0; i < ivos.length; i++) {
	                    if(ivos[i].getPk_trans_m()==null || ivos[i].getPk_trans_m().trim().length()==0){
	                        ivos[i].setPk_trans(hvo.getPk_trans());
	                        dmo.insert(ivos[i]);
	                    } else {
	                        dmo.update(ivos[i]);
	                    }
	                }
    		    }
    		}
    		array.add(0,hvo.getPk_trans());
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
     * @return nc.vo.cc.workflow.CCPlanTransVO
     * @param vo nc.vo.cc.workflow.CCPlanTransVO
     * @exception java.sql.SQLException 异常说明。
     */
    public AggregatedValueObject unapproveTrans(nc.vo.lowcost.trans.TransVO vo) throws  java.rmi.RemoteException
    {
    	try
    	{
    	    System.out.println("----sunrui test----:in saveTrans()");
    	    TransHeaderVO hvo = (TransHeaderVO)vo.getParentVO();
    		TransItemVO [] ivos = (TransItemVO []) vo.getChildrenVO();
    		if(hvo.getTallyflag()!=null && hvo.getTallyflag().equals("Y")){
    		    throw new Exception ("已经记账的单据不能进行反审核");
    		}
    		CardDMO cdmo = new CardDMO();
    		for (int i = 0; i < ivos.length; i++) {
    		    cdmo.UpdateUseDept(ivos[i].getPk_lccard(),ivos[i].getPk_deptfrom());
    		    cdmo.UpdateUser(ivos[i].getPk_lccard(), ivos[i].getDef2());
            }
    		return vo;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw new java.rmi.RemoteException(e.getMessage());
    	}
    }
}
