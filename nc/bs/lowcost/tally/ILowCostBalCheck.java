/*
 * �������� 2006-2-8
 *
 * @author ����
 */
package nc.bs.lowcost.tally;

import nc.vo.pub.lang.UFDouble;

/**
 * @author ����
 *
 */
public interface ILowCostBalCheck {
    public UFDouble getAccountBalance(String acctCode) throws Exception;
}
