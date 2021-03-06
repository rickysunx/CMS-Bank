/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product.                              *
\***************************************************************/
package nc.vo.lowcost.card;

import nc.vo.pub.*;
import nc.vo.pub.lang.*;


/**
 * 此处插入类型说明。
 *
 * 创建日期：(2005-9-16)
 * @author：
 */
public class CardVO extends CircularlyAccessibleValueObject {
    /**
     *
     */
    private static final long serialVersionUID = -8646323942670583410L;

    /**
     *     描述上面属性的FieldObjects。主要用于系统工具中，
     * 业务代码中不会用到下面的FieldObjects。
     */
    private static StringField m_pk_lccardField;
    private static StringField m_lccodeField;
    private static StringField m_lcnameField;
    private static StringField m_pk_lctypeField;
    private static StringField m_pk_managedeptField;
    private static StringField m_pk_usedeptField;
    private static UFBooleanField m_tallyflagField;
    private static UFBooleanField m_cancelflagField;
    private static UFDateField m_buydateField;
    private static UFDateField m_adddateField;
    private static UFDateField m_tallydateField;
    private static UFDateField m_canceldateField;
    private static UFDoubleField m_priceField;
    private static UFDoubleField m_numberField;
    private static StringField m_remarkField;
    private static StringField m_def1Field;
    private static StringField m_def2Field;
    private static StringField m_def3Field;
    private static StringField m_def4Field;
    private static StringField m_def5Field;
    public String m_pk_lccard;
    public String m_lccode;
    public String m_lcname;
    public String m_pk_lctype;
    public String m_pk_managedept;
    public String m_pk_usedept;
    public UFBoolean m_tallyflag;
    public UFBoolean m_cancelflag;
    public UFDate m_buydate;
    public UFDate m_adddate;
    public UFDate m_tallydate;
    public UFDate m_canceldate;
    public UFDouble m_price;
    public UFDouble m_number;
    public String m_remark;
    public String m_def1; //增加作为：使用人
    public String m_def2;
    public String m_def3;
    public String m_def4;
    public String m_def5; //录入人
    public String m_status;
    public String m_pk_corp;
    public boolean m_inclusub; //是否包含下级
    public String m_loginuser;
    public String dep;
    public String psn;

    //增加的代码
    private String type;
    private UFDouble pricestart;
    private UFDouble priceend;
    private UFDouble amountstart;
    private UFDouble amountend;
    private String user = null;
    private String totalpricestart = null;
    private String totalpriceend = null;
    private UFDate addDateEnd = null;
    private UFDate buyDateEnd = null;
    private UFDate destroyEnd = null;

    //private static BooleanField m_inclusubField;
    /**
     * 使用主键字段进行初始化的构造子。
     *
     * 创建日期：(2005-9-16)
     */
    public CardVO() {
    }

    /**
     * 使用主键进行初始化的构造子。
     *
     * 创建日期：(2005-9-16)
     * @param ??fieldNameForMethod?? 主键值
     */
    public CardVO(String newPk_lccard) {
        // 为主键字段赋值:
        m_pk_lccard = newPk_lccard;
    }

    /**
     * 根类Object的方法,克隆这个VO对象。
     *
     * 创建日期：(2005-9-16)
     */
    public Object clone() {
        // 复制基类内容并创建新的VO对象：
        Object o = null;

        try {
            o = super.clone();
        } catch (Exception e) {
        }

        CardVO card = (CardVO) o;

        // 你在下面复制本VO对象的所有属性：
        return card;
    }

    /**
     * 返回数值对象的显示名称。
     *
     * 创建日期：(2005-9-16)
     * @return java.lang.String 返回数值对象的显示名称。
     */
    public String getEntityName() {
        return "Card";
    }

    /**
     * 返回对象标识，用来唯一定位对象。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getPrimaryKey() {
        return m_pk_lccard;
    }

    /**
     * 设置对象标识，用来唯一定位对象。
     *
     * 创建日期：(2005-9-16)
     * @param m_pk_lccard String
     */
    public void setPrimaryKey(String newPk_lccard) {
        m_pk_lccard = newPk_lccard;
    }

