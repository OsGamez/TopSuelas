package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.KardexCmp;
import ObjectLayer.Material;
import ObjectLayer.Movs_materiales;
import ObjectLayer.ObjectConceptosPrima;
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
    ProveedorMPrima pmp = new ProveedorMPrima();
    Vector<Almacen> listaalmacen = new Vector<>();
    Vector<Almacen> listaalmacena = new Vector<>();
    ObjectMateriales ObjM = new ObjectMateriales();
    ObjectKardexCmp Objcmp = new ObjectKardexCmp();
    String columna = "";
    String columna2 = "";
    Sesioninfo s = new Sesioninfo();

    DefaultListModel<ProveedorMPrima> modeloListaProveedor = new DefaultListModel<>();
    DefaultListModel<Material> modeloListaMat = new DefaultListModel<>();
    DefaultTableModel modelMaterials;

    public MovimientosesCMP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Refresh_36729.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelAlmacen();
        LoadModelAlmacena();
        Calendar fecha = new GregorianCalendar();
        JeFecha.setCalendar(fecha);
        JeFecha.setEnabled(false);
        JtCuenta.requestFocus();
        Jlserie.setText(s.getSerie());
        LoadModelmaterials();
        JbIdProd.setVisible(false);
        JbCvet.setVisible(false);
        Jlca.setVisible(false);
        JtCuentaa.setVisible(false);
        Jlsa.setVisible(false);
        JtSubcuentaa.setVisible(false);
        Jla.setVisible(false);
        JcAlmacena.setVisible(false);
        Jlcambio.setVisible(false);
        JtFolio2.setVisible(false);
        pmp.setProveedor(0);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        JttMaterial = new javax.swing.JTable();
        JbMov = new javax.swing.JButton();
        JtCuentaa = new javax.swing.JTextField();
        JtSubcuentaa = new javax.swing.JTextField();
        Jlca = new javax.swing.JLabel();
        Jlsa = new javax.swing.JLabel();
        JcAlmacena = new javax.swing.JComboBox<>();
        Jla = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JtCuenta = new javax.swing.JTextField();
        JtSubcuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JcAlmacen = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Jlcambio = new javax.swing.JLabel();
        JtFolio2 = new javax.swing.JTextField();

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
        setTitle("Movimientos de Entrada y Salida");
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

        JeFecha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

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
        jScrollPane2.setViewportView(JttMaterial);

        JbMov.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMov.setText("Realizar Movimiento");
        JbMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbMovActionPerformed(evt);
            }
        });

        JtCuentaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCuentaaActionPerformed(evt);
            }
        });

        JtSubcuentaa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtSubcuentaaMouseClicked(evt);
            }
        });
        JtSubcuentaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtSubcuentaaActionPerformed(evt);
            }
        });

        Jlca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jlca.setText("Cuenta");

        Jlsa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jlsa.setText("Subcuenta");

        JcAlmacena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JcAlmacena.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcAlmacenaItemStateChanged(evt);
            }
        });
        JcAlmacena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JcAlmacenaMouseClicked(evt);
            }
        });

        Jla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jla.setText("Almacen");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(JcAlmacen, 0, 209, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(JtSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JcAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );

        Jlcambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N

        JtFolio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtFolio2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JtFolio2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jlserie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JbMat)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JbCvet)
                                .addComponent(JbIdProd)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JbMov)
                                .addGap(212, 212, 212))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(JtMat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(JtProveedor)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(Jlca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtCuentaa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jlsa)
                        .addGap(10, 10, 10)
                        .addComponent(JtSubcuentaa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Jla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JcAlmacena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jlcambio)
                .addGap(371, 371, 371))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(JtFolio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JeFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jlserie, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jlcambio)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JcAlmacena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jla)
                        .addComponent(JtSubcuentaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jlsa)
                        .addComponent(JtCuentaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Jlca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbMat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(JbIdProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JbCvet)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(JbMov)
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

    private void LoadModelAlmacena() {
        Almacen e = new Almacen();
        e.conCMP();
        DefaultComboBoxModel modelEtiqueta = new DefaultComboBoxModel(e.getAlmacenes());
        listaalmacena = e.getAlmacenes();
        JcAlmacena.setModel(modelEtiqueta);
        JcAlmacena.setSelectedIndex(0);
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
//        System.out.println(rows);
        for (int i = rows - 1; i >= 0; i--) {
            modelMaterials.removeRow(i);
        }
    }
    private void JtProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyReleased
        int cuenta = Integer.parseInt(JtCuenta.getText());
        int sub = Integer.parseInt(JtSubcuenta.getText());
        if (listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen()
                == listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen() && ((cuenta == 1 && sub == 16) || (cuenta == 60 && sub == 16))) {
            JOptionPane.showMessageDialog(null, "No puede elegirse el mismo almacen!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            JcAlmacena.requestFocus();
            limpiarMaterial();
            JtProveedor.setText("");
        } else {
            if (JtProveedor.getText().isEmpty()) {
                limpiarListaProveedor();
            } else {
                limpiarListaProveedor();
                listaproveedorm = pm.ProveedorMPrimaSearch(JtProveedor.getText());
                for (ProveedorMPrima p : listaproveedorm) {
                    modeloListaProveedor.addElement(p);
                }
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
        JtProveedor.setText("");
        if (JtCuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        }

    }//GEN-LAST:event_JtProveedorMouseClicked

    private void JtMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyReleased
        int cuenta = Integer.parseInt(JtCuenta.getText());
        int sub = Integer.parseInt(JtSubcuenta.getText());
        if (listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen()
                == listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen() && ((cuenta == 1 && sub == 16) || (cuenta == 60 && sub == 16))) {
            JOptionPane.showMessageDialog(null, "No puede elegirse el mismo almacen!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            JcAlmacena.requestFocus();
            limpiarMaterial();
            JtMat.setText("");
        } else {
            if (JtMat.getText().isEmpty()) {
                limpiarMaterial();
            } else {
                limpiarMaterial();
                listaMaterial = ObjM.GetByCosto(JtMat.getText());
                for (Material m : listaMaterial) {
                    modeloListaMat.addElement(m);
                }
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
            while (Float.parseFloat(resp) <= 0 && (!v.verificanumeros(resp) || v.verificaflotantes(resp))) {
                resp = JOptionPane.showInputDialog("Escribe la cantidad: ");
            }
            float existencia;
            if (Integer.parseInt(JtCuenta.getText()) == 1 && Integer.parseInt(JtSubcuenta.getText()) == 16) {
                existencia = ObjM.validaralmacen_material(listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen(), mat.getCveMat());
            } else {
                existencia = ObjM.validaralmacen_material(listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen(), mat.getCveMat());
            }
//            System.out.println(existencia + " * " + resp + " *");
            if (existencia == 0 || existencia < Float.parseFloat(resp)) {//  verifica si hay stock suficiente para hacer el traspaso
                JOptionPane.showMessageDialog(null, "No se cuenta con suficiente existencia de este material con el almacen seleccionado", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                JtMat.setText("");
                JtMat.requestFocus();
                limpiarMaterial();
            } else {
                ma.setCantidad(Float.parseFloat(resp));
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
        if (JtCuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        } else {
            JtSubcuenta.setText("");
            JtSubcuenta.requestFocus();
        }
    }//GEN-LAST:event_JtCuentaActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (JtCuenta.getText().equals("") && JtSubcuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        }
    }//GEN-LAST:event_formMouseClicked

    private void JtSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtSubcuentaActionPerformed
        Validacion v = new Validacion();
        if (JtSubcuenta.getText().equals("") || !v.verificanumeros(JtCuenta.getText())
                || !v.verificanumeros(JtSubcuenta.getText())) {
            JtSubcuenta.requestFocus();
        } else {
            int cuenta = Integer.parseInt(JtCuenta.getText());
            int subcuenta = Integer.parseInt(JtSubcuenta.getText());
            if (cuenta == 1 && subcuenta == 1) {
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
                    JtCuenta.setText("");
                }
            } else if (cuenta == 1 && subcuenta == 16) {
                JtFolio.setText(Objcmp.getparametro("Entradas"));
                JtFolio2.setText(Objcmp.getparametro("Salidas"));
                JtCuentaa.setText("60");
                JtSubcuentaa.setText("16");
                JtCuentaa.setEnabled(false);
                JtSubcuentaa.setEnabled(false);
                Jlca.setVisible(true);
                JtCuentaa.setVisible(true);
                Jlsa.setVisible(true);
                JtSubcuentaa.setVisible(true);
                Jla.setVisible(true);
                JcAlmacena.setVisible(true);
                Jlcambio.setVisible(true);
                JtFolio2.setVisible(true);
                JcAlmacen.requestFocus();
            } else if (cuenta == 60 && subcuenta == 16) {
                JtFolio.setText(Objcmp.getparametro("Salidas"));
                JtFolio2.setText(Objcmp.getparametro("Entradas"));
                JtCuentaa.setText("01");
                JtSubcuentaa.setText("16");
                JtCuentaa.setEnabled(false);
                JtSubcuentaa.setEnabled(false);
                Jlca.setVisible(true);
                JtCuentaa.setVisible(true);
                Jlsa.setVisible(true);
                JtSubcuentaa.setVisible(true);
                Jla.setVisible(true);
                JcAlmacena.setVisible(true);
                Jlcambio.setVisible(true);
                JtFolio2.setVisible(true);
                JcAlmacen.requestFocus();
            } else {
                ObjectConceptosPrima ocp = new ObjectConceptosPrima();
                if (!ocp.validarCuenta(JtCuenta.getText(), JtSubcuenta.getText())) {
                    columna = (cuenta < 50) ? "Entradas" : "Salidas";
                    JtFolio.setText(Objcmp.getparametro(columna));
                    JcAlmacen.requestFocus();
                    Jlca.setVisible(false);
                    JtCuentaa.setVisible(false);
                    Jlsa.setVisible(false);
                    JtSubcuentaa.setVisible(false);
                    Jla.setVisible(false);
                    JcAlmacena.setVisible(false);
                    Jlcambio.setVisible(false);
                    JtFolio2.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "La cuenta y subcuenta no existe!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    JtCuenta.requestFocus();
                }
            }
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

    private void JbMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbMovActionPerformed
        generarmovimiento();
    }//GEN-LAST:event_JbMovActionPerformed

    private void JcAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAlmacenItemStateChanged
        JcAlmacena.requestFocus();
    }//GEN-LAST:event_JcAlmacenItemStateChanged

    private void JlserieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlserieMouseClicked
        String serie = (s.getSerie().equals("A")) ? "B" : "A";
        s.setSerie(serie);
        Jlserie.setText(serie);
    }//GEN-LAST:event_JlserieMouseClicked

    private void JtCuentaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCuentaaActionPerformed
        Validacion v = new Validacion();
        if (JtCuenta.getText().equals("") && JtSubcuenta.getText().equals("") || v.verificanumeros(JtCuenta.getText())) {
            JtCuenta.requestFocus();
        } else {
            JtSubcuentaa.requestFocus();
        }
    }//GEN-LAST:event_JtCuentaaActionPerformed

    private void JtSubcuentaaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtSubcuentaaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtSubcuentaaMouseClicked

    private void JtSubcuentaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtSubcuentaaActionPerformed
        if (JtCuenta.getText().equals("") && JtSubcuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        } else {
            JcAlmacena.requestFocus();
        }
    }//GEN-LAST:event_JtSubcuentaaActionPerformed

    private void JcAlmacenaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAlmacenaItemStateChanged
        if (JtCuenta.getText().equals("") && JtSubcuenta.getText().equals("")) {
            JtCuenta.requestFocus();
        } else {
            if (listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen()
                    == listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen()) {
                JOptionPane.showMessageDialog(null, "No puede elegirse el mismo almacen!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JtMat.requestFocus();
            }
        }
    }//GEN-LAST:event_JcAlmacenaItemStateChanged

    private void JcAlmacenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JcAlmacenaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JcAlmacenaMouseClicked

    private void JtFolio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtFolio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtFolio2ActionPerformed

    private void JtMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtMatActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String serie = (s.getSerie().equals("A")) ? "B" : "A";
        s.setSerie(serie);
        Jlserie.setText(serie);
    }//GEN-LAST:event_jLabel5MouseClicked
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
                } else if (listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen()
                        == listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen()) {
                    JOptionPane.showMessageDialog(null, "No puede elegirse el mismo almacen!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    JcAlmacena.requestFocus();
                } else if (pmp.getProveedor() == 0) {
                    JtProveedor.requestFocus();
                    JOptionPane.showMessageDialog(null, "Elija un almacen un proveedor, si no es Orden de compra elija SISTEMA", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ArrayList<Movs_materiales> arr = new ArrayList<>();
                    int rows = JttMaterial.getRowCount();
                    for (int i = 0; i < rows; i++) {
                        String numaux = JttMaterial.getValueAt(i, 1).toString();
                        Movs_materiales mo = new Movs_materiales();
                        mo.setMaterial(listamovimiento_material.get(i).getMaterial());
                        mo.setCosto(listamovimiento_material.get(i).getCosto());
                        mo.setCantidad(Float.parseFloat(numaux));
                        arr.add(mo);
                    }
                    String[] ar;// operacion
                    String[] tipo;// tipo movimiento
                    int[] carr;//cuentas
                    int[] sarr;// subcuentas
                    int[] alm;// almacenes
                    int i = 0;
                    int[] folios;// folios
                    int cuenta = Integer.parseInt(JtCuenta.getText());
                    int sub = Integer.parseInt(JtSubcuenta.getText());
                    if ((cuenta == 1 && sub == 16)) {//establecer que valores tomara al ser E/S
                        ar = new String[2];// signo que tomara la operacion
                        ar[0] = "+";
                        ar[1] = "-";
                        tipo = new String[2];// definir que será, entrada o Salida
                        tipo[0] = "E";
                        tipo[1] = "S";
                        carr = new int[2];// cuentas por operacion
                        carr[0] = 1;
                        carr[1] = 60;
                        sarr = new int[2];// subcuenta por operacion
                        sarr[0] = 16;
                        sarr[1] = 16;
                        alm = new int[2];// almacenes para entrada y salidas
                        alm[0] = listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen();
                        alm[1] = listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen();
                        folios = new int[2];// folios obtenidos de parametros
                        folios[0] = Integer.parseInt(JtFolio.getText()) + 1;
                        folios[1] = Integer.parseInt(JtFolio2.getText()) + 1;
                    } else if (cuenta == 60 && sub == 16) {
                        ar = new String[2];
                        ar[0] = "-";
                        ar[1] = "+";
                        tipo = new String[2];
                        tipo[0] = "S";
                        tipo[1] = "E";
                        carr = new int[2];
                        carr[0] = 60;
                        carr[1] = 01;
                        sarr = new int[2];
                        sarr[0] = 16;
                        sarr[1] = 16;
                        alm = new int[2];
                        alm[0] = listaalmacena.get(JcAlmacena.getSelectedIndex()).getAlmacen();
                        alm[1] = listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen();
                        folios = new int[2];
                        folios[0] = Integer.parseInt(JtFolio.getText()) + 1;
                        folios[1] = Integer.parseInt(JtFolio2.getText()) + 1;
                    } else {
                        // solo se ejecutara una por movimiento que no sea traspaso de almacen
                        ar = new String[1];
                        ar[0] = (columna.equals("Entradas")) ? "+" : "-";
                        tipo = new String[1];
                        tipo[0] = columna.charAt(0) + "";
                        carr = new int[1];
                        carr[0] = cuenta;
                        sarr = new int[1];
                        sarr[0] = sub;
                        alm = new int[1];
                        alm[0] = listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen();
                        folios = new int[1];
                        folios[0] = Integer.parseInt(JtFolio.getText()) + 1;
                    }
                    //String operacion = (columna.equals("Entradas")) ? "+" : "-";
                    KardexCmp k = new KardexCmp();
                    k.setProveedor(pmp.getProveedor());// cambia
                    k.setOrdenc("");// cambia
                    k.setFechamov(getfecha());
                    k.setFechadoc(getfecha());//cambia
                    k.setSerie(s.getSerie());
                    k.setDocref("");//cambia
                    k.setUsuario(s.getId_usuario());
                    k.setMat(arr);
                    while (i < ar.length) {// ciclo que movera todos los arreglos
                        k.setOperacion(ar[i]);
                        k.setFolio(folios[i]);
                        k.setCuenta(carr[i]);
                        k.setSubcuenta(sarr[i]);
                        k.setAlmacen(alm[i]);
                        k.setTipo(tipo[i]);
                        if (Objcmp.KardexCmpAdd(k)) {
                            limpiamovimiento();
                            informacion = "1";
                            JOptionPane.showMessageDialog(null, "Movimiento Completo!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Algo salio Mal, Contacta a Sistemas! ", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        }
                        i++;
                    }
                    //k.setTipo(columna.charAt(0) + "");
                    //k.setOperacion(operacion);
//                    k.setFolio(Integer.parseInt(JtFolio.getText()) + 1);
//                    k.setCuenta(Integer.parseInt(JtCuenta.getText()));
//                    k.setSubcuenta(Integer.parseInt(JtSubcuenta.getText()));
                    //k.setAlmacen(listaalmacen.get(JcAlmacen.getSelectedIndex()).getAlmacen()); no cambia
                }
            } catch (Exception e) {
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
        listaMaterial.clear();
        listamovimiento_material.clear() ; 
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
    private javax.swing.JButton JbMov;
    private javax.swing.JComboBox<String> JcAlmacen;
    private javax.swing.JComboBox<String> JcAlmacena;
    private com.toedter.calendar.JDateChooser JeFecha;
    private javax.swing.JLabel Jla;
    private javax.swing.JLabel Jlca;
    private javax.swing.JLabel Jlcambio;
    private javax.swing.JLabel Jlsa;
    private javax.swing.JLabel Jlserie;
    private javax.swing.JMenuItem Jmi;
    private javax.swing.JPopupMenu JpMenu;
    private javax.swing.JTextField JtCuenta;
    private javax.swing.JTextField JtCuentaa;
    private javax.swing.JTextField JtFolio;
    private javax.swing.JTextField JtFolio2;
    public javax.swing.JTextField JtMat;
    public javax.swing.JTextField JtProveedor;
    private javax.swing.JTextField JtSubcuenta;
    private javax.swing.JTextField JtSubcuentaa;
    public javax.swing.JLabel Jtlc;
    private javax.swing.JTable JttMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JList<Material> listaMat;
    public javax.swing.JList<ProveedorMPrima> listaProveedor;
    // End of variables declaration//GEN-END:variables
}
