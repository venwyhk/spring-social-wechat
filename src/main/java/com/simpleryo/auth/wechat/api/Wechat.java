package com.simpleryo.auth.wechat.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
public interface Wechat extends ApiBinding {

	RestOperations restOperations();

	UserInfoOperations userInfoOperations();

}
