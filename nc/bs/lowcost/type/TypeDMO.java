/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product.                              *
\***************************************************************/

package nc.bs.lowcost.type;

import java.sql.*;
import java.math.*;
import java.util.*;
import nc.bs.pub.*;
import nc.vo.pub.lang.*;
import nc.vo.lowcost.type.*;
/**
 * Type的DMO类。
 *
 * 创建日期：(2005-9-16)
 * @author：
 */
public class TypeDMO extends DataManageObject {
/**
 * TypeDMO 构造子注解。
 *
 * @exception javax.naming.NamingException 父类构造子抛出的异常。
 * @exception nc.bs.pub.SystemException 父类构造子抛出的异常。
 */
public TypeDMO() throws javax.naming.NamingException, SystemException {
	super();
}
/**
 * TypeDMO 构造子注解。
 *
 * @param dbName java.lang.String 在EJB Server中配置的数据库DataSource名称。
 * @exception javax.naming.NamingException 父类构造子抛出的异常。
 * @exception nc.bs.pub.SystemException 父类构造子抛出的异常。
 */
public TypeDMO(String dbName) throws javax.naming.NamingException, SystemException {
	super(dbName);
}
/**
 * 通过主键查找一个VO对象。
 *
 * 创建日期：(2005-9-16)
 * @return nc.vo.lowcost.type.TypeVO
 * @param key String
 * @exception java.sql.SQLException 异常说明。
 */
public TypeVO findByPrimaryKey(String key) throws SQLException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "findByPrimaryKey", new Object[]{key});
	/*************************************************************/

	String sql = "select pk_parent, lctypecode, lctypename, def1, def2, def3, def4, def5 from lc_type where pk_lctype = ?";

	TypeVO type = null;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, key);
		ResultSet rs = stmt.executeQuery();
		//
		if (rs.next()) {
			type = new TypeVO(key);
			// pk_parent :
			String pk_parent = rs.getString(1);
			type.setPk_parent(pk_parent == null ? null : pk_parent.trim());
			// lctypecode :
			String lctypecode = rs.getString(2);
			type.setLctypecode(lctypecode == null ? null : lctypecode.trim());
			// lctypename :
			String lctypename = rs.getString(3);
			type.setLctypename(lctypename == null ? null : lctypename.trim());
			// def1 :
			String def1 = rs.getString(4);
			type.setDef1(def1 == null ? null : def1.trim());
			// def2 :
			String def2 = rs.getString(5);
			type.setDef2(def2 == null ? null : def2.trim());
			// def3 :
			String def3 = rs.getString(6);
			type.setDef3(def3 == null ? null : def3.trim());
			// def4 :
			String def4 = rs.getString(7);
			type.setDef4(def4 == null ? null : def4.trim());
			// def5 :
			String def5 = rs.getString(8);
			type.setDef5(def5 == null ? null : def5.trim());
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
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "findByPrimaryKey", new Object[]{key});
	/*************************************************************/

	return type;
}
/**
 * 向数据库插入一个VO对象。
 *
 * 创建日期：(2005-9-16)
 * @param node nc.vo.lowcost.type.TypeVO
 * @exception java.sql.SQLException 异常说明。
 */
public String insert(TypeVO type) throws java.sql.SQLException, nc.bs.pub.SystemException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "insert", new Object[]{type});
	/*************************************************************/

	String sql = "insert into lc_type(pk_lctype, pk_parent, lctypecode, lctypename, def1, def2, def3, def4, def5) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
		if (type.getPk_parent() == null) {
			stmt.setNull(2, Types.CHAR);
		}
		else {
			stmt.setString(2, type.getPk_parent());
		}
		if (type.getLctypecode() == null) {
			stmt.setNull(3, Types.CHAR);
		}
		else {
			stmt.setString(3, type.getLctypecode());
		}
		if (type.getLctypename() == null) {
			stmt.setNull(4, Types.CHAR);
		}
		else {
			stmt.setString(4, type.getLctypename());
		}
		if (type.getDef1() == null) {
			stmt.setNull(5, Types.CHAR);
		}
		else {
			stmt.setString(5, type.getDef1());
		}
		if (type.getDef2() == null) {
			stmt.setNull(6, Types.CHAR);
		}
		else {
			stmt.setString(6, type.getDef2());
		}
		if (type.getDef3() == null) {
			stmt.setNull(7, Types.CHAR);
		}
		else {
			stmt.setString(7, type.getDef3());
		}
		if (type.getDef4() == null) {
			stmt.setNull(8, Types.CHAR);
		}
		else {
			stmt.setString(8, type.getDef4());
		}
		if (type.getDef5() == null) {
			stmt.setNull(9, Types.CHAR);
		}
		else {
			stmt.setString(9, type.getDef5());
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
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "insert", new Object[]{type});
	/*************************************************************/

	return key;
}
/**
 * 向数据库插入一批VO对象。
 *
 * 创建日期：(2005-9-16)
 * @param types nc.vo.lowcost.type.TypeVO[]
 * @exception java.sql.SQLException 异常说明。
 */
