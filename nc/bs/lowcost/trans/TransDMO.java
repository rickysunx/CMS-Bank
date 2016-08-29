/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product.                              *
\***************************************************************/

package nc.bs.lowcost.trans;

import java.sql.*;
import java.util.*;
import nc.bs.pub.*;
import nc.bs.pub.pf.IBackCheckState;
import nc.bs.pub.pf.ICheckState;
import nc.vo.pub.*;
import nc.vo.pub.lang.*;
import nc.vo.lowcost.trans.*;
/**
 * Trans��DMO�ࡣ
 *
 * �������ڣ�(2005-9-22)
 * @author��
 */
public class TransDMO extends DataManageObject implements ICheckState,IBackCheckState {
/**
 * TransDMO ������ע�⡣
 *
 * @exception javax.naming.NamingException ���๹�����׳����쳣��
 * @exception nc.bs.pub.SystemException ���๹�����׳����쳣��
 */
public TransDMO() throws javax.naming.NamingException, SystemException {
	super();
}
/**
 * TransDMO ������ע�⡣
 *
 * @param dbName java.lang.String ��EJB Server�����õ����ݿ�DataSource���ơ�
 * @exception javax.naming.NamingException ���๹�����׳����쳣��
 * @exception nc.bs.pub.SystemException ���๹�����׳����쳣��
 */
public TransDMO(String dbName) throws javax.naming.NamingException, SystemException {
	super(dbName);
}
/**
 * <p>���ݱ�ͷ��������ѯһ��VO��
 * <p>
 * �������ڣ�(2005-9-22)
 * @param key ??dbFieldType??
 * @exception java.sql.SQLException �쳣˵����
 */
public TransVO findByPrimaryKey(String key) throws SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "findByPrimaryKey", new Object[]{key});
	/*************************************************************/

	TransVO vo = new TransVO();
	//
	TransHeaderVO header = findHeaderByPrimaryKey(key);
	TransItemVO[] items = null;
	if (header != null) {
		items = findItemsForHeader(header.getPrimaryKey());
	}
	//
	vo.setParentVO(header);
	vo.setChildrenVO(items);

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "findByPrimaryKey", new Object[]{key});
	/*************************************************************/

	return vo;
}
/**
 * ͨ����������һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @return nc.vo.lowcost.trans.TransHeaderVO
 * @param key String
 * @exception java.sql.SQLException �쳣˵����
 */
public TransHeaderVO findHeaderByPrimaryKey(String key) throws SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "findHeaderByPrimaryKey", new Object[]{key});
	/*************************************************************/

	String sql = "select transcode, transreason, pk_maker, makedate, pk_checker, checkdate, checkflag, tallyflag, tallydate, def1, def2, def3, def4, def5 from lc_trans where pk_trans = ?";

	TransHeaderVO transHeader = null;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, key);
		ResultSet rs = stmt.executeQuery();
		//
		if (rs.next()) {
			transHeader = new TransHeaderVO(key);
			// transcode :
			String transcode = rs.getString(1);
			transHeader.setTranscode(transcode == null ? null : transcode.trim());
			// transreason :
			String transreason = rs.getString(2);
			transHeader.setTransreason(transreason == null ? null : transreason.trim());
			// pk_maker :
			String pk_maker = rs.getString(3);
			transHeader.setPk_maker(pk_maker == null ? null : pk_maker.trim());
			// makedate :
			String makedate = rs.getString(4);
			transHeader.setMakedate(makedate == null ? null : new UFDate(makedate.trim()));
			// pk_checker :
			String pk_checker = rs.getString(5);
			transHeader.setPk_checker(pk_checker == null ? null : pk_checker.trim());
			// checkdate :
			String checkdate = rs.getString(6);
			transHeader.setCheckdate(checkdate == null ? null : new UFDate(checkdate.trim()));
			// checkflag :
			String checkflag = rs.getString(7);
			transHeader.setCheckflag(checkflag == null ? null : new UFBoolean(checkflag.trim()));
			// tallyflag :
			String tallyflag = rs.getString(8);
			transHeader.setTallyflag(tallyflag == null ? null : new UFBoolean(tallyflag.trim()));
			// tallydate :
			String tallydate = rs.getString(9);
			transHeader.setTallydate(tallydate == null ? null : new UFDate(tallydate.trim()));
			// def1 :
			String def1 = rs.getString(10);
			transHeader.setDef1(def1 == null ? null : def1.trim());
			// def2 :
			String def2 = rs.getString(11);
			transHeader.setDef2(def2 == null ? null : def2.trim());
			// def3 :
			String def3 = rs.getString(12);
			transHeader.setDef3(def3 == null ? null : def3.trim());
			// def4 :
			String def4 = rs.getString(13);
			transHeader.setDef4(def4 == null ? null : def4.trim());
			// def5 :
			String def5 = rs.getString(14);
			transHeader.setDef5(def5 == null ? null : def5.trim());
		}
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "findHeaderByPrimaryKey", new Object[]{key});
	/*************************************************************/

	return transHeader;
}
/**
 * ͨ����������һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @return nc.vo.lowcost.trans.TransItemVO
 * @param key String
 * @exception java.sql.SQLException �쳣˵����
 */
