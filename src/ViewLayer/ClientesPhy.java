
package ViewLayer;

import ObjectLayer.Cliente;
import ObjectLayer.ObjectClientes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ClientesPhy extends javax.swing.JDialog {

    
    ObjectClientes obj = new ObjectClientes();
    DefaultTableModel modelCliente = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public ClientesPhy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        LoadColumns();
        LoadModelCliente();
    }

    public void LoadColumns() {
        modelCliente.addColumn("N.CLIENTE");//0
        modelCliente.addColumn("NOMBRE");//1
        modelCliente.addColumn("RAZÓN SOCIAL");//2
        modelCliente.addColumn("RFC");//3
        modelCliente.addColumn("CODIGO");//4
        modelCliente.addColumn("COLONIA");//5
        modelCliente.addColumn("CALLE");//6
        modelCliente.addColumn("CFDI");//7
        modelCliente.addColumn("CUENTA");//8
        modelCliente.addColumn("FORMA PAGO");//9
        modelCliente.addColumn("METODO PAGO");//10
        modelCliente.addColumn("SERIE");//11
    }
    
    public void LoadModelCliente() {
        ArrayList<Cliente> listaClientes = obj.clientesGetAll();
        modelCliente.setNumRows(listaClientes.size());

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);

            modelCliente.setValueAt(cliente.getNumCliente(), i, 0);
            modelCliente.setValueAt(cliente.getNombre(), i, 1);
            modelCliente.setValueAt(cliente.getRazonSocial(), i, 2);
            modelCliente.setValueAt(cliente.getRFC(), i, 3);
            modelCliente.setValueAt(cliente.getCodigo(), i, 4);
            modelCliente.setValueAt(cliente.getColonia(), i, 5);
            modelCliente.setValueAt(cliente.getCalle(), i, 6);
            modelCliente.setValueAt(cliente.getNumeroCalle(), i, 7);
            modelCliente.setValueAt(cliente.getCuenta(), i, 8);
            modelCliente.setValueAt(cliente.getFormaPago(), i, 9);
            modelCliente.setValueAt(cliente.getMetodoPago(), i, 10);
            modelCliente.setValueAt(cliente.getSerie(), i, 11);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatosCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LISTADO DE CLIENTES");
        setPreferredSize(new java.awt.Dimension(1000, 500));
        setResizable(false);

        JtDatosCliente.setModel(modelCliente);
        jScrollPane1.setViewportView(JtDatosCliente);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyPressed
        CleanTable();
        JtBuscar.getText();
        ArrayList<Cliente> listaClientes = obj.clienteSearch(JtBuscar.getText());
        listaClientes.size();
        modelCliente.setNumRows(listaClientes.size());
        
         for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            
            modelCliente.setValueAt(cliente.getNumCliente(), i, 0);
            modelCliente.setValueAt(cliente.getNombre(), i, 1);
            modelCliente.setValueAt(cliente.getRazonSocial(), i, 2);
            modelCliente.setValueAt(cliente.getRFC(), i, 3);
            modelCliente.setValueAt(cliente.getCodigo(), i, 4);
            modelCliente.setValueAt(cliente.getColonia(), i, 5);
            modelCliente.setValueAt(cliente.getCalle(), i, 6);
            modelCliente.setValueAt(cliente.getNumeroCalle(), i, 7);
            modelCliente.setValueAt(cliente.getCuenta(), i, 8);
            modelCliente.setValueAt(cliente.getFormaPago(), i, 9);
            modelCliente.setValueAt(cliente.getMetodoPago(), i, 10);
            modelCliente.setValueAt(cliente.getSerie(), i, 11);
         }
    }//GEN-LAST:event_JtBuscarKeyPressed

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped
    
    private void CleanTable() {
        int numFilas = modelCliente.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modelCliente.removeRow(i);
            }
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
            java.util.logging.Logger.getLogger(ClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesPhy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClientesPhy dialog = new ClientesPhy(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable JtDatosCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
