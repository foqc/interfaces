/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.controladores;

import ec.edu.espoch.bsc.modelo.MDependencia;
import ec.edu.espoch.bsc.entidades.CDependencia;
import ec.edu.espoch.bsc.entidades.CTipoDependencia;
import ec.edu.espoch.bsc.entidades.CVision;
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
public class ControladorDependencia implements Serializable{

    private CDependencia objDependencia;
    private CDependencia selObjDependencia;
    private ArrayList<CDependencia> lstDependencias;

    public ControladorDependencia() {
        this.objDependencia = new CDependencia();
        this.lstDependencias = new ArrayList<>();
        this.selObjDependencia = new CDependencia();
        this.objDependencia.setFechaInicio(new Date());
    }

    public CDependencia getObjDependencia() {
        return objDependencia;
    }

    public void setObjDependencia(CDependencia objDependencia) {
        this.objDependencia = objDependencia;
    }

    public CDependencia getSelObjDependencia() {
        return selObjDependencia;
    }

    public void setSelObjDependencia(CDependencia selObjDependencia) {
        this.selObjDependencia = selObjDependencia;
    }

    public ArrayList<CDependencia> getLstDependencias() {
        return lstDependencias;
    }

    public void setLstDependencias(ArrayList<CDependencia> lstDependencias) {
        this.lstDependencias = lstDependencias;
    }

   

    /*
     postonstructor se ejecuta luego del constructor
     */
    @PostConstruct
    public void reinit() {
        //si no inicio los estos objetos no puedo leer los atributos de un objeto que esta dentro de otro objeto.
        CVision objVision = new CVision();
        this.objDependencia.setObjVision(objVision);
        this.selObjDependencia.setObjVision(objVision);
        
        CTipoDependencia objCTipoDependencia=new CTipoDependencia();
        this.objDependencia.setObjTipoDependencia(objCTipoDependencia);
        this.selObjDependencia.setObjTipoDependencia(objCTipoDependencia);
        cargarDependencias();

    }
    /*
     Metodo que permite cargar todos los registros de la base de datos
     */

    public void cargarDependencias() {
        try {
            this.lstDependencias = (ArrayList<CDependencia>) MDependencia.cargarDependencias();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Insertar Dependencia">
    public void insertarDependencia() {
        try {
            if (MDependencia.insertarDependencia(objDependencia)) {
                cargarDependencias();
                Util.addSuccessMessage("Datos insertados!");
            } else {
                Util.mostrarMensaje("Datos no insertados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="Actualizar Dependencia">
    public void actualizarDependencia() {
        try {
            if (MDependencia.actualizarDependencia(selObjDependencia)) {
                cargarDependencias();
                DefaultRequestContext.getCurrentInstance().execute("PF('TdependenciaEditDialog').hide()");
                Util.addSuccessMessage("Datos actualizados!");                
            } else {
                Util.mostrarMensaje("Datos no actualizados!");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Eliminar Dependencia">
    public void eliminarDependencia() {
        try {
            if (MDependencia.eliminarUsuario(selObjDependencia.getCodigo())) {
                DefaultRequestContext.getCurrentInstance().execute("PF('TdependenciaDeleteDialog').hide()");
                Util.addSuccessMessage("Datos eliminados!");
                cargarDependencias();
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    //</editor-fold>
}
