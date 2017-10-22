package javarestapi.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
public class ServerMain {
    public ServerMain() {
        super();
    }
    
    public static void main(String ... args) throws Exception{
        String webappDirLocation = "src/webapp/";
        String webPort = System.getenv("PORT");
                if (webPort == null || webPort.isEmpty()) {
                    webPort = "80";
        }
       Server server = new Server(Integer.valueOf(webPort)); 
       WebAppContext root = new WebAppContext();
       root.setContextPath("/");
               root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
       root.setResourceBase(webappDirLocation);
       root.setParentLoaderPriority(true);

               server.setHandler(root);

               server.start();
       server.join();
    }
}
