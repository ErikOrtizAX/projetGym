/*
Este programa fue creado como proyecto escolar
para la materia de Teoria de sistemas 
Universidad Autonoma del Estado de México UAEM
exclusivo por parte de los alumnos:
Melchor Gaspar Juan Manuel
Moreno Pacheco Luis Antonio
Ortiz Duarte Erik Isaias
Suárez Nava Daniel
Rojas Romo Javier Emmanuel
 */
package gym;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Erik
 */
public class conexion {
    
            
    Connection conexion=null;
    public Connection conectar(){
        String user="root";
        String password = "";
        String url ="jdbc:mysql://localhost/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
  
    
    public ResultSet consulta(String sql){
        ResultSet res=null;
        try{
            PreparedStatement psmt = conexion.prepareStatement(sql);
            res = psmt.executeQuery();
        }catch(SQLException ex){
            System.err.println("error de consulta : "+ex.getMessage());
        }
        return res;
    }
    
    public DefaultComboBoxModel objeto(){
        DefaultComboBoxModel lista = new DefaultComboBoxModel();
        lista.addElement("selecione actividad");
        ResultSet res = this.consulta("select * from actividad order by actividad");
        try{
            while(res.next()){
                lista.addElement(res.getString("actividad"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println("error de consulta : "+ex.getMessage());
        }
        return lista;
    }
}
