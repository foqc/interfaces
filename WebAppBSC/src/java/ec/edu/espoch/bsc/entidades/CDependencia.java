/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.entidades;

import java.util.Date;

/**
 *
 * @author ©foqc
 */
public class CDependencia {
    private int codigo;
    private String nombre;
    private String vision;
    private Date fechaInicio;
    private Date fechaFin;
    private CVision objVision;
    private CTipoDependencia objTipoDependencia;

    public CDependencia() {
    }

    public CDependencia(int codigo, String nombre, String vision, Date fechaInicio, Date fechaFin, CVision objVision, CTipoDependencia objTipoDependencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.vision = vision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.objVision = objVision;
        this.objTipoDependencia = objTipoDependencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CVision getObjVision() {
        return objVision;
    }

    public void setObjVision(CVision objVision) {
        this.objVision = objVision;
    }

    public CTipoDependencia getObjTipoDependencia() {
        return objTipoDependencia;
    }

    public void setObjTipoDependencia(CTipoDependencia objTipoDependencia) {
        this.objTipoDependencia = objTipoDependencia;
    }
    
    
}
