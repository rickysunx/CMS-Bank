/*
 * �������� 2006-5-25
 *
 * @author ����
 */
package nc.bs.lowcost.other.nhnx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import javax.naming.NamingException;



import nc.bs.lowcost.card.CardDMO;
import nc.bs.lowcost.tally.ILowCostTally;
import nc.bs.nhnx.expvoucher.VoucherDealDMO;
import nc.bs.pub.DataManageObject;
import nc.bs.pub.SystemException;
import nc.vo.lowcost.cancel.CancelHeaderVO;
import nc.vo.lowcost.cancel.CancelItemVO;
import nc.vo.lowcost.cancel.CancelVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tally.TallyCorpTypeVO;
import nc.vo.lowcost.trans.TransHeaderVO;
import nc.vo.lowcost.trans.TransItemVO;
import nc.vo.lowcost.trans.TransVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDouble;

/**
 * @author ����
 *
 */
public class BankInterfaceDMO extends DataManageObject implements ILowCostTally {

    /**
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public BankInterfaceDMO() throws NamingException, SystemException {
        super();
        // TODO �Զ����ɹ��캯�����
    }

    /**
     * @param dbName
     * @throws javax.naming.NamingException
     * @throws nc.bs.pub.SystemException
     */
    public BankInterfaceDMO(String dbName) throws NamingException,
            SystemException {
        super(dbName);
        // TODO �Զ����ɹ��캯�����
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#doTallyTrade(nc.vo.lowcost.card.CardVO[], nc.vo.lowcost.trans.TransVO[], nc.vo.lowcost.cancel.CancelVO[])
     */
    public void doTallyTrade(CardVO[] cards, TransVO[] trans, CancelVO[] cancels) throws Exception {
        // TODO �Զ����ɷ������
        
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#doCorpTallyTrade(nc.vo.pub.lang.UFDate, java.lang.String, nc.vo.pub.lang.UFDouble, nc.vo.pub.lang.UFDouble)
     */
    public void doCorpTallyTrade(UFDate date, String pk_corp, UFDouble newSum, UFDouble cancelSum) throws Exception {
        // TODO �Զ����ɷ������
        
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#doUnTallyTrade(nc.vo.pub.lang.UFDate)
     */
    public void doUnTallyTrade(UFDate date) throws Exception {
        // TODO �Զ����ɷ������
        
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#doTallyCard(nc.vo.lowcost.card.CardVO[])
     */
    public CardVO[] doTallyCard(CardVO[] cards) throws Exception {
        // TODO �Զ����ɷ������
        CardVO [] rCards = null;
        Vector vRCards = new Vector();
        Vector vTally = new Vector();  //Ҫ������Ŀ
        HashMap hmTally = new HashMap();
        HashMap hmTypeCorp = null;
        cards = queryCardPkCorp(cards);
        
        if(cards!=null){
            
            //��ϳ�Ҫ���м��˵���Ŀ
            hmTypeCorp = queryAllTypeCorp();
            for (int i = 0; i < cards.length; i++) {
                String corpAndType = cards[i].getPk_corp() + "-" + cards[i].getPk_lctype();
                if(hmTally.containsKey(corpAndType)){
                    TallyCorpTypeVO tctVo = (TallyCorpTypeVO) hmTally.get(corpAndType);
                    tctVo.getTallyobj().add(cards[i]);
                    tctVo.setJe(tctVo.getJe().add(cards[i].getPrice().multiply(cards[i].getNumber())));
                } else {
                    TallyCorpTypeVO tctVo = new TallyCorpTypeVO();
                    tctVo.setPk_corp(cards[i].getPk_corp());
                    tctVo.setPk_lctype(cards[i].getPk_lctype());
                    Object obj = hmTypeCorp.get(tctVo.getPk_corp() + "-" + tctVo.getPk_lctype());
                    if(obj==null){
                        throw new Exception ("��Ʒ["+ cards[i].getLccode() + "]" + cards[i].getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
                    }
                    tctVo.setBank_kmbm(obj==null?null:(String)obj);
                    tctVo.getTallyobj().add(cards[i]);
                    tctVo.setJe(tctVo.getJe().add(cards[i].getPrice().multiply(cards[i].getNumber())));
                    vTally.add(tctVo);
                    hmTally.put(corpAndType,tctVo);
                }
            }
            
            //��ʼ����
            for (int i = 0; i < vTally.size(); i++) {
                TallyCorpTypeVO tctvo = (TallyCorpTypeVO)vTally.elementAt(i);
                try {
                    VoucherDealDMO vdmo = new VoucherDealDMO();
                    vRCards.addAll(tctvo.getTallyobj());
                    vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","1",tctvo.getJe());

                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        CardVO cvo = (CardVO)tctvo.getTallyobj().elementAt(j);
                        cvo.setTallyflag(new UFBoolean(true));
                    }
                } catch (Exception ex){
                	ex.printStackTrace();
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        CardVO cvo = (CardVO)tctvo.getTallyobj().elementAt(j);
                        cvo.setTallyflag(new UFBoolean(false));
                        cvo.setDef5(ex.getMessage());
                    }
                }
            }
            
            if(vRCards.size()>0){
                rCards = new CardVO[vRCards.size()];
                vRCards.copyInto(rCards);
            }
            
        }
        return rCards;
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#doTallyTrans(nc.vo.lowcost.trans.TransVO[])
     */
    public TransVO[] doTallyTrans(TransVO[] trans) throws Exception {
        // TODO �Զ����ɷ������
        
        TransVO [] rTrans = null;
        Vector vRTrans = new Vector();
        
        Vector vTally = new Vector();  //Ҫ������Ŀ
        HashMap hmTally = new HashMap();
        HashMap hmTypeCorp = null;
        HashMap hmDept = null;
        
        if(trans!=null){
            hmTypeCorp = queryAllTypeCorp();
            hmDept = queryAllDept();
            //��Ҫ���м��˵ĵ������ݣ�������������ǲ�ͬ����ʱ��������Ҫ����ķ��͵�������
            Vector vTransToBank = new Vector();
            for (int i = 0; i < trans.length; i++) {
                boolean bTransToBank = false;
                TransItemVO [] items = (TransItemVO[])trans[i].getChildrenVO();
                for (int j = 0; j < items.length; j++) {
                    Object fromCorp = hmDept.get(items[j].getPk_deptfrom());
                    Object toCorp = hmDept.get(items[j].getPk_deptto());
                    if(fromCorp!=null && (!fromCorp.equals(toCorp))){
                        bTransToBank = true;
                        CardVO card = (new CardDMO()).findByPrimaryKey(items[j].getPk_lccard());
                        items[i].card = card;
                        items[i].bTransToBank = true;
                        
                        String fromTallyKey = fromCorp+"-"+card.getPk_lctype();
                        String toTallyKey = toCorp+"-"+card.getPk_lctype();
                        
                        if(hmTally.containsKey(fromTallyKey)){
                            TallyCorpTypeVO tctVofrom = (TallyCorpTypeVO)hmTally.get(fromTallyKey);
                            tctVofrom.setJe(tctVofrom.getJe().add(card.getPrice().multiply(card.getNumber()).multiply(new UFDouble(-1.0f))));
                            tctVofrom.getTallyobj().add(trans[i]);
                        } else {
	                        TallyCorpTypeVO tctVofrom = new TallyCorpTypeVO();
	                        tctVofrom.setPk_corp((String)fromCorp);
	                        tctVofrom.setPk_lctype(card.getPk_lctype());
	                        Object obj = hmTypeCorp.get(tctVofrom.getPk_corp() + "-" + tctVofrom.getPk_lctype());
	                        if(obj==null){
	                            throw new Exception ("��Ʒ["+ card.getLccode() + "]" + card.getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
	                        }
	                        tctVofrom.setBank_kmbm(obj==null?null:(String)obj);
	                        tctVofrom.setJe(tctVofrom.getJe().add(card.getPrice().multiply(card.getNumber()).multiply(new UFDouble(-1.0f))));
	                        tctVofrom.getTallyobj().add(trans[i]);
	                        vTally.add(tctVofrom);
	                        hmTally.put(fromTallyKey,tctVofrom);
                        }
                        
                        if(hmTally.containsKey(toTallyKey)){
                            TallyCorpTypeVO tctVoto = (TallyCorpTypeVO)hmTally.get(toTallyKey);
                            tctVoto.setJe(tctVoto.getJe().add(card.getPrice().multiply(card.getNumber())));
                            tctVoto.getTallyobj().add(trans[i]);
                        } else {
	                        TallyCorpTypeVO tctVoto = new TallyCorpTypeVO();
	                        tctVoto.setPk_corp((String)toCorp);
	                        tctVoto.setPk_lctype(card.getPk_lctype());
	                        Object obj = hmTypeCorp.get(tctVoto.getPk_corp() + "-" + tctVoto.getPk_lctype());
	                        if(obj==null){
	                            throw new Exception ("��Ʒ["+ card.getLccode() + "]" + card.getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
	                        }
	                        tctVoto.setBank_kmbm(obj==null?null:(String)obj);
	                        tctVoto.setJe(tctVoto.getJe().add(card.getPrice().multiply(card.getNumber())));
	                        tctVoto.getTallyobj().add(trans[i]);
	                        vTally.add(tctVoto);
	                        hmTally.put(toTallyKey,tctVoto);
                        }
                        
                    }
                }
                if(bTransToBank){
                    //Ҫ������
                    vTransToBank.add(trans[i]);
                } else {
                    //��������
                    ((TransHeaderVO)trans[i].getParentVO()).setTallyflag(new UFBoolean(true));
                    vRTrans.add(trans[i]);
                }
            }
            
            //����������ҵ��ϵͳ
            for (int i = 0; i < vTally.size(); i++) {
                TallyCorpTypeVO tctvo = (TallyCorpTypeVO)vTally.elementAt(i);
                try {
                    VoucherDealDMO vdmo = new VoucherDealDMO();
                    if(tctvo.getJe().compareTo(new UFDouble(0.0f))>0){
                        vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","1",tctvo.getJe());
                    } else {
                        vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","2",tctvo.getJe().multiply(new UFDouble(-1.0f)));
                    }
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        TransVO tvo = (TransVO) tallyobj;
                        TransHeaderVO header = (TransHeaderVO) tvo.getParentVO();
                        header.setTallyflag(new UFBoolean(true));
                        if(!vRTrans.contains(tallyobj)){
                            vRTrans.add(tallyobj);
                        }
                    }
                } catch (Exception ex){
                	ex.printStackTrace();
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        TransVO tvo = (TransVO) tallyobj;
                        TransHeaderVO header = (TransHeaderVO) tvo.getParentVO();
                        header.setTallyflag(new UFBoolean(false));
                        header.m_def5 = ex.getMessage();
                        if(!vRTrans.contains(tallyobj)){
                            vRTrans.add(tallyobj);
                        }
                    }
                }
            }
        }
        
        if(vRTrans.size()>0){
            rTrans = new TransVO[vRTrans.size()];
            vRTrans.copyInto(rTrans);
        }
        return rTrans;
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#doTallyCancel(nc.vo.lowcost.cancel.CancelVO[])
     */
    public CancelVO[] doTallyCancel(CancelVO[] cancels) throws Exception {
        // TODO �Զ����ɷ������
        CancelVO [] rCancel = null;
        Vector vRCancel = new Vector();
        
        Vector vTally = new Vector();
        HashMap hmTally = new HashMap();
        HashMap hmTypeCorp = null;
        HashMap hmDept = null;
        if(cancels!=null){
            hmTypeCorp = queryAllTypeCorp();
            hmDept = queryAllDept();
            for (int i = 0; i < cancels.length; i++) {
                CancelItemVO [] items = (CancelItemVO[])cancels[i].getChildrenVO();
                for (int j = 0; j < items.length; j++) {
                    CardVO card = (new CardDMO()).findByPrimaryKey(items[j].getPk_lccard());
                    items[j].m_cardvo = card;
                    card.setPk_corp((String)hmDept.get(card.getPk_usedept()));
                    
                    String typeCorpKey = card.getPk_corp()+"-"+card.getPk_lctype();
                    if(hmTally.containsKey(typeCorpKey)){
                        TallyCorpTypeVO tctvo = (TallyCorpTypeVO) hmTally.get(typeCorpKey);
                        tctvo.getTallyobj().add(cancels[i]);
                        tctvo.setJe(tctvo.getJe().add(card.getPrice().multiply(card.getNumber())));
                    } else {
                        TallyCorpTypeVO tctVo = new TallyCorpTypeVO();
                        tctVo.setPk_corp(card.getPk_corp());
                        tctVo.setPk_lctype(card.getPk_lctype());
                        Object obj = hmTypeCorp.get(tctVo.getPk_corp() + "-" + tctVo.getPk_lctype());
                        if(obj==null){
                            throw new Exception ("��Ʒ["+ card.getLccode() + "]" + card.getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
                        }
                        tctVo.setBank_kmbm(obj==null?null:(String)obj);
                        tctVo.getTallyobj().add(cancels[i]);
                        tctVo.setJe(tctVo.getJe().add(card.getPrice().multiply(card.getNumber())));
                        vTally.add(tctVo);
                        hmTally.put(typeCorpKey,tctVo);
                    }
                    
                }
            }
            
            
            
            //��ʼ����
            for (int i = 0; i < vTally.size(); i++) {
                TallyCorpTypeVO tctvo = (TallyCorpTypeVO)vTally.elementAt(i);
                try {
                    VoucherDealDMO vdmo = new VoucherDealDMO();
                    vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","2",tctvo.getJe());
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        CancelVO cvo = (CancelVO) tallyobj;
                        CancelHeaderVO header = (CancelHeaderVO) cvo.getParentVO();
                        header.setTallyflag(new UFBoolean(true));
                        if(!vRCancel.contains(tallyobj)){
                            vRCancel.add(tallyobj);
                        }
                    }
                } catch (Exception ex){
                	ex.printStackTrace();
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        CancelVO cvo = (CancelVO) tallyobj;
                        CancelHeaderVO header = (CancelHeaderVO) cvo.getParentVO();
                        header.setTallyflag(new UFBoolean(false));
                        header.m_def5 += ex.getMessage();
                        if(!vRCancel.contains(tallyobj)){
                            vRCancel.add(tallyobj);
                        }
                    }
                }
            }
        }
        
        if(vRCancel.size()>0){
            rCancel = new CancelVO[vRCancel.size()];
            vRCancel.copyInto(rCancel);
        }
        
        return rCancel;
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#undoTallyCard(nc.vo.lowcost.card.CardVO[])
     */
    public CardVO[] undoTallyCard(CardVO[] cards) throws Exception {
        // TODO �Զ����ɷ������
        CardVO [] rCards = null;
        Vector vRCards = new Vector();
        Vector vTally = new Vector();  //Ҫ������Ŀ
        HashMap hmTally = new HashMap();
        HashMap hmTypeCorp = null;
        cards = queryCardPkCorp(cards);
        
        if(cards!=null){
            
            //��ϳ�Ҫ���м��˵���Ŀ
            hmTypeCorp = queryAllTypeCorp();
            for (int i = 0; i < cards.length; i++) {
                String corpAndType = cards[i].getPk_corp() + "-" + cards[i].getPk_lctype();
                if(hmTally.containsKey(corpAndType)){
                    TallyCorpTypeVO tctVo = (TallyCorpTypeVO) hmTally.get(corpAndType);
                    tctVo.getTallyobj().add(cards[i]);
                    tctVo.setJe(tctVo.getJe().add(cards[i].getPrice().multiply(cards[i].getNumber())));
                } else {
                    TallyCorpTypeVO tctVo = new TallyCorpTypeVO();
                    tctVo.setPk_corp(cards[i].getPk_corp());
                    tctVo.setPk_lctype(cards[i].getPk_lctype());
                    Object obj = hmTypeCorp.get(tctVo.getPk_corp() + "-" + tctVo.getPk_lctype());
                    if(obj==null){
                        throw new Exception ("��Ʒ["+ cards[i].getLccode() + "]" + cards[i].getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
                    }
                    tctVo.setBank_kmbm(obj==null?null:(String)obj);
                    tctVo.getTallyobj().add(cards[i]);
                    tctVo.setJe(tctVo.getJe().add(cards[i].getPrice().multiply(cards[i].getNumber())));
                    vTally.add(tctVo);
                    hmTally.put(corpAndType,tctVo);
                }
            }
            
            //��ʼ����
            for (int i = 0; i < vTally.size(); i++) {
                TallyCorpTypeVO tctvo = (TallyCorpTypeVO)vTally.elementAt(i);
                try {
                    VoucherDealDMO vdmo = new VoucherDealDMO();
                    vRCards.addAll(tctvo.getTallyobj());
                    vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","2",tctvo.getJe());

                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        CardVO cvo = (CardVO)tctvo.getTallyobj().elementAt(j);
                        cvo.setTallyflag(new UFBoolean(false));
                    }
                } catch (Exception ex){
                	ex.printStackTrace();
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        CardVO cvo = (CardVO)tctvo.getTallyobj().elementAt(j);
                        cvo.setTallyflag(new UFBoolean(true));
                        cvo.setDef5(ex.getMessage());
                    }
                }
            }
            
            if(vRCards.size()>0){
                rCards = new CardVO[vRCards.size()];
                vRCards.copyInto(rCards);
            }
            
        }
        return rCards;
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#undoTallyTrans(nc.vo.lowcost.trans.TransVO[])
     */
    public TransVO[] undoTallyTrans(TransVO[] trans) throws Exception {
        // TODO �Զ����ɷ������
        TransVO [] rTrans = null;
        Vector vRTrans = new Vector();
        
        Vector vTally = new Vector();  //Ҫ������Ŀ
        HashMap hmTally = new HashMap();
        HashMap hmTypeCorp = null;
        HashMap hmDept = null;
        
        if(trans!=null){
            hmTypeCorp = queryAllTypeCorp();
            hmDept = queryAllDept();
            //��Ҫ���м��˵ĵ������ݣ�������������ǲ�ͬ����ʱ��������Ҫ����ķ��͵�������
            Vector vTransToBank = new Vector();
            for (int i = 0; i < trans.length; i++) {
                boolean bTransToBank = false;
                TransItemVO [] items = (TransItemVO[])trans[i].getChildrenVO();
                for (int j = 0; j < items.length; j++) {
                    Object fromCorp = hmDept.get(items[j].getPk_deptfrom());
                    Object toCorp = hmDept.get(items[j].getPk_deptto());
                    if(fromCorp!=null && (!fromCorp.equals(toCorp))){
                        bTransToBank = true;
                        CardVO card = (new CardDMO()).findByPrimaryKey(items[j].getPk_lccard());
                        items[i].card = card;
                        items[i].bTransToBank = true;
                        
                        String fromTallyKey = fromCorp+"-"+card.getPk_lctype();
                        String toTallyKey = toCorp+"-"+card.getPk_lctype();
                        
                        if(hmTally.containsKey(fromTallyKey)){
                            TallyCorpTypeVO tctVofrom = (TallyCorpTypeVO)hmTally.get(fromTallyKey);
                            tctVofrom.setJe(tctVofrom.getJe().add(card.getPrice().multiply(card.getNumber()).multiply(new UFDouble(-1.0f))));
                            tctVofrom.getTallyobj().add(trans[i]);
                        } else {
	                        TallyCorpTypeVO tctVofrom = new TallyCorpTypeVO();
	                        tctVofrom.setPk_corp((String)fromCorp);
	                        tctVofrom.setPk_lctype(card.getPk_lctype());
	                        Object obj = hmTypeCorp.get(tctVofrom.getPk_corp() + "-" + tctVofrom.getPk_lctype());
	                        if(obj==null){
	                            throw new Exception ("��Ʒ["+ card.getLccode() + "]" + card.getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
	                        }
	                        tctVofrom.setBank_kmbm(obj==null?null:(String)obj);
	                        tctVofrom.setJe(tctVofrom.getJe().add(card.getPrice().multiply(card.getNumber()).multiply(new UFDouble(-1.0f))));
	                        tctVofrom.getTallyobj().add(trans[i]);
	                        vTally.add(tctVofrom);
	                        hmTally.put(fromTallyKey,tctVofrom);
                        }
                        
                        if(hmTally.containsKey(toTallyKey)){
                            TallyCorpTypeVO tctVoto = (TallyCorpTypeVO)hmTally.get(toTallyKey);
                            tctVoto.setJe(tctVoto.getJe().add(card.getPrice().multiply(card.getNumber())));
                            tctVoto.getTallyobj().add(trans[i]);
                        } else {
	                        TallyCorpTypeVO tctVoto = new TallyCorpTypeVO();
	                        tctVoto.setPk_corp((String)toCorp);
	                        tctVoto.setPk_lctype(card.getPk_lctype());
	                        Object obj = hmTypeCorp.get(tctVoto.getPk_corp() + "-" + tctVoto.getPk_lctype());
	                        if(obj==null){
	                            throw new Exception ("��Ʒ["+ card.getLccode() + "]" + card.getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
	                        }
	                        tctVoto.setBank_kmbm(obj==null?null:(String)obj);
	                        tctVoto.setJe(tctVoto.getJe().add(card.getPrice().multiply(card.getNumber())));
	                        tctVoto.getTallyobj().add(trans[i]);
	                        vTally.add(tctVoto);
	                        hmTally.put(toTallyKey,tctVoto);
                        }
                        
                    }
                }
                if(bTransToBank){
                    //Ҫ������
                    vTransToBank.add(trans[i]);
                } else {
                    //��������
                    ((TransHeaderVO)trans[i].getParentVO()).setTallyflag(new UFBoolean(true));
                    vRTrans.add(trans[i]);
                }
            }
            
            //����������ҵ��ϵͳ
            for (int i = 0; i < vTally.size(); i++) {
                TallyCorpTypeVO tctvo = (TallyCorpTypeVO)vTally.elementAt(i);
                try {
                    VoucherDealDMO vdmo = new VoucherDealDMO();
                    if(tctvo.getJe().compareTo(new UFDouble(0.0f))>0){
                        vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","2",tctvo.getJe());
                    } else {
                        vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","1",tctvo.getJe().multiply(new UFDouble(-1.0f)));
                    }
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        TransVO tvo = (TransVO) tallyobj;
                        TransHeaderVO header = (TransHeaderVO) tvo.getParentVO();
                        header.setTallyflag(new UFBoolean(false));
                        if(!vRTrans.contains(tallyobj)){
                            vRTrans.add(tallyobj);
                        }
                    }
                } catch (Exception ex){
                	ex.printStackTrace();
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        TransVO tvo = (TransVO) tallyobj;
                        TransHeaderVO header = (TransHeaderVO) tvo.getParentVO();
                        header.setTallyflag(new UFBoolean(true));
                        header.m_def5 = ex.getMessage();
                        if(!vRTrans.contains(tallyobj)){
                            vRTrans.add(tallyobj);
                        }
                    }
                }
            }
        }
        
        if(vRTrans.size()>0){
            rTrans = new TransVO[vRTrans.size()];
            vRTrans.copyInto(rTrans);
        }
        return rTrans;
    }

    /* ���� Javadoc��
     * @see nc.bs.lowcost.tally.ILowCostTally#undoTallyCancel(nc.vo.lowcost.cancel.CancelVO[])
     */
    public CancelVO[] undoTallyCancel(CancelVO[] cancels) throws Exception {

        // TODO �Զ����ɷ������
        CancelVO [] rCancel = null;
        Vector vRCancel = new Vector();
        
        Vector vTally = new Vector();
        HashMap hmTally = new HashMap();
        HashMap hmTypeCorp = null;
        HashMap hmDept = null;
        if(cancels!=null){
            hmTypeCorp = queryAllTypeCorp();
            hmDept = queryAllDept();
            for (int i = 0; i < cancels.length; i++) {
                CancelItemVO [] items = (CancelItemVO[])cancels[i].getChildrenVO();
                for (int j = 0; j < items.length; j++) {
                    CardVO card = (new CardDMO()).findByPrimaryKey(items[j].getPk_lccard());
                    items[j].m_cardvo = card;
                    card.setPk_corp((String)hmDept.get(card.getPk_usedept()));
                    
                    String typeCorpKey = card.getPk_corp()+"-"+card.getPk_lctype();
                    if(hmTally.containsKey(typeCorpKey)){
                        TallyCorpTypeVO tctvo = (TallyCorpTypeVO) hmTally.get(typeCorpKey);
                        tctvo.getTallyobj().add(cancels[i]);
                        tctvo.setJe(tctvo.getJe().add(card.getPrice().multiply(card.getNumber())));
                    } else {
                        TallyCorpTypeVO tctVo = new TallyCorpTypeVO();
                        tctVo.setPk_corp(card.getPk_corp());
                        tctVo.setPk_lctype(card.getPk_lctype());
                        Object obj = hmTypeCorp.get(tctVo.getPk_corp() + "-" + tctVo.getPk_lctype());
                        if(obj==null){
                            throw new Exception ("��Ʒ["+ card.getLccode() + "]" + card.getLcname() + "������Ӧ����Ʒ���Ĵ���˺�û�����ã����ܽ��м��ˣ�");
                        }
                        tctVo.setBank_kmbm(obj==null?null:(String)obj);
                        tctVo.getTallyobj().add(cancels[i]);
                        tctVo.setJe(tctVo.getJe().add(card.getPrice().multiply(card.getNumber())));
                        vTally.add(tctVo);
                        hmTally.put(typeCorpKey,tctVo);
                    }
                    
                }
            }
            
            
            
            //��ʼ����
            for (int i = 0; i < vTally.size(); i++) {
                TallyCorpTypeVO tctvo = (TallyCorpTypeVO)vTally.elementAt(i);
                try {
                    VoucherDealDMO vdmo = new VoucherDealDMO();
                    vdmo.doLowCostTrade(tctvo.getPk_corp(),tctvo.getBank_kmbm(),"00010000000000000001","1",tctvo.getJe());
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        CancelVO cvo = (CancelVO) tallyobj;
                        CancelHeaderVO header = (CancelHeaderVO) cvo.getParentVO();
                        header.setTallyflag(new UFBoolean(false));
                        if(!vRCancel.contains(tallyobj)){
                            vRCancel.add(tallyobj);
                        }
                    }
                } catch (Exception ex){
                	ex.printStackTrace();
                    for (int j = 0; j < tctvo.getTallyobj().size(); j++) {
                        Object tallyobj = tctvo.getTallyobj().elementAt(j);
                        CancelVO cvo = (CancelVO) tallyobj;
                        CancelHeaderVO header = (CancelHeaderVO) cvo.getParentVO();
                        header.setTallyflag(new UFBoolean(true));
                        header.m_def5 += ex.getMessage();
                        if(!vRCancel.contains(tallyobj)){
                            vRCancel.add(tallyobj);
                        }
                    }
                }
            }
        }
        
        if(vRCancel.size()>0){
            rCancel = new CancelVO[vRCancel.size()];
            vRCancel.copyInto(rCancel);
        }
        
        return rCancel;
    }
    
    public CardVO [] queryCardPkCorp (CardVO [] cards) throws Exception {
        if(cards!=null){
            HashMap hmDept = queryAllDept();
            for (int i = 0; i < cards.length; i++) {
                Object obj = hmDept.get(cards[i].getPk_usedept());
                cards[i].setPk_corp(obj==null?null:(String)obj);
            }
        }
        return cards;
    }
    
    public HashMap queryAllDept () throws Exception {
        HashMap hmDept = new HashMap();
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select pk_deptdoc,pk_corp from bd_deptdoc";
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                hmDept.put(rs.getString(1),rs.getString(2));
            }
        } finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
        }
        return hmDept;
    }
    
    public HashMap queryAllTypeCorp() throws Exception {
        HashMap hmTypeCorp = new HashMap();
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "select pk_corp,pk_lctype,bank_kmbm from lc_subj";
        try {
            con = getConnection();
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                hmTypeCorp.put(rs.getString(1)+"-"+rs.getString(2),rs.getString(3));
            }
        } finally {
    		try {
    			if (stmt != null) {
    				stmt.close();
    			}
    		}catch (Exception e) {}
    		try {
    			if (con != null) {
    				con.close();
    			}
    		}catch (Exception e) {}
        }
        return hmTypeCorp;
    }
}
