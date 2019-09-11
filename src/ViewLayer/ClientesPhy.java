
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
       modelCliente.addColumn("Código");//0
        modelCliente.addColumn("N.CLIENTE");//1
        modelCliente.addColumn("NOMBRE");//2
        modelCliente.addColumn("RAZÓN SOCIAL");//3
        modelCliente.addColumn("RFC");//4
        modelCliente.addColumn("Cod");//5
        modelCliente.addColumn("CP");//6
        modelCliente.addColumn("COLONIA");//7
        modelCliente.addColumn("CALLE");//8
        modelCliente.addColumn("NumeroCalle");//9
        modelCliente.addColumn("CFDI");//10
        modelCliente.addColumn("Email");//11
        modelCliente.addColumn("Observaciones");//12
        modelCliente.addColumn("TELEFONO");//13
        modelCliente.addColumn("TELEFONO2");//14
        modelCliente.addColumn("TELEFONO3");//15
        modelCliente.addColumn("Cuenta");//16
        modelCliente.addColumn("Días Crédito");//17
        modelCliente.addColumn("CONTACTO");//18
        modelCliente.addColumn("Forma Pago");//19
        modelCliente.addColumn("MetodoPago");//20
        modelCliente.addColumn("AGENTE");//21
        modelCliente.addColumn("Cod-Agente");//22
        modelCliente.addColumn("ZONA");//23
        modelCliente.addColumn("Cod-Zona");//24
        modelCliente.addColumn("PAIS");//25
        modelCliente.addColumn("Cod-Pais");//26
        modelCliente.addColumn("ESTADO");//27
        modelCliente.addColumn("Cod-Estado");//28
        modelCliente.addColumn("CIUDAD");//29
        modelCliente.addColumn("Cod-Ciudad");//30
        modelCliente.addColumn("BANCO");//31
        modelCliente.addColumn("Cod-Banco");//32
        modelCliente.addColumn("SERIE");//33

        JtDatosCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(0).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(1).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(1).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(1).setPreferredWidth(0);

        /*JtDatosCliente.getColumnModel().getColumn(3).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(3).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(3).setPreferredWidth(0);*/

        JtDatosCliente.getColumnModel().getColumn(4).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(4).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(4).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(5).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(5).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(5).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(6).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(6).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(6).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(7).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(7).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(7).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(8).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(8).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(8).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(9).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(9).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(9).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(10).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(10).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(10).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(11).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(11).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(11).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(12).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(12).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(12).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(13).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(13).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(13).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(14).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(14).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(14).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(15).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(15).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(15).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(17).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(17).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(17).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(18).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(18).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(18).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(22).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(22).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(22).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(24).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(24).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(24).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(26).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(26).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(26).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(28).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(28).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(28).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(30).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(30).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(30).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(32).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(32).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(32).setPreferredWidth(0);

        JtDatosCliente.getColumnModel().getColumn(33).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(33).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(33).setPreferredWidth(0);
    }
    
    public void LoadModelCliente() {
        ArrayList<Cliente> listaClientes = obj.clientesGetAll();
        modelCliente.setNumRows(listaClientes.size());

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);

            modelCliente.setValueAt(cliente.getId_Cliente(), i, 0);
            modelCliente.setValueAt(cliente.getNumCliente(), i, 1);
            modelCliente.setValueAt(cliente.getNombre(), i, 2);
            modelCliente.setValueAt(cliente.getRazonSocial(), i, 3);
            modelCliente.setValueAt(cliente.getRFC(), i, 4);
            modelCliente.setValueAt(cliente.getCodigo(), i, 5);
            modelCliente.setValueAt(cliente.getCP(), i, 6);
            modelCliente.setValueAt(cliente.getColonia(), i, 7);
            modelCliente.setValueAt(cliente.getCalle(), i, 8);
            modelCliente.setValueAt(cliente.getNumeroCalle(), i, 9);
            modelCliente.setValueAt(cliente.getUsoCfdi(), i, 10);
            modelCliente.setValueAt(cliente.getEmail(), i, 11);
            modelCliente.setValueAt(cliente.getObservaciones(), i, 12);
            modelCliente.setValueAt(cliente.getTelefono(), i, 13);
            modelCliente.setValueAt(cliente.getTelefono2(), i, 14);
            modelCliente.setValueAt(cliente.getTelefono3(), i, 15);
            modelCliente.setValueAt(cliente.getCuenta(), i, 16);
            modelCliente.setValueAt(cliente.getDiasCredito(), i, 17);
            modelCliente.setValueAt(cliente.getContacto(), i, 18);
            modelCliente.setValueAt(cliente.getFormaPago(), i, 19);
            modelCliente.setValueAt(cliente.getMetodoPago(), i, 20);
            modelCliente.setValueAt(cliente.getAgente(), i, 21);
            modelCliente.setValueAt(cliente.getId_Agente(), i, 22);
            modelCliente.setValueAt(cliente.getZona(), i, 23);
            modelCliente.setValueAt(cliente.getId_Zona(), i, 24);
            modelCliente.setValueAt(cliente.getPais(), i, 25);
            modelCliente.setValueAt(cliente.getId_Pais(), i, 26);
            modelCliente.setValueAt(cliente.getEstado(), i, 27);
            modelCliente.setValueAt(cliente.getId_Estado(), i, 28);
            modelCliente.setValueAt(cliente.getCiudad(), i, 29);
            modelCliente.setValueAt(cliente.getId_Ciudad(), i, 30);
            modelCliente.setValueAt(cliente.getBanco(), i, 31);
            modelCliente.setValueAt(cliente.getId_Banco(), i, 32);
            modelCliente.setValueAt(cliente.getSerie(), i, 33);
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
        JtDatosCliente.setSelectionBackground(new java.awt.Color(102, 153, 255));
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
