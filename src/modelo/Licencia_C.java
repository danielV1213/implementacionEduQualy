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
public class Licencia_C extends ID{
    String rh, restricciones, organismo_asociado;

    public Licencia_C() {
    }

    public Licencia_C(String rh, String restricciones, String organismo_asociado, String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        super(nombres, apellidos, sexo, numId, fecha_nacimiento, fecha_expedicion);
        this.rh = rh;
        this.restricciones = restricciones;
        this.organismo_asociado = organismo_asociado;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getOrganismo_asociado() {
        return organismo_asociado;
    }

    public void setOrganismo_asociado(String organismo_asociado) {
        this.organismo_asociado = organismo_asociado;
    }

    @Override
    public String toString() {
        return super.toString() + "Licencia_C{" + "rh=" + rh + ", restricciones=" + restricciones + ", organismo_asociado=" + organismo_asociado + '}';
    }
    
}
