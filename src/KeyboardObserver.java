import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyboardObserver implements Runnable {
    private Queue<KeyEvent> keyEvents;      //  a queue of KeyEvents
    private JFrame frame;   // a JFrame instance
    public KeyboardObserver() { //  class constructor
        keyEvents = new ArrayBlockingQueue<>(100);
    }

    @Override
    public void run() {
        //  Instantiate the JFrame with an initial frame title.
        frame = new JFrame("KeyPress Tester");
        //  Set the closing operation of the JFrame instance.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Transparent JFrame Demo"); //   sets the title of the JFrame.

        frame.setSize(400, 400); // Sets the dimensions of the JFrame.
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());
        //  frame.setUndecorated(true);

        //  frame.setOpacity(0.0f);
        frame.setVisible(true); //  Displays the JFrame instance on screen.

        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) { //Do nothing
            }

            @Override
            public void focusLost(FocusEvent e) {  System.exit(0);  }
        });

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {  //Do nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {    //Do nothing
            }

            @Override
            public void keyReleased(KeyEvent e) { keyEvents.add(e); }
        });
    }

    public boolean hasKeyEvents(){  return !keyEvents.isEmpty();    }

    public KeyEvent getEventFromTop(){  return keyEvents.poll();    }
}
