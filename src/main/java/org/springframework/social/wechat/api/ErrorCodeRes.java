package org.springframework.social.wechat.api;

import lombok.Data;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 18.6.27
 */
@Data
public class ErrorCodeRes {

	public Integer errcode;

	public String errmsg;

}
