package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.KardexCmp;
import ObjectLayer.Material;
import ObjectLayer.Movs_materiales;
import ObjectLayer.ObjectKardexCmp;
import ObjectLayer.ObjectMateriales;
import ObjectLayer.ObjectOrdencompra;
import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.Ordencompra;
import ObjectLayer.ProveedorMPrima;
import ObjectLayer.Sesioninfo;
import ObjectLayer.Validacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
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

public class NOrdenCompra extends javax.swing.JDialog {

    String informacion = "";
    ObjectProveedoresMPrima pm = new ObjectProveedoresMPrima();
    ArrayList<ProveedorMPrima> listaproveedorm;
    ArrayList<Material> listaMaterial;
    ArrayList<Ordencompra> listaOrden;
    ArrayList<Ordencompra> listaOrdenB;
    ArrayList<Movs_materiales> listamovimiento_material = new ArrayList<>();
    ProveedorMPrima pmp = new ProveedorMPrima();
    Vector<Almacen> listaalmacen = new Vector<>();
    ObjectMateriales ObjM = new ObjectMateriales();
    ObjectKardexCmp Objcmp = new ObjectKardexCmp();
    ObjectOrdencompra ObjO = new ObjectOrdencompra();
    String columna = "";
    String columna2 = "";
    Sesioninfo s = new Sesioninfo();

    DefaultListModel<ProveedorMPrima> modeloListaProveedor = new DefaultListModel<>();
    DefaultListModel<Material> modeloListaMat = new DefaultListModel<>();
    DefaultListModel<Ordencompra> modeloListaOrden = new DefaultListModel<>();
    DefaultTableModel modelMaterials;

    public NOrdenCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelAlmacen();
        Calendar fecha = Calendar.getInstance();
        JeFecha.setCalendar(fecha);
        Jlserie.setText(s.getSerie());
        
        LoadModelmaterials();
        LoadOrden();
        JbIdProd.setVisible(false);
        JbCvet.setVisible(false);
        pmp.setProveedor(0);
        JpB.setVisible(false);
        JtFolio.setEditable(false);
        //JtCambio.setVisible(false);
        JtCambio.setText("0");
        JpAlmacen.setVisible(false);
        JtMat.requestFocus();
        JtSubtotal.setEditable(false);
        JtIva.setEditable(false);
        JtTotal.setEditable(false);
        JlIcono.setVisible(false);
        JlIcono.setToolTipText("Limpia los campos para iniciar una nueva Orden de Compra");
        JeFecha.setVisible(false);
        JlFecha.setText(fechaactual());
    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpMenu = new javax.swing.JPopupMenu();
        Jmi = new javax.swing.JMenuItem();
        Jmm = new javax.swing.JMenuItem();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        JttMaterial = new javax.swing.JTable();
        JbMov = new javax.swing.JButton();
        JpAlmacen = new javax.swing.JPanel();
        JcAlmacen = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JeFechadoc = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        JbBusca = new javax.swing.JButton();
        JbImpresion = new javax.swing.JButton();
        JpB = new javax.swing.JPanel();
        JtBusquedas = new javax.swing.JTextField();
        Jll = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JlBusquedas = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        JtaObservaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        JtCambio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JtRdoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JtSubtotal = new javax.swing.JTextField();
        JtIva = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JlIcono = new javax.swing.JLabel();
        JlFecha = new javax.swing.JLabel();

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

