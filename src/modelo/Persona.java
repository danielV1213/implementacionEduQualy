/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Persona {
    
    protected String nombre, apellido, genero, nivel_academico, password;
    protected int id, edad;
    protected Date fecha_nacimiento;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String genero, String nivel_academico, String password, int id, int edad, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.nivel_academico = nivel_academico;
        this.password = password;
        this.id = id;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", nivel_academico=" + nivel_academico + ", password=" + password + ", id=" + id + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
}