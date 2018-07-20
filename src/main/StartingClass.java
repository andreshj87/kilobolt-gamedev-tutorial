package main;

import java.applet.Applet;
import java.awt.*;

public class StartingClass extends Applet implements Runnable {
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
}
