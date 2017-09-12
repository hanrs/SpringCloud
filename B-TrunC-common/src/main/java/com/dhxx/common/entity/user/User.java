package com.dhxx.common.entity.user;

import java.io.Serializable;
import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author hanrs
 * Date: 2017年07月20日
 * @version 1.01
 * 用户表 (tb_user)
 */
public class User implements Serializable {

	/** 属性说明 */
	private static final long serialVersionUID = 1L;

	private Long id;// 主键
	private String userAccount;// 用户账号
	private String userName;// 用户名
	private String userPassword;// 密码
	private String salt;// 密码干扰
	private String phone;// 手机号
	private String role;// 角色 [sys_admin, sys_user, ]
	private String idCard;// 身份证号
	private int status;// 状态 0: 启用 1:禁用
	private Date registerDate;// 注册时间
	
	private String newPassword;// 新密码：只做修改密码的时候使用

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
