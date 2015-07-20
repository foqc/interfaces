/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.entidades.CTipoDependencia;
import ec.edu.espoch.bsc.modelo.MTipoDependencia;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author @foqc
 */
@ManagedBean
@ViewScoped
public class ControladorTipoDependencia implements Serializable{

    private CTipoDependencia objTipoDependencia;
    private CTipoDependencia selObjTipoDependencia;
    private ArrayList<CTipoDependencia> lstTipoDependencias;

    /**
     * Creates a new instance of ControladorTipoUsuario
     */
    public ControladorTipoDependencia() {
        this.objTipoDependencia = new CTipoDependencia();
        this.selObjTipoDependencia = new CTipoDependencia();
        this.lstTipoDependencias = new ArrayList<>();
    }

    public CTipoDependencia getObjTipoDependencia() {
        return objTipoDependencia;
    }

    public void setObjTipoDependencia(CTipoDependencia objTipoDependencia) {
        this.objTipoDependencia = objTipoDependencia;
    }

    public CTipoDependencia getSelObjTipoDependencia() {
        return selObjTipoDependencia;
    }

    public void setSelObjTipoDependencia(CTipoDependencia selObjTipoDependencia) {
        this.selObjTipoDependencia = selObjTipoDependencia;
    }

    public ArrayList<CTipoDependencia> getLstTipoDependencias() {
        return lstTipoDependencias;
    }

    public void setLstTipoDependencias(ArrayList<CTipoDependencia> lstTipoDependencias) {
        this.lstTipoDependencias = lstTipoDependencias;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        cargarTipoDependencia();

    }

    public void cargarTipoDependencia() {
        try {
            this.lstTipoDependencias = (ArrayList<CTipoDependencia>) MTipoDependencia.cargarTipoDependencias();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Insertar Rol">
    public void insertarTipoDependencia() {
        try {
            if (MTipoDependencia.insertarTipoDependencia(objTipoDependencia)) {
                Util.addSuccessMessage("Datos Insertados!");
                cargarTipoDependencia();

            } else {
                Util.mostrarMensaje("Datos no insertados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Actualizar Rol">
    public void actualizarTipoDependencia() {
        try {
            if (MTipoDependencia.actualizarTipoDependencia(selObjTipoDependencia)) {
                cargarTipoDependencia();
                DefaultRequestContext.getCurrentInstance().execute("PF('TtipodependenciaEditDialog').hide()");
                Util.addSuccessMessage("Datos actualizados!");                
            } else {
                Util.mostrarMensaje("Datos no actualizados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
     //</editor-fold>

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Eliminar Rol">
    public void eliminarTipoDependencia() {
        try {
            if (MTipoDependencia.eliminarTipoDependencia(selObjTipoDependencia.getCodigo())) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TtipodependenciaDeleteDialog').hide()");
                Util.addSuccessMessage("Datos eliminados!");
                cargarTipoDependencia();
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>
}
