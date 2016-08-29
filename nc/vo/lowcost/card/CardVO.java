/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product.                              *
\***************************************************************/
package nc.vo.lowcost.card;

import nc.vo.pub.*;
import nc.vo.pub.lang.*;


/**
 * �˴���������˵����
 *
 * �������ڣ�(2005-9-16)
 * @author��
 */
public class CardVO extends CircularlyAccessibleValueObject {
    /**
     *
     */
    private static final long serialVersionUID = -8646323942670583410L;

    /**
     *     �����������Ե�FieldObjects����Ҫ����ϵͳ�����У�
     * ҵ������в����õ������FieldObjects��
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
    public String m_def1; //������Ϊ��ʹ����
    public String m_def2;
    public String m_def3;
    public String m_def4;
    public String m_def5; //¼����
    public String m_status;
    public String m_pk_corp;
    public boolean m_inclusub; //�Ƿ�����¼�
    public String m_loginuser;
    public String dep;
    public String psn;

    //���ӵĴ���
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
     * ʹ�������ֶν��г�ʼ���Ĺ����ӡ�
     *
     * �������ڣ�(2005-9-16)
     */
    public CardVO() {
    }

    /**
     * ʹ���������г�ʼ���Ĺ����ӡ�
     *
     * �������ڣ�(2005-9-16)
     * @param ??fieldNameForMethod?? ����ֵ
     */
    public CardVO(String newPk_lccard) {
        // Ϊ�����ֶθ�ֵ:
        m_pk_lccard = newPk_lccard;
    }

    /**
     * ����Object�ķ���,��¡���VO����
     *
     * �������ڣ�(2005-9-16)
     */
    public Object clone() {
        // ���ƻ������ݲ������µ�VO����
        Object o = null;

        try {
            o = super.clone();
        } catch (Exception e) {
        }

        CardVO card = (CardVO) o;

        // �������渴�Ʊ�VO������������ԣ�
        return card;
    }

    /**
     * ������ֵ�������ʾ���ơ�
     *
     * �������ڣ�(2005-9-16)
     * @return java.lang.String ������ֵ�������ʾ���ơ�
     */
    public String getEntityName() {
        return "Card";
    }

    /**
     * ���ض����ʶ������Ψһ��λ����
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getPrimaryKey() {
        return m_pk_lccard;
    }

    /**
     * ���ö����ʶ������Ψһ��λ����
     *
     * �������ڣ�(2005-9-16)
     * @param m_pk_lccard String
     */
    public void setPrimaryKey(String newPk_lccard) {
        m_pk_lccard = newPk_lccard;
    }

    /**
     * ����m_pk_lccard��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getPk_lccard() {
        return m_pk_lccard;
    }

    /**
     * ����m_lccode��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getLccode() {
        return m_lccode;
    }

    /**
     * ����m_lcname��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getLcname() {
        return m_lcname;
    }

    /**
     * ����m_pk_lctype��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getPk_lctype() {
        return m_pk_lctype;
    }

    /**
     * ����m_pk_managedept��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getPk_managedept() {
        return m_pk_managedept;
    }

    /**
     * ����m_pk_usedept��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getPk_usedept() {
        return m_pk_usedept;
    }

    /**
     * ����m_tallyflag��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFBoolean
     */
    public UFBoolean getTallyflag() {
        return m_tallyflag;
    }

    public boolean getInclusub() {
        return m_inclusub;
    }

    /**
     * ����m_cancelflag��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFBoolean
     */
    public UFBoolean getCancelflag() {
        return m_cancelflag;
    }

    /**
     * ����m_buydate��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFDate
     */
    public UFDate getBuydate() {
        return m_buydate;
    }

    /**
     * ����m_adddate��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFDate
     */
    public UFDate getAdddate() {
        return m_adddate;
    }

    /**
     * ����m_tallydate��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFDate
     */
    public UFDate getTallydate() {
        return m_tallydate;
    }

    /**
     * ����m_canceldate��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFDate
     */
    public UFDate getCanceldate() {
        return m_canceldate;
    }

    /**
     * ����m_price��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFDouble
     */
    public UFDouble getPrice() {
        return m_price;
    }

