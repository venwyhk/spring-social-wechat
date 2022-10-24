package org.springframework.social.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.wechat.ProviderID;
import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.api.WechatMp;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WechatMpConnectionFactory extends OAuth2ConnectionFactory<WechatMp> {
	
	private boolean checkState;

	public WechatMpConnectionFactory(String appId, String appSecret) {
		this(appId, appSecret, null);
	}
	
	public WechatMpConnectionFactory(String appId, String appSecret, boolean checkState) {
		this(appId, appSecret, null);
		this.checkState = checkState;
	}

	public WechatMpConnectionFactory(String appId, String appSecret, ApiAdapter<WechatMp> apiAdapter) {
		super(ProviderID.WECHAT_MINI_PROGRAM,
				new WechatServiceProvider<WechatMp>(appId, appSecret, UrlConstants.AUTHORIZE_API_URL), apiAdapter);
	}

	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		return ((WechatAccessGrant) accessGrant).getOpenid();
	}
	
	@Override
	public boolean supportsStateParameter() {
		return checkState;
	}

}
