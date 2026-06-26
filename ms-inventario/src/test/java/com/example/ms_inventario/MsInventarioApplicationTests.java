package com.example.ms_inventario;

import com.example.ms_inventario.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MsInventarioApplicationTests {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Test
	void testValidarConexionBaseDatos() {
		long cantidadProductos = inventoryRepository.count();
		assertTrue(cantidadProductos > 0, "El catálogo en la base de datos está vacío o no conecta");
	}

	@Test
	void testBuscarProductoReal() {
		var producto = inventoryRepository.findById(1L);
		assertTrue(producto.isPresent(), "No se encontró el producto con ID 1 en la base de datos real");
	}
}

