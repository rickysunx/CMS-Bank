/*
 * 创建日期 2006-2-8
 *
 * @author 孙锐
 */
package nc.vo.lowcost.pub;

import nc.ui.pub.para.SysInitBO_Client;
import nc.vo.pub.para.SysInitVO;

/**
 * @author 孙锐
 *
 */
public class LCTools {

    /**
     * 
     */
    public LCTools() {
        super();
        // TODO 自动生成构造函数存根
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
