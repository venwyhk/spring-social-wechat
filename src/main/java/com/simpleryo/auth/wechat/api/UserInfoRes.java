package com.simpleryo.auth.wechat.api;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
@Data
@NoArgsConstructor
@ToString
public class UserInfoRes {

	public String openid;

	public String nickname;

	public Integer sex;

	public String language;

	public String province;

	public String city;

	public String country;

	public String headimgurl;

	public List<String> privilege;

	public String unionid;

}
