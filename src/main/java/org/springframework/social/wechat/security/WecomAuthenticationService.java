package org.springframework.social.wechat.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.wechat.api.Wecom;
import org.springframework.social.wechat.connect.WecomConnectionFactory;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomAuthenticationService extends OAuth2AuthenticationService<Wecom> {

	public WecomAuthenticationService(final String apiKey, final String agentId, final String appSecret) {
		super(new WecomConnectionFactory(apiKey, agentId, appSecret));
	}

}
