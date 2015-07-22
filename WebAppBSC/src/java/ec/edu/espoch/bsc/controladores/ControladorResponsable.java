/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.entidades.CResponsable;
import ec.edu.espoch.bsc.modelo.MUsuario;
import ec.edu.espoch.bsc.modelo.MResponsable;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class ControladorResponsable implements Serializable {

    private CResponsable objResponsable;
    private CResponsable selObjResponsable;
    private ArrayList<CResponsable> lstResponsables;

    public ControladorResponsable() {
        this.objResponsable = new CResponsable();
        this.selObjResponsable = new CResponsable();
        this.lstResponsables = new ArrayList<>();

    }

    public CResponsable getObjResponsable() {
        return objResponsable;
    }

    public void setObjResponsable(CResponsable objResponsable) {
        this.objResponsable = objResponsable;
    }

    public CResponsable getSelObjResponsable() {
        return selObjResponsable;
    }

    public void setSelObjResponsable(CResponsable selObjResponsable) {
        this.selObjResponsable = selObjResponsable;
    }

    public ArrayList<CResponsable> getLstResponsables() {
        return lstResponsables;
    }

    public void setLstResponsables(ArrayList<CResponsable> lstResponsables) {
        this.lstResponsables = lstResponsables;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {

        cargarResponsable();

    }
    /*
     Metodo que permite cargar todos los registros de la base de datos
     */

    public void cargarResponsable() {
        try {
            this.lstResponsables = (ArrayList<CResponsable>) MResponsable.cargarResponsables();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Insertar Responsable">
    public void insertarResponsable() {
        try {
            if (MResponsable.insertarResponsable(objResponsable)) {
                cargarResponsable();
                DefaultRequestContext.getCurrentInstance().execute("PF('TusuarioCreateDialog').hide()");
                Util.addSuccessMessage("Datos insertados!");
            } else {
                Util.mostrarMensaje("Datos no insertados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="Actualizar Responsable">
    public void actualizarResponsable() {
        try {
            if (MResponsable.actualizarResponsable(selObjResponsable)) {
                cargarResponsable();
                DefaultRequestContext.getCurrentInstance().execute("PF('TusuarioEditDialog').hide()");
                Util.addSuccessMessage("Datos actualizados!");
            } else {
                Util.mostrarMensaje("Datos no actualizados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Eliminar Responsable">
    public void eliminarResponsable() {
        try {
            if (MUsuario.eliminarUsuario(selObjResponsable.getCodigo())) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TusuarioDeleteDialog').hide()");
                Util.addSuccessMessage("Datos eliminados!");
                cargarResponsable();
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>
}
