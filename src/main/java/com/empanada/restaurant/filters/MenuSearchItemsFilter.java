package com.empanada.restaurant.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/searchItem.html")
public class MenuSearchItemsFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//		String searchItem = servletRequest.getParameter("searchTerm");
//
//		if (searchItem.toLowerCase().equals("chook")){
//
//			MenuSearchItemsRequestWrapper menuSearchItemsRequestWrapper = new MenuSearchItemsRequestWrapper((HttpServletRequest) servletRequest);
//			menuSearchItemsRequestWrapper.setNewSearchTerm("chicken");
//
//			filterChain.doFilter(menuSearchItemsRequestWrapper,servletResponse);
//		}

		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {

	}
}
