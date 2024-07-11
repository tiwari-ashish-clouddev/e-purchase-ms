package com.assembleyourpc.app.users.repository;

import com.assembleyourpc.app.users.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findByUserRoleName(String roleAdmin);
}
