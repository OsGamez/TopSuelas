package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.Agente;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import net.sf.jasperreports.view.JRViewer;

public class ReporteClientesPhy extends javax.swing.JDialog {

    Agente ag = new Agente();

    public ReporteClientesPhy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        LoadModelAm();
    }

    Connection c = Server.getServerCobranza();
    JasperReport reporte;
    JasperPrint jprint;
    JRViewer view;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbRTodos1 = new javax.swing.JButton();
        JpReporte = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JdFin = new com.toedter.calendar.JDateChooser();
        JdInicio = new com.toedter.calendar.JDateChooser();
        JbRFechas = new javax.swing.JButton();
        JbLimpiarFecha = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JbRTodos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JcAgentes = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        JdAgente = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        JdAgentef = new com.toedter.calendar.JDateChooser();
        JbLimpiarFecha1 = new javax.swing.JButton();

        JbRTodos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbRTodos1.setText("MOSTRAR REPORTE");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTES COBRANZA");

        JpReporte.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout JpReporteLayout = new javax.swing.GroupLayout(JpReporte);
        JpReporte.setLayout(JpReporteLayout);
        JpReporteLayout.setHorizontalGroup(
            JpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JpReporteLayout.setVerticalGroup(
            JpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Fecha Inicial:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Fecha Final:");

        JbRFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbRFechas.setText("MOSTRAR REPORTE");
        JbRFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbRFechasActionPerformed(evt);
            }
        });

        JbLimpiarFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Trash-80_icon-icons.com_57254.png"))); // NOI18N
        JbLimpiarFecha.setText("LIMPIAR");
        JbLimpiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbLimpiarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JdInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JdFin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(JbRFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(JbLimpiarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(JdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(JdFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JbRFechas, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(JbLimpiarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rango de Fechas", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JbRTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbRTodos.setText("MOSTRAR REPORTE");
        JbRTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbRTodosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Agente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Fecha Inicial:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Fecha Final:");

        JbLimpiarFecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Trash-80_icon-icons.com_57254.png"))); // NOI18N
        JbLimpiarFecha1.setText("LIMPIAR");
        JbLimpiarFecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbLimpiarFecha1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JdAgente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JdAgentef, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(155, 155, 155))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(JcAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JbLimpiarFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbRTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(JdAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(JdAgentef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(JcAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JbRTodos)
                        .addGap(18, 18, 18)
                        .addComponent(JbLimpiarFecha1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Por Agente", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(JpReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadModelAm() {
        DefaultComboBoxModel modelAm = new DefaultComboBoxModel(ag.getAgentesR());
        JcAgentes.setModel(modelAm);
    }

    private void JbRTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbRTodosActionPerformed
        Agente a = (Agente) JcAgentes.getSelectedItem();

        if (a.getId_Agente() <= 0) {
            JOptionPane.showMessageDialog(this, "Ingresa un agente", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else {
            if (JdAgente.getDate() != null && JdAgentef.getDate() != null) {
                String fecha, fecha2;
                String formato = JdAgente.getDateFormatString();
                String formato2 = JdAgentef.getDateFormatString();
                Date date = JdAgente.getDate();
                Date date2 = JdAgentef.getDate();
                SimpleDateFormat sm = new SimpleDateFormat(formato);
                SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
                fecha = String.valueOf(sm.format(date));
                fecha2 = String.valueOf(sm2.format(date2));
                Map par = new HashMap();
                par.put("fecha", fecha);
                par.put("fecha2", fecha2);
                par.put("cve", a.getId_Agente());

                try {
                    reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/VentasAgentesA.jasper"));
                    try {
                        jprint = JasperFillManager.fillReport(reporte, par, c);
                        view = new JRViewer(jprint);

                        JpReporte.removeAll();
                        JpReporte.setLayout(new BorderLayout());
                        JpReporte.add(view, BorderLayout.CENTER);
                        JpReporte.setVisible(true);
                        JpReporte.repaint();
                        JpReporte.revalidate();
                    } catch (JRException ex) {
                        Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (JRException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingresa las fechas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_JbRTodosActionPerformed

    private void JbLimpiarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbLimpiarFechaActionPerformed
        JpReporte.removeAll();
        JpReporte.repaint();

        JdInicio.setDate(null);
        JdFin.setDate(null);
    }//GEN-LAST:event_JbLimpiarFechaActionPerformed

    private void JbRFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbRFechasActionPerformed

        if (JdInicio.getDate() != null && JdFin.getDate() != null) {
            String fecha, fecha2;
            String formato = JdInicio.getDateFormatString();
            String formato2 = JdFin.getDateFormatString();
            Date date = JdInicio.getDate();
            Date date2 = JdFin.getDate();
            SimpleDateFormat sm = new SimpleDateFormat(formato);
            SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
            fecha = String.valueOf(sm.format(date));
            fecha2 = String.valueOf(sm2.format(date2));
            Map par = new HashMap();
            par.put("fecha", fecha);
            par.put("fecha2", fecha2);

            try {
                reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/VentasAgentesFecha.jasper"));
                try {
                    jprint = JasperFillManager.fillReport(reporte, par, c);
                    view = new JRViewer(jprint);

                    JpReporte.removeAll();
                    JpReporte.setLayout(new BorderLayout());
                    JpReporte.add(view, BorderLayout.CENTER);
                    JpReporte.setVisible(true);
                    JpReporte.repaint();
                    JpReporte.revalidate();
                } catch (JRException ex) {
                    Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingresa las fechas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_JbRFechasActionPerformed

    private void JbLimpiarFecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbLimpiarFecha1ActionPerformed
        JpReporte.removeAll();
        JpReporte.repaint();

        JdAgente.setDate(null);
        JdAgentef.setDate(null);
        JcAgentes.setSelectedIndex(0);
    }//GEN-LAST:event_JbLimpiarFecha1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteClientesPhy dialog = new ReporteClientesPhy(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbLimpiarFecha;
    private javax.swing.JButton JbLimpiarFecha1;
    private javax.swing.JButton JbRFechas;
    private javax.swing.JButton JbRTodos;
    private javax.swing.JButton JbRTodos1;
    private javax.swing.JComboBox<String> JcAgentes;
    private com.toedter.calendar.JDateChooser JdAgente;
    private com.toedter.calendar.JDateChooser JdAgentef;
    private com.toedter.calendar.JDateChooser JdFin;
    private com.toedter.calendar.JDateChooser JdInicio;
    private javax.swing.JPanel JpReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
