/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Button btnRegresar;
    
    @FXML
    private void esMasculino(ActionEvent event) {
        
    }
    
    @FXML
    private void esFemenino(ActionEvent event) {
        
    }
    
    @FXML
    private void esPrimaria(ActionEvent event) {
        
    }
    
    @FXML
    private void esSecundaria(ActionEvent event) {
        
    }
    
    @FXML
    private void esTecnico(ActionEvent event) {
        
    }
    
    @FXML
    private void esProfesional(ActionEvent event) {
        
    }
    
    @FXML
    private void opmRegresar(ActionEvent event) {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void closeWindows(){
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
