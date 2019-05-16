package ViewLayer;

import ObjectLayer.Encrypt;
import ObjectLayer.ObjectUsuarios;
import ObjectLayer.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NUsuario extends javax.swing.JDialog {

    ObjectUsuarios obj = new ObjectUsuarios();
    String informacion = "";

    public NUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/pluscircleregular_106319.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        JtId.setVisible(false);
    }

    public String getInformacion() {
        return this.informacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbTipo = new javax.swing.JLabel();
        JbPass = new javax.swing.JLabel();
        JbCpass = new javax.swing.JLabel();
        JbDes = new javax.swing.JLabel();
        JbGuardar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JtPassword = new javax.swing.JPasswordField();
        JtConfirmar = new javax.swing.JPasswordField();
        JtUsuario = new javax.swing.JTextField();
        JcDep = new javax.swing.JComboBox<>();
        JbNombre = new javax.swing.JLabel();
        JtNombre = new javax.swing.JTextField();
        JtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR USUARIO");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbTipo.setText("Departamento:");

        JbPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbPass.setText("Password:");

        JbCpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbCpass.setText("<html>Confirmar Password:</html>");

        JbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbDes.setText("Usuario:");

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

        JcDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "COBRANZA", "PRODUCCION", "SUELAS" }));

        JbNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbNombre.setText("Nombre:");

        JtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtNombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(JbGuardar)
                        .addGap(50, 50, 50)
                        .addComponent(JbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbNombre)
                                    .addComponent(JbDes))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(JbTipo)
                                    .addGap(277, 277, 277))
                                .addComponent(JcDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JbCpass, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JbPass)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(53, 53, 53)
                        .addComponent(JtId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbNombre)
                    .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbDes)
                    .addComponent(JtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbTipo)
                    .addComponent(JcDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbPass)
                    .addComponent(JtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JbCpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        if (JtUsuario.getText().isEmpty() || JtNombre.getText().isEmpty() || JtPassword.getPassword().length == 0 || JtConfirmar.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos de ingresar", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (JtId.getText().isEmpty()) {
            if (obj.validarUsuario(JtUsuario.getText()) == 0) {
                Guardar();
            } else {
                JOptionPane.showMessageDialog(this, "El usuario ya existe", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            Editar();
        }
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void Guardar() {
        String pass = new String(JtPassword.getPassword());
        String passcon = new String(JtConfirmar.getPassword());
        String nombre = JtNombre.getText();
        String Dep = JcDep.getSelectedItem().toString();
        String Us = JtUsuario.getText();

        if (pass.equals(passcon)) {

            if (obj.validarUsuario(JtUsuario.getText()) == 0) {
                String nuevoPass = Encrypt.sha1(pass);
                Usuario us = new Usuario();
                us.setUsuario(Us);
                us.setNombre(nombre);
                us.setPassword(nuevoPass);
                us.setDepartamento(Dep);
                us.setActivo(true);

                if (obj.registrarUsuario(us)) {
                    JOptionPane.showMessageDialog(this, "Usuario registrado", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                    Limpiar();
                    informacion = "1";
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error contacta con sistemas", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    Limpiar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coiciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            JbPass.requestFocus();
            JtPassword.setText("");
            JtConfirmar.setText("");
            JbPass.setForeground(Color.red);
            JbCpass.setForeground(Color.red);
        }
    }

    private void Editar() {
        String pass = new String(JtPassword.getPassword());
        String passcon = new String(JtConfirmar.getPassword());
        String nombre = JtNombre.getText();
        String Usuario = JtUsuario.getText();
        String Dep = JcDep.getSelectedItem().toString();
        int Id = Integer.parseInt(JtId.getText());

        if (pass.equals(passcon)) {
            String nuevoPass = Encrypt.sha1(pass);
            Usuario us = new Usuario();
            us.setId_Usuario(Id);
            us.setUsuario(Usuario);
            us.setNombre(nombre);
            us.setPassword(nuevoPass);
            us.setDepartamento(Dep);

            if (obj.usuarioUpdate(us)) {
                JOptionPane.showMessageDialog(this, "Usuario Modificado", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                informacion = "1";
            } else {
                JOptionPane.showMessageDialog(this, "Error al Actualizar", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coiciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNombreKeyReleased
        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_ENTER)
                && !(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Escribe solo letras");
            JtNombre.setText("");
        }
    }//GEN-LAST:event_JtNombreKeyReleased

    private void JtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_JtNombreKeyTyped
    private void Limpiar() {
        JtNombre.requestFocus();
        this.JtNombre.setText("");
        this.JtUsuario.setText("");
        this.JtConfirmar.setText("");
        this.JtPassword.setText("");
        this.JcDep.setSelectedIndex(0);
    }

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
            java.util.logging.Logger.getLogger(NUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NUsuario dialog = new NUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbCancelar;
    private javax.swing.JLabel JbCpass;
    private javax.swing.JLabel JbDes;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JLabel JbNombre;
    private javax.swing.JLabel JbPass;
    private javax.swing.JLabel JbTipo;
    public javax.swing.JComboBox<String> JcDep;
    public javax.swing.JPasswordField JtConfirmar;
    public javax.swing.JTextField JtId;
    public javax.swing.JTextField JtNombre;
    public javax.swing.JPasswordField JtPassword;
    public javax.swing.JTextField JtUsuario;
    // End of variables declaration//GEN-END:variables
}
