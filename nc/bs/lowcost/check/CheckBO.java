/*
 * 创建日期 2006-2-19
 *
 * @author 孙锐
 */
package nc.bs.lowcost.check;

import java.rmi.RemoteException;
import java.util.Date;

import nc.bs.pub.BusinessObject;
import nc.bs.zjnx.expvoucher.VoucherDealDMO;
import nc.vo.lowcost.check.CheckVO;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class CheckBO extends BusinessObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2603374697834163064L;

	/**
     * 
     */
    public CheckBO() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.BusinessObject#ejbCreate()
     */
    public void ejbCreate() throws RemoteException {
    }

    public CheckVO [] doCheck(CheckVO [] vos) throws RemoteException {
        try {
            CheckDMO dmo = new CheckDMO();
	        if(vos!=null){
	            for (int i = 0; i < vos.length; i++) {
	                try {
	                    UFDouble ncValue = dmo.getLcBalance(vos[i].getPk_corp());
	                    vos[i].setNcValue(ncValue);
	                    UFDouble bankValue = (new VoucherDealDMO()).getSubjBanlance(vos[i].getPk_corp(),vos[i].getAcctCode(),new UFDate(new Date()));
	                    vos[i].setBankValue(bankValue);
	                    if(ncValue!=null && bankValue!=null && ncValue.compareTo(bankValue)==0){
	                        vos[i].setChkInf("平");
	                    } else {
	                        vos[i].setChkInf("不平");
	                    }
	                } catch (Exception e){
	                    e.printStackTrace();
	                    vos[i].setChkInf("对账出错："+e.getMessage());
	                }
	            }
	        }
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
        return vos;
    }
    
    public CheckVO [] queryCheck (String pk_user) throws RemoteException {
        CheckVO [] vos = null;
        try {
            CheckDMO dmo = new CheckDMO();
            vos = dmo.queryCheck(pk_user);
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
        return vos;
    }
    
    public CheckVO [] doTypeCorpCheck(String pk_corp) throws RemoteException {
        CheckVO [] vos = null;
        try {
            CheckDMO dmo = new CheckDMO();
            vos = dmo.queryCorpTypeCheckVO(pk_corp);
            if(vos!=null){
                for (int i = 0; i < vos.length; i++) {
                    try {
                        nc.bs.nhnx.expvoucher.VoucherDealDMO vdmo = new nc.bs.nhnx.expvoucher.VoucherDealDMO();
                    	vos[i].setBankValue(vdmo.getSubjBalance(pk_corp,vos[i].getAcctCode(),new UFDate(new Date())));
                    	if(vos[i].ncValue!=null && vos[i].getBankValue()!=null){
                    	    if(vos[i].ncValue.compareTo(vos[i].bankValue)==0){
                    	        vos[i].setChkInf("平");
                    	    } else {
                    	        vos[i].setChkInf("不平");
                    	    }
                    	}
                    } catch (Exception e){
                        e.printStackTrace();
                        vos[i].setChkInf("对账出错："+e.getMessage());
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException (e.getMessage());
        }

        return vos;
    }
}