    /**
     * 属性m_pk_lccard的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getPk_lccard() {
        return m_pk_lccard;
    }

    /**
     * 属性m_lccode的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getLccode() {
        return m_lccode;
    }

    /**
     * 属性m_lcname的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getLcname() {
        return m_lcname;
    }

    /**
     * 属性m_pk_lctype的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getPk_lctype() {
        return m_pk_lctype;
    }

    /**
     * 属性m_pk_managedept的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getPk_managedept() {
        return m_pk_managedept;
    }

    /**
     * 属性m_pk_usedept的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getPk_usedept() {
        return m_pk_usedept;
    }

    /**
     * 属性m_tallyflag的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFBoolean
     */
    public UFBoolean getTallyflag() {
        return m_tallyflag;
    }

    public boolean getInclusub() {
        return m_inclusub;
    }

    /**
     * 属性m_cancelflag的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFBoolean
     */
    public UFBoolean getCancelflag() {
        return m_cancelflag;
    }

    /**
     * 属性m_buydate的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFDate
     */
    public UFDate getBuydate() {
        return m_buydate;
    }

    /**
     * 属性m_adddate的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFDate
     */
    public UFDate getAdddate() {
        return m_adddate;
    }

    /**
     * 属性m_tallydate的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFDate
     */
    public UFDate getTallydate() {
        return m_tallydate;
    }

    /**
     * 属性m_canceldate的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFDate
     */
    public UFDate getCanceldate() {
        return m_canceldate;
    }

    /**
     * 属性m_price的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFDouble
     */
    public UFDouble getPrice() {
        return m_price;
    }

    /**
     * 属性m_number的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return UFDouble
     */
    public UFDouble getNumber() {
        return m_number;
    }

    /**
     * 属性m_remark的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getRemark() {
        return m_remark;
    }

    /**
     * 属性m_def1的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getDef1() {
        return m_def1;
    }

    /**
     * 属性m_def2的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getDef2() {
        return m_def2;
    }

    /**
     * 属性m_def3的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getDef3() {
        return m_def3;
    }

    /**
     * 属性m_def4的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getDef4() {
        return m_def4;
    }

    /**
     * 属性m_def5的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return String
     */
    public String getDef5() {
        return m_def5;
    }

    /**
     * 属性m_pk_lccard的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_pk_lccard String
     */
    public void setPk_lccard(String newPk_lccard) {
        m_pk_lccard = newPk_lccard;
    }

    /**
     * 属性m_lccode的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_lccode String
     */
    public void setLccode(String newLccode) {
        m_lccode = newLccode;
    }

    /**
     * 属性m_lcname的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_lcname String
     */
    public void setLcname(String newLcname) {
        m_lcname = newLcname;
    }

    /**
     * 属性m_pk_lctype的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_pk_lctype String
     */
    public void setPk_lctype(String newPk_lctype) {
        m_pk_lctype = newPk_lctype;
    }

    /**
     * 属性m_pk_managedept的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_pk_managedept String
     */
    public void setPk_managedept(String newPk_managedept) {
        m_pk_managedept = newPk_managedept;
    }

    /**
     * 属性m_pk_usedept的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_pk_usedept String
     */
    public void setPk_usedept(String newPk_usedept) {
        m_pk_usedept = newPk_usedept;
    }

    /**
     * 属性m_tallyflag的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_tallyflag UFBoolean
     */
    public void setTallyflag(UFBoolean newTallyflag) {
        m_tallyflag = newTallyflag;
    }

    public void setInclusub(boolean newflag) {
        m_inclusub = newflag;
    }

    /**
     * 属性m_cancelflag的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_cancelflag UFBoolean
     */
    public void setCancelflag(UFBoolean newCancelflag) {
        m_cancelflag = newCancelflag;
    }

