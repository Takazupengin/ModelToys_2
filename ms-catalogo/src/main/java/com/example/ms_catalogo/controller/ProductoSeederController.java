package com.example.ms_catalogo.controller;

import com.example.ms_catalogo.model.Product;
import com.example.ms_catalogo.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/products/seeder")
public class ProductoSeederController {

    @Autowired
    private ProductRepository productRepository; // Ajustado a "Product" según tu arquitectura

    @GetMapping
    public ResponseEntity<String> sembrarDatos() {
        // Inicializamos Faker en español para nombres geniales
        Faker faker = new Faker(new Locale("es"));
        List<Product> productosFalsos = new ArrayList<>();

        // Generamos 20 productos de simulación automática
        for (int i = 0; i < 20; i++) {
            Product p = new Product();

            // Inventamos nombres de fantasía basados en videojuegos
            String modeloRandom = faker.videoGame().title();
            p.setName("Figura " + modeloRandom + " - Edición Especial");
            p.setGrade("Premium PVC");

            // Precios coherentes entre $15.000 y $85.000 CLP
            p.setPrice(faker.number().randomDouble(0, 15000, 85000));

            productosFalsos.add(p);
        }

        // Se guardan todos de un viaje en tu Laragon (y mañana en AWS)
        productRepository.saveAll(productosFalsos);

        return ResponseEntity.ok("🎲 ¡Éxito! Se han sembrado 20 figuras coleccionables aleatorias en tu base de datos.");
    }
}