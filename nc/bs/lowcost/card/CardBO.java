/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product.                              *
\***************************************************************/

package nc.bs.lowcost.card;

import java.util.*;
import java.rmi.*;

import nc.bs.lowcost.type.TypeDMO;
import nc.bs.pub.*;
import nc.vo.lowcost.card.*;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
/**
 * Card��BO��
 *
 * �������ڣ�(2005-9-16)
 * @author��
 */
public class CardBO extends BusinessObject {

/**
	 * 
	 */
	private static final long serialVersionUID = 2770137194800228372L;

/**
 * CardBO ������ע�⡣
 */
public CardBO() {
	super();
}
/**
 * EJB�淶��Ҫ��ķ�����
 *
 * �������ڣ�(2005-9-16)
 */
public void ejbCreate() {}
/**
 * ͨ���������VO����
 *
 * �������ڣ�(2005-9-16)
 * @return nc.vo.lowcost.card.CardVO
 * @param key String
 * @exception java.rmi.RemoteException �쳣˵����
 */
public CardVO findByPrimaryKey(String key) throws java.rmi.RemoteException {

	CardVO card = null;
	try {
		CardDMO dmo = new CardDMO();
		card = dmo.findByPrimaryKey(key);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::findByPrimaryKey(CardPK) Exception!", e);
	}
	return card;
}
/**
 * �����ݿ��в���һ��VO����
 *
 * �������ڣ�(2005-9-16)
 * @param card nc.vo.lowcost.card.CardVO
 * @return java.lang.String  ������VO����������ַ�����
 * @exception java.rmi.RemoteException �쳣˵����
 */
public String insert(CardVO card) throws RemoteException {

	try {
		CardDMO dmo = new CardDMO();
		//У���Ƿ����ظ��ı���
		if(card.getLccode()!=null&&card.getLccode().trim().length()>0){
		    dmo.checkCardCode(card.getLccode(),null);
		}
		/*
		if(!(new TypeDMO()).isLeafNode(card.getPk_lctype())){
		    throw new Exception ("��Ʒ���Ϊ��ĩ����Ʒ���");
		}
		*/
		String key = dmo.insert(card);
		return key;
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBO::insert(CardVO) Exception!", e);
	}
}

public void copy(CardVO vo,int n) throws RemoteException {
    try {
        vo.setLccode(null);
        vo.setTallydate(null);
        vo.setTallyflag(new UFBoolean(false));
        vo.setCanceldate(null);
        vo.setCancelflag(new UFBoolean(false));
        for (int i = 0; i < n; i++) {
            (new CardDMO()).insert(vo);
        }
    } catch (Exception e){
        e.printStackTrace();
        throw new RemoteException(e.getMessage());
    }
}
/**
 * �����ݿ��в���һ��VO����
 *
 * �������ڣ�(2005-9-16)
 * @param card nc.vo.lowcost.card.CardVO[]
 * @return java.lang.String[]  ������VO��������������ַ������顣
 * @exception java.rmi.RemoteException �쳣˵����
 */
public String[] insertArray(CardVO[] cards) throws RemoteException {

	try {
		CardDMO dmo = new CardDMO();
		
		for (int i = 0; i < cards.length; i++) {
		    try {
	            cards[i].setLccode(null/*dmo.getLcCode(cards[i].getDef5())*/);
	            cards[i].setPk_lctype(dmo.getLcTypePkByCode(cards[i].getPk_lctype()));
	            cards[i].setPk_managedept(dmo.getDeptPkByCode(cards[i].getDef5(),cards[i].getPk_managedept()));
	            cards[i].setPk_usedept(dmo.getDeptPkByCode(cards[i].getDef5(),cards[i].getPk_usedept()));
	            cards[i].setTallyflag(new UFBoolean(true));
	            cards[i].setTallydate(new UFDate(new Date()));
	            if(cards[i].getDef1()!=null && cards[i].getDef1().trim().length()>0){
	                cards[i].setDef1(dmo.getPsndocPkByCode(cards[i].getDef5(),cards[i].getDef1()));
	            }
			    dmo.insert(cards[i]);
		    } catch (Exception e) {
		        throw new Exception ("�����" + (i+2) +"�����ݳ�����" + e.getMessage());
		    }
        }
		
		//String[] keys = dmo.insertArray(cards);
		return null;
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBO::insertArray(CardVO[]) Exception!", e);
	}
}
/**
 * �������������ݿ���ɾ��һ��VO����
 *
 * �������ڣ�(2005-9-16)
 * @param key String
 * @exception java.rmi.RemoteException �쳣˵����
 */
public void delete(CardVO vo) throws java.rmi.RemoteException {

	try {
		CardDMO dmo = new CardDMO();
		dmo.delete(vo);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBO::delete(CardPK) Exception!", e);
	}
}
/**
 * ��VO���������ֵ�������ݿ⡣
 *
 * �������ڣ�(2005-9-16)
 * @param card nc.vo.lowcost.card.CardVO
 * @exception java.rmi.RemoteException �쳣˵����
 */
public void update(CardVO card) throws java.rmi.RemoteException {

	try {
		CardDMO dmo = new CardDMO();
		//dmo.checkCardCode(card.getLccode(),card.getPk_lccard());
		if(!(new TypeDMO()).isLeafNode(card.getPk_lctype())){
		    throw new Exception ("��Ʒ���Ϊ��ĩ����Ʒ���");
		}
		dmo.update(card);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBO::update(CardVO) Exception!", e);
	}
}
/**
 * ͨ����λ���뷵��ָ����˾���м�¼VO���顣�����λ����Ϊ�շ������м�¼��
 *
 * �������ڣ�(2005-9-16)
 * @return nc.vo.lowcost.card.CardVO[] �鵽��VO��������
 * @param unitCode int
 * @exception java.rmi.RemoteException �쳣˵����
 */
public CardVO[] queryAll(String pk_corp) throws java.rmi.RemoteException {

	CardVO[] cards = null;
	try {
		CardDMO dmo = new CardDMO();
		cards = dmo.queryAll(pk_corp);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::queryAll(String pk_corp) Exception!", e);
	}
	return cards;
}

public Vector getControlPks(String corp,String user,String objname) throws RemoteException{
	Vector pks = null;
	try {
		CardDMO dmo = new CardDMO();
		pks = dmo.getControlPks(corp,user,objname);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::getControlPks(String pk_corp,String user,String objname) Exception!", e);
	}
	return pks;
}

public boolean isControl(String corp,String objname) throws RemoteException{
	boolean flag = false;
	try {
		CardDMO dmo = new CardDMO();
		flag = dmo.isControl(corp,objname);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::isControl(String corp,String objname) Exception!", e);
	}
	return flag;
}
/**
 * ����VO�����趨�������������з���������VO����
 *
 * �������ڣ�(2005-9-16)
 * @return nc.vo.lowcost.card.CardVO[]
 * @param cardVO nc.vo.lowcost.card.CardVO
 * @param isAnd boolean ����������ѯ�����Ի�������ѯ
 * @exception java.sql.SQLException �쳣˵����
 */
public CardVO[] queryByVO(CardVO condCardVO, Boolean isAnd) throws java.rmi.RemoteException {

	CardVO[] cards = null;
	try {
		CardDMO dmo = new CardDMO();
		cards = dmo.queryByVO(condCardVO, isAnd);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::queryByVO(CardVO condCardVO, Boolean isAnd) Exception!", e);
	}
	return cards;
}

public CardVO[] queryByCondVO(CardVO condVO) throws RemoteException {
	CardVO[] cards = null;
	try {
		CardDMO dmo = new CardDMO();
		cards = dmo.queryByCondVO(condVO);
	}catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::queryByCondVO(CardVO condVO) Exception!", e);
	}
	return cards;
}

public CardVO [] queryByWhereSqlAndWithUseDept(String whereSql) throws RemoteException {
	CardVO[] cards = null;
	try {
		CardDMO dmo = new CardDMO();
		cards = dmo.queryByWhereSqlAndWithUseDept(whereSql);
	}
	catch (Exception e) {
		reportException(e);
		throw new RemoteException("CardBean::queryByWhereSqlAndWithUseDept(String whereSql) Exception!", e);
	}
	return cards;    
}

public String getLcCode(String prefix) throws RemoteException {
    String lcCode = null;
    try {
        lcCode = (new CardDMO()).getLcCode(prefix);
    } catch (Exception e){
        reportException(e);
        throw new RemoteException(e.getMessage());
    }
    return lcCode;
}

public void check(CardVO [] vos,String pk_checker) throws RemoteException {
    try {
        (new CardDMO()).check(vos,pk_checker);
    } catch (Exception e){
        e.printStackTrace();
        throw new RemoteException(e.getMessage());
    }
}
}