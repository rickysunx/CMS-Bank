/*
 * �������� 2005-10-8
 *
 * @author ����
 */
package nc.ui.lowcost.cancel;

import java.io.Serializable;

import nc.vo.trade.pub.IBDGetCheckClass;

/**
 * @author ����
 *
 */
public class CancelGetCheck implements Serializable, IBDGetCheckClass {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5447529210054336238L;

	/**
     * 
     */
    public CancelGetCheck() {
        super();
    }

    /* ���� Javadoc��
     * @see nc.vo.trade.pub.IBDGetCheckClass#getCheckClass()
     */
    public String getCheckClass() {
        return "nc.ui.lowcost.cancel.CancelCheck";
    }

}
