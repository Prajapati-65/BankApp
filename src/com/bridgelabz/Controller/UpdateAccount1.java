package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.AccountDetails;

//@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String accountnumber = req.getParameter("accountnumber");
		int id = Integer.parseInt(req.getParameter("id"));
		// System.out.println("test id -->"+id+" name : "+name+" email :
		// "+email+" city : "+city+" accountnumber :"+accountnumber);
		AccountDetails account = new AccountDetails();
		account.setName(name);
		account.setEmail(email);
		account.setCity(city);
		account.setAccountnumber(accountnumber);
		account.setUserId(id);
		System.out.println("test id -->" + id + " name : " + name + " email : " + email + " city : " + city
				+ " accountnumber :" + accountnumber);
		if (BankDAO.saveAccountData(account) > 0) {

			int pid = BankDAO.updateAccount(id);
			BankDAO bank = new BankDAO();
			bank.editAccount(pid, name, email, city, accountnumber);
			RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
			dispatcher.forward(req, resp);

		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(req, resp);
	}

}
