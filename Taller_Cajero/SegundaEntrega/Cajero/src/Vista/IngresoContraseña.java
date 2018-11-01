/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Consultas;
import Controlador.Retirar;
import Controlador.ValidarContraseñas;
import Modelo.Administrador;
import Modelo.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeisson
 */
public class IngresoContraseña extends javax.swing.JFrame {

    private int Contra;
    private Administrador admin;
    private Cliente user;
    private int monto;
    private int intentos;
    /**
     * Creates new form IngresoContraseña
     */
    public IngresoContraseña() {
        admin=null;
        user=null;
        initComponents();
    }

    public IngresoContraseña(Administrador admin) {
        this.admin=admin;
        user=null;
        initComponents();
    }
    
    public IngresoContraseña(Cliente user) {
        this.user=user;
        admin=null;
        monto=0;
        intentos=3;
        initComponents();
    }
    public void setMonto(int monto){
        this.monto = monto;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        Contraseña = new javax.swing.JTextField();
        Ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 350));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setPreferredSize(new java.awt.Dimension(450, 350));
        getContentPane().setLayout(null);

        Volver.setText("Cancelar Operación");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(140, 240, 190, 40);

        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        Contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ContraseñaKeyTyped(evt);
            }
        });
        getContentPane().add(Contraseña);
        Contraseña.setBounds(170, 150, 200, 40);

        Ok.setText("OK");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });
        getContentPane().add(Ok);
        Ok.setBounds(50, 150, 70, 40);

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setText("DIGITE SU CONTRASEÑA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 260, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Digite.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 500, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Bienvenida retorno=new Bienvenida();
        retorno.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VolverActionPerformed

    private void ContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContraseñaKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
        if (Contraseña.getText().length()== 4)evt.consume();
    }//GEN-LAST:event_ContraseñaKeyTyped

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        if(Contraseña.getText().length()==4){
            Contra=Integer.parseInt(Contraseña.getText());
            if(user!=null){
                ValidarContraseñas consultar = new ValidarContraseñas();
                boolean respuesta1= consultar.ValidarCliente(user.getNit(), Contra);
                if(respuesta1==true && intentos != 0){
                    if(monto!=0 ){
                        boolean respuesta2;
                        Retirar retiro = new Retirar();
                        try {
                            respuesta2 = retiro.RetirarFondos(this.monto, user.getNit());
                            if(respuesta2==true){
                                Consultas consulta = new Consultas();
                                user=consulta.ValidarTarjetaCliente(user.getNit());
                                ImpresionCliente imprimir = new ImpresionCliente(user,monto);
                                imprimir.setVisible(true);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo realizar retiro, fondos insuficientes");
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(IngresoContraseña.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No se han implementado mas opiciones distintas de retiro");
                    }
                }else if(intentos==0){
                    try {
                        respuesta1 = consultar.BloquearTarjetaCliente(user.getNit());
                        if(respuesta1==true){
                            JOptionPane.showMessageDialog(null, "Maximo de intentos permitidos: Tarjeta bloqueada");
                            //Devolver a ventana bienvinedia
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo bloquear la tarjeta");
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(IngresoContraseña.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else{
                    intentos-=1;
                    JOptionPane.showMessageDialog(null, "Contraseña invalida, restan: "+intentos+" intentos");
                }
            }else if(admin!=null){
                ValidarContraseñas consultar = new ValidarContraseñas();
                boolean respuesta1= consultar.ValidarAdministrador(admin.getNit(), Contra);
                if(respuesta1==true && intentos != 0){
                   MenuAdmin menu = new MenuAdmin(admin);
                   
                }else if(intentos==0){
                    try {
                        respuesta1 = consultar.BloquearTarjetaAdmin(admin.getNit());
                        if(respuesta1==true){
                            JOptionPane.showMessageDialog(null, "Maximo de intentos permitidos: Tarjeta bloqueada");
                            Bienvenida bv = new Bienvenida();
                            bv.setVisible(true);
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo bloquear la tarjeta");
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(IngresoContraseña.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else{
                    intentos-=1;
                    JOptionPane.showMessageDialog(null, "Contraseña invalida, restan: "+intentos+" intentos");
                }
            }else{
               JOptionPane.showMessageDialog(null, "ERROR!!: Administrador y usuario nulo.");
            }
            
            //ValidarContraseña
        }
        else{
            JOptionPane.showMessageDialog(null, "Contraseña invalida");
            JOptionPane.showMessageDialog(null, "FORMATO: XXXX");
        }
    }//GEN-LAST:event_OkActionPerformed

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contraseña;
    private javax.swing.JButton Ok;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
