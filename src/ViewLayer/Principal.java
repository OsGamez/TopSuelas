package ViewLayer;

import ObjectLayer.Hora;
import ObjectLayer.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    Bancos banco;
    Colores color;
    Corridas corrida;
    Productos productos;
    Clientes cliente;
    Pedidos pedidos;
    Gastos gasto;
    Estados estado;
    Agentes agente;
    Ciudades ciudad;
    Paises pais;
    Zonas zona;
    Lineas linea;
    Usuarios usuario;
    Usuario us;
    Precios ps;
    Login login;
    Costos costo;
    Materiales material;
    Almacenes almacen;
    frmPlaneacion pr;
    double precioa;
    double preciob;
    String id_usuario = "";
    String UsuarioChat = "";
    Moldes m;
    Proveedores pv;

    public Principal() {
        initComponents();
    }

    public Principal(Usuario us) {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Hora hr = new Hora(JbHora, JbFecha);
        hr.start();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/shoeprints_24027.png"));
        setIconImage(icon);
        JbUser.setText(us.getNombre());
        JbRol.setText(us.getDepartamento());
        this.us = us;

        if (us.getDepartamento().equals("ADMIN")) {

        } else if (us.getUsuario().equals("kim")) {
            JmConfig.setVisible(false);
            
        } else if (us.getDepartamento().equals("COBRANZA")) {
            JmConfig.setVisible(false);
            JmProduccion.setVisible(false);
        } else if (us.getDepartamento().equals("PRODUCCION")) {
            JmCobranza.setVisible(false);
            JmCPT.setVisible(false);
            JmConfig.setVisible(false);
        }
    }

    private void Cerrar() {
        String botones[] = {"Salir", ""
            + ""
            + "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar sesión?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Seguir navegando", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        MainContent = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JbUser = new javax.swing.JLabel();
        JbRol = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JbHora = new javax.swing.JLabel();
        JbFecha = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JmCobranza = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        JmAgente = new javax.swing.JMenuItem();
        JmBanco = new javax.swing.JMenuItem();
        JmCiudad = new javax.swing.JMenuItem();
        JmClientes = new javax.swing.JMenuItem();
        JmEstados = new javax.swing.JMenuItem();
        JmPais = new javax.swing.JMenuItem();
        JmZona = new javax.swing.JMenuItem();
        JmCPT = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        JmPrecios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        JmProveedor = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JmCancelación = new javax.swing.JMenuItem();
        JmPedidos = new javax.swing.JMenuItem();
        JmReportes = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        JmConfig = new javax.swing.JMenu();
        JmUsuario = new javax.swing.JMenuItem();
        JmProduccion = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        JmAlmacenes = new javax.swing.JMenuItem();
        JmColores = new javax.swing.JMenuItem();
        JmCorridas = new javax.swing.JMenuItem();
        JmCostos = new javax.swing.JMenuItem();
        JmLineas = new javax.swing.JMenuItem();
        JmGastos = new javax.swing.JMenuItem();
        JmMateriales = new javax.swing.JMenuItem();
        JmProductos = new javax.swing.JMenuItem();
        JmMoldes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JmAyuda = new javax.swing.JMenuItem();
        JmSalir = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOP-SUELAS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MainContent.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        JbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbUser.setForeground(new java.awt.Color(255, 255, 255));
        JbUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/females_female_avatar_woman_people_faces_18406.png"))); // NOI18N
        JbUser.setText("jLabel2");

        JbRol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbRol.setForeground(new java.awt.Color(255, 255, 255));
        JbRol.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/calendar-icon_34471.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ic-action-book_108234.png"))); // NOI18N

        JbHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbHora.setForeground(new java.awt.Color(255, 255, 255));
        JbHora.setText("jLabel5");

        JbFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbFecha.setForeground(new java.awt.Color(255, 255, 255));
        JbFecha.setText("JbFecha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JbUser)
                .addGap(44, 44, 44)
                .addComponent(JbRol)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JbFecha)
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(JbHora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbUser)
                    .addComponent(JbRol)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(JbHora)
                    .addComponent(JbFecha))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        MainContent.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(MainContent);
        MainContent.setLayout(MainContentLayout);
        MainContentLayout.setHorizontalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainContentLayout.setVerticalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuBar1KeyPressed(evt);
            }
        });

        JmCobranza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/propagation_calculator_calc_6110.png"))); // NOI18N
        JmCobranza.setText("Cobranza");
        JmCobranza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/korganizer_task_tasks_list_9500.png"))); // NOI18N
        jMenu5.setText("Catálgo");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmAgente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/customer_person_people_woman_you_1627.png"))); // NOI18N
        JmAgente.setText("Agentes");
        JmAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAgenteActionPerformed(evt);
            }
        });
        jMenu5.add(JmAgente);

        JmBanco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bank_78392.png"))); // NOI18N
        JmBanco.setText("Banco");
        JmBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBancoActionPerformed(evt);
            }
        });
        jMenu5.add(JmBanco);

        JmCiudad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Citycons_building_icon-icons.com_67935.png"))); // NOI18N
        JmCiudad.setText("Ciudad");
        JmCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCiudadActionPerformed(evt);
            }
        });
        jMenu5.add(JmCiudad);

        JmClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/manager_person_man_people_2841.png"))); // NOI18N
        JmClientes.setText("Clientes");
        JmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmClientesActionPerformed(evt);
            }
        });
        jMenu5.add(JmClientes);

        JmEstados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmEstados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1-51_icon-icons.com_68849.png"))); // NOI18N
        JmEstados.setText("Estados");
        JmEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEstadosActionPerformed(evt);
            }
        });
        jMenu5.add(JmEstados);

        JmPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mexico_flags_flag_17036.png"))); // NOI18N
        JmPais.setText("País");
        JmPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPaisActionPerformed(evt);
            }
        });
        jMenu5.add(JmPais);

        JmZona.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmZona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/if-traveling-icon-flat-outline09-3405110_107375.png"))); // NOI18N
        JmZona.setText("Zona");
        JmZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmZonaActionPerformed(evt);
            }
        });
        jMenu5.add(JmZona);

        JmCobranza.add(jMenu5);

        jMenuBar1.add(JmCobranza);

        JmCPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1562683-branding-card-pencil-profile_107062.png"))); // NOI18N
        JmCPT.setText("CPT");
        JmCPT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/korganizer_task_tasks_list_9500.png"))); // NOI18N
        jMenu6.setText("Catálogos");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmPrecios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cash_40532.png"))); // NOI18N
        JmPrecios.setText("Precios");
        JmPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPreciosActionPerformed(evt);
            }
        });
        jMenu6.add(JmPrecios);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/User_Group-80_icon-icons.com_57247.png"))); // NOI18N
        jMenuItem1.setText("Clientes");
        jMenu6.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/package_box_10801.png"))); // NOI18N
        jMenuItem2.setText("Almacénes");
        jMenu6.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/courses_letters_blackboard_board_staff_book_1475.png"))); // NOI18N
        jMenuItem3.setText("Conceptos");
        jMenu6.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/zapato.png"))); // NOI18N
        jMenuItem4.setText("Productos");
        jMenu6.add(jMenuItem4);

        JmProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/money-care_116477.png"))); // NOI18N
        JmProveedor.setText("Proveedores");
        JmProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProveedorActionPerformed(evt);
            }
        });
        jMenu6.add(JmProveedor);

        JmCPT.add(jMenu6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486564168-finance-bank-check_81495.png"))); // NOI18N
        jMenu1.setText("Facturación");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486564168-finance-bank-check_81495.png"))); // NOI18N
        jMenuItem10.setText("Facturación");
        jMenu1.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        jMenuItem11.setText("Refacturación");
        jMenu1.add(jMenuItem11);

        JmCPT.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/move_23058.png"))); // NOI18N
        jMenu2.setText("Movimientos");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/BagOK_icon-icons.com_51210.png"))); // NOI18N
        jMenuItem7.setText("Entradas");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Bagcancel_icon-icons.com_51212.png"))); // NOI18N
        jMenuItem8.setText("Salidas");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Refresh_36729.png"))); // NOI18N
        jMenuItem9.setText("Devoluciones");
        jMenu2.add(jMenuItem9);

        JmCPT.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Shopping-icon_30277.png"))); // NOI18N
        jMenu3.setText("Pedidos");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmCancelación.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCancelación.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JmCancelación.setText("Cancelación");
        jMenu3.add(JmCancelación);

        JmPedidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Shopping-icon_30277.png"))); // NOI18N
        JmPedidos.setText("Pedidos");
        JmPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedidosActionPerformed(evt);
            }
        });
        jMenu3.add(JmPedidos);

        JmReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/travel_journey_icon-icons.com_55995.png"))); // NOI18N
        JmReportes.setText("Planeación");
        JmReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmReportesActionPerformed(evt);
            }
        });
        jMenu3.add(JmReportes);

        JmCPT.add(jMenu3);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Data_Meter4_37237.png"))); // NOI18N
        jMenu8.setText("Reportes");
        jMenu8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Data_Meter4_37237.png"))); // NOI18N
        jMenuItem12.setText("Reportes");
        jMenu8.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486564180-finance-financial-report_81493.png"))); // NOI18N
        jMenuItem13.setText("Existencias");
        jMenu8.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/check-form_116472.png"))); // NOI18N
        jMenuItem14.setText("Kardex");
        jMenu8.add(jMenuItem14);

        JmCPT.add(jMenu8);

        jMenuBar1.add(JmCPT);

        JmConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cogregular_106332.png"))); // NOI18N
        JmConfig.setText("Configuración");
        JmConfig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/safety_reader_card_10784.png"))); // NOI18N
        JmUsuario.setText("Control de Acceso");
        JmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmUsuarioActionPerformed(evt);
            }
        });
        JmConfig.add(JmUsuario);

        jMenuBar1.add(JmConfig);

        JmProduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/42498factory_99134.png"))); // NOI18N
        JmProduccion.setText("Producción");
        JmProduccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/korganizer_task_tasks_list_9500.png"))); // NOI18N
        jMenu7.setText("Catálogo");

        JmAlmacenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmAlmacenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ForkliftTruck_Loaded_Black_icon-icons.com_54893.png"))); // NOI18N
        JmAlmacenes.setText("Almacenes");
        JmAlmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAlmacenesActionPerformed(evt);
            }
        });
        jMenu7.add(JmAlmacenes);

        JmColores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmColores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/RGB_Circle_1-80_icon-icons.com_57282.png"))); // NOI18N
        JmColores.setText("Colores");
        JmColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmColoresActionPerformed(evt);
            }
        });
        jMenu7.add(JmColores);

        JmCorridas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCorridas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Numbers512_44201.png"))); // NOI18N
        JmCorridas.setText("Corridas");
        JmCorridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCorridasActionPerformed(evt);
            }
        });
        jMenu7.add(JmCorridas);

        JmCostos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/chart-1_111423.png"))); // NOI18N
        JmCostos.setText("Costos");
        JmCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCostosActionPerformed(evt);
            }
        });
        jMenu7.add(JmCostos);

        JmLineas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmLineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/organizer_calendar_pen_note_6134.png"))); // NOI18N
        JmLineas.setText("Lineas");
        JmLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmLineasActionPerformed(evt);
            }
        });
        jMenu7.add(JmLineas);

        JmGastos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/money_dollar_cash_coins_riches_wealth_icon-icons.com_53585.png"))); // NOI18N
        JmGastos.setText("Gastos");
        JmGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmGastosActionPerformed(evt);
            }
        });
        jMenu7.add(JmGastos);

        JmMateriales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmMateriales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/box_full_products_14639.png"))); // NOI18N
        JmMateriales.setText("Materiales");
        JmMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaterialesActionPerformed(evt);
            }
        });
        jMenu7.add(JmMateriales);

        JmProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Vans_Sundown_Black_37299.png"))); // NOI18N
        JmProductos.setText("Productos");
        JmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProductosActionPerformed(evt);
            }
        });
        jMenu7.add(JmProductos);

        JmMoldes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmMoldes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/suela.png"))); // NOI18N
        JmMoldes.setText("Moldes");
        JmMoldes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMoldesActionPerformed(evt);
            }
        });
        jMenu7.add(JmMoldes);

        JmProduccion.add(jMenu7);

        jMenuBar1.add(JmProduccion);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/File_Explorer_23583.png"))); // NOI18N
        jMenu4.setText("Archivo");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1492616984-13-setting-configure-repair-support-optimization-google_83419.png"))); // NOI18N
        JmAyuda.setText("Soporte");
        jMenu4.add(JmAyuda);

        JmSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit_closethesession_close_6317.png"))); // NOI18N
        JmSalir.setText("Salir ");
        JmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSalirActionPerformed(evt);
            }
        });
        jMenu4.add(JmSalir);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainContent)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainContent)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadProducto() {
        if (productos == null) {
            productos = new Productos();
            MainContent.add(productos);
            MainContent.getDesktopManager().maximizeFrame(productos);
            productos.setVisible(true);
        } else {
            productos.dispose();
            productos = new Productos();
            MainContent.add(productos);
            MainContent.getDesktopManager().maximizeFrame(productos);
            productos.setVisible(true);
        }
    }

    private void LoadAgente() {
        if (agente == null) {
            agente = new Agentes();
            MainContent.add(agente);
            MainContent.getDesktopManager().maximizeFrame(agente);
            agente.setVisible(true);
        } else {
            agente.dispose();
            agente = new Agentes();
            MainContent.add(agente);
            MainContent.getDesktopManager().maximizeFrame(agente);
            agente.setVisible(true);
        }
    }

    private void LoadBanco() {
        if (banco == null) {
            banco = new Bancos();
            MainContent.add(banco);
            MainContent.getDesktopManager().maximizeFrame(banco);
            banco.setVisible(true);
        } else {
            banco.dispose();
            banco = new Bancos();
            MainContent.add(banco);
            MainContent.getDesktopManager().maximizeFrame(banco);
            banco.setVisible(true);
        }
    }

    private void LoadCiudad() {
        if (ciudad == null) {
            ciudad = new Ciudades();
            MainContent.add(ciudad);
            MainContent.getDesktopManager().maximizeFrame(ciudad);
            ciudad.setVisible(true);
        } else {
            ciudad.dispose();
            ciudad = new Ciudades();
            MainContent.add(ciudad);
            MainContent.getDesktopManager().maximizeFrame(ciudad);
            ciudad.setVisible(true);
        }
    }

    private void LoadEstado() {
        if (estado == null) {
            estado = new Estados();
            MainContent.add(estado);
            MainContent.getDesktopManager().maximizeFrame(estado);
            estado.setVisible(true);
        } else {
            estado.dispose();
            estado = new Estados();
            MainContent.add(estado);
            MainContent.getDesktopManager().maximizeFrame(estado);
            estado.setVisible(true);
        }
    }

    private void LoadPais() {
        if (pais == null) {
            pais = new Paises();
            MainContent.add(pais);
            MainContent.getDesktopManager().maximizeFrame(pais);
            pais.setVisible(true);
        } else {
            pais.dispose();
            pais = new Paises();
            MainContent.add(pais);
            MainContent.getDesktopManager().maximizeFrame(pais);
            pais.setVisible(true);
        }
    }

    private void LoadZona() {
        if (zona == null) {
            zona = new Zonas();
            MainContent.add(zona);
            MainContent.getDesktopManager().maximizeFrame(zona);
            zona.setVisible(true);
        } else {
            zona.dispose();
            zona = new Zonas();
            MainContent.add(zona);
            MainContent.getDesktopManager().maximizeFrame(zona);
            zona.setVisible(true);
        }
    }

    private void LoadCliente() {
        if (cliente == null) {
            cliente = new Clientes();
            MainContent.add(cliente);
            MainContent.getDesktopManager().maximizeFrame(cliente);
            cliente.setVisible(true);
        } else {
            cliente.dispose();
            cliente = new Clientes();
            MainContent.add(cliente);
            MainContent.getDesktopManager().maximizeFrame(cliente);
            cliente.setVisible(true);
        }
    }

    private void LoadColor() {
        if (color == null) {
            color = new Colores();
            MainContent.add(color);
            MainContent.getDesktopManager().maximizeFrame(color);
            color.setVisible(true);
        } else {
            color.dispose();
            color = new Colores();
            MainContent.add(color);
            MainContent.getDesktopManager().maximizeFrame(color);
            color.setVisible(true);
        }
    }

    private void LoadCorrida() {
        if (corrida == null) {
            corrida = new Corridas();
            MainContent.add(corrida);
            MainContent.getDesktopManager().maximizeFrame(corrida);
            corrida.setVisible(true);
        } else {
            corrida.dispose();
            corrida = new Corridas();
            MainContent.add(corrida);
            MainContent.getDesktopManager().maximizeFrame(corrida);
            corrida.setVisible(true);
        }
    }

    private void LoadLinea() {
        if (linea == null) {
            linea = new Lineas();
            MainContent.add(linea);
            MainContent.getDesktopManager().maximizeFrame(linea);
            linea.setVisible(true);
        } else {
            linea.dispose();
            linea = new Lineas();
            MainContent.add(linea);
            MainContent.getDesktopManager().maximizeFrame(linea);
            linea.setVisible(true);
        }
    }

    private void LoadCosto() {
        if (costo == null) {
            costo = new Costos();
            MainContent.add(costo);
            MainContent.getDesktopManager().maximizeFrame(costo);
            costo.setVisible(true);
        } else {
            costo.dispose();
            costo = new Costos();
            MainContent.add(costo);
            MainContent.getDesktopManager().maximizeFrame(costo);
            costo.setVisible(true);
        }
    }

    private void LoadGasto() {
        if (gasto == null) {
            gasto = new Gastos();
            MainContent.add(gasto);
            MainContent.getDesktopManager().maximizeFrame(gasto);
            gasto.setVisible(true);
        } else {
            gasto.dispose();
            gasto = new Gastos();
            MainContent.add(gasto);
            MainContent.getDesktopManager().maximizeFrame(gasto);
            gasto.setVisible(true);
        }
    }

    private void LoadAlmacen() {
        if (almacen == null) {
            almacen = new Almacenes();
            MainContent.add(almacen);
            MainContent.getDesktopManager().maximizeFrame(almacen);
            almacen.setVisible(true);
        } else {
            almacen.dispose();
            almacen = new Almacenes();
            MainContent.add(almacen);
            MainContent.getDesktopManager().maximizeFrame(almacen);
            almacen.setVisible(true);
        }
    }

    private void LoadMaterial() {
        if (material == null) {
            material = new Materiales();
            MainContent.add(material);
            MainContent.getDesktopManager().maximizeFrame(material);
            material.setVisible(true);
        } else {
            material.dispose();
            material = new Materiales();
            MainContent.add(material);
            MainContent.getDesktopManager().maximizeFrame(material);
            material.setVisible(true);
        }
    }

    private void LoadUsuario() {
        if (usuario == null) {
            usuario = new Usuarios();
            MainContent.add(usuario);
            usuario.IdUs = Integer.parseInt(id_usuario);
            MainContent.getDesktopManager().maximizeFrame(usuario);
            usuario.setVisible(true);
        } else {
            usuario.dispose();
            usuario = new Usuarios();
            MainContent.add(usuario);
            usuario.IdUs = Integer.parseInt(id_usuario);
            MainContent.getDesktopManager().maximizeFrame(usuario);
            usuario.setVisible(true);
        }
    }

    private void LoadPedido() {
        if (pedidos == null) {
            pedidos = new Pedidos();
            MainContent.add(pedidos);
            pedidos.Id_Usuario = Integer.parseInt(id_usuario);
            MainContent.getDesktopManager().maximizeFrame(pedidos);
            pedidos.setVisible(true);
        } else {
            pedidos.dispose();
            pedidos = new Pedidos();
            pedidos.Id_Usuario = Integer.parseInt(id_usuario);
            MainContent.add(pedidos);
            MainContent.getDesktopManager().maximizeFrame(pedidos);
            pedidos.setVisible(true);
        }
    }

    private void LoadPrecio() {
        if (ps == null) {
            ps = new Precios();
            MainContent.add(ps);
            MainContent.getDesktopManager().maximizeFrame(ps);
            ps.setVisible(true);
        } else {
            ps.dispose();
            ps = new Precios();
            MainContent.add(ps);
            MainContent.getDesktopManager().maximizeFrame(ps);
            ps.setVisible(true);
        }
    }

    private void LoadProgramacion() {
        if (pr == null) {
            pr = new frmPlaneacion();
            MainContent.add(pr);
            MainContent.getDesktopManager().maximizeFrame(pr);
            pr.setVisible(true);
        } else {
            pr.dispose();
            pr = new frmPlaneacion();
            MainContent.add(pr);
            MainContent.getDesktopManager().maximizeFrame(pr);
            pr.setVisible(true);
        }
    }
    private void LoadMolde(){
            m = new Moldes();
            MainContent.add(m);
            MainContent.getDesktopManager().maximizeFrame(m);
            m.setVisible(true);
    }
    
    private void LoadProveedor() {
        if (pv == null) {
            pv = new Proveedores();
            MainContent.add(pv);
            MainContent.getDesktopManager().maximizeFrame(pv);
            pv.setVisible(true);
        } else {
            pv.dispose();
            pv = new Proveedores();
            MainContent.add(pv);
            MainContent.getDesktopManager().maximizeFrame(pv);
            pv.setVisible(true);
        }
    }
    private void JmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSalirActionPerformed
        Cerrar();
    }//GEN-LAST:event_JmSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JmBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBancoActionPerformed
        LoadBanco();
    }//GEN-LAST:event_JmBancoActionPerformed

    private void JmColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmColoresActionPerformed
        LoadColor();
    }//GEN-LAST:event_JmColoresActionPerformed

    private void JmCorridasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCorridasActionPerformed
        LoadCorrida();
    }//GEN-LAST:event_JmCorridasActionPerformed

    private void JmProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmProductosActionPerformed
        LoadProducto();
    }//GEN-LAST:event_JmProductosActionPerformed

    private void JmPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPedidosActionPerformed
        LoadPedido();
    }//GEN-LAST:event_JmPedidosActionPerformed

    private void JmGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmGastosActionPerformed
        LoadGasto();
    }//GEN-LAST:event_JmGastosActionPerformed

    private void JmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmClientesActionPerformed
        LoadCliente();
    }//GEN-LAST:event_JmClientesActionPerformed

    private void JmEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEstadosActionPerformed
        LoadEstado();
    }//GEN-LAST:event_JmEstadosActionPerformed

    private void JmAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAgenteActionPerformed
        LoadAgente();
    }//GEN-LAST:event_JmAgenteActionPerformed

    private void JmCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCiudadActionPerformed
        LoadCiudad();
    }//GEN-LAST:event_JmCiudadActionPerformed

    private void JmPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPaisActionPerformed
        LoadPais();
    }//GEN-LAST:event_JmPaisActionPerformed

    private void JmZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmZonaActionPerformed
        LoadZona();
    }//GEN-LAST:event_JmZonaActionPerformed

    private void JmLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmLineasActionPerformed
        LoadLinea();
    }//GEN-LAST:event_JmLineasActionPerformed

    private void JmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmUsuarioActionPerformed
        LoadUsuario();
    }//GEN-LAST:event_JmUsuarioActionPerformed

    private void JmPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPreciosActionPerformed
        LoadPrecio();
    }//GEN-LAST:event_JmPreciosActionPerformed

    private void jMenuBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuBar1KeyPressed

    }//GEN-LAST:event_jMenuBar1KeyPressed

    private void JmCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCostosActionPerformed
        LoadCosto();
    }//GEN-LAST:event_JmCostosActionPerformed

    private void JmMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaterialesActionPerformed
        LoadMaterial();
    }//GEN-LAST:event_JmMaterialesActionPerformed

    private void JmAlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAlmacenesActionPerformed
        LoadAlmacen();
    }//GEN-LAST:event_JmAlmacenesActionPerformed

    private void JmReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmReportesActionPerformed
        LoadProgramacion();
    }//GEN-LAST:event_JmReportesActionPerformed

    private void JmMoldesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMoldesActionPerformed
        LoadMolde();
    }//GEN-LAST:event_JmMoldesActionPerformed

    private void JmProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmProveedorActionPerformed
       LoadProveedor();
    }//GEN-LAST:event_JmProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JbFecha;
    public javax.swing.JLabel JbHora;
    public javax.swing.JLabel JbRol;
    private javax.swing.JLabel JbUser;
    private javax.swing.JMenuItem JmAgente;
    private javax.swing.JMenuItem JmAlmacenes;
    private javax.swing.JMenuItem JmAyuda;
    private javax.swing.JMenuItem JmBanco;
    private javax.swing.JMenu JmCPT;
    private javax.swing.JMenuItem JmCancelación;
    private javax.swing.JMenuItem JmCiudad;
    private javax.swing.JMenuItem JmClientes;
    private javax.swing.JMenu JmCobranza;
    private javax.swing.JMenuItem JmColores;
    private javax.swing.JMenu JmConfig;
    private javax.swing.JMenuItem JmCorridas;
    private javax.swing.JMenuItem JmCostos;
    private javax.swing.JMenuItem JmEstados;
    private javax.swing.JMenuItem JmGastos;
    private javax.swing.JMenuItem JmLineas;
    private javax.swing.JMenuItem JmMateriales;
    private javax.swing.JMenuItem JmMoldes;
    private javax.swing.JMenuItem JmPais;
    private javax.swing.JMenuItem JmPedidos;
    private javax.swing.JMenuItem JmPrecios;
    private javax.swing.JMenu JmProduccion;
    private javax.swing.JMenuItem JmProductos;
    private javax.swing.JMenuItem JmProveedor;
    private javax.swing.JMenuItem JmReportes;
    private javax.swing.JMenuItem JmSalir;
    private javax.swing.JMenuItem JmUsuario;
    private javax.swing.JMenuItem JmZona;
    private javax.swing.JDesktopPane MainContent;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
