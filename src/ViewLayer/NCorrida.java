
package ViewLayer;

import ObjectLayer.Corrida;
import ObjectLayer.ObjectCorridas;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

 
public class NCorrida extends javax.swing.JDialog {

   ObjectCorridas obj = new ObjectCorridas();
   String informacion = "";
    public NCorrida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));;
        setIconImage(icon);
        setLocationRelativeTo(null);
        Jtid.setVisible(false);
    }
    public String getInformacion(){
        return this.informacion;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbDes = new javax.swing.JLabel();
        JtDescripcion = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JbPi = new javax.swing.JLabel();
        JbPt = new javax.swing.JLabel();
        JtPi = new javax.swing.JTextField();
        JtPf = new javax.swing.JTextField();
        JbOb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JaObservacion = new javax.swing.JTextArea();
        Jtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CORRIDA");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDes.setText("Descripción:");

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saveas_1173.png"))); // NOI18N
        JbGuardar.setText("REGISTRAR");
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        JbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JbCancelar.setText("CANCELAR");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        JbPi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPi.setText("Punto Inicial:");

        JbPt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPt.setText("Punto Final:");

        JbOb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbOb.setText("Observaciones:");

        JaObservacion.setColumns(20);
        JaObservacion.setRows(5);
        JaObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JaObservacionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(JaObservacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbDes)
                            .addComponent(JbPi)
                            .addComponent(JbPt))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JtPf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(JtPi, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(JbOb)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JbGuardar)
                            .addGap(23, 23, 23)
                            .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbDes)
                    .addComponent(JtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPi)
                    .addComponent(JtPi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbPt)
                    .addComponent(JtPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(JbOb)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbGuardar)
                    .addComponent(JbCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void Cerrar(){
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this,"¿Deseas cerrar esta ventana?", "TOP-SUELAS", 
                0, 0, null, botones, this);
        if(eleccion == JOptionPane.YES_OPTION){
            dispose();
        }else if(eleccion == JOptionPane.NO_OPTION){
        }
    }
    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
       Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
      if(JtDescripcion.getText().equals("") || JtPf.getText().equals("") || JtPi.getText().equals("")){
        JOptionPane.showMessageDialog(this, "Faltan datos de ingresar","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
      }else if(Jtid.getText().isEmpty()){
          if(obj.validarCorrida(JtDescripcion.getText())==0){
              Guardar();
          }else{
        JOptionPane.showMessageDialog(null,"Este registro ya existe","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        }   
      }else{
          if(obj.validarCorrida(JtDescripcion.getText())==0){
              Editar();
          }else{
        JOptionPane.showMessageDialog(null,"Este registro ya existe","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        }    
      }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void Guardar(){
        float Pi = Float.parseFloat(JtPi.getText());
        float Pt = Float.parseFloat(JtPf.getText());
        Corrida corrida = new Corrida();
        corrida.setDescripcion(JtDescripcion.getText());
        corrida.setPunto_Inicial(Pi);
        corrida.setPunto_Final(Pt);
        corrida.setObservaciones(JaObservacion.getText());
        corrida.setActivo(true);
        if(obj.corridaAdd(corrida)){
        JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!","TOP-SUELAS" ,JOptionPane.INFORMATION_MESSAGE);
        informacion = "1";
        Limpiar();
        }else{
        JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        Limpiar();
         }
    }
    
    private void Editar(){
        float Pi = Float.parseFloat(JtPi.getText());
        float Pt = Float.parseFloat(JtPf.getText());
        Corrida corrida = new Corrida();
        corrida.setDescripcion(JtDescripcion.getText());
        corrida.setPunto_Inicial(Pi);
        corrida.setPunto_Final(Pt);
        corrida.setObservaciones(JaObservacion.getText());
        corrida.setId_Corrida(Integer.parseInt(Jtid.getText()));
      
        if(obj.corridaUpdate(corrida)){
        JOptionPane.showMessageDialog(this, "Corrida Editada Correctamente!!!","TOP-SUELAS" ,JOptionPane.INFORMATION_MESSAGE);
        informacion = "1";
        this.dispose();
        }else{
        JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas","TOP-SUELAS" ,JOptionPane.WARNING_MESSAGE);
        this.dispose();
         }
    }
    
    private void JaObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JaObservacionKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JaObservacionKeyTyped
    private void Limpiar(){
        JtDescripcion.setText("");
        JtPi.setText("");
        JtPf.setText("");
        JaObservacion.setText("");
        JtDescripcion.requestFocus();
        JbDes.setForeground(Color.BLACK);
        JbPi.setForeground(Color.BLACK);
        JbPt.setForeground(Color.BLACK);
        JbOb.setForeground(Color.BLACK);
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
            java.util.logging.Logger.getLogger(NCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NCorrida dialog = new NCorrida(new javax.swing.JFrame(), true);
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
    public javax.swing.JTextArea JaObservacion;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbDes;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbOb;
    private javax.swing.JLabel JbPi;
    private javax.swing.JLabel JbPt;
    public javax.swing.JTextField JtDescripcion;
    public javax.swing.JTextField JtPf;
    public javax.swing.JTextField JtPi;
    public javax.swing.JTextField Jtid;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
