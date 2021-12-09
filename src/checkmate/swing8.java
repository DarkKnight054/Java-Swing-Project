//bishop
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing8 implements ActionListener{
    private JPanel jp,panel;
    Container c;
    int counter =180,hugo=8,lolz=30,pre=30,ghost_x=0,ghost_y=0,life=6,pt=0;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private ImageIcon icon,icon1,icon2;
    private JLabel jl,jl1,jl2,instruction,jl3,jl4,ghost_label,point;
    Timer timer;
    int count = 0,rr,ll,rr1,ll1,rr2,ll2,ll3,rr3;
    boolean ok,got_it;
    Random rd;
    public void in8(Container c)
    {
         write_file lol = new write_file();
          pt=lol.write(2);
        this.c=c;
        panel = new JPanel();
        panel.setLayout(null);
        jl = new JLabel("Timer:180");
        jl.setBounds(25,0,120,50);
        ghost_label = new JLabel("Ghost:30");
        ghost_label.setBounds(200,0,200,50);
        point = new JLabel("PT:"+pt);
        point.setBounds(445,0,120,50);
        jp = new JPanel();
        gd = new GridLayout(8,8);
        jp.setLayout(gd);
        jp.setBounds(0,50,785,715);
        panel.add(jp);
        instruction = new JLabel();
        instruction.setBounds(0,0,785,50);
        panel.setBackground(Color.ORANGE);
        instruction.add(jl);
        instruction.add(point);
        rd = new Random();
        jl1 = new JLabel(new ImageIcon(getClass().getResource("bishop-icon.jpg")));
        jl1.setBounds(550,0,60,50);
        jl2 = new JLabel(":8");
        jl2.setBounds(612,0,50,50);
        jl3 = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        jl3.setBounds(665,0,50,50);
        jl4 = new JLabel(" : 6");
        jl4.setBounds(715,0,60,50);
        instruction.add(jl3);
        instruction.add(jl4);
        panel.add(jp);
        instruction.add(jl1);
        instruction.add(jl2);
        instruction.add(ghost_label);
        instruction.add(jl);
        panel.add(instruction);
        c.add(panel,"8");
        Font fau = new Font("Arial",Font.BOLD,27);
        Font f = new Font("TimesRoman",Font.ITALIC,25);
        jl.setFont(f);
        jl4.setFont(fau);
        ghost_label.setFont(f);
        jl2.setFont(fau);
        point.setFont(f);
        btn = new JButton[8][8];
        icon = new ImageIcon(getClass().getResource("bishop.png"));
        icon1 = new ImageIcon(getClass().getResource("coin.png"));
        icon2 = new ImageIcon(getClass().getResource("ghost.jpg"));
        for (int i = 0; i < 8; i++) {
            for (int j  = 0; j < 8; j++){
                btn[i][j] = new JButton();
                if((i+j)%2==0){
                    btn[i][j].setBackground(Color.CYAN);
                }
                else
                {
                    btn[i][j].setBackground(Color.BLUE);
                }
                btn[i][j].addActionListener(this);
                jp.add(btn[i][j]);
            }
        }
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<8;i++)
                {
                    for(int j=0;j<8;j++)
                    {
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
                        ((CardLayout) c.getLayout()).show(c,"4");
                    }
                    --life;
                    if(life<=0)
                    {
                          pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                        ghost_label.setText("Ghost:0");
                        timer.stop();
                        JOptionPane.showMessageDialog(null,"Oops! Your game is over.");
                        ((CardLayout) c.getLayout()).show(c,"4");
                    }
                    for(int i=0;i<8;i++)
                    {
                        for(int j=0;j<8;j++)
                        {
                            btn[i][j].setIcon(icon2);
                        }
                    }
                    hugo=8;
                    jl2.setText(":"+hugo);
                    ghost_label.setText("Ghost:"+lolz);
                    jl4.setText(" : "+life);
                    point.setText("PT:"+pt);
                }
                else ghost_label.setText("Ghost:"+lolz);
                if(counter%8==0)
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
                jl.setText("Timer:"+(--counter));
                if (counter <= 0) {
                      pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                    timer.stop();
                    JOptionPane.showMessageDialog(null,"Oops! Your game is over.");
                    ((CardLayout) c.getLayout()).show(c,"4");
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
        got_it=false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(btn[i][j]==src)
                {
                    if(btn[i][j].getIcon()!=icon){
                        count++;
                        ok=true;}
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
                        if(btn[i][j].getIcon()==icon1)pt+=50;
                        btn[i][j].setIcon(icon);
                        for (int k = 1; k < 8; k++) {
                            if((i-k>=0) && (j-k>=0) && btn[i-k][j-k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        for (int k = 1; k < 8; k++) {
                            if((i+k<=7) && (j+k<=7) && btn[i+k][j+k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        for (int k = 1; k < 8; k++) {
                            if((i+k<=7) && (j-k>=0) && btn[i+k][j-k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        for (int k = 1; k < 8; k++) {
                            if((i-k>=0) && (j+k<=7) && btn[i-k][j+k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        if(rr1!=1)
                        {
                            lolz=pre;
                            ghost_label.setText("Ghost:"+lolz);
                            point.setText("PT:"+pt);
                            jl2.setText(":"+(--hugo));
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
                            ((CardLayout) c.getLayout()).show(c,"4");
                        }
                        else if(count==8){
                               read_file t = new read_file();
                                 write_file t1 = new write_file();
                        if(t1.write(1)<4)
                        t.read("4",1);
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