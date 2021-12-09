//knight,bishop,rook
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing9 implements ActionListener{
    private JPanel jp,panel;
    Container c;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private ImageIcon icon,icon1,icon2;
    int counter = 110,pt=0,ghost_x=0,ghost_y=0,lolz=30,pre=30,life=6,hugo=16;
    private JLabel jl,jl1,jl2,jl3,jl4,ghost_label,point;
    Timer timer;
    Random rd;
    boolean ok,got_it;
    int count = 0,rr,ll,rr1,ll1,rr2,ll2;
    int arr1[] = {1,1,-1,-1,2,2,-2,-2};
    int arr2[] = {-2,2,-2,2,1,-1,1,-1};
    public void in9(Container c)
    { 
        write_file lol = new write_file();
          pt=lol.write(2);
        this.c=c;
        panel = new JPanel();
        rd = new Random();
        panel.setLayout(null);
        jl = new JLabel("Timer:110");
        jl.setBounds(25,0,120,50);
        jp = new JPanel();
        gd = new GridLayout(8,8);
        jp.setLayout(gd);
        jp.setBounds(0,50,785,715);
        panel.add(jp);
        c.add(panel,"9");
        jl1 = new JLabel(new ImageIcon(getClass().getResource("knight-icon.jpg")));
        jl1.setBounds(500,0,50,50);
        jl2 = new JLabel(" :16");
        jl2.setBounds(550,0,50,50);
        jl3 = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        jl3.setBounds(620,0,50,50);
        jl4 = new JLabel(" :6");
        jl4.setBounds(670,0,50,50);
        ghost_label = new JLabel("Ghost:30");
        ghost_label.setBounds(150,0,100,50);
        point = new JLabel("PT:"+pt);
        point.setBounds(270,0,100,50);
        panel.add(point);
        panel.add(ghost_label);
        panel.add(jl4);
        panel.add(jl3);
        panel.add(jl2);
        panel.add(jl1);
        panel.add(jl);
        panel.setBackground(Color.ORANGE);
        Font f = new Font("TimesRoman",Font.ITALIC,22);
        jl.setFont(f);
        jl2.setFont(f);
        jl4.setFont(f);
        ghost_label.setFont(f);
        point.setFont(f);
        btn = new JButton[8][8];
        icon = new ImageIcon(getClass().getResource("knight.png"));
        icon1 = new ImageIcon(getClass().getResource("coin.png"));
        icon2 = new ImageIcon(getClass().getResource("ghost.jpg"));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                btn[i][j] = new JButton();
                if((i+j)%2==0)
                {
                    btn[i][j].setBackground(Color.BLUE);
                }
                else
                {
                    btn[i][j].setBackground(Color.CYAN);
                }
                jp.add(btn[i][j]);
                btn[i][j].addActionListener(this);
            }
        }
        btn[2][2].setIcon(icon);
        count++;
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<8;i++)
                {
                    for(int j=0;j<8;j++)
                    {
                        if(i==2&&j==2)continue;
                        if(btn[i][j].getIcon()==icon2)btn[i][j].setIcon(null);
                    }
                }
                --lolz;
                if(lolz<=0)
                {
                    count=0;
                     if(pt>0)
                         pt-=50;
                    if(pre==30){lolz=20;pre=20;}
                    else if(pre==20){lolz=15;pre=15;}
                    else if(pre==15){lolz=10;pre=10;}
                    else if(pre==10){lolz=5;pre=5;}
                    else
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
                    --life;
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
                    jl4.setText(" :"+life);
                    ghost_label.setText("Ghost:"+lolz);
                    jl2.setText(" :"+hugo);
                    point.setText("PT:"+pt);
                    for(int i=0;i<8;i++)
                    {
                        for(int j=0;j<8;j++)
                        {
                            if(i==2&&j==2)continue;
                            btn[i][j].setIcon(icon2);
                        }
                    }
                }
                else ghost_label.setText("Ghost:"+lolz);
                jl.setText("Timer:"+(--counter));
                if(counter%10==0)
                {
                    if(btn[ghost_x][ghost_y].getIcon()==icon1)btn[ghost_x][ghost_y].setIcon(null);
                    ghost_x=rd.nextInt(8);
                    ghost_y=rd.nextInt(8);
                    while(btn[ghost_x][ghost_y].getIcon()==icon)
                    {
                        ghost_x=rd.nextInt(8);
                        ghost_y=rd.nextInt(8);
                    }
                    btn[ghost_x][ghost_y].setIcon(icon1);
                }
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
        ok=false;got_it=false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(btn[i][j]==src)
                {
                    if(btn[i][j].getIcon()!=icon) {
                        count++;
                        ok = true;
                    }
                    break;
                }
            }
        }
        if(ok)
        {
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if(btn[i][j]==src)
                    {
                        rr1=0;
                        if(btn[i][j].getIcon()==icon1)got_it=true;
                        btn[i][j].setIcon(icon);
                        for (int k = 0; k < 8; k++){
                            rr=arr1[k]+i;
                            ll=arr2[k]+j;
                            if(rr>=0 && rr<8 && ll>=0 && ll<8 && btn[rr][ll].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        if(rr1!=1)
                        {
                            hugo--;
                            if(got_it)pt+=50;
                            point.setText("PT:"+pt);
                            lolz=pre;
                            ghost_label.setText("Ghost:"+lolz);
                            jl2.setText(" :"+hugo);
                        }
                        if(rr1==1){
                            pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                            timer.stop();
                            btn[i][j].setIcon(null);
                            btn[i][j].setBackground(Color.red);
                            JOptionPane.showMessageDialog(null,"OOps!Your game is over.");
                            ((CardLayout)c.getLayout()).show(c,"4");
                        }
                        else if(count==16){
                               read_file t = new read_file();
                                 write_file t1 = new write_file();
                        if(t1.write(1)<5)
                        t.read("5",1);
                        t.read(Integer.toString(pt),2);
                            timer.stop();
                            btn[i][j].setIcon(null);
                            btn[i][j].setBackground(Color.green);
                            JOptionPane.showMessageDialog(null,"Congratulation,your level is complete");
                              swing4 frame = new swing4();
                        frame.in4(c);
                        ((CardLayout)c.getLayout()).show(c,"4");
                        }
                    }
                }
            }
        }
    }
}