    /**
     * 属性m_buydate的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_buydate UFDate
     */
    public void setBuydate(UFDate newBuydate) {
        m_buydate = newBuydate;
    }

    /**
     * 属性m_adddate的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_adddate UFDate
     */
    public void setAdddate(UFDate newAdddate) {
        m_adddate = newAdddate;
    }

    /**
     * 属性m_tallydate的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_tallydate UFDate
     */
    public void setTallydate(UFDate newTallydate) {
        m_tallydate = newTallydate;
    }

    /**
     * 属性m_canceldate的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_canceldate UFDate
     */
    public void setCanceldate(UFDate newCanceldate) {
        m_canceldate = newCanceldate;
    }

    /**
     * 属性m_price的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_price UFDouble
     */
    public void setPrice(UFDouble newPrice) {
        m_price = newPrice;
    }

    /**
     * 属性m_number的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_number UFDouble
     */
    public void setNumber(UFDouble newNumber) {
        m_number = newNumber;
    }

    /**
     * 属性m_remark的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_remark String
     */
    public void setRemark(String newRemark) {
        m_remark = newRemark;
    }

    /**
     * 属性m_def1的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_def1 String
     */
    public void setDef1(String newDef1) {
        m_def1 = newDef1;
    }

    /**
     * 属性m_def2的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_def2 String
     */
    public void setDef2(String newDef2) {
        m_def2 = newDef2;
    }

    /**
     * 属性m_def3的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_def3 String
     */
    public void setDef3(String newDef3) {
        m_def3 = newDef3;
    }

    /**
     * 属性m_def4的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_def4 String
     */
    public void setDef4(String newDef4) {
        m_def4 = newDef4;
    }

    /**
     * 属性m_def5的setter方法。
     *
     * 创建日期：(2005-9-16)
     * @param newM_def5 String
     */
    public void setDef5(String newDef5) {
        m_def5 = newDef5;
    }

    /**
     * 验证对象各属性之间的数据逻辑正确性。
     *
     * 创建日期：(2005-9-16)
     * @exception nc.vo.pub.ValidationException 如果验证失败，抛出
     *     ValidationException，对错误进行解释。
     */

    /*public void validate() throws ValidationException {
    
            ArrayList errFields = new ArrayList(); // errFields record those null fields that cannot be null.
            // 检查是否为不允许空的字段赋了空值，你可能需要修改下面的提示信息：
            if (m_pk_lccard == null) {
                    errFields.add(new String("m_pk_lccard"));
            }
            // construct the exception message:
            StringBuffer message = new StringBuffer();
            message.append("下列字段不能为空：");
            if (errFields.size() > 0) {
                    String[] temp = (String[]) errFields.toArray(new String[0]);
                    message.append(temp[0]);
                    for ( int i= 1; i < temp.length; i++ ) {
                            message.append("、");
                            message.append(temp[i]);
                    }
                    // throw the exception:
                    //throw new NullFieldException(message.toString());
            }
    }*/
    public void validate() throws ValidationException {
    }

    /**
     * <p>需要在一个循环中访问的属性的名称数组。
     * <p>
     * 创建日期：(??Date??)
     * @return java.lang.String[]
     */
    public java.lang.String[] getAttributeNames() {
        return new String[] {
            "lccode", "lcname", "pk_lctype", "pk_managedept", "pk_usedept",
            "tallyflag", "cancelflag", "buydate", "adddate", "tallydate",
            "canceldate", "price", "number", "remark", "def1", "def2", "def3",
            "def4", "def5"
        };
    }

