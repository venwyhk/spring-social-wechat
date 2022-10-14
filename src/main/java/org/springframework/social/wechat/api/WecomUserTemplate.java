package org.springframework.social.wechat.api;

import org.springframework.social.wechat.UrlConstants;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@AllArgsConstructor
public class WecomUserTemplate implements WecomUserOperations {

	@Getter
	private RestOperations restOperations;

	@Getter
	private String accessToken;

	@Override
	public WecomUser getUserProfile(String code) {
		Assert.notNull(code, "The code cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
		params.add("code", code);
		params.add("access_token", getAccessToken());
		WecomUser wecomUser = getRestOperations().postForObject(UrlConstants.WECOM_USERINFO_API_URL, params,
				WecomUser.class);
		params.add("userid", wecomUser.getUserid());
		return getRestOperations().postForObject(UrlConstants.WECOM_USER_API_URL, params, WecomUser.class);
	}

}
