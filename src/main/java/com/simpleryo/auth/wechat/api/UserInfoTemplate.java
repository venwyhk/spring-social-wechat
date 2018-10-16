package com.simpleryo.auth.wechat.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.simpleryo.auth.wechat.WechatConstant;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
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
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("openid", openId);
		params.add("lang", WechatConstant.LANG);
		params.add("access_token", accessToken);
		return restOperations.postForObject(WechatConstant.USERINFO_API_URL, params, UserInfoRes.class);
	}

}
