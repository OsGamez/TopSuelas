
package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.ObjectUsuarios;
import ObjectLayer.Usuario;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Usuarios extends javax.swing.JInternalFrame {
     ObjectUsuarios obj = new ObjectUsuarios();
     Connection c = Server.getUsuario();
     public int IdUs;
     DefaultTableModel modelUsuario = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }  
    };
   
    public Usuarios() {
        initComponents();
        LoadColumnas();
        LoadModelUsuario();
        JtDatosUsuario.getTableHeader().setReorderingAllowed(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatosUsuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setTitle("USUARIOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/safety_reader_card_10784.png"))); // NOI18N

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
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(31, 31, 31)
                .addComponent(JbReporte)
                .addGap(31, 31, 31)
                .addComponent(JbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JtDatosUsuario.setModel(modelUsuario);
        jScrollPane1.setViewportView(JtDatosUsuario);

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
        NUsuario nuevo = new NUsuario(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if(nuevo.getInformacion()!=""){
            CleanTable();
            LoadModelUsuario();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed
    private void LoadModelUsuario(){
         ArrayList<Usuario>listaUsuarios = obj.usuariosGetAll();
         
          modelUsuario.setNumRows(listaUsuarios.size());
          for(int i =0; i <listaUsuarios.size(); i++){
            Usuario us = listaUsuarios.get(i);
            
            modelUsuario.setValueAt(us.getId_Usuario(), i, 0);
            modelUsuario.setValueAt(us.getNombre(), i, 1);
            modelUsuario.setValueAt(us.getUsuario(), i, 2);
            modelUsuario.setValueAt(us.getDepartamento(), i, 3);
            modelUsuario.setValueAt(us.getPassword(), i, 4);
            
          }
    }
    private void LoadColumnas(){
        modelUsuario.addColumn("Código");
        modelUsuario.addColumn("NOMBRE");
        modelUsuario.addColumn("USUARIO");
        modelUsuario.addColumn("DEPARTAMENTO");
        modelUsuario.addColumn("PASSWORD");
        
        JtDatosUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
        JtDatosUsuario.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatosUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtDatosUsuario.getSelectedRow();
        try{
            if(row >=0){
              int opcion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de borrar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
              if(opcion ==JOptionPane.YES_OPTION){
              String Id =  JtDatosUsuario.getValueAt(row, 0).toString();
              if(IdUs == Integer.parseInt(Id)){
              JOptionPane.showMessageDialog(null,"No puedes elimar tu usuario","TOP-SUELAS" ,JOptionPane.INFORMATION_MESSAGE); 
              }else{
              obj.usuarioDelete(Integer.parseInt(JtDatosUsuario.getValueAt(row, 0).toString()));
              modelUsuario.removeRow(row);
              JOptionPane.showMessageDialog(null,"Registro eliminado","TOP-SUELAS" ,JOptionPane.INFORMATION_MESSAGE);  
              }
            }
        }else{
             JOptionPane.showMessageDialog(null,"No se ha selecionado ningun registro","TOP-SUELAS" ,JOptionPane.INFORMATION_MESSAGE);   
            } 
    }
        catch(Exception ex){
            
            ex.printStackTrace();
}
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
        MUsuario editar = new MUsuario(null, true);
        int fila = JtDatosUsuario.getSelectedRow();
        
          try{
              if(fila >=0){
                Usuario us = new Usuario();
                int opcion = JOptionPane.showConfirmDialog(this,"¿Quieres editar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);   
                if(opcion ==JOptionPane.YES_OPTION){
                
                editar.JtId.setText(JtDatosUsuario.getValueAt(fila, 0).toString());
                editar.JtNombre.setText(JtDatosUsuario.getValueAt(fila, 1).toString());
                editar.JtUsuario.setText(JtDatosUsuario.getValueAt(fila, 2).toString());
                us.setDepartamento(JtDatosUsuario.getValueAt(fila, 3).toString());
                editar.JcDep.setSelectedItem(JtDatosUsuario.getValueAt(fila, 3).toString());
                //editar.JtConfirmar.setText(JtDatosUsuario.getValueAt(fila, 4).toString());
                //editar.JtPassword.setText(JtDatosUsuario.getValueAt(fila, 4).toString());
                editar.setVisible(true);
                editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                editar.setAlwaysOnTop(true);
                  if(editar.getInformacion()!=""){ 
                    CleanTable();
                    LoadModelUsuario();
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

    private void JtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyReleased
       CleanTable();
       JtBuscar.getText();
       
        ArrayList<Usuario>listaUsuarios = obj.usuarioSearch(JtBuscar.getText());
        listaUsuarios.size();
        modelUsuario.setNumRows(listaUsuarios.size());
        
        for(int i=0; i<listaUsuarios.size(); i++){
            Usuario us = listaUsuarios.get(i);
            
            modelUsuario.setValueAt(us.getId_Usuario(), i, 0);
            modelUsuario.setValueAt(us.getNombre(), i, 1);
            modelUsuario.setValueAt(us.getUsuario(), i, 2);
            modelUsuario.setValueAt(us.getDepartamento(), i, 3);
            modelUsuario.setValueAt(us.getPassword(), i, 4);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
       try {                                                     
        JasperReport reporte = (JasperReport)JRLoader.loadObject(getClass().getResource("/Reports/CatalogoUsuarios.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null,c);
                JasperViewer view = new  JasperViewer(jprint,false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JbReporteActionPerformed

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
    private void CleanTable(){
        int numFilas = modelUsuario.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >=0; i--){
                modelUsuario.removeRow(i);            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtDatosUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
