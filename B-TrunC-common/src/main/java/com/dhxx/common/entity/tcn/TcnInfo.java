package com.dhxx.common.entity.tcn;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 核心网信息表 (TB_TCN_INFO)
 */
public class TcnInfo {
    private Long id; //主键
    private String account; //账号
    private String ip; //ip地址
    private String routeAddress; //路由地址
    private String dns; //DNS
    private String realmName; //域名

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public String getIp() { return ip; }

    public void setIp(String ip) { this.ip = ip; }

    public String getRouteAddress() { return routeAddress; }

    public void setRouteAddress(String routeAddress) { this.routeAddress = routeAddress; }

    public String getDns() { return dns; }

    public void setDns(String dns) { this.dns = dns; }

    public String getRealmName() { return realmName; }

    public void setRealmName(String realmName) { this.realmName = realmName; }
}
