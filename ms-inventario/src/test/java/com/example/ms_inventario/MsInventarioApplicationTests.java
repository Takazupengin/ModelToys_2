package com.example.ms_inventario;

import com.example.ms_inventario.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // <-- Esto levanta el servicio real con tu Base de Datos
class MsInventarioApplicationTests {

	@Autowired
	private InventoryRepository inventoryRepository; // <-- Conecta tu repositorio real

	@Test
	void testValidarConexionBaseDatos() {
		// Busca en tu base de datos real si existen productos cargados
		long cantidadProductos = inventoryRepository.count();

		// El test pasa si la base de datos responde y tiene al menos 1 producto (ej. tu Gundam)
		assertTrue(cantidadProductos > 0, "El catálogo en la base de datos está vacío o no conecta");
	}

	@Test
	void testBuscarProductoReal() {
		// Busca el ID 1 directo en tu base de datos
		var producto = inventoryRepository.findById(1L);

		// El test pasa si el producto con ID 1 realmente existe en tu sistema
		assertTrue(producto.isPresent(), "No se encontró el producto con ID 1 en la base de datos real");
	}
}

