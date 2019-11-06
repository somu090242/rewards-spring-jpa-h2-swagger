package com.test.rewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.rewards.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
