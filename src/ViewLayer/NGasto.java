package ViewLayer;

import ObjectLayer.Gasto;
import ObjectLayer.ObjectGastos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class NGasto extends javax.swing.JDialog {

    String informacion = "";
    ObjectGastos obj = new ObjectGastos();

    public NGasto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        Jtid.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbAño = new javax.swing.JLabel();
        JbMes = new javax.swing.JLabel();
        JbMo = new javax.swing.JLabel();
        JbGf = new javax.swing.JLabel();
        JbGa = new javax.swing.JLabel();
        JtMo = new javax.swing.JTextField();
        JtGf = new javax.swing.JTextField();
        JtGa = new javax.swing.JTextField();
        JbMi = new javax.swing.JLabel();
        JtMi = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JyAño = new com.toedter.calendar.JYearChooser();
        JmMes = new com.toedter.calendar.JMonthChooser();
        Jtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GASTO");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbAño.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbAño.setText("Año:");

        JbMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMes.setText("Mes:");

        JbMo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMo.setText("Mano Obra:");

        JbGf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbGf.setText("Gastos Fac:");

        JbGa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbGa.setText("Gastos Adm:");

        JbMi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbMi.setText("Mat. Ind:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbAño)
                            .addComponent(JbMes))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JyAño, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JmMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbGa)
                            .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbGuardar)
                            .addComponent(JtGa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbMo)
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbCancelar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbGf)
                                    .addComponent(JbMi))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JtGf)
                                        .addComponent(JtMi))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JtMo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JbAño)
                                .addComponent(JbMo))
                            .addComponent(JyAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JbGf)
                                .addComponent(JbMes))
                            .addComponent(JmMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbGa)
                            .addComponent(JtGa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbMi)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JtGf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(JtMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        int Mes = JmMes.getMonth();
        String m = String.valueOf(Mes+1);
        
        if (JtMo.getText().equals("") || JtGf.getText().equals("") || JtGa.getText().equals("") || JtMi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Falta datos de ingresar verifica", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }else if(Jtid.getText().isEmpty()){
            if (obj.validarGasto(JyAño.getYear(), m) == 0) {
                Guardar();
        } else {
            JOptionPane.showMessageDialog(this, "Este Gasto ya esta registrado", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
        }else{
            Editar();
        } 
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void Guardar() {
        int Año = JyAño.getYear();
        int Mes = JmMes.getMonth();
        double Mo = Double.parseDouble(JtMo.getText());
        double Gf = Double.parseDouble(JtGf.getText());
        double Ga = Double.parseDouble(JtGa.getText());
        double Mi = Double.parseDouble(JtMi.getText());
        Gasto g = new Gasto();
        g.setMes(String.valueOf(Mes + 1));
        g.setAño(Año);
        g.setMo(Mo);
        g.setGf(Gf);
        g.setGa(Ga);
        g.setMi(Mi);
        if (obj.gastoAdd(g)) {
            JOptionPane.showMessageDialog(this, "Registro Guardado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void Editar() {
        int Año = JyAño.getYear();
        int Mes = JmMes.getMonth();
        double Mo = Double.parseDouble(JtMo.getText());
        double Gf = Double.parseDouble(JtGf.getText());
        double Ga = Double.parseDouble(JtGa.getText());
        double Mi = Double.parseDouble(JtMi.getText());
        Gasto g = new Gasto();
        g.setMes(String.valueOf(Mes + 1));
        g.setAño(Año);
        g.setMo(Mo);
        g.setGf(Gf);
        g.setGa(Ga);
        g.setMi(Mi);
        if (obj.gastoUpdate(g)) {
            JOptionPane.showMessageDialog(this, "Registro Editado Correctamente!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            informacion = "1";
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }
    }

    public void Limpiar() {
        JtGa.requestFocus();
        JtMo.setText("");
        JtGf.setText("");
        JtGa.setText("");
        JtMi.setText("");
    }
    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing
    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas cerrar esta ventana?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {

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
            java.util.logging.Logger.getLogger(NGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NGasto dialog = new NGasto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JbAño;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbGa;
    private javax.swing.JLabel JbGf;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbMes;
    private javax.swing.JLabel JbMi;
    private javax.swing.JLabel JbMo;
    public com.toedter.calendar.JMonthChooser JmMes;
    public javax.swing.JTextField JtGa;
    public javax.swing.JTextField JtGf;
    public javax.swing.JTextField JtMi;
    public javax.swing.JTextField JtMo;
    public javax.swing.JTextField Jtid;
    public com.toedter.calendar.JYearChooser JyAño;
    // End of variables declaration//GEN-END:variables
}
