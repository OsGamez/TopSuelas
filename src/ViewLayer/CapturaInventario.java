package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.Infisico;
import ObjectLayer.ObjectAlmacenes;
import ObjectLayer.ObjectInfisico;
import ObjectLayer.ObjectProductos;
import ObjectLayer.ObjectRCPT;
import ObjectLayer.PtProducto;
import ObjectLayer.Sesioninfo;
import ObjectLayer.objInv;
import Plugins.Sound;
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
import java.util.StringTokenizer;
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
    objInv inv = new objInv();
    ObjectRCPT obj = new ObjectRCPT();
    Sesioninfo sesion = new Sesioninfo();
    Connection c = Server.getRcpt();
    Sound sn = new Sound();
    String cadena = "";
    int sum, CodigoSuela, contador = 0;
    String am, prod, punto, cantidad, tipo = "S", ms;
    int var;
    String c1 = "0", c2 = "0", c3 = "0", c4 = "0", c5 = "0", c6 = "0", c7 = "0", c8 = "0", c9 = "0", c10 = "0", c11 = "0", c12 = "0";
    ArrayList<String> array = new ArrayList<>();
    File fichero = new File("C:\\tsmanager\\datos.txt");//Archivo usado para guardar y leer los datos, con ruta 
    String TbTemp = "";
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
        OcultarCampos();
        TbTemp = sesion.getUsuario();
        LoadModelPhy();
    }

    private boolean LimpiarTabla() {
        return objF.deleteTemp();
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
        JlistProductos = new javax.swing.JList<PtProducto>();
        jLabel1 = new javax.swing.JLabel();
        JtAm = new javax.swing.JTextField();
        JlPares = new javax.swing.JLabel();
        JtPares = new javax.swing.JTextField();
        JbEstilo = new javax.swing.JLabel();
        JbCombinacion = new javax.swing.JLabel();
        JbRemove = new javax.swing.JButton();
        JbClean = new javax.swing.JButton();
        JbGenerar = new javax.swing.JButton();
        JbIdSuela = new javax.swing.JLabel();
        JbAm = new javax.swing.JLabel();
        JbPunto = new javax.swing.JLabel();
        JbCantidad = new javax.swing.JLabel();
        JcCaptura = new javax.swing.JCheckBox();
        JcAgrupado = new javax.swing.JCheckBox();
        JcAgrupadoA = new javax.swing.JCheckBox();
        JbEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTARIO FISICO");
        setLocation(new java.awt.Point(100, 100));
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

        JbIdSuela.setText("jLabel2");

        JbAm.setText("jLabel2");

        JbPunto.setText("jLabel2");

        JbCantidad.setText("jLabel2");

        JcCaptura.setText("Captura");
        JcCaptura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcCapturaItemStateChanged(evt);
            }
        });

        JcAgrupado.setText("Agrupado / Linea");
        JcAgrupado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcAgrupadoItemStateChanged(evt);
            }
        });

        JcAgrupadoA.setText("Agrupado / Almacén");
        JcAgrupadoA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcAgrupadoAItemStateChanged(evt);
            }
        });

        JbEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N
        JbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(524, 524, 524)
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
                            .addComponent(JbCantidad)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(JlPares)
                                                .addGap(18, 18, 18)
                                                .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JbEstilo)
                                                .addGap(18, 18, 18)
                                                .addComponent(JbCombinacion)))
                                        .addGap(22, 22, 22)
                                        .addComponent(JbIdSuela)
                                        .addGap(18, 18, 18)
                                        .addComponent(JbAm))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(JbClean, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(JbGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(JbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(JcCaptura)
                                        .addGap(47, 47, 47)
                                        .addComponent(JcAgrupado)
                                        .addGap(34, 34, 34)
                                        .addComponent(JcAgrupadoA))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbCorrida)
                                .addGap(18, 18, 18)
                                .addComponent(JbProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbIdProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbPi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbPf)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SUELA)
                            .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbPunto)
                            .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(JlPares)
                            .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(JbCantidad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcCaptura)
                            .addComponent(JcAgrupado)
                            .addComponent(JcAgrupadoA))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            listaProd.forEach((pt) -> {
                modeloListaProductos.addElement(pt);
            });
        }
    }//GEN-LAST:event_JtSuelaKeyReleased

    private void JtSuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyTyped
        char cr = evt.getKeyChar();
        if (Character.isLowerCase(cr)) {
            String cad = ("" + cr).toUpperCase();
            cr = cad.charAt(0);
            evt.setKeyChar(cr);
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

    private void MostrarDetalle() {
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
        dt[6] = tipo;
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

        Infisico inv = new Infisico();
        inv.setProducto(Integer.parseInt(dt[0]));
        inv.setAlmacen(Integer.parseInt(dt[2]));
        inv.setEstilo(Integer.parseInt(dt[3]));
        inv.setCorrida(Integer.parseInt(dt[4]));
        inv.setCombinacion(Integer.parseInt(dt[5]));
        inv.setTipo(tipo);
        inv.setPto1(Integer.parseInt(dt[7]));
        inv.setPto2(Integer.parseInt(dt[8]));
        inv.setPto3(Integer.parseInt(dt[9]));
        inv.setPto4(Integer.parseInt(dt[10]));
        inv.setPto5(Integer.parseInt(dt[11]));
        inv.setPto6(Integer.parseInt(dt[12]));
        inv.setPto7(Integer.parseInt(dt[13]));
        inv.setPto8(Integer.parseInt(dt[14]));
        inv.setPto9(Integer.parseInt(dt[15]));
        inv.setPto10(Integer.parseInt(dt[16]));
        inv.setPto11(Integer.parseInt(dt[17]));
        inv.setPto12(Integer.parseInt(dt[18]));
        inv.setPto13(Integer.parseInt(dt[19]));
        inv.setPto14(Integer.parseInt(dt[20]));
        inv.setTotalPares(Integer.parseInt(dt[21]));
        
        if(objF.AddTemp(inv)){
            modelP.addRow(dt);
            LimpiarCampos();
        }else{
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }

//        if (objF.VerificarTabla(TbTemp) == 0) {//Verifica si existe la tabla temporal 
//            if (objF.CrearTb(TbTemp)) {//Crea la tabla
//                if (objF.AddTemporal(inv, TbTemp)) {
//                    modelP.addRow(dt);
//                    LimpiarCampos();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        } else {
//            if (objF.AddTemporal(inv, TbTemp)) {
//                modelP.addRow(dt);
//                LimpiarCampos();
//            } else {
//                JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
    }

    private void LimpiarCampos() {
        //JtAm.setText("");
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
            LimpiarRegistro();
        }
    }//GEN-LAST:event_formWindowActivated

    private void JbRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbRemoveActionPerformed
        int row = JtPhylon.getSelectedRow();

        if (row >= 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres omitir este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(JtPhylon.getValueAt(row, 0).toString());
                if (objF.deleteByPt(id)) {
                    modelP.removeRow(row);
                    JtAm.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
                }
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
        if (contador > 1) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opción!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        } else if (contador == 0) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionar una opción!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        } else if (contador == 1) {
            if (JcCaptura.isSelected()) {
                Reporte();
            } else if (JcAgrupado.isSelected()) {
                ReporteAgrupado();
            }else if(JcAgrupadoA.isSelected()){
                ReporteAgrupadoAlmacen();
            }
        }
    }//GEN-LAST:event_JbGenerarActionPerformed

    private void Generar() {
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
        if ("OK".equals(ms)) {

        } else if ("ERROR".equals(ms)) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

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

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void JcCapturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcCapturaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcCapturaItemStateChanged

    private void JcAgrupadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAgrupadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcAgrupadoItemStateChanged

    private void JcAgrupadoAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcAgrupadoAItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcAgrupadoAItemStateChanged

    private void JbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEnviarActionPerformed
        if(inv.validarEnvio() == 0){
            CleanTable();
            LoadModelEnvio();
            Guardar();
        }else{
           JOptionPane.showMessageDialog(null, "Tienes folios por afectar", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_JbEnviarActionPerformed

    private void ComprobaroPuntos() {
        String dt[] = new String[22];
        float Pti = Float.parseFloat(JbPi.getText());
        float pto = Float.parseFloat(punto) / 10;
        int cant = Integer.parseInt(JbCantidad.getText());
        //int almacen = Integer.parseInt(JbAm.getText());
        float num = .5f;

        for (float i = Pti; i <= pto; i++) {
            array.add(String.valueOf(cant));
            System.out.println(i);
        }

        if (Pti != pto) {
            for (float j = Pti + num; j <= pto; j++) {
                array.add(String.valueOf(cant));
                System.out.println(j);
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

            Infisico inve = new Infisico();
            inve.setProducto(Pt);
            inve.setAlmacen(Am);
            inve.setEstilo(Est);
            inve.setCorrida(Corr);
            inve.setCombinacion(Comb);
            inve.setTipo(Tipo);
            inve.setPto1(Pto1);
            inve.setPto2(Pto2);
            inve.setPto3(Pto3);
            inve.setPto4(Pto4);
            inve.setPto5(Pto5);
            inve.setPto6(Pto6);
            inve.setPto7(Pto7);
            inve.setPto8(Pto8);
            inve.setPto9(Pto9);
            inve.setPto10(Pto10);
            inve.setPto11(Pto11);
            inve.setPto12(Pto12);
            inve.setPto13(Pto13);
            inve.setPto14(Pto14);
            inve.setTotalPares(Tpares);

            if (objF.AddInventario(inve)) {
                ms = "OK";
            } else {
                ms = "ERROR";
            }
        }

        if ("OK".equals(ms)) {
            JOptionPane.showMessageDialog(this, "Se han agregado los registros al inventario!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            CleanTable();
            //BorrarTabla();
            //VaciarDatos();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            CleanTable();
            LoadModelPhy();
        }
    }

    private void LoadModelPhy() {
        ArrayList<Infisico> listaInv = objF.GetInventario();

        if (listaInv.size() > 0) {
            modelP.setNumRows(listaInv.size());

            for (int i = 0; i < listaInv.size(); i++) {
                Infisico inv = listaInv.get(i);

                modelP.setValueAt(inv.getProducto(), i, 0);
                modelP.setValueAt(inv.getSuela(), i, 1);
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
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void LoadModelEnvio() {
        ArrayList<Infisico> listaInv = objF.GetInventarioAgrupado();

        if (listaInv.size() > 0) {
            modelP.setNumRows(listaInv.size());

            for (int i = 0; i < listaInv.size(); i++) {
                Infisico inv = listaInv.get(i);

                modelP.setValueAt(inv.getProducto(), i, 0);
                modelP.setValueAt(inv.getSuela(), i, 1);
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
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void ReporteAgrupadoAlmacen() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InventarioDetallado.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                view.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    public void windowClosing(java.awt.event.WindowEvent evt) {
//                        if (JOptionPane.showConfirmDialog(null, new Object[]{"Quieres guardar las suelas en el inventario?"}, "JOPtion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
//                            Guardar();
//                        }
//                    }
//                });
            } catch (JRException ex) {
                Logger.getLogger(Bancos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(CapturaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReporteAgrupado() {
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/InvAgrupadoLinea.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(CapturaInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(CapturaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Reporte() {
        try {
            JasperReport reporte;
            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/Inventario.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(CapturaInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(CapturaInventario.class.getName()).log(Level.SEVERE, null, ex);
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
        Object[] datos = {"0"};
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

//    private void LeerDatos() {
//        FileReader fr = null;
//        BufferedReader br = null;
//
//        if (fichero.exists()) {
//            try {
//                fr = new FileReader(fichero);
//                br = new BufferedReader(fr);
//                String linea;
//
//                while ((linea = br.readLine()) != null) {
//                    if (linea.equals("")) {
//                        System.out.println("VACIO");
//                    } else {
//                        StringTokenizer dt = new StringTokenizer(linea, "|");
//                        Vector x = new Vector();
//                        while (dt.hasMoreTokens()) {
//                            x.addElement(dt.nextToken());
//                        }
//                        modelP.addRow(x);
//                    }
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No existe ningun archivo");
//        }
//    }

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
            this.dispose();
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
    private javax.swing.JButton JbEnviar;
    private javax.swing.JLabel JbEstilo;
    private javax.swing.JButton JbGenerar;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbIdSuela;
    private javax.swing.JLabel JbPf;
    private javax.swing.JLabel JbPi;
    private javax.swing.JLabel JbProducto;
    private javax.swing.JLabel JbPunto;
    private javax.swing.JButton JbRemove;
    private javax.swing.JCheckBox JcAgrupado;
    private javax.swing.JCheckBox JcAgrupadoA;
    private javax.swing.JCheckBox JcCaptura;
    private javax.swing.JLabel JlPares;
    private javax.swing.JList<PtProducto> JlistProductos;
    private javax.swing.JPanel Jpanel;
    public javax.swing.JTextField JtAm;
    public javax.swing.JTextField JtPares;
    public javax.swing.JTable JtPhylon;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JLabel SUELA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
