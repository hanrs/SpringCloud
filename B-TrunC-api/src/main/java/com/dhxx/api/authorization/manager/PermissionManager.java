package com.dhxx.api.authorization.manager;

import com.dhxx.common.entity.roleper.RolePermission;
import com.dhxx.common.entity.user.UserInfo;

import java.util.List;

public interface PermissionManager {

    /**
     * 把角色对应权限的集合保存于redis
     * @param list  角色对应权限的集合
     */
    public void createAccount(List<RolePermission> list, String account) throws Exception;

    /**
     * 获取登陆用户的权限
     * @param account 登陆用户账号
     * @return
     */
    public List<RolePermission> getAccount(String account);

    /**
     * 检查redis account是否有效
     * @param list
     * @return 是否有效
     */
    public boolean checkAccount(List<RolePermission> list, String account, String url);

    /**
     * 清除account
     * @param account 登录用户的account
     */
    public void deleteAccount(String account);

}
