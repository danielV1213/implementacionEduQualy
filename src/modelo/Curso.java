/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel
 */
public class Curso {

    String nombre, modalidad;
    int codigo, duracion_horas;
    int id_docente;

    public Curso() {
    }

    public Curso(String nombre, int codigo, int duracion_horas, String modalidad, int id_docente) {
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.codigo = codigo;
        this.duracion_horas = duracion_horas;
        this.id_docente = id_docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDuracion_horas() {
        return duracion_horas;
    }

    public void setDuracion_horas(int duracion_horas) {
        this.duracion_horas = duracion_horas;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    @Override
    public String toString() {
        return "Curso{" + "nombre=" + nombre + ", modalidad=" + modalidad + ", codigo=" + codigo + ", duracion_horas=" + duracion_horas + ", id_docente=" + id_docente + '}';
    }

    public static void llenarInfoCursosP(Connection conexion,
            ObservableList<Curso> lista) {
        try {
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT NOMBRE, "
                    + "CÓDIGO, "
                    + "DURACIÓN_H, "
                    + "MODALIDAD, "
                    + "ID_DOCENTE, "
                    + "FROM cursos"
            );
            while (resultado.next()) {
                lista.add(
                        new Curso(resultado.getString("NOMBRE"),
                                resultado.getInt("CÓDIGO"),
                                resultado.getInt("DURACIÓN_H"),
                                resultado.getString("MODALIDAD"),
                                resultado.getInt("ID_DOCENTE"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenadoDeTablas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
