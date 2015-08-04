/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.entidades.CPerspectiva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class MPerspectiva {
//<editor-fold defaultstate="collapsed" desc="Listar Perspectivas">    

    public static List<CPerspectiva> cargarPerspectivas() throws Exception {
        List<CPerspectiva> lstPerspectivas = new ArrayList<>();
        try {
            String sql = "select *from bsc.fn_select_tperspectiva()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CPerspectiva obj = new CPerspectiva();
                obj.setCodigo(rs.getInt(0));
                obj.setNombre(rs.getString(1));
                obj.setDescripcion(rs.getString(2));
                obj.setFecha(rs.getDate(3));
                obj.setPorcentaje(rs.getInt(4));
                obj.setBsc(rs.getInt(5));

                lstPerspectivas.add(obj);
            }
            rs = null;
        } catch (Exception e) {
            lstPerspectivas.clear();
            throw e;
        }
        return lstPerspectivas;
    }
//</editor-fold>

}
