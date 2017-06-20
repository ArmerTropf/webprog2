package aufgabe11;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;

@ServerEndpoint("/chat/{nick-name}")
public class Aufgabe11 {

	public static List<Session> lsession = new ArrayList<Session>();
	String name;

	@OnOpen
	public void onOpen(Session session, EndpointConfig config, @PathParam("nick-name") String name) {
		System.out.println(name + " angemeldet");
		this.name = name;
		lsession.add(session);
	}

	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("JAVA error:  " + t.getMessage());
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println(this.name + " Disconnected... Reason: " + reason);
	}

	@OnMessage
	public void text(Session session, String msg) {
		System.out.println("bekommen von: " + this.name + " nachricht: " + msg);
		for (Session session2 : lsession) {
			if (session2.isOpen()) {
				System.out.println("schreibe an " + this.name);
				JSONObject obj = new JSONObject();

				obj.put("name", this.name);
				obj.put("message", msg);

				System.out.print(obj);
				session2.getAsyncRemote().sendText(this.name + ": " + obj);
			}
		}

	}

}
