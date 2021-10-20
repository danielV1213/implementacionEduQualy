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
public class Tarjeta_Pro extends ID{
    int no_matricula;
    String profesion, institucion_asociada; 

    public Tarjeta_Pro() {
    }

    public Tarjeta_Pro(int no_matricula, String profesion, String institucion_asociada, String nombres, String apellidos, String sexo, int numId, Date fecha_nacimiento, Date fecha_expedicion) {
        super(nombres, apellidos, sexo, numId, fecha_nacimiento, fecha_expedicion);
        this.no_matricula = no_matricula;
        this.profesion = profesion;
        this.institucion_asociada = institucion_asociada;
    }

    public int getNo_matricula() {
        return no_matricula;
    }

    public void setNo_matricula(int no_matricula) {
        this.no_matricula = no_matricula;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getInstitucion_asociada() {
        return institucion_asociada;
    }

    public void setInstitucion_asociada(String institucion_asociada) {
        this.institucion_asociada = institucion_asociada;
    }

    @Override
    public String toString() {
        return super.toString() + "Tarjeta_Pro{" + "no_matricula=" + no_matricula + ", profesion=" + profesion + ", institucion_asociada=" + institucion_asociada + '}';
    }
    
}
