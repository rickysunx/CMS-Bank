/*
 * �������� 2006-2-10
 *
 * @author ����
 */
package nc.vo.lowcost.tally;

import nc.vo.pub.ValidationException;
import nc.vo.pub.ValueObject;

/**
 * @author ����
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
        // TODO �Զ����ɷ������
        return "[" + unitcode + "]" + unitname;
    }
}
