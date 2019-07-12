package ViewLayer;

import ObjectLayer.ObjectConceptos;
import ObjectLayer.ObjectParametros;
import ObjectLayer.Parametro;
import ObjectLayer.Sesioninfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class MovimientosCPT extends javax.swing.JFrame {

    ObjectParametros Par = new ObjectParametros();
    ObjectConceptos concepto = new ObjectConceptos();
    Sesioninfo sesion = new Sesioninfo();

    public MovimientosCPT() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        JbSerie.setText(sesion.getSerie());
        ocultarCampos();
        Calendar fecha = new GregorianCalendar();
        JdFecha.setCalendar(fecha);
        JdFecha.setEnabled(false);
        JtCuenta.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        JcaDestino = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        JtpC = new javax.swing.JTextField();
        JpSuela = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JlSuela = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JtsubCuenta = new javax.swing.JTextField();
        JdFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        JbSerie = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JbFolio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JtCuenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JcPrimer = new javax.swing.JCheckBox();
        JtcP = new javax.swing.JTextField();
        JtSuela = new javax.swing.JTextField();
        JcaOrigen = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatos = new javax.swing.JTable();
        JbfolioSalida = new javax.swing.JLabel();
        JbcuentaSalida = new javax.swing.JLabel();
        JbsubCuentaSalida = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JtDoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIMIENTOS CPT");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Refresh_36729.png"))); // NOI18N

        JcaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Precio / Costo");

        JpSuela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JlSuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlSuelaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JlSuela);

        javax.swing.GroupLayout JpSuelaLayout = new javax.swing.GroupLayout(JpSuela);
        JpSuela.setLayout(JpSuelaLayout);
        JpSuelaLayout.setHorizontalGroup(
            JpSuelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSuelaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        JpSuelaLayout.setVerticalGroup(
            JpSuelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpSuelaLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setText("Cl / Pr");

        jLabel7.setText("SubCuenta:");

        JtsubCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtsubCuentaActionPerformed(evt);
            }
        });

        jLabel9.setText("Almacén:");

        JbSerie.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        JbSerie.setForeground(new java.awt.Color(255, 51, 51));
        JbSerie.setText("A");

        jLabel10.setText("Suela:");

        jLabel1.setText("Folio:");

        JbFolio.setForeground(new java.awt.Color(51, 153, 0));
        JbFolio.setText("XXXXXX");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Cuenta:");

        JtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCuentaActionPerformed(evt);
            }
        });

        jLabel5.setText("Prioridad:");

        JcPrimer.setText("PRIMER");

        JtSuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtSuelaKeyReleased(evt);
            }
        });

        JcaOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        JtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtDatos);

        JbfolioSalida.setForeground(new java.awt.Color(51, 153, 0));
        JbfolioSalida.setText("XXXXXX");

        JbcuentaSalida.setText("Cuenta");

        JbsubCuentaSalida.setText("Scuenta");

        jLabel2.setText("Doc. Ref:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JtcP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbfolioSalida)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtsubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(JbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JcPrimer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(JbcuentaSalida)
                                .addGap(28, 28, 28)
                                .addComponent(JbsubCuentaSalida)
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(JcaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addComponent(JcaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(JtpC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(JpSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JcPrimer)
                        .addComponent(jLabel5)
                        .addComponent(JbSerie)
                        .addComponent(JbcuentaSalida)
                        .addComponent(JbsubCuentaSalida))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(JbFolio)
                        .addComponent(JbfolioSalida)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JtsubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(JcaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(JcaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtcP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(JtpC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarFolio() {
        int entrada = 1, salida = 50000;

        int cuenta = Integer.parseInt(JtCuenta.getText());
        int subCuenta = Integer.parseInt(JtsubCuenta.getText());

        if (cuenta < 50) {
            ArrayList<Parametro> listE = Par.getFolioEntrada();
            ArrayList<Parametro> listS = Par.getFolioSalida();
            if (subCuenta != 16) {
                for (Parametro par : listE) {
                    int F = par.getEntrada();
                    if (F > 0) {
                        int var = entrada + F;
                        JbFolio.setText(String.valueOf(var));
                        JtDoc.setText(String.valueOf(var));
                    } else {
                        JbFolio.setText(String.valueOf(entrada));
                        JtDoc.setText(String.valueOf(entrada));
                    }
                }
            } else if(cuenta == 1 && subCuenta == 16) {
                for (Parametro par : listE) {
                    int F = par.getEntrada();
                    if (F > 0) {
                        int var = entrada + F;
                        JbFolio.setText(String.valueOf(var));
                        JtDoc.setText(String.valueOf(var));
                    } else {
                        JbFolio.setText(String.valueOf(entrada));
                        JtDoc.setText(String.valueOf(entrada));
                    }
                }
                
                JbfolioSalida.setVisible(true);
                for (Parametro par : listS) {
                    int F = par.getSalida();
                    
                    if (F > 0) {
                        int var = salida + F;
                        JbfolioSalida.setText(String.valueOf(var));
                    } else {
                        JbfolioSalida.setText(String.valueOf(salida));
                    }
                }
            }
            
            

        } else if (cuenta >= 50) {

            ArrayList<Parametro> listP = Par.getFolioSalida();
            for (Parametro par : listP) {
                int F = par.getSalida();
                if (F > 0) {
                    int var = entrada + F;
                    JbFolio.setText(String.valueOf(var));
                    JtDoc.setText(String.valueOf(var));
                } else {
                    JbFolio.setText(String.valueOf(salida));
                    JtDoc.setText(String.valueOf(salida));
                }
            }
        }

    }

    private void ocultarCampos() {
        JpSuela.setVisible(false);
        JbfolioSalida.setVisible(false);
    }

    private void JlSuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlSuelaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JlSuelaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void JtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCuentaActionPerformed
        if (concepto.validarCuenta(JtCuenta.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Esta cuenta no existe", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JtsubCuenta.requestFocus();
        }
    }//GEN-LAST:event_JtCuentaActionPerformed

    private void JtsubCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtsubCuentaActionPerformed
        if (concepto.validarSubCuenta(JtsubCuenta.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Esta Subcuenta no existe", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        } else {
           
                cargarFolio();
            
        }
    }//GEN-LAST:event_JtsubCuentaActionPerformed

    private void JtSuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyReleased
        JpSuela.setVisible(true);
    }//GEN-LAST:event_JtSuelaKeyReleased

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
            java.util.logging.Logger.getLogger(MovimientosCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosCPT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbFolio;
    public javax.swing.JLabel JbSerie;
    private javax.swing.JLabel JbcuentaSalida;
    private javax.swing.JLabel JbfolioSalida;
    private javax.swing.JLabel JbsubCuentaSalida;
    private javax.swing.JCheckBox JcPrimer;
    private javax.swing.JComboBox<String> JcaDestino;
    private javax.swing.JComboBox<String> JcaOrigen;
    private com.toedter.calendar.JDateChooser JdFecha;
    private javax.swing.JList<String> JlSuela;
    private javax.swing.JPanel JpSuela;
    private javax.swing.JTextField JtCuenta;
    private javax.swing.JTable JtDatos;
    private javax.swing.JTextField JtDoc;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JTextField JtcP;
    private javax.swing.JTextField JtpC;
    private javax.swing.JTextField JtsubCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
