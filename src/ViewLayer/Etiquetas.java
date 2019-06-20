package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.ObjectEtiquetas;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Producto;
import ObjectLayer.Validacion;
import ObjectLayer.etiqueta;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Etiquetas extends javax.swing.JDialog {
    String informacion = "";
    ObjectProductos ObjP = new ObjectProductos();
    ArrayList<etiqueta> listaetiqueta = new ArrayList<>();
    Vector<Almacen> listaalmacen = new Vector<>();
    
    DefaultListModel<Producto> modeloListaProductos= new DefaultListModel<Producto>();

    public Etiquetas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelEtiqueta();
        LoadModelAlmacen();
        Calendar fecha = new GregorianCalendar();
        JeFecha.setCalendar(fecha);
        JbIdProd.setVisible(false);
        Jtp.setVisible(false);

    }

    private void LoadModelEtiqueta() {
//        ObjectEtiquetas e = new ObjectEtiquetas();
//        DefaultComboBoxModel modelEtiqueta = new DefaultComboBoxModel();
//        listaetiqueta = e.EtiquetaGetAll();
//        Jtp.setModel(modelEtiqueta);
//        for (int i = 0; i < listaetiqueta.size(); i++) {
//            Jtp.addItem(listaetiqueta.get(i).getDescripcion());
//        }
//        Jtp.setSelectedIndex(0);
    }

    private void LoadModelAlmacen() {
        Almacen e = new Almacen();
        e.conRCPT();
        DefaultComboBoxModel modelEtiqueta = new DefaultComboBoxModel(e.getAlmacenes());
        listaalmacen = e.getAlmacenes();
        JeAlmacen.setModel(modelEtiqueta);
        JeAlmacen.setSelectedIndex(0);
    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jtlc = new javax.swing.JLabel();
        Jtp = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JeAlm = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JeTalla = new javax.swing.JTextField();
        JePares = new javax.swing.JTextField();
        JeAlmacen = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JeFecha = new com.toedter.calendar.JDateChooser();
        JtProducto = new javax.swing.JTextField();
        JbIdProd = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        JtBase = new javax.swing.JTextField();
        JbNombre = new javax.swing.JLabel();
        JcRadiado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GENERAR ETIQUETAS");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Jtp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Jtp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JtpItemStateChanged(evt);
            }
        });

        jLabel1.setText("Seleccione Producto");

        JeAlm.setText("Almacen:");

        jLabel4.setText("TALLA:");

        jLabel5.setText("PARES:");

        JeTalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JeTallaMouseClicked(evt);
            }
        });
        JeTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JeTallaActionPerformed(evt);
            }
        });
        JeTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JeTallaKeyPressed(evt);
            }
        });

        JePares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JeParesMouseClicked(evt);
            }
        });
        JePares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JeParesActionPerformed(evt);
            }
        });

        JeAlmacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/labelprint.png"))); // NOI18N
        jButton1.setText("Generar Etiqueta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("FECHA");

        JeFecha.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        JtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtProductoMouseClicked(evt);
            }
        });
        JtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtProductoActionPerformed(evt);
            }
        });
        JtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtProductoKeyTyped(evt);
            }
        });

        JbIdProd.setText("jLabel2");

        listaProductos.setModel(modeloListaProductos);
        listaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaProductos);

        jLabel3.setText("BASE:");

        JtBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtBaseActionPerformed(evt);
            }
        });

        JbNombre.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N

        JcRadiado.setText("Radiado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(JeAlm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JeAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JeTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JtBase, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(JePares, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JeFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(JcRadiado)
                                .addGap(85, 85, 85))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(JbIdProd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(JbIdProd)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JeTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JePares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(JtBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcRadiado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JeAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JeAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JtpItemStateChanged

    }//GEN-LAST:event_JtpItemStateChanged

    private void JeTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JeTallaActionPerformed
        JePares.requestFocus();
    }//GEN-LAST:event_JeTallaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setEtiqueta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JeParesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JeParesActionPerformed
       
        JtBase.requestFocus();
    }//GEN-LAST:event_JeParesActionPerformed

    private void JeTallaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JeTallaKeyPressed
        
    }//GEN-LAST:event_JeTallaKeyPressed

    private void JtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyReleased
        limpiarListaProductos();
        if (JtProducto.getText().isEmpty()) {
            limpiarListaProductos();
        } else {
            ArrayList<Producto> listaProductos = ObjP.GetByCosto(JtProducto.getText());

            for (Producto prod : listaProductos) {
                modeloListaProductos.addElement(prod);
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
 private void limpiarListaProductos() {
        modeloListaProductos.clear();
    }
 
    private void listaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProductosMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Producto prod = (Producto) lis.getSelectedValue();
            JtProducto.setText(prod.getDescripcion());
            JbIdProd.setText(String.valueOf(prod.getId_Producto()));
            limpiarListaProductos();
            JeTalla.requestFocus();
        }
    }//GEN-LAST:event_listaProductosMouseClicked

    private void JtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtProductoActionPerformed
        
    }//GEN-LAST:event_JtProductoActionPerformed

    private void JtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtProductoMouseClicked
        JtProducto.setText("");
    }//GEN-LAST:event_JtProductoMouseClicked

    private void JeTallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JeTallaMouseClicked
        JeTalla.setText("");
    }//GEN-LAST:event_JeTallaMouseClicked

    private void JeParesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JeParesMouseClicked
        JePares.setText("");
    }//GEN-LAST:event_JeParesMouseClicked

    private void JtBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtBaseActionPerformed
        int var = Integer.parseInt(JtBase.getText())/ Integer.parseInt(JePares.getText());
        int var2 = Integer.parseInt(JtBase.getText())% Integer.parseInt(JePares.getText());
        JbNombre.setText(String.valueOf(var)+" Etiquetas de "+JePares.getText()+", 1 de " + String.valueOf(var2));
    }//GEN-LAST:event_JtBaseActionPerformed
    private void Cerrar() {
//        String botones[] = {"SI", "NO"};
//        int eleccion = JOptionPane.showOptionDialog(this,"¿Deseas cerrar esta ventana?", "TOP-SUELAS", 
//                0, 0, null, botones, this);
//        if(eleccion == JOptionPane.YES_OPTION){
        dispose();
        
//        }else if(eleccion == JOptionPane.NO_OPTION){       
//        }
    }
    private void limpiar(){
        JeTalla.setText("");
        JePares.setText("");
        Jtp.setSelectedIndex(0);
        JeAlmacen.setSelectedIndex(0);
        
    }

    public void setEtiqueta() {
        try {
            ObjectEtiquetas obje = new ObjectEtiquetas();
            listaetiqueta=obje.EtiquetaBusca(Integer.parseInt(JbIdProd.getText()));
            Map parametros = new HashMap();
            parametros.put("a", "a");
            ArrayList<Object> reports = new ArrayList<>();
            Validacion v = new Validacion();
            int rowprod = 1;
            int rowalm = JeAlmacen.getSelectedIndex();
            String Rader = JcRadiado.isSelected() ? "R": "N";
            if (JeAlmacen.getSelectedIndex() == 0 || JeTalla.getText().equals("") || JePares.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Faltan datos por introducir o seleccionar!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            } else if ( !v.verificanumeros(JePares.getText())) {
                JOptionPane.showMessageDialog(this, "Datos introducidos no validos", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
                JeTalla.requestFocus();
            } else if (Float.parseFloat(JeTalla.getText()) >= listaetiqueta.get(rowprod).getPi()
                    && Float.parseFloat(JeTalla.getText()) <= listaetiqueta.get(rowprod).getPf()) {
                etiqueta e = new etiqueta();
                DateFormat df = DateFormat.getDateInstance();
                e.setAlmacen(listaalmacen.get(rowalm).getAlmacen());
                e.setProducto(JbIdProd.getText());
                e.setColor(listaetiqueta.get(rowprod).getColor());
                e.setFecha(df.format(JeFecha.getDate()));
                e.setPunto(JeTalla.getText());
                e.setPares(JePares.getText());
                e.setModelo(listaetiqueta.get(rowprod).getModelo());
                e.setDescripcion(Rader);
                e.setCodigo(CreaCodigo(e));
                reports.add(e);
                this.dispose();
                JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/EtiquetaCodigo.jasper"));
                JasperPrint print = JasperFillManager.fillReport(jasper, parametros, new JRBeanCollectionDataSource(reports));
                JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
                ver.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        setVisible(true);
                        //limpiar();
                    }
                } );
                ver.setTitle("ETIQUETAS");
                ver.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "La talla especificada no es parte de la corrida del producto", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                JeTalla.requestFocus();
            }
