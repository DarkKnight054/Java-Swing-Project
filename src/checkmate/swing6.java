//rock
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing6 implements ActionListener{
    private JPanel jp,panel,instruction;
    Container c;
    int counter = 120,hp=8,life=8,lolz=40,pre=40,pt=0;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private ImageIcon icon,icon1,icon2;
    private JLabel devil,jl,jl1,img,jl2,img2,jl3;
    Timer timer;
    boolean ok,got_it;
    int count = 0,rr,ll,rr1,ll1,rr2,ll2;
    int ghost_x,ghost_y;
    Random rd;
    public void in6(Container c)
    {
         write_file lol = new write_file();
          pt=lol.write(2);
        this.c=c;
        panel = new JPanel();
        panel.setLayout(null);
        devil = new JLabel("Ghost:40");
        devil.setBounds(200,0,120,50);
        jl = new JLabel("Timer:120");
        jl.setBounds(50,0,120,50);
        jp = new JPanel();
        gd = new GridLayout(8,8);
        jp.setLayout(gd);
        jp.setBounds(0,50,785,715);
        instruction = new JPanel();
        instruction.setLayout(null);
        instruction.setBounds(0,0,785,50);
        instruction.setBackground(Color.ORANGE);
        instruction.add(jl);
        instruction.add(devil);
        img = new JLabel(new ImageIcon(getClass().getResource("rook-icon.jpg")));
        img2 = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        img.setBounds(400,0,60,50);
        instruction.add(img);
        jl1 = new JLabel(": 8");
        jl1.setBounds(460,0,100,60);
        img2.setBounds(565,0,60,50);
        jl2 = new JLabel(": 8");
        jl2.setBounds(625,0,50,60);
        jl3 = new JLabel("PT:"+pt);
        jl3.setBounds(675,0,110,50);
        Font fau = new Font("Arial",Font.BOLD,25);
        jl1.setFont(fau);
        jl2.setFont(fau);
        instruction.add(jl3);
        instruction.add(jl1);
        instruction.add(img2);
        instruction.add(jl2);
        panel.add(jp);
        panel.add(instruction);
        c.add(panel,"6");
        Font f = new Font("TimesRoman",Font.ITALIC,22);
        jl.setFont(f);
        jl3.setFont(f);
        devil.setFont(f);
        btn = new JButton[8][8];
        icon = new ImageIcon(getClass().getResource("rock.jpg"));
        icon1 = new ImageIcon(getClass().getResource("coin.png"));
        icon2 = new ImageIcon(getClass().getResource("ghost.jpg"));
        rd = new Random();
        ghost_x=rd.nextInt(8);
        ghost_y=rd.nextInt(8);
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
                    jl2.setText(": "+(--life));
                     count=0;
                     if(pt>0)
                         pt-=50;
                    if (life <= 0)
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
                    if(pre==40)
                    {
                        lolz=30;pre=30;
                    }
                    else if(pre==30)
                    {
                        lolz=20;pre=20;
                    }
                    else if(pre==20)
                    {
                        lolz=15;pre=15;
                    }
                    else if(pre==15)
                    {
                        lolz=10;pre=10;
                    }
                    else if(pre==10)
                    {
                        lolz=5;pre=5;
                    }
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
                            btn[i][j].setIcon(icon2);
                        }
                    }
                    hp=8;
                    jl1.setText(": "+hp);
                    jl3.setText("PT:"+pt);
                    devil.setText("Ghost:"+lolz);
                }
                else devil.setText("Ghost:"+lolz);
                if((counter%5)==0)
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
        ok=false;got_it=false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(btn[i][j]==src)
                {
                    if(btn[i][j].getIcon()!=icon)
                    {
                        count++;
                        ok=true;
                        if(btn[i][j].getIcon()==icon1)got_it=true;
                    }
                    break;
                }
            }
        }
        if(ok)
        {
            hp--;
            lolz=pre;
            devil.setText("Ghost:"+lolz);
        }
        jl1.setText(": "+hp);
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(btn[i][j]==src)
                {
                    rr1=0;
                    btn[i][j].setIcon(icon);
                    for (int k = 0; k < 8; k++) {
                        if(k!=i && (btn[k][j].getIcon()==icon||btn[i][j].getIcon()==icon1))
                        {
                            rr1=1;
                        }
                        if(k!=j && btn[i][k].getIcon()==icon)
                        {
                            rr1=1;
                        }
                    }
                    if(rr1!=1){if(got_it)pt+=50;jl3.setText("PT:"+pt);}
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
                        if(t1.write(1)<1)
                        t.read("1",1);
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