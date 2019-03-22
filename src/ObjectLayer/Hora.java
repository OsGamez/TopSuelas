package ObjectLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Hora extends Thread {

    private JLabel JbHora;
    private JLabel JbFecha;

    public Hora(JLabel JbHora, JLabel JbFecha) {
        this.JbHora = JbHora;
        this.JbFecha = JbFecha;
    }

    @Override
    public void run() {
        while (true) {
            Date hoy = new Date();
            DateFormat dm = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sm = new SimpleDateFormat("HH:mm:ss");
            JbHora.setText(sm.format(hoy));
            JbFecha.setText(dm.format(hoy));
            try {
                sleep(1000);
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }
}
