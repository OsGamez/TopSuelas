package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Infisico;
import ObjectLayer.ObjectAlmacenes;
import ObjectLayer.ObjectInfisico;
import ObjectLayer.ObjectRCPT;
import ObjectLayer.PtProducto;
import ObjectLayer.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class PlaneacionPhy extends javax.swing.JInternalFrame {

    ObjectRCPT obj = new ObjectRCPT();
    ObjectAlmacenes am = new ObjectAlmacenes();
    ObjectInfisico objF = new ObjectInfisico();
    Connection c = Server.getRcpt();
    int cont = 1, cc = 0;
    public String User;

    String data[];

    File fichero = new File("C:\\InvFisico\\datos.txt");//Archivo usado para guardar y leer los datos, con ruta 

    int Cantidad = 0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;

    DefaultTableModel modelPhylon = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultListModel<PtProducto> modeloListaRCPT = new DefaultListModel<PtProducto>();

    public PlaneacionPhy() {
        /*initComponents();
        OcultarCampos();
        LoadColumns();
        //LoadModelPhy();
        LeerDatos();
        System.out.println(User);
        JtPhylon.getTableHeader().setReorderingAllowed(false);
        JbGenerar.setToolTipText("CREAR PDF");
        JbGuardar.setToolTipText("GUARDAR EN INVENTARIO");
        JbClean.setToolTipText("LIMPIAR CAPTURA");
        JbRemove.setToolTipText("QUITAR SUELA");*/
    }

    public PlaneacionPhy(Usuario us) {
        initComponents();
        OcultarCampos();
        LoadColumns();
        LeerDatos();
        User = us.getUsuario();
        JtPhylon.getTableHeader().setReorderingAllowed(false);
        JbGenerar.setToolTipText("CREAR PDF");
        JbGuardar.setToolTipText("GUARDAR EN INVENTARIO");
        JbClean.setToolTipText("LIMPIAR CAPTURA");
        JbRemove.setToolTipText("QUITAR SUELA");

    }

    private void LoadColumns() {
        modelPhylon.addColumn("NO");
        modelPhylon.addColumn("CÓDIGO");
        modelPhylon.addColumn("SUELA");
        modelPhylon.addColumn("ALMACEN");
        modelPhylon.addColumn("ESTILO");
        modelPhylon.addColumn("CORRIDA");
        modelPhylon.addColumn("COMBINACIÓN");
        modelPhylon.addColumn("TIPO");
        modelPhylon.addColumn("C1");
        modelPhylon.addColumn("C2");
        modelPhylon.addColumn("C3");
        modelPhylon.addColumn("C4");
        modelPhylon.addColumn("C5");
        modelPhylon.addColumn("C6");
        modelPhylon.addColumn("C7");
        modelPhylon.addColumn("C8");
        modelPhylon.addColumn("C9");
        modelPhylon.addColumn("C10");
        modelPhylon.addColumn("C11");
        modelPhylon.addColumn("C12");
        modelPhylon.addColumn("C13");
        modelPhylon.addColumn("C14");
        modelPhylon.addColumn("PARES");

        JtPhylon.getColumnModel().getColumn(0).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(0).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(0).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(1).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(1).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(1).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(4).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(4).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(4).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(5).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(5).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(5).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(6).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(6).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(6).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(7).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(7).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(7).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JtAm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JtProducto = new javax.swing.JTextField();
        JlDescripcion = new javax.swing.JLabel();
        JlPares = new javax.swing.JLabel();
        JtPares = new javax.swing.JTextField();
        JbRemove = new javax.swing.JButton();
        JbClean = new javax.swing.JButton();
        JbGenerar = new javax.swing.JButton();
        JbGuardar = new javax.swing.JButton();
        JlCombinacion = new javax.swing.JLabel();
        JlEstilo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtPhylon = new javax.swing.JTable();
        JtCorrida = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRCPT = new javax.swing.JList<>();
        JbPt = new javax.swing.JLabel();
        Psuelas = new javax.swing.JPanel();
        Jb1 = new javax.swing.JLabel();
        Jb6 = new javax.swing.JLabel();
        Jb2 = new javax.swing.JLabel();
        Jb3 = new javax.swing.JLabel();
        Jb4 = new javax.swing.JLabel();
        Jb5 = new javax.swing.JLabel();
        Jt2 = new javax.swing.JTextField();
        Jt1 = new javax.swing.JTextField();
        Jt5 = new javax.swing.JTextField();
        Jt4 = new javax.swing.JTextField();
        Jt3 = new javax.swing.JTextField();
        Jt6 = new javax.swing.JTextField();
        Jt7 = new javax.swing.JTextField();
        Jb7 = new javax.swing.JLabel();
        Jt8 = new javax.swing.JTextField();
        Jb8 = new javax.swing.JLabel();
        Jt9 = new javax.swing.JTextField();
        Jb9 = new javax.swing.JLabel();
        Jt10 = new javax.swing.JTextField();
        Jb10 = new javax.swing.JLabel();
        Jt11 = new javax.swing.JTextField();
        Jb11 = new javax.swing.JLabel();
        Jt12 = new javax.swing.JTextField();
        Jb12 = new javax.swing.JLabel();
        Jt13 = new javax.swing.JTextField();
        Jb13 = new javax.swing.JLabel();
        Jt14 = new javax.swing.JTextField();
        Jb14 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Almacén:");

        JtAm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtAmKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Suela:");

        JtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtProductoKeyTyped(evt);
            }
        });

        JlDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlDescripcion.setText("jLabel3");

        JlPares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlPares.setText("Pares:");

        JtPares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtParesKeyPressed(evt);
            }
        });

        JbRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/crosscircleregular_106260.png"))); // NOI18N
        JbRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbRemoveActionPerformed(evt);
            }
        });

        JbClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/iconfinder-trash-4341321_120557.png"))); // NOI18N
        JbClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCleanActionPerformed(evt);
            }
        });

        JbGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGenerarActionPerformed(evt);
            }
        });

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/datainboth_directions_transfer_arrow_3091.png"))); // NOI18N
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        JlCombinacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlCombinacion.setText("3");

        JlEstilo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlEstilo.setText("1");

        JtPhylon.setModel(modelPhylon);
        JtPhylon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtPhylonKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JtPhylon);

        listaRCPT.setModel(modeloListaRCPT);
        listaRCPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRCPTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaRCPT);

        JbPt.setText("jLabel3");

        Psuelas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jb1.setText("L1");
        Psuelas.add(Jb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, -1, -1));

        Jb6.setText("L1");
        Psuelas.add(Jb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 12, -1, -1));

        Jb2.setText("L1");
        Psuelas.add(Jb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 12, -1, -1));

        Jb3.setText("L1");
        Psuelas.add(Jb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 12, -1, -1));

        Jb4.setText("L1");
        Psuelas.add(Jb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 12, -1, -1));

        Jb5.setText("L1");
        Psuelas.add(Jb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 12, -1, -1));

        Jt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt2KeyPressed(evt);
            }
        });
        Psuelas.add(Jt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 6, 54, -1));

        Jt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt1KeyPressed(evt);
            }
        });
        Psuelas.add(Jt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 6, 54, -1));

        Jt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt5KeyPressed(evt);
            }
        });
        Psuelas.add(Jt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 6, 54, -1));

        Jt4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt4KeyPressed(evt);
            }
        });
        Psuelas.add(Jt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 6, 54, -1));

        Jt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt3KeyPressed(evt);
            }
        });
        Psuelas.add(Jt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 6, 54, -1));

        Jt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt6KeyPressed(evt);
            }
        });
        Psuelas.add(Jt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 6, 54, -1));

        Jt7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt7KeyPressed(evt);
            }
        });
        Psuelas.add(Jt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 6, 54, -1));

        Jb7.setText("L1");
        Psuelas.add(Jb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 12, -1, -1));

        Jt8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt8KeyPressed(evt);
            }
        });
        Psuelas.add(Jt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 6, 54, -1));

        Jb8.setText("L1");
        Psuelas.add(Jb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(758, 12, -1, -1));

        Jt9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt9KeyPressed(evt);
            }
        });
        Psuelas.add(Jt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 6, 54, -1));

        Jb9.setText("L1");
        Psuelas.add(Jb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(874, 12, -1, -1));

        Jt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt10KeyPressed(evt);
            }
        });
        Psuelas.add(Jt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 55, 54, -1));

        Jb10.setText("L1");
        Psuelas.add(Jb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, -1, -1));

        Jt11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt11KeyPressed(evt);
            }
        });
        Psuelas.add(Jt11, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 55, 54, -1));

        Jb11.setText("L1");
        Psuelas.add(Jb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 61, -1, -1));

        Jt12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt12KeyPressed(evt);
            }
        });
        Psuelas.add(Jt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 55, 54, -1));

        Jb12.setText("L1");
        Psuelas.add(Jb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 61, -1, -1));

        Jt13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt13KeyPressed(evt);
            }
        });
        Psuelas.add(Jt13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 55, 54, -1));

        Jb13.setText("L1");
        Psuelas.add(Jb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 61, -1, -1));

        Jt14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt14KeyPressed(evt);
            }
        });
        Psuelas.add(Jt14, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 55, 54, -1));

        Jb14.setText("L1");
        Psuelas.add(Jb14, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 61, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(JlPares)
                        .addGap(12, 12, 12)
                        .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(JbPt)
                        .addGap(29, 29, 29)
                        .addComponent(JlEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(JtCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(JlCombinacion)
                        .addGap(42, 42, 42)
                        .addComponent(JlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Psuelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(JbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(JbClean, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(JbGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(JtCorrida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JlPares)
                                .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JbPt)
                            .addComponent(JlEstilo)
                            .addComponent(JlCombinacion)
                            .addComponent(JlDescripcion))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Psuelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbRemove)
                    .addComponent(JbClean)
                    .addComponent(JbGenerar)
                    .addComponent(JbGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarRegistro() {
        switch (User) {
            case "oswaldo":
                Borrar();
                break;
            case "nazaret":
                BorrarN();
                break;
            case "kim":
                BorrarK();
                break;
            case "lupita":
                Borrar();
            default:
                break;
        }
    }

    private void JtAmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtAmKeyPressed
        ArrayList<PtProducto> listaA = obj.getPhyAlmacen(JtAm.getText());

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JtAm.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ingresaste un numero de almacén");
            } else {
                if (listaA.size() > 0) {
                    JtProducto.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Este almacén no existe");
                }
            }
        }
    }//GEN-LAST:event_JtAmKeyPressed

    private void JtParesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtParesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (JtPares.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ingresaste una cantidad");
            } else {
                ValidarCorrida();
                Jt1.requestFocus();
            }
        }
    }//GEN-LAST:event_JtParesKeyPressed

    private void JbCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCleanActionPerformed
        int row = JtPhylon.getRowCount();

        if (row > 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de limpiar los registros?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                //EliminarRegistro();
                //CleanTable();
                //VaciarDatos();
                JOptionPane.showMessageDialog(null, "Se han limpiado los registros");
                JtAm.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros");
            JtAm.requestFocus();
        }
    }//GEN-LAST:event_JbCleanActionPerformed

    private void Borrar() {
        objF.deleteDatos();
    }

    private void BorrarN() {
        objF.deleteDatosN();
    }

    private void BorrarK() {
        objF.deleteDatosK();
    }

    private boolean ValidarDetalle() {
        if (this.JtPhylon.getRowCount() == 0 && this.JtPhylon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No hay suelas", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            JtAm.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void JbRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbRemoveActionPerformed
        int row = JtPhylon.getSelectedRow();

        if (row >= 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres omitir este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                modelPhylon.removeRow(row);
                JtAm.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
        }
    }//GEN-LAST:event_JbRemoveActionPerformed

    private void JtPhylonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtPhylonKeyReleased
        if (evt.getExtendedKeyCode() == KeyEvent.VK_F12) {
            int row = JtPhylon.getSelectedRow();
            String Cant1 = (String) modelPhylon.getValueAt(row, 6);
            String Cant2 = (String) modelPhylon.getValueAt(row, 7);
            String Cant3 = (String) modelPhylon.getValueAt(row, 8);
            String Cant4 = (String) modelPhylon.getValueAt(row, 9);
            String Cant5 = (String) modelPhylon.getValueAt(row, 10);
            String Cant6 = (String) modelPhylon.getValueAt(row, 11);
            String Corrida = (String) modelPhylon.getValueAt(row, 4);

            JTextField C1 = new JTextField(4);
            JTextField C2 = new JTextField(4);
            JTextField C3 = new JTextField(4);
            JTextField C4 = new JTextField(4);
            JTextField C5 = new JTextField(4);
            JTextField C6 = new JTextField(4);

            C1.setText("0");
            C2.setText("0");
            C3.setText("0");
            C4.setText("0");
            C5.setText("0");
            C6.setText("0");
            JPanel Editar = new JPanel();

            switch (Corrida) {
                case "80":
                    Editar.add(new JLabel("10:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("11:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("12:"));
                    Editar.add(C3);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "81":
                    Editar.add(new JLabel("13:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("14:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("15:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("16:"));
                    Editar.add(C4);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "82":
                    Editar.add(new JLabel("27:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("28:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("29:"));
                    Editar.add(C3);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "85":
                    Editar.add(new JLabel("11:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("12:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("13:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("14:"));
                    Editar.add(C4);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "88":
                    Editar.add(new JLabel("22:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("23:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("24:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("25:"));
                    Editar.add(C4);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("26:"));
                    Editar.add(C5);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("27:"));
                    Editar.add(C6);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    C5.setSelectionStart(0);
                    C6.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "89":
                    Editar.add(new JLabel("12:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("13:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("14:"));
                    Editar.add(C3);
                    JtAm.requestFocus();
                    break;
                case "90":
                    Editar.add(new JLabel("15:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("16:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("17:"));
                    Editar.add(C3);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "91":
                    Editar.add(new JLabel("18:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("19:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("20:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("21:"));
                    Editar.add(C4);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "92":
                    Editar.add(new JLabel("22:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("23:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("24:"));
                    Editar.add(C3);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "93":
                    C1.requestFocus();
                    Editar.add(new JLabel("22:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("23:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("24:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("25:"));
                    Editar.add(C4);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("26:"));
                    Editar.add(C5);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    C5.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "94":
                    Editar.add(new JLabel("25:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("26:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("27:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("28:"));
                    Editar.add(C4);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("29:"));
                    Editar.add(C5);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("30:"));
                    Editar.add(C6);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    C5.setSelectionStart(0);
                    C6.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "95":
                    Editar.add(new JLabel("21:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("22:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("23:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("24:"));
                    Editar.add(C4);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("25:"));
                    Editar.add(C5);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    C5.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "96":
                    Editar.add(new JLabel("30:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("31:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("32:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("33:"));
                    Editar.add(C4);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "97":
                    Editar.add(new JLabel("17:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("18:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("19:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("20:"));
                    Editar.add(C4);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("21:"));
                    Editar.add(C5);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    C5.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                case "98":
                    Editar.add(new JLabel("23:"));
                    Editar.add(C1);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("24:"));
                    Editar.add(C2);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("25:"));
                    Editar.add(C3);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("26:"));
                    Editar.add(C4);
                    Editar.add(Box.createHorizontalStrut(15)); // a spacer
                    Editar.add(new JLabel("27:"));
                    Editar.add(C5);
                    C1.setSelectionStart(0);
                    C2.setSelectionStart(0);
                    C3.setSelectionStart(0);
                    C4.setSelectionStart(0);
                    C5.setSelectionStart(0);
                    JtAm.requestFocus();
                    break;
                default:
                    break;
            }
            Object[] options = {"ACEPTAR", "CANCELAR"};

            int result = JOptionPane.showOptionDialog(null, Editar,
                    "Ingresa los valores", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, null);

            if (result == JOptionPane.OK_OPTION) {

                int nc1 = Integer.parseInt(Cant1) + Integer.parseInt(C1.getText());
                int nc2 = Integer.parseInt(Cant2) + Integer.parseInt(C2.getText());
                int nc3 = Integer.parseInt(Cant3) + Integer.parseInt(C3.getText());
                int nc4 = Integer.parseInt(Cant4) + Integer.parseInt(C4.getText());
                int nc5 = Integer.parseInt(Cant5) + Integer.parseInt(C5.getText());
                int nc6 = Integer.parseInt(Cant6) + Integer.parseInt(C6.getText());
                int Sum = nc1 + nc2 + nc3 + nc4 + nc5 + nc6;

                modelPhylon.setValueAt(String.valueOf(nc1), row, 6);
                modelPhylon.setValueAt(String.valueOf(nc2), row, 7);
                modelPhylon.setValueAt(String.valueOf(nc3), row, 8);
                modelPhylon.setValueAt(String.valueOf(nc4), row, 9);
                modelPhylon.setValueAt(String.valueOf(nc5), row, 10);
                modelPhylon.setValueAt(String.valueOf(nc6), row, 11);
                modelPhylon.setValueAt(String.valueOf(Sum), row, 20);
            }
        }
    }//GEN-LAST:event_JtPhylonKeyReleased

    private void JbGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGenerarActionPerformed
        //Generar();

        switch (User) {
            case "oswaldo":
                Generar();
                break;
            case "nazaret":
                GenerarN();
                break;
            case "kim":
                GenerarK();
                break;
            case "lupita":
                Generar();
            default:
                break;
        }
    }//GEN-LAST:event_JbGenerarActionPerformed

    private void Generar() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.validarInv() == 0) {
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 1));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 22));

                    Infisico inv = new Infisico();
                    inv.setProducto(Pt);
                    inv.setAlmacen(Am);
                    inv.setEstilo(Est);
                    inv.setCorrida(Corr);
                    inv.setCombinacion(Comb);
                    inv.setTipo(tipo);
                    inv.setPto1(Pto1);
                    inv.setPto2(Pto2);
                    inv.setPto3(Pto3);
                    inv.setPto4(Pto4);
                    inv.setPto5(Pto5);
                    inv.setPto6(Pto6);
                    inv.setPto7(Pto7);
                    inv.setPto8(Pto8);
                    inv.setPto9(Pto9);
                    inv.setPto10(Pto10);
                    inv.setPto11(Pto11);
                    inv.setPto12(Pto12);
                    inv.setPto13(Pto13);
                    inv.setPto14(Pto14);
                    inv.setTotalPares(Tpares);

                    if (objF.AddInventarioCopy(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            } else {
                Borrar();
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 1));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 22));

                    Infisico inv = new Infisico();
                    inv.setProducto(Pt);
                    inv.setAlmacen(Am);
                    inv.setEstilo(Est);
                    inv.setCorrida(Corr);
                    inv.setCombinacion(Comb);
                    inv.setTipo(tipo);
                    inv.setPto1(Pto1);
                    inv.setPto2(Pto2);
                    inv.setPto3(Pto3);
                    inv.setPto4(Pto4);
                    inv.setPto5(Pto5);
                    inv.setPto6(Pto6);
                    inv.setPto7(Pto7);
                    inv.setPto8(Pto8);
                    inv.setPto9(Pto9);
                    inv.setPto10(Pto10);
                    inv.setPto11(Pto11);
                    inv.setPto12(Pto12);
                    inv.setPto13(Pto13);
                    inv.setPto14(Pto14);
                    inv.setTotalPares(Tpares);

                    if (objF.AddInventarioCopy(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            }
        }
        if (ms == "OK") {
            Reporte();
        } else if (ms == "ERROR") {
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void GenerarN() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.validarInvN() == 0) {
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 1));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 22));

                    Infisico inv = new Infisico();
                    inv.setProducto(Pt);
                    inv.setAlmacen(Am);
                    inv.setEstilo(Est);
                    inv.setCorrida(Corr);
                    inv.setCombinacion(Comb);
                    inv.setTipo(tipo);
                    inv.setPto1(Pto1);
                    inv.setPto2(Pto2);
                    inv.setPto3(Pto3);
                    inv.setPto4(Pto4);
                    inv.setPto5(Pto5);
                    inv.setPto6(Pto6);
                    inv.setPto7(Pto7);
                    inv.setPto8(Pto8);
                    inv.setPto9(Pto9);
                    inv.setPto10(Pto10);
                    inv.setPto11(Pto11);
                    inv.setPto12(Pto12);
                    inv.setPto13(Pto13);
                    inv.setPto14(Pto14);
                    inv.setTotalPares(Tpares);

                    if (objF.AddInventarioCopyN(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            } else {
                BorrarN();
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 1));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 22));

                    Infisico inv = new Infisico();
                    inv.setProducto(Pt);
                    inv.setAlmacen(Am);
                    inv.setEstilo(Est);
                    inv.setCorrida(Corr);
                    inv.setCombinacion(Comb);
                    inv.setTipo(tipo);
                    inv.setPto1(Pto1);
                    inv.setPto2(Pto2);
                    inv.setPto3(Pto3);
                    inv.setPto4(Pto4);
                    inv.setPto5(Pto5);
                    inv.setPto6(Pto6);
                    inv.setPto7(Pto7);
                    inv.setPto8(Pto8);
                    inv.setPto9(Pto9);
                    inv.setPto10(Pto10);
                    inv.setPto11(Pto11);
                    inv.setPto12(Pto12);
                    inv.setPto13(Pto13);
                    inv.setPto14(Pto14);
                    inv.setTotalPares(Tpares);

                    if (objF.AddInventarioCopyN(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            }
        }
        if (ms == "OK") {
            ReporteNS();
        } else if (ms == "ERROR") {
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void GenerarK() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.validarInvK() == 0) {
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 1));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 22));

                    Infisico inv = new Infisico();
                    inv.setProducto(Pt);
                    inv.setAlmacen(Am);
                    inv.setEstilo(Est);
                    inv.setCorrida(Corr);
                    inv.setCombinacion(Comb);
                    inv.setTipo(tipo);
                    inv.setPto1(Pto1);
                    inv.setPto2(Pto2);
                    inv.setPto3(Pto3);
                    inv.setPto4(Pto4);
                    inv.setPto5(Pto5);
                    inv.setPto6(Pto6);
                    inv.setPto7(Pto7);
                    inv.setPto8(Pto8);
                    inv.setPto9(Pto9);
                    inv.setPto10(Pto10);
                    inv.setPto11(Pto11);
                    inv.setPto12(Pto12);
                    inv.setPto13(Pto13);
                    inv.setPto14(Pto14);
                    inv.setTotalPares(Tpares);

                    if (objF.AddInventarioCopyK(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            } else {
                BorrarK();
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 1));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 22));

                    Infisico inv = new Infisico();
                    inv.setProducto(Pt);
                    inv.setAlmacen(Am);
                    inv.setEstilo(Est);
                    inv.setCorrida(Corr);
                    inv.setCombinacion(Comb);
                    inv.setTipo(tipo);
                    inv.setPto1(Pto1);
                    inv.setPto2(Pto2);
                    inv.setPto3(Pto3);
                    inv.setPto4(Pto4);
                    inv.setPto5(Pto5);
                    inv.setPto6(Pto6);
                    inv.setPto7(Pto7);
                    inv.setPto8(Pto8);
                    inv.setPto9(Pto9);
                    inv.setPto10(Pto10);
                    inv.setPto11(Pto11);
                    inv.setPto12(Pto12);
                    inv.setPto13(Pto13);
                    inv.setPto14(Pto14);
                    inv.setTotalPares(Tpares);

                    if (objF.AddInventarioCopyK(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            }
        }
        if (ms == "OK") {
            ReporteKS();
        } else if (ms == "ERROR") {
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void CrearReporte() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            for (int i = 0; i < row; i++) {
                int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 6));
                int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));

                Infisico inv = new Infisico();
                inv.setProducto(Pt);
                inv.setAlmacen(Am);
                inv.setEstilo(Est);
                inv.setCorrida(Corr);
                inv.setCombinacion(Comb);
                inv.setTipo(tipo);
                inv.setPto1(Pto1);
                inv.setPto2(Pto2);
                inv.setPto3(Pto3);
                inv.setPto4(Pto4);
                inv.setPto5(Pto5);
                inv.setPto6(Pto6);
                inv.setPto7(Pto7);
                inv.setPto8(Pto8);
                inv.setPto9(Pto9);
                inv.setPto10(Pto10);
                inv.setPto11(Pto11);
                inv.setPto12(Pto12);
                inv.setPto13(Pto13);
                inv.setPto14(Pto14);
                inv.setTotalPares(Tpares);

                if (objF.AddInventarioCopy(inv)) {
                    ms = "OK";
                } else {
                    ms = "ERROR";
                }
            }
        }
        if (ms == "OK") {

        } else if (ms == "ERROR") {
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        if (ValidarDetalle()) {

            switch (User) {
                case "oswaldo":
                    if (objF.validarInv() == 0) {
                        JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
                    } else {
                        Save();
                    }
                    break;
                case "nazaret":
                    if (objF.validarInvN() == 0) {
                        JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
                    } else {
                        Save();
                    }
                    break;
                case "kim":
                    if (objF.validarInvK() == 0) {
                        JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
                    } else {
                        Save();
                    }
                    break;
                case "lupita":
                    if (objF.validarInv() == 0) {
                        JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
                    } else {
                        Save();
                    }
                default:
                    break;
            }

        }


    }//GEN-LAST:event_JbGuardarActionPerformed

    private void listaRCPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRCPTMouseClicked
        JList lis = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            PtProducto prod = (PtProducto) lis.getSelectedValue();
            JbPt.setText(String.valueOf(prod.getProducto()));
            JlDescripcion.setText(prod.getDescripcion());
            JlEstilo.setText(String.valueOf(prod.getEstilo()));
            JtCorrida.setText(String.valueOf(prod.getCorrida()));
            JlCombinacion.setText(String.valueOf(prod.getCombinacion()));
            limpiarRCPT();
            JtPares.requestFocus();
            JtProducto.setText(prod.getDescripcion());
        }
    }//GEN-LAST:event_listaRCPTMouseClicked

    private void JtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyReleased
        limpiarRCPT();
        if (JtProducto.getText().isEmpty()) {
            limpiarRCPT();
            OcultarCorrida();
            JtPares.setText("");
        } else {
            ArrayList<PtProducto> listaProd = obj.GetByRCPT(JtProducto.getText());

            for (PtProducto prod : listaProd) {
                modeloListaRCPT.addElement(prod);

            }
        }
    }//GEN-LAST:event_JtProductoKeyReleased

    private void JtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtProductoKeyTyped

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        if (this.JtPhylon.getRowCount() == 0 && this.JtPhylon.getSelectedRow() == -1) {
            //NADA
        } else {
            // int opcion = JOptionPane.showConfirmDialog(this, "¿Quires conservar los registros?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            GuardarFichero();
            //if (opcion == JOptionPane.YES_OPTION) {
            //}
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void Jt6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt6KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }

    }//GEN-LAST:event_Jt6KeyPressed

    private void Jt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt5KeyPressed

    private void Jt4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt4KeyPressed

    private void Jt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt3KeyPressed

    private void Jt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt1KeyPressed

    private void Jt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt2KeyPressed

    private void Jt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt7KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt7KeyPressed

    private void Jt8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt8KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt8KeyPressed

    private void Jt9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt9KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt9KeyPressed

    private void Jt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt10KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt10KeyPressed

    private void Jt11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt11KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt11KeyPressed

    private void Jt12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt12KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt12KeyPressed

    private void Jt13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt13KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt13KeyPressed

    private void Jt14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt14KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Agregar();
        }
    }//GEN-LAST:event_Jt14KeyPressed

    private void Agregar() {
        int cantidad = Integer.parseInt(JtPares.getText());
        String Tipo = "S";

        c1 = Integer.parseInt(Jt1.getText());
        c2 = Integer.parseInt(Jt2.getText());
        c3 = Integer.parseInt(Jt3.getText());
        c4 = Integer.parseInt(Jt4.getText());
        c5 = Integer.parseInt(Jt5.getText());
        c6 = Integer.parseInt(Jt6.getText());
        c7 = Integer.parseInt(Jt7.getText());
        c8 = Integer.parseInt(Jt8.getText());
        c9 = Integer.parseInt(Jt9.getText());
        c10 = Integer.parseInt(Jt10.getText());
        c11 = Integer.parseInt(Jt11.getText());
        c12 = Integer.parseInt(Jt12.getText());
        c13 = Integer.parseInt(Jt13.getText());
        c14 = Integer.parseInt(Jt14.getText());

        String datos[] = new String[23];

        if (this.JtPhylon.getRowCount() == 0 && this.JtPhylon.getSelectedRow() == -1) {
            datos[0] = String.valueOf(cont);
            datos[1] = JbPt.getText();
            datos[2] = JlDescripcion.getText();
            datos[3] = JtAm.getText();
            datos[4] = JlEstilo.getText();
            datos[5] = JtCorrida.getText();
            datos[6] = JlCombinacion.getText();
            datos[7] = Tipo;
            datos[8] = Jt1.getText();
            datos[9] = Jt2.getText();
            datos[10] = Jt3.getText();
            datos[11] = Jt4.getText();
            datos[12] = Jt5.getText();
            datos[13] = Jt6.getText();
            datos[14] = Jt7.getText();
            datos[15] = Jt8.getText();
            datos[16] = Jt9.getText();
            datos[17] = Jt10.getText();
            datos[18] = Jt11.getText();
            datos[19] = Jt12.getText();
            datos[20] = Jt13.getText();
            datos[21] = Jt14.getText();
            datos[22] = JtPares.getText();
        } else {
            int index = modelPhylon.getRowCount() - 1;
            String var = JtPhylon.getValueAt(index, 0).toString();
            cc = Integer.parseInt(var) + 1;
            datos[0] = String.valueOf(cc);
            datos[1] = JbPt.getText();
            datos[2] = JlDescripcion.getText();
            datos[3] = JtAm.getText();
            datos[4] = JlEstilo.getText();
            datos[5] = JtCorrida.getText();
            datos[6] = JlCombinacion.getText();
            datos[7] = Tipo;
            datos[8] = Jt1.getText();
            datos[9] = Jt2.getText();
            datos[10] = Jt3.getText();
            datos[11] = Jt4.getText();
            datos[12] = Jt5.getText();
            datos[13] = Jt6.getText();
            datos[14] = Jt7.getText();
            datos[15] = Jt8.getText();
            datos[16] = Jt9.getText();
            datos[17] = Jt10.getText();
            datos[18] = Jt11.getText();
            datos[19] = Jt12.getText();
            datos[20] = Jt13.getText();
            datos[21] = Jt14.getText();
            datos[22] = JtPares.getText();
        }

        if (User.equals("")) {
            
        }

        switch (JtCorrida.getText()) {
            case "80":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "81":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty() || Jt6.getText().isEmpty() || Jt7.getText().isEmpty() || Jt8.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "82":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty()
                        || Jt4.getText().isEmpty() || Jt5.getText().isEmpty() || Jt6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "85":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty() || Jt6.getText().isEmpty() || Jt7.getText().isEmpty() || Jt8.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Jt1.requestFocus();
                    LimpiarTxt();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "88":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty() || Jt6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "89":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "90":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "91":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "92":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "93":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "94":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty() || Jt6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "95":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "96":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "97":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            case "98":
                if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                        || Jt5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos de ingresar");
                } else if (cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10) {
                    modelPhylon.addRow(datos);
                    cont++;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    JtPares.requestFocus();
                    LimpiarTxt();
                }
                break;
            default:
                break;
        }
    }

    private void OcultarCorrida() {
        Jt1.setVisible(false);
        Jt2.setVisible(false);
        Jt3.setVisible(false);
        Jt4.setVisible(false);
        Jt5.setVisible(false);
        Jt6.setVisible(false);
        Jt7.setVisible(false);
        Jt8.setVisible(false);
        Jt9.setVisible(false);
        Jt10.setVisible(false);
        Jt11.setVisible(false);
        Jt12.setVisible(false);
        Jb1.setVisible(false);
        Jb2.setVisible(false);
        Jb3.setVisible(false);
        Jb4.setVisible(false);
        Jb5.setVisible(false);
        Jb6.setVisible(false);
        Jb7.setVisible(false);
        Jb8.setVisible(false);
        Jb9.setVisible(false);
        Jb10.setVisible(false);
        Jb11.setVisible(false);
        Jb12.setVisible(false);
    }

    private void limpiarRCPT() {
        modeloListaRCPT.clear();
    }

    private void Reporte() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InPhylonS.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReporteNS() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InCopyNS.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReporteKS() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InCopyKS.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Guardar() {
        String ms = "";
        CleanTable();

        switch (User) {
            case "oswaldo":
                LoadModelPhy();
                break;
            case "nazaret":
                LoadModelPhyN();
                break;
            case "kim":
                LoadModelPhyK();
                break;
            case "lupita":
                LoadModelPhy();
            default:
                break;
        }

        //LoadModelPhy();
        int row = JtPhylon.getRowCount();
        for (int i = 0; i < row; i++) {
            String pt = JtPhylon.getValueAt(i, 1).toString();
            String am = JtPhylon.getValueAt(i, 3).toString();
            String est = JtPhylon.getValueAt(i, 4).toString();
            String corr = JtPhylon.getValueAt(i, 5).toString();
            String com = JtPhylon.getValueAt(i, 6).toString();
            String Tipo = JtPhylon.getValueAt(i, 7).toString();
            String pt1 = JtPhylon.getValueAt(i, 8).toString();
            String pt2 = JtPhylon.getValueAt(i, 9).toString();
            String pt3 = JtPhylon.getValueAt(i, 10).toString();
            String pt4 = JtPhylon.getValueAt(i, 11).toString();
            String pt5 = JtPhylon.getValueAt(i, 12).toString();
            String pt6 = JtPhylon.getValueAt(i, 13).toString();
            String pt7 = JtPhylon.getValueAt(i, 14).toString();
            String pt8 = JtPhylon.getValueAt(i, 15).toString();
            String pt9 = JtPhylon.getValueAt(i, 16).toString();
            String pt10 = JtPhylon.getValueAt(i, 17).toString();
            String pt11 = JtPhylon.getValueAt(i, 18).toString();
            String pt12 = JtPhylon.getValueAt(i, 19).toString();
            String pt13 = JtPhylon.getValueAt(i, 20).toString();
            String pt14 = JtPhylon.getValueAt(i, 21).toString();
            String tpares = JtPhylon.getValueAt(i, 22).toString();

            int Pt = Integer.parseInt(pt);
            int Am = Integer.parseInt(am);
            int Est = Integer.parseInt(est);
            int Corr = Integer.parseInt(corr);
            int Comb = Integer.parseInt(com);
            int Pto1 = Integer.parseInt(pt1);
            int Pto2 = Integer.parseInt(pt2);
            int Pto3 = Integer.parseInt(pt3);
            int Pto4 = Integer.parseInt(pt4);
            int Pto5 = Integer.parseInt(pt5);
            int Pto6 = Integer.parseInt(pt6);
            int Pto7 = Integer.parseInt(pt7);
            int Pto8 = Integer.parseInt(pt8);
            int Pto9 = Integer.parseInt(pt9);
            int Pto10 = Integer.parseInt(pt10);
            int Pto11 = Integer.parseInt(pt11);
            int Pto12 = Integer.parseInt(pt12);
            int Pto13 = Integer.parseInt(pt13);
            int Pto14 = Integer.parseInt(pt14);
            int Tpares = Integer.parseInt(tpares);

            Infisico inv = new Infisico();
            inv.setProducto(Pt);
            inv.setAlmacen(Am);
            inv.setEstilo(Est);
            inv.setCorrida(Corr);
            inv.setCombinacion(Comb);
            inv.setTipo(Tipo);
            inv.setPto1(Pto1);
            inv.setPto2(Pto2);
            inv.setPto3(Pto3);
            inv.setPto4(Pto4);
            inv.setPto5(Pto5);
            inv.setPto6(Pto6);
            inv.setPto7(Pto7);
            inv.setPto8(Pto8);
            inv.setPto9(Pto9);
            inv.setPto10(Pto10);
            inv.setPto11(Pto11);
            inv.setPto12(Pto12);
            inv.setPto13(Pto13);
            inv.setPto14(Pto14);
            inv.setTotalPares(Tpares);

            if (objF.AddInventario(inv)) {
                ms = "OK";
            } else {
                ms = "ERROR";
            }
        }

        switch (User) {
            case "oswaldo":
                if ("OK".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Se han agregado los registros al inventario!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CleanTable();
                    //Borrar();
                    //VaciarDatos();
                } else if ("ERROR".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    //CleanTable();
                    //Borrar();
                }
                break;
            case "nazaret":
                if ("OK".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Se han agregado los registros al inventario!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CleanTable();
                    BorrarN();
                    VaciarDatos();
                } else if ("ERROR".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    //CleanTable();
                    //BorrarN();
                }
                break;
            case "kim":
                if ("OK".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Se han agregado los registros al inventario!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CleanTable();
                    BorrarK();
                    VaciarDatos();
                } else if ("ERROR".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CleanTable();
                    //BorrarK();
                }
                break;
            case "lupita":
                if ("OK".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Se han agregado los registros al inventario!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CleanTable();
                    Borrar();
                    VaciarDatos();
                } else if ("ERROR".equals(ms)) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    CleanTable();
                    //Borrar();
                }
            default:
                break;
        }

    }

    private void Save() {
        switch (User) {
            case "oswaldo":
                ReporteGroup();
                break;
            case "nazaret":
                ReporteGroupN();
                break;
            case "kim":
                ReporteGroupK();
                break;
            case "lupita":
                ReporteGroup();
            default:
                break;
        }
    }

    private void ReporteGroup() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InPhylon.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        if (JOptionPane.showConfirmDialog(null, new Object[]{"Quiere guardar las suelas en el inventario?"}, "JOPtion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                            Guardar();
                        }
                    }
                });
            } catch (JRException ex) {
                Logger.getLogger(Bancos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReporteGroupK() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InCopyK.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        if (JOptionPane.showConfirmDialog(null, new Object[]{"Quiere guardar las suelas en el inventario?"}, "JOPtion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                            Guardar();
                        }
                    }
                });
            } catch (JRException ex) {
                Logger.getLogger(Bancos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReporteGroupN() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InCopyN.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        if (JOptionPane.showConfirmDialog(null, new Object[]{"Quiere guardar las suelas en el inventario?"}, "JOPtion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                            Guardar();
                        }
                    }
                });
            } catch (JRException ex) {
                Logger.getLogger(Bancos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(PlaneacionPhy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }

    private void LimpiarTxt() {
        Jt1.setText("0");
        Jt2.setText("0");
        Jt3.setText("0");
        Jt4.setText("0");
        Jt5.setText("0");
        Jt6.setText("0");
        Jt7.setText("0");
        Jt8.setText("0");
        Jt9.setText("0");
        Jt10.setText("0");
        Jt11.setText("0");
        Jt12.setText("0");
        Jt13.setText("0");
        Jt14.setText("0");
    }

    private void OcultarCampos() {
        JlDescripcion.setVisible(false);
        JlEstilo.setVisible(false);
        JtCorrida.setVisible(false);
        JlCombinacion.setVisible(false);
        JbPt.setVisible(false);
        Jt1.setVisible(false);
        Jt2.setVisible(false);
        Jt3.setVisible(false);
        Jt4.setVisible(false);
        Jt5.setVisible(false);
        Jt6.setVisible(false);
        Jt7.setVisible(false);
        Jt8.setVisible(false);
        Jt9.setVisible(false);
        Jt10.setVisible(false);
        Jt11.setVisible(false);
        Jt12.setVisible(false);
        Jt13.setVisible(false);
        Jt14.setVisible(false);
        Jb1.setVisible(false);
        Jb2.setVisible(false);
        Jb3.setVisible(false);
        Jb4.setVisible(false);
        Jb5.setVisible(false);
        Jb6.setVisible(false);
        Jb7.setVisible(false);
        Jb8.setVisible(false);
        Jb9.setVisible(false);
        Jb10.setVisible(false);
        Jb11.setVisible(false);
        Jb12.setVisible(false);
        Jb13.setVisible(false);
        Jb14.setVisible(false);
    }

    private void ValidarCorrida() {

        Jt1.setText("0");
        Jt2.setText("0");
        Jt3.setText("0");
        Jt4.setText("0");
        Jt5.setText("0");
        Jt6.setText("0");
        Jt7.setText("0");
        Jt8.setText("0");
        Jt9.setText("0");
        Jt10.setText("0");
        Jt11.setText("0");
        Jt12.setText("0");
        Jt13.setText("0");
        Jt14.setText("0");

        switch (JtCorrida.getText()) {
            case "80":
                Jb1.setText("10:");
                Jb2.setText("10.5:");
                Jb3.setText("11:");
                Jb4.setText("11.5:");
                Jb5.setText("12:");
                Jb6.setText("12.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                break;
            case "81":
                Jb1.setText("13:");
                Jb2.setText("13.5:");
                Jb3.setText("14:");
                Jb4.setText("14.5:");
                Jb5.setText("15:");
                Jb6.setText("15.5:");
                Jb7.setText("16:");
                Jb8.setText("16.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                break;
            case "82":
                Jb1.setText("27:");
                Jb2.setText("27.5:");
                Jb3.setText("28:");
                Jb4.setText("28.5:");
                Jb5.setText("29:");
                Jb6.setText("29.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb3.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                break;
            case "85":
                Jb1.setText("11:");
                Jb2.setText("11.5:");
                Jb3.setText("12:");
                Jb4.setText("12.5:");
                Jb4.setText("13:");
                Jb4.setText("13.5:");
                Jb4.setText("14:");
                Jb4.setText("14.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                break;
            case "88":
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb7.setText("25:");
                Jb8.setText("25.5:");
                Jb9.setText("26:");
                Jb10.setText("26.5:");
                Jb11.setText("27:");
                Jb12.setText("27.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jb9.setVisible(true);
                Jb10.setVisible(true);
                Jb11.setVisible(true);
                Jb12.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt9.setSelectionStart(0);
                Jt10.setSelectionStart(0);
                Jt11.setSelectionStart(0);
                Jt12.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                Jt9.setVisible(true);
                Jt10.setVisible(true);
                Jt11.setVisible(true);
                Jt12.setVisible(true);
                break;
            case "89":
                Jb1.setText("12:");
                Jb2.setText("12.5:");
                Jb3.setText("13:");
                Jb4.setText("13.5:");
                Jb5.setText("14:");
                Jb6.setText("14.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                break;
            case "90":
                Jb1.setText("15:");
                Jb2.setText("15.5:");
                Jb3.setText("16:");
                Jb4.setText("16.5:");
                Jb5.setText("17:");
                Jb6.setText("17.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                break;
            case "91":
                Jb1.setText("18:");
                Jb2.setText("18.5:");
                Jb3.setText("19:");
                Jb4.setText("19.5:");
                Jb5.setText("20:");
                Jb6.setText("20.5:");
                Jb7.setText("21:");
                Jb8.setText("21.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                break;
            case "92":
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                break;
            case "93":
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb7.setText("25:");
                Jb8.setText("25.5:");
                Jb9.setText("26:");
                Jb10.setText("26.5:");
                Jt1.requestFocus();
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jb9.setVisible(true);
                Jb10.setVisible(true);
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt9.setSelectionStart(0);
                Jt10.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                Jt9.setVisible(true);
                Jt10.setVisible(true);
                break;
            case "94":
                Jb1.setText("25:");
                Jb2.setText("25.5:");
                Jb3.setText("26:");
                Jb4.setText("26.5:");
                Jb5.setText("27:");
                Jb6.setText("27.5:");
                Jb7.setText("28:");
                Jb8.setText("28.5:");
                Jb9.setText("29:");
                Jb10.setText("29.5:");
                Jb11.setText("30:");
                Jb12.setText("30.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jb9.setVisible(true);
                Jb10.setVisible(true);
                Jb11.setVisible(true);
                Jb12.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt9.setSelectionStart(0);
                Jt10.setSelectionStart(0);
                Jt11.setSelectionStart(0);
                Jt12.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                Jt9.setVisible(true);
                Jt10.setVisible(true);
                Jt11.setVisible(true);
                Jt12.setVisible(true);
                break;
            case "95":
                Jb1.setText("21:");
                Jb2.setText("21.5:");
                Jb3.setText("22:");
                Jb4.setText("22.5:");
                Jb5.setText("23:");
                Jb6.setText("23.5:");
                Jb7.setText("24:");
                Jb8.setText("24.5:");
                Jb9.setText("25:");
                Jb10.setText("25.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jb9.setVisible(true);
                Jb10.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt9.setSelectionStart(0);
                Jt10.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                Jt9.setVisible(true);
                Jt10.setVisible(true);
                break;
            case "96":
                Jb1.setText("30:");
                Jb2.setText("30.5:");
                Jb3.setText("31:");
                Jb4.setText("31.5:");
                Jb5.setText("32:");
                Jb6.setText("32.5:");
                Jb7.setText("33:");
                Jb8.setText("33.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                break;
            case "97":
                Jb1.setText("17:");
                Jb2.setText("17.5:");
                Jb3.setText("18:");
                Jb4.setText("18.5:");
                Jb5.setText("19:");
                Jb6.setText("19.5:");
                Jb7.setText("20:");
                Jb8.setText("20.5:");
                Jb9.setText("21:");
                Jb10.setText("21.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jb9.setVisible(true);
                Jb10.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt9.setSelectionStart(0);
                Jt10.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                Jt9.setVisible(true);
                Jt10.setVisible(true);
                break;
            case "98":
                Jb1.setText("23:");
                Jb2.setText("23.5:");
                Jb3.setText("24:");
                Jb4.setText("24.5:");
                Jb5.setText("25:");
                Jb6.setText("25.5:");
                Jb7.setText("26:");
                Jb8.setText("26.5:");
                Jb9.setText("27:");
                Jb10.setText("27.5:");
                Jb1.setVisible(true);
                Jb2.setVisible(true);
                Jb3.setVisible(true);
                Jb4.setVisible(true);
                Jb5.setVisible(true);
                Jb6.setVisible(true);
                Jb7.setVisible(true);
                Jb8.setVisible(true);
                Jb9.setVisible(true);
                Jb10.setVisible(true);
                Jt1.requestFocus();
                Jt1.setSelectionStart(0);
                Jt2.setSelectionStart(0);
                Jt3.setSelectionStart(0);
                Jt4.setSelectionStart(0);
                Jt5.setSelectionStart(0);
                Jt6.setSelectionStart(0);
                Jt7.setSelectionStart(0);
                Jt8.setSelectionStart(0);
                Jt9.setSelectionStart(0);
                Jt10.setSelectionStart(0);
                Jt1.setVisible(true);
                Jt2.setVisible(true);
                Jt3.setVisible(true);
                Jt4.setVisible(true);
                Jt5.setVisible(true);
                Jt6.setVisible(true);
                Jt7.setVisible(true);
                Jt8.setVisible(true);
                Jt9.setVisible(true);
                Jt10.setVisible(true);
                break;
            default:
                break;
        }
    }

    private void Limpiar() {
        JtAm.setText("");
        JtCorrida.setText("");
        JtProducto.setText("");
        JtPares.setText("");
        JtAm.requestFocus();
        JbPt.setVisible(false);
        Jt1.setVisible(false);
        Jt2.setVisible(false);
        Jt3.setVisible(false);
        Jt4.setVisible(false);
        Jt5.setVisible(false);
        Jt6.setVisible(false);
        Jt7.setVisible(false);
        Jt8.setVisible(false);
        Jt9.setVisible(false);
        Jt10.setVisible(false);
        Jt11.setVisible(false);
        Jt12.setVisible(false);
        Jb1.setVisible(false);
        Jb2.setVisible(false);
        Jb3.setVisible(false);
        Jb4.setVisible(false);
        Jb5.setVisible(false);
        Jb6.setVisible(false);
        Jb7.setVisible(false);
        Jb8.setVisible(false);
        Jb9.setVisible(false);
        Jb10.setVisible(false);
        Jb11.setVisible(false);
        Jb12.setVisible(false);
    }

    private void CleanTable() {
        int row = modelPhylon.getRowCount();
        if (row > 0) {
            for (int i = row - 1; i >= 0; i--) {
                modelPhylon.removeRow(i);
            }
        }
    }

    private void LoadModelPhy() {
        ArrayList<Infisico> listaInv = objF.InvGetAll();

        modelPhylon.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelPhylon.setValueAt(inv.getProducto(), i, 1);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 3);
            modelPhylon.setValueAt(inv.getEstilo(), i, 4);
            modelPhylon.setValueAt(inv.getCorrida(), i, 5);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 6);
            modelPhylon.setValueAt(inv.getTipo(), i, 7);
            modelPhylon.setValueAt(inv.getPto1(), i, 8);
            modelPhylon.setValueAt(inv.getPto2(), i, 9);
            modelPhylon.setValueAt(inv.getPto3(), i, 10);
            modelPhylon.setValueAt(inv.getPto4(), i, 11);
            modelPhylon.setValueAt(inv.getPto5(), i, 12);
            modelPhylon.setValueAt(inv.getPto6(), i, 13);
            modelPhylon.setValueAt(inv.getPto7(), i, 14);
            modelPhylon.setValueAt(inv.getPto8(), i, 15);
            modelPhylon.setValueAt(inv.getPto9(), i, 16);
            modelPhylon.setValueAt(inv.getPto10(), i, 17);
            modelPhylon.setValueAt(inv.getPto11(), i, 18);
            modelPhylon.setValueAt(inv.getPto12(), i, 19);
            modelPhylon.setValueAt(inv.getPto13(), i, 20);
            modelPhylon.setValueAt(inv.getPto14(), i, 21);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 22);
        }
    }

    private void LoadModelPhyN() {
        ArrayList<Infisico> listaInv = objF.InvGetAllN();

        modelPhylon.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelPhylon.setValueAt(inv.getProducto(), i, 1);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 3);
            modelPhylon.setValueAt(inv.getEstilo(), i, 4);
            modelPhylon.setValueAt(inv.getCorrida(), i, 5);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 6);
            modelPhylon.setValueAt(inv.getTipo(), i, 7);
            modelPhylon.setValueAt(inv.getPto1(), i, 8);
            modelPhylon.setValueAt(inv.getPto2(), i, 9);
            modelPhylon.setValueAt(inv.getPto3(), i, 10);
            modelPhylon.setValueAt(inv.getPto4(), i, 11);
            modelPhylon.setValueAt(inv.getPto5(), i, 12);
            modelPhylon.setValueAt(inv.getPto6(), i, 13);
            modelPhylon.setValueAt(inv.getPto7(), i, 14);
            modelPhylon.setValueAt(inv.getPto8(), i, 15);
            modelPhylon.setValueAt(inv.getPto9(), i, 16);
            modelPhylon.setValueAt(inv.getPto10(), i, 17);
            modelPhylon.setValueAt(inv.getPto11(), i, 18);
            modelPhylon.setValueAt(inv.getPto12(), i, 19);
            modelPhylon.setValueAt(inv.getPto13(), i, 20);
            modelPhylon.setValueAt(inv.getPto14(), i, 21);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 22);
        }
    }

    private void LoadModelPhyK() {
        ArrayList<Infisico> listaInv = objF.InvGetAllK();

        modelPhylon.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelPhylon.setValueAt(inv.getProducto(), i, 1);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 3);
            modelPhylon.setValueAt(inv.getEstilo(), i, 4);
            modelPhylon.setValueAt(inv.getCorrida(), i, 5);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 6);
            modelPhylon.setValueAt(inv.getTipo(), i, 7);
            modelPhylon.setValueAt(inv.getPto1(), i, 8);
            modelPhylon.setValueAt(inv.getPto2(), i, 9);
            modelPhylon.setValueAt(inv.getPto3(), i, 10);
            modelPhylon.setValueAt(inv.getPto4(), i, 11);
            modelPhylon.setValueAt(inv.getPto5(), i, 12);
            modelPhylon.setValueAt(inv.getPto6(), i, 13);
            modelPhylon.setValueAt(inv.getPto7(), i, 14);
            modelPhylon.setValueAt(inv.getPto8(), i, 15);
            modelPhylon.setValueAt(inv.getPto9(), i, 16);
            modelPhylon.setValueAt(inv.getPto10(), i, 17);
            modelPhylon.setValueAt(inv.getPto11(), i, 18);
            modelPhylon.setValueAt(inv.getPto12(), i, 19);
            modelPhylon.setValueAt(inv.getPto13(), i, 20);
            modelPhylon.setValueAt(inv.getPto14(), i, 21);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 22);
        }
    }

    private void GuardarFichero() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            if (!fichero.exists()) {
                fichero.createNewFile();
            } else {
                for (int i = 0; i < JtPhylon.getRowCount(); i++) {
                    for (int j = 0; j < JtPhylon.getColumnCount(); j++) {
                        bw.write((String) (JtPhylon.getValueAt(i, j) + "|"));
                        /*if (i < JtPhylon.getRowCount() - 1) {
                            bw.write(",");
                        }*/
                    }
                    bw.newLine();
                }
                //JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void LeerDatos() {
        FileReader fr = null;
        BufferedReader br = null;

        if (fichero.exists()) {
            try {
                fr = new FileReader(fichero);
                br = new BufferedReader(fr);
                String linea;

                /*if (br.readLine().equals("")) {
                    JOptionPane.showMessageDialog(null, "No hay datos para cargar");
                    CleanTable();
                }*/
                while ((linea = br.readLine()) != null) {
                    if (linea.equals("")) {
                        System.out.println("VACIO");
                    } else {
                        StringTokenizer dt = new StringTokenizer(linea, "|");
                        Vector x = new Vector();
                        while (dt.hasMoreTokens()) {
                            x.addElement(dt.nextToken());
                        }
                        modelPhylon.addRow(x);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningun archivo");
        }
    }

    private void VaciarDatos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            if (!fichero.exists()) {

            } else {
                bw.write("");
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jb1;
    private javax.swing.JLabel Jb10;
    private javax.swing.JLabel Jb11;
    private javax.swing.JLabel Jb12;
    private javax.swing.JLabel Jb13;
    private javax.swing.JLabel Jb14;
    private javax.swing.JLabel Jb2;
    private javax.swing.JLabel Jb3;
    private javax.swing.JLabel Jb4;
    private javax.swing.JLabel Jb5;
    private javax.swing.JLabel Jb6;
    private javax.swing.JLabel Jb7;
    private javax.swing.JLabel Jb8;
    private javax.swing.JLabel Jb9;
    private javax.swing.JButton JbClean;
    private javax.swing.JButton JbGenerar;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbPt;
    private javax.swing.JButton JbRemove;
    private javax.swing.JLabel JlCombinacion;
    private javax.swing.JLabel JlDescripcion;
    private javax.swing.JLabel JlEstilo;
    private javax.swing.JLabel JlPares;
    private javax.swing.JTextField Jt1;
    private javax.swing.JTextField Jt10;
    private javax.swing.JTextField Jt11;
    private javax.swing.JTextField Jt12;
    private javax.swing.JTextField Jt13;
    private javax.swing.JTextField Jt14;
    private javax.swing.JTextField Jt2;
    private javax.swing.JTextField Jt3;
    private javax.swing.JTextField Jt4;
    private javax.swing.JTextField Jt5;
    private javax.swing.JTextField Jt6;
    private javax.swing.JTextField Jt7;
    private javax.swing.JTextField Jt8;
    private javax.swing.JTextField Jt9;
    private javax.swing.JTextField JtAm;
    private javax.swing.JTextField JtCorrida;
    private javax.swing.JTextField JtPares;
    private javax.swing.JTable JtPhylon;
    private javax.swing.JTextField JtProducto;
    private javax.swing.JPanel Psuelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<PtProducto> listaRCPT;
    // End of variables declaration//GEN-END:variables
}
