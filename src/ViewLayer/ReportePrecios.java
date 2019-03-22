package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Cliente;
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportePrecios extends javax.swing.JDialog {

    Connection c = Server.getCobranza();

    public ReportePrecios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        LoadModelCliente();
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Print_icon-icons.com_73705.png"));
        setIconImage(icon);
        Ocultar();
    }

    private void LoadModelCliente() {
        Cliente cl = new Cliente();
        DefaultComboBoxModel modelCliente = new DefaultComboBoxModel(cl.getClientes());
        JcCliente.setModel(modelCliente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbCliente = new javax.swing.JLabel();
        JcCliente = new javax.swing.JComboBox<>();
        JcC = new javax.swing.JCheckBox();
        JcTodo = new javax.swing.JCheckBox();
        JbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE PRECIOS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCliente.setText("Cliente:");

        JcC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JcC.setText("Cliente");
        JcC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcCItemStateChanged(evt);
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
                        .addComponent(JbCliente)
                        .addGap(33, 33, 33)
                        .addComponent(JcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(JcC)
                        .addGap(28, 28, 28)
                        .addComponent(JcTodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbCliente)
                    .addComponent(JcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JbImprimir)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcC)
                            .addComponent(JcTodo))
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        Cliente cliente = (Cliente) JcCliente.getSelectedItem();
        if (JcC.isSelected() == false && JcTodo.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Selecciona una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JcC.isSelected() == true && JcTodo.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JcC.isSelected() == true && JcCliente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un cliente", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JcC.isSelected() == true) {
            try {
                JasperReport reporte = null;
                Map par = new HashMap();
                par.put("Id_Cliente", cliente.getId_Cliente());
                reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/CatalogoPreciosCliente.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                    JasperViewer view = new JasperViewer(jprint, false);
                    this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(ReportePrecios.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReportePrecios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (JcTodo.isSelected() == true) {
            try {
                JasperReport reporte = null;
                reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/CatalogoPrecios.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                    JasperViewer view = new JasperViewer(jprint, false);
                    this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(ReportePrecios.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReportePrecios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JcCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcCItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED){
          Mostrar();
      }else{
          Ocultar();
      }
    }//GEN-LAST:event_JcCItemStateChanged

    private void JcTodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcTodoItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED){
          Ocultar();
      }
    }//GEN-LAST:event_JcTodoItemStateChanged
    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }
    private void Ocultar(){
        JcCliente.setVisible(false);
        JbCliente.setVisible(false);
    }
    
    private void Mostrar(){
        JcCliente.setVisible(true);
        JbCliente.setVisible(true);
    }

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
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
            java.util.logging.Logger.getLogger(ReportePrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportePrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportePrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportePrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportePrecios dialog = new ReportePrecios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbCliente;
    private javax.swing.JButton JbImprimir;
    private javax.swing.JCheckBox JcC;
    private javax.swing.JComboBox<String> JcCliente;
    private javax.swing.JCheckBox JcTodo;
    // End of variables declaration//GEN-END:variables
}
