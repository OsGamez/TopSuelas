package ViewLayer;

import ObjectLayer.AlmacenRcpt;
import ObjectLayer.Cliente;
import ObjectLayer.ExistenciasStock;
import ObjectLayer.Kardex;
import ObjectLayer.ObjExistenciasStock;
import ObjectLayer.ObjectClientes;
import ObjectLayer.ObjectConceptos;
import ObjectLayer.ObjectKardex;
import ObjectLayer.ObjectParametros;
import ObjectLayer.ObjectProductos;
import ObjectLayer.ObjectProveedores;
import ObjectLayer.Parametro;
import ObjectLayer.Producto;
import ObjectLayer.Proveedor;
import ObjectLayer.Sesioninfo;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class MovimientosesCPT extends javax.swing.JFrame {

    ObjectParametros Par = new ObjectParametros();
    ObjectConceptos concepto = new ObjectConceptos();
    ObjectClientes objC = new ObjectClientes();
    ObjectProveedores objPv = new ObjectProveedores();
    ObjectProductos objProd = new ObjectProductos();
    ObjectKardex objK = new ObjectKardex();
    ObjExistenciasStock objSt = new ObjExistenciasStock();
    Sesioninfo sesion = new Sesioninfo();
    AlmacenRcpt am = new AlmacenRcpt();
    ObjExistenciasStock ObjE = new ObjExistenciasStock();
    DefaultListModel<Cliente> modeloListaCliente = new DefaultListModel<>();
    DefaultListModel<Proveedor> modeloListaProveedor = new DefaultListModel<>();
    DefaultListModel<Producto> modeloListaProducto = new DefaultListModel<>();
    int cuenta = 0, subCuenta = 0, idCliente, idSuela, idProveedor, sum, Am, amMov;
    int Cant1, Cant2, Cant3, Cant4, Cant5, Cant6, Cant7, Cant8, Cant9, Cant10, Cant11, Cant12, prod,
            st1 = 0, st2 = 0, st3 = 0, st4 = 0, st5 = 0, st6 = 0, st7 = 0, st8 = 0, st9 = 0, st10 = 0, st11 = 0, st12 = 0;
    double importe;
    Date Captura;
    float pi, pf;
    String ms, ms2, Movimiento, Serie = sesion.getSerie(), Doc, informacion = "";
    String c1 = "0", c2 = "0", c3 = "0", c4 = "0", c5 = "0", c6 = "0", c7 = "0", c8 = "0", c9 = "0", c10 = "0", c11 = "0", c12 = "0";
    ArrayList<String> array = new ArrayList<>();
    DecimalFormat format = new DecimalFormat("#.00");
    String data[] = new String[12];

    DefaultTableModel modelM = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public String getInformacion() {
        return this.informacion;
    }
    
    public MovimientosesCPT() {
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
        cargarListenerKardex();
        JtDoc.setEditable(false);
        JtDatos.getTableHeader().setReorderingAllowed(false);
        JtDatos.getTableHeader().setResizingAllowed(false);
        JtSuela.setEditable(false);
        JtPares.setEditable(false);
        JtpC.setEditable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/exchange.png"));
        setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbIcono = new javax.swing.JLabel();
        JcaDestino = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        JtpC = new javax.swing.JTextField();
        JpSuela = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JlSuela = new javax.swing.JList<Producto>();
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
        JcaOrigen = new javax.swing.JComboBox<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtObv = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatos = new javax.swing.JTable();
        JbfolioSalida = new javax.swing.JLabel();
        JbcuentaSalida = new javax.swing.JLabel();
        JbsubCuentaSalida = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JtDoc = new javax.swing.JTextField();
        JpCliente = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JlCliente = new javax.swing.JList<Cliente>();
        JtProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JpProveedor = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JlProveedor = new javax.swing.JList<Proveedor>();
        jLabel12 = new javax.swing.JLabel();
        JbQuitar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        JtPares = new javax.swing.JTextField();
        JbCancelar = new javax.swing.JButton();
        JbGuardar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        JbPares = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JbCosto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIMIENTOS CPT");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Refresh_36729.png"))); // NOI18N

        JcaDestino.setBackground(new java.awt.Color(102, 153, 255));
        JcaDestino.setForeground(new java.awt.Color(102, 153, 255));
        JcaDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JcaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcaDestinoActionPerformed(evt);
            }
        });

        jLabel11.setText("Precio / Costo :");

        JtpC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtpCActionPerformed(evt);
            }
        });

        JlSuela.setModel(modeloListaProducto);
        JlSuela.setSelectionBackground(new java.awt.Color(204, 255, 204));
        JlSuela.setSelectionForeground(new java.awt.Color(51, 51, 51));
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        JpSuelaLayout.setVerticalGroup(
            JpSuelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        JcaOrigen.setBackground(new java.awt.Color(102, 153, 255));
        JcaOrigen.setForeground(new java.awt.Color(102, 153, 255));
        JcaOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JcaOrigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcaOrigenItemStateChanged(evt);
            }
        });
        JcaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcaOrigenActionPerformed(evt);
            }
        });

        JtObv.setColumns(20);
        JtObv.setRows(5);
        jScrollPane2.setViewportView(JtObv);

        JtDatos.setBackground(new java.awt.Color(204, 255, 204));
        JtDatos.setForeground(new java.awt.Color(51, 51, 51));
        JtDatos.setModel(modelM);
        JtDatos.setGridColor(new java.awt.Color(255, 255, 255));
        JtDatos.setSelectionBackground(new java.awt.Color(224, 255, 255));
        JtDatos.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(JtDatos);

        JbfolioSalida.setForeground(new java.awt.Color(51, 153, 0));
        JbfolioSalida.setText("XXXXXX");

        JbcuentaSalida.setText("Cuenta");

        JbsubCuentaSalida.setText("Scuenta");

        jLabel2.setText("Doc. Ref:");

        JlCliente.setModel(modeloListaCliente);
        JlCliente.setSelectionBackground(new java.awt.Color(204, 255, 204));
        JlCliente.setSelectionForeground(new java.awt.Color(51, 51, 51));
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
                .addGap(0, 8, Short.MAX_VALUE))
        );
        JpClienteLayout.setVerticalGroup(
            JpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtProveedorKeyTyped(evt);
            }
        });

        jLabel8.setText("Proveedor:");

        JlProveedor.setModel(modeloListaProveedor);
        JlProveedor.setSelectionBackground(new java.awt.Color(204, 255, 204));
        JlProveedor.setSelectionForeground(new java.awt.Color(51, 51, 51));
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
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpProveedorLayout.setVerticalGroup(
            JpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProveedorLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel12.setText("Observaciones:");

        JbQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486348819-back-backwards-repeat-arrows-arrow-blue_80473.png"))); // NOI18N
        JbQuitar.setText("QUITAR SUELA");
        JbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbQuitarActionPerformed(evt);
            }
        });

        jLabel13.setText("Pares:");

        JtPares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtParesActionPerformed(evt);
            }
        });

        JbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/crossregular_106296.png"))); // NOI18N
        JbCancelar.setText("CANCELAR");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saveas_1173.png"))); // NOI18N
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        jLabel14.setText("Pares:");

        JbPares.setForeground(new java.awt.Color(51, 153, 0));
        JbPares.setText("0");

        jLabel16.setText("Costo:");

        JbCosto.setForeground(new java.awt.Color(51, 153, 0));
        JbCosto.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtpC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JcPrimer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addGap(26, 26, 26)
                                        .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(JpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel9)
                        .addGap(31, 31, 31)
                        .addComponent(JcaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbIcono)
                        .addGap(26, 26, 26)
                        .addComponent(JcaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JpProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JpSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(118, 118, 118))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbGuardar)
                                        .addGap(104, 104, 104)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JbPares, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(JbCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JbQuitar)))
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(64, 64, 64)
                        .addComponent(JbIcono)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JpProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(JpCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JcPrimer)
                                .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(JtpC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JpSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JbGuardar)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(JbPares)
                            .addComponent(jLabel16)
                            .addComponent(JbCosto))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadColumns() {
        modelM.addColumn("ID");
        modelM.addColumn("SUELA");
        modelM.addColumn("ALM");
        modelM.addColumn("TIPO");
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
        modelM.addColumn("CANT");
        modelM.addColumn("COSTO");
        modelM.addColumn("IMP");
        modelM.addColumn("#AM");

        JtDatos.getColumnModel().getColumn(0).setMaxWidth(0);
        JtDatos.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatos.getColumnModel().getColumn(0).setPreferredWidth(0);

        JtDatos.getColumnModel().getColumn(3).setMaxWidth(0);
        JtDatos.getColumnModel().getColumn(3).setMinWidth(0);
        JtDatos.getColumnModel().getColumn(3).setPreferredWidth(0);

        JtDatos.getColumnModel().getColumn(0).setPreferredWidth(0);
        JtDatos.getColumnModel().getColumn(1).setPreferredWidth(260);
        JtDatos.getColumnModel().getColumn(2).setPreferredWidth(65);
        JtDatos.getColumnModel().getColumn(4).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(5).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(6).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(7).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(8).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(9).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(10).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(11).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(12).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(13).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(14).setPreferredWidth(20);
        JtDatos.getColumnModel().getColumn(15).setPreferredWidth(20);

        JtDatos.getColumnModel().getColumn(16).setPreferredWidth(40);
        JtDatos.getColumnModel().getColumn(17).setPreferredWidth(40);
        JtDatos.getColumnModel().getColumn(18).setPreferredWidth(40);

        JtDatos.getColumnModel().getColumn(19).setMaxWidth(0);
        JtDatos.getColumnModel().getColumn(19).setMinWidth(0);
        JtDatos.getColumnModel().getColumn(19).setPreferredWidth(0);
    }

    private void LoadModelAm() {
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
                JbcuentaSalida.setText("60");
                JbsubCuentaSalida.setText("16");
                Movimiento = "Traspaso";
                JtpC.setEditable(false);

                for (Parametro par : listE) {
                    int var = entrada + par.getEntrada();
                    JbFolio.setText(String.valueOf(var));
                    JtDoc.setText(String.valueOf(var));
                }

                for (Parametro par : listS) {
                    int var = entrada + par.getSalida();
                    JbfolioSalida.setText(String.valueOf(var));
                }

            } else {
                JtProveedor.setEditable(true);
                Movimiento = "Entrada";
                for (Parametro par : listE) {
                    int var = entrada + par.getEntrada();
                    JbFolio.setText(String.valueOf(var));
                    JtDoc.setText(String.valueOf(var));
                }
            }
        } else if (cuenta >= 50) {
            if (cuenta == 60 && subCuenta == 16) {
                JbfolioSalida.setVisible(true);
                JbIcono.setVisible(true);
                JcaDestino.setVisible(true);
                JtSuela.setEditable(true);
                JbcuentaSalida.setText("01");
                JbsubCuentaSalida.setText("16");
                Movimiento = "Traspaso";
                JtpC.setEditable(false);
                for (Parametro par : listS) {
                    int var = entrada + par.getSalida();
                    JbFolio.setText(String.valueOf(var));
                    JtDoc.setText(String.valueOf(var));

                }
                for (Parametro par : listE) {
                    int var = entrada + par.getEntrada();
                    JbfolioSalida.setText(String.valueOf(var));
                }
            } else {
                JtCliente.setEditable(true);
                Movimiento = "Salida";
                JtpC.setEditable(false);
                for (Parametro par : listS) {
                    int var = entrada + par.getSalida();
                    JbFolio.setText(String.valueOf(var));
                    JtDoc.setText(String.valueOf(var));
                }
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

        int almacen = JcaOrigen.getSelectedIndex();
        int amd = JcaDestino.getSelectedIndex();

        if (evt.getClickCount() == 1) {
            Producto produc = (Producto) lis.getSelectedValue();
            switch (Movimiento) {
                case "Traspaso":
                    if (almacen == 0 || amd == 0 || JtPares.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Faltan datos de ingresar, verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JtSuela.setText(produc.getDescripcion());
                        limpiarListaProductos();
                        idSuela = produc.getId_Producto();
                        pi = produc.getPti();
                        pf = produc.getPtf();
                        JpSuela.setVisible(false);
                        validarCorrida();
                        JtpC.setText("0");
                    }
                    break;
                case "Salida":
                    if (almacen == 0 || JtPares.getText().equals("") || JtCliente.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Faltan datos de ingresar, verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JtSuela.setText(produc.getDescripcion());
                        limpiarListaProductos();
                        idSuela = produc.getId_Producto();
                        pi = produc.getPti();
                        pf = produc.getPtf();
                        JpSuela.setVisible(false);

                        if (Serie.equals("A") && JcPrimer.isSelected() == false) {
                            double precio = produc.getPrecioAP();
                            JtpC.setText(format.format(precio));
                        } else if (Serie.equals("A") && JcPrimer.isSelected() == true) {
                            double precio = produc.getPrecioA();
                            JtpC.setText(format.format(precio));
                        } else if (Serie.equals("B") && JcPrimer.isSelected() == false) {
                            double precio = produc.getPrecioBP();
                            JtpC.setText(format.format(precio));
                        } else if (Serie.equals("B") && JcPrimer.isSelected() == true) {
                            double precio = produc.getPrecioB();
                            JtpC.setText(format.format(precio));
                        }

                        validarCorrida();
                    }
                    break;
                case "Entrada":
                    if (almacen == 0 || JtPares.getText().equals("") || JtpC.getText().equals("") || JtProveedor.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Faltan datos de ingresar, verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JtSuela.setText(produc.getDescripcion());
                        limpiarListaProductos();
                        idSuela = produc.getId_Producto();
                        pi = produc.getPti();
                        pf = produc.getPtf();
                        JpSuela.setVisible(false);
                        validarCorrida();
                    }
                    break;
            }

        }
    }//GEN-LAST:event_JlSuelaMouseClicked

    private void validarCorrida() {
        int pt1 = (int) pi;
        int pt2 = (int) pf;
        double num = 0.5;
        sum = pt2 - pt1 + 1;
        String colums;
        Object[] datos = {"0"};

        PuntosMov p = new PuntosMov(null, true);
        for (int i = pt1; i <= pt2; i++) {
            colums = String.valueOf(i);
            p.modelP.addColumn(colums, datos);

            for (double j = i + num; j <= i + num; j++) {
                colums = String.valueOf(j);
                p.modelP.addColumn(colums, datos);
            }
        }

        if ("Salida".equals(Movimiento) || "Traspaso".equals(Movimiento)) {
            if (verificarExistencias()) {
                switch (sum * 2) {
                    case 12:
                        data[0] = String.valueOf(st1);
                        data[1] = String.valueOf(st2);
                        data[2] = String.valueOf(st3);
                        data[3] = String.valueOf(st4);
                        data[4] = String.valueOf(st5);
                        data[5] = String.valueOf(st6);
                        data[6] = String.valueOf(st7);
                        data[7] = String.valueOf(st8);
                        data[8] = String.valueOf(st9);
                        data[9] = String.valueOf(st10);
                        data[10] = String.valueOf(st11);
                        data[11] = String.valueOf(st12);

                        break;
                    case 10:
                        data[0] = String.valueOf(st1);
                        data[1] = String.valueOf(st2);
                        data[2] = String.valueOf(st3);
                        data[3] = String.valueOf(st4);
                        data[4] = String.valueOf(st5);
                        data[5] = String.valueOf(st6);
                        data[6] = String.valueOf(st7);
                        data[7] = String.valueOf(st8);
                        data[8] = String.valueOf(st9);
                        data[9] = String.valueOf(st10);
                        break;
                    case 8:
                        data[0] = String.valueOf(st1);
                        data[1] = String.valueOf(st2);
                        data[2] = String.valueOf(st3);
                        data[3] = String.valueOf(st4);
                        data[4] = String.valueOf(st5);
                        data[5] = String.valueOf(st6);
                        data[6] = String.valueOf(st7);
                        data[7] = String.valueOf(st8);
                        break;
                    case 6:
                        data[0] = String.valueOf(st1);
                        data[1] = String.valueOf(st2);
                        data[2] = String.valueOf(st3);
                        data[3] = String.valueOf(st4);
                        data[4] = String.valueOf(st5);
                        data[5] = String.valueOf(st6);
                        break;
                }

                p.modelP.addRow(data);

                p.SumaPuntos = sum;
                p.Am = Am;
                p.AmD = amMov;
                p.Prod = idSuela;
                p.Mov = Movimiento;
                p.Pares = Integer.parseInt(JtPares.getText());
                p.Jtdatos.changeSelection(0, 0, true, false);
                p.array = array;
                p.setVisible(true);
            } else {
                JtSuela.setText("");
                JtPares.setText("");
                JtpC.setText("");
                JtPares.requestFocus();
            }
        } else {
            p.SumaPuntos = sum;
            p.Mov = Movimiento;
            p.Pares = Integer.parseInt(JtPares.getText());
            p.Jtdatos.changeSelection(0, 0, true, false);
            p.array = array;
            p.setVisible(true);
        }

    }

    private void MostrarDetalle() {
        Object[] obj = array.toArray();
        String dt[] = new String[20];

        switch (obj.length) {
            case 12:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                c7 = (String) obj[6];
                c8 = (String) obj[7];
                c9 = (String) obj[8];
                c10 = (String) obj[9];
                c11 = (String) obj[10];
                c12 = (String) obj[11];
                break;
            case 10:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                c7 = (String) obj[6];
                c8 = (String) obj[7];
                c9 = (String) obj[8];
                c10 = (String) obj[9];
                break;
            case 8:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                c7 = (String) obj[6];
                c8 = (String) obj[7];
                break;
            case 6:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                break;
            default:
                break;
        }

        double impor = Double.parseDouble(JtPares.getText()) * Double.parseDouble(JtpC.getText());

        dt[0] = String.valueOf(idSuela);
        dt[1] = JtSuela.getText();
        dt[2] = (String) JcaOrigen.getSelectedItem().toString();
        dt[3] = "Entrada";
        dt[4] = c1;
        dt[5] = c2;
        dt[6] = c3;
        dt[7] = c4;
        dt[8] = c5;
        dt[9] = c6;
        dt[10] = c7;
        dt[11] = c8;
        dt[12] = c9;
        dt[13] = c10;
        dt[14] = c11;
        dt[15] = c12;
        dt[16] = JtPares.getText();
        dt[17] = JtpC.getText();
        dt[18] = String.valueOf(impor);
        dt[19] = String.valueOf(Am);
        modelM.addRow(dt);
    }

    private boolean verificarExistencias() {
        ArrayList<ExistenciasStock> listE = ObjE.getStock(Am, idSuela);

        if (listE.size() > 0) {
            for (ExistenciasStock ex : listE) {
                st1 = ex.getPunto1();
                st2 = ex.getPunto2();
                st3 = ex.getPunto3();
                st4 = ex.getPunto4();
                st5 = ex.getPunto5();
                st6 = ex.getPunto6();
                st7 = ex.getPunto7();
                st8 = ex.getPunto8();
                st9 = ex.getPunto9();
                st10 = ex.getPunto10();
                st11 = ex.getPunto11();
                st12 = ex.getPunto12();
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Esta suela no tiene existencias", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            array.clear();
        }

        return false;
    }

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

    private void JlClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlClienteMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {

            if (JcaOrigen.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Selecciona un almacén", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                Cliente cl = (Cliente) lis.getSelectedValue();

                if (cl.getRazonSocial().equals("")) {
                    JOptionPane.showMessageDialog(null, ms, "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JtCliente.setText(cl.getNombre());
                    limpiarListaClientes();
                    idCliente = cl.getId_Cliente();
                    JpCliente.setVisible(false);
                    JtSuela.setEditable(true);
                    JtPares.setEditable(true);
                    JtPares.requestFocus();
                    JtpC.setEditable(false);
                }
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

            switch (Serie) {
                case "A":
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
                    break;
                case "B":
                    listaClientesR.forEach(modeloListaCliente::addElement);
                    break;
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

            if (JcaOrigen.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Selecciona un almacén", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                Proveedor pv = (Proveedor) lis.getSelectedValue();

                JtProveedor.setText(pv.getNombre());
                limpiarListaProveedores();
                idProveedor = pv.getProveedor();
                JpProveedor.setVisible(false);
                JtPares.setEditable(true);
                JtPares.requestFocus();
                JtpC.setEditable(true);
                JtSuela.setEditable(true);
            }

        }
    }//GEN-LAST:event_JlProveedorMouseClicked

    private void JtsubCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtsubCuentaMouseClicked

    }//GEN-LAST:event_JtsubCuentaMouseClicked

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

    private void JtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtClienteMouseClicked
        if (evt.getClickCount() > 1) {
            JtCliente.setText("");
            limpiarListaClientes();
            JpCliente.setVisible(false);
        }
    }//GEN-LAST:event_JtClienteMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (array.size() > 0) {

            MostrarDetalle();
            LimpiarRegistro();

            switch (Movimiento) {
                case "Entrada":
                    JcaOrigen.setEnabled(false);
                    break;
                case "Salida":
                    JcaOrigen.setEnabled(false);
                    break;
                case "Traspaso":
                    JcaOrigen.setEnabled(false);
                    JcaDestino.setEnabled(false);
                    break;
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void JtParesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtParesActionPerformed
        if (JtPares.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa una cantidad, verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else {
            switch (Movimiento) {
                case "Entrada":
                    if (JtProveedor.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Selecciona un proveedor", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JtpC.requestFocus();
                    }
                    break;
                case "Salida":
                    if (JtCliente.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Selecciona un cliente", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JtSuela.requestFocus();
                        JtpC.setEditable(false);
                    }
                    break;
                case "Traspaso":
                    JtSuela.requestFocus();
                    JtpC.setEditable(false);
                    break;
            }
        }
    }//GEN-LAST:event_JtParesActionPerformed

    private void JtsubCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtsubCuentaActionPerformed
        if (concepto.validarSubCuenta(JtsubCuenta.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Esta Subcuenta no existe", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else {
            cargarFolio();
            JcaOrigen.requestFocus();
        }
    }//GEN-LAST:event_JtsubCuentaActionPerformed

    private void JcaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcaDestinoActionPerformed
        if ("Traspaso".equals(Movimiento)) {
            if (JcaOrigen.getSelectedItem().toString().equals(JcaDestino.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Selecciona una almacén diferente");
                JcaDestino.setSelectedIndex(0);
            } else {
                JtPares.setEditable(true);
                JtPares.requestFocus();
                JtSuela.setEditable(true);

            }
            AlmacenRcpt al = (AlmacenRcpt) JcaDestino.getSelectedItem();
            amMov = al.getAlmacen();
        }
    }//GEN-LAST:event_JcaDestinoActionPerformed

    private void JbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbQuitarActionPerformed
        int row = JtDatos.getSelectedRow();

        if (row >= 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres omitir este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                modelM.removeRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
        }
    }//GEN-LAST:event_JbQuitarActionPerformed

    private void JtpCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtpCActionPerformed

        if (Movimiento.equals("Entrada")) {
            if (JtpC.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingresa un precio, verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                JtSuela.requestFocus();
            }
        } else {
            JtSuela.requestFocus();
        }
    }//GEN-LAST:event_JtpCActionPerformed

    private void JcaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcaOrigenActionPerformed
        if ("Traspaso".equals(Movimiento)) {
            JcaDestino.requestFocus();
        } else {
            if (cuenta < 50) {
                JtProveedor.requestFocus();
            } else {
                JtCliente.requestFocus();
            }
        }
        AlmacenRcpt al = (AlmacenRcpt) JcaOrigen.getSelectedItem();
        Am = al.getAlmacen();
    }//GEN-LAST:event_JcaOrigenActionPerformed

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres cancelar esta operación?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            JtSuela.setText("");
            idSuela = 0;
            pi = 0;
            pf = 0;
            JtPares.setText("");
            JtProveedor.setEditable(false);
            JtCliente.setEditable(false);
            JtpC.setText("");
            array.clear();
            c1 = "0";
            c2 = "0";
            c3 = "0";
            c4 = "0";
            c5 = "0";
            c6 = "0";
            c7 = "0";
            c8 = "0";
            c9 = "0";
            c10 = "0";
            c11 = "0";
            c12 = "0";
            JbFolio.setText("XXXXXX");
            JbfolioSalida.setVisible(false);
            JtsubCuenta.setText("");
            JtCliente.setText("");
            JtSuela.setText("");
            JtProveedor.setText("");
            JtPares.setText("");
            JtpC.setText("");
            Movimiento = "";
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
            JcaOrigen.setEnabled(true);
            JcaDestino.setEnabled(true);
            JtsubCuenta.setEditable(true);
            JtCuenta.setEditable(true);
            JtpC.setEditable(false);
            JtPares.setEditable(false);
            cleanTable();
            JtCuenta.setText("");
            JtCuenta.requestFocus();
            JtSuela.setEditable(false);
        }
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void limpiarMovimiento() {

        JtSuela.setText("");
        idSuela = 0;
        pi = 0;
        pf = 0;
        JtPares.setText("");
        JtProveedor.setEditable(false);
        JtCliente.setEditable(false);
        JtpC.setText("");
        array.clear();
        c1 = "0";
        c2 = "0";
        c3 = "0";
        c4 = "0";
        c5 = "0";
        c6 = "0";
        c7 = "0";
        c8 = "0";
        c9 = "0";
        c10 = "0";
        c11 = "0";
        c12 = "0";
        JbFolio.setText("XXXXXX");
        JbfolioSalida.setVisible(false);
        JtsubCuenta.setText("");
        JtCliente.setText("");
        JtSuela.setText("");
        JtProveedor.setText("");
        JtPares.setText("");
        JtpC.setText("");
        Movimiento = "";
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
        JcaOrigen.setEnabled(true);
        JcaDestino.setEnabled(true);
        JtsubCuenta.setEditable(true);
        JtCuenta.setEditable(true);
        JtpC.setEditable(false);
        JtPares.setEditable(false);
        cleanTable();
        JtCuenta.setText("");
        JtCuenta.requestFocus();
        JtSuela.setEditable(false);

    }

    private void JcaOrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcaOrigenItemStateChanged

    }//GEN-LAST:event_JcaOrigenItemStateChanged

    private void JtSuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtSuelaKeyTyped

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

    private void JtSuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtSuelaMouseClicked
        if (evt.getClickCount() > 1) {
            JtSuela.setText("");
            limpiarListaProductos();
            JpSuela.setVisible(false);
        }
    }//GEN-LAST:event_JtSuelaMouseClicked

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void LimpiarRegistro() {
        JtSuela.setText("");
        idSuela = 0;
        pi = 0;
        pf = 0;
        JtPares.setText("");
        JtProveedor.setEditable(false);
        JtCliente.setEditable(false);
        JtCuenta.setEditable(false);
        JtsubCuenta.setEditable(false);
        JtpC.setText("");
        array.clear();
        c1 = "0";
        c2 = "0";
        c3 = "0";
        c4 = "0";
        c5 = "0";
        c6 = "0";
        c7 = "0";
        c8 = "0";
        c9 = "0";
        c10 = "0";
        c11 = "0";
        c12 = "0";
        JtPares.requestFocus();
        JtObv.setText("");
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

    private void cleanTable() {
        int numFilas = modelM.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelM.removeRow(i);
            }
        }
    }

    private void Guardar() {

        switch (Movimiento) {
            case "Salida":
                Salida();
                break;
            case "Entrada":
                Entrada();
                break;
            case "Traspaso":
                Traspaso();
                switch (JtCuenta.getText()) {
                    case "01":
                        if (ms.equals("ok")) {
                            Par.actualizarFolioEntrada(Integer.parseInt(JbFolio.getText()));
                            Par.actualizarFolioSalida(Integer.parseInt(JbfolioSalida.getText()));
                            JOptionPane.showMessageDialog(this, "Movimiento Guardado!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            limpiarMovimiento();
                            informacion = "1";
                        } else {

                        }
                        break;
                    case "60":
                        if (ms.equals("ok")) {
                            Par.actualizarFolioEntrada(Integer.parseInt(JbfolioSalida.getText()));
                            Par.actualizarFolioSalida(Integer.parseInt(JbFolio.getText()));
                            JOptionPane.showMessageDialog(this, "Movimiento Guardado!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            limpiarMovimiento();
                            informacion = "1";
                        } else {

                        }
                        break;
                }
                break;
        }
    }

    private void Entrada() {

        for (int i = 0; i < JtDatos.getRowCount(); i++) {

            Captura = JdFecha.getDate();
            long c = Captura.getTime();
            java.sql.Date fechaMovimiento = new java.sql.Date(c);
            prod = Integer.parseInt((String) JtDatos.getValueAt(i, 0));
            Am = Integer.parseInt((String) JtDatos.getValueAt(i, 19));

            Cant1 = Integer.parseInt((String) JtDatos.getValueAt(i, 4));
            Cant2 = Integer.parseInt((String) JtDatos.getValueAt(i, 5));
            Cant3 = Integer.parseInt((String) JtDatos.getValueAt(i, 6));
            Cant4 = Integer.parseInt((String) JtDatos.getValueAt(i, 7));
            Cant5 = Integer.parseInt((String) JtDatos.getValueAt(i, 8));
            Cant6 = Integer.parseInt((String) JtDatos.getValueAt(i, 9));
            Cant7 = Integer.parseInt((String) JtDatos.getValueAt(i, 10));
            Cant8 = Integer.parseInt((String) JtDatos.getValueAt(i, 11));
            Cant9 = Integer.parseInt((String) JtDatos.getValueAt(i, 12));
            Cant10 = Integer.parseInt((String) JtDatos.getValueAt(i, 13));
            Cant11 = Integer.parseInt((String) JtDatos.getValueAt(i, 14));
            Cant12 = Integer.parseInt((String) JtDatos.getValueAt(i, 15));
            importe = Double.parseDouble((String) JtDatos.getValueAt(i, 18));

            Kardex kd = new Kardex();
            kd.setAlmacen(Am);
            kd.setProducto(prod);
            kd.setFolio(Integer.parseInt(JbFolio.getText()));
            kd.setFMovimiento(fechaMovimiento);
            kd.setDocumentoRef(JtDoc.getText());
            kd.setCuenta(JtCuenta.getText());
            kd.setSubCuenta(JtsubCuenta.getText());
            kd.setTotalPares(Integer.parseInt(JbPares.getText()));
            kd.setImporteCosto(importe);
            kd.setCantidad1(Cant1);
            kd.setCantidad2(Cant2);
            kd.setCantidad3(Cant3);
            kd.setCantidad4(Cant4);
            kd.setCantidad5(Cant5);
            kd.setCantidad6(Cant6);
            kd.setCantidad7(Cant7);
            kd.setCantidad8(Cant8);
            kd.setCantidad9(Cant9);
            kd.setCantidad10(Cant10);
            kd.setCantidad11(Cant11);
            kd.setCantidad12(Cant12);
            kd.setObservaciones(JtObv.getText());
            kd.setUsuario(sesion.getUsuario());
            kd.setSerie(Serie);

            ExistenciasStock st = new ExistenciasStock();
            st.setAlmacen(Am);
            st.setProducto(prod);
            st.setPunto1(Cant1);
            st.setPunto2(Cant2);
            st.setPunto3(Cant3);
            st.setPunto4(Cant4);
            st.setPunto5(Cant5);
            st.setPunto6(Cant6);
            st.setPunto7(Cant7);
            st.setPunto8(Cant8);
            st.setPunto9(Cant9);
            st.setPunto10(Cant10);
            st.setPunto11(Cant11);
            st.setPunto12(Cant12);
            st.setSerie(Serie);
            st.setUsuario(sesion.getUsuario());
            st.setRegistro(fechaMovimiento);

            ArrayList<ExistenciasStock> listE = ObjE.getStock(Am, prod);

            if (listE.size() > 0) {
                if (objK.kardexAdd(kd)) {
                    if (objSt.sumarExistencia(st)) {
                        ms = "ok";
                        Par.actualizarFolioEntrada(Integer.parseInt(JbFolio.getText()));
                        informacion = "1";
                    } else {
                        ms = "error";
                    }
                }

            } else {
                if (objK.kardexAdd(kd)) {
                    if (objSt.AddExistencia(st)) {
                        ms = "ok";
                        Par.actualizarFolioEntrada(Integer.parseInt(JbFolio.getText()));
                    } else {
                        ms = "error";
                        informacion = "1";
                    }
                }
            }
        }

        switch (ms) {
            case "ok":
                JOptionPane.showMessageDialog(this, "Movimiento Guardado!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                limpiarMovimiento();
                break;
            case "error":
                JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                limpiarMovimiento();
                break;
        }
    }

    private void Salida() {
        for (int i = 0; i < JtDatos.getRowCount(); i++) {

            Captura = JdFecha.getDate();
            long c = Captura.getTime();
            java.sql.Date fechaMovimiento = new java.sql.Date(c);
            prod = Integer.parseInt((String) JtDatos.getValueAt(i, 0));
            Am = Integer.parseInt((String) JtDatos.getValueAt(i, 19));

            Cant1 = Integer.parseInt((String) JtDatos.getValueAt(i, 4));
            Cant2 = Integer.parseInt((String) JtDatos.getValueAt(i, 5));
            Cant3 = Integer.parseInt((String) JtDatos.getValueAt(i, 6));
            Cant4 = Integer.parseInt((String) JtDatos.getValueAt(i, 7));
            Cant5 = Integer.parseInt((String) JtDatos.getValueAt(i, 8));
            Cant6 = Integer.parseInt((String) JtDatos.getValueAt(i, 9));
            Cant7 = Integer.parseInt((String) JtDatos.getValueAt(i, 10));
            Cant8 = Integer.parseInt((String) JtDatos.getValueAt(i, 11));
            Cant9 = Integer.parseInt((String) JtDatos.getValueAt(i, 12));
            Cant10 = Integer.parseInt((String) JtDatos.getValueAt(i, 13));
            Cant11 = Integer.parseInt((String) JtDatos.getValueAt(i, 14));
            Cant12 = Integer.parseInt((String) JtDatos.getValueAt(i, 15));
            importe = Double.parseDouble((String) JtDatos.getValueAt(i, 18));

            Kardex kd = new Kardex();
            kd.setAlmacen(Am);
            kd.setProducto(prod);
            kd.setFolio(Integer.parseInt(JbFolio.getText()));
            kd.setFMovimiento(fechaMovimiento);
            kd.setDocumentoRef(JtDoc.getText());
            kd.setCuenta(JtCuenta.getText());
            kd.setSubCuenta(JtsubCuenta.getText());
            kd.setTotalPares(Integer.parseInt(JbPares.getText()));
            kd.setImporteCosto(importe);
            kd.setCantidad1(Cant1);
            kd.setCantidad2(Cant2);
            kd.setCantidad3(Cant3);
            kd.setCantidad4(Cant4);
            kd.setCantidad5(Cant5);
            kd.setCantidad6(Cant6);
            kd.setCantidad7(Cant7);
            kd.setCantidad8(Cant8);
            kd.setCantidad9(Cant9);
            kd.setCantidad10(Cant10);
            kd.setCantidad11(Cant11);
            kd.setCantidad12(Cant12);
            kd.setObservaciones(JtObv.getText());
            kd.setUsuario(sesion.getUsuario());
            kd.setSerie(Serie);

            ExistenciasStock st = new ExistenciasStock();
            st.setAlmacen(Am);
            st.setProducto(prod);
            st.setPunto1(Cant1);
            st.setPunto2(Cant2);
            st.setPunto3(Cant3);
            st.setPunto4(Cant4);
            st.setPunto5(Cant5);
            st.setPunto6(Cant6);
            st.setPunto7(Cant7);
            st.setPunto8(Cant8);
            st.setPunto9(Cant9);
            st.setPunto10(Cant10);
            st.setPunto11(Cant11);
            st.setPunto12(Cant12);
            st.setSerie(Serie);
            st.setUsuario(sesion.getUsuario());
            st.setRegistro(fechaMovimiento);

            if (objK.kardexAdd(kd)) {
                if (objSt.quitarExistencia(st)) {
                    ms = "ok";
                    Par.actualizarFolioSalida(Integer.parseInt(JbFolio.getText()));
                    informacion = "1";
                } else {
                    ms = "error";
                }
            }
        }

        switch (ms) {
            case "ok":
                JOptionPane.showMessageDialog(this, "Movimiento Guardado!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                limpiarMovimiento();
                break;
            case "error":
                JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                limpiarMovimiento();
                break;
        }
    }

    private void EntradaT() {

        for (int i = 0; i < JtDatos.getRowCount(); i++) {

            Captura = JdFecha.getDate();
            long c = Captura.getTime();
            java.sql.Date fechaMovimiento = new java.sql.Date(c);
            prod = Integer.parseInt((String) JtDatos.getValueAt(i, 0));
            //Am = Integer.parseInt((String) JtDatos.getValueAt(i, 19));

            Cant1 = Integer.parseInt((String) JtDatos.getValueAt(i, 4));
            Cant2 = Integer.parseInt((String) JtDatos.getValueAt(i, 5));
            Cant3 = Integer.parseInt((String) JtDatos.getValueAt(i, 6));
            Cant4 = Integer.parseInt((String) JtDatos.getValueAt(i, 7));
            Cant5 = Integer.parseInt((String) JtDatos.getValueAt(i, 8));
            Cant6 = Integer.parseInt((String) JtDatos.getValueAt(i, 9));
            Cant7 = Integer.parseInt((String) JtDatos.getValueAt(i, 10));
            Cant8 = Integer.parseInt((String) JtDatos.getValueAt(i, 11));
            Cant9 = Integer.parseInt((String) JtDatos.getValueAt(i, 12));
            Cant10 = Integer.parseInt((String) JtDatos.getValueAt(i, 13));
            Cant11 = Integer.parseInt((String) JtDatos.getValueAt(i, 14));
            Cant12 = Integer.parseInt((String) JtDatos.getValueAt(i, 15));
            importe = Double.parseDouble((String) JtDatos.getValueAt(i, 18));

            Kardex kd = new Kardex();
            kd.setAlmacen(amMov);
            kd.setProducto(prod);
            kd.setFolio(Integer.parseInt(JbfolioSalida.getText()));
            kd.setFMovimiento(fechaMovimiento);
            kd.setDocumentoRef(JbfolioSalida.getText());
            kd.setCuenta(JbcuentaSalida.getText());
            kd.setSubCuenta(JbsubCuentaSalida.getText());
            kd.setTotalPares(Integer.parseInt(JbPares.getText()));
            kd.setImporteCosto(importe);
            kd.setCantidad1(Cant1);
            kd.setCantidad2(Cant2);
            kd.setCantidad3(Cant3);
            kd.setCantidad4(Cant4);
            kd.setCantidad5(Cant5);
            kd.setCantidad6(Cant6);
            kd.setCantidad7(Cant7);
            kd.setCantidad8(Cant8);
            kd.setCantidad9(Cant9);
            kd.setCantidad10(Cant10);
            kd.setCantidad11(Cant11);
            kd.setCantidad12(Cant12);
            kd.setObservaciones(JtObv.getText());
            kd.setUsuario(sesion.getUsuario());
            kd.setSerie(Serie);

            ExistenciasStock st = new ExistenciasStock();
            st.setAlmacen(amMov);
            st.setProducto(prod);
            st.setPunto1(Cant1);
            st.setPunto2(Cant2);
            st.setPunto3(Cant3);
            st.setPunto4(Cant4);
            st.setPunto5(Cant5);
            st.setPunto6(Cant6);
            st.setPunto7(Cant7);
            st.setPunto8(Cant8);
            st.setPunto9(Cant9);
            st.setPunto10(Cant10);
            st.setPunto11(Cant11);
            st.setPunto12(Cant12);
            st.setSerie(Serie);
            st.setUsuario(sesion.getUsuario());
            st.setRegistro(fechaMovimiento);

            ArrayList<ExistenciasStock> listE = ObjE.getStock(amMov, prod);

            if (listE.size() > 0) {
                if (objK.kardexAdd(kd)) {
                    if (objSt.sumarExistencia(st)) {
                        ms = "ok";
                    } else {
                        ms = "error";
                    }
                }
            } else {
                if (objK.kardexAdd(kd)) {
                    if (objSt.AddExistencia(st)) {
                        ms = "ok";
                    } else {
                        ms = "error";
                    }
                }
            }
        }
    }

    private void SalidT() {
        for (int i = 0; i < JtDatos.getRowCount(); i++) {

            Captura = JdFecha.getDate();
            long c = Captura.getTime();
            java.sql.Date fechaMovimiento = new java.sql.Date(c);
            prod = Integer.parseInt((String) JtDatos.getValueAt(i, 0));
            Am = Integer.parseInt((String) JtDatos.getValueAt(i, 19));

            Cant1 = Integer.parseInt((String) JtDatos.getValueAt(i, 4));
            Cant2 = Integer.parseInt((String) JtDatos.getValueAt(i, 5));
            Cant3 = Integer.parseInt((String) JtDatos.getValueAt(i, 6));
            Cant4 = Integer.parseInt((String) JtDatos.getValueAt(i, 7));
            Cant5 = Integer.parseInt((String) JtDatos.getValueAt(i, 8));
            Cant6 = Integer.parseInt((String) JtDatos.getValueAt(i, 9));
            Cant7 = Integer.parseInt((String) JtDatos.getValueAt(i, 10));
            Cant8 = Integer.parseInt((String) JtDatos.getValueAt(i, 11));
            Cant9 = Integer.parseInt((String) JtDatos.getValueAt(i, 12));
            Cant10 = Integer.parseInt((String) JtDatos.getValueAt(i, 13));
            Cant11 = Integer.parseInt((String) JtDatos.getValueAt(i, 14));
            Cant12 = Integer.parseInt((String) JtDatos.getValueAt(i, 15));
            importe = Double.parseDouble((String) JtDatos.getValueAt(i, 18));

            Kardex kd = new Kardex();
            kd.setAlmacen(Am);
            kd.setProducto(prod);
            kd.setFolio(Integer.parseInt(JbFolio.getText()));
            kd.setFMovimiento(fechaMovimiento);
            kd.setDocumentoRef(JbFolio.getText());
            kd.setCuenta(JtCuenta.getText());
            kd.setSubCuenta(JtsubCuenta.getText());
            kd.setTotalPares(Integer.parseInt(JbPares.getText()));
            kd.setImporteCosto(importe);
            kd.setCantidad1(Cant1);
            kd.setCantidad2(Cant2);
            kd.setCantidad3(Cant3);
            kd.setCantidad4(Cant4);
            kd.setCantidad5(Cant5);
            kd.setCantidad6(Cant6);
            kd.setCantidad7(Cant7);
            kd.setCantidad8(Cant8);
            kd.setCantidad9(Cant9);
            kd.setCantidad10(Cant10);
            kd.setCantidad11(Cant11);
            kd.setCantidad12(Cant12);
            kd.setObservaciones(JtObv.getText());
            kd.setUsuario(sesion.getUsuario());
            kd.setSerie(Serie);

            ExistenciasStock st = new ExistenciasStock();
            st.setAlmacen(Am);
            st.setProducto(prod);
            st.setPunto1(Cant1);
            st.setPunto2(Cant2);
            st.setPunto3(Cant3);
            st.setPunto4(Cant4);
            st.setPunto5(Cant5);
            st.setPunto6(Cant6);
            st.setPunto7(Cant7);
            st.setPunto8(Cant8);
            st.setPunto9(Cant9);
            st.setPunto10(Cant10);
            st.setPunto11(Cant11);
            st.setPunto12(Cant12);
            st.setSerie(Serie);
            st.setUsuario(sesion.getUsuario());
            st.setRegistro(fechaMovimiento);

            if (objK.kardexAdd(kd)) {
                if (objSt.quitarExistencia(st)) {
                    ms2 = "ok";
                } else {
                    ms2 = "error";
                }
            }
        }
    }

    private void Traspaso() {
        SalidT();

        switch (ms2) {
            case "ok":
                EntradaT();
                break;
            case "error":
                JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                limpiarMovimiento();
                break;
        }

    }

    private void cargarListenerKardex() {
        modelM.addTableModelListener((TableModelEvent e) -> {
            int row = modelM.getRowCount();
            double sumatoria = 0;
            int pares = 0;
            DecimalFormat total = new DecimalFormat("0.00");
            for (int i = 0; i < row; i++) {
                String importe = (String) modelM.getValueAt(i, 18);
                String tpares = (String) modelM.getValueAt(i, 16);
                sumatoria += Double.parseDouble(importe);
                pares += Integer.parseInt(tpares);
            }
            JbCosto.setText(total.format(sumatoria));
            JbPares.setText(String.valueOf(pares));
        });
    }

    
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
            java.util.logging.Logger.getLogger(MovimientosesCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosesCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosesCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosesCPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosesCPT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbCosto;
    private javax.swing.JLabel JbFolio;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbIcono;
    private javax.swing.JLabel JbPares;
    private javax.swing.JButton JbQuitar;
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
    private javax.swing.JTextArea JtObv;
    private javax.swing.JTextField JtPares;
    private javax.swing.JTextField JtProveedor;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JTextField JtpC;
    private javax.swing.JTextField JtsubCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
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
    // End of variables declaration//GEN-END:variables
}
