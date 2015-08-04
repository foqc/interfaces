/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.entidades;

import java.sql.Date;

/**
 *
 * @author User
 */
public class CPerspectiva {

    private int codigo;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int porcentaje;
    private int bsc;

    public CPerspectiva() {
    }

    public CPerspectiva(int codigo, String nombre, String descripcion, Date fecha, int porcentaje, int bsc) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.porcentaje = porcentaje;
        this.bsc = bsc;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getBsc() {
        return bsc;
    }

    public void setBsc(int bsc) {
        this.bsc = bsc;
    }

}
