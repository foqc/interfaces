/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.entidades.CTipoUsuario;
import ec.edu.espoch.bsc.modelo.MUsuario;
import ec.edu.espoch.bsc.entidades.CUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import recursos.Util;

/**
 *
 * @author @foqc
 */
@ManagedBean
@ViewScoped
public class ControladorUsuario implements Serializable{

    private CUsuario objUsuario;
    private CUsuario selObjUsuario;
    private ArrayList<CUsuario> lstUsuarios;

    public ControladorUsuario() {
        this.objUsuario = new CUsuario();
        this.lstUsuarios = new ArrayList<>();
        this.selObjUsuario = new CUsuario();
    }

    public CUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(CUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public CUsuario getSelObjUsuario() {
        return selObjUsuario;
    }

    public void setSelObjUsuario(CUsuario selObjUsuario) {
        this.selObjUsuario = selObjUsuario;
    }

    public ArrayList<CUsuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(ArrayList<CUsuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        CTipoUsuario objTipo = new CTipoUsuario();
        this.objUsuario.setObjTipoUsuario(objTipo);
        this.selObjUsuario.setObjTipoUsuario(objTipo);
        cargarUsuario();

    }
    /*
     Metodo que permite cargar todos los registros de la base de datos
     */

    public void cargarUsuario() {
        try {
            this.lstUsuarios = (ArrayList<CUsuario>) MUsuario.cargarUsuarios();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Insertar Usuario">
    public void insertarUsuario() {
        try {
            objUsuario.setClave("12345");
            if (MUsuario.insertarUsuario(objUsuario)) {
                cargarUsuario();
                Util.addSuccessMessage("Datos insertados!");
            } else {
                Util.mostrarMensaje("Datos no insertados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="Actualizar Usuario">
    public void actualizarPersona() {
        try {
            if (MUsuario.actualizarUsuario(selObjUsuario)) {
                cargarUsuario();
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
    //<editor-fold defaultstate="collapsed" desc="Eliminar Usuario">
    public void eliminarPersona() {
        try {
            if (MUsuario.eliminarUsuario(selObjUsuario.getCodigo())) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TusuarioDeleteDialog').hide()");
                Util.addSuccessMessage("Datos eliminados!");
                cargarUsuario();
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>
}
