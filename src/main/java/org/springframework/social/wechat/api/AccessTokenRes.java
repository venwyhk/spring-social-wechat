package org.springframework.social.wechat.api;

import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 18.6.27
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
