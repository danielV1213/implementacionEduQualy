/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private void ingresarEstudiante(ActionEvent event) {
        System.out.println("Ingresar");
    }
    
    @FXML
    private void registrarEstudiante(ActionEvent event) {
        
    }
    @FXML
    private void ingresarDocente(ActionEvent event) {
        
    }
    
    @FXML
    private void registrarDocente(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
