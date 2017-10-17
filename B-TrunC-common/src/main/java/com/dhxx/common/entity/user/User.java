package com.dhxx.common.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author hanrs
 * Date: 2017年07月20日
 * @version 1.01
 * 用户表 (TB_USER)
 */
public class User implements Serializable {

	/** 属性说明 */
	private static final long serialVersionUID = 1L;

	private Long id;// 主键
	private String account;// 用户账号
	private String password;// 密码
	private String salt;// 密码干扰
	private String userName;// 用户名
	private String udn; //用户号码
	private String role;// 角色 [sys_admin, sys_user, ]
	private int status;// 状态 0: 正常 1:注销
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date registerDate;// 注册时间

	private String area; //TZ地区
	private String city; //TZ城市
	private String server; //NTP服务器
	private String remark; //备注

	private String newPassword;// 新密码：只做修改密码的时候使用

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getAccount() { return account; }

	public void setAccount(String account) { this.account = account; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getSalt() { return salt; }

	public void setSalt(String salt) { this.salt = salt; }

	public String getUserName() { return userName; }

	public void setUserName(String userName) { this.userName = userName; }

	public String getUdn() { return udn; }

	public void setUdn(String udn) { this.udn = udn; }

	public String getRole() { return role; }

	public void setRole(String role) { this.role = role; }

	public int getStatus() { return status; }

	public void setStatus(int status) { this.status = status; }

	public Date getRegisterDate() { return registerDate; }

	public void setRegisterDate(Date registerDate) { this.registerDate = registerDate; }

	public String getArea() { return area; }

	public void setArea(String area) { this.area = area; }

	public String getCity() { return city; }

	public void setCity(String city) { this.city = city; }

	public String getServer() { return server; }

	public void setServer(String server) { this.server = server; }

	public String getRemark() { return remark; }

	public void setRemark(String remark) { this.remark = remark; }

	public String getNewPassword() { return newPassword; }

	public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}
