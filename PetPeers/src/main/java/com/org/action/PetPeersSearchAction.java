package com.org.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PetSearchDAO;
import com.org.dao.PetTransactionDAO;
import com.org.model.Pet;
import com.org.model.PetSearch;

public class PetPeersSearchAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		PetSearch ps = new PetSearch();
		PetSearchDAO psdao = new PetSearchDAO();
		ps.setPetType(req.getParameter("pettype"));
		ps.setPetSize(req.getParameter("petsize"));
		ps.setName(req.getParameter("name"));
		ps.setAge(Integer.parseInt(req.getParameter("age")));
		ps.setPlace(req.getParameter("place"));
		List<Pet> result = psdao.searchPets(ps);
		req.setAttribute("searchresults", result);
		RequestDispatcher rd = req.getRequestDispatcher("./Search_Results.jsp");
		rd.forward(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PetTransactionDAO dao = new PetTransactionDAO();
		List<Pet> pets = dao.buyPet(Long.parseLong(req.getParameter("id").trim()));
		req.setAttribute("petList", pets.get(0));
		RequestDispatcher rd = req.getRequestDispatcher("./Pet_Buy.jsp");
		rd.forward(req, resp);

	}
}
