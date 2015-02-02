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

        //send a bad request response if the text or language codes are not sent in the request
        if(text.equals("") || source_lang.equals("") || target_lang.equals("")){
            resp.setContentType("text/html");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Please check that you have entered text and selected the source and target languages.");
        }else if(target_lang.equals(source_lang)){
            resp.setContentType("text/html");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Please check that the source and target languages are not the same.");
        }else{
            Translator translator = new Translator(source_lang, target_lang);
            resp.setContentType("text/html");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(translator.translate(text));
        }
	}
	
}
