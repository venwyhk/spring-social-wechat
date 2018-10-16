package com.simpleryo.auth.wechat.api;

import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
@Data
public class ErrorCodeRes {

	public Integer errcode;

	public String errmsg;

}