        Jmm.setText("Guardar cantidad");
        Jmm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmmMouseClicked(evt);
            }
        });
        Jmm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmmActionPerformed(evt);
            }
        });
        JpMenu.add(Jmm);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden de Compra");
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
        jLabel2.setText("FECHA: ");

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

        listaProveedor.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
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
        JtMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtMatActionPerformed(evt);
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

        listaMat.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
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
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        Jlserie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlserieMouseClicked(evt);
            }
        });

        JttMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JttMaterialMouseClicked(evt);
            }
        });
        JttMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JttMaterialKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(JttMaterial);

        JbMov.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMov.setText("Guardar");
        JbMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbMovActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout JpAlmacenLayout = new javax.swing.GroupLayout(JpAlmacen);
        JpAlmacen.setLayout(JpAlmacenLayout);
        JpAlmacenLayout.setHorizontalGroup(
            JpAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAlmacenLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcAlmacen, 0, 209, Short.MAX_VALUE)
                .addGap(162, 162, 162))
        );
        JpAlmacenLayout.setVerticalGroup(
            JpAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAlmacenLayout.createSequentialGroup()
                .addGroup(JpAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JcAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("FECHA DOC");

        JeFechadoc.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        JbBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Magnifier_29783.png"))); // NOI18N
        JbBusca.setText("BUSCAR");
        JbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbBuscaActionPerformed(evt);
            }
        });

        JbImpresion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbImpresion.setText("IMPRIMIR");
        JbImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbImpresionActionPerformed(evt);
            }
        });

        JtBusquedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtBusquedasActionPerformed(evt);
            }
        });
        JtBusquedas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtBusquedasKeyReleased(evt);
            }
        });

        Jll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jll.setText("Busca:");

        JlBusquedas.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        JlBusquedas.setModel(modeloListaOrden);
        JlBusquedas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlBusquedasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JlBusquedas);

        javax.swing.GroupLayout JpBLayout = new javax.swing.GroupLayout(JpB);
        JpB.setLayout(JpBLayout);
        JpBLayout.setHorizontalGroup(
            JpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBLayout.createSequentialGroup()
                .addComponent(Jll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JtBusquedas))
        );
        JpBLayout.setVerticalGroup(
            JpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbBusca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbImpresion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JbBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JbImpresion)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        JtaObservaciones.setColumns(10);
        JtaObservaciones.setRows(5);
        JtaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtaObservacionesKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(JtaObservaciones);

        jLabel6.setText("OBSERVACIONES:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ref. Doc");

        JtRdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtRdocActionPerformed(evt);
            }
        });

        jLabel9.setText("SUBTOTAL:");

        JtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setText("IVA:");

        JtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("TOTAL:");

        JlIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/new.png"))); // NOI18N
        JlIcono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlIconoMouseClicked(evt);
            }
        });

        JlFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jlserie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(JlIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JpAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(320, 320, 320)
                                    .addComponent(JbMov))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(JbMat)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JtMat, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JbCvet)
                                                .addComponent(JbIdProd))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JtProveedor)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JeFechadoc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JtRdoc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(JtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jlserie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JeFechadoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(JtRdoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JlFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(JpAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbMat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(JbIdProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JbCvet))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(JtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(JtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(JtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbMov))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void LoadOrden() {
        JtFolio.setText(Objcmp.getByOrden() + "");
    }

    private void LoadModelmaterials() {
        modelMaterials = new DefaultTableModel();
        modelMaterials.addColumn("Material");
        modelMaterials.addColumn("Cantidad");
        modelMaterials.addColumn("Precio");
        modelMaterials.addColumn("Importe");
        JttMaterial.editCellAt(1, 1);
        JttMaterial.setModel(modelMaterials);
    }

    private void LoadModelsurtido() {
        modelMaterials = new DefaultTableModel();
        modelMaterials.addColumn("Material");
        modelMaterials.addColumn("Cantidad");
        modelMaterials.addColumn("Surtido");
        modelMaterials.addColumn("Precio");
        modelMaterials.addColumn("Importe");
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
            limpiarListaProveedor();
        } else {
            limpiarListaProveedor();
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
    private void limpiarListaProveedor() {
        modeloListaProveedor.clear();
    }

    private void listaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProveedorMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            if (pmp.getNombre() == null || pmp.getNombre().equals("")) {
                pmp.setNombre(listaproveedorm.get(lis.getSelectedIndex()).getNombre());
                pmp.setProveedor(listaproveedorm.get(lis.getSelectedIndex()).getProveedor());
                ProveedorMPrima p = (ProveedorMPrima) lis.getSelectedValue();
                JtProveedor.setText(listaproveedorm.get(lis.getSelectedIndex()).getNombre());
                JbIdProd.setText(String.valueOf(p.getProveedor()) + " " + listaproveedorm.get(lis.getSelectedIndex()).getProveedor());
                JbMov.requestFocus();
            } else {
                pmp.setNombre(listaproveedorm.get(lis.getSelectedIndex()).getNombre());
                pmp.setProveedor(listaproveedorm.get(lis.getSelectedIndex()).getProveedor());
                JtProveedor.setText(listaproveedorm.get(lis.getSelectedIndex()).getNombre());
                JbMov.requestFocus();
            }

        }
    }//GEN-LAST:event_listaProveedorMouseClicked

    private void JtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtProveedorActionPerformed

    }//GEN-LAST:event_JtProveedorActionPerformed

    private void JtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtProveedorMouseClicked

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
            DecimalFormat df = new DecimalFormat("#.00");
            Material mat = (Material) lis.getSelectedValue();
            JbCvet.setText(listaMaterial.get(listaMat.getSelectedIndex()).getCveMat());
            JtMat.setText(mat.getDescripcion());
            Movs_materiales ma = new Movs_materiales();
            Validacion v = new Validacion();
            String resp = JOptionPane.showInputDialog("Escribe la cantidad: ");
            if (resp == null || resp.equals("") || resp.isEmpty()) {

            } else {
                while (!v.verificanumeros(resp) || Integer.parseInt(resp) <= 0) {
                    resp = JOptionPane.showInputDialog("Escribe la cantidad: ");
                }
                double importe = Integer.parseInt(resp) * mat.getCostoCosteo();
                ma.setCantidad(Integer.parseInt(resp));
                ma.setMaterial(mat.getCveMat());
                ma.setNombre_material(mat.getDescripcion());
                ma.setCosto((float) mat.getCostoCosteo());
                ma.setImporte(Float.parseFloat(df.format(importe)));
                listamovimiento_material.add(ma);
                setdata();
                Object arr[] = {mat.getDescripcion(), resp, mat.getCostoCosteo(), df.format(importe)};
                modelMaterials.addRow(arr);
            }

            JtMat.setText("");
            JtMat.requestFocus();
            limpiarMaterial();
        }
    }//GEN-LAST:event_listaMatMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void JttMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JttMaterialMouseClicked
        if (JtCambio.getText().equals("0")) {
            if (evt.getButton() == 3) {
                JpMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }

    }//GEN-LAST:event_JttMaterialMouseClicked

    private void JmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmiMouseClicked

    }//GEN-LAST:event_JmiMouseClicked

    private void JmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiActionPerformed
        int aux = JttMaterial.getSelectedRow();
        modelMaterials.removeRow(aux);
        listamovimiento_material.remove(aux);
        setdata();
    }//GEN-LAST:event_JmiActionPerformed

    private void JtMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtMatMouseClicked

    }//GEN-LAST:event_JtMatMouseClicked

    private void JcAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JcAlmacenMouseClicked

    }//GEN-LAST:event_JcAlmacenMouseClicked

    private void JbMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbMovActionPerformed
        generarmovimiento();
    }//GEN-LAST:event_JbMovActionPerformed

    private void JcAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAlmacenItemStateChanged
        JbMov.requestFocus();
    }//GEN-LAST:event_JcAlmacenItemStateChanged

    private void JlserieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlserieMouseClicked
        String serie = (s.getSerie().equals("A")) ? "B" : "A";
        s.setSerie(serie);
        Jlserie.setText(serie);
    }//GEN-LAST:event_JlserieMouseClicked

    private void JtMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtMatActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String serie = (s.getSerie().equals("A")) ? "B" : "A";
        s.setSerie(serie);
        Jlserie.setText(serie);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void JbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbBuscaActionPerformed
        JpB.setVisible(true);
        JtBusquedas.requestFocus();
    }//GEN-LAST:event_JbBuscaActionPerformed

    private void JlBusquedasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlBusquedasMouseClicked
        JList lis = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            Calendar fecha = Calendar.getInstance();
            JeFechadoc.setCalendar(fecha);
            DecimalFormat df = new DecimalFormat("#.00");
            Ordencompra o = (Ordencompra) lis.getSelectedValue();
            listaOrdenB = ObjO.ordenSearchxfolio(o.getFolio() + "");
            Movs_materiales ma = new Movs_materiales();
            String material = "";
            int cantidad;
            int surtido;
            float precio;
            float importe;
            float subtotal = 0;
            LoadModelsurtido();
            for (int i = 0; i < listaOrdenB.get(0).getMat().size(); i++) {// puede y de error
                material = listaOrdenB.get(0).getMat().get(i).getNombre_material();
                cantidad = listaOrdenB.get(0).getMat().get(i).getCantidad();
                surtido = listaOrdenB.get(0).getMat().get(i).getSurtido();
                precio = listaOrdenB.get(0).getMat().get(i).getCosto();
                importe = (float) listaOrdenB.get(0).getMat().get(i).getImporte();
                Object arr[] = {material, cantidad, surtido, precio, importe};
                subtotal += importe;
                modelMaterials.addRow(arr);
            }
            JtBusquedas.setText("");
            Jlserie.setText(listaOrdenB.get(0).getSerie());
            JtProveedor.setText(listaOrdenB.get(0).getNombreproveedor());
            JlFecha.setText(listaOrdenB.get(0).getFecha());
            JeFecha.setEnabled(false);
            JtFolio.setText(String.valueOf(listaOrdenB.get(0).getFolio()));
            JtSubtotal.setText(subtotal + "");
            JtaObservaciones.setText(listaOrdenB.get(0).getObservaciones());
            JtIva.setText(df.format(subtotal * 0.16));
            JtTotal.setText(df.format((subtotal * 0.16) + subtotal));
            JtBusquedas.requestFocus();
            JtProveedor.setEditable(false);
            JpAlmacen.setVisible(true);
            limpiarOrden();
            JtCambio.setText("1");
            JlIcono.setVisible(true);
            JtRdoc.requestFocus();

        }

    }//GEN-LAST:event_JlBusquedasMouseClicked

    private void JtBusquedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtBusquedasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtBusquedasActionPerformed

    private void JbImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImpresionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JbImpresionActionPerformed

    private void JtBusquedasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBusquedasKeyReleased
        if (JtBusquedas.getText().isEmpty()) {
            limpiarOrden();
        } else {
            limpiarOrden();
            listaOrden = ObjO.ordenSearch(JtBusquedas.getText());
            for (Ordencompra o : listaOrden) {
                modeloListaOrden.addElement(o);
            }
        }
    }//GEN-LAST:event_JtBusquedasKeyReleased

    private void JtaObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtaObservacionesKeyReleased

    }//GEN-LAST:event_JtaObservacionesKeyReleased

    private void JtRdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtRdocActionPerformed
        JcAlmacen.requestFocus();
    }//GEN-LAST:event_JtRdocActionPerformed

    private void JttMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JttMaterialKeyReleased

    }//GEN-LAST:event_JttMaterialKeyReleased

    private void JmmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JmmMouseClicked

    private void JmmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmmActionPerformed
        DecimalFormat df = new DecimalFormat("#.00");
        int row = JttMaterial.getSelectedRow();
        Movs_materiales mov = new Movs_materiales();
        int cantidad = Integer.parseInt(JttMaterial.getValueAt(row, 1).toString());
        float costo = listamovimiento_material.get(row).getCosto();
        float importe = cantidad * costo;
        mov.setCosto(costo);
        mov.setCantidad(cantidad);
        mov.setMaterial(listamovimiento_material.get(row).getMaterial());
        mov.setSurtido(listamovimiento_material.get(row).getSurtido());
        mov.setNombre_material(listamovimiento_material.get(row).getNombre_material());
        mov.setImporte(Float.parseFloat(df.format(importe)));
        listamovimiento_material.set(row, mov);
        modelMaterials.removeRow(row);
        Object arr[] = {mov.getNombre_material(), cantidad, costo, df.format(importe)};
        modelMaterials.addRow(arr);
        setdata();

