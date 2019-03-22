
package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Agente;
import ObjectLayer.Banco;
import ObjectLayer.Ciudad;
import ObjectLayer.Cliente;
import ObjectLayer.Estado;
import ObjectLayer.ObjectClientes;
import ObjectLayer.Pais;
import ObjectLayer.Zona;
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


public class Clientes extends javax.swing.JInternalFrame {

    ObjectClientes obj = new ObjectClientes();
    DefaultTableModel modelCliente = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }
    };
    Connection c = Server.getCobranza();
    public Clientes() {
        initComponents();
        LoadColumns();
        LoadModelCliente();
        JtDatosCliente.getTableHeader().setReorderingAllowed(false);
    }
     public void LoadColumns(){
        modelCliente.addColumn("Código");//0
        modelCliente.addColumn("RAZÓN SOCIAL");//1
        modelCliente.addColumn("RFC");//2
        modelCliente.addColumn("Cod");//3
        modelCliente.addColumn("CP");//4
        modelCliente.addColumn("COLONIA");//5
        modelCliente.addColumn("CALLE");//6
        modelCliente.addColumn("NumeroCalle");//7
        modelCliente.addColumn("CFDI");//8
        modelCliente.addColumn("Email");//9
        modelCliente.addColumn("Observaciones");//10
        modelCliente.addColumn("TELEFONO");//11
        modelCliente.addColumn("TELEFONO2");//12
        modelCliente.addColumn("TELEFONO3");//13
        modelCliente.addColumn("Cuenta");//14
        modelCliente.addColumn("Días Crédito");//15
        modelCliente.addColumn("CONTACTO");//16
        modelCliente.addColumn("Forma Pago");//17
        modelCliente.addColumn("MetodoPago");//18
        modelCliente.addColumn("AGENTE");//19
        modelCliente.addColumn("Cod-Agente");//20
        modelCliente.addColumn("ZONA");//21
        modelCliente.addColumn("Cod-Zona");//22
        modelCliente.addColumn("PAIS");//23
        modelCliente.addColumn("Cod-Pais");//24
        modelCliente.addColumn("ESTADO");//25
        modelCliente.addColumn("Cod-Estado");//26
        modelCliente.addColumn("CIUDAD");//27
        modelCliente.addColumn("Cod-Ciudad");//28
        modelCliente.addColumn("BANCO");//29
        modelCliente.addColumn("Cod-Banco");//30
        
        JtDatosCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(0).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        JtDatosCliente.getColumnModel().getColumn(3).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(3).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(3).setPreferredWidth(0);
               
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
        
        JtDatosCliente.getColumnModel().getColumn(12).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(12).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(12).setPreferredWidth(0);
        
        JtDatosCliente.getColumnModel().getColumn(13).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(13).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(13).setPreferredWidth(0);
        
        JtDatosCliente.getColumnModel().getColumn(16).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(16).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(16).setPreferredWidth(0);
               
        JtDatosCliente.getColumnModel().getColumn(17).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(17).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(17).setPreferredWidth(0);
               
        JtDatosCliente.getColumnModel().getColumn(18).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(18).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(18).setPreferredWidth(0);
               
        JtDatosCliente.getColumnModel().getColumn(20).setMaxWidth(0);
        JtDatosCliente.getColumnModel().getColumn(20).setMinWidth(0);
        JtDatosCliente.getColumnModel().getColumn(20).setPreferredWidth(0);
               
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
    }
     public void LoadModelCliente(){
         ArrayList<Cliente>listaClientes = obj.clientesGetAll();
         modelCliente.setNumRows(listaClientes.size());
         
         for(int i =0; i<listaClientes.size(); i++){
               Cliente cliente = listaClientes.get(i);
               
               modelCliente.setValueAt(cliente.getId_Cliente(), i, 0);
               modelCliente.setValueAt(cliente.getRazonSocial(), i, 1);
               modelCliente.setValueAt(cliente.getRFC(), i, 2);
               modelCliente.setValueAt(cliente.getCodigo(), i, 3);
               modelCliente.setValueAt(cliente.getCP(), i, 4);
               modelCliente.setValueAt(cliente.getColonia(), i, 5);
               modelCliente.setValueAt(cliente.getCalle(), i, 6);
               modelCliente.setValueAt(cliente.getNumeroCalle(), i, 7);
               modelCliente.setValueAt(cliente.getUsoCfdi(), i, 8);
               modelCliente.setValueAt(cliente.getEmail(), i, 9);
               modelCliente.setValueAt(cliente.getObservaciones(), i, 10);
               modelCliente.setValueAt(cliente.getTelefono(), i, 11);
               modelCliente.setValueAt(cliente.getTelefono2(), i, 12);
               modelCliente.setValueAt(cliente.getTelefono3(), i, 13);
               modelCliente.setValueAt(cliente.getCuenta(), i, 14);
               modelCliente.setValueAt(cliente.getDiasCredito(),i,15);
               modelCliente.setValueAt(cliente.getContacto(), i, 16);
               modelCliente.setValueAt(cliente.getFormaPago(), i, 17);
               modelCliente.setValueAt(cliente.getMetodoPago(), i, 18);
               modelCliente.setValueAt(cliente.getAgente(), i, 19);
               modelCliente.setValueAt(cliente.getId_Agente(), i, 20);
               modelCliente.setValueAt(cliente.getZona(), i, 21);
               modelCliente.setValueAt(cliente.getId_Zona(), i, 22);
               modelCliente.setValueAt(cliente.getPais(), i, 23);
               modelCliente.setValueAt(cliente.getId_Pais(), i, 24);
               modelCliente.setValueAt(cliente.getEstado(), i, 25);
               modelCliente.setValueAt(cliente.getId_Estado(), i, 26);
               modelCliente.setValueAt(cliente.getCiudad(), i, 27);
               modelCliente.setValueAt(cliente.getId_Ciudad(), i, 28);
               modelCliente.setValueAt(cliente.getBanco(), i, 29);
               modelCliente.setValueAt(cliente.getId_Banco(), i, 30);
         }
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
        JtDatosCliente = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("CLIENTES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/manager_person_man_people_2841.png"))); // NOI18N

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
                .addGap(33, 33, 33)
                .addComponent(JbActualizar)
                .addGap(31, 31, 31)
                .addComponent(JbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JtDatosCliente.setModel(modelCliente);
        jScrollPane1.setViewportView(JtDatosCliente);

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
        NCliente nuevo = new NCliente(null, true);
        nuevo.setVisible(true);
        nuevo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevo.setAlwaysOnTop(true);
        if(nuevo.getInformacion()!=""){
            CleanTable();
            LoadModelCliente();
        }
    }//GEN-LAST:event_JbNuevoActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void JbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEliminarActionPerformed
        int row = JtDatosCliente.getSelectedRow();
        
        try{
            if(row >=0){
                int opcion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de borrar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(opcion ==JOptionPane.YES_OPTION){
                    if(obj.clienteDelete(Integer.parseInt(JtDatosCliente.getValueAt(row, 0).toString()))){
                         modelCliente.removeRow(row);
                         JOptionPane.showMessageDialog(null,"Registro eliminado");
                    }else{
                         JOptionPane.showMessageDialog(null,"Este cliente tiene pedidos activos en el sistema");
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

    private void JbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEditarActionPerformed
        MCliente editar = new MCliente(null, true);
        int fila = JtDatosCliente.getSelectedRow();

        try{
            if(fila >=0){
                 int opcion = JOptionPane.showConfirmDialog(this,"¿Quires editar este registro?","TOP-SUELAS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                 
                if(opcion ==JOptionPane.YES_OPTION){
                    Agente ag = new Agente();
                    Banco bn = new Banco();
                    Estado ed = new Estado();
                    Ciudad cd = new Ciudad();
                    Pais ps = new Pais();
                    Zona zn = new Zona();
                
                    editar.JtId.setText(JtDatosCliente.getValueAt(fila, 0).toString());
                    editar.JtRs.setText(JtDatosCliente.getValueAt(fila, 1).toString());
                    editar.JtRFC.setText(JtDatosCliente.getValueAt(fila, 2).toString());
                    editar.JtCod.setText(JtDatosCliente.getValueAt(fila, 3).toString());
                    editar.JtCP.setText(JtDatosCliente.getValueAt(fila, 4).toString());
                    editar.JtColonia.setText(JtDatosCliente.getValueAt(fila, 5).toString());
                    editar.JtCalle.setText(JtDatosCliente.getValueAt(fila, 6).toString());
                    editar.JtNum.setText(JtDatosCliente.getValueAt(fila, 7).toString());
                    editar.JtCf.setText(JtDatosCliente.getValueAt(fila, 8).toString());
                    editar.JtEmail.setText(JtDatosCliente.getValueAt(fila, 9).toString());
                    editar.JaObv.setText(JtDatosCliente.getValueAt(fila, 10).toString());
                    editar.JtTel.setText(JtDatosCliente.getValueAt(fila, 11).toString());
                    editar.JtTel2.setText(JtDatosCliente.getValueAt(fila, 12).toString());
                    editar.JtTel3.setText(JtDatosCliente.getValueAt(fila, 13).toString());
                    editar.JtCta.setText(JtDatosCliente.getValueAt(fila, 14).toString());
                    editar.JsCred.setValue(JtDatosCliente.getValueAt(fila, 15));
                    editar.JtContacto.setText(JtDatosCliente.getValueAt(fila, 16).toString());
                    editar.JcFpago.setSelectedItem(JtDatosCliente.getValueAt(fila, 17));
                    editar.JcMpago.setSelectedItem(JtDatosCliente.getValueAt(fila, 18));
                    ag.setDescripcion(JtDatosCliente.getValueAt(fila, 19).toString());
                    ag.setId_Agente((int)JtDatosCliente.getValueAt(fila, 20));
                    editar.JcAgente.getModel().setSelectedItem(ag);
                    zn.setDescripcion(JtDatosCliente.getValueAt(fila, 21).toString());
                    zn.setId_Zona((int)JtDatosCliente.getValueAt(fila, 22));
                    editar.JcZona.getModel().setSelectedItem(zn);
                    ps.setDescripcion(JtDatosCliente.getValueAt(fila, 23).toString());
                    ps.setId_Pais((int)JtDatosCliente.getValueAt(fila, 24));
                    editar.JcPais.getModel().setSelectedItem(ps);
                    ed.setDescripcion(JtDatosCliente.getValueAt(fila, 25).toString());
                    ed.setId_Estado((int)JtDatosCliente.getValueAt(fila, 26));
                    editar.JcEstado.getModel().setSelectedItem(ed);
                    cd.setDescripcion(JtDatosCliente.getValueAt(fila, 27).toString());
                    cd.setId_Ciudad((int)JtDatosCliente.getValueAt(fila, 28));
                    editar.JcCiudad.getModel().setSelectedItem(cd);
                    bn.setDescripcion(JtDatosCliente.getValueAt(fila, 29).toString());
                    bn.setId_Banco((int)JtDatosCliente.getValueAt(fila, 30));
                    editar.JcBanco.getModel().setSelectedItem(bn);
                    editar.setVisible(true);
                    editar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    editar.setAlwaysOnTop(true);
                if(editar.getInformacion()!=""){
                    CleanTable();
                    LoadModelCliente();
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
         ArrayList<Cliente>listaClientes = obj.clienteSearch(JtBuscar.getText());
         listaClientes.size();
         modelCliente.setNumRows(listaClientes.size());
         
         for(int i =0; i<listaClientes.size(); i++){
            Cliente cliente = listaClientes.get(i);
             
            modelCliente.setValueAt(cliente.getId_Cliente(), i, 0);
            modelCliente.setValueAt(cliente.getRazonSocial(), i, 1);
            modelCliente.setValueAt(cliente.getRFC(), i, 2);
            modelCliente.setValueAt(cliente.getCodigo(), i, 3);
            modelCliente.setValueAt(cliente.getCP(), i, 4);
            modelCliente.setValueAt(cliente.getColonia(), i, 5);
            modelCliente.setValueAt(cliente.getCalle(), i, 6);
            modelCliente.setValueAt(cliente.getNumeroCalle(), i, 7);
            modelCliente.setValueAt(cliente.getUsoCfdi(), i, 8);
            modelCliente.setValueAt(cliente.getEmail(), i, 9);
            modelCliente.setValueAt(cliente.getObservaciones(), i, 10);
            modelCliente.setValueAt(cliente.getTelefono(), i, 11);
            modelCliente.setValueAt(cliente.getTelefono2(), i, 12);
            modelCliente.setValueAt(cliente.getTelefono3(), i, 13);
            modelCliente.setValueAt(cliente.getCuenta(), i, 14);
            modelCliente.setValueAt(cliente.getDiasCredito(),i,15);
            modelCliente.setValueAt(cliente.getContacto(), i, 16);
            modelCliente.setValueAt(cliente.getFormaPago(), i, 17);
            modelCliente.setValueAt(cliente.getMetodoPago(), i, 18);
            modelCliente.setValueAt(cliente.getAgente(), i, 19);
            modelCliente.setValueAt(cliente.getId_Agente(), i, 20);
            modelCliente.setValueAt(cliente.getZona(), i, 21);
            modelCliente.setValueAt(cliente.getId_Zona(), i, 22);
            modelCliente.setValueAt(cliente.getPais(), i, 23);
            modelCliente.setValueAt(cliente.getId_Pais(), i, 24);
            modelCliente.setValueAt(cliente.getEstado(), i, 25);
            modelCliente.setValueAt(cliente.getId_Estado(), i, 26);
            modelCliente.setValueAt(cliente.getCiudad(), i, 27);
            modelCliente.setValueAt(cliente.getId_Ciudad(), i, 28);
            modelCliente.setValueAt(cliente.getBanco(), i, 29);
            modelCliente.setValueAt(cliente.getId_Banco(), i, 30); 
         }
    }//GEN-LAST:event_JtBuscarKeyReleased

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
       try {                                          
            JasperReport reporte = null;
            reporte = (JasperReport)JRLoader.loadObject(getClass().getResource("/Reports/CatalogoClientes.jasper"));
            try {
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null,c);
                JasperViewer view = new  JasperViewer(jprint,false);
                
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
                view.setIconImage(getImage());
                 view.setTitle("TOP-SUELAS");
            } catch (JRException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JbReporteActionPerformed

    private void JbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbActualizarActionPerformed
        JtBuscar.setText("");
        CleanTable();
        LoadModelCliente();
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
    private void CleanTable(){
        int numFilas = modelCliente.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >=0; i--){
                modelCliente.removeRow(i);            }
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
    private javax.swing.JTable JtDatosCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
