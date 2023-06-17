package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "usuario";


    protected void conectarBaseDeDatos() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/" + DATABASE;
            conexion = java.sql.DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException e) {
            throw e;
        }
    }

    protected void desconectarBaseDeDatos() throws Exception {
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultado != null) {
                resultado.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBaseDeDatos();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            desconectarBaseDeDatos();
        }
    }

    protected void consultarBaseDeDatos(String sql) throws Exception {
        try {
            conectarBaseDeDatos();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException  e) {
            throw e;
        }
    }



}
