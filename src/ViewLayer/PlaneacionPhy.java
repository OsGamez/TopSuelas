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
    ObjectInfisico objF = new ObjectInfisico();
    Connection c = Conexion.getRcpt();
    int cont = 1, cc = 0;
    public String User;

    String data[];

    File fichero = new File("C:\\InvFisico\\datos.txt");//Archivo usado para guardar y leer los datos, con ruta 

    int Cantidad = 0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;

    public DefaultTableModel modelPhylon = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultListModel<PtProducto> modeloListaRCPT = new DefaultListModel<PtProducto>();

    public PlaneacionPhy() {
        initComponents();
        LoadColumns();
        LeerDatos();
        JtPhylon.getTableHeader().setReorderingAllowed(false);
        JbGenerar.setToolTipText("CREAR PDF");
        JbGuardar.setToolTipText("GUARDAR EN INVENTARIO");
        JbClean.setToolTipText("LIMPIAR CAPTURA");
        JbRemove.setToolTipText("QUITAR SUELA");
        Psuelas.setVisible(false);
    }

    /*public PlaneacionPhy(Usuario us) {
        initComponents();
        LoadColumns();
        LeerDatos();
        User = us.getUsuario();
        JtPhylon.getTableHeader().setReorderingAllowed(false);
        JbGenerar.setToolTipText("CREAR PDF");
        JbGuardar.setToolTipText("GUARDAR EN INVENTARIO");
        JbClean.setToolTipText("LIMPIAR CAPTURA");
        JbRemove.setToolTipText("QUITAR SUELA");
        Psuelas.setVisible(false);
    }*/

    private void LoadColumns() {
        modelPhylon.addColumn("ID");
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

        JtPhylon.getColumnModel().getColumn(3).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(3).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(3).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(4).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(4).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(4).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(5).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(5).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(5).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(6).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(6).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(6).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JtAm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JtProducto = new javax.swing.JTextField();
        JlPares = new javax.swing.JLabel();
        JtPares = new javax.swing.JTextField();
        JbRemove = new javax.swing.JButton();
        JbClean = new javax.swing.JButton();
        JbGenerar = new javax.swing.JButton();
        JbGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtPhylon = new javax.swing.JTable();
        Psuelas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRCPT = new javax.swing.JList<>();

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

        JtPhylon.setBorder(null);
        JtPhylon.setModel(modelPhylon);
        JtPhylon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtPhylonKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JtPhylon);

        Psuelas.setBorder(null);

        listaRCPT.setModel(modeloListaRCPT);
        listaRCPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRCPTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaRCPT);

        javax.swing.GroupLayout PsuelasLayout = new javax.swing.GroupLayout(Psuelas);
        Psuelas.setLayout(PsuelasLayout);
        PsuelasLayout.setHorizontalGroup(
            PsuelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PsuelasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        PsuelasLayout.setVerticalGroup(
            PsuelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PsuelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(JbClean, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JbGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(JlPares)
                        .addGap(18, 18, 18)
                        .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Psuelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JlPares)
                    .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(Psuelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbRemove)
                    .addComponent(JbClean)
                    .addComponent(JbGenerar)
                    .addComponent(JbGuardar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            case "anayeli":
                BorrarA();
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
                    JtPares.requestFocus();
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
                JtProducto.requestFocus();
            }
        }
    }//GEN-LAST:event_JtParesKeyPressed

    private void JbCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCleanActionPerformed
        int row = JtPhylon.getRowCount();

        if (row > 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de limpiar los registros?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                EliminarRegistro();
                CleanTable();
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

    private void BorrarA() {
        objF.deleteDatosA();
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
       
                Generar();
             
    }//GEN-LAST:event_JbGenerarActionPerformed

    private void Generar() {
        /*String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.validarInv() == 0) {
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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
        }*/
    }

    private void GenerarN() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.validarInvN() == 0) {
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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

    private void GenerarA() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.validarInvA() == 0) {
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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

                    if (objF.AddInventarioCopyA(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            } else {
                BorrarA();
                for (int i = 0; i < row; i++) {
                    int Pt = Integer.parseInt((String) JtPhylon.getValueAt(i, 0));
                    int Am = Integer.parseInt((String) JtPhylon.getValueAt(i, 2));
                    int Est = Integer.parseInt((String) JtPhylon.getValueAt(i, 3));
                    int Corr = Integer.parseInt((String) JtPhylon.getValueAt(i, 4));
                    int Comb = Integer.parseInt((String) JtPhylon.getValueAt(i, 5));
                    int Pto1 = Integer.parseInt((String) JtPhylon.getValueAt(i, 7));
                    int Pto2 = Integer.parseInt((String) JtPhylon.getValueAt(i, 8));
                    int Pto3 = Integer.parseInt((String) JtPhylon.getValueAt(i, 9));
                    int Pto4 = Integer.parseInt((String) JtPhylon.getValueAt(i, 10));
                    int Pto5 = Integer.parseInt((String) JtPhylon.getValueAt(i, 11));
                    int Pto6 = Integer.parseInt((String) JtPhylon.getValueAt(i, 12));
                    int Pto7 = Integer.parseInt((String) JtPhylon.getValueAt(i, 13));
                    int Pto8 = Integer.parseInt((String) JtPhylon.getValueAt(i, 14));
                    int Pto9 = Integer.parseInt((String) JtPhylon.getValueAt(i, 15));
                    int Pto10 = Integer.parseInt((String) JtPhylon.getValueAt(i, 16));
                    int Pto11 = Integer.parseInt((String) JtPhylon.getValueAt(i, 17));
                    int Pto12 = Integer.parseInt((String) JtPhylon.getValueAt(i, 18));
                    int Pto13 = Integer.parseInt((String) JtPhylon.getValueAt(i, 19));
                    int Pto14 = Integer.parseInt((String) JtPhylon.getValueAt(i, 20));
                    int Tpares = Integer.parseInt((String) JtPhylon.getValueAt(i, 21));

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

                    if (objF.AddInventarioCopyA(inv)) {
                        ms = "OK";
                    } else {
                        ms = "ERROR";
                    }
                }
            }
        }
        if (ms == "OK") {
            ReporteAS();
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
        /*if (ValidarDetalle()) {
            if (objF.validarInv() == 0) {
                JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
            } else {
                Save();
            }

        }*/


    }//GEN-LAST:event_JbGuardarActionPerformed

    private void listaRCPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRCPTMouseClicked
        JList lis = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            PtProducto prod = (PtProducto) lis.getSelectedValue();
            limpiarRCPT();

            PuntosPlaneacion pp = new PuntosPlaneacion(null, true);
            pp.Corrida = String.valueOf(prod.getCorrida());
            pp.Suela = prod.getDescripcion();
            pp.Idp = String.valueOf(prod.getProducto());
            pp.Combinacion = String.valueOf(prod.getCombinacion());
            pp.Estilo = String.valueOf(prod.getEstilo());
            pp.Pares = JtPares.getText();
            pp.Am = JtAm.getText();
            pp.Jt1.requestFocus();
            pp.Jt1.setSelectionStart(0);
            pp.ValidarCorrida();
            pp.modelPhylon = modelPhylon;
            pp.setVisible(true);
            Setear();
        }
    }//GEN-LAST:event_listaRCPTMouseClicked


    private void JtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyReleased
        Psuelas.setVisible(true);
        limpiarRCPT();
        if (JtProducto.getText().isEmpty()) {
            limpiarRCPT();
            Psuelas.setVisible(false);
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

    private void ReporteAS() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InCopyAS.jasper"));
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
        LoadModelPhy();

        int row = JtPhylon.getRowCount();
        for (int i = 0; i < row; i++) {
            String pt = JtPhylon.getValueAt(i, 0).toString();
            String am = JtPhylon.getValueAt(i, 2).toString();
            String est = JtPhylon.getValueAt(i, 3).toString();
            String corr = JtPhylon.getValueAt(i, 4).toString();
            String com = JtPhylon.getValueAt(i, 5).toString();
            String Tipo = JtPhylon.getValueAt(i, 6).toString();
            String pt1 = JtPhylon.getValueAt(i, 7).toString();
            String pt2 = JtPhylon.getValueAt(i, 8).toString();
            String pt3 = JtPhylon.getValueAt(i, 9).toString();
            String pt4 = JtPhylon.getValueAt(i, 10).toString();
            String pt5 = JtPhylon.getValueAt(i, 11).toString();
            String pt6 = JtPhylon.getValueAt(i, 12).toString();
            String pt7 = JtPhylon.getValueAt(i, 13).toString();
            String pt8 = JtPhylon.getValueAt(i, 14).toString();
            String pt9 = JtPhylon.getValueAt(i, 15).toString();
            String pt10 = JtPhylon.getValueAt(i, 16).toString();
            String pt11 = JtPhylon.getValueAt(i, 17).toString();
            String pt12 = JtPhylon.getValueAt(i, 18).toString();
            String pt13 = JtPhylon.getValueAt(i, 19).toString();
            String pt14 = JtPhylon.getValueAt(i, 20).toString();
            String tpares = JtPhylon.getValueAt(i, 21).toString();

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

        if ("OK".equals(ms)) {
            JOptionPane.showMessageDialog(this, "Se han agregado los registros al inventario!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            CleanTable();
            Borrar();
        }
    }

    private void Save() {

        ReporteGroup();

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

    private void ReporteGroupA() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InCopyA.jasper"));
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

            modelPhylon.setValueAt(inv.getProducto(), i, 0);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 2);
            modelPhylon.setValueAt(inv.getEstilo(), i, 3);
            modelPhylon.setValueAt(inv.getCorrida(), i, 4);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 5);
            modelPhylon.setValueAt(inv.getTipo(), i, 6);
            modelPhylon.setValueAt(inv.getPto1(), i, 7);
            modelPhylon.setValueAt(inv.getPto2(), i, 8);
            modelPhylon.setValueAt(inv.getPto3(), i, 9);
            modelPhylon.setValueAt(inv.getPto4(), i, 10);
            modelPhylon.setValueAt(inv.getPto5(), i, 11);
            modelPhylon.setValueAt(inv.getPto6(), i, 12);
            modelPhylon.setValueAt(inv.getPto7(), i, 13);
            modelPhylon.setValueAt(inv.getPto8(), i, 14);
            modelPhylon.setValueAt(inv.getPto9(), i, 15);
            modelPhylon.setValueAt(inv.getPto10(), i, 16);
            modelPhylon.setValueAt(inv.getPto11(), i, 17);
            modelPhylon.setValueAt(inv.getPto12(), i, 18);
            modelPhylon.setValueAt(inv.getPto13(), i, 19);
            modelPhylon.setValueAt(inv.getPto14(), i, 20);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 21);
        }
    }

    private void LoadModelPhyN() {
        ArrayList<Infisico> listaInv = objF.InvGetAllN();

        modelPhylon.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelPhylon.setValueAt(inv.getProducto(), i, 0);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 2);
            modelPhylon.setValueAt(inv.getEstilo(), i, 3);
            modelPhylon.setValueAt(inv.getCorrida(), i, 4);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 5);
            modelPhylon.setValueAt(inv.getTipo(), i, 6);
            modelPhylon.setValueAt(inv.getPto1(), i, 7);
            modelPhylon.setValueAt(inv.getPto2(), i, 8);
            modelPhylon.setValueAt(inv.getPto3(), i, 9);
            modelPhylon.setValueAt(inv.getPto4(), i, 10);
            modelPhylon.setValueAt(inv.getPto5(), i, 11);
            modelPhylon.setValueAt(inv.getPto6(), i, 12);
            modelPhylon.setValueAt(inv.getPto7(), i, 13);
            modelPhylon.setValueAt(inv.getPto8(), i, 14);
            modelPhylon.setValueAt(inv.getPto9(), i, 15);
            modelPhylon.setValueAt(inv.getPto10(), i, 16);
            modelPhylon.setValueAt(inv.getPto11(), i, 17);
            modelPhylon.setValueAt(inv.getPto12(), i, 18);
            modelPhylon.setValueAt(inv.getPto13(), i, 19);
            modelPhylon.setValueAt(inv.getPto14(), i, 20);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 21);
        }
    }

    private void LoadModelPhyK() {
        ArrayList<Infisico> listaInv = objF.InvGetAllK();

        modelPhylon.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelPhylon.setValueAt(inv.getProducto(), i, 0);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 2);
            modelPhylon.setValueAt(inv.getEstilo(), i, 3);
            modelPhylon.setValueAt(inv.getCorrida(), i, 4);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 5);
            modelPhylon.setValueAt(inv.getTipo(), i, 6);
            modelPhylon.setValueAt(inv.getPto1(), i, 7);
            modelPhylon.setValueAt(inv.getPto2(), i, 8);
            modelPhylon.setValueAt(inv.getPto3(), i, 9);
            modelPhylon.setValueAt(inv.getPto4(), i, 10);
            modelPhylon.setValueAt(inv.getPto5(), i, 11);
            modelPhylon.setValueAt(inv.getPto6(), i, 12);
            modelPhylon.setValueAt(inv.getPto7(), i, 13);
            modelPhylon.setValueAt(inv.getPto8(), i, 14);
            modelPhylon.setValueAt(inv.getPto9(), i, 15);
            modelPhylon.setValueAt(inv.getPto10(), i, 16);
            modelPhylon.setValueAt(inv.getPto11(), i, 17);
            modelPhylon.setValueAt(inv.getPto12(), i, 18);
            modelPhylon.setValueAt(inv.getPto13(), i, 19);
            modelPhylon.setValueAt(inv.getPto14(), i, 20);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 21);
        }
    }

    private void LoadModelPhyA() {
        ArrayList<Infisico> listaInv = objF.InvGetAllA();

        modelPhylon.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelPhylon.setValueAt(inv.getProducto(), i, 0);
            modelPhylon.setValueAt(inv.getAlmacen(), i, 2);
            modelPhylon.setValueAt(inv.getEstilo(), i, 3);
            modelPhylon.setValueAt(inv.getCorrida(), i, 4);
            modelPhylon.setValueAt(inv.getCombinacion(), i, 5);
            modelPhylon.setValueAt(inv.getTipo(), i, 6);
            modelPhylon.setValueAt(inv.getPto1(), i, 7);
            modelPhylon.setValueAt(inv.getPto2(), i, 8);
            modelPhylon.setValueAt(inv.getPto3(), i, 9);
            modelPhylon.setValueAt(inv.getPto4(), i, 10);
            modelPhylon.setValueAt(inv.getPto5(), i, 11);
            modelPhylon.setValueAt(inv.getPto6(), i, 12);
            modelPhylon.setValueAt(inv.getPto7(), i, 13);
            modelPhylon.setValueAt(inv.getPto8(), i, 14);
            modelPhylon.setValueAt(inv.getPto9(), i, 15);
            modelPhylon.setValueAt(inv.getPto10(), i, 16);
            modelPhylon.setValueAt(inv.getPto11(), i, 17);
            modelPhylon.setValueAt(inv.getPto12(), i, 18);
            modelPhylon.setValueAt(inv.getPto13(), i, 19);
            modelPhylon.setValueAt(inv.getPto14(), i, 20);
            modelPhylon.setValueAt(inv.getTotalPares(), i, 21);
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

    private void Setear() {
        JtPares.setText("");
        JtAm.setText("");
        JtProducto.setText("");
        JtAm.requestFocus();
        limpiarRCPT();
        Psuelas.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbClean;
    private javax.swing.JButton JbGenerar;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JButton JbRemove;
    private javax.swing.JLabel JlPares;
    public javax.swing.JTextField JtAm;
    public javax.swing.JTextField JtPares;
    private javax.swing.JTable JtPhylon;
    public javax.swing.JTextField JtProducto;
    private javax.swing.JPanel Psuelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<PtProducto> listaRCPT;
    // End of variables declaration//GEN-END:variables
}