public TransItemVO findItemByPrimaryKey(String key) throws SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "findItemByPrimaryKey", new Object[]{key});
	/*************************************************************/

	String sql = "select pk_trans, pk_lccard, pk_deptfrom, pk_deptto, def1, def2, def3, def4, def5 from lc_trans_m where pk_trans_m = ?";

	TransItemVO transItem = null;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, key);
		ResultSet rs = stmt.executeQuery();
		//
		if (rs.next()) {
			transItem = new TransItemVO(key);
			// pk_trans :
			String pk_trans = rs.getString(1);
			transItem.setPk_trans(pk_trans == null ? null : pk_trans.trim());
			// pk_lccard :
			String pk_lccard = rs.getString(2);
			transItem.setPk_lccard(pk_lccard == null ? null : pk_lccard.trim());
			// pk_deptfrom :
			String pk_deptfrom = rs.getString(3);
			transItem.setPk_deptfrom(pk_deptfrom == null ? null : pk_deptfrom.trim());
			// pk_deptto :
			String pk_deptto = rs.getString(4);
			transItem.setPk_deptto(pk_deptto == null ? null : pk_deptto.trim());
			// def1 :
			String def1 = rs.getString(5);
			transItem.setDef1(def1 == null ? null : def1.trim());
			// def2 :
			String def2 = rs.getString(6);
			transItem.setDef2(def2 == null ? null : def2.trim());
			// def3 :
			String def3 = rs.getString(7);
			transItem.setDef3(def3 == null ? null : def3.trim());
			// def4 :
			String def4 = rs.getString(8);
			transItem.setDef4(def4 == null ? null : def4.trim());
			// def5 :
			String def5 = rs.getString(9);
			transItem.setDef5(def5 == null ? null : def5.trim());
		}
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "findItemByPrimaryKey", new Object[]{key});
	/*************************************************************/

	return transItem;
}
/**
 * ͨ����������һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @return nc.vo.lowcost.trans.TransItemVO
 * @param key String
 * @exception java.sql.SQLException �쳣˵����
 */
