package checkmate;
import javax.swing.*;
import java.awt.*;
public class swing2{
    private JTextField jt;
    private JLabel jl,jl1;
    private JPanel jp;
    private JButton jb;
    private Font f;
    public void in2(Container c)
    {
        jp = new JPanel();
        jp.setLayout(null);
         f = new Font("TimesRoman",Font.ITALIC,23);
        c.add(jp,"2");
        jl = new JLabel();
        jl.setBounds(0,0,800,800);
        jp.add(jl);
        jl1 = new JLabel("<html>This game is all about placing chess-pieces in right boxes. You have to gain coin by placing them. We've shown icons of chess pieces and a number of those chess pieces you have to place on the chessboard. </html>");
        jl1.setBounds(30,200,700,200);
        jl1.setFont(new Font("TimesRoman",Font.ITALIC,22));
        jl1.setForeground(Color.MAGENTA);
        jl.add(jl1);
        jb = new JButton("Back");
        jb.setBounds(325,675,140,30);
        jb.setFont(f);
        jb.setForeground(Color.BLUE);
        jb.setBorder(new RoundedBorder(30));
        jb.setContentAreaFilled(false);
        jl.add(jb);
        jb.addActionListener(e -> {
            ((CardLayout)c.getLayout()).show(c,"0");
        });
    }
}