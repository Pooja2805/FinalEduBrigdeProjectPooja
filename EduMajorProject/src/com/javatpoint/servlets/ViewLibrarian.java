package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.LibrarianBean;
import com.javatpoint.dao.LibrarianDao;

@WebServlet("/ViewLibrarian")
public class ViewLibrarian extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Librarian</title>");
		out.println("<link rel='stylesheet' href='../../../../../css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");

		List<LibrarianBean> list = LibrarianDao.view();

		out.println(
				"<table class='table' border='1px solid beige' width='100%' style='background-color: #283350; border-collapse: collapse;'>");
		out.println(
				"<tr><th style='color: Beige'>Id</th><th style='color: Beige'>Name</th><th style='color: Beige'>Email</th><th style='color: Beige'>Password</th><th style='color: Beige'>Mobile</th><th style='color: Beige'>Edit</th><th style='color: Beige'>Delete</th></tr>");
		for (LibrarianBean bean : list) {
			out.println("<tr style='text-align: center'><td style='color: #ff7129'>" + bean.getId()
					+ "</td><td style='color: #ff7129'>" + bean.getName() + "</td><td style='color: #ff7129'>"
					+ bean.getEmail() + "</td><td style='color: #ff7129'>" + bean.getPassword()
					+ "</td><td style='color: #ff7129'>" + bean.getMobile()
					+ "</td><td style='color: #ff7129'><a style='color: #ff7129' href='EditLibrarianForm?id="
					+ bean.getId()
					+ "'>Edit</a></td><td style='color: #ff7129'><a style='color: #ff7129' href='DeleteLibrarian?id="
					+ bean.getId() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");

		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}
}