public String[] insertArray(TypeVO[] types) throws java.sql.SQLException, nc.bs.pub.SystemException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "insertArray", new Object[]{types});
	/*************************************************************/

	String sql = "insert into lc_type(pk_lctype, pk_parent, lctypecode, lctypename, def1, def2, def3, def4, def5) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String[] keys = null;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		keys = getOIDs(types.length);
		con = getConnection();
		stmt = con.prepareStatement(sql);
		for (int i = 0; i < types.length; i++) {
			// set PK fields:
			stmt.setString(1, keys[i]);
			// set non PK fields:
			if (types[i].getPk_parent() == null) {
				stmt.setNull(2, Types.CHAR);
			}
			else {
				stmt.setString(2, types[i].getPk_parent());
			}
			if (types[i].getLctypecode() == null) {
				stmt.setNull(3, Types.CHAR);
			}
			else {
				stmt.setString(3, types[i].getLctypecode());
			}
			if (types[i].getLctypename() == null) {
				stmt.setNull(4, Types.CHAR);
			}
			else {
				stmt.setString(4, types[i].getLctypename());
			}
			if (types[i].getDef1() == null) {
				stmt.setNull(5, Types.CHAR);
			}
			else {
				stmt.setString(5, types[i].getDef1());
			}
			if (types[i].getDef2() == null) {
				stmt.setNull(6, Types.CHAR);
			}
			else {
				stmt.setString(6, types[i].getDef2());
			}
			if (types[i].getDef3() == null) {
				stmt.setNull(7, Types.CHAR);
			}
			else {
				stmt.setString(7, types[i].getDef3());
			}
			if (types[i].getDef4() == null) {
				stmt.setNull(8, Types.CHAR);
			}
			else {
				stmt.setString(8, types[i].getDef4());
			}
			if (types[i].getDef5() == null) {
				stmt.setNull(9, Types.CHAR);
			}
			else {
				stmt.setString(9, types[i].getDef5());
			}
			//
			stmt.executeUpdate();
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
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "insertArray", new Object[]{types});
	/*************************************************************/

	return keys;
}
/**
 * 根据主键在数据库中删除一个VO对象。
 *
 * 创建日期：(2005-9-16)
 * @param key nc.vo.pub.oid.OID
 * @exception java.sql.SQLException 异常说明。
 */
public void delete(TypeVO vo) throws java.sql.SQLException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "delete", new Object[]{vo});
	/*************************************************************/

	String sql = "delete from lc_type where pk_lctype = ?";

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
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "delete", new Object[]{vo});
	/*************************************************************/
}
/**
 * 用一个VO对象的属性更新数据库中的值。
 *
 * 创建日期：(2005-9-16)
 * @param type nc.vo.lowcost.type.TypeVO
 * @exception java.sql.SQLException 异常说明。
 */
public void update(TypeVO type) throws java.sql.SQLException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "update", new Object[]{type});
	/*************************************************************/

	String sql = "update lc_type set pk_parent = ?, lctypecode = ?, lctypename = ?, def1 = ?, def2 = ?, def3 = ?, def4 = ?, def5 = ? where pk_lctype = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con=getConnection();
		stmt = con.prepareStatement(sql);
		// update non PK fields:
		if (type.getPk_parent() == null) {
			stmt.setNull(1, Types.CHAR);
		}
		else {
			stmt.setString(1, type.getPk_parent());
		}
		if (type.getLctypecode() == null) {
			stmt.setNull(2, Types.CHAR);
		}
		else {
			stmt.setString(2, type.getLctypecode());
		}
		if (type.getLctypename() == null) {
			stmt.setNull(3, Types.CHAR);
		}
		else {
			stmt.setString(3, type.getLctypename());
		}
		if (type.getDef1() == null) {
			stmt.setNull(4, Types.CHAR);
		}
		else {
			stmt.setString(4, type.getDef1());
		}
		if (type.getDef2() == null) {
			stmt.setNull(5, Types.CHAR);
		}
		else {
			stmt.setString(5, type.getDef2());
		}
		if (type.getDef3() == null) {
			stmt.setNull(6, Types.CHAR);
		}
		else {
			stmt.setString(6, type.getDef3());
		}
		if (type.getDef4() == null) {
			stmt.setNull(7, Types.CHAR);
		}
		else {
			stmt.setString(7, type.getDef4());
		}
		if (type.getDef5() == null) {
			stmt.setNull(8, Types.CHAR);
		}
		else {
			stmt.setString(8, type.getDef5());
		}
		// find record by PK fields:
		stmt.setString(9, type.getPrimaryKey());
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
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "update", new Object[]{type});
	/*************************************************************/
}
/**
 * 通过单位编码返回指定公司所有记录VO数组。如果单位编码为空返回所有记录。
 *
 * 已知问题：请注意生成的sql语句：where子句中假设公司编码字段为pk_corp。
 *			如果你要针对公司进行查询，那么应采用你的实际字段名来手工修改
 *			sql语句。
 * 创建日期：(2005-9-16)
 * @return nc.vo.lowcost.type.TypeVO[]
 * @param unitCode int
 * @exception java.sql.SQLException 异常说明。
 */
