package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.BookBean;
import com.javatpoint.beans.IssueBookBean;
import com.javatpoint.dao.BookDao;

@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
		out.println("<link rel='stylesheet' href='../../../../../css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);

		out.println("<div class='container'>");

		List<IssueBookBean> list = BookDao.viewIssuedBooks();

		out.println(
				"<table class='table' border='1px solid beige' width='100%' style='background-color: #283350; border-collapse: collapse;'>");
		out.println(
				"<tr><th style='color: Beige'>Callno</th><th style='color: Beige'>Student Id</th><th style='color: Beige'>Student Name</th><th style='color: Beige'>Student Mobile</th><th style='color: Beige'>Issued Date</th><th style='color: Beige'>Return Status</th></tr>");
		for (IssueBookBean bean : list) {
			out.println("<tr style='text-align: center'><td style='color: #ff7129'>" + bean.getCallno()
					+ "</td><td style='color: #ff7129'>" + bean.getStudentid() + "</td><td style='color: #ff7129'>"
					+ bean.getStudentname() + "</td><td style='color: #ff7129'>" + bean.getStudentmobile()
					+ "</td><td style='color: #ff7129'>" + bean.getIssueddate() + "</td><td style='color: #ff7129'>"
					+ bean.getReturnstatus() + "</td></tr>");
		}
		out.println("</table>");

		out.println("</div>");

		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
