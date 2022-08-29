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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Erik
 */
public class actualizar {
    
    public void actual(){
        conexion cc=new conexion(); // constructor de la conexion a la base de datos
        Connection con = cc.conectar(); //iniciamos la conexion
        String sql1="";
        try {
                PreparedStatement pst1; //preparamos la variable que contendra la consulta 
                sql1="update membresia set status = 'Inactivo' where vencimiento < now() or vencimiento <= now();" ;
                pst1 = con.prepareStatement(sql1);
                pst1.executeUpdate();
                
             
        } catch (SQLException ex) {
                Logger.getLogger(regismem.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void Directorio() {

        File directorio = new File("C:/recursos");
        try {
            String ruta = "C:/recursos/ejecutar.bat";
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }
            String contenido = "@echo off\n" +"\n" +"start C:\\wamp64\\wampmanager.exe";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
