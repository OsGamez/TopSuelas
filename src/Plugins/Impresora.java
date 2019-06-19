/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plugins;

/**
 *
 * @author GATEWAY1-
 */
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

/**
 * ******************************************************************
 *
 * La siguiente clase llamada "Impresora", es la encargada de *
 *
 * establecer la fuente con que se va a imprimir, de obtener el	*
 *
 * trabajo de impresion, la página. En esta clase hay un método	*
 *
 * llamado imprimir, el cual recibe una cadena y la imprime.	*
 *
 *******************************************************************
 */

class Impresora {

    Font fuente = new Font("Dialog", Font.PLAIN, 10);

    PrintJob pj;

    Graphics pagina;

    /**
     * ******************************************************************
     *
     * A continuación el constructor de la clase. Aquí lo único que	*
     *
     * hago es tomar un objeto de impresion.	*
     *
     *******************************************************************
     */

    Impresora() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    }

    /**
     * ******************************************************************
     *
     * A continuación el método "imprimir(String)", el encargado de *
     *
     * colocar en el objeto gráfico la cadena que se le pasa como *
     *
     * parámetro y se imprime.	*
     *
     *******************************************************************
     */
    public void imprimir(String Cadena) {
        //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);
            pagina.drawString(Cadena, 60, 60);
            pagina.dispose();
            pj.end();

        } catch (Exception e) {

            System.out.println("LA IMPRESION HA SIDO CANCELADA...");

        }

    }//FIN DEL PROCEDIMIENTO imprimir(String...)

}//FIN DE LA CLASE Impresora

//A CONTINUACION LA CLASE PRINCIPAL

