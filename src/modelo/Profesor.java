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
public class Profesor extends Persona{
    
    int anios_experiencia;
    ArrayList<Curso>cursos_dictados;
    String area_academica;

    public Profesor() {
    }

    public Profesor(int anios_experiencia, ArrayList<Curso> cursos_dictados, String area_academica, String nombre, String apellido, String genero, String nivel_academico, String password, int id, int edad, Date fecha_nacimiento) {
        super(nombre, apellido, genero, nivel_academico, password, id, edad, fecha_nacimiento);
        this.anios_experiencia = anios_experiencia;
        this.cursos_dictados = cursos_dictados;
        this.area_academica = area_academica;
    }

    public int getAnios_experiencia() {
        return anios_experiencia;
    }

    public void setAnios_experiencia(int anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
    }

    public ArrayList<Curso> getCursos_dictados() {
        return cursos_dictados;
    }

    public void setCursos_dictados(ArrayList<Curso> cursos_dictados) {
        this.cursos_dictados = cursos_dictados;
    }

    public String getArea_academica() {
        return area_academica;
    }

    public void setArea_academica(String area_academica) {
        this.area_academica = area_academica;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor{" + "anios_experiencia=" + anios_experiencia + ", cursos_dictados=" + cursos_dictados + ", area_academica=" + area_academica + '}';
    }
    
}
