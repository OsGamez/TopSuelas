package ViewLayer;

import ObjectLayer.Corrida;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Producto;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PruebaPedidos extends javax.swing.JFrame {

    ObjectProductos ObjP = new ObjectProductos();
    Corrida cr = new Corrida();
    int sum = 0;
    String c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
    ArrayList<String> array = new ArrayList<String>();
    DefaultTableModel modelP = new DefaultTableModel() {
        /*@Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }*/
    };

    public PruebaPedidos() {
        initComponents();
        Jpanel.setVisible(false);
    }

    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SUELA = new javax.swing.JLabel();
        JtSuela = new javax.swing.JTextField();
        JbCorrida = new javax.swing.JLabel();
        JbProducto = new javax.swing.JLabel();
        JbIdProd = new javax.swing.JLabel();
        JbPi = new javax.swing.JLabel();
        JbPf = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JbAgregar = new javax.swing.JButton();
        JbMostrar = new javax.swing.JButton();
        Jpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SUELA.setText("SUELA");

        JtSuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtSuelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtSuelaKeyTyped(evt);
            }
        });

        JbCorrida.setText("jLabel1");

        JbProducto.setText("jLabel1");

        JbIdProd.setText("jLabel1");

        JbPi.setText("jLabel1");

        JbPf.setText("jLabel1");

        jTable1.setModel(modelP);
        jScrollPane2.setViewportView(jTable1);

        JbAgregar.setText("AGREGAR");
        JbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAgregarActionPerformed(evt);
            }
        });

        JbMostrar.setText("MOSTRAR");
        JbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbMostrarActionPerformed(evt);
            }
        });

        Jpanel.setBorder(null);

        jList1.setModel(modeloListaProductos);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(SUELA)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(JbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbPi)
                        .addGap(43, 43, 43)
                        .addComponent(JbPf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbCorrida)
                        .addGap(43, 43, 43)
                        .addComponent(JbProducto)
                        .addGap(37, 37, 37)
                        .addComponent(JbIdProd)))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbCorrida)
                            .addComponent(JbProducto)
                            .addComponent(JbIdProd))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbPi)
                            .addComponent(JbPf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JbMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SUELA)
                            .addComponent(JtSuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtSuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyReleased
        limpiarListaProductos();
        if (JtSuela.getText().isEmpty()) {
            limpiarListaProductos();
        } else {
            ArrayList<Producto> listaProductos = ObjP.GetByC(JtSuela.getText());

            for (Producto prod : listaProductos) {
                modeloListaProductos.addElement(prod);
            }
        }
    }//GEN-LAST:event_JtSuelaKeyReleased

    private void JtSuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtSuelaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtSuelaKeyTyped

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        JList lis = (JList) evt.getSource();

        if (evt.getClickCount() == 1) {
            Producto prod = (Producto) lis.getSelectedValue();
            JbCorrida.setText(prod.getDescripcionCorrida());
            JbProducto.setText(prod.getDescripcion());
            JbIdProd.setText(String.valueOf(prod.getId_Producto()));
            JbPi.setText(String.valueOf(prod.getPti()));
            JbPf.setText(String.valueOf(prod.getPtf()));
            limpiarListaProductos();
            ValidarCorrida();
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void JbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAgregarActionPerformed
        int row = modelP.getRowCount();
        int tarreglo = sum*2;
        
        for (int i = 0; i < row; i++) {
            for(int j =0; j< tarreglo; j++){    
                String Pares = modelP.getValueAt(i, j).toString(); 
                array.add(Pares);
            } 
        }
    }//GEN-LAST:event_JbAgregarActionPerformed

    private void JbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbMostrarActionPerformed
       Object[] obj = array.toArray();
      
       
       if(obj.length == 12){
           c1 =  (String) obj[0];
           c2 =  (String) obj[1];
           c3 =  (String) obj[2];
           c4 =  (String) obj[3];
           c5 =  (String) obj[4];
           c6 =  (String) obj[5];
           c7 =  (String) obj[6];
           c8 =  (String) obj[7];
           c9 =  (String) obj[8];
           c10 =  (String) obj[9];
           c11 =  (String) obj[10];
           c12 =  (String) obj[11];
       }
    }//GEN-LAST:event_JbMostrarActionPerformed

    private void ValidarCorrida() {
        int pt1 = Integer.parseInt(JbPi.getText().substring(0, 2));
        int pt2 = Integer.parseInt(JbPf.getText().substring(0, 2));
        double num = 0.5;

        sum = pt2 - pt1 + 1;
       
        String colums = null;
        Object[] datos = {" "};
        for (int i = pt1; i <= pt2; i++) {
            colums = String.valueOf(i);
            modelP.addColumn(colums, datos);
           
            for (double j = i+num; j <= i+num; j++) {
                colums = String.valueOf(j);
                modelP.addColumn(colums, datos);
            }
        }
    }

    private void limpiarListaProductos() {
        modeloListaProductos.clear();
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
            java.util.logging.Logger.getLogger(PruebaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbAgregar;
    private javax.swing.JLabel JbCorrida;
    private javax.swing.JLabel JbIdProd;
    private javax.swing.JButton JbMostrar;
    private javax.swing.JLabel JbPf;
    private javax.swing.JLabel JbPi;
    private javax.swing.JLabel JbProducto;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JTextField JtSuela;
    private javax.swing.JLabel SUELA;
    private javax.swing.JList<Producto> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
