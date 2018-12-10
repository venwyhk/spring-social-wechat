package org.springframework.social.wechat.api;

import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Data
public class AccessTokenRes {

	private String accessToken;

	private String expiresIn;

	private String refreshToken;

	private String openid;

	private String scope;

	private String unionid;

}
