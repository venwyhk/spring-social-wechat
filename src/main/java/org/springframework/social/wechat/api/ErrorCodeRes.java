package org.springframework.social.wechat.api;

import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Data
public class ErrorCodeRes {

	private Integer errcode;

	private String errmsg;

}