//        listamovimiento_material.s
    }//GEN-LAST:event_JmmActionPerformed

    private void JlIconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlIconoMouseClicked
        finorden();
    }//GEN-LAST:event_JlIconoMouseClicked
    private void limpiarMaterial() {
        modeloListaMat.clear();
    }

    private void finorden() {
        Calendar fecha = Calendar.getInstance();
        JtMat.requestFocus();
        JtBusquedas.setText("");
        JtCambio.setText("0");
        JeFechadoc.setCalendar(fecha);
        JtRdoc.setText("");
        JtSubtotal.setText("");
        JtIva.setText("");
        JtTotal.setText("");
        JtaObservaciones.setText("");
        JpB.setVisible(false);
        JlIcono.setVisible(false);
        JtProveedor.setEditable(true);
        JpAlmacen.setVisible(false);
        Jlserie.setText(s.getSerie());
        JlFecha.setText(fechaactual());
        LoadModelmaterials();
        limpiarMaterial();
        limpiarOrden();
        LoadOrden();
    }

    private void limpiarOrden() {
        modeloListaOrden.clear();
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
    private String fechaactual(){
        Calendar fechas = Calendar.getInstance(); //intanciar informacion del calendiario respecto al sistema
        int año = fechas.get(Calendar.YEAR);
        int mes = fechas.get(Calendar.MONTH) + 1;
        int dia = fechas.get(Calendar.DAY_OF_MONTH);
        return dia+"/"+mes+"/"+año;
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
        String fechac = dia + "-" + mes + "-" + año + " " + horas + ":00.000";//fecha formada por Calendar.getInstance(); 
        return fechac;
    }

    private String getfechadoc(String fechas) {
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
        String fechac = fechas + " " + horas + ":00.000";//fecha formada por Calendar.getInstance(); 
        return fechac;
    }

    private void setdata() {
        double sumsub = 0;//
        for (int i = 0; i < listamovimiento_material.size(); i++) {
            sumsub += listamovimiento_material.get(i).getImporte();
        }
        //(double)Math.round(number * 100d) / 100d
        DecimalFormat df = new DecimalFormat("#.00");
        JtSubtotal.setText(df.format(sumsub) + "");
        JtIva.setText(df.format((sumsub * 0.16)) + "");
        JtTotal.setText(df.format((sumsub * 0.16) + sumsub) + "");
    }

    private void generarmovimiento() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Estas Seguro de realizar el movimiento?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            try {
                if (JcAlmacen.getSelectedIndex() == 0 && listamovimiento_material.isEmpty() || JtCambio.getText().equals("2")) {
                    JcAlmacen.requestFocus();
                    JOptionPane.showMessageDialog(null, "Elija un almacen o un material!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                } else if (JtCambio.getText().equals("2") || (pmp.getProveedor() == 0 && listaOrdenB.isEmpty())) {
                    JtProveedor.requestFocus();
                    JOptionPane.showMessageDialog(null, "Elija un proveedor!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JtCambio.getText().equals("0")) {// eleccion entre una nueva o surtir orden
                        ArrayList<Movs_materiales> arr = new ArrayList<>();
                        int rows = JttMaterial.getRowCount();
                        int cantidad = 0;
                        float costo = 0;
                        boolean flagnumber = true;
                        for (int i = 0; i < rows; i++) {
                            String numaux = JttMaterial.getValueAt(i, 1).toString();
                            Validacion v = new Validacion();
                            if (v.puntoflotante(numaux) || v.verificanumeros(numaux)) {//verifica numeros
                                Movs_materiales mo = new Movs_materiales();
                                mo.setMaterial(listamovimiento_material.get(i).getMaterial());
                                mo.setCosto(listamovimiento_material.get(i).getCosto());
                                mo.setCantidad(Integer.parseInt(numaux));
                                arr.add(mo);
                                cantidad += Integer.parseInt(numaux);
                                costo += listamovimiento_material.get(i).getCosto();
                            } else {// sino lo detiene y termina procesos
                                i = rows;
                                flagnumber = false;
                            }
                        }
                        if (flagnumber) {
                            DecimalFormat df = new DecimalFormat("#.00");
                            Ordencompra o = new Ordencompra();
                            String importe = df.format((costo * cantidad));
                            o.setFolio(Integer.parseInt(JtFolio.getText()));
                            o.setProveedor(pmp.getProveedor());
                            o.setRefdoc("");
                            o.setCantidad(cantidad);
                            o.setTotal(Float.parseFloat(importe));
                            o.setFecha(getfecha());
                            o.setFechadoc(getfecha());
                            o.setObservaciones(JtaObservaciones.getText());
                            o.setUsuario(s.getId_usuario());
                            o.setMat(arr);
                            o.setSerie("A");
                            ObjectOrdencompra orden = new ObjectOrdencompra();
                            if (orden.OrdenAdd(o)) {
                                JOptionPane.showMessageDialog(null, "Orden de compra Completo Exitosamente", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                                limpiamovimiento();
                                limpiaorden();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al completar Orden de compra, Intentelo de nuevo!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Solamente puedes introducir numeros en la cantidad", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        GoKardex();
                    }
                    //String operacion = (columna.equals("Entradas")) ? "+" : "-";
                    //k.setTipo(columna.charAt(0) + "");
                    //k.setOperacion(operacion);
//                    k.setFolio(Integer.parseInt(JtFolio.getText()) + 1);
//                    k.setCuenta(Integer.parseInt(JtCuenta.getText()));
//                    k.setSubcuenta(Integer.parseInt(JtSubcuenta.getText()));
                    //k.setAlmacen(listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen()); no cambia
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void GoKardex() throws Exception {
        int rows = JttMaterial.getRowCount();
        boolean flagnumber = true;
        ArrayList<Movs_materiales> arr = new ArrayList<>();
        for (int i = 0; i < rows; i++) { // productos de la orden de compra
            String numaux = JttMaterial.getValueAt(i, 2).toString();
            Validacion v = new Validacion();
            if (v.puntoflotante(numaux) || v.verificanumeros(numaux)) {//valida celdas de surtido
                Movs_materiales mo = new Movs_materiales();
                mo.setMaterial(listaOrdenB.get(0).getMat().get(i).getMaterial());
                mo.setCosto(listaOrdenB.get(0).getMat().get(i).getCosto());
                mo.setCantidad(listaOrdenB.get(0).getMat().get(i).getCantidad());
                mo.setSurtido(Integer.parseInt(numaux));
                mo.setRenglon(listaOrdenB.get(0).getMat().get(i).getRenglon());
                arr.add(mo);
            } else {
                i = rows;
                flagnumber = false;
            }
        }
        if (flagnumber) {//verificacion de numeros
            int y = 0;
            for (int i = 0; i < arr.size(); i++) {
                int surtido = listaOrdenB.get(0).getMat().get(y).getSurtido();
                int cantidad = listaOrdenB.get(0).getMat().get(y).getCantidad();
                int cantsurtido=surtido+arr.get(i).getSurtido();
//                if ((arr.get(i).getSurtido() <= surtido || (arr.get(i).getSurtido() > cantidad))
//                        || surtido == arr.get(i).getSurtido()) {
                    if(cantsurtido>cantidad && surtido!=0 ){
                    arr.remove(i);
                    i--;
                }
                y++;
            }
            if (arr.isEmpty()) {
                JtRdoc.requestFocus();
                JOptionPane.showMessageDialog(null, "No se realizo ningun cambio de acuerdo al surtido de productos o \n se excedio la cantidad total por el surtido", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (JtRdoc.getText().equals("") || JcAlmacen.getSelectedIndex() == 0) {
                }
                KardexCmp k = new KardexCmp();
                DateFormat df = DateFormat.getDateInstance();
                String a = df.format(JeFechadoc.getDate());
                k.setProveedor(listaOrdenB.get(0).getProveedor());// cambia
                k.setOrdenc(listaOrdenB.get(0).getFolio() + "");// cambia
                k.setFechamov(listaOrdenB.get(0).getFecha() + " " + listaOrdenB.get(0).getTiempo());
                k.setFechadoc(getfechadoc(a));//cambia
                k.setSerie(listaOrdenB.get(0).getSerie());
                k.setDocref(JtRdoc.getText());//cambia
                k.setUsuario(listaOrdenB.get(0).getUsuario());
                k.setOperacion("+");
                k.setFolio(Integer.parseInt(Objcmp.getparametro("Entradas")) + 1);
                k.setCuenta(01);
                k.setSubcuenta(01);
                k.setAlmacen(listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen());
                k.setTipo("E");
                k.setMat(arr);
                if (Objcmp.KardexCmpOrdenAdd(k)) {
                    finorden();
                    informacion = "1";
                    JOptionPane.showMessageDialog(null, "Surtido Completo!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Algo salio Mal, Contacta a Sistemas! ", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solamente puedes introducir numeros en la cantidad", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void limpiamovimiento() {
        JtFolio.setText("");
        JcAlmacen.setSelectedIndex(0);
        LoadModelmaterials();
    }

    private void limpiaorden() {
        LoadOrden();
        LoadModelmaterials();
        JtaObservaciones.setText("");
        JtMat.requestFocus();
        JtSubtotal.setText("");
        JtIva.setText("");
        JtTotal.setText("");
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
            java.util.logging.Logger.getLogger(NOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                NOrdenCompra dialog = new NOrdenCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbBusca;
    private javax.swing.JLabel JbCvet;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JButton JbImpresion;
    private javax.swing.JLabel JbMat;
    private javax.swing.JButton JbMov;
    private javax.swing.JComboBox<String> JcAlmacen;
    private com.toedter.calendar.JDateChooser JeFecha;
    private com.toedter.calendar.JDateChooser JeFechadoc;
    public javax.swing.JList<Ordencompra> JlBusquedas;
    private javax.swing.JLabel JlFecha;
    private javax.swing.JLabel JlIcono;
    private javax.swing.JLabel Jll;
    private javax.swing.JLabel Jlserie;
    private javax.swing.JMenuItem Jmi;
    private javax.swing.JMenuItem Jmm;
    private javax.swing.JPanel JpAlmacen;
    private javax.swing.JPanel JpB;
    private javax.swing.JPopupMenu JpMenu;
    private javax.swing.JTextField JtBusquedas;
    private javax.swing.JTextField JtCambio;
    private javax.swing.JTextField JtFolio;
    private javax.swing.JTextField JtIva;
    public javax.swing.JTextField JtMat;
    public javax.swing.JTextField JtProveedor;
    private javax.swing.JTextField JtRdoc;
    private javax.swing.JTextField JtSubtotal;
    private javax.swing.JTextField JtTotal;
    private javax.swing.JTextArea JtaObservaciones;
    private javax.swing.JTable JttMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JList<Material> listaMat;
    public javax.swing.JList<ProveedorMPrima> listaProveedor;
    // End of variables declaration//GEN-END:variables
}
