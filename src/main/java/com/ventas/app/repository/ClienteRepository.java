package com.ventas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
