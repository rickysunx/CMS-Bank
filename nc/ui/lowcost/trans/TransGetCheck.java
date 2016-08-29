/*
 * 创建日期 2005-9-30
 *
 * @author 孙锐
 */
package nc.ui.lowcost.trans;

import java.io.Serializable;

import nc.vo.trade.pub.IBDGetCheckClass;

/**
 * @author 孙锐
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

    /* （非 Javadoc）
     * @see nc.vo.trade.pub.IBDGetCheckClass#getCheckClass()
     */
    public String getCheckClass() {
        return "nc.bs.lowcost.trans.TransBusiCheck";
    }

}
