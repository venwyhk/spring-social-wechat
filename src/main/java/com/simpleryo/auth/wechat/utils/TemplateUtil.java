package com.simpleryo.auth.wechat.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.simpleryo.auth.wechat.WechatMappingJackson2HttpMessageConverter;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.7.5
 */
public class TemplateUtil {

	public static RestTemplate addHttpMessageConverter(RestTemplate restTemplate,
			HttpMessageConverter<?> httpMessageConverter) {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(2);
		converters.add(new FormHttpMessageConverter());
		converters.add(new FormMapHttpMessageConverter());
		converters.add(new WechatMappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}

}
