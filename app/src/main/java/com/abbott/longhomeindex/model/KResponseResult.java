package com.abbott.longhomeindex.model;

import java.io.Serializable;

public class KResponseResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回状态 0 成功 2 失败
	 */
	private int Code;

	/***
	 * 当info不为0时，描述具体错诨原因
	 */
	private String Message = "";

    private String ServerTime = "";

	/**
	 * 返回信息
	 */
	private T Data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public String getServerTime() {
        return ServerTime;
    }

    public void setServerTime(String serverTime) {
        ServerTime = serverTime;
    }
}
