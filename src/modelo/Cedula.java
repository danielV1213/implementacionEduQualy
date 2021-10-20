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
public class Cedula extends ID{
    String lugar_expedicion, lugar_nacimiento, rh;
    double estatura;    

    public Cedula() {
    }

    public Cedula(String lugar_expedicion, String lugar_nacimiento, String rh, double estatura, String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        super(nombres, apellidos, sexo, numId, fecha_nacimiento, fecha_expedicion);
        this.lugar_expedicion = lugar_expedicion;
        this.lugar_nacimiento = lugar_nacimiento;
        this.rh = rh;
        this.estatura = estatura;
    }

    public String getLugar_expedicion() {
        return lugar_expedicion;
    }

    public void setLugar_expedicion(String lugar_expedicion) {
        this.lugar_expedicion = lugar_expedicion;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return super.toString() + "Cedula{" + "lugar_expedicion=" + lugar_expedicion + ", lugar_nacimiento=" + lugar_nacimiento + ", rh=" + rh + ", estatura=" + estatura + '}';
    }
    
}
