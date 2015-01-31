package edu.ycp.coady.translator.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TranslatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cType = req.getContentType();
		int length = req.getContentLength();
		System.out.println(cType);
		System.out.println(length);
		System.out.println("hi, how's it going?");
	}
	
}
