package com.abbott.longhomeindex.utils;

public abstract class ACallBack {
	/**外部数据传递*/
	private Object data;
	/**内部数据传递*/
	private Object nativeData;
	/**内部回调传递*/
	private ACallBack nativeCallBack;

	
	/** 内部数据错误码,由于大部分消息都用了  nativeData，nativeData被占用。*/
	private Object errorData;
	
	
	public Object getErrorData() {
		return errorData;
	}

	public void setErrorData(Object errorData) {
		this.errorData = errorData;
	}

	/**获取内部回调*/
	public ACallBack getNativeCallBack() {
		return nativeCallBack;
	}

	/**设置内部回调*/
	public void setNativeCallBack(ACallBack nativeCallBack) {
		this.nativeCallBack = nativeCallBack;
	}

	/**获取内部数据data*/
	public Object getNativeData() {
		return nativeData;
	}

	/**设置内部数据data*/
	public void setNativeData(Object nativeData) {
		this.nativeData = nativeData;
	}

	/**当成功时的回调方法*/
	public abstract void onSuccess();

	/**设置外部数据data*/
	public void setData(Object data) {
		this.data = data;
	}

	/**获取外部数据data*/
	public Object getData() {
		return this.data;
	}

	/**
	 * 当发生错误时的回调方法
	 * @param paramString 错误日志
	 */
	public abstract void onError(String paramString);

	/**进度回调，不要求强制实现*/
	public void onProgress(int paramInt, String parmString) {}
}
