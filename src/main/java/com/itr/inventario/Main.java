package com.itr.inventario.principal;

// Importamos la interfaz, la implementación y el modelo
import com.itr.inventario.dao.ProductoDAO;
import com.itr.inventario.dao.ProductoDAOImpl;
import com.itr.inventario.modelo.Producto;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Instanciamos el DAO. Usamos la interfaz para llamar a la implementación.
        ProductoDAO dao = new ProductoDAOImpl();

        // ==========================================
        // 1. INSERTAR (CREATE)
        // ==========================================
        System.out.println("--- INSERTANDO PRODUCTO ---");
        // Creamos un producto de prueba.
        // ¡Ojo! El primer "1" es el id_categoria.
        // Debes tener una categoría con ID 1 en tu base de datos para que no falle.
        Producto nuevo = new Producto(1, "P001", "Camisa Polo", "Camisa talla M", 45000.0, 10, "Disponible");
        dao.insertar(nuevo); // Llamamos al método insertar de la base de datos

        // ==========================================
        // 2. CONSULTAR (READ)
        // ==========================================
        System.out.println("\n--- LISTANDO PRODUCTOS ---");
        // Traemos todos los productos de la base de datos a una lista de Java
        List<Producto> productos = dao.listar();

        // Recorremos la lista y imprimimos cada producto
        for (Producto p : productos) {
            System.out.println(p.toString());
        }

        // ==========================================
        // 3. ACTUALIZAR (UPDATE)
        // ==========================================
        System.out.println("\n--- ACTUALIZANDO PRODUCTO ---");
        // Verificamos que la lista no esté vacía para evitar errores
        if (!productos.isEmpty()) {
            // Tomamos el primer producto de la lista (posición 0)
            Producto paraActualizar = productos.get(0);

            // Le cambiamos el precio y el stock
            paraActualizar.setPrecio(50000.0);
            paraActualizar.setStock(8);

            // Enviamos el producto modificado a la base de datos
            dao.actualizar(paraActualizar);
        }

        // ==========================================
        // 4. ELIMINAR (DELETE)
        // ==========================================
        System.out.println("\n--- ELIMINANDO PRODUCTO ---");
        if (!productos.isEmpty()) {
            // Tomamos el último producto de la lista
            Producto paraEliminar = productos.get(productos.size() - 1);

            // Obtenemos su ID y lo enviamos a eliminar
            dao.eliminar(paraEliminar.getIdProducto());
        }
    }
}