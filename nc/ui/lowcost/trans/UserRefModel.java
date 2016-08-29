/*
 * 创建日期 2005-12-3
 *
 * @author 孙锐
 */
package nc.ui.lowcost.trans;

import nc.ui.bd.ref.DefaultRefModel;
import nc.ui.pub.ClientEnvironment;

/**
 * @author 孙锐
 *
 */
public class UserRefModel extends DefaultRefModel {

    /**
     * 
     */
    public UserRefModel() {
        super();
        String pk_corp = ClientEnvironment.getInstance().getCorporation().getPk_corp();
        setFieldCode(new String[] { "user_code", "user_name","cuserid" });
        setFieldName(new String[] { "用户编码", "用户名称","主键" });
        setPkFieldCode("cuserid");
        setTableName("sm_user");
        setOrderPart("user_code");
        setWherePart(" cuserid in (select cuserid from sm_userandcorp where pk_corp = '" + pk_corp + "') ");
    }

    /**
     * @param refNodeName
     */
    public UserRefModel(String refNodeName) {
        super(refNodeName);
        // TODO 自动生成构造函数存根
    }

}
