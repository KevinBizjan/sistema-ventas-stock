package com.ventas.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.app.model.DetalleVenta;
import com.ventas.app.model.Producto;
import com.ventas.app.model.Venta;
import com.ventas.app.repository.ProductoRepository;
import com.ventas.app.repository.VentaRepository;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    public VentaController(VentaRepository ventaRepository,
                           ProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {

        if (venta.getDetalles() == null || venta.getDetalles().isEmpty()) {
            throw new RuntimeException("La venta no tiene detalles");
        }

        venta.setFecha(LocalDateTime.now());
        double total = 0;

        for (DetalleVenta d : venta.getDetalles()) {

            Producto producto = productoRepository.findById(d.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (producto.getStock() < d.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - d.getCantidad());
            productoRepository.save(producto);

            d.setPrecioUnitario(producto.getPrecio().doubleValue());
            d.setSubtotal(d.getCantidad() * d.getPrecioUnitario());
            d.setVenta(venta);

            total += d.getSubtotal();
        }

        venta.setTotal(total);

        Venta ventaGuardada = ventaRepository.save(venta);
        return ventaGuardada;
    }

    @GetMapping
    public List<Venta> listar() {
        return ventaRepository.findAll();
    }
}
