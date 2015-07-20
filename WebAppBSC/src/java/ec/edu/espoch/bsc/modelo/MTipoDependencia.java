/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.accesodatos.Parametro;
import ec.edu.espoch.bsc.entidades.CTipoDependencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ©foqc
 */
public class MTipoDependencia {
    
    public static boolean insertarTipoDependencia(CTipoDependencia tipoDependencia) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamTipoDependencia = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_ttipodependencia(?)";
            lstParamTipoDependencia.add(new Parametro(1, tipoDependencia.getDescripcion()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamTipoDependencia);
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

    public static List<CTipoDependencia> cargarTipoDependencias() throws Exception {
        List<CTipoDependencia> lstTipoUsuarios = new ArrayList<>();
        try {
            String sql = "select * from bsc.fn_select_ttipodependencia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CTipoDependencia tipoDependencia = new CTipoDependencia();
                tipoDependencia.setCodigo(rs.getInt(0));
                tipoDependencia.setDescripcion(rs.getString(1));

                lstTipoUsuarios.add(tipoDependencia);
            }
            rs = null;
        } catch (Exception e) {
            lstTipoUsuarios.clear();
            throw e;
        }
        return lstTipoUsuarios;
    }

    public static boolean actualizarTipoDependencia(CTipoDependencia tipoDependencia) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamTipoDependencia = new ArrayList<>();
            String sql = "SELECT bsc.fn_update_ttipodependencia(?,?)";
            lstParamTipoDependencia.add(new Parametro(1, tipoDependencia.getCodigo()));
            lstParamTipoDependencia.add(new Parametro(2, tipoDependencia.getDescripcion()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamTipoDependencia);
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

    public static boolean eliminarTipoDependencia(int codigoRol) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select bsc.fn_delete_ttipodependencia(?)";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, codigoRol));

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
