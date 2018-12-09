import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.*;

/**
 * source: https://examples.javacodegeeks.com/enterprise-java/tomcat/apache-tomcat-websocket-tutorial/#toc630
 */
@ServerEndpoint("/adinhubsoc")
public class WsServer {

    @OnOpen
    public void processOpen(Session session) {
	System.out.println("open, session: " + session);
    }

    @OnClose
    public void processClose(Session session) {
	System.out.println("close, session: " + session);
    }

    @OnMessage
    public String processMessage(String message, Session session) {
    	System.out.println("message from client: " + message);
    	String echoMsg = "Echo from the server : " + message; 
    	return echoMsg;                       
    }

    @OnError
    public void processError(Session session, Throwable t) {
	System.out.println("error, session: " + session);
	t.printStackTrace();
    }

}
