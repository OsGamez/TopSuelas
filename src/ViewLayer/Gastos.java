package ViewLayer;

import ObjectLayer.Gasto;
import ObjectLayer.ObjectGastos;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Gastos extends javax.swing.JInternalFrame {

    DefaultTableModel modelGasto = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    ObjectGastos obj = new ObjectGastos();
    Gasto gt = new Gasto();

    public Gastos() {
        initComponents();
        LoadColumns();
        LoadModelGasto();
        JtGastos.getTableHeader().setReorderingAllowed(false);
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
        JtGastos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("GASTOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/money_dollar_cash_coins_riches_wealth_icon-icons.com_53585.png"))); // NOI18N

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
                .addGap(29, 29, 29)
                .addComponent(JbReporte)
                .addGap(32, 32, 32)
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

        JtGastos.setModel(modelGasto);
        jScrollPane1.setViewportView(JtGastos);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        NGasto nuevo = new NGasto(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if (nuevo.getInformacion() != "") {
            CleanTable();
            LoadModelGasto();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        ReporteGastos r = new ReporteGastos(null, true);
        r.setVisible(true);
        r.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        r.setAlwaysOnTop(true);
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtGastos.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de borrar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    String Mes = JtGastos.getValueAt(row, 0).toString();
                    int Año = Integer.parseInt(JtGastos.getValueAt(row, 1).toString());
                    if (obj.gastoDelete(Mes, Año)) {
                        modelGasto.removeRow(row);
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
        NGasto editar = new NGasto(null, true);
        int row = JtGastos.getSelectedRow();
        try {
            if (row >= 0) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres editar este registro?", "TOP-SUELAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    
                    int mes = Integer.parseInt(JtGastos.getValueAt(row, 6).toString());
                    editar.Jtid.setText(JtGastos.getValueAt(row, 6).toString());
                    editar.JmMes.setEnabled(false);
                    editar.JyAño.setEnabled(false);
                    editar.JmMes.setMonth(mes-1);
                    editar.JyAño.setYear(Integer.parseInt(JtGastos.getValueAt(row, 1).toString()));
                    editar.JtMo.setText(String.valueOf(JtGastos.getValueAt(row, 2)));
                    editar.JtGf.setText(String.valueOf(JtGastos.getValueAt(row, 3)));
                    editar.JtGa.setText(String.valueOf(JtGastos.getValueAt(row, 4)));
                    editar.JtMi.setText(String.valueOf(JtGastos.getValueAt(row, 5)));
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                    if (editar.getInformacion() != "") {
                        CleanTable();
                        LoadModelGasto();
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
        ArrayList<Gasto> listaGastos = obj.gastoSearch(JtBuscar.getText());

        modelGasto.setNumRows(listaGastos.size());
        for (int i = 0; i < listaGastos.size(); i++) {
            Gasto g = listaGastos.get(i);
            
            DecimalFormat var = new DecimalFormat("0.00");

            modelGasto.setValueAt(g.getMes(), i, 0);
            modelGasto.setValueAt(g.getAño(), i, 1);
            modelGasto.setValueAt(var.format(g.getMo()), i, 2);
            modelGasto.setValueAt(var.format(g.getGf()), i, 3);
            modelGasto.setValueAt(var.format(g.getGa()), i, 4);
            modelGasto.setValueAt(var.format(g.getMi()), i, 5);
            modelGasto.setValueAt(g.getM(), i, 6);
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

    private void LoadModelGasto() {
        ArrayList<Gasto> listaGastos = obj.gastoGetAll();

        modelGasto.setNumRows(listaGastos.size());

        for (int i = 0; i < listaGastos.size(); i++) {
            Gasto g = listaGastos.get(i);

            DecimalFormat var = new DecimalFormat("0.00");

            modelGasto.setValueAt(g.getMes(), i, 0);
            modelGasto.setValueAt(g.getAño(), i, 1);
            modelGasto.setValueAt(var.format(g.getMo()), i, 2);
            modelGasto.setValueAt(var.format(g.getGf()), i, 3);
            modelGasto.setValueAt(var.format(g.getGa()), i, 4);
            modelGasto.setValueAt(var.format(g.getMi()), i, 5);
            modelGasto.setValueAt(g.getM(), i, 6);
        }
    }

    public void LoadColumns() {
        modelGasto.addColumn("MES");
        modelGasto.addColumn("AÑO");
        modelGasto.addColumn("MANO OBRA");
        modelGasto.addColumn("GASTOS FABRICACIÓN");
        modelGasto.addColumn("GASTOS ADMINISTRATIVOS");
        modelGasto.addColumn("MATERIAL INDIRECTO");
        modelGasto.addColumn("M");
        
        JtGastos.getColumnModel().getColumn(6).setMaxWidth(0);
        JtGastos.getColumnModel().getColumn(6).setMinWidth(0);
        JtGastos.getColumnModel().getColumn(6).setPreferredWidth(0);
    }

    private void CleanTable() {
        int numFilas = modelGasto.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelGasto.removeRow(i);
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
    private javax.swing.JTable JtGastos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
