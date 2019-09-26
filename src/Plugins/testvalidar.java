/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plugins;

import ObjectLayer.Validacion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GATEWAY1-
 */
public class testvalidar {
    public static void main(String [] ar){
//        Validacion v = new Validacion();
//        System.out.println(v.verificanumeros("3"));
testvalidar t = new testvalidar();

        System.out.println(t.verificanumeros("//"));
    }
    public boolean verificanumeros(String cad) {
        boolean resp = false;
        String patt = "[0-9A-Za-z/-]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (!match.matches()) {
            resp = true;
        }
        return resp;
    }
}
    
