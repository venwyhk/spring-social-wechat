package org.springframework.social.wechat.api;

import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.WechatLangEnum;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

public class WecomUserTemplate extends WechatUserTemplate {

	public WecomUserTemplate(RestOperations restOperations, String accessToken) {
		super(restOperations, accessToken);
	}
	
	@Override
	public User getUserProfile(String code, WechatLangEnum lang) {
		Assert.notNull(code, "The code cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
		params.add("code", code);
		params.add("access_token", getAccessToken());
		return getRestOperations().postForObject(UrlConstants.WECOM_USERINFO_API_URL, params, WecomUser.class);
	}

}
