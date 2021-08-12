//Nueva version para programacion y avances
package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.Almacen;
import ObjectLayer.Maquina;
import ObjectLayer.ObjectMaquinas;
import ObjectLayer.ObjectOrdenTrabajo;
import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.Ordencompra;
import ObjectLayer.Ordentrabajo;
import ObjectLayer.Programacion_enc;
import ObjectLayer.ProveedorMPrima;
import ObjectLayer.Sesioninfo;
import ObjectLayer.Validacion;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ProgramarSuelaxMaquinav2 extends javax.swing.JDialog {

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
    ArrayList<Programacion_enc> arrlineas = new ArrayList<>();

    DateFormat df = DateFormat.getDateInstance();

    public ProgramarSuelaxMaquinav2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelDetalle();
//        Jp1.setVisible(false);
        JlFecha.setText(fechaactual());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Jp3 = new javax.swing.JPanel();
        JlFecha = new javax.swing.JLabel();
        fi = new com.toedter.calendar.JDateChooser();
        ff = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        JbAll = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Jp1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Jp1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tarjetas de Avances");
        Jp1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reporte de Tarjeta");
        Jp1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        Jp3.setBackground(new java.awt.Color(52, 65, 97));

        JlFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlFecha.setForeground(new java.awt.Color(255, 255, 255));
        JlFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Jp3Layout = new javax.swing.GroupLayout(Jp3);
        Jp3.setLayout(Jp3Layout);
        Jp3Layout.setHorizontalGroup(
            Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp3Layout.createSequentialGroup()
                .addGroup(Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jp3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fi, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(ff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(Jp3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton1))
                    .addGroup(Jp3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 85, Short.MAX_VALUE))
        );
        Jp3Layout.setVerticalGroup(
            Jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("MODELOS");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtDetalleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JtDetalle);

        JbAll.setText("Agregar Todo");
        JbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAllActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbAll)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(Jp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Jp3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(JbAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addGap(23, 23, 23)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void LoadModelDetalle() {
        modelOrdenT = new DefaultTableModel();
        modelOrdenT.addColumn("Cliente");
        modelOrdenT.addColumn("Pares");
        modelOrdenT.addColumn("Fecha ped.");
        modelOrdenT.addColumn("Fecha Entrega");
        JtDetalle.setModel(modelOrdenT);
        JtDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        JtDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        JtDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        JtDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void vaciatablaDetalle() {
        int rows = JtDetalle.getRowCount();
//        //System.out.println(rows);
        for (int i = rows - 1; i >= 0; i--) {
            modelOrdenT.removeRow(i);
        }
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

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

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (node == null) {
            return;

        } else {
//            System.out.println(arrlineas.size() + " #" + jTree1.getMinSelectionRow());
            if (jTree1.getMinSelectionRow() != 0) {
////                System.out.println(true);
////                System.out.println(jTree1.getLastSelectedPathComponent()); // aqui regresa el valor del texto del menu.
//
////                System.out.println(jTree1.getMinSelectionRow() + "-" + jTree1.getPathForRow(0) + "-"
//                        + jTree1.getSelectionPath().toString());
////                System.out.println("");
////                System.out.println("* " + arrlineas.get(jTree1.getMinSelectionRow()).getId_arbol());
////                System.out.println("tamaño " + arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().size());
                modelOrdenT.setNumRows(arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().size());
                for (int i = 0; i < arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().size(); i++) {

                    String cliente = arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().get(i).getClientedesc();
                    int par = arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().get(i).getPares();
                    String fechap = arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().get(i).getFecha_cap();
                    String fechae = arrlineas.get(jTree1.getMinSelectionRow()).getArrdet().get(i).getFecha_entrega();
//                    System.out.println(cliente + "*" + par + "*" + arrlineas.get(jTree1.getMinSelectionRow()).getLinea());
                    modelOrdenT.setValueAt(cliente, i, 0);
                    modelOrdenT.setValueAt(par, i, 1);
                    modelOrdenT.setValueAt(fechap, i, 2);
                    modelOrdenT.setValueAt(fechae, i, 3);
                }
            }

        }
        Object nodeInfo = node.getUserObject();
//        //System.out.println(nodeInfo.toString());
    }//GEN-LAST:event_jTree1ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectpedidos();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void JtDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMouseClicked
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas programar la linea seleccionada?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            int renglon = JtDetalle.getSelectedRow();
            int enc = jTree1.getMinSelectionRow();
            String fechaactual = getfecha();
            int programa = ObjOT.ProgramaAdd(arrlineas, enc, renglon, fechaactual);
            if (programa != 0) {
                JOptionPane.showMessageDialog(null, "Completo");

                LoadModelDetalle();
                selectpedidos();
                impProg(programa);
                arrlineas.clear();
            } else {
                JOptionPane.showMessageDialog(null, "Error al completar");
            }
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }


    }//GEN-LAST:event_JtDetalleMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int programa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de tarjeta"));
        impProgavances(programa);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void JbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAllActionPerformed
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas programar TODA la linea seleccionada?", "TOP-SUELAS",
                0, 0, null, botones, this);

        if (eleccion == JOptionPane.YES_OPTION) {
            //int renglon = JtDetalle.getSelectedRow();
            int enc = jTree1.getMinSelectionRow();
            String fechaactual = getfecha();
            if(checkpares(enc)){
                int programa = ObjOT.ProgramaAddAll(arrlineas, enc, fechaactual);
                if (programa != 0) {
                    JOptionPane.showMessageDialog(null, "Completo");
                    LoadModelDetalle();
                    selectpedidos();
                    JOptionPane.showMessageDialog(null, "Numero de tarjeta: " + programa);
                    impProg(programa);
                    arrlineas.clear();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al completar");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error al completar debido a falta de pares en un punto");
            }
            
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_JbAllActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int programa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de tarjeta"));
        impProg(programa);

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        if(checkpares()){
//            JOptionPane.showMessageDialog(null, "Completado");
//        }else{
//            JOptionPane.showMessageDialog(null, "Error al completar debido a falta de pares en un punto");
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void onDetalleselect() {
//        if (JtLinea.getRowCount() != 0) {// Vaciar tabla de linea y color
//            vaciatablaDetalle();
//        }

    }

    private void selectpedidos() {
        String fa = df.format(fi.getDate());
        String fb = df.format(ff.getDate());
//        //System.out.println(fa + "*" + fb);
        arrlineas = ObjOT.GetModelos(fa, fb);
        //prog.GetModelos();
        int renglonenc = 0;//contador externo a i
        DefaultMutableTreeNode dad = new DefaultMutableTreeNode("MODELOS");//nueva raiz
        DefaultTreeModel modelo = new DefaultTreeModel(dad);
        for (int i = 0; i < arrlineas.size(); i++) {//i son raices

            if (i == 0) {

            } else {
                String nombre = arrlineas.get(i).getDesclinea() + " " + arrlineas.get(i).getColor() + ",   " + arrlineas.get(i).getPares();
                DefaultMutableTreeNode a = new DefaultMutableTreeNode(nombre);
                modelo.insertNodeInto(a, dad, renglonenc);
                int renglond = 0;
//                //System.out.println(arrlineas.get(i).getArrdet().size());
//                for (int j = 0; j < arrlineas.get(i).getArrdet().size(); j++) {//detalle de clientes
//                    String cliente =arrlineas.get(i).getArrdet().get(j).getClientedesc();
//                    int pares = arrlineas.get(i).getArrdet().get(j).getPares();
//                    String fechap=arrlineas.get(i).getArrdet().get(j).getFecha_cap();
//                    String fechae=arrlineas.get(i).getArrdet().get(j).getFecha_entrega();
//                    String nombred="  "+cliente+" , "+pares+" , " +fechap+" , "+fechae;
////                    //System.out.println(nombred);
//                    DefaultMutableTreeNode ba = new DefaultMutableTreeNode(nombred);
//                    modelo.insertNodeInto(ba, a, renglond);
//                    renglond++;
//                }
                renglonenc++;
            }
        }

//        DefaultMutableTreeNode b = new DefaultMutableTreeNode("BLOND");
//        DefaultMutableTreeNode clientb = new DefaultMutableTreeNode("A");
//        DefaultMutableTreeNode clienteb = new DefaultMutableTreeNode("B");
//        DefaultMutableTreeNode cb = new DefaultMutableTreeNode("C");
//        modelo.insertNodeInto(b, dad, 0);
//        modelo.insertNodeInto(clientb, b, 0);
//        modelo.insertNodeInto(clienteb, b, 1);
//        modelo.insertNodeInto(cb, b, 2);
        jTree1.setModel(modelo);
        jTree1.repaint();

    }

    private void impProg(int p) {
        try {
            Connection c = Server.getProduccion();
            Map par = new HashMap();
//                System.out.println(p);
            par.put("folio", p);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Programa.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                JasperViewer view = new JasperViewer(jprint, false);
                this.dispose();
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setTitle("TOP-SUELAS");
                view.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        reabrir();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });
            } catch (JRException ex) {
                Logger.getLogger(ReporteMoldes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(ReporteMoldes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void reabrir() {
        this.setVisible(true);
    }

    private boolean checkpares(int enc) {//verificar numero de pares que sean mayor a X numero de pares x punto mas el 5 %
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        int c7 = 0;
        int c8 = 0;
        int c9 = 0;
        int c10 = 0;
        int c11 = 0;
        int c12 = 0;
        //int enc = jTree1.getMinSelectionRow();      
            for (int x = 0; x < arrlineas.get(enc).getArrdet().size(); x++) {
//                c1 += arrlineas.get(enc).getArrdet().get(x).getC1();
//                c2 += arrlineas.get(enc).getArrdet().get(x).getC2();
//                c3 += arrlineas.get(enc).getArrdet().get(x).getC3();
//                c4 += arrlineas.get(enc).getArrdet().get(x).getC4();
//                c5 += arrlineas.get(enc).getArrdet().get(x).getC5();
//                c6 += arrlineas.get(enc).getArrdet().get(x).getC6();
//                c7 += arrlineas.get(enc).getArrdet().get(x).getC7();
//                c8 += arrlineas.get(enc).getArrdet().get(x).getC8();
//                c9 += arrlineas.get(enc).getArrdet().get(x).getC9();
//                c10 += arrlineas.get(enc).getArrdet().get(x).getC10();
//                c11 += arrlineas.get(enc).getArrdet().get(x).getC11();
//                c12 += arrlineas.get(enc).getArrdet().get(x).getC12();
                
                c1 += arrlineas.get(enc).getArrdet().get(x).getC1()+(arrlineas.get(enc).getArrdet().get(x).getC1()*0.05);
                c2 += arrlineas.get(enc).getArrdet().get(x).getC2()+(arrlineas.get(enc).getArrdet().get(x).getC2()*0.05);
                c3 += arrlineas.get(enc).getArrdet().get(x).getC3()+(arrlineas.get(enc).getArrdet().get(x).getC3()*0.05);
                c4 += arrlineas.get(enc).getArrdet().get(x).getC4()+(arrlineas.get(enc).getArrdet().get(x).getC4()*0.05);
                c5 += arrlineas.get(enc).getArrdet().get(x).getC5()+(arrlineas.get(enc).getArrdet().get(x).getC5()*0.05);
                c6 += arrlineas.get(enc).getArrdet().get(x).getC6()+(arrlineas.get(enc).getArrdet().get(x).getC6()*0.05);
                c7 += arrlineas.get(enc).getArrdet().get(x).getC7()+(arrlineas.get(enc).getArrdet().get(x).getC7()*0.05);
                c8 += arrlineas.get(enc).getArrdet().get(x).getC8()+(arrlineas.get(enc).getArrdet().get(x).getC8()*0.05);
                c9 += arrlineas.get(enc).getArrdet().get(x).getC9()+(arrlineas.get(enc).getArrdet().get(x).getC9()*0.05);
                c10 += arrlineas.get(enc).getArrdet().get(x).getC10()+(arrlineas.get(enc).getArrdet().get(x).getC10()*0.05);
                c11 += arrlineas.get(enc).getArrdet().get(x).getC11()+(arrlineas.get(enc).getArrdet().get(x).getC11()*0.05);
                c12 += arrlineas.get(enc).getArrdet().get(x).getC12()+(arrlineas.get(enc).getArrdet().get(x).getC12()*0.05);
            }
//        System.out.println(c1+" - "+c2+" - "+c3+" - "+c4+" - "+c5+" - "+c6+" - "+c7+" - "+c8+" - "+c9+" - "+c10+" - "+c11+" - "+c12);
//        c1=(int) ((c1*0.05)+c1);
//        c2=(int) ((c2*0.05)+c2);
//        c3=(int) ((c3*0.05)+c3);
//        c4=(int) ((c4*0.05)+c4);
//        c5=(int) ((c5*0.05)+c5);
//        c6=(int) ((c6*0.05)+c6);
//        c7=(int) ((c7*0.05)+c7);
//        c8=(int) ((c8*0.05)+c8);
//        c9=(int) ((c9*0.05)+c9);
//        c10=(int) ((c10*0.05)+c10);
//        c11=(int) ((c11*0.05)+c11);
//        c12=(int) ((c12*0.05)+c12);
        
            
        boolean resp=((c1>99||c1==0) && (c2>99||c2==0) &&(c3>99||c3==0) &&(c4>99||c4==0) &&(c5>99||c5==0) &&(c6>99||c6==0) &&
                (c7>99||c7==0) &&(c8>99||c8==0) &&(c9>99||c9==0) &&(c10>99||c10==0) &&(c11>99||c11==0) &&(c12>99||c12==0));
        System.out.println(c1+" - "+c2+" - "+c3+" - "+c4+" - "+c5+" - "+c6+" - "+c7+" - "+c8+" - "+c9+" - "+c10+" - "+c11+" - "+c12);
        return resp;
    }

    private void impProgavances(int p) {
        try {
            Connection c = Server.getProduccion();
            Map par = new HashMap();
//                System.out.println(p);
            par.put("programa", p);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Avances.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                JasperViewer view = new JasperViewer(jprint, false);
                this.dispose();
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setTitle("TOP-SUELAS");
                view.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        reabrir();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });

            } catch (JRException ex) {
                Logger.getLogger(ReporteMoldes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(ReporteMoldes.class.getName()).log(Level.SEVERE, null, ex);
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
        String dias = (dia > 9) ? dia + "" : "0" + dia;
        String meses = (mes > 9) ? mes + "" : "0" + mes;
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
        String fechac = dias + "-" + meses + "-" + año + " " + horas + ":00.000";//fecha formada por Calendar.getInstance(); 
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
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquinav2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquinav2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquinav2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramarSuelaxMaquinav2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgramarSuelaxMaquinav2 dialog = new ProgramarSuelaxMaquinav2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbAll;
    private javax.swing.JLabel JlFecha;
    private javax.swing.JMenuItem Jmi;
    private javax.swing.JMenuItem Jmm;
    private javax.swing.JPanel Jp1;
    private javax.swing.JPanel Jp3;
    private javax.swing.JPopupMenu JpMenu;
    private javax.swing.JTable JtDetalle;
    private com.toedter.calendar.JDateChooser ff;
    private com.toedter.calendar.JDateChooser fi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
