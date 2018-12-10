package org.springframework.social.wechat.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@AllArgsConstructor
@Data
public class AuthReq {

	public String accessToken;

	public String openid;

}
