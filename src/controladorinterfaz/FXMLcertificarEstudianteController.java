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
import modelo.Graduado;

/**
 * FXML Controller class
 *
 * @author jjjim
 */
public class FXMLcertificarEstudianteController implements Initializable {
    
    @FXML
    private Button btnRegresar;

    @FXML
    private TextField tf_idCertificado;

    @FXML
    private TextField tf_codCertificado;

    @FXML
    private TableView<Graduado> tableGraduados;

    @FXML
    private TableColumn<Graduado, String> TC_NG;

    @FXML
    private TableColumn<Graduado, String> TC_APeG;

    @FXML
    private TableColumn<Graduado, Integer> TC_IDG;

    @FXML
    private TableColumn<Graduado, Integer> TC_EDADG;

    @FXML
    private TableColumn<Graduado, String> TC_GENG;

    @FXML
    private TableColumn<Graduado, String> TC_OCG;

    @FXML
    private TableColumn<Graduado, String> TC_NIVACG;

    @FXML
    private TableColumn<Graduado, String> TC_FECHAG;

    @FXML
    private TableColumn<Graduado, Integer> TC_CODCURG;

    private FXMLmenuProfesorController fxmlMenuProfesorController;
    private Stage stage;

    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
     @FXML
    private void opmRegresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    

    @FXML
    private void certificar(ActionEvent event) {
        String nameDB = "eduqualy";
        String user = "root";
        String pwd = "root1242";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String srcURL = "jdbc:mysql:///" + nameDB;
            Connection databaConnection = DriverManager.getConnection(srcURL, user, pwd);

            JOptionPane.showMessageDialog(null, "Conexión establecida con la base de datos de EduQualy", "Conexión", JOptionPane.INFORMATION_MESSAGE);

            Statement st = databaConnection.createStatement();

            int numId = Integer.parseInt(tf_idCertificado.getText());
            int codCurso = Integer.parseInt(tf_codCertificado.getText());

            String SQL = "select * from estudiantes where ID='" + numId + "'";

            ResultSet set = st.executeQuery(SQL);

            if (set.next()) {
                String nom = set.getString("NOMBRES");
                String ape = set.getString("APELLIDOS");
                int edad = set.getInt("EDAD");
                String genero = set.getString("GÉNERO");
                String ocupa = set.getString("OCUPACIÓN");
                String nivelAc = set.getString("NIVEL_AC");
                String fechaNac = set.getString("FECHA_NAC");

                String sqlString = "insert into graduados"
                        + "(NOMBRES, APELLIDOS, ID, EDAD, GÉNERO, OCUPACIÓN, NIVEL_AC, FECHA_NAC, CÓDIGO_CURSO)"
                        + " values('" + nom + "', '" + ape + "', '" + numId + "', '" + edad + "', '" + genero + "', '" + ocupa + "', '" + nivelAc + "','" + fechaNac + "','" + codCurso + "')";

                //String sqlString2 = "insert into graduados" + "(NOM_TID, NÚM_ID_EST)" + " values('" + tipoId + "', '" + num_id + "')";
                st.executeUpdate(sqlString);
                //st.executeUpdate(sqlString2);

                JOptionPane.showMessageDialog(null, "Usted ha certificado a este estudiante satisfactoriamente", "Registro", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas.");
            }

        } catch (ClassNotFoundException evt) {
            System.err.println(evt);
            JOptionPane.showMessageDialog(null, "Error en la certificación, revise los campos", "Certificación fallida", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            JOptionPane.showMessageDialog(null, "Error en la certificación, revise los campos", "Certificación fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void actualizarTablaGraduados(ActionEvent event) {
        oblistG.clear();

        try {
            Connection con = javaMysql.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from graduados");

            while (rs.next()) {
                oblistG.add(new Graduado(
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOS"),
                        rs.getInt("ID"),
                        rs.getInt("EDAD"),
                        rs.getString("GÉNERO"),
                        rs.getString("OCUPACIÓN"),
                        rs.getString("NIVEL_AC"),
                        rs.getString("FECHA_NAC"),
                        rs.getInt("CÓDIGO_CURSO")));
            }

            TC_NG.setCellValueFactory(new PropertyValueFactory<>("nombres"));
            TC_APeG.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            TC_IDG.setCellValueFactory(new PropertyValueFactory<>("id"));
            TC_EDADG.setCellValueFactory(new PropertyValueFactory<>("edad"));
            TC_GENG.setCellValueFactory(new PropertyValueFactory<>("genero"));
            TC_OCG.setCellValueFactory(new PropertyValueFactory<>("ocupacion"));
            TC_NIVACG.setCellValueFactory(new PropertyValueFactory<>("nivel_ac"));
            TC_FECHAG.setCellValueFactory(new PropertyValueFactory<>("fecha_nac"));
            TC_CODCURG.setCellValueFactory(new PropertyValueFactory<>("code_curso"));

            tableGraduados.setItems(oblistG);

        } catch (SQLException ex) {
            Logger.getLogger(FXMLmenuProfesorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en las tablas.", "Certificación", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    ObservableList<Graduado> oblistG = FXCollections.observableArrayList();

    void init(Stage stage, FXMLmenuProfesorController aThis) {
        this.fxmlMenuProfesorController = aThis;
        this.stage = stage;
    }

}
