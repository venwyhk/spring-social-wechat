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
	public String getUserId(String code) {
		Assert.notNull(code, "The code cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
		params.add("code", code);
		params.add("access_token", getAccessToken());
		return getRestOperations().postForObject(UrlConstants.WECOM_USERINFO_API_URL, params, WecomUser.class)
				.getUserid();
	}

	@Override
	public <T> T getUserProfile(String code, Class<T> responseType) {
		Assert.notNull(code, "The code cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
		params.add("access_token", getAccessToken());
		params.add("userid", getUserId(code));
		return getRestOperations().postForObject(UrlConstants.WECOM_USER_API_URL, params, responseType);
	}

	@Override
	public WecomUser getUserProfile(String code) {
		return getUserProfile(code, WecomUser.class);
	}

}
