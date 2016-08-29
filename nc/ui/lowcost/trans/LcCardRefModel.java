/*
 * 创建日期 2005-9-27
 *
 * @author 孙锐
 */
package nc.ui.lowcost.trans;

import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.bd.b06.PsndocBO_Client;
import nc.ui.bd.ref.DefaultRefModel;

import nc.ui.pub.ClientEnvironment;

import nc.vo.bd.b04.DeptdocVO;
import nc.vo.bd.b06.PsndocVO;


/**
 * @author 孙锐
 *
 */
public class LcCardRefModel extends DefaultRefModel {
    /**
     *
     */
    public LcCardRefModel() {
        super();
        setRefTitle("物品参照");
        setFieldCode(new String[] {
                "lc_card.lccode", "lc_card.lcname", "bd_deptdoc.deptname",
                "bd_psndoc.psnname"
            });
        setFieldName(new String[] { "物品编码", "物品名称", "使用部门", "使用人" });
        setHiddenFieldCode(new String[] { "lc_card.pk_lccard" });
        setPkFieldCode("lc_card.pk_lccard");
        setTableName("lc_card inner join bd_deptdoc on lc_card.pk_usedept = bd_deptdoc.pk_deptdoc left outer join bd_psndoc on lc_card.def1 = bd_psndoc.pk_psndoc ");
        setOrderPart("lc_card.lccode");
        setDefaultFieldCount(4);

        String whereSql = " lc_card.tallyflag = 'Y' and (lc_card.cancelflag is null or lc_card.cancelflag = 'N')";

        try {
            String pk_corp = ClientEnvironment.getInstance().getCorporation()
                                              .getPrimaryKey();
            DeptdocVO condVO = new DeptdocVO();
            condVO.setPk_corp(pk_corp);

            DeptdocVO[] dcvos = DeptdocBO_Client.queryByVO(condVO,
                    new Boolean(true));
            StringBuffer deptSql = new StringBuffer();

            if ((dcvos == null) || (dcvos.length == 0)) {
                whereSql += " and 1<>1 ";
            } else {
                for (int i = 0; i < dcvos.length; i++) {
                    deptSql.append("'" + dcvos[i].getPrimaryKey() + "'");

                    if (i != (dcvos.length - 1)) {
                        deptSql.append(",");
                    }
                }

                whereSql += (" and lc_card.pk_usedept in (" +
                deptSql.toString() + ")");
            }

            PsndocVO vo = new PsndocVO();
            vo.setPk_corp(pk_corp);

            PsndocVO[] vos = PsndocBO_Client.queryByVO(vo, new Boolean(true));
            StringBuffer userSql = new StringBuffer();

            if ((vos == null) || (vos.length == 0)) {
                whereSql += " and 1<>1 ";
            } else {
                for (int i = 0; i < vos.length; i++) {
                    userSql.append("'" + vos[i].getPrimaryKey() + "'");

                    if (i != (vos.length - 1)) {
                        userSql.append(",");
                    }
                }

                whereSql += (" and (bd_psndoc.pk_psndoc in (" +
                userSql.toString() + ",'')");
                whereSql += " or bd_psndoc.pk_psndoc is null)";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //whereSql += "  ";
        setWherePart(whereSql);
    }

    /**
     * @param refNodeName
     */
    public LcCardRefModel(String refNodeName) {
        super(refNodeName);
    }
}
