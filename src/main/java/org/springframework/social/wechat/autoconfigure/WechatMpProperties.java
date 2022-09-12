package org.springframework.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@ConfigurationProperties(prefix = "spring.social.wechatmp")
public class WechatMpProperties extends SocialProperties {

	@Getter
	@Setter
	private String scope = "snsapi_userinfo"; // or snsapi_base

}