public TypeVO[] queryAll(String pk_corp) throws SQLException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "queryAll", new Object[]{pk_corp});
	/*************************************************************/

	String sql = "";
	if (pk_corp != null) {
		sql = "select pk_lctype, pk_parent, lctypecode, lctypename, def1, def2, def3, def4, def5 from lc_type where pk_corp = ? order by lctypecode";
	}
	else {
		sql ="select pk_lctype, pk_parent, lctypecode, lctypename, def1, def2, def3, def4, def5 from lc_type order by lctypecode";
	}

	TypeVO types[] = null;
	Vector v = new Vector();
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		if (pk_corp != null) {
			stmt.setString(1, pk_corp);
		}
		ResultSet rs = stmt.executeQuery();
		//
		while (rs.next()) {
			TypeVO type = new TypeVO();
			// pk_lctype :
			String pk_lctype = rs.getString(1);
			type.setPk_lctype(pk_lctype == null ? null : pk_lctype.trim());
			// pk_parent :
			String pk_parent = rs.getString(2);
			type.setPk_parent(pk_parent == null ? null : pk_parent.trim());
			// lctypecode :
			String lctypecode = rs.getString(3);
			type.setLctypecode(lctypecode == null ? null : lctypecode.trim());
			// lctypename :
			String lctypename = rs.getString(4);
			type.setLctypename(lctypename == null ? null : lctypename.trim());
			// def1 :
			String def1 = rs.getString(5);
			type.setDef1(def1 == null ? null : def1.trim());
			// def2 :
			String def2 = rs.getString(6);
			type.setDef2(def2 == null ? null : def2.trim());
			// def3 :
			String def3 = rs.getString(7);
			type.setDef3(def3 == null ? null : def3.trim());
			// def4 :
			String def4 = rs.getString(8);
			type.setDef4(def4 == null ? null : def4.trim());
			// def5 :
			String def5 = rs.getString(9);
			type.setDef5(def5 == null ? null : def5.trim());

			v.addElement(type);
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
	types = new TypeVO[v.size()];
	if (v.size() > 0) {
		v.copyInto(types);
	}

	/*************************************************************/
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "queryAll", new Object[]{pk_corp});
	/*************************************************************/

	return types;
}
/**
 * 根据VO中所设定的条件返回所有符合条件的VO数组
 *
 * 创建日期：(2005-9-16)
 * @return nc.vo.lowcost.type.TypeVO[]
 * @param typeVO nc.vo.lowcost.type.TypeVO
 * @param isAnd boolean 以与条件查询还是以或条件查询
 * @exception java.sql.SQLException 异常说明。
 */
