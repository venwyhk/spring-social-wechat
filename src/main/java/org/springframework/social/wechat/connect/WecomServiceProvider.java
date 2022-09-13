package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.api.impl.WechatImpl;
import org.springframework.util.Assert;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomServiceProvider<T extends Wechat> extends AbstractOAuth2ServiceProvider<T> {

	public WecomServiceProvider(String appId, String agentId, String appSecret) {
		this(getOAuth2Template(appId, appSecret, UrlConstants.WECOM_QRCONNECT_API_URL));
	}

	public WecomServiceProvider(OAuth2Template template) {
		super(template);
	}

	private static OAuth2Template getOAuth2Template(String appId, String appSecret, String authorizeUrl) {
		OAuth2Template oauth2Template = new WechatOAuth2Template(appId, appSecret, authorizeUrl,
				UrlConstants.WECOM_ACCESS_TOKEN_API_URL);
		oauth2Template.setUseParametersForClientAuthentication(true);
		return oauth2Template;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getApi(String accessToken) {
		Assert.notNull(accessToken, "The accessToken cannot be null");
		return (T) new WechatImpl(accessToken);
	}

}