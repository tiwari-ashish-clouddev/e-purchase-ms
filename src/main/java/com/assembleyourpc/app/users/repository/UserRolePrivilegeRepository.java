package com.assembleyourpc.app.users.repository;

import com.assembleyourpc.app.users.model.UserRolePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolePrivilegeRepository extends JpaRepository<UserRolePrivilege, Long> {

    UserRolePrivilege findByUserRolePrivilegeName(String privilegeName);

}
