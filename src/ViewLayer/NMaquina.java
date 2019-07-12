package ViewLayer;

import ObjectLayer.Maquina;
import ObjectLayer.ObjectMaquinas;
import ObjectLayer.Validacion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class NMaquina extends javax.swing.JDialog {

    String informacion = "";

    public NMaquina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void Cerrar() {
//        String botones[] = {"SI", "NO"};
//        int eleccion = JOptionPane.showOptionDialog(this,"¿Deseas cerrar esta ventana?", "TOP-SUELAS", 
//                0, 0, null, botones, this);
//        if(eleccion == JOptionPane.YES_OPTION){
        dispose();
//        }else if(eleccion == JOptionPane.NO_OPTION){       
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbProd = new javax.swing.JLabel();
        JbPrecioa = new javax.swing.JLabel();
        Jte = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        Jtm = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVA LISTA");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbProd.setText("Numero de maquina:");

        JbPrecioa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa.setText("Cantidad de Estaciones");

        Jte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JteActionPerformed(evt);
            }
        });

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saveas_1173.png"))); // NOI18N
        JbGuardar.setText("REGISTRAR");
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        JbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JbCerrar.setText("CANCELAR");
        JbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCerrarActionPerformed(evt);
            }
        });

        Jtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbPrecioa)
                            .addComponent(JbProd))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jtm, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jte, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JbGuardar)
                        .addGap(50, 50, 50)
                        .addComponent(JbCerrar)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbProd)
                    .addComponent(Jtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPrecioa)
                    .addComponent(Jte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(JbCerrar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCerrarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        nuevamaquina();
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtmActionPerformed
        Jte.requestFocus();
    }//GEN-LAST:event_JtmActionPerformed

    private void JteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JteActionPerformed
        nuevamaquina();
    }//GEN-LAST:event_JteActionPerformed

    private void nuevamaquina() {
        Validacion v = new Validacion();
        if ( Jte.equals("") && Jtm.equals("")) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Jtm.requestFocus();
        } else if (v.verificanumeros(Jte.getText())) {//
            ObjectMaquinas obmaq = new ObjectMaquinas();
            Maquina maq = new Maquina();
            maq.setMaquina(Jtm.getText().toUpperCase());
            maq.setEstaciones(Integer.parseInt(Jte.getText()));
            if(obmaq.BuscaMaquinab(Jtm.getText())){
            if (obmaq.MaquinaAdd(maq)) {
                JOptionPane.showMessageDialog(this, "Maquina y Estaciones Almacenadas Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                Limpiar();
                Cerrar();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
                Limpiar();
            }
            }else{ JOptionPane.showMessageDialog(this, "Ya existe la Maquina seleccionada! ", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                Limpiar();
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Datos introducidos no validos, Intentelo de nuevo", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Jtm.requestFocus();
        }
    }

    private void Limpiar() {
        Jte.setText("");
        Jtm.setText("");
        JbProd.setForeground(Color.BLACK);
        JbPrecioa.setForeground(Color.BLACK);
    }

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
            java.util.logging.Logger.getLogger(NMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NMaquina dialog = new NMaquina(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbCerrar;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbPrecioa;
    private javax.swing.JLabel JbProd;
    private javax.swing.JTextField Jte;
    private javax.swing.JTextField Jtm;
    // End of variables declaration//GEN-END:variables
}
