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
import ec.edu.espoch.bsc.entidades.CUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class MTipoUsuario {

    public static boolean insertarTipoUsuario(CTipoUsuario tipoUsuario) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamTipoUsusario = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_ttipousuario(?)";
            lstParamTipoUsusario.add(new Parametro(1, tipoUsuario.getDescripcion()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamTipoUsusario);
            while (rs.next()) {
                if (rs.getBoolean(0)) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

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