public TransItemVO[] findItemsForHeader(String key) throws SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "findItemsForHeader", new Object[]{key});
	/*************************************************************/

	String sql = "select pk_trans_m, pk_trans, pk_lccard, pk_deptfrom, pk_deptto, def1, def2, def3, def4, def5 from lc_trans_m where pk_trans = ?";

	TransItemVO[] transItems = null;
	Vector v = new Vector();
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, key);
		ResultSet rs = stmt.executeQuery();
		//
		while (rs.next()) {
			TransItemVO transItem = new TransItemVO();
			//
			String pk_trans_m = rs.getString("pk_trans_m");
			transItem.setPk_trans_m(pk_trans_m == null ? null : pk_trans_m.trim());
			//
			String pk_trans = rs.getString("pk_trans");
			transItem.setPk_trans(pk_trans == null ? null : pk_trans.trim());
			//
			String pk_lccard = rs.getString("pk_lccard");
			transItem.setPk_lccard(pk_lccard == null ? null : pk_lccard.trim());
			//
			String pk_deptfrom = rs.getString("pk_deptfrom");
			transItem.setPk_deptfrom(pk_deptfrom == null ? null : pk_deptfrom.trim());
			//
			String pk_deptto = rs.getString("pk_deptto");
			transItem.setPk_deptto(pk_deptto == null ? null : pk_deptto.trim());
			//
			String def1 = rs.getString("def1");
			transItem.setDef1(def1 == null ? null : def1.trim());
			//
			String def2 = rs.getString("def2");
			transItem.setDef2(def2 == null ? null : def2.trim());
			//
			String def3 = rs.getString("def3");
			transItem.setDef3(def3 == null ? null : def3.trim());
			//
			String def4 = rs.getString("def4");
			transItem.setDef4(def4 == null ? null : def4.trim());
			//
			String def5 = rs.getString("def5");
			transItem.setDef5(def5 == null ? null : def5.trim());
			v.addElement(transItem);
		}
	}
	finally {
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
	transItems = new TransItemVO[v.size()];
	if (v.size() > 0){
		v.copyInto(transItems);
	}

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "findItemsForHeader", new Object[]{key});
	/*************************************************************/

	return transItems;
}
/**
 * <p>��VO����ĸ�ӱ���
 * <p>
 * �������ڣ�(2005-9-22)
 * @param vo nc.vo.lowcost.trans.TransVO
 * @exception java.sql.SQLException �쳣˵����
 */
public String insert(TransVO vo) throws SQLException, SystemException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "insert", new Object[]{vo});
	/*************************************************************/

	// �����ͷ��
	String key = insertHeader((TransHeaderVO) vo.getParentVO());
	// ���������
	TransItemVO[] items = (TransItemVO[]) vo.getChildrenVO();
	for ( int i = 0; i < items.length; i++ ) {
		insertItem(items[i], key);
	}

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "insert", new Object[]{vo});
	/*************************************************************/

	return key;
}
/**
 * �����ݿ����һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @param node nc.vo.lowcost.trans.TransHeaderVO
 * @exception java.sql.SQLException �쳣˵����
 */
public String insertHeader(TransHeaderVO transHeader) throws java.sql.SQLException, nc.bs.pub.SystemException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "insertHeader", new Object[]{transHeader});
	/*************************************************************/

	String sql = "insert into lc_trans(pk_trans, transcode, transreason, pk_maker, makedate, pk_checker, checkdate, checkflag, tallyflag, tallydate, def1, def2, def3, def4, def5) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String key = null;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		key = getOID();
		con = getConnection();
		stmt = con.prepareStatement(sql);
		// set PK fields:
		stmt.setString(1, key);
		// set non PK fields:
		if (transHeader.getTranscode() == null) {
			stmt.setNull(2, Types.CHAR);
		}
		else {
			stmt.setString(2, transHeader.getTranscode());
		}
		if (transHeader.getTransreason() == null) {
			stmt.setNull(3, Types.CHAR);
		}
		else {
			stmt.setString(3, transHeader.getTransreason());
		}
		if (transHeader.getPk_maker() == null) {
			stmt.setNull(4, Types.CHAR);
		}
		else {
			stmt.setString(4, transHeader.getPk_maker());
		}
		if (transHeader.getMakedate() == null) {
			stmt.setNull(5, Types.CHAR);
		}
		else {
			stmt.setString(5, transHeader.getMakedate().toString());
		}
		if (transHeader.getPk_checker() == null) {
			stmt.setNull(6, Types.CHAR);
		}
		else {
			stmt.setString(6, transHeader.getPk_checker());
		}
		if (transHeader.getCheckdate() == null) {
			stmt.setNull(7, Types.CHAR);
		}
		else {
			stmt.setString(7, transHeader.getCheckdate().toString());
		}
		if (transHeader.getCheckflag() == null) {
			stmt.setNull(8, Types.CHAR);
		}
		else {
			stmt.setString(8, transHeader.getCheckflag().toString());
		}
		if (transHeader.getTallyflag() == null) {
			stmt.setNull(9, Types.CHAR);
		}
		else {
			stmt.setString(9, transHeader.getTallyflag().toString());
		}
		if (transHeader.getTallydate() == null) {
			stmt.setNull(10, Types.CHAR);
		}
		else {
			stmt.setString(10, transHeader.getTallydate().toString());
		}
		if (transHeader.getDef1() == null) {
			stmt.setNull(11, Types.CHAR);
		}
		else {
			stmt.setString(11, transHeader.getDef1());
		}
		if (transHeader.getDef2() == null) {
			stmt.setNull(12, Types.CHAR);
		}
		else {
			stmt.setString(12, transHeader.getDef2());
		}
		if (transHeader.getDef3() == null) {
			stmt.setNull(13, Types.CHAR);
		}
		else {
			stmt.setString(13, transHeader.getDef3());
		}
		if (transHeader.getDef4() == null) {
			stmt.setNull(14, Types.CHAR);
		}
		else {
			stmt.setString(14, transHeader.getDef4());
		}
		if (transHeader.getDef5() == null) {
			stmt.setNull(15, Types.CHAR);
		}
		else {
			stmt.setString(15, transHeader.getDef5());
		}
		//
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "insertHeader", new Object[]{transHeader});
	/*************************************************************/

	return key;
}
/**
 * �����ݿ����һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @param node nc.vo.lowcost.trans.TransItemVO
 * @exception java.sql.SQLException �쳣˵����
 */
