package ViewLayer;

import ObjectLayer.Almacen;
import ObjectLayer.ObjectAlmacenes;
import ObjectLayer.ObjectRCPT;
import ObjectLayer.PtProducto;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InformePhylon extends javax.swing.JDialog {

    ObjectRCPT obj = new ObjectRCPT();
    ObjectAlmacenes am = new ObjectAlmacenes();

    DefaultTableModel modelPhylon = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public InformePhylon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        LoadColumns();
        JtPhylon.getTableHeader().setReorderingAllowed(false);
    }

    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {

        }
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

        JlEstilo = new javax.swing.JLabel();
        JlCorrida = new javax.swing.JLabel();
        JlCombinacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtPhylon = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        L4 = new javax.swing.JLabel();
        L5 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        L9 = new javax.swing.JLabel();
        L7 = new javax.swing.JLabel();
        L8 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        L13 = new javax.swing.JLabel();
        L10 = new javax.swing.JLabel();
        L12 = new javax.swing.JLabel();
        L11 = new javax.swing.JLabel();
        L14 = new javax.swing.JLabel();
        Jt1 = new javax.swing.JTextField();
        Jt2 = new javax.swing.JTextField();
        Jt3 = new javax.swing.JTextField();
        Jt4 = new javax.swing.JTextField();
        Jt5 = new javax.swing.JTextField();
        Jt6 = new javax.swing.JTextField();
        Jt7 = new javax.swing.JTextField();
        Jt8 = new javax.swing.JTextField();
        Jt9 = new javax.swing.JTextField();
        Jt10 = new javax.swing.JTextField();
        Jt11 = new javax.swing.JTextField();
        Jt12 = new javax.swing.JTextField();
        Jt13 = new javax.swing.JTextField();
        Jt14 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JlEstilo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlEstilo.setText("1");

        JlCorrida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlCorrida.setText("2");

        JlCombinacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JlCombinacion.setText("3");

        JtPhylon.setModel(modelPhylon);
        jScrollPane1.setViewportView(JtPhylon);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save_as-80_icon-icons.com_57275.png"))); // NOI18N

        L4.setText("14");

        L5.setText("15");

        L3.setText("13");

        L2.setText("12");

        L1.setText("11");

        L9.setText("19");

        L7.setText("17");

        L8.setText("18");

        L6.setText("16");

        L13.setText("23");

        L10.setText("20");

        L12.setText("22");

        L11.setText("21");

        L14.setText("24");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L1)
                                .addGap(40, 40, 40)
                                .addComponent(L2)
                                .addGap(36, 36, 36)
                                .addComponent(L3)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(L4)
                                .addGap(33, 33, 33)
                                .addComponent(L5)
                                .addGap(37, 37, 37)
                                .addComponent(L6)
                                .addGap(37, 37, 37)
                                .addComponent(L7)
                                .addGap(35, 35, 35)
                                .addComponent(L8)
                                .addGap(36, 36, 36)
                                .addComponent(L9)
                                .addGap(33, 33, 33)
                                .addComponent(L10)
                                .addGap(38, 38, 38)
                                .addComponent(L11)
                                .addGap(36, 36, 36)
                                .addComponent(L12)
                                .addGap(36, 36, 36)
                                .addComponent(L13)
                                .addGap(34, 34, 34)
                                .addComponent(L14))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jt14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JlEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JlCorrida)
                        .addGap(18, 18, 18)
                        .addComponent(JlCombinacion)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 417, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlEstilo)
                    .addComponent(JlCorrida)
                    .addComponent(JlCombinacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L1)
                    .addComponent(L2)
                    .addComponent(L3)
                    .addComponent(L4)
                    .addComponent(L5)
                    .addComponent(L6)
                    .addComponent(L7)
                    .addComponent(L8)
                    .addComponent(L9)
                    .addComponent(L10)
                    .addComponent(L11)
                    .addComponent(L12)
                    .addComponent(L13)
                    .addComponent(L14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing
     
    private void ValidarCorrida(){
        switch (JlCorrida.getText()){
            case "93":
                L1.setVisible(true);
                L1.setText("25");
                Jt1.setVisible(true);
                L2.setVisible(true);
                Jt2.setVisible(true);
            default:
                        break;    
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
            java.util.logging.Logger.getLogger(InformePhylon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformePhylon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformePhylon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformePhylon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InformePhylon dialog = new InformePhylon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlCombinacion;
    private javax.swing.JLabel JlCorrida;
    private javax.swing.JLabel JlEstilo;
    private javax.swing.JTextField Jt1;
    private javax.swing.JTextField Jt10;
    private javax.swing.JTextField Jt11;
    private javax.swing.JTextField Jt12;
    private javax.swing.JTextField Jt13;
    private javax.swing.JTextField Jt14;
    private javax.swing.JTextField Jt2;
    private javax.swing.JTextField Jt3;
    private javax.swing.JTextField Jt4;
    private javax.swing.JTextField Jt5;
    private javax.swing.JTextField Jt6;
    private javax.swing.JTextField Jt7;
    private javax.swing.JTextField Jt8;
    private javax.swing.JTextField Jt9;
    private javax.swing.JTable JtPhylon;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L10;
    private javax.swing.JLabel L11;
    private javax.swing.JLabel L12;
    private javax.swing.JLabel L13;
    private javax.swing.JLabel L14;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L7;
    private javax.swing.JLabel L8;
    private javax.swing.JLabel L9;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
