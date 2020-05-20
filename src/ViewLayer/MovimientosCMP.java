package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Agente;
import ObjectLayer.Banco;
import ObjectLayer.Ciudad;
import ObjectLayer.Cliente;
import ObjectLayer.Estado;
import ObjectLayer.KardexCmp;
import ObjectLayer.ObjectClientes;
import ObjectLayer.ObjectKardexCmp;
import ObjectLayer.Pais;
import ObjectLayer.Zona;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class MovimientosCMP extends javax.swing.JInternalFrame {

    ObjectKardexCmp obj = new ObjectKardexCmp();
    DefaultTableModel modelkardexcmp = new DefaultTableModel();
    ArrayList<KardexCmp> listakardex;
    public String Serie = "";

    public MovimientosCMP() {
        initComponents();
        LoadColumns();
        Loadmodelkardexcmp();
        JbEliminar.setVisible(false);
        JbEditar.setVisible(false);
       // JtDatosCliente.getTableHeader().setReorderingAllowed(false);
    }

    public void LoadColumns() {
        modelkardexcmp.addColumn("Folio");
        modelkardexcmp.addColumn("Cuenta");
        modelkardexcmp.addColumn("Subcuenta");
        modelkardexcmp.addColumn("Fecha Mov");
        modelkardexcmp.addColumn("Serie");
        modelkardexcmp.addColumn("Almacen");
        modelkardexcmp.addColumn("Material");
        modelkardexcmp.addColumn("Cantidad");
    }

    public void Loadmodelkardexcmp() {
        listakardex = obj.KardexCmpGatAll();
        modelkardexcmp.setNumRows(listakardex.size());
        for (int i = 0; i < listakardex.size(); i++) {
            KardexCmp kardex = listakardex.get(i);
            modelkardexcmp.setValueAt(kardex.getFolio(), i, 0);
            modelkardexcmp.setValueAt(kardex.getCuenta(), i, 1);
            modelkardexcmp.setValueAt(kardex.getSubcuenta(), i, 2);
            modelkardexcmp.setValueAt(kardex.getFechamov(), i, 3);
            modelkardexcmp.setValueAt(kardex.getSerie(), i, 4);
            modelkardexcmp.setValueAt(kardex.getNombrealmacen(), i, 5);
            modelkardexcmp.setValueAt(kardex.getNombrematerial(), i, 6);
            modelkardexcmp.setValueAt(kardex.getCantidad(), i, 7);
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
        JtDatosCliente = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Entradas y Salidas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Banking_00016_A_icon-icons.com_59832.png"))); // NOI18N

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JbNuevo)
                .addGap(18, 18, 18)
                .addComponent(JbReporte)
                .addGap(18, 18, 18)
                .addComponent(JbSalir)
                .addGap(188, 188, 188)
                .addComponent(JbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbEditar)
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

        JtDatosCliente.setModel(modelkardexcmp);
        jScrollPane1.setViewportView(JtDatosCliente);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        MovimientosesCMP nuevo = new MovimientosesCMP(null, true);
        //nuevo.JbSerie.setText(Serie);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);

        if (nuevo.getInformacion() != "") {
            CleanTable();
            Loadmodelkardexcmp();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtDatosCliente.getSelectedRow();

        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de borrar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
//                    if (obj.clienteDelete(Integer.parseInt(JtDatosCliente.getValueAt(row, 0).toString()))) {
//                        modelkardexcmp.removeRow(row);
//                        JOptionPane.showMessageDialog(null, "Registro eliminado");
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Este cliente tiene pedidos activos en el sistema");
//                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
        NCliente editar = new NCliente(null, true);
        int fila = JtDatosCliente.getSelectedRow();

        try {
            if (fila >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Quires editar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    Agente ag = new Agente();
                    Banco bn = new Banco();
                    Estado ed = new Estado();
                    Ciudad cd = new Ciudad();
                    Pais ps = new Pais();
                    Zona zn = new Zona();

                    editar.Jtid.setText(JtDatosCliente.getValueAt(fila, 0).toString());
                    editar.JbNumC.setText(JtDatosCliente.getValueAt(fila, 1).toString());
                    editar.JtNombre.setText(JtDatosCliente.getValueAt(fila, 2).toString());
                    editar.JtRs.setText(JtDatosCliente.getValueAt(fila, 3).toString());
                    editar.JtRFC.setText(JtDatosCliente.getValueAt(fila, 4).toString());
                    editar.JtCod.setText(JtDatosCliente.getValueAt(fila, 5).toString());
                    editar.JtCP.setText(JtDatosCliente.getValueAt(fila, 6).toString());
                    editar.JtColonia.setText(JtDatosCliente.getValueAt(fila, 7).toString());
                    editar.JtCalle.setText(JtDatosCliente.getValueAt(fila, 8).toString());
                    editar.JtNum.setText(JtDatosCliente.getValueAt(fila, 9).toString());
                    editar.JtCf.setText(JtDatosCliente.getValueAt(fila, 10).toString());
                    editar.JtEmail.setText(JtDatosCliente.getValueAt(fila, 11).toString());
                    editar.JaObv.setText(JtDatosCliente.getValueAt(fila, 12).toString());
                    editar.JtTel.setText(JtDatosCliente.getValueAt(fila, 13).toString());
                    editar.JtTel2.setText(JtDatosCliente.getValueAt(fila, 14).toString());
                    editar.JtTel3.setText(JtDatosCliente.getValueAt(fila, 15).toString());
                    editar.JtCta.setText(JtDatosCliente.getValueAt(fila, 16).toString());
                    editar.JsCred.setValue(JtDatosCliente.getValueAt(fila, 17));
                    editar.JtContacto.setText(JtDatosCliente.getValueAt(fila, 18).toString());
                    editar.JcFpago.setSelectedItem(JtDatosCliente.getValueAt(fila, 19));
                    editar.JcMpago.setSelectedItem(JtDatosCliente.getValueAt(fila, 20));
                    ag.setDescripcion(JtDatosCliente.getValueAt(fila, 21).toString());
                    ag.setId_Agente((int) JtDatosCliente.getValueAt(fila, 22));
                    editar.JcAgente.getModel().setSelectedItem(ag);
                    zn.setDescripcion(JtDatosCliente.getValueAt(fila, 23).toString());
                    zn.setId_Zona((int) JtDatosCliente.getValueAt(fila, 24));
                    editar.JcZona.getModel().setSelectedItem(zn);
                    ps.setDescripcion(JtDatosCliente.getValueAt(fila, 25).toString());
                    ps.setId_Pais((int) JtDatosCliente.getValueAt(fila, 26));
                    editar.JcPais.getModel().setSelectedItem(ps);
                    ed.setDescripcion(JtDatosCliente.getValueAt(fila, 27).toString());
                    ed.setId_Estado((int) JtDatosCliente.getValueAt(fila, 28));
                    editar.JcEstado.getModel().setSelectedItem(ed);
                    cd.setDescripcion(JtDatosCliente.getValueAt(fila, 29).toString());
                    cd.setId_Ciudad((int) JtDatosCliente.getValueAt(fila, 30));
                    editar.JcCiudad.getModel().setSelectedItem(cd);
                    bn.setDescripcion(JtDatosCliente.getValueAt(fila, 31).toString());
                    bn.setId_Banco((int) JtDatosCliente.getValueAt(fila, 32));
                    editar.JcBanco.getModel().setSelectedItem(bn);
                    editar.JbSerie.setText(JtDatosCliente.getValueAt(fila, 33).toString());
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                    if (editar.getInformacion() != "") {
                        CleanTable();
                        Loadmodelkardexcmp();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEditarActionPerformed

    private void JtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyReleased
        CleanTable();
        listakardex = obj.KardexCmpSearch(JtBuscar.getText());
        modelkardexcmp.setNumRows(listakardex.size());

        for (int i = 0; i < listakardex.size(); i++) {
            KardexCmp kardex = listakardex.get(i);

            modelkardexcmp.setValueAt(kardex.getFolio(), i, 0);
            modelkardexcmp.setValueAt(kardex.getCuenta(), i, 1);
            modelkardexcmp.setValueAt(kardex.getSubcuenta(), i, 2);
            modelkardexcmp.setValueAt(kardex.getFechamov(), i, 3);
            modelkardexcmp.setValueAt(kardex.getSerie(), i, 4);
            modelkardexcmp.setValueAt(kardex.getNombrealmacen(), i, 5);
            modelkardexcmp.setValueAt(kardex.getNombrematerial(), i, 6);
            modelkardexcmp.setValueAt(kardex.getCantidad(), i, 7);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
       
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped
    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Banking_00016_A_icon-icons.com_59832.png"));
        return icon;
    }

    private void CleanTable() {
        int numFilas = modelkardexcmp.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelkardexcmp.removeRow(i);
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
    private javax.swing.JTable JtDatosCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
