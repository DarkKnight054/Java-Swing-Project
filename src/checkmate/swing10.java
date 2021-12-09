//rock and 2nd division
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing10 implements ActionListener {
    private JPanel jp, panel;
    Container c;
    int counter = 100, rock = 0, queen = 0, knight = 0;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private JLabel jl, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10;
    private ImageIcon icon1, icon2, rook_img, knight_img, queen_img;
    Timer timer;
    int ghost_x = 0, ghost_y = 0, count = 0, pt = 0, rr, ll, rr1, ll1, rr2, ll2, lolz = 20, pre = 20, life = 6;
    boolean ok, got_it, x, y, z;
    int arr1[] = {1, 1, -1, -1, 2, 2, -2, -2};
    int arr2[] = {-2, 2, -2, 2, 1, -1, 1, -1};
    Random rd;

    public void in10(Container c) {
         write_file lol = new write_file();
          pt=lol.write(2);
        this.c = c;
        panel = new JPanel();
        panel.setLayout(null);
        rd = new Random();
        jl = new JLabel("Timer:100");
        jl.setBounds(10, 0, 120, 50);
        jl1 = new JLabel("Ghost:20");
        jl1.setBounds(135, 0, 120, 50);
        jl2 = new JLabel("PT:"+pt);
        jl2.setBounds(260, 0, 120, 50);
        jl3 = new JLabel(new ImageIcon(getClass().getResource("rook-icon.jpg")));
        jl3.setBounds(400, 0, 50, 50);
        jl4 = new JLabel(" :2");
        jl4.setBounds(450, 0, 40, 50);
        jl5 = new JLabel(new ImageIcon(getClass().getResource("queen-icon.jpg")));
        jl5.setBounds(500, 0, 50, 50);
        jl6 = new JLabel(" :2");
        jl6.setBounds(550, 0, 40, 50);
        jl7 = new JLabel(new ImageIcon(getClass().getResource("knight-icon.jpg")));
        jl7.setBounds(600, 0, 50, 50);
        jl8 = new JLabel(" :2");
        jl8.setBounds(650, 0, 40, 50);
        jl9 = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        jl9.setBounds(700, 0, 50, 50);
        jl10 = new JLabel(" :6");
        jl10.setBounds(750, 0, 35, 50);
        jp = new JPanel();
        gd = new GridLayout(8, 8);
        jp.setLayout(gd);
        jp.setBounds(0, 50, 785, 715);
        panel.add(jp);
        c.add(panel, "10");
        Font f = new Font("TimesRoman", Font.ITALIC, 25);
        jl.setFont(f);
        jl1.setFont(f);
        jl2.setFont(f);
        jl4.setFont(f);
        jl6.setFont(f);
        jl8.setFont(f);
        jl10.setFont(f);
        panel.add(jl1);
        panel.add(jl2);
        panel.add(jl);
        panel.add(jl3);
        panel.add(jl4);
        panel.add(jl5);
        panel.add(jl6);
        panel.add(jl7);
        panel.add(jl8);
        panel.add(jl9);
        panel.add(jl10);
        panel.setBackground(Color.ORANGE);
        btn = new JButton[8][8];
        icon1 = new ImageIcon(getClass().getResource("coin.png"));
        icon2 = new ImageIcon(getClass().getResource("ghost.jpg"));
        queen_img = new ImageIcon(getClass().getResource("queen.jpg"));
        rook_img = new ImageIcon(getClass().getResource("rock.jpg"));
        knight_img = new ImageIcon(getClass().getResource("knight.png"));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                btn[i][j] = new JButton();
                if ((i + j) % 2 == 0) {
                    btn[i][j].setBackground(Color.CYAN);
                } else {
                    btn[i][j].setBackground(Color.BLUE);
                }
                btn[i][j].addActionListener(this);
                jp.add(btn[i][j]);
            }
        }
        btn[2][2].setIcon(rook_img);
        count++;
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (btn[i][j].getIcon() == icon2) btn[i][j].setIcon(null);
                    }
                }
                --lolz;
                if (lolz <= 0) {
                     count=0;
                     if(pt>0)
                         pt-=50;
                    if (pre == 20) {
                        lolz = 15;
                        pre = 15;
                    } else if (pre == 15) {
                        lolz = 10;
                        pre = 10;
                    } else if (pre == 10) {
                        lolz = 5;
                        pre = 5;
                    } else {
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "Oops! Your game is over.");
                        ((CardLayout) c.getLayout()).show(c, "4");
                    }
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (i == 2 && j == 2) continue;
                            btn[i][j].setIcon(icon2);
                        }
                    }
                    --life;
                    if (life <= 0) {
                          pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "Oops! Your game is over.");
                        ((CardLayout) c.getLayout()).show(c, "4");
                    }
                    rock = 0;
                    queen = 0;
                    knight = 0;
                    jl4.setText(" :2");
                    jl6.setText(" :2");
                    jl8.setText(" :2");
                    jl1.setText("Ghost:" + lolz);
                    jl10.setText(" :" + life);
                    jl2.setText("PT:"+pt);
                } else jl1.setText("Ghost:" + lolz);
                jl.setText("Timer:" + (--counter));
                if (counter % 9 == 0) {
                    if (btn[ghost_x][ghost_y].getIcon() == icon1) btn[ghost_x][ghost_y].setIcon(null);
                    ghost_x = rd.nextInt(8);
                    ghost_y = rd.nextInt(8);
                    while ((btn[ghost_x][ghost_y].getIcon() == queen_img || btn[ghost_x][ghost_y].getIcon() == knight_img || btn[ghost_x][ghost_y].getIcon() == rook_img)) {
                        ghost_x = rd.nextInt(8);
                        ghost_y = rd.nextInt(8);
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
                    JOptionPane.showMessageDialog(null, "Oops! Your game is over.");
                    ((CardLayout) c.getLayout()).show(c, "4");
                }
            }
        };
        timer = new Timer(1000, a);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ok = false;
        got_it = false;
        x = false;
        y = false;
        z = false;
        Object src = ae.getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (btn[i][j] == src) {
                    ll1 = i;
                    ll2 = j;
                    if (rock == 2 && queen == 2 && (btn[i][j].getIcon() == null || btn[i][j].getIcon() == icon1)) {
                        ok = true;
                        z = true;
                        knight++;
                    } else if (rock == 2 && (btn[i][j].getIcon() == null || btn[i][j].getIcon() == icon1)) {
                        y = true;
                        ok = true;
                        queen++;
                    } else if ((btn[i][j].getIcon() == null || btn[i][j].getIcon() == icon1)) {
                        x = true;
                        ok = true;
                        rock++;
                    }
                    break;
                }
            }
        }
        if (ok) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (btn[i][j] == src) {
                        if (btn[i][j].getIcon() == icon1) got_it = true;
                        if (x) {
                            btn[i][j].setIcon(rook_img);
                        } else if (y) {
                            btn[i][j].setIcon(queen_img);
                        } else if (z) {
                            btn[i][j].setIcon(knight_img);
                        }
                    }
                }
            }
            rr1 = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (btn[i][j].getIcon() == knight_img) {
                        for (int k = 0; k < 8; k++) {
                            rr = arr1[k] + i;
                            ll = arr2[k] + j;
                            if (rr >= 0 && rr < 8 && ll >= 0 && ll < 8 && (btn[ll][rr].getIcon() == queen_img || btn[ll][rr].getIcon() == rook_img || btn[ll][rr].getIcon() == knight_img)) {
                                rr1 = 1;
                            }
                        }
                    } else if (btn[i][j].getIcon() == queen_img) {
                        for (int k = 0; k < 8; k++) {
                            if (k != i && (btn[k][j].getIcon() == queen_img || btn[k][j].getIcon() == knight_img || btn[k][j].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                            if (k != j && (btn[i][k].getIcon() == queen_img || btn[i][k].getIcon() == knight_img || btn[i][k].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                        }
                        for (int k = 1; k < 8; k++) {
                            if ((i - k >= 0) && (j - k >= 0) && (btn[i - k][j - k].getIcon() == queen_img || btn[i - k][j - k].getIcon() == knight_img || btn[i - k][j - k].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                            if ((i + k <= 7) && (j + k <= 7) && (btn[i + k][j + k].getIcon() == queen_img || btn[i + k][j + k].getIcon() == knight_img || btn[i + k][j + k].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                            if ((i + k <= 7) && (j - k >= 0) && (btn[i + k][j - k].getIcon() == queen_img || btn[i + k][j - k].getIcon() == knight_img || btn[i + k][j - k].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                            if ((i - k >= 0) && (j + k <= 7) && (btn[i - k][j + k].getIcon() == queen_img || btn[i - k][j + k].getIcon() == knight_img || btn[i - k][j + k].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                        }
                    } else if (btn[i][j].getIcon() == rook_img) {
                        for (int k = 0; k < 8; k++) {
                            if (k != i && (btn[k][j].getIcon() == queen_img || btn[k][j].getIcon() == knight_img || btn[k][j].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                            if (k != j && (btn[i][k].getIcon() == queen_img || btn[i][k].getIcon() == knight_img || btn[i][k].getIcon() == rook_img)) {
                                rr1 = 1;
                            }
                        }
                    }
                }
            }
            if (rr1 != 1) {
                lolz = pre;
                jl1.setText("Ghost:" + lolz);
                if (got_it) pt += 50;
                jl2.setText("PT:" + pt);
                if (x) jl4.setText(" :" + (2 - rock));
                else if (y) jl6.setText(" :" + (2 - queen));
                else jl8.setText(" :" + (2 - knight));
            }
            if (rr1 == 1) {
                  pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                timer.stop();
                btn[ll1][ll2].setIcon(null);
                btn[ll1][ll2].setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "OOps!Your game is over.");
                ((CardLayout) c.getLayout()).show(c, "4");
            } else if (rock == 2 && queen == 2 && knight == 2) {
                 read_file t = new read_file();
                   write_file t1 = new write_file();
                        if(t1.write(1)<6)
                        t.read("6",1);
                        t.read(Integer.toString(pt),2);
                timer.stop();
                btn[ll2][ll2].setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Congratulation,your level is complete");
                 swing4 frame = new swing4();
                        frame.in4(c);
                        ((CardLayout)c.getLayout()).show(c,"4");
            }
        }
    }
}