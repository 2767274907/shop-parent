package com.t248.cure.base;

import lombok.Data;

/**
 * 接口统一返回码
 * @param <T>
 */
@Data
public class BaseResponse<T> {

	/**
	 * 返回码
	 */
	private Integer code;
	/**
	 * 返回消息
	 */
	private String msg;
	/**
	 * 返回的数据
	 */
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

}
