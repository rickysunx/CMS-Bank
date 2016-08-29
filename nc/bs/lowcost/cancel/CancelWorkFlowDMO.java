/*
 * 创建日期 2005-10-12
 *
 * @author 孙锐
 */
package nc.bs.lowcost.cancel;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.naming.NamingException;

import nc.bs.pub.DataManageObject;
import nc.bs.pub.SystemException;
import nc.vo.dap.voucher.MsgAggregatedStruct;
import nc.vo.lowcost.cancel.CancelHeaderVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.CircularlyAccessibleValueObject;

/**
 * @author 孙锐
 *
 */
public class CancelWorkFlowDMO extends DataManageObject implements nc.bs.dmp.outinteface.IDmpGetData, nc.bs.dap.out.IAccountProcMsg,nc.bs.pub.pf.IQueryData,nc.bs.pub.pf.ICheckState3,nc.bs.pub.pf.IBackCheckState,nc.bs.dap.out.IAccountProcMsgInBulk {

    /**
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public CancelWorkFlowDMO() throws NamingException, SystemException {
        super();
    }

    /**
     * @param dbName
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public CancelWorkFlowDMO(String dbName) throws NamingException,
            SystemException {
        super(dbName);
    }

    /* （非 Javadoc）
     * @see nc.bs.dmp.outinteface.IDmpGetData#queryDataByProcId(java.lang.String, java.lang.String, java.lang.String)
     */
    public CircularlyAccessibleValueObject[] queryDataByProcId(String billType, String billId, String ManaCode) throws RemoteException {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.dap.out.IAccountProcMsg#queryDataByProcId(java.lang.String, java.lang.String)
     */
    public AggregatedValueObject queryDataByProcId(String billTypeOrProc, String procMsg) throws SQLException {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IQueryData#queryAllBodyData(java.lang.String)
     */
    public CircularlyAccessibleValueObject[] queryAllBodyData(String key) throws SQLException {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IQueryData#queryAllHeadData(java.lang.String)
     */
    public CircularlyAccessibleValueObject[] queryAllHeadData(String whereString) throws SQLException {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.ICheckState3#checkGoing(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean checkGoing(AggregatedValueObject vo, String ApproveId, String ApproveDate, String checkNote) throws Exception {
        log("checkGoing");
        String pk_cancel = ((CancelHeaderVO)vo.getParentVO()).getPk_cancel();
        super.executeUpdate("update lc_cancel set checkflag=null,pk_checker='" + ApproveId + "',checkdate = '" + ApproveDate +"' where pk_cancel = '" + pk_cancel + "'");
        return false;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.ICheckState3#checkNoPass(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean checkNoPass(AggregatedValueObject vo, String ApproveId, String ApproveDate, String checkNote) throws Exception {
        log("checkNoPass");
        String pk_cancel = ((CancelHeaderVO)vo.getParentVO()).getPk_cancel();
        super.executeUpdate("update lc_cancel set checkflag = 'N',pk_checker = '" + ApproveId + "', checkdate = '" + ApproveDate + "' where pk_cancel = '" + pk_cancel + "'");
        return false;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.ICheckState3#checkPass(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean checkPass(AggregatedValueObject vo, String ApproveId, String ApproveDate, String checkNote) throws Exception {
        log("checkPass");
        String pk_cancel = ((CancelHeaderVO)vo.getParentVO()).getPk_cancel();
        ((CancelHeaderVO)vo.getParentVO()).setPk_checker(ApproveId);
        super.executeUpdate("update lc_cancel set checkflag = 'Y',pk_checker = '" + ApproveId + "', checkdate = '" + ApproveDate + "' where pk_cancel = '" + pk_cancel + "'");
        return false;
    }




    /* （非 Javadoc）
     * @see nc.bs.dap.out.IAccountProcMsgInBulk#queryDataByProcIds(java.lang.String, java.lang.String[])
     */
    public MsgAggregatedStruct[] queryDataByProcIds(String billTypeOrProc, String[] procMsg) throws SQLException {
        return null;
    }
    
    public void log(String str){
        System.out.println("----sunrui test----:TransWorkFlowDMO::" + str);
    }


    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState#backGoing(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void backGoing(String billId, String approveId, String approveDate, String backNote) throws Exception {
        log("backGoing");
        super.executeUpdate("update lc_cancel set checkflag=null,pk_checker='" + approveId + "',checkdate = '" + approveDate +"' where pk_cancel = '" + billId + "'");
        
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState#backNoState(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void backNoState(String billId, String approveId, String approveDate, String backNote) throws Exception {
        log("backNoState");
        super.executeUpdate("update lc_cancel set checkflag=null,pk_checker=null,checkdate=null where pk_cancel = '" + billId +"'" );       
    }
}
