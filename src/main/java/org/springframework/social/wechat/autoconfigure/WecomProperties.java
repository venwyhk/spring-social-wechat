package org.springframework.social.wechat.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@ConfigurationProperties(prefix = "spring.social.wecom")
@Data
public class WecomProperties {

	private String cropId;

	private String agentId;

	private String secret;

	private String checkState = "true";

}
