/*
 * �������� 2006-2-20
 *
 * @author ����
 */
package nc.vo.lowcost.check;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;
import nc.vo.pub.lang.UFDouble;

/**
 * @author ����
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

    /* ���� Javadoc��
     * @see nc.vo.pub.ValueObject#getEntityName()
     */
    public String getEntityName() {
        return null;
    }

    /* ���� Javadoc��
     * @see nc.vo.pub.ValueObject#validate()
     */
    public void validate() throws ValidationException {

    }

    /**
     * @return ���� acctCode��
     */
    public String getAcctCode() {
        return acctCode;
    }
    /**
     * @param acctCode Ҫ���õ� acctCode��
     */
    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode;
    }
    /**
     * @return ���� bankValue��
     */
    public UFDouble getBankValue() {
        return bankValue;
    }
    /**
     * @param bankValue Ҫ���õ� bankValue��
     */
    public void setBankValue(UFDouble bankValue) {
        this.bankValue = bankValue;
    }
    /**
     * @return ���� ncValue��
     */
    public UFDouble getNcValue() {
        return ncValue;
    }
    /**
     * @param ncValue Ҫ���õ� ncValue��
     */
    public void setNcValue(UFDouble ncValue) {
        this.ncValue = ncValue;
    }
    /**
     * @return ���� pk_corp��
     */
    public String getPk_corp() {
        return pk_corp;
    }
    /**
     * @param pk_corp Ҫ���õ� pk_corp��
     */
    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }
    /**
     * @return ���� chkInf��
     */
    public String getChkInf() {
        return chkInf;
    }
    /**
     * @param chkInf Ҫ���õ� chkInf��
     */
    public void setChkInf(String chkInf) {
        this.chkInf = chkInf;
    }
    /**
     * @return ���� unitcode��
     */
    public String getUnitcode() {
        return unitcode;
    }
    /**
     * @param unitcode Ҫ���õ� unitcode��
     */
    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }
    /**
     * @return ���� unitname��
     */
    public String getUnitname() {
        return unitname;
    }
    /**
     * @param unitname Ҫ���õ� unitname��
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }
    /* ���� Javadoc��
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "[" + unitcode + "]" + unitname;
    }
}
