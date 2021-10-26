/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class TestConnection {

    public TestConnection() {

    }

    public static void main(String[] args) throws SQLException {

        String nombreDB = new String("eduqualy");
        String usuario = new String("root");
        String clave = new String("root");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String fuente = "jdbc:mysql://" + nombreDB;

            Connection conexDB = DriverManager.getConnection(fuente, usuario, clave);
            System.out.println("¡Conexión establecida correctamente!.");

            conexDB.close();
        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

    } //Fin del main

} //Fin clase
