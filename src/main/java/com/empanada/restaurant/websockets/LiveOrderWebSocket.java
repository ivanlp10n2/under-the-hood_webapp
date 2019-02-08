package com.empanada.restaurant.websockets;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/live-order")
public class LiveOrderWebSocket {

	@OnOpen
	public void onOpen(Session sess){
		System.out.println("webconnection OPEN");
	}

	@OnClose
	public void onClose(Session sess){
		System.out.println("connection Closed");
	}

	@OnError
	public void onError(Throwable t){
		System.out.println("onError: " + t.getMessage());
	}

	@OnMessage
	public void onMessage(String message, Session sess){
		System.out.println("the message is " + message + " from : " + sess.getId());

		try{
			sess.getBasicRemote().sendText("Hello Client " + sess.getId() + "!");
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}
