/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.accesodatos.Parametro;
import ec.edu.espoch.bsc.entidades.CTipoUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class MTipoUsuario {
    
    public static List<CTipoUsuario> cargarTipoUsuarios() throws Exception {
        List<CTipoUsuario> lstTipoUsuarios = new ArrayList<>();
        try {
            String sql = "select * from bsc.fn_select_ttipousuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CTipoUsuario tipoUsuario = new CTipoUsuario();
                tipoUsuario.setCodigo(rs.getInt(0));
                tipoUsuario.setDescripcion(rs.getString(1));

                lstTipoUsuarios.add(tipoUsuario);
            }
            rs = null;
        } catch (Exception e) {
            lstTipoUsuarios.clear();
            throw e;
        }
        return lstTipoUsuarios;
    }
}
