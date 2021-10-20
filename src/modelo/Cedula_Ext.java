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
public class Cedula_Ext extends ID{
    String nacionalidad, rh;
    Date fecha_vencimiento;
    int num_residente;

    public Cedula_Ext() {
    }

    public Cedula_Ext(String nacionalidad, String rh, Date fecha_vencimiento, int num_residente, String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        super(nombres, apellidos, sexo, numId, fecha_nacimiento, fecha_expedicion);
        this.nacionalidad = nacionalidad;
        this.rh = rh;
        this.fecha_vencimiento = fecha_vencimiento;
        this.num_residente = num_residente;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getNum_residente() {
        return num_residente;
    }

    public void setNum_residente(int num_residente) {
        this.num_residente = num_residente;
    }

    @Override
    public String toString() {
        return super.toString() + "Cedula_Ext{" + "nacionalidad=" + nacionalidad + ", rh=" + rh + ", fecha_vencimiento=" + fecha_vencimiento + ", num_residente=" + num_residente + '}';
    }
    
}
