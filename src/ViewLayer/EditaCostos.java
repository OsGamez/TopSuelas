package ViewLayer;

import ObjectLayer.Costo;
import ObjectLayer.Linea;
import ObjectLayer.ObjectCostos;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class EditaCostos extends javax.swing.JDialog {

    String informacion = "";
    ObjectCostos obj = new ObjectCostos();

    public EditaCostos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        LoadModelLinea();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void LoadModelLinea() {
        Linea ln = new Linea();
        DefaultComboBoxModel modelLinea = new DefaultComboBoxModel(ln.getLinea());
        JcLinea.setModel(modelLinea);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JckLinea = new javax.swing.JCheckBox();
        JckAll = new javax.swing.JCheckBox();
        JcLinea = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JtTol = new javax.swing.JTextField();
        JtCol = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR COSTO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JckLinea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JckLinea.setText("Linea");

        JckAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JckAll.setText("Todos");

        JcLinea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcLineaItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("%Tolerancia:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("%Colada:");

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saveas_1173.png"))); // NOI18N
        JbGuardar.setText("REGISTRAR");
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        JbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JbCancelar.setText("CANCELAR");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JckAll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JckLinea)
                        .addGap(18, 18, 18)
                        .addComponent(JcLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtTol)
                            .addComponent(JtCol, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addComponent(JbGuardar)
                        .addGap(36, 36, 36)
                        .addComponent(JbCancelar)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JckLinea)
                    .addComponent(JcLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(JckAll)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtTol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JtCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbGuardar)
                            .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        Linea ln = (Linea) JcLinea.getSelectedItem();
        Costo ct = new Costo();
        if (JckAll.isSelected() == false && JckLinea.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Debes selecionar una opción!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JckAll.isSelected() == true && JckLinea.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes selecionar una opción!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JckAll.isSelected() == true) {
            if (JtTol.getText().equals("") || JtCol.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Completa los campos!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                ct.setPtolerancia(Double.parseDouble(JtTol.getText()));
                ct.setPcolada(Double.parseDouble(JtCol.getText()));
                if (obj.UpdateRegistro(ct)) {
                    informacion = "1";
                    JOptionPane.showMessageDialog(this, "Registro Actualizado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (JckLinea.isSelected() == true) {
            if (JcLinea.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Debes seleccionar una linea", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else if (JtTol.getText().equals("") || JtCol.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Completa los campos", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                ct.setPtolerancia(Double.parseDouble(JtTol.getText()));
                ct.setPcolada(Double.parseDouble(JtCol.getText()));
                ct.setLinea(ln.getId_Linea());
                if (obj.UpdateByLinea(ct)) {
                    informacion = "1";
                    JOptionPane.showMessageDialog(this, "Registro Actualizado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing
    private void Limpiar() {
        JtTol.setText("");
        JtCol.setText("");
        JcLinea.setSelectedIndex(0);
    }
    private void JcLineaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcLineaItemStateChanged
        /*if(evt.getStateChange() == ItemEvent.SELECTED){
            Linea ln = (Linea)JcLinea.getSelectedItem();
            JbId.setText(String.valueOf(ln.getId_Linea()));
        }*/
    }//GEN-LAST:event_JcLineaItemStateChanged

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
            java.util.logging.Logger.getLogger(EditaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditaCostos dialog = new EditaCostos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbCancelar;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JComboBox<String> JcLinea;
    private javax.swing.JCheckBox JckAll;
    private javax.swing.JCheckBox JckLinea;
    private javax.swing.JTextField JtCol;
    private javax.swing.JTextField JtTol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
