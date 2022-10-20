package org.springframework.social.wechat.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.social.wechat.ErrorHandler;
import org.springframework.social.wechat.ProviderID;
import org.springframework.social.wechat.WechatMappingJackson2HttpMessageConverter;
import org.springframework.social.wechat.api.WechatUserOperations;
import org.springframework.social.wechat.api.WechatUserTemplate;
import org.springframework.social.wechat.api.Wechat;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WechatImpl extends AbstractOAuth2ApiBinding implements Wechat {

	private WechatUserOperations userOperations;

	public WechatImpl(String accessToken) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.userOperations = new WechatUserTemplate(restOperations(), accessToken);
	}

	public WechatImpl(String accessToken, WechatUserOperations userOperations) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.userOperations = userOperations;
	}

	@Override
	public WechatUserOperations userOperations() {
		return userOperations;
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
		restTemplate.setErrorHandler(new ErrorHandler(ProviderID.WECHAT));
		super.configureRestTemplate(restTemplate);
	}

	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(3);
		converters.add(new FormHttpMessageConverter());
		converters.add(new FormMapHttpMessageConverter());
		converters.add(new WechatMappingJackson2HttpMessageConverter());
		return converters;
	}

}
