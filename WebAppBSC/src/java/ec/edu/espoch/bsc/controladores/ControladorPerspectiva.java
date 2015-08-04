/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.entidades.CPerspectiva;
import ec.edu.espoch.bsc.modelo.MPerspectiva;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class ControladorPerspectiva implements Serializable {

    private CPerspectiva objPespectiva;
    private CPerspectiva selObjPerspectiva;
    private ArrayList<CPerspectiva> lstPerspectivas;

    /**
     * Creates a new instance of ControladorPerspectiva
     */
    public ControladorPerspectiva() {
        this.objPespectiva = new CPerspectiva();
        this.selObjPerspectiva = new CPerspectiva();
        this.lstPerspectivas = new ArrayList<>();
    }

    public CPerspectiva getObjPespectiva() {
        return objPespectiva;
    }

    public void setObjPespectiva(CPerspectiva objPespectiva) {
        this.objPespectiva = objPespectiva;
    }

    public CPerspectiva getSelObjPerspectiva() {
        return selObjPerspectiva;
    }

    public void setSelObjPerspectiva(CPerspectiva selObjPerspectiva) {
        this.selObjPerspectiva = selObjPerspectiva;
    }

    public ArrayList<CPerspectiva> getLstPerspectivas() {
        return lstPerspectivas;
    }

    public void setLstPerspectivas(ArrayList<CPerspectiva> lstPerspectivas) {
        this.lstPerspectivas = lstPerspectivas;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {

        cargarPerspectiva();

    }
    /*
     Metodo que permite cargar todos los registros de la base de datos
     */

    public void cargarPerspectiva() {
        try {
            this.lstPerspectivas = (ArrayList<CPerspectiva>) MPerspectiva.cargarPerspectivas();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

}
