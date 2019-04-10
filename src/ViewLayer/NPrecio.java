package ViewLayer;

import ObjectLayer.Cliente;
import ObjectLayer.ObjectPrecios;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Precio;
import ObjectLayer.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class NPrecio extends javax.swing.JDialog {

    ObjectPrecios op = new ObjectPrecios();
    ObjectProductos ObjP = new ObjectProductos();
    String informacion = "";
    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();

    public NPrecio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LoadModelCliente();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        JbIdProd.setVisible(false);
        Jtid.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void LoadModelCliente() {
        Cliente cl = new Cliente();
        DefaultComboBoxModel modelCliente = new DefaultComboBoxModel(cl.getClientes());
        JcCliente.setModel(modelCliente);
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

        JbDes = new javax.swing.JLabel();
        JbProd = new javax.swing.JLabel();
        JbPrecioa = new javax.swing.JLabel();
        JbPreciob = new javax.swing.JLabel();
        JcCliente = new javax.swing.JComboBox<>();
        Jta = new javax.swing.JTextField();
        Jtb = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        JtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        JbIdProd = new javax.swing.JLabel();
        Jtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JtaP = new javax.swing.JTextField();
        JtbP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRECIO");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDes.setText("Cliente:");

        JbProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbProd.setText("Producto:");

        JbPrecioa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecioa.setText("Precio A:");

        JbPreciob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPreciob.setText("Precio B:");

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

        JtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtProductoKeyTyped(evt);
            }
        });

        listaProductos.setModel(modeloListaProductos);
        listaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaProductos);

        JbIdProd.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Precio A Premiere:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Precio B Premiere:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbProd)
                            .addComponent(JbDes)
                            .addComponent(JbPrecioa)
                            .addComponent(JbPreciob)
                            .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Jta, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(Jtb))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JtbP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(JtaP, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(83, 83, 83))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JcCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JtProducto)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbGuardar)
                                .addGap(50, 50, 50)
                                .addComponent(JbCerrar)
                                .addContainerGap(120, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbDes)
                            .addComponent(JcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(JbProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbPreciob))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(JbPrecioa)
                            .addComponent(JtaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(JtbP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JbGuardar)
                        .addComponent(JbCerrar)))
                .addGap(9, 9, 9)
                .addComponent(JbIdProd)
                .addContainerGap())
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
        Cliente cliente = (Cliente) JcCliente.getSelectedItem();
        int Idp = Integer.parseInt(JbIdProd.getText());

        if (Jta.getText().equals("") || Jtb.getText().equals("") || JcCliente.getSelectedIndex() == 0
                || JtProducto.getText().equals("") || JbIdProd.getText().equals("0") || JtaP.getText().equals("")
                || JtbP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (Jtid.getText().isEmpty()) {
            if (op.validarLista(Idp, cliente.getId_Cliente()) == 0) {
                Guardar();
            } else {
                JOptionPane.showMessageDialog(this, "Esta lista ya existe", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            Editar();
        }


    }//GEN-LAST:event_JbGuardarActionPerformed

    private void Guardar() {
        Cliente cliente = (Cliente) JcCliente.getSelectedItem();
        int Idp = Integer.parseInt(JbIdProd.getText());

        Precio precio = new Precio();
        precio.setId_Cliente(cliente.getId_Cliente());
        precio.setId_Producto(Idp);
        precio.setPrecioA(Double.parseDouble(Jta.getText()));
        precio.setPrecioB(Double.parseDouble(Jtb.getText()));
        precio.setPrecioAP(Double.parseDouble(JtaP.getText()));
        precio.setPrecioBP(Double.parseDouble(JtbP.getText()));
        precio.setActivo(true);

        if (op.precioAdd(precio)) {
            JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Limpiar();
        }
    }

    private void Editar() {
        Cliente cliente = (Cliente) JcCliente.getSelectedItem();
        int Idp = Integer.parseInt(Jtid.getText());

        Precio precio = new Precio();
        
        precio.setPrecioA(Double.parseDouble(Jta.getText()));
        precio.setPrecioB(Double.parseDouble(Jtb.getText()));
        precio.setPrecioAP(Double.parseDouble(JtaP.getText()));
        precio.setPrecioBP(Double.parseDouble(JtbP.getText()));
        precio.setId_Cliente(cliente.getId_Cliente());
        precio.setId_Producto(Idp);
        
        if (op.precioUpdate(precio)) {
            JOptionPane.showMessageDialog(this, "Registro Editado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }
    }

    private void JtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtProductoKeyTyped

    private void listaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProductosMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Producto prod = (Producto) lis.getSelectedValue();
            JtProducto.setText(prod.getDescripcion());
            JbIdProd.setText(String.valueOf(prod.getId_Producto()));
            limpiarListaProductos();
            Jta.requestFocus();
        }
    }//GEN-LAST:event_listaProductosMouseClicked

    private void JtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyReleased
        limpiarListaProductos();
        if (JtProducto.getText().isEmpty()) {
            limpiarListaProductos();
        } else {
            ArrayList<Producto> listaProductos = ObjP.GetByCosto(JtProducto.getText());

            for (Producto prod : listaProductos) {
                modeloListaProductos.addElement(prod);
            }
        }
    }//GEN-LAST:event_JtProductoKeyReleased

    private void limpiarListaProductos() {
        modeloListaProductos.clear();
    }

    private void Limpiar() {
        JcCliente.setSelectedIndex(0);
        JtProducto.setText("");
        Jta.setText("");
        Jtb.setText("");
        JcCliente.requestFocus();
        JtaP.setText("");
        JtbP.setText("");
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
            java.util.logging.Logger.getLogger(NPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NPrecio dialog = new NPrecio(new javax.swing.JFrame(), true);
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
    public javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbPrecioa;
    private javax.swing.JLabel JbPreciob;
    private javax.swing.JLabel JbProd;
    public javax.swing.JComboBox<String> JcCliente;
    public javax.swing.JTextField JtProducto;
    public javax.swing.JTextField Jta;
    public javax.swing.JTextField JtaP;
    public javax.swing.JTextField Jtb;
    public javax.swing.JTextField JtbP;
    public javax.swing.JTextField Jtid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Producto> listaProductos;
    // End of variables declaration//GEN-END:variables
}
