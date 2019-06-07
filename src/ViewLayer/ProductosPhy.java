/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import ObjectLayer.ObjectProductos;
import ObjectLayer.Producto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProductosPhy extends javax.swing.JDialog {

    ObjectProductos obj = new ObjectProductos();
    DefaultTableModel modelProducto = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ProductosPhy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        LoadColumns();
        LoadModelProducto();
    }

    public void LoadColumns() {
        modelProducto.addColumn("DESCRIPCIÓN");
        modelProducto.addColumn("OBSERVACIONES");
        modelProducto.addColumn("COLOR");
        modelProducto.addColumn("CORRIDA");
        modelProducto.addColumn("LINEA");
    }

    public void LoadModelProducto() {

        ArrayList<Producto> listaProductos = obj.productosGetAll();

        modelProducto.setNumRows(listaProductos.size());

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);

            modelProducto.setValueAt(producto.getDescripcion(), i, 0);
            modelProducto.setValueAt(producto.getObservaciones(), i, 1);
            modelProducto.setValueAt(producto.getDescripcionColor(), i, 2);
            modelProducto.setValueAt(producto.getDescripcionCorrida(), i, 3);
            modelProducto.setValueAt(producto.getDescripcionLinea(), i, 4);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatosProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JtDatosProducto.setModel(modelProducto);
        jScrollPane1.setViewportView(JtDatosProducto);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search_book_open_search_locate_6178.png"))); // NOI18N
        jLabel1.setText("Buscar");

        JtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyPressed
        CleanTable();
  
        ArrayList<Producto> listaProductos = obj.productoSearch(JtBuscar.getText());
   
        modelProducto.setNumRows(listaProductos.size());

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            modelProducto.setValueAt(producto.getDescripcion(), i, 0);
            modelProducto.setValueAt(producto.getObservaciones(), i, 1);
            modelProducto.setValueAt(producto.getDescripcionColor(), i, 2);
            modelProducto.setValueAt(producto.getDescripcionCorrida(), i, 3);
            modelProducto.setValueAt(producto.getDescripcionLinea(), i, 4);
        }
    }//GEN-LAST:event_JtBuscarKeyPressed

    private void CleanTable(){
        int numFilas = modelProducto.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >=0; i--){
                modelProducto.removeRow(i);            }
        }
    }
    
    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped

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
            java.util.logging.Logger.getLogger(ProductosPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductosPhy dialog = new ProductosPhy(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtDatosProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
