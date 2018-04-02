package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionesDB {
public String estado="";
//Linea de conexion de Microsoft SQL Server*******************************************************************************************************************
//Autenticacion integrada-------------------------------------------------------------------
public String servidor="jdbc:sqlserver://;database=dome;integratedSecurity=true";
//Autenticacion con usuario y contraseña
//public String String conexion="jdbc:sqlserver://acer1974\\alumno:1433;databaseName=SucursalesVentas;user=sa; password=sasa;";
//*******************************************************************************************************************************
//Linea de conexion de MariaDB MySQL
// variable servidor de tipo String esta compuesta por:
// direccion ip del servidor (en este caso Local host en el puerto 3307)--------------------------------------------> Servidor: jdbc:mariadb://localhost:3307 
// Informacion de base de datos(en este caso/Ventas) usuario (?user=root) contraseña (&password=1234)---------------> /Ventas?user=root&password=1234
//public String servidor="jdbc:mariadb://localhost:3307/Ventas?user=root&password=1234";


    //Declaracion de objeto de tipo Connection (java.sql.Connection) se usara pafra establecer una conexxion con el Gestor de Base de datos
    Connection conexion;
    //Declaracion de objeto de tipo PreparedStatement(java.sql.PreparedStatement) utilizado para hacer sentencias que seran ejecutadas por el gestor de base de datos
    PreparedStatement sentencia;
    
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    /*Metodo que permite comprobar si la conexion con el Gestor de base de datos funciona, tiene un retorno de tipo String que devuelve un mensaje de acuerdo al estado de la conexion
    //Uso: declarar un objeto de esta clase y posteriormente invocar el metodo desde el, almacenando su salida en una variable String y posteriormente imprimir la variable:
    
      ConexionesDB conector;
      String estadoDeConexion;
      estadoDeConexion=conector.probarConexion();
      System.out.printLn(estadoDeConexion);
    */
    public String probarConexion(){
    
    try {
            conexion = DriverManager.getConnection(servidor);
            if (conexion != null) {
                conexion.close();
                estado="Conectado a la base de datos";
            }   
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al conectar a la base de datos, la informacion siguiente puede ayudar a diagnosticar el problema:\n"+ ex);
            estado="No ha sido posible establecer conexión con la base de datos";
        }
        return estado;
    }
    
    
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*Metodo que permite ejecutar una sentencia del Gestor de base de datos , tiene un retorno de tipo String que devuelve un mensaje de acuerdo al resultado de la misma
    //Uso: declarar un objeto de esta clase y posteriormente invocar el metodo desde el,añadir como parametro una variable tipo String que conetenga una sentencia valida de codigo SQL 
    //Almacenar su salida en una variable String y posteriormente imprimir la variable segun se requiera:
    
      ConexionesDB conector;
      String resultado;
      resultado=conector.ejecutarSentencia("codigoSQLaEjecutar");
      System.out.printLn(resultado);
    */
    
    public String ejecutarSentencia(String SQL)
    {
        try {
            conexion = DriverManager.getConnection(servidor);
            if (conexion != null) {
                sentencia = conexion.prepareStatement(SQL);
                sentencia.execute();  
                
                estado="La orden se ha realizado satisfactoriamente";              
            }   
         } catch (SQLException ex) {
                estado="No se ha posido realizar la operacion el error ha sido el siguiente:\n"+ex;
        }   
                return estado;
    }
    
    
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    /*Metodo que permite ejecutar una consulta del Gestor de base de datos, tiene un retorno de tipo Resultset que devuelve el resultado de la consulta ejecutada
    //Uso: declarar un objeto de esta clase y posteriormente invocar el metodo desde el,añadir como parametro una variable tipo String que conetenga una sentencia valida de codigo SQL 
    //Almacenar su salida en una variable ResultSet y posteriormente usarla segun se requiera (puede ser impresa o mostrada en tablas de Swing etc):
    
      ConexionesDB conector;
      ResultSet resultado;
      resultado=resultado.registrar("codigoSQLaEjecutar");
      
    */
     public ResultSet consulta(String SQL)
    {
        ResultSet resultado=null;
        try {
             conexion = DriverManager.getConnection(servidor);   
             Statement sentencia = conexion.createStatement();
             resultado =sentencia.executeQuery(SQL);
                    
        } 
        catch (SQLException ex) 
        {
              JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta con la base de datos:\n"+ex);
        }
        
        return resultado;
}

    //Metodo que permite cerrar 
      public void cerrarConexion()
     {
    try {
        conexion.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"La conexion no se ha podido cerrar "+ex);
    }
     }
    
}