public String insertItem(TransItemVO transItem) throws java.sql.SQLException, nc.bs.pub.SystemException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "insertItem", new Object[]{transItem});
	/*************************************************************/

	String sql = "insert into lc_trans_m(pk_trans_m, pk_trans, pk_lccard, pk_deptfrom, pk_deptto, def1, def2, def3, def4, def5) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String key = null;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		key = getOID();
		con = getConnection();
		stmt = con.prepareStatement(sql);
		// set PK fields:
		stmt.setString(1, key);
		// set non PK fields:
		if (transItem.getPk_trans() == null) {
			stmt.setNull(2, Types.CHAR);
		}
		else {
			stmt.setString(2, transItem.getPk_trans());
		}
		if (transItem.getPk_lccard() == null) {
			stmt.setNull(3, Types.CHAR);
		}
		else {
			stmt.setString(3, transItem.getPk_lccard());
		}
		if (transItem.getPk_deptfrom() == null) {
			stmt.setNull(4, Types.CHAR);
		}
		else {
			stmt.setString(4, transItem.getPk_deptfrom());
		}
		if (transItem.getPk_deptto() == null) {
			stmt.setNull(5, Types.CHAR);
		}
		else {
			stmt.setString(5, transItem.getPk_deptto());
		}
		if (transItem.getDef1() == null) {
			stmt.setNull(6, Types.CHAR);
		}
		else {
			stmt.setString(6, transItem.getDef1());
		}
		if (transItem.getDef2() == null) {
			stmt.setNull(7, Types.CHAR);
		}
		else {
			stmt.setString(7, transItem.getDef2());
		}
		if (transItem.getDef3() == null) {
			stmt.setNull(8, Types.CHAR);
		}
		else {
			stmt.setString(8, transItem.getDef3());
		}
		if (transItem.getDef4() == null) {
			stmt.setNull(9, Types.CHAR);
		}
		else {
			stmt.setString(9, transItem.getDef4());
		}
		if (transItem.getDef5() == null) {
			stmt.setNull(10, Types.CHAR);
		}
		else {
			stmt.setString(10, transItem.getDef5());
		}
		//
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "insertItem", new Object[]{transItem});
	/*************************************************************/

	return key;
}
/**
 * <p>�����ݿ����һ��VO����
 * <p>
 * �������ڣ�(2005-9-22)
 * @param TransItem nc.vo.lowcost.trans.TransItemVO
 * @param foreignKey String
 * @exception java.sql.SQLException �쳣˵����
 */
