package ViewLayer;

import ObjectLayer.Costo;
import ObjectLayer.Material;
import ObjectLayer.ObjectCostos;
import ObjectLayer.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class MCosto extends javax.swing.JDialog {

    String informacion = "";
    ObjectCostos obj = new ObjectCostos();
    double Tolerancia = 0;
    double Colada = 0;
    double PesoTotal = 0;
    double CostoTotal = 0;

    public MCosto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/edit-validated_40458.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        JcProd.setEnabled(false);
        JcRc.setEnabled(false);
        JcMaterial.setEnabled(false);
        JtPunto.setEnabled(false);
        JtPeso.setEnabled(false);
        JtPtol.requestFocus();
        JbId.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbCol = new javax.swing.JLabel();
        JbMat = new javax.swing.JLabel();
        JcProd = new javax.swing.JComboBox<>();
        JtPunto = new javax.swing.JTextField();
        JtPeso = new javax.swing.JTextField();
        JtPtol = new javax.swing.JTextField();
        JtPcol = new javax.swing.JTextField();
        JcMaterial = new javax.swing.JComboBox<>();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JbId = new javax.swing.JLabel();
        JcRc = new javax.swing.JComboBox<>();
        JbPc = new javax.swing.JLabel();
        JbPrecio = new javax.swing.JLabel();
        JbTolerancia = new javax.swing.JLabel();
        JbColada = new javax.swing.JLabel();
        JbP = new javax.swing.JLabel();
        JbSuela = new javax.swing.JLabel();
        JbPesoT = new javax.swing.JLabel();
        JbRc = new javax.swing.JLabel();
        JbC = new javax.swing.JLabel();
        JbPunto = new javax.swing.JLabel();
        JbCostoT = new javax.swing.JLabel();
        JbPeso = new javax.swing.JLabel();
        JbTol = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR COSTO");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbCol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCol.setText("% Colada:");

        JbMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMat.setText("Material:");

        JtPtol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtPtolKeyPressed(evt);
            }
        });

        JtPcol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtPcolKeyPressed(evt);
            }
        });

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

        JbId.setText("jLabel1");

        JbPc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPc.setText("Costo:");

        JbPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecio.setForeground(new java.awt.Color(0, 51, 204));
        JbPrecio.setText("0.00");

        JbTolerancia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTolerancia.setForeground(new java.awt.Color(0, 51, 204));
        JbTolerancia.setText("0.00");

        JbColada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbColada.setForeground(new java.awt.Color(0, 51, 204));
        JbColada.setText("0.00");

        JbP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbP.setText("Peso Total:");

        JbSuela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbSuela.setText("Suela:");

        JbPesoT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPesoT.setForeground(new java.awt.Color(0, 51, 204));
        JbPesoT.setText("0.00");

        JbRc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbRc.setText("RCPT:");

        JbC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbC.setText("Costo Total:");

        JbPunto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPunto.setText("Punto:");

        JbCostoT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCostoT.setForeground(new java.awt.Color(0, 51, 204));
        JbCostoT.setText("0.00");

        JbPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPeso.setText("Peso Gr:");

        JbTol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTol.setText("% Tolerancia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JcMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JbRc)
                                        .addComponent(JbSuela))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JcProd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JcRc, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(JbMat)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbPunto)
                                .addGap(18, 18, 18)
                                .addComponent(JtPunto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JbPc)
                                .addGap(18, 18, 18)
                                .addComponent(JbPrecio)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbPeso)
                                    .addComponent(JbTol)
                                    .addComponent(JbCol))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JtPtol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JtPcol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JbColada)
                                            .addComponent(JbTolerancia)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbPesoT)
                                .addGap(20, 20, 20)
                                .addComponent(JbC)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbCostoT))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbGuardar)
                        .addGap(47, 47, 47)
                        .addComponent(JbCancelar))
                    .addComponent(JbId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbSuela)
                            .addComponent(JcProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbPeso))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbRc)
                            .addComponent(JcRc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbTol))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbMat)
                            .addComponent(JcMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCol))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbPunto)
                            .addComponent(JtPunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbPc)
                            .addComponent(JbPrecio)
                            .addComponent(JbP)
                            .addComponent(JbPesoT)
                            .addComponent(JbC)
                            .addComponent(JbCostoT))
                        .addGap(43, 43, 43)
                        .addComponent(JbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbTolerancia)
                                .addGap(26, 26, 26)
                                .addComponent(JbColada))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtPtol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(JtPcol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Alerta() {
        JcMaterial.requestFocus();
        JbTol.setForeground(Color.red);
        JbCol.setForeground(Color.red);
        JbPeso.setForeground(Color.red);
        JbMat.setForeground(Color.red);
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtPtolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPtolKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            DecimalFormat var = new DecimalFormat("0.00");
            double Pg = Double.parseDouble(JtPeso.getText());
            double Ptol = Double.parseDouble(JtPtol.getText());
            Tolerancia = Ptol * Pg / 100;
            JbTolerancia.setText(var.format(Tolerancia));
            JtPcol.setEnabled(true);
            JtPcol.requestFocus();
        }
    }//GEN-LAST:event_JtPtolKeyPressed

    private void JtPcolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPcolKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            DecimalFormat var = new DecimalFormat("0.00");
            DecimalFormat var2 = new DecimalFormat("0.000");
            double Pg = Double.parseDouble(JtPeso.getText());
            double Pcol = Double.parseDouble(JtPcol.getText());
            double Precio = Double.parseDouble(JbPrecio.getText());
            Colada = Pcol * Pg / 100;
            JbColada.setText(var.format(Colada));
            PesoTotal = Pg + Tolerancia + Colada;
            JbPesoT.setText(var.format(PesoTotal));
            CostoTotal = PesoTotal * Precio;
            JbCostoT.setText(var.format(CostoTotal));
        }
    }//GEN-LAST:event_JtPcolKeyPressed

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        Producto prod = (Producto) JcProd.getSelectedItem();
        if (JtPcol.getText().equals("") || JtPtol.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Completa los campos", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JbTol.setForeground(Color.red);
            JbTol.setForeground(Color.red);
        } else {
            Costo ct = new Costo();
            ct.setId_Producto(prod.getId_Producto());
            ct.setPunto(Integer.parseInt(JtPunto.getText()));
            ct.setPtolerancia(Double.parseDouble(JtPtol.getText()));
            ct.setPcolada(Double.parseDouble(JtPcol.getText()));
            if (obj.costoUpdate(ct)) {
                JOptionPane.showMessageDialog(this, "Registro Actualizado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed
    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {
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
            java.util.logging.Logger.getLogger(MCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MCosto dialog = new MCosto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbC;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbCol;
    public javax.swing.JLabel JbColada;
    public javax.swing.JLabel JbCostoT;
    private javax.swing.JButton JbGuardar;
    public javax.swing.JLabel JbId;
    private javax.swing.JLabel JbMat;
    private javax.swing.JLabel JbP;
    private javax.swing.JLabel JbPc;
    private javax.swing.JLabel JbPeso;
    public javax.swing.JLabel JbPesoT;
    public javax.swing.JLabel JbPrecio;
    private javax.swing.JLabel JbPunto;
    private javax.swing.JLabel JbRc;
    private javax.swing.JLabel JbSuela;
    private javax.swing.JLabel JbTol;
    public javax.swing.JLabel JbTolerancia;
    public javax.swing.JComboBox<String> JcMaterial;
    public javax.swing.JComboBox<String> JcProd;
    public javax.swing.JComboBox<String> JcRc;
    public javax.swing.JTextField JtPcol;
    public javax.swing.JTextField JtPeso;
    public javax.swing.JTextField JtPtol;
    public javax.swing.JTextField JtPunto;
    // End of variables declaration//GEN-END:variables
}
