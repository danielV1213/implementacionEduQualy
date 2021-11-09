/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jjjim
 */
public class FXMLregistroEstudiantesController implements Initializable {

    @FXML
    private TextField tf_nombres;

    @FXML
    private TextField tf_apellidos;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_edad;

    @FXML
    private TextField tf_genero;

    @FXML
    private TextField tf_ocupacion;
    
    @FXML
    private TextField tf_fechaNac;

    @FXML
    private Button btnRegresar;

    @FXML
    private RadioButton rBPrimaria;

    @FXML
    private RadioButton rBSecundaria;

    @FXML
    private RadioButton rBTec;

    @FXML
    private RadioButton rBPro;

    @FXML
    private Label labelSeleccion;

    @FXML
    private void esSeleccionado(ActionEvent event) {
        if (rBPrimaria.isSelected()) {
            labelSeleccion.setText(rBPrimaria.getText());
        } else if (rBSecundaria.isSelected()) {
            labelSeleccion.setText(rBSecundaria.getText());
        } else if (rBTec.isSelected()) {
            labelSeleccion.setText(rBTec.getText());
        } else if (rBPro.isSelected()) {
            labelSeleccion.setText(rBPro.getText());
        }
    }

    @FXML
    private void reg_Estudiante(ActionEvent event) throws ClassNotFoundException, SQLException {

        String nameDB = "eduqualy";
        String user = "root";
        String pwd = "root1242";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String srcURL = "jdbc:mysql:///" + nameDB;
            Connection databaConnection = DriverManager.getConnection(srcURL, user, pwd);

            //JOptionPane.showMessageDialog(null, "Conexión con " + nameDB + " restablecida");
            JOptionPane.showMessageDialog(null, "¡Te has registrado con éxito en EduQualy!");

            Statement st = databaConnection.createStatement();

            String nombres = tf_nombres.getText();
            String apellidos = tf_apellidos.getText();
            int num_id = Integer.parseInt(tf_id.getText());
            int edad = Integer.parseInt(tf_edad.getText());
            String gen = tf_genero.getText();
            String ocupacion = tf_ocupacion.getText();
            String nivel_ac = labelSeleccion.getText();
            String fecha_nac = tf_fechaNac.getText();

            String sqlString = "insert into registro_estudiantes"
                    + "(NOMBRES, APELLIDOS, ID, EDAD, GÉNERO, OCUPACIÓN, NIVEL_AC, FECHA_NAC)"
                    + " values('" + nombres + "', '" + apellidos + "', '" + num_id + "', '" + edad + "', '" + gen + "', '" + ocupacion + "', '" + nivel_ac +"','"+fecha_nac+"')";

            st.executeUpdate(sqlString); 
        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        
        tf_nombres.setText("");
        tf_apellidos.setText("");
        tf_id.setText("");
        tf_edad.setText("");
        tf_genero.setText("");
        tf_ocupacion.setText("");
        labelSeleccion.setText("");
    }

    @FXML
    private void opmRegresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLDocument.fxml"));
            Parent root = loader.load();

            FXMLDocumentController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
