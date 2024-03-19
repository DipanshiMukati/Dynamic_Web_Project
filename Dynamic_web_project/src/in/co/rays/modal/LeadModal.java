package in.co.rays.modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.LeadBean;

public class LeadModal {
    
	public void add(LeadBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
        PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?)");
//        int pk = nextpk();
//       ps.setInt(1,pk);
       ps.setInt(1,bean.getId());
       ps.setString(2, bean.getName());
       ps.setInt(3, bean.getId());
       int i = ps.executeUpdate();
        System.out.println("inserted data="+i);
	}
	
	public void update(LeadBean bean ) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
		PreparedStatement ps = conn.prepareStatement("update prachi set name =?,maths=?, where id = ?");
		
		ps.setInt(3, bean.getId());
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("inserted data ="+i);
				

	}
//	
//	public  List search() throws Exception {
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
//	PreparedStatement ps = conn.prepareStatement("select * from prachi");
//	ResultSet rs = ps.executeQuery();
//    List list = new ArrayList();
//    
//    while(rs.next()) {
//    LeadBean  bean = new LeadBean();
//    bean.setId(rs.getInt(1));
//    bean.setName(rs.getString(2));
//    bean.setMaths(rs.getInt(3));
//     list .add(bean);
//	}
//	return list;
//}
	
//	public Integer nextpk() throws Exception {
//		int pk = 0;
//
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
//		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//			pk = rs.getInt(1);
//
//		}
//
//		return pk + 1;
//	}
	
	public void  delete (int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		ps.setInt(1, id );
		int i= ps.executeUpdate();
		System.out.println("data deleted ="+i);
		
	}
	
	public List searchsimple() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
         List list =  new ArrayList();
         while(rs.next()) {
	     LeadBean bean = new LeadBean();
	     bean.setId(rs.getInt(1));
	     bean.setName(rs.getString(2));
	     bean.setMaths(rs.getInt(3));
	     list.add(bean);
	     
         }
         
		return list;
		
	}
	 public List search(LeadBean bean , int pageNo, int pagesize) throws Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
			StringBuffer sql = new StringBuffer("select * from marksheet where 1 = 1 " );
		if(bean != null) {
			if (bean.getId()>0) {
				sql.append(" and id = " + bean.getId());
				
			}
			if(bean.getName()!=null && bean.getName().length()>0) {
				sql.append("and name like '" + bean.getName() + " % '");
			}
		}
		if(pagesize>0) {
			pageNo = (pageNo-1)*pagesize;
			sql.append(" limit "+  pageNo + "," +  pagesize);
			
		}
		System.out.println("sql=>" + sql);

			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			List list = new ArrayList();
		  while(rs.next()) {
			  bean = new LeadBean();
			  bean.setId(rs.getInt(1));
			  bean.setName(rs.getString(2));
			  bean.setMaths(rs.getInt(3));
			  list.add(bean);
		  }
		
		 return list;
	}
}

