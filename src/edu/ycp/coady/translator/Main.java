/**
 * 
 */
package edu.ycp.coady.translator;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author jcoady9
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception{
		Server server = new Server(8082);
		
		WebAppContext webContext = new WebAppContext();
		webContext.setContextPath("/");
		webContext.setWar("./war");
		webContext.setResourceBase("./war/page/");
		webContext.setWelcomeFiles(new String[] {"translatorPage.html"});
		
		server.setHandler(webContext);
		
		server.start();
		server.join();
	}
}
