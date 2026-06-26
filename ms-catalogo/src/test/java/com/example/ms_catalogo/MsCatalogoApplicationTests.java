package com.example.ms_catalogo;

import com.example.ms_catalogo.repository.ProductRepository; // Ajusta a tu nombre (ej. ProductoRepository)
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Levanta el catálogo real conectado a tu BD
class MsCatalogoApplicationTests {

	@Autowired
	private ProductRepository productRepository; // Tu repositorio real de productos

	@Test
	void testVerificarCatalogoDisponible() {
		// Le pregunta a la base de datos real si hay productos registrados
		long totalProductos = productRepository.count();

		// Pasa si encuentra tus modelos cargados en el sistema
		assertTrue(totalProductos > 0, "Error: El catálogo está vacío en la base de datos real");
	}

	@Test
	void testValidarNombresProductos() {
		// Trae el primer producto que pille en tu base de datos de verdad
		var primerProducto = productRepository.findAll().stream().findFirst();

		// Verifica que el producto exista y que su nombre real no esté en blanco
		assertTrue(primerProducto.isPresent(), "No hay ningún producto en la BD para validar");
		assertNotNull(primerProducto.get().getName(), "El producto encontrado tiene el nombre nulo"); // Ajusta a getName() o getNombre()
	}
}