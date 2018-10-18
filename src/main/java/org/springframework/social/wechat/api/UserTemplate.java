package org.springframework.social.wechat.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import org.springframework.social.wechat.WechatConstant;
import org.springframework.social.wechat.WechatLangEnum;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 18.6.27
 */
public class UserInfoTemplate implements UserInfoOperations {

	private RestOperations restOperations;

	private String accessToken;

	public UserInfoTemplate(RestOperations restOperations, String accessToken) {
		this.restOperations = restOperations;
		this.accessToken = accessToken;
	}

	@Override
	public UserInfoRes getUserInfo(String openId) {
		return getUserInfo(openId, WechatLangEnum.EN);
	}

	@Override
	public UserInfoRes getUserInfo(String openId, WechatLangEnum lang) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("openid", openId);
		params.add("lang", lang.value());
		params.add("access_token", accessToken);
		return restOperations.postForObject(WechatConstant.USERINFO_API_URL, params, UserInfoRes.class);
	}

}
