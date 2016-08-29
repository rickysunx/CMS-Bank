package nc.ui.lowcost.tally;
public class TallyBO_Client extends nc.servlet.call.ServletCallBase {
private  static String beanName="nc.bs.lowcost.tally.TallyBO";
public static nc.vo.lowcost.tally.TallylogVO doTally(nc.vo.pub.lang.UFDate p0,java.lang.String p1,java.lang.String p2,nc.vo.lowcost.tally.TallyCorpVO[] p3) throws Exception{
	Object []params={p0,p1,p2,p3};
  Class []paramTypes={nc.vo.pub.lang.UFDate.class,java.lang.String.class,java.lang.String.class,nc.vo.lowcost.tally.TallyCorpVO[].class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"doTally",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("执行方法:" + beanName + "::doTally " + " 所消耗的时间为：" + t + " ms。");
 return (nc.vo.lowcost.tally.TallylogVO)result;
 }
public static nc.vo.lowcost.tally.TallylogVO doUnTally(nc.vo.pub.lang.UFDate p0,nc.vo.lowcost.tally.TallyCorpVO[] p1) throws Exception{
	Object []params={p0,p1};
  Class []paramTypes={nc.vo.pub.lang.UFDate.class,nc.vo.lowcost.tally.TallyCorpVO[].class};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"doUnTally",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("执行方法:" + beanName + "::doUnTally " + " 所消耗的时间为：" + t + " ms。");
 return (nc.vo.lowcost.tally.TallylogVO)result;
 }
public static nc.vo.pub.lang.UFDate queryLastTallyDate() throws Exception{
	Object []params={};
  Class []paramTypes={};
	long t = System.currentTimeMillis();
  Object result=remoteCall(beanName,"queryLastTallyDate",paramTypes,params);
	t = System.currentTimeMillis() - t;
	System.out.println("执行方法:" + beanName + "::queryLastTallyDate " + " 所消耗的时间为：" + t + " ms。");
 return (nc.vo.pub.lang.UFDate)result;
 }
};