    /**
     * ����m_number��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return UFDouble
     */
    public UFDouble getNumber() {
        return m_number;
    }

    /**
     * ����m_remark��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getRemark() {
        return m_remark;
    }

    /**
     * ����m_def1��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getDef1() {
        return m_def1;
    }

    /**
     * ����m_def2��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getDef2() {
        return m_def2;
    }

    /**
     * ����m_def3��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getDef3() {
        return m_def3;
    }

    /**
     * ����m_def4��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getDef4() {
        return m_def4;
    }

    /**
     * ����m_def5��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return String
     */
    public String getDef5() {
        return m_def5;
    }

    /**
     * ����m_pk_lccard��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_pk_lccard String
     */
    public void setPk_lccard(String newPk_lccard) {
        m_pk_lccard = newPk_lccard;
    }

    /**
     * ����m_lccode��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_lccode String
     */
    public void setLccode(String newLccode) {
        m_lccode = newLccode;
    }

    /**
     * ����m_lcname��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_lcname String
     */
    public void setLcname(String newLcname) {
        m_lcname = newLcname;
    }

    /**
     * ����m_pk_lctype��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_pk_lctype String
     */
    public void setPk_lctype(String newPk_lctype) {
        m_pk_lctype = newPk_lctype;
    }

    /**
     * ����m_pk_managedept��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_pk_managedept String
     */
    public void setPk_managedept(String newPk_managedept) {
        m_pk_managedept = newPk_managedept;
    }

    /**
     * ����m_pk_usedept��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_pk_usedept String
     */
    public void setPk_usedept(String newPk_usedept) {
        m_pk_usedept = newPk_usedept;
    }

    /**
     * ����m_tallyflag��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_tallyflag UFBoolean
     */
    public void setTallyflag(UFBoolean newTallyflag) {
        m_tallyflag = newTallyflag;
    }

    public void setInclusub(boolean newflag) {
        m_inclusub = newflag;
    }

    /**
     * ����m_cancelflag��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_cancelflag UFBoolean
     */
    public void setCancelflag(UFBoolean newCancelflag) {
        m_cancelflag = newCancelflag;
    }

    /**
     * ����m_buydate��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_buydate UFDate
     */
    public void setBuydate(UFDate newBuydate) {
        m_buydate = newBuydate;
    }

    /**
     * ����m_adddate��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_adddate UFDate
     */
    public void setAdddate(UFDate newAdddate) {
        m_adddate = newAdddate;
    }

    /**
     * ����m_tallydate��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_tallydate UFDate
     */
    public void setTallydate(UFDate newTallydate) {
        m_tallydate = newTallydate;
    }

    /**
     * ����m_canceldate��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_canceldate UFDate
     */
    public void setCanceldate(UFDate newCanceldate) {
        m_canceldate = newCanceldate;
    }

    /**
     * ����m_price��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_price UFDouble
     */
    public void setPrice(UFDouble newPrice) {
        m_price = newPrice;
    }

    /**
     * ����m_number��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_number UFDouble
     */
    public void setNumber(UFDouble newNumber) {
        m_number = newNumber;
    }

    /**
     * ����m_remark��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_remark String
     */
    public void setRemark(String newRemark) {
        m_remark = newRemark;
    }

    /**
     * ����m_def1��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_def1 String
     */
    public void setDef1(String newDef1) {
        m_def1 = newDef1;
    }

    /**
     * ����m_def2��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_def2 String
     */
    public void setDef2(String newDef2) {
        m_def2 = newDef2;
    }

    /**
     * ����m_def3��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_def3 String
     */
    public void setDef3(String newDef3) {
        m_def3 = newDef3;
    }

    /**
     * ����m_def4��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_def4 String
     */
    public void setDef4(String newDef4) {
        m_def4 = newDef4;
    }

    /**
     * ����m_def5��setter������
     *
     * �������ڣ�(2005-9-16)
     * @param newM_def5 String
     */
    public void setDef5(String newDef5) {
        m_def5 = newDef5;
    }

