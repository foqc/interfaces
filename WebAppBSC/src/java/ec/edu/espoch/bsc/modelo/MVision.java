/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.accesodatos.Parametro;
import ec.edu.espoch.bsc.entidades.CVision;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ©foqc
 */
public class MVision {

    public static boolean insertarVision(CVision vision) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamVision = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_tvision(?,?)";
            
            java.sql.Date sqlDate = new java.sql.Date(vision.getFecha().getTime());

            lstParamVision.add(new Parametro(1, vision.getDescripcion()));
            lstParamVision.add(new Parametro(2, sqlDate));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamVision);
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

    public static List<CVision> cargarVisiones() throws Exception {
        List<CVision> lstTipoUsuarios = new ArrayList<>();
        try {
            String sql = "select * from bsc.fn_select_tvision()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CVision vision = new CVision();
                vision.setCodigo(rs.getInt(0));
                vision.setDescripcion(rs.getString(1));
                vision.setFecha(rs.getDate(2));

                lstTipoUsuarios.add(vision);
            }
            rs = null;
        } catch (Exception e) {
            lstTipoUsuarios.clear();
            throw e;
        }
        return lstTipoUsuarios;
    }

    public static boolean actualizarVision(CVision vision) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamVision = new ArrayList<>();
            String sql = "SELECT bsc.fn_update_tvision(?,?,?)";
            
            java.sql.Date sqlDate = new java.sql.Date(vision.getFecha().getTime());
            
            lstParamVision.add(new Parametro(1, vision.getCodigo()));
            lstParamVision.add(new Parametro(2, vision.getDescripcion()));
            lstParamVision.add(new Parametro(3, sqlDate));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamVision);
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

    public static boolean eliminarVision(int codigo) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select bsc.fn_delete_tvision(?)";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, codigo));

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
