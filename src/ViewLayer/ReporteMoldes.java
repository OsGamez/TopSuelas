package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.Linea;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteMoldes extends javax.swing.JDialog {

    Connection c = Server.getProduccion();
    Vector<Linea> datos = new Vector<Linea>();

    public ReporteMoldes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Print_icon-icons.com_73705.png"));
        setIconImage(icon);
        LoadModelMolde();
        ButtonGroup bg= new ButtonGroup();
        bg.add(Jtt);
        bg.add(Jts);
        Jtt.setSelected(true);
        Ocultar();
    }

    private void LoadModelMolde() {
        Linea ln = new Linea();
        DefaultComboBoxModel modelLinea = new DefaultComboBoxModel(ln.getLinea());
        datos = ln.getLinea();
        Jtl.setModel(modelLinea);
        Jtl.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbCliente = new javax.swing.JLabel();
        Jtl = new javax.swing.JComboBox<>();
        Jts = new javax.swing.JCheckBox();
        Jtt = new javax.swing.JCheckBox();
        JbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE MOLDES");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCliente.setText("Suela");

        Jts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jts.setText("Suela");
        Jts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JtsItemStateChanged(evt);
            }
        });
        Jts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtsActionPerformed(evt);
            }
        });

        Jtt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jtt.setText("Todo");
        Jtt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JttItemStateChanged(evt);
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
                        .addComponent(Jtl, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(Jts)
                        .addGap(28, 28, 28)
                        .addComponent(Jtt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbCliente)
                    .addComponent(Jtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JbImprimir)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jts)
                            .addComponent(Jtt))
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        String l = datos.get(Jtl.getSelectedIndex()).getDescripcion();// se toma el dato del combobox
        if (Jts.isSelected() == false && Jtt.isSelected() == false) {// verifica que las opciones esten seleccionadas
            JOptionPane.showMessageDialog(this, "Selecciona una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (Jts.isSelected() == true && Jtt.isSelected() == true) {
            //verifica que alguna de las opciones este marcada
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (Jts.isSelected() == true && Jtl.getSelectedIndex() == 0) {// verifica que las opciones esten seleccionadas
            JOptionPane.showMessageDialog(this, "Selecciona una suela", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else {
            String select = (Jtt.isSelected()) ? "" : l;// asigna de la suela para la posterior comparacion en el reporte
            try {
                Map par = new HashMap();
                par.put("linea", select);
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/CatalogoMoldes.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                    JasperViewer view = new JasperViewer(jprint, false);
                    this.dispose();
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(ReporteMoldes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReporteMoldes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JtsItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Mostrar();
        } else {
            Ocultar();
        }
    }//GEN-LAST:event_JtsItemStateChanged

    private void JttItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JttItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Ocultar();
        }
    }//GEN-LAST:event_JttItemStateChanged

    private void JtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtsActionPerformed
    private void Cerrar() {
//        String botones[] = {"SI", "NO"};
//        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
//                0, 0, null, botones, this);
//        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
//        } else if (eleccion == JOptionPane.NO_OPTION) {
//        }
    }

    private void Ocultar() {
        Jtl.setVisible(false);
        JbCliente.setVisible(false);
    }

    private void Mostrar() {
        Jtl.setVisible(true);
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
            java.util.logging.Logger.getLogger(ReporteMoldes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteMoldes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteMoldes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteMoldes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteMoldes dialog = new ReporteMoldes(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> Jtl;
    private javax.swing.JCheckBox Jts;
    private javax.swing.JCheckBox Jtt;
    // End of variables declaration//GEN-END:variables
}
