package com.anonymous63.sms.repository;

import com.anonymous63.sms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
