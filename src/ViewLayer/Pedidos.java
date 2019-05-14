package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Cliente;
import ObjectLayer.Color;
import ObjectLayer.Corrida;
import ObjectLayer.Dpedido;
import ObjectLayer.ObjectClientes;
import ObjectLayer.ObjectCorridas;
import ObjectLayer.ObjectDetalle;
import ObjectLayer.ObjectParametros;
import ObjectLayer.ObjectPedidos;
import ObjectLayer.ObjectPrecios;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Parametro;
import ObjectLayer.Pedido;
import ObjectLayer.Precio;
import ObjectLayer.Producto;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Pedidos extends javax.swing.JInternalFrame {

    ObjectClientes obj = new ObjectClientes();
    Cliente cliente = new Cliente();
    ObjectProductos op = new ObjectProductos();
    ObjectCorridas oc = new ObjectCorridas();
    ObjectPrecios pc = new ObjectPrecios();
    ObjectPedidos pedido = new ObjectPedidos();
    ObjectDetalle detalle = new ObjectDetalle();
    ObjectParametros Par = new ObjectParametros();
    Pedido ped = new Pedido();
    Color cl = new Color();
    Corrida cr = new Corrida();
    Precio ps = new Precio();
    Principal main = new Principal();
    SimpleDateFormat fecha = new SimpleDateFormat();
    String Est = "10";
    int cont = 1;
    int cc = 0;
    public int Id_Usuario;
    DefaultTableModel modelPedido = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Connection c = Server.getRpt();
    int Id_Producto;
    int cantidad, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    DecimalFormat precioA = new DecimalFormat("#.00");
    DecimalFormat precioB = new DecimalFormat("#.00");
    SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
    String codigo;

    public Pedidos() {
        initComponents();
        JbNuevo.setToolTipText("Realizar Pedido");
        JbEliminar.setToolTipText("Cancelar Pedido");
        JbBuscar.setToolTipText("Buscar Pedido");
        JbImprimir.setToolTipText("Imprimir");
        JbSalir.setToolTipText("Salir");
        JbActualizar.setToolTipText("Actualizar Pedido");
        Calendar fecha = new GregorianCalendar();
        JdCaptura.setCalendar(fecha);
        JdPedido.setCalendar(fecha);
        JdEntrega.setCalendar(fecha);
        JdRecibido.setCalendar(fecha);
        LoadColumns();
        LoadModelCliente();
        OcultarCampos();
        JbAlerta.setBackground(java.awt.Color.gray);
        JbAlerta.setToolTipText("REMICIÓN");
        cargarListenerPedido();
        CargarPedido();
        JtNpedido.setEditable(false);
        JtNpedido.setForeground(java.awt.Color.red);
        JtPedido.getTableHeader().setReorderingAllowed(false);
        JbActualizar.setEnabled(false);
        JbSerie.setText("A");
        JbSerie.setVisible(false);
        JtRenglon.setVisible(false);
        JdCaptura.setEnabled(false);
        JcCliente.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JtNpedido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JtNpc = new javax.swing.JTextField();
        JtOcompra = new javax.swing.JTextField();
        JbPlazo = new javax.swing.JLabel();
        JbAgente = new javax.swing.JLabel();
        JtabDatos = new javax.swing.JTabbedPane();
        JpDpedido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtPedido = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblPares = new javax.swing.JLabel();
        JpObservaciones = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JtCobranza = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        JtCancelar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JdCaptura = new com.toedter.calendar.JDateChooser();
        JdPedido = new com.toedter.calendar.JDateChooser();
        JdRecibido = new com.toedter.calendar.JDateChooser();
        JdEntrega = new com.toedter.calendar.JDateChooser();
        JpFacturas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtFacturas = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JbCliente = new javax.swing.JLabel();
        JbColonia = new javax.swing.JLabel();
        JbCD = new javax.swing.JLabel();
        JbCP = new javax.swing.JLabel();
        JbImprimir = new javax.swing.JButton();
        JbNuevo = new javax.swing.JButton();
        JbEliminar = new javax.swing.JButton();
        JbBuscar = new javax.swing.JButton();
        JbSalir = new javax.swing.JButton();
        JbEstado = new javax.swing.JLabel();
        JbPais = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JcCliente = new javax.swing.JComboBox<>();
        JcSuela = new javax.swing.JComboBox<>();
        JbAgregar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        JtCorrida = new javax.swing.JTextField();
        JtColor = new javax.swing.JTextField();
        JtprecioA = new javax.swing.JTextField();
        JbQuitar = new javax.swing.JButton();
        JbAlerta = new javax.swing.JButton();
        JbCalle = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();
        JbActualizar = new javax.swing.JButton();
        JtCliente = new javax.swing.JTextField();
        JtRenglon = new javax.swing.JTextField();
        JbSerie = new javax.swing.JLabel();
        JcColor = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        JtCant = new javax.swing.JTextField();
        L1 = new javax.swing.JLabel();
        JtC1 = new javax.swing.JTextField();
        L2 = new javax.swing.JLabel();
        JtC2 = new javax.swing.JTextField();
        L3 = new javax.swing.JLabel();
        JtC3 = new javax.swing.JTextField();
        L4 = new javax.swing.JLabel();
        JtC4 = new javax.swing.JTextField();
        L5 = new javax.swing.JLabel();
        JtC5 = new javax.swing.JTextField();
        L6 = new javax.swing.JLabel();
        JtC6 = new javax.swing.JTextField();
        JtC7 = new javax.swing.JTextField();
        L7 = new javax.swing.JLabel();
        JtC8 = new javax.swing.JTextField();
        L8 = new javax.swing.JLabel();
        JtC9 = new javax.swing.JTextField();
        L9 = new javax.swing.JLabel();
        L10 = new javax.swing.JLabel();
        JtC10 = new javax.swing.JTextField();
        L11 = new javax.swing.JLabel();
        JtC11 = new javax.swing.JTextField();
        L12 = new javax.swing.JLabel();
        JtC12 = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setTitle("PEDIDOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/3440908-ecommerce-label-price-shop-shopping-store-tag_107534.png"))); // NOI18N
        setName(""); // NOI18N
        setVisible(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("No. Pedido:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("No. Pedido cliente:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Orden de  Compra:");

        JbPlazo.setForeground(new java.awt.Color(0, 51, 102));

        JbAgente.setForeground(new java.awt.Color(0, 51, 102));

        JtabDatos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        JtPedido.setModel(modelPedido);
        JtPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtPedido);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setText("Costo:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(51, 153, 0));
        lblTotal.setText("0.00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 0));
        jLabel10.setText("Pares:");

        lblPares.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPares.setForeground(new java.awt.Color(51, 153, 0));
        lblPares.setText("0");

        javax.swing.GroupLayout JpDpedidoLayout = new javax.swing.GroupLayout(JpDpedido);
        JpDpedido.setLayout(JpDpedidoLayout);
        JpDpedidoLayout.setHorizontalGroup(
            JpDpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDpedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpDpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1305, Short.MAX_VALUE)
                    .addGroup(JpDpedidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPares)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        JpDpedidoLayout.setVerticalGroup(
            JpDpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDpedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JpDpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTotal)
                    .addComponent(jLabel10)
                    .addComponent(lblPares))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        JtabDatos.addTab("Detalle del Pedido", JpDpedido);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cobranza");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Cancelación");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Fecha Captura:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Fecha Pedido:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Fecha Recibido:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Fecha Entrega:");

        javax.swing.GroupLayout JpObservacionesLayout = new javax.swing.GroupLayout(JpObservaciones);
        JpObservaciones.setLayout(JpObservacionesLayout);
        JpObservacionesLayout.setHorizontalGroup(
            JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpObservacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(JtCobranza, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(JtCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JpObservacionesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(JdRecibido, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .addGroup(JpObservacionesLayout.createSequentialGroup()
                        .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpObservacionesLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel19))))
                        .addGap(18, 18, 18)
                        .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JdCaptura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JdPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JdEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        JpObservacionesLayout.setVerticalGroup(
            JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpObservacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpObservacionesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtCobranza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpObservacionesLayout.createSequentialGroup()
                        .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(JdCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(JdRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(JdEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        JtabDatos.addTab("Observaciones", JpObservaciones);

        JtFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "CODIGO", "ESTILO", "NO", "CORRIDA", "NO", "COMBINACION", "CANT", "PRECIO", "IMPORTE", "ST"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JtFacturas);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Detalle de Facturas Correspondientes al Pedido");

        javax.swing.GroupLayout JpFacturasLayout = new javax.swing.GroupLayout(JpFacturas);
        JpFacturas.setLayout(JpFacturasLayout);
        JpFacturasLayout.setHorizontalGroup(
            JpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFacturasLayout.createSequentialGroup()
                .addGroup(JpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpFacturasLayout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel24))
                    .addGroup(JpFacturasLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(397, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        JpFacturasLayout.setVerticalGroup(
            JpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpFacturasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JtabDatos.addTab("Facturas", JpFacturas);

        JbCliente.setForeground(new java.awt.Color(0, 51, 102));

        JbColonia.setForeground(new java.awt.Color(0, 51, 102));

        JbCD.setForeground(new java.awt.Color(0, 51, 102));

        JbCP.setForeground(new java.awt.Color(0, 51, 102));

        JbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Print_icon-icons.com_73705.png"))); // NOI18N
        JbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbImprimirActionPerformed(evt);
            }
        });

        JbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486485588-add-create-new-math-sign-cross-plus_81186.png"))); // NOI18N
        JbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbNuevoActionPerformed(evt);
            }
        });

        JbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/crossregular_106296.png"))); // NOI18N
        JbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEliminarActionPerformed(evt);
            }
        });

        JbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search_book_open_search_locate_6178.png"))); // NOI18N
        JbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbBuscarActionPerformed(evt);
            }
        });

        JbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit_icon-icons.com_70975.png"))); // NOI18N
        JbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbSalirActionPerformed(evt);
            }
        });

        JbEstado.setForeground(new java.awt.Color(0, 51, 102));

        JbPais.setForeground(new java.awt.Color(0, 51, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Suela:");

        JcCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcClienteItemStateChanged(evt);
            }
        });

        JcSuela.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcSuelaItemStateChanged(evt);
            }
        });

        JbAgregar.setText("Agregar >>>");
        JbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAgregarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Combinación");

        JtCorrida.setForeground(new java.awt.Color(0, 51, 255));
        JtCorrida.setEnabled(false);

        JtColor.setForeground(new java.awt.Color(0, 51, 255));
        JtColor.setEnabled(false);

        JbQuitar.setText("<<< Quitar");
        JbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbQuitarActionPerformed(evt);
            }
        });

        JbAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/iconfinder-bellnotificationsnoticenotifyalert-3993856_112639.png"))); // NOI18N
        JbAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbAlertaMouseClicked(evt);
            }
        });
        JbAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAlertaActionPerformed(evt);
            }
        });

        JbCalle.setForeground(new java.awt.Color(0, 51, 102));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Buscar:");

        JtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtBuscarKeyPressed(evt);
            }
        });

        JbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N
        JbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbActualizarActionPerformed(evt);
            }
        });

        JbSerie.setText("A");

        JcColor.setText("PREMIER");
        JcColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcColorItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cantidad:");

        JtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtCantKeyPressed(evt);
            }
        });

        L1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L1.setText("C1");

        JtC1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC1KeyPressed(evt);
            }
        });

        L2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L2.setText("C2");

        JtC2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC2KeyPressed(evt);
            }
        });

        L3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L3.setText("C3");

        JtC3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC3KeyPressed(evt);
            }
        });

        L4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L4.setText("C4");

        JtC4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC4KeyPressed(evt);
            }
        });

        L5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L5.setText("C5");

        JtC5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC5KeyPressed(evt);
            }
        });

        L6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L6.setText("C6");

        JtC6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC6KeyPressed(evt);
            }
        });

        JtC7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC7KeyPressed(evt);
            }
        });

        L7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L7.setText("C7");

        JtC8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC8KeyPressed(evt);
            }
        });

        L8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L8.setText("C8");

        JtC9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC9KeyPressed(evt);
            }
        });

        L9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L9.setText("C9");

        L10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L10.setText("C10");

        JtC10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC10KeyPressed(evt);
            }
        });

        L11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L11.setText("C11");

        JtC11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC11KeyPressed(evt);
            }
        });

        L12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L12.setText("C12");

        JtC12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtC12KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtC1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(L2)
                        .addGap(18, 18, 18)
                        .addComponent(JtC2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L3)
                        .addGap(18, 18, 18)
                        .addComponent(JtC3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L4)
                        .addGap(18, 18, 18)
                        .addComponent(JtC4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L5)
                        .addGap(18, 18, 18)
                        .addComponent(JtC5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L6)
                        .addGap(18, 18, 18)
                        .addComponent(JtC6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtC7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(L8)
                        .addGap(18, 18, 18)
                        .addComponent(JtC8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L9)
                        .addGap(18, 18, 18)
                        .addComponent(JtC9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L10)
                        .addGap(18, 18, 18)
                        .addComponent(JtC10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(L11)
                        .addGap(18, 18, 18)
                        .addComponent(JtC11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L12)
                        .addGap(18, 18, 18)
                        .addComponent(JtC12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L4)
                        .addComponent(JtC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(L1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L6)
                        .addComponent(JtC6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L5)
                        .addComponent(JtC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(L3)
                        .addComponent(JtC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(L2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L12)
                        .addComponent(JtC12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L11)
                        .addComponent(JtC11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L10)
                        .addComponent(JtC10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(L7)
                        .addComponent(JtC7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(L8)
                        .addComponent(JtC8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(L9)
                        .addComponent(JtC9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JtabDatos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JcColor)
                .addGap(65, 65, 65)
                .addComponent(JbAlerta)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(266, 266, 266)
                                        .addComponent(JbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(JbBuscar)
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JbNuevo)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(JbEliminar)))
                                        .addGap(106, 106, 106)))
                                .addComponent(JbImprimir)
                                .addGap(28, 28, 28)
                                .addComponent(JbSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JtNpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, 0)
                                        .addComponent(JtOcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(221, 221, 221)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JcSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JtCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JtprecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtRenglon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JbCD, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JbAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JbPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JbColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(JbCP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(104, 104, 104))
                                .addComponent(JbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JbQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JbNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtNpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JtNpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(JtOcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtprecioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtRenglon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbSerie))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JcSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(JbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JbCP, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(JbCD, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(JbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbAgregar)
                            .addComponent(JbQuitar)
                            .addComponent(jLabel8)
                            .addComponent(JtCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbAlerta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JcColor)
                                .addGap(14, 14, 14)))
                        .addGap(31, 31, 31)))
                .addComponent(JtabDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        if (JtBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No has seleccionado un pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String Np = JtNpedido.getText();
            Parametro pam = new Parametro();
            pam.setNpedido(Np);

            int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres cancelar este pedido?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                if (JbSerie.getText().equals("A")) {
                    if (pedido.cancelarPedido(Np, pam) && pedido.cancelarPedidoA(Np, pam)) {
                        JOptionPane.showMessageDialog(this, "Se ha cancelado el pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        LimpiarPedido();
                        LimpiarCliente();
                        CleanTable();
                        JtBuscar.setText("");
                        JtBuscar.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede cancelar este pedido", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        LimpiarPedido();
                        LimpiarCliente();
                        CleanTable();
                        JtBuscar.setText("");
                        JtBuscar.requestFocus();
                    }
                } else {
                    if (pedido.cancelarPedidoA(Np, pam)) {
                        JOptionPane.showMessageDialog(this, "Se ha cancelado el pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        LimpiarPedido();
                        LimpiarCliente();
                        CleanTable();
                        JtBuscar.setText("");
                        JtBuscar.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede cancelar este pedido", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        LimpiarPedido();
                        LimpiarCliente();
                        CleanTable();
                        JtBuscar.setText("");
                        JtBuscar.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_JbEliminarActionPerformed
    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed
    private void CargarPedido() {
        int num = 1;
        ArrayList<Parametro> listP = pedido.getPedidoActual();
        if (listP.size() > 0) {
            for (Parametro par : listP) {
                int Np = Integer.parseInt(par.getNpedido());
                int var = num + Np;
                JtNpedido.setText(String.valueOf(var));
            }
        } else {
            JtNpedido.setText(String.valueOf(num));
        }
    }
    private void JcClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcClienteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            OcultarCampos();
            Cliente cl = (Cliente) JcCliente.getSelectedItem();
            Producto prod = new Producto();
            DefaultComboBoxModel modelProd = new DefaultComboBoxModel(prod.getProd(cl.getId_Cliente()));
            JcSuela.setModel(modelProd);
            if (JcCliente.getSelectedIndex() == 0) {
                LimpiarCliente();
                JcSuela.setModel(modelProd);
                JtColor.setText("");
                JtCorrida.setText("");
            } else {
                ArrayList<Cliente> lista = obj.clienteGetByID(cl.getId_Cliente());
                if (lista.size() > 0) {
                    for (Cliente cn : lista) {
                        JbCliente.setText(cn.getRazonSocial());
                        JbCalle.setText(cn.getCalle());
                        JbColonia.setText(cn.getColonia());
                        JbCD.setText(cn.getCiudad());
                        JbEstado.setText(cn.getEstado());
                        JbCP.setText(cn.getCP());
                        JbPais.setText(cn.getPais());
                        JbPlazo.setText("Plazo" + " " + String.valueOf(cn.getDiasCredito()) + " " + "Días");
                        JbAgente.setText("Agente" + " " + String.valueOf(cn.getId_Agente()));
                        JtCobranza.setText(cn.getObservaciones());
                    }
                }
            }
        }
    }//GEN-LAST:event_JcClienteItemStateChanged
    private void JcSuelaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcSuelaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Producto prod = (Producto) JcSuela.getSelectedItem();
            Cliente cli = (Cliente) JcCliente.getSelectedItem();
            JtCorrida.setText(String.valueOf(cr.getCorridas(prod.getId_Producto())));
            JtColor.setText(String.valueOf(cl.getColor(prod.getId_Producto())));
            if (JcSuela.getSelectedIndex() == 0) {
                OcultarCampos();
                limpiarCorrida();
                JtColor.setText("");
                JtCorrida.setText("");
            } else {
                ValidarCorridas();
                JtCant.requestFocus();
                cargarPrecio();
            }
        }
    }//GEN-LAST:event_JcSuelaItemStateChanged

    private void ValidarCorridas() {
        JtC1.setText("0");
        JtC2.setText("0");
        JtC3.setText("0");
        JtC4.setText("0");
        JtC5.setText("0");
        JtC6.setText("0");
        JtC7.setText("0");
        JtC8.setText("0");
        JtC9.setText("0");
        JtC10.setText("0");
        JtC11.setText("0");
        JtC12.setText("0");

        switch (JtCorrida.getText()) {
            case "[10-12]":
                L1.setText("10:");
                L2.setText("10.5:");
                L3.setText("11:");
                L4.setText("11.5:");
                L5.setText("12:");
                L6.setText("12.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                break;
            case "[13-16]":
                L1.setText("13:");
                L2.setText("13.5:");
                L3.setText("14:");
                L4.setText("14.5:");
                L5.setText("15:");
                L6.setText("15.5:");
                L7.setText("16:");
                L8.setText("16.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                break;
            case "[27-29]":
                L1.setText("27:");
                L2.setText("27.5:");
                L3.setText("28:");
                L4.setText("28.5:");
                L5.setText("29:");
                L6.setText("29.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L3.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                break;
            case "[11-14]":
                L1.setText("11:");
                L2.setText("11.5:");
                L3.setText("12:");
                L4.setText("12.5:");
                L4.setText("13:");
                L4.setText("13.5:");
                L4.setText("14:");
                L4.setText("14.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                break;
            case "[22-27]":
                L1.setText("22:");
                L2.setText("22.5:");
                L3.setText("23:");
                L4.setText("23.5:");
                L5.setText("24:");
                L6.setText("24.5:");
                L7.setText("25:");
                L8.setText("25.5:");
                L9.setText("26:");
                L10.setText("26.5:");
                L11.setText("27:");
                L12.setText("27.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                L11.setVisible(true);
                L12.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC11.setSelectionStart(0);
                JtC12.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                JtC11.setVisible(true);
                JtC12.setVisible(true);
                break;
            case "[12-14]":
                L1.setText("12:");
                L2.setText("12.5:");
                L3.setText("13:");
                L4.setText("13.5:");
                L5.setText("14:");
                L6.setText("14.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                break;
            case "[15-17]":
                L1.setText("15:");
                L2.setText("15.5:");
                L3.setText("16:");
                L4.setText("16.5:");
                L5.setText("17:");
                L6.setText("17.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                break;
            case "[18-21]":
                L1.setText("18:");
                L2.setText("18.5:");
                L3.setText("19:");
                L4.setText("19.5:");
                L5.setText("20:");
                L6.setText("20.5:");
                L7.setText("21:");
                L8.setText("21.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                break;
            case "[22-24]":
                L1.setText("22:");
                L2.setText("22.5:");
                L3.setText("23:");
                L4.setText("23.5:");
                L5.setText("24:");
                L6.setText("24.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                break;
            case "[22-26]":
                L1.setText("22:");
                L2.setText("22.5:");
                L3.setText("23:");
                L4.setText("23.5:");
                L5.setText("24:");
                L6.setText("24.5:");
                L7.setText("25:");
                L8.setText("25.5:");
                L9.setText("26:");
                L10.setText("26.5:");
                JtC1.requestFocus();
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                break;
            case "[23-26]":
                L1.setText("22:");
                L2.setText("22.5:");
                L3.setText("23:");
                L4.setText("23.5:");
                L5.setText("24:");
                L6.setText("24.5:");
                L7.setText("25:");
                L8.setText("25.5:");
                L9.setText("26:");
                L10.setText("26.5:");
                JtC1.requestFocus();
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                break;
             case "[23-29]":
                L1.setText("22:");
                L2.setText("22.5:");
                L3.setText("23:");
                L4.setText("23.5:");
                L5.setText("24:");
                L6.setText("24.5:");
                L7.setText("25:");
                L8.setText("25.5:");
                L9.setText("26:");
                L10.setText("26.5:");
                JtC1.requestFocus();
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                break;    
            case "[25-30]":
                L1.setText("25:");
                L2.setText("25.5:");
                L3.setText("26:");
                L4.setText("26.5:");
                L5.setText("27:");
                L6.setText("27.5:");
                L7.setText("28:");
                L8.setText("28.5:");
                L9.setText("29:");
                L10.setText("29.5:");
                L11.setText("30:");
                L12.setText("30.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                L11.setVisible(true);
                L12.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC11.setSelectionStart(0);
                JtC12.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                JtC11.setVisible(true);
                JtC12.setVisible(true);
                break;
             case "[25-29]":
                L1.setText("25:");
                L2.setText("25.5:");
                L3.setText("26:");
                L4.setText("26.5:");
                L5.setText("27:");
                L6.setText("27.5:");
                L7.setText("28:");
                L8.setText("28.5:");
                L9.setText("29:");
                L10.setText("29.5:");
                L11.setText("30:");
                L12.setText("30.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                L11.setVisible(true);
                L12.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC11.setSelectionStart(0);
                JtC12.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                JtC11.setVisible(true);
                JtC12.setVisible(true);
                break;    
            case "[21-25]":
                L1.setText("21:");
                L2.setText("21.5:");
                L3.setText("22:");
                L4.setText("22.5:");
                L5.setText("23:");
                L6.setText("23.5:");
                L7.setText("24:");
                L8.setText("24.5:");
                L9.setText("25:");
                L10.setText("25.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                break;
            case "[30-33]":
                L1.setText("30:");
                L2.setText("30.5:");
                L3.setText("31:");
                L4.setText("31.5:");
                L5.setText("32:");
                L6.setText("32.5:");
                L7.setText("33:");
                L8.setText("33.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                break;
            case "[17-21]":
                L1.setText("17:");
                L2.setText("17.5:");
                L3.setText("18:");
                L4.setText("18.5:");
                L5.setText("19:");
                L6.setText("19.5:");
                L7.setText("20:");
                L8.setText("20.5:");
                L9.setText("21:");
                L10.setText("21.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                break;
            case "[23-27]":
                L1.setText("23:");
                L2.setText("23.5:");
                L3.setText("24:");
                L4.setText("24.5:");
                L5.setText("25:");
                L6.setText("25.5:");
                L7.setText("26:");
                L8.setText("26.5:");
                L9.setText("27:");
                L10.setText("27.5:");
                L1.setVisible(true);
                L2.setVisible(true);
                L3.setVisible(true);
                L4.setVisible(true);
                L5.setVisible(true);
                L6.setVisible(true);
                L7.setVisible(true);
                L8.setVisible(true);
                L9.setVisible(true);
                L10.setVisible(true);
                JtC1.requestFocus();
                JtC1.setSelectionStart(0);
                JtC2.setSelectionStart(0);
                JtC3.setSelectionStart(0);
                JtC4.setSelectionStart(0);
                JtC5.setSelectionStart(0);
                JtC6.setSelectionStart(0);
                JtC7.setSelectionStart(0);
                JtC8.setSelectionStart(0);
                JtC9.setSelectionStart(0);
                JtC10.setSelectionStart(0);
                JtC1.setVisible(true);
                JtC2.setVisible(true);
                JtC3.setVisible(true);
                JtC4.setVisible(true);
                JtC5.setVisible(true);
                JtC6.setVisible(true);
                JtC7.setVisible(true);
                JtC8.setVisible(true);
                JtC9.setVisible(true);
                JtC10.setVisible(true);
                break;
            default:
                break;
        }
    }

    private void JbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAgregarActionPerformed
        AgregarDetalle();
    }//GEN-LAST:event_JbAgregarActionPerformed
    
    private void AgregarDetalle(){
        ArrayList<Dpedido> detalles = new ArrayList<Dpedido>();
        ArrayList<Pedido> list = pedido.pedidoGetByID(JtBuscar.getText());
        int index = modelPedido.getRowCount() - 1;
        if (JtCant.getText().isEmpty() || JcSuela.getSelectedIndex() == 0) {
            JtCant.requestFocus();
            JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
        } else if (list.size() > 0) {
            Producto prod = (Producto) JcSuela.getSelectedItem();
            double precioa = Double.parseDouble(JtprecioA.getText());
            Double importe = Double.parseDouble(JtCant.getText()) * precioa;
            DecimalFormat impt = new DecimalFormat("#.00");
            String Desc = prod.getDescripcion();
            String Color = JtColor.getText();
            String Corrida = JtCorrida.getText();
            this.Id_Producto = prod.getId_Producto();
            String Npedido = JtNpedido.getText();

            Cliente cli = (Cliente) JcCliente.getSelectedItem();
            Date Captura = JdCaptura.getDate();
            long c = Captura.getTime();
            java.sql.Date fechaCap = new java.sql.Date(c);
            Date Entrega = JdEntrega.getDate();
            long e = Entrega.getTime();
            java.sql.Date fechaEn = new java.sql.Date(e);
            Date Pedido = JdPedido.getDate();
            long p = Pedido.getTime();
            java.sql.Date fechaPed = new java.sql.Date(p);
            Date Recibido = JdRecibido.getDate();
            long r = Recibido.getTime();
            java.sql.Date fechaRec = new java.sql.Date(r);
            String Serie = JbSerie.getText();

            String Cantidad = JtCant.getText();
            int Pares = Integer.parseInt(Cantidad);
            String pre = JtprecioA.getText();
            Double precio = Double.parseDouble(pre);
            int cr1 = Integer.parseInt(JtC1.getText());
            int cr2 = Integer.parseInt(JtC2.getText());
            int cr3 = Integer.parseInt(JtC3.getText());
            int cr4 = Integer.parseInt(JtC4.getText());
            int cr5 = Integer.parseInt(JtC5.getText());
            int cr6 = Integer.parseInt(JtC6.getText());
            int cr7 = Integer.parseInt(JtC7.getText());
            int cr8 = Integer.parseInt(JtC8.getText());
            int cr9 = Integer.parseInt(JtC9.getText());
            int cr10 = Integer.parseInt(JtC10.getText());
            int cr11 = Integer.parseInt(JtC11.getText());
            int cr12 = Integer.parseInt(JtC12.getText());

            boolean aviso = false;
            String datos[] = new String[21];
            datos[0] = String.valueOf(Id_Producto);
            datos[1] = String.valueOf(cont);
            datos[2] = Desc;
            datos[3] = Color;
            datos[4] = Corrida;
            datos[5] = String.valueOf(cr1);
            datos[6] = String.valueOf(cr2);
            datos[7] = String.valueOf(cr3);
            datos[8] = String.valueOf(cr4);
            datos[9] = String.valueOf(cr5);
            datos[10] = String.valueOf(cr6);
            datos[11] = String.valueOf(cr7);
            datos[12] = String.valueOf(cr8);
            datos[13] = String.valueOf(cr9);
            datos[14] = String.valueOf(cr10);
            datos[15] = String.valueOf(cr11);
            datos[16] = String.valueOf(cr12);
            datos[17] = Cantidad;
            datos[18] = precioA.format(precioa);
            datos[19] = impt.format(importe);
            datos[20] = Est;
            for (int i = 0; i < JtPedido.getRowCount(); i++) {
                if (JtPedido.getValueAt(i, 0).equals(String.valueOf(Id_Producto))) {
                    aviso = true;
                    String cant = JtCant.getText();
                    String ct = JtPedido.getValueAt(i, 17).toString();
                    int canti = Integer.parseInt(cant) + Integer.parseInt(ct);
                    String cn1 = JtC1.getText();
                    String corrida = JtPedido.getValueAt(i, 5).toString();
                    int cor = Integer.parseInt(cn1) + Integer.parseInt(corrida);
                    String cn2 = JtC2.getText();
                    String corrida2 = JtPedido.getValueAt(i, 6).toString();
                    int cor2 = Integer.parseInt(cn2) + Integer.parseInt(corrida2);
                    String cn3 = JtC3.getText();
                    String corrida3 = JtPedido.getValueAt(i, 7).toString();
                    int cor3 = Integer.parseInt(cn3) + Integer.parseInt(corrida3);
                    String cn4 = JtC4.getText();
                    String corrida4 = JtPedido.getValueAt(i, 8).toString();
                    int cor4 = Integer.parseInt(cn4) + Integer.parseInt(corrida4);
                    String cn5 = JtC5.getText();
                    String corrida5 = JtPedido.getValueAt(i, 9).toString();
                    int cor5 = Integer.parseInt(cn5) + Integer.parseInt(corrida5);
                    String cn6 = JtC6.getText();
                    String corrida6 = JtPedido.getValueAt(i, 10).toString();
                    int cor6 = Integer.parseInt(cn6) + Integer.parseInt(corrida6);
                    String cn7 = JtC7.getText();
                    String corrida7 = JtPedido.getValueAt(i, 11).toString();
                    int cor7 = Integer.parseInt(cn7) + Integer.parseInt(corrida7);
                    String cn8 = JtC8.getText();
                    String corrida8 = JtPedido.getValueAt(i, 12).toString();
                    int cor8 = Integer.parseInt(cn8) + Integer.parseInt(corrida8);
                    String cn9 = JtC9.getText();
                    String corrida9 = JtPedido.getValueAt(i, 13).toString();
                    int cor9 = Integer.parseInt(cn9) + Integer.parseInt(corrida9);
                    String cn10 = JtC10.getText();
                    String corrida10 = JtPedido.getValueAt(i, 14).toString();
                    int cor10 = Integer.parseInt(cn10) + Integer.parseInt(corrida10);
                    String cn11 = JtC11.getText();
                    String corrida11 = JtPedido.getValueAt(i, 15).toString();
                    int cor11 = Integer.parseInt(cn11) + Integer.parseInt(corrida11);
                    String cn12 = JtC12.getText();
                    String corrida12 = JtPedido.getValueAt(i, 16).toString();
                    int cor12 = Integer.parseInt(cn12) + Integer.parseInt(corrida12);

                    Double precios = Double.parseDouble(JtprecioA.getText());
                    double impor = Integer.valueOf(canti) * precio;
                    modelPedido.setValueAt(String.valueOf(cor), i, 5);
                    modelPedido.setValueAt(String.valueOf(cor2), i, 6);
                    modelPedido.setValueAt(String.valueOf(cor3), i, 7);
                    modelPedido.setValueAt(String.valueOf(cor4), i, 8);
                    modelPedido.setValueAt(String.valueOf(cor5), i, 9);
                    modelPedido.setValueAt(String.valueOf(cor6), i, 10);
                    modelPedido.setValueAt(String.valueOf(cor7), i, 11);
                    modelPedido.setValueAt(String.valueOf(cor8), i, 12);
                    modelPedido.setValueAt(String.valueOf(cor9), i, 13);
                    modelPedido.setValueAt(String.valueOf(cor10), i, 14);
                    modelPedido.setValueAt(String.valueOf(cor11), i, 15);
                    modelPedido.setValueAt(String.valueOf(cor12), i, 16);
                    modelPedido.setValueAt(String.valueOf(canti), i, 17);
                    modelPedido.setValueAt(precioA.format(precios), i, 18);
                    modelPedido.setValueAt(impt.format(impor), i, 19);
                    Limpiar();
                    OcultarCampos();
                }
            }
            if (aviso == false) {
                modelPedido.addRow(datos);
                String var = JtPedido.getValueAt(index, 1).toString();
                cc = Integer.parseInt(var) + 1;
                String costo = lblTotal.getText();
                double costoPedido = Double.parseDouble(costo);
                String par = lblPares.getText();
                int TotalPares = Integer.parseInt(par);
                Pedido pd = new Pedido();
                pd.setNpedido(Npedido);
                pd.setTotalPares(TotalPares);
                pd.setCostoTotal(costoPedido);

                Dpedido Dt = new Dpedido();
                Dt.setRenglon(cc);
                Dt.setNpedido(Npedido);
                Dt.setId_Cliente(cli.getId_Cliente());
                Dt.setFecha_Pedido(fechaPed);
                Dt.setFecha_Entrega(fechaEn);
                Dt.setId_Producto(Id_Producto);
                Dt.setCorrida(Corrida);
                Dt.setC1(cr1);
                Dt.setC2(cr2);
                Dt.setC3(cr3);
                Dt.setC4(cr4);
                Dt.setC5(cr5);
                Dt.setC6(cr6);
                Dt.setC7(cr7);
                Dt.setC8(cr8);
                Dt.setC9(cr9);
                Dt.setC10(cr10);
                Dt.setC11(cr11);
                Dt.setC12(cr12);
                Dt.setPares(Pares);
                Dt.setImporte(importe);
                Dt.setSerie(Serie);
                Dt.setCSurt1(0);
                Dt.setCSurt2(0);
                Dt.setCSurt3(0);
                Dt.setCSurt4(0);
                Dt.setCSurt5(0);
                Dt.setCSurt6(0);
                Dt.setCSurt7(0);
                Dt.setCSurt8(0);
                Dt.setCSurt9(0);
                Dt.setCSurt10(0);
                Dt.setCSurt11(0);
                Dt.setCSurt12(0);
                Dt.setParesSurt(0);
                Dt.setStatus(Est);
                Dt.setPrecio(precio);
                detalles.add(Dt);
                if (JbSerie.getText().equals("A")) {
                    if (pedido.agregarPedido(pd, detalles, Npedido) && pedido.agregarPedidoA(pd, detalles, Npedido)) {
                        JOptionPane.showMessageDialog(this, "Se agrego la suela al pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        Limpiar();
                        OcultarCampos();

                    } else {
                        JOptionPane.showMessageDialog(this, "Este pedido no se puede actualizar!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        Limpiar();
                        OcultarCampos();
                        CleanTable();
                        CargarDetalle();
                    }
                } else {
                    if (pedido.agregarPedidoA(pd, detalles, Npedido)) {
                        JOptionPane.showMessageDialog(this, "Se agrego la suela al pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        Limpiar();
                        OcultarCampos();

                    } else {
                        JOptionPane.showMessageDialog(this, "Este pedido no se puede actualizar!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);

                        Limpiar();
                        OcultarCampos();
                        CleanTable();
                        CargarDetalle();
                    }
                }
            }
        } else {
            AddItem();
            JbAlerta.setEnabled(false);
            JcColor.setEnabled(false);
        }
    }
    
    private void AddItem() {
        switch (JtCorrida.getText()) {
            case "[10-12]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC1()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[11-14]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC2()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[12-14]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC1()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[13-16]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC2()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[15-17]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC1()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[17-21]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC3()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[18-21]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC2()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[21-25]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC3()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[22-24]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC1()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[22-26]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC3()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[22-27]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC4()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[23-26]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC3()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[23-27]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC3()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
            case "[23-29]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC3()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[25-30]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC4()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
             case "[25-29]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty() || JtC9.getText().isEmpty() || JtC10.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC4()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;    
            case "[27-29]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC1()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
                break;
            case "[30-33]":
                if (JtC1.getText().isEmpty() || JtC2.getText().isEmpty() || JtC3.getText().isEmpty()
                        || JtC4.getText().isEmpty() || JtC5.getText().isEmpty() || JtC6.getText().isEmpty()
                        || JtC7.getText().isEmpty() || JtC8.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (ValidarC2()) {
                    AddProducto();
                    Limpiar();
                    OcultarCampos();
                }
            default:
                break;
        }
    }
    private void JbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbQuitarActionPerformed
        ArrayList<Pedido> list = pedido.pedidoGetByID(JtBuscar.getText());
        int row = JtPedido.getSelectedRow();
        String Npedido = JtNpedido.getText();
        try {

            if (list.size() > 0) {
                if (row >= 0) {
                    int opcion = JOptionPane.showConfirmDialog(this, "¿Quitar registro del pedido?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opcion == JOptionPane.YES_OPTION) {
                        modelPedido.removeRow(row);
                        String par = lblPares.getText();
                        int TotalPares = Integer.parseInt(par);
                        String costo = lblTotal.getText();
                        double costoPedido = Double.parseDouble(costo);
                        Pedido pd = new Pedido();
                        pd.setNpedido(Npedido);
                        pd.setCostoTotal(costoPedido);
                        pd.setTotalPares(TotalPares);

                        String Num = JtRenglon.getText();
                        if (JbSerie.getText().equals("A")) {
                            if (pedido.eliminarPedido(pd, Integer.parseInt(Num)) && pedido.eliminarPedidoA(pd, Integer.parseInt(Num))) {
                                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                                OcultarCampos();
                                Limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Este pedido ya fue surtido", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);

                                OcultarCampos();
                                Limpiar();
                                CleanTable();
                                CargarDetalle();
                            }
                        } else {
                            if (pedido.eliminarPedidoA(pd, Integer.parseInt(Num))) {
                                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                                OcultarCampos();
                                Limpiar();
                            } else {
                                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                                OcultarCampos();
                                Limpiar();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
                }
            } else {
                if (row >= 0) {
                    int opcion = JOptionPane.showConfirmDialog(this, "¿Quitar registro del pedido?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opcion == JOptionPane.YES_OPTION) {
                        modelPedido.removeRow(row);
                        OcultarCampos();
                        Limpiar();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_JbQuitarActionPerformed

    private void JbAlertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbAlertaMouseClicked
        Producto prod = (Producto) JcSuela.getSelectedItem();
        Cliente cli = (Cliente) JcCliente.getSelectedItem();
        ArrayList<Precio> lista = pc.GetByID(prod.getId_Producto(), cli.getId_Cliente());

        if (evt.getClickCount() == 1) {
            JbAlerta.setBackground(java.awt.Color.gray);

            JbSerie.setText("A");

            if (JcColor.isSelected() == false) {
                for (Precio p : lista) {
                    double precio = p.getPrecioA();
                    JtprecioA.setText(precioA.format(precio));
                }
            } else {
                for (Precio p : lista) {
                    double precio = p.getPrecioAP();
                    JtprecioA.setText(precioA.format(precio));
                }
            }
        } else {
            JbAlerta.setBackground(java.awt.Color.yellow);
            JbSerie.setText("B");

            if (JcColor.isSelected() == false) {
                for (Precio p : lista) {
                    double precio = p.getPrecioB();
                    JtprecioA.setText(precioA.format(precio));
                }
            } else {
                for (Precio p : lista) {
                    double precio = p.getPrecioBP();
                    JtprecioA.setText(precioA.format(precio));
                }
            }
        }
    }//GEN-LAST:event_JbAlertaMouseClicked

    private void cargarPrecio() {
        Producto prod = (Producto) JcSuela.getSelectedItem();
        Cliente cli = (Cliente) JcCliente.getSelectedItem();

        ArrayList<Precio> lista = pc.GetByID(prod.getId_Producto(), cli.getId_Cliente());

        if (JbAlerta.getBackground().equals(java.awt.Color.gray) && JcColor.isSelected() == false) {
            for (Precio p : lista) {
                double precio = p.getPrecioA();
                JtprecioA.setText(precioA.format(precio));
            }
        } else if (JbAlerta.getBackground().equals(java.awt.Color.gray) && JcColor.isSelected() == true) {
            for (Precio p : lista) {
                double precio = p.getPrecioAP();
                JtprecioA.setText(precioA.format(precio));
            }
        } else if (JbAlerta.getBackground().equals(java.awt.Color.yellow) && JcColor.isSelected() == false) {
            for (Precio p : lista) {
                double precio = p.getPrecioB();
                JtprecioA.setText(precioA.format(precio));
            }
        } else if (JbAlerta.getBackground().equals(java.awt.Color.yellow) && JcColor.isSelected() == true) {
            for (Precio p : lista) {
                double precio = p.getPrecioBP();
                JtprecioA.setText(precioA.format(precio));
            }
        }

    }

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        ArrayList<Dpedido> detalles = new ArrayList<Dpedido>();
        String Condicion = "Nada";
        String Npedido = JtNpedido.getText();
        String Serie = JbSerie.getText();
        String Npc = JtNpc.getText();
        String Orden = JtOcompra.getText();
        String Obv = JtCobranza.getText();
        int TotalPares = Integer.parseInt(lblPares.getText());
        Cliente cli = (Cliente) JcCliente.getSelectedItem();
        Date Captura = JdCaptura.getDate();
        long c = Captura.getTime();
        java.sql.Date fechaCap = new java.sql.Date(c);
        Date Entrega = JdEntrega.getDate();
        long e = Entrega.getTime();
        java.sql.Date fechaEn = new java.sql.Date(e);
        Date Pedido = JdPedido.getDate();
        long p = Pedido.getTime();
        java.sql.Date fechaPed = new java.sql.Date(p);
        Date Recibido = JdRecibido.getDate();
        long r = Recibido.getTime();
        java.sql.Date fechaRec = new java.sql.Date(r);
        double costoPedido = Double.parseDouble(lblTotal.getText());

        if (ValidarDatos()) {
            int var = Integer.parseInt(JtNpedido.getText());
            if (pedido.validarPedido(var) == 0) {
                if (ValidarFecha()) {
                    if (JtNpc.getText().isEmpty()) {
                        int row = modelPedido.getRowCount();
                        Pedido pd = new Pedido();
                        pd.setNpedido(Npedido);
                        pd.setNpedidoCl(Npedido);
                        pd.setId_Cliente(cli.getId_Cliente());
                        pd.setFecha_Pedido(fechaPed);
                        pd.setFecha_Entrega(fechaEn);
                        pd.setCondiciones(Condicion);
                        pd.setObservaciones(Obv);
                        pd.setId_Usuario(Id_Usuario);
                        pd.setSerie(Serie);
                        pd.setTotalPares(TotalPares);
                        pd.setCostoTotal(costoPedido);
                        pd.setStatus(Est);
                        pd.setParesSurt(0);
                        pd.setOrdenCompra(Orden);
                        pd.setFecha_Recibido(fechaRec);
                        pd.setFecha_Captura(fechaCap);
                        Parametro pam = new Parametro();
                        pam.setNpedido(Npedido);
                        pam.setEntrada(0);
                        pam.setFcatura(0);
                        pam.setSalida(0);
                        for (int i = 0; i < row; i++) {
                            int idprod = Integer.parseInt((String) modelPedido.getValueAt(i, 0));
                            int rn = Integer.parseInt((String) modelPedido.getValueAt(i, 1));
                            String corrida = (String) modelPedido.getValueAt(i, 4);
                            double precio = Double.parseDouble((String) modelPedido.getValueAt(i, 18));
                            double importe = Double.parseDouble((String) modelPedido.getValueAt(i, 19));
                            String Status = (String) modelPedido.getValueAt(i, 20);
                            int Pares = Integer.parseInt((String) modelPedido.getValueAt(i, 17));
                            int cr1 = Integer.parseInt((String) modelPedido.getValueAt(i, 5));
                            int cr2 = Integer.parseInt((String) modelPedido.getValueAt(i, 6));
                            int cr3 = Integer.parseInt((String) modelPedido.getValueAt(i, 7));
                            int cr4 = Integer.parseInt((String) modelPedido.getValueAt(i, 8));
                            int cr5 = Integer.parseInt((String) modelPedido.getValueAt(i, 9));
                            int cr6 = Integer.parseInt((String) modelPedido.getValueAt(i, 10));
                            int cr7 = Integer.parseInt((String) modelPedido.getValueAt(i, 11));
                            int cr8 = Integer.parseInt((String) modelPedido.getValueAt(i, 12));
                            int cr9 = Integer.parseInt((String) modelPedido.getValueAt(i, 13));
                            int cr10 = Integer.parseInt((String) modelPedido.getValueAt(i, 14));
                            int cr11 = Integer.parseInt((String) modelPedido.getValueAt(i, 15));
                            int cr12 = Integer.parseInt((String) modelPedido.getValueAt(i, 16));
                            Dpedido Dt = new Dpedido();
                            Dt.setRenglon(rn);
                            Dt.setNpedido(Npedido);
                            Dt.setId_Cliente(cli.getId_Cliente());
                            Dt.setFecha_Pedido(fechaPed);
                            Dt.setFecha_Entrega(fechaEn);
                            Dt.setId_Producto(idprod);
                            Dt.setCorrida(corrida);
                            Dt.setC1(cr1);
                            Dt.setC2(cr2);
                            Dt.setC3(cr3);
                            Dt.setC4(cr4);
                            Dt.setC5(cr5);
                            Dt.setC6(cr6);
                            Dt.setC7(cr7);
                            Dt.setC8(cr8);
                            Dt.setC9(cr9);
                            Dt.setC10(cr10);
                            Dt.setC11(cr11);
                            Dt.setC12(cr12);
                            Dt.setPares(Pares);
                            Dt.setImporte(importe);
                            Dt.setSerie(Serie);
                            Dt.setCSurt1(0);
                            Dt.setCSurt2(0);
                            Dt.setCSurt3(0);
                            Dt.setCSurt4(0);
                            Dt.setCSurt5(0);
                            Dt.setCSurt7(0);
                            Dt.setCSurt8(0);
                            Dt.setCSurt9(0);
                            Dt.setCSurt10(0);
                            Dt.setCSurt11(0);
                            Dt.setCSurt12(0);
                            Dt.setParesSurt(0);
                            Dt.setStatus(Status);
                            Dt.setPrecio(precio);
                            detalles.add(Dt);
                        }
                        //SI ES PRECIO A
                        if (JbSerie.getText().equals("A")) {
                            if (pedido.insertarVenta(pd, detalles, pam) && pedido.insertarVentaA(pd, detalles, pam)) {
                                JOptionPane.showMessageDialog(this, "Pedido realizado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                            }
                            CleanTable();
                            LimpiarPedido();
                            CargarPedido();
                        }// SI ES PRECIO B
                        else {
                            if (pedido.insertarVentaA(pd, detalles, pam) && pedido.insertarParametro(pam)) {
                                JOptionPane.showMessageDialog(this, "Pedido realizado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                            }
                            CleanTable();
                            LimpiarPedido();
                            CargarPedido();
                        }
                    } else {
                        int row = modelPedido.getRowCount();
                        Pedido pd = new Pedido();
                        pd.setNpedido(Npedido);
                        pd.setNpedidoCl(Npedido);
                        pd.setId_Cliente(cli.getId_Cliente());
                        pd.setFecha_Pedido(fechaPed);
                        pd.setFecha_Entrega(fechaEn);
                        pd.setCondiciones(Condicion);
                        pd.setObservaciones(Obv);
                        pd.setId_Usuario(Id_Usuario);
                        pd.setSerie(Serie);
                        pd.setTotalPares(TotalPares);
                        pd.setCostoTotal(costoPedido);
                        pd.setStatus(Est);
                        pd.setParesSurt(0);
                        pd.setOrdenCompra(Orden);
                        pd.setFecha_Recibido(fechaRec);
                        pd.setFecha_Captura(fechaCap);
                        Parametro pam = new Parametro();
                        pam.setNpedido(Npedido);
                        pam.setEntrada(0);
                        pam.setFcatura(0);
                        pam.setSalida(0);
                        for (int i = 0; i < row; i++) {
                            int idprod = Integer.parseInt((String) modelPedido.getValueAt(i, 0));
                            int rn = Integer.parseInt((String) modelPedido.getValueAt(i, 1));
                            String corrida = (String) modelPedido.getValueAt(i, 4);
                            double precio = Double.parseDouble((String) modelPedido.getValueAt(i, 18));
                            double importe = Double.parseDouble((String) modelPedido.getValueAt(i, 19));
                            String Status = (String) modelPedido.getValueAt(i, 20);
                            int Pares = Integer.parseInt((String) modelPedido.getValueAt(i, 17));
                            int cr1 = Integer.parseInt((String) modelPedido.getValueAt(i, 5));
                            int cr2 = Integer.parseInt((String) modelPedido.getValueAt(i, 6));
                            int cr3 = Integer.parseInt((String) modelPedido.getValueAt(i, 7));
                            int cr4 = Integer.parseInt((String) modelPedido.getValueAt(i, 8));
                            int cr5 = Integer.parseInt((String) modelPedido.getValueAt(i, 9));
                            int cr6 = Integer.parseInt((String) modelPedido.getValueAt(i, 10));
                            int cr7 = Integer.parseInt((String) modelPedido.getValueAt(i, 11));
                            int cr8 = Integer.parseInt((String) modelPedido.getValueAt(i, 12));
                            int cr9 = Integer.parseInt((String) modelPedido.getValueAt(i, 13));
                            int cr10 = Integer.parseInt((String) modelPedido.getValueAt(i, 14));
                            int cr11 = Integer.parseInt((String) modelPedido.getValueAt(i, 15));
                            int cr12 = Integer.parseInt((String) modelPedido.getValueAt(i, 16));
                            Dpedido Dt = new Dpedido();
                            Dt.setRenglon(rn);
                            Dt.setNpedido(Npedido);
                            Dt.setId_Cliente(cli.getId_Cliente());
                            Dt.setFecha_Pedido(fechaPed);
                            Dt.setFecha_Entrega(fechaEn);
                            Dt.setId_Producto(idprod);
                            Dt.setCorrida(corrida);
                            Dt.setC1(cr1);
                            Dt.setC2(cr2);
                            Dt.setC3(cr3);
                            Dt.setC4(cr4);
                            Dt.setC5(cr5);
                            Dt.setC6(cr6);
                            Dt.setC7(cr7);
                            Dt.setC8(cr8);
                            Dt.setC9(cr9);
                            Dt.setC10(cr10);
                            Dt.setC11(cr11);
                            Dt.setC12(cr12);
                            Dt.setPares(Pares);
                            Dt.setImporte(importe);
                            Dt.setSerie(Serie);
                            Dt.setCSurt1(0);
                            Dt.setCSurt2(0);
                            Dt.setCSurt3(0);
                            Dt.setCSurt4(0);
                            Dt.setCSurt5(0);
                            Dt.setCSurt6(0);
                            Dt.setCSurt7(0);
                            Dt.setCSurt8(0);
                            Dt.setCSurt9(0);
                            Dt.setCSurt10(0);
                            Dt.setCSurt11(0);
                            Dt.setCSurt12(0);
                            Dt.setParesSurt(0);
                            Dt.setStatus(Status);
                            Dt.setPrecio(precio);
                            detalles.add(Dt);
                        }
                        if (JbSerie.getText().equals("A")) {
                            if (pedido.insertarVenta(pd, detalles, pam) && pedido.insertarVentaA(pd, detalles, pam)) {
                                JOptionPane.showMessageDialog(this, "Pedido realizado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                            }
                            CleanTable();
                            LimpiarPedido();
                            CargarPedido();
                        } else {
                            if (pedido.insertarVentaA(pd, detalles, pam) && pedido.insertarParametro(pam)) {
                                JOptionPane.showMessageDialog(this, "Pedido realizado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                            }
                            CleanTable();
                            LimpiarPedido();
                            CargarPedido();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Este pedido ya existe!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                CargarPedido();
                String Nped = JtNpedido.getText();
                int row = modelPedido.getRowCount();
                int opcion = JOptionPane.showConfirmDialog(this, "¿Este pedido ya esta registrado desea continuar con el siguiente?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    Pedido pd = new Pedido();
                    pd.setNpedido(Npedido);
                    pd.setNpedidoCl(Npedido);
                    pd.setId_Cliente(cli.getId_Cliente());
                    pd.setFecha_Pedido(fechaPed);
                    pd.setFecha_Entrega(fechaEn);
                    pd.setCondiciones(Condicion);
                    pd.setObservaciones(Obv);
                    pd.setId_Usuario(Id_Usuario);
                    pd.setSerie(Serie);
                    pd.setTotalPares(TotalPares);
                    pd.setCostoTotal(costoPedido);
                    pd.setStatus(Est);
                    pd.setParesSurt(0);
                    pd.setOrdenCompra(Orden);
                    pd.setFecha_Recibido(fechaRec);
                    pd.setFecha_Captura(fechaCap);
                    Parametro pam = new Parametro();
                    pam.setNpedido(Npedido);
                    pam.setEntrada(0);
                    pam.setFcatura(0);
                    pam.setSalida(0);
                    for (int i = 0; i < row; i++) {
                        int idprod = Integer.parseInt((String) modelPedido.getValueAt(i, 0));
                        int rn = Integer.parseInt((String) modelPedido.getValueAt(i, 1));
                        String corrida = (String) modelPedido.getValueAt(i, 4);
                        double precio = Double.parseDouble((String) modelPedido.getValueAt(i, 18));
                        double importe = Double.parseDouble((String) modelPedido.getValueAt(i, 19));
                        String Status = (String) modelPedido.getValueAt(i, 20);
                        int Pares = Integer.parseInt((String) modelPedido.getValueAt(i, 17));
                        int cr1 = Integer.parseInt((String) modelPedido.getValueAt(i, 5));
                        int cr2 = Integer.parseInt((String) modelPedido.getValueAt(i, 6));
                        int cr3 = Integer.parseInt((String) modelPedido.getValueAt(i, 7));
                        int cr4 = Integer.parseInt((String) modelPedido.getValueAt(i, 8));
                        int cr5 = Integer.parseInt((String) modelPedido.getValueAt(i, 9));
                        int cr6 = Integer.parseInt((String) modelPedido.getValueAt(i, 10));
                        int cr7 = Integer.parseInt((String) modelPedido.getValueAt(i, 11));
                        int cr8 = Integer.parseInt((String) modelPedido.getValueAt(i, 12));
                        int cr9 = Integer.parseInt((String) modelPedido.getValueAt(i, 13));
                        int cr10 = Integer.parseInt((String) modelPedido.getValueAt(i, 14));
                        int cr11 = Integer.parseInt((String) modelPedido.getValueAt(i, 15));
                        int cr12 = Integer.parseInt((String) modelPedido.getValueAt(i, 16));
                        Dpedido Dt = new Dpedido();
                        Dt.setRenglon(rn);
                        Dt.setNpedido(Npedido);
                        Dt.setId_Cliente(cli.getId_Cliente());
                        Dt.setFecha_Pedido(fechaPed);
                        Dt.setFecha_Entrega(fechaEn);
                        Dt.setId_Producto(idprod);
                        Dt.setCorrida(corrida);
                        Dt.setC1(cr1);
                        Dt.setC2(cr2);
                        Dt.setC3(cr3);
                        Dt.setC4(cr4);
                        Dt.setC5(cr5);
                        Dt.setC6(cr6);
                        Dt.setC7(cr7);
                        Dt.setC8(cr8);
                        Dt.setC9(cr9);
                        Dt.setC10(cr10);
                        Dt.setC11(cr11);
                        Dt.setC12(cr12);
                        Dt.setPares(Pares);
                        Dt.setImporte(importe);
                        Dt.setSerie(Serie);
                        Dt.setCSurt1(0);
                        Dt.setCSurt2(0);
                        Dt.setCSurt3(0);
                        Dt.setCSurt4(0);
                        Dt.setCSurt5(0);
                        Dt.setCSurt6(0);
                        Dt.setCSurt7(0);
                        Dt.setCSurt8(0);
                        Dt.setCSurt9(0);
                        Dt.setCSurt10(0);
                        Dt.setCSurt11(0);
                        Dt.setCSurt12(0);
                        Dt.setParesSurt(0);
                        Dt.setStatus(Status);
                        Dt.setPrecio(precio);
                        detalles.add(Dt);
                    }
                    if (JbSerie.getText().equals("A")) {
                        if (pedido.insertarVenta(pd, detalles, pam) && pedido.insertarVentaA(pd, detalles, pam)) {
                            JOptionPane.showMessageDialog(this, "Pedido realizado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        }
                        CleanTable();
                        LimpiarPedido();
                        CargarPedido();
                    } else {
                        if (pedido.insertarVentaA(pd, detalles, pam) && pedido.insertarParametro(pam)) {
                            JOptionPane.showMessageDialog(this, "Pedido realizado correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        }
                        CleanTable();
                        LimpiarPedido();
                        CargarPedido();
                    }
                }
            }
        }
    }//GEN-LAST:event_JbNuevoActionPerformed
    private boolean ValidarFecha() {
        if (JdEntrega.getDate().equals(JdCaptura.getDate())) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿La fecha de entrega es igual a la de captura deseas continuar?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        RPedido nuevo = new RPedido();
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
    }//GEN-LAST:event_JbImprimirActionPerformed
    private void CargarDetalle() {
        ArrayList<Pedido> list = pedido.pedidoGetByID(JtBuscar.getText());
        if (list.size() > 0) {
            for (Pedido ls : list) {
                DecimalFormat impo = new DecimalFormat("#.00");
                String arreglo[] = new String[21];
                arreglo[0] = String.valueOf(ls.getId_Producto());
                arreglo[1] = String.valueOf(ls.getRenglon());
                arreglo[2] = ls.getSuela();
                arreglo[3] = ls.getColor();
                arreglo[4] = ls.getCorrida();
                arreglo[5] = String.valueOf(ls.getC1());
                arreglo[6] = String.valueOf(ls.getC2());
                arreglo[7] = String.valueOf(ls.getC3());
                arreglo[8] = String.valueOf(ls.getC4());
                arreglo[9] = String.valueOf(ls.getC5());
                arreglo[10] = String.valueOf(ls.getC6());
                arreglo[11] = String.valueOf(ls.getC7());
                arreglo[12] = String.valueOf(ls.getC8());
                arreglo[13] = String.valueOf(ls.getC9());
                arreglo[14] = String.valueOf(ls.getC10());
                arreglo[15] = String.valueOf(ls.getC11());
                arreglo[16] = String.valueOf(ls.getC12());
                arreglo[17] = String.valueOf(ls.getPares());
                arreglo[18] = precioA.format(ls.getPrecio());
                arreglo[19] = impo.format(ls.getImporte());
                arreglo[20] = ls.getStatus();
                modelPedido.addRow(arreglo);
            }
        }
    }
    private void JbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbBuscarActionPerformed
        ArrayList<Pedido> lista = pedido.pedidoGetByID(JtBuscar.getText());
        if (JtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No introduciste un numero de pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JtBuscar.requestFocus();
        } else if (lista.size() > 0) {
            CleanTable();
            JcCliente.setEnabled(false);
            JbNuevo.setEnabled(false);
            JtNpc.setEditable(false);
            JtOcompra.setEditable(false);
            JdCaptura.setEnabled(false);
            JdEntrega.setEnabled(false);
            JdPedido.setEnabled(false);
            JdRecibido.setEnabled(false);

            JbActualizar.setEnabled(true);
            JbEliminar.setEnabled(true);
            String datos[] = new String[15];
            for (Pedido p : lista) {
                Cliente cli = new Cliente();
                JtCliente.setText(String.valueOf(p.getId_Cliente()));
                JbCliente.setText(p.getRsocial());
                cli.setId_Cliente(Integer.parseInt(JtCliente.getText()));
                cli.setRazonSocial(JbCliente.getText());
                JcCliente.getModel().setSelectedItem(cli);
                JbCalle.setText(p.getCalle());
                JbColonia.setText(p.getColonia());
                JbCD.setText(p.getCiudad());
                JbEstado.setText(p.getEstado());
                JbCP.setText(p.getCp());
                JbPais.setText(p.getPais());
                JtNpc.setText(p.getNpedidoCl());
                JtNpedido.setText(p.getNpedido());
                JbPlazo.setText("Plazo" + " " + String.valueOf(p.getCred()) + " " + "Días");
                JbAgente.setText("Agente" + " " + String.valueOf(p.getAgente()));
                JtCobranza.setText(p.getObservaciones());
                JdPedido.setDate(p.getFecha_Pedido());
                JdCaptura.setDate(p.getFecha_Captura());
                JdEntrega.setDate(p.getFecha_Entrega());
                JdRecibido.setDate(p.getFecha_Recibido());
                JtOcompra.setText(p.getOrdenCompra());
                JbSerie.setText(p.getSerie());
                JbAlerta.setEnabled(false);
                /*if(JbSerie.getText().equals("A")){
            JbAlerta.setBackground(java.awt.Color.gray);
    }else{
        JbAlerta.setBackground(java.awt.Color.yellow);
    }*/

                DecimalFormat impt = new DecimalFormat("#.00");
                datos[0] = String.valueOf(p.getId_Producto());
                datos[1] = String.valueOf(p.getRenglon());
                datos[2] = p.getSuela();
                datos[3] = p.getColor();
                datos[4] = p.getCorrida();
                datos[5] = String.valueOf(p.getC1());
                datos[6] = String.valueOf(p.getC2());
                datos[7] = String.valueOf(p.getC3());
                datos[8] = String.valueOf(p.getC4());
                datos[9] = String.valueOf(p.getC5());
                datos[10] = String.valueOf(p.getC6());
                datos[11] = String.valueOf(p.getC7());
                datos[12] = String.valueOf(p.getC8());
                datos[13] = String.valueOf(p.getC9());
                datos[14] = String.valueOf(p.getC10());
                datos[15] = String.valueOf(p.getC11());
                datos[16] = String.valueOf(p.getC12());
                datos[17] = String.valueOf(p.getPares());
                datos[18] = precioA.format(p.getPrecio());
                datos[19] = impt.format(p.getImporte());
                datos[20] = p.getStatus();
            }
            /*int index = modelPedido.getRowCount()-1;
            String var = modelPedido.getValueAt(index, 1).toString();
            cc = Integer.parseInt(var) + 1;*/
        } else {
            JOptionPane.showMessageDialog(this, "No existe este pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JtBuscar.setText("");
            JtBuscar.requestFocus();
        }
    }//GEN-LAST:event_JbBuscarActionPerformed

    private void JtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_BACKSPACE) {
            LimpiarPedido();
            CleanTable();
            CargarPedido();
            JcCliente.setEnabled(true);
            JbNuevo.setEnabled(true);
            JtNpc.setEditable(true);
            JtOcompra.setEditable(true);
            JdCaptura.setEnabled(true);
            JdEntrega.setEnabled(true);
            JdPedido.setEnabled(true);
            JdRecibido.setEnabled(true);
            JtCliente.setText("");
            JbAlerta.setEnabled(true);
            JbActualizar.setEnabled(false);
            JbEliminar.setEnabled(false);
            JtprecioA.setText("");
        } else if (codigo == KeyEvent.VK_ENTER) {
            ArrayList<Pedido> lista = pedido.pedidoGetByID(JtBuscar.getText());
            if (JtBuscar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No introduciste un numero de pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                JtBuscar.requestFocus();
            } else if (lista.size() > 0) {
                CleanTable();
                JcCliente.setEnabled(false);
                JbNuevo.setEnabled(false);
                JtNpc.setEditable(false);
                JtOcompra.setEditable(false);
                JdCaptura.setEnabled(false);
                JdEntrega.setEnabled(false);
                JdPedido.setEnabled(false);
                JdRecibido.setEnabled(false);

                JbActualizar.setEnabled(true);
                JbEliminar.setEnabled(true);
                String datos[] = new String[21];
                for (Pedido p : lista) {
                    Cliente cli = new Cliente();
                    JtCliente.setText(String.valueOf(p.getId_Cliente()));
                    JbCliente.setText(p.getRsocial());
                    cli.setId_Cliente(Integer.parseInt(JtCliente.getText()));
                    cli.setRazonSocial(JbCliente.getText());
                    JcCliente.getModel().setSelectedItem(cli);
                    JbCalle.setText(p.getCalle());
                    JbColonia.setText(p.getColonia());
                    JbCD.setText(p.getCiudad());
                    JbEstado.setText(p.getEstado());
                    JbCP.setText(p.getCp());
                    JbPais.setText(p.getPais());
                    JtNpc.setText(p.getNpedidoCl());
                    JtNpedido.setText(p.getNpedido());
                    JbPlazo.setText("Plazo" + " " + String.valueOf(p.getCred()) + " " + "Días");
                    JbAgente.setText("Agente" + " " + String.valueOf(p.getAgente()));
                    JtCobranza.setText(p.getObservaciones());
                    JdPedido.setDate(p.getFecha_Pedido());
                    JdCaptura.setDate(p.getFecha_Captura());
                    JdEntrega.setDate(p.getFecha_Entrega());
                    JdRecibido.setDate(p.getFecha_Recibido());
                    JtOcompra.setText(p.getOrdenCompra());
                    JbSerie.setText(p.getSerie());
                    JbAlerta.setEnabled(false);
                    /*if(JbSerie.getText().equals("A")){
            JbAlerta.setBackground(java.awt.Color.gray);
    }else{
        JbAlerta.setBackground(java.awt.Color.yellow);
    }*/

                    DecimalFormat impt = new DecimalFormat("#.00");
                    datos[0] = String.valueOf(p.getId_Producto());
                    datos[1] = String.valueOf(p.getRenglon());
                    datos[2] = p.getSuela();
                    datos[3] = p.getColor();
                    datos[4] = p.getCorrida();
                    datos[5] = String.valueOf(p.getC1());
                    datos[6] = String.valueOf(p.getC2());
                    datos[7] = String.valueOf(p.getC3());
                    datos[8] = String.valueOf(p.getC4());
                    datos[9] = String.valueOf(p.getC5());
                    datos[10] = String.valueOf(p.getC6());
                    datos[11] = String.valueOf(p.getC7());
                    datos[12] = String.valueOf(p.getC8());
                    datos[13] = String.valueOf(p.getC9());
                    datos[14] = String.valueOf(p.getC10());
                    datos[15] = String.valueOf(p.getC11());
                    datos[16] = String.valueOf(p.getC12());
                    datos[17] = String.valueOf(p.getPares());
                    datos[18] = precioA.format(p.getPrecio());
                    datos[19] = impt.format(p.getImporte());
                    datos[20] = p.getStatus();
                    modelPedido.addRow(datos);
                }
                /*int index = modelPedido.getRowCount()-1;
            String var = modelPedido.getValueAt(index, 1).toString();
            cc = Integer.parseInt(var) + 1;*/
            } else {
                JOptionPane.showMessageDialog(this, "No existe este pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                JtBuscar.setText("");
                JtBuscar.requestFocus();
            }
        }
    }//GEN-LAST:event_JtBuscarKeyPressed
    private void CleanTable() {
        int row = modelPedido.getRowCount();
        if (row > 0) {
            for (int i = row - 1; i >= 0; i--) {
                modelPedido.removeRow(i);
            }
        }
    }
    private void JbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbActualizarActionPerformed
        int row = JtPedido.getSelectedRow();

        if (row >= 0) {
            String Npedido = JtNpedido.getText();
            String par = lblPares.getText();
            int TotalPares = Integer.parseInt(par);
            String costo = lblTotal.getText();
            double costoPedido = Double.parseDouble(costo);
            int id_dt = Integer.parseInt((String) JtPedido.getValueAt(row, 1));
            int cs1 = Integer.parseInt((String) JtPedido.getValueAt(row, 5));
            int cs2 = Integer.parseInt((String) JtPedido.getValueAt(row, 6));
            int cs3 = Integer.parseInt((String) JtPedido.getValueAt(row, 7));
            int cs4 = Integer.parseInt((String) JtPedido.getValueAt(row, 8));
            int cs5 = Integer.parseInt((String) JtPedido.getValueAt(row, 9));
            int cs6 = Integer.parseInt((String) JtPedido.getValueAt(row, 10));
            int cs7 = Integer.parseInt((String) JtPedido.getValueAt(row, 11));
            int cs8 = Integer.parseInt((String) JtPedido.getValueAt(row, 12));
            int cs9 = Integer.parseInt((String) JtPedido.getValueAt(row, 13));
            int cs10 = Integer.parseInt((String) JtPedido.getValueAt(row, 14));
            int cs11 = Integer.parseInt((String) JtPedido.getValueAt(row, 15));
            int cs12 = Integer.parseInt((String) JtPedido.getValueAt(row, 16));
            int cant = Integer.parseInt((String) JtPedido.getValueAt(row, 17));
            Double imp = Double.parseDouble((String) JtPedido.getValueAt(row, 19));

            Dpedido det = new Dpedido();
            det.setC1(cs1);
            det.setC2(cs2);
            det.setC3(cs3);
            det.setC4(cs4);
            det.setC5(cs5);
            det.setC6(cs6);
            det.setC7(cs7);
            det.setC8(cs8);
            det.setC9(cs9);
            det.setC10(cs10);
            det.setC11(cs11);
            det.setC12(cs12);
            det.setPares(cant);
            det.setImporte(imp);
            det.setRenglon(id_dt);
            det.setNpedido(Npedido);

            Pedido pd = new Pedido();
            pd.setNpedido(Npedido);
            pd.setCostoTotal(costoPedido);
            pd.setTotalPares(TotalPares);
            int opcion = JOptionPane.showConfirmDialog(this, "¿Modificar registro del pedido?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                if (JbSerie.getText().equals("A")) {
                    if (pedido.actualizarPedido(pd, det, id_dt) && pedido.actualizarPedidoA(pd, det, id_dt)) {
                        JOptionPane.showMessageDialog(this, "Se actualizo el pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        JbAlerta.setEnabled(true);
                        JcColor.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Este pedido no se puede modificar!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        JbAlerta.setEnabled(true);
                        OcultarCampos();
                        Limpiar();
                        CleanTable();
                        CargarDetalle();
                    }
                } else {
                    if (pedido.actualizarPedidoA(pd, det, id_dt)) {
                        JOptionPane.showMessageDialog(this, "Se actualizo el pedido!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        JbAlerta.setEnabled(true);
                        JcColor.setEnabled(true);
                        OcultarCampos();
                        Limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Este pedido no se puede modificar!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        JbAlerta.setEnabled(true);
                        OcultarCampos();
                        Limpiar();
                        CleanTable();
                        CargarDetalle();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar un registro para poder actualizarlo");
        }
    }//GEN-LAST:event_JbActualizarActionPerformed

    private void JtPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtPedidoMouseClicked
        int row = JtPedido.rowAtPoint(evt.getPoint());
        Producto Pro = new Producto();
        JtRenglon.setText(String.valueOf(JtPedido.getValueAt(row, 1)));
        Pro.setId_Producto(Integer.parseInt(JtPedido.getValueAt(row, 0).toString()));
        Pro.setDescripcion(JtPedido.getValueAt(row, 2).toString());
        JcSuela.getModel().setSelectedItem(Pro);
        JtprecioA.setText(JtPedido.getValueAt(row, 18).toString());
        JcColor.setEnabled(false);
    }//GEN-LAST:event_JtPedidoMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_F12) {
            JOptionPane.showMessageDialog(null, "Presionaste F12");
        }
    }//GEN-LAST:event_formKeyPressed

    private void JbAlertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAlertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JbAlertaActionPerformed

    private void JcColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcColorItemStateChanged
        Producto prod = (Producto) JcSuela.getSelectedItem();
        Cliente cli = (Cliente) JcCliente.getSelectedItem();
        ArrayList<Precio> lista = pc.GetByID(prod.getId_Producto(), cli.getId_Cliente());

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            if (JbAlerta.getBackground().equals(java.awt.Color.gray)) {
                for (Precio p : lista) {
                    double precio = p.getPrecioAP();
                    JtprecioA.setText(precioA.format(precio));
                }
            } else if (JbAlerta.getBackground().equals(java.awt.Color.yellow)) {
                for (Precio p : lista) {
                    double precio = p.getPrecioBP();
                    JtprecioA.setText(precioA.format(precio));
                }
            }
        } else {
            if (JbAlerta.getBackground().equals(java.awt.Color.gray)) {
                for (Precio p : lista) {
                    double precio = p.getPrecioA();
                    JtprecioA.setText(precioA.format(precio));
                }
            } else if (JbAlerta.getBackground().equals(java.awt.Color.yellow)) {
                for (Precio p : lista) {
                    double precio = p.getPrecioB();
                    JtprecioA.setText(precioA.format(precio));
                }
            }
        }
    }//GEN-LAST:event_JcColorItemStateChanged

    private void JtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCantKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            JtC1.requestFocus();
        }
    }//GEN-LAST:event_JtCantKeyPressed

    private void JtC1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC1KeyPressed

    private void JtC2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC2KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC2KeyPressed

    private void JtC3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC3KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC3KeyPressed

    private void JtC4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC4KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC4KeyPressed

    private void JtC5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC5KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC5KeyPressed

    private void JtC6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC6KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC6KeyPressed

    private void JtC7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC7KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC7KeyPressed

    private void JtC8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC8KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC8KeyPressed

    private void JtC9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC9KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC9KeyPressed

    private void JtC10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC10KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC10KeyPressed

    private void JtC11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC11KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC11KeyPressed

    private void JtC12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtC12KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            AgregarDetalle();
        }
    }//GEN-LAST:event_JtC12KeyPressed
    private boolean ValidarDatos() {
        if (this.JtPedido.getRowCount() == 0 && this.JtPedido.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No hay productos para el pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void LimpiarPedido() {
        lblTotal.setText("0.00");
        lblPares.setText("0");
        JtNpedido.setText("");
        JtNpc.setText("");
        JtOcompra.setText("");
        JcCliente.setSelectedIndex(0);
        JbCliente.setText("");
        JbCalle.setText("");
        JbColonia.setText("");
        JbCD.setText("");
        JbEstado.setText("");
        JbCP.setText("");
        JbPais.setText("");
        JbPlazo.setText("");
        JbAgente.setText("");
        JtCobranza.setText("");
        Calendar fechaActual = new GregorianCalendar();
        JdCaptura.setCalendar(fechaActual);
        JdPedido.setCalendar(fechaActual);
        JdEntrega.setCalendar(fechaActual);
        JdRecibido.setCalendar(fechaActual);
        JbAlerta.setEnabled(true);
        JcColor.setEnabled(true);
    }

    private void LimpiarCliente() {
        JbCliente.setText("");
        JbCalle.setText("");
        JbColonia.setText("");
        JbCD.setText("");
        JbEstado.setText("");
        JbCP.setText("");
        JbPais.setText("");
        JbPlazo.setText("");
        JbAgente.setText("");
        JtCobranza.setText("");
    }

    private boolean ValidarC1() {
        cantidad = Integer.parseInt(JtCant.getText());
        c1 = Integer.parseInt(JtC1.getText());
        c2 = Integer.parseInt(JtC2.getText());
        c3 = Integer.parseInt(JtC3.getText());
        c4 = Integer.parseInt(JtC4.getText());
        c5 = Integer.parseInt(JtC5.getText());
        c6 = Integer.parseInt(JtC6.getText());
        if (cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Las cantidades no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    private boolean ValidarC2() {
        cantidad = Integer.parseInt(JtCant.getText());
        c1 = Integer.parseInt(JtC1.getText());
        c2 = Integer.parseInt(JtC2.getText());
        c3 = Integer.parseInt(JtC3.getText());
        c4 = Integer.parseInt(JtC4.getText());
        c5 = Integer.parseInt(JtC5.getText());
        c6 = Integer.parseInt(JtC6.getText());
        c7 = Integer.parseInt(JtC7.getText());
        c8 = Integer.parseInt(JtC8.getText());

        if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Las cantidades no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    private boolean ValidarC3() {
        cantidad = Integer.parseInt(JtCant.getText());
        c1 = Integer.parseInt(JtC1.getText());
        c2 = Integer.parseInt(JtC2.getText());
        c3 = Integer.parseInt(JtC3.getText());
        c4 = Integer.parseInt(JtC4.getText());
        c5 = Integer.parseInt(JtC5.getText());
        c6 = Integer.parseInt(JtC6.getText());
        c7 = Integer.parseInt(JtC7.getText());
        c8 = Integer.parseInt(JtC8.getText());
        c9 = Integer.parseInt(JtC9.getText());
        c10 = Integer.parseInt(JtC10.getText());
        if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Las cantidades no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    private boolean ValidarC4() {
        cantidad = Integer.parseInt(JtCant.getText());
        c1 = Integer.parseInt(JtC1.getText());
        c2 = Integer.parseInt(JtC2.getText());
        c3 = Integer.parseInt(JtC3.getText());
        c4 = Integer.parseInt(JtC4.getText());
        c5 = Integer.parseInt(JtC5.getText());
        c6 = Integer.parseInt(JtC6.getText());

        c7 = Integer.parseInt(JtC7.getText());
        c8 = Integer.parseInt(JtC8.getText());
        c9 = Integer.parseInt(JtC9.getText());
        c10 = Integer.parseInt(JtC10.getText());
        c11 = Integer.parseInt(JtC11.getText());
        c12 = Integer.parseInt(JtC12.getText());

        if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Las cantidades no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    private void OcultarCampos() {
        L1.setVisible(false);
        L2.setVisible(false);
        L3.setVisible(false);
        L4.setVisible(false);
        L5.setVisible(false);
        L6.setVisible(false);
        L7.setVisible(false);
        L8.setVisible(false);
        L9.setVisible(false);
        L10.setVisible(false);
        L11.setVisible(false);
        L12.setVisible(false);
        JtC1.setVisible(false);
        JtC2.setVisible(false);
        JtC3.setVisible(false);
        JtC4.setVisible(false);
        JtC5.setVisible(false);
        JtC6.setVisible(false);
        JtC7.setVisible(false);
        JtC8.setVisible(false);
        JtC9.setVisible(false);
        JtC10.setVisible(false);
        JtC11.setVisible(false);
        JtC12.setVisible(false);
        JtprecioA.setVisible(false);
        JtCliente.setVisible(false);
    }

    private void HideBack() {
        L4.setVisible(false);
        L5.setVisible(false);
        L6.setVisible(false);
        JtC4.setVisible(false);
        JtC5.setVisible(false);
        JtC6.setVisible(false);
    }

    private void HideBack2() {
        L5.setVisible(false);
        JtC5.setVisible(false);
        L6.setVisible(false);
        JtC6.setVisible(false);
    }

    private void HideBack3() {
        L6.setVisible(false);
        JtC6.setVisible(false);
    }

    private void HideBack4() {
        L5.setVisible(false);
        JtC5.setVisible(false);
        L6.setVisible(false);
        JtC6.setVisible(false);
    }

    private void AddProducto() {
        Producto prod = (Producto) JcSuela.getSelectedItem();
        double precioa = Double.parseDouble(JtprecioA.getText());
        double importe = Double.parseDouble(JtCant.getText()) * precioa;
        String Desc = prod.getDescripcion();
        String Color = JtColor.getText();
        String Corrida = JtCorrida.getText();
        this.Id_Producto = prod.getId_Producto();
        DecimalFormat impt = new DecimalFormat("#.00");
        boolean aviso = false;
        String datos[] = new String[21];

        datos[0] = String.valueOf(Id_Producto);
        datos[1] = String.valueOf(cont);
        datos[2] = Desc;
        datos[3] = Color;
        datos[4] = Corrida;
        datos[5] = JtC1.getText();
        datos[6] = JtC2.getText();
        datos[7] = JtC3.getText();
        datos[8] = JtC4.getText();
        datos[9] = JtC5.getText();
        datos[10] = JtC6.getText();
        datos[11] = JtC7.getText();
        datos[12] = JtC8.getText();
        datos[13] = JtC9.getText();
        datos[14] = JtC10.getText();
        datos[15] = JtC11.getText();
        datos[16] = JtC12.getText();
        datos[17] = JtCant.getText();
        datos[18] = precioA.format(precioa);
        datos[19] = impt.format(importe);
        datos[20] = Est;

        for (int i = 0; i < JtPedido.getRowCount(); i++) {
            if (JtPedido.getValueAt(i, 0).equals(String.valueOf(Id_Producto))) {
                aviso = true;
                String cant = JtCant.getText();
                String ct = JtPedido.getValueAt(i, 17).toString();
                int canti = Integer.parseInt(cant) + Integer.parseInt(ct);
                String cn1 = JtC1.getText();
                String corrida = JtPedido.getValueAt(i, 5).toString();
                int cor = Integer.parseInt(cn1) + Integer.parseInt(corrida);
                String cn2 = JtC2.getText();
                String corrida2 = JtPedido.getValueAt(i, 6).toString();
                int cor2 = Integer.parseInt(cn2) + Integer.parseInt(corrida2);
                String cn3 = JtC3.getText();
                String corrida3 = JtPedido.getValueAt(i, 7).toString();
                int cor3 = Integer.parseInt(cn3) + Integer.parseInt(corrida3);
                String cn4 = JtC4.getText();
                String corrida4 = JtPedido.getValueAt(i, 8).toString();
                int cor4 = Integer.parseInt(cn4) + Integer.parseInt(corrida4);
                String cn5 = JtC5.getText();
                String corrida5 = JtPedido.getValueAt(i, 9).toString();
                int cor5 = Integer.parseInt(cn5) + Integer.parseInt(corrida5);
                String cn6 = JtC6.getText();
                String corrida6 = JtPedido.getValueAt(i, 10).toString();
                int cor6 = Integer.parseInt(cn6) + Integer.parseInt(corrida6);
                String cn7 = JtC7.getText();
                String corrida7 = JtPedido.getValueAt(i, 11).toString();
                int cor7 = Integer.parseInt(cn7) + Integer.parseInt(corrida7);
                String cn8 = JtC8.getText();
                String corrida8 = JtPedido.getValueAt(i, 12).toString();
                int cor8 = Integer.parseInt(cn8) + Integer.parseInt(corrida8);
                String cn9 = JtC9.getText();
                String corrida9 = JtPedido.getValueAt(i, 13).toString();
                int cor9 = Integer.parseInt(cn9) + Integer.parseInt(corrida9);
                String cn10 = JtC10.getText();
                String corrida10 = JtPedido.getValueAt(i, 14).toString();
                int cor10 = Integer.parseInt(cn10) + Integer.parseInt(corrida10);
                String cn11 = JtC11.getText();
                String corrida11 = JtPedido.getValueAt(i, 15).toString();
                int cor11 = Integer.parseInt(cn11) + Integer.parseInt(corrida11);
                String cn12 = JtC12.getText();
                String corrida12 = JtPedido.getValueAt(i, 16).toString();
                int cor12 = Integer.parseInt(cn12) + Integer.parseInt(corrida12);

                Double precio = Double.parseDouble(JtprecioA.getText());
                double impor = Integer.valueOf(canti) * precio;
                modelPedido.setValueAt(String.valueOf(cor), i, 5);
                modelPedido.setValueAt(String.valueOf(cor2), i, 6);
                modelPedido.setValueAt(String.valueOf(cor3), i, 7);
                modelPedido.setValueAt(String.valueOf(cor4), i, 8);
                modelPedido.setValueAt(String.valueOf(cor5), i, 9);
                modelPedido.setValueAt(String.valueOf(cor6), i, 10);
                modelPedido.setValueAt(String.valueOf(cor7), i, 11);
                modelPedido.setValueAt(String.valueOf(cor8), i, 12);
                modelPedido.setValueAt(String.valueOf(cor9), i, 13);
                modelPedido.setValueAt(String.valueOf(cor10), i, 14);
                modelPedido.setValueAt(String.valueOf(cor11), i, 15);
                modelPedido.setValueAt(String.valueOf(cor12), i, 16);
                modelPedido.setValueAt(String.valueOf(canti), i, 17);
                modelPedido.setValueAt(precioA.format(precio), i, 18);
                modelPedido.setValueAt(impt.format(impor), i, 19);
            }
        }
        if (aviso == false) {
            modelPedido.addRow(datos);
            cont++;
        }
    }

    private void LoadModelCliente() {
        Cliente cl = new Cliente();
        DefaultComboBoxModel modelCliente = new DefaultComboBoxModel(cl.getClientes());
        JcCliente.setModel(modelCliente);
    }

    private void Limpiar() {
        JcSuela.setSelectedIndex(0);
        JtCant.setText("");
        JtC1.setText("");
        JtC2.setText("");
        JtC3.setText("");
        JtC4.setText("");
        JtC5.setText("");
        JtC6.setText("");
        JtC7.setText("");
        JtC8.setText("");
        JtC9.setText("");
        JtC10.setText("");
        JtC11.setText("");
        JtC12.setText("");
        JtCorrida.setText("");
        JtColor.setText("");
        JtprecioA.setText("");
        cont = 1;
        //JtRenglon.setText("");
    }

    private void LoadColumns() {
        modelPedido.addColumn("ID");
        modelPedido.addColumn("#");
        modelPedido.addColumn("SUELA");
        modelPedido.addColumn("COLOR");
        modelPedido.addColumn("CORRIDA");
        modelPedido.addColumn("C1");
        modelPedido.addColumn("C2");
        modelPedido.addColumn("C3");
        modelPedido.addColumn("C4");
        modelPedido.addColumn("C5");
        modelPedido.addColumn("C6");
        modelPedido.addColumn("C7");
        modelPedido.addColumn("C8");
        modelPedido.addColumn("C9");
        modelPedido.addColumn("C10");
        modelPedido.addColumn("C11");
        modelPedido.addColumn("C12");
        modelPedido.addColumn("CANTIDAD");
        modelPedido.addColumn("PRECIO");
        modelPedido.addColumn("IMPORTE");
        modelPedido.addColumn("ESTATUS");

        JtPedido.getColumnModel().getColumn(0).setMaxWidth(0);
        JtPedido.getColumnModel().getColumn(0).setMinWidth(0);
        JtPedido.getColumnModel().getColumn(0).setPreferredWidth(0);

        JtPedido.getColumnModel().getColumn(1).setMaxWidth(0);
        JtPedido.getColumnModel().getColumn(1).setMinWidth(0);
        JtPedido.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    private void LimpiarCambios() {
        LimpiarPedido();
        Calendar fecha = new GregorianCalendar();
        JdCaptura.setCalendar(fecha);
        JdPedido.setCalendar(fecha);
        JdEntrega.setCalendar(fecha);
        JdRecibido.setCalendar(fecha);
        CleanTable();
        CargarPedido();
        JcCliente.setEnabled(true);
        JbNuevo.setEnabled(true);
        JtNpc.setEditable(true);
        JtOcompra.setEditable(true);
        JdCaptura.setEnabled(true);
        JdEntrega.setEnabled(true);
        JdPedido.setEnabled(true);
        JdRecibido.setEnabled(true);
        JtCliente.setText("");
        JbAlerta.setEnabled(true);
        JtBuscar.setText("");
        JtprecioA.setText("");
    }

    private void limpiarCorrida() {
        JtC1.setText("");
        JtC2.setText("");
        JtC3.setText("");
        JtC4.setText("");
        JtC5.setText("");
        JtC6.setText("");
        JtC7.setText("");
        JtC8.setText("");
        JtC9.setText("");
        JtC10.setText("");
        JtC11.setText("");
        JtC12.setText("");
        JtCant.setText("");
    }

    private void cargarListenerPedido() {
        modelPedido.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = modelPedido.getRowCount();
                double sumatoria = 0;
                int pares = 0;
                DecimalFormat total = new DecimalFormat("#.00");
                for (int i = 0; i < row; i++) {
                    String importe = (String) modelPedido.getValueAt(i, 19);
                    String tpares = (String) modelPedido.getValueAt(i, 17);
                    sumatoria += Double.parseDouble(importe);
                    pares += Integer.parseInt(tpares);
                }
                lblTotal.setText(total.format(sumatoria));
                lblPares.setText(String.valueOf(pares));
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbActualizar;
    private javax.swing.JLabel JbAgente;
    private javax.swing.JButton JbAgregar;
    private javax.swing.JButton JbAlerta;
    private javax.swing.JButton JbBuscar;
    private javax.swing.JLabel JbCD;
    private javax.swing.JLabel JbCP;
    private javax.swing.JLabel JbCalle;
    private javax.swing.JLabel JbCliente;
    private javax.swing.JLabel JbColonia;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JLabel JbEstado;
    private javax.swing.JButton JbImprimir;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JLabel JbPais;
    private javax.swing.JLabel JbPlazo;
    private javax.swing.JButton JbQuitar;
    private javax.swing.JButton JbSalir;
    private javax.swing.JLabel JbSerie;
    private javax.swing.JComboBox<String> JcCliente;
    private javax.swing.JCheckBox JcColor;
    private javax.swing.JComboBox<String> JcSuela;
    private com.toedter.calendar.JDateChooser JdCaptura;
    private com.toedter.calendar.JDateChooser JdEntrega;
    private com.toedter.calendar.JDateChooser JdPedido;
    private com.toedter.calendar.JDateChooser JdRecibido;
    private javax.swing.JPanel JpDpedido;
    private javax.swing.JPanel JpFacturas;
    private javax.swing.JPanel JpObservaciones;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTextField JtC1;
    private javax.swing.JTextField JtC10;
    private javax.swing.JTextField JtC11;
    private javax.swing.JTextField JtC12;
    private javax.swing.JTextField JtC2;
    private javax.swing.JTextField JtC3;
    private javax.swing.JTextField JtC4;
    private javax.swing.JTextField JtC5;
    private javax.swing.JTextField JtC6;
    private javax.swing.JTextField JtC7;
    private javax.swing.JTextField JtC8;
    private javax.swing.JTextField JtC9;
    private javax.swing.JTextField JtCancelar;
    private javax.swing.JTextField JtCant;
    private javax.swing.JTextField JtCliente;
    private javax.swing.JTextField JtCobranza;
    private javax.swing.JTextField JtColor;
    private javax.swing.JTextField JtCorrida;
    private javax.swing.JTable JtFacturas;
    private javax.swing.JTextField JtNpc;
    private javax.swing.JTextField JtNpedido;
    private javax.swing.JTextField JtOcompra;
    private javax.swing.JTable JtPedido;
    private javax.swing.JTextField JtRenglon;
    private javax.swing.JTabbedPane JtabDatos;
    private javax.swing.JTextField JtprecioA;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L10;
    private javax.swing.JLabel L11;
    private javax.swing.JLabel L12;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L7;
    private javax.swing.JLabel L8;
    private javax.swing.JLabel L9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPares;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables

}
