/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import GUI.MenuGrafico;
import domain.ConexionesDB;


public class Main {
    
    public static void main(String[] args) {
        
        ConexionesDB conector = new ConexionesDB();
        String estadoDeConexion = null;
        estadoDeConexion = conector.probarConexion();
        System.out.println(estadoDeConexion);
        
        //String orden = "insert into prueba values(" + 3 +",'Marcelo'" + ",'Sanchez')";
        //String devuelveOrden = conector.ejecutarSentencia(orden);
        //System.out.println(devuelveOrden);
        
        String orden2 = "delete * from prueba where idprueba =1";
        String devuelveOrden = conector.ejecutarSentencia(orden2);
        
        
        //MenuGrafico menuGui = new MenuGrafico();
        //menuGui.setVisible(true);
        
    }
    
}