public String insertItem(TransItemVO transItem, String foreignKey) throws java.sql.SQLException, nc.bs.pub.SystemException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "insertItem", new Object[]{transItem, foreignKey});
	/*************************************************************/

	transItem.setPk_trans(foreignKey);
	String key = insertItem(transItem);

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "insertItem", new Object[]{transItem, foreignKey});
	/*************************************************************/

	return key;
}
/**
 * <p>ɾ��ĸ�ӱ����������ݡ�
 * <p>
 * �������ڣ�(2005-9-22)
 * @param key String
 * @exception java.sql.SQLException �쳣˵����
 */
public void delete(TransVO vo) throws java.sql.SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "delete", new Object[]{vo});
	/*************************************************************/

	deleteItemsForHeader(((TransHeaderVO)vo.getParentVO()).getPrimaryKey());
	deleteHeader((TransHeaderVO)vo.getParentVO());

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "delete", new Object[]{vo});
	/*************************************************************/
}
/**
 * �������������ݿ���ɾ��һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @param key nc.vo.pub.oid.OID
 * @exception java.sql.SQLException �쳣˵����
 */
public void deleteHeader(TransHeaderVO vo) throws java.sql.SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "deleteHeader", new Object[]{vo});
	/*************************************************************/

	String sql = "delete from lc_trans where pk_trans = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con=getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, vo.getPrimaryKey());
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "deleteHeader", new Object[]{vo});
	/*************************************************************/
}
/**
 * �������������ݿ���ɾ��һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @param key nc.vo.pub.oid.OID
 * @exception java.sql.SQLException �쳣˵����
 */
public void deleteItem(TransItemVO vo) throws java.sql.SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "deleteItem", new Object[]{vo});
	/*************************************************************/

	String sql = "delete from lc_trans_m where pk_trans_m = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con=getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, vo.getPrimaryKey());
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "deleteItem", new Object[]{vo});
	/*************************************************************/
}
/**
 * �������������ݿ���ɾ��һ��VO����
 *
 * �������ڣ�(2005-9-22)
 * @param key nc.vo.pub.oid.OID
 * @exception java.sql.SQLException �쳣˵����
 */
public void deleteItemsForHeader(String headerKey) throws java.sql.SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "deleteItemsForHeader", new Object[]{headerKey});
	/*************************************************************/

	String sql = "delete from lc_trans_m where pk_trans = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con=getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, headerKey);
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "deleteItemsForHeader", new Object[]{headerKey});
	/*************************************************************/
}
/**
 * <p>ʹ��VO��ֵ����ĸ�ӱ���
 * <p>
 * �������ڣ�(2005-9-22)
 * @param vo nc.vo.lowcost.trans.TransVO
 * @exception java.sql.SQLException �쳣˵����
 */
public void update(TransVO vo) throws SQLException, BusinessException, SystemException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "update", new Object[]{vo});
	/*************************************************************/

	TransItemVO[] items = (TransItemVO[]) vo.getChildrenVO();
	for ( int i = 0; i < items.length; i++ ) {
		switch (items[i].getStatus()) {
			case VOStatus.NEW :
				insertItem(items[i]);
				break;
			case VOStatus.UPDATED :
				updateItem(items[i]);
				break;
			case VOStatus.DELETED :
				deleteItem(items[i]);
		}
	}
	updateHeader((TransHeaderVO) vo.getParentVO());

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "update", new Object[]{vo});
	/*************************************************************/
}
/**
 * ��һ��VO��������Ը������ݿ��е�ֵ��
 *
 * �������ڣ�(2005-9-22)
 * @param transHeader nc.vo.lowcost.trans.TransHeaderVO
 * @exception java.sql.SQLException �쳣˵����
 */
