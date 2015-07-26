/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import ec.edu.espoch.bsc.entidades.CTipoDependencia;
import ec.edu.espoch.bsc.modelo.MTipoDependencia;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author ©foqc
 */
@ManagedBean
@RequestScoped
public class tipoDependenciaItemsBean {

    private List<SelectItem> selectOneItemsTipoDependencia;

    /**
     * Creates a new instance of tipoDependenciaItemsBean
     */
    public tipoDependenciaItemsBean() {
    }

    public List<SelectItem> getSelectOneItemsTipoDependencia() {
        try {
            this.selectOneItemsTipoDependencia = new ArrayList<>();
            List<CTipoDependencia> tipoDependencias = MTipoDependencia.cargarTipoDependencias();
            for (CTipoDependencia tipoDependencia : tipoDependencias) {
                SelectItem selectItem = new SelectItem(tipoDependencia.getCodigo(), tipoDependencia.getDescripcion());
                this.selectOneItemsTipoDependencia.add(selectItem);
            }
        } catch (Exception e) {
            System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
        }
        return this.selectOneItemsTipoDependencia;
    }

}
