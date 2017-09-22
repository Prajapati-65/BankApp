package com.bridgelabz.Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.AccountDetails;

//@WebServlet("/AddAccountDetails")
public class AddAccountDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String emailid=(String) session.getAttribute("email");
		int id = BankDAO.id(emailid);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>" + "Your account is successful" + "</br>");
		out.println(title);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String number = req.getParameter("accountnumber");
		int accountNumber = Integer.parseInt(number);
		AccountDetails account = new AccountDetails();
		account.setName(name);
		account.setEmail(email);
		account.setCity(city);
		account.setAccountnumber(accountNumber);
		account.setUserId(id);
		if (BankDAO.saveAccountData(account) > 0) {
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("city", city);
			session.setAttribute("accountnumber", number);
			RequestDispatcher dispatcher = req.getRequestDispatcher("homePage.jsp");
			dispatcher.forward(req, resp);
		} else {
			out.println("Sorry unable to save record");
		}
	}
}
