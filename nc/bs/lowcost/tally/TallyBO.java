/*
 * 创建日期 2006-2-10
 *
 * @author 孙锐
 */
package nc.bs.lowcost.tally;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

import nc.bs.pub.BusinessObject;
import nc.vo.lowcost.cancel.CancelItemVO;
import nc.vo.lowcost.cancel.CancelVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.pub.LCTools;
import nc.vo.lowcost.tally.TallyCorpVO;
import nc.vo.lowcost.tally.TallylogVO;
import nc.vo.lowcost.trans.TransVO;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;

/**
 * @author 孙锐
 *
 */
public class TallyBO extends BusinessObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5248500850928084220L;

	/**
     * 
     */
    public TallyBO() {
        super();
    }

    /* （非 Javadoc）
     * @see nc.bs.pub.BusinessObject#ejbCreate()
     */
    public void ejbCreate() throws RemoteException {
    }
    
    public TallylogVO doTally(UFDate date,String pk_corp,String pk_user,TallyCorpVO [] tallyCorps) throws RemoteException {

    	TallylogVO reallvo = new TallylogVO();
    	reallvo.m_def5 = "";
    	TallylogVO recardvo = null;
    	TallylogVO recancelvo = null;
    	TallylogVO retransvo = null;
    	CardVO [] cardvos = null;
        CardVO [] returncardvos = null;
        TransVO [] tranvos = null;
        TransVO [] returntranvos = null;
        CancelVO [] cancelvos = null;
        CancelVO [] returncancelvos = null;
        try {
            //开始调用外部接口
            String strClassName = LCTools.getParam(null,"LC15");
            System.out.println("=======低值易耗品，外部接口类(LC15)======："+strClassName);
            if(strClassName!=null && strClassName.trim().length()>0 && (!strClassName.trim().equals("#"))){
            	cardvos = (new TallyDMO()).findTallyCard(tallyCorps);
            	tranvos = (new TallyDMO()).findTallyTrans(tallyCorps);
            	cancelvos = (new TallyDMO()).findTallyCancel(tallyCorps);
            	
            	ILowCostTally lctally = (ILowCostTally) Class.forName(strClassName).newInstance();
            	
            	//Start
            	UFDouble newSum = new UFDouble(0.0f);
            	UFDouble cancelSum = new UFDouble(0.0f);
            	if(cardvos!=null&&cardvos.length>0){
            		for (int i = 0; i < cardvos.length; i++) {
            			newSum = newSum.add(cardvos[i].getNumber().multiply(cardvos[i].getPrice()));
            		}
            	}
            	
            	if(cancelvos!=null&&cancelvos.length>0){
            		CardVO[] cards = null;
            		Vector v = new Vector();
            		for (int i = 0; i < cancelvos.length; i++) {
            			CancelItemVO[] civo = (CancelItemVO[]) cancelvos[i].getChildrenVO();
            			for (int j = 0; j < civo.length; j++) {
            				v.add(civo[j].getCardVO());
						}            		
					}
            		cards = new CardVO[v.size()];
            		v.copyInto(cards);
            		for (int i = 0; i < cards.length; i++) {
						cancelSum = cancelSum.add(cards[i].getNumber().multiply(cards[i].getPrice()));
					}
            	}
            	
            	lctally.doCorpTallyTrade(date,tallyCorps[0].getPk_corp(),newSum,cancelSum);
            	//END
                returncardvos = lctally.doTallyCard(cardvos);
                returntranvos = lctally.doTallyTrans(tranvos);
                returncancelvos = lctally.doTallyCancel(cancelvos);
                      
                if((returncardvos!=null)&&(returncardvos.length>0))
                	recardvo = (new TallyDMO()).updateCard(returncardvos,date);
                if((returntranvos!=null)&&(returntranvos.length>0))
                	retransvo = (new TallyDMO()).updateTrans(returntranvos,date);
                if((returncancelvos!=null)&&(returncancelvos.length>0))
                	recancelvo = (new TallyDMO()).updateCancel(returncancelvos,date);
                
                if(recardvo!=null){
                    reallvo.m_def5 += recardvo.getDef5();
                }
                if(retransvo!=null){
                    reallvo.m_def5 += retransvo.getDef5();
                }
                if(recancelvo!=null){
                    reallvo.m_def5 += reallvo.getDef5();
                }
                //返回统计结果
                if((recardvo == null)||(recardvo.getNewsum()==null))
                   reallvo.setNewsum(new UFDouble(0.0f));
                else
                   reallvo.setNewsum(recardvo.getNewsum());
                if((retransvo == null)||(retransvo.getTranssum()==null))
                   reallvo.setTranssum(new UFDouble(0.0f));
                else
                   reallvo.setTranssum(retransvo.getTranssum());
                if((recancelvo == null)||(recancelvo.getCancelsum()==null))
                   reallvo.setCancelsum(new UFDouble(0.0f));
                else
                   reallvo.setCancelsum(recancelvo.getCancelsum());
                
                if(tallyCorps!=null){
                	for (int i = 0; i < tallyCorps.length; i++) {
						TallylogVO logVO = new TallylogVO();
		        		logVO.setNewsum(newSum);
		        		logVO.setCancelsum(cancelSum);
		        		logVO.setTranssum(new UFDouble(0.0f));
		        		logVO.setTallydate(date);
		        		logVO.setPk_corp(tallyCorps[i].getPk_corp());
		        		logVO.setPk_user(pk_user);
		        		try {
		        		    (new TallylogDMO()).insert(logVO);
		        		} catch(Exception e) {
		        		    throw new SQLException (e.getMessage());
		        		}
                	}
                }
        		
            }else{  	
            	reallvo = (new TallyDMO()).doTally(date,pk_corp,pk_user,tallyCorps);          	
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
      
        return reallvo;
    }

    
    
    public TallylogVO doUnTally(UFDate date,TallyCorpVO [] tallyCorps) throws RemoteException {
    	TallylogVO reallvo = new TallylogVO();
    	reallvo.m_def5 = "";
    	TallylogVO recardvo = null;
    	TallylogVO recancelvo = null;
    	TallylogVO retransvo = null;
    	CardVO [] cardvos = null;
        CardVO [] returncardvos = null;
        TransVO [] tranvos = null;
        TransVO [] returntranvos = null;
        CancelVO [] cancelvos = null;
        CancelVO [] returncancelvos = null;
        try {
        	String strClassName = LCTools.getParam(null,"LC15");
        	if(strClassName!=null && strClassName.trim().length()>0 && (!strClassName.trim().equals("#"))){
        		cardvos = (new TallyDMO()).findUntallyCard(tallyCorps, date);
            	tranvos = (new TallyDMO()).findUntallyTrans(tallyCorps, date);
            	cancelvos = (new TallyDMO()).findUntallyCancel(tallyCorps, date);
            	
            	ILowCostTally lctally = (ILowCostTally) Class.forName(strClassName).newInstance();
            	
            	//Start
            	UFDouble newSum = new UFDouble(0.0f);
            	UFDouble cancelSum = new UFDouble(0.0f);
            	if(cardvos!=null&&cardvos.length>0){
            		for (int i = 0; i < cardvos.length; i++) {
						newSum = newSum.add(cardvos[i].getNumber().multiply(cardvos[i].getPrice()));
					}
            	}
            	
            	if(cancelvos!=null&&cancelvos.length>0){
            		CardVO[] cards = null;
            		Vector v = new Vector();
            		for (int i = 0; i < cancelvos.length; i++) {
            			CancelItemVO[] civo = (CancelItemVO[]) cancelvos[i].getChildrenVO();
            			for (int j = 0; j < civo.length; j++) {
            				v.add(civo[j].getCardVO());
            			}            		
					}
            		cards = new CardVO[v.size()];
            		v.copyInto(cards);
            		for (int i = 0; i < cards.length; i++) {
						cancelSum = cancelSum.add(cards[i].getNumber().multiply(cards[i].getPrice()));
					}
            	}
            	lctally.doCorpTallyTrade(date,tallyCorps[0].getPk_corp(),cancelSum,newSum);
            	//END
            	
            	
                returncardvos = lctally.undoTallyCard(cardvos);//卡片
                returntranvos = lctally.undoTallyTrans(tranvos);//调拨
                returncancelvos = lctally.undoTallyCancel(cancelvos);//核销
                
                if((returncardvos!=null)&&(returncardvos.length>0))
                	recardvo = (new TallyDMO()).updateCard1(returncardvos,date);
                if((returntranvos!=null)&&(returntranvos.length>0))
                	retransvo = (new TallyDMO()).updateTrans1(returntranvos,date);
                if((returncancelvos!=null)&&(returncancelvos.length>0))
                	recancelvo = (new TallyDMO()).updateCancel1(returncancelvos,date);
                
                if(recardvo!=null){
                    reallvo.m_def5 += recardvo.getDef5();
                }
                if(retransvo!=null){
                    reallvo.m_def5 += retransvo.getDef5();
                }
                if(recancelvo!=null){
                    reallvo.m_def5 += reallvo.getDef5();
                }
                
                if((recardvo == null)||(recardvo.getNewsum()==null))
                    reallvo.setNewsum(new UFDouble(0.0f));
                 else
                    reallvo.setNewsum(recardvo.getNewsum());
                 if((retransvo == null)||(retransvo.getTranssum()==null))
                    reallvo.setTranssum(new UFDouble(0.0f));
                 else
                    reallvo.setTranssum(retransvo.getTranssum());
                 if((recancelvo == null)||(recancelvo.getCancelsum()==null))
                    reallvo.setCancelsum(new UFDouble(0.0f));
                 else
                    reallvo.setCancelsum(recancelvo.getCancelsum());
                 
                 
                 if(tallyCorps!=null){
                	 for (int i = 0; i < tallyCorps.length; i++) {
                		 (new TallyDMO()).deleteTallyLog(tallyCorps[i].getPk_corp(),date);
                	 }
                 }
        	}else{
        		reallvo = (new TallyDMO()).doUnTally(date,tallyCorps);
        	}
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
        return reallvo;
    }
    
    public UFDate queryLastTallyDate() throws RemoteException {
        UFDate date = null;
        try {
            date = (new TallyDMO()).queryLastTallyDate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
        return date;
    }
}
