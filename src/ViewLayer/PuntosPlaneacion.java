package ViewLayer;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PuntosPlaneacion extends javax.swing.JDialog {

    public String Corrida = "";
    public String Idp = "";
    public String Am = "";
    public String Suela = "";
    public String Estilo = "";
    public String Combinacion = "";
    public String Pares = "";
    int aux = 0;
    int Cantidad = 0; 
    int c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
    String datos[] = new String[22];
    PlaneacionPhy phy = new PlaneacionPhy();

    public DefaultTableModel modelPhylon = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return true;
        }
    };

    public PuntosPlaneacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        OcultarCampos();
        setText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Jt4 = new javax.swing.JTextField();
        Jb10 = new javax.swing.JLabel();
        Jb5 = new javax.swing.JLabel();
        Jt10 = new javax.swing.JTextField();
        Jt5 = new javax.swing.JTextField();
        Jb11 = new javax.swing.JLabel();
        Jb6 = new javax.swing.JLabel();
        Jt11 = new javax.swing.JTextField();
        Jt6 = new javax.swing.JTextField();
        Jb12 = new javax.swing.JLabel();
        Jb7 = new javax.swing.JLabel();
        Jt12 = new javax.swing.JTextField();
        Jt7 = new javax.swing.JTextField();
        Jb8 = new javax.swing.JLabel();
        Jt8 = new javax.swing.JTextField();
        Jb1 = new javax.swing.JLabel();
        Jb2 = new javax.swing.JLabel();
        Jt1 = new javax.swing.JTextField();
        Jt2 = new javax.swing.JTextField();
        Jb3 = new javax.swing.JLabel();
        Jt3 = new javax.swing.JTextField();
        Jb9 = new javax.swing.JLabel();
        Jb4 = new javax.swing.JLabel();
        Jt9 = new javax.swing.JTextField();
        Jb13 = new javax.swing.JLabel();
        Jt13 = new javax.swing.JTextField();
        Jb14 = new javax.swing.JLabel();
        Jt14 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(200, 200));
        setResizable(false);

        jPanel1.setBorder(null);

        Jt4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt4KeyPressed(evt);
            }
        });

        Jb10.setText("L1:");

        Jb5.setText("L5:");

        Jt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt10KeyPressed(evt);
            }
        });

        Jt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt5KeyPressed(evt);
            }
        });

        Jb11.setText("L1:");

        Jb6.setText("L6:");

        Jt11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt11KeyPressed(evt);
            }
        });

        Jt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt6KeyPressed(evt);
            }
        });

        Jb12.setText("L1:");

        Jb7.setText("L7:");

        Jt12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt12KeyPressed(evt);
            }
        });

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

        Jb9.setText("L9:");

        Jb4.setText("L4:");

        Jt9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt9KeyPressed(evt);
            }
        });

        Jb13.setText("L1:");

        Jt13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt13KeyPressed(evt);
            }
        });

        Jb14.setText("L1:");

        Jt14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jt14KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jb7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jb3)
                    .addComponent(Jb9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jt9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jb10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jb5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Jb11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jb12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jb14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Jb6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(Jb13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jt13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jb13)
                        .addComponent(Jt13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                        .addComponent(Jt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jb14)
                        .addComponent(Jt14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                        .addComponent(Jt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ValidarCorrida() {
        switch (Corrida) {
            case "80":
                Mostrar6();
                Jb1.setText("10:");
                Jb2.setText("10.5:");
                Jb3.setText("11:");
                Jb4.setText("11.5:");
                Jb5.setText("12:");
                Jb6.setText("12.5:");
                break;
            case "81":
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
            case "82":
                Mostrar6();
                Jb1.setText("27:");
                Jb2.setText("27.5:");
                Jb3.setText("28:");
                Jb4.setText("28.5:");
                Jb5.setText("29:");
                Jb6.setText("29.5:");
                break;
            case "85":
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
            case "88":
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
            case "89":
                Mostrar6();
                Jb1.setText("12:");
                Jb2.setText("12.5:");
                Jb3.setText("13:");
                Jb4.setText("13.5:");
                Jb5.setText("14:");
                Jb6.setText("14.5:");
                break;
            case "90":
                Mostrar6();
                Jb1.setText("15:");
                Jb2.setText("15.5:");
                Jb3.setText("16:");
                Jb4.setText("16.5:");
                Jb5.setText("17:");
                Jb6.setText("17.5:");
                break;
            case "91":
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
            case "92":
                Mostrar6();
                Jb1.setText("22:");
                Jb2.setText("22.5:");
                Jb3.setText("23:");
                Jb4.setText("23.5:");
                Jb5.setText("24:");
                Jb6.setText("24.5:");
                break;
            case "93":
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
            case "94":
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
            case "95":
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
            case "96":
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
            case "97":
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
            case "98":
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
        }
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
        Jt13.setText("0");
        Jt14.setText("0");
    }

    private void Jt4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt4KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt4KeyPressed

    private void Jt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt10KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt10KeyPressed

    private void Jt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt5KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt5KeyPressed

    private void Jt11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt11KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt11KeyPressed

    private void Jt6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt6KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt6KeyPressed

    private void Jt12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt12KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt12KeyPressed

    private void Jt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt7KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt7KeyPressed

    private void Jt8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt8KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt8KeyPressed

    private void Jt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt1KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt1KeyPressed

    private void Jt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt2KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt2KeyPressed

    private void Jt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt3KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt3KeyPressed

    private void Jt9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt9KeyPressed
        int codigo = evt.getKeyCode();

        if (codigo == KeyEvent.VK_ENTER) {
            ValidarCampos();
            if (aux == 1) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_Jt9KeyPressed

    private void ValidarCampos() {
        switch (Corrida) {
            case "80":
                Validar6();
                break;
            case "81":
                Validar8();
                break;
            case "82":
                Validar6();
                break;
            case "85":
                Validar8();
                break;
            case "88":
                Validar12();
                break;
            case "89":
                Validar6();
                break;
            case "90":
                Validar6();
                break;
            case "91":
                Validar8();
                break;
            case "92":
                Validar6();
                break;
            case "93":
                Validar10();
                break;
            case "94":
                Validar12();
                break;
            case "95":
                Validar10();
                break;
            case "96":
                Validar8();
                break;
            case "97":
                Validar10();
                break;
            case "98":
                Validar10();
                break;
            default:
                break;
        }
    }

    private void Agregar() {

        String Tipo = "S";
        //int Cantidad = Integer.parseInt(Pares);

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
        c13 = Integer.parseInt(Jt13.getText());
        c14 = Integer.parseInt(Jt14.getText());

        

        datos[0] = Idp;
        datos[1] = Suela;
        datos[2] = Am;
        datos[3] = Estilo;
        datos[4] = Corrida;
        datos[5] = Combinacion;
        datos[6] = Tipo;
        datos[7] = Jt1.getText();
        datos[8] = Jt2.getText();
        datos[9] = Jt3.getText();
        datos[10] = Jt4.getText();
        datos[11] = Jt5.getText();
        datos[12] = Jt6.getText();
        datos[13] = Jt7.getText();
        datos[14] = Jt8.getText();
        datos[15] = Jt9.getText();
        datos[16] = Jt10.getText();
        datos[17] = Jt11.getText();
        datos[18] = Jt12.getText();
        datos[19] = Jt13.getText();
        datos[20] = Jt14.getText();
        datos[21] = Pares;
        
        switch (Corrida) {
            case "80":
                  ValidarC6();
                break;
            case "81":
                 ValidarC8();
                break;
            case "82":
                 ValidarC6();
                break;
            case "85":
                ValidarC8();
                break;
            case "88":
                ValidarC12();
                break;
            case "89":
                ValidarC6();
                break;
            case "90":
                ValidarC6();
                break;
            case "91":
                ValidarC8();
                break;
            case "92":
                ValidarC6();
                break;
            case "93":
                ValidarC10();
                break;
            case "94":
                ValidarC12();
                break;
            case "95":
                ValidarC10();
                break;
            case "96":
                ValidarC8();
                break;
            case "97":
               ValidarC10();
                break;
            case "98":
                ValidarC10();
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
            return true;
        }
    }
    
    private boolean ValidarC12()
    {
        Cantidad = Integer.parseInt(Pares);
        if (Cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12) {
                    modelPhylon.addRow(datos);
                    aux = 1;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    Jt1.requestFocus();
                    return false;
                }
    }
    
    private boolean ValidarC10(){
        Cantidad = Integer.parseInt(Pares);
        if (Cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10) {
                    modelPhylon.addRow(datos);
                    aux = 1;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    Jt1.requestFocus();
                    return false;
                }
    }
    
    private boolean ValidarC8(){
        Cantidad = Integer.parseInt(Pares);
        if (Cantidad == c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) {
                    modelPhylon.addRow(datos);
                    aux = 1;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    Jt1.requestFocus();
                    return false;
                }
    }
    
    private boolean ValidarC6(){
        Cantidad = Integer.parseInt(Pares);
         if (Cantidad == c1 + c2 + c3 + c4 + c5 + c6) {
                    modelPhylon.addRow(datos);
                    aux = 1;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Las cantidades no coinciden");
                    Jt1.requestFocus();
                    return false;
                }
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
        Jt13.setVisible(false);
        Jt14.setVisible(false);
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
        Jb13.setVisible(false);
        Jb14.setVisible(false);
    }

    private void Jt13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt13KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jt13KeyPressed

    private void Jt14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jt14KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jt14KeyPressed

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
            java.util.logging.Logger.getLogger(PuntosPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntosPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntosPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntosPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PuntosPlaneacion dialog = new PuntosPlaneacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Jb13;
    private javax.swing.JLabel Jb14;
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
    public javax.swing.JTextField Jt13;
    public javax.swing.JTextField Jt14;
    private javax.swing.JTextField Jt2;
    private javax.swing.JTextField Jt3;
    private javax.swing.JTextField Jt4;
    private javax.swing.JTextField Jt5;
    private javax.swing.JTextField Jt6;
    private javax.swing.JTextField Jt7;
    private javax.swing.JTextField Jt8;
    private javax.swing.JTextField Jt9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
