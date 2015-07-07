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

/**
 *
 * @author root
 */
public class MTipoUsuario {
    public static boolean insertarPersona(CTipoUsuario tipoUusuario) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamTipoUsusario = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_ttipousuario(?)";
            lstParamTipoUsusario.add(new Parametro(1, tipoUusuario.getDescripcion()));

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
}
