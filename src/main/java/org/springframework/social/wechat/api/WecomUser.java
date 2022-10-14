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
public class WecomUser extends ErrorCodeRes implements User {

	private String userid;
	
	private String name;
	
	private Integer[] department;
	
	private Integer[] order;
	
	private String position;
	
	private String mobile;
	
	private String gender;
	
	private String email;
	
	private String bizMail;
	
	private Integer[] isLeaderInDept;
	
	private String[] directLeader;
	
	private String avatar;
	
	private String thumbAvatar;
	
	private String telephone;
	
	private String alias;
	
	private String address;
	
	private String openUserid;
	
	private Integer mainDepartment;
	
	private Integer status;
	
	private Integer qrCode;
	
	private Integer externalPosition;

}
