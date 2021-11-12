/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import BaseDatos.ConexionMySQL;
import BaseDatos.javaMysql;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField TF_id_est;

    @FXML
    private TextField TF_pass_est;

    @FXML
    private TextField TF_id_doc;

    @FXML
    private TextField TF_pass_doc;

    @FXML
    private Button btnRegistroEstudiante;
    @FXML
    private Button btnRegistroProfesor;

    @FXML
    private Stage stage;

    @FXML
    private void ingresarEstudiante(ActionEvent event) throws IOException {
        try {
            ConexionMySQL Con = new ConexionMySQL();

            String id = TF_id_est.getText();
            String oc = TF_pass_est.getText();

            Con.ConectarBasedeDatos();

            String SQL = "SELECT ID, OCUPACIÓN FROM registro_estudiantes WHERE ID='" + id + "' AND OCUPACIÓN ='" + oc + "'";

            Con.resultado = Con.sentencia.executeQuery(SQL);

            if (Con.resultado.next()) {

                JOptionPane.showMessageDialog(null, "Acceso concedido.");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuEstudiante.fxml"));
                Parent root = loader.load();
                FXMLmenuEstudianteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                controlador.init(stage, this);
                stage.show();
                //Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
                //this.stage.close();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        System.out.println("Ingresar");
    }

    @FXML
    private void registrarEstudiante(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLregistroEstudiantes.fxml"));
        Parent root = loader.load();
        FXMLregistroEstudiantesController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controlador.init(stage, this);
        stage.show();
    }

    @FXML
    private void ingresarDocente(ActionEvent event) throws IOException {
        try {
            ConexionMySQL Con = new ConexionMySQL();

            String u = TF_id_doc.getText();
            String p = TF_pass_doc.getText();

            Con.ConectarBasedeDatos();

            String SQL = "SELECT ID, ÁREA_AC FROM registro_docentes WHERE ID='" + u + "' AND ÁREA_AC ='" + p + "'";

            Con.resultado = Con.sentencia.executeQuery(SQL);

            if (Con.resultado.next()) {

                JOptionPane.showMessageDialog(null, "Acceso concedido.");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuProfesor.fxml"));
                Parent root = loader.load();
                FXMLmenuProfesorController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                controlador.init(stage, this);
                stage.show();
                //Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
                //this.stage.close();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @FXML
    private void registrarDocente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLregistroProfesores.fxml"));
        Parent root = loader.load();
        FXMLregistroProfesoresController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controlador.init(stage, this);
        stage.show();
    }

    @FXML
    private void conectarBD(ActionEvent event) {
        javaMysql mysql = new javaMysql();
        mysql.conectar();
    }

    @FXML
    private void salirVentana1(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

}
