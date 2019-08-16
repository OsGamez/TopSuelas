package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.Maquina;
import ObjectLayer.ObjectMaquinas;
import ObjectLayer.ObjectOrdenTrabajo;
import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.Ordencompra;
import ObjectLayer.Ordentrabajo;
import ObjectLayer.ProveedorMPrima;
import ObjectLayer.Sesioninfo;
import ObjectLayer.Validacion;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProgramarSuelaxMaquina extends javax.swing.JDialog {

    String informacion = "";
    ArrayList<String> listasemana = new ArrayList<>();
    ArrayList<Ordentrabajo> listaOT = new ArrayList<>();
    ArrayList<Ordentrabajo> listaOTB = new ArrayList<>();
    ArrayList<Maquina> listaMaquina = new ArrayList<>();
    ObjectOrdenTrabajo ObjOT = new ObjectOrdenTrabajo();
    ObjectMaquinas objMaquina = new ObjectMaquinas();
    Sesioninfo s = new Sesioninfo();
    DefaultListModel<Ordencompra> modeloListaOrden = new DefaultListModel<>();
    DefaultTableModel modelOrdenT;
    DefaultTableModel modelLinea;
    DefaultTableModel modelOrden;
    DefaultTableModel modelOrdenTrabajo;
    DefaultComboBoxModel modelMaquina;
    DefaultComboBoxModel modelEstacion;

    public ProgramarSuelaxMaquina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelSemana();
        LoadModelLinea();
        LoadModelLineaS();
        LoadModelOrden();
//        Jp1.setVisible(false);
        JlFecha.setText(fechaactual());
        JtLinea.setModel(modelOrdenT);
//        Dimension t = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setSize(t);
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
        Jp1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Jp3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtLinea = new javax.swing.JTable();
        JcSemana = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JlFecha = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtLineaS1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtOrden = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        JlSemana = new javax.swing.JLabel();
        JcEstacion = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        JcMaquina = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        JlOrden = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JtDistribucion = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(1320, 800));
        setPreferredSize(new java.awt.Dimension(1280, 820));
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

        Jp1.setBackground(new java.awt.Color(52, 65, 97));
        Jp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf.png"))); // NOI18N
        Jp1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        Jp3.setBackground(new java.awt.Color(52, 65, 97));

        JtLinea.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        JtLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtLineaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtLineaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(JtLinea);

        JcSemana.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JcSemana.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcSemanaItemStateChanged(evt);
            }
        });
        JcSemana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JcSemanaMousePressed(evt);
            }
        });
        JcSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcSemanaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Semana # :");

        JlFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlFecha.setForeground(new java.awt.Color(255, 255, 255));
        JlFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout Jp3Layout = new javax.swing.GroupLayout(Jp3);
        Jp3.setLayout(Jp3Layout);
        Jp3Layout.setHorizontalGroup(
            Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(Jp3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcSemana, 0, 149, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jp3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Jp3Layout.setVerticalGroup(
            Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JcSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        JtLineaS1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JtLineaS1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtLineaS1MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(JtLineaS1);

        JtOrden.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JtOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtOrdenMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(JtOrden);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Semana: #");

        JlSemana.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JlSemana.setForeground(new java.awt.Color(255, 255, 255));

        JcEstacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        JcEstacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcEstacionItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estación : ");

        JcMaquina.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        JcMaquina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcMaquinaItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Maquina : ");

        JlOrden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JlOrden.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Orden de Trabajo : ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ASIGNACION DE PARES");

        jPanel4.setPreferredSize(new java.awt.Dimension(587, 69));

        JtDistribucion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JtDistribucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtDistribucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDistribucionMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(JtDistribucion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save_as-80_icon-icons.com_57275.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GUARDAR");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fondo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(159, 159, 159)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(284, 284, 284)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(204, 204, 204)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(284, 284, 284)
                                            .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JlOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JcMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JcEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JlSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(79, 79, 79)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(112, 112, 112))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(JlSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(JlOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JcEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel10))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(JcMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Jp3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void LoadModelLinea() {
        modelOrdenT = new DefaultTableModel();
        modelOrdenT.addColumn("Modelo");
        modelOrdenT.addColumn("Pares");
        JtLinea.setModel(modelOrdenT);
        JtLinea.getColumnModel().getColumn(0).setPreferredWidth(135);
        JtLinea.getColumnModel().getColumn(1).setPreferredWidth(1);
    }

    private void LoadModelLineaS() {
        modelLinea = new DefaultTableModel();
        modelLinea.addColumn("Linea");
        modelLinea.addColumn("Pares");
        JtLineaS1.setModel(modelLinea);
        JtLineaS1.getColumnModel().getColumn(0).setPreferredWidth(135);
        JtLineaS1.getColumnModel().getColumn(1).setPreferredWidth(1);
        onLineaSSelect();
    }

    private void LoadModelOrden() {
        modelOrden = new DefaultTableModel();
        modelOrden.addColumn("Orden");
        JtOrden.setModel(modelOrden);
        JtOrden.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    private void LoadModelSemana() {
        listasemana = ObjOT.GetSemana();
        for (int i = 0; i < listasemana.size(); i++) {
            JcSemana.addItem(listasemana.get(i));
        }
    }

    private void LoadModelOrdenTrabajo(int pi, int pf) {
        modelOrdenTrabajo = new DefaultTableModel();
        Object arr[] = new Object[(pf - pi) + 1];
        int cont = 0;
        for (int i = pi; i <= pf; i++) {
            modelOrdenTrabajo.addColumn(i + "");
            arr[cont] = "";
        }
        JtDistribucion.setModel(modelOrdenTrabajo);
        modelOrdenTrabajo.addRow(arr);
    }

    private void LoadModelMaquina() {
        
        if(JcMaquina.getItemCount()!=0){
        modelMaquina.removeAllElements();
        modelEstacion.removeAllElements();
        }
        modelMaquina=new DefaultComboBoxModel();
        modelEstacion=new DefaultComboBoxModel();
        JcMaquina.setModel(modelMaquina);
        JcEstacion.setModel(modelEstacion);
        listaMaquina = objMaquina.MaquinaGetAll();
        JcMaquina.addItem("Seleccione Maquina:");
        for (int i = 0; i < listaMaquina.size(); i++) {
            JcMaquina.addItem(listaMaquina.get(i).getMaquina());
        }
        JcEstacion.addItem("Seleccione Estacion:");
        int row = JcMaquina.getSelectedIndex();
        for (int j = 1; j <= listaMaquina.get(row).getEstaciones(); j++) {
            JcEstacion.addItem(j + "");
        }
    }

    private void vaciatablaLinea() {
        int rows = JtLinea.getRowCount();
        //System.out.println(rows);
        for (int i = rows - 1; i >= 0; i--) {
            modelOrdenT.removeRow(i);
        }
    }

    private void vaciatablaLineaS() {
        modelLinea.setRowCount(0);
        this.modelLinea.getDataVector().clear();
    }

    private void vaciatablaorden() {
        modelOrden.setRowCount(0);
        this.modelOrden.getDataVector().clear();
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void JtLineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtLineaMouseClicked

    }//GEN-LAST:event_JtLineaMouseClicked

    private void JmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmiMouseClicked

    }//GEN-LAST:event_JmiMouseClicked

    private void JmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiActionPerformed
    }//GEN-LAST:event_JmiActionPerformed

    private void JmmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JmmMouseClicked

    private void JmmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmmActionPerformed

//        listamovimiento_material.s
    }//GEN-LAST:event_JmmActionPerformed

    private void JcSemanaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcSemanaItemStateChanged
        if (JcSemana.getSelectedIndex() != 0) {
            if (JtLinea.getRowCount() != 0) {
                vaciatablaLinea();
            }
            onLineaSelect();
        }
    }//GEN-LAST:event_JcSemanaItemStateChanged

    private void JtLineaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtLineaMousePressed
        Validacion v = new Validacion();
        String resp = JOptionPane.showInputDialog("Escribe la cantidad de Ordenes de trabajo para la suela seleccionada: ");
        // verificar que lo que va a ingresar el usuario es un numero y no continuar hasta que ingrese uno o cancele.    
        if (resp == null || resp.equals("") || resp.isEmpty()) {
        } else {
            while (!v.verificanumeros(resp) || Integer.parseInt(resp) <= 0) {
                resp = JOptionPane.showInputDialog("Escribe la cantidad de Ordenes de trabajo para la suela seleccionada: ");
            }
            int row = JtLinea.getSelectedRow();
            Ordentrabajo o = new Ordentrabajo();
            o.setCantidadOrden(Integer.parseInt(resp));
            o.setSemana(Integer.parseInt(JcSemana.getSelectedItem().toString()));
            o.setProducto(listaOT.get(row).getProducto());
            o.setTotal(listaOT.get(row).getTotal());
            o.setLinea(listaOT.get(row).getLinea());
            o.setFecha(getfecha());
            ObjOT.OrdenesTAdd(o);
            modelOrdenT.removeRow(row);
            listaOT.remove(row);
            vaciatablaLineaS();
            LoadModelLineaS();
        }
    }//GEN-LAST:event_JtLineaMousePressed

    private void JtLineaS1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtLineaS1MousePressed
        try {
            int row = JtLineaS1.getSelectedRow();
            if (JtOrden.getRowCount() == 0) {
                vaciatablaorden();
            }
            vaciatablaorden();
            listaOTB = ObjOT.GetOrdenxLinea(listaOTB, row);
            for (int i = 0; i < listaOTB.get(row).getArrorden().size(); i++) {
                int orden = listaOTB.get(row).getArrorden().get(i).getOrden();
                Object arr[] = {"Orden Numero : " + orden};
                modelOrden.addRow(arr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }//GEN-LAST:event_JtLineaS1MousePressed

    private void JtOrdenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtOrdenMousePressed

        int rowl = JtLineaS1.getSelectedRow();
        int roworden = JtOrden.getSelectedRow();
        LoadModelOrdenTrabajo(listaOTB.get(rowl).getPi(), listaOTB.get(rowl).getPf());
        JlSemana.setText(listaOTB.get(rowl).getArrorden().get(roworden).getSemana() + "");
        JlOrden.setText(listaOTB.get(rowl).getArrorden().get(roworden).getOrden() + "");
        LoadModelMaquina();
        JcMaquina.requestFocus();
    }//GEN-LAST:event_JtOrdenMousePressed

    private void JtDistribucionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDistribucionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtDistribucionMousePressed

    private void JcMaquinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcMaquinaItemStateChanged
        JcEstacion.requestFocus();
    }//GEN-LAST:event_JcMaquinaItemStateChanged

    private void JcEstacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcEstacionItemStateChanged
        JtDistribucion.requestFocus();
    }//GEN-LAST:event_JcEstacionItemStateChanged

    private void JcSemanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JcSemanaMousePressed

    }//GEN-LAST:event_JcSemanaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
        int row = JtLineaS1.getSelectedRow();
        int roworden = JtOrden.getSelectedRow();
        int pi = listaOTB.get(row).getPi();
        int pf = listaOTB.get(row).getPf();
        String a = "update DOrdenTrabajo set ";// query para actualizar detalle de Orden
        if(JcMaquina.getSelectedIndex()==0 && JcEstacion.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Debes seleccionar una estacion y maquina");
            JcMaquina.requestFocus();
        }else if (verificadistribucion()) {// verifica campos numero de puntos, vacios y nulos
            JOptionPane.showMessageDialog(null, "No puedes Incluir mas de 2 puntos en una orden de trabajo");
        } else {
            int pi2 = pi;// contador que hace pro punto
            int cantidad = 1;
            int movtabla = 0;//movimiento entre columnas de la tabla
            int formacadena = 0;// para saber si hay una coma al final o no
            int totalpares=0;
            while (pi2 <= pf) {
                if (JtDistribucion.getValueAt(0, movtabla) == null || JtDistribucion.getValueAt(0, movtabla).equals("")) {
                    cantidad += 2;
                } else if (verificadistribucion2()) {// verifica que haya digitos y se validan
                    JOptionPane.showMessageDialog(null, "Debes de introducir numero de pares en 2 puntos distintos");
                } else {
                    if (formacadena == 1) {
                        a += "cant" + cantidad + "=" + JtDistribucion.getValueAt(0, movtabla) + " ";
                        totalpares+=Integer.parseInt(JtDistribucion.getValueAt(0, movtabla).toString());
                        formacadena++;
                    } else {
                        a += "cant" + cantidad + "=" + JtDistribucion.getValueAt(0, movtabla) + ", ";
                        totalpares+=Integer.parseInt(JtDistribucion.getValueAt(0, movtabla).toString());
                        formacadena++;
                    }
                    cantidad += 2;
                }
                pi2++;
                movtabla++;
            }
            //si es solo un punto se quitara la coma del final
            if (a.charAt(a.length() - 2) == ',') {
                a = a.substring(0, a.length() - 2);
            }
            a += " where DOrden =" + listaOTB.get(row).getArrorden().get(roworden).getDOrden();
            Ordentrabajo ot = new Ordentrabajo();
            ot.setOrden(listaOTB.get(row).getArrorden().get(roworden).getOrden());
            ot.setMaquina(listaMaquina.get(JcMaquina.getSelectedIndex()).getMaquina());
            ot.setEstacion(Integer.parseInt(JcEstacion.getSelectedItem().toString()));
            ot.setQuery(a);
            ot.setCantidadOrden(totalpares);
            ot.setIdDOrden(listaOTB.get(row).getArrorden().get(roworden).getDOrden());
            if(ObjOT.OrdentUpdate(ot)){
                JOptionPane.showMessageDialog(null, "Asignacion de Orden Completa!");
            }else
                JOptionPane.showMessageDialog(null, "No se pudo realizar La asignacion, Intentelo de nuevo");
        }
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error, contacte a Sistemas:\n"+e.getMessage());
       } 
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JcSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcSemanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcSemanaActionPerformed
    private boolean verificadistribucion() {
        int aux = 0;
        for (int i = 0; i < JtDistribucion.getColumnCount(); i++) {
            if (JtDistribucion.getValueAt(0, i) == null || JtDistribucion.getValueAt(0, i).equals("")) {
            } else {
                aux++;
            }
        }
        return (aux > 2);
    }

    private boolean verificadistribucion2() {
        int aux = 0;
        for (int i = 0; i < JtDistribucion.getColumnCount(); i++) {
            if (JtDistribucion.getValueAt(0, i) == null || JtDistribucion.getValueAt(0, i).equals("")) {
            } else {
                Validacion v = new Validacion();
                if (v.verificanumeros(JtDistribucion.getValueAt(0, i).toString())) {
                    aux++;
                }
            }
        }
        return (aux == 0);
    }

    private void onLineaSelect() {
        if (JtLinea.getRowCount() != 0) {
            vaciatablaLinea();
        }
        listaOT = ObjOT.GetLineaxSemana(JcSemana.getSelectedItem().toString());
        if (!listaOT.isEmpty()) {
            for (int i = 0; i < listaOT.size(); i++) {
                Object arri[] = {listaOT.get(i).getNombreprod(), listaOT.get(i).getTotal() + ""};
                modelOrdenT.addRow(arri);
            }
        }
    }

    private void onLineaSSelect() {
        if (JtLineaS1.getRowCount() != 0) {
            vaciatablaLineaS();
        }
        listaOTB = ObjOT.GetLineaxProg();
        if (!listaOTB.isEmpty()) {
            for (int i = 0; i < listaOTB.size(); i++) {
                Object arri[] = {listaOTB.get(i).getNombreprod(), listaOTB.get(i).getTotal() + ""};
                modelLinea.addRow(arri);
            }
        }
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

    private String fechaactual() {
        Calendar fechas = Calendar.getInstance(); //intanciar informacion del calendiario respecto al sistema
        int año = fechas.get(Calendar.YEAR);
        int mes = fechas.get(Calendar.MONTH) + 1;
        int dia = fechas.get(Calendar.DAY_OF_MONTH);
        return dia + "/" + mes + "/" + año;
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
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgramarSuelaxMaquina dialog = new ProgramarSuelaxMaquina(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JcEstacion;
    private javax.swing.JComboBox<String> JcMaquina;
    private javax.swing.JComboBox<String> JcSemana;
    private javax.swing.JLabel JlFecha;
    private javax.swing.JLabel JlOrden;
    private javax.swing.JLabel JlSemana;
    private javax.swing.JMenuItem Jmi;
    private javax.swing.JMenuItem Jmm;
    private javax.swing.JPanel Jp1;
    private javax.swing.JPanel Jp3;
    private javax.swing.JPopupMenu JpMenu;
    private javax.swing.JTable JtDistribucion;
    private javax.swing.JTable JtLinea;
    private javax.swing.JTable JtLineaS1;
    private javax.swing.JTable JtOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
