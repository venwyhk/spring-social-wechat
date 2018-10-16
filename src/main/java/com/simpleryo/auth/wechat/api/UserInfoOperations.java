package com.simpleryo.auth.wechat.api;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
public interface UserInfoOperations {
	
	UserInfoRes getUserInfo(String openId);

}
