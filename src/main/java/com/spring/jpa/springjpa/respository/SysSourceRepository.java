package com.spring.jpa.springjpa.respository;

import com.spring.jpa.springjpa.entity.SysSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.UUID;

public interface SysSourceRepository extends BaseRepository<SysSourceEntity>, JpaRepository<SysSourceEntity, UUID>, JpaSpecificationExecutor<SysSourceEntity> {
}
