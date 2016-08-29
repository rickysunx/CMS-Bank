package nc.ui.lowcost.subj;
public class SubjBO_Client extends nc.servlet.call.ServletCallBase {
private  static String beanName="nc.bs.lowcost.subj.SubjBO";
public static void delete(nc.vo.lowcost.subj.SubjVO p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={nc.vo.lowcost.subj.SubjVO.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"delete",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::delete " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 ;
 }
public static java.lang.String insert(nc.vo.lowcost.subj.SubjVO p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={nc.vo.lowcost.subj.SubjVO.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"insert",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::insert " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 return (java.lang.String)result;
 }
public static void update(nc.vo.lowcost.subj.SubjVO p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={nc.vo.lowcost.subj.SubjVO.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"update",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::update " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 ;
 }
public static nc.vo.lowcost.subj.SubjVO findByPrimaryKey(java.lang.String p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={java.lang.String.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"findByPrimaryKey",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::findByPrimaryKey " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 return (nc.vo.lowcost.subj.SubjVO)result;
 }
public static nc.vo.lowcost.subj.SubjVO[] queryByVO(nc.vo.lowcost.subj.SubjVO p0,java.lang.Boolean p1) throws Exception{
	Object []params={p0,p1};
  Class []paramTypes={nc.vo.lowcost.subj.SubjVO.class,java.lang.Boolean.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"queryByVO",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::queryByVO " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.subj.SubjVO[])result;
 }
public static nc.vo.lowcost.subj.SubjVO[] queryAll(java.lang.String p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={java.lang.String.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"queryAll",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::queryAll " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.subj.SubjVO[])result;
 }
public static java.lang.String[] insertArray(nc.vo.lowcost.subj.SubjVO[] p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={nc.vo.lowcost.subj.SubjVO[].class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"insertArray",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::insertArray " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (java.lang.String[])result;
 }
public static void saveAll(nc.vo.lowcost.subj.SubjVO[] p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={nc.vo.lowcost.subj.SubjVO[].class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"saveAll",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::saveAll " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 ;
 }
public static nc.vo.lowcost.subj.SubjVO[] queryAllByCorp(java.lang.String p0) throws Exception{
	Object []params={p0};
  Class []paramTypes={java.lang.String.class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"queryAllByCorp",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::queryAllByCorp " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.subj.SubjVO[])result;
 }
public static nc.vo.lowcost.subj.SubjVO[] queryAllVO() throws Exception{
	Object []params={};
  Class []paramTypes={};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"queryAllVO",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("ִ�з���:" + beanName + "::queryAllVO " + " �����ĵ�ʱ��Ϊ��" + t + " ms��");
 if(result == null)
	return null;
else
	return (nc.vo.lowcost.subj.SubjVO[])result;
 }
};