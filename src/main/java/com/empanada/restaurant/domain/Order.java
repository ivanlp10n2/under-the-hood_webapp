package com.empanada.restaurant.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {

	private Long id;
	private Map<MenuItem,Integer> currentOrder = new HashMap<MenuItem,Integer>();
	private String status;
	private String customer;

	public void addToOrder(MenuItem menuItem, int quantity) {
		int currentQuantity = 0;
		if (currentOrder.get(menuItem) != null) currentQuantity = currentOrder.get(menuItem);
		currentOrder.put(menuItem, currentQuantity + quantity);
	}

	public Double getOrderTotal() {
		double d = 0d;
		for (MenuItem menuItem : currentOrder.keySet()) {
			d += currentOrder.get(menuItem) * menuItem.getPrice();
		}
		return d;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (MenuItem menuItem : currentOrder.keySet()) {
			sb.append(menuItem.getName() + " : " + currentOrder.get(menuItem) + "<br/>");
		}
		return sb.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomer() {
		return customer;
	}

	public void setContents(Map<MenuItem, Integer> contents) {
		this.currentOrder=contents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}