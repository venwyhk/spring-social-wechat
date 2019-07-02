package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.api.impl.WechatImpl;
import org.springframework.social.wechat.connect.WechatOAuth2Template;
import org.springframework.util.Assert;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WechatServiceProvider<T extends Wechat> extends AbstractOAuth2ServiceProvider<T> {

	public WechatServiceProvider(String appId, String appSecret) {
		this(appId, appSecret, UrlConstants.QRCONNECT_API_URL);
	}

	public WechatServiceProvider(String appId, String appSecret, String authorizeUrl) {
		super(getOAuth2Template(appId, appSecret, authorizeUrl));
	}

	private static OAuth2Template getOAuth2Template(String appId, String appSecret, String authorizeUrl) {
		OAuth2Template oauth2Template = new WechatOAuth2Template(appId, appSecret, authorizeUrl,
				UrlConstants.ACCESS_TOKEN_API_URL);
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