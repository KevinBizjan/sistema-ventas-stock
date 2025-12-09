package com.ventas.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ventas.app.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    //Ventas por dia
    @Query("""
    SELECT DATE(v.fecha), SUM(v.total)
    FROM Venta v
    GROUP BY DATE(v.fecha)
    """)
    List<Object[]> ventasPorDia();
    //Clientes con mas compras
    @Query("""
    SELECT v.cliente.nombre, COUNT(v.id)
    FROM Venta v
    GROUP BY v.cliente.nombre
    ORDER BY COUNT(v.id) DESC
    """)
    List<Object[]> clienteConMasCompras();
}
