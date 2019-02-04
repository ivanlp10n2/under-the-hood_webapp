package com.empanada.restaurant.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * The idea of this wrapper is to extend HttpServlet Request in order to be able to set new parameters before getParameter works*/

public class MenuSearchItemsRequestWrapper extends HttpServletRequestWrapper {

	private String newSearchTerm;

	public MenuSearchItemsRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	//Doesnt' have get method bc we never use it (and we shouldn't)
	public void setNewSearchTerm(String newSearchTerm) {
		this.newSearchTerm = newSearchTerm;
	}

	@Override
	public String getParameter(String name) {
		if (name.equals("searchTerm")){
			return newSearchTerm;
		}
		else
		return super.getParameter(name);
	}
}
