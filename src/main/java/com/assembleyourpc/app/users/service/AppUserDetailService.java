package com.assembleyourpc.app.users.service;

import com.assembleyourpc.app.users.exceptions.UserNotFoundException;
import com.assembleyourpc.app.users.model.ApplicationUser;
import com.assembleyourpc.app.users.model.User;
import com.assembleyourpc.app.users.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailService implements UserDetailsService {

    public final UserRepository userRepository;

    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String emailOrMobile) throws UsernameNotFoundException {

        Optional<User> userOptional = emailOrMobile.contains("@")
                ? userRepository.findByUserEmail(emailOrMobile)
                : userRepository.findByUserMobile(emailOrMobile);
        return userOptional
                .map(ApplicationUser::new)
                .orElseThrow(() -> new UserNotFoundException("Email Or Mobile number provided not found"));
    }
}