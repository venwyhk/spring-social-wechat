package org.springframework.social.wechat.api;

import org.springframework.social.wechat.WechatLangEnum;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 18.6.27
 */
public interface UserInfoOperations {

	UserInfoRes getUserInfo(String openId);

	UserInfoRes getUserInfo(String openId, WechatLangEnum lang);

}
