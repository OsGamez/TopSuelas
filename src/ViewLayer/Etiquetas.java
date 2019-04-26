package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.ObjectEtiquetas;
import ObjectLayer.Validacion;
import ObjectLayer.etiqueta;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
    ArrayList<etiqueta> listaetiqueta = new ArrayList<>();
    Vector<Almacen> listaalmacen = new Vector<>();
    ObjectEtiquetas obetq = new ObjectEtiquetas();

    public Etiquetas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        LoadModelEtiqueta();
        LoadModelAlmacen();

    }

    private void LoadModelEtiqueta() {
        ObjectEtiquetas e = new ObjectEtiquetas();
        DefaultComboBoxModel modelEtiqueta = new DefaultComboBoxModel();
        listaetiqueta = e.EtiquetaGetAll();
        Jtp.setModel(modelEtiqueta);
        for (int i = 0; i < listaetiqueta.size(); i++) {
            Jtp.addItem(listaetiqueta.get(i).getDescripcion());
        }
        Jtp.setSelectedIndex(0);
    }

    private void LoadModelAlmacen() {
        Almacen e = new Almacen();
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
        Jemodelo = new javax.swing.JLabel();
        JeAlm = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JeTalla = new javax.swing.JTextField();
        JePares = new javax.swing.JTextField();
        JeAlmacen = new javax.swing.JComboBox<>();
        JeColor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JeFecha = new com.toedter.calendar.JDateChooser();

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

        Jemodelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JeAlm.setText("Almacen:");

        jLabel4.setText("TALLA:");

        jLabel5.setText("PARES:");

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

        JePares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JeParesActionPerformed(evt);
            }
        });

        JeAlmacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JeColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/labelprint.png"))); // NOI18N
        jButton1.setText("Generar Etiqueta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("FECHA");

        JeFecha.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jemodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JeColor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JeAlm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JeAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JeTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JePares, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JeFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(130, 130, 130)
                                    .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Jtp, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jButton1)
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
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jemodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JeColor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JeTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JePares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JeAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JeAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JtpItemStateChanged
        Jemodelo.setText(listaetiqueta.get(Jtp.getSelectedIndex()).getModelo());
        JeColor.setText(listaetiqueta.get(Jtp.getSelectedIndex()).getColor());
    }//GEN-LAST:event_JtpItemStateChanged

    private void JeTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JeTallaActionPerformed
        JePares.requestFocus();
    }//GEN-LAST:event_JeTallaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setEtiqueta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JeParesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JeParesActionPerformed
        JeFecha.requestFocus();
    }//GEN-LAST:event_JeParesActionPerformed

    private void JeTallaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JeTallaKeyPressed
        if(JeTalla.getText().length()>3){
            JOptionPane.showMessageDialog(this, "Considera este ejemplo como talla 25.5", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
            JeTalla.setText("");
        }
    }//GEN-LAST:event_JeTallaKeyPressed
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
            Map parametros = new HashMap();
            parametros.put("a", "a");
            //List<Object> reports = new LinkedList<Object>();
            ArrayList<Object> reports = new ArrayList<>();
            Validacion v = new Validacion();
            int rowprod = Jtp.getSelectedIndex();
            int rowalm = JeAlmacen.getSelectedIndex();
            if (Jtp.getSelectedIndex() == 0
                    || JeAlmacen.getSelectedIndex() == 0 || JeTalla.getText().equals("") || JePares.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Faltan datos por introducir o seleccionar!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            } else if ((!v.verificaflotantes(JeTalla.getText()) || !v.verificanumeros(JeTalla.getText()))
                    && !v.verificanumeros(JePares.getText())) {
                JOptionPane.showMessageDialog(this, "Datos introducidos no validos", "TOP-SUELAS", JOptionPane.ERROR_MESSAGE);
                JeTalla.requestFocus();
            } else if (Float.parseFloat(JeTalla.getText()) >= listaetiqueta.get(rowprod).getPi()
                    && Float.parseFloat(JeTalla.getText()) <= listaetiqueta.get(rowprod).getPf()) {
                
                etiqueta e = new etiqueta();
                DateFormat df = DateFormat.getDateInstance();
                e.setAlmacen(listaalmacen.get(rowalm).getAlmacen());
                e.setProducto(String.valueOf(listaetiqueta.get(rowprod).getProducto()));
                e.setColor(listaetiqueta.get(rowprod).getColor());
                e.setFecha(df.format(JeFecha.getDate()));
                e.setPunto(JeTalla.getText());
                e.setPares(JePares.getText());
                e.setModelo(listaetiqueta.get(rowprod).getModelo());
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
                        limpiar();
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

    public String CreaCodigo(etiqueta e) {
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
        System.out.println(codigo);
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
    private javax.swing.JLabel JeAlm;
    private javax.swing.JComboBox<String> JeAlmacen;
    private javax.swing.JLabel JeColor;
    private com.toedter.calendar.JDateChooser JeFecha;
    private javax.swing.JTextField JePares;
    private javax.swing.JTextField JeTalla;
    private javax.swing.JLabel Jemodelo;
    public javax.swing.JLabel Jtlc;
    private javax.swing.JComboBox<String> Jtp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
