package org.springframework.social.wechat.api;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public interface WecomUserOperations {

	String getUserId(String code);
	
	<T> T getUserProfile(String code, Class<T> responseType);

	WecomUser getUserProfile(String code);

}
