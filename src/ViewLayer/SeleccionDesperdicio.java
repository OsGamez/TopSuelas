package ViewLayer;

import ObjectLayer.Consumo;
import ObjectLayer.Linea;
import ObjectLayer.ObjectConsumos;
import ObjectLayer.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class SeleccionDesperdicio extends javax.swing.JDialog {

    String informacion = "";
    Vector<Linea> listalineas = new Vector<>();
    Vector<Producto> listaproductos = new Vector<>();

    public SeleccionDesperdicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        ButtonGroup bg = new ButtonGroup();
        bg.add(Jcs);
        bg.add(Jct);
        bg.add(Jcl);
        Jct.setSelected(true);
        jcp.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void LoadLineas() {
        Linea l = new Linea();
        DefaultComboBoxModel modelselect = new DefaultComboBoxModel(l.getLinea());
        listalineas = l.getLinea();
        jcp.setModel(modelselect);
    }

    private void LoadProductos() {
        Producto l = new Producto();
        DefaultComboBoxModel modelselect = new DefaultComboBoxModel(l.getProdP());
        listaproductos = l.getProdP();
        jcp.setModel(modelselect);
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
     private void limpiar() {
        listalineas.clear();
        listalineas.clear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbGuardar = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        Jcd = new javax.swing.JComboBox<>();
        JbPrecioa1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcp = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Jct = new javax.swing.JRadioButton();
        Jcs = new javax.swing.JRadioButton();
        Jcl = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVA LISTA");
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

        Jcd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9", "15" }));
        Jcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcdActionPerformed(evt);
            }
        });

        JbPrecioa1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa1.setText("Desperdicio ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Selecciona lo que quieres modificar");

        jcp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcpActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("%");

        Jct.setText("Todo");
        Jct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JctActionPerformed(evt);
            }
        });

        Jcs.setText("Suela");
        Jcs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcsActionPerformed(evt);
            }
        });

        Jcl.setText("Linea");
        Jcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JclActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbPrecioa1)
                        .addGap(22, 22, 22)
                        .addComponent(Jcd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JbGuardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JbCerrar))
                                .addComponent(jcp, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Jct)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Jcl)
                            .addGap(68, 68, 68)
                            .addComponent(Jcs))))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jcs)
                    .addComponent(Jct)
                    .addComponent(Jcl))
                .addGap(22, 22, 22)
                .addComponent(jcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbPrecioa1)
                    .addComponent(jLabel2))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(JbCerrar))
                .addContainerGap(28, Short.MAX_VALUE))
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
        ModificaConsumos();
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcdActionPerformed

    private void jcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcpActionPerformed
//        System.out.println(jcp.getSelectedItem() +" "+listaProductos.get(jcp.getSelectedIndex()).getId_Producto());
    }//GEN-LAST:event_jcpActionPerformed

    private void JcsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcsActionPerformed
        jcp.setVisible(true);
        LoadProductos();
    }//GEN-LAST:event_JcsActionPerformed

    private void JclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JclActionPerformed
        jcp.setVisible(true);
        LoadLineas();
    }//GEN-LAST:event_JclActionPerformed

    private void JctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JctActionPerformed
        jcp.setVisible(false);
    }//GEN-LAST:event_JctActionPerformed

    private void ModificaConsumos() {

        ObjectConsumos obsumos = new ObjectConsumos();
        Consumo sumos = new Consumo();
        String where = "";
        int id=0;
            if (Jcs.isSelected()) {
                where = "where p.id_producto=" + listaproductos.get(jcp.getSelectedIndex()).getId_Producto() + "";
                id=listaproductos.get(jcp.getSelectedIndex()).getId_Producto();
            } else if (Jcl.isSelected()) {
                where = "where p.id_linea=" + listalineas.get(jcp.getSelectedIndex()).getId_Linea() + "";
                id=listalineas.get(jcp.getSelectedIndex()).getId_Linea();
            }
            sumos.setProducto(id);
            sumos.setConsulta(where);
            sumos.setDesperdicio((Float.parseFloat(Jcd.getSelectedItem().toString())/100)+1);
            if (obsumos.ConsumoUpdateDesperdicio(sumos)) {
                JOptionPane.showMessageDialog(this, "Consumos Modificados Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                limpiar();
                Cerrar();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
               
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
            java.util.logging.Logger.getLogger(SeleccionDesperdicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionDesperdicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionDesperdicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionDesperdicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                SeleccionDesperdicio dialog = new SeleccionDesperdicio(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbPrecioa1;
    private javax.swing.JComboBox<String> Jcd;
    private javax.swing.JRadioButton Jcl;
    private javax.swing.JRadioButton Jcs;
    private javax.swing.JRadioButton Jct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jcp;
    // End of variables declaration//GEN-END:variables
}
