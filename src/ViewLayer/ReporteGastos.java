package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
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

public class ReporteGastos extends javax.swing.JDialog {

    DB db = new DB();
    Connection c = db.Produccion();

    public ReporteGastos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        Ocultar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbAño = new javax.swing.JLabel();
        JbMes = new javax.swing.JLabel();
        JyAño = new com.toedter.calendar.JYearChooser();
        JbImprimir = new javax.swing.JButton();
        JcReporte = new javax.swing.JCheckBox();
        JcFecha = new javax.swing.JCheckBox();
        JmMes = new com.toedter.calendar.JMonthChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE GASTOS");
        setBackground(new java.awt.Color(240, 122, 69));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbAño.setText("AÑO:");

        JbMes.setText("MES:");

        JbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Print_icon-icons.com_73705.png"))); // NOI18N
        JbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbImprimirActionPerformed(evt);
            }
        });

        JcReporte.setText("IMPRIMIR TODO");
        JcReporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcReporteItemStateChanged(evt);
            }
        });

        JcFecha.setText("MES");
        JcFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcFechaItemStateChanged(evt);
            }
        });
        JcFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbAño)
                        .addGap(18, 18, 18)
                        .addComponent(JyAño, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(JbMes)
                        .addGap(19, 19, 19)
                        .addComponent(JmMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JcReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JcFecha)
                        .addGap(59, 59, 59)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JyAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JbMes, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JbAño))
                    .addComponent(JmMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcReporte)
                            .addComponent(JcFecha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(JbImprimir)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        if (JcFecha.isSelected() == false && JcReporte.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Selecciona una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JcFecha.isSelected() == true && JcReporte.isSelected() == true) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JcFecha.isSelected() == true) {
            try {
                Map par = new HashMap();
                int mes = JmMes.getMonth() + 1;
                par.put("Año", JyAño.getYear());
                par.put("Mes", String.valueOf(mes));
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/ReporteGastosMes.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else if (JcReporte.isSelected() == true) {
            try {
                JasperReport reporte = null;
                reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/ReporteGastos.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(ReporteGastos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReporteGastos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_JbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JcFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcFechaActionPerformed

    private void JcFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcFechaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Mostrar();
        } else {
            Ocultar();
        }
    }//GEN-LAST:event_JcFechaItemStateChanged

    private void JcReporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcReporteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Ocultar();
        }
    }//GEN-LAST:event_JcReporteItemStateChanged

    private void Ocultar() {
        JbAño.setVisible(false);
        JbMes.setVisible(false);
        JyAño.setVisible(false);
        JmMes.setVisible(false);
    }

    private void Mostrar() {
        JbMes.setVisible(true);
        JbAño.setVisible(true);
        JyAño.setVisible(true);
        JmMes.setVisible(true);
    }

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }

    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
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
            java.util.logging.Logger.getLogger(ReporteGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteGastos dialog = new ReporteGastos(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbAño;
    private javax.swing.JButton JbImprimir;
    private javax.swing.JLabel JbMes;
    private javax.swing.JCheckBox JcFecha;
    private javax.swing.JCheckBox JcReporte;
    private com.toedter.calendar.JMonthChooser JmMes;
    private com.toedter.calendar.JYearChooser JyAño;
    // End of variables declaration//GEN-END:variables
}
