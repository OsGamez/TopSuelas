package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.KardexCmp;
import ObjectLayer.Material;
import ObjectLayer.Movs_materiales;
import ObjectLayer.ObjectKardexCmp;
import ObjectLayer.ObjectMateriales;
import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.ProveedorMPrima;
import ObjectLayer.Sesioninfo;
import ObjectLayer.Validacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MovimientosesCMP extends javax.swing.JDialog {
    
    String informacion = "";
    ObjectProveedoresMPrima pm = new ObjectProveedoresMPrima();
    ArrayList<ProveedorMPrima> listaproveedorm;
    ArrayList<Material> listaMaterial;
    ArrayList<Movs_materiales> listamovimiento_material = new ArrayList<>();
    Vector<Almacen> listaalmacen = new Vector<>();
    ObjectMateriales ObjM = new ObjectMateriales();
    ObjectKardexCmp Objcmp = new ObjectKardexCmp();
    String columna = "";
    Sesioninfo s = new Sesioninfo();
    
    DefaultListModel<ProveedorMPrima> modeloListaProveedor = new DefaultListModel<>();
    DefaultListModel<Material> modeloListaMat = new DefaultListModel<>();
    DefaultTableModel modelMaterials;
    
    public MovimientosesCMP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelAlmacen();
        Calendar fecha = new GregorianCalendar();
        JeFecha.setCalendar(fecha);
        JtCuenta.requestFocus();
        Jlserie.setText(s.getSerie());
        LoadModelmaterials();
        JbIdProd.setVisible(false);
        JbCvet.setVisible(false);
    }
    
    public String getInformacion() {
        return this.informacion;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpMenu = new javax.swing.JPopupMenu();
        Jmi = new javax.swing.JMenuItem();
        Jtlc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JeFecha = new com.toedter.calendar.JDateChooser();
        JtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProveedor = new javax.swing.JList<>();
        JbIdProd = new javax.swing.JLabel();
        JtMat = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMat = new javax.swing.JList<>();
        JbMat = new javax.swing.JLabel();
        JbCvet = new javax.swing.JLabel();
        JtFolio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Jlserie = new javax.swing.JLabel();
        JtCuenta = new javax.swing.JTextField();
        JtSubcuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JcAlmacen = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JttMaterial = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        Jmi.setText("Eliminar Producto");
        Jmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmiMouseClicked(evt);
            }
        });
        Jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiActionPerformed(evt);
            }
        });
        JpMenu.add(Jmi);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden de compra");
        setLocation(new java.awt.Point(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione Proveedor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("FECHA");

        JeFecha.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        JtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtProveedorMouseClicked(evt);
            }
        });
        JtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtProveedorActionPerformed(evt);
            }
        });
        JtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtProveedorKeyTyped(evt);
            }
        });

        listaProveedor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listaProveedor.setModel(modeloListaProveedor);
        listaProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaProveedor);

        JbIdProd.setText("jLabel3");

        JtMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtMatMouseClicked(evt);
            }
        });
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

        JbMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMat.setText("Material:");

        JbCvet.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Folio");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Serie:");

        JtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCuentaActionPerformed(evt);
            }
        });

        JtSubcuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtSubcuentaMouseClicked(evt);
            }
        });
        JtSubcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtSubcuentaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cuenta");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Subcuenta");

        JcAlmacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JcAlmacen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcAlmacenItemStateChanged(evt);
            }
        });
        JcAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JcAlmacenMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Almacen");

        JttMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JttMaterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JttMaterial);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Realizar Movimiento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JcAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JtFolio, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JbMat)
                                    .addComponent(JbIdProd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbCvet)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jlserie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(212, 212, 212))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(JtMat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(JtProveedor)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jlserie, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(JtSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JcAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbIdProd)
                    .addComponent(JbCvet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbMat)
                    .addComponent(JtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing
    private void LoadModelAlmacen() {
        Almacen e = new Almacen();
        e.conCMP();
        DefaultComboBoxModel modelEtiqueta = new DefaultComboBoxModel(e.getAlmacenes());
        listaalmacen = e.getAlmacenes();
        JcAlmacen.setModel(modelEtiqueta);
        JcAlmacen.setSelectedIndex(0);
    }
    
    private void LoadModelmaterials() {
        modelMaterials = new DefaultTableModel();
        modelMaterials.addColumn("Material");
        modelMaterials.addColumn("Cantidad");
        JttMaterial.editCellAt(1, 1);
        JttMaterial.setModel(modelMaterials);
    }

    private void vaciatabla() {
        int rows = JttMaterial.getRowCount();
        System.out.println(rows);
        for (int i = rows - 1; i >= 0; i--) {
            modelMaterials.removeRow(i);
        }
    }
    private void JtProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyReleased
        
        if (JtProveedor.getText().isEmpty()) {
        } else {
            listaproveedorm = pm.ProveedorMPrimaSearch(JtProveedor.getText());
            for (ProveedorMPrima p : listaproveedorm) {
                modeloListaProveedor.addElement(p);
            }
        }
    }//GEN-LAST:event_JtProveedorKeyReleased

    private void JtProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtProveedorKeyTyped
    private void limpiarListaProductos() {
        modeloListaProveedor.clear();
    }

    private void listaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProveedorMouseClicked
        JList lis = (JList) evt.getSource();
        
        if (evt.getClickCount() == 1) {
            ProveedorMPrima p = (ProveedorMPrima) lis.getSelectedValue();
            //JbCorrida.setText(String.valueOf(cr.getCorridas(prod.getId_Producto())));
            JbIdProd.setText(String.valueOf(p.getProveedor()) + " " + listaproveedorm.get(lis.getSelectedIndex()).getProveedor());
//            limpiarListaProductos();
            //  JtPt.requestFocus();
        }
    }//GEN-LAST:event_listaProveedorMouseClicked

    private void JtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtProveedorActionPerformed

    }//GEN-LAST:event_JtProveedorActionPerformed

    private void JtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtProveedorMouseClicked
        JtProveedor.setText("");
    }//GEN-LAST:event_JtProveedorMouseClicked

    private void JtMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyReleased
        
        if (JtMat.getText().isEmpty()) {
            limpiarMaterial();
        } else {
            limpiarMaterial();
            listaMaterial = ObjM.GetByCosto(JtMat.getText());
            for (Material m : listaMaterial) {
                modeloListaMat.addElement(m);
            }
            
        }
    }//GEN-LAST:event_JtMatKeyReleased

    private void JtMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtMatKeyTyped

    private void listaMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMatMouseClicked
        JList lis = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            Material mat = (Material) lis.getSelectedValue();
            JbCvet.setText(listaMaterial.get(listaMat.getSelectedIndex()).getCveMat());
            JtMat.setText(mat.getDescripcion());
            Movs_materiales ma = new Movs_materiales();
            Validacion v = new Validacion();
            String resp = JOptionPane.showInputDialog("Escribe la cantidad: ");
            while (!v.verificanumeros(resp) || Integer.parseInt(resp) <= 0) {
                resp = JOptionPane.showInputDialog("Escribe la cantidad: ");
            }
            int existencia = ObjM.validaralmacen_material(listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen(), mat.getCveMat());
            if (existencia <= Integer.parseInt(resp) && Integer.parseInt(JtCuenta.getText()) > 59) {
                JOptionPane.showMessageDialog(null, "No se cuenta con suficiente existencia de este material con el almacen seleccionado", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                JtMat.setText("");
                JtMat.requestFocus();
                limpiarMaterial();
            } else {
                ma.setCantidad(Integer.parseInt(resp));
                ma.setMaterial(mat.getCveMat());
                ma.setNombre_material(mat.getDescripcion());
                ma.setCosto((float) mat.getCostoCosteo());
                listamovimiento_material.add(ma);
                Object arr[] = {mat.getDescripcion(), resp};
                modelMaterials.addRow(arr);
                JtMat.setText("");
                JtMat.requestFocus();
                limpiarMaterial();
            }
            
        }
    }//GEN-LAST:event_listaMatMouseClicked

    private void JtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCuentaActionPerformed
        JtSubcuenta.requestFocus();
    }//GEN-LAST:event_JtCuentaActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (JtCuenta.getText().equals("") && JtSubcuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        }
    }//GEN-LAST:event_formMouseClicked

    private void JtSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtSubcuentaActionPerformed
        if ((JtCuenta.getText().equals("01") || JtCuenta.getText().equals("1"))
                && JtSubcuenta.getText().equals("01") || JtSubcuenta.getText().equals("1")) {
            String botones[] = {"SI", "NO"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas realizar una orden de compra?", "TOP-SUELAS",
                    0, 0, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                this.dispose();
                NOrdenCompra ordenc = new NOrdenCompra(null, true);
                ordenc.setVisible(true);
                ordenc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                ordenc.setAlwaysOnTop(true);
            } else if (eleccion == JOptionPane.NO_OPTION) {
                JtSubcuenta.setText("");
            }
        } else {
            int cuenta = Integer.parseInt(JtCuenta.getText());
            columna = (cuenta < 50) ? "Entradas" : "Salidas";
            JtFolio.setText(Objcmp.getparametro(columna));
            JcAlmacen.requestFocus();
            
        }
    }//GEN-LAST:event_JtSubcuentaActionPerformed

    private void JttMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JttMaterialMouseClicked
        if (evt.getButton() == 3) {
            JpMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JttMaterialMouseClicked

    private void JmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmiMouseClicked

    }//GEN-LAST:event_JmiMouseClicked

    private void JmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiActionPerformed
        int aux = JttMaterial.getSelectedRow();
        modelMaterials.removeRow(aux);
        listamovimiento_material.remove(aux);
    }//GEN-LAST:event_JmiActionPerformed

    private void JtMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtMatMouseClicked
        if (JtCuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        }
    }//GEN-LAST:event_JtMatMouseClicked

    private void JtSubcuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtSubcuentaMouseClicked
        if (JtCuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        }
    }//GEN-LAST:event_JtSubcuentaMouseClicked

    private void JcAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JcAlmacenMouseClicked
        if (JtCuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        }
    }//GEN-LAST:event_JcAlmacenMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generarmovimiento();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JcAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAlmacenItemStateChanged
        JtMat.requestFocus();
    }//GEN-LAST:event_JcAlmacenItemStateChanged
    private void limpiarMaterial() {
        modeloListaMat.clear();
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
    
    private String getfecha() {
        Calendar fecha = Calendar.getInstance(); //intanciar informacion del calendiario respecto al sistema
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        String horas = "";
        if (hora > 9) {// verificar que la hora y minuto tengan 2 digitos
            horas = hora + ":";
        }
        if (hora < 10) {
            horas = "0" + hora + ":";
        }
        if (minuto < 10) {
            horas = hora + ":0" + minuto;
        }
        if (minuto > 9) {
            horas += minuto;
        }
        String fechac = dia + "-0" + mes + "-" + año + " " + horas + ":00.000";//fecha formada por Calendar.getInstance(); 
        return fechac;
    }
    
    private void generarmovimiento() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Estas Seguro de realizar el movimiento?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            try {
                if (JcAlmacen.getSelectedIndex() == 0 && listamovimiento_material.isEmpty()) {
                    JcAlmacen.requestFocus();
                    JOptionPane.showMessageDialog(null, "Elija un almacen o un material!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                } else if (JtCuenta.getText().equals("") || JtSubcuenta.getText().equals("") || JtFolio.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "La cuenta y subcuenta no pueden ir vacias!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    JtCuenta.requestFocus();
                } else {
                    ArrayList<Movs_materiales> arr = new ArrayList<>();
                    int rows = JttMaterial.getRowCount();
                    for (int i = 0; i < rows; i++) {
                        String numaux = JttMaterial.getValueAt(i, 1).toString();
                        Movs_materiales mo = new Movs_materiales();
                        mo.setMaterial(listamovimiento_material.get(i).getMaterial());
                        mo.setCosto(listamovimiento_material.get(i).getCosto());
                        mo.setCantidad(Integer.parseInt(numaux));
                        arr.add(mo);
                    }
                    String operacion = (columna.equals("Entradas")) ? "+" : "-";
                    KardexCmp k = new KardexCmp();
                    k.setFolio(Integer.parseInt(JtFolio.getText()) + 1);
                    k.setCuenta(Integer.parseInt(JtCuenta.getText()));
                    k.setSubcuenta(Integer.parseInt(JtSubcuenta.getText()));
                    k.setProveedor(0);// cambia
                    k.setAlmacen(listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen());
                    k.setOrdenc("");// cambia
                    k.setFechamov(getfecha());
                    k.setFechadoc(getfecha());//cambia
//                    k.setSerie(s.getSerie());
                    k.setSerie("A");
                    k.setTipo(columna.charAt(0) + "");
                    k.setDocref("");//cambia
                    k.setOperacion(operacion);
                    k.setUsuario(s.getId_usuario());
                    k.setMat(arr);
                    if (Objcmp.KardexCmpAdd(k)) {
                        limpiamovimiento();
                        JOptionPane.showMessageDialog(null, "Movimiento Completo!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo salio Mal, Contacta a Sistemas!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "En cantidad de productos solo pueden ir numeros!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                JtCuenta.requestFocus();
                e.printStackTrace();
            }
        }
        
    }
    
    private void limpiamovimiento() {
        JtCuenta.setText("");
        JtSubcuenta.setText("");
        JtFolio.setText("");
        JcAlmacen.setSelectedIndex(0);
        LoadModelmaterials();
        JtCuenta.requestFocus();
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
            java.util.logging.Logger.getLogger(MovimientosesCMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosesCMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosesCMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosesCMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                MovimientosesCMP dialog = new MovimientosesCMP(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbCvet;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbMat;
    private javax.swing.JComboBox<String> JcAlmacen;
    private com.toedter.calendar.JDateChooser JeFecha;
    private javax.swing.JLabel Jlserie;
    private javax.swing.JMenuItem Jmi;
    private javax.swing.JPopupMenu JpMenu;
    private javax.swing.JTextField JtCuenta;
    private javax.swing.JTextField JtFolio;
    public javax.swing.JTextField JtMat;
    public javax.swing.JTextField JtProveedor;
    private javax.swing.JTextField JtSubcuenta;
    public javax.swing.JLabel Jtlc;
    private javax.swing.JTable JttMaterial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JList<Material> listaMat;
    public javax.swing.JList<ProveedorMPrima> listaProveedor;
    // End of variables declaration//GEN-END:variables
}
