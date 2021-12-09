//queen
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing7 implements ActionListener{
    private JPanel jp,panel;
    Container c;
    int counter = 120,hugo=7,lolz=35,pre=35,life=7,pt=0,ghost_x=0,ghost_y=0;
    private JLabel jl,jl1,jl2,instruction,ghost_label,life_img,life_label,point;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private ImageIcon icon,icon1,icon2;
    Timer timer;
    Random rd;
    int count = 0,rr,ll,rr1,ll1,rr2,ll2;
    boolean ok,got_it;
    public void in7(Container c)
    {
         write_file lol = new write_file();
          pt=lol.write(2);
        this.c=c;
        panel = new JPanel();
        panel.setLayout(null);
        jl = new JLabel("Timer:120");//timer
        jl.setBounds(5,0,120,50);//timer
        ghost_label = new JLabel("Ghost:35");
        ghost_label.setBounds(130,0,120,50);
        jp = new JPanel();//Boxes
        gd = new GridLayout(8,8);
        jp.setLayout(gd);//Boxes
        jp.setBounds(0,50,785,715);//Boxes
        instruction = new JLabel();//Upper-part
        instruction.setLayout(null);
        panel.setBackground(Color.ORANGE);
        instruction.setBounds(0,0,785,50);
        instruction.add(jl);
        instruction.add(ghost_label);
        jl1 = new JLabel(new ImageIcon(getClass().getResource("queen-icon.jpg")));//queen-image
        jl1.setBounds(310,0,50,50);
        jl2 = new JLabel(":7");
        jl2.setBounds(360,0,50,50);//queen-number
        life_img = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        life_img.setBounds(420,0,50,50);
        life_label = new JLabel(":"+life);
        life_label.setBounds(470,0,50,50);
        point = new JLabel("PT:"+pt);
        point.setBounds(535,0,200,50);
        instruction.add(point);
        instruction.add(life_label);
        instruction.add(life_img);
        panel.add(jp);
        instruction.add(jl1);
        instruction.add(jl2);
        panel.add(instruction);
        Font fau = new Font("Arial",Font.BOLD,30);
        Font f = new Font("TimesRoman",Font.ITALIC,25);
        life_label.setFont(fau);
        point.setFont(f);
        ghost_label.setFont(f);
        jl.setFont(f);
        jl2.setFont(fau);
        rd = new Random();
        c.add(panel,"7");
        btn = new JButton[8][8];
        icon = new ImageIcon(getClass().getResource("queen.jpg"));
        icon1 = new ImageIcon(getClass().getResource("coin.png"));
        icon2 = new ImageIcon(getClass().getResource("ghost.jpg"));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                btn[i][j] = new JButton();
                if((i+j)%2==0){
                    btn[i][j].setBackground(Color.BLUE);
                }
                else
                {
                    btn[i][j].setBackground(Color.CYAN);
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
                        timer.stop();
                        JOptionPane.showMessageDialog(null,"Oops! Your game is over.");
                        ((CardLayout) c.getLayout()).show(c,"4");
                    }
                    for(int i=0;i<8;i++)
                    {
                        for(int j=0;j<8;j++)
                        {
                            btn[i][j].setIcon(null);
                        }
                    }
                    life--;
                    if(life<=0)
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
                    for(int i=0;i<8;i++)
                    {
                        for(int j=0;j<8;j++)
                        {
                            btn[i][j].setIcon(icon2);
                        }
                    }
                    life_label.setText(":"+life);
                    ghost_label.setText("Ghost:"+lolz);
                     point.setText("PT:"+pt);
                    jl2.setText(":7");
                }
                else ghost_label.setText("Ghost:"+lolz);
                if(counter%7==0)
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
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        ok=false;
        got_it=false;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if(btn[i][j]==src)
                {
                    if(btn[i][j].getIcon()!=icon){ok=true;
                        count++;}
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
                        for (int k = 0; k < 8; k++) {
                            if(k!=i && btn[k][j].getIcon()==icon)
                            {
                                rr1=1;
                            }
                            if(k!=j && btn[i][k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        for (int k = 1; k < 8; k++) {
                            if((i-k>=0) && (j-k>=0) && btn[i-k][j-k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                            if((i+k<=7) && (j+k<=7) && btn[i+k][j+k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                            if((i+k<=7) && (j-k>=0) && btn[i+k][j-k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                            if((i-k>=0) && (j+k<=7) && btn[i-k][j+k].getIcon()==icon)
                            {
                                rr1=1;
                            }
                        }
                        if(rr1!=1)
                        {
                            lolz=pre;
                            ghost_label.setText("Ghost:"+pre);
                            if(got_it)pt+=50;
                            System.out.println("Point: "+pt);
                            point.setText("PT:"+pt);
                            hugo--;
                            jl2.setText(":"+hugo);
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
                        else if(count==7){
                             read_file t = new read_file();
                               write_file t1 = new write_file();
                        if(t1.write(1)<3)
                             t.read("3",1);
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