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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel
 */
public class Graduado {

    String nombres, apellidos, genero, ocupacion, nivel_ac, fecha_nac;
    int id, edad, code_curso;

    public Graduado() {
    }

    public Graduado(String nombres, String apellidos, int id, int edad, String genero, String ocupacion, String nivel_ac, String fecha_nac, int code_curso) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.nivel_ac = nivel_ac;
        this.fecha_nac = fecha_nac;
        this.id = id;
        this.edad = edad;
        this.code_curso = code_curso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNivel_ac() {
        return nivel_ac;
    }

    public void setNivel_ac(String nivel_ac) {
        this.nivel_ac = nivel_ac;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCode_curso() {
        return code_curso;
    }

    public void setCode_curso(int code_curso) {
        this.code_curso = code_curso;
    }

    @Override
    public String toString() {
        return "Graduado{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero + ", ocupacion=" + ocupacion + ", nivel_ac=" + nivel_ac + ", fecha_nac=" + fecha_nac + ", id=" + id + ", edad=" + edad + ", code_curso=" + code_curso + '}';
    }

    public static void llenarEstGraduados(Connection conexion, ObservableList<Estudiante> listaG) {
        try {
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT NOMBRES, "
                    + "APELLIDOS, "
                    + "ID, "
                    + "EDAD, "
                    + "GÉNERO, "
                    + "OCUPACIÓN, "
                    + "NIVEL_AC, "
                    + "FECHA_NAC, "
                    + "CÓDIGO_CURSO, "
            );
            while (resultado.next()) {
                listaG.add(
                        new Estudiante(resultado.getString("NOMBRES"),
                                resultado.getString("APELLIDOS"),
                                resultado.getInt("ID"),
                                resultado.getInt("EDAD"),
                                resultado.getString("GÉNERO"),
                                resultado.getString("OCUPACIÓN"),
                                resultado.getString("NIVEL_AC"),
                                resultado.getString("FECHA_NAC"),
                                resultado.getInt("CÓDIGO_CURSO"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenadoDeTablas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
