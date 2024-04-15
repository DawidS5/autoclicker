import javax.swing.*;

public class AlertFrame {
    public static void display(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}
