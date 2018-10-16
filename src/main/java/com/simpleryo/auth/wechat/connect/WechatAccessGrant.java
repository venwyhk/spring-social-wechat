package com.simpleryo.auth.wechat.connect;

import org.springframework.social.oauth2.AccessGrant;

import lombok.Getter;

/**
 * spring-social-wechat
 * 
 * @author <a href="mailto:lei.su@simpleryo.co.nz">sulei</a>
 * @version 18.6.27
 */
@Getter
public class WechatAccessGrant extends AccessGrant {

	private static final long serialVersionUID = 1L;

	private String openid;

	private String unionid;

	public WechatAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, String openId,
			String unionId) {
		super(accessToken, scope, refreshToken, expiresIn);
		this.openid = openId;
		this.unionid = unionId;
	}

}
