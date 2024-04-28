package com.testeyoux.testepratico.util;

import com.testeyoux.testepratico.enums.StatusResponse;

public class Response {
	
	private StatusResponse status;
	
	private Iterable<?> list;
	
	private Object item;
	
	private String message;

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}

	public Iterable<?> getList() {
		return list;
	}

	public void setList(Iterable<?> list) {
		this.list = list;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
