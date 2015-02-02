package edu.ycp.coady.translator.servlet;

import edu.ycp.coady.translator.models.Translator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TranslatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = (String)req.getParameter("text");
        String source_lang = (String)req.getParameter("source_lang");
        String target_lang = (String)req.getParameter("target_lang");
        Translator translator = new Translator(source_lang, target_lang);
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(translator.translate(text + " : " + translator.getSourceLanguage() + " : " + translator.getTargetLanguage()));
	}
	
}
