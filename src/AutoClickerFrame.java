import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.GlobalScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AutoClickerFrame implements NativeKeyListener {
    private final double cps;
    private double delay;
    private final int stopat;
    private final String jButton1;
    private final String activation;
    private final String mousebutton;
    private boolean clickerEnabled = false;
    private boolean running = false;

    AutoClickerFrame(double cps, String jButton1, String activation, String mousebutton, int stopat){
        this.cps = cps;
        this.jButton1 = jButton1;
        this.activation = activation;
        this.mousebutton = mousebutton;
        this.stopat = stopat;
    }
    void display(){
        JFrame frame = new JFrame();
        frame.setResizable(false);
        JLabel label = new JLabel("clicks per seocnd: "+  String.valueOf(cps));
        label.setBorder(new EmptyBorder(20, 500000, 10,500000));
        frame.add(label);
        JLabel label2 = new JLabel("key: " + jButton1);
        label2.setBorder(new EmptyBorder(10, 500000, 10,500000));
        frame.add(label2);
        JLabel label3 = new JLabel("activation type: " + activation);
        label3.setBorder(new EmptyBorder(10, 500000, 10,500000));
        frame.add(label3);
        JLabel label4 = new JLabel("mouse button: " + mousebutton);
        label4.setBorder(new EmptyBorder(10, 500000, 10,500000));
        frame.add(label4);
        JLabel label5 = new JLabel("stop at: " + stopat + " click");
        label5.setBorder(new EmptyBorder(10, 500000, 10,500000));
        frame.add(label5);


        JButton button = new JButton("close");
        button.addActionListener(e -> stopThread());
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon image = new ImageIcon("src/logo.png");
        frame.setIconImage(image.getImage());
        frame.setTitle("macro 1.0 frame");
        frame.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                cleanGlobalScreen();
                stopThread();
            }
        });
        frame.setSize(280, 300);
        frame.setLayout(new FlowLayout());
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        button.addActionListener(e -> cleanGlobalScreen());
        button.addActionListener(e -> frame.dispose());
    }

    void KeyPressed(){
        switch (activation){
            case "toggle": if(clickerEnabled){
                stopThread();
                clickerEnabled = false;
            }else {
                startThread();
                clickerEnabled = true;
            }
            break;
            case "press": if(!clickerEnabled){
                startThread();
                clickerEnabled = true;
            }
                break;
        }
    }

    void KeyReleased(){
        if(activation.equals("press")){
            stopThread();
            clickerEnabled = false;
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).toLowerCase().equals(jButton1.toLowerCase())){
            KeyPressed();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).toLowerCase().equals(jButton1.toLowerCase())){
            KeyReleased();
        }
    }
    public void cleanGlobalScreen() {
        try {
            GlobalScreen.unregisterNativeHook();
            GlobalScreen.removeNativeKeyListener(this);
        } catch (NativeHookException nativeHookException) {
            nativeHookException.printStackTrace();
        }
    }
Thread thread;
    public void startThread(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(cps > 90 && cps < 100){
                        delay = 1000/cps * 0.8999999999999999;
                    }else{
                        delay = 1000/(cps + 0.5);
                    }
                    Robot robot = new Robot();
                    running = true;
                    if(stopat!=0){
                        for(int i = 0; i < stopat; i++){
                            if(mousebutton.equals("left")){
                                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                robot.delay((int) delay);
                            }else{
                                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                                robot.delay((int) delay);
                            }
                        }
                    }else {
                        while (running) {
                            if(mousebutton.equals("left")){
                                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                robot.delay((int) delay);
                            }else{
                                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                                robot.delay((int) delay);
                            }

                        }
                    }
                } catch (AWTException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public void stopThread() {
        running = false;
    }

}
