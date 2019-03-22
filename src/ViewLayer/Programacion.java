package ViewLayer;

import ObjectLayer.ObjectPlaneacion;
import ObjectLayer.Planeacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Programacion extends javax.swing.JInternalFrame {
    ObjectPlaneacion obj = new ObjectPlaneacion();
    
    DefaultTableModel Table = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public Programacion() {
        initComponents();
        LoadColumns();
        Tb.setFont(new java.awt.Font("Tahoma", 0, 9)); 
        Jmes.setMonth(0);
    }
    
    
    
    private void LoadColumns(){
        Table.addColumn("NO");
        Table.addColumn("PEDIDO");
        Table.addColumn("CLIENTE");
        Table.addColumn("A.G");
        Table.addColumn("MODELO");
        Table.addColumn("COLOR");
        Table.addColumn("11");
        Table.addColumn("12");
        Table.addColumn("13");
        Table.addColumn("14");
        Table.addColumn("15");
        Table.addColumn("16");
        Table.addColumn("17");
        Table.addColumn("18");
        Table.addColumn("19");
        Table.addColumn("20");
        Table.addColumn("21");
        Table.addColumn("22");
        Table.addColumn("23");
        Table.addColumn("24");
        Table.addColumn("25");
        Table.addColumn("26");
        Table.addColumn("27");
        Table.addColumn("28");
        Table.addColumn("29");
        Table.addColumn("30");
        Table.addColumn("31");
        Table.addColumn("32");
        Table.addColumn("33");
        Table.addColumn("PARES");
        Table.addColumn("OBSV");
        Table.addColumn("O.COMPRA");
        
        Table.addColumn("Id_Color");
        Table.addColumn("Id_Corrida");
        Table.addColumn("Id_Producto");
        Table.addColumn("Id_Cliente");
        Table.addColumn("Id_Agente");
        
        Tb.getColumnModel().getColumn(0).setPreferredWidth(50);
        Tb.getColumnModel().getColumn(1).setPreferredWidth(105);
        Tb.getColumnModel().getColumn(2).setPreferredWidth(120);
        Tb.getColumnModel().getColumn(3).setPreferredWidth(50);
        Tb.getColumnModel().getColumn(4).setPreferredWidth(115);
        Tb.getColumnModel().getColumn(5).setPreferredWidth(110);
        Tb.getColumnModel().getColumn(6).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(7).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(8).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(9).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(10).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(11).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(12).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(13).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(14).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(15).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(16).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(17).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(18).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(19).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(20).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(21).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(22).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(23).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(24).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(25).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(26).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(27).setPreferredWidth(38);
        Tb.getColumnModel().getColumn(28).setPreferredWidth(38);
        
        Tb.getColumnModel().getColumn(32).setMaxWidth(0);
        Tb.getColumnModel().getColumn(32).setMinWidth(0);
        Tb.getColumnModel().getColumn(32).setPreferredWidth(0);
        
        Tb.getColumnModel().getColumn(33).setMaxWidth(0);
        Tb.getColumnModel().getColumn(33).setMinWidth(0);
        Tb.getColumnModel().getColumn(33).setPreferredWidth(0);
        
        Tb.getColumnModel().getColumn(34).setMaxWidth(0);
        Tb.getColumnModel().getColumn(34).setMinWidth(0);
        Tb.getColumnModel().getColumn(34).setPreferredWidth(0);
        
        Tb.getColumnModel().getColumn(35).setMaxWidth(0);
        Tb.getColumnModel().getColumn(35).setMinWidth(0);
        Tb.getColumnModel().getColumn(35).setPreferredWidth(0);
        
        Tb.getColumnModel().getColumn(36).setMaxWidth(0);
        Tb.getColumnModel().getColumn(36).setMinWidth(0);
        Tb.getColumnModel().getColumn(36).setPreferredWidth(0);
    }
    
    private void LoadModelP() {
        CleanTable();
        int Año = Jaño.getYear();
        int Mes = Jmes.getMonth();
        int Semana = (int)Jsemana.getValue();
        
        ArrayList<Planeacion> listP = obj.obtenerPlaneacion(Año, Mes+1, Semana);
        Table.setNumRows(listP.size());
        if (listP.size() > 0) {
            for (int i = 0; i < listP.size(); i++) {
                Planeacion p = listP.get(i);
                Table.setValueAt(p.getNumero(), i, 0);
                Table.setValueAt(p.getNpedido(), i, 1);
                Table.setValueAt(p.getCliente(), i, 2);
                Table.setValueAt(p.getAgente(), i, 3);
                Table.setValueAt(p.getModelo(), i, 4);
                Table.setValueAt(p.getColor(), i, 5);
                Table.setValueAt(p.getC11(), i, 6);
                Table.setValueAt(p.getC12(), i, 7);
                Table.setValueAt(p.getC13(), i, 8);
                Table.setValueAt(p.getC14(), i, 9);
                Table.setValueAt(p.getC15(), i, 10);
                Table.setValueAt(p.getC16(), i, 11);
                Table.setValueAt(p.getC17(), i, 12);
                Table.setValueAt(p.getC18(), i, 13);
                Table.setValueAt(p.getC19(), i, 14);
                Table.setValueAt(p.getC20(), i, 15);
                Table.setValueAt(p.getC21(), i, 16);
                Table.setValueAt(p.getC22(), i, 17);
                Table.setValueAt(p.getC23(), i, 18);
                Table.setValueAt(p.getC24(), i, 19);
                Table.setValueAt(p.getC25(), i, 20);
                Table.setValueAt(p.getC26(), i, 21);
                Table.setValueAt(p.getC27(), i, 22);
                Table.setValueAt(p.getC28(), i, 23);
                Table.setValueAt(p.getC29(), i, 24);
                Table.setValueAt(p.getC30(), i, 25);
                Table.setValueAt(p.getC31(), i, 26);
                Table.setValueAt(p.getC32(), i, 27);
                Table.setValueAt(p.getC33(), i, 28);
                Table.setValueAt(p.getPares(), i, 29);
                Table.setValueAt(p.getObservaciones(), i, 30);
                Table.setValueAt(p.getOrdenCompra(), i, 31);
                Table.setValueAt(p.getId_Color(), i, 32);
                Table.setValueAt(p.getId_Corrida(), i, 33);
                Table.setValueAt(p.getId_Producto(), i, 34);
                Table.setValueAt(p.getId_Cliente(), i, 35);
                Table.setValueAt(p.getId_Agente(), i, 36);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void CleanTable() {
        int file = Tb.getRowCount();
        if (file > 0) {
            for (int i = file - 1; i >= 0; i--) {
                Table.removeRow(i);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Jsemana = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jaño = new com.toedter.calendar.JYearChooser();
        Jmes = new com.toedter.calendar.JMonthChooser();
        JbBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JbLimpiar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("PROGRAMACIÓN");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Semana");

        Tb.setModel(Table);
        jScrollPane1.setViewportView(Tb);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Año:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Mes:");

        JbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Magnifier_29783.png"))); // NOI18N
        JbBuscar.setText("BUSCAR");
        JbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbBuscarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        jButton2.setText("REPORTE");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save_as-80_icon-icons.com_57275.png"))); // NOI18N
        jButton3.setText("GUARDAR");

        JbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/eraser_icon-icons.com_60679.png"))); // NOI18N
        JbLimpiar.setText("LIMPIAR");
        JbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Jaño, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3))
                    .addComponent(JbBuscar))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Jmes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Jsemana, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(JbLimpiar)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(JbBuscar)
                    .addComponent(JbLimpiar))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(Jmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Jsemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbBuscarActionPerformed
        LoadModelP();
    }//GEN-LAST:event_JbBuscarActionPerformed

    private void JbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbLimpiarActionPerformed
        CleanTable();
        Jsemana.setValue(0);
        Jmes.setMonth(0);
    }//GEN-LAST:event_JbLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser Jaño;
    private javax.swing.JButton JbBuscar;
    private javax.swing.JButton JbLimpiar;
    private com.toedter.calendar.JMonthChooser Jmes;
    private javax.swing.JSpinner Jsemana;
    private javax.swing.JTable Tb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
