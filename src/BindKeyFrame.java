import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BindKeyFrame {
    JLabel l;
    JDialog d;
    JButton button;
    JButton bindbutton;
    public void display(String title, String message, JButton bindbutton){
        this.bindbutton = bindbutton;
        l = new JLabel(message);
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setBorder(new EmptyBorder(30, 100, 30, 100));

        button = new JButton("Cancel");
        button.setBounds(100, 100, 80, 30);
        button.setFocusable(false);
        d = new JDialog(new Frame(), title,true);
        d.setLayout(new FlowLayout());
        d.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String str = java.awt.event.KeyEvent.getKeyText(e.getKeyCode());
                if(str.equals("1")){
                    bindbutton.setText("k1");
                }else if(str.equals("2")){
                    bindbutton.setText("k2");
                }else if(str.equals("3")){
                    bindbutton.setText("k3");
                }else if(str.equals("4")){
                    bindbutton.setText("k4");
                }else if(str.equals("5")){
                    bindbutton.setText("k5");
                }else if(str.equals("6")){
                    bindbutton.setText("k6");
                }else if(str.equals("7")){
                    bindbutton.setText("k7");
                }else if(str.equals("8")){
                    bindbutton.setText("k8");
                }else if(str.equals("9")){
                    bindbutton.setText("k9");
                }else if(str.equals("0")){
                    bindbutton.setText("k0");
                }
                else {
                    bindbutton.setText(str);
                }
                d.dispose();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        d.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String str = String.valueOf(e.getButton());
                switch (str){
                    case "3": bindbutton.setText("m2");
                        break;
                    case "2": bindbutton.setText("m3");
                        break;
                    case "1": bindbutton.setText("m1");
                        break;
                    case "4": bindbutton.setText("m4");
                        break;
                    case "5": bindbutton.setText("m5");
                        break;
                    default:bindbutton.setText(str);
                }

                d.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        d.add(l);
        d.add(button);
        d.setResizable(false);
        d.setBounds(70, 30, 300, 200);
        button.addActionListener(e -> d.dispose());
        d.setVisible(true);



    }

}
