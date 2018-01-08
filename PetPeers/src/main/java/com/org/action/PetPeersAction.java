package com.org.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PetDAO;
import com.org.model.Pet;

public class PetPeersAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		PetDAO pdao = new PetDAO();
		List<Pet> result = pdao.fetchAll();
		if (result.isEmpty()) {
			out.println("<center>"
					+ "<h4 style='color:red;'>"
					+ "OPPS...No Records of Pets in DataBase...Please Add Pet Details..."
					+ "</h4>" + "</center>");
			RequestDispatcher rd = req.getRequestDispatcher("./pet_home.jsp");
			rd.include(req, resp);
		} else {
			req.setAttribute("petResult", result);
			RequestDispatcher rd = req.getRequestDispatcher("./pet_home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		PetDAO pdao = new PetDAO();
		// Calendar c=new GregorianCalendar();
		Calendar c = Calendar.getInstance();
		Pet p = new Pet();
		p.setId(c.getTimeInMillis() % 10000);
		p.setName(req.getParameter("name"));
		p.setAge(Integer.parseInt(req.getParameter("age")));
		p.setPlace(req.getParameter("place"));
		p.setPetType(req.getParameter("pettype"));
		p.setAvlQty(Integer.parseInt(req.getParameter("avlqty")));
		p.setPetSex(req.getParameter("petsex"));
		p.setPetSize(req.getParameter("petsize"));
		pdao.savePet(p);
		resp.sendRedirect("./pets");
	}
}
