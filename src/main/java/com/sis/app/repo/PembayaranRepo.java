package com.sis.app.repo;

import com.sis.app.entitity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembayaranRepo extends JpaRepository<Pembayaran, Integer> {
}
