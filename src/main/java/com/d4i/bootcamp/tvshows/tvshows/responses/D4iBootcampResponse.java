package com.d4i.bootcamp.tvshows.tvshows.responses;

import java.io.Serializable;

public class D4iBootcampResponse<T> implements Serializable {

	private String status;
	private String code;
	private String message;
	private T data;

	private static final long serialVersionUID = 7302319210373510173L;

	public D4iBootcampResponse() {
		super();
	}

	public D4iBootcampResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public D4iBootcampResponse(String status, String code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
