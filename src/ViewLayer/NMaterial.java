package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.Material;
import ObjectLayer.ObjectMateriales;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class NMaterial extends javax.swing.JDialog {

    String informacion = "";
    ObjectMateriales obj = new ObjectMateriales();

    public NMaterial(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        LoadAlmacen();
        setLocationRelativeTo(null);
        JtUcosto.setText("0.00");
        JtCostoC.setText("0.00");
        JtId.setVisible(false);
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

    public String getInformacion() {
        return this.informacion;
    }

    private void LoadAlmacen() {
        Almacen am = new Almacen();
        DefaultComboBoxModel modelAlmacen = new DefaultComboBoxModel(am.getAlmacenes());
        JcAlm.setModel(modelAlmacen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        JbClave = new javax.swing.JLabel();
        JbNombre = new javax.swing.JLabel();
        JbSat = new javax.swing.JLabel();
        JbFconsumo = new javax.swing.JLabel();
        JbFcompra = new javax.swing.JLabel();
        JbConsumo = new javax.swing.JLabel();
        JbAlma = new javax.swing.JLabel();
        JbUcompra = new javax.swing.JLabel();
        JbUcosto = new javax.swing.JLabel();
        JtCv = new javax.swing.JTextField();
        JtNombre = new javax.swing.JTextField();
        JtSat = new javax.swing.JTextField();
        JcUdc = new javax.swing.JComboBox<>();
        JtFcompra = new javax.swing.JTextField();
        JcConsumo = new javax.swing.JComboBox<>();
        JtFconsumo = new javax.swing.JTextField();
        JtUcosto = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JbCostoc = new javax.swing.JLabel();
        JtCostoC = new javax.swing.JTextField();
        JbCminima = new javax.swing.JLabel();
        JtCantidadM = new javax.swing.JTextField();
        JbCmaxima = new javax.swing.JLabel();
        JtCantidadMa = new javax.swing.JTextField();
        JbTipo = new javax.swing.JLabel();
        JtTcosto = new javax.swing.JTextField();
        JbDivisa = new javax.swing.JLabel();
        JcDivisa = new javax.swing.JComboBox<>();
        JcAlm = new javax.swing.JComboBox<>();
        JtId = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MATERIAL");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbClave.setText("Clave:");

        JbNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbNombre.setText("Nombre Mat:");

        JbSat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbSat.setText("Clasificación SAT:");

        JbFconsumo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbFconsumo.setText("Factor Consumo:");

        JbFcompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbFcompra.setText("Factor Compra:");

        JbConsumo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbConsumo.setText("Unidad de consumo:");

        JbAlma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbAlma.setText("Almacén:");

        JbUcompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbUcompra.setText("Unidad M. Compra:");

        JbUcosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbUcosto.setText("Ultimo Costo:");

        JtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtNombreKeyTyped(evt);
            }
        });

        JtSat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtSatKeyTyped(evt);
            }
        });

        JcUdc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "PZ", "LT" }));

        JcConsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "PZ", "LT" }));

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

        JbCostoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCostoc.setText("Costo Costeo:");

        JbCminima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCminima.setText("Cantidad Minima:");

        JbCmaxima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCmaxima.setText("Cantidad Maxima:");

        JbTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTipo.setText("Tipo Costo:");

        JtTcosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtTcostoKeyTyped(evt);
            }
        });

        JbDivisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDivisa.setText("Divisa:");

        JcDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MNX", "USD", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbUcompra)
                        .addGap(27, 27, 27)
                        .addComponent(JcUdc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JbAlma)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbNombre)
                                        .addGap(63, 63, 63)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(JtCv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JtSat, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(JcAlm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(38, 38, 38))
                                    .addComponent(JbClave, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(JbSat))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbConsumo)
                                        .addGap(18, 18, 18)
                                        .addComponent(JcConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbFconsumo)
                                        .addGap(38, 38, 38)
                                        .addComponent(JtFconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbFcompra)
                                        .addGap(48, 48, 48)
                                        .addComponent(JtFcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(JbGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(JbCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(JbCostoc)
                                            .addGap(34, 34, 34))
                                        .addComponent(JbUcosto)
                                        .addComponent(JbCminima))
                                    .addComponent(JbCmaxima)
                                    .addComponent(JbDivisa)
                                    .addComponent(JbTipo))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JcDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JtTcosto)
                                            .addComponent(JtCantidadMa, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                            .addComponent(JtCantidadM)
                                            .addComponent(JtUcosto))
                                        .addComponent(JtCostoC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(JtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbUcosto)
                            .addComponent(JtUcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JbAlma)
                            .addComponent(JcAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbClave)
                            .addComponent(JtCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCostoc)
                            .addComponent(JtCostoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbNombre)
                            .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCminima)
                            .addComponent(JtCantidadM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbSat)
                            .addComponent(JtSat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCmaxima)
                            .addComponent(JtCantidadMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbUcompra)
                    .addComponent(JcUdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbTipo)
                    .addComponent(JtTcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbFcompra)
                    .addComponent(JtFcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbDivisa)
                    .addComponent(JcDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbConsumo)
                    .addComponent(JcConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbFconsumo)
                    .addComponent(JtFconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        int Alm = JcAlm.getSelectedIndex();
        String Nombre = JtNombre.getText();
        Almacen am = (Almacen) JcAlm.getSelectedItem();
        String Cv = JtCv.getText();

        if (JtCv.getText().equals("") || Alm == 0 || JtNombre.getText().equals("") || JtSat.getText().equals("") || JtTcosto.getText().equals("")
                || JtFcompra.getText().equals("") || JtFconsumo.getText().equals("")
                || JtCantidadM.getText().equals("") || JtCantidadMa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JtId.getText().isEmpty()) {
            if (obj.validarMaterial(Nombre, am.getAlmacen(), Cv) == 0 && obj.validarMat(Nombre, am.getAlmacen()) == 0 && obj.validarMatr(am.getAlmacen(), Cv) == 0) {
                Guardar();
            } else {
                JOptionPane.showMessageDialog(this, "Este Material ya esta registrado", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            Editar();
        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void Guardar() {
        String Cv = JtCv.getText();
        String Nombre = JtNombre.getText();
        String Sat = JtSat.getText();
        String Udc = JcUdc.getSelectedItem().toString();
        String Udcs = JcConsumo.getSelectedItem().toString();
        String Tipo = JtTcosto.getText();
        String Divisa = JcDivisa.getSelectedItem().toString();
        Almacen am = (Almacen) JcAlm.getSelectedItem();

        double Fcompra = Double.parseDouble(JtFcompra.getText());
        double Fconsumo = Double.parseDouble(JtFconsumo.getText());
        double Ucosto = Double.parseDouble(JtUcosto.getText());
        double CostoC = Double.parseDouble(JtCostoC.getText());
        double CnMaxima = Double.parseDouble(JtCantidadM.getText());
        double CnMinima = Double.parseDouble(JtCantidadMa.getText());

        Material m = new Material();
        m.setAlmacen(am.getAlmacen());
        m.setCveMat(Cv);
        m.setDescripcion(Nombre);
        m.setCodigoSat(Sat);
        m.setUdeC(Udc);
        m.setFcompra(Fcompra);
        m.setUdeCs(Udcs);
        m.setFconsumo(Fconsumo);
        m.setUltimoCosto(Ucosto);
        m.setCostoCosteo(CostoC);
        m.setCantidadMaxima(CnMaxima);
        m.setCantidadMinima(CnMinima);
        m.setTipoCosto(Tipo);
        m.setDivisa(Divisa);

        if (obj.addMaterial(m)) {
            JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            Limpiar();
            JtUcosto.setText("0.00");
            JtCostoC.setText("0.00");
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Limpiar();
            JtUcosto.setText("0.00");
            JtCostoC.setText("0.00");
        }

    }

    private void Editar() {
        String Cv = JtCv.getText();
        String Nombre = JtNombre.getText();
        String Sat = JtSat.getText();
        String Udc = JcUdc.getSelectedItem().toString();
        String Udcs = JcConsumo.getSelectedItem().toString();
        String Tipo = JtTcosto.getText();
        String Divisa = JcDivisa.getSelectedItem().toString();
        Almacen am = (Almacen) JcAlm.getSelectedItem();

        double Fcompra = Double.parseDouble(JtFcompra.getText());
        double Fconsumo = Double.parseDouble(JtFconsumo.getText());
        double Ucosto = Double.parseDouble(JtUcosto.getText());
        double CostoC = Double.parseDouble(JtCostoC.getText());
        double CnMaxima = Double.parseDouble(JtCantidadM.getText());
        double CnMinima = Double.parseDouble(JtCantidadMa.getText());
        
        Material m = new Material();
        m.setAlmacen(am.getAlmacen());
        m.setCveMat(Cv);
        m.setDescripcion(Nombre);
        m.setCodigoSat(Sat);
        m.setUdeC(Udc);
        m.setFcompra(Fcompra);
        m.setUdeCs(Udcs);
        m.setFconsumo(Fconsumo);
        m.setUltimoCosto(Ucosto);
        m.setCostoCosteo(CostoC);
        m.setCantidadMaxima(CnMaxima);
        m.setCantidadMinima(CnMinima);
        m.setTipoCosto(Tipo);
        m.setDivisa(Divisa);
        if (obj.materialUpdate(m)) {
            JOptionPane.showMessageDialog(this, "Registro Modificado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            dispose();
        }
    }

    private void Limpiar() {
        JcAlm.setSelectedIndex(0);
        JtCv.setText("");
        JtNombre.setText("");
        JtSat.setText("");
        JcUdc.getSelectedItem().toString();
        JtTcosto.setText("");
        JtFcompra.setText("");
        JtFconsumo.setText("");
        JtUcosto.setText("");
        JtCostoC.setText("");
        JtCantidadM.setText("");
        JtCantidadMa.setText("");
    }
    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtNombreKeyTyped

    private void JtSatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSatKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtSatKeyTyped

    private void JtTcostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtTcostoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtTcostoKeyTyped

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
            java.util.logging.Logger.getLogger(NMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NMaterial dialog = new NMaterial(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbAlma;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbClave;
    private javax.swing.JLabel JbCmaxima;
    private javax.swing.JLabel JbCminima;
    private javax.swing.JLabel JbConsumo;
    private javax.swing.JLabel JbCostoc;
    private javax.swing.JLabel JbDivisa;
    private javax.swing.JLabel JbFcompra;
    private javax.swing.JLabel JbFconsumo;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbNombre;
    private javax.swing.JLabel JbSat;
    private javax.swing.JLabel JbTipo;
    private javax.swing.JLabel JbUcompra;
    private javax.swing.JLabel JbUcosto;
    public javax.swing.JComboBox<String> JcAlm;
    public javax.swing.JComboBox<String> JcConsumo;
    public javax.swing.JComboBox<String> JcDivisa;
    public javax.swing.JComboBox<String> JcUdc;
    public javax.swing.JTextField JtCantidadM;
    public javax.swing.JTextField JtCantidadMa;
    public javax.swing.JTextField JtCostoC;
    public javax.swing.JTextField JtCv;
    public javax.swing.JTextField JtFcompra;
    public javax.swing.JTextField JtFconsumo;
    public javax.swing.JTextField JtId;
    public javax.swing.JTextField JtNombre;
    public javax.swing.JTextField JtSat;
    public javax.swing.JTextField JtTcosto;
    public javax.swing.JTextField JtUcosto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
