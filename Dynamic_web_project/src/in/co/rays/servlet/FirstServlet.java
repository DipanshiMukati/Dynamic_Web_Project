package in.co.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("my first doGet method ");
		resp.setContentType("text/html"); // method of forwad to jsp veiw page
		PrintWriter out = resp.getWriter();
		out.println("Run my first servlet");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("my first doPost method");

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		
		resp.setContentType("text/html"); // method of forwad to jsp veiw page
		PrintWriter out = resp.getWriter();
		out.println(fname);
		out.println(lname);
		out.println(login);
		out.println(pass);
		out.println(dob);
		out.println(address);
		out.close();
	}
}
