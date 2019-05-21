package ViewLayer;

import ObjectLayer.Copiaarchivo;
import ObjectLayer.Hora;
import ObjectLayer.ObjectVersioning;
import ObjectLayer.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
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
    AlmacenesRcpt almacenR;
    frmPlaneacion pr;
    double precioa;
    double preciob;
    String id_usuario = "";
    String UsuarioChat = "";
    String User = "";
    Moldes m;
    Proveedores pv;
    PlaneacionPhy phy;
    Consumos sumos;
    Etiquetas etiq;
    Entradas entrada;
    public String Estado = "A";

    Maquinas maq;
    
    ImageIcon notificacion = new ImageIcon("C:\\tsmanager\\imagenes\\push.png");
    ImageIcon campana = new ImageIcon("C:\\tsmanager\\imagenes\\bell.png");

    public Principal() {
        initComponents();
    }

    public Principal(Usuario us) {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/programa.png"));
        setIconImage(icon);
        popprod.add(JmProduccion);
        popcpt.add(JmCPT);
        popcobranza.add(JmCobranza);

        popopciones.add(JmConfig);
        popopciones.add(JmSalir);
        JbUser.setText(us.getNombre());
        JbRol.setText(us.getDepartamento());
        this.us = us;
        LoadVersion();
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
        }else if(us.getDepartamento().equals("PRODUCCIONCPT")){
            JmCobranza.setVisible(false);
            JmConfig.setVisible(false);
            Jmcatcpt.setVisible(false);
            Jmfaccpt.setVisible(false);
            Jmpedcpt.setVisible(false);
            Jmcatprod.setVisible(false);
            cobranza.setVisible(false);
            nominas.setVisible(false);
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

        JmCobranza = new javax.swing.JMenu();
        JmCatalogocobranza = new javax.swing.JMenu();
        JmAgente = new javax.swing.JMenuItem();
        JmBanco = new javax.swing.JMenuItem();
        JmCiudad = new javax.swing.JMenuItem();
        JmClientes = new javax.swing.JMenuItem();
        JmEstados = new javax.swing.JMenuItem();
        JmPais = new javax.swing.JMenuItem();
        JmZona = new javax.swing.JMenuItem();
        JmCPT = new javax.swing.JMenu();
        Jmcatcpt = new javax.swing.JMenu();
        JmPrecios = new javax.swing.JMenuItem();
        JmClientescpt = new javax.swing.JMenuItem();
        JmAlmacenescpt = new javax.swing.JMenuItem();
        JmConceptoscpt = new javax.swing.JMenuItem();
        JmProductoscpt = new javax.swing.JMenuItem();
        JmProveedor = new javax.swing.JMenuItem();
        Jmfaccpt = new javax.swing.JMenu();
        JmFacturacionfac = new javax.swing.JMenuItem();
        JmFacturacionrefac = new javax.swing.JMenuItem();
        Jmmovcpt = new javax.swing.JMenu();
        JmEntradascpt = new javax.swing.JMenuItem();
        JmSalidascpt = new javax.swing.JMenuItem();
        JmDevolucionescpt = new javax.swing.JMenuItem();
        Jmpedcpt = new javax.swing.JMenu();
        JmCancelación = new javax.swing.JMenuItem();
        JmPedidos = new javax.swing.JMenuItem();
        JmReportes = new javax.swing.JMenuItem();
        Jmrepcpt = new javax.swing.JMenu();
        JmReportescpt = new javax.swing.JMenuItem();
        JmExistenciascpt = new javax.swing.JMenuItem();
        JmKardexcpt = new javax.swing.JMenuItem();
        JmInventariofcpt = new javax.swing.JMenuItem();
        JmConfig = new javax.swing.JMenu();
        JmUsuario = new javax.swing.JMenuItem();
        JmProduccion = new javax.swing.JMenu();
        Jmcatprod = new javax.swing.JMenu();
        JmAlmacenes = new javax.swing.JMenuItem();
        JmColores = new javax.swing.JMenuItem();
        JmCorridas = new javax.swing.JMenuItem();
        JmCostos = new javax.swing.JMenuItem();
        JmLineas = new javax.swing.JMenuItem();
        JmGastos = new javax.swing.JMenuItem();
        JmMateriales = new javax.swing.JMenuItem();
        JmProductos = new javax.swing.JMenuItem();
        JmMoldes = new javax.swing.JMenuItem();
        JmMaquinas = new javax.swing.JMenuItem();
        JmConsumos = new javax.swing.JMenuItem();
        Jmutilprod = new javax.swing.JMenu();
        Jmetiqprod = new javax.swing.JMenuItem();
        JmOpciones = new javax.swing.JMenu();
        JmAyuda = new javax.swing.JMenuItem();
        JmSalir = new javax.swing.JMenuItem();
        popprod = new javax.swing.JPopupMenu();
        popcpt = new javax.swing.JPopupMenu();
        popcobranza = new javax.swing.JPopupMenu();
        popnomina = new javax.swing.JPopupMenu();
        popopciones = new javax.swing.JPopupMenu();
        MainContent = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JbUser = new javax.swing.JLabel();
        JbRol = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JbAlerta = new javax.swing.JLabel();
        cpt = new javax.swing.JLabel();
        cobranza = new javax.swing.JLabel();
        nominas = new javax.swing.JLabel();
        prod = new javax.swing.JLabel();

        JmCobranza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/propagation_calculator_calc_6110.png"))); // NOI18N
        JmCobranza.setText("Cobranza");
        JmCobranza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmCatalogocobranza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/korganizer_task_tasks_list_9500.png"))); // NOI18N
        JmCatalogocobranza.setText("Catálgo");
        JmCatalogocobranza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmAgente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/customer_person_people_woman_you_1627.png"))); // NOI18N
        JmAgente.setText("Agentes");
        JmAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAgenteActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmAgente);

        JmBanco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bank_78392.png"))); // NOI18N
        JmBanco.setText("Banco");
        JmBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBancoActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmBanco);

        JmCiudad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Citycons_building_icon-icons.com_67935.png"))); // NOI18N
        JmCiudad.setText("Ciudad");
        JmCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCiudadActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmCiudad);

        JmClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/manager_person_man_people_2841.png"))); // NOI18N
        JmClientes.setText("Clientes");
        JmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmClientesActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmClientes);

        JmEstados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmEstados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1-51_icon-icons.com_68849.png"))); // NOI18N
        JmEstados.setText("Estados");
        JmEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEstadosActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmEstados);

        JmPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mexico_flags_flag_17036.png"))); // NOI18N
        JmPais.setText("País");
        JmPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPaisActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmPais);

        JmZona.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmZona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/if-traveling-icon-flat-outline09-3405110_107375.png"))); // NOI18N
        JmZona.setText("Zona");
        JmZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmZonaActionPerformed(evt);
            }
        });
        JmCatalogocobranza.add(JmZona);

        JmCobranza.add(JmCatalogocobranza);

        JmCPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1562683-branding-card-pencil-profile_107062.png"))); // NOI18N
        JmCPT.setText("CPT");
        JmCPT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Jmcatcpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/korganizer_task_tasks_list_9500.png"))); // NOI18N
        Jmcatcpt.setText("Catálogos");
        Jmcatcpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmPrecios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cash_40532.png"))); // NOI18N
        JmPrecios.setText("Precios");
        JmPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPreciosActionPerformed(evt);
            }
        });
        Jmcatcpt.add(JmPrecios);

        JmClientescpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmClientescpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/User_Group-80_icon-icons.com_57247.png"))); // NOI18N
        JmClientescpt.setText("Clientes");
        Jmcatcpt.add(JmClientescpt);

        JmAlmacenescpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmAlmacenescpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/package_box_10801.png"))); // NOI18N
        JmAlmacenescpt.setText("Almacénes");
        JmAlmacenescpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAlmacenescptActionPerformed(evt);
            }
        });
        Jmcatcpt.add(JmAlmacenescpt);

        JmConceptoscpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmConceptoscpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/courses_letters_blackboard_board_staff_book_1475.png"))); // NOI18N
        JmConceptoscpt.setText("Conceptos");
        Jmcatcpt.add(JmConceptoscpt);

        JmProductoscpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmProductoscpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/zapato.png"))); // NOI18N
        JmProductoscpt.setText("Productos");
        Jmcatcpt.add(JmProductoscpt);

        JmProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/money-care_116477.png"))); // NOI18N
        JmProveedor.setText("Proveedores");
        JmProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProveedorActionPerformed(evt);
            }
        });
        Jmcatcpt.add(JmProveedor);

        JmCPT.add(Jmcatcpt);

        Jmfaccpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486564168-finance-bank-check_81495.png"))); // NOI18N
        Jmfaccpt.setText("Facturación");
        Jmfaccpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmFacturacionfac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmFacturacionfac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmFacturacionfac.setText("Facturación");
        Jmfaccpt.add(JmFacturacionfac);

        JmFacturacionrefac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmFacturacionrefac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmFacturacionrefac.setText("Refacturación");
        Jmfaccpt.add(JmFacturacionrefac);

        JmCPT.add(Jmfaccpt);

        Jmmovcpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/move_23058.png"))); // NOI18N
        Jmmovcpt.setText("Movimientos");
        Jmmovcpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmEntradascpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmEntradascpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/BagOK_icon-icons.com_51210.png"))); // NOI18N
        JmEntradascpt.setText("Entradas");
        JmEntradascpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEntradascptActionPerformed(evt);
            }
        });
        Jmmovcpt.add(JmEntradascpt);

        JmSalidascpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmSalidascpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Bagcancel_icon-icons.com_51212.png"))); // NOI18N
        JmSalidascpt.setText("Salidas");
        Jmmovcpt.add(JmSalidascpt);

        JmDevolucionescpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmDevolucionescpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Refresh_36729.png"))); // NOI18N
        JmDevolucionescpt.setText("Devoluciones");
        Jmmovcpt.add(JmDevolucionescpt);

        JmCPT.add(Jmmovcpt);

        Jmpedcpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Shopping-icon_30277.png"))); // NOI18N
        Jmpedcpt.setText("Pedidos");
        Jmpedcpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmCancelación.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCancelación.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JmCancelación.setText("Cancelación");
        Jmpedcpt.add(JmCancelación);

        JmPedidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Shopping-icon_30277.png"))); // NOI18N
        JmPedidos.setText("Pedidos");
        JmPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedidosActionPerformed(evt);
            }
        });
        Jmpedcpt.add(JmPedidos);

        JmReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/travel_journey_icon-icons.com_55995.png"))); // NOI18N
        JmReportes.setText("Planeación");
        JmReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmReportesActionPerformed(evt);
            }
        });
        Jmpedcpt.add(JmReportes);

        JmCPT.add(Jmpedcpt);

        Jmrepcpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Data_Meter4_37237.png"))); // NOI18N
        Jmrepcpt.setText("Reportes");
        Jmrepcpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmReportescpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmReportescpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Data_Meter4_37237.png"))); // NOI18N
        JmReportescpt.setText("Reportes");
        Jmrepcpt.add(JmReportescpt);

        JmExistenciascpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmExistenciascpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1486564180-finance-financial-report_81493.png"))); // NOI18N
        JmExistenciascpt.setText("Existencias");
        Jmrepcpt.add(JmExistenciascpt);

        JmKardexcpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmKardexcpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/check-form_116472.png"))); // NOI18N
        JmKardexcpt.setText("Kardex");
        Jmrepcpt.add(JmKardexcpt);

        JmInventariofcpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmInventariofcpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/applicationvnd_103607.png"))); // NOI18N
        JmInventariofcpt.setText("Inventario Fisico");
        JmInventariofcpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmInventariofcptActionPerformed(evt);
            }
        });
        Jmrepcpt.add(JmInventariofcpt);

        JmCPT.add(Jmrepcpt);

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

        JmProduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/42498factory_99134.png"))); // NOI18N
        JmProduccion.setText("Producción");
        JmProduccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Jmcatprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/korganizer_task_tasks_list_9500.png"))); // NOI18N
        Jmcatprod.setText("Catálogo");
        Jmcatprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmcatprodMouseClicked(evt);
            }
        });
        Jmcatprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmcatprodActionPerformed(evt);
            }
        });

        JmAlmacenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmAlmacenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ForkliftTruck_Loaded_Black_icon-icons.com_54893.png"))); // NOI18N
        JmAlmacenes.setText("Almacenes");
        JmAlmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAlmacenesActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmAlmacenes);

        JmColores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmColores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/RGB_Circle_1-80_icon-icons.com_57282.png"))); // NOI18N
        JmColores.setText("Colores");
        JmColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmColoresActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmColores);

        JmCorridas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCorridas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Numbers512_44201.png"))); // NOI18N
        JmCorridas.setText("Corridas");
        JmCorridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCorridasActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmCorridas);

        JmCostos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/chart-1_111423.png"))); // NOI18N
        JmCostos.setText("Costos");
        JmCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCostosActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmCostos);

        JmLineas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmLineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/organizer_calendar_pen_note_6134.png"))); // NOI18N
        JmLineas.setText("Lineas");
        JmLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmLineasActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmLineas);

        JmGastos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/money_dollar_cash_coins_riches_wealth_icon-icons.com_53585.png"))); // NOI18N
        JmGastos.setText("Gastos");
        JmGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmGastosActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmGastos);

        JmMateriales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmMateriales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/box_full_products_14639.png"))); // NOI18N
        JmMateriales.setText("Materiales");
        JmMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaterialesActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmMateriales);

        JmProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Vans_Sundown_Black_37299.png"))); // NOI18N
        JmProductos.setText("Productos");
        JmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProductosActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmProductos);

        JmMoldes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmMoldes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/suela.png"))); // NOI18N
        JmMoldes.setText("Moldes");
        JmMoldes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMoldesActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmMoldes);

        JmMaquinas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmMaquinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/machine.png"))); // NOI18N
        JmMaquinas.setText("Maquinas");
        JmMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaquinasActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmMaquinas);

        JmConsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JmConsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/medida.png"))); // NOI18N
        JmConsumos.setText("Consumos");
        JmConsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmConsumosActionPerformed(evt);
            }
        });
        Jmcatprod.add(JmConsumos);

        JmProduccion.add(Jmcatprod);

        Jmutilprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/utileria.png"))); // NOI18N
        Jmutilprod.setText("Utilerias");

        Jmetiqprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/etiqueta.png"))); // NOI18N
        Jmetiqprod.setText("Generador de Etiquetas");
        Jmetiqprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmetiqprodActionPerformed(evt);
            }
        });
        Jmutilprod.add(Jmetiqprod);

        JmProduccion.add(Jmutilprod);

        JmOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/File_Explorer_23583.png"))); // NOI18N
        JmOpciones.setText("Archivo");
        JmOpciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JmAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1492616984-13-setting-configure-repair-support-optimization-google_83419.png"))); // NOI18N
        JmAyuda.setText("Soporte");
        JmOpciones.add(JmAyuda);

        JmSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit_closethesession_close_6317.png"))); // NOI18N
        JmSalir.setText("Salir ");
        JmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSalirActionPerformed(evt);
            }
        });
        JmOpciones.add(JmSalir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOP-SUELAS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MainContent.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        JbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbUser.setForeground(new java.awt.Color(255, 255, 255));
        JbUser.setText("jLabel2");

        JbRol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbRol.setForeground(new java.awt.Color(255, 255, 255));
        JbRol.setText("jLabel2");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/opcion.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/females_female_avatar_woman_people_faces_18406.png"))); // NOI18N

        JbAlerta.setForeground(new java.awt.Color(0, 255, 0));
        JbAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/62794bell_109308.png"))); // NOI18N
        JbAlerta.setText("A");
        JbAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JbAlertaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JbUser)
                .addGap(44, 44, 44)
                .addComponent(JbRol)
                .addGap(31, 31, 31)
                .addComponent(JbAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbUser)
                            .addComponent(JbRol)
                            .addComponent(JbAlerta)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cpt.png"))); // NOI18N
        cpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cptMouseClicked(evt);
            }
        });

        cobranza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cobranza.png"))); // NOI18N
        cobranza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cobranzaMouseClicked(evt);
            }
        });

        nominas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nomina.png"))); // NOI18N
        nominas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nominasMouseClicked(evt);
            }
        });

        prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/produccion.png"))); // NOI18N
        prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nominas, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127)
                .addComponent(cpt, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addGap(138, 138, 138)
                .addComponent(cobranza, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prod, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(cobranza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpt, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addComponent(nominas, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        MainContent.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(MainContent);
        MainContent.setLayout(MainContentLayout);
        MainContentLayout.setHorizontalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1439, Short.MAX_VALUE)
        );
        MainContentLayout.setVerticalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );

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

    private void LoadInFisico() {
        if (phy == null) {
            phy = new PlaneacionPhy(us);
            MainContent.add(phy);
            MainContent.getDesktopManager().maximizeFrame(phy);
            phy.setVisible(true);
        } else {
            phy.dispose();
            phy = new PlaneacionPhy(us);
            MainContent.add(phy);
            MainContent.getDesktopManager().maximizeFrame(phy);
            phy.setVisible(true);
        }
    }
    
    private void LoadInAlmacenRcpt() {
        if (almacenR == null) {
            almacenR = new AlmacenesRcpt();
            MainContent.add(almacenR);
            MainContent.getDesktopManager().maximizeFrame(almacenR);
            almacenR.setVisible(true);
        } else {
            almacenR.dispose();
            almacenR = new AlmacenesRcpt();
            MainContent.add(almacenR);
            MainContent.getDesktopManager().maximizeFrame(almacenR);
            almacenR.setVisible(true);
        }
    }
    
    private void LoadEntradas(){
        if(entrada == null){
            entrada = new Entradas();
            MainContent.add(entrada);
            MainContent.getDesktopManager().maximizeFrame(entrada);
            entrada.setVisible(true);
        }else {
            entrada.dispose();
            entrada = new Entradas();
            MainContent.add(entrada);
            MainContent.getDesktopManager().maximizeFrame(entrada);
            entrada.setVisible(true);
        }
    }

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
            pedidos.JbSerie.setText(Estado);
            MainContent.getDesktopManager().maximizeFrame(pedidos);
            pedidos.setVisible(true);
        } else {
            pedidos.dispose();
            pedidos = new Pedidos();
            pedidos.Id_Usuario = Integer.parseInt(id_usuario);
            pedidos.JbSerie.setText(Estado);
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

    private void LoadMolde() {
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

    private void LoadMaquina() {
        maq = new Maquinas();
        MainContent.add(maq);
        MainContent.getDesktopManager().maximizeFrame(maq);
        maq.setVisible(true);
    }

    private void LoadConsumo() {
        sumos = new Consumos();
        MainContent.add(sumos);
        MainContent.getDesktopManager().maximizeFrame(sumos);
        sumos.setVisible(true);
    }

    private void LoadEtiqueta() {
        etiq = new Etiquetas(null, true);
        etiq.setVisible(true);

    }

    private void LoadVersion() {
        try {
            Copiaarchivo ca = new Copiaarchivo();
            ca.start();
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el uso de un directorio para copia de archivos \n" + e.getMessage(), "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
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

    private void JmcatprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmcatprodActionPerformed

    }//GEN-LAST:event_JmcatprodActionPerformed

    private void JmcatprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmcatprodMouseClicked

    }//GEN-LAST:event_JmcatprodMouseClicked

    private void prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodMouseClicked
        popprod.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_prodMouseClicked

    private void cptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cptMouseClicked
        popcpt.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_cptMouseClicked

    private void cobranzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cobranzaMouseClicked
        popcobranza.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_cobranzaMouseClicked

    private void nominasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nominasMouseClicked
        popnomina.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_nominasMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        popopciones.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JmInventariofcptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmInventariofcptActionPerformed
        LoadInFisico();
    }//GEN-LAST:event_JmInventariofcptActionPerformed

    private void JmConsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmConsumosActionPerformed
        LoadConsumo();
    }//GEN-LAST:event_JmConsumosActionPerformed

    private void JmetiqprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmetiqprodActionPerformed
        LoadEtiqueta();
    }//GEN-LAST:event_JmetiqprodActionPerformed

    private void JbAlertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbAlertaMousePressed

        if (evt.getClickCount() > 1) {
            JbAlerta.setText("B");
            JbAlerta.setForeground(Color.red);
            Estado = "B";
            JbAlerta.setIcon(notificacion);
        } else {
            JbAlerta.setText("A");
            JbAlerta.setForeground(Color.green);
            JbAlerta.setIcon(campana);
            Estado = "A";
        }
    }//GEN-LAST:event_JbAlertaMousePressed

    private void JmEntradascptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEntradascptActionPerformed
        LoadEntradas();
    }//GEN-LAST:event_JmEntradascptActionPerformed

    private void JmAlmacenescptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAlmacenescptActionPerformed
       LoadInAlmacenRcpt();
    }//GEN-LAST:event_JmAlmacenescptActionPerformed
    private void JmMaquinasActionPerformed(java.awt.event.ActionEvent evt) {
        LoadMaquina();
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
    private javax.swing.JLabel JbAlerta;
    public javax.swing.JLabel JbRol;
    private javax.swing.JLabel JbUser;
    private javax.swing.JMenuItem JmAgente;
    private javax.swing.JMenuItem JmAlmacenes;
    private javax.swing.JMenuItem JmAlmacenescpt;
    private javax.swing.JMenuItem JmAyuda;
    private javax.swing.JMenuItem JmBanco;
    private javax.swing.JMenu JmCPT;
    private javax.swing.JMenuItem JmCancelación;
    private javax.swing.JMenu JmCatalogocobranza;
    private javax.swing.JMenuItem JmCiudad;
    private javax.swing.JMenuItem JmClientes;
    private javax.swing.JMenuItem JmClientescpt;
    private javax.swing.JMenu JmCobranza;
    private javax.swing.JMenuItem JmColores;
    private javax.swing.JMenuItem JmConceptoscpt;
    private javax.swing.JMenu JmConfig;
    private javax.swing.JMenuItem JmConsumos;
    private javax.swing.JMenuItem JmCorridas;
    private javax.swing.JMenuItem JmCostos;
    private javax.swing.JMenuItem JmDevolucionescpt;
    private javax.swing.JMenuItem JmEntradascpt;
    private javax.swing.JMenuItem JmEstados;
    private javax.swing.JMenuItem JmExistenciascpt;
    private javax.swing.JMenuItem JmFacturacionfac;
    private javax.swing.JMenuItem JmFacturacionrefac;
    private javax.swing.JMenuItem JmGastos;
    private javax.swing.JMenuItem JmInventariofcpt;
    private javax.swing.JMenuItem JmKardexcpt;
    private javax.swing.JMenuItem JmLineas;
    private javax.swing.JMenuItem JmMaquinas;
    private javax.swing.JMenuItem JmMateriales;
    private javax.swing.JMenuItem JmMoldes;
    private javax.swing.JMenu JmOpciones;
    private javax.swing.JMenuItem JmPais;
    private javax.swing.JMenuItem JmPedidos;
    private javax.swing.JMenuItem JmPrecios;
    private javax.swing.JMenu JmProduccion;
    private javax.swing.JMenuItem JmProductos;
    private javax.swing.JMenuItem JmProductoscpt;
    private javax.swing.JMenuItem JmProveedor;
    private javax.swing.JMenuItem JmReportes;
    private javax.swing.JMenuItem JmReportescpt;
    private javax.swing.JMenuItem JmSalidascpt;
    private javax.swing.JMenuItem JmSalir;
    private javax.swing.JMenuItem JmUsuario;
    private javax.swing.JMenuItem JmZona;
    private javax.swing.JMenu Jmcatcpt;
    private javax.swing.JMenu Jmcatprod;
    private javax.swing.JMenuItem Jmetiqprod;
    private javax.swing.JMenu Jmfaccpt;
    private javax.swing.JMenu Jmmovcpt;
    private javax.swing.JMenu Jmpedcpt;
    private javax.swing.JMenu Jmrepcpt;
    private javax.swing.JMenu Jmutilprod;
    private javax.swing.JDesktopPane MainContent;
    private javax.swing.JLabel cobranza;
    private javax.swing.JLabel cpt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nominas;
    private javax.swing.JPopupMenu popcobranza;
    private javax.swing.JPopupMenu popcpt;
    private javax.swing.JPopupMenu popnomina;
    private javax.swing.JPopupMenu popopciones;
    private javax.swing.JPopupMenu popprod;
    private javax.swing.JLabel prod;
    // End of variables declaration//GEN-END:variables
}
