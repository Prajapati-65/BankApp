package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.AccountDetails;

//@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String userId = req.getParameter("id");
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		int id = BankDAO.id(email);
		JSONObject obj=BankDAO.updateAccount(Integer.parseInt(userId));
		out.print(obj.toJSONString());
		
		
		/*
		if (userId.equals("0"))
		{
			HttpSession session = req.getSession();
			String email = (String) session.getAttribute("email");
			int id = BankDAO.id(email);
			JSONObject obj=BankDAO.updateAccount(id);
			out.print(obj.toJSONString());
			
			BankDAO bank = new BankDAO();
			int pId=Integer.parseInt(userId);
			
			bank.editRow(pId, name, email,city ,accountnumber);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
			dispatcher.forward(req, resp);
			
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(req, resp);*/
	}
}
