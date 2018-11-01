/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeisson
 */
public class MenuCliente extends javax.swing.JFrame {

    private Cliente user;
    /**
     * Creates new form MenuCliente
     */
    public MenuCliente() {
        user=null;
        initComponents();
    }
    
    public MenuCliente(Cliente user) {
        this.user=user;
        initComponents();
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
        RETIRO = new javax.swing.JButton();
        CancelarOp = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 350));
        setMinimumSize(new java.awt.Dimension(350, 350));
        setPreferredSize(new java.awt.Dimension(350, 350));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("SELECCIONE UNA OPCION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 60, 210, 40);

        RETIRO.setText("RETIRAR");
        RETIRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RETIROActionPerformed(evt);
            }
        });
        getContentPane().add(RETIRO);
        RETIRO.setBounds(160, 110, 150, 50);

        CancelarOp.setText("Cancelar Operación");
        CancelarOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarOpActionPerformed(evt);
            }
        });
        getContentPane().add(CancelarOp);
        CancelarOp.setBounds(130, 230, 190, 50);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenus.jpg"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 550, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RETIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RETIROActionPerformed
        if(user!=null){
            IngresarMonto monto = new IngresarMonto(user);
            monto.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, " ERROR!!!!! :Usuario nulo");
        }
    }//GEN-LAST:event_RETIROActionPerformed

    private void CancelarOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarOpActionPerformed
        Bienvenida retorno=new Bienvenida();
        retorno.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelarOpActionPerformed

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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarOp;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton RETIRO;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
