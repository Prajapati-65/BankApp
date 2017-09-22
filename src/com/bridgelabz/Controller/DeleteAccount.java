package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;

//@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println("Inside delete acconut");
		String deleteid = req.getParameter("id");
		int id =Integer.parseInt(deleteid);
		BankDAO.deleteAccount(id);
		System.out.println("Account deleted");
	}
}




