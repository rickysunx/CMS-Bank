/*
 * 创建日期 2005-10-12
 *
 * @author 孙锐
 */
package nc.bs.lowcost.trans;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.naming.NamingException;

import nc.bs.pub.DataManageObject;
import nc.bs.pub.SystemException;
import nc.vo.dap.voucher.MsgAggregatedStruct;
import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.CircularlyAccessibleValueObject;

/**
 * @author 孙锐
 *
 */
public class TransWorkFlowDMO extends DataManageObject implements nc.bs.dmp.outinteface.IDmpGetData, nc.bs.dap.out.IAccountProcMsg,nc.bs.pub.pf.IQueryData,nc.bs.pub.pf.ICheckState3, nc.bs.pub.pf.IBackCheckState,nc.bs.dap.out.IAccountProcMsgInBulk {

    /**
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public TransWorkFlowDMO() throws NamingException, SystemException {
        super();
    }

    /**
     * @param dbName
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public TransWorkFlowDMO(String dbName) throws NamingException,
            SystemException {
        super(dbName);
        // TODO 自动生成构造函数存根
    }

    /* （非 Javadoc）
     * @see nc.bs.dmp.outinteface.IDmpGetData#queryDataByProcId(java.lang.String, java.lang.String, java.lang.String)
     */
    public CircularlyAccessibleValueObject[] queryDataByProcId(String billType, String billId, String ManaCode) throws RemoteException {
        // TODO 自动生成方法存根
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.dap.out.IAccountProcMsg#queryDataByProcId(java.lang.String, java.lang.String)
     */
    public AggregatedValueObject queryDataByProcId(String billTypeOrProc, String procMsg) throws SQLException {
        // TODO 自动生成方法存根
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IQueryData#queryAllBodyData(java.lang.String)
     */
    public CircularlyAccessibleValueObject[] queryAllBodyData(String key) throws SQLException {
        // TODO 自动生成方法存根
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IQueryData#queryAllHeadData(java.lang.String)
     */
    public CircularlyAccessibleValueObject[] queryAllHeadData(String whereString) throws SQLException {
        // TODO 自动生成方法存根
        return null;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.ICheckState3#checkGoing(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean checkGoing(AggregatedValueObject vo, String ApproveId, String ApproveDate, String checkNote) throws Exception {
        // TODO 自动生成方法存根
        log("checkGoing");
        String pk_trans = ((TransHeaderVO)vo.getParentVO()).getPk_trans();
        super.executeUpdate("update lc_trans set checkflag=null,pk_checker='" + ApproveId + "',checkdate = '" + ApproveDate +"' where pk_trans = '" + pk_trans + "'");
        return false;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.ICheckState3#checkNoPass(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean checkNoPass(AggregatedValueObject vo, String ApproveId, String ApproveDate, String checkNote) throws Exception {
        // TODO 自动生成方法存根
        log("checkNoPass");
        String pk_trans = ((TransHeaderVO)vo.getParentVO()).getPk_trans();
        super.executeUpdate("update lc_trans set checkflag = 'N',pk_checker = '" + ApproveId + "', checkdate = '" + ApproveDate + "' where pk_trans = '" + pk_trans + "'");
        return false;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.ICheckState3#checkPass(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean checkPass(AggregatedValueObject vo, String ApproveId, String ApproveDate, String checkNote) throws Exception {
        // TODO 自动生成方法存根
        log("checkPass");
        String pk_trans = ((TransHeaderVO)vo.getParentVO()).getPk_trans();
        ((TransHeaderVO)vo.getParentVO()).setPk_checker(ApproveId);
        super.executeUpdate("update lc_trans set checkflag = 'Y',pk_checker = '" + ApproveId + "', checkdate = '" + ApproveDate + "' where pk_trans = '" + pk_trans + "'");
        return false;
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState3#backGoing(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
//    public void backGoing(AggregatedValueObject vo, String approveId, String approveDate, String backNote) throws Exception {
//        
//        log("backGoing");
//        String pk_trans = ((TransHeaderVO)vo.getParentVO()).getPk_trans();
//        super.executeUpdate("update lc_trans set checkflag=null,pk_checker='" + approveId + "',checkdate = '" + approveDate +"' where pk_trans = '" + pk_trans + "'");
//    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState3#backNoState(nc.vo.pub.AggregatedValueObject, java.lang.String, java.lang.String, java.lang.String)
     */
//    public void backNoState(AggregatedValueObject vo, String approveId, String approveDate, String backNote) throws Exception {
//        // TODO 自动生成方法存根
//        log("backNoState");
//        String pk_trans = ((TransHeaderVO)vo.getParentVO()).getPk_trans();
//        super.executeUpdate("update lc_trans set checkflag=null,pk_checker=null,checkdate=null where pk_trans = '" + pk_trans +"'" );
//    }

    /* （非 Javadoc）
     * @see nc.bs.dap.out.IAccountProcMsgInBulk#queryDataByProcIds(java.lang.String, java.lang.String[])
     */
    public MsgAggregatedStruct[] queryDataByProcIds(String billTypeOrProc, String[] procMsg) throws SQLException {
        // TODO 自动生成方法存根
        return null;
    }
    
    public void log(String str){
        System.out.println("----sunrui test----:TransWorkFlowDMO::" + str);
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState2#backGoing(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
//    public void backGoing(String tableName, String pkFieldName, String billId, String approveId, String approveDate, String backNote) throws Exception {
//        // TODO 自动生成方法存根
//        log("backGoing");
//        super.executeUpdate("update lc_trans set checkflag=null,pk_checker='" + approveId + "',checkdate = '" + approveDate +"' where transcode = '" + billId + "'");        
//    }
//
//    /* （非 Javadoc）
//     * @see nc.bs.pub.pf.IBackCheckState2#backNoState(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
//     */
//    public void backNoState(String tableName, String pkFieldName, String billId, String approveId, String approveDate, String backNote) throws Exception {
//        // TODO 自动生成方法存根
//        log("backNoState");
//        super.executeUpdate("update lc_trans set checkflag=null,pk_checker=null,checkdate=null where pk_trans = '" + billId +"'" );        
//    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState#backGoing(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void backGoing(String billId, String approveId, String approveDate, String backNote) throws Exception {
        // TODO 自动生成方法存根
        log("----------反审核测试：----------backGoing");
        super.executeUpdate("update lc_trans set checkflag=null,pk_checker='" + approveId + "',checkdate = '" + approveDate +"' where pk_trans = '" + billId + "'");           
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.pf.IBackCheckState#backNoState(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void backNoState(String billId, String approveId, String approveDate, String backNote) throws Exception {
        // TODO 自动生成方法存根
        log("----------反审核测试：----------backNoState");
        super.executeUpdate("update lc_trans set checkflag=null,pk_checker=null,checkdate=null where pk_trans = '" + billId +"'" );           
    }
}
