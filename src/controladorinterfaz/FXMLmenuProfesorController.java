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
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jjjim
 */
public class FXMLmenuProfesorController implements Initializable {

    @FXML
    private TextField tf_nombreCurso;

    @FXML
    private TextField tf_duracion;

    @FXML
    private TextField tf_modalidad;

    @FXML
    private TextField tf_IDprofesor;
    
    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCrearCurso;
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TableView tableCursosCreados;
    
    @FXML
    private TableView tableEstudiantesMat;
    
    private FXMLDocumentController fxmlDocumentController;
    private Stage stage;
    
    @FXML
    private void limpiarCampos(ActionEvent event) {

        tf_nombreCurso.setText("");
        tf_duracion.setText("");
        tf_modalidad.setText("");
        tf_IDprofesor.setText("");
    
    }
    
    @FXML
    private void opmRegresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void init(Stage stage, FXMLDocumentController aThis) {
        this.fxmlDocumentController = aThis;
        this.stage = stage;
    }

    
}
