package com.simpleryo.auth.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;

import com.simpleryo.auth.wechat.WechatConstant;
import com.simpleryo.auth.wechat.api.Wechat;
import com.simpleryo.auth.wechat.connect.WechatMpConnectionFactory.WechatMp;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.7.31
 */
public class WechatMpConnectionFactory extends OAuth2ConnectionFactory<WechatMp> {

	public WechatMpConnectionFactory(String appId, String appSecret) {
		this(appId, appSecret, new WechatAdapter<WechatMp>());
	}

	public WechatMpConnectionFactory(String appId, String appSecret, ApiAdapter<WechatMp> apiAdapter) {
		super("wechat-mp", new WechatServiceProvider<WechatMp>(appId, appSecret, WechatConstant.AUTHORIZE_API_URL),
				apiAdapter);
	}

	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		return ((WechatAccessGrant) accessGrant).getOpenid();
	}

	public interface WechatMp extends Wechat {
	}

}
