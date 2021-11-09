/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class javaMysql {

    Connection conectar = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduqualy", "root", "root1242");
            JOptionPane.showMessageDialog(null, "Conexión exitosa ", "Conexión", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión fallida " + e, "Conexión", JOptionPane.ERROR_MESSAGE);
        } 
        return conectar;
    }
}
