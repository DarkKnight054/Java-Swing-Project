package checkmate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Checkmate extends JFrame implements ActionListener{
    private Container c1;
    private JLabel label1;
    private JButton btn1,btn2,btn3,btn4,btn5;
    private Font f;
    private JPanel jp;
    private CardLayout cd;
    private  ImageIcon icon,nicon;
    boolean music=true;
    Checkmate()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320,40,800,800);
        this.setTitle("");
        cd = new CardLayout(); 
        init1();
    }
    public void init1()
    {
        
        c1 = this.getContentPane();
        c1.setLayout(cd);
        f = new Font("TimesRoman",Font.ITALIC,23);
        label1 = new JLabel(new ImageIcon(getClass().getResource("cover_img.jpg")));
        label1.setBounds(0,0,800,800);
        jp = new JPanel();
        jp.setBackground(Color.pink);
        jp.setLayout(null);
        jp.add(label1);
        c1.add(jp,"0");       
        btn1 = new JButton("Start");
        btn1.setBounds(325,475,140,30);
        btn1.setFont(f);
        btn1.setForeground(Color.YELLOW);
        btn1.setBorder(new RoundedBorder(30));
        btn1.setContentAreaFilled(false);
        label1.add(btn1);
        btn2 = new JButton("Rules");
        btn2.setBounds(325,520,140,30);
        btn2.setForeground(Color.YELLOW);
        btn2.setBorder(new RoundedBorder(30));
        btn2.setContentAreaFilled(false);
        btn2.setFont(f);
        label1.add(btn2);
        btn3 = new JButton("Creator");
        btn3.setBounds(325,565,140,30);
        btn3.setForeground(Color.YELLOW);
        btn3.setBorder(new RoundedBorder(30));
        btn3.setContentAreaFilled(false);
        btn3.setFont(f);
        label1.add(btn3);
        btn4 = new JButton("Exit");
        btn4.setBounds(325,610,140,30);
        btn4.setForeground(Color.YELLOW);
        btn4.setBorder(new RoundedBorder(30));
        btn4.setContentAreaFilled(false);
        btn4.setFont(f);
        label1.add(btn4);
        btn5 = new JButton();
        btn5.setBounds(720,40,30,30);
        icon = new ImageIcon(getClass().getResource("music.png"));
        btn5.setContentAreaFilled(false);
        btn5.setIcon(icon);
        label1.add(btn5);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btn1)
        {
            swing4 frame1 = new swing4();
            frame1.in4(c1);
            cd.show(c1,"4");
        }
        else if(ae.getSource()==btn2)
        {
            swing2 frame = new swing2();
            frame.in2(c1);
            cd.show(c1,"2");
        }
        else if(ae.getSource()==btn3)
        {
          /*  swing3 frame = new swing3();
            frame.in3(c1);
            cd.show(c1,"3");
           */
        }
        else if(ae.getSource()==btn4)
        {
            System.exit(0);
        }
        else
        {
            if(music)
            {
                music=false;
                nicon = new ImageIcon(getClass().getResource("Stop-Music.png"));
                btn5.setIcon(nicon);
            }
            else
            {
                icon = new ImageIcon(getClass().getResource("music.png"));
                music=true;
                btn5.setIcon(icon);
            }
        }
        
    }
    public static void main(String[] args) {
        Checkmate newframe = new Checkmate();
        newframe.setVisible(true);
    }
}