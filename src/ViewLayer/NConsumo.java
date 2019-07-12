package ViewLayer;

import ObjectLayer.Consumo;
import ObjectLayer.ObjectConsumos;
import ObjectLayer.Producto;
import ObjectLayer.Validacion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NConsumo extends javax.swing.JDialog {

    String informacion = "";
    Vector<Producto> listaProductos = new Vector<Producto>();
    

    public NConsumo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        LoadProductos();
        setLocationRelativeTo(null);
    }

    public String getInformacion() {
        return this.informacion;
    }
    private void LoadProductos(){
    Producto p = new Producto();
     DefaultComboBoxModel modelproducto = new  DefaultComboBoxModel(p.getProdP());
     listaProductos=p.getProdP();
     jcp.setModel(modelproducto);
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
        Jcepeso = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        Jcp = new javax.swing.JTextField();
        JbPrecioa1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcp = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Jcd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVA LISTA");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbProd.setText("Punto");

        JbPrecioa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa.setText("Peso");

        Jcepeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcepesoActionPerformed(evt);
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

        Jcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcpActionPerformed(evt);
            }
        });

        JbPrecioa1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa1.setText("Desperdicio ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Suela");

        jcp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcpActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("%");

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
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbProd)
                    .addComponent(JbPrecioa1)
                    .addComponent(JbPrecioa)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jcd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Jcepeso, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(Jcp)))
                        .addGap(67, 67, 67))
                    .addComponent(jcp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(JbGuardar)
                .addGap(50, 50, 50)
                .addComponent(JbCerrar)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbProd)
                    .addComponent(Jcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPrecioa)
                    .addComponent(Jcepeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPrecioa1)
                    .addComponent(jLabel2)
                    .addComponent(Jcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(JbCerrar))
                .addGap(25, 25, 25))
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
        nuevoConsumo();
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcpActionPerformed
        Jcepeso.requestFocus();
    }//GEN-LAST:event_JcpActionPerformed

    private void JcepesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcepesoActionPerformed
        JbGuardar.requestFocus();
        JbGuardar.setSelected(true);
    }//GEN-LAST:event_JcepesoActionPerformed

    private void jcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcpActionPerformed
//        System.out.println(jcp.getSelectedItem() +" "+listaProductos.get(jcp.getSelectedIndex()).getId_Producto());
    }//GEN-LAST:event_jcpActionPerformed

    private void JcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcdActionPerformed

    private void nuevoConsumo() {
        Validacion v = new Validacion();
        System.out.println(v.verificapunto(Jcp.getText()) +" "+ v.verificaflotantes(Jcepeso.getText()));
        if ( Jcepeso.getText().equals("") && Jcp.getText().equals("") && jcp.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Jcp.requestFocus();
        } else if ((v.verificapunto(Jcp.getText())|| v.puntoflotante(Jcp.getText())) && v.verificaflotantes(Jcepeso.getText())) {//
            ObjectConsumos obsumos = new ObjectConsumos();
            Consumo sumos = new Consumo();
            sumos.setProducto(listaProductos.get(jcp.getSelectedIndex()).getId_Producto());
            sumos.setDesperdicio((Float.parseFloat(Jcd.getText())/100));
            sumos.setPeso(Float.parseFloat(Jcepeso.getText()));
            String punto=Jcp.getText();
            if(Jcp.getText().length()>1){
                punto = String.valueOf(Float.parseFloat(Jcp.getText())*10);
            }
            sumos.setPunto(Float.parseFloat(punto));
            if(obsumos.BuscaConsumob(sumos)){
            if (obsumos.ConsumoAdd(sumos)) {
                JOptionPane.showMessageDialog(this, "Consumo Almacenado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                Limpiar();
                Cerrar();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
                Limpiar();
            }
            }else{ JOptionPane.showMessageDialog(this, "Ya existe el producto con el punto seleccionado! o \n no entra dentro del rango de la corrida", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                Limpiar();
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Datos introducidos no validos, Intentelo de nuevo", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Jcp.requestFocus();
        }
    }

    private void Limpiar() {
        Jcepeso.setText("");
        Jcp.setText("");
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
            java.util.logging.Logger.getLogger(NConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                NConsumo dialog = new NConsumo(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbPrecioa1;
    private javax.swing.JLabel JbProd;
    private javax.swing.JTextField Jcd;
    private javax.swing.JTextField Jcepeso;
    private javax.swing.JTextField Jcp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jcp;
    // End of variables declaration//GEN-END:variables
}
