package org.springframework.social.wechat.api;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public interface WecomUserOperations {
	
	String getUserId(String code);

	WecomUser getUserProfile(String code);


}
