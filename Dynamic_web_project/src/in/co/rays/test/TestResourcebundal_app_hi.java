package in.co.rays.test;

import java.util.ResourceBundle;

public class TestResourcebundal_app_hi {

	public static void main(String[] args) {
		
//ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hii");

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new
		// Locale("hi"));

//		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("sp"));

		System.out.println(rb.getString("greeting"));
	}
}
