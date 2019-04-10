package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.ObjectAlmacenes;
import ObjectLayer.ObjectRCPT;
import ObjectLayer.PtProducto;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

public class PlaneacionPhy extends javax.swing.JInternalFrame {

    ObjectRCPT obj = new ObjectRCPT();
    ObjectAlmacenes am = new ObjectAlmacenes();

    DefaultTableModel modelPhylon = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public PlaneacionPhy() {
        initComponents();
        OcultarCampos();
        LoadColumns();
    }

    private void LoadColumns() {
        modelPhylon.addColumn("SUELA");
        modelPhylon.addColumn("ESTILO");
        modelPhylon.addColumn("CORRIDA");
        modelPhylon.addColumn("COMBINACIÓN");
        modelPhylon.addColumn("11");
        modelPhylon.addColumn("12");
        modelPhylon.addColumn("13");
        modelPhylon.addColumn("14");
        modelPhylon.addColumn("15");
        modelPhylon.addColumn("16");
        modelPhylon.addColumn("17");
        modelPhylon.addColumn("18");
        modelPhylon.addColumn("19");
        modelPhylon.addColumn("21");
        modelPhylon.addColumn("22");
        modelPhylon.addColumn("23");
        modelPhylon.addColumn("24");
        modelPhylon.addColumn("25");
        modelPhylon.addColumn("26");
        modelPhylon.addColumn("27");
        modelPhylon.addColumn("28");
        modelPhylon.addColumn("29");
        modelPhylon.addColumn("30");
        modelPhylon.addColumn("31");

        JtPhylon.getColumnModel().getColumn(0).setMaxWidth(50);
        JtPhylon.getColumnModel().getColumn(0).setMinWidth(50);
        JtPhylon.getColumnModel().getColumn(0).setPreferredWidth(50);

        JtPhylon.getColumnModel().getColumn(1).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(1).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(1).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(2).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(2).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(2).setPreferredWidth(0);

        JtPhylon.getColumnModel().getColumn(3).setMaxWidth(0);
        JtPhylon.getColumnModel().getColumn(3).setMinWidth(0);
        JtPhylon.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JtAm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JtProducto = new javax.swing.JTextField();
        JlDescripcion = new javax.swing.JLabel();
        JlPares = new javax.swing.JLabel();
        JtPares = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        JlCombinacion = new javax.swing.JLabel();
        JlCorrida = new javax.swing.JLabel();
        JlEstilo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtPhylon = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Almacén:");

        JtAm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtAmKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Suela:");

        JtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtProductoKeyPressed(evt);
            }
        });

        JlDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlDescripcion.setText("jLabel3");

        JlPares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlPares.setText("Pares:");

        JtPares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtParesKeyPressed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/crosscircleregular_106260.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ordering_25406.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("0");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Clear_37294.png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save_as-80_icon-icons.com_57275.png"))); // NOI18N

        JlCombinacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlCombinacion.setText("3");

        JlCorrida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlCorrida.setText("2");

        JlEstilo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlEstilo.setText("1");

        JtPhylon.setModel(modelPhylon);
        jScrollPane1.setViewportView(JtPhylon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(JlPares)
                                .addGap(18, 18, 18)
                                .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JlEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JlCorrida)
                                .addGap(18, 18, 18)
                                .addComponent(JlCombinacion)))
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap(197, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlPares)
                    .addComponent(JtPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlDescripcion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JlEstilo)
                        .addComponent(JlCorrida)
                        .addComponent(JlCombinacion)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton6)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtAmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtAmKeyPressed
        ArrayList<Almacen> listaA = am.getById(JtAm.getText());
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (listaA.size() > 0) {
                JtProducto.requestFocus();
            } else {
                System.out.println("NO EXISTE");
            }
        }
    }//GEN-LAST:event_JtAmKeyPressed

    private void JtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtProductoKeyPressed
        ArrayList<PtProducto> listaP = obj.getPhylon(JtProducto.getText());

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (listaP.size() > 0) {
                for (PtProducto pt : listaP) {
                    JlDescripcion.setVisible(true);
                    JlDescripcion.setText(pt.getDescripcion());
                    JlEstilo.setText(String.valueOf(pt.getEstilo()));
                    JlCorrida.setText(String.valueOf(pt.getCorrida()));
                    JlCombinacion.setText(String.valueOf(pt.getCombinacion()));
                    JtPares.requestFocus();
                }
            } else {
                System.out.println("NO EXISTE");
            }
        }

    }//GEN-LAST:event_JtProductoKeyPressed

    private void JtParesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtParesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            InformePhylon nuevo = new InformePhylon(null, true);
            nuevo.setVisible(true);
            nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            nuevo.setAlwaysOnTop(true);

        }
    }//GEN-LAST:event_JtParesKeyPressed

    private void OcultarCampos() {
        JlDescripcion.setVisible(false);
        JlEstilo.setVisible(false);
        JlCorrida.setVisible(false);
        JlCombinacion.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlCombinacion;
    private javax.swing.JLabel JlCorrida;
    private javax.swing.JLabel JlDescripcion;
    private javax.swing.JLabel JlEstilo;
    private javax.swing.JLabel JlPares;
    private javax.swing.JTextField JtAm;
    private javax.swing.JTextField JtPares;
    private javax.swing.JTable JtPhylon;
    private javax.swing.JTextField JtProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
