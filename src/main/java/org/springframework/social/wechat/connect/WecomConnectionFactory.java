package org.springframework.social.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.wechat.api.Wecom;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomConnectionFactory extends OAuth2ConnectionFactory<Wecom> {

	public WecomConnectionFactory(String appId, String agentId, String appSecret) {
		this(appId, agentId, appSecret, null);
	}

	public WecomConnectionFactory(String appId, String agentId, String appSecret, ApiAdapter<Wecom> apiAdapter) {
		super("wecom", new WecomServiceProvider<Wecom>(appId, agentId, appSecret), apiAdapter);
	}

	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		return ((WecomAccessGrant) accessGrant).getCode();
	}

}
