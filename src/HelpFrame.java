import javax.swing.*;

public class HelpFrame extends JFrame {
    HelpFrame(){
        this.setResizable(false);
        JTextPane textPane = new JTextPane();
        textPane.setText("enter how many clicks you want per second\n\nyou can enter fractional frequencies (0.5 is one click every 2 seconds)\n\nselect activation type toggle or press\n\nclick on button ''bind key'' \n\nand then click any key when activation key window pops up\n\nselect mouse button left or right\n\nand if you want you can choose on which click the program should stop\n\n0 (next to stop at) means this function is disabled\n\nonce you have everything set, click the start button\n\nthis autoclicker is enabled when the macro frame is visible\n\nthis autoclicker is not accurate (idk why)\n\nI was inspired by this https://github.com/jacobwhiteis/CrowClicker project\n\n\n\nsource code in my github profile\n\nhttps://github.com/DawidS5");
        textPane.setEditable(false);
        this.add(textPane);
        ImageIcon image = new ImageIcon("src/logo.png");
        this.setIconImage(image.getImage());
        this.setTitle("macro 1.0 help");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(400, 0, 443, 600);
        this.setVisible(true);
    }
}
