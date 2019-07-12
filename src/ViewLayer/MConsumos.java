package ViewLayer;

import ObjectLayer.Consumo;
import ObjectLayer.Maquina;
import ObjectLayer.ObjectConsumos;
import ObjectLayer.Validacion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MConsumos extends javax.swing.JDialog {

    ObjectConsumos obsumos = new ObjectConsumos();
    public Consumo consumo;
    String informacion = "";

    public MConsumos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/edit-validated_40458.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);

    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbGuardar = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        Jtp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jts = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Jtdesp = new javax.swing.JTextField();
        Jtpunto = new javax.swing.JLabel();
        Jcd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR CONSUMOS");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saveas_1173.png"))); // NOI18N
        JbGuardar.setText("MODIFICAR");
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

        Jtp.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        jLabel3.setText("Peso");

        jLabel5.setText("Desperdicio");

        Jtdesp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtdespMouseClicked(evt);
            }
        });
        Jtdesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtdespActionPerformed(evt);
            }
        });

        Jtpunto.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        Jcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbGuardar)
                                .addGap(39, 39, 39)
                                .addComponent(JbCerrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Jcd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(Jtdesp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Jts, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Jtpunto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jtpunto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jts, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Jtdesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Jcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(JbCerrar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        ConsumoUpdate();
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCerrarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtdespMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtdespMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtdespMouseClicked

    private void JtdespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtdespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtdespActionPerformed

    private void JcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcdActionPerformed
    private void Cerrar() {
//        String botones[] = {"SI", "NO"};
//        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
//                0, 0, null, botones, this);
//        if (eleccion == JOptionPane.YES_OPTION) {
        dispose();
//        } else if (eleccion == JOptionPane.NO_OPTION) {
//        }
    }

    private void ConsumoUpdate() {
        try {
            if (Jtdesp.getText().equals("")) {// verifica que el campo no este vacio
                JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                Validacion v = new Validacion();
                if (v.verificaflotantes(Jtdesp.getText())) {// verifica el contenido sea valido
                    //&&consumo.getDesperdicio()==Float.parseFloat(Jcd.getSelectedItem().toString())
                    if (consumo.getPeso() == Float.parseFloat(Jtdesp.getText())) {// verifica si el contenido es lo mismo y no sufrio cambios
                        Jtdesp.requestFocus();
                    } else {
                        consumo.setPeso(Float.parseFloat(Jtdesp.getText()));
                        consumo.setDesperdicio((Float.parseFloat(Jcd.getText()) / 100));
                        if (obsumos.ConsumoUpdate(consumo)) {
                            JOptionPane.showMessageDialog(this, "Modificacion exitosa!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            informacion = "1";
                            Cerrar();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al modificar Contacta a Sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Los datos que has introducido no son válidos.", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
                    //dispose();
                    Jtdesp.requestFocus();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            java.util.logging.Logger.getLogger(MConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MConsumos dialog = new MConsumos(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Jcd;
    public javax.swing.JTextField Jtdesp;
    public javax.swing.JLabel Jtp;
    public javax.swing.JLabel Jtpunto;
    public javax.swing.JLabel Jts;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
