package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class StartingClass extends JApplet implements Runnable, KeyListener {
    private static final boolean ALWAYS = true;
    private static final int SLEEP_TIME_IN_MS = 17;
    private static final int SIZE_WIDTH = 800;
    private static final int SIZE_HEIGHT = 480;
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final boolean IS_FOCUSABLE = true;
    private static final String TITLE = "Q-Bot game!";

    private Robot robot;
    private Image image;
    private Graphics graphics;
    private BufferedImage character;

    @Override
    public void init() {
        initUi();
        addKeyListener(this);
    }

    @Override
    public void start() {
        robot = new Robot();
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
            robot.update();
            repaint();
            sleep(SLEEP_TIME_IN_MS);
        }
    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            graphics = image.getGraphics();
        }

        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(getForeground());
        paint(graphics);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(character, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
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
        try {
            character = ImageIO.read(this.getClass().getResource("/data/char.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                robot.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                robot.moveRight();
                break;
            case KeyEvent.VK_SPACE:
                robot.jump();
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
                robot.stop();
                break;
            case KeyEvent.VK_RIGHT:
                robot.stop();
                break;
            case KeyEvent.VK_SPACE:
                robot.stop();
                break;
        }
    }
}
