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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class MUsuario {

    //Insertar cPersona
    public static boolean insertarUsuario(CUsuario usuario) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamUsusario = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_tusuario(?,?,?,?,?,?,?,?,?,?)";
            lstParamUsusario.add(new Parametro(1, usuario.getCedula()));
            lstParamUsusario.add(new Parametro(2, usuario.getNombres()));
            lstParamUsusario.add(new Parametro(3, usuario.getApellidos()));
            lstParamUsusario.add(new Parametro(4, usuario.getAlias()));
            lstParamUsusario.add(new Parametro(5, usuario.getClave()));
            lstParamUsusario.add(new Parametro(6, usuario.getTelefono()));
            lstParamUsusario.add(new Parametro(7, usuario.getCelular()));
            lstParamUsusario.add(new Parametro(8, usuario.getCorreo()));
            lstParamUsusario.add(new Parametro(9, usuario.getDireccion()));
            lstParamUsusario.add(new Parametro(10, usuario.getObjTipoUsuario().getCodigo()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamUsusario);
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

    public static List<CUsuario> cargarUsuarios() throws Exception {
        List<CUsuario> lstUsuarios = new ArrayList<>();
        try {
            String sql = "select * from bsc.fn_select_tusuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CUsuario usuario = new CUsuario();
                usuario.setCodigo(rs.getInt(1));
                usuario.setCedula(rs.getString(2));
                usuario.setNombres(rs.getString(3));
                usuario.setApellidos(rs.getString(4));
                usuario.setAlias(rs.getString(5));
                usuario.setClave(rs.getString(6));
                usuario.setTelefono(rs.getString(7));
                usuario.setCelular(rs.getString(8));
                usuario.setCorreo(rs.getString(9));
                usuario.setDireccion(rs.getString(10));

                CTipoUsuario objTipoUsuario = new CTipoUsuario();
                objTipoUsuario.setDescripcion(rs.getString(11));

                usuario.setObjTipoUsuario(objTipoUsuario);

                lstUsuarios.add(usuario);
            }
            rs = null;
        } catch (Exception e) {
            lstUsuarios.clear();
            throw e;
        }
        return lstUsuarios;
    }

    public static boolean actualizarUsuario(CUsuario usuario) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamUsusario = new ArrayList<>();
            String sql = "SELECT bsc.fn_update_tusuario(?,?,?,?,?,?,?,?,?,?)";
            lstParamUsusario.add(new Parametro(1, usuario.getCedula()));
            lstParamUsusario.add(new Parametro(2, usuario.getNombres()));
            lstParamUsusario.add(new Parametro(3, usuario.getApellidos()));
            lstParamUsusario.add(new Parametro(4, usuario.getAlias()));
            lstParamUsusario.add(new Parametro(5, usuario.getClave()));
            lstParamUsusario.add(new Parametro(6, usuario.getTelefono()));
            lstParamUsusario.add(new Parametro(7, usuario.getCelular()));
            lstParamUsusario.add(new Parametro(8, usuario.getCorreo()));
            lstParamUsusario.add(new Parametro(9, usuario.getDireccion()));
            lstParamUsusario.add(new Parametro(10, usuario.getObjTipoUsuario().getCodigo()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamUsusario);
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

    public static boolean eliminarUsuario(int codigoPersona) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select hojadevida.fn_delete_tpersona(?)";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, codigoPersona));

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
