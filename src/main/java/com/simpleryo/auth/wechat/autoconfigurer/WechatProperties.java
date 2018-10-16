package com.simpleryo.auth.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
@ConfigurationProperties(prefix = "spring.social.wechat")
public class WechatProperties extends SocialProperties {
}
