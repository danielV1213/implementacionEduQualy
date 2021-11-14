/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import BaseDatos.javaMysql;
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
import javafx.fxml.Initializable;
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
public class FXMLmenuEstudianteController implements Initializable {

    /**
     * Initializes the controller class.
     */ 
    
    //Cursos disponibles.
    
    @FXML
    private TableView<Curso> tableCursosDisponibles;
    
    @FXML
    private TableColumn<Curso, String> tc_Nombre;
    
    @FXML
    private TableColumn<Curso, Integer> tc_Code;
    
    @FXML
    private TableColumn<Curso, Integer> tc_DuraH;
    
    @FXML
    private TableColumn<Curso, String> tc_Modal;
    
    @FXML
    private TableColumn<Curso, Integer> tc_ID_Docente;
    
    @FXML
    private TextField tf_IDCurso;
    
    @FXML
    private TextField tf_IDSeccEst;
    
    //Cursos matriculados.
    
    @FXML
    private TableView<Curso> tableCursosMatriculados;
    
    @FXML
    private TableColumn<Curso, String> tC_Nombre;
    
    @FXML
    private TableColumn<Curso, Integer> tC_Code;
    
    @FXML
    private TableColumn<Curso, Integer> tC_DuraH;
    
    @FXML
    private TableColumn<Curso, String> tC_Modal;
    
    @FXML
    private TableColumn<Curso, Integer> tC_ID_Docente;
    
    private FXMLDocumentController fxmlDocumentController;
    private Stage stage;
    
    @FXML
    private void  matricularCurso(ActionEvent event) {
        
        String nameDB = "eduqualy";
        String user = "root";
        String pwd = "root1242";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String srcURL = "jdbc:mysql:///" + nameDB;
            Connection databaConnection = DriverManager.getConnection(srcURL, user, pwd);

            JOptionPane.showMessageDialog(null, "Conexión establecida con la base de datos de EduQualy", "Conexión", JOptionPane.INFORMATION_MESSAGE);

            Statement st = databaConnection.createStatement();

            int code_curso = Integer.parseInt(tf_IDCurso.getText());
            
            int id_est = Integer.parseInt(tf_IDSeccEst.getText());
           

            String sqlString = "update estudiantes "
                    + "set CÓDIGO_CURSO = " + code_curso
                    + " where ID = " + id_est;

            st.executeUpdate(sqlString);

            JOptionPane.showMessageDialog(null, "¡Curso matriculado correctamente!", "Matrícula", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
            JOptionPane.showMessageDialog(null, "Error en la matrícula del curso, revise los campos.", "Matrícula", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            JOptionPane.showMessageDialog(null, "Error en la matrícula del curso, revise los campos.", "Matrícula", JOptionPane.ERROR_MESSAGE);
        }
        
    } 
    
    @FXML
    private void  verMatricula(ActionEvent event) {
        
        obListCursosMat.clear();
        
        try {
            Connection con = javaMysql.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from cursos where CÓDIGO = " + tf_IDCurso.getText());

            while (rs.next()) {
                obListCursosMat.add(new Curso(
                        rs.getString("NOMBRE"),
                        rs.getInt("CÓDIGO"),
                        rs.getInt("DURACIÓN_H"),
                        rs.getString("MODALIDAD"),
                        rs.getInt("ID_DOCENTE")));
            }
            
            tC_Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tC_Code.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            tC_DuraH.setCellValueFactory(new PropertyValueFactory<>("duracion_horas"));
            tC_Modal.setCellValueFactory(new PropertyValueFactory<>("modalidad"));
            tC_ID_Docente.setCellValueFactory(new PropertyValueFactory<>("id_docente"));

            tableCursosMatriculados.setItems(obListCursosMat);
                    

        } catch (SQLException ex) {
            Logger.getLogger(FXMLmenuProfesorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void  regresarSeccEst(ActionEvent event) {
        
    }
    
    ObservableList<Curso> obListCursosDisp = FXCollections.observableArrayList();
    ObservableList<Curso> obListCursosMat = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = javaMysql.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from cursos");

            while (rs.next()) {

                
                
                obListCursosDisp.add(new Curso(rs.getString("NOMBRE"),
                        rs.getInt("CÓDIGO"), rs.getInt("DURACIÓN_H"),
                        rs.getString("MODALIDAD"), rs.getInt("ID_DOCENTE")));
            }

            tc_Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tc_Code.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            tc_DuraH.setCellValueFactory(new PropertyValueFactory<>("duracion_horas"));
            tc_Modal.setCellValueFactory(new PropertyValueFactory<>("modalidad"));
            tc_ID_Docente.setCellValueFactory(new PropertyValueFactory<>("id_docente"));

            tableCursosDisponibles.setItems(obListCursosDisp);    
            

        } catch (SQLException ex) {
            Logger.getLogger(FXMLmenuProfesorController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    

    void init(Stage stage, FXMLDocumentController aThis) {
        this.fxmlDocumentController = aThis;
        this.stage = stage;
    }
    
}
