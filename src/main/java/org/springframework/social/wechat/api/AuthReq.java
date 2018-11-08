package org.springframework.social.wechat.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 18.6.27
 */
@AllArgsConstructor
@Data
public class AuthReq {

	private String accessToken;

	private String openid;

}
