package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Costo;
import ObjectLayer.Material;
import ObjectLayer.ObjectCostos;
import ObjectLayer.Producto;
import ObjectLayer.PtProducto;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Costos extends javax.swing.JInternalFrame {

    Connection c = Server.getProduccion();
    ObjectCostos obj = new ObjectCostos();
    DefaultTableModel modelCosto = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public Costos() {
        initComponents();
        LoadColumns();
        LoadModelCosto();
        JtCostos.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JbNuevaCorrida = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JbSalir = new javax.swing.JButton();
        JbEliminar = new javax.swing.JButton();
        JbEditar = new javax.swing.JButton();
        JbActualizar = new javax.swing.JButton();
        JbUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtCostos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("COSTOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/chart-1_111423.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

        JbNuevaCorrida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pluscircleregular_106319.png"))); // NOI18N
        JbNuevaCorrida.setText("NUEVO");
        JbNuevaCorrida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbNuevaCorridaActionPerformed(evt);
            }
        });

        JbReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbReporte.setText("REPORTE");
        JbReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbReporteActionPerformed(evt);
            }
        });

        JbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit_icon-icons.com_70975.png"))); // NOI18N
        JbSalir.setText("SALIR");
        JbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbSalirActionPerformed(evt);
            }
        });

        JbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/crossregular_106296.png"))); // NOI18N
        JbEliminar.setText("ELIMINAR");
        JbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEliminarActionPerformed(evt);
            }
        });

        JbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit-validated_40458.png"))); // NOI18N
        JbEditar.setText("EDITAR");
        JbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEditarActionPerformed(evt);
            }
        });

        JbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N
        JbActualizar.setText("REFRESCAR");
        JbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbActualizarActionPerformed(evt);
            }
        });

        JbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/button_refresh_15001.png"))); // NOI18N
        JbUpdate.setText("ACTUALIZAR");
        JbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevaCorrida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JbNuevaCorrida)
                .addGap(32, 32, 32)
                .addComponent(JbEliminar)
                .addGap(29, 29, 29)
                .addComponent(JbEditar)
                .addGap(29, 29, 29)
                .addComponent(JbReporte)
                .addGap(27, 27, 27)
                .addComponent(JbUpdate)
                .addGap(31, 31, 31)
                .addComponent(JbActualizar)
                .addGap(26, 26, 26)
                .addComponent(JbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR:");

        JtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtBuscarKeyTyped(evt);
            }
        });

        JtCostos.setModel(modelCosto);
        jScrollPane1.setViewportView(JtCostos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevaCorridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevaCorridaActionPerformed
        NCosto nuevo = new NCosto(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if (nuevo.getInformacion() != "") {
            CleanTable();
            LoadModelCosto();
        }
    }//GEN-LAST:event_JbNuevaCorridaActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        
        if(JtBuscar.getText().equals("")){
            try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/ReporteCostos.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(Costos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(Costos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            Map par = new HashMap();
            par.put("Descripcion", JtBuscar.getText());
            
            try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/ReporteCostosFiltro.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(Costos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(Costos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        

    }//GEN-LAST:event_JbReporteActionPerformed
    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }
    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtCostos.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de borrar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    int Id = Integer.parseInt(JtCostos.getValueAt(row, 0).toString());
                    int Punto = Integer.parseInt(JtCostos.getValueAt(row, 5).toString());
                    if (obj.costoDelete(Id, Punto)) {
                        modelCosto.removeRow(row);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrio un error contacta con sistemas");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
        MCosto editar = new MCosto(null, true);
        Producto p = new Producto();
        PtProducto pt = new PtProducto();
        Material m = new Material();
        int row = JtCostos.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres editar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    p.setId_Producto((int) JtCostos.getValueAt(row, 0));
                    p.setDescripcion(JtCostos.getValueAt(row, 1).toString());
                    pt.setProducto((int) JtCostos.getValueAt(row, 2));
                    pt.setDescripcion(JtCostos.getValueAt(row, 3).toString());
                    m.setDescripcion(JtCostos.getValueAt(row, 4).toString());
                    editar.JcProd.getModel().setSelectedItem(p);
                    editar.JcRc.getModel().setSelectedItem(pt);
                    editar.JcMaterial.getModel().setSelectedItem(m);
                    editar.JtPunto.setText(JtCostos.getValueAt(row, 5).toString());
                    editar.JtPeso.setText(JtCostos.getValueAt(row, 6).toString());
                    editar.JtPtol.setText(JtCostos.getValueAt(row, 7).toString());
                    editar.JtPcol.setText(JtCostos.getValueAt(row, 8).toString());
                    editar.JbTolerancia.setText(JtCostos.getValueAt(row, 9).toString());
                    editar.JbColada.setText(JtCostos.getValueAt(row, 10).toString());
                    editar.JbPesoT.setText(JtCostos.getValueAt(row, 11).toString());
                    editar.JbPrecio.setText(JtCostos.getValueAt(row, 12).toString());
                    editar.JbCostoT.setText(JtCostos.getValueAt(row, 13).toString());
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                    if (editar.getInformacion() != "") {
                        CleanTable();
                        LoadModelCosto();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEditarActionPerformed

    private void JbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbActualizarActionPerformed
        JtBuscar.setText("");
        CleanTable();
        LoadModelCosto();
    }//GEN-LAST:event_JbActualizarActionPerformed

    private void JtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyReleased
        ArrayList<Costo> listaCostos = obj.costoSearch(JtBuscar.getText());
        modelCosto.setNumRows(listaCostos.size());
        for (int i = 0; i < listaCostos.size(); i++) {
            Costo ct = listaCostos.get(i);
            DecimalFormat var = new DecimalFormat("#.00");
            DecimalFormat num = new DecimalFormat("0.00");
            modelCosto.setValueAt(ct.getId_Producto(), i, 0);
            modelCosto.setValueAt(ct.getDescripcion(), i, 1);
            modelCosto.setValueAt(ct.getId_ProductoRCPT(), i, 2);
            modelCosto.setValueAt(ct.getDp(), i, 3);
            modelCosto.setValueAt(ct.getMaterial(), i, 4);
            modelCosto.setValueAt(ct.getPunto(), i, 5);
            modelCosto.setValueAt(num.format(ct.getPesoGr()), i, 6);
            modelCosto.setValueAt(var.format(ct.getPtolerancia()), i, 7);
            modelCosto.setValueAt(var.format(ct.getPcolada()), i, 8);
            modelCosto.setValueAt(num.format(ct.getTolerancia()), i, 9);
            modelCosto.setValueAt(num.format(ct.getColada()), i, 10);
            modelCosto.setValueAt(num.format(ct.getPesoTotal()), i, 11);
            modelCosto.setValueAt(var.format(ct.getPrecio()), i, 12);
            modelCosto.setValueAt(var.format(ct.getCosto()), i, 13);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbUpdateActionPerformed
        EditaCostos nuevo = new EditaCostos(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if (nuevo.getInformacion() != "") {
            CleanTable();
            LoadModelCosto();
        }
    }//GEN-LAST:event_JbUpdateActionPerformed

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped
    private void LoadModelCosto() {
        ArrayList<Costo> listaCostos = obj.costoGetAll();
        modelCosto.setNumRows(listaCostos.size());
        for (int i = 0; i < listaCostos.size(); i++) {
            Costo ct = listaCostos.get(i);
            DecimalFormat var = new DecimalFormat("#.00");
            DecimalFormat num = new DecimalFormat("0.00");
            modelCosto.setValueAt(ct.getId_Producto(), i, 0);
            modelCosto.setValueAt(ct.getDescripcion(), i, 1);
            modelCosto.setValueAt(ct.getId_ProductoRCPT(), i, 2);
            modelCosto.setValueAt(ct.getDp(), i, 3);
            modelCosto.setValueAt(ct.getMaterial(), i, 4);
            modelCosto.setValueAt(ct.getPunto(), i, 5);
            modelCosto.setValueAt(num.format(ct.getPesoGr()), i, 6);
            modelCosto.setValueAt(var.format(ct.getPtolerancia()), i, 7);
            modelCosto.setValueAt(var.format(ct.getPcolada()), i, 8);
            modelCosto.setValueAt(num.format(ct.getTolerancia()), i, 9);
            modelCosto.setValueAt(num.format(ct.getColada()), i, 10);
            modelCosto.setValueAt(num.format(ct.getPesoTotal()), i, 11);
            modelCosto.setValueAt(var.format(ct.getPrecio()), i, 12);
            modelCosto.setValueAt(var.format(ct.getCosto()), i, 13);
        }
    }

    private void LoadColumns() {
        modelCosto.addColumn("Id_Producto");
        modelCosto.addColumn("SUELA");
        modelCosto.addColumn("Id_ProductoRCPT");
        modelCosto.addColumn("PRODUCTO");
        modelCosto.addColumn("MATERIAL");
        modelCosto.addColumn("PUNTO");
        modelCosto.addColumn("PESOGR");
        modelCosto.addColumn("%TOLERANCIA");
        modelCosto.addColumn("%COLADA");
        modelCosto.addColumn("TOLERANCIA");
        modelCosto.addColumn("COLADA");
        modelCosto.addColumn("PESO");
        modelCosto.addColumn("PRECIO");
        modelCosto.addColumn("COSTO");

        JtCostos.getColumnModel().getColumn(0).setMaxWidth(0);
        JtCostos.getColumnModel().getColumn(0).setMinWidth(0);
        JtCostos.getColumnModel().getColumn(0).setPreferredWidth(0);

        JtCostos.getColumnModel().getColumn(1).setMaxWidth(250);
        JtCostos.getColumnModel().getColumn(1).setMinWidth(250);
        JtCostos.getColumnModel().getColumn(1).setPreferredWidth(250);

        JtCostos.getColumnModel().getColumn(2).setMaxWidth(0);
        JtCostos.getColumnModel().getColumn(2).setMinWidth(0);
        JtCostos.getColumnModel().getColumn(2).setPreferredWidth(0);

        JtCostos.getColumnModel().getColumn(3).setMaxWidth(0);
        JtCostos.getColumnModel().getColumn(3).setMinWidth(0);
        JtCostos.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    private void CleanTable() {
        int numFilas = modelCosto.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelCosto.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbActualizar;
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevaCorrida;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JButton JbUpdate;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtCostos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
