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
public class FXMLregistroProfesoresController implements Initializable {

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
    private TextField tf_areaAc;
    
    @FXML
    private TextField tf_fechaNac;
    
    @FXML
    private TextField tf_aniosExp;
    
    @FXML
    private TextField tf_tipoid;

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
    
    private FXMLDocumentController fxmlDocumentController;
    private Stage stage;

    @FXML
    private void esSeleccionado(ActionEvent event) {
        
    }
    
    @FXML
    private void limpiarProfesores(ActionEvent event) {
        tf_nombres.setText("");
        tf_apellidos.setText("");
        tf_id.setText("");
        tf_tipoid.setText("");
        tf_edad.setText("");
        tf_genero.setText("");
        tf_areaAc.setText("");
        tf_fechaNac.setText("");
        tf_aniosExp.setText("");
    }

    @FXML
    private void reg_Profesor(ActionEvent event) throws ClassNotFoundException, SQLException {

        String nameDB = "eduqualy";
        String user = "root";
        String pwd = "root1242";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String srcURL = "jdbc:mysql:///" + nameDB;
            Connection databaConnection = DriverManager.getConnection(srcURL, user, pwd);

            JOptionPane.showMessageDialog(null, "Conexión establecida con la base de datos de EduQualy", "Conexión", JOptionPane.INFORMATION_MESSAGE);

            Statement st = databaConnection.createStatement();

            String nombres = tf_nombres.getText();
            String apellidos = tf_apellidos.getText();
            int num_id = Integer.parseInt(tf_id.getText());
            int edad = Integer.parseInt(tf_edad.getText());
            String gen = tf_genero.getText();
            String areaAc = tf_areaAc.getText();     
            String fecha_nac = tf_fechaNac.getText();
            String anios_exp = tf_aniosExp.getText();
            String tipoId = tf_tipoid.getText();

            String sqlString = "insert into docentes"
                    + "(NOMBRES, APELLIDOS, ID, EDAD, GÉNERO, ÁREA_AC, FECHA_NAC, AÑOS_EXP)"
                    + " values('" + nombres + "', '" + apellidos + "', '" + num_id + "', '" + edad + "', '" + gen + "', '" + areaAc + "','" + fecha_nac +"', '"+ anios_exp +"')";
            
                    String sqlString2 = "insert into identificaciones" + "(NOM_TID, NÚM_ID_DOC)" + " values('" + tipoId + "', '" + num_id + "')";
            
            st.executeUpdate(sqlString);
            st.executeUpdate(sqlString2);
            
            JOptionPane.showMessageDialog(null, "¡Te has registrado con éxito en EduQualy!", "Registro", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
            JOptionPane.showMessageDialog(null, "Error en el registro, revise los campos", "Registro fallido", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            JOptionPane.showMessageDialog(null, "Error en el registro, revise los campos", "Registro fallido", JOptionPane.ERROR_MESSAGE);
        }
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

    void init(Stage stage, FXMLDocumentController aThis) {
        this.fxmlDocumentController = aThis;
        this.stage = stage;
    }

}
