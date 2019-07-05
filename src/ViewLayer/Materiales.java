package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Almacen;
import ObjectLayer.Material;
import ObjectLayer.ObjectMateriales;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

public class Materiales extends javax.swing.JInternalFrame {

    ArrayList<Material> listaMaterial;
    Connection c = Server.getCmpPhylon();
    DefaultTableModel modelMat = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    ObjectMateriales obj = new ObjectMateriales();

    public Materiales() {
        initComponents();
        LoadColums();
        LoadModelMaterial();
        JtMaterial.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JbNuevo = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JbSalir = new javax.swing.JButton();
        JbEliminar = new javax.swing.JButton();
        JbEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtMaterial = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("MATERIALES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/box_full_products_14639.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

        JbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pluscircleregular_106319.png"))); // NOI18N
        JbNuevo.setText("NUEVO");
        JbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbNuevoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JbNuevo)
                .addGap(32, 32, 32)
                .addComponent(JbEliminar)
                .addGap(29, 29, 29)
                .addComponent(JbEditar)
                .addGap(29, 29, 29)
                .addComponent(JbReporte)
                .addGap(31, 31, 31)
                .addComponent(JbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR:");

        JtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtBuscarKeyReleased(evt);
            }
        });

        JtMaterial.setModel(modelMat);
        JtMaterial.setSelectionBackground(new java.awt.Color(102, 153, 255));
        JtMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtMaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtMaterial);

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

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        NMaterial nuevo = new NMaterial(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if (nuevo.getInformacion() != "") {
            CleanTable();
            LoadModelMaterial();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/ReporteMateriales.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed
    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }
    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtMaterial.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de borrar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    int Alm = Integer.parseInt(JtMaterial.getValueAt(row, 0).toString());
                    String Cv = JtMaterial.getValueAt(row, 2).toString();
                    if (obj.materialDelete(Alm, Cv)) {
                        modelMat.removeRow(row);
                        JOptionPane.showMessageDialog(this, "Registro eliminado!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    }else {
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
        NMaterial editar = new NMaterial(null, true);
        int row = JtMaterial.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres editar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    Almacen am = new Almacen();
                    editar.JcAlm.setEnabled(false);
                    editar.JtCv.setEnabled(false);
                    editar.JtId.setText(JtMaterial.getValueAt(row, 0).toString());
                    am.setAlmacen((int) JtMaterial.getValueAt(row, 0));
                    am.setDescripcion(JtMaterial.getValueAt(row, 1).toString());
                    editar.JcAlm.getModel().setSelectedItem(am);
                    editar.JtCv.setText(JtMaterial.getValueAt(row, 2).toString());
                    editar.JtNombre.setText(String.valueOf(JtMaterial.getValueAt(row, 3)));
                    editar.JtSat.setText(String.valueOf(JtMaterial.getValueAt(row, 4)));
                    editar.JcUdc.setSelectedItem(String.valueOf(JtMaterial.getValueAt(row, 5)));
                    editar.JtFcompra.setText(String.valueOf(JtMaterial.getValueAt(row, 6)));
                    editar.JcConsumo.setSelectedItem(String.valueOf(JtMaterial.getValueAt(row, 7)));
                    editar.JtFconsumo.setText(String.valueOf(JtMaterial.getValueAt(row, 8)));
                    editar.JtUcosto.setText(String.valueOf(JtMaterial.getValueAt(row, 9)));
                    editar.JtCostoC.setText(String.valueOf(JtMaterial.getValueAt(row, 10)));
                    editar.JtCantidadM.setText(String.valueOf(JtMaterial.getValueAt(row, 11)));
                    editar.JtCantidadMa.setText(String.valueOf(JtMaterial.getValueAt(row, 12)));
                    editar.JtTcosto.setText(String.valueOf(JtMaterial.getValueAt(row, 13)));
                    editar.JcDivisa.setSelectedItem(String.valueOf(JtMaterial.getValueAt(row, 14)));
                    editar.JcProveedor.setSelectedItem(listaMaterial.get(JtMaterial.getSelectedRow()).getDescproveedor());
//                    System.out.println(listaMaterial.get(JtMaterial.getSelectedRow()).getDescproveedor());
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                    if (editar.getInformacion() != "") {
                        CleanTable();
                        LoadModelMaterial();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEditarActionPerformed

    private void JtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyReleased
        CleanTable();
        ArrayList<Material> listaMat = obj.materialSearch(JtBuscar.getText());
        listaMaterial=listaMat;
        listaMat.size();
        modelMat.setNumRows(listaMat.size());
        for (int i = 0; i < listaMat.size(); i++) {
            Material m = listaMat.get(i);
            DecimalFormat var = new DecimalFormat("#.00");

            modelMat.setValueAt(m.getAlmacen(), i, 0);
            modelMat.setValueAt(m.getDesAlm(), i, 1);
            modelMat.setValueAt(m.getCveMat(), i, 2);
            modelMat.setValueAt(m.getDescripcion(), i, 3);
            modelMat.setValueAt(m.getCodigoSat(), i, 4);
            modelMat.setValueAt(m.getUdeC(), i, 5);
            modelMat.setValueAt(var.format(m.getFcompra()), i, 6);
            modelMat.setValueAt(m.getUdeCs(), i, 7);
            modelMat.setValueAt(var.format(m.getFconsumo()), i, 8);
            modelMat.setValueAt(var.format(m.getUltimoCosto()), i, 9);
            modelMat.setValueAt(var.format(m.getCostoCosteo()), i, 10);
            modelMat.setValueAt(var.format(m.getCantidadMinima()), i, 11);
            modelMat.setValueAt(var.format(m.getCantidadMaxima()), i, 12);
            modelMat.setValueAt(m.getTipoCosto(), i, 13);
            modelMat.setValueAt(m.getDivisa(), i, 14);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JtMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtMaterialMouseClicked
                  
    }//GEN-LAST:event_JtMaterialMouseClicked

    private void LoadModelMaterial() {
        ArrayList<Material> listaMat = obj.materialGetAll();
        listaMaterial=listaMat;
        modelMat.setNumRows(listaMat.size());
        for (int i = 0; i < listaMat.size(); i++) {
            Material m = listaMat.get(i);
            DecimalFormat var = new DecimalFormat("#.00");
            modelMat.setValueAt(m.getAlmacen(), i, 0);
            modelMat.setValueAt(m.getDesAlm(), i, 1);
            modelMat.setValueAt(m.getCveMat(), i, 2);
            modelMat.setValueAt(m.getDescripcion(), i, 3);
            modelMat.setValueAt(m.getCodigoSat(), i, 4);
            modelMat.setValueAt(m.getUdeC(), i, 5);
            modelMat.setValueAt(var.format(m.getFcompra()), i, 6);
            modelMat.setValueAt(m.getUdeCs(), i, 7);
            modelMat.setValueAt(var.format(m.getFconsumo()), i, 8);
            modelMat.setValueAt(var.format(m.getUltimoCosto()), i, 9);
            modelMat.setValueAt(var.format(m.getCostoCosteo()), i, 10);
            modelMat.setValueAt(var.format(m.getCantidadMinima()), i, 11);
            modelMat.setValueAt(var.format(m.getCantidadMaxima()), i, 12);
            modelMat.setValueAt(m.getTipoCosto(), i, 13);
            modelMat.setValueAt(m.getDivisa(), i, 14);
        }
    }

    private void LoadColums() {
        modelMat.addColumn("#");
        modelMat.addColumn("Almacén");
        modelMat.addColumn("CVEMAT");
        modelMat.addColumn("MATERIAL");
        modelMat.addColumn("CODIGO-SAT");
        modelMat.addColumn("U-COMPRA");
        modelMat.addColumn("F-COMPRA");
        modelMat.addColumn("U-CONSUMO");
        modelMat.addColumn("F-CONSUMO");
        modelMat.addColumn("U-COSTO");
        modelMat.addColumn("C-COSTEO");
        modelMat.addColumn("C-MINIMA");
        modelMat.addColumn("C-MAXIMA");
        modelMat.addColumn("T-COSTO");
        modelMat.addColumn("DIVISA");
    }

    private void CleanTable() {
        int numFilas = modelMat.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelMat.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
