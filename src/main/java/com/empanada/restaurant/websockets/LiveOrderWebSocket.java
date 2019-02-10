package com.empanada.restaurant.websockets;

import com.empanada.restaurant.domain.Order;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;

@ServerEndpoint("/ws-live-order")
public class LiveOrderWebSocket {

	//Session handler is to keep track of different users
	@OnOpen
	public void onOpen(Session sess){
		LiveOrderSessionHandler sessionHandler = LiveOrderSessionHandlerSingleton.getHandler();
		sessionHandler.addSession(sess);
		System.out.println("New client has opened a connection...");
		System.out.println("Retrieving all the orders...");
		sessionHandler.getAllOrders(sess);
	}

	@OnClose
	public void onClose(Session sess){
		LiveOrderSessionHandler sessionHandler = LiveOrderSessionHandlerSingleton.getHandler();
		sessionHandler.removeSession(sess);
		System.out.println("connection Closed for session " + sess.getId());
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
