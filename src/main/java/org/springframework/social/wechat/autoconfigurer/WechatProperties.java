package org.springframework.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@ConfigurationProperties(prefix = "spring.social.wechat")
public class WechatProperties extends SocialProperties {
}
