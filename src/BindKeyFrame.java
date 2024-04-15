import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BindKeyFrame {
    JLabel l;
    JDialog d;
    JButton button;
    public void display(String title, String message, JButton bindbutton){
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
                bindbutton.setText(java.awt.event.KeyEvent.getKeyText(e.getKeyCode()));
                d.dispose();
            }

            @Override
            public void keyReleased(KeyEvent e) {

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
