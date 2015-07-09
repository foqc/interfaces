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
        this.objTipoUsuario=new CTipoUsuario();
        this.selObjTipoUsuario=new CTipoUsuario();
        this.lstTipoUsuarios=new ArrayList<>();
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
    
}
