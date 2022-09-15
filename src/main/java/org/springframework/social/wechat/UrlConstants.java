package org.springframework.social.wechat;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class UrlConstants {

	public static final String AUTH_API_URL = "https://api.weixin.qq.com/sns/auth";

	public static final String ACCESS_TOKEN_API_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

	public static final String REFRESH_TOKEN_API_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

	public static final String USERINFO_API_URL = "https://api.weixin.qq.com/sns/userinfo";

	public static final String AUTHORIZE_API_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

	public static final String QRCONNECT_API_URL = "https://open.weixin.qq.com/connect/qrconnect";
	
	public static final String WECOM_QRCONNECT_API_URL = "https://open.work.weixin.qq.com/wwopen/sso/qrConnect";
	
	public static final String WECOM_ACCESS_TOKEN_API_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
	
	public static final String WECOM_USERINFO_API_URL = "https://qyapi.weixin.qq.com/cgi-bin/auth/getuserinfo";
	
	public static final String WECOM_USER_API_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get";

}
