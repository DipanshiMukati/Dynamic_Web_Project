
package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet1")
public class FirstServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("my first doGetServlet");
//		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
//		rd.forward(req, resp);
       resp.sendRedirect("SecondServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("my SecondServlet");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		System.out.println(firstName);
		System.out.println(lastName);

		req.setAttribute("fn", firstName);
		req.setAttribute("ln", lastName);
//		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
//		rd.forward(req, resp);
		 resp.sendRedirect("SecondServlet");
	}

}