package nc.ui.lowcost.check;
public class CheckBO_Client extends nc.servlet.call.ServletCallBase {
private  static String beanName="nc.bs.lowcost.check.CheckBO";
public static nc.vo.lowcost.check.CheckVO[] doCheck(nc.vo.lowcost.check.CheckVO[] p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={nc.vo.lowcost.check.CheckVO[].class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"doCheck",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::doCheck " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.check.CheckVO[])result;
 }
public static nc.vo.lowcost.check.CheckVO[] queryCheck(java.lang.String p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={java.lang.String.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"queryCheck",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::queryCheck " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.check.CheckVO[])result;
 }
public static nc.vo.lowcost.check.CheckVO[] doTypeCorpCheck(java.lang.String p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={java.lang.String.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"doTypeCorpCheck",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::doTypeCorpCheck " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.check.CheckVO[])result;
 }
};