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
public class Tarjeta_ID extends ID{
    String lugar_nacimiento, rh, lugar_expedicion;

    public Tarjeta_ID() {
    }

    public Tarjeta_ID(String lugar_nacimiento, String rh, String lugar_expedicion, String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        super(nombres, apellidos, sexo, numId, fecha_nacimiento, fecha_expedicion);
        this.lugar_nacimiento = lugar_nacimiento;
        this.rh = rh;
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

    public String getLugar_expedicion() {
        return lugar_expedicion;
    }

    public void setLugar_expedicion(String lugar_expedicion) {
        this.lugar_expedicion = lugar_expedicion;
    }

    @Override
    public String toString() {
        return super.toString() + "Tarjeta_ID{" + "lugar_nacimiento=" + lugar_nacimiento + ", rh=" + rh + ", lugar_expedicion=" + lugar_expedicion + '}';
    }
}
