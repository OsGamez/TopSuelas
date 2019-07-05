
package Plugins;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class Sound {
    
    
    
    public void play(){
        try {
         Clip sonido = AudioSystem.getClip();
         File a = new File("C:\\tsmanager\\sounds\\audio.wav");
         sonido.open(AudioSystem.getAudioInputStream(a));
         sonido.start();
         Thread.sleep(4000); // 4000 milisegundos (4 segundos)
         sonido.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }
}
