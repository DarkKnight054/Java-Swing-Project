package checkmate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class write_file {
    public int write(int cnt)
    {
        BufferedReader read = null;
        int ans=0;
        try{
            if(cnt==1)
            {
                read = new BufferedReader(new FileReader("level.txt"));
                String s= read.readLine();
               //  System.out.println(s);
                ans=Integer.parseInt(s);
            }
            else if(cnt==2)
            {
                read = new BufferedReader(new FileReader("Point.txt"));
                String s= read.readLine();
                ans=Integer.parseInt(s);
            }
            else if(cnt==3)
            {
                read = new BufferedReader(new FileReader("life.txt"));
                String s= read.readLine();
                ans=Integer.parseInt(s);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    //    System.out.println(ans);
        return ans;
    }
}
