package com.org.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDAO;
import com.org.model.User;

@WebServlet("login")
public class PetPeersLoginAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getParameter("login").equals("Sign In")) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			HttpSession session = req.getSession(true);
			String loginName = req.getParameter("username");
			String loginPwd = req.getParameter("password");
			UserDAO udao = new UserDAO();
			List flag = udao.validateLogin(loginName, loginPwd);
			if (flag.get(0).equals("true")) {
				session.setAttribute("userID", flag.get(2));
				session.setAttribute("userName", flag.get(1));
				RequestDispatcher rd = req
						.getRequestDispatcher("./pet_welcome.jsp");
				rd.include(req, resp);
			} else {
				out.println("<center><h3 style='color: red;'>"
						+ "OOPS...Invalied User Name or Password..."
						+ "</h3></center>");
				RequestDispatcher rd = req
						.getRequestDispatcher("./pet_login.jsp");
				rd.include(req, resp);
			}

		} else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			User u = new User();
			UserDAO udao = new UserDAO();
			Calendar c = Calendar.getInstance();
			u.setUserId(c.getTimeInMillis() % 100000);
			u.setLoginName(req.getParameter("username"));
			u.setLoginpwd(req.getParameter("password"));
			u.setUserName(req.getParameter("name"));
			boolean checkUser = udao.checkUser(u);
			if (checkUser) {
				udao.saveUser(u);
				out.println("<center><h3 style='color: green;'>"
						+ "Registration Successfull" + "</h3></center>");
				RequestDispatcher rd = req
						.getRequestDispatcher("./pet_login.jsp");
				rd.include(req, resp);
			} else {
				out.println("<center><h3 style='color: red;'>"
						+ "User name Already Exists" + "</h3></center>");
				RequestDispatcher rd = req
						.getRequestDispatcher("./pet_login.jsp");
				rd.include(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// out.println("<center><h3 style='color: red;'>"
		// + "you are logged of Successfully." + "</h3></center>");
		RequestDispatcher rd = req.getRequestDispatcher("/pet_login.jsp");
		rd.include(req, resp);

	}

}
