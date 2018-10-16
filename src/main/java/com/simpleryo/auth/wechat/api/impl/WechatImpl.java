package com.simpleryo.auth.wechat.api.impl;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.simpleryo.auth.wechat.api.UserInfoOperations;
import com.simpleryo.auth.wechat.api.UserInfoTemplate;
import com.simpleryo.auth.wechat.api.Wechat;
import com.simpleryo.auth.wechat.utils.TemplateUtil;
import com.simpleryo.auth.wechat.WechatMappingJackson2HttpMessageConverter;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
public class WechatImpl extends AbstractOAuth2ApiBinding implements Wechat {

	private UserInfoOperations userInfoOperations;

	public WechatImpl(String accessToken) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		userInfoOperations = new UserInfoTemplate(TemplateUtil.addHttpMessageConverter(getRestTemplate(),
				new WechatMappingJackson2HttpMessageConverter()), accessToken);
	}

	@Override
	public UserInfoOperations userInfoOperations() {
		return userInfoOperations;
	}

	@Override
	public RestOperations restOperations() {
		return getRestTemplate();
	}

	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER_DRAFT_2;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		super.configureRestTemplate(restTemplate);
		restTemplate.setErrorHandler(new WechatErrorHandler());
	}
}
