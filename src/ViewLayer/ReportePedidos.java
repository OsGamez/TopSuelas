package ViewLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import ObjectLayer.ObjectPedidos;
import ObjectLayer.Pedido;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class ReportePedidos extends javax.swing.JDialog {

    ObjectPedidos p = new ObjectPedidos();
//    DB db = new DB();
//    Connection c = db.RCPTPhylonA();
    Connection c = Server.getRcpt();
    ObjectPedidos obj = new ObjectPedidos();
    int contador = 0;

    public ReportePedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JtNpedido.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JtNpedido = new javax.swing.JTextField();
        JbImprimir = new javax.swing.JButton();
        JcPedido = new javax.swing.JCheckBox();
        JcFecha = new javax.swing.JCheckBox();
        JcTodos = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        JdInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        JdFin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(200, 200));

        jLabel1.setText("N. Pedido:");

        JtNpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtNpedidoActionPerformed(evt);
            }
        });

        JbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbImprimirActionPerformed(evt);
            }
        });

        JcPedido.setText("Pedido");
        JcPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcPedidoItemStateChanged(evt);
            }
        });

        JcFecha.setText("Fechas");
        JcFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcFechaItemStateChanged(evt);
            }
        });

        JcTodos.setText("Todos");
        JcTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcTodosItemStateChanged(evt);
            }
        });

        jLabel2.setText("Fecha inicial:");

        jLabel3.setText("Fecha final:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(JtNpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JdFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(JcPedido)
                                .addGap(103, 103, 103)
                                .addComponent(JcFecha)
                                .addGap(90, 90, 90)
                                .addComponent(JcTodos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcPedido)
                    .addComponent(JcFecha)
                    .addComponent(JcTodos))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(JtNpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JdFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtNpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtNpedidoActionPerformed

    }//GEN-LAST:event_JtNpedidoActionPerformed

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        String fecha, fecha2;

        if (contador > 1) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (contador == 0) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (contador == 1) {
            if (JcPedido.isSelected()) {
                ArrayList<Pedido> list = obj.pedidoGetByReporte(JtNpedido.getText());
                if (JtNpedido.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingresa un numero de pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (list.size() > 0) {
                        try {
                            Map par = new HashMap();
                            par.put("Npedido", JtNpedido.getText());
                            JasperReport reporte = null;
                            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pedidos.jasper"));

                            try {
                                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                                JasperViewer view = new JasperViewer(jprint, false);

                                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                                view.setVisible(true);
                                view.setIconImage(getImage());
                                view.setTitle("TOP-SUELAS");
                            } catch (JRException ex) {
                                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (JRException ex) {
                            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "No extiste el pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    }
                }

            } else if (JcFecha.isSelected()) {
                if (JdInicio.getDate() == null && JdFin.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Debes selecionar un rango de fechas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdInicio.getDate() != null && JdFin.getDate() != null) {
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
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/PedidosFechas.jasper"));
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
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() == null && JdFin.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha de inicio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdFin.getDate() == null && JdInicio.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha final", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }
            } else if (JcTodos.isSelected()) {
                try {
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/PedidosAll.jasper"));
                    try {

                        JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
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
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_JbImprimirActionPerformed

    private void JcPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcPedidoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
            JtNpedido.setEditable(true);
            JtNpedido.requestFocus();
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
            JtNpedido.setEditable(false);
        }
    }//GEN-LAST:event_JcPedidoItemStateChanged

    private void JcFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcFechaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcFechaItemStateChanged

    private void JcTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcTodosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcTodosItemStateChanged

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
            java.util.logging.Logger.getLogger(ReportePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportePedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportePedidos dialog = new ReportePedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox JcFecha;
    private javax.swing.JCheckBox JcPedido;
    private javax.swing.JCheckBox JcTodos;
    private com.toedter.calendar.JDateChooser JdFin;
    private com.toedter.calendar.JDateChooser JdInicio;
    private javax.swing.JTextField JtNpedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
