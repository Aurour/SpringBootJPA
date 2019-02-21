package com.spring.jpa.springjpa.respository;

import com.spring.jpa.springjpa.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SysUserRepository extends BaseRepository<SysUserEntity>, JpaRepository<SysUserEntity, UUID>, JpaSpecificationExecutor<SysUserEntity> {

}
