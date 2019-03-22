


package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Linea;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ReporteProductos extends 
        
        
        
    javax.swing.JDialog {
    Connection c = Server.getProduccion();
  
    public ReporteProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LoadModelLinea();
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Print_icon-icons.com_73705.png"));
        setIconImage(icon);
        Ocultar();
    }

   private void LoadModelLinea(){
        Linea l = new Linea();
        DefaultComboBoxModel modelLinea = new DefaultComboBoxModel(l.getLinea());
        JcLinea.setModel(modelLinea);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbLinea = new javax.swing.JLabel();
        JcLinea = new javax.swing.JComboBox<>();
        JcL = new javax.swing.JCheckBox();
        JcTodo = new javax.swing.JCheckBox();
        JbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE PRODUCTOS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbLinea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbLinea.setText("Linea:");

        JcL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JcL.setText("Linea");
        JcL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcLItemStateChanged(evt);
            }
        });

        JcTodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JcTodo.setText("Todo");
        JcTodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcTodoItemStateChanged(evt);
            }
        });

        JbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Print_icon-icons.com_73705.png"))); // NOI18N
        JbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(JbLinea)
                        .addGap(33, 33, 33)
                        .addComponent(JcLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(JcL)
                        .addGap(28, 28, 28)
                        .addComponent(JcTodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbLinea)
                    .addComponent(JcLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbImprimir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcL)
                            .addComponent(JcTodo))
                        .addGap(10, 10, 10)))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        Linea l = (Linea)JcLinea.getSelectedItem();
        if(JcL.isSelected()== false && JcTodo.isSelected() == false){
            JOptionPane.showMessageDialog(this, "Selecciona una opcion","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        }else if(JcL.isSelected()== true && JcTodo.isSelected() == true){
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        }else if(JcL.isSelected()==true && JcLinea.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Selecciona una Linea","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        }

        else if(JcL.isSelected()==true){
            try {
                Map par = new HashMap();
                par.put("Id_Linea", l.getId_Linea());
                JasperReport reporte = (JasperReport)JRLoader.loadObject(getClass().getResource("/Reports/CatalogoNproducto.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par,c);
                    JasperViewer view = new  JasperViewer(jprint,false);
                    
                    this. dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                    view.setVisible(true);
                    
                } catch (JRException ex) {
                    Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

        else if(JcTodo.isSelected()==true){
            try {
                JasperReport reporte = (JasperReport)JRLoader.loadObject(getClass().getResource("/Reports/CatalogoProductos.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null,c);
                    JasperViewer view = new  JasperViewer(jprint,false);
                    
                    this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JcLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcLItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED){
          Mostrar();
      }else{
          Ocultar();
      }
    }//GEN-LAST:event_JcLItemStateChanged

    private void JcTodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcTodoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
          Ocultar();
      }else{
          
      }
    }//GEN-LAST:event_JcTodoItemStateChanged
     public Image getImage(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }
    private void Cerrar(){
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this,"¿Deseas cerrar esta ventana?", "TOP-SUELAS", 
                0, 0, null, botones, this);
        if(eleccion == JOptionPane.YES_OPTION){
            dispose();
        }else if(eleccion == JOptionPane.NO_OPTION){       
        }
    }
    private void Ocultar(){
        JbLinea.setVisible(false);
        JcLinea.setVisible(false);
    }
    
    private void Mostrar(){
        JbLinea.setVisible(true);
        JcLinea.setVisible(true);
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
            java.util.logging.Logger.getLogger(ReporteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteProductos dialog = new ReporteProductos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbImprimir;
    private javax.swing.JLabel JbLinea;
    private javax.swing.JCheckBox JcL;
    private javax.swing.JComboBox<String> JcLinea;
    private javax.swing.JCheckBox JcTodo;
    // End of variables declaration//GEN-END:variables
}
