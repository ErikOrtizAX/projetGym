/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class update extends javax.swing.JFrame {

    /**
     * Creates new form update
     */
    conexion cc=new conexion();
    Connection con = cc.conectar();
    conexion cos = new conexion();
    int numero=0;
    public update() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/Recurso 2.png")).getImage());
    }
    public void actualizar(){
        
         String sql="update membresia set actividad=99"+actividad1.getText()+", actividad2="+actividad2.getText()+", pago="+pago.getText()+", inicio='"+in.getText()+"', vencimiento='"+fin.getText()+"' where id_membresia='"+bust.getText()+"'";
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
            
            sql="SELECT * FROM membresia where id_membresia='"+bust.getText()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantcol=rsmd.getColumnCount();
            modelo.addColumn("ID Membresia");
            modelo.addColumn("ID Cliente");
            modelo.addColumn("actividad 1");
            modelo.addColumn("actividad 2");
            modelo.addColumn("Estatus");
            modelo.addColumn("Pago");
            modelo.addColumn("inicio");
            modelo.addColumn("Vencimiento");
            
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
        pago.setText("");
        in.setText("");
        fin.setText("");
    }
    public void buscar(){
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            tablac.setModel(modelo);
            PreparedStatement ps=null;
            ResultSet rs=null;
            conexion conn = new conexion();
            Connection con=conn.conectar();
            
            String sql="SELECT * FROM membresia where id_membresia='"+bust.getText()+"' or id_cliente='"+bust.getText()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantcol=rsmd.getColumnCount();
            modelo.addColumn("ID Membresia");
            modelo.addColumn("ID Cliente");
            modelo.addColumn("actividad 1");
            modelo.addColumn("actividad 2");
            modelo.addColumn("Estatus");
            modelo.addColumn("Pago");
            modelo.addColumn("inicio");
            modelo.addColumn("Vencimiento");
            
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
        String id="",idc="",act1="",act2="",sta="",Pago="",inicio="",ven="";
        
                
        String sql1="SELECT * FROM membresia where id_membresia='"+bust.getText()+"' or id_cliente='"+bust.getText()+"'";  
            try {
                PreparedStatement pst1;
                pst1 = con.prepareStatement(sql1);
                ResultSet s=pst1.executeQuery(sql1);
                while(s.next()){
                    id=s.getString("id_membresia");
                    idc=s.getString("id_cliente");
                    act1=s.getString("actividad");
                    act2=s.getString("actividad2");
                    sta=s.getString("status");
                    Pago=s.getString("pago");
                    inicio=s.getString("inicio");
                    ven=s.getString("vencimiento");
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(regismem.class.getName()).log(Level.SEVERE, null, ex);
            }
            idm.setText(id);
            idc1.setText(idc);
            actividad1.setText(act1);
            actividad2.setText(act2);
            stado.setText(sta);
            pago.setText(Pago);
            in.setText(inicio);
            fin.setText(ven);
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
        pago = new javax.swing.JTextField();
        in = new javax.swing.JTextField();
        fin = new javax.swing.JTextField();
        actividad1 = new javax.swing.JTextField();
        actividad2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idm = new javax.swing.JLabel();
        idc1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablac = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagoKeyReleased(evt);
            }
        });

        in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inKeyReleased(evt);
            }
        });

        fin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                finKeyReleased(evt);
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

        jLabel2.setText("ID Membresia");

        idm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        idc1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ID Cliente");

        stado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Status");

        jLabel5.setText("Actividad 1°");

        jLabel6.setText("Actividad 2°");

        jLabel7.setText("pago");

        jLabel8.setText("Inicio");

        jLabel9.setText("Vencimiento");

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

        tablac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Membresia", "ID cliente", "Actividad 1", "Actividad 2", "estatus", "pago", "Inicio", "Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablac);

        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recurso MIN.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-informacion (1).png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(bust, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idm, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(idc1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(82, 82, 82)
                                            .addComponent(jLabel8)))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(actividad2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(stado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(in, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(bust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idc1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(actividad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 11, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
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

    private void pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagoKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_pagoKeyReleased

    private void inKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_inKeyReleased

    private void finKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_finKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            actualizar();
        }
    }//GEN-LAST:event_finKeyReleased

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        informacion pass = new informacion();
        pass.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actividad1;
    private javax.swing.JTextField actividad2;
    private javax.swing.JTextField bust;
    private javax.swing.JTextField fin;
    private javax.swing.JLabel idc1;
    private javax.swing.JLabel idm;
    private javax.swing.JTextField in;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pago;
    private javax.swing.JLabel stado;
    private javax.swing.JTable tablac;
    // End of variables declaration//GEN-END:variables
}
