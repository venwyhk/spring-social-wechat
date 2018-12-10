package org.springframework.social.wechat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@AllArgsConstructor
public enum WechatLangEnum {

	ZH_CN("zh-CN"), EN("en");

	@Getter
	private String value;

}
