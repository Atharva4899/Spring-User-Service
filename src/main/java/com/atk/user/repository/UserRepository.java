package com.atk.user.repository;

import com.atk.user.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUserId(Long userId);
}
