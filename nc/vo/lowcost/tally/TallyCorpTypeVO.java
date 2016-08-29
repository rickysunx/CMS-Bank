/*
 * 创建日期 2006-6-10
 *
 * @author 孙锐
 */
package nc.vo.lowcost.tally;

import java.util.Vector;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class TallyCorpTypeVO extends ValueObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1641907073548697559L;


	/**
     * @return 返回 bank_kmbm。
     */
    public String getBank_kmbm() {
        return bank_kmbm;
    }
    /**
     * @param bank_kmbm 要设置的 bank_kmbm。
     */
    public void setBank_kmbm(String bank_kmbm) {
        this.bank_kmbm = bank_kmbm;
    }
    /**
     * @return 返回 je。
     */
    public UFDouble getJe() {
        return je;
    }
    /**
     * @param je 要设置的 je。
     */
    public void setJe(UFDouble je) {
        this.je = je;
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
     * @return 返回 pk_lctype。
     */
    public String getPk_lctype() {
        return pk_lctype;
    }
    /**
     * @param pk_lctype 要设置的 pk_lctype。
     */
    public void setPk_lctype(String pk_lctype) {
        this.pk_lctype = pk_lctype;
    }
    /**
     * @return 返回 tallyobj。
     */
    public Vector getTallyobj() {
        return tallyobj;
    }
    /**
     * @param tallyobj 要设置的 tallyobj。
     */
    public void setTallyobj(Vector tallyobj) {
        this.tallyobj = tallyobj;
    }
    public String pk_corp = null;
    public String pk_lctype = null;
    public Vector tallyobj = new Vector();
    public String bank_kmbm = null;
    public UFDouble je = new UFDouble(0.0f);
    
    
    /**
     * 
     */
    public TallyCorpTypeVO() {
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

}
