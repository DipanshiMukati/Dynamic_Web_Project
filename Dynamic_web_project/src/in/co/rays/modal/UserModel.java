package in.co.rays.modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {
	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		int pk = nextPk();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, pk);
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		int i = ps.executeUpdate();
		System.out.println("data insedrted=" + i);
	}

	public void update(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update user set firstname = ?, lastname = ?, loginid = ?, password = ?, dob = ?, address = ? where id = ?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());
		int i = ps.executeUpdate();

		System.out.println("data updated=" + i);

	}

	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			UserBean bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
	}

	public UserBean authenticate(String loginid, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user where LoginId =? and password =?");
		ps.setString(1, loginid);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

		}
		
		return bean;

	}

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id =?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();

		System.out.println("data delete=" + i);

	}

	public Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from User");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);
		}

		return pk + 1;
	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {

		int pk = nextPk();
	//System.out.println("model dob"+bean.getDob());

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql= new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and Id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and FirstName like '" + bean.getFirstName() + "%'");
			}
	
		if (bean.getDob() != null && bean.getDob().getTime() > 0) {
	         sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
		}
	}
		

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql => " + sql);

		PreparedStatement st = conn.prepareStatement(sql.toString());

		ResultSet rs = st.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		conn.close();
		return list;
	}
	
	
	
	public UserBean findByPk(int id) throws Exception {

	

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}
		return bean;
	}

}
