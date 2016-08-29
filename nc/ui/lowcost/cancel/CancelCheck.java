/*
 * 创建日期 2005-10-8
 *
 * @author 孙锐
 */
package nc.ui.lowcost.cancel;

import java.awt.Container;
import java.util.HashMap;

import nc.ui.lowcost.card.CardBO_Client;
import nc.ui.trade.check.BeforeActionCHK;
import nc.vo.lowcost.cancel.*;
import nc.vo.lowcost.card.CardVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.trade.checkrule.CheckRule;
import nc.vo.trade.checkrule.ICheckRule;
import nc.vo.trade.checkrule.ICheckRules;
import nc.vo.trade.checkrule.ICheckRules2;
import nc.vo.trade.checkrule.ICompareRule;
import nc.vo.trade.checkrule.ISpecialChecker;
import nc.vo.trade.checkrule.IUniqueRule;
import nc.vo.trade.checkrule.IUniqueRules;
import nc.vo.trade.checkrule.UniqueRule;
import nc.vo.trade.checkrule.VOChecker;

/**
 * @author 孙锐
 *
 */
public class CancelCheck extends BeforeActionCHK implements ICheckRules,ICheckRules2,IUniqueRules {

    /**
     * 
     */
    public CancelCheck() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.check.BeforeActionCHK#runBatchClass(java.awt.Container, java.lang.String, java.lang.String, nc.vo.pub.AggregatedValueObject[], java.lang.Object[])
     */
    public void runBatchClass(Container arg0, String arg1, String arg2, AggregatedValueObject[] arg3, Object[] arg4) throws Exception {
        
    }

    /* （非 Javadoc）
     * @see nc.ui.trade.check.BeforeActionCHK#runClass(java.awt.Container, java.lang.String, java.lang.String, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    public void runClass(Container arg0, String arg1, String arg2, AggregatedValueObject arg3, Object arg4) throws Exception {
        if(arg2!=null && arg2.equals("SAVE")){
            if(!VOChecker.check(arg3,this)){
	            throw new Exception(VOChecker.getErrorMessage());
	        }
            CancelVO vo = (CancelVO) arg3;
            if(vo==null){
                throw new Exception ("校验输入时出错，VO不能为空");
            }
            //CancelHeaderVO hvo = (CancelHeaderVO) vo.getParentVO();
            CancelItemVO[] ivos = (CancelItemVO[]) vo.getChildrenVO();
            if(ivos==null){
                throw new Exception ("校验输入时出错，子表vo不能为空");
            }
            CardVO[] cardvos = null;
            HashMap cancelmap = new HashMap();
            try{
            	cardvos = CardBO_Client.queryByWhereSqlAndWithUseDept(" a.cancelflag = 'Y' ");
              if((cardvos != null)&&(cardvos.length>0))
			  {
              	for (int k=0;k<cardvos.length;k++){
              		CardVO tmpv = new CardVO();
              		tmpv = cardvos[k];
              		String pk_lc = tmpv.getPk_lccard();
              		String cancelflag = tmpv.getCancelflag().toString();
              		if(pk_lc!=null)
              		cancelmap.put(pk_lc,cancelflag);
              	}
			  }
            }catch(Exception e){
            	
            }
            for (int i = 0; i < ivos.length; i++) {
                String pk_lccard = ivos[i].getPk_lccard();
                if((cancelmap.containsKey(pk_lccard))&&(cancelmap.get(pk_lccard)!=null)
				&&(cancelmap.get(pk_lccard).toString().equals("Y")))
                {
                	throw new Exception ("第" + (i+1) + "行，物品已经核销");	
                }
            }
        }
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getHeadCheckRules()
     */
    public ICheckRule[] getHeadCheckRules() {
        return new CheckRule[]{
                new CheckRule("单据编码","cancelcode",false,null,null)
        };
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getItemCheckRules(java.lang.String)
     */
    public ICheckRule[] getItemCheckRules(String tablecode) {
        return new CheckRule[]{
                new CheckRule("选择的物品","pk_lccard",false,null,null)
        };
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getHeadCompareRules()
     */
    public ICompareRule[] getHeadCompareRules() {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getHeadIntegerField()
     */
    public String[] getHeadIntegerField() {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getHeadUFDoubleField()
     */
    public String[] getHeadUFDoubleField() {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getItemCompareRules(java.lang.String)
     */
    public ICompareRule[] getItemCompareRules(String tablecode) {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getItemIntegerField(java.lang.String)
     */
    public String[] getItemIntegerField(String tablecode) {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getItemUFDoubleField(java.lang.String)
     */
    public String[] getItemUFDoubleField(String tablecode) {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules2#getSpecialChecker()
     */
    public ISpecialChecker getSpecialChecker() {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules2#isAllowEmptyBody(java.lang.String)
     */
    public boolean isAllowEmptyBody(String tablecode) {
        return false;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.IUniqueRules#getHeadUniqueRules()
     */
    public IUniqueRule[] getHeadUniqueRules() {
        return null;
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.IUniqueRules#getItemUniqueRules(java.lang.String)
     */
    public IUniqueRule[] getItemUniqueRules(String tablecode) {
        return new IUniqueRule [] {
                new UniqueRule("要核销的物品重复",new String []{"pk_lccard"})
        };
    }

}
