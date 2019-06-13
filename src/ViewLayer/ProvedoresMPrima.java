package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.ObjectProveedoresMPrima;
import ObjectLayer.ProveedorMPrima;
import java.sql.Connection;
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

public class ProvedoresMPrima extends javax.swing.JInternalFrame {
     ArrayList<ProveedorMPrima> listaProveedorMPrima;
    ObjectProveedoresMPrima obj = new ObjectProveedoresMPrima();
    DefaultTableModel modelProvedorPrima = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ProvedoresMPrima() {
        initComponents();
        LoadColumns();
        LoadmodelProvedorPrima();
    }

    private void LoadColumns() {
        modelProvedorPrima.addColumn("NOMBRE");
        modelProvedorPrima.addColumn("RFC");
        modelProvedorPrima.addColumn("DIRECCION");
        modelProvedorPrima.addColumn("ESTADO");
        modelProvedorPrima.addColumn("CIUDAD");
        modelProvedorPrima.addColumn("TELEFONO");
        modelProvedorPrima.addColumn("EMAIL");
        
    }

    private void LoadmodelProvedorPrima() {
       listaProveedorMPrima = obj.ProveedorMPrimaGetAll();
        modelProvedorPrima.setNumRows(listaProveedorMPrima.size());
        for (int i = 0; i < listaProveedorMPrima.size(); i++) {
            ProveedorMPrima p = listaProveedorMPrima.get(i);
            modelProvedorPrima.setValueAt(p.getNombre(), i, 0);
            modelProvedorPrima.setValueAt(p.getRfc(), i, 1);
            modelProvedorPrima.setValueAt(p.getCalle(), i, 2);
            modelProvedorPrima.setValueAt(p.getEstado(), i, 3);
            modelProvedorPrima.setValueAt(p.getCiudad(), i, 4);
            modelProvedorPrima.setValueAt(p.getTelefono(), i, 5);
            modelProvedorPrima.setValueAt(p.getEmail(), i, 6);
        }
    }

    private void CleanTable() {
        int numFilas = modelProvedorPrima.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelProvedorPrima.removeRow(i);
            }
        }
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
        JtProveedorMPrima = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Proveedores Materia Prima");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delivery.png"))); // NOI18N

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
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JbNuevo)
                .addGap(32, 32, 32)
                .addComponent(JbEliminar)
                .addGap(29, 29, 29)
                .addComponent(JbEditar)
                .addGap(31, 31, 31)
                .addComponent(JbReporte)
                .addGap(32, 32, 32)
                .addComponent(JbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR:");

        JtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtBuscarActionPerformed(evt);
            }
        });
        JtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtBuscarKeyTyped(evt);
            }
        });

        JtProveedorMPrima.setModel(modelProvedorPrima);
        jScrollPane1.setViewportView(JtProveedorMPrima);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
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
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        NProveedorMPrima nuevo = new NProveedorMPrima(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if (nuevo.getInformacion() != "") {
            CleanTable();
            LoadmodelProvedorPrima();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
         try {
             Connection c = Server.getCmpPhylon();
                Map par = new HashMap();
                par.put("nombre", JtBuscar.getText());
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/CatalogoProveedorMPrima.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                    JasperViewer view = new JasperViewer(jprint, false);
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    view.setTitle("TOP-SUELAS");
                } catch (JRException ex) {
                    Logger.getLogger(ReporteConsumos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReporteConsumos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtProveedorMPrima.getSelectedRow();
        int id=listaProveedorMPrima.get(row).getProveedor();
        if(obj.ProveedorMPrimaDelete(id)){
            modelProvedorPrima.removeRow(row);
        }else
            JOptionPane.showMessageDialog(null, "Ocurrio un error contacta con sistemas");
        try {
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
        NProveedorMPrima editar = new NProveedorMPrima(null, true);
        int row = JtProveedorMPrima.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres editar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    editar.Jtid.setText(String.valueOf(listaProveedorMPrima.get(row).getProveedor()));
                    editar.JtNombre.setText(listaProveedorMPrima.get(row).getNombre());
                    editar.JtRfc.setText(listaProveedorMPrima.get(row).getRfc());
                    editar.JtDir.setText(listaProveedorMPrima.get(row).getCalle());
                    editar.JtCol.setText(listaProveedorMPrima.get(row).getColonia());
                    editar.JtCiudad.setText(listaProveedorMPrima.get(row).getCiudad());
                    editar.JtEstado.setText(listaProveedorMPrima.get(row).getEstado());
                    editar.Jtpais.setText(listaProveedorMPrima.get(row).getPais());
                    editar.JtCp.setText(listaProveedorMPrima.get(row).getCp());
                    editar.JtEmbarque.setText(listaProveedorMPrima.get(row).getEmbarque());
                    editar.JtCorreo.setText(listaProveedorMPrima.get(row).getEmail());
                    editar.JtContacto.setText(listaProveedorMPrima.get(row).getContacto());
                    editar.JtCredito.setText(String.valueOf(listaProveedorMPrima.get(row).getDiascredito()));
                    editar.JtLcredito.setText(listaProveedorMPrima.get(row).getLimitecredito());
                    editar.JtTel.setText(listaProveedorMPrima.get(row).getTelefono());
                    editar.JtTelaux.setText(listaProveedorMPrima.get(row).getTelefono2());
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                    if (editar.getInformacion() != "") {
                        CleanTable();
                        LoadmodelProvedorPrima();
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
        ArrayList<ProveedorMPrima> listaProveedorMPrima = obj.ProveedorMPrimaSearch(JtBuscar.getText());
        modelProvedorPrima.setNumRows(listaProveedorMPrima.size());
        for (int i = 0; i < listaProveedorMPrima.size(); i++) {
            ProveedorMPrima p = listaProveedorMPrima.get(i);
            modelProvedorPrima.setValueAt(p.getNombre(), i, 0);
            modelProvedorPrima.setValueAt(p.getRfc(), i, 1);
            modelProvedorPrima.setValueAt(p.getCalle(), i, 2);
            modelProvedorPrima.setValueAt(p.getEstado(), i, 3);
            modelProvedorPrima.setValueAt(p.getCiudad(), i, 4);
            modelProvedorPrima.setValueAt(p.getTelefono(), i, 5);
            modelProvedorPrima.setValueAt(p.getEmail(), i, 6);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped

    private void JtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtProveedorMPrima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
