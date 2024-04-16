import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author DawidS5
 */
public class Frame extends JFrame {
    AutoClickerFrame f;
    public Frame() {
        initComponents();
        this.setResizable(false);
        this.setTitle("autoclicker 1.0");
        ImageIcon image = new ImageIcon("src/logo.png");
        this.setIconImage(image.getImage());
        jButton1.addActionListener(e -> {
            BindKeyFrame keyframe = new BindKeyFrame();
            keyframe.display("activation key", "press key to bind", jButton1);
        });

    }


    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField1 = new JTextField();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jComboBox2 = new JComboBox<>();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel5 = new JLabel();
        jTextField2 = new JTextField();
        jTextField2.setText("0");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("clicks per second");

        jLabel2.setText("activation");

        jLabel3.setText("bind key");

        jLabel4.setText("mouse button");

        jLabel5.setText("stop at");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "toggle", "press" }));

        jButton1.setText("bind key");
        jButton2.addActionListener(e -> jButton1.setText("bind key"));

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);

            }
        });

        jButton2.setText("unbind key");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);

            }
        });

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "left", "right" }));

        jButton3.setText("start");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    jButton3ActionPerformed(evt);
            }

        });

        jButton4.setText("help");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addComponent(jButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4)
                                                .addGap(0, 116, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel4)
                                                                        .addGap(69, 69, 69))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(108, 108, 108)))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton1))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButton2))
                                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addGap(22, 22, 22))
        );
        pack();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        try{
            if(jTextField1.getText().equals("")){
                throw new EmptyInputException("You must enter a cps value");
            }else if(jButton1.getText().equals("bind key")){
                throw new NoBindKeyException("You must bind a key");
            }

            double cps = Double.parseDouble(jTextField1.getText());
            int stopat = Integer.parseInt(jTextField2.getText());
            String bindbutton = jButton1.getText();

            try {
                LogManager.getLogManager().reset();
                Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
                logger.setLevel(Level.OFF);GlobalScreen.registerNativeHook();

                f = new AutoClickerFrame(cps, bindbutton, jComboBox1.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString(), stopat);
                f.display();
                GlobalScreen.addNativeKeyListener(f);

            } catch (NativeHookException ex) {
                ex.printStackTrace();
            }


        }catch (NumberFormatException e){
            AlertFrame.display("Invalid Format", e.getMessage() + " (you must enter a number)");
        }catch (EmptyInputException e) {
            AlertFrame.display("Invalid Input", e.getMessage());
        } catch (NoBindKeyException e) {
            AlertFrame.display("No key binded", e.getMessage());
        }

    }

    private void jButton1ActionPerformed(ActionEvent evt) {

    }
    private void jButton2ActionPerformed(ActionEvent evt) {

    }
    private void jButton4ActionPerformed(ActionEvent evt) {
        HelpFrame frame = new HelpFrame();
    }


    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField jTextField1;
    private JTextField jTextField2;
}
