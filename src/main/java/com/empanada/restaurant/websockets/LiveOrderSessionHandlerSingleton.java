package com.empanada.restaurant.websockets;

public class LiveOrderSessionHandlerSingleton {

	private static LiveOrderSessionHandler liveOrderSessionHandler;

	public static LiveOrderSessionHandler getHandler() {
		if (liveOrderSessionHandler == null) liveOrderSessionHandler = new LiveOrderSessionHandler();
		return liveOrderSessionHandler;
	}


}
