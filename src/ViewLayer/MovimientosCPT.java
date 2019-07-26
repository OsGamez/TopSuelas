package ViewLayer;

import ObjectLayer.AlmacenRcpt;
import ObjectLayer.Cliente;
import ObjectLayer.ObjectClientes;
import ObjectLayer.ObjectConceptos;
import ObjectLayer.ObjectParametros;
import ObjectLayer.ObjectProductos;
import ObjectLayer.ObjectProveedores;
import ObjectLayer.Parametro;
import ObjectLayer.Producto;
import ObjectLayer.Proveedor;
import ObjectLayer.Sesioninfo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MovimientosCPT extends javax.swing.JFrame {

    ObjectParametros Par = new ObjectParametros();
    ObjectConceptos concepto = new ObjectConceptos();
    ObjectClientes objC = new ObjectClientes();
    ObjectProveedores objPv = new ObjectProveedores();
    ObjectProductos objProd = new ObjectProductos();
    Sesioninfo sesion = new Sesioninfo();
    DefaultListModel<Cliente> modeloListaCliente = new DefaultListModel<>();
    DefaultListModel<Proveedor> modeloListaProveedor = new DefaultListModel<>();
    DefaultListModel<Producto> modeloListaProducto = new DefaultListModel<>();
    int cuenta = 0, subCuenta = 0, idCliente, idSuela, idProveedor;
    String ms, Movimiento, Serie = sesion.getSerie();

    DefaultTableModel modelM = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    public MovimientosCPT() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        JbSerie.setText(sesion.getSerie());
        ocultarCampos();
        deshabilitarCampos();
        Calendar fecha = new GregorianCalendar();
        JdFecha.setCalendar(fecha);
        JdFecha.setEnabled(false);
        JtCuenta.requestFocus();
        LoadModelAm();
        LoadModelAmD();
        loadColumns();
        JtDoc.setEditable(false);
        JtDatos.getTableHeader().setResizingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbIcono = new javax.swing.JLabel();
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
        JtCliente = new javax.swing.JTextField();
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
        JpCliente = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JlCliente = new javax.swing.JList<>();
        JtProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JpProveedor = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JlProveedor = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIMIENTOS CPT");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Refresh_36729.png"))); // NOI18N

        JcaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Precio / Costo :");

        JpSuela.setBorder(null);

        JlSuela.setModel(modeloListaProducto);
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
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpSuelaLayout.setVerticalGroup(
            JpSuelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSuelaLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jLabel6.setText("Cliente:");

        jLabel7.setText("SubCuenta:");

        JtsubCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtsubCuentaMouseClicked(evt);
            }
        });
        JtsubCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtsubCuentaActionPerformed(evt);
            }
        });
        JtsubCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtsubCuentaKeyPressed(evt);
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

        JtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtClienteMouseClicked(evt);
            }
        });
        JtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtClienteKeyTyped(evt);
            }
        });

        JtSuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtSuelaMouseClicked(evt);
            }
        });
        JtSuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtSuelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtSuelaKeyTyped(evt);
            }
        });

        JcaOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        JtDatos.setModel(modelM);
        JtDatos.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setViewportView(JtDatos);

        JbfolioSalida.setForeground(new java.awt.Color(51, 153, 0));
        JbfolioSalida.setText("XXXXXX");

        JbcuentaSalida.setText("Cuenta");

        JbsubCuentaSalida.setText("Scuenta");

        jLabel2.setText("Doc. Ref:");

        JpCliente.setBorder(null);

        JlCliente.setModel(modeloListaCliente);
        JlCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlClienteMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(JlCliente);

        javax.swing.GroupLayout JpClienteLayout = new javax.swing.GroupLayout(JpCliente);
        JpCliente.setLayout(JpClienteLayout);
        JpClienteLayout.setHorizontalGroup(
            JpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        JpClienteLayout.setVerticalGroup(
            JpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        JtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtProveedorMouseClicked(evt);
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

        jLabel8.setText("Proveedor:");

        JpProveedor.setBorder(null);

        JlProveedor.setModel(modeloListaProveedor);
        JlProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlProveedorMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(JlProveedor);

        javax.swing.GroupLayout JpProveedorLayout = new javax.swing.GroupLayout(JpProveedor);
        JpProveedor.setLayout(JpProveedorLayout);
        JpProveedorLayout.setHorizontalGroup(
            JpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProveedorLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        JpProveedorLayout.setVerticalGroup(
            JpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProveedorLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jLabel12.setText("Observaciones:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486348819-back-backwards-repeat-arrows-arrow-blue_80473.png"))); // NOI18N
        jButton1.setText("Quitar Suela");

        jLabel13.setText("Pares:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JcPrimer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(JtsubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbfolioSalida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(JpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel9)
                        .addGap(31, 31, 31)
                        .addComponent(JcaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE)
                        .addComponent(JbIcono)
                        .addGap(58, 58, 58)
                        .addComponent(JcaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(32, 32, 32)
                                        .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JpProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JpSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(118, 118, 118))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(101, 101, 101)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(JtpC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(JbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(JbcuentaSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbsubCuentaSalida)
                        .addGap(41, 41, 41))))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(JbSerie)
                        .addComponent(JbcuentaSalida)
                        .addComponent(JbsubCuentaSalida))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(JbFolio)
                        .addComponent(JbfolioSalida)
                        .addComponent(jLabel2)
                        .addComponent(JtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(JtsubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(JbIcono)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(JtpC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(JcPrimer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JpSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadColumns() {
        modelM.addColumn("AM");
        modelM.addColumn("TIPO");
        modelM.addColumn("SUELA");
        modelM.addColumn("C1");
        modelM.addColumn("C2");
        modelM.addColumn("C3");
        modelM.addColumn("C4");
        modelM.addColumn("C5");
        modelM.addColumn("C6");
        modelM.addColumn("C7");
        modelM.addColumn("C8");
        modelM.addColumn("C9");
        modelM.addColumn("C10");
        modelM.addColumn("C11");
        modelM.addColumn("C12");
        modelM.addColumn("CANTIDAD");
        modelM.addColumn("COSTO");
        modelM.addColumn("IMPORTE");
        
//        JtDatos.getColumnModel().getColumn(0).setMaxWidth(0);
//        JtDatos.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
        
    }

    private void LoadModelAm() {
        AlmacenRcpt am = new AlmacenRcpt();
        DefaultComboBoxModel modelAm = new DefaultComboBoxModel(am.getAm());
        JcaOrigen.setModel(modelAm);
    }

    private void LoadModelAmD() {
        AlmacenRcpt am = new AlmacenRcpt();
        DefaultComboBoxModel modelAm = new DefaultComboBoxModel(am.getAm());
        JcaDestino.setModel(modelAm);
    }

    private void cargarFolio() {
        int entrada = 1, salida = 50000;

        cuenta = Integer.parseInt(JtCuenta.getText());
        subCuenta = Integer.parseInt(JtsubCuenta.getText());
        ArrayList<Parametro> listE = Par.getFolioEntrada();
        ArrayList<Parametro> listS = Par.getFolioSalida();
        if (cuenta < 50) {
            if (cuenta == 1 && subCuenta == 16) {
                JbfolioSalida.setVisible(true);
                JbIcono.setVisible(true);
                JcaDestino.setVisible(true);
                JtSuela.setEditable(true);
                JbcuentaSalida.setText("60");
                JbsubCuentaSalida.setText("16");
                Movimiento = "Traspaso";
                listE.stream().map((par) -> par.getEntrada()).forEachOrdered((F) -> {
                    if (F > 0) {
                        int var = entrada + F;
                        JbFolio.setText(String.valueOf(var));
                        JtDoc.setText(String.valueOf(var));
                    } else {
                        JbFolio.setText(String.valueOf(entrada));
                        JtDoc.setText(String.valueOf(entrada));
                    }
                });
                listS.stream().map((par) -> par.getSalida()).forEachOrdered((F) -> {
                    if (F > 0) {
                        int var = salida + F;
                        JbfolioSalida.setText(String.valueOf(var));
                    } else {
                        JbfolioSalida.setText(String.valueOf(salida));
                    }
                });
            } else {
                JtProveedor.setEditable(true);
                JtSuela.setEditable(true);
                Movimiento = "Entrada";
                listE.stream().map((par) -> par.getEntrada()).forEachOrdered((F) -> {
                    if (F > 0) {
                        int var = entrada + F;
                        JbFolio.setText(String.valueOf(var));
                        JtDoc.setText(String.valueOf(var));
                    } else {
                        JbFolio.setText(String.valueOf(entrada));
                        JtDoc.setText(String.valueOf(entrada));
                    }
                });
            }
        } else {
            if (cuenta == 60 && subCuenta == 16) {
                JbfolioSalida.setVisible(true);
                JbIcono.setVisible(true);
                JcaDestino.setVisible(true);
                JtSuela.setEditable(true);
                JbcuentaSalida.setText("01");
                JbsubCuentaSalida.setText("16");
                Movimiento = "Traspaso";
                listE.stream().map((par) -> par.getSalida()).forEachOrdered((F) -> {
                    if (F > 0) {
                        int var = salida + F;
                        JbFolio.setText(String.valueOf(var));
                        JtDoc.setText(String.valueOf(var));
                    } else {
                        JbFolio.setText(String.valueOf(salida));
                        JtDoc.setText(String.valueOf(salida));
                    }
                });
                listS.stream().map((par) -> par.getEntrada()).forEachOrdered((F) -> {
                    if (F > 0) {
                        int var = entrada + F;
                        JbfolioSalida.setText(String.valueOf(var));
                    } else {
                        JbfolioSalida.setText(String.valueOf(entrada));
                    }
                });
            } else {
                JtCliente.setEditable(true);
                Movimiento = "Salida";
                listE.stream().map((par) -> par.getSalida()).forEachOrdered((F) -> {
                    if (F > 0) {
                        int var = salida + F;
                        JbFolio.setText(String.valueOf(var));
                        JtDoc.setText(String.valueOf(var));
                    } else {
                        JbFolio.setText(String.valueOf(salida));
                        JtDoc.setText(String.valueOf(salida));
                    }
                });
            }
        }
    }

    private void ocultarCampos() {
        JpSuela.setVisible(false);
        JpCliente.setVisible(false);
        JpProveedor.setVisible(false);
        JbfolioSalida.setVisible(false);
        JbIcono.setVisible(false);
        JcaDestino.setVisible(false);
        JbcuentaSalida.setVisible(false);
        JbsubCuentaSalida.setVisible(false);
    }

    private void deshabilitarCampos() {
        JtProveedor.setEditable(false);
        JtCliente.setEditable(false);
        JtSuela.setEditable(false);
    }

    private void JlSuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlSuelaMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Producto prod = (Producto) lis.getSelectedValue();

            JtSuela.setText(prod.getDescripcion());
            limpiarListaProductos();
            idSuela = prod.getId_Producto();
            JpSuela.setVisible(false);
        }
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
        limpiarListaProductos();

        if (JtSuela.getText().isEmpty()) {
            limpiarListaProductos();
            JpSuela.setVisible(false);
        } else {
            if (Movimiento.equals("Salida")) {
                ArrayList<Producto> listaProductos = objProd.GetByCliente(idCliente, JtSuela.getText());
                listaProductos.forEach(modeloListaProducto::addElement);
            } else {
                ArrayList<Producto> listaProductos = objProd.GetByM(JtSuela.getText());
                listaProductos.forEach(modeloListaProducto::addElement);
            }
        }
    }//GEN-LAST:event_JtSuelaKeyReleased

    private void JlClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlClienteMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Cliente cl = (Cliente) lis.getSelectedValue();

            if (cl.getRazonSocial().equals("")) {
                JOptionPane.showMessageDialog(null, ms, "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JtCliente.setText(cl.getNombre());
                limpiarListaClientes();
                idCliente = cl.getId_Cliente();
                JpCliente.setVisible(false);
                JtSuela.setEditable(true);
                JtSuela.requestFocus();
            }
        }
    }//GEN-LAST:event_JlClienteMouseClicked

    private void JtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtClienteKeyReleased
        JpCliente.setVisible(true);
        limpiarListaClientes();
        if (JtCliente.getText().isEmpty()) {
            limpiarListaClientes();
            JpCliente.setVisible(false);
        } else {

            ArrayList<Cliente> listaClientesR = objC.clienteGetByRz(JtCliente.getText());

            if (Serie.equals("A")) {
                listaClientesR.forEach((Cliente cli) -> {
                    if (!cli.getRazonSocial().equals("")) {
                        cli.setNombre(cli.getRazonSocial());
                        modeloListaCliente.addElement(cli);
                    } else if (cli.getRazonSocial().equals("")) {
                        ms = "ESTE CLIENTE NO TIENE RAZÓN SOCIAL";
                        cli.setNombre("ESTE CLIENTE NO TIENE RAZÓN SOCIAL");
                        modeloListaCliente.addElement(cli);
                    }
                });
            } else if (Serie.equals("B")) {
                listaClientesR.forEach(modeloListaCliente::addElement);
            }
        }
    }//GEN-LAST:event_JtClienteKeyReleased

    private void JtProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyReleased
        JpProveedor.setVisible(true);
        limpiarListaProveedores();
        if (JtProveedor.getText().isEmpty()) {
            limpiarListaProveedores();
            JpProveedor.setVisible(false);
        } else {
            ArrayList<Proveedor> listaP = objPv.proveedorSearch(JtProveedor.getText());

            listaP.forEach((pv) -> {
                modeloListaProveedor.addElement(pv);
            });
        }
    }//GEN-LAST:event_JtProveedorKeyReleased

    private void JlProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlProveedorMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Proveedor pv = (Proveedor) lis.getSelectedValue();

            JtProveedor.setText(pv.getNombre());
            limpiarListaProveedores();
            idProveedor = pv.getProveedor();
            JpProveedor.setVisible(false);
            JtSuela.requestFocus();
        }
    }//GEN-LAST:event_JlProveedorMouseClicked

    private void JtsubCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtsubCuentaMouseClicked
        if (evt.getClickCount() > 1) {
            limpiarCampos();
        }
    }//GEN-LAST:event_JtsubCuentaMouseClicked

    private void JtsubCuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtsubCuentaKeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_BACK_SPACE) {
            limpiarCampos();
        }
    }//GEN-LAST:event_JtsubCuentaKeyPressed

    private void JtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtClienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtClienteKeyTyped

    private void JtProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtProveedorKeyTyped

    private void JtSuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtSuelaKeyTyped

    private void JtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtClienteMouseClicked
        if (evt.getClickCount() > 1) {
            JtCliente.setText("");
            limpiarListaClientes();
            JpCliente.setVisible(false);
        }
    }//GEN-LAST:event_JtClienteMouseClicked

    private void JtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtProveedorMouseClicked
        if (evt.getClickCount() > 1) {
            JtProveedor.setText("");
            limpiarListaProveedores();
            JpProveedor.setVisible(false);
        }
    }//GEN-LAST:event_JtProveedorMouseClicked

    private void JtSuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtSuelaMouseClicked
        if (evt.getClickCount() > 1) {
            JtSuela.setText("");
            limpiarListaProductos();
            JpSuela.setVisible(false);
        }
    }//GEN-LAST:event_JtSuelaMouseClicked

    private void limpiarCampos() {
        deshabilitarCampos();
        JtsubCuenta.setText("");
        JbFolio.setText("XXXXXX");
        JbfolioSalida.setVisible(false);
        JtCliente.setText("");
        JtSuela.setText("");
        JtProveedor.setText("");
        JcaOrigen.setSelectedIndex(0);
        JcaDestino.setSelectedIndex(0);
        JcaDestino.setVisible(false);
        JbIcono.setVisible(false);
        JtDoc.setText("");
        limpiarListaClientes();
        limpiarListaProveedores();
        limpiarListaProductos();
        JpCliente.setVisible(false);
        JpProveedor.setVisible(false);
        JpSuela.setVisible(false);
    }

    private void limpiarListaClientes() {
        modeloListaCliente.clear();
    }

    private void limpiarListaProveedores() {
        modeloListaProveedor.clear();
    }

    private void limpiarListaProductos() {
        modeloListaProducto.clear();
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
    private javax.swing.JLabel JbIcono;
    public javax.swing.JLabel JbSerie;
    private javax.swing.JLabel JbcuentaSalida;
    private javax.swing.JLabel JbfolioSalida;
    private javax.swing.JLabel JbsubCuentaSalida;
    private javax.swing.JCheckBox JcPrimer;
    private javax.swing.JComboBox<String> JcaDestino;
    private javax.swing.JComboBox<String> JcaOrigen;
    private com.toedter.calendar.JDateChooser JdFecha;
    private javax.swing.JList<Cliente> JlCliente;
    private javax.swing.JList<Proveedor> JlProveedor;
    private javax.swing.JList<Producto> JlSuela;
    private javax.swing.JPanel JpCliente;
    private javax.swing.JPanel JpProveedor;
    private javax.swing.JPanel JpSuela;
    private javax.swing.JTextField JtCliente;
    private javax.swing.JTextField JtCuenta;
    private javax.swing.JTable JtDatos;
    private javax.swing.JTextField JtDoc;
    private javax.swing.JTextField JtProveedor;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JTextField JtpC;
    private javax.swing.JTextField JtsubCuenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
