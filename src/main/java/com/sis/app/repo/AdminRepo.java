package com.sis.app.repo;

import com.sis.app.entitity.admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<admin, Integer> {
}
