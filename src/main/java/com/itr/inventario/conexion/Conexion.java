package com.itr.inventario.conexion;

// Importamos las herramientas necesarias para manejar la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // 1. Definimos la URL de conexión.
    // "jdbc:mysql://" indica que usaremos MySQL.
    // "127.0.0.1:3306" es tu computadora local y el puerto por defecto de MySQL.
    // "itr" es el nombre de tu base de datos (asegúrate de que se llame así).
    // "useSSL=false" y "serverTimezone=UTC" evitan errores comunes de conexión.
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/itr?useSSL=false&serverTimezone=UTC";

    // 2. Usuario de MySQL (por defecto suele ser "root")
    private static final String USER = "root";

    // 3. Contraseña de MySQL. ¡CAMBIA ESTO POR TU CONTRASEÑA REAL!
    private static final String PASSWORD = "Cristi1929";

    // Método principal que nos dará la conexión. Es "static" para llamarlo sin crear objetos.
    public static Connection obtenerConexion() {

        // Inicializamos la conexión en null (vacía)
        Connection conexion = null;

        // Bloque try-catch: Intentamos conectar y atrapamos posibles errores
        try {
            // Aquí ocurre la magia: DriverManager busca el conector y se conecta usando los datos
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            // Si llegamos a esta línea, la conexión fue exitosa. Imprimimos un mensaje.
            System.out.println("¡Conexión exitosa a la base de datos ITR!");

        } catch (SQLException e) {
            // Si hay un error (contraseña mal, DB apagada, etc.), caerá aquí.
            // System.err imprime el mensaje en color rojo en la consola para que lo notes.
            System.err.println("Error de conexión: " + e.getMessage());
        }

        // Retornamos la conexión (si falló, retornará null, si funcionó, retornará el "cable" conectado)
        return conexion;
    }
}