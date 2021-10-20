/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Curso {
    String nombre, docente_asociado, modalidad;
    int codigo, duracion_horas;
    ArrayList<Estudiante> estudiantes_matriculados;

    public Curso() {
    }

    public Curso(String nombre, String docente_asociado, String modalidad, int codigo, int duracion_horas, ArrayList<Estudiante> estudiantes_matriculados) {
        this.nombre = nombre;
        this.docente_asociado = docente_asociado;
        this.modalidad = modalidad;
        this.codigo = codigo;
        this.duracion_horas = duracion_horas;
        this.estudiantes_matriculados = estudiantes_matriculados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente_asociado() {
        return docente_asociado;
    }

    public void setDocente_asociado(String docente_asociado) {
        this.docente_asociado = docente_asociado;
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

    public ArrayList<Estudiante> getEstudiantes_matriculados() {
        return estudiantes_matriculados;
    }

    public void setEstudiantes_matriculados(ArrayList<Estudiante> estudiantes_matriculados) {
        this.estudiantes_matriculados = estudiantes_matriculados;
    }

    @Override
    public String toString() {
        return "Curso{" + "nombre=" + nombre + ", docente_asociado=" + docente_asociado + ", modalidad=" + modalidad + ", codigo=" + codigo + ", duracion_horas=" + duracion_horas + ", estudiantes_matriculados=" + estudiantes_matriculados + '}';
    }
}
