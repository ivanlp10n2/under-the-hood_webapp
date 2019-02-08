package com.empanada.restaurant.websockets;

import com.google.gson.Gson;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LiveOrderSessionHandler {

	private List<Session> sessions = new ArrayList<Session>();

	public void addSession (Session sess){
		sessions.add(sess);
	}

	public void removeSession (Session sess){
		sessions.remove(sess);
	}

	public void sendMessage(Gson meesage) throws IOException {
		for (Session session : sessions){
			try{
				session.getBasicRemote().sendText(meesage.toString());
			}catch (IOException e){
				removeSession(session);
			}

		}
	}
}
