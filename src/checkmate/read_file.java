package checkmate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class    read_file {
    public void read(String s,int cnt)
    {
        try {
            if(cnt==1){BufferedWriter writer = new BufferedWriter(new FileWriter("level.txt"));
            writer.write(s);
            writer.close();}
            else if(cnt==2){BufferedWriter writer = new BufferedWriter(new FileWriter("Point.txt"));
                writer.write(s);
                writer.close();}
            else if(cnt==3){BufferedWriter writer = new BufferedWriter(new FileWriter("life.txt"));
                writer.write(s);
                writer.close();}
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}