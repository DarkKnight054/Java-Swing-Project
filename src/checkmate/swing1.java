//knight
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing1 implements ActionListener{
    private JPanel instruction,jp,panel;
    Container c;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private ImageIcon icon,icon1,icon2;
    int l,r,counter = 150,hop=16,life=8,lolz=35,pre=35,pt=0;
    private JLabel jl,imglabel,jl1,img,jl2,jl3,devil;
    Timer timer;
    boolean ok;
    Random rd;
    int count = 0,rr,ll,rr1,ll1,rr2,ll2;
    int coin_x=5,coin_y=3;
    int arr1[] = {1,1,-1,-1,2,2,-2,-2};
    int arr2[] = {-2,2,-2,2,1,-1,1,-1};
    public void in1(Container c)
    {
          write_file lol = new write_file();
          pt=lol.write(2);
        this.c=c;
        panel = new JPanel();
        panel.setLayout(null);
        rd = new Random();
        jl = new JLabel("Timer:150");
        jl.setBounds(40,0,120,50);
         jl.setBackground(Color.BLACK);
        jl2 = new JLabel("Ghost:35");
        jl1 = new JLabel(" : 16");
        jl3 = new JLabel(" : 8");
        devil = new JLabel("PT:"+pt);
      
        jl2.setBounds(180,0,120,50);
       
        jp = new JPanel();
        instruction = new JPanel();
        gd = new GridLayout(8,8);
        jp.setLayout(gd);
        jp.setBounds(0,50,785,737);
        instruction.setLayout(null);
        instruction.setBounds(0,0,785,50);
        instruction.setBackground(Color.ORANGE);
        panel.add(instruction);
        panel.add(jp);
        c.add(panel,"1");
        instruction.add(jl);
        Font f = new Font("TimesRoan",Font.ITALIC,25);
        Font fau = new Font("Arial",Font.BOLD,25);
        jl.setFont(f);
        jl1.setFont(fau);
        jl2.setFont(f);
        instruction.add(jl2);
        btn = new JButton[8][8];
        icon = new ImageIcon(getClass().getResource("knight.png"));
        icon1 = new ImageIcon(getClass().getResource("ghost.jpg"));
        icon2 = new ImageIcon(getClass().getResource("coin.png"));
        jl1.setBounds(390,0,50,50);
        imglabel = new JLabel(new ImageIcon(getClass().getResource("knight-icon.jpg")));
        img = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        imglabel.setBounds(340,0,50,50);
        img.setBounds(450,0,50,50);
        jl3.setBounds(500,0,50,50);
        devil.setBounds(555,0,100,50);
        devil.setFont(f);
        jl3.setFont(fau);
        instruction.add(devil);
        instruction.add(img);
        instruction.add(jl3);
        instruction.add(imglabel);
        instruction.add(jl1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                btn[i][j] = new JButton();
                if((i+j)%2==0){
                    btn[i][j].setBackground(Color.CYAN);
                }
                else
                {
                    btn[i][j].setBackground(Color.BLUE);
                }
                jp.add(btn[i][j]);
                btn[i][j].addActionListener(this);
            }
        }
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<8;i++)
                {
                    for(int j=0;j<8;j++)
                    {
                        if(btn[i][j].getIcon()==icon1)btn[i][j].setIcon(null);
                    }
                }
                --lolz;
                if(lolz<=0)
                {
                      count=0;
                     if(pt>0)
                         pt-=50;
                     devil.setText("PT:"+pt);
                    if(pre==35){lolz=25;pre=25;}
                    else if(pre==25){lolz=15;pre=15;}
                    else if(pre==15){lolz=10;pre=10;}
                    else if(pre==10){lolz=5;pre=5;}
                    else
                    {
                          pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                        jl2.setText("Ghost:0");
                        timer.stop();
                        JOptionPane.showMessageDialog(null,"Oops! Your game is over.");
                        ((CardLayout)c.getLayout()).show(c,"4");
                    }
                    for(int i=0;i<8;i++)
                    {
                        for(int j=0;j<8;j++)
                        {
                            if(btn[i][j].getIcon()==icon)
                            {
                                hop++;
                                btn[i][j].setIcon(null);
                            }
                        }
                    }
                    life--;
                    jl3.setText(" : "+life);
                    jl1.setText(" : "+hop);
                    jl2.setText("Ghost:"+lolz);
                    if(life<=0)
                    {
                          pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                        timer.stop();
                        JOptionPane.showMessageDialog(null,"Oops! Your game is over.");
                        ((CardLayout)c.getLayout()).show(c,"4");
                    }
                    for(int i=0;i<8;i++)
                    {
                        for(int j=0;j<8;j++)
                        {
                            btn[i][j].setIcon(icon1);
                        }
                    }
                }
                else jl2.setText("Ghost:"+lolz);
                if(counter%7==0)
                {
                    if(btn[coin_x][coin_y].getIcon()==icon2)btn[coin_x][coin_y].setIcon(null);
                    while(btn[coin_x][coin_y].getIcon()==icon)
                    {
                        coin_x = rd.nextInt(8);
                        coin_y = rd.nextInt(8);
                    }
                    btn[coin_x][coin_y].setIcon(icon2);
                }
                jl.setText("Timer:"+(--counter));
                if (counter <= 0) {
                      pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                    timer.stop();
                    JOptionPane.showMessageDialog(null,"Oops! Your game is over.");
                    ((CardLayout)c.getLayout()).show(c,"4");
                }
            }
        };
        timer = new Timer(1000, a);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        Object src = ae.getSource();
        ok=false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(btn[i][j]==src)
                {
                    if(btn[i][j].getIcon()!=icon)
                    {
                        count++;
                        ok=true;
                    }
                    break;
                }
            }
        }
        if(ok) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (btn[i][j] == src) {
                        rr1 = 0;
                        if(btn[i][j].getIcon()==icon2)pt+=50;
                        btn[i][j].setIcon(icon);
                        for (int k = 0; k < 8; k++) {
                            rr = arr1[k] + i;
                            ll = arr2[k] + j;
                            if (rr >= 0 && rr < 8 && ll >= 0 && ll < 8 && btn[rr][ll].getIcon() == icon) {
                                rr1 = 1;
                            }
                        }
                        if (rr1 == 1) {
                            pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                            timer.stop();
                            btn[i][j].setIcon(null);
                            btn[i][j].setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "OOps!Your game is over.");
                            ((CardLayout) c.getLayout()).show(c, "4");
                        } else if (count == 16) {
                            read_file t = new read_file();
                              write_file t1 = new write_file();
                        if(t1.write(1)<2)
                            t.read("2",1);
                        t.read(Integer.toString(pt),2);
                            timer.stop();
                            btn[i][j].setIcon(null);
                            btn[i][j].setBackground(Color.green);
                            JOptionPane.showMessageDialog(null, "Congratulation,your level is complete");
                            swing4 frame = new swing4();
                        frame.in4(c);
                        ((CardLayout)c.getLayout()).show(c,"4");
                        } else{
                            lolz=pre;
                            jl2.setText("Ghost:"+lolz);
                            jl1.setText(": "+(--hop));
                            devil.setText("PT:"+pt);
                        }
                    }
                }
            }
        }
    }
}