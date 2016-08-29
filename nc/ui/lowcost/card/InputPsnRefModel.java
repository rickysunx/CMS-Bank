package nc.ui.lowcost.card;

import nc.ui.bd.ref.DefaultRefModel;

import java.io.Serializable;


public class InputPsnRefModel extends DefaultRefModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4761052882984779079L;

    public InputPsnRefModel() {
        super();
        setFieldCode(new String[] { "user_code", "user_name", "cuserid" });
        setFieldName(new String[] { "用户编码", "用户名称", "用户主键" });
        setPkFieldCode("cuserid");
        setTableName("sm_user");
        setOrderPart("user_code");
        setWherePart(" ");
    }

    public InputPsnRefModel(String refNodeName) {
        super(refNodeName);
    }
}
