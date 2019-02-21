package com.spring.jpa.springjpa.respository;

import com.spring.jpa.springjpa.entity.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SysRoleRepository extends BaseRepository<SysRoleEntity>, JpaRepository<SysRoleEntity, UUID>, JpaSpecificationExecutor<SysRoleEntity> {


}
