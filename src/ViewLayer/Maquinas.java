
package ViewLayer;

import ObjectLayer.Maquina;
import ObjectLayer.ObjectMaquinas;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class Maquinas extends javax.swing.JInternalFrame {
    ArrayList<Maquina>listaMaquina;
    
    DefaultTableModel modelMaquina = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }  
    };
    ObjectMaquinas obmaq = new ObjectMaquinas();
    public Maquinas() {
        initComponents();
        LoadColumns();
        LoadModelMaquina();
        JtDatosMaquina.getTableHeader().setReorderingAllowed(false);
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
        JbActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDatosMaquina = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("MAQUINAS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/machine.png"))); // NOI18N

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

        JbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N
        JbActualizar.setText("REFRESCAR");
        JbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbActualizarActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JbActualizar))
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(29, 29, 29)
                .addComponent(JbActualizar)
                .addGap(27, 27, 27)
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

        JtDatosMaquina.setModel(modelMaquina);
        jScrollPane1.setViewportView(JtDatosMaquina);

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
        NMaquina nuevo = new NMaquina(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if(nuevo.getInformacion()!=""){
            CleanTable();
            LoadModelMaquina();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed
    private void LoadColumns(){
        modelMaquina.addColumn("Maquina");
        modelMaquina.addColumn("Status");
        modelMaquina.addColumn("Cantidad de Estaciones");
    }
    
    private void LoadModelMaquina(){
           listaMaquina=obmaq.MaquinaGetAll();
          modelMaquina.setNumRows(listaMaquina.size());
          for(int i =0; i <listaMaquina.size(); i++){
            modelMaquina.setValueAt(listaMaquina.get(i).getMaquina(), i, 0);
            modelMaquina.setValueAt(listaMaquina.get(i).getStatus(), i, 1);
            modelMaquina.setValueAt(listaMaquina.get(i).getEstaciones(), i, 2);     
          }
    }
    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtDatosMaquina.getSelectedRow();
         try{
            if(row >=0){
              int opcion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de borrar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
              if(opcion ==JOptionPane.YES_OPTION){
                  obmaq.MaquinaDelete((int)JtDatosMaquina.getValueAt(row,0));
                  modelMaquina.removeRow(row); 
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
            MMaquinaEstacion editarmaq= new MMaquinaEstacion(null,true);
            int fila = JtDatosMaquina.getSelectedRow();
          
            try{
                if(fila>=0){
                    int opcion = JOptionPane.showConfirmDialog(this,"¿Quieres editar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(opcion ==JOptionPane.YES_OPTION){
                        Maquina maq = new Maquina();
                        maq.setMaquina((int)JtDatosMaquina.getValueAt(fila, 0));
                        maq.setEstaciones((int)JtDatosMaquina.getValueAt(fila, 2));
                    editarmaq.Jtm.setText("Maquina # ".concat(String.valueOf(maq.getMaquina())));
                    editarmaq.maq=maq;
                    editarmaq.setVisible(true);
                    editarmaq.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editarmaq.setAlwaysOnTop(true);
                 if(editarmaq.getInformacion()!=""){ 
                    CleanTable();
                    LoadModelMaquina();
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
        listaMaquina = obmaq.BuscaMaquina(JtBuscar.getText());
        modelMaquina.setNumRows(listaMaquina.size());
        
        for(int i =0; i <listaMaquina.size(); i++){
           modelMaquina.setValueAt(listaMaquina.get(i).getMaquina(), i, 0);
            modelMaquina.setValueAt(listaMaquina.get(i).getStatus(), i, 1);
            modelMaquina.setValueAt(listaMaquina.get(i).getEstaciones(), i, 2); 
        }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        ReporteMoldes p = new ReporteMoldes(null,true);
        p.setVisible(true);
        p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        p.setAlwaysOnTop(true); 
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbActualizarActionPerformed
        CleanTable();
        LoadModelMaquina();
    }//GEN-LAST:event_JbActualizarActionPerformed

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
        int numFilas = modelMaquina.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >=0; i--){
                modelMaquina.removeRow(i);            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbActualizar;
    private javax.swing.JButton JbEditar;
    private javax.swing.JButton JbEliminar;
    private javax.swing.JButton JbNuevo;
    private javax.swing.JButton JbReporte;
    private javax.swing.JButton JbSalir;
    private javax.swing.JTextField JtBuscar;
    private javax.swing.JTable JtDatosMaquina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
