/*
 * 创建日期 2005-10-9
 *
 * @author 孙锐
 */
package nc.vo.lowcost.card;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;


/**
 * @author 孙锐
 *
 */

/**
 * @author 孙锐
 *
 */
public class CardQueryVO extends ValueObject {
    /**
         *
         */
    private static final long serialVersionUID = -7587916482352734844L;
    public String[] Corp = null;
    public String[] UseDept = null;
    public String[] ManageDept = null;
    public String LcStatus = null;

    /**
     *
     */
    public CardQueryVO() {
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
     * @return 返回 corp。
     */
    public String[] getCorp() {
        return Corp;
    }

    /**
     * @param corp 要设置的 corp。
     */
    public void setCorp(String[] corp) {
        Corp = corp;
    }

    /**
     * @return 返回 lcStatus。
     */
    public String getLcStatus() {
        return LcStatus;
    }

    /**
     * @param lcStatus 要设置的 lcStatus。
     */
    public void setLcStatus(String lcStatus) {
        LcStatus = lcStatus;
    }

    /**
     * @return 返回 manageDept。
     */
    public String[] getManageDept() {
        return ManageDept;
    }

    /**
     * @param manageDept 要设置的 manageDept。
     */
    public void setManageDept(String[] manageDept) {
        ManageDept = manageDept;
    }

    /**
     * @return 返回 useDept。
     */
    public String[] getUseDept() {
        return UseDept;
    }

    /**
     * @param useDept 要设置的 useDept。
     */
    public void setUseDept(String[] useDept) {
        UseDept = useDept;
    }
}
