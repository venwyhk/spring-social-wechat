package org.springframework.social.wechat.api;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Data
@NoArgsConstructor
@ToString
public class WechatUser implements User {

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
