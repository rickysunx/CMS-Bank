/*
 * 创建日期 2005-9-30
 *
 * @author 孙锐
 */
package nc.ui.lowcost.trans;

import java.awt.Container;
import java.util.HashMap;

import nc.ui.trade.check.BeforeActionCHK;
import nc.ui.lowcost.card.*;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.trans.TransItemVO;
import nc.vo.lowcost.trans.TransVO;
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
public class TransCheck extends BeforeActionCHK implements ICheckRules,ICheckRules2,IUniqueRules {

    /**
     * 
     */
    public TransCheck() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.pf.IUIBeforeProcAction#runBatchClass(java.awt.Container, java.lang.String, java.lang.String, nc.vo.pub.AggregatedValueObject[], java.lang.Object[])
     */
    public void runBatchClass(Container arg0, String arg1, String arg2,
            AggregatedValueObject[] arg3, Object[] arg4) throws Exception {

    }

    /* （非 Javadoc）
     * @see nc.ui.pub.pf.IUIBeforeProcAction#runClass(java.awt.Container, java.lang.String, java.lang.String, nc.vo.pub.AggregatedValueObject, java.lang.Object)
     */
    public void runClass(Container arg0, String arg1, String arg2,
            AggregatedValueObject arg3, Object arg4) throws Exception {
        if(arg2!=null && arg2.equals("SAVE")){
            if(!VOChecker.check(arg3,this)){
	            throw new Exception(VOChecker.getErrorMessage());
	        }
            
            //校验调入调出部门
            TransVO vo = (TransVO) arg3;
            if(vo==null){
                throw new Exception ("校验输入时出错，VO不能为空");
            }
            //TransHeaderVO hvo = (TransHeaderVO) vo.getParentVO();
            TransItemVO [] ivos = (TransItemVO[]) vo.getChildrenVO();
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
                String pk_deptfrom = ivos[i].getPk_deptfrom();
                String pk_deptto = ivos[i].getPk_deptto();
                //ryh 20060517 edit
                String pk_lccard = ivos[i].getPk_lccard();
                if(pk_deptto==null){
                    throw new Exception ("第" + (i+1) + "行，调入部门不能为空");
                }
                if(pk_deptto.equals(pk_deptfrom)){
                    throw new Exception ("第" + (i+1) + "行，调入和调出部门不能是同一个部门");
                }
                if((cancelmap.containsKey(pk_lccard))&&(cancelmap.get(pk_lccard)!=null)
				&&(cancelmap.get(pk_lccard).toString().equals("Y")))
                {
                	throw new Exception ("第" + (i+1) + "行，物品已经核销");	
                }
            }

        }
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
     * @see nc.vo.trade.checkrule.ICheckRules#getHeadCheckRules()
     */
    public ICheckRule[] getHeadCheckRules() {
        return new CheckRule[]{
                new CheckRule("单据编码","transcode",false,null,null)
        };
    }

    /* （非 Javadoc）
     * @see nc.vo.trade.checkrule.ICheckRules#getItemCheckRules(java.lang.String)
     */
    public ICheckRule[] getItemCheckRules(String tablecode) {
        return new CheckRule[]{
                new CheckRule("选择的物品","pk_lccard",false,null,null),
                new CheckRule("调入部门","pk_deptto",false,null,null)
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
                new UniqueRule("要调拨的物品重复",new String []{"pk_lccard"})
        };
    }

}