//            
        } catch (Exception ex) {
            Logger.getLogger(Etiquetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String CreaCodigo(etiqueta e) {
        String codigo = (e.getAlmacen() < 10) ? "0" + e.getAlmacen() : e.getAlmacen() + "";//01
        for (int i = e.getProducto().length(); i < 5; i++) {
            codigo += "0";
        }
        codigo += e.getProducto();//0100128
        codigo += (e.getPunto().length() == 1) ? e.getPunto() + "0" : (int) (Float.parseFloat(e.getPunto()) * 10) + "";//0100128265
        for (int i = e.getPares().length(); i < 3; i++) {
            codigo += "0";
        }
        codigo += e.getPares();//01,00128,265,050 {13 numeros}
        //System.out.println(codigo);
        return codigo;
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
            java.util.logging.Logger.getLogger(Etiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Etiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Etiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Etiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Etiquetas dialog = new Etiquetas(new javax.swing.JFrame(), true);
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
    public javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbNombre;
    private javax.swing.JCheckBox JcRadiado;
    private javax.swing.JLabel JeAlm;
    private javax.swing.JComboBox<String> JeAlmacen;
    private com.toedter.calendar.JDateChooser JeFecha;
    private javax.swing.JTextField JePares;
    private javax.swing.JTextField JeTalla;
    private javax.swing.JTextField JtBase;
    public javax.swing.JTextField JtProducto;
    public javax.swing.JLabel Jtlc;
    private javax.swing.JComboBox<String> Jtp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList<Producto> listaProductos;
    // End of variables declaration//GEN-END:variables
}
