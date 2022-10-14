package org.springframework.social.wechat.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public interface Wecom extends ApiBinding {

	WecomUserOperations userOperations();

	RestOperations restOperations();

}