    /**
     *  <p>根据一个属性名称字符串该属性的值。
     *  <p>
     * 创建日期：(2005-9-16)
     * @param key java.lang.String
     */
    public Object getAttributeValue(String attributeName) {
        if (attributeName.equals("pk_lccard")) {
            return m_pk_lccard;
        } else if (attributeName.equals("lccode")) {
            return m_lccode;
        } else if (attributeName.equals("lcname")) {
            return m_lcname;
        } else if (attributeName.equals("pk_lctype")) {
            return m_pk_lctype;
        } else if (attributeName.equals("pk_managedept")) {
            return m_pk_managedept;
        } else if (attributeName.equals("pk_usedept")) {
            return m_pk_usedept;
        } else if (attributeName.equals("tallyflag")) {
            return m_tallyflag;
        } else if (attributeName.equals("cancelflag")) {
            return m_cancelflag;
        } else if (attributeName.equals("buydate")) {
            return m_buydate;
        } else if (attributeName.equals("adddate")) {
            return m_adddate;
        } else if (attributeName.equals("tallydate")) {
            return m_tallydate;
        } else if (attributeName.equals("canceldate")) {
            return m_canceldate;
        } else if (attributeName.equals("price")) {
            return m_price;
        } else if (attributeName.equals("number")) {
            return m_number;
        } else if (attributeName.equals("remark")) {
            return m_remark;
        } else if (attributeName.equals("def1")) {
            return m_def1;
        } else if (attributeName.equals("def2")) {
            return m_def2;
        } else if (attributeName.equals("def3")) {
            return m_def3;
        } else if (attributeName.equals("def4")) {
            return m_def4;
        } else if (attributeName.equals("def5")) {
            return m_def5;
        } else if (attributeName.equals("lcstatus")) {
            String lcstatus = null;

            if ((m_tallyflag == null) || (m_tallyflag.booleanValue() == false)) {
                lcstatus = "未记账";
            }

            if (((m_tallyflag != null) && (m_tallyflag.booleanValue() == true)) &&
                    ((m_cancelflag == null) ||
                    (m_cancelflag.booleanValue() == false))) {
                lcstatus = "已记账";
            }

            if ((m_cancelflag != null) &&
                    (m_cancelflag.booleanValue() == true)) {
                lcstatus = "已核销";
            }

            return lcstatus;
        }

        return null;
    }

