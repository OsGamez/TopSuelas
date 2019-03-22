
package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Color;
import ObjectLayer.Corrida;
import ObjectLayer.Linea;
import ObjectLayer.ObjectProductos;
import ObjectLayer.Producto;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Productos extends javax.swing.JInternalFrame {
   ObjectProductos obj = new ObjectProductos();
   DefaultTableModel modelProducto = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }
   };
   Connection c = Server.getProduccion();
    public Productos() {
        initComponents();
        LoadColumns();
        LoadModelProducto();   
        JtDatosProducto.getTableHeader().setReorderingAllowed(false);
    }
    public void LoadColumns(){
        modelProducto.addColumn("Código Producto");
        modelProducto.addColumn("DESCRIPCIÓN");
        modelProducto.addColumn("OBSERVACIONES");
        modelProducto.addColumn("COLOR");
        modelProducto.addColumn("Código-Color");
        modelProducto.addColumn("CORRIDA");
        modelProducto.addColumn("Código-Corrida");
        modelProducto.addColumn("LINEA");
        modelProducto.addColumn("Código-Linea");
        
        JtDatosProducto.getColumnModel().getColumn(0).setMaxWidth(0);
        JtDatosProducto.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatosProducto.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        JtDatosProducto.getColumnModel().getColumn(4).setMaxWidth(0);
        JtDatosProducto.getColumnModel().getColumn(4).setMinWidth(0);
        JtDatosProducto.getColumnModel().getColumn(4).setPreferredWidth(0);
            
        JtDatosProducto.getColumnModel().getColumn(6).setMaxWidth(0);
        JtDatosProducto.getColumnModel().getColumn(6).setMinWidth(0);
        JtDatosProducto.getColumnModel().getColumn(6).setPreferredWidth(0);
            
        JtDatosProducto.getColumnModel().getColumn(8).setMaxWidth(0);
        JtDatosProducto.getColumnModel().getColumn(8).setMinWidth(0);
        JtDatosProducto.getColumnModel().getColumn(8).setPreferredWidth(0);
    }
    public void LoadModelProducto(){
        
        ArrayList<Producto>listaProductos = obj.productosGetAll();
        
        modelProducto.setNumRows(listaProductos.size());
        
        for(int i =0; i <listaProductos.size(); i++){
            Producto producto = listaProductos.get(i);
            
            int id = producto.getId_Producto();
            String nombre = producto.getDescripcion();
            String obv = producto.getObservaciones();
            String color = producto.getDescripcionColor();
            String corrida = producto.getDescripcionCorrida();
            String linea = producto.getDescripcionLinea();
            int id_color = producto.getId_Color();
            int id_corrida = producto.getId_Corrida();
            int id_linea = producto.getId_Linea();
            
            modelProducto.setValueAt(id, i, 0);
            modelProducto.setValueAt(nombre, i, 1);
            modelProducto.setValueAt(obv, i, 2);
            modelProducto.setValueAt(color, i, 3);
            modelProducto.setValueAt(id_color, i, 4);
            modelProducto.setValueAt(corrida, i, 5);
            modelProducto.setValueAt(id_corrida, i, 6);
            modelProducto.setValueAt(linea, i, 7);
            modelProducto.setValueAt(id_linea, i, 8);
           
        }
    }
    private void CleanTable(){
        int numFilas = modelProducto.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >=0; i--){
                modelProducto.removeRow(i);            }
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatosProducto = new javax.swing.JTable();
        JpMenu = new javax.swing.JPanel();
        JbNuevo = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JbSalir = new javax.swing.JButton();
        JbEliminar = new javax.swing.JButton();
        JbEditar = new javax.swing.JButton();
        JbActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setTitle("SUELAS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Vans_Sundown_Black_37299.png"))); // NOI18N

        JtDatosProducto.setModel(modelProducto);
        jScrollPane1.setViewportView(JtDatosProducto);

        JpMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

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

        JbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N
        JbActualizar.setText("REFRESCAR");
        JbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpMenuLayout = new javax.swing.GroupLayout(JpMenu);
        JpMenu.setLayout(JpMenuLayout);
        JpMenuLayout.setHorizontalGroup(
            JpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpMenuLayout.setVerticalGroup(
            JpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JbNuevo)
                .addGap(32, 32, 32)
                .addComponent(JbEliminar)
                .addGap(29, 29, 29)
                .addComponent(JbEditar)
                .addGap(31, 31, 31)
                .addComponent(JbReporte)
                .addGap(31, 31, 31)
                .addComponent(JbActualizar)
                .addGap(29, 29, 29)
                .addComponent(JbSalir)
                .addContainerGap(87, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(JpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        NProducto nuevo = new NProducto(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
         if(nuevo.getInformacion()!=""){ 
                    CleanTable();
                    LoadModelProducto();
         }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyReleased
        CleanTable();
        JtBuscar.getText();
        ArrayList<Producto>listaProductos = obj.productoSearch(JtBuscar.getText());
       
        modelProducto.setNumRows(listaProductos.size());
        
        for(int i = 0; i < listaProductos.size(); i++){
            Producto producto = listaProductos.get(i);
            
            int id = producto.getId_Producto();
            String nombre = producto.getDescripcion();
            String obv = producto.getObservaciones();
            String color = producto.getDescripcionColor();
            String corrida = producto.getDescripcionCorrida();
            String linea = producto.getDescripcionLinea();
            int id_color = producto.getId_Color();
            int id_corrida = producto.getId_Corrida();
            int id_linea = producto.getId_Linea();
            
            modelProducto.setValueAt(id, i, 0);
            modelProducto.setValueAt(nombre, i, 1);
            modelProducto.setValueAt(obv, i, 2);
            modelProducto.setValueAt(color, i, 3);
            modelProducto.setValueAt(id_color, i, 4);
            modelProducto.setValueAt(corrida, i, 5);
            modelProducto.setValueAt(id_corrida, i, 6);
            modelProducto.setValueAt(linea, i, 7);
            modelProducto.setValueAt(id_linea, i, 8);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
    MProducto editar = new MProducto(null, true);
    int fila = JtDatosProducto.getSelectedRow();       
    try{
        if(fila>=0){
        int opcion = JOptionPane.showConfirmDialog(this,"¿Quieres editar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opcion ==JOptionPane.YES_OPTION){
        Color cl = new Color();
        Corrida cr = new Corrida();
        Linea ln = new Linea();
        editar.JtId.setText(JtDatosProducto.getValueAt(fila, 0).toString());
        editar.JtNombre.setText(JtDatosProducto.getValueAt(fila, 1).toString());
        editar.JaObservacion.setText(JtDatosProducto.getValueAt(fila, 2).toString());
        cl.setDescripcion(JtDatosProducto.getValueAt(fila, 3).toString());
        cl.setId_Color((int) JtDatosProducto.getValueAt(fila, 4));
        cr.setDescripcion(JtDatosProducto.getValueAt(fila, 5).toString());
        cr.setId_Corrida((int)JtDatosProducto.getValueAt(fila, 6));
        ln.setDescripcion(JtDatosProducto.getValueAt(fila, 7).toString());
        ln.setId_Linea((int)JtDatosProducto.getValueAt(fila, 8));
        editar.JcLinea.getModel().setSelectedItem(ln);
        editar.JcColor.getModel().setSelectedItem(cl);
        editar.JcCorrida.getModel().setSelectedItem(cr);
        editar.setVisible(true);
        editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        editar.setAlwaysOnTop(true);
        if(editar.getInformacion()!=""){ 
                    CleanTable();
                    LoadModelProducto();
                }
              }
            }else{
                  JOptionPane.showMessageDialog(null,"No se ha seleccionado ningun registro");  
                }
        }
        catch(Exception ex){
            
            ex.printStackTrace();
        }
            
    }//GEN-LAST:event_JbEditarActionPerformed
  
    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
       int row = JtDatosProducto.getSelectedRow();
       try{
            if(row >= 0){
              int opcion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de borrar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
             if(opcion ==JOptionPane.YES_OPTION){
               if(obj.productoDelete(Integer.parseInt(JtDatosProducto.getValueAt(row, 0).toString()))){
                   modelProducto.removeRow(row);
                   JOptionPane.showMessageDialog(null,"Registro eliminado");
               }else{
                   JOptionPane.showMessageDialog(null,"Esta suela se encuentra registrada en un pedido activo");
               }
              }  
            }else{
               JOptionPane.showMessageDialog(null,"No se ha seleccionado ningun registro"); 
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
} 
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
       ReporteProductos p = new ReporteProductos(null,true);
       p.setVisible(true);
       p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       p.setAlwaysOnTop(true); 
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbActualizarActionPerformed
       JtBuscar.setText("");
       CleanTable();
       LoadModelProducto();
    }//GEN-LAST:event_JbActualizarActionPerformed

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtBuscarKeyTyped
    public Image getImage(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbActualizar;
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JPanel JpMenu;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtDatosProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
