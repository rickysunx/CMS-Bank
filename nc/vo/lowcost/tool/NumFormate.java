package nc.vo.lowcost.tool;
/**
 * ��Ϣ��ȡ
 * �������ڣ�(2001-8-31 9:04:16)
 * @author����÷
 */
 import java.text.DecimalFormat;
import java.text.FieldPosition;

public class NumFormate 
{	//���ݾ��ȣ�����С��λ����
	private static int m_iPrecision = 4;

/**
 * �������ݾ��ȣ�����С��λ����
 * �������ڣ�(2001-10-12 8:51:24)
 * @return int
 */
public static int getPrecision() {
	return m_iPrecision;
}
/**
 * �ڴ˴����뷽��˵����
 * �������ڣ�(2001-10-12 8:58:24)
 * @return java.lang.String
 * @param o java.lang.Object
 */
public static String getPrecisionData(Object o) {
	if(o==null || o.toString().equals("NaN") || o.toString().equals("Infinity"))
		return "";
	int iPrecision = getPrecision();
	double data = 0.0;
	try{
		data = ((Double)o).doubleValue();
	}catch(Throwable e){
		try{
			data = Double.valueOf(o.toString()).doubleValue();
		}catch(Throwable ee){
			return o.toString();
		}
	}
	
	StringBuffer sFormat = new StringBuffer();
	sFormat.append("###,###,###,###,###,##0");
	if(iPrecision>0){
		sFormat.append(".");
		for(int i=0;i<iPrecision;i++){
			sFormat.append("0");
		}
	}
	
	StringBuffer sOut = new StringBuffer();
	try{
		DecimalFormat df=new DecimalFormat(sFormat.toString());
		df.format(data,sOut,new FieldPosition(0));
	}
	catch(Throwable e){
		System.out.println(e);
	}
	return sOut.toString();
	
}




	/**
 * �˴����뷽��˵����
 * �������ڣ�(2002-5-15 17:18:38)
 * @return java.lang.Object[][]
 * @param data java.lang.Object[][]
 */
public static Object[][] getPrecisionData(Object[][] data) 
{
	if (data == null||data.length == 0)
		return null;
	int iHei = data.length;
	int iWid = data[0].length;
	Object oNew[][] = new Object[iHei][iWid];
	for(int i = 0;i<iHei;i++)
	{
		oNew[i][0] = data[i][0];
		for(int j = 1;j<iWid;j++)
			oNew[i][j] = getPrecisionData(data[i][j]);
	}
	return oNew;
}

	/**
 * �˴����뷽��˵����
 * �������ڣ�(2002-5-15 17:18:38)
 * @return java.lang.Object[][]
 * @param data java.lang.Object[][]
 */
public static Object[][] getPrecisionData(Object[][] data,int iPrecision) 
{
	if (data == null||data.length == 0)
		return null;
	int iHei = data.length;
	int iWid = data[0].length;
	Object oNew[][] = new Object[iHei][iWid];
	for(int i = 0;i<iHei;i++)
	{
		oNew[i][0] = data[i][0];
		for(int j = 1;j<iWid;j++)
			oNew[i][j] = getPrecisionData(data[i][j],iPrecision);
	}
	return oNew;
}

/**
 * �ڴ˴����뷽��˵����
 * �������ڣ�(2001-10-12 8:58:24)
 * @return java.lang.String
 * @param o java.lang.Object
 */
public static String getPrecisionData(Object o,int iPrecision) {
	if(o==null || o.toString().equals("NaN") || o.toString().equals("Infinity"))
		return "";
	
	double data = 0.0;
	try{
		data = ((Double)o).doubleValue();
	}catch(Throwable e){
		try{
			data = Double.valueOf(o.toString()).doubleValue();
		}catch(Throwable ee){
			return o.toString();
		}
	}
	
	StringBuffer sFormat = new StringBuffer();
	sFormat.append("###,###,###,###,###,##0");
	if(iPrecision>0){
		sFormat.append(".");
		for(int i=0;i<iPrecision;i++){
			sFormat.append("0");
		}
	}
	
	StringBuffer sOut = new StringBuffer();
	try{
		DecimalFormat df=new DecimalFormat(sFormat.toString());
		df.format(data,sOut,new FieldPosition(0));
	}
	catch(Throwable e){
		System.out.println(e);
	}
	return sOut.toString();
	
}
}