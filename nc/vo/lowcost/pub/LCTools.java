/*
 * �������� 2006-2-8
 *
 * @author ����
 */
package nc.vo.lowcost.pub;

import nc.ui.pub.para.SysInitBO_Client;
import nc.vo.pub.para.SysInitVO;

/**
 * @author ����
 *
 */
public class LCTools {

    /**
     * 
     */
    public LCTools() {
        super();
        // TODO �Զ����ɹ��캯�����
    }
    
    public static String getParam(String pk_corp,String paramCode){
        String paramValue = null;
        try {
            if(pk_corp==null){
                pk_corp = "0001";
            }
            SysInitVO vo = SysInitBO_Client.queryByParaCode(pk_corp,paramCode);
            if(vo==null){
                paramValue = null;
            } else {
                paramValue = vo.getValue();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return paramValue;
    }
    
    public static String getRepeatStr(String repeatStr,int n){
        String str = "";
        if(repeatStr==null){
            return null;
        }
        for (int i = 0; i < n; i++) {
            str += repeatStr;
        }
        return str;
    }
}
