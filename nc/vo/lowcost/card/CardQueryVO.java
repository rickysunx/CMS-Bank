/*
 * �������� 2005-10-9
 *
 * @author ����
 */
package nc.vo.lowcost.card;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;


/**
 * @author ����
 *
 */

/**
 * @author ����
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
     * @return ���� corp��
     */
    public String[] getCorp() {
        return Corp;
    }

    /**
     * @param corp Ҫ���õ� corp��
     */
    public void setCorp(String[] corp) {
        Corp = corp;
    }

    /**
     * @return ���� lcStatus��
     */
    public String getLcStatus() {
        return LcStatus;
    }

    /**
     * @param lcStatus Ҫ���õ� lcStatus��
     */
    public void setLcStatus(String lcStatus) {
        LcStatus = lcStatus;
    }

    /**
     * @return ���� manageDept��
     */
    public String[] getManageDept() {
        return ManageDept;
    }

    /**
     * @param manageDept Ҫ���õ� manageDept��
     */
    public void setManageDept(String[] manageDept) {
        ManageDept = manageDept;
    }

    /**
     * @return ���� useDept��
     */
    public String[] getUseDept() {
        return UseDept;
    }

    /**
     * @param useDept Ҫ���õ� useDept��
     */
    public void setUseDept(String[] useDept) {
        UseDept = useDept;
    }
}
