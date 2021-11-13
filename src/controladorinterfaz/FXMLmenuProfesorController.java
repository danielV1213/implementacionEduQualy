/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import java.net.URL;
import java.util.ResourceBundle;
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
    private Button btnCrearCurso;
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TableView tableCursosCreados;
    
    @FXML
    private TableView tableEstudiantesMat;
    
    private FXMLDocumentController fxmlDocumentController;
    private Stage stage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void init(Stage stage, FXMLDocumentController aThis) {
        this.fxmlDocumentController = aThis;
        this.stage = stage;
    }

    
}
