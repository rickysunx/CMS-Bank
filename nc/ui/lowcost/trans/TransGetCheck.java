/*
 * �������� 2005-9-30
 *
 * @author ����
 */
package nc.ui.lowcost.trans;

import java.io.Serializable;

import nc.vo.trade.pub.IBDGetCheckClass;

/**
 * @author ����
 *
 */
public class TransGetCheck implements Serializable, IBDGetCheckClass {

    /**
	 * 
	 */
	private static final long serialVersionUID = 186304927590123943L;

	/**
     * 
     */
    public TransGetCheck() {
        super();
    }

    /* ���� Javadoc��
     * @see nc.vo.trade.pub.IBDGetCheckClass#getCheckClass()
     */
    public String getCheckClass() {
        return "nc.bs.lowcost.trans.TransBusiCheck";
    }

}
