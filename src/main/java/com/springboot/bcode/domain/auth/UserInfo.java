package com.springboot.bcode.domain.auth;

import java.util.Date;
import java.util.List;

import com.springboot.core.jdbc.annotation.Columns;
import com.springboot.core.jdbc.annotation.Tables;
import com.springboot.core.web.mvc.JqGridParam;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:47
 * @Package: com.springboot.bcode.domain.auth
 */

@Tables(table = "t_web_user")
public class UserInfo extends JqGridParam {

    @Columns(column = "uid", primaryKey = true, autoIncrement = false)
    private String uid;
    
    @Columns(column = "name")
    private String name;
    
    @Columns(column = "password")
    private String password;
    
    @Columns(column = "vsername")
    private String vserName;
    
    @Columns(column = "mobile")
    private String mobile;
    
    @Columns(column = "createTime")
    private Date createTime;
    
    @Columns(column = "state")
    private Integer state;
    // 用户状态1:正常;0:禁用
    
    @Columns(column = "deptid")
    private Integer deptid;
    // 部门id
    
    @Columns(column = "jobid")
    private Integer jobid;
    // 岗位id
    
    @Columns(column = "email")
    private String email;
    
    private String avatar = "pic";
    
    private String introduction = "hello word";

    private String token;
    
    private String deptName;
    // 部门名称
    
    private String jobName;
    // 岗位名称
    // 角色
    
    private List<Role> roles;
    // 用户的菜单
    
    private List<MenuVO> menus;
    // 用户拥有的功能权限
    
    private List<Permission> permissions;
    // 数据权限范围（1：全部数据权限 2：自定数据权限 3：本部门及以下数据权限4：本部门数据权限 5：本人）
    
    private Integer datascope;
    // 户拥有的数据权限
    
    private List<Integer> datascopes;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVserName() {
        return vserName;
    }

    public void setVserName(String vserName) {
        this.vserName = vserName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDatascopes() {
        return datascopes;
    }

    public void setDatascopes(List<Integer> datascopes) {
        this.datascopes = datascopes;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<MenuVO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVO> menus) {
        this.menus = menus;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getDatascope() {
        return datascope;
    }

    public void setDatascope(Integer datascope) {
        this.datascope = datascope;
    }
}
