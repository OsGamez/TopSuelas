package ViewLayer;

import ObjectLayer.Linea;
import ObjectLayer.Molde;
import ObjectLayer.ObjectMoldes;
import ObjectLayer.Validacion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NMolde extends javax.swing.JDialog {

    Vector<Linea> datos = new Vector<Linea>();
    String informacion = "";

    public NMolde(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LoadModelMolde();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void LoadModelMolde() {
        Linea ln = new Linea();
        DefaultComboBoxModel modelLinea = new DefaultComboBoxModel(ln.getLinea());
        datos = ln.getLinea();
        Jtl.setModel(modelLinea);
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

        JbDes = new javax.swing.JLabel();
        JbProd = new javax.swing.JLabel();
        JbPrecioa = new javax.swing.JLabel();
        Jtl = new javax.swing.JComboBox<>();
        Jtc = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        Jtp = new javax.swing.JTextField();
        JbPrecioa1 = new javax.swing.JLabel();
        JtCaja = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVA LISTA");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDes.setText("Linea");

        JbProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbProd.setText("Punto:");

        JbPrecioa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa.setText("Cantidad de moldes");

        Jtl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JtlItemStateChanged(evt);
            }
        });

        Jtc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtcActionPerformed(evt);
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

        Jtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtpActionPerformed(evt);
            }
        });

        JbPrecioa1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa1.setText("Pares por Cajon");

        JtCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCajaActionPerformed(evt);
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
                        .addComponent(JbDes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(Jtl, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JbGuardar)
                        .addGap(50, 50, 50)
                        .addComponent(JbCerrar)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbProd)
                            .addComponent(JbPrecioa1))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbPrecioa)
                        .addGap(55, 55, 55)
                        .addComponent(Jtc, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbDes)
                    .addComponent(Jtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbProd)
                    .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPrecioa)
                    .addComponent(Jtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPrecioa1)
                    .addComponent(JtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
        nuevomolde();
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtpActionPerformed
        Jtc.requestFocus();
    }//GEN-LAST:event_JtpActionPerformed

    private void JtcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtcActionPerformed
        nuevomolde();
    }//GEN-LAST:event_JtcActionPerformed

    private void JtlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JtlItemStateChanged
        Jtp.requestFocus();
    }//GEN-LAST:event_JtlItemStateChanged

    private void JtCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtCajaActionPerformed

    private void nuevomolde() {
        Validacion v = new Validacion();// instancia objeto para validar campos
        Molde m = new Molde();
        if (Jtl.getSelectedIndex() == 0 && Jtc.equals("") && Jtp.equals("")) {//si son vacios regresar mensaje
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Jtp.requestFocus();
        }//verifica el campo de punto y el campo de cantidad 
        else if (v.verificanumeros(Jtc.getText())&&v.verificanumeros(JtCaja.getText())) {
            //se añaden los datos al objeto 'molde'
            m.setCantidad(Integer.parseInt(Jtc.getText()));
            m.setLinea((datos.get(Jtl.getSelectedIndex()).getId_Linea()));
            m.setPunto(Jtp.getText().toUpperCase());
            m.setParxcaja(Integer.parseInt(JtCaja.getText()));
            ObjectMoldes obm = new ObjectMoldes();
            if (obm.MoldeAdd(m)) {// se ejecuta insercion, si todo esta bien regresa true
                JOptionPane.showMessageDialog(this, "Molde Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                Limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Datos introducidos no validos, Intentelo de nuevo", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Jtp.requestFocus();
        }
    }

    private void Limpiar() {
        Jtl.setSelectedIndex(0);
        Jtc.setText("");
        Jtl.requestFocus();
        JbDes.setForeground(Color.BLACK);
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
            java.util.logging.Logger.getLogger(NMolde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NMolde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NMolde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NMolde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NMolde dialog = new NMolde(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbDes;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbPrecioa;
    private javax.swing.JLabel JbPrecioa1;
    private javax.swing.JLabel JbProd;
    private javax.swing.JTextField JtCaja;
    private javax.swing.JTextField Jtc;
    private javax.swing.JComboBox<String> Jtl;
    private javax.swing.JTextField Jtp;
    // End of variables declaration//GEN-END:variables
}
