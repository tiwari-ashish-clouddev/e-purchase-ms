package com.assembleyourpc.app.users.repository;

import com.assembleyourpc.app.users.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password,Long> {
}
