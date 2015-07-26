/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import ec.edu.espoch.bsc.entidades.CVision;
import ec.edu.espoch.bsc.modelo.MVision;
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
public class VisionItemsBean {

    private List<SelectItem> selectOneItemsVision;

    /**
     * Creates a new instance of VisionItemsBean
     */
    public VisionItemsBean() {
    }
    
    public List<SelectItem> getSelectOneItemsVision() {
        try {
            this.selectOneItemsVision = new ArrayList<>();
            List<CVision> visiones = MVision.cargarVisiones();
            for (CVision vision : visiones) {
                SelectItem selectItem = new SelectItem(vision.getCodigo(), vision.getDescripcion());
                this.selectOneItemsVision.add(selectItem);
            }
        } catch (Exception e) {
            System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
        }
        return this.selectOneItemsVision;
    }
}