public TypeVO[] queryByVO(TypeVO condTypeVO, Boolean isAnd) throws SQLException {

	/*************************************************************/
	// 保留的系统管理接口：
	beforeCallMethod("nc.bs.lowcost.type.TypeDMO", "queryByVO", new Object[]{condTypeVO, isAnd});
	/*************************************************************/

	String strSql = "select pk_lctype, pk_parent, lctypecode, lctypename, def1, def2, def3, def4, def5 from lc_type";
	String strConditionNames = "";
	String strAndOr = "and ";
	if (!isAnd.booleanValue()) {
		strAndOr = "or  ";
	}
	if (condTypeVO.getPk_parent() != null) {
		strConditionNames += strAndOr + "pk_parent=? ";
	}
	if (condTypeVO.getLctypecode() != null) {
		strConditionNames += strAndOr + "lctypecode=? ";
	}
	if (condTypeVO.getLctypename() != null) {
		strConditionNames += strAndOr + "lctypename=? ";
	}
	if (condTypeVO.getDef1() != null) {
		strConditionNames += strAndOr + "def1=? ";
	}
	if (condTypeVO.getDef2() != null) {
		strConditionNames += strAndOr + "def2=? ";
	}
	if (condTypeVO.getDef3() != null) {
		strConditionNames += strAndOr + "def3=? ";
	}
	if (condTypeVO.getDef4() != null) {
		strConditionNames += strAndOr + "def4=? ";
	}
	if (condTypeVO.getDef5() != null) {
		strConditionNames += strAndOr + "def5=? ";
	}
	if (strConditionNames.length() > 0) {
		strConditionNames = strConditionNames.substring(3, strConditionNames.length() - 1);
	}
	else {
		return queryAll(null);
	}
	//拼接后的SQL语句
	strSql = strSql + " where " + strConditionNames + " order by lctypecode";
	//
	int index = 0;
	TypeVO types[] = null;
	Vector v = new Vector();
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = getConnection();
		stmt = con.prepareStatement(strSql);
		// set query condition fields:
		// set non PK fields:
		if (condTypeVO.getPk_parent() != null) {
			stmt.setString(++index, condTypeVO.getPk_parent());
		}
		if (condTypeVO.getLctypecode() != null) {
			stmt.setString(++index, condTypeVO.getLctypecode());
		}
		if (condTypeVO.getLctypename() != null) {
			stmt.setString(++index, condTypeVO.getLctypename());
		}
		if (condTypeVO.getDef1() != null) {
			stmt.setString(++index, condTypeVO.getDef1());
		}
		if (condTypeVO.getDef2() != null) {
			stmt.setString(++index, condTypeVO.getDef2());
		}
		if (condTypeVO.getDef3() != null) {
			stmt.setString(++index, condTypeVO.getDef3());
		}
		if (condTypeVO.getDef4() != null) {
			stmt.setString(++index, condTypeVO.getDef4());
		}
		if (condTypeVO.getDef5() != null) {
			stmt.setString(++index, condTypeVO.getDef5());
		}

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			TypeVO type = new TypeVO();
			//
			String pk_lctype = rs.getString(1);
			type.setPk_lctype(pk_lctype == null ? null : pk_lctype.trim());
			//
			String pk_parent = rs.getString(2);
			type.setPk_parent(pk_parent == null ? null : pk_parent.trim());
			//
			String lctypecode = rs.getString(3);
			type.setLctypecode(lctypecode == null ? null : lctypecode.trim());
			//
			String lctypename = rs.getString(4);
			type.setLctypename(lctypename == null ? null : lctypename.trim());
			//
			String def1 = rs.getString(5);
			type.setDef1(def1 == null ? null : def1.trim());
			//
			String def2 = rs.getString(6);
			type.setDef2(def2 == null ? null : def2.trim());
			//
			String def3 = rs.getString(7);
			type.setDef3(def3 == null ? null : def3.trim());
			//
			String def4 = rs.getString(8);
			type.setDef4(def4 == null ? null : def4.trim());
			//
			String def5 = rs.getString(9);
			type.setDef5(def5 == null ? null : def5.trim());

			v.addElement(type);
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
	types = new TypeVO[v.size()];
	if (v.size() > 0) {
		v.copyInto(types);
	}

	/*************************************************************/
	// 保留的系统管理接口：
	afterCallMethod("nc.bs.lowcost.type.TypeDMO", "queryByVO", new Object[]{condTypeVO, isAnd});
	/*************************************************************/

	return types;
}

public String queryMaxCode(TypeVO parentVO) throws SQLException {
	String maxCode = null;
	
    Connection con = null;
	PreparedStatement stmt = null;
	String sql = null;
	if(parentVO==null){
	    sql = "select max(lctypecode) from lc_type where pk_parent is null";
	} else {
	    sql = "select max(lctypecode) from lc_type where pk_parent = ?";
	}
	
	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		if(parentVO!=null){
		    stmt.setString(1,parentVO.getPk_lctype());
		}
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
		    maxCode = rs.getString(1);
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
    return maxCode;
}
public int querySonCount(TypeVO parentVO) throws SQLException {
	int nSonCount = 0;
    Connection con = null;
	PreparedStatement stmt = null;
	String sql = "select count(*) from lc_type where pk_parent = ?";

	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		if(parentVO==null){
		    throw new SQLException ("父VO不能为空！");
		}
		stmt.setString(1,parentVO.getPk_lctype());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
		    nSonCount = rs.getInt(1);
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
	return nSonCount;
}

public boolean isReffed(String pk_lctype) throws SQLException {
    boolean result = false;
	Connection con = null;
	PreparedStatement stmt = null;
	String sql = "select 1 from lc_card where pk_lctype = ?";

	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1,pk_lctype);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
		    result = true;
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
    
    return result;
}
public boolean isLeafNode(String pk_lctype) throws SQLException {
    boolean result = true;
	Connection con = null;
	PreparedStatement stmt = null;
	String sql = "select 1 from lc_type where pk_parent = ?";

	try {
		con = getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1,pk_lctype);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
		    result = false;
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
    
    return result;    
}
}