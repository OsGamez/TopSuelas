package ViewLayer;

import ObjectLayer.ExistenciasStock;
import ObjectLayer.ObjExistenciasStock;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PuntosMov extends javax.swing.JDialog {

    public ArrayList<String> array = new ArrayList<>();
    ArrayList<String> validar = new ArrayList<>();
    ObjExistenciasStock ObjE = new ObjExistenciasStock();
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, c11 = 0, c12 = 0, st1 = 0, st2 = 0, st3 = 0, st4 = 0, st5 = 0, st6 = 0, st7 = 0, st8 = 0, st9 = 0, st10 = 0, st11 = 0, st12 = 0;
    String ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11, ct12, Mov;
    String dt[] = new String[12];
    public int Pares, Suma, SumaPuntos, Am, Prod, AmD,x,y;

    public PuntosMov(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public DefaultTableModel modelP = new DefaultTableModel() {
     
         
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Jtdatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(250, 250));
        setResizable(false);

        Jtdatos.setBackground(new java.awt.Color(204, 255, 204));
        Jtdatos.setForeground(new java.awt.Color(51, 51, 51));
        Jtdatos.setModel(modelP);
        Jtdatos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        Jtdatos.setSelectionForeground(new java.awt.Color(51, 51, 51));
        Jtdatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtdatosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Jtdatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarDetalle() {
        int row = modelP.getRowCount();
        int tarreglo = SumaPuntos * 2;

        if ("Salida".equals(Mov) || "Traspaso".equals(Mov)) {
            for (int i = 0; i < row - 1; i++) {
                for (int j = 0; j < tarreglo; j++) {
                    String Par = modelP.getValueAt(i, j).toString();
                    array.add(Par);//Se asigna el tamaño del arreglo
                }
            }
        }else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < tarreglo; j++) {
                    String Par = modelP.getValueAt(i, j).toString();
                    array.add(Par);//Se asigna el tamaño del arreglo
                }
            }
        }

    }

    private void VerificarPuntos() {
        AgregarDetalle();
        Object[] obj = array.toArray();
        int sum = 0;

        switch (obj.length) {
            case 12:
                ct1 = (String) obj[0];
                ct2 = (String) obj[1];
                ct3 = (String) obj[2];
                ct4 = (String) obj[3];
                ct5 = (String) obj[4];
                ct6 = (String) obj[5];
                ct7 = (String) obj[6];
                ct8 = (String) obj[7];
                ct9 = (String) obj[8];
                ct10 = (String) obj[9];
                ct11 = (String) obj[10];
                ct12 = (String) obj[11];

                c1 = Integer.parseInt(ct1);
                c2 = Integer.parseInt(ct2);
                c3 = Integer.parseInt(ct3);
                c4 = Integer.parseInt(ct4);
                c5 = Integer.parseInt(ct5);
                c6 = Integer.parseInt(ct6);
                c7 = Integer.parseInt(ct7);
                c8 = Integer.parseInt(ct8);
                c9 = Integer.parseInt(ct9);
                c10 = Integer.parseInt(ct10);
                c11 = Integer.parseInt(ct11);
                c12 = Integer.parseInt(ct12);
                sum = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12;
                break;
            case 10:
                ct1 = (String) obj[0];
                ct2 = (String) obj[1];
                ct3 = (String) obj[2];
                ct4 = (String) obj[3];
                ct5 = (String) obj[4];
                ct6 = (String) obj[5];
                ct7 = (String) obj[6];
                ct8 = (String) obj[7];
                ct9 = (String) obj[8];
                ct10 = (String) obj[9];
                c1 = Integer.parseInt(ct1);
                c2 = Integer.parseInt(ct2);
                c3 = Integer.parseInt(ct3);
                c4 = Integer.parseInt(ct4);
                c5 = Integer.parseInt(ct5);
                c6 = Integer.parseInt(ct6);
                c7 = Integer.parseInt(ct7);
                c8 = Integer.parseInt(ct8);
                c9 = Integer.parseInt(ct9);
                c10 = Integer.parseInt(ct10);
                sum = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10;
                break;
            case 8:
                ct1 = (String) obj[0];
                ct2 = (String) obj[1];
                ct3 = (String) obj[2];
                ct4 = (String) obj[3];
                ct5 = (String) obj[4];
                ct6 = (String) obj[5];
                ct7 = (String) obj[6];
                ct8 = (String) obj[7];

                c1 = Integer.parseInt(ct1);
                c2 = Integer.parseInt(ct2);
                c3 = Integer.parseInt(ct3);
                c4 = Integer.parseInt(ct4);
                c5 = Integer.parseInt(ct5);
                c6 = Integer.parseInt(ct6);
                c7 = Integer.parseInt(ct7);
                c8 = Integer.parseInt(ct8);
                sum = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
                break;
            case 6:
                ct1 = (String) obj[0];
                ct2 = (String) obj[1];
                ct3 = (String) obj[2];
                ct4 = (String) obj[3];
                ct5 = (String) obj[4];
                ct6 = (String) obj[5];

                c1 = Integer.parseInt(ct1);
                c2 = Integer.parseInt(ct2);
                c3 = Integer.parseInt(ct3);
                c4 = Integer.parseInt(ct4);
                c5 = Integer.parseInt(ct5);
                c6 = Integer.parseInt(ct6);
                sum = c1 + c2 + c3 + c4 + c5 + c6;
                break;
        }

        if ("Salida".equals(Mov)) {
            verificarExistencias();
            if (c1 > st1 || c2 > st2 || c3 > st3 || c4 > st4 || c5 > st5 || c6 > st6 || c7 > st7 || c8 > st8
                    || c9 > st9 || st10 > st10 || c11 > st1 || c12 > st12) {
                JOptionPane.showMessageDialog(this, "No hay stock suficiente", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                array.clear();
            } else {
                if (sum != Pares) {
                    array.clear();
                    JOptionPane.showMessageDialog(this, "Las cantides no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.dispose();
                }
            }
        } else {
            if (sum != Pares) {
                array.clear();
                JOptionPane.showMessageDialog(this, "Las cantides no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
            } else {
                this.dispose();
            }
        }
    }

    private void verificarExistencias() {
        ArrayList<ExistenciasStock> listE = ObjE.getStock(Am, Prod);

        for (ExistenciasStock ex : listE) {
            st1 = ex.getPunto1();
            st2 = ex.getPunto2();
            st3 = ex.getPunto3();
            st4 = ex.getPunto4();
            st5 = ex.getPunto5();
            st6 = ex.getPunto6();
            st7 = ex.getPunto7();
            st8 = ex.getPunto8();
            st9 = ex.getPunto9();
            st10 = ex.getPunto10();
            st11 = ex.getPunto11();
            st12 = ex.getPunto12();
        }
    }

    private void JtdatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtdatosKeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER && !Jtdatos.isEditing()) {
            VerificarPuntos();
        }
    }//GEN-LAST:event_JtdatosKeyPressed

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
            java.util.logging.Logger.getLogger(PuntosMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntosMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntosMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntosMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PuntosMov dialog = new PuntosMov(new javax.swing.JFrame(), true);
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
    public javax.swing.JTable Jtdatos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
