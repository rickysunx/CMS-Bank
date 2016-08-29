/*
 * 创建日期 2006-2-20
 *
 * @author 孙锐
 */
package nc.vo.lowcost.check;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class CheckVO extends ValueObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = -550454576183271970L;
	public String acctCode = null;
    public String pk_corp = null;
    public String unitcode = null;
    public String unitname = null;
    public UFDouble ncValue = null;
    public UFDouble bankValue = null;
    public String chkInf = null;
    
    /**
     * 
     */
    public CheckVO() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.vo.pub.ValueObject#getEntityName()
     */
    public String getEntityName() {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.pub.ValueObject#validate()
     */
    public void validate() throws ValidationException {

    }

    /**
     * @return 返回 acctCode。
     */
    public String getAcctCode() {
        return acctCode;
    }
    /**
     * @param acctCode 要设置的 acctCode。
     */
    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode;
    }
    /**
     * @return 返回 bankValue。
     */
    public UFDouble getBankValue() {
        return bankValue;
    }
    /**
     * @param bankValue 要设置的 bankValue。
     */
    public void setBankValue(UFDouble bankValue) {
        this.bankValue = bankValue;
    }
    /**
     * @return 返回 ncValue。
     */
    public UFDouble getNcValue() {
        return ncValue;
    }
    /**
     * @param ncValue 要设置的 ncValue。
     */
    public void setNcValue(UFDouble ncValue) {
        this.ncValue = ncValue;
    }
    /**
     * @return 返回 pk_corp。
     */
    public String getPk_corp() {
        return pk_corp;
    }
    /**
     * @param pk_corp 要设置的 pk_corp。
     */
    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }
    /**
     * @return 返回 chkInf。
     */
    public String getChkInf() {
        return chkInf;
    }
    /**
     * @param chkInf 要设置的 chkInf。
     */
    public void setChkInf(String chkInf) {
        this.chkInf = chkInf;
    }
    /**
     * @return 返回 unitcode。
     */
    public String getUnitcode() {
        return unitcode;
    }
    /**
     * @param unitcode 要设置的 unitcode。
     */
    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }
    /**
     * @return 返回 unitname。
     */
    public String getUnitname() {
        return unitname;
    }
    /**
     * @param unitname 要设置的 unitname。
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }
    /* （非 Javadoc）
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "[" + unitcode + "]" + unitname;
    }
}
