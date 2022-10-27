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

	/**
	 * 获取企业微信的userid，无需可信域名验证
	 * <a href="https://developer.work.weixin.qq.com/document/path/91023">参考文档</a>
	 * 
	 * @param code
	 */
	@Override
	public String getUserId(String code) {
		Assert.notNull(code, "The code cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
		params.add("code", code);
		params.add("access_token", getAccessToken());
		return getRestOperations().postForObject(UrlConstants.WECOM_USERINFO_API_URL, params, WecomUser.class)
				.getUserid();
	}

	/**
	 * 自定义返回对象获取企业微信的用户详情，需要可信域名验证
	 * <a href="https://developer.work.weixin.qq.com/document/path/90332">参考文档</a>
	 * 
	 * @param code
	 * @param responseType 自定义返回对象
	 */
	@Override
	public <T> T getUserProfile(String code, Class<T> responseType) {
		Assert.notNull(code, "The code cannot be null");
		Assert.notNull(responseType, "The responseType cannot be null");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
		params.add("access_token", getAccessToken());
		params.add("userid", getUserId(code));
		return getRestOperations().postForObject(UrlConstants.WECOM_USER_API_URL, params, responseType);
	}

	/**
	 * 获取企业微信的部分用户信息，需要可信域名验证
	 * <a href="https://developer.work.weixin.qq.com/document/path/90332">参考文档</a>
	 * 
	 * @param code
	 */
	@Override
	public WecomUser getUserProfile(String code) {
		return getUserProfile(code, WecomUser.class);
	}

}
