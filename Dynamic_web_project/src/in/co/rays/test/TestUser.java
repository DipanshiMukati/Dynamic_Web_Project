package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.modal.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {

	testAdd();
//		testSearch();
//		testAuth();
//		 testNextPk();
//        testdelete();
//		 testupdate();
		// testFindByPk();
	}
	
	private static void testFindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(2);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());

	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();
		
	

	 bean.setFirstName("s");
		
		
		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}

	}

	private static void testNextPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		int pk = model.nextPk();

		System.out.println("pk=" + pk);

	}

	private static void testAuth() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.authenticate("sonali@gmail.com", "1234");
		if (bean != null) {
			System.out.println();
			 System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		} else {
			System.out.println("loginid & password is invalid...!!");
		}
	}	
	private static void testdelete() throws Exception {
		
		UserModel modal = new UserModel();
		 modal.delete(15);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		UserBean bean = new UserBean();

		bean.setId(8);
		bean.setFirstName("sonu");
		bean.setLastName("patel");
		bean.setLoginId("sonu@gmail.com");
		bean.setPassword("34434");
		bean.setDob(new Date());
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}

	private static void testupdate() throws Exception {
		
		UserBean bean = new UserBean();
		bean.setId(13);
		bean.setFirstName("Aditi");
		bean.setLastName("rawat");
		bean.setLoginId("aditi@123");
		bean.setPassword("4444");
//		bean.setDob(sdf.parse("2020-03-12"));
		bean.setDob(new Date());
		bean.setAddress("indore");
		 UserModel modal = new UserModel();
		 modal.update(bean);
	}			

//	private static void testsearch() throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//		UserBean bean = new UserBean();
//		bean.setDob(sdf.parse("2023-11-30"));
//		List list = new ArrayList();
//
//		UserModel model = new UserModel();
//
//		list = model.search();
//
//		Iterator it = list.iterator();
//
//		while (it.hasNext()) {
//
//			bean = (UserBean) it.next();
//
//			System.out.print(bean.getId());
//			System.out.print("\t" + bean.getFirstName());
//			System.out.print("\t" + bean.getLastName());
//			System.out.print("\t" + bean.getLoginId());
//			System.out.print("\t" + bean.getPassword());
//			System.out.print("\t" + bean.getDob());
//			System.out.println("\t" + bean.getAddress());
//
//		}
//	}

}
