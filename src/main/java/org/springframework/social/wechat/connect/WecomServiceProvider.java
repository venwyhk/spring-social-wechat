package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.api.Wecom;
import org.springframework.social.wechat.api.impl.WecomImpl;
import org.springframework.util.Assert;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomServiceProvider<T extends Wecom> extends AbstractOAuth2ServiceProvider<T> {

	public WecomServiceProvider(String cropId, String agentId, String secret) {
		this(getOAuth2Template(cropId, agentId, secret, UrlConstants.WECOM_QRCONNECT_API_URL));
	}

	public WecomServiceProvider(OAuth2Template template) {
		super(template);
	}

	private static OAuth2Template getOAuth2Template(String cropId, String agentId, String secret, String authorizeUrl) {
		WecomOAuth2Template oauth2Template = new WecomOAuth2Template(cropId, agentId, secret, authorizeUrl,
				UrlConstants.WECOM_ACCESS_TOKEN_API_URL);
		oauth2Template.setUseParametersForClientAuthentication(true);
		return oauth2Template;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getApi(String accessToken) {
		Assert.notNull(accessToken, "The accessToken cannot be null");
		return (T) new WecomImpl(accessToken);
	}

}