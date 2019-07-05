package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportesPlaneacion extends javax.swing.JDialog {

    Connection c = Server.getRcpt();

    public ReportesPlaneacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JcSemanal = new javax.swing.JCheckBox();
        JcDetalle = new javax.swing.JCheckBox();
        JcMensual = new javax.swing.JCheckBox();
        JbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE DE PLANEACIÓN");
        setResizable(false);

        JcSemanal.setText("Semanal");

        JcDetalle.setText("Semanal Detallada");

        JcMensual.setText("Mensual");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(JcSemanal)
                        .addGap(51, 51, 51)
                        .addComponent(JcDetalle)
                        .addGap(43, 43, 43)
                        .addComponent(JcMensual))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcSemanal)
                    .addComponent(JcDetalle)
                    .addComponent(JcMensual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        if (JcSemanal.isSelected() == false && JcDetalle.isSelected() == false && JcMensual.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Selecciona una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JcSemanal.isSelected() == true && JcDetalle.isSelected() == true && JcMensual.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JcSemanal.setSelected(false);
            JcDetalle.setSelected(false);
            JcMensual.setSelected(false);
        } else if (JcSemanal.isSelected() == true && JcDetalle.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JcSemanal.setSelected(false);
            JcDetalle.setSelected(false);
        } else if (JcSemanal.isSelected() == true && JcMensual.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JcSemanal.setSelected(false);
            JcMensual.setSelected(false);
        } else if (JcDetalle.isSelected() == true && JcMensual.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JcDetalle.setSelected(false);
            JcMensual.setSelected(false);
        } else if (JcSemanal.isSelected() == true) {
            try {
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Psemanal.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    //this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        } else if (JcDetalle.isSelected() == true) {
            try {
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pdetallada.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    //this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }else if(JcMensual.isSelected() == true){
            try {
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pmensual.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    //this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_JbImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(ReportesPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportesPlaneacion dialog = new ReportesPlaneacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox JcDetalle;
    private javax.swing.JCheckBox JcMensual;
    private javax.swing.JCheckBox JcSemanal;
    // End of variables declaration//GEN-END:variables

}
