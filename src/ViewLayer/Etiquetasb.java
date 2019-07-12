package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.ObjectEtiquetas;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Producto;
import ObjectLayer.Validacion;
import ObjectLayer.etiqueta;
import java.awt.Dimension;
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

public class Etiquetasb extends javax.swing.JDialog {

    String informacion = "";
    ObjectProductos ObjP = new ObjectProductos();
    ArrayList<etiqueta> listaetiqueta = new ArrayList<>();
    Vector<Almacen> listaalmacen = new Vector<>();

    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();

    public Etiquetasb(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        Calendar fecha = new GregorianCalendar();
        JeFecha.setCalendar(fecha);
        JeTalla.requestFocus();

    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JeTalla = new javax.swing.JTextField();
        JePares = new javax.swing.JTextField();
        Etq = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JeFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        JtColor = new javax.swing.JTextField();
        JtLote = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JcModelo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GENERAR ETIQUETAS");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("MODELO");

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

        Etq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/labelprint.png"))); // NOI18N
        Etq.setText("Generar Etiqueta");
        Etq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtqActionPerformed(evt);
            }
        });

        jLabel2.setText("FECHA");

        JeFecha.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel6.setText("COLOR:");

        JtColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtColorMouseClicked(evt);
            }
        });
        JtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtColorActionPerformed(evt);
            }
        });
        JtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtColorKeyPressed(evt);
            }
        });

        JtLote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtLoteMouseClicked(evt);
            }
        });
        JtLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtLoteActionPerformed(evt);
            }
        });
        JtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtLoteKeyPressed(evt);
            }
        });

        jLabel7.setText("LOTE:");

        JcModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MIDSOLE", "ABZORB" }));
        JcModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcModeloItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Etq)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(JtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(JcModelo, javax.swing.GroupLayout.Alignment.LEADING, 0, 106, Short.MAX_VALUE)
                                                .addComponent(JeTalla, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JePares, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JcModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JeTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JePares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(Etq)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JeTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JeTallaActionPerformed
        JePares.requestFocus();
    }//GEN-LAST:event_JeTallaActionPerformed

    private void EtqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtqActionPerformed
        setEtiqueta();
    }//GEN-LAST:event_EtqActionPerformed

    private void JeParesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JeParesActionPerformed
        JtColor.requestFocus();

    }//GEN-LAST:event_JeParesActionPerformed

    private void JeTallaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JeTallaKeyPressed

    }//GEN-LAST:event_JeTallaKeyPressed

    private void JeTallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JeTallaMouseClicked
        JeTalla.setText("");
    }//GEN-LAST:event_JeTallaMouseClicked

    private void JeParesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JeParesMouseClicked
        JePares.setText("");
    }//GEN-LAST:event_JeParesMouseClicked

    private void JtColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtColorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtColorMouseClicked

    private void JtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtColorActionPerformed
        JtLote.requestFocus();
    }//GEN-LAST:event_JtColorActionPerformed

    private void JtColorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtColorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtColorKeyPressed

    private void JtLoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtLoteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtLoteMouseClicked

    private void JtLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtLoteActionPerformed
        Etq.requestFocus();
    }//GEN-LAST:event_JtLoteActionPerformed

    private void JtLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtLoteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtLoteKeyPressed

    private void JcModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcModeloItemStateChanged
        JeTalla.requestFocus();
    }//GEN-LAST:event_JcModeloItemStateChanged
    private void Cerrar() {
//        String botones[] = {"SI", "NO"};
//        int eleccion = JOptionPane.showOptionDialog(this,"¿Deseas cerrar esta ventana?", "TOP-SUELAS", 
//                0, 0, null, botones, this);
//        if(eleccion == JOptionPane.YES_OPTION){
        dispose();

//        }else if(eleccion == JOptionPane.NO_OPTION){       
//        }
    }

    private void limpiar() {

    }

    public void setEtiqueta() {
        try {
            ObjectEtiquetas obje = new ObjectEtiquetas();
            Map parametros = new HashMap();
            parametros.put("a", "a");
            ArrayList<Object> reports = new ArrayList<>();
            etiqueta e = new etiqueta();
            DateFormat df = DateFormat.getDateInstance();
            boolean a = JeFecha.isValid();
            e.setFecha((JeFecha.isValid()) ? df.format(JeFecha.getDate()) : "");
            e.setPunto(JeTalla.getText());
            e.setPares(JePares.getText());
            e.setModelo(JcModelo.getSelectedItem().toString());
            e.setColor(JtColor.getText().toUpperCase());
            e.setDescripcion(JtLote.getText());
            //e.setLote(Integer.parseInt());
            String reporte = (e.getModelo().equals("MIDSOLE")) ? "EtiquetaCodigoA" : "EtiquetaCodigoB";
            reports.add(e);
            this.dispose();
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/" + reporte + ".jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, new JRBeanCollectionDataSource(reports));
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    setVisible(true);
                    //limpiar();
                }
            });
            ver.setTitle("ETIQUETAS");
            ver.setVisible(true);
            Calendar fecha = new GregorianCalendar();
            JeFecha.setCalendar(fecha);

//            
        } catch (Exception ex) {
            Logger.getLogger(Etiquetasb.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Etiquetasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Etiquetasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Etiquetasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Etiquetasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Etiquetasb dialog = new Etiquetasb(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Etq;
    private javax.swing.JComboBox<String> JcModelo;
    private com.toedter.calendar.JDateChooser JeFecha;
    private javax.swing.JTextField JePares;
    private javax.swing.JTextField JeTalla;
    private javax.swing.JTextField JtColor;
    private javax.swing.JTextField JtLote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
