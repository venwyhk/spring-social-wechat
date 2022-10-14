package org.springframework.social.wechat.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.wechat.api.Wecom;
import org.springframework.social.wechat.api.WecomUserOperations;
import org.springframework.social.wechat.api.WecomUserTemplate;
import org.springframework.web.client.RestOperations;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WecomImpl extends AbstractOAuth2ApiBinding implements Wecom {
	
	private WecomUserOperations userOperations;

	public WecomImpl(String accessToken) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.userOperations = new WecomUserTemplate(restOperations(), accessToken);
	}

	public WecomImpl(String accessToken, WecomUserOperations userOperations) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.userOperations = userOperations;
	}

	@Override
	public WecomUserOperations userOperations() {
		return userOperations;
	}

	@Override
	public RestOperations restOperations() {
		return getRestTemplate();
	}

}
