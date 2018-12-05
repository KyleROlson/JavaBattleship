//Kyle R. Olson
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.border.LineBorder;
public class BattleShip
{
    public static java.awt.Color color = Color.decode("#d63031");
    public static int turnCount = 0;
    public static int boatCount = 0;
    public static boolean finalized = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Battleship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setSize(500,500);
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1,2));
        ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() instanceof JButton) {
                        ((JButton)e.getSource()).setUI((ButtonUI)
                            BasicButtonUI.createUI((JButton)e.getSource()));
                        ((JButton)e.getSource()).setBackground(color);
                    }
                }
            };
        JPanel panel = new JPanel(new GridLayout(11,10));
        panel.setSize(new Dimension(500, 250));
        JButton[][] button = new JButton[][]{
                {new JButton(), new JButton("A"), new JButton("B"), new JButton("C"), new JButton("D"), new JButton("E"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("I")},
                {new JButton("1"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("2"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("3"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("4"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("5"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("6"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("7"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("8"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("9"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()}};
        for(int i = 0; i < button.length; i++) {
            for(int j = 0; j < button[i].length; j++) {
                button[i][j].addActionListener(listener);
                button[i][j].setBorder(new LineBorder(color.decode("#2d3436")));
                button[i][j].setUI((ButtonUI)
                    BasicButtonUI.createUI(button[i][j]));
                button[i][j].setBackground(color.decode("#74b9ff"));
                panel.add(button[i][j]);
            }
        }
        for(int i = 0; i < button.length; i++) {
            button[i][0].setEnabled(false);
            button[i][0].setUI((ButtonUI)
                BasicButtonUI.createUI(button[i][0]));
            button[i][0].setBackground(null);
            button[i][0].setForeground(color.decode("#2d3436"));
        }
        for(int i = 0; i < button.length; i++) {
            button[0][i].setEnabled(false);
            button[0][i].setUI((ButtonUI)
                BasicButtonUI.createUI(button[0][i]));
            button[0][i].setBackground(null);
            button[0][i].setForeground(color.decode("#2d3436"));
        }
        JButton hit = new JButton("Hit");
        panel.add(hit);
        JButton miss = new JButton("Miss");
        panel.add(miss);
        hit.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    color= Color.decode("#d63031");
                } 
            } );
        miss.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    color= Color.decode("#ffffff");
                } 
            } );
        frame.add(panel);
        //Player's Board
        ActionListener listener2 = new ActionListener() {
                java.awt.Color color1 = Color.decode("#2d3436");
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (finalized == false){
                        if (e.getSource() instanceof JButton) {
                            if(boatCount<12){
                                ((JButton)e.getSource()).setUI((ButtonUI)
                                    BasicButtonUI.createUI((JButton)e.getSource()));
                                ((JButton)e.getSource()).setBackground(color1);
                                boatCount++;
                            }
                            else{
                                finalized = true;
                            }
                        }
                    }
                    else{
                        if (e.getSource() instanceof JButton) {

                            ((JButton)e.getSource()).setUI((ButtonUI)
                                BasicButtonUI.createUI((JButton)e.getSource()));
                            ((JButton)e.getSource()).setBackground(Color.decode("#d63031"));
                        }
                    }
                }

            };
        JPanel panel2 = new JPanel(new GridLayout(11,10));
        JButton[][] button2 = new JButton[][]{
                {new JButton(), new JButton("A"), new JButton("B"), new JButton("C"), new JButton("D"), new JButton("E"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("I")},
                {new JButton("1"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("2"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("3"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("4"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("5"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("6"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("7"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("8"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()},
                {new JButton("9"), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()}};
        for(int i = 0; i < button2.length; i++) {
            for(int j = 0; j < button2[i].length; j++) {
                button2[i][j].addActionListener(listener2);
                button2[i][j].setBorder(new LineBorder(color.decode("#2d3436")));
                button2[i][j].setUI((ButtonUI)
                    BasicButtonUI.createUI(button2[i][j]));
                button2[i][j].setBackground(color.decode("#74b9ff"));
                panel2.add(button2[i][j]);
            }
        }
        for(int i = 0; i < button2.length; i++) {
            button2[i][0].setEnabled(false);
            button2[i][0].setUI((ButtonUI)
                BasicButtonUI.createUI(button2[i][0]));
            button2[i][0].setBackground(null);
            button2[i][0].setForeground(color.decode("#2d3436"));
        }
        for(int i = 0; i < button2.length; i++) {
            button2[0][i].setEnabled(false);
            button2[0][i].setUI((ButtonUI)
                BasicButtonUI.createUI(button2[0][i]));
            button2[0][i].setBackground(null);
            button2[0][i].setForeground(color.decode("#2d3436"));
        }
        JButton confirm = new JButton("Turn");
        panel2.add(confirm);
        confirm.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    finalized = true;
                    turnCount++;
                    if(turnCount%3 == 0){
                        button2[(int)(Math.random() * 9)+1][(int)(Math.random() * 9)+1].setBackground(Color.decode("#d63031"));
                    }
                }
            } );   
        container.add(panel);
        container.add(panel2); 
        frame.add(container);
        frame.setVisible(true);
    }
}