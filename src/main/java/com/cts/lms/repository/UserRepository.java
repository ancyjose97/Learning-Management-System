package com.cts.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
