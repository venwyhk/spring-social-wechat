package org.springframework.social.wechat.connect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.social.wechat.ErrorHandler;
import org.springframework.social.wechat.ProviderID;
import org.springframework.social.wechat.WechatMappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomOAuth2Template extends OAuth2Template {

	private String agentId;

	public WecomOAuth2Template(String appId, String agentId, String appSecret, String authorizeUrl,
			String accessTokenUrl) {
		super(appId, appSecret, authorizeUrl, accessTokenUrl);
		Assert.notNull(agentId, "The agentId property cannot be null");
		this.agentId = agentId;
	}

	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		StringBuilder url = new StringBuilder();
		url.append(accessTokenUrl);
		url.append("?corpid=");
		url.append(parameters.getFirst("client_id"));
		url.append("&corpsecret=");
		url.append(parameters.getFirst("client_secret"));
		return new WecomAccessGrant(
				(String) super.getRestTemplate().getForObject(url.toString(), Map.class).get("access_token"),
				parameters.getFirst("code"));
	}

	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = super.createRestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(3);
		converters.add(new FormHttpMessageConverter());
		converters.add(new FormMapHttpMessageConverter());
		converters.add(new WechatMappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(converters);
		restTemplate.setErrorHandler(new ErrorHandler(ProviderID.WECHAT_WORK));
		return restTemplate;
	}

	@Override
	public String buildAuthorizeUrl(OAuth2Parameters parameters) {
		return replaceParamKey(super.buildAuthorizeUrl(adjustmentParameters(parameters)));
	}

	@Override
	public String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters) {
		return replaceParamKey(super.buildAuthorizeUrl(grantType, adjustmentParameters(parameters)));
	}

	private OAuth2Parameters adjustmentParameters(OAuth2Parameters parameters) {
		parameters.add("agentid", agentId);
		return parameters;
	}

	private String replaceParamKey(String url) {
		return url.replace("client_id", "corpid").replace("client_secret", "corpsecret");
	}

}
