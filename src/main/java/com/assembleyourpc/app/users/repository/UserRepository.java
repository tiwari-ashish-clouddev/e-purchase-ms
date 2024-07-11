package com.assembleyourpc.app.users.repository;

import com.assembleyourpc.app.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserEmail(String emailOrMobile);

    Optional<User> findByUserMobile(String emailOrMobile);

}
