package ViewLayer;

import ObjectLayer.Encrypt;
import ObjectLayer.ObjectUsuarios;
import ObjectLayer.Sesioninfo;
import ObjectLayer.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Usuario us = new Usuario();
    
    boolean a = true;
    public String ip, password;
    ImageIcon mostrar = new ImageIcon("C:\\tsmanager\\imagenes\\ojo2.png");
    ImageIcon ocultar = new ImageIcon("C:\\tsmanager\\imagenes\\ojo.png");
    
    public Login() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/programa.png"));
        setIconImage(icon);
        btnMostrar.setIcon(mostrar);
        JcDB.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JbEntrar = new javax.swing.JButton();
        JbSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Jpassword = new javax.swing.JPasswordField();
        JtUsuario = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        JcDB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 120));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user_icon-icons.com_57997.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/key_keys_10804.png"))); // NOI18N

        JbEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tickflat_105962.png"))); // NOI18N
        JbEntrar.setText("ENTRAR");
        JbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEntrarActionPerformed(evt);
            }
        });

        JbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Login_37128.png"))); // NOI18N
        JbSalir.setText("SALIR");
        JbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbSalirActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        Jpassword.setBackground(new java.awt.Color(214, 217, 223));
        Jpassword.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Jpassword.setForeground(new java.awt.Color(255, 102, 51));
        Jpassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        Jpassword.setCaretColor(java.awt.Color.orange);
        Jpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JpasswordKeyPressed(evt);
            }
        });

        JtUsuario.setBackground(new java.awt.Color(214, 217, 223));
        JtUsuario.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        JtUsuario.setForeground(new java.awt.Color(255, 102, 51));
        JtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        JtUsuario.setCaretColor(new java.awt.Color(255, 204, 51));
        JtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtUsuarioKeyPressed(evt);
            }
        });

        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        JcDB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "192.168.90.1", "192.168.6.93" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JtUsuario)
                    .addComponent(Jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcDB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JcDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void userData(){
//        ip = JcDB.getSelectedItem().toString();
//        
//        if(ip.equals("192.168.90.1")){
//            password = "Admin1305";
//        }else if(ip.equals("192.168.6.93")){
//            password = "123";
//        }
//        sesion.setIp(ip);
//        sesion.setContraseña(password);
    }
    
    private void JbEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEntrarActionPerformed
        //userData();
        ObjectUsuarios obj = new ObjectUsuarios();
        String pass = new String(Jpassword.getPassword());
        String nuevoPass = Encrypt.sha1(pass);
        String usuario = JtUsuario.getText();

        us.setUsuario(usuario);
        us.setPassword(nuevoPass);
        try {
            if (JtUsuario.getText().isEmpty() || Jpassword.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Debe de ingresar sus datos", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                Jpassword.requestFocus();
            } else if (obj.Login(us)) {
                Principal inicio = new Principal(us);
                inicio.id_usuario = String.valueOf(us.getId_Usuario());
                inicio.User = us.getNombre();
                inicio.UsuarioChat = usuario;
                
                inicio.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                JtUsuario.setText("");
                Jpassword.setText("");
                JtUsuario.requestFocus();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JbEntrarActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
        Cerrar();
    }//GEN-LAST:event_JbSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void JpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JpasswordKeyPressed
        int codigo = evt.getKeyCode();
        if (codigo == KeyEvent.VK_ENTER) {
            userData();
            ObjectUsuarios obj = new ObjectUsuarios();
            String pass = new String(Jpassword.getPassword());
            String nuevoPass = Encrypt.sha1(pass);
            String usuario = JtUsuario.getText();

            us.setUsuario(usuario);
            us.setPassword(nuevoPass);
            try {
                if (JtUsuario.getText().isEmpty() || Jpassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "Debe de ingresar sus datos", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    Jpassword.requestFocus();

                } else if (obj.Login(us)) {
                    Principal inicio = new Principal(us);
                    inicio.id_usuario = String.valueOf(us.getId_Usuario());
                    inicio.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Datos incorrectos", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    JtUsuario.setText("");
                    Jpassword.setText("");
                    JtUsuario.requestFocus();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_JpasswordKeyPressed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
       char i = '*';
       
       if(a){
         Jpassword.setEchoChar((char)0);
         a = false;
         CambiarIcono();
       }
       else{
         Jpassword.setEchoChar(i);
         a = true;
         CargarIcono();
       }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void JtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtUsuarioKeyPressed
        int codigo = evt.getKeyCode();
        
        if(codigo == KeyEvent.VK_F12){
           JcDB.setVisible(true);
        }
    }//GEN-LAST:event_JtUsuarioKeyPressed
    private void CambiarIcono(){
        btnMostrar.setIcon(ocultar);
    }
    
    private void CargarIcono(){
        btnMostrar.setIcon(mostrar);
    }
    
    private void Cerrar() {
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Deseas salir de la aplicación?", "TOP-SUELAS",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEntrar;
    private javax.swing.JButton JbSalir;
    private javax.swing.JComboBox<String> JcDB;
    private javax.swing.JPasswordField Jpassword;
    private javax.swing.JTextField JtUsuario;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
