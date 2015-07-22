/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.accesodatos.Parametro;
import java.util.ArrayList;

/**
 *
 * @author Tupac
 */
public class MLogin {

    public static boolean loginUsuario(String usuario, String clave) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * FROM bsc.fn_login_usuario(?,?) ";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, usuario));
            lstParam.add(new Parametro(2, clave));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                respuesta = rs.getBoolean(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

}
