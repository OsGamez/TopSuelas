package ViewLayer;

import ObjectLayer.Validacion;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class PuntosCaptura extends javax.swing.JDialog {

    public ArrayList<String> array = new ArrayList<String>();
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, c11 = 0, c12 = 0;
    String ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11, ct12;
    String dt[] = new String[12];
    public int Pares, Suma, SumaPuntos;

    public PuntosCaptura(java.awt.Frame parent, boolean modal) {
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

        Jtdatos.setModel(modelP);
        Jtdatos.setSelectionBackground(new java.awt.Color(255, 153, 0));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarDetalle() {
        int row = modelP.getRowCount();
        //int var = Integer.parseInt(JbSuma.getText());
        int var = SumaPuntos;
        int tarreglo = var * 2;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < tarreglo; j++) {
                String Pares = modelP.getValueAt(i, j).toString();
                array.add(Pares);
            }
        }
    }

    private void  VerificarPuntos() {
        AgregarDetalle();
        Object[] obj = array.toArray();
       
        int sum = 0;

        if (obj.length == 12) {

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
            
        } else if (obj.length == 10) {
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
            
        } else if (obj.length == 8) {
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
            
        } else if (obj.length == 6) {
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
        }
       
       if(sum != Pares){
         array.clear();
         JOptionPane.showMessageDialog(this, "Las cantides no coinciden", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
       }else{
           this.dispose();
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
            java.util.logging.Logger.getLogger(PuntosCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntosCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntosCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntosCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PuntosCaptura dialog = new PuntosCaptura(new javax.swing.JFrame(), true);
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