    /**
     * ��֤���������֮��������߼���ȷ�ԡ�
     *
     * �������ڣ�(2005-9-16)
     * @exception nc.vo.pub.ValidationException �����֤ʧ�ܣ��׳�
     *     ValidationException���Դ�����н��͡�
     */

    /*public void validate() throws ValidationException {
    
            ArrayList errFields = new ArrayList(); // errFields record those null fields that cannot be null.
            // ����Ƿ�Ϊ�������յ��ֶθ��˿�ֵ���������Ҫ�޸��������ʾ��Ϣ��
            if (m_pk_lccard == null) {
                    errFields.add(new String("m_pk_lccard"));
            }
            // construct the exception message:
            StringBuffer message = new StringBuffer();
            message.append("�����ֶβ���Ϊ�գ�");
            if (errFields.size() > 0) {
                    String[] temp = (String[]) errFields.toArray(new String[0]);
                    message.append(temp[0]);
                    for ( int i= 1; i < temp.length; i++ ) {
                            message.append("��");
                            message.append(temp[i]);
                    }
                    // throw the exception:
                    //throw new NullFieldException(message.toString());
            }
    }*/
    public void validate() throws ValidationException {
    }

    /**
     * <p>��Ҫ��һ��ѭ���з��ʵ����Ե��������顣
     * <p>
     * �������ڣ�(??Date??)
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
     *  <p>����һ�����������ַ��������Ե�ֵ��
     *  <p>
     * �������ڣ�(2005-9-16)
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
                lcstatus = "δ����";
            }

            if (((m_tallyflag != null) && (m_tallyflag.booleanValue() == true)) &&
                    ((m_cancelflag == null) ||
                    (m_cancelflag.booleanValue() == false))) {
                lcstatus = "�Ѽ���";
            }

            if ((m_cancelflag != null) &&
                    (m_cancelflag.booleanValue() == true)) {
                lcstatus = "�Ѻ���";
            }

            return lcstatus;
        }

        return null;
    }

    /**
     *  <p>�Բ���name���͵���������ֵ��
     *  <p>
     * �������ڣ�(2005-9-16)
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
            throw new ClassCastException("setAttributeValue������Ϊ " + name +
                " ��ֵʱ����ת�����󣡣�ֵ��" + value + "��");
        }
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_lccardField() {
        if (m_pk_lccardField == null) {
            try {
                m_pk_lccardField = new StringField();
                // ���Ե�����
                m_pk_lccardField.setName("pk_lccard");
                // ���Ե�����
                m_pk_lccardField.setLabel("null");

                // �����ӶԱ����Ե�����������
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
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getLccodeField() {
        if (m_lccodeField == null) {
            try {
                m_lccodeField = new StringField();
                // ���Ե�����
                m_lccodeField.setName("lccode");
                // ���Ե�����
                m_lccodeField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_lccodeField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getLcnameField() {
        if (m_lcnameField == null) {
            try {
                m_lcnameField = new StringField();
                // ���Ե�����
                m_lcnameField.setName("lcname");
                // ���Ե�����
                m_lcnameField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_lcnameField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_lctypeField() {
        if (m_pk_lctypeField == null) {
            try {
                m_pk_lctypeField = new StringField();
                // ���Ե�����
                m_pk_lctypeField.setName("pk_lctype");
                // ���Ե�����
                m_pk_lctypeField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_lctypeField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_managedeptField() {
        if (m_pk_managedeptField == null) {
            try {
                m_pk_managedeptField = new StringField();
                // ���Ե�����
                m_pk_managedeptField.setName("pk_managedept");
                // ���Ե�����
                m_pk_managedeptField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_managedeptField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getPk_usedeptField() {
        if (m_pk_usedeptField == null) {
            try {
                m_pk_usedeptField = new StringField();
                // ���Ե�����
                m_pk_usedeptField.setName("pk_usedept");
                // ���Ե�����
                m_pk_usedeptField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_pk_usedeptField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFBooleanField getTallyflagField() {
        if (m_tallyflagField == null) {
            try {
                m_tallyflagField = new UFBooleanField();
                // ���Ե�����
                m_tallyflagField.setName("tallyflag");
                // ���Ե�����
                m_tallyflagField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_tallyflagField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFBooleanField getCancelflagField() {
        if (m_cancelflagField == null) {
            try {
                m_cancelflagField = new UFBooleanField();
                // ���Ե�����
                m_cancelflagField.setName("cancelflag");
                // ���Ե�����
                m_cancelflagField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_cancelflagField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getBuydateField() {
        if (m_buydateField == null) {
            try {
                m_buydateField = new UFDateField();
                // ���Ե�����
                m_buydateField.setName("buydate");
                // ���Ե�����
                m_buydateField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_buydateField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getAdddateField() {
        if (m_adddateField == null) {
            try {
                m_adddateField = new UFDateField();
                // ���Ե�����
                m_adddateField.setName("adddate");
                // ���Ե�����
                m_adddateField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_adddateField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getTallydateField() {
        if (m_tallydateField == null) {
            try {
                m_tallydateField = new UFDateField();
                // ���Ե�����
                m_tallydateField.setName("tallydate");
                // ���Ե�����
                m_tallydateField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_tallydateField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDateField getCanceldateField() {
        if (m_canceldateField == null) {
            try {
                m_canceldateField = new UFDateField();
                // ���Ե�����
                m_canceldateField.setName("canceldate");
                // ���Ե�����
                m_canceldateField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_canceldateField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDoubleField getPriceField() {
        if (m_priceField == null) {
            try {
                m_priceField = new UFDoubleField();
                // ���Ե�����
                m_priceField.setName("price");
                // ���Ե�����
                m_priceField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_priceField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static UFDoubleField getNumberField() {
        if (m_numberField == null) {
            try {
                m_numberField = new UFDoubleField();
                // ���Ե�����
                m_numberField.setName("number");
                // ���Ե�����
                m_numberField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_numberField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getRemarkField() {
        if (m_remarkField == null) {
            try {
                m_remarkField = new StringField();
                // ���Ե�����
                m_remarkField.setName("remark");
                // ���Ե�����
                m_remarkField.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_remarkField;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef1Field() {
        if (m_def1Field == null) {
            try {
                m_def1Field = new StringField();
                // ���Ե�����
                m_def1Field.setName("def1");
                // ���Ե�����
                m_def1Field.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def1Field;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef2Field() {
        if (m_def2Field == null) {
            try {
                m_def2Field = new StringField();
                // ���Ե�����
                m_def2Field.setName("def2");
                // ���Ե�����
                m_def2Field.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def2Field;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef3Field() {
        if (m_def3Field == null) {
            try {
                m_def3Field = new StringField();
                // ���Ե�����
                m_def3Field.setName("def3");
                // ���Ե�����
                m_def3Field.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def3Field;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef4Field() {
        if (m_def4Field == null) {
            try {
                m_def4Field = new StringField();
                // ���Ե�����
                m_def4Field.setName("def4");
                // ���Ե�����
                m_def4Field.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def4Field;
    }

    /**
     * FieldObject��Getter������
     *
     * �������ڣ�(2005-9-16)
     * @return nc.vo.pub.FieldObject
     */
    public static StringField getDef5Field() {
        if (m_def5Field == null) {
            try {
                m_def5Field = new StringField();
                // ���Ե�����
                m_def5Field.setName("def5");
                // ���Ե�����
                m_def5Field.setLabel("null");

                // �����ӶԱ����Ե�����������
            } catch (Throwable exception) {
                handleException(exception);
            }
        }

        return m_def5Field;
    }

    /**
     * �������ValueObject�������FieldObject����ļ��ϡ�
     *
     * �������ڣ�(2005-9-16)
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
     * @return ���� m_status��
     */
    public String getM_status() {
        return m_status;
    }

    /**
     * @param m_status Ҫ���õ� m_status��
     */
    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public String getCardStatus() {
        if ((m_tallyflag == null) || m_tallyflag.equals(new UFBoolean(false))) {
            return "δ����";
        } else {
            if ((m_cancelflag == null) ||
                    m_cancelflag.equals(new UFBoolean(false))) {
                return "�Ѽ���";
            } else {
                return "�Ѻ���";
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