package org.springframework.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.wechat.api.WechatMp;
import org.springframework.social.wechat.connect.WechatMpConnectionFactory;

import lombok.AllArgsConstructor;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Configuration
@ConditionalOnClass({ SocialConfigurerAdapter.class, WechatMpConnectionFactory.class })
@ConditionalOnProperty(prefix = "spring.social.wechatmp", name = "app-id")
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WechatMpAutoConfiguration {

	@AllArgsConstructor
	@Configuration
	@EnableSocial
	@EnableConfigurationProperties(WechatMpProperties.class)
	@ConditionalOnWebApplication
	protected static class WechatConfigurerAdapter extends SocialAutoConfigurerAdapter {

		private final WechatMpProperties properties;

		@Override
		protected ConnectionFactory<WechatMp> createConnectionFactory() {
			final WechatMpConnectionFactory factory = new WechatMpConnectionFactory(properties.getAppId(),
					properties.getAppSecret());
			factory.setScope(properties.getScope());
			return factory;
		}

	}

}
