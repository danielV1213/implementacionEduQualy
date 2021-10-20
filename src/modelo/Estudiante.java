/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Estudiante extends Persona {

    private ArrayList<Curso> cursos_matriculados;
    private String ocupacion;

    public Estudiante() {
    }

    public Estudiante(ArrayList<Curso> cursos_matriculados, String ocupacion, String nombre, String apellido, String genero, String nivel_academico, String password, int id, int edad, Date fecha_nacimiento) {
        super(nombre, apellido, genero, nivel_academico, password, id, edad, fecha_nacimiento);
        this.cursos_matriculados = cursos_matriculados;
        this.ocupacion = ocupacion;
    }

    public ArrayList<Curso> getCursos_matriculados() {
        return cursos_matriculados;
    }

    public void setCursos_matriculados(ArrayList<Curso> cursos_matriculados) {
        this.cursos_matriculados = cursos_matriculados;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante{" + "cursos_matriculados=" + cursos_matriculados + ", ocupacion=" + ocupacion + '}';
    }
    
    
}
