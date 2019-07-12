package ViewLayer;

import DataAccesLayer.Conexion;
import ObjectLayer.Almacen;
import ObjectLayer.AlmacenRcpt;
import ObjectLayer.Concepto;
import ObjectLayer.Corrida;
import ObjectLayer.ObjectAlmacenRcpt;
import ObjectLayer.ObjectParametros;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Parametro;
import ObjectLayer.Producto;
import ObjectLayer.Proveedor;
import Plugins.ParametroCliente;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Entradas extends javax.swing.JInternalFrame {

    ParametroCliente f = new ParametroCliente();
    Corrida cr = new Corrida();
    ObjectAlmacenRcpt objAm = new ObjectAlmacenRcpt();
    ObjectProductos ObjP = new ObjectProductos();
    ObjectParametros Par = new ObjectParametros();
    public String arreglo[] = new String[17];

    DefaultListModel<Producto> modeloAlmacen = new DefaultListModel<Producto>();

    public Entradas() {
        initComponents();
        LoadColumns();
        LoadModelAm();
        LoadModelProv();
        LoadModelCuenta();
        Jp.setVisible(false);
        JbCorrida.setVisible(false);
        JbIdProd.setVisible(false);
        JbAm.setVisible(false);
        CargarCodigo();
        cargarListenerPedido();
        JbTpares.setVisible(false);
    }

    private void LoadModelAm() {
        AlmacenRcpt am = new AlmacenRcpt();
        DefaultComboBoxModel modelAm = new DefaultComboBoxModel(am.getAm());
        JcAm.setModel(modelAm);
    }

    private void LoadModelProv() {
        Proveedor pv = new Proveedor();
        DefaultComboBoxModel modelPv = new DefaultComboBoxModel(pv.getProveedores());
        JcProveedor.setModel(modelPv);
    }

    private void LoadModelCuenta() {
        Concepto cp = new Concepto();
        DefaultComboBoxModel modelC = new DefaultComboBoxModel(cp.getCp());
        JcCuenta.setModel(modelC);
    }

    public DefaultTableModel modelEntrada = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return true;
        }
    };

    private void LoadColumns() {
        modelEntrada.addColumn("ALMACÉN");
        modelEntrada.addColumn("ID");
        modelEntrada.addColumn("SUELA");
        modelEntrada.addColumn("C1");
        modelEntrada.addColumn("C2");
        modelEntrada.addColumn("C3");
        modelEntrada.addColumn("C4");
        modelEntrada.addColumn("C5");
        modelEntrada.addColumn("C6");
        modelEntrada.addColumn("C7");
        modelEntrada.addColumn("C8");
        modelEntrada.addColumn("C9");
        modelEntrada.addColumn("C10");
        modelEntrada.addColumn("C11");
        modelEntrada.addColumn("C12");
        modelEntrada.addColumn("T.PARES");
        modelEntrada.addColumn("COSTO");

        JtEntradas.getColumnModel().getColumn(1).setMaxWidth(0);
        JtEntradas.getColumnModel().getColumn(1).setMinWidth(0);
        JtEntradas.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JbFolio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JtSub = new javax.swing.JTextField();
        JcProveedor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JbSerie = new javax.swing.JLabel();
        JdFecha = new com.toedter.calendar.JDateChooser();
        JtDoc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtEntradas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JtSuela = new javax.swing.JTextField();
        Jp = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JlSuela = new javax.swing.JList<>();
        JcAm = new javax.swing.JComboBox<>();
        JbCorrida = new javax.swing.JLabel();
        JbIdProd = new javax.swing.JLabel();
        JbAm = new javax.swing.JLabel();
        JcCuenta = new javax.swing.JComboBox<>();
        JbTpares = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("ENTRADAS");

        jLabel1.setText("Folio:");

        JbFolio.setForeground(new java.awt.Color(255, 51, 51));
        JbFolio.setText("000124");

        jLabel3.setText("Cuenta:");

        jLabel4.setText("SubCuenta:");

        jLabel5.setText("Proveedor:");

        jLabel2.setText("Fecha:");

        jLabel6.setText("Observaciones:");

        jLabel7.setText("Serie:");

        jLabel8.setText("Doc Ref:");

        JbSerie.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        JbSerie.setForeground(new java.awt.Color(255, 51, 51));
        JbSerie.setText("A");

        JtDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtDocKeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        JtEntradas.setModel(modelEntrada);
        JtEntradas.setSelectionBackground(new java.awt.Color(102, 153, 255));
        JtEntradas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtEntradasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(JtEntradas);

        jLabel9.setText("Almacén:");

        jLabel10.setText("Suela:");

        JtSuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtSuelaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtSuelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtSuelaKeyTyped(evt);
            }
        });

        Jp.setBorder(null);

        JlSuela.setModel(modeloAlmacen);
        JlSuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlSuelaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JlSuela);

        javax.swing.GroupLayout JpLayout = new javax.swing.GroupLayout(Jp);
        Jp.setLayout(JpLayout);
        JpLayout.setHorizontalGroup(
            JpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        JpLayout.setVerticalGroup(
            JpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JcAm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcAmItemStateChanged(evt);
            }
        });

        JbCorrida.setText("jLabel11");

        JbIdProd.setText("jLabel11");

        JbAm.setText("jLabel11");

        JcCuenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcCuentaItemStateChanged(evt);
            }
        });

        JbTpares.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addComponent(JbFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtSub)
                            .addComponent(JcProveedor, 0, 170, Short.MAX_VALUE)
                            .addComponent(JcAm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JcCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(Jp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(JbTpares, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JtDoc)
                                .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(48, 48, 48)
                                .addComponent(JbCorrida)
                                .addGap(45, 45, 45)
                                .addComponent(JbIdProd)
                                .addGap(18, 18, 18)
                                .addComponent(JbAm))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JbFolio))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(JcCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(JtSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(JcProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(JcAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(JbSerie)
                                    .addComponent(JbTpares))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel8)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(JtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(JbCorrida)
                                    .addComponent(JbIdProd)
                                    .addComponent(JbAm))
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtEntradasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtEntradasKeyPressed


    }//GEN-LAST:event_JtEntradasKeyPressed

    private void JtSuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyReleased
        Jp.setVisible(true);
        limpiarListaProductos();

        if (JtSuela.getText().isEmpty()) {
            limpiarListaProductos();
            Jp.setVisible(false);
        } else {
            ArrayList<Producto> list = ObjP.GetByCosto(JtSuela.getText());
            for (Producto prod : list) {
                modeloAlmacen.addElement(prod);
            }
        }
    }//GEN-LAST:event_JtSuelaKeyReleased

    private void JlSuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlSuelaMouseClicked
        Jp.setVisible(false);
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Producto prod = (Producto) lis.getSelectedValue();
            //JbCorrida.setText(String.valueOf(cr.getCorridas(prod.getId_Producto())));
            //JtSuela.setText(prod.getDescripcion());
            //101JbIdProd.setText(String.valueOf(prod.getId_Producto()));
            limpiarListaProductos();

            PuntosEntrada nuevo = new PuntosEntrada(null, true);
            nuevo.Corrida = String.valueOf(cr.getCorridas(prod.getId_Producto()));
            nuevo.Idp = String.valueOf(prod.getId_Producto());
            nuevo.Am = JbAm.getText();
            nuevo.Suela = prod.getDescripcion();
            nuevo.Jt1.requestFocus();
            nuevo.Jt1.setSelectionStart(0);
            nuevo.ValidarCorrida();
            nuevo.modelEn = modelEntrada;
            JtSuela.setText("");
            JtSuela.requestFocus();
            nuevo.setVisible(true);
        }
    }//GEN-LAST:event_JlSuelaMouseClicked

    private void JtSuelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyPressed

    }//GEN-LAST:event_JtSuelaKeyPressed

    private void JtSuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtSuelaKeyTyped

    private void JcAmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAmItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            AlmacenRcpt am = (AlmacenRcpt) JcAm.getSelectedItem();
            JbAm.setText(String.valueOf(am.getAlmacen()));
        }
    }//GEN-LAST:event_JcAmItemStateChanged

    private void JcCuentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcCuentaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Concepto cp = (Concepto) JcCuenta.getSelectedItem();
            JtSub.setText(cp.getSubCuenta());
        }
    }//GEN-LAST:event_JcCuentaItemStateChanged

    private void JtDocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtDocKeyPressed
        
    }//GEN-LAST:event_JtDocKeyPressed

    private void limpiarListaProductos() {
        modeloAlmacen.clear();
    }

    private void CargarCodigo() {
        int num = 1;

        ArrayList<Parametro> listP = Par.getFolioEntrada();

        if (listP.size() > 0) {
            for (Parametro par : listP) {
                int F = par.getEntrada();
                int var = num + F;
                JbFolio.setText(String.valueOf(var));
            }
        } else {
            JbFolio.setText(String.valueOf(num));
        }

        /*ArrayList<Folio> listf = f.Cargar();
        int j;
        if (listf.size() > 0) {
            for (Folio fl : listf) {
                String c = fl.numFolio;
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                f.generar(j);
                JbFolio.setText(f.Serie());
            }

        } else {
            JbFolio.setText("CD0001");
        }*/
    }

    private void cargarListenerPedido() {
        modelEntrada.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = modelEntrada.getRowCount();
                //double sumatoria = 0;
                int pares = 0;
               // DecimalFormat total = new DecimalFormat("#.00");
                for (int i = 0; i < row; i++) {
                    //String importe = (String) modelEntrada.getValueAt(i, 19);
                    String tpares = (String) modelEntrada.getValueAt(i, 15);
                    //sumatoria += Double.parseDouble(importe);
                    pares += Integer.parseInt(tpares);
                }
                //lblTotal.setText(total.format(sumatoria));
                JbTpares.setText(String.valueOf(pares));
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbAm;
    private javax.swing.JLabel JbCorrida;
    private javax.swing.JLabel JbFolio;
    private javax.swing.JLabel JbIdProd;
    public javax.swing.JLabel JbSerie;
    private javax.swing.JLabel JbTpares;
    private javax.swing.JComboBox<String> JcAm;
    private javax.swing.JComboBox<String> JcCuenta;
    private javax.swing.JComboBox<String> JcProveedor;
    private com.toedter.calendar.JDateChooser JdFecha;
    private javax.swing.JList<Producto> JlSuela;
    private javax.swing.JPanel Jp;
    private javax.swing.JTextField JtDoc;
    private javax.swing.JTable JtEntradas;
    private javax.swing.JTextField JtSub;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
