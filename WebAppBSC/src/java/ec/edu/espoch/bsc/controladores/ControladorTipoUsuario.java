/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.entidades.CTipoUsuario;
import ec.edu.espoch.bsc.modelo.MTipoUsuario;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class ControladorTipoUsuario {

    private CTipoUsuario objTipoUsuario;
    private CTipoUsuario selObjTipoUsuario;
    private ArrayList<CTipoUsuario> lstTipoUsuarios;

    /**
     * Creates a new instance of ControladorTipoUsuario
     */
    public ControladorTipoUsuario() {
        this.objTipoUsuario = new CTipoUsuario();
        this.selObjTipoUsuario = new CTipoUsuario();
        this.lstTipoUsuarios = new ArrayList<>();
    }

    public CTipoUsuario getObjTipoUsuario() {
        return objTipoUsuario;
    }

    public void setObjTipoUsuario(CTipoUsuario objTipoUsuario) {
        this.objTipoUsuario = objTipoUsuario;
    }

    public CTipoUsuario getSelObjTipoUsuario() {
        return selObjTipoUsuario;
    }

    public void setSelObjTipoUsuario(CTipoUsuario selObjTipoUsuario) {
        this.selObjTipoUsuario = selObjTipoUsuario;
    }

    public ArrayList<CTipoUsuario> getLstTipoUsuarios() {
        return lstTipoUsuarios;
    }

    public void setLstTipoUsuarios(ArrayList<CTipoUsuario> lstTipoUsuarios) {
        this.lstTipoUsuarios = lstTipoUsuarios;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        cargarTipoUsuario();

    }

    public void cargarTipoUsuario() {
        try {
            this.lstTipoUsuarios = (ArrayList<CTipoUsuario>) MTipoUsuario.cargarTipoUsuarios();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Insertar Rol">
    public void insertarTipoUsuario() {
        try {
            if (MTipoUsuario.insertarTipoUsuario(objTipoUsuario)) {
                DefaultRequestContext.getCurrentInstance().execute("PF('wgRolInsertar').hide()");
                Util.addSuccessMessage("Datos Insertados");
                cargarTipoUsuario();

            } else {
                Util.mostrarMensaje("Datos no insertados");
            }
            objTipoUsuario = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>    

    
    //<editor-fold defaultstate="collapsed" desc="Actualizar Usuario">
   public void actualizarTipoPersona() {
        try {
            if (MTipoUsuario.actualizarTipoUsuario(selObjTipoUsuario)) {
                DefaultRequestContext.getCurrentInstance().execute("PF('wgEditarRol').hide()");
                Util.addSuccessMessage("Datos actualizados");
                cargarTipoUsuario();
            } else {
                Util.mostrarMensaje("Datos no actualizados");
            }
            selObjTipoUsuario = null;
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
     //</editor-fold>
}
