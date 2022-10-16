package org.springframework.social.wechat.api;

import org.springframework.social.wechat.WechatLangEnum;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public interface WechatUserOperations {

	WechatUser getUserProfile(String openId);

	WechatUser getUserProfile(String openId, WechatLangEnum lang);

}
