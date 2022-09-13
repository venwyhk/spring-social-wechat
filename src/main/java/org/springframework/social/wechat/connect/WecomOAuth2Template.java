package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.OAuth2Parameters;

import lombok.Setter;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomOAuth2Template extends WechatOAuth2Template {

	@Setter
	private String agentId;

	public WecomOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
	}

	@Override
	protected OAuth2Parameters adjustmentParameters(OAuth2Parameters parameters) {
		parameters.add("agentid", agentId);
		return parameters;
	}

}
