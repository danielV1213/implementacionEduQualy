/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import BaseDatos.javaMysql;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Estudiante;

/**
 * FXML Controller class
 *
 * @author jjjim
 */
public class FXMLmenuProfesorController implements Initializable {
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TextField tf_nombreCurso;
    
    @FXML
    private TextField tf_duracion;
    
    @FXML
    private TextField tf_CodeCurso;
    
    @FXML
    private TextField tf_modalidad;
    
    @FXML
    private TextField tf_IDprofesor;
    
    @FXML
    private Button btnActualizar;
    
    @FXML
    private Button btnCrearCurso;
    
    //Cursos creados
    @FXML
    private TableView<Curso> tableCursosCreados;
    
    @FXML
    private TableColumn<Curso, String> TC_Nombre;
    
    @FXML
    private TableColumn<Curso, Integer> TC_Code;
    
    @FXML
    private TableColumn<Curso, Integer> TC_DuraH;
    
    @FXML
    private TableColumn<Curso, String> TC_Modal;
    
    @FXML
    private TableColumn<Curso, Integer> TC_ID_Docente;

    //Estudiantes matriculados.
    @FXML
    private TableView<Estudiante> tableEstudiantesMat;
    
    @FXML
    private TableColumn<Estudiante, String> TC_Nest;
    
    @FXML
    private TableColumn<Estudiante, String> TC_APest;
    
    @FXML
    private TableColumn<Estudiante, Integer> TC_IDest;
    
    @FXML
    private TableColumn<Estudiante, Integer> TC_EDADest;
    
    @FXML
    private TableColumn<Estudiante, String> TC_GENest;
    
    @FXML
    private TableColumn<Estudiante, String> TC_OCest;
    
    @FXML
    private TableColumn<Estudiante, String> TC_NIVACest;
    
    @FXML
    private TableColumn<Estudiante, String> TC_FECHAest;
    
    @FXML
    private TableColumn<Estudiante, Integer> TC_CODCURest;
    
    private ObservableList<Curso> listaCursosCreados;
    private javaMysql conexion;
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
    private void regresarProf(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void crearCurso(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        String nameDB = "eduqualy";
        String user = "root";
        String pwd = "root1242";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String srcURL = "jdbc:mysql:///" + nameDB;
            Connection databaConnection = DriverManager.getConnection(srcURL, user, pwd);
            
            JOptionPane.showMessageDialog(null, "Conexi??n establecida con la base de datos de EduQualy", "Conexi??n", JOptionPane.INFORMATION_MESSAGE);
            
            Statement st = databaConnection.createStatement();
            
            String nombre = tf_nombreCurso.getText();
            int code = Integer.parseInt(tf_CodeCurso.getText());
            int durac_h = Integer.parseInt(tf_duracion.getText());
            String modalidad = tf_modalidad.getText();
            int id_doc = Integer.parseInt(tf_IDprofesor.getText());
            
            String sqlString = "insert into cursos"
                    + "(NOMBRE, C??DIGO, DURACI??N_H, MODALIDAD, ID_DOCENTE)"
                    + " values('" + nombre + "', '" + code + "', '" + durac_h + "', '" + modalidad + "', '" + id_doc + "')";
            
            st.executeUpdate(sqlString);
            
            JOptionPane.showMessageDialog(null, "??Curso creado correctamente!", "Creaci??n de cursos", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
            JOptionPane.showMessageDialog(null, "Error en la creaci??n del curso, revise los campos.", "Creaci??n de cursos", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            JOptionPane.showMessageDialog(null, "Error en la creaci??n del curso, revise los campos.", "Creaci??n de cursos", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @FXML
    private void actualizarTablaCursos(ActionEvent event) {
        
        oblist.clear();
        
        try {
            Connection con = javaMysql.getConnection();
            
            ResultSet rs = con.createStatement().executeQuery("select * from cursos where ID_DOCENTE = " + tf_IDprofesor.getText());
            
            while (rs.next()) {
                oblist.add(new Curso(rs.getString("NOMBRE"),
                        rs.getInt("C??DIGO"), rs.getInt("DURACI??N_H"),
                        rs.getString("MODALIDAD"), rs.getInt("ID_DOCENTE")));
            }
            
            TC_Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            TC_Code.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            TC_DuraH.setCellValueFactory(new PropertyValueFactory<>("duracion_horas"));
            TC_Modal.setCellValueFactory(new PropertyValueFactory<>("modalidad"));
            TC_ID_Docente.setCellValueFactory(new PropertyValueFactory<>("id_docente"));
            
            tableCursosCreados.setItems(oblist);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLmenuProfesorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void actualizarTablaEst(ActionEvent event) {

        //Ver estudiantes matriculados
        oblistEst.clear();
        
        try {
            Connection con = javaMysql.getConnection();
            
            ResultSet rs = con.createStatement().executeQuery("select * from estudiantes where C??DIGO_CURSO = " + tf_CodeCurso.getText());
            
            while (rs.next()) {
                oblistEst.add(new Estudiante(
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOS"),
                        rs.getInt("ID"),
                        rs.getInt("EDAD"),
                        rs.getString("G??NERO"),
                        rs.getString("OCUPACI??N"),
                        rs.getString("NIVEL_AC"),
                        rs.getString("FECHA_NAC"),
                        rs.getInt("C??DIGO_CURSO")));
            }
            
            TC_Nest.setCellValueFactory(new PropertyValueFactory<>("nombres"));
            TC_APest.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            TC_IDest.setCellValueFactory(new PropertyValueFactory<>("id"));
            TC_EDADest.setCellValueFactory(new PropertyValueFactory<>("edad"));
            TC_GENest.setCellValueFactory(new PropertyValueFactory<>("genero"));
            TC_OCest.setCellValueFactory(new PropertyValueFactory<>("ocupacion"));
            TC_NIVACest.setCellValueFactory(new PropertyValueFactory<>("nivel_ac"));
            TC_FECHAest.setCellValueFactory(new PropertyValueFactory<>("fecha_nac"));
            TC_CODCURest.setCellValueFactory(new PropertyValueFactory<>("code_curso"));
            
            tableEstudiantesMat.setItems(oblistEst);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLmenuProfesorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void certificarEstudiante(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLcertificarEstudiante.fxml"));
                Parent root = loader.load();
                FXMLcertificarEstudianteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                controlador.init(stage, this);
                stage.show();
    }
    
    ObservableList<Curso> oblist = FXCollections.observableArrayList();
    ObservableList<Estudiante> oblistEst = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    void init(Stage stage, FXMLDocumentController aThis) {
        this.fxmlDocumentController = aThis;
        this.stage = stage;
    }
    
}
