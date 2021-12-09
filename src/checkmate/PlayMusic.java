package checkmate;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlayMusic {
    public void playmusic(String filepath,boolean ok)
    {
        File musicpath = new File(filepath);
        try
        {
            if(musicpath.exists())
            {
                AudioInputStream audioInput;
                audioInput = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}