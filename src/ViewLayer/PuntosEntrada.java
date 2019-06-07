package ViewLayer;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PuntosEntrada extends javax.swing.JDialog {

    public String Corrida = "";
    public String Idp = "";
    public String Am = "";
    public String Suela = "";
    int aux = 0;
    int Cantidad = 0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
    DecimalFormat pc = new DecimalFormat("#.00");

    public DefaultTableModel modelEn = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return true;
        }
    };

    public PuntosEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setText();
        OcultarCampos();
    }

    private void Agregar() {

        c1 = Integer.parseInt(Jt1.getText());
        c2 = Integer.parseInt(Jt2.getText());
        c3 = Integer.parseInt(Jt3.getText());
        c4 = Integer.parseInt(Jt4.getText());
        c5 = Integer.parseInt(Jt5.getText());
        c6 = Integer.parseInt(Jt6.getText());
        c7 = Integer.parseInt(Jt7.getText());
        c8 = Integer.parseInt(Jt8.getText());
        c9 = Integer.parseInt(Jt9.getText());
        c10 = Integer.parseInt(Jt10.getText());
        c11 = Integer.parseInt(Jt11.getText());
        c12 = Integer.parseInt(Jt12.getText());
        String costo = "5.00";
        int cantidad = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12;
        double precio = Double.parseDouble(costo);

        String datos[] = new String[17];
        datos[0] = Am;
        datos[1] = Idp;
        datos[2] = Suela;
        datos[3] = String.valueOf(c1);
        datos[4] = String.valueOf(c2);
        datos[5] = String.valueOf(c3);
        datos[6] = String.valueOf(c4);
        datos[7] = String.valueOf(c5);
        datos[8] = String.valueOf(c6);
        datos[9] = String.valueOf(c7);
        datos[10] = String.valueOf(c8);
        datos[11] = String.valueOf(c9);
        datos[12] = String.valueOf(c10);
        datos[13] = String.valueOf(c11);
        datos[14] = String.valueOf(c12);
        datos[15] = String.valueOf(cantidad);
        datos[16] = pc.format(precio);

        modelEn.addRow(datos);
    }

    public void ValidarCorrida() {
        switch (Corrida) {
            case "[10-12]":
                Mostrar6();
                Jb1.setText("10:");
                Jb2.setText("10.5:");
                Jb3.setText("11:");
                Jb4.setText("11.5:");
                Jb5.setText("12:");
                Jb6.setText("12.5:");
                break;
            case "[13-16]":
                Mostrar8();
                Jb1.setText("13:");
                Jb2.setText("13.5:");
                Jb3.setText("14:");
                Jb4.setText("14.5:");
                Jb5.setText("15:");
                Jb6.setText("15.5:");
                Jb7.setText("16:");
                Jb8.setText("16.5:");
                break;
            case "[27-29]":
                Mostrar6();
                Jb1.setText("27:");
                Jb2.setText("27.5:");
                Jb3.setText("28:");
                Jb4.setText("28.5:");
                Jb5.setText("29:");
                Jb6.setText("29.5:");
                break;
            case "[11-14]":
                Mostrar8();
                Jb1.setText("11:");
                Jb2.setText("11.5:");
                Jb3.setText("12:");
                Jb4.setText("12.5:");
                Jb5.setText("13:");
                Jb6.setText("13.5:");
                Jb7.setText("14:");
                Jb8.setText("14.5:");
                break;
            case "[22-27]":
                Mostrar12();
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb7.setText("25:");
                Jb8.setText("25.5:");
                Jb9.setText("26:");
                Jb10.setText("26.5:");
                Jb11.setText("27:");
                Jb12.setText("27.5:");
                break;
            case "[12-14]":
                Mostrar6();
                Jb1.setText("12:");
                Jb2.setText("12.5:");
                Jb3.setText("13:");
                Jb4.setText("13.5:");
                Jb5.setText("14:");
                Jb6.setText("14.5:");
                break;
            case "[15-17]":
                Mostrar6();
                Jb1.setText("15:");
                Jb2.setText("15.5:");
                Jb3.setText("16:");
                Jb4.setText("16.5:");
                Jb5.setText("17:");
                Jb6.setText("17.5:");
                break;
            case "[18-21]":
                Mostrar8();
                Jb1.setText("18:");
                Jb2.setText("18.5:");
                Jb3.setText("19:");
                Jb4.setText("19.5:");
                Jb5.setText("20:");
                Jb6.setText("20.5:");
                Jb7.setText("21:");
                Jb8.setText("21.5:");
                break;
            case "[22-24]":
                Mostrar6();
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                break;
            case "[22-26]":
                Mostrar10();
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb7.setText("25:");
                Jb8.setText("25.5:");
                Jb9.setText("26");
                Jb10.setText("26.5");
                break;
            case "[25-30]":
                Mostrar12();
                Jb1.setText("25:");
                Jb2.setText("25.5:");
                Jb3.setText("26:");
                Jb4.setText("26.5:");
                Jb5.setText("27:");
                Jb6.setText("27.5:");
                Jb7.setText("28:");
                Jb8.setText("28.5:");
                Jb9.setText("29:");
                Jb10.setText("29.5:");
                Jb11.setText("30:");
                Jb12.setText("30.5:");
                break;
            case "[21-25]":
                Mostrar10();
                Jb1.setText("21:");
                Jb2.setText("21.5:");
                Jb3.setText("22:");
                Jb4.setText("22.5:");
                Jb5.setText("23:");
                Jb6.setText("23.5:");
                Jb7.setText("24:");
                Jb8.setText("24.5:");
                Jb9.setText("25");
                Jb10.setText("25.5");
                break;
            case "[30-33]":
                Mostrar8();
                Jb1.setText("30:");
                Jb2.setText("30.5:");
                Jb3.setText("31:");
                Jb4.setText("31.5:");
                Jb5.setText("32:");
                Jb6.setText("32.5:");
                Jb7.setText("33:");
                Jb8.setText("33.5:");
                break;
            case "[17-21]":
                Mostrar10();
                Jb1.setText("17:");
                Jb2.setText("17.5:");
                Jb3.setText("18:");
                Jb4.setText("18.5:");
                Jb5.setText("19:");
                Jb6.setText("19.5:");
                Jb7.setText("20:");
                Jb8.setText("20.5:");
                Jb9.setText("21");
                Jb10.setText("21.5");
                break;
            case "[23-27]":
                Mostrar10();
                Jb1.setText("23:");
                Jb2.setText("23.5:");
                Jb3.setText("24:");
                Jb4.setText("24.5:");
                Jb5.setText("25:");
                Jb6.setText("25.5:");
                Jb7.setText("26:");
                Jb8.setText("26.5:");
                Jb9.setText("27");
                Jb10.setText("27.5");
                break;
            case "[23-26]":
                Mostrar10();
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb7.setText("25:");
                Jb8.setText("25.5:");
                Jb9.setText("26");
                Jb10.setText("26.5");
                break;
            case "[23-29]":
                Mostrar10();
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                Jb7.setText("25:");
                Jb8.setText("25.5:");
                Jb9.setText("26");
                Jb10.setText("26.5");
                break;
            case "[25-29]":
                Mostrar12();
                Jb1.setText("25:");
                Jb2.setText("25.5:");
                Jb3.setText("26:");
                Jb4.setText("26.5:");
                Jb5.setText("27:");
                Jb6.setText("27.5:");
                Jb7.setText("28:");
                Jb8.setText("28.5:");
                Jb9.setText("29:");
                Jb10.setText("29.5:");
                Jb11.setText("30:");
                Jb12.setText("30.5:");
                break;
            default:
                break;
        }
    }

    private void setText() {
        Jt1.setText("0");
        Jt2.setText("0");
        Jt3.setText("0");
        Jt4.setText("0");
        Jt5.setText("0");
        Jt6.setText("0");
        Jt7.setText("0");
        Jt8.setText("0");
        Jt9.setText("0");
        Jt10.setText("0");
        Jt11.setText("0");
        Jt12.setText("0");
    }

    private void Mostrar12() {
        Jt1.setVisible(true);
        Jt2.setVisible(true);
        Jt3.setVisible(true);
        Jt4.setVisible(true);
        Jt5.setVisible(true);
        Jt6.setVisible(true);
        Jt7.setVisible(true);
        Jt8.setVisible(true);
        Jt9.setVisible(true);
        Jt10.setVisible(true);
        Jt11.setVisible(true);
        Jt12.setVisible(true);
        Jb1.setVisible(true);
        Jb2.setVisible(true);
        Jb3.setVisible(true);
        Jb4.setVisible(true);
        Jb5.setVisible(true);
        Jb6.setVisible(true);
        Jb7.setVisible(true);
        Jb8.setVisible(true);
        Jb9.setVisible(true);
        Jb10.setVisible(true);
        Jb11.setVisible(true);
        Jb12.setVisible(true);
        Jt2.setSelectionStart(0);
        Jt3.setSelectionStart(0);
        Jt4.setSelectionStart(0);
        Jt5.setSelectionStart(0);
        Jt6.setSelectionStart(0);
        Jt7.setSelectionStart(0);
        Jt8.setSelectionStart(0);
        Jt9.setSelectionStart(0);
        Jt10.setSelectionStart(0);
        Jt11.setSelectionStart(0);
        Jt12.setSelectionStart(0);
    }

    private void Mostrar10() {
        Jt1.setVisible(true);
        Jt2.setVisible(true);
        Jt3.setVisible(true);
        Jt4.setVisible(true);
        Jt5.setVisible(true);
        Jt6.setVisible(true);
        Jt7.setVisible(true);
        Jt8.setVisible(true);
        Jt9.setVisible(true);
        Jt10.setVisible(true);
        Jb1.setVisible(true);
        Jb2.setVisible(true);
        Jb3.setVisible(true);
        Jb4.setVisible(true);
        Jb5.setVisible(true);
        Jb6.setVisible(true);
        Jb7.setVisible(true);
        Jb8.setVisible(true);
        Jb9.setVisible(true);
        Jb10.setVisible(true);
        Jt2.setSelectionStart(0);
        Jt3.setSelectionStart(0);
        Jt4.setSelectionStart(0);
        Jt5.setSelectionStart(0);
        Jt6.setSelectionStart(0);
        Jt7.setSelectionStart(0);
        Jt8.setSelectionStart(0);
        Jt9.setSelectionStart(0);
        Jt10.setSelectionStart(0);
    }

    private void Mostrar8() {
        Jt1.setVisible(true);
        Jt2.setVisible(true);
        Jt3.setVisible(true);
        Jt4.setVisible(true);
        Jt5.setVisible(true);
        Jt6.setVisible(true);
        Jt7.setVisible(true);
        Jt8.setVisible(true);
        Jb1.setVisible(true);
        Jb2.setVisible(true);
        Jb3.setVisible(true);
        Jb4.setVisible(true);
        Jb5.setVisible(true);
        Jb6.setVisible(true);
        Jb7.setVisible(true);
        Jb8.setVisible(true);
        Jt2.setSelectionStart(0);
        Jt3.setSelectionStart(0);
        Jt4.setSelectionStart(0);
        Jt5.setSelectionStart(0);
        Jt6.setSelectionStart(0);
        Jt7.setSelectionStart(0);
        Jt8.setSelectionStart(0);
    }

    private void Mostrar6() {
        Jt1.setVisible(true);
        Jt2.setVisible(true);
        Jt3.setVisible(true);
        Jt4.setVisible(true);
        Jt5.setVisible(true);
        Jt6.setVisible(true);
        Jb1.setVisible(true);
        Jb2.setVisible(true);
        Jb3.setVisible(true);
        Jb4.setVisible(true);
        Jb5.setVisible(true);
        Jb6.setVisible(true);
        Jt2.setSelectionStart(0);
        Jt3.setSelectionStart(0);
        Jt4.setSelectionStart(0);
        Jt5.setSelectionStart(0);
        Jt6.setSelectionStart(0);
    }

    private void OcultarCampos() {
        Jt1.setVisible(false);
        Jt2.setVisible(false);
        Jt3.setVisible(false);
        Jt4.setVisible(false);
        Jt5.setVisible(false);
        Jt6.setVisible(false);
        Jt7.setVisible(false);
        Jt8.setVisible(false);
        Jt9.setVisible(false);
        Jt10.setVisible(false);
        Jt11.setVisible(false);
        Jt12.setVisible(false);
        Jb1.setVisible(false);
        Jb2.setVisible(false);
        Jb3.setVisible(false);
        Jb4.setVisible(false);
        Jb5.setVisible(false);
        Jb6.setVisible(false);
        Jb7.setVisible(false);
        Jb8.setVisible(false);
        Jb9.setVisible(false);
        Jb10.setVisible(false);
        Jb11.setVisible(false);
        Jb12.setVisible(false);
    }

    private void ValidarCampos() {
        switch (Corrida) {
            case "[10-12]":
                Validar6();
                break;
            case "[13-16]":
                Validar8();
                break;
            case "[27-29]":
                Validar6();
                break;
            case "[11-14]":
                Validar8();
                break;
            case "[22-27]":
                Validar12();
                break;
            case "[12-14]":
                Validar6();
                break;
            case "[15-17]":
                Validar6();
                break;
            case "[18-21]":
                Validar8();
                break;
            case "[22-24]":
                Validar6();
                break;
            case "[22-26]":
                Validar10();
                break;
            case "[25-30]":
                Validar12();
                break;
            case "[21-25]":
                Validar10();
                break;
            case "[30-33]":
                Validar8();
                break;
            case "[17-21]":
                Validar10();
                break;
            case "[23-27]":
                Validar10();
                break;
            case "[23-26]":
                Validar10();
                break;
            case "[23-29]":
                Validar10();
                break;
            case "[25-29]":
                Validar12();
                break;
            default:
                break;
        }
    }

    private boolean Validar12() {
        if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                || Jt5.getText().isEmpty() || Jt6.getText().isEmpty() || Jt7.getText().isEmpty() || Jt8.getText().isEmpty()
                || Jt9.getText().isEmpty() || Jt10.getText().isEmpty() || Jt11.getText().isEmpty() || Jt12.getText().isEmpty()) {
            Jt1.requestFocus();
            JOptionPane.showMessageDialog(null, "Hay campos vacios, verifica!!!");
            return false;
        } else {
            Agregar();
            aux = 1;
            return true;
        }
    }

    private boolean Validar10() {
        if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                || Jt5.getText().isEmpty() || Jt6.getText().isEmpty() || Jt7.getText().isEmpty() || Jt8.getText().isEmpty()
                || Jt9.getText().isEmpty() || Jt10.getText().isEmpty()) {
            Jt1.requestFocus();
            JOptionPane.showMessageDialog(null, "Hay campos vacios, verifica!!!");
            return false;
        } else {
            Agregar();
            aux = 1;
            return true;
        }
    }

    private boolean Validar8() {
        if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                || Jt5.getText().isEmpty() || Jt6.getText().isEmpty() || Jt7.getText().isEmpty() || Jt8.getText().isEmpty()) {
            Jt1.requestFocus();
            JOptionPane.showMessageDialog(null, "Hay campos vacios, verifica!!!");
            return false;
        } else {
            Agregar();
            aux = 1;
            return true;
        }
    }

    private boolean Validar6() {
        if (Jt1.getText().isEmpty() || Jt2.getText().isEmpty() || Jt3.getText().isEmpty() || Jt4.getText().isEmpty()
                || Jt5.getText().isEmpty() || Jt6.getText().isEmpty()) {
            Jt1.requestFocus();
             JOptionPane.showMessageDialog(null, "Hay campos vacios, verifica!!!");
            return false;
        } else {
            Agregar();
            aux = 1;
            return true;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jb1 = new javax.swing.JLabel();
        Jb2 = new javax.swing.JLabel();
        Jt1 = new javax.swing.JTextField();
        Jt2 = new javax.swing.JTextField();
        Jb3 = new javax.swing.JLabel();
        Jt3 = new javax.swing.JTextField();
        Jb4 = new javax.swing.JLabel();
        Jt4 = new javax.swing.JTextField();
        Jb5 = new javax.swing.JLabel();
        Jt5 = new javax.swing.JTextField();
        Jb6 = new javax.swing.JLabel();
        Jt6 = new javax.swing.JTextField();
        Jb7 = new javax.swing.JLabel();
        Jt7 = new javax.swing.JTextField();
        Jb8 = new javax.swing.JLabel();
        Jt8 = new javax.swing.JTextField();
        Jb9 = new javax.swing.JLabel();
        Jt9 = new javax.swing.JTextField();
        Jb10 = new javax.swing.JLabel();
        Jt10 = new javax.swing.JTextField();
        Jb11 = new javax.swing.JLabel();
        Jt11 = new javax.swing.JTextField();
        Jb12 = new javax.swing.JLabel();
        Jt12 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DISTRIBUCIÓN DE PUNTOS");
        setLocation(new java.awt.Point(200, 200));

        Jb1.setText("L1:");

        Jb2.setText("L2:");

        Jt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt1KeyPressed(evt);
            }
        });

        Jt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt2KeyPressed(evt);
            }
        });

        Jb3.setText("L3:");

        Jt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt3KeyPressed(evt);
            }
        });

        Jb4.setText("L4:");

        Jt4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt4KeyPressed(evt);
            }
        });

        Jb5.setText("L5:");

        Jt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt5KeyPressed(evt);
            }
        });

        Jb6.setText("L6:");

        Jt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt6KeyPressed(evt);
            }
        });

        Jb7.setText("L7:");

        Jt7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt7KeyPressed(evt);
            }
        });

        Jb8.setText("L8:");

        Jt8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt8KeyPressed(evt);
            }
        });

        Jb9.setText("L9:");

        Jt9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt9KeyPressed(evt);
            }
        });

        Jb10.setText("L1:");

        Jt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt10KeyPressed(evt);
            }
        });

        Jb11.setText("L1:");

        Jt11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt11KeyPressed(evt);
            }
        });

        Jb12.setText("L1:");

        Jt12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt12KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jb7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jb3)
                    .addComponent(Jb9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jt9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jb5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Jb11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jb12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jb6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jb1)
                    .addComponent(Jb2)
                    .addComponent(Jt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb3)
                    .addComponent(Jt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb4)
                    .addComponent(Jt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb5)
                    .addComponent(Jt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb6)
                    .addComponent(Jt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jb7)
                    .addComponent(Jt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb8)
                    .addComponent(Jt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb9)
                    .addComponent(Jt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb10)
                    .addComponent(Jt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb11)
                    .addComponent(Jt11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jb12)
                    .addComponent(Jt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void Jt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt1KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt1KeyPressed

    private void Jt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt2KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt2KeyPressed

    private void Jt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt3KeyPressed
       int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt3KeyPressed

    private void Jt4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt4KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt4KeyPressed

    private void Jt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt5KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt5KeyPressed

    private void Jt6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt6KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt6KeyPressed

    private void Jt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt7KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt7KeyPressed

    private void Jt8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt8KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt8KeyPressed

    private void Jt9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt9KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt9KeyPressed

    private void Jt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt10KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt10KeyPressed

    private void Jt11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt11KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt11KeyPressed

    private void Jt12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt12KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if(aux == 1){
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt12KeyPressed

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
            java.util.logging.Logger.getLogger(PuntosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PuntosEntrada dialog = new PuntosEntrada(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Jb1;
    private javax.swing.JLabel Jb10;
    private javax.swing.JLabel Jb11;
    private javax.swing.JLabel Jb12;
    private javax.swing.JLabel Jb2;
    private javax.swing.JLabel Jb3;
    private javax.swing.JLabel Jb4;
    private javax.swing.JLabel Jb5;
    private javax.swing.JLabel Jb6;
    private javax.swing.JLabel Jb7;
    private javax.swing.JLabel Jb8;
    private javax.swing.JLabel Jb9;
    public javax.swing.JTextField Jt1;
    private javax.swing.JTextField Jt10;
    private javax.swing.JTextField Jt11;
    private javax.swing.JTextField Jt12;
    private javax.swing.JTextField Jt2;
    private javax.swing.JTextField Jt3;
    private javax.swing.JTextField Jt4;
    private javax.swing.JTextField Jt5;
    private javax.swing.JTextField Jt6;
    private javax.swing.JTextField Jt7;
    private javax.swing.JTextField Jt8;
    private javax.swing.JTextField Jt9;
    // End of variables declaration//GEN-END:variables
}
