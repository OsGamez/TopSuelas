package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.Material;
import ObjectLayer.ObjectEtiquetas;
import ObjectLayer.ObjectMateriales;
import ObjectLayer.ObjectProductos;
import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.Producto;
import ObjectLayer.Proveedor;
import ObjectLayer.ProveedorMPrima;
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

public class OrdenCompra extends javax.swing.JDialog {
    String informacion = "";
    ObjectProveedoresMPrima pm = new ObjectProveedoresMPrima();
    ArrayList<ProveedorMPrima> listaproveedorm;
    ArrayList<Material> listaMaterial;
    ObjectMateriales ObjM = new ObjectMateriales();
    
    DefaultListModel<ProveedorMPrima> modeloListaProveedor= new DefaultListModel<>();
    DefaultListModel<Material> modeloListaMat = new DefaultListModel<>();

    public OrdenCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/etiqueta.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        Calendar fecha = new GregorianCalendar();
        JeFecha.setCalendar(fecha);

    }
    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jtlc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JeFecha = new com.toedter.calendar.JDateChooser();
        JtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProveedor = new javax.swing.JList<>();
        JbIdProd = new javax.swing.JLabel();
        JtMat = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMat = new javax.swing.JList<>();
        JbMat = new javax.swing.JLabel();
        JeFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        JbCvet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GENERAR ETIQUETAS");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione Producto");

        jLabel2.setText("FECHA");

        JeFecha.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        JtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtProveedorMouseClicked(evt);
            }
        });
        JtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtProveedorActionPerformed(evt);
            }
        });
        JtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtProveedorKeyTyped(evt);
            }
        });

        listaProveedor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listaProveedor.setModel(modeloListaProveedor);
        listaProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaProveedor);

        JbIdProd.setText("jLabel3");

        JtMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtMatKeyTyped(evt);
            }
        });

        listaMat.setModel( modeloListaMat);
        listaMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMatMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaMat);

        JbMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMat.setText("Material:");

        JeFecha1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel3.setText("FECHA");

        JbCvet.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(JbIdProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JbCvet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(JtProveedor)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(JbMat)
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(JtMat))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JeFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jtlc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JeFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(JeFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbIdProd)
                    .addComponent(JbCvet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbMat)
                    .addComponent(JtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyReleased
        
        if (JtProveedor.getText().isEmpty()) {
        } else {
            listaproveedorm= pm.ProveedorMPrimaSearch(JtProveedor.getText());
            for(ProveedorMPrima p:listaproveedorm){
                modeloListaProveedor.addElement(p);
            }
        }
    }//GEN-LAST:event_JtProveedorKeyReleased

    private void JtProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProveedorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtProveedorKeyTyped
 private void limpiarListaProductos() {
        modeloListaProveedor.clear();
    }
 
    private void listaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProveedorMouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            ProveedorMPrima p = (ProveedorMPrima) lis.getSelectedValue();
            //JbCorrida.setText(String.valueOf(cr.getCorridas(prod.getId_Producto())));
            JbIdProd.setText(String.valueOf(p.getProveedor())+" "+listaproveedorm.get(lis.getSelectedIndex()).getProveedor());
//            limpiarListaProductos();
          //  JtPt.requestFocus();
        }
    }//GEN-LAST:event_listaProveedorMouseClicked

    private void JtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtProveedorActionPerformed
        
    }//GEN-LAST:event_JtProveedorActionPerformed

    private void JtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtProveedorMouseClicked
        JtProveedor.setText("");
    }//GEN-LAST:event_JtProveedorMouseClicked

    private void JtMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyReleased
       
        if (JtMat.getText().isEmpty()) {
            limpiarMaterial();
        } else {
            limpiarMaterial();
           listaMaterial = ObjM.GetByCosto(JtMat.getText());
            for (Material m : listaMaterial) {
                modeloListaMat.addElement(m);
            }
             for(int i =0;i<listaMaterial.size();i++){
            System.out.println(listaMaterial.get(i).getCveMat());
        }
        }
    }//GEN-LAST:event_JtMatKeyReleased

    private void JtMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtMatKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtMatKeyTyped

    private void listaMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMatMouseClicked
        JList lis = (JList) evt.getSource();
       
        if (evt.getClickCount() == 1) {
            Material mat = (Material) lis.getSelectedValue();
            
            JbCvet.setText(listaMaterial.get(listaMat.getSelectedIndex()).getCveMat());
            JtMat.setText(mat.getDescripcion());
        }
    }//GEN-LAST:event_listaMatMouseClicked
    private void limpiarMaterial() {
        modeloListaMat.clear();
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
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                OrdenCompra dialog = new OrdenCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbCvet;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JLabel JbMat;
    private com.toedter.calendar.JDateChooser JeFecha;
    private com.toedter.calendar.JDateChooser JeFecha1;
    public javax.swing.JTextField JtMat;
    public javax.swing.JTextField JtProveedor;
    public javax.swing.JLabel Jtlc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JList<Material> listaMat;
    public javax.swing.JList<ProveedorMPrima> listaProveedor;
    // End of variables declaration//GEN-END:variables
}
