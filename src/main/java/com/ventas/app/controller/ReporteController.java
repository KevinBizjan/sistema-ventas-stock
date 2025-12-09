package com.ventas.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.app.repository.DetalleVentaRepository;
import com.ventas.app.repository.VentaRepository;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;

    public ReporteController(VentaRepository ventaRepository,
                             DetalleVentaRepository detalleVentaRepository) {
        this.ventaRepository = ventaRepository;
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @GetMapping("/ventas-por-dia")
    public List<Object[]> ventasPorDia() {
        return ventaRepository.ventasPorDia();
    }

    @GetMapping("/producto-mas-vendido")
    public List<Object[]> productoMasVendido() {
        return detalleVentaRepository.productoMasVendido();
    }

    @GetMapping("/cliente-con-mas-compras")
    public List<Object[]> clienteConMasCompras() {
        return ventaRepository.clienteConMasCompras();
    }
}
