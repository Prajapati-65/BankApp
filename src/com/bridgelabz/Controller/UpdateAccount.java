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
        String accountnu = req.getParameter("accountnumber");
        int accountNo = Integer.parseInt(accountnu);
        int id=Integer.parseInt(req.getParameter("id"));
        AccountDetails account = new AccountDetails();
        account.setName(name);
        account.setEmail(email);
        account.setCity(city);
        account.setAccountnumber(accountNo);
        account.setId(id);
     
        int status = BankDAO.updateAccount(id);
        
		if(status > 0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("homePage.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			out.println("sorry unable to update");
		}
	}

}
