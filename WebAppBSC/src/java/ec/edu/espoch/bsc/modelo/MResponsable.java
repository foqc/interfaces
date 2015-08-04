/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.accesodatos.Parametro;
import ec.edu.espoch.bsc.entidades.CResponsable;
import ec.edu.espoch.bsc.entidades.CTipoUsuario;
import ec.edu.espoch.bsc.entidades.CUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @foqc
 */
public class MResponsable {

    //Insertar cPersona
    public static boolean insertarResponsable(CResponsable responsable) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamUsusario = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_tresponsable(?,?,?,?,?,?,?,?)";
            lstParamUsusario.add(new Parametro(1, responsable.getCedula()));
            lstParamUsusario.add(new Parametro(2, responsable.getNombres()));
            lstParamUsusario.add(new Parametro(3, responsable.getApellidos()));
            lstParamUsusario.add(new Parametro(4, responsable.getTelefono()));
            lstParamUsusario.add(new Parametro(5, responsable.getCelular()));
            lstParamUsusario.add(new Parametro(6, responsable.getCorreo()));
            lstParamUsusario.add(new Parametro(7, responsable.getDireccion()));
            lstParamUsusario.add(new Parametro(8, responsable.getNivelacademico()));

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

    public static boolean actualizarResponsable(CResponsable responsable) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamUsusario = new ArrayList<>();
            String sql = "SELECT bsc.fn_update_tresponsable(?,?,?,?,?,?,?,?,?)";
            lstParamUsusario.add(new Parametro(1, responsable.getCodigo()));
            lstParamUsusario.add(new Parametro(2, responsable.getCedula()));
            lstParamUsusario.add(new Parametro(3, responsable.getNombres()));
            lstParamUsusario.add(new Parametro(4, responsable.getApellidos()));
            lstParamUsusario.add(new Parametro(5, responsable.getTelefono()));
            lstParamUsusario.add(new Parametro(6, responsable.getCelular()));
            lstParamUsusario.add(new Parametro(7, responsable.getCorreo()));
            lstParamUsusario.add(new Parametro(8, responsable.getDireccion()));
            lstParamUsusario.add(new Parametro(9, responsable.getNivelacademico()));

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

    public static boolean eliminarResponsable(int codigoPersona) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "select bsc.fn_delete_tresponsable(?)";
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

    public static List<CResponsable> cargarResponsables() throws Exception {
        List<CResponsable> lstResponsables = new ArrayList<>();
        try {
            String sql = "select *from bsc.fn_select_tresponsable()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CResponsable responsable = new CResponsable();
                responsable.setCodigo(rs.getInt(0));
                responsable.setCedula(rs.getString(1));
                responsable.setNombres(rs.getString(2));
                responsable.setApellidos(rs.getString(3));
                responsable.setTelefono(rs.getString(4));
                responsable.setCelular(rs.getString(4));
                responsable.setCorreo(rs.getString(6));
                responsable.setDireccion(rs.getString(7));
                responsable.setNivelacademico(rs.getString(8));
                lstResponsables.add(responsable);
            }
            rs = null;
        } catch (Exception e) {
            lstResponsables.clear();
            throw e;
        }
        return lstResponsables;
    }

}
