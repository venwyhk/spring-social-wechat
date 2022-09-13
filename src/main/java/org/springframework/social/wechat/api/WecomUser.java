package org.springframework.social.wechat.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@ToString
public class WecomUser extends ErrorCodeRes implements User {

	@Getter
	@Setter
	private String userid;

}
