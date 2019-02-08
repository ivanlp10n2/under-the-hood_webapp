package com.empanada.restaurant.websockets;

import com.empanada.restaurant.domain.Order;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LiveOrderSessionHandler {

	private List<Session> sessions = new ArrayList<Session>();

	public void addSession (Session sess){
		sessions.add(sess);
	}

	public void removeSession (Session sess){
		sessions.remove(sess);
	}

	public void sendMessage(JsonObject meesage){
		for (Session session : sessions){
			try{
				session.getBasicRemote().sendText(meesage.toString());
			}catch (IOException e){
				removeSession(session);
			}

		}
	}

	public void createOrder(Order order) {

		JsonObject json = new JsonObject();
		json.addProperty("id", order.getId());
		json.addProperty("update", new Date().toString());
		json.addProperty("currentOrder", order.toString());
		json.addProperty("status", order.getStatus());
		json.addProperty("action", "add");

		sendMessage(json);
		System.out.println(json);
	}
}
