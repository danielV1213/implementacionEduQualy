/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class InsertStatement {

    public InsertStatement() {
    }

    public static void main(String[] args) throws SQLException {

        String nombreBD = new String("eduqualy");
        String usuario = new String("root");
        String clave = new String("root1242");

        try {
            // Cargar la clase Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Definir el origen de los datos del driver
            String fuente = "jdbc:mysql:///" + nombreBD;
            // Crear una conexion a traves del DriverManager
            Connection databaseConnection
                    = DriverManager.getConnection(fuente, usuario, clave);
            // Crear el objeto Statement que permita la ejecución del SQL
            Statement st = databaseConnection.createStatement();

            String actor = "THE PROFE";
            String actriz = "THE STUDENT";
            String tipo = "DRAMA";
            String fecha = "2005/09/25";

            // crea una tabla UAO_TABLE en la base de datos app_WEB
            String sqlString = "INSERT INTO UAO_TABLE "
                    + "(TITULO, ACTOR_LIDER, ACTRIZ_LIDER, TIPO, FECHA_LIBERACION) "
                    + "VALUES('GRAN OBRA" + "','" + actor + "','"
                    + actriz + "','" + tipo + "','" + fecha + "')";

            st.executeUpdate(sqlString);

        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }
}
