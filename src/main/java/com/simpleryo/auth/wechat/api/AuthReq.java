package com.simpleryo.auth.wechat.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
@Data
@AllArgsConstructor
public class AuthReq {

	public String accessToken;

	public String openid;

}
