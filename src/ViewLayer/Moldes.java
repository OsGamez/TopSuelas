
package ViewLayer;

import DataAccesLayer.Server;
import ObjectLayer.Molde;
import ObjectLayer.ObjectMoldes;
import ObjectLayer.ObjectPrecios;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class Moldes extends javax.swing.JInternalFrame {
    ArrayList<Molde>listaMolde;
    
    DefaultTableModel modelMolde = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }  
    };
    ObjectMoldes obm = new ObjectMoldes();
    public Moldes() {
        initComponents();
        LoadColumns();
        LoadModelMolde();
        JtDatosMolde.getTableHeader().setReorderingAllowed(false);
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
        JtDatosMolde = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("MOLDES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/suela.png"))); // NOI18N

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(JbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGap(33, 33, 33)
                .addComponent(JbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR:");

        JtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtBuscarActionPerformed(evt);
            }
        });
        JtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtBuscarKeyTyped(evt);
            }
        });

        JtDatosMolde.setModel(modelMolde);
        jScrollPane1.setViewportView(JtDatosMolde);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNuevoActionPerformed
        NMolde nuevo = new NMolde(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if(nuevo.getInformacion()!=""){
            CleanTable();
            LoadModelMolde();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed
    private void LoadColumns(){
        modelMolde.addColumn("Molde");
        modelMolde.addColumn("Punto");
        modelMolde.addColumn("Cantidad");
        modelMolde.addColumn("Status");
        modelMolde.addColumn("Suela");
    }
    
    private void LoadModelMolde(){
           listaMolde=obm.MoldeGetAll();
          modelMolde.setNumRows(listaMolde.size());
          for(int i =0; i <listaMolde.size(); i++){
            Molde m = new Molde();
            modelMolde.setValueAt(listaMolde.get(i).getMolde(), i, 0);
            modelMolde.setValueAt(listaMolde.get(i).getPunto(), i, 1);
            modelMolde.setValueAt(listaMolde.get(i).getCantidad(), i, 2);
            modelMolde.setValueAt(listaMolde.get(i).getStatus(), i, 3);
            modelMolde.setValueAt(listaMolde.get(i).getCharlinea(), i, 4);      
          }
    }
    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtDatosMolde.getSelectedRow();
        int column = JtDatosMolde.getColumnCount();
         try{
            if(row >=0){
              int opcion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de borrar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
              if(opcion ==JOptionPane.YES_OPTION){
                  obm.MoldeDelete((int)JtDatosMolde.getValueAt(row,0));
                  modelMolde.removeRow(row); 
                       JOptionPane.showMessageDialog(null,"Registro eliminado");
                }
        }else{
             JOptionPane.showMessageDialog(null,"No se ha selecionado ningun registro");   
            } 
    }
        catch(Exception ex){
            
            ex.printStackTrace();
}
    }//GEN-LAST:event_JbEliminarActionPerformed

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
            MMolde editar = new MMolde(null, true);
            int fila = JtDatosMolde.getSelectedRow();
          
            try{
                if(fila>=0){
                    int opcion = JOptionPane.showConfirmDialog(this,"¿Quieres editar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(opcion ==JOptionPane.YES_OPTION){
                        Molde m = new Molde();
                        m.setMolde((int)JtDatosMolde.getValueAt(fila, 0));
                        m.setPunto((int)JtDatosMolde.getValueAt(fila, 1));
                        m.setCantidad((int)JtDatosMolde.getValueAt(fila, 2));
                        m.setStatus(JtDatosMolde.getValueAt(fila, 3).toString());
                        m.setCharlinea(JtDatosMolde.getValueAt(fila, 4).toString());
                        
                    editar.Jtp.setText(String.valueOf(m.getPunto()));
                    editar.Jtc.setText(String.valueOf(m.getCantidad()));
                    editar.Jts.setText(m.getStatus());
                    editar.Jtlc.setText(m.getCharlinea());
                    editar.m=m;
                    //editar.Jtl.getModel().setSelectedItem(m.getCharlinea());
                    //editar.JtId.setText(JtDatosMolde.getValueAt(fila, 0).toString());
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                 if(editar.getInformacion()!=""){ 
                    CleanTable();
                    LoadModelMolde();
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
        listaMolde = obm.BuscaMolde(JtBuscar.getText());
        modelMolde.setNumRows(listaMolde.size());
        
        for(int i =0; i <listaMolde.size(); i++){
            modelMolde.setValueAt(listaMolde.get(i).getMolde(), i, 0);
            modelMolde.setValueAt(listaMolde.get(i).getPunto(), i, 1);
            modelMolde.setValueAt(listaMolde.get(i).getCantidad(), i, 2);
            modelMolde.setValueAt(listaMolde.get(i).getStatus(), i, 3);
            modelMolde.setValueAt(listaMolde.get(i).getLinea(), i, 4);
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        ReporteMoldes p = new ReporteMoldes(null,true);
        p.setVisible(true);
        p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        p.setAlwaysOnTop(true); 
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtBuscarKeyTyped
      char c = evt.getKeyChar();
      if(Character.isLowerCase(c)){
        String cad = (""+c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
      }
    }//GEN-LAST:event_JtBuscarKeyTyped

    private void JtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtBuscarActionPerformed
     public Image getImage(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    } 
    private void CleanTable(){
        int numFilas = modelMolde.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >=0; i--){
                modelMolde.removeRow(i);            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtDatosMolde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
