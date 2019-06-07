package ViewLayer;

import ObjectLayer.Agente;
import ObjectLayer.Banco;
import ObjectLayer.Ciudad;
import ObjectLayer.Cliente;
import ObjectLayer.Estado;
import ObjectLayer.ObjectAgentes;
import ObjectLayer.ObjectBancos;
import ObjectLayer.ObjectCiudades;
import ObjectLayer.ObjectClientes;
import ObjectLayer.ObjectEstados;
import ObjectLayer.ObjectPaises;
import ObjectLayer.ObjectZonas;
import ObjectLayer.Pais;
import ObjectLayer.Zona;
import Plugins.ParametroCliente;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NCliente extends javax.swing.JDialog {

    ObjectClientes obj = new ObjectClientes();
    ObjectAgentes ag = new ObjectAgentes();
    ObjectCiudades cd = new ObjectCiudades();
    ObjectEstados ed = new ObjectEstados();
    ObjectBancos bn = new ObjectBancos();
    ObjectPaises ps = new ObjectPaises();
    ObjectZonas zn = new ObjectZonas();
    ParametroCliente par = new ParametroCliente();
    String informacion = "";

    public NCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LoadModelAgente();
        LoadModelCiudad();
        LoadModelBanco();
        LoadModelEstado();
        LoadModelPais();
        LoadModelZona();
        CargarNum();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        Jtid.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    private void LoadModelAgente() {
        Agente ag = new Agente();
        DefaultComboBoxModel modelAgente = new DefaultComboBoxModel(ag.getAgentes());
        JcAgente.setModel(modelAgente);
    }

    private void LoadModelCiudad() {
        Ciudad cd = new Ciudad();
        DefaultComboBoxModel modelCiudad = new DefaultComboBoxModel(cd.getCiudades());
        JcCiudad.setModel(modelCiudad);
    }

    private void LoadModelBanco() {
        Banco bn = new Banco();
        DefaultComboBoxModel modelBanco = new DefaultComboBoxModel(bn.getBancos());
        JcBanco.setModel(modelBanco);
    }

    private void LoadModelEstado() {
        Estado ed = new Estado();
        DefaultComboBoxModel modelEstado = new DefaultComboBoxModel(ed.getEstados());
        JcEstado.setModel(modelEstado);
    }

    private void LoadModelPais() {
        Pais ps = new Pais();
        DefaultComboBoxModel modelPais = new DefaultComboBoxModel(ps.getPaises());
        JcPais.setModel(modelPais);
    }

    private void LoadModelZona() {
        Zona zn = new Zona();
        DefaultComboBoxModel modelZona = new DefaultComboBoxModel(zn.getZonas());
        JcZona.setModel(modelZona);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JtabDatos = new javax.swing.JTabbedPane();
        Pane1 = new javax.swing.JPanel();
        JbDes = new javax.swing.JLabel();
        JbCod = new javax.swing.JLabel();
        JtRs = new javax.swing.JTextField();
        JtCod = new javax.swing.JTextField();
        JbRFC = new javax.swing.JLabel();
        JtRFC = new javax.swing.JTextField();
        JbCTA = new javax.swing.JLabel();
        JtCta = new javax.swing.JTextField();
        JbCred = new javax.swing.JLabel();
        JbMpago = new javax.swing.JLabel();
        JbObv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JaObv = new javax.swing.JTextArea();
        JbCFDI = new javax.swing.JLabel();
        JtCf = new javax.swing.JTextField();
        JbPago = new javax.swing.JLabel();
        JsCred = new javax.swing.JSpinner();
        JbAgente = new javax.swing.JLabel();
        JcAgente = new javax.swing.JComboBox<>();
        JcFpago = new javax.swing.JComboBox<>();
        JbBanco = new javax.swing.JLabel();
        JcBanco = new javax.swing.JComboBox<>();
        JbContac = new javax.swing.JLabel();
        JcMpago = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtContacto = new javax.swing.JTextArea();
        JbSerie = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JbNumC = new javax.swing.JLabel();
        Pane2 = new javax.swing.JPanel();
        JbPais = new javax.swing.JLabel();
        JcPais = new javax.swing.JComboBox<>();
        JbEstado = new javax.swing.JLabel();
        JcEstado = new javax.swing.JComboBox<>();
        JbCiudad = new javax.swing.JLabel();
        JcCiudad = new javax.swing.JComboBox<>();
        JbZona = new javax.swing.JLabel();
        JcZona = new javax.swing.JComboBox<>();
        JbCP = new javax.swing.JLabel();
        JtCP = new javax.swing.JTextField();
        JtCalle = new javax.swing.JTextField();
        JbCalle = new javax.swing.JLabel();
        JbNum = new javax.swing.JLabel();
        JtNum = new javax.swing.JTextField();
        JbCol = new javax.swing.JLabel();
        JtColonia = new javax.swing.JTextField();
        JbTel = new javax.swing.JLabel();
        JtTel = new javax.swing.JTextField();
        JbEmail = new javax.swing.JLabel();
        JtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JtTel2 = new javax.swing.JTextField();
        JtTel3 = new javax.swing.JTextField();
        Jtid = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTE");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ingresa los datos del cliente");

        JbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDes.setText("Razón Social:");

        JbCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCod.setText("Código:");

        JtRs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtRsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtRsKeyTyped(evt);
            }
        });

        JtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCodKeyTyped(evt);
            }
        });

        JbRFC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbRFC.setText("RFC:");

        JtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtRFCKeyTyped(evt);
            }
        });

        JbCTA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCTA.setText("Cuenta:");

        JtCta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCtaKeyTyped(evt);
            }
        });

        JbCred.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCred.setText("Diás Crédito:");

        JbMpago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMpago.setText("Método Pago:");

        JbObv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbObv.setText("Observaciones:");

        JaObv.setColumns(20);
        JaObv.setRows(5);
        JaObv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JaObvKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(JaObv);

        JbCFDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCFDI.setText("Uso CFDI:");

        JtCf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCfKeyTyped(evt);
            }
        });

        JbPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPago.setText("Forma Pago");

        JbAgente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbAgente.setText("Agente:");

        JcAgente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JcFpago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una forma de pago", "01 Efectivo", "02 Cheque", "03 Transferencia de fondos", "99 Por definir" }));

        JbBanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbBanco.setText("Banco:");

        JcBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JbContac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbContac.setText("Contacto:");

        JcMpago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un método de pago", "PUE", "PPD" }));

        JtContacto.setColumns(20);
        JtContacto.setRows(5);
        JtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtContactoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(JtContacto);

        JbSerie.setText("jLabel4");

        jLabel4.setText("Serie:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre:");

        JtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtNombreKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Num Cliente:");

        JbNumC.setText("jLabel7");

        javax.swing.GroupLayout Pane1Layout = new javax.swing.GroupLayout(Pane1);
        Pane1.setLayout(Pane1Layout);
        Pane1Layout.setHorizontalGroup(
            Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane1Layout.createSequentialGroup()
                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbDes)
                            .addComponent(jLabel5)
                            .addComponent(JbObv)
                            .addComponent(JbCTA)))
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JbAgente))
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JbRFC))
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JbCred)))
                .addGap(18, 18, 18)
                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtCta, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addComponent(JsCred, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(JbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JtRs)
                        .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(JbCFDI)
                            .addComponent(JbPago))
                        .addGap(19, 19, 19)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JcFpago, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtCf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbNumC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbMpago)
                            .addComponent(JbCod)
                            .addComponent(JbBanco)
                            .addComponent(JbContac))
                        .addGap(18, 18, 18)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcMpago, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        Pane1Layout.setVerticalGroup(
            Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pane1Layout.createSequentialGroup()
                                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(Pane1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(JbNumC)))
                                .addGap(44, 44, 44)
                                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JbCFDI)
                                    .addComponent(JtCf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Pane1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(JbDes)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel5)))
                        .addGap(152, 152, 152)
                        .addComponent(JbCTA))
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(JtRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbPago)
                            .addComponent(JcFpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbRFC))
                        .addGap(36, 36, 36)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbMpago)
                            .addComponent(JcMpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbAgente))
                        .addGap(27, 27, 27)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtCta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCod)
                            .addComponent(JtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JsCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JbCred))
                            .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(JbSerie))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JbBanco)
                                .addComponent(JcBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(3, 3, 3)
                .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pane1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Pane1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(JbObv))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbContac)
                        .addGap(26, 26, 26))))
        );

        JtabDatos.addTab("Datos Generales", Pane1);

        JbPais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPais.setText("País");

        JcPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JbEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbEstado.setText("Estado:");

        JcEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JbCiudad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCiudad.setText("Ciudad:");

        JcCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JbZona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbZona.setText("Zona:");

        JcZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JbCP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCP.setText("CP:");

        JtCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtCPKeyReleased(evt);
            }
        });

        JtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtCalleKeyTyped(evt);
            }
        });

        JbCalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCalle.setText("Calle:");

        JbNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbNum.setText("No:");

        JtNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtNumKeyReleased(evt);
            }
        });

        JbCol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCol.setText("Colonia:");

        JtColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtColoniaKeyTyped(evt);
            }
        });

        JbTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTel.setText("Telefono:");

        JtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtTelKeyReleased(evt);
            }
        });

        JbEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbEmail.setText("Email:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Telefono2:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Telefono3:");

        javax.swing.GroupLayout Pane2Layout = new javax.swing.GroupLayout(Pane2);
        Pane2.setLayout(Pane2Layout);
        Pane2Layout.setHorizontalGroup(
            Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Pane2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(JtTel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane2Layout.createSequentialGroup()
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JbEstado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbCiudad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbTel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbCP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbPais, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pane2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(JcPais, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JcEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JcCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JtTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(Pane2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JtTel2)))
                .addGap(108, 108, 108)
                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pane2Layout.createSequentialGroup()
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JbNum)
                                .addComponent(JbCol)
                                .addComponent(JbCalle)
                                .addComponent(JbEmail))
                            .addGroup(Pane2Layout.createSequentialGroup()
                                .addComponent(JbZona)
                                .addGap(17, 17, 17)))
                        .addGap(26, 26, 26)
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcZona, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Pane2Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );
        Pane2Layout.setVerticalGroup(
            Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pane2Layout.createSequentialGroup()
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Pane2Layout.createSequentialGroup()
                                .addComponent(JbPais)
                                .addGap(48, 48, 48)
                                .addComponent(JbEstado)
                                .addGap(102, 102, 102)
                                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JbCP)
                                    .addComponent(JtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JbCol)
                                    .addComponent(JtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
                            .addGroup(Pane2Layout.createSequentialGroup()
                                .addComponent(JcPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JbCalle))
                                .addGap(37, 37, 37)
                                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JcCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JbCiudad))
                                .addGap(91, 91, 91)
                                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JbTel)
                                    .addComponent(JbEmail)
                                    .addComponent(JtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33)
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbZona))
                        .addGroup(Pane2Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JbNum)
                                .addComponent(JtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addGroup(Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JtTel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        JtabDatos.addTab("Dirección", Pane2);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(JbGuardar)
                        .addGap(46, 46, 46)
                        .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(JtabDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JtabDatos)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(JbCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        if (JtNombre.getText().isEmpty() || JtRFC.getText().isEmpty() || JcAgente.getSelectedIndex() == 0
                || JcCiudad.getSelectedIndex() == 0 || JcBanco.getSelectedIndex() == 0 || JcEstado.getSelectedIndex() == 0
                || JcPais.getSelectedIndex() == 0 || JcZona.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (Jtid.getText().isEmpty()) {
            if (obj.validarCliente(JtRs.getText(), JtNombre.getText()) == 0) {
                Guardar();
            } else {
                JOptionPane.showMessageDialog(null, "Este registro ya existe", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            Editar();
        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void CargarNum() {
        int num = 1;
        String P = "0";
        ArrayList<Cliente> listP = obj.getNumCli();

        if (listP.size() > 0) {
            for (Cliente par : listP) {
                int Num = Integer.parseInt(par.getNumCliente());
                int var = num + Num;
                JbNumC.setText(String.valueOf(var));
            }
        } else {
            JbNumC.setText(String.valueOf(num));
        }
        /* for (Cliente par : listP) {

            if (par.getNumCliente().equals(P)) {
                JbNumC.setText(String.valueOf(num));
            } else {
                int Num = Integer.parseInt(par.getNumCliente());
                int var = num + Num;
                JbNumC.setText(String.valueOf(var));
            }
        }*/
    }

    private void Guardar() {
        Agente agente = (Agente) JcAgente.getSelectedItem();
        Ciudad ciudad = (Ciudad) JcCiudad.getSelectedItem();
        Banco banco = (Banco) JcBanco.getSelectedItem();
        Estado estado = (Estado) JcEstado.getSelectedItem();
        Pais pais = (Pais) JcPais.getSelectedItem();
        Zona zona = (Zona) JcZona.getSelectedItem();
        String rs = JtRs.getText();
        String rfc = JtRFC.getText();
        String cta = JtCta.getText();
        int cred = (int) JsCred.getValue();
        String cp = JtCP.getText();
        String email = JtEmail.getText();
        String col = JtColonia.getText();
        String Calle = JtCalle.getText();
        String Num = JtNum.getText();
        String cod = JtCod.getText();
        String cont = JtContacto.getText();
        String obv = JaObv.getText();
        String Fpago = JcFpago.getSelectedItem().toString();

        String Mpago = JcMpago.getSelectedItem().toString();
        String cf = JtCf.getText();
        String tel = JtTel.getText();
        String tel2 = JtTel2.getText();
        String tel3 = JtTel3.getText();
        String Nombre = JtNombre.getText();
        String NumC = JbNumC.getText();

        Cliente cl = new Cliente();
        cl.setRazonSocial(rs);
        cl.setCodigo(cod);
        cl.setId_Ciudad(ciudad.getId_Ciudad());
        cl.setRFC(rfc);
        cl.setId_Agente(agente.getId_Agente());
        cl.setCP(cp);
        cl.setId_Zona(zona.getId_Zona());
        cl.setColonia(col);
        cl.setCalle(Calle);
        cl.setNumeroCalle(Num);
        cl.setTelefono(tel);
        cl.setId_Pais(pais.getId_Pais());
        cl.setId_Estado(estado.getId_Estado());
        cl.setCuenta(cta);
        cl.setDiasCredito(cred);
        cl.setEmail(email);
        cl.setContacto(cont);
        cl.setObservaciones(obv);
        cl.setUsoCfdi(cf);
        cl.setFormaPago(Fpago);
        cl.setMetodoPago(Mpago);
        cl.setId_Banco(banco.getId_Banco());
        cl.setActivo(true);
        
        cl.setTelefono2(tel2);
        cl.setTelefono3(tel3);
        cl.setNombre(Nombre);
        cl.setSerie(JbSerie.getText());
        cl.setNumCliente(NumC);
        int Nc = Integer.parseInt(NumC);

        if (obj.validarNumCliente(Nc) == 0) {
            if (obj.clientesAdd(cl)) {
                JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                CargarNum();
                informacion = "1";
                Limpiar();
                /*if (par.insertarPam(NumC)) {
                    JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CargarNum();
                    informacion = "1";
                    Limpiar();
                } else {
                    obj.anularCliente(NumC);
                }*/
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                //Limpiar();
            }
        } else {
            //JOptionPane.showMessageDialog(this, "Ya existe", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            CargarNum();
            if (obj.clientesAdd(cl)) {
                JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                CargarNum();
                informacion = "1";
                Limpiar();
                /*if (par.insertarPam(NumC)) {
                    JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CargarNum();
                    informacion = "1";
                    Limpiar();
                } else {
                    obj.anularCliente(NumC);
                }*/

            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                //Limpiar();
            }
        }
    }

    private void Editar() {
        int Id = Integer.parseInt(Jtid.getText());
        Agente agente = (Agente) JcAgente.getSelectedItem();
        Ciudad ciudad = (Ciudad) JcCiudad.getSelectedItem();
        Banco banco = (Banco) JcBanco.getSelectedItem();
        Estado estado = (Estado) JcEstado.getSelectedItem();
        Pais pais = (Pais) JcPais.getSelectedItem();
        Zona zona = (Zona) JcZona.getSelectedItem();
        String rs = JtRs.getText();
        String rfc = JtRFC.getText();
        String cta = JtCta.getText();
        int cred = (int) JsCred.getValue();
        String cp = JtCP.getText();
        String email = JtEmail.getText();
        String col = JtColonia.getText();
        String Calle = JtCalle.getText();
        String Num = JtNum.getText();
        String cod = JtCod.getText();
        String cont = JtContacto.getText();
        String obv = JaObv.getText();
        String Fpago = JcFpago.getSelectedItem().toString();
        String Mpago = JcMpago.getSelectedItem().toString();
        String cf = JtCf.getText();
        String tel = JtTel.getText();
        String tel2 = JtTel2.getText();
        String tel3 = JtTel3.getText();
        String Nombre = JtNombre.getText();

        Cliente cl = new Cliente();
        cl.setId_Cliente(Id);
        cl.setRazonSocial(rs);
        cl.setCodigo(cod);
        cl.setId_Ciudad(ciudad.getId_Ciudad());
        cl.setRFC(rfc);
        cl.setId_Agente(agente.getId_Agente());
        cl.setCP(cp);
        cl.setId_Zona(zona.getId_Zona());
        cl.setColonia(col);
        cl.setCalle(Calle);
        cl.setNumeroCalle(Num);
        cl.setTelefono(tel);
        cl.setId_Pais(pais.getId_Pais());
        cl.setId_Estado(estado.getId_Estado());
        cl.setCuenta(cta);
        cl.setDiasCredito(cred);
        cl.setEmail(email);
        cl.setContacto(cont);
        cl.setObservaciones(obv);
        cl.setUsoCfdi(cf);
        cl.setFormaPago(Fpago);
        cl.setMetodoPago(Mpago);
        cl.setId_Banco(banco.getId_Banco());
        cl.setActivo(true);
        cl.setTelefono2(tel2);
        cl.setTelefono3(tel3);
        cl.setNombre(Nombre);

        if (obj.clienteUpdate(cl)) {
            JOptionPane.showMessageDialog(this, "Registro Editado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            Limpiar();
        }
    }

    private void JtRsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtRsKeyReleased
        /*if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_ENTER)
                && !(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Escribe solo letras");
            JtRs.setText("");
        }*/
    }//GEN-LAST:event_JtRsKeyReleased

    private void JtTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtTelKeyReleased
        /*if(!Character.isDigit(evt.getKeyCode())
            &&!(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
            && !(evt.getKeyChar()== KeyEvent.VK_ENTER)
            && !(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Escribe solo Numeros");
            JtTel.setText("");
        }*/
    }//GEN-LAST:event_JtTelKeyReleased

    private void JtNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNumKeyReleased
        /* if(!Character.isDigit(evt.getKeyCode())
            &&!(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
            && !(evt.getKeyChar()== KeyEvent.VK_ENTER)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Escribe solo Numeros");
            JtTel.setText("");
        }*/
    }//GEN-LAST:event_JtNumKeyReleased

    private void JtCPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCPKeyReleased
        /*if(!Character.isDigit(evt.getKeyCode())
            &&!(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
            && !(evt.getKeyChar()== KeyEvent.VK_ENTER)
            && !(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Escribe solo Numeros");
            JtTel.setText("");
        }*/
    }//GEN-LAST:event_JtCPKeyReleased

    private void JtRsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtRsKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtRsKeyTyped

    private void JtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtRFCKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtRFCKeyTyped

    private void JaObvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JaObvKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JaObvKeyTyped

    private void JtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCalleKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtCalleKeyTyped

    private void JtColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtColoniaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtColoniaKeyTyped

    private void JtCtaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCtaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtCtaKeyTyped

    private void JtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCodKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtCodKeyTyped

    private void JtCfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtCfKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtCfKeyTyped

    private void JtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtContactoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtContactoKeyTyped

    private void JtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtNombreKeyTyped

    private void Limpiar() {
        this.JtRs.setText("");
        this.JtColonia.setText("");
        this.JaObv.setText("");
        this.JtCP.setText("");
        this.JtCalle.setText("");
        this.JtCf.setText("");
        this.JtCod.setText("");
        this.JtContacto.setText("");
        this.JtCta.setText("");
        this.JtEmail.setText("");
        this.JtNum.setText("");
        this.JtRFC.setText("");
        this.JtTel.setText("");
        this.JtTel2.setText("");
        this.JtTel3.setText("");
        this.JcAgente.setSelectedIndex(0);
        this.JcBanco.setSelectedIndex(0);
        this.JcCiudad.setSelectedIndex(0);
        this.JcEstado.setSelectedIndex(0);
        this.JcFpago.setSelectedIndex(0);
        this.JcMpago.setSelectedIndex(0);
        this.JcPais.setSelectedIndex(0);
        this.JcZona.setSelectedIndex(0);
        this.JsCred.setValue(0);
        this.JcMpago.setSelectedIndex(0);
        this.JcFpago.setSelectedIndex(0);
        JtRs.requestFocus();
        JtRs.requestFocus();
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
            java.util.logging.Logger.getLogger(NCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NCliente dialog = new NCliente(new javax.swing.JFrame(), true);
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

    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea JaObv;
    private javax.swing.JLabel JbAgente;
    private javax.swing.JLabel JbBanco;
    private javax.swing.JLabel JbCFDI;
    private javax.swing.JLabel JbCP;
    private javax.swing.JLabel JbCTA;
    private javax.swing.JLabel JbCalle;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbCiudad;
    private javax.swing.JLabel JbCod;
    private javax.swing.JLabel JbCol;
    private javax.swing.JLabel JbContac;
    private javax.swing.JLabel JbCred;
    private javax.swing.JLabel JbDes;
    private javax.swing.JLabel JbEmail;
    private javax.swing.JLabel JbEstado;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbMpago;
    private javax.swing.JLabel JbNum;
    public javax.swing.JLabel JbNumC;
    private javax.swing.JLabel JbObv;
    private javax.swing.JLabel JbPago;
    private javax.swing.JLabel JbPais;
    private javax.swing.JLabel JbRFC;
    public javax.swing.JLabel JbSerie;
    private javax.swing.JLabel JbTel;
    private javax.swing.JLabel JbZona;
    public javax.swing.JComboBox<String> JcAgente;
    public javax.swing.JComboBox<String> JcBanco;
    public javax.swing.JComboBox<String> JcCiudad;
    public javax.swing.JComboBox<String> JcEstado;
    public javax.swing.JComboBox<String> JcFpago;
    public javax.swing.JComboBox<String> JcMpago;
    public javax.swing.JComboBox<String> JcPais;
    public javax.swing.JComboBox<String> JcZona;
    public javax.swing.JSpinner JsCred;
    public javax.swing.JTextField JtCP;
    public javax.swing.JTextField JtCalle;
    public javax.swing.JTextField JtCf;
    public javax.swing.JTextField JtCod;
    public javax.swing.JTextField JtColonia;
    public javax.swing.JTextArea JtContacto;
    public javax.swing.JTextField JtCta;
    public javax.swing.JTextField JtEmail;
    public javax.swing.JTextField JtNombre;
    public javax.swing.JTextField JtNum;
    public javax.swing.JTextField JtRFC;
    public javax.swing.JTextField JtRs;
    public javax.swing.JTextField JtTel;
    public javax.swing.JTextField JtTel2;
    public javax.swing.JTextField JtTel3;
    private javax.swing.JTabbedPane JtabDatos;
    public javax.swing.JTextField Jtid;
    private javax.swing.JPanel Pane1;
    private javax.swing.JPanel Pane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
