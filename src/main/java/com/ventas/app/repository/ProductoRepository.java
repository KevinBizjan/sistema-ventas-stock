package com.ventas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.app.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
