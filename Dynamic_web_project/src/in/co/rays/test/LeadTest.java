package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.LeadBean;
import in.co.rays.modal.LeadModal;

public class LeadTest {
public static void main(String[] args) throws Exception {
	
//	testadd();
	//testupdate();
	//testsearch();
//	testdelete();
//	testsearchsimple();
	testsearch();
}



private static void testsearch() throws Exception {
	 
	LeadBean bean = new LeadBean();
	bean.setId(4);
	//bean.setName("a");
	  
	LeadModal modal = new LeadModal ();
	
	List list = modal.search(bean , 1 , 5);
	
	Iterator it = list.iterator();
	
	while(it.hasNext()) {
		bean = (LeadBean)it.next();
		 System.out.print("\t" + bean.getId());
		 System.out.print("\t" + bean.getName());
		 System.out.println("\t" + bean.getMaths());
	}
	
}

private static void testsearchsimple() throws Exception {
	LeadModal modal = new LeadModal();
	List list = modal.searchsimple();
	Iterator it = list.iterator();
	while (it.hasNext()) {
		LeadBean bean = (LeadBean) it.next();
		System.out.print("\t"+ bean.getId());
		System.out.print("\t"+ bean.getName());
		System.out.println(("\t"+bean.getMaths()));
		
	}
	
}



private static void testdelete() throws Exception {
	LeadModal modal = new LeadModal();
	modal.delete(56);
	
}

//private static void testsearch() throws Exception {
//	 LeadBean bean = new LeadBean();
//	 LeadModal modal = new LeadModal();
//	 List list = modal.search();
//	 Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//		
//		 bean = (LeadBean) it.next();
//		System.out.println(bean.getId());
//		System.out.println(bean.getName());
//		System.out.println(bean.getMaths());
//		
//	}



private static void testupdate() throws Exception {
  LeadBean bean = new  LeadBean();
  bean.setId(4);
  bean.setName("dipanshi");
  bean.setMaths(50);	
  
  LeadModal  modal = new LeadModal();
    modal.update(bean);
}

private static void testadd() throws Exception {
	  LeadBean bean = new LeadBean();
       bean.setId(56);
	   bean.setName("anjali");
	   bean.setMaths(70);			 
      LeadModal modal = new LeadModal();
      modal.add(bean);
   }
 
            	
 }
