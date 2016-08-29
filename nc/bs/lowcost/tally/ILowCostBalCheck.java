/*
 * 创建日期 2006-2-8
 *
 * @author 孙锐
 */
package nc.bs.lowcost.tally;

import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public interface ILowCostBalCheck {
    public UFDouble getAccountBalance(String acctCode) throws Exception;
}
