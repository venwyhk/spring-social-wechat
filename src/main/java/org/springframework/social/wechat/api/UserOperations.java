package org.springframework.social.wechat.api;

import org.springframework.social.wechat.WechatLangEnum;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public interface UserOperations {

	User getUserProfile(String openId);

	User getUserProfile(String openId, WechatLangEnum lang);

}
