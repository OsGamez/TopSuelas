package ViewLayer;

import ObjectLayer.ObjectColores;
import ObjectLayer.ObjectCorridas;
import ObjectLayer.Color;
import ObjectLayer.Corrida;
import ObjectLayer.Linea;
import ObjectLayer.ObjectLineas;
import ObjectLayer.Producto;
import ObjectLayer.ObjectProductos;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NProducto extends javax.swing.JDialog {

    ObjectColores cl = new ObjectColores();
    ObjectCorridas cr = new ObjectCorridas();
    ObjectLineas ln = new ObjectLineas();
    ObjectProductos op = new ObjectProductos();
    String informacion = "";

    public NProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        initComponents();
        LoadModelColor();
        LoadModelCorrida();
        LoadModelLinea();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        Jtid.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void LoadModelColor() {
        Color cl = new Color();
        DefaultComboBoxModel modelColor = new DefaultComboBoxModel(cl.getColores());
        JcColor.setModel(modelColor);
    }

    private void LoadModelCorrida() {
        Corrida cr = new Corrida();
        DefaultComboBoxModel modelCorrida = new DefaultComboBoxModel(cr.getCorrida());
        JcCorrida.setModel(modelCorrida);
    }

    private void LoadModelLinea() {
        Linea ln = new Linea();
        DefaultComboBoxModel modelLinea = new DefaultComboBoxModel(ln.getLinea());
        JcLinea.setModel(modelLinea);
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
        JbObv = new javax.swing.JLabel();
        JbColor = new javax.swing.JLabel();
        JbCorrida = new javax.swing.JLabel();
        JtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JaObservacion = new javax.swing.JTextArea();
        JcColor = new javax.swing.JComboBox<>();
        JcCorrida = new javax.swing.JComboBox<>();
        JtGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JbLinea = new javax.swing.JLabel();
        JcLinea = new javax.swing.JComboBox<>();
        Jtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTO");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDes.setText("Descripción:");

        JbObv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbObv.setText("Observaciones:");

        JbColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbColor.setText("Color:");

        JbCorrida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCorrida.setText("Corrida:");

        JtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtNombreKeyTyped(evt);
            }
        });

        JaObservacion.setColumns(20);
        JaObservacion.setRows(5);
        JaObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JaObservacionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(JaObservacion);

        JtGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saveas_1173.png"))); // NOI18N
        JtGuardar.setText("REGISTRAR");
        JtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtGuardarActionPerformed(evt);
            }
        });

        JbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JbCancelar.setText("CANCELAR");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        JbLinea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbLinea.setText("Linea:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbDes)
                            .addComponent(JbColor)
                            .addComponent(JbCorrida)
                            .addComponent(JbLinea))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JcCorrida, 0, 270, Short.MAX_VALUE)
                            .addComponent(JtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(JcColor, 0, 270, Short.MAX_VALUE)
                            .addComponent(JcLinea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbObv)
                            .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JbCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbDes)
                    .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbColor)
                    .addComponent(JcColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(JbCorrida))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbLinea)
                    .addComponent(JcLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbObv)
                        .addGap(29, 29, 29)
                        .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbCancelar)
                    .addComponent(JtGuardar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtGuardarActionPerformed

        int color = JcColor.getSelectedIndex();
        int corrida = JcCorrida.getSelectedIndex();
        int linea = JcLinea.getSelectedIndex();

        if (JtNombre.getText().isEmpty() || color == 0 || corrida == 0 || linea == 0) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if(Jtid.getText().isEmpty()){
            Guardar();
        }else{
            Editar();
        }
    }//GEN-LAST:event_JtGuardarActionPerformed

    private void Guardar() {
        Color cl = (Color) JcColor.getSelectedItem();
        Corrida cr = (Corrida) JcCorrida.getSelectedItem();
        Linea ln = (Linea) JcLinea.getSelectedItem();
        String Nombre = JtNombre.getText();
        String Obv = JaObservacion.getText();

        Producto producto = new Producto();
        producto.setDescripcion(Nombre);
        producto.setObservaciones(Obv);
        producto.setId_Color(cl.getId_Color());
        producto.setId_Corrida(cr.getId_Corrida());
        producto.setActivo(true);
        producto.setId_Linea(ln.getId_Linea());
        if (op.productoAdd(producto)) {
            JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Limpiar();
        }
    }

    private void Editar() {
        Color cl = (Color) JcColor.getSelectedItem();
        Corrida cr = (Corrida) JcCorrida.getSelectedItem();
        Linea ln = (Linea) JcLinea.getSelectedItem();
        String Nombre = JtNombre.getText();
        String Obv = JaObservacion.getText();

        Producto producto = new Producto();
        int id = Integer.parseInt(Jtid.getText());
        producto.setDescripcion(Nombre);
        producto.setObservaciones(Obv);
        producto.setId_Color(cl.getId_Color());
        producto.setId_Corrida(cr.getId_Corrida());
        producto.setActivo(true);
        producto.setId_Linea(ln.getId_Linea());
        producto.setId_Producto(id);
        if (op.productoUpdate(producto)) {
            JOptionPane.showMessageDialog(this, "Registro Editado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }
    }

    private void JtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtNombreKeyTyped

    private void JaObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JaObservacionKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JaObservacionKeyTyped

    private void Limpiar() {
        this.JtNombre.setText("");
        this.JaObservacion.setText("");
        this.JcLinea.setSelectedIndex(0);
        this.JcColor.setSelectedIndex(0);
        this.JcCorrida.setSelectedIndex(0);
        JtNombre.requestFocus();
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
            java.util.logging.Logger.getLogger(NProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NProducto dialog = new NProducto(new javax.swing.JFrame(), true);
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
    public javax.swing.JTextArea JaObservacion;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbColor;
    private javax.swing.JLabel JbCorrida;
    private javax.swing.JLabel JbDes;
    private javax.swing.JLabel JbLinea;
    private javax.swing.JLabel JbObv;
    public javax.swing.JComboBox<String> JcColor;
    public javax.swing.JComboBox<String> JcCorrida;
    public javax.swing.JComboBox<String> JcLinea;
    private javax.swing.JButton JtGuardar;
    public javax.swing.JTextField JtNombre;
    public javax.swing.JTextField Jtid;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
