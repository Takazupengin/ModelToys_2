package com.example.ms_ventas.controller;

import com.example.ms_ventas.model.Venta;
import com.example.ms_ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodasLasVentas() {
        return ResponseEntity.ok(ventaService.obtenerTodasLasVentas());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crearVenta(@RequestBody Map<String, Object> request) {
        Venta nuevaVenta = ventaService.crearVenta(request);

        Map<String, Object> voucher = new LinkedHashMap<>();
        voucher.put("mensaje", "✨ ¡Compra efectuada con éxito! ✨");
        voucher.put("comprobanteId", "#000" + nuevaVenta.getId());
        voucher.put("productoId", nuevaVenta.getProductoId());
        voucher.put("cantidadUnidades", nuevaVenta.getCantidad() + " unidades");
        voucher.put("totalAPagar", "$ " + String.format("%,.0f", nuevaVenta.getTotal()) + " CLP");

        // Retorna la respuesta limpia con el voucher directo
        return ResponseEntity.status(HttpStatus.CREATED).body(voucher);
    }
}