package com.healthmonitoringsystem.project.fitlyf.repository;

import com.healthmonitoringsystem.project.fitlyf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
