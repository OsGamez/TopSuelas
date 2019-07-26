package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.Folio;
import ObjectLayer.Infisico;
import ObjectLayer.ObjectInfisico;
import ObjectLayer.invFolio;
import ObjectLayer.objInv;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FolioInventario extends javax.swing.JFrame {

    objInv ObjInv = new objInv();
    ObjectInfisico objF = new ObjectInfisico();
    int fl, contador = 0;
    String ms, Estado;
    Connection c = Server.getRcpt();

    public FolioInventario() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        mostrarFolios();
        JtDatos.getTableHeader().setReorderingAllowed(false);
        cargarColumnasFtemp();
        JpCodigos.setVisible(false);
        JbReporte.setToolTipText("IMPRIMIR FOLIO");
        JbEnviar.setToolTipText("ENVIAR FOLIO");
    }

    DefaultTableModel modelInv = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    DefaultTableModel modelFolio = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatos = new javax.swing.JTable();
        JbEnviar = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JpCodigos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtFolios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FOLIOS DEL INVENTARIO");
        setLocation(new java.awt.Point(200, 150));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MOVIMIENTO", "FOLIO", "ALMACÉN", "FECHA", "ESTATUS", "PARES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JtDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtDatos);

        JbEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/refresh_arrows_14418.png"))); // NOI18N
        JbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEnviarActionPerformed(evt);
            }
        });

        JbReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbReporteActionPerformed(evt);
            }
        });

        JpCodigos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JtFolios.setModel(modelFolio);
        jScrollPane4.setViewportView(JtFolios);

        javax.swing.GroupLayout JpCodigosLayout = new javax.swing.GroupLayout(JpCodigos);
        JpCodigos.setLayout(JpCodigosLayout);
        JpCodigosLayout.setHorizontalGroup(
            JpCodigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpCodigosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpCodigosLayout.setVerticalGroup(
            JpCodigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(JbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(JbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267)
                        .addComponent(JpCodigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JpCodigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarColumnasFtemp() {
        modelFolio.addColumn("PROD");
        modelFolio.addColumn("AM");
        modelFolio.addColumn("ES");
        modelFolio.addColumn("COR");
        modelFolio.addColumn("COM");
        modelFolio.addColumn("E");
        modelFolio.addColumn("1");
        modelFolio.addColumn("2");
        modelFolio.addColumn("3");
        modelFolio.addColumn("4");
        modelFolio.addColumn("5");
        modelFolio.addColumn("6");
        modelFolio.addColumn("7");
        modelFolio.addColumn("8");
        modelFolio.addColumn("9");
        modelFolio.addColumn("10");
        modelFolio.addColumn("11");
        modelFolio.addColumn("12");
        modelFolio.addColumn("13");
        modelFolio.addColumn("14");
        modelFolio.addColumn("P");
    }

    private void JtDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDatosMouseClicked
        cleanTableTemp();
        int row = JtDatos.rowAtPoint(evt.getPoint());
        boolean valor = (Boolean) JtDatos.getValueAt(row, 0);
        Estado = (String) JtDatos.getValueAt(row, 4);

        if (valor == true) {
            int folio = (int) JtDatos.getValueAt(row, 1);
            ArrayList<Folio> list = ObjInv.getFolioById(folio);
            if (list.size() > 0) {
                fl = folio;
                contador++;
                modelFolio.setNumRows(list.size());
                for (int i = 0; i < list.size(); i++) {
                    Folio f = list.get(i);
                    modelFolio.setValueAt(f.getProducto(), i, 0);
                    modelFolio.setValueAt(f.getAlmacen(), i, 1);
                    modelFolio.setValueAt(f.getEstilo(), i, 2);
                    modelFolio.setValueAt(f.getCorrida(), i, 3);
                    modelFolio.setValueAt(f.getCombinacion(), i, 4);
                    modelFolio.setValueAt(f.getTipo(), i, 5);
                    modelFolio.setValueAt(f.getPto1(), i, 6);
                    modelFolio.setValueAt(f.getPto2(), i, 7);
                    modelFolio.setValueAt(f.getPto3(), i, 8);
                    modelFolio.setValueAt(f.getPto4(), i, 9);
                    modelFolio.setValueAt(f.getPto5(), i, 10);
                    modelFolio.setValueAt(f.getPto6(), i, 11);
                    modelFolio.setValueAt(f.getPto7(), i, 12);
                    modelFolio.setValueAt(f.getPto8(), i, 13);
                    modelFolio.setValueAt(f.getPto9(), i, 14);
                    modelFolio.setValueAt(f.getPto10(), i, 15);
                    modelFolio.setValueAt(f.getPto11(), i, 16);
                    modelFolio.setValueAt(f.getPto12(), i, 17);
                    modelFolio.setValueAt(f.getPto13(), i, 18);
                    modelFolio.setValueAt(f.getPto14(), i, 19);
                    modelFolio.setValueAt(f.getTotalPares(), i, 20);
                }
            }
        } else {
            contador--;
            cleanTableTemp();
        }
    }//GEN-LAST:event_JtDatosMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private boolean validarEnvioFolios() {
        if (this.JtFolios.getRowCount() == 0 && this.JtFolios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No has seleccionado ningun folio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void JbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEnviarActionPerformed
        if (validarEnvioFolios()) {
            if (Estado.equals("A")) {
                JOptionPane.showMessageDialog(this, "Este folio ya ha sido enviado", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                cleanTableTemp();
                cleanFolios();
                mostrarFolios();
                contador = 0;
            } else {
                if (contador > 1) {
                    JOptionPane.showMessageDialog(this, "Envie un registro a la vez", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    cleanTableTemp();
                    cleanFolios();
                    mostrarFolios();
                    contador = 0;
                } else if (contador == 0) {
                    JOptionPane.showMessageDialog(this, "No hay ningun registro", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    cleanTableTemp();
                    cleanFolios();
                    mostrarFolios();
                    contador = 0;
                } else if (contador == 1) {
                    int row = JtFolios.getRowCount();

                    for (int i = 0; i < row; i++) {
                        Infisico inv = new Infisico();

                        String pt = JtFolios.getValueAt(i, 0).toString();
                        String am = JtFolios.getValueAt(i, 1).toString();
                        String es = JtFolios.getValueAt(i, 2).toString();
                        String cor = JtFolios.getValueAt(i, 3).toString();
                        String com = JtFolios.getValueAt(i, 4).toString();
                        String pt1 = JtFolios.getValueAt(i, 6).toString();
                        String pt2 = JtFolios.getValueAt(i, 7).toString();
                        String pt3 = JtFolios.getValueAt(i, 8).toString();
                        String pt4 = JtFolios.getValueAt(i, 9).toString();
                        String pt5 = JtFolios.getValueAt(i, 10).toString();
                        String pt6 = JtFolios.getValueAt(i, 11).toString();
                        String pt7 = JtFolios.getValueAt(i, 12).toString();
                        String pt8 = JtFolios.getValueAt(i, 13).toString();
                        String pt9 = JtFolios.getValueAt(i, 14).toString();
                        String pt10 = JtFolios.getValueAt(i, 15).toString();
                        String pt11 = JtFolios.getValueAt(i, 16).toString();
                        String pt12 = JtFolios.getValueAt(i, 17).toString();
                        String pt13 = JtFolios.getValueAt(i, 18).toString();
                        String pt14 = JtFolios.getValueAt(i, 19).toString();
                        String pares = JtFolios.getValueAt(i, 20).toString();

                        inv.setProducto(Integer.parseInt(pt));
                        inv.setAlmacen(Integer.parseInt(am));
                        inv.setEstilo(Integer.parseInt(es));
                        inv.setCorrida(Integer.parseInt(cor));
                        inv.setCombinacion(Integer.parseInt(com));
                        inv.setTipo(JtFolios.getValueAt(i, 5).toString());
                        inv.setPto1(Integer.parseInt(pt1));
                        inv.setPto2(Integer.parseInt(pt2));
                        inv.setPto3(Integer.parseInt(pt3));
                        inv.setPto4(Integer.parseInt(pt4));
                        inv.setPto5(Integer.parseInt(pt5));
                        inv.setPto6(Integer.parseInt(pt6));
                        inv.setPto7(Integer.parseInt(pt7));
                        inv.setPto8(Integer.parseInt(pt8));
                        inv.setPto9(Integer.parseInt(pt9));
                        inv.setPto10(Integer.parseInt(pt10));
                        inv.setPto11(Integer.parseInt(pt11));
                        inv.setPto12(Integer.parseInt(pt12));
                        inv.setPto13(Integer.parseInt(pt13));
                        inv.setPto14(Integer.parseInt(pt14));
                        inv.setTotalPares(Integer.parseInt(pares));

                        if (objF.AddTemp(inv)) {
                            ms = "ok";
                        } else {
                            ms = "error";
                        }
                    }

                    if (ms.equals("ok")) {
                        JOptionPane.showMessageDialog(this, "Registro agregado", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                        cleanTableTemp();
                        ObjInv.updateFolioxPistola(fl);
                        cleanFolios();
                        mostrarFolios();
                        contador = 0;
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo agregar el registro contacte con sistemas!!!", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        cleanTableTemp();
                        contador = 0;
                    }
                }
            }
        }
    }//GEN-LAST:event_JbEnviarActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        if (contador > 1) {
            JOptionPane.showMessageDialog(this, "Selecciona solo un registro", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            cleanTableTemp();
            cleanFolios();
            mostrarFolios();
            contador = 0;
        } else if (contador == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un registro", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            cleanTableTemp();
            cleanFolios();
            mostrarFolios();
            contador = 0;
        } else if (contador == 1) {
            try {
                JasperReport reporte;
                reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/Reports/ReporteFolios.jasper"));
                try {
                    Map par = new HashMap();
                    par.put("folio", fl);
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(FolioInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(FolioInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            cleanTableTemp();
            cleanFolios();
            mostrarFolios();
            contador = 0;
        }
    }//GEN-LAST:event_JbReporteActionPerformed

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }

    private void mostrarFolios() {
        DefaultTableModel modelo = (DefaultTableModel) JtDatos.getModel();

        ArrayList<invFolio> list = ObjInv.getInv();

        for (invFolio inv : list) {
            modelo.addRow(new Object[]{inv.getEstado(), inv.getFolio(), inv.getAlmacen(), inv.getFecha(), inv.getEstatus(), inv.getPares()});
        }
        JtDatos.setModel(modelo);
        modelInv = modelo;
    }

    private void cleanFolios() {
        int row = modelInv.getRowCount();
        if (row > 0) {
            for (int i = row - 1; i >= 0; i--) {
                modelInv.removeRow(i);
            }
        }
    }

    private void cleanTableTemp() {
        int row = modelFolio.getRowCount();
        if (row > 0) {
            for (int i = row - 1; i >= 0; i--) {
                modelFolio.removeRow(i);
            }
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
            java.util.logging.Logger.getLogger(FolioInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FolioInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FolioInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FolioInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FolioInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEnviar;
    private javax.swing.JButton JbReporte;
    private javax.swing.JPanel JpCodigos;
    private javax.swing.JTable JtDatos;
    private javax.swing.JTable JtFolios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