    /**
     *  <p>对参数name对型的属性设置值。
     *  <p>
     * 创建日期：(2005-9-16)
     * @param key java.lang.String
     */
    public void setAttributeValue(String name, Object value) {
        try {
            if (name.equals("pk_lccard")) {
                m_pk_lccard = (String) value;
            } else if (name.equals("lccode")) {
                m_lccode = (String) value;
            } else if (name.equals("lcname")) {
                m_lcname = (String) value;
            } else if (name.equals("pk_lctype")) {
                m_pk_lctype = (String) value;
            } else if (name.equals("pk_managedept")) {
                m_pk_managedept = (String) value;
            } else if (name.equals("pk_usedept")) {
                m_pk_usedept = (String) value;
            } else if (name.equals("tallyflag")) {
                m_tallyflag = (UFBoolean) value;
            } else if (name.equals("cancelflag")) {
                m_cancelflag = (UFBoolean) value;
            } else if (name.equals("buydate")) {
                m_buydate = (UFDate) value;
            } else if (name.equals("adddate")) {
                m_adddate = (UFDate) value;
            } else if (name.equals("tallydate")) {
                m_tallydate = (UFDate) value;
            } else if (name.equals("canceldate")) {
                m_canceldate = (UFDate) value;
            } else if (name.equals("price")) {
                m_price = (UFDouble) value;
            } else if (name.equals("number")) {
                m_number = (UFDouble) value;
            } else if (name.equals("remark")) {
                m_remark = (String) value;
            } else if (name.equals("def1")) {
                m_def1 = (String) value;
            } else if (name.equals("def2")) {
                m_def2 = (String) value;
            } else if (name.equals("def3")) {
                m_def3 = (String) value;
            } else if (name.equals("def4")) {
                m_def4 = (String) value;
            } else if (name.equals("def5")) {
                m_def5 = (String) value;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("setAttributeValue方法中为 " + name +
                " 赋值时类型转换错误！（值：" + value + "）");
        }
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_lccardField() {
        if (m_pk_lccardField == null) {
            try {
                m_pk_lccardField = new StringField();
                // 属性的名称
                m_pk_lccardField.setName("pk_lccard");
                // 属性的描述
                m_pk_lccardField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_lccardField;
    }

    public String getPk_corp() {
        return m_pk_corp;
    }

    public String getLoginuser() {
        return m_loginuser;
    }

    public void setPk_corp(String newPk_corp) {
        m_pk_corp = newPk_corp;
    }

    public void setLoginuser(String user) {
        m_loginuser = user;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getLccodeField() {
        if (m_lccodeField == null) {
            try {
                m_lccodeField = new StringField();
                // 属性的名称
                m_lccodeField.setName("lccode");
                // 属性的描述
                m_lccodeField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_lccodeField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getLcnameField() {
        if (m_lcnameField == null) {
            try {
                m_lcnameField = new StringField();
                // 属性的名称
                m_lcnameField.setName("lcname");
                // 属性的描述
                m_lcnameField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_lcnameField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_lctypeField() {
        if (m_pk_lctypeField == null) {
            try {
                m_pk_lctypeField = new StringField();
                // 属性的名称
                m_pk_lctypeField.setName("pk_lctype");
                // 属性的描述
                m_pk_lctypeField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_lctypeField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_managedeptField() {
        if (m_pk_managedeptField == null) {
            try {
                m_pk_managedeptField = new StringField();
                // 属性的名称
                m_pk_managedeptField.setName("pk_managedept");
                // 属性的描述
                m_pk_managedeptField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_managedeptField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_usedeptField() {
        if (m_pk_usedeptField == null) {
            try {
                m_pk_usedeptField = new StringField();
                // 属性的名称
                m_pk_usedeptField.setName("pk_usedept");
                // 属性的描述
                m_pk_usedeptField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_usedeptField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFBooleanField getTallyflagField() {
        if (m_tallyflagField == null) {
            try {
                m_tallyflagField = new UFBooleanField();
                // 属性的名称
                m_tallyflagField.setName("tallyflag");
                // 属性的描述
                m_tallyflagField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_tallyflagField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFBooleanField getCancelflagField() {
        if (m_cancelflagField == null) {
            try {
                m_cancelflagField = new UFBooleanField();
                // 属性的名称
                m_cancelflagField.setName("cancelflag");
                // 属性的描述
                m_cancelflagField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_cancelflagField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getBuydateField() {
        if (m_buydateField == null) {
            try {
                m_buydateField = new UFDateField();
                // 属性的名称
                m_buydateField.setName("buydate");
                // 属性的描述
                m_buydateField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_buydateField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getAdddateField() {
        if (m_adddateField == null) {
            try {
                m_adddateField = new UFDateField();
                // 属性的名称
                m_adddateField.setName("adddate");
                // 属性的描述
                m_adddateField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_adddateField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getTallydateField() {
        if (m_tallydateField == null) {
            try {
                m_tallydateField = new UFDateField();
                // 属性的名称
                m_tallydateField.setName("tallydate");
                // 属性的描述
                m_tallydateField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_tallydateField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getCanceldateField() {
        if (m_canceldateField == null) {
            try {
                m_canceldateField = new UFDateField();
                // 属性的名称
                m_canceldateField.setName("canceldate");
                // 属性的描述
                m_canceldateField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_canceldateField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDoubleField getPriceField() {
        if (m_priceField == null) {
            try {
                m_priceField = new UFDoubleField();
                // 属性的名称
                m_priceField.setName("price");
                // 属性的描述
                m_priceField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_priceField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDoubleField getNumberField() {
        if (m_numberField == null) {
            try {
                m_numberField = new UFDoubleField();
                // 属性的名称
                m_numberField.setName("number");
                // 属性的描述
                m_numberField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_numberField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getRemarkField() {
        if (m_remarkField == null) {
            try {
                m_remarkField = new StringField();
                // 属性的名称
                m_remarkField.setName("remark");
                // 属性的描述
                m_remarkField.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_remarkField;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef1Field() {
        if (m_def1Field == null) {
            try {
                m_def1Field = new StringField();
                // 属性的名称
                m_def1Field.setName("def1");
                // 属性的描述
                m_def1Field.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def1Field;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef2Field() {
        if (m_def2Field == null) {
            try {
                m_def2Field = new StringField();
                // 属性的名称
                m_def2Field.setName("def2");
                // 属性的描述
                m_def2Field.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def2Field;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef3Field() {
        if (m_def3Field == null) {
            try {
                m_def3Field = new StringField();
                // 属性的名称
                m_def3Field.setName("def3");
                // 属性的描述
                m_def3Field.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def3Field;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef4Field() {
        if (m_def4Field == null) {
            try {
                m_def4Field = new StringField();
                // 属性的名称
                m_def4Field.setName("def4");
                // 属性的描述
                m_def4Field.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def4Field;
    }

    /**
     * FieldObject的Getter方法。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef5Field() {
        if (m_def5Field == null) {
            try {
                m_def5Field = new StringField();
                // 属性的名称
                m_def5Field.setName("def5");
                // 属性的描述
                m_def5Field.setLabel("null");

                // 请添加对本属性的期它描述：
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def5Field;
    }

    /**
     * 返回这个ValueObject类的所有FieldObject对象的集合。
     *
     * 创建日期：(2005-9-16)
     * @return nc.vo.pub.FieldObject[]
     */
    public FieldObject[] getFields() {
        FieldObject[] fields = {
                getPk_lccardField(), getLccodeField(), getLcnameField(),
                getPk_lctypeField(), getPk_managedeptField(),
                getPk_usedeptField(), getTallyflagField(), getCancelflagField(),
                getBuydateField(), getAdddateField(), getTallydateField(),
                getCanceldateField(), getPriceField(), getNumberField(),
                getRemarkField(), getDef1Field(), getDef2Field(), getDef3Field(),
                getDef4Field(), getDef5Field()
            };

        return fields;
    }

    /**
     * @return 返回 m_status。
     */
    public String getM_status() {
        return m_status;
    }

    /**
     * @param m_status 要设置的 m_status。
     */
    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public String getCardStatus() {
        if ((m_tallyflag == null) || m_tallyflag.equals(new UFBoolean(false))) {
            return "未记账";
        } else {
            if ((m_cancelflag == null) ||
                    m_cancelflag.equals(new UFBoolean(false))) {
                return "已记帐";
            } else {
                return "已核销";
            }
        }
    }

    public UFDouble getAmountend() {
        return amountend;
    }

    public void setAmountend(UFDouble amountend) {
        this.amountend = amountend;
    }

    public UFDouble getAmountstart() {
        return amountstart;
    }

    public void setAmountstart(UFDouble amountstart) {
        this.amountstart = amountstart;
    }

    public UFDouble getPriceend() {
        return priceend;
    }

    public void setPriceend(UFDouble priceend) {
        this.priceend = priceend;
    }

    public UFDouble getPricestart() {
        return pricestart;
    }

    public void setPricestart(UFDouble pricestart) {
        this.pricestart = pricestart;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTotalpriceend() {
        return totalpriceend;
    }

    public void setTotalpriceend(String totalpriceend) {
        this.totalpriceend = totalpriceend;
    }

    public String getTotalpricestart() {
        return totalpricestart;
    }

    public void setTotalpricestart(String totalpricestart) {
        this.totalpricestart = totalpricestart;
    }

    public UFDate getAddDateEnd() {
        return addDateEnd;
    }

    public void setAddDateEnd(UFDate addDateEnd) {
        this.addDateEnd = addDateEnd;
    }

    public UFDate getBuyDateEnd() {
        return buyDateEnd;
    }

    public void setBuyDateEnd(UFDate buyDateEnd) {
        this.buyDateEnd = buyDateEnd;
    }

    public UFDate getDestroyEnd() {
        return destroyEnd;
    }

    public void setDestroyEnd(UFDate destroyEnd) {
        this.destroyEnd = destroyEnd;
    }
}
