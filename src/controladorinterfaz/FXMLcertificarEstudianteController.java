/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jjjim
 */
public class FXMLcertificarEstudianteController implements Initializable {

    @FXML
    private TextField tf_idCertificado;

    @FXML
    private TextField tf_codCertificado;

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
    private void certificar(ActionEvent event) {
        String nameDB = "eduqualy";
        String user = "root";
        String pwd = "serperior27";

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

    void init(Stage stage, FXMLmenuProfesorController aThis) {
        this.fxmlMenuProfesorController = aThis;
        this.stage = stage;
    }

}
