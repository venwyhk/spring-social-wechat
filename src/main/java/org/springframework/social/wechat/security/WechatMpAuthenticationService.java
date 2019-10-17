package org.springframework.social.wechat.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.wechat.api.WechatMp;
import org.springframework.social.wechat.connect.WechatMpConnectionFactory;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WechatMpAuthenticationService extends OAuth2AuthenticationService<WechatMp> {

	public WechatMpAuthenticationService(final String apiKey, final String appSecret) {
		super(new WechatMpConnectionFactory(apiKey, appSecret));
	}

}
