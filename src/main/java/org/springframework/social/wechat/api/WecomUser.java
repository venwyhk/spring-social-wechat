package org.springframework.social.wechat.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
@Data
@NoArgsConstructor
@ToString
public class WecomUser {

	private String userid;
	
	private String name;
	
	private Integer[] department;
	
	private Integer[] order;
	
	private String alias;
	
	private String telephone;
	
	private Integer status;

}
