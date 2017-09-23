package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		System.out.println();
		if (userId.equals("0")) {
			HttpSession session = req.getSession();
			String userName = (String) session.getAttribute("name");
			int user_id = BankDAO.id(userName);
			JSONObject obj=BankDAO.updateAccount(user_id);
			out.print(obj.toJSONString());
			resp.sendRedirect("homepage");
			}
			else{
				BankDAO object = new BankDAO();
				int pId=Integer.parseInt(userId); 
				object.editRow(pId, name, bankName,accountNumber,city);
			}
		}
}
