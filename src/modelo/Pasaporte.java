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
public class Pasaporte extends ID{
    String lugar_nacimiento, nacionalidad;

    public Pasaporte() {
    }

    public Pasaporte(String lugar_nacimiento, String nacionalidad, String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        super(nombres, apellidos, sexo, numId, fecha_nacimiento, fecha_expedicion);
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return super.toString() + "Pasaporte{" + "lugar_nacimiento=" + lugar_nacimiento + ", nacionalidad=" + nacionalidad + '}';
    }
    
}
