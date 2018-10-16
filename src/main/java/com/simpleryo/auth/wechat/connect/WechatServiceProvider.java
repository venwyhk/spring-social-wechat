package com.simpleryo.auth.wechat.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import com.simpleryo.auth.wechat.WechatConstant;
import com.simpleryo.auth.wechat.api.Wechat;
import com.simpleryo.auth.wechat.api.impl.WechatImpl;
import com.simpleryo.auth.wechat.connect.WechatOAuth2Template;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
public class WechatServiceProvider<T extends Wechat> extends AbstractOAuth2ServiceProvider<T> {

	public WechatServiceProvider(String appId, String appSecret) {
		super(getOAuth2Template(appId, appSecret, WechatConstant.QRCONNECT_API_URL));
	}

	public WechatServiceProvider(String appId, String appSecret, String authorizeUrl) {
		super(getOAuth2Template(appId, appSecret, authorizeUrl));
	}

	private static OAuth2Template getOAuth2Template(String appId, String appSecret, String authorizeUrl) {
		OAuth2Template oauth2Template = new WechatOAuth2Template(appId, appSecret, authorizeUrl,
				WechatConstant.ACCESS_TOKEN_API_URL);
		oauth2Template.setUseParametersForClientAuthentication(true);
		return oauth2Template;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getApi(String accessToken) {
		return (T) new WechatImpl(accessToken);
	}

}