package com.buiminhduc.model.entity;

import com.buiminhduc.common.annotation.Column;
import com.buiminhduc.common.annotation.Entity;
import com.buiminhduc.common.annotation.Id;

@Entity(name = "user ")
public class UserEntity {
    @Id(value = "id")
    private Integer id;
    @Column(value = "user_name")
    private String userName;
    @Column(value = "password")
    private String password;
    @Column(value = "phone")
    private String phone;
    @Column(value = "email")
    private String email;
    @Column(value = "role_id")
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
