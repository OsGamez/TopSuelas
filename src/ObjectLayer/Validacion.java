/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GATEWAY1-
 */
public class Validacion {

    public boolean verificanumeros(String cad) {
        boolean resp = false;
        String patt = "[0-9]+[0-9]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    public boolean verificapunto(String cad) {
        boolean resp = false;
        String patt = "[0-9]+[0-9]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            if (Integer.parseInt(cad) > 14 && Integer.parseInt(cad) < 33) {
                resp = true;
            }
        }
        return resp;
    }
}
