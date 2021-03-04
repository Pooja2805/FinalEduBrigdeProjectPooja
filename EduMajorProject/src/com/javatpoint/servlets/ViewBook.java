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
import com.javatpoint.beans.LibrarianBean;
import com.javatpoint.dao.BookDao;
import com.javatpoint.dao.LibrarianDao;

@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='../../../../../css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);

		out.println("<div class='container'>");

		List<BookBean> list = BookDao.view();

		out.println(
				"<table class='table' border='1px solid beige' width='100%' style='background-color: #283350; border-collapse: collapse;'>");
		out.println(
				"<tr><th style='color: Beige'>Callno</th><th style='color: Beige'>Name</th><th style='color: Beige'>Author</th><th style='color: Beige'>Publisher</th><th style='color: Beige'>Quantity</th><th style='color: Beige'>Issued</th><th style='color: Beige'>Delete</th></tr>");
		for (BookBean bean : list) {
			out.println("<tr style='text-align: center'><td style='color: #ff7129'>" + bean.getCallno()
					+ "</td><td style='color: #ff7129'>" + bean.getName() + "</td><td style='color: #ff7129'>"
					+ bean.getAuthor() + "</td><td style='color: #ff7129'>" + bean.getPublisher()
					+ "</td><td style='color: #ff7129'>" + bean.getQuantity() + "</td><td style='color: #ff7129'>"
					+ bean.getIssued()
					+ "</td><td style='color: #ff7129'><a style='color: #ff7129' href='DeleteBook?callno="
					+ bean.getCallno() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");

		out.println("</div>");

		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}