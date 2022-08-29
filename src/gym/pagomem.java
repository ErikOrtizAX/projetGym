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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Erik
 */
public class pagomem extends javax.swing.JFrame {

    conexion cc=new conexion();
    Connection con = cc.conectar();
    conexion cos = new conexion();
    String cons="",cons2="",fechas="",fechas2="";
    int numero=0,band=0;
    float total=0;
    String fechasfin="";
    
    /**
     * Creates new form sesion
     */
    public pagomem() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/Recurso 2.png")).getImage());
        cargarc();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha.setText(dateFormat.format(date));
        //acti.setModel(cos.objeto());
    }

    @SuppressWarnings("unchecked")
    
     public void agregarusuario(){
         String act = (String) clientes.getSelectedItem();
         String id="";
         initComponents();
         String sql="insert into pago (idpago, id_membresia, fecha, total) values(?,?,?,?)";
         try{
             PreparedStatement pst=con.prepareStatement(sql);
             pst.setString(1, numero+"");
             String sql1="select * from membresia where id_membresia='"+act+"'";   
            try {
                PreparedStatement pst1;
                pst1 = con.prepareStatement(sql1);
                ResultSet s=pst1.executeQuery(sql1);
                while(s.next()){
                    id=s.getString("id_membresia");
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(pagomem.class.getName()).log(Level.SEVERE, null, ex);
            }
             pst.setString(2, id);
             pst.setString(3, fechas);
             pst.setString(4, total+"");
             pst.executeUpdate();
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "error"+e.getMessage());
             
         }
         String sql2="update membresia set status='Activo', inicio='"+fechas+"', vencimiento='"+fechasfin+"' where id_membresia='"+id+"';";
         try {
            PreparedStatement pst;
            pst = con.prepareStatement(sql2);
            pst.executeUpdate(sql2);
            JOptionPane.showMessageDialog(null, "pago completado");
        } catch (SQLException ex) {
            Logger.getLogger(pagomem.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.dispose();         
     }
     public void calculo2(){
        float pag= Float.parseFloat(pagog.getText());
        float pag2= Float.parseFloat(pagoin.getText());
        float tot=pag2-pag;
        cambio.setText(tot+"");
     }
     public void cargarc(){
         String sql2="select id_membresia from membresia";
         
        try {
            PreparedStatement pst;
            PreparedStatement pst1;
            pst = con.prepareStatement(sql2);
            ResultSet sr=pst.executeQuery(sql2);
            clientes.removeAllItems();
            while(sr.next()){
                clientes.addItem(sr.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pagomem.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     public void aleatorio(){
         int band=0;
         do{
                
                try {
                    numero = (int)Math.round(Math.random()*(9999-1000)+1000);
                    String sql2="select * from pago where idpago='"+numero+"'";
                    PreparedStatement pst;
                    pst = con.prepareStatement(sql2);
                    ResultSet sr=pst.executeQuery(sql2);
                    if(sr.next() || sr.next()){
                        band=0;
                    }else{
                         band=1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(regiscliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            
         }while(band==0);
         id.setText(numero+"");
     }
     public void calculo(){
        fechas = fecha.getText();  
        String[] arrayfechas = fechas.split("-");
        for (int i = 0; i < arrayfechas.length; i++) {
            System.out.println(arrayfechas[i]);
        } 
        int anio= Integer.parseInt(arrayfechas[0]);
        int mes= Integer.parseInt(arrayfechas[1]);
        int dia= Integer.parseInt(arrayfechas[2]);
        if (mes==12){
            mes=01;
            anio=anio+1;
        }else{
            mes= mes + 1;
        }
        /*recuperar costo de las actividades seleccionadas*/
        float costo1=0;
        String sql="select * from membresia where id_membresia='"+(String) clientes.getSelectedItem()+"'";   
        try {
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            ResultSet s=pst.executeQuery(sql);
            while(s.next()){
                costo1=s.getFloat("pago");              
            }
        } catch (SQLException ex) {
            Logger.getLogger(pagomem.class.getName()).log(Level.SEVERE, null, ex);
        }
        total=costo1;
        fechas2=anio+"-"+mes+"-"+dia;
        fechafin.setText(anio+"-"+mes+"-"+dia);
        fechasfin=anio+"-"+mes+"-"+dia;
        pagog.setText(total+"");
        
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        fin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        pagoin = new javax.swing.JTextField();
        clientes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        generar = new javax.swing.JButton();
        calcular = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        monto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        pagar = new javax.swing.JButton();
        pagog = new javax.swing.JLabel();
        fechafin = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        cambio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Renovacion de membresia");

        fin.setText("terminar");
        fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finActionPerformed(evt);
            }
        });

        jLabel2.setText("id de pago");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2b22e1ec-02de-477c-b903-69d0b29321a3_200x200.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        id.setText("genere numero de cliente ->");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        fecha.setName(""); // NOI18N
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        pagoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoinActionPerformed(evt);
            }
        });
        pagoin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagoinKeyReleased(evt);
            }
        });

        clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });

        jLabel5.setText("id membresia");

        generar.setText("generar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        calcular.setText("calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        jLabel7.setText("pago");

        monto.setText("monto");

        jLabel9.setText("cambio");

        label.setText(" ");

        pagar.setText("pagar");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        pagog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pagog.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fechafin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechafin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label1.setText("fecha de termino");

        cambio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Fecha de inicio(yyyy-mm-dd)");

        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-informacion (1).png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(label1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(monto)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pagar)
                                .addGap(28, 28, 28)
                                .addComponent(fin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(30, 30, 30))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(fechafin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(pagog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(10, 10, 10))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(cambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(label)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(pagoin))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addComponent(calcular))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(fecha, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(clientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(generar)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pagog, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(calcular)))
                                .addGap(15, 15, 15)
                                .addComponent(pagoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addGap(14, 14, 14)))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7)
                                .addGap(15, 15, 15)
                                .addComponent(monto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(7, 7, 7)
                        .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pagar)
                                .addComponent(fin)))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16))))
        );

        fecha.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finActionPerformed
        agregarusuario();
    }//GEN-LAST:event_finActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientesActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        aleatorio();
    }//GEN-LAST:event_generarActionPerformed

    private void pagoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagoinActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        calculo();
    }//GEN-LAST:event_calcularActionPerformed

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        calculo2();
    }//GEN-LAST:event_pagarActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        informacion pass = new informacion();
        pass.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void pagoinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagoinKeyReleased
        if(band==0){
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            calculo2();
            band=1;
        }}else{
            if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            agregarusuario();
        }
        }
    }//GEN-LAST:event_pagoinKeyReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        informacion pass = new informacion();
        pass.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(pagomem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pagomem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pagomem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pagomem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pagomem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular;
    private javax.swing.JLabel cambio;
    private javax.swing.JComboBox<String> clientes;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel fechafin;
    private javax.swing.JButton fin;
    private javax.swing.JButton generar;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel monto;
    private javax.swing.JButton pagar;
    private javax.swing.JLabel pagog;
    private javax.swing.JTextField pagoin;
    // End of variables declaration//GEN-END:variables
}
