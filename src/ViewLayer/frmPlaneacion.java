package ViewLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import ObjectLayer.Dprograma;
import ObjectLayer.ObjectPlaneacion;
import ObjectLayer.Pedido;
import ObjectLayer.Planeacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmPlaneacion extends javax.swing.JInternalFrame {

    ObjectPlaneacion obj = new ObjectPlaneacion();
    SimpleDateFormat fecha = new SimpleDateFormat();
    Connection c = Conexion.getRcpt();

    DefaultTableModel Table = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public frmPlaneacion() {
        initComponents();
        LoadColumns();
        Tb.setFont(new java.awt.Font("Tahoma", 0, 9));
        JdFecha.setVisible(false);
        cargarListenerPedido();
        lblPares.setVisible(false);
        Calendar fecha = new GregorianCalendar();
        JdFecha.setCalendar(fecha);
        JbBuscar.setToolTipText("HOLA");
        Jmes.setVisible(false);
        Tb.getTableHeader().setReorderingAllowed(false);
    }

    private void LoadColumns() {
        Table.addColumn("NO");
        Table.addColumn("PEDIDO");
        Table.addColumn("CLIENTE");
        Table.addColumn("Id_Cliente");
        Table.addColumn("Id_Agente");
        Table.addColumn("Id_Producto");
        Table.addColumn("A.G");
        Table.addColumn("MODELO");
        Table.addColumn("COLOR");
        Table.addColumn("Id_Color");
        Table.addColumn("Id_Corrida");
        Table.addColumn("C1");
        Table.addColumn("C2");
        Table.addColumn("C3");
        Table.addColumn("C4");
        Table.addColumn("C5");
        Table.addColumn("C6");
        Table.addColumn("PARES");
        Table.addColumn("OBSV");
        Table.addColumn("O.COMPRA");
        Table.addColumn("Estatus");
        Table.addColumn("Pto1");
        Table.addColumn("Pto2");
        Table.addColumn("Pto3");
        Table.addColumn("Pto4");
        Table.addColumn("Pto5");
        Table.addColumn("Pto6");
        Table.addColumn("Serie");

        Tb.getColumnModel().getColumn(3).setMaxWidth(0);
        Tb.getColumnModel().getColumn(3).setMinWidth(0);
        Tb.getColumnModel().getColumn(3).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(4).setMaxWidth(0);
        Tb.getColumnModel().getColumn(4).setMinWidth(0);
        Tb.getColumnModel().getColumn(4).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(5).setMaxWidth(0);
        Tb.getColumnModel().getColumn(5).setMinWidth(0);
        Tb.getColumnModel().getColumn(5).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(9).setMaxWidth(0);
        Tb.getColumnModel().getColumn(9).setMinWidth(0);
        Tb.getColumnModel().getColumn(9).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(10).setMaxWidth(0);
        Tb.getColumnModel().getColumn(10).setMinWidth(0);
        Tb.getColumnModel().getColumn(10).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(20).setMaxWidth(0);
        Tb.getColumnModel().getColumn(20).setMinWidth(0);
        Tb.getColumnModel().getColumn(20).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(21).setMaxWidth(0);
        Tb.getColumnModel().getColumn(21).setMinWidth(0);
        Tb.getColumnModel().getColumn(21).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(22).setMaxWidth(0);
        Tb.getColumnModel().getColumn(22).setMinWidth(0);
        Tb.getColumnModel().getColumn(22).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(23).setMaxWidth(0);
        Tb.getColumnModel().getColumn(23).setMinWidth(0);
        Tb.getColumnModel().getColumn(23).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(24).setMaxWidth(0);
        Tb.getColumnModel().getColumn(24).setMinWidth(0);
        Tb.getColumnModel().getColumn(24).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(25).setMaxWidth(0);
        Tb.getColumnModel().getColumn(25).setMinWidth(0);
        Tb.getColumnModel().getColumn(25).setPreferredWidth(0);

        Tb.getColumnModel().getColumn(26).setMaxWidth(0);
        Tb.getColumnModel().getColumn(26).setMinWidth(0);
        Tb.getColumnModel().getColumn(26).setPreferredWidth(0);

        /*Tb.getColumnModel().getColumn(27).setMaxWidth(0);
        Tb.getColumnModel().getColumn(27).setMinWidth(0);
        Tb.getColumnModel().getColumn(27).setPreferredWidth(0);*/
    }

    private void LoadModelP() {
        CleanTable();
        int Año = Jaño.getYear();
        int Semana = (int) Jsemana.getValue();

        ArrayList<Planeacion> listP = obj.obtenerPlaneacion(Año, Semana);

        if (listP.size() > 0) {
            for (Planeacion pn : listP) {
                String arreglo[] = new String[28];

                arreglo[0] = String.valueOf(pn.getNumero());
                arreglo[1] = pn.getNpedido();
                arreglo[2] = pn.getCliente();
                arreglo[3] = String.valueOf(pn.getId_Cliente());
                arreglo[4] = String.valueOf(pn.getId_Agente());
                arreglo[5] = String.valueOf(pn.getId_Producto());
                arreglo[6] = pn.getAgente();
                arreglo[7] = pn.getModelo();
                arreglo[8] = pn.getColor();
                arreglo[9] = String.valueOf(pn.getId_Color());
                arreglo[10] = String.valueOf(pn.getId_Corrida());
                arreglo[11] = String.valueOf(pn.getC1());
                arreglo[12] = String.valueOf(pn.getC2());
                arreglo[13] = String.valueOf(pn.getC3());
                arreglo[14] = String.valueOf(pn.getC4());
                arreglo[15] = String.valueOf(pn.getC5());
                arreglo[16] = String.valueOf(pn.getC6());
                arreglo[17] = String.valueOf(pn.getPares());
                arreglo[18] = pn.getObservaciones();
                arreglo[19] = pn.getOrdenCompra();
                arreglo[20] = pn.getEstatus();
                arreglo[21] = String.valueOf(pn.getPto1());
                arreglo[22] = String.valueOf(pn.getPto2());
                arreglo[23] = String.valueOf(pn.getPto3());
                arreglo[24] = String.valueOf(pn.getPto4());
                arreglo[25] = String.valueOf(pn.getPto5());
                arreglo[26] = String.valueOf(pn.getPto6());
                arreglo[27] = pn.getSerie();
                Table.addRow(arreglo);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void CleanTable() {
        int file = Tb.getRowCount();
        if (file > 0) {
            for (int i = file - 1; i >= 0; i--) {
                Table.removeRow(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Jsemana = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Jaño = new com.toedter.calendar.JYearChooser();
        JbBuscar = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JbGuardar = new javax.swing.JButton();
        JbLimpiar = new javax.swing.JButton();
        JdFecha = new com.toedter.calendar.JDateChooser();
        lblPares = new javax.swing.JLabel();
        Jmes = new com.toedter.calendar.JMonthChooser();

        setClosable(true);
        setMaximizable(true);
        setTitle("PLANEACIÓN");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Programa:");

        Tb.setModel(Table);
        jScrollPane1.setViewportView(Tb);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Año:");

        JbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Magnifier_29783.png"))); // NOI18N
        JbBuscar.setText("BUSCAR");
        JbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbBuscarActionPerformed(evt);
            }
        });

        JbReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbReporte.setText("REPORTE");
        JbReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbReporteActionPerformed(evt);
            }
        });

        JbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save_as-80_icon-icons.com_57275.png"))); // NOI18N
        JbGuardar.setText("GUARDAR");
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        JbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/eraser_icon-icons.com_60679.png"))); // NOI18N
        JbLimpiar.setText("LIMPIAR");
        JbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbLimpiarActionPerformed(evt);
            }
        });

        lblPares.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbBuscar)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Jaño, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbReporte)
                        .addGap(40, 40, 40)
                        .addComponent(JbGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jsemana, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Jmes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbLimpiar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPares, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(JbReporte)
                    .addComponent(JbBuscar)
                    .addComponent(JbLimpiar))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jsemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPares)
                    .addComponent(Jmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbBuscarActionPerformed
        LoadModelP();
    }//GEN-LAST:event_JbBuscarActionPerformed

    private void JbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbLimpiarActionPerformed
        CleanTable();
        Jsemana.setValue(0);
    }//GEN-LAST:event_JbLimpiarActionPerformed

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed
        ArrayList<Dprograma> dt = new ArrayList<Dprograma>();
        int Est = 20;
        String A = "A";

        Date Entrega = JdFecha.getDate();
        long e = Entrega.getTime();
        java.sql.Date Fecha = new java.sql.Date(e);

        String var = "";
        String var2 = null;
        int Mes = Jmes.getMonth() + 1;
        int row = Table.getRowCount();
        int Programa = (int) Jsemana.getValue();
        int pares = Integer.parseInt(lblPares.getText());

        if (ValidarDatos()) {
            for (int i = 0; i < row; i++) {
                int cont = Integer.parseInt((String) Table.getValueAt(i, 0));
                String pedido = Table.getValueAt(i, 1).toString();
                var = pedido;
                int cliente = Integer.parseInt((String) Table.getValueAt(i, 3));
                int agente = Integer.parseInt((String) Table.getValueAt(i, 4));
                int modelo = Integer.parseInt((String) Table.getValueAt(i, 5));
                int corrida = Integer.parseInt((String) Table.getValueAt(i, 10));
                int color = Integer.parseInt((String) Table.getValueAt(i, 9));
                int Cant1 = Integer.parseInt((String) Table.getValueAt(i, 11));
                int Cant2 = Integer.parseInt((String) Table.getValueAt(i, 12));
                int Cant3 = Integer.parseInt((String) Table.getValueAt(i, 13));
                int Cant4 = Integer.parseInt((String) Table.getValueAt(i, 14));
                int Cant5 = Integer.parseInt((String) Table.getValueAt(i, 15));
                int Cant6 = Integer.parseInt((String) Table.getValueAt(i, 16));
                int Pto1 = Integer.parseInt((String) Table.getValueAt(i, 21));
                int Pto2 = Integer.parseInt((String) Table.getValueAt(i, 22));
                int Pto3 = Integer.parseInt((String) Table.getValueAt(i, 23));
                int Pto4 = Integer.parseInt((String) Table.getValueAt(i, 24));
                int Pto5 = Integer.parseInt((String) Table.getValueAt(i, 25));
                int Pto6 = Integer.parseInt((String) Table.getValueAt(i, 26));
                String Serie = Table.getValueAt(i, 27).toString();

                Planeacion p = new Planeacion();
                p.setPrograma(Programa);
                p.setMes(String.valueOf(Mes));
                p.setFecha(Fecha);
                p.setPares(pares);
                p.setCont(cont);
                p.setNpedido(pedido);
                p.setId_Cliente(cliente);
                p.setId_Agente(agente);
                p.setId_Producto(modelo);
                p.setId_Color(color);
                p.setId_Corrida(corrida);
                p.setPto1(Pto1);
                p.setPto2(Pto2);
                p.setPto3(Pto3);
                p.setPto4(Pto4);
                p.setPto5(Pto5);
                p.setPto6(Pto6);
                p.setPto7(0);
                p.setPto8(0);
                p.setPto9(0);
                p.setPto10(0);
                p.setPto11(0);
                p.setPto12(0);
                p.setC1(Cant1);
                p.setC2(Cant2);
                p.setC3(Cant3);
                p.setC4(Cant4);
                p.setC5(Cant5);
                p.setC6(Cant6);
                p.setC7(0);
                p.setC8(0);
                p.setC9(0);
                p.setC10(0);
                p.setC11(0);
                p.setC12(0);
                p.setSerie(Serie);
                
                
                if (Serie == "A") {
                if (obj.AddPlaneacionA(p, String.valueOf(Est), String.valueOf(var)) && obj.CambiarEstatus(String.valueOf(Est), String.valueOf(var))) {
                    var = "ok";
                   
                } else {
                    var = "error";
                }
            } else {
                if (obj.AddPlaneacionA(p, String.valueOf(Est), String.valueOf(var))) {
                   var = "ok";
                } else {
                    var = "error";
                }
            } 
            }
        }
        
        if(var == "ok"){
           JOptionPane.showMessageDialog(this, "Programa Guardado!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }else if(var == "error"){
           JOptionPane.showMessageDialog(this, "Ocurrio un error!!!", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_JbGuardarActionPerformed

    private boolean ValidarDatos() {
        if (this.Tb.getRowCount() == 0 && this.Tb.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No hay datos para el programa", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void JbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbReporteActionPerformed
        if (this.Tb.getRowCount() == 0 && this.Tb.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No hay datos para exportar", "TOP-SUELAS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Map par = new HashMap();
                par.put("Año", Jaño.getYear());
                par.put("Semana", Integer.parseInt(Jsemana.getValue().toString()));
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/ReportePlaneacion.jasper"));
                try {
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                    JasperViewer view = new JasperViewer(jprint, false);

                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setIconImage(getImage());
                    view.setTitle("TOP-SUELAS");
                    view.setVisible(true);

                } catch (JRException ex) {
                    Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JRException ex) {
                Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JbReporteActionPerformed

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
    }

    private void cargarListenerPedido() {
        Table.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = Table.getRowCount();
                int pares = 0;
                for (int i = 0; i < row; i++) {
                    String tpares = (String) Table.getValueAt(i, 17);
                    pares += Integer.parseInt(tpares);
                    System.out.println(pares);
                }
                lblPares.setText(String.valueOf(pares));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser Jaño;
    private javax.swing.JButton JbBuscar;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JButton JbLimpiar;
    private javax.swing.JButton JbReporte;
    private com.toedter.calendar.JDateChooser JdFecha;
    private com.toedter.calendar.JMonthChooser Jmes;
    private javax.swing.JSpinner Jsemana;
    private javax.swing.JTable Tb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPares;
    // End of variables declaration//GEN-END:variables
}
