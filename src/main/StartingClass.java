package main;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass extends Applet implements Runnable, KeyListener {
    private static final boolean ALWAYS = true;
    private static final int SLEEP_TIME_IN_MS = 17;
    private static final int SIZE_WIDTH = 800;
    private static final int SIZE_HEIGHT = 480;
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final boolean IS_FOCUSABLE = true;
    private static final String TITLE = "Q-Bot game!";

    @Override
    public void init() {
        initUi();
        addKeyListener(this);
    }

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void run() {
        while (ALWAYS) {
            repaint();
            sleep(SLEEP_TIME_IN_MS);
        }
    }

    private void sleep(int sleepTimeInMs) {
        try {
            Thread.sleep(sleepTimeInMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initUi() {
        setSize(SIZE_WIDTH, SIZE_HEIGHT);
        setBackground(BACKGROUND_COLOR);
        setFocusable(IS_FOCUSABLE);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle(TITLE);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Move up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Move down");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Move left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Move right");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Jump");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Stop moving up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Stop moving down");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Stop moving left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Stop moving right");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Stop jumping");
                break;
        }
    }
}
