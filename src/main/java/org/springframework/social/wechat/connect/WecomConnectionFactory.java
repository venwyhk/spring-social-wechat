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

	public WecomConnectionFactory(String appId, String appSecret) {
		this(appId, appSecret, null);
	}

	public WecomConnectionFactory(String appId, String appSecret, ApiAdapter<Wecom> apiAdapter) {
		super("wecom", new WechatOAuth2Template<Wecom>(appId, appSecret), apiAdapter);
	}

	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		return ((WechatAccessGrant) accessGrant).getOpenid();
	}

}
