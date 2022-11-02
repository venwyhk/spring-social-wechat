package org.springframework.social.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.wechat.ProviderID;
import org.springframework.social.wechat.api.Wecom;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomConnectionFactory extends OAuth2ConnectionFactory<Wecom> {

	private boolean checkState;

	public WecomConnectionFactory(String appId, String agentId, String appSecret) {
		this(appId, agentId, appSecret, null);
	}

	public WecomConnectionFactory(String cropId, String agentId, String secret, boolean checkState) {
		this(cropId, agentId, secret, null);
		this.checkState = checkState;
	}

	public WecomConnectionFactory(String cropId, String agentId, String secret, ApiAdapter<Wecom> apiAdapter) {
		super(ProviderID.WECHAT_WORK, new WecomServiceProvider<Wecom>(cropId, agentId, secret), apiAdapter);
	}

	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		return ((WecomAccessGrant) accessGrant).getCode();
	}

	@Override
	public boolean supportsStateParameter() {
		return checkState;
	}

}
