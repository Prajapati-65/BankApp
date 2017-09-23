package com.bridgelabz.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.AccountDetails;

//@WebServlet("/AccountView")
public class AccountView extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String city = req.getParameter("city");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<h1>Account List</h1>");
		List<AccountDetails> list = BankDAO.getAllAccount(city);
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("citydetails.jsp");
		dispatcher.forward(req, resp);
	}
}
