package com.dhxx.api.exception;

/**
 * @author jhy
 */
public class RestException extends BusinessException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestException(){}
	
	public RestException(String msg) {
		super(-1, msg);
	}
	
	/**
     * 验证码发送失败
     */
    public static final RestException SEND_SMS_ERROR = new RestException("验证码发送失败");
    
    /**
     * 验证码错误
     */
    public static final RestException SMS_CODE_ERROR = new RestException("验证码错误");
    
    /**
     * 验证码超时
     */
    public static final RestException SMS_CODE_TIME_OUT = new RestException("验证码超时");
	
	/**
     * 用户未登录
     */
    public static final RestException USER_AUTHOR_ERROR = new RestException("用户未登录");
    
	/**
     * 用户不存在
     */
    public static final RestException USER_NOT_EXISTS = new RestException("用户不存在");
    
    /**
     * 用户已存在
     */
    public static final RestException USER_EXISTS = new RestException("用户已存在");
    
    /**
     * 密码错误
     */
    public static final RestException USER_LOGINED_ERROR = new RestException("用户已登录, 不允许重复登录");
    
    /**
     * 用户已登录
     */
    public static final RestException USER_PASS_ERROR = new RestException("密码错误");
    
}
