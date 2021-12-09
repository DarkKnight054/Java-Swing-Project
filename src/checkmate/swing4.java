package checkmate;
import javax.swing.*;
import java.awt.*;
public class swing4 {
    private JTextField jt;
    private JLabel jl, coin_img, coin_num, life_img, life_num;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13;
    private JPanel jp4;
    private Font f;

    public void in4(Container c) {
        write_file lol = new write_file();
        jp4 = new JPanel();
        c.add(jp4, "4");
        jp4.setLayout(null);
        life_img = new JLabel(new ImageIcon(getClass().getResource("level_img.jpg")));
        life_img.setBounds(0,0,787,787);
        jp4.add(life_img);
        f = new Font("TimesRoman", Font.ITALIC, 30);
        coin_img = new JLabel(new ImageIcon(getClass().getResource("coin.png")));
        coin_img.setBounds(0, 0, 50, 50);
        coin_num = new JLabel("~" + lol.write(2));
        coin_num.setBounds(50, 0, 150, 50);
        coin_num.setFont(new Font("TimesRoman", Font.ITALIC, 22));
        coin_num.setForeground(Color.ORANGE);
        life_img.add(coin_img);
        life_img.add(coin_num);
        btn2 = new JButton("Level 1");
        btn2.setBounds(275, 250, 200, 40);
        btn2.setFont(f);
        btn2.setContentAreaFilled(false);
        btn2.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 0) btn2.setForeground(Color.GREEN);
        else btn2.setForeground(Color.YELLOW);
        life_img.add(btn2);
        btn1 = new JButton("Level 2");
        btn1.setBounds(275,300 , 200, 40);
        btn1.setFont(f);
        btn1.setContentAreaFilled(false);
        btn1.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 1) btn1.setForeground(Color.GREEN);
        else btn1.setForeground(Color.YELLOW);
        life_img.add(btn1);
        btn3 = new JButton("Level 3");
        btn3.setBounds(275, 350, 200, 40);
        btn3.setFont(f);
        btn3.setContentAreaFilled(false);
        btn3.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 2) btn3.setForeground(Color.GREEN);
        else btn3.setForeground(Color.YELLOW);
        life_img.add(btn3);
        btn4 = new JButton("Level 4");
        btn4.setBounds(275, 400, 200, 40);
        btn4.setFont(f);
        btn4.setContentAreaFilled(false);
        btn4.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 3) btn4.setForeground(Color.GREEN);
        else btn4.setForeground(Color.YELLOW);
        life_img.add(btn4);
        btn5 = new JButton("Level 5");
        btn5.setBounds(275, 450, 200, 40);
        btn5.setFont(f);
        btn5.setContentAreaFilled(false);
        btn5.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 4) btn5.setForeground(Color.GREEN);
        else btn5.setForeground(Color.YELLOW);
        life_img.add(btn5);
        btn6 = new JButton("Level 6");
        btn6.setBounds(275, 500, 200, 40);
        btn6.setFont(f);
        btn6.setContentAreaFilled(false);
        btn6.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 5) btn6.setForeground(Color.GREEN);
        else btn6.setForeground(Color.YELLOW);
        life_img.add(btn6);
        btn7 = new JButton("Level 7");
        btn7.setBounds(275, 550, 200, 40);
        btn7.setFont(f);
        btn7.setContentAreaFilled(false);
        btn7.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 6) btn7.setForeground(Color.GREEN);
        else btn7.setForeground(Color.YELLOW);
        life_img.add(btn7);
        btn8 = new JButton("Level 8");
        btn8.setBounds(275, 600, 200, 40);
        btn8.setFont(f);
        btn8.setContentAreaFilled(false);
        btn8.setBorder(new RoundedBorder(20));
        if (lol.write(1) > 7) btn8.setForeground(Color.GREEN);
        else btn8.setForeground(Color.YELLOW);
        life_img.add(btn8);
        btn13 = new JButton("EXIT");
        btn13.setBounds(275, 650, 200, 50);
        btn13.setFont(f);
        btn13.setContentAreaFilled(false);
        btn13.setBorder(new RoundedBorder(20));
        btn13.setForeground(Color.red);
        life_img.add(btn13);
        btn13.addActionListener(e -> {
            ((CardLayout) c.getLayout()).show(c, "0");
        });
        btn1.addActionListener(e -> {
            if (lol.write(1) >= 1) {
                swing1 frame1 = new swing1();
                frame1.in1(c);
                ((CardLayout) c.getLayout()).show(c, "1");
            } else {
                if (lol.write(2) < 200) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 200$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 200;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing1 frame1 = new swing1();
                        frame1.in1(c);
                        ((CardLayout) c.getLayout()).show(c, "1");
                    }
                }
            }
        });
        btn2.addActionListener(e -> {
            if (lol.write(1) >= 0) {
                swing6 frame1 = new swing6();
                frame1.in6(c);
                ((CardLayout) c.getLayout()).show(c, "6");
            } else {
                if (lol.write(2) < 200) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 200$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 200;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing6 frame1 = new swing6();
                        frame1.in6(c);
                        ((CardLayout) c.getLayout()).show(c, "6");
                    }
                }
            }
        });
        btn3.addActionListener(e -> {
            if (lol.write(1) >= 2) {
                swing7 frame1 = new swing7();
                frame1.in7(c);
                ((CardLayout) c.getLayout()).show(c, "7");
            } else {
                if (lol.write(2) < 1000) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 1000$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 1000;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing7 frame1 = new swing7();
                        frame1.in7(c);
                        ((CardLayout) c.getLayout()).show(c, "7");
                    }
                }
            }
        });
        btn4.addActionListener(e -> {
            if (lol.write(1) >= 3) {
                swing8 frame1 = new swing8();
                frame1.in8(c);
                ((CardLayout) c.getLayout()).show(c, "8");
            } else {
                if (lol.write(2) < 1400) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 1400$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 1400;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing8 frame1 = new swing8();
                        frame1.in8(c);
                        ((CardLayout) c.getLayout()).show(c, "8");
                    }
                }
            }
        });
        btn5.addActionListener(e -> {
            if (lol.write(1) >= 4) {
                swing9 frame1 = new swing9();
                frame1.in9(c);
                ((CardLayout) c.getLayout()).show(c, "9");
            } else {
                if (lol.write(2) < 1600) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 1600$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 1600;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing9 frame1 = new swing9();
                        frame1.in9(c);
                        ((CardLayout) c.getLayout()).show(c, "9");
                    }
                }
            }
        });
        btn6.addActionListener(e -> {
            if (lol.write(1) >= 5) {
                swing10 frame1 = new swing10();
                frame1.in10(c);
                ((CardLayout) c.getLayout()).show(c, "10");
            } else {
                if (lol.write(2) < 2000) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 2000$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 2000;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing10 frame1 = new swing10();
                        frame1.in10(c);
                        ((CardLayout) c.getLayout()).show(c, "10");
                    }
                }
            }
        });
        btn7.addActionListener(e -> {
            if (lol.write(1) >= 6) {
                swing11 frame1 = new swing11();
                frame1.in11(c);
                ((CardLayout) c.getLayout()).show(c, "11");
            } else {
                if (lol.write(2) < 2200) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 2200$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 2200;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing11 frame1 = new swing11();
                        frame1.in11(c);
                        ((CardLayout) c.getLayout()).show(c, "11");
                    }
                }
            }
        });
        btn8.addActionListener(e -> {
            if (lol.write(1) >= 4) {
                swing12 frame1 = new swing12();
                frame1.in12(c);
                ((CardLayout) c.getLayout()).show(c, "12");
            } else {
                if (lol.write(2) < 2600) {
                    JOptionPane.showMessageDialog(null, "You have not completed previous level.Also,You have not sufficient coins.");
                } else {
                    int joke = JOptionPane.showConfirmDialog(null, "You haven't fulfilled requirements to unlock this level." + "\n" + "Do You want to cost 2600$ ?");
                    if (joke == JOptionPane.YES_OPTION) {
                        int ut = lol.write(2);
                        ut -= 2600;
                        read_file tot = new read_file();
                        tot.read(Integer.toString(ut), 2);
                        coin_num.setText("~" + ut);
                        swing12 frame1 = new swing12();
                        frame1.in12(c);
                        ((CardLayout) c.getLayout()).show(c, "12");
                    }
                }
            }
        });
        
    }
}