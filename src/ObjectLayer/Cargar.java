package ObjectLayer;

import javax.swing.JProgressBar;

public final class Cargar extends Thread {

    JProgressBar progreso;

    public Cargar(JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            progreso.setValue(i);
            Pausa(35);
        }
    }

    public void Pausa(int mlSe) {
        try {
            Thread.sleep(mlSe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
