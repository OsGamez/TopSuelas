package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Color;
import ObjectLayer.ObjectColores;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Colores extends javax.swing.JInternalFrame {

    DefaultTableModel modelColor = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    ObjectColores obj = new ObjectColores();
    ObjectLayer.Color color = new ObjectLayer.Color();
    Connection c = Server.getProduccion();

    public Colores() {
        initComponents();
        LoadColumns();
        LoadModelColor();
        JtDatosColor.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JbNuevo = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JbSalir = new javax.swing.JButton();
        JbEliminar = new javax.swing.JButton();
        JbEditarCorrida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatosColor = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("COLORES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/RGB_Circle_1-80_icon-icons.com_57282.png"))); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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

        JbEditarCorrida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit-validated_40458.png"))); // NOI18N
        JbEditarCorrida.setText("EDITAR");
        JbEditarCorrida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEditarCorridaActionPerformed(evt);
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
                    .addComponent(JbEditarCorrida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(JbEditarCorrida)
                .addGap(31, 31, 31)
                .addComponent(JbReporte)
                .addGap(36, 36, 36)
                .addComponent(JbSalir)
                .addContainerGap(143, Short.MAX_VALUE))
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

        JtDatosColor.setModel(modelColor
        );
        JtDatosColor.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setViewportView(JtDatosColor);

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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        NColor nuevo = new NColor(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if (nuevo.getInformacion() != "") {
            CleanTable();
            LoadModelColor();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed
    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtDatosColor.getSelectedRow();

        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de borrar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    if (obj.colorDelete(Integer.parseInt(JtDatosColor.getValueAt(row, 0).toString()))) {
                        modelColor.removeRow(row);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este color esta asociado a un producto");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyReleased
        CleanTable();
        ArrayList<Color> listaColores = obj.colorSearch(JtBuscar.getText());
        modelColor.setNumRows(listaColores.size());
        
        for (int i = 0; i < listaColores.size(); i++) {

            Color color = listaColores.get(i);

            modelColor.setValueAt(color.getId_Color(), i, 0);
            modelColor.setValueAt(color.getDescripcion(), i, 1);

        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbEditarCorridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarCorridaActionPerformed
        NColor editar = new NColor(null, true);
        int fila = JtDatosColor.getSelectedRow();

        try {
            if (fila >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Quires editar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    editar.Jtid.setText(JtDatosColor.getValueAt(fila, 0).toString());
                    editar.JtDescripcion.setText(JtDatosColor.getValueAt(fila, 1).toString());

                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                    if (editar.getInformacion() != "") {
                        CleanTable();
                        LoadModelColor();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEditarCorridaActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        try {
            JasperReport reporte = null;

            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/CatalogoColores.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                JasperViewer view = new JasperViewer(jprint, false);

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
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_F1){
             System.out.println("BIEN");
         }
    }//GEN-LAST:event_formKeyPressed
    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }

    private void LoadColumns() {
        modelColor.addColumn("Código");
        modelColor.addColumn("DESCRIPCIÓN");

        JtDatosColor.getColumnModel().getColumn(0).setMaxWidth(0);
        JtDatosColor.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatosColor.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void LoadModelColor() {

        ArrayList<ObjectLayer.Color> listaColores = obj.coloresGetAll();

        modelColor.setNumRows(listaColores.size());

        for (int i = 0; i < listaColores.size(); i++) {
            ObjectLayer.Color color = listaColores.get(i);

            int id = color.getId_Color();
            String descripcion = color.getDescripcion();

            modelColor.setValueAt(id, i, 0);
            modelColor.setValueAt(descripcion, i, 1);
        }
    }

    private void CleanTable() {
        int numFilas = modelColor.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelColor.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEditarCorrida;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtDatosColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
