package ViewLayer;

import ObjectLayer.Corrida;
import ObjectLayer.Costo;
import ObjectLayer.Material;
import ObjectLayer.ObjectCostos;
import ObjectLayer.ObjectMateriales;
import ObjectLayer.ObjectProductos;
import ObjectLayer.ObjectRCPT;
import ObjectLayer.Producto;
import ObjectLayer.PtProducto;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class NCosto extends javax.swing.JDialog {

    String informacion = "";
    Corrida cr = new Corrida();
    ObjectCostos obj = new ObjectCostos();
    ObjectProductos ObjP = new ObjectProductos();
    ObjectMateriales ObjM = new ObjectMateriales();
    ObjectRCPT pt = new ObjectRCPT();
    Material m = new Material();
    double Tolerancia = 0;
    double Colada = 0;
    double PesoTotal = 0;
    double CostoTotal = 0;

    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();
    DefaultListModel<PtProducto> modeloListaRCPT = new DefaultListModel<PtProducto>();
    DefaultListModel<Material> modeloListaMat = new DefaultListModel<Material>();

    public NCosto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        JbCorrida.setVisible(false);
        JbRCPT.setVisible(false);
        JbIdProd.setVisible(false);
        JbCvet.setVisible(false);
        setLocationRelativeTo(null);
        JbColada.setForeground(Color.blue);
        JbTolerancia.setForeground(Color.blue);
        JbCostoT.setForeground(Color.blue);
        JbPrecio.setForeground(Color.blue);
        JtPesoT.setForeground(Color.blue);
    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbSuela = new javax.swing.JLabel();
        JbPunto = new javax.swing.JLabel();
        JbPeso = new javax.swing.JLabel();
        JbTol = new javax.swing.JLabel();
        JbCol = new javax.swing.JLabel();
        JbMat = new javax.swing.JLabel();
        JtPunto = new javax.swing.JTextField();
        JtPeso = new javax.swing.JTextField();
        JtPtol = new javax.swing.JTextField();
        JtPcol = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JbCorrida = new javax.swing.JLabel();
        JbPc = new javax.swing.JLabel();
        JbPrecio = new javax.swing.JLabel();
        JbTolerancia = new javax.swing.JLabel();
        JbColada = new javax.swing.JLabel();
        JbP = new javax.swing.JLabel();
        JtPesoT = new javax.swing.JLabel();
        JbC = new javax.swing.JLabel();
        JbCostoT = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        JtPt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRCPT = new javax.swing.JList<>();
        JbRCPT = new javax.swing.JLabel();
        JbIdProd = new javax.swing.JLabel();
        JtMat = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMat = new javax.swing.JList<>();
        JbCvet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO COSTO");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbSuela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbSuela.setText("Suela:");

        JbPunto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPunto.setText("Punto:");

        JbPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPeso.setText("Peso Gr:");

        JbTol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTol.setText("% Tolerancia:");

        JbCol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCol.setText("% Colada:");

        JbMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMat.setText("Material:");

        JtPunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtPuntoKeyPressed(evt);
            }
        });

        JtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtPesoKeyPressed(evt);
            }
        });

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

        JbCorrida.setText("jLabel1");

        JbPc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPc.setText("Costo");

        JbPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPrecio.setText("0.00");

        JbTolerancia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTolerancia.setText("0.00");

        JbColada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbColada.setText("0.00");

        JbP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbP.setText("Peso Total:");

        JtPesoT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JtPesoT.setText("0.00");

        JbC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbC.setText("Costo Total:");

        JbCostoT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCostoT.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("RCPT:");

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

        JtPt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtPtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtPtKeyTyped(evt);
            }
        });

        listaRCPT.setModel(modeloListaRCPT);
        listaRCPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRCPTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaRCPT);

        JbRCPT.setText("jLabel2");

        JbIdProd.setText("jLabel2");

        JtMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtMatKeyTyped(evt);
            }
        });

        listaMat.setModel( modeloListaMat);
        listaMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMatMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaMat);

        JbCvet.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(JbSuela)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JbRCPT)
                                .addGap(34, 34, 34)
                                .addComponent(JbIdProd)
                                .addGap(18, 18, 18)
                                .addComponent(JbCvet))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JtPt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbMat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(JtMat))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(JbGuardar)
                        .addGap(47, 47, 47)
                        .addComponent(JbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbPc)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(JbPrecio)))
                                .addGap(36, 36, 36)
                                .addComponent(JbP)
                                .addGap(20, 20, 20)
                                .addComponent(JtPesoT)
                                .addGap(18, 18, 18)
                                .addComponent(JbC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbCostoT))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbPunto)
                                    .addComponent(JbPeso)
                                    .addComponent(JbTol))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtPunto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JtPtol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(JbTolerancia))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(JtPcol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71))
                                .addComponent(JbCol))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(JbColada)))))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtPt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbPunto)
                            .addComponent(JtPunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbPeso))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbTolerancia)
                            .addComponent(JbTol)
                            .addComponent(JtPtol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JbSuela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtPcol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCol)
                            .addComponent(JbColada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbPc)
                            .addComponent(JbPrecio)
                            .addComponent(JtPesoT)
                            .addComponent(JbP)
                            .addComponent(JbC)
                            .addComponent(JbCostoT))
                        .addGap(17, 17, 17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JbMat)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbCorrida)
                    .addComponent(JbRCPT)
                    .addComponent(JbIdProd)
                    .addComponent(JbCvet))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        if (JtPtol.getText().equals("") || JtPcol.getText().equals("") || JtPeso.getText().equals("")
                || JtPunto.getText().equals("")
                || JbTolerancia.getText().equals("") || JbColada.getText().equals("")
                || JtPesoT.getText().equals("0.00") || JbCostoT.getText().equals("0.00")) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JtPunto.requestFocus();
        } else if (obj.validarCosto(Integer.parseInt(JbIdProd.getText()), Integer.parseInt(JtPunto.getText())) == 0) {
            Costo ct = new Costo();
            ct.setId_Producto(Integer.parseInt(JbIdProd.getText()));
            ct.setId_ProductoRCPT(Integer.parseInt(JbRCPT.getText()));
            ct.setPunto(Integer.parseInt(JtPunto.getText()));
            ct.setPesoGr(Double.parseDouble(JtPeso.getText()));
            ct.setPtolerancia(Double.parseDouble(JtPtol.getText()));
            ct.setPcolada(Double.parseDouble(JtPcol.getText()));
            ct.setTolerancia(Double.parseDouble(JbTolerancia.getText()));
            ct.setColada(Double.parseDouble(JbColada.getText()));
            ct.setCveMat(JbCvet.getText());
            ct.setPesoTotal(PesoTotal);
            ct.setPrecio(Double.parseDouble(JbPrecio.getText()));
            ct.setCosto(CostoTotal);
            if (ValidarCorrida()) {
                if (obj.CostoAdd(ct)) {
                    JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    informacion = "1";
                    Limpiar();
                    JtProducto.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    Limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Este punto no esta en la corrida", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                JtPunto.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Este punto ya esta registrado", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JtPunto.requestFocus();
        }
    }//GEN-LAST:event_JbGuardarActionPerformed
    private void Limpiar() {
        JtPunto.setText("");
        JtPeso.setText("");
        JtPtol.setText("");
        JtPcol.setText("");
        JbTolerancia.setText("0.00");
        JbColada.setText("0.00");
        JbCostoT.setText("0.00");
        JtPesoT.setText("0.00");
        JbPrecio.setText("0.00");
        JbRCPT.setText("");
        JbCvet.setText("");
        JbIdProd.setText("");
        JbCorrida.setText("");
        JtProducto.setText("");
        JtPt.setText("");
        JtMat.setText("");
    }

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private boolean ValidarCorrida() {
        switch (JbCorrida.getText()) {
            case "[15-17]":
                if (JtPunto.getText().equals("15") || JtPunto.getText().equals("16") || JtPunto.getText().equals("17")) {
                    return true;
                } else {
                    return false;
                }
            case "[25-30]":
                if (JtPunto.getText().equals("25") || JtPunto.getText().equals("26") || JtPunto.getText().equals("27")
                        || JtPunto.getText().equals("28") || JtPunto.getText().equals("29") || JtPunto.getText().equals("30")) {
                    return true;
                } else {
                    return false;
                }
            case "[18-21]":
                if (JtPunto.getText().equals("18") || JtPunto.getText().equals("19") || JtPunto.getText().equals("20")
                        || JtPunto.getText().equals("21")) {
                    return true;
                } else {
                    return false;
                }
            case "[22-24]":
                if (JtPunto.getText().equals("22") || JtPunto.getText().equals("23") || JtPunto.getText().equals("24")) {
                    return true;
                } else {
                    return false;
                }
            case "[22-26]":
                if (JtPunto.getText().equals("22") || JtPunto.getText().equals("23") || JtPunto.getText().equals("24")
                        || JtPunto.getText().equals("25") || JtPunto.getText().equals("26")) {
                    return true;
                } else {
                    return false;
                }
            case "[23-26]":
                if (JtPunto.getText().equals("23") || JtPunto.getText().equals("24")
                        || JtPunto.getText().equals("25") || JtPunto.getText().equals("26")) {
                    return true;
                } else {
                    return false;
                }
            case "[23-29]":
                if (JtPunto.getText().equals("23") || JtPunto.getText().equals("24")
                        || JtPunto.getText().equals("25") || JtPunto.getText().equals("26")
                        || JtPunto.getText().equals("27") || JtPunto.getText().equals("28")
                        || JtPunto.getText().equals("29")) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    private void JtPtolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPtolKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            DecimalFormat var = new DecimalFormat("0.00");
            double Pg = Double.parseDouble(JtPeso.getText());
            double Ptol = Double.parseDouble(JtPtol.getText());
            Tolerancia = Ptol * Pg / 100;
            JbTolerancia.setText(var.format(Tolerancia));
            JtPcol.requestFocus();
        }
    }//GEN-LAST:event_JtPtolKeyPressed

    private void JtPcolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPcolKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            DecimalFormat var = new DecimalFormat("0.00");
            double Pg = Double.parseDouble(JtPeso.getText());
            double Pcol = Double.parseDouble(JtPcol.getText());
            double Precio = Double.parseDouble(JbPrecio.getText());
            Colada = Pcol * Pg / 100;
            JbColada.setText(var.format(Colada));
            PesoTotal = Pg + Tolerancia + Colada;
            JtPesoT.setText(var.format(PesoTotal));
            CostoTotal = PesoTotal * Precio;
            JbCostoT.setText(var.format(CostoTotal));
        }
    }//GEN-LAST:event_JtPcolKeyPressed

    private void JtPuntoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPuntoKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            JtPeso.requestFocus();
        }
    }//GEN-LAST:event_JtPuntoKeyPressed

    private void JtPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPesoKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            JtPtol.requestFocus();
        }
    }//GEN-LAST:event_JtPesoKeyPressed

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
            JbCorrida.setText(String.valueOf(cr.getCorridas(prod.getId_Producto())));
            JtProducto.setText(prod.getDescripcion());
            JbIdProd.setText(String.valueOf(prod.getId_Producto()));
            limpiarListaProductos();
            JtPt.requestFocus();
        }
    }//GEN-LAST:event_listaProductosMouseClicked

    private void JtPtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPtKeyReleased
        limpiarRCPT();
        if (JtPt.getText().isEmpty()) {
            limpiarRCPT();
        } else {
            ArrayList<PtProducto> listaProd = pt.GetByRCPT(JtPt.getText());

            for (PtProducto prod : listaProd) {
                modeloListaRCPT.addElement(prod);
            }
        }
    }//GEN-LAST:event_JtPtKeyReleased

    private void JtPtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPtKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtPtKeyTyped

    private void listaRCPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRCPTMouseClicked
        JList lis = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            PtProducto prod = (PtProducto) lis.getSelectedValue();
            JbRCPT.setText(String.valueOf(prod.getProducto()));
            JtPt.setText(prod.getDescripcion());
            limpiarRCPT();
            JtMat.requestFocus();
        }
    }//GEN-LAST:event_listaRCPTMouseClicked

    private void JtMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtMatKeyTyped

    private void JtMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyReleased
        limpiarMaterial();
        if (JtMat.getText().isEmpty()) {
            limpiarMaterial();
        } else {
            ArrayList<Material> listaMaterial = ObjM.GetByCosto(JtMat.getText());
            for (Material m : listaMaterial) {
                modeloListaMat.addElement(m);
            }
        }
    }//GEN-LAST:event_JtMatKeyReleased

    private void listaMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMatMouseClicked
        JList lis = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            Material mat = (Material) lis.getSelectedValue();
            DecimalFormat var = new DecimalFormat("0.00");
            JbCvet.setText(mat.getCveMat());
            JtMat.setText(mat.getDescripcion());
            limpiarMaterial();
            JtPunto.requestFocus();
            JbPrecio.setText(var.format(mat.getCostoCosteo()));
        }
    }//GEN-LAST:event_listaMatMouseClicked

    private void limpiarListaProductos() {
        modeloListaProductos.clear();
    }

    private void limpiarRCPT() {
        modeloListaRCPT.clear();
    }

    private void limpiarMaterial() {
        modeloListaMat.clear();
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
            java.util.logging.Logger.getLogger(NCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NCosto dialog = new NCosto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbColada;
    private javax.swing.JLabel JbCorrida;
    private javax.swing.JLabel JbCostoT;
    private javax.swing.JLabel JbCvet;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbMat;
    private javax.swing.JLabel JbP;
    private javax.swing.JLabel JbPc;
    private javax.swing.JLabel JbPeso;
    private javax.swing.JLabel JbPrecio;
    private javax.swing.JLabel JbPunto;
    private javax.swing.JLabel JbRCPT;
    private javax.swing.JLabel JbSuela;
    private javax.swing.JLabel JbTol;
    private javax.swing.JLabel JbTolerancia;
    private javax.swing.JTextField JtMat;
    private javax.swing.JTextField JtPcol;
    private javax.swing.JTextField JtPeso;
    private javax.swing.JLabel JtPesoT;
    private javax.swing.JTextField JtProducto;
    private javax.swing.JTextField JtPt;
    private javax.swing.JTextField JtPtol;
    private javax.swing.JTextField JtPunto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Material> listaMat;
    private javax.swing.JList<Producto> listaProductos;
    private javax.swing.JList<PtProducto> listaRCPT;
    // End of variables declaration//GEN-END:variables
}