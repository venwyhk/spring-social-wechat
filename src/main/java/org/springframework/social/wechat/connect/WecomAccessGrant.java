package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AccessGrant;

import lombok.Getter;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Getter
public class WecomAccessGrant extends AccessGrant {

	private static final long serialVersionUID = 1L;

	private String code;

	public WecomAccessGrant(String accessToken, String code) {
		super(accessToken);
		this.code = code;
	}

}