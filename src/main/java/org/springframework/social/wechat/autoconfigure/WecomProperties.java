package org.springframework.social.wechat.autoconfigure;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@ConfigurationProperties(prefix = "spring.social.wecom")
public class WecomProperties extends SocialProperties {

	@Getter
	@Setter
	private String agentId;

}
