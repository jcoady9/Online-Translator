/**
 * 
 */
package edu.ycp.coady.translator;

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
		webContext.setWelcomeFiles(new String[] {"translatorPage.html"});
		
		server.setHandler(webContext);
		
		server.start();

        System.out.println("Server starting up, enter 'quit' to shutdown.");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            if(str.trim().toLowerCase().equals("quit")){
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
