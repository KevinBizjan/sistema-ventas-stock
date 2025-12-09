package com.ventas.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ventas.app.model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    //Producto mas vendido
    @Query("""
    SELECT d.producto.nombre, SUM(d.cantidad)
    FROM DetalleVenta d
    GROUP BY d.producto.nombre
    ORDER BY SUM(d.cantidad) DESC
    """)
    List<Object[]> productoMasVendido();
}
