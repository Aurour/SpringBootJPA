package com.spring.jpa.springjpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_source", schema = "springboot", catalog = "")
public class SysSourceEntity {
    private int id;
    private String sourceName;
    private String sourceIdentity;
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
    @Column(name = "source_name")
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Basic
    @Column(name = "source_identity")
    public String getSourceIdentity() {
        return sourceIdentity;
    }

    public void setSourceIdentity(String sourceIdentity) {
        this.sourceIdentity = sourceIdentity;
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
        SysSourceEntity that = (SysSourceEntity) o;
        return id == that.id &&
                Objects.equals(sourceName, that.sourceName) &&
                Objects.equals(sourceIdentity, that.sourceIdentity) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceName, sourceIdentity, status);
    }
}