public void updateHeader(TransHeaderVO transHeader) throws java.sql.SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "updateHeader", new Object[]{transHeader});
	/*************************************************************/

	String sql = "update lc_trans set transcode = ?, transreason = ?, pk_maker = ?, makedate = ?, pk_checker = ?, checkdate = ?, checkflag = ?, tallyflag = ?, tallydate = ?, def1 = ?, def2 = ?, def3 = ?, def4 = ?, def5 = ? where pk_trans = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con=getConnection();
		stmt = con.prepareStatement(sql);
		// update non PK fields:
		if (transHeader.getTranscode() == null) {
			stmt.setNull(1, Types.CHAR);
		}
		else {
			stmt.setString(1, transHeader.getTranscode());
		}
		if (transHeader.getTransreason() == null) {
			stmt.setNull(2, Types.CHAR);
		}
		else {
			stmt.setString(2, transHeader.getTransreason());
		}
		if (transHeader.getPk_maker() == null) {
			stmt.setNull(3, Types.CHAR);
		}
		else {
			stmt.setString(3, transHeader.getPk_maker());
		}
		if (transHeader.getMakedate() == null) {
			stmt.setNull(4, Types.CHAR);
		}
		else {
			stmt.setString(4, transHeader.getMakedate().toString());
		}
		if (transHeader.getPk_checker() == null) {
			stmt.setNull(5, Types.CHAR);
		}
		else {
			stmt.setString(5, transHeader.getPk_checker());
		}
		if (transHeader.getCheckdate() == null) {
			stmt.setNull(6, Types.CHAR);
		}
		else {
			stmt.setString(6, transHeader.getCheckdate().toString());
		}
		if (transHeader.getCheckflag() == null) {
			stmt.setNull(7, Types.CHAR);
		}
		else {
			stmt.setString(7, transHeader.getCheckflag().toString());
		}
		if (transHeader.getTallyflag() == null) {
			stmt.setNull(8, Types.CHAR);
		}
		else {
			stmt.setString(8, transHeader.getTallyflag().toString());
		}
		if (transHeader.getTallydate() == null) {
			stmt.setNull(9, Types.CHAR);
		}
		else {
			stmt.setString(9, transHeader.getTallydate().toString());
		}
		if (transHeader.getDef1() == null) {
			stmt.setNull(10, Types.CHAR);
		}
		else {
			stmt.setString(10, transHeader.getDef1());
		}
		if (transHeader.getDef2() == null) {
			stmt.setNull(11, Types.CHAR);
		}
		else {
			stmt.setString(11, transHeader.getDef2());
		}
		if (transHeader.getDef3() == null) {
			stmt.setNull(12, Types.CHAR);
		}
		else {
			stmt.setString(12, transHeader.getDef3());
		}
		if (transHeader.getDef4() == null) {
			stmt.setNull(13, Types.CHAR);
		}
		else {
			stmt.setString(13, transHeader.getDef4());
		}
		if (transHeader.getDef5() == null) {
			stmt.setNull(14, Types.CHAR);
		}
		else {
			stmt.setString(14, transHeader.getDef5());
		}
		// find record by PK fields:
		stmt.setString(15, transHeader.getPrimaryKey());
		//
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "updateHeader", new Object[]{transHeader});
	/*************************************************************/
}
/**
 * ��һ��VO��������Ը������ݿ��е�ֵ��
 *
 * �������ڣ�(2005-9-22)
 * @param transItem nc.vo.lowcost.trans.TransItemVO
 * @exception java.sql.SQLException �쳣˵����
 */
