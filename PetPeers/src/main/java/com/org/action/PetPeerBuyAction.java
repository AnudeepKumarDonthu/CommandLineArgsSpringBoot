package com.org.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PetTransactionDAO;

public class PetPeerBuyAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Date d = new Date();
		PetTransactionDAO ptdao = new PetTransactionDAO();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String sDate = dateFormat.format(d);
		Calendar c = Calendar.getInstance();
		Map<String, Object> buypojo = new HashMap<String, Object>();
		buypojo.put("tid", c.getTimeInMillis() % 100000);
		buypojo.put("ptype", req.getParameter("pettype"));
		buypojo.put("cid", Long.parseLong(req.getParameter("cid")));
		buypojo.put("pqty", Integer.parseInt(req.getParameter("qty")));
		buypojo.put("pdate", new Date());
		boolean flag = ptdao.saveOrder(buypojo,
				Long.parseLong(req.getParameter("pid")));
		if (flag) {
			out.println("<center><h3 style='color: green;'>"
					+ "Order Placed Successfully with Order Id: "
					+ buypojo.get("tid") + "</h3></center>");
			RequestDispatcher rp = req
					.getRequestDispatcher("./pet_welcome.jsp");
			rp.include(req, resp);
		} else {
			out.println("<center><h3 style='color: red;'>"
					+ "OOPS...Out of stock..." + "</h3></center>");
			RequestDispatcher rp = req
					.getRequestDispatcher("./pet_welcome.jsp");
			rp.include(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(true);
		session.setAttribute("userID", 1111);
		session.setAttribute("userName", "Guest");
		RequestDispatcher rd = req.getRequestDispatcher("./pet_welcome.jsp");
		rd.include(req, resp);

	}

}
