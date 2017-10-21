package com.dhxx.common.entity.role;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 角色权限表 (TB_ROLE)
 */
public class Role {
    private Long id;
    private String roleName;
    private String describe;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getRoleName() { return roleName; }

    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }
}
