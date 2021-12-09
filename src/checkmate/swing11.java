//queen and 2nd division
package checkmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class swing11 implements ActionListener {
    private JPanel jp, panel;
    Container c;
    int counter = 90, lolz = 20, pre = 20, life = 3, bishop = 0, knight = 0;
    private GridLayout gd;
    private JButton[][] btn;
    private JButton btn1;
    private JLabel jl, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;
    private ImageIcon bishop_img, knight_img, icon2, icon3, queen_img, rook_img;
    Timer timer;
    int count = 0, rr, ll, rr1, ll1, rr2, ll2, ghost_x = 0, ghost_y = 0, pt = 0;
    boolean ok, got_it, x, y;
    int arr1[] = {1, 1, -1, -1, 2, 2, -2, -2};
    int arr2[] = {-2, 2, -2, 2, 1, -1, 1, -1};
    Random rd;
    public void in11(Container c) {
         write_file lol = new write_file();
          pt=lol.write(2);
        this.c = c;
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);
        rd = new Random();
        jl = new JLabel("Timer:90");
        jl.setBounds(10, 0, 100, 50);
        jl1 = new JLabel("Ghost:20");
        jl1.setBounds(120, 0, 120, 50);
        jl2 = new JLabel("PT:"+pt);
        jl2.setBounds(240, 0, 120, 50);
        jl3 = new JLabel(new ImageIcon(getClass().getResource("bishop-icon.jpg")));
        jl3.setBounds(400, 0, 50, 50);
        jl4 = new JLabel(" :4");
        jl4.setBounds(450, 0, 50, 50);
        jl5 = new JLabel(new ImageIcon(getClass().getResource("knight-icon.jpg")));
        jl5.setBounds(500, 0, 50, 50);
        jl6 = new JLabel(" :8");
        jl6.setBounds(550, 0, 50, 50);
        jl7 = new JLabel(new ImageIcon(getClass().getResource("life.jpg")));
        jl7.setBounds(600, 0, 50, 50);
        jl8 = new JLabel(" :3");
        jl8.setBounds(650, 0, 50, 50);
        jp = new JPanel();
        gd = new GridLayout(8, 8);
        jp.setLayout(gd);
        jp.setBounds(0, 50, 785, 715);
        panel.add(jp);
        c.add(panel, "11");
        Font f = new Font("TimesRoman", Font.ITALIC, 25);
        jl.setFont(f);
        jl1.setFont(f);
        jl2.setFont(f);
        jl4.setFont(f);
        jl6.setFont(f);
        jl8.setFont(f);
        panel.add(jl);
        panel.add(jl1);
        panel.add(jl2);
        panel.add(jl3);
        panel.add(jl4);
        panel.add(jl5);
        panel.add(jl6);
        panel.add(jl7);
        panel.add(jl8);
        btn = new JButton[8][8];
        bishop_img = new ImageIcon(getClass().getResource("bishop.png"));
        knight_img = new ImageIcon(getClass().getResource("knight.png"));
        queen_img = new ImageIcon(getClass().getResource("queen.jpg"));
        rook_img = new ImageIcon(getClass().getResource("rock.jpg"));
        icon2 = new ImageIcon(getClass().getResource("ghost.jpg"));
        icon3 = new ImageIcon(getClass().getResource("coin.png"));
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
        btn[4][3].setIcon(queen_img);
        btn[3][1].setIcon(rook_img);
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
                          pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "Oops! Your game is over.");
                        ((CardLayout) c.getLayout()).show(c, "4");
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
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if ((i == 4 && j == 3) || (i == 3 && j == 1)) continue;
                            btn[i][j].setIcon(icon2);
                        }
                    }
                    bishop = 0;
                    knight = 0;
                    jl1.setText("Ghost:" + lolz);
                    jl8.setText(" :" + life);
                    jl4.setText(" :4");
                    jl6.setText(" :8");
                    jl2.setText("PT:"+pt);
                } else jl1.setText("Ghost:" + lolz);
                if (counter % 9 == 0) {
                    if (btn[ghost_x][ghost_y].getIcon() == icon3) btn[ghost_x][ghost_y].setIcon(null);
                    ghost_x = rd.nextInt(8);
                    ghost_y = rd.nextInt(8);
                    while (btn[ghost_x][ghost_y].getIcon() != null) {
                        ghost_x = rd.nextInt(8);
                        ghost_y = rd.nextInt(8);
                    }
                    btn[ghost_x][ghost_y].setIcon(icon3);
                }
                jl.setText("Timer:" + (--counter));
                if (counter <= 0) {
                      pt-=100;
                 if(pt<0)
                pt=0;
              read_file t = new read_file();
                 t.read(Integer.toString(pt),2);
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Oops! Your game is over.");
                    ((CardLayout) c.getLayout()).show(c, "3");
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
        Object src = ae.getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (btn[i][j] == src) {
                    if (btn[i][j].getIcon() == null || btn[i][j].getIcon() == icon3) {
                        ok = true;
                        if (bishop < 4) {
                            x = true;
                            bishop++;
                        } else {
                            y = true;
                            knight++;
                        }
                    }
                    break;
                }
            }
        }
        if (ok) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (btn[i][j] == src) {
                        ll1 = i;
                        ll2 = j;
                        if (btn[i][j].getIcon() == icon3) got_it = true;
                        if (x) {
                            btn[i][j].setIcon(bishop_img);
                        } else if (y) {
                            btn[i][j].setIcon(knight_img);
                        }
                    }
                }
            }
            rr1 = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (btn[i][j].getIcon() == knight_img) {
                        //System.out.println("1");
                        for (int k = 0; k < 8; k++) {
                            rr = arr1[k] + i;
                            ll = arr2[k] + j;
                            if (rr >= 0 && rr < 8 && ll >= 0 && ll < 8 && btn[ll][rr].getIcon() != null && btn[i][j].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(ll)+" "+(rr));
                            }
                        }
                    } else if (btn[i][j].getIcon() == queen_img) {
                        //System.out.println("2");
                        for (int k = 0; k < 8; k++) {
                            if (k != i && btn[k][j].getIcon() != null && btn[k][j].getIcon() != icon3) {
                                rr1 = 1;
                        //        System.out.println(""+(k)+" "+(j));
                            }
                            if (k != j && btn[i][k].getIcon() != null && btn[i][k].getIcon() != icon3) {
                                rr1 = 1;
                        //        System.out.println(""+(i)+" "+(k));
                            }
                        }
                        for (int k = 1; k < 8; k++) {
                            if ((i - k >= 0) && (j - k >= 0) && btn[i - k][j - k].getIcon() != null && btn[i - k][j - k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i-k)+" "+(j-k));
                            }
                            if ((i + k <= 7) && (j + k <= 7) && btn[i + k][j + k].getIcon() != null && btn[i + k][j + k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i+k)+" "+(j+k));
                            }
                            if ((i + k <= 7) && (j - k >= 0) && btn[i + k][j - k].getIcon() != null && btn[i + k][j - k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i+k)+" "+(j-k));
                            }
                            if ((i - k >= 0) && (j + k <= 7) && btn[i - k][j + k].getIcon() != null && btn[i - k][j + k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i-k)+" "+(j+k));
                            }
                        }
                    } else if (btn[i][j].getIcon() == rook_img) {
                        //System.out.println("3");
                        for (int k = 0; k < 8; k++) {
                            if (k != i && btn[k][j].getIcon() != null && btn[k][j].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(k)+" "+(j));
                            }
                            if (k != j && btn[i][k].getIcon() != null && btn[i][k].getIcon() != icon3) {
                                System.out.println(""+(i)+" "+(k));
                            //    rr1 = 1;
                            }
                        }
                    } else if (btn[i][j].getIcon() == bishop_img) {
                        //System.out.println("4");
                        for (int k = 1; k < 8; k++) {
                            if ((i - k >= 0) && (j - k >= 0) && btn[i - k][j - k].getIcon() != null && btn[i - k][j - k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i-k)+" "+(j-k));
                            }
                            if ((i + k <= 7) && (j + k <= 7) && btn[i + k][j + k].getIcon() != null && btn[i + k][j + k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i+k)+" "+(j+k));
                            }
                            if ((i + k <= 7) && (j - k >= 0) && btn[i + k][j - k].getIcon() != null && btn[i + k][j - k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i+k)+" "+(j-k));
                            }
                            if ((i - k >= 0) && (j + k <= 7) && btn[i - k][j + k].getIcon() != null && btn[i - k][j + k].getIcon() != icon3) {
                                rr1 = 1;
                            //    System.out.println(""+(i-k)+" "+(j+k));
                            }
                        }
                    }
                }
            }
            if (rr1 != 1) {
                lolz = pre;
                if (got_it) pt += 50;
                jl2.setText(":" + pt);
                jl1.setText("Ghost:" + lolz);
                jl4.setText(" :" + (4 - bishop));
                jl6.setText(" :" + (8 - knight));
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
            } else if (bishop == 4 && knight == 8) {
                  read_file t = new read_file();
                    write_file t1 = new write_file();
                        if(t1.write(1)<7)
                        t.read("7",1);
                        t.read(Integer.toString(pt),2);
                timer.stop();
                btn[ll1][ll2].setIcon(null);
                btn[ll1][ll2].setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Congratulation,your level is complete");
                swing4 frame = new swing4();
                        frame.in4(c);
                        ((CardLayout)c.getLayout()).show(c,"4");
            }
        }
    }
}