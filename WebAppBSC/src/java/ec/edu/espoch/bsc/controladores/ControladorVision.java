/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.entidades.CVision;
import ec.edu.espoch.bsc.modelo.MVision;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class ControladorVision implements Serializable {
    
    private CVision objVision;
    private CVision selObjVision;
    private ArrayList<CVision> lstVision;
    
    public ControladorVision() {
        this.objVision = new CVision();
        this.selObjVision = new CVision();
        this.lstVision = new ArrayList<>();
        
        this.objVision.setFecha(new Date());
    }
    
    public CVision getObjVision() {
        return objVision;
    }
    
    public void setObjVision(CVision objVision) {
        this.objVision = objVision;
    }
    
    public CVision getSelObjVision() {
        return selObjVision;
    }
    
    public void setSelObjVision(CVision selObjVision) {
        this.selObjVision = selObjVision;
    }
    
    public ArrayList<CVision> getLstVision() {
        return lstVision;
    }
    
    public void setLstVision(ArrayList<CVision> lstVision) {
        this.lstVision = lstVision;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        cargarVision();
        
    }
    
    public void cargarVision() {
        try {
            this.lstVision = (ArrayList<CVision>) MVision.cargarVisiones();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Insertar Rol">
    public void insertarVision() {
        try {
            
            if (MVision.insertarVision(objVision)) {
                Util.addSuccessMessage("Datos Insertados!");
                cargarVision();
                
            } else {
                Util.mostrarMensaje("Datos no insertados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Actualizar Rol">
    public void actualizarVision() {
        try {
            selObjVision.setFecha(objVision.getFecha());
            if (MVision.actualizarVision(selObjVision)) {
                cargarVision();
                DefaultRequestContext.getCurrentInstance().execute("PF('TvisionEditDialog').hide()");
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
    public void eliminarVision() {
        try {
            if (MVision.eliminarVision(selObjVision.getCodigo())) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TvisionDeleteDialog').hide()");
                Util.addSuccessMessage("Datos eliminados!");
                cargarVision();
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>
}
