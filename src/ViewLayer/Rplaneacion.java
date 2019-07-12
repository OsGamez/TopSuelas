package ViewLayer;

import DataAccesLayer.Server;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rplaneacion extends javax.swing.JFrame {

    Connection c = Server.getRcpt();
    int contador = 0;

    public Rplaneacion() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JcmSuela = new javax.swing.JCheckBox();
        JcSemanalS = new javax.swing.JCheckBox();
        JcPedido = new javax.swing.JCheckBox();
        JcSemanal = new javax.swing.JCheckBox();
        JtNpedido = new javax.swing.JTextField();
        JcDetalle = new javax.swing.JCheckBox();
        JcMensual = new javax.swing.JCheckBox();
        JbImprimir = new javax.swing.JButton();
        JdInicio = new com.toedter.calendar.JDateChooser();
        JdFin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPORTES PLANEACIÓN");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Fecha inicial:");

        jLabel2.setText("Fecha final:");

        JcmSuela.setText("Mensual / Suela");
        JcmSuela.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmSuelaItemStateChanged(evt);
            }
        });

        JcSemanalS.setText("Semanal / Suela");
        JcSemanalS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcSemanalSItemStateChanged(evt);
            }
        });

        JcPedido.setText("Pedido");
        JcPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcPedidoItemStateChanged(evt);
            }
        });

        JcSemanal.setText("Semanal / Cliente");
        JcSemanal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcSemanalItemStateChanged(evt);
            }
        });

        JcDetalle.setText("Semanal / Detallada");
        JcDetalle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcDetalleItemStateChanged(evt);
            }
        });

        JcMensual.setText("Mensual / Cliente");
        JcMensual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcMensualItemStateChanged(evt);
            }
        });

        JbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JcDetalle)
                    .addComponent(JcSemanal)
                    .addComponent(JcSemanalS))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JcMensual)
                            .addComponent(JcmSuela))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JcPedido)
                        .addGap(27, 27, 27)
                        .addComponent(JtNpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JdFin, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(JdInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JcSemanal)
                            .addComponent(JcMensual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcDetalle)
                            .addComponent(JcmSuela)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(JdFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcSemanalS)
                            .addComponent(JcPedido)
                            .addComponent(JtNpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(JbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JcmSuelaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmSuelaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcmSuelaItemStateChanged

    private void JcSemanalSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcSemanalSItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcSemanalSItemStateChanged

    private void JcPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcPedidoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
            JtNpedido.requestFocus();
        }else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcPedidoItemStateChanged

    private void JcSemanalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcSemanalItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcSemanalItemStateChanged

    private void JcDetalleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcDetalleItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcDetalleItemStateChanged

    private void JcMensualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcMensualItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            contador++;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            contador--;
        }
    }//GEN-LAST:event_JcMensualItemStateChanged

    private void JbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbImprimirActionPerformed
        String fecha, fecha2;

        if (contador > 1) {
            JOptionPane.showMessageDialog(this, "Solo debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (contador == 0) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionar una opcion", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
        } else if (contador == 1) {
            if (JcSemanal.isSelected()) {
                if (JdInicio.getDate() == null && JdFin.getDate() == null) {
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Psemanal.jasper"));
                        try {

                            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() != null && JdFin.getDate() != null) {
                    String formato = JdInicio.getDateFormatString();
                    String formato2 = JdFin.getDateFormatString();
                    Date date = JdInicio.getDate();
                    Date date2 = JdFin.getDate();
                    SimpleDateFormat sm = new SimpleDateFormat(formato);
                    SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
                    fecha = String.valueOf(sm.format(date));
                    fecha2 = String.valueOf(sm2.format(date2));
                    Map par = new HashMap();
                    par.put("fecha", fecha);
                    par.put("fecha2", fecha2);
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Psemanal.jasper"));
                        try {

                            JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() == null && JdFin.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha de inicio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdFin.getDate() == null && JdInicio.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha final", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }

            } else if (JcDetalle.isSelected()) {
                if (JdInicio.getDate() == null && JdFin.getDate() == null) {
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pdetallada.jasper"));
                        try {
                            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() != null && JdFin.getDate() != null) {
                    String formato = JdInicio.getDateFormatString();
                    String formato2 = JdFin.getDateFormatString();
                    Date date = JdInicio.getDate();
                    Date date2 = JdFin.getDate();
                    SimpleDateFormat sm = new SimpleDateFormat(formato);
                    SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
                    fecha = String.valueOf(sm.format(date));
                    fecha2 = String.valueOf(sm2.format(date2));
                    Map par = new HashMap();
                    par.put("fecha", fecha);
                    par.put("fecha2", fecha2);

                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pdetallada.jasper"));
                        try {
                            JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() == null && JdFin.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha de inicio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdFin.getDate() == null && JdInicio.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha final", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }

            } else if (JcMensual.isSelected()) {
                if (JdInicio.getDate() == null && JdFin.getDate() == null) {
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pmensual.jasper"));
                        try {
                            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() != null && JdFin.getDate() != null) {
                    String formato = JdInicio.getDateFormatString();
                    String formato2 = JdFin.getDateFormatString();
                    Date date = JdInicio.getDate();
                    Date date2 = JdFin.getDate();
                    SimpleDateFormat sm = new SimpleDateFormat(formato);
                    SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
                    fecha = String.valueOf(sm.format(date));
                    fecha2 = String.valueOf(sm2.format(date2));
                    Map par = new HashMap();
                    par.put("fecha", fecha);
                    par.put("fecha2", fecha2);

                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pmensual.jasper"));
                        try {
                            JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() == null && JdFin.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha de inicio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdFin.getDate() == null && JdInicio.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha final", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }
            } else if (JcmSuela.isSelected()) {
                if (JdInicio.getDate() == null && JdFin.getDate() == null) {
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/PmensualSuela.jasper"));
                        try {
                            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() != null && JdFin.getDate() != null) {
                    String formato = JdInicio.getDateFormatString();
                    String formato2 = JdFin.getDateFormatString();
                    Date date = JdInicio.getDate();
                    Date date2 = JdFin.getDate();
                    SimpleDateFormat sm = new SimpleDateFormat(formato);
                    SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
                    fecha = String.valueOf(sm.format(date));
                    fecha2 = String.valueOf(sm2.format(date2));
                    Map par = new HashMap();
                    par.put("fecha", fecha);
                    par.put("fecha2", fecha2);

                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/PmensualSuela.jasper"));
                        try {
                            JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() == null && JdFin.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha de inicio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdFin.getDate() == null && JdInicio.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha final", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }
            } else if (JcSemanalS.isSelected()) {
                if (JdInicio.getDate() == null && JdFin.getDate() == null) {
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/PsemanalSuela.jasper"));
                        try {

                            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex, "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, ex, "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (JdInicio.getDate() != null && JdFin.getDate() != null) {
                    String formato = JdInicio.getDateFormatString();
                    String formato2 = JdFin.getDateFormatString();
                    Date date = JdInicio.getDate();
                    Date date2 = JdFin.getDate();
                    SimpleDateFormat sm = new SimpleDateFormat(formato);
                    SimpleDateFormat sm2 = new SimpleDateFormat(formato2);
                    fecha = String.valueOf(sm.format(date));
                    fecha2 = String.valueOf(sm2.format(date2));
                    Map par = new HashMap();
                    par.put("fecha", fecha);
                    par.put("fecha2", fecha2);
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/PsemanalSuela.jasper"));
                        try {

                            JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                            JasperViewer view = new JasperViewer(jprint, false);

                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex, "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                } else if (JdInicio.getDate() == null && JdFin.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha de inicio", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else if (JdFin.getDate() == null && JdInicio.getDate() != null) {
                    JOptionPane.showMessageDialog(this, "Ingresa una fecha final", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                }
            } else if (JcPedido.isSelected()) {
                if (JtNpedido.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingresa un numero de pedido", "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                } else {
                    Map par = new HashMap();
                    par.put("Npedido", JtNpedido.getText());
                    try {
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Pedidos.jasper"));
                        try {

                            JasperPrint jprint = JasperFillManager.fillReport(reporte, par, c);
                            JasperViewer view = new JasperViewer(jprint, false);
                            JtNpedido.setText("");
                            JtNpedido.requestFocus();
                            this.toBack();
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);
                            view.setIconImage(getImage());
                            view.setTitle("TOP-SUELAS");
                        } catch (JRException ex) {
                            Logger.getLogger(Colores.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex, "TOP-SUELAS", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_JbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public Image getImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/PhotoPrint_11187.png"));
        return icon;
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
            java.util.logging.Logger.getLogger(Rplaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rplaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rplaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rplaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rplaneacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbImprimir;
    private javax.swing.JCheckBox JcDetalle;
    private javax.swing.JCheckBox JcMensual;
    private javax.swing.JCheckBox JcPedido;
    private javax.swing.JCheckBox JcSemanal;
    private javax.swing.JCheckBox JcSemanalS;
    private javax.swing.JCheckBox JcmSuela;
    private com.toedter.calendar.JDateChooser JdFin;
    private com.toedter.calendar.JDateChooser JdInicio;
    private javax.swing.JTextField JtNpedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
