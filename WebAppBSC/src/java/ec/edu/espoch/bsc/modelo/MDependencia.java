/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espoch.bsc.modelo;

import ec.edu.espoch.bsc.accesodatos.AccesoDatos;
import ec.edu.espoch.bsc.accesodatos.ConjuntoResultado;
import ec.edu.espoch.bsc.accesodatos.Parametro;
import ec.edu.espoch.bsc.entidades.CDependencia;
import ec.edu.espoch.bsc.entidades.CTipoDependencia;
import ec.edu.espoch.bsc.entidades.CVision;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @foqc
 */
public class MDependencia {

    //Insertar cPersona
    public static boolean insertarDependencia(CDependencia dependencia) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamDependencia = new ArrayList<>();
            String sql = "SELECT bsc.fn_insert_tdependencia(?,?,?,?,?,?)";

            java.sql.Date sqlDateInicio = new java.sql.Date(dependencia.getFechaInicio().getTime());
            java.sql.Date sqlDateFin = new java.sql.Date(dependencia.getFechaInicio().getTime());

            lstParamDependencia.add(new Parametro(1, dependencia.getNombre()));
            lstParamDependencia.add(new Parametro(2, dependencia.getVision()));
            lstParamDependencia.add(new Parametro(3, sqlDateInicio));
            lstParamDependencia.add(new Parametro(4, sqlDateFin));
            lstParamDependencia.add(new Parametro(5, dependencia.getObjVision().getCodigo()));
            lstParamDependencia.add(new Parametro(6, dependencia.getObjTipoDependencia().getCodigo()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamDependencia);
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

    public static List<CDependencia> cargarDependencias() throws Exception {
        List<CDependencia> lstDependencias = new ArrayList<>();
        try {
            String sql = "select * from bsc.fn_select_tdependencia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                CDependencia dependencia = new CDependencia();
                dependencia.setCodigo(rs.getInt(0));
                dependencia.setNombre(rs.getString(1));
                dependencia.setVision(rs.getString(2));
                dependencia.setFechaInicio(rs.getDate(3));
                dependencia.setFechaFin(rs.getDate(4));

                //cargando objeto vision
                //no es necesario recibir una lista ya que busca por codigo y solo devuelve 1 objeto
                List<CVision> objVisiones = MVision.cargarVisionesPorCodigo(rs.getInt(5));
                for (CVision objVision : objVisiones) {
                    dependencia.setObjVision(objVision);
                }
                //cargando objeto tipoDependencia
                //no es necesario recibir una lista ya que busca por codigo y solo devuelve 1 objeto
                List<CTipoDependencia> objCTipoDependencias = MTipoDependencia.cargarTipoDependenciasPorCodigo(rs.getInt(6));
                for (CTipoDependencia objCTipoDependencia : objCTipoDependencias) {
                    dependencia.setObjTipoDependencia(objCTipoDependencia);
                }

                lstDependencias.add(dependencia);
            }
            rs = null;
        } catch (Exception e) {
            lstDependencias.clear();
            throw e;
        }
        return lstDependencias;
    }

    public static boolean actualizarDependencia(CDependencia dependencia) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamDependencia = new ArrayList<>();
            String sql = "SELECT bsc.fn_update_tdependencia(?,?,?,?,?,?,?)";
            java.sql.Date sqlDateInicio = new java.sql.Date(dependencia.getFechaInicio().getTime());
            java.sql.Date sqlDateFin = new java.sql.Date(dependencia.getFechaInicio().getTime());
            
            lstParamDependencia.add(new Parametro(1, dependencia.getCodigo()));
            lstParamDependencia.add(new Parametro(2, dependencia.getNombre()));
            lstParamDependencia.add(new Parametro(3, dependencia.getVision()));
            lstParamDependencia.add(new Parametro(4, sqlDateInicio));
            lstParamDependencia.add(new Parametro(5, sqlDateFin));
            lstParamDependencia.add(new Parametro(6, dependencia.getObjVision().getCodigo()));
            lstParamDependencia.add(new Parametro(7, dependencia.getObjTipoDependencia().getCodigo()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamDependencia);
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
            String sql = "select bsc.fn_delete_tdependencia(?)";
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
