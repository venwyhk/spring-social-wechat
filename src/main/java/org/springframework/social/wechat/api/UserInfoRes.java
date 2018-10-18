package org.springframework.social.wechat.api;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 18.6.27
 */
@Data
@NoArgsConstructor
@ToString
public class UserInfoRes {

	private String openid;

	private String nickname;

	private Integer sex;

	private String language;

	private String province;

	private String city;

	private String country;

	private String headimgurl;

	private List<String> privilege;

	private String unionid;

}
