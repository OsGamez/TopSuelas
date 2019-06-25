package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Infisico;
import ObjectLayer.ObjectAlmacenes;
import ObjectLayer.ObjectInfisico;
import ObjectLayer.ObjectProductos;
import ObjectLayer.ObjectRCPT;
import ObjectLayer.PtProducto;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CapturaInventario extends javax.swing.JFrame {

    ObjectProductos ObjP = new ObjectProductos();
    ObjectAlmacenes ObjA = new ObjectAlmacenes();
    ObjectInfisico objF = new ObjectInfisico();
    ObjectRCPT obj = new ObjectRCPT();
    Connection c = Server.getRcpt();
    String cadena = "";
    int sum, CodigoSuela;
    String am, prod, punto, cantidad;
    int var;
    String c1 = "0", c2 = "0", c3 = "0", c4 = "0", c5 = "0", c6 = "0", c7 = "0", c8 = "0", c9 = "0", c10 = "0", c11 = "0", c12 = "0";
    ArrayList<String> array = new ArrayList<String>();
    File fichero = new File("C:\\tsmanager\\datos.txt");//Archivo usado para guardar y leer los datos, con ruta 
    public String TbTemp = "";
    DefaultTableModel modelP = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public CapturaInventario() {
        initComponents();
        Jpanel.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JtPhylon.getTableHeader().setReorderingAllowed(false);
        LoadColumns();
        LeerDatos();
        OcultarCampos();
        JtCod.setEnabled(false);
    }

    private void BorrarTabla() {
        objF.dropTable(TbTemp);
    }

    private boolean LimpiarTabla() {
        if (objF.deleteTemp(TbTemp)) {
            return true;
        } else {
            return false;
        }
    }

    private void LoadColumns() {
        modelP.addColumn("ID");
        modelP.addColumn("SUELA");
        modelP.addColumn("AM");
        modelP.addColumn("ESTILO");
        modelP.addColumn("CORRIDA");
        modelP.addColumn("CBN");
        modelP.addColumn("TIPO");
        modelP.addColumn("C1");
        modelP.addColumn("C2");
        modelP.addColumn("C3");
        modelP.addColumn("C4");
        modelP.addColumn("C5");
        modelP.addColumn("C6");
        modelP.addColumn("C7");
        modelP.addColumn("C8");
        modelP.addColumn("C9");
        modelP.addColumn("C10");
        modelP.addColumn("C11");
        modelP.addColumn("C12");
        modelP.addColumn("C13");
        modelP.addColumn("C14");
        modelP.addColumn("PARES");

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

    DefaultListModel<PtProducto> modeloListaProductos = new DefaultListModel<PtProducto>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SUELA = new javax.swing.JLabel();
        JtSuela = new javax.swing.JTextField();
        JbCorrida = new javax.swing.JLabel();
        JbProducto = new javax.swing.JLabel();
        JbIdProd = new javax.swing.JLabel();
        JbPi = new javax.swing.JLabel();
        JbPf = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtPhylon = new javax.swing.JTable();
        Jpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JlistProductos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        JtAm = new javax.swing.JTextField();
        JlPares = new javax.swing.JLabel();
        JtPares = new javax.swing.JTextField();
        JbEstilo = new javax.swing.JLabel();
        JbCombinacion = new javax.swing.JLabel();
        JbRemove = new javax.swing.JButton();
        JbClean = new javax.swing.JButton();
        JbGenerar = new javax.swing.JButton();
        JbGuardar = new javax.swing.JButton();
        JcCódigo = new javax.swing.JCheckBox();
        JtCod = new javax.swing.JTextField();
        JbIdSuela = new javax.swing.JLabel();
        JbAm = new javax.swing.JLabel();
        JbPunto = new javax.swing.JLabel();
        JbCantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        SUELA.setText("SUELA");

        JtSuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtSuelaMouseClicked(evt);
            }
        });
        JtSuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtSuelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtSuelaKeyTyped(evt);
            }
        });

        JbCorrida.setText("jLabel1");

        JbProducto.setText("jLabel1");

        JbIdProd.setText("jLabel1");

        JbPi.setText("jLabel1");

        JbPf.setText("jLabel1");

        JtPhylon.setModel(modelP);
        JtPhylon.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane2.setViewportView(JtPhylon);

        Jpanel.setBorder(null);

        JlistProductos.setModel(modeloListaProductos);
        JlistProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlistProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JlistProductos);

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Almacén:");

        JtAm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtAmActionPerformed(evt);
            }
        });

        JlPares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlPares.setText("Pares:");

        JtPares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtParesActionPerformed(evt);
            }
        });

        JbEstilo.setText("jLabel2");

        JbCombinacion.setText("jLabel2");

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

        JcCódigo.setText("Leer Códigos");
        JcCódigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcCódigoItemStateChanged(evt);
            }
        });

        JtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCodActionPerformed(evt);
            }
        });

        JbIdSuela.setText("jLabel2");

        JbAm.setText("jLabel2");

        JbPunto.setText("jLabel2");

        JbCantidad.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(JlPares)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbEstilo)
                                        .addGap(18, 18, 18)
                                        .addComponent(JbCombinacion)
                                        .addGap(22, 22, 22)
                                        .addComponent(JbIdSuela))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(JbClean, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(JbGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JbCorrida)
                        .addGap(18, 18, 18)
                        .addComponent(JbProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbIdProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbPi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbPf)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SUELA)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbPunto)
                            .addComponent(JbCantidad))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbAm)
                        .addGap(55, 55, 55)
                        .addComponent(JcCódigo)
                        .addGap(46, 46, 46)
                        .addComponent(JtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUELA)
                    .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JlPares)
                    .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbPunto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbRemove)
                            .addComponent(JbClean)
                            .addComponent(JbGenerar)
                            .addComponent(JbGuardar))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbCorrida)
                            .addComponent(JbProducto)
                            .addComponent(JbIdProd)
                            .addComponent(JbPi)
                            .addComponent(JbPf)
                            .addComponent(JbEstilo)
                            .addComponent(JbCombinacion)
                            .addComponent(JbIdSuela)
                            .addComponent(JbAm))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(JbCantidad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcCódigo)
                            .addComponent(JtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtSuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyReleased
        Jpanel.setVisible(true);
        limpiarListaProductos();
        if (JtSuela.getText().isEmpty()) {
            limpiarListaProductos();
            Jpanel.setVisible(false);
        } else {
            ArrayList<PtProducto> listaProd = obj.getById(JtSuela.getText());

            for (PtProducto prod : listaProd) {
                modeloListaProductos.addElement(prod);
            }
        }
    }//GEN-LAST:event_JtSuelaKeyReleased

    private void JtSuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtSuelaKeyTyped

    private void JlistProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlistProductosMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            PtProducto prod = (PtProducto) lis.getSelectedValue();
            JbCorrida.setText(String.valueOf(prod.getCorrida()));
            JbProducto.setText(prod.getDescripcion());
            JbIdProd.setText(String.valueOf(prod.getProducto()));
            JbPi.setText(String.valueOf(prod.getPti()));
            JbPf.setText(String.valueOf(prod.getPtf()));
            JbEstilo.setText(String.valueOf(prod.getEstilo()));
            JbCombinacion.setText(String.valueOf(prod.getCombinacion()));
            limpiarListaProductos();
            Jpanel.setVisible(false);
            ValidarCorrida();
        }
    }//GEN-LAST:event_JlistProductosMouseClicked

    public void MostrarDetalle() {
        Object[] obj = array.toArray();
        String dt[] = new String[22];

        switch (obj.length) {
            case 12:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                c7 = (String) obj[6];
                c8 = (String) obj[7];
                c9 = (String) obj[8];
                c10 = (String) obj[9];
                c11 = (String) obj[10];
                c12 = (String) obj[11];
                break;
            case 10:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                c7 = (String) obj[6];
                c8 = (String) obj[7];
                c9 = (String) obj[8];
                c10 = (String) obj[9];
                break;
            case 8:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                c7 = (String) obj[6];
                c8 = (String) obj[7];
                break;
            case 6:
                c1 = (String) obj[0];
                c2 = (String) obj[1];
                c3 = (String) obj[2];
                c4 = (String) obj[3];
                c5 = (String) obj[4];
                c6 = (String) obj[5];
                break;
            default:
                break;
        }
        dt[0] = JbIdProd.getText();
        dt[1] = JbProducto.getText();
        dt[2] = JtAm.getText();
        dt[3] = JbEstilo.getText();
        dt[4] = JbCorrida.getText();
        dt[5] = JbCombinacion.getText();
        dt[6] = "E";
        dt[7] = c1;
        dt[8] = c2;
        dt[9] = c3;
        dt[10] = c4;
        dt[11] = c5;
        dt[12] = c6;
        dt[13] = c7;
        dt[14] = c8;
        dt[15] = c9;
        dt[16] = c10;
        dt[17] = c11;
        dt[18] = c12;
        dt[19] = "0";
        dt[20] = "0";
        dt[21] = JtPares.getText();
        modelP.addRow(dt);
        array.clear();
        LimpiarCampos();
    }

    private void DesabilitarCampos() {
        JtAm.setEnabled(false);
        JtPares.setEnabled(false);
        JtSuela.setEnabled(false);
        JtCod.setEnabled(true);
        JtCod.requestFocus();
    }

    private void HabilitarCampos() {
        JtAm.setEnabled(true);
        JtPares.setEnabled(true);
        JtSuela.setEnabled(true);
        JtCod.setEnabled(false);
        JtAm.requestFocus();
    }

    private void LimpiarCampos() {
        JtAm.setText("");
        JtSuela.setText("");
        JtPares.setText("");
        JbCorrida.setText("");
        JbEstilo.setText("");
        JbCombinacion.setText("");
        JbProducto.setText("");
        JbIdProd.setText("");
        JbPi.setText("");
        JbPf.setText("");
    }

    private void CleanTable() {
        int numFilas = modelP.getRowCount();

        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelP.removeRow(i);
            }
        }
    }

    private void JtParesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtParesActionPerformed
        if (JtPares.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ingresaste una cantidad");
        } else {
            JtSuela.requestFocus();
        }
    }//GEN-LAST:event_JtParesActionPerformed

    private void JtAmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtAmActionPerformed
        ArrayList<PtProducto> listaA = obj.getPhyAlmacen(JtAm.getText());

        if (JtAm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ingresaste un numero de almacén");
        } else {
            if (listaA.size() > 0) {
                JtPares.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Este almacén no existe");
            }
        }

    }//GEN-LAST:event_JtAmActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (array.size() > 0) {
            MostrarDetalle();
        }
    }//GEN-LAST:event_formWindowActivated

    private void JbRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbRemoveActionPerformed
        int row = JtPhylon.getSelectedRow();

        if (row >= 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres omitir este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                modelP.removeRow(row);
                JtAm.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
        }
    }//GEN-LAST:event_JbRemoveActionPerformed

    private void JbCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCleanActionPerformed
        int row = JtPhylon.getRowCount();

        if (row > 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de limpiar los registros?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                if (LimpiarTabla()) {
                    VaciarDatos();
                    CleanTable();
                    JOptionPane.showMessageDialog(null, "Se han limpiado los registros");
                    JtAm.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo limpiar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros");
            JtAm.requestFocus();
        }
    }//GEN-LAST:event_JbCleanActionPerformed

    private void JbGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGenerarActionPerformed
        Generar();
    }//GEN-LAST:event_JbGenerarActionPerformed

    private void Generar() {
        String tipo = "S";
        String ms = "";
        int row = JtPhylon.getRowCount();

        if (ValidarDetalle()) {
            if (objF.VerificarTabla(TbTemp) == 0) {//Verifica si existe la tabla temporal 
                if (objF.CrearTb(TbTemp)) {//Crea la tabla
                    //Inserta los datos
                    for (int i = 0; i < row; i++) {
                        Infisico inv = new Infisico();
                        inv.setProducto(Integer.parseInt((String) JtPhylon.getValueAt(i, 0)));
                        inv.setAlmacen(Integer.parseInt((String) JtPhylon.getValueAt(i, 2)));
                        inv.setEstilo(Integer.parseInt((String) JtPhylon.getValueAt(i, 3)));
                        inv.setCorrida(Integer.parseInt((String) JtPhylon.getValueAt(i, 4)));
                        inv.setCombinacion(Integer.parseInt((String) JtPhylon.getValueAt(i, 5)));
                        inv.setTipo(tipo);
                        inv.setPto1(Integer.parseInt((String) JtPhylon.getValueAt(i, 7)));
                        inv.setPto2(Integer.parseInt((String) JtPhylon.getValueAt(i, 8)));
                        inv.setPto3(Integer.parseInt((String) JtPhylon.getValueAt(i, 9)));
                        inv.setPto4(Integer.parseInt((String) JtPhylon.getValueAt(i, 10)));
                        inv.setPto5(Integer.parseInt((String) JtPhylon.getValueAt(i, 11)));
                        inv.setPto6(Integer.parseInt((String) JtPhylon.getValueAt(i, 12)));
                        inv.setPto7(Integer.parseInt((String) JtPhylon.getValueAt(i, 13)));
                        inv.setPto8(Integer.parseInt((String) JtPhylon.getValueAt(i, 14)));
                        inv.setPto9(Integer.parseInt((String) JtPhylon.getValueAt(i, 15)));
                        inv.setPto10(Integer.parseInt((String) JtPhylon.getValueAt(i, 16)));
                        inv.setPto11(Integer.parseInt((String) JtPhylon.getValueAt(i, 17)));
                        inv.setPto12(Integer.parseInt((String) JtPhylon.getValueAt(i, 18)));
                        inv.setPto13(Integer.parseInt((String) JtPhylon.getValueAt(i, 19)));
                        inv.setPto14(Integer.parseInt((String) JtPhylon.getValueAt(i, 20)));
                        inv.setTotalPares(Integer.parseInt((String) JtPhylon.getValueAt(i, 21)));

                        if (objF.AddTemporal(inv, TbTemp)) {
                            ms = "OK";
                        } else {
                            ms = "ERROR";
                        }
                    }
                }
            } else {
                //Si la tabla existe
                if (LimpiarTabla()) {
                    for (int i = 0; i < row; i++) {
                        Infisico inv = new Infisico();
                        inv.setProducto(Integer.parseInt((String) JtPhylon.getValueAt(i, 0)));
                        inv.setAlmacen(Integer.parseInt((String) JtPhylon.getValueAt(i, 2)));
                        inv.setEstilo(Integer.parseInt((String) JtPhylon.getValueAt(i, 3)));
                        inv.setCorrida(Integer.parseInt((String) JtPhylon.getValueAt(i, 4)));
                        inv.setCombinacion(Integer.parseInt((String) JtPhylon.getValueAt(i, 5)));
                        inv.setTipo(tipo);
                        inv.setPto1(Integer.parseInt((String) JtPhylon.getValueAt(i, 7)));
                        inv.setPto2(Integer.parseInt((String) JtPhylon.getValueAt(i, 8)));
                        inv.setPto3(Integer.parseInt((String) JtPhylon.getValueAt(i, 9)));
                        inv.setPto4(Integer.parseInt((String) JtPhylon.getValueAt(i, 10)));
                        inv.setPto5(Integer.parseInt((String) JtPhylon.getValueAt(i, 11)));
                        inv.setPto6(Integer.parseInt((String) JtPhylon.getValueAt(i, 12)));
                        inv.setPto7(Integer.parseInt((String) JtPhylon.getValueAt(i, 13)));
                        inv.setPto8(Integer.parseInt((String) JtPhylon.getValueAt(i, 14)));
                        inv.setPto9(Integer.parseInt((String) JtPhylon.getValueAt(i, 15)));
                        inv.setPto10(Integer.parseInt((String) JtPhylon.getValueAt(i, 16)));
                        inv.setPto11(Integer.parseInt((String) JtPhylon.getValueAt(i, 17)));
                        inv.setPto12(Integer.parseInt((String) JtPhylon.getValueAt(i, 18)));
                        inv.setPto13(Integer.parseInt((String) JtPhylon.getValueAt(i, 19)));
                        inv.setPto14(Integer.parseInt((String) JtPhylon.getValueAt(i, 20)));
                        inv.setTotalPares(Integer.parseInt((String) JtPhylon.getValueAt(i, 21)));

                        if (objF.AddTemporal(inv, TbTemp)) {
                            ms = "OK";
                        } else {
                            ms = "ERROR";
                        }
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

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        if (ValidarDetalle()) {
            if (objF.VerificarTabla(TbTemp) == 0) {
                JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
            } else {
                if (objF.validarInv(TbTemp) == 0) {
                    JOptionPane.showMessageDialog(null, "Revisa el registro antes del concentrado");
                } else {
                    ReporteGroup();
                }
            }

        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtSuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtSuelaMouseClicked
        if (evt.getClickCount() > 1) {
            JtSuela.setText("");
            limpiarListaProductos();
            Jpanel.setVisible(false);
        }
    }//GEN-LAST:event_JtSuelaMouseClicked

    private void JcCódigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcCódigoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            DesabilitarCampos();
        } else {
            HabilitarCampos();
        }

    }//GEN-LAST:event_JcCódigoItemStateChanged

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            System.out.println("BIEN");
        }
    }//GEN-LAST:event_formKeyPressed

    private void JtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCodActionPerformed
        String cadena = JtCod.getText();

        if (JtAm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes de elegir un almacén", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            JtCod.setText("");
        } else {
            if (cadena.length() != 13) {
                JOptionPane.showMessageDialog(null, "El tamaño del código no es correcto", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                JtCod.setText("");
            } else {
                am = cadena.substring(0, 2);
                prod = cadena.substring(2, 7);
                CodigoSuela = Integer.parseInt(prod);
                punto = cadena.substring(7, 10);
                cantidad = cadena.substring(10, 13);
                ObtenerProductoRCPT();
                ComprobaroPuntos();
            }
        }
    }//GEN-LAST:event_JtCodActionPerformed

    private void ObtenerProductoRCPT() {
        ArrayList<PtProducto> listaProd = obj.GetByInventario(CodigoSuela);

        if (listaProd.size() > 0) {
            for (PtProducto pt : listaProd) {
                JbCorrida.setText(String.valueOf(pt.getCorrida()));
                JbProducto.setText(pt.getDescripcion());
                JbIdProd.setText(String.valueOf(pt.getSuelaPhy()));
                JbPi.setText(String.valueOf(pt.getPti()));
                JbPf.setText(String.valueOf(pt.getPtf()));
                JbEstilo.setText(String.valueOf(pt.getEstilo()));
                JbCombinacion.setText(String.valueOf(pt.getCombinacion()));
                JbIdSuela.setText(String.valueOf(pt.getSuelaPhy()));
                //JbAm.setText(am);
                JbPunto.setText(punto);
                JbCantidad.setText(cantidad);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            JtCod.setText("");
        }
    }

    private void ComprobaroPuntos() {
        String dt[] = new String[22];
        float Pti = Float.parseFloat(JbPi.getText());
        float pto = Float.parseFloat(punto) / 10;
        int cant = Integer.parseInt(JbCantidad.getText());
        //int almacen = Integer.parseInt(JbAm.getText());
        float num = .5f;

        for (float i = Pti; i <= pto; i++) {
            array.add(String.valueOf(cant));
        }

        if (Pti != pto) {
            for (float j = Pti + num; j <= pto; j++) {
                array.add(String.valueOf(cant));
            }
        }

        switch (array.size()) {
            case 12:
                c12 = String.valueOf(cant);
                break;
            case 11:
                c11 = String.valueOf(cant);
                break;
            case 10:
                c10 = String.valueOf(cant);
                break;
            case 9:
                c9 = String.valueOf(cant);
                break;
            case 8:
                c8 = String.valueOf(cant);
                break;
            case 7:
                c7 = String.valueOf(cant);
                break;
            case 6:
                c6 = String.valueOf(cant);
                break;
            case 5:
                c5 = String.valueOf(cant);
                break;
            case 4:
                c4 = String.valueOf(cant);
                break;
            case 3:
                c3 = String.valueOf(cant);
                break;
            case 2:
                c2 = String.valueOf(cant);
                break;
            case 1:
                c1 = String.valueOf(cant);
                break;
            default:
                break;
        }
        dt[0] = JbIdProd.getText();
        dt[1] = JbProducto.getText();
        dt[2] = JtAm.getText();
        dt[3] = JbEstilo.getText();
        dt[4] = JbCorrida.getText();
        dt[5] = JbCombinacion.getText();
        dt[6] = "E";
        dt[7] = c1;
        dt[8] = c2;
        dt[9] = c3;
        dt[10] = c4;
        dt[11] = c5;
        dt[12] = c6;
        dt[13] = c7;
        dt[14] = c8;
        dt[15] = c9;
        dt[16] = c10;
        dt[17] = c11;
        dt[18] = c12;
        dt[19] = "0";
        dt[20] = "0";
        dt[21] = String.valueOf(cant);
        modelP.addRow(dt);
        LimpiarRegistro();
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
            BorrarTabla();
            //VaciarDatos();
        }
    }

    private void LoadModelPhy() {
        ArrayList<Infisico> listaInv = objF.InvGetTemp(TbTemp);

        modelP.setNumRows(listaInv.size());

        for (int i = 0; i < listaInv.size(); i++) {
            Infisico inv = listaInv.get(i);

            modelP.setValueAt(inv.getProducto(), i, 0);
            modelP.setValueAt(inv.getAlmacen(), i, 2);
            modelP.setValueAt(inv.getEstilo(), i, 3);
            modelP.setValueAt(inv.getCorrida(), i, 4);
            modelP.setValueAt(inv.getCombinacion(), i, 5);
            modelP.setValueAt(inv.getTipo(), i, 6);
            modelP.setValueAt(inv.getPto1(), i, 7);
            modelP.setValueAt(inv.getPto2(), i, 8);
            modelP.setValueAt(inv.getPto3(), i, 9);
            modelP.setValueAt(inv.getPto4(), i, 10);
            modelP.setValueAt(inv.getPto5(), i, 11);
            modelP.setValueAt(inv.getPto6(), i, 12);
            modelP.setValueAt(inv.getPto7(), i, 13);
            modelP.setValueAt(inv.getPto8(), i, 14);
            modelP.setValueAt(inv.getPto9(), i, 15);
            modelP.setValueAt(inv.getPto10(), i, 16);
            modelP.setValueAt(inv.getPto11(), i, 17);
            modelP.setValueAt(inv.getPto12(), i, 18);
            modelP.setValueAt(inv.getPto13(), i, 19);
            modelP.setValueAt(inv.getPto14(), i, 20);
            modelP.setValueAt(inv.getTotalPares(), i, 21);
        }
    }

    private void ReporteGroup() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InPhylon.jasper"));
            try {
                Map par = new HashMap();
                par.put("tabla", TbTemp);
                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        if (JOptionPane.showConfirmDialog(null, new Object[]{"Quieres guardar las suelas en el inventario?"}, "JOPtion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
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

    private void Reporte() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InPhylonS.jasper"));
            try {
                Map par = new HashMap();
                par.put("tabla", TbTemp);
                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
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

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
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

    private void ValidarCorrida() {
        int pt1 = Integer.parseInt(JbPi.getText());
        int pt2 = Integer.parseInt(JbPf.getText());
        double num = 0.5;

        sum = pt2 - pt1 + 1;

        String colums = null;
        Object[] datos = {""};
        PuntosCaptura p = new PuntosCaptura(null, true);
        for (int i = pt1; i <= pt2; i++) {
            colums = String.valueOf(i);
            p.modelP.addColumn(colums, datos);

            for (double j = i + num; j <= i + num; j++) {
                colums = String.valueOf(j);
                p.modelP.addColumn(colums, datos);
            }
        }
        p.SumaPuntos = sum;
        p.Pares = Integer.parseInt(JtPares.getText());
        p.Jtdatos.changeSelection(0, 0, true, false);
        p.array = array;
        p.setVisible(true);
    }

    private void limpiarListaProductos() {
        modeloListaProductos.clear();
    }

    private void OcultarCampos() {
        JbCorrida.setVisible(false);
        JbProducto.setVisible(false);
        JbIdProd.setVisible(false);
        JbPi.setVisible(false);
        JbPf.setVisible(false);
        JbEstilo.setVisible(false);
        JbCombinacion.setVisible(false);
        JbIdSuela.setVisible(false);
        JbPunto.setVisible(false);
        JbCantidad.setVisible(false);
        JbAm.setVisible(false);
    }

    private void LimpiarRegistro() {
        JbCorrida.setText("");
        JbProducto.setText("");
        JbIdProd.setText("");
        JbPi.setText("");
        JbPf.setText("");
        JbEstilo.setText("");
        JbCombinacion.setText("");
        JbIdSuela.setText("");
        JbPunto.setText("");
        JbCantidad.setText("");
        JbAm.setText("");
        JtCod.setText("");
        array.clear();
        c1 = "0";
        c2 = "0";
        c3 = "0";
        c4 = "0";
        c5 = "0";
        c6 = "0";
        c7 = "0";
        c8 = "0";
        c9 = "0";
        c10 = "0";
        c11 = "0";
        c12 = "0";
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
                    }
                    bw.newLine();
                }
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

                while ((linea = br.readLine()) != null) {
                    if (linea.equals("")) {
                        System.out.println("VACIO");
                    } else {
                        StringTokenizer dt = new StringTokenizer(linea, "|");
                        Vector x = new Vector();
                        while (dt.hasMoreTokens()) {
                            x.addElement(dt.nextToken());
                        }
                        modelP.addRow(x);
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

    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            if (this.JtPhylon.getRowCount() == 0 && this.JtPhylon.getSelectedRow() == -1) {
                this.dispose();
            } else {
                GuardarFichero();
                this.dispose();

            }
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
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
            java.util.logging.Logger.getLogger(CapturaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturaInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbAm;
    private javax.swing.JLabel JbCantidad;
    private javax.swing.JButton JbClean;
    private javax.swing.JLabel JbCombinacion;
    private javax.swing.JLabel JbCorrida;
    private javax.swing.JLabel JbEstilo;
    private javax.swing.JButton JbGenerar;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbIdSuela;
    private javax.swing.JLabel JbPf;
    private javax.swing.JLabel JbPi;
    private javax.swing.JLabel JbProducto;
    private javax.swing.JLabel JbPunto;
    private javax.swing.JButton JbRemove;
    private javax.swing.JCheckBox JcCódigo;
    private javax.swing.JLabel JlPares;
    private javax.swing.JList<PtProducto> JlistProductos;
    private javax.swing.JPanel Jpanel;
    public javax.swing.JTextField JtAm;
    private javax.swing.JTextField JtCod;
    public javax.swing.JTextField JtPares;
    public javax.swing.JTable JtPhylon;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JLabel SUELA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
