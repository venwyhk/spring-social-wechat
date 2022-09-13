package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.util.MultiValueMap;

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
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		if ("authorization_code".equals(parameters.getFirst("grant_type"))) {
			parameters.set("corpid", parameters.getFirst("client_id"));
			parameters.remove("client_id");
			parameters.set("corpsecret", parameters.getFirst("client_secret"));
			parameters.remove("client_secret");
		}
		return super.postForAccessGrant(accessTokenUrl, parameters);
	}

	@Override
	protected OAuth2Parameters adjustmentParameters(OAuth2Parameters parameters) {
		parameters.add("agentid", agentId);
		return parameters;
	}

}
