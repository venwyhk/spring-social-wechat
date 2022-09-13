package org.springframework.social.wechat.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.connect.WechatConnectionFactory;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomAuthenticationService extends OAuth2AuthenticationService<Wechat> {

	public WecomAuthenticationService(final String apiKey, final String appSecret) {
		super(new WechatConnectionFactory(apiKey, appSecret));
	}

}
