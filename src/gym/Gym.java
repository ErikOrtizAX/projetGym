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
import javax.swing.JOptionPane;


/**
 *
 * @author Erik
 */
public class Gym{
 
    public static void main(String[] args) throws InterruptedException {//Metodo principal
        Runtime aplicacion = Runtime.getRuntime(); // variable para ejecutar el cmd
        splash pass=new splash(); //constructor del splash inicial
        actualizar ac = new actualizar(); //constructor de funciones de actualizacion
        ac.Directorio(); //generamos directorio con el archivo .bat y las instrucciones en caso de el primer inicio o algun error posterior
        pass.setVisible(true); //mostramos el splash inicial
        try{
            aplicacion.exec("cmd.exe /k C:/recursos/ejecutar.bat /s");// instruccion para ejecutar archivo ejecutar .bat
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);//se muestra el error si lo hay
        }
        Thread.sleep(20000);// tiempo de espera para levantar la base de datos
        pass.setVisible(false); // cerramos el splash inicial una vez terminado el tiempo
        ac.actual();//llama a actual para actualizar las membresias de la base de datos
        new sesion().setVisible(true); //mostramos el login inicial
        
    }       
    
}
    
    

