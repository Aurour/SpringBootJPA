package com.spring.jpa.springjpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_role", schema = "springboot", catalog = "")
public class SysRoleEntity {
    private int id;
    private String roleName;
    private String roleIdentity;
    private Integer status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_identity")
    public String getRoleIdentity() {
        return roleIdentity;
    }

    public void setRoleIdentity(String roleIdentity) {
        this.roleIdentity = roleIdentity;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleEntity that = (SysRoleEntity) o;
        return id == that.id &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleIdentity, that.roleIdentity) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, roleIdentity, status);
    }
}
