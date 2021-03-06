/**
 * 
 */
package edu.ycp.coady.translator;

import edu.ycp.coady.translator.models.Database;
import edu.ycp.coady.translator.models.DictionaryDB;
import edu.ycp.coady.translator.servlet.TranslatorServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.Scanner;

/**
 * @author jcoady9
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception{
		Server server = new Server(8081);
		
		WebAppContext webContext = new WebAppContext();
		webContext.setContextPath("/");
		webContext.setWar("./war");
		webContext.setResourceBase("./war/page/");
		webContext.setWelcomeFiles(new String[]{"translatorPage.html"});
        webContext.addServlet(TranslatorServlet.class, "/translate");
		server.setHandler(webContext);

		Database dictionaryServer = new DictionaryDB();
        if(!dictionaryServer.isActive()){
            throw new Exception("JDict dictionary server is not active, please run JDict before running main server.");
        }

        server.start();

        System.out.println("Server starting up, enter 'quit' to shutdown.");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            str = str.trim().toLowerCase();
            if(str.equals("quit") || str.equals("exit")){
                break;
            }
        }

        System.out.println("shutting down!");
        server.stop();
        server.join();
        System.out.println("Server is shutdown, goodbye!");

        return;
	}
}
