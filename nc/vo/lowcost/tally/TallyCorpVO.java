/*
 * 创建日期 2006-2-10
 *
 * @author 孙锐
 */
package nc.vo.lowcost.tally;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;

/**
 * @author 孙锐
 *
 */
public class TallyCorpVO extends ValueObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2469486265011038204L;
	public String pk_corp = null;
    public String unitcode = null;
    public String unitname = null;
    /**
     * 
     */
    public TallyCorpVO() {
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
        // TODO 自动生成方法存根
        return "[" + unitcode + "]" + unitname;
    }
}
