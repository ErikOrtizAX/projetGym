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

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erik
 */
public class updateCLI extends javax.swing.JFrame {

    /**
     * Creates new form update
     */
    conexion cc=new conexion();
    Connection con = cc.conectar();
    conexion cos = new conexion();
    int numero=0;
    public updateCLI() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/Recurso 2.png")).getImage());
    }
    public void actualizar(){
        
         String sql="update CLIENTE set nombre='"+idc1.getText()+"', ap_p='"+actividad1.getText()+"', ap_m='"+actividad2.getText()+"', sexo='"+stado.getText()+"' where id_cliente='"+bust.getText()+"'";
         try{
             PreparedStatement pst=con.prepareStatement(sql);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "registro modificado");
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "error: "+e.getMessage());
             
         } 
         try{
            DefaultTableModel modelo = new DefaultTableModel();
            tablac.setModel(modelo);
            PreparedStatement ps=null;
            ResultSet rs=null;
            conexion conn = new conexion();
            Connection con=conn.conectar();
            
            sql="SELECT * FROM cliente where id_cliente='"+bust.getText()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantcol=rsmd.getColumnCount();
            modelo.addColumn("ID Cliente");
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("sexo");
            
            while (rs.next()) {
                Object[] filas = new Object[cantcol];
                for (int i = 0; i < cantcol; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
        idm.setText("");
        idc1.setText("");
        actividad1.setText("");
        actividad2.setText("");
        stado.setText("");
        idc1.setText("");
    }
    public void buscar(){
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            tablac.setModel(modelo);
            PreparedStatement ps=null;
            ResultSet rs=null;
            conexion conn = new conexion();
            Connection con=conn.conectar();
            
            String sql="SELECT * FROM CLIENTE where id_cliente='"+bust.getText()+"' or nombre='"+bust.getText()+"' or ap_p='"+bust.getText()+"' or ap_m='"+bust.getText()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantcol=rsmd.getColumnCount();
            modelo.addColumn("ID Cliente");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Sexo");
            
            while (rs.next()) {
                Object[] filas = new Object[cantcol];
                for (int i = 0; i < cantcol; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
        String id="",nom="",ap="",am="",sex="";
        
                
        String sql1="select * from cliente where id_cliente='"+bust.getText()+"'";   
            try {
                PreparedStatement pst1;
                pst1 = con.prepareStatement(sql1);
                ResultSet s=pst1.executeQuery(sql1);
                while(s.next()){
                    id=s.getString("id_cliente");
                    nom=s.getString("nombre");
                    ap=s.getString("ap_p");
                    am=s.getString("ap_m");
                    sex=s.getString("sexo");

                }
               
            } catch (SQLException ex) {
                Logger.getLogger(regismem.class.getName()).log(Level.SEVERE, null, ex);
            }
            idm.setText(id);
            idc1.setText(nom);
            actividad1.setText(ap);
            actividad2.setText(am);
            stado.setText(sex);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bust = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        stado = new javax.swing.JTextField();
        idc1 = new javax.swing.JTextField();
        actividad1 = new javax.swing.JTextField();
        actividad2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idm = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablac = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar");

        bust.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bustKeyReleased(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        stado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stadoActionPerformed(evt);
            }
        });
        stado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stadoKeyReleased(evt);
            }
        });

        idc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idc1KeyReleased(evt);
            }
        });

        actividad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                actividad1KeyReleased(evt);
            }
        });

        actividad2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                actividad2KeyReleased(evt);
            }
        });

        jLabel2.setText("Nombre(s)");

        idm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ID Cliente");

        jLabel4.setText("Sexo");

        jLabel5.setText("Apellido Paterno");

        jLabel6.setText("Apellido materno");

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-informacion (1).png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        tablac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID cliente", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablac);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recurso MIN.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 257, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(bust, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idc1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actividad2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(bust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(actividad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(stado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bustKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bustKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            buscar();
        }  
    }//GEN-LAST:event_bustKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void actividad1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actividad1KeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_actividad1KeyReleased

    private void actividad2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actividad2KeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_actividad2KeyReleased

    private void stadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stadoKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_stadoKeyReleased

    private void idc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idc1KeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_idc1KeyReleased

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        informacion pass = new informacion();
        pass.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void stadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateCLI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actividad1;
    private javax.swing.JTextField actividad2;
    private javax.swing.JTextField bust;
    private javax.swing.JTextField idc1;
    private javax.swing.JLabel idm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField stado;
    private javax.swing.JTable tablac;
    // End of variables declaration//GEN-END:variables
}
