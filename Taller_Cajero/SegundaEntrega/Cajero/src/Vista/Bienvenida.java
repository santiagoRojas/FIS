/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Estudiantes
 */
public class Bienvenida extends javax.swing.JFrame {

    private int nit;
    private int tipo;
    /**
     * Creates new form Bienvenida
     */
    public Bienvenida() {
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

        RestoNIT = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        IngreseNIT = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        PrimerDigitoNIT = new javax.swing.JTextField();
        Separador = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(338, 338));
        setMinimumSize(new java.awt.Dimension(338, 338));
        setPreferredSize(new java.awt.Dimension(338, 338));
        getContentPane().setLayout(null);

        RestoNIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestoNITActionPerformed(evt);
            }
        });
        RestoNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RestoNITKeyTyped(evt);
            }
        });
        getContentPane().add(RestoNIT);
        RestoNIT.setBounds(50, 230, 88, 40);

        Titulo.setText("BIENVENIDO A SU BANCO PREFERIDO");
        getContentPane().add(Titulo);
        Titulo.setBounds(60, 10, 250, 20);

        IngreseNIT.setText("Ingrese Nit Tarjeta: ");
        getContentPane().add(IngreseNIT);
        IngreseNIT.setBounds(10, 190, 110, 30);

        Aceptar.setText("ACEPTAR");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar);
        Aceptar.setBounds(210, 220, 100, 30);

        PrimerDigitoNIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimerDigitoNITActionPerformed(evt);
            }
        });
        PrimerDigitoNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrimerDigitoNITKeyTyped(evt);
            }
        });
        getContentPane().add(PrimerDigitoNIT);
        PrimerDigitoNIT.setBounds(20, 230, 19, 40);

        Separador.setText("-");
        getContentPane().add(Separador);
        Separador.setBounds(40, 240, 10, 14);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 340, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RestoNITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestoNITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RestoNITActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        
        if(PrimerDigitoNIT.getText().length()==1 && RestoNIT.getText().length()==7){
            nit=Integer.parseInt(RestoNIT.getText());
            tipo=Integer.parseInt(PrimerDigitoNIT.getText());
            if(tipo==1){
                //validar si es cliente si lo 
                /*MenuCliente menu=new MenuCliente();
                menu.setVisible(true);
                this.setVisible(false);*/
                
            }else{
                //validar si es admin
                /*MenuAdmin menu=new MenuAdmin();
                menu.setVisible(true);
                this.setVisible(false);*/
            }
        }else{
            JOptionPane.showMessageDialog(null, "NIT invalido");
            JOptionPane.showMessageDialog(null, "FORMATO: X-XXXXXXX");
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void PrimerDigitoNITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimerDigitoNITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimerDigitoNITActionPerformed

    private void RestoNITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RestoNITKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
        if (RestoNIT.getText().length()== 7)evt.consume();
    }//GEN-LAST:event_RestoNITKeyTyped

    private void PrimerDigitoNITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerDigitoNITKeyTyped
        char c=evt.getKeyChar();
        if(c<'1'||c>'2')evt.consume();
        if (PrimerDigitoNIT.getText().length()== 1)evt.consume();
    }//GEN-LAST:event_PrimerDigitoNITKeyTyped

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
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel IngreseNIT;
    private javax.swing.JTextField PrimerDigitoNIT;
    private javax.swing.JTextField RestoNIT;
    private javax.swing.JLabel Separador;
    private javax.swing.JLabel Titulo;
    // End of variables declaration//GEN-END:variables
}
