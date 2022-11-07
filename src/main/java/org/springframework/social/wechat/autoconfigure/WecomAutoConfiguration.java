package org.springframework.social.wechat.autoconfigure;

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

import org.springframework.social.wechat.api.Wecom;
import org.springframework.social.wechat.connect.WecomConnectionFactory;

import lombok.AllArgsConstructor;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Configuration
@ConditionalOnClass({ SocialConfigurerAdapter.class, WecomConnectionFactory.class })
@ConditionalOnProperty(prefix = "spring.social.wecom", name = "crop-id")
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WecomAutoConfiguration {

	@AllArgsConstructor
	@Configuration
	@EnableSocial
	@EnableConfigurationProperties(WecomProperties.class)
	@ConditionalOnWebApplication
	protected static class WecomConfigurerAdapter extends SocialAutoConfigurerAdapter {

		private final WecomProperties properties;

		@Override
		protected ConnectionFactory<Wecom> createConnectionFactory() {
			return new WecomConnectionFactory(properties.getCropId(), properties.getAgentId(), properties.getSecret(),
					"true".equalsIgnoreCase(properties.getCheckState()));
		}

	}

}
