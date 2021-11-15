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

    
    private Connection connection;
    
    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduqualy", "root", "serperior27");
        return connection;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduqualy", "root", "serperior27");
            JOptionPane.showMessageDialog(null, "Información actualizada.", "Actualización", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión con la Base de Datos fallida." + e, "Actualización fallida", JOptionPane.ERROR_MESSAGE);
        } 
        return connection;
    }
    
    public void cerrarConexion(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
