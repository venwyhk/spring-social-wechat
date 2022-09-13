package org.springframework.social.wechat.api;

import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import lombok.AllArgsConstructor;

import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.WechatLangEnum;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@AllArgsConstructor
public class UserTemplate implements UserOperations {

	private RestOperations restOperations;

	private String accessToken;

	@Override
	public User getUserProfile(String openId) {
		return getUserProfile(openId, WechatLangEnum.EN);
	}

	@Override
	public User getUserProfile(String openId, WechatLangEnum lang) {
		Assert.notNull(openId, "The openId cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(3);
		params.add("openid", openId);
		params.add("lang", lang.getValue());
		params.add("access_token", accessToken);
		return restOperations.postForObject(UrlConstants.USERINFO_API_URL, params, User.class);
	}

}
