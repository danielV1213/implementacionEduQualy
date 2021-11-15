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
public class ID {
    private String nombres, apellidos, sexo;
    private int numId;
    private Date fecha_nacimiento, fecha_expedicion;

    public ID() {
    }

    public ID(String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.numId = numId;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_expedicion = fecha_expedicion;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(Date fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }

    @Override
    public String toString() {
        return "ID{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + ", numId=" + numId + ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_expedicion=" + fecha_expedicion + '}';
    }
    
}