public void updateItem(TransItemVO transItem) throws java.sql.SQLException {

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	beforeCallMethod("nc.bs.lowcost.trans.TransDMO", "updateItem", new Object[]{transItem});
	/*************************************************************/

	String sql = "update lc_trans_m set pk_trans = ?, pk_lccard = ?, pk_deptfrom = ?, pk_deptto = ?, def1 = ?, def2 = ?, def3 = ?, def4 = ?, def5 = ? where pk_trans_m = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con=getConnection();
		stmt = con.prepareStatement(sql);
		// update non PK fields:
		if (transItem.getPk_trans() == null) {
			stmt.setNull(1, Types.CHAR);
		}
		else {
			stmt.setString(1, transItem.getPk_trans());
		}
		if (transItem.getPk_lccard() == null) {
			stmt.setNull(2, Types.CHAR);
		}
		else {
			stmt.setString(2, transItem.getPk_lccard());
		}
		if (transItem.getPk_deptfrom() == null) {
			stmt.setNull(3, Types.CHAR);
		}
		else {
			stmt.setString(3, transItem.getPk_deptfrom());
		}
		if (transItem.getPk_deptto() == null) {
			stmt.setNull(4, Types.CHAR);
		}
		else {
			stmt.setString(4, transItem.getPk_deptto());
		}
		if (transItem.getDef1() == null) {
			stmt.setNull(5, Types.CHAR);
		}
		else {
			stmt.setString(5, transItem.getDef1());
		}
		if (transItem.getDef2() == null) {
			stmt.setNull(6, Types.CHAR);
		}
		else {
			stmt.setString(6, transItem.getDef2());
		}
		if (transItem.getDef3() == null) {
			stmt.setNull(7, Types.CHAR);
		}
		else {
			stmt.setString(7, transItem.getDef3());
		}
		if (transItem.getDef4() == null) {
			stmt.setNull(8, Types.CHAR);
		}
		else {
			stmt.setString(8, transItem.getDef4());
		}
		if (transItem.getDef5() == null) {
			stmt.setNull(9, Types.CHAR);
		}
		else {
			stmt.setString(9, transItem.getDef5());
		}
		// find record by PK fields:
		stmt.setString(10, transItem.getPrimaryKey());
		//
		stmt.executeUpdate();
	}
	finally {
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

	/*************************************************************/
	// ������ϵͳ�����ӿڣ�
	afterCallMethod("nc.bs.lowcost.trans.TransDMO", "updateItem", new Object[]{transItem});
	/*************************************************************/
}
/* ���� Javadoc��
 * @see nc.bs.pub.pf.ICheckState#checkGoing(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
public boolean checkGoing(String billId, String ApproveId, String ApproveDate, String checkNote) throws Exception {
    System.out.println("");
    System.out.println("----------------checkGoing start-----------");
    System.out.println("billid:" + billId);
    System.out.println("ApproveId:" + ApproveId);
    System.out.println("ApproveDate:" + ApproveDate);
    System.out.println("checkNote:" + checkNote);
    System.out.println("----------------checkGoing end-----------");
    return false;
}
/* ���� Javadoc��
 * @see nc.bs.pub.pf.ICheckState#checkNoPass(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
public boolean checkNoPass(String billId, String ApproveId, String ApproveDate, String checkNote) throws Exception {
    System.out.println("");
    System.out.println("----------------checkNoPass start-----------");
    System.out.println("billid:" + billId);
    System.out.println("ApproveId:" + ApproveId);
    System.out.println("ApproveDate:" + ApproveDate);
    System.out.println("checkNote:" + checkNote);
    System.out.println("----------------checkNoPass end-----------");
    return false;
}
/* ���� Javadoc��
 * @see nc.bs.pub.pf.ICheckState#checkPass(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
public boolean checkPass(String billId, String ApproveId, String ApproveDate, String checkNote) throws Exception {
    System.out.println("");
    System.out.println("----------------checkPass start-----------");
    System.out.println("billid:" + billId);
    System.out.println("ApproveId:" + ApproveId);
    System.out.println("ApproveDate:" + ApproveDate);
    System.out.println("checkNote:" + checkNote);
    System.out.println("----------------checkPass end-----------");
    return false;
}
/* ���� Javadoc��
 * @see nc.bs.pub.pf.IBackCheckState#backGoing(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
public void backGoing(String billId, String approveId, String approveDate, String backNote) throws Exception {
    System.out.println("");
    System.out.println("----------------backGoing start-----------");
    System.out.println("billid:" + billId);
    System.out.println("ApproveId:" + approveId);
    System.out.println("ApproveDate:" + approveDate);
    System.out.println("checkNote:" + backNote);
    System.out.println("----------------backGoing end-----------");
    
}
/* ���� Javadoc��
 * @see nc.bs.pub.pf.IBackCheckState#backNoState(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
public void backNoState(String billId, String approveId, String approveDate, String backNote) throws Exception {
    System.out.println("");
    System.out.println("----------------backNoState start-----------");
    System.out.println("billid:" + billId);
    System.out.println("ApproveId:" + approveId);
    System.out.println("ApproveDate:" + approveDate);
    System.out.println("checkNote:" + backNote);
    System.out.println("----------------backNoState end-----------");
    
}
}