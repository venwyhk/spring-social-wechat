package com.simpleryo.auth.wechat.connect;

import java.util.Map;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.simpleryo.auth.wechat.WechatMappingJackson2HttpMessageConverter;
import com.simpleryo.auth.wechat.utils.TemplateUtil;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
public class WechatOAuth2Template extends OAuth2Template {

	public WechatOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
	}

	public WechatOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String authenticateUrl,
			String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, authenticateUrl, accessTokenUrl);
	}

	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		if ("authorization_code".equals(parameters.getFirst("grant_type"))) {
			parameters.set("appid", parameters.getFirst("client_id"));
			parameters.set("secret", parameters.getFirst("client_secret"));
			parameters.remove("client_id");
			parameters.remove("client_secret");
		}
		return super.postForAccessGrant(accessTokenUrl, parameters);
	}

	@Override
	protected WechatAccessGrant createAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn,
			Map<String, Object> response) {
		return new WechatAccessGrant(accessToken, scope, refreshToken, expiresIn, (String) response.get("openid"),
				(String) response.get("unionid"));
	}

	@Override
	protected RestTemplate createRestTemplate() {
		return TemplateUtil.addHttpMessageConverter(super.createRestTemplate(),
				new WechatMappingJackson2HttpMessageConverter());
	}
	
	@Override
	public String buildAuthorizeUrl(OAuth2Parameters parameters) {
		return replaceParamKey(super.buildAuthorizeUrl(parameters));
	}

	@Override
	public String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters) {
		return replaceParamKey(super.buildAuthorizeUrl(grantType, parameters));
	}
	
	private String replaceParamKey(String url) {
		return url.replace("client_id", "appid").replace("client_secret", "secret");
	}

}