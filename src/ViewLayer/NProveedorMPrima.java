package ViewLayer;

import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.ProveedorMPrima;
import ObjectLayer.Validacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class NProveedorMPrima extends javax.swing.JDialog {

    String informacion = "";
    ObjectProveedoresMPrima pv = new ObjectProveedoresMPrima();

    public NProveedorMPrima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        Jtid.setVisible(false);
        JtNombre.requestFocus();
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

        jLabel1 = new javax.swing.JLabel();
        JtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JtRfc = new javax.swing.JTextField();
        JtDir = new javax.swing.JTextField();
        JtCol = new javax.swing.JTextField();
        JtTel = new javax.swing.JTextField();
        JtCp = new javax.swing.JTextField();
        JtEmbarque = new javax.swing.JTextField();
        JtCorreo = new javax.swing.JTextField();
        JtContacto = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        Jtid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JtCiudad = new javax.swing.JTextField();
        Jtpais = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JtTelaux = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JtCredito = new javax.swing.JTextField();
        JtLcredito = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        JtEstado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Proveedor de materia prima");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        JtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtNombreActionPerformed(evt);
            }
        });
        JtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("RFC:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Calle:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Colonia:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CP:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Embarque:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Correo:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Contacto:");

        JtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtRfcActionPerformed(evt);
            }
        });
        JtRfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtRfcKeyTyped(evt);
            }
        });

        JtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtDirActionPerformed(evt);
            }
        });
        JtDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtDirKeyTyped(evt);
            }
        });

        JtCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtColActionPerformed(evt);
            }
        });
        JtCol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtColKeyTyped(evt);
            }
        });

        JtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtTelActionPerformed(evt);
            }
        });

        JtCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCpActionPerformed(evt);
            }
        });
        JtCp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCpKeyTyped(evt);
            }
        });

        JtEmbarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtEmbarqueActionPerformed(evt);
            }
        });
        JtEmbarque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtEmbarqueKeyTyped(evt);
            }
        });

        JtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCorreoActionPerformed(evt);
            }
        });
        JtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCorreoKeyTyped(evt);
            }
        });

        JtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtContactoActionPerformed(evt);
            }
        });
        JtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtContactoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtContactoKeyTyped(evt);
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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ciudad");

        JtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCiudadActionPerformed(evt);
            }
        });
        JtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCiudadKeyTyped(evt);
            }
        });

        Jtpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtpaisActionPerformed(evt);
            }
        });
        Jtpais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtpaisKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("País:");

        JtTelaux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtTelauxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Telefono Auxiliar:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Dias de credito:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Limite de credito:");

        JtCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCreditoActionPerformed(evt);
            }
        });
        JtCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCreditoKeyTyped(evt);
            }
        });

        JtLcredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtLcreditoActionPerformed(evt);
            }
        });
        JtLcredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtLcreditoKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Estado:");

        JtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtEstadoActionPerformed(evt);
            }
        });
        JtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtEstadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JbGuardar)
                .addGap(58, 58, 58)
                .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(105, 666, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JtTelaux, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JtDir, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(JtRfc)
                                        .addComponent(JtNombre)
                                        .addComponent(JtCol, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JtCiudad)
                                        .addComponent(Jtpais))
                                    .addComponent(JtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JtLcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JtContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                            .addComponent(JtCorreo)
                                            .addComponent(JtCp, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                            .addComponent(JtEmbarque)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(JtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(JtCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JtEmbarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(JtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(JtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(JtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(JtLcredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(JtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(Jtpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(JtTelaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JbCancelar)
                        .addComponent(JbGuardar)))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        if (JtNombre.getText().isEmpty() || JtRfc.getText().isEmpty() || JtDir.getText().isEmpty()
                || JtCol.getText().isEmpty() || JtTel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faltan datos de ingresar ", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (Jtid.getText().isEmpty()) {
            if (pv.validarProveedor(JtNombre.getText(), JtRfc.getText()) == 0) {
                Guardar();
            } else {
                JOptionPane.showMessageDialog(null, "El registro ya existe", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (JtNombre.getText().isEmpty() || JtRfc.getText().isEmpty() || JtDir.getText().isEmpty()
                    || JtCol.getText().isEmpty() || JtTel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Faltan datos de ingresar o estan vacios", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                Editar();
            }
        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void Guardar() {
        Validacion v = new Validacion();
        if (v.verificanumeros(JtCp.getText()) && v.verificanumeros(JtTel.getText()) && v.verificanumeros(JtTelaux.getText())) {
            Calendar fecha = Calendar.getInstance();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            String fechac = año + "-" + mes + "-" + dia;
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            String horas = formatofecha(hora, minuto);
            ProveedorMPrima p = new ProveedorMPrima();
            p.setNombre(JtNombre.getText().toUpperCase());
            p.setCalle(JtDir.getText().toUpperCase());
            p.setColonia(JtCol.getText().toUpperCase());
            p.setCiudad(JtCiudad.getText().toUpperCase());
            p.setEstado(JtEstado.getText().toUpperCase());
            p.setPais(Jtpais.getText().toUpperCase());
            p.setCp(JtCp.getText());
            p.setRfc(JtRfc.getText().toUpperCase());
            p.setEmail(JtCorreo.getText());
            p.setTelefono(JtTel.getText());
            p.setTelefono2(JtTelaux.getText());
            p.setContacto(JtContacto.getText().toUpperCase());
            p.setEmbarque(JtEmbarque.getText().toUpperCase());
            p.setDiascredito(Integer.parseInt(JtCredito.getText()));
            p.setLimitecredito(JtLcredito.getText().toUpperCase());
            p.setFechaultima(fechac + " " + horas);
            p.setTpo("");
            if (pv.ProveedorMPrimaAdd(p)) {
                JOptionPane.showMessageDialog(this, "Registro creado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                Limpiar();
                JtNombre.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                Limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos \n PD: El campo de telefono y codigo postal solamente se ingresar numeros", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JtCp.requestFocus();
        }

    }

    private void Editar() {
       
        Validacion v = new Validacion();
        if (v.verificanumeros(JtCp.getText()) && v.verificanumeros(JtTel.getText()) && v.verificanumeros(JtTelaux.getText())) {
            Calendar fecha = Calendar.getInstance();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            String fechac = año + "-" + mes + "-" + dia;
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            String horas = formatofecha(hora, minuto);
             ProveedorMPrima p = new ProveedorMPrima();
            p.setProveedor(Integer.parseInt(Jtid.getText()));
            p.setNombre(JtNombre.getText().toUpperCase());
            p.setCalle(JtDir.getText().toUpperCase());
            p.setColonia(JtCol.getText().toUpperCase());
            p.setCiudad(JtCiudad.getText().toUpperCase());
            p.setEstado(JtEstado.getText().toUpperCase());
            p.setPais(Jtpais.getText().toUpperCase());
            p.setCp(JtCp.getText());
            p.setRfc(JtRfc.getText().toUpperCase());
            p.setEmail(JtCorreo.getText());
            p.setTelefono(JtTel.getText());
            p.setTelefono2(JtTelaux.getText());
            p.setContacto(JtContacto.getText().toUpperCase());
            p.setEmbarque(JtEmbarque.getText().toUpperCase());
            p.setDiascredito(Integer.parseInt(JtCredito.getText()));
            p.setLimitecredito(JtLcredito.getText().toUpperCase());
            p.setFechaultima(fechac + " " + horas);
            p.setTpo("");
            
            if (pv.ProveedorMPrimaUpdate(p)) {
                JOptionPane.showMessageDialog(this, "Registro editado correctamente !!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                informacion = "1";
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                Limpiar();
            }
        }else {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos \n PD: El campo de telefono y codigo postal solamente se ingresar numeros", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JtCp.requestFocus();
        }

    }

    private void Limpiar() {
        JtNombre.setText("");
        JtCiudad.setText("");
        JtEstado.setText("");
        Jtpais.setText("");
        JtCredito.setText("");
        JtLcredito.setText("");
        JtDir.setText("");
        JtCorreo.setText("");
        JtCol.setText("");
        JtCp.setText("");
        JtEmbarque.setText("");
        JtContacto.setText("");
        JtTel.setText("");
        JtRfc.setText("");
        Jtid.setText("");
    }

    private String formatofecha(int hora, int minuto) {
        String horas = "";
        if (hora > 9) {
            horas = hora + ":";
        }
        if (hora < 10) {
            horas = "0" + hora + ":";
        }
        if (minuto < 10) {
            horas = horas + "0" + minuto;
        }
        if (minuto > 9) {
            horas += minuto;
        }
        horas = (horas.length() == 5) ? horas : "0" + horas;
        return horas;
    }

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void JtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNombreKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtNombreKeyTyped

    private void JtRfcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtRfcKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtRfcKeyTyped

    private void JtDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtDirKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtDirKeyTyped

    private void JtColKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtColKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtColKeyTyped

    private void JtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtContactoKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtContactoKeyTyped

    private void JtContactoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtContactoKeyReleased
        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_ENTER)
                && !(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Escribe solo letras");
        }
    }//GEN-LAST:event_JtContactoKeyReleased

    private void JtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCiudadActionPerformed
        JtEstado.requestFocus();
    }//GEN-LAST:event_JtCiudadActionPerformed

    private void JtCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCreditoActionPerformed
        JtLcredito.requestFocus();
    }//GEN-LAST:event_JtCreditoActionPerformed

    private void JtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtEstadoActionPerformed
        Jtpais.requestFocus();
    }//GEN-LAST:event_JtEstadoActionPerformed

    private void JtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtNombreActionPerformed
        JtRfc.requestFocus();
    }//GEN-LAST:event_JtNombreActionPerformed

    private void JtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtRfcActionPerformed
        JtDir.requestFocus();
    }//GEN-LAST:event_JtRfcActionPerformed

    private void JtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtDirActionPerformed
        JtCol.requestFocus();
    }//GEN-LAST:event_JtDirActionPerformed

    private void JtColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtColActionPerformed
        JtCiudad.requestFocus();
    }//GEN-LAST:event_JtColActionPerformed

    private void JtpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtpaisActionPerformed
        JtCp.requestFocus();
    }//GEN-LAST:event_JtpaisActionPerformed

    private void JtCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCpActionPerformed
        JtEmbarque.requestFocus();
    }//GEN-LAST:event_JtCpActionPerformed

    private void JtEmbarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtEmbarqueActionPerformed
        JtCorreo.requestFocus();
    }//GEN-LAST:event_JtEmbarqueActionPerformed

    private void JtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCorreoActionPerformed
        JtContacto.requestFocus();
    }//GEN-LAST:event_JtCorreoActionPerformed

    private void JtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtContactoActionPerformed
        JtCredito.requestFocus();
    }//GEN-LAST:event_JtContactoActionPerformed

    private void JtLcreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtLcreditoActionPerformed
        JtTel.requestFocus();
    }//GEN-LAST:event_JtLcreditoActionPerformed

    private void JtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtTelActionPerformed
        JtTelaux.requestFocus();
    }//GEN-LAST:event_JtTelActionPerformed

    private void JtTelauxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtTelauxActionPerformed
        JbGuardar.requestFocus();
    }//GEN-LAST:event_JtTelauxActionPerformed

    private void JtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtEstadoKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtEstadoKeyTyped

    private void JtCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCiudadKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtCiudadKeyTyped

    private void JtpaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtpaisKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtpaisKeyTyped

    private void JtCpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCpKeyTyped
        
    }//GEN-LAST:event_JtCpKeyTyped

    private void JtEmbarqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtEmbarqueKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtEmbarqueKeyTyped

    private void JtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCorreoKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtCorreoKeyTyped

    private void JtCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCreditoKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtCreditoKeyTyped

    private void JtLcreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtLcreditoKeyTyped
        touppercase(evt);
    }//GEN-LAST:event_JtLcreditoKeyTyped

    private void touppercase(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
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
            java.util.logging.Logger.getLogger(NProveedorMPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NProveedorMPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NProveedorMPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NProveedorMPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NProveedorMPrima dialog = new NProveedorMPrima(new javax.swing.JFrame(), true);
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
    public javax.swing.JTextField JtCiudad;
    public javax.swing.JTextField JtCol;
    public javax.swing.JTextField JtContacto;
    public javax.swing.JTextField JtCorreo;
    public javax.swing.JTextField JtCp;
    public javax.swing.JTextField JtCredito;
    public javax.swing.JTextField JtDir;
    public javax.swing.JTextField JtEmbarque;
    public javax.swing.JTextField JtEstado;
    public javax.swing.JTextField JtLcredito;
    public javax.swing.JTextField JtNombre;
    public javax.swing.JTextField JtRfc;
    public javax.swing.JTextField JtTel;
    public javax.swing.JTextField JtTelaux;
    public javax.swing.JTextField Jtid;
    public javax.swing.JTextField Jtpais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
