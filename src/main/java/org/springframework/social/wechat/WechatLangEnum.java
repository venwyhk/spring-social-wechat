package org.springframework.social.wechat;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public enum WechatLangEnum {

	ZH_CN("zh-CN"), EN("en");

	private String value;

	private WechatLangEnum(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
