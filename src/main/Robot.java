package main;

public class Robot {
    private static final int DEFAULT_NORMAL_SPEED = 6;
    private static final int DEFAULT_JUMP_SPEED = 15;

    private int centerX = 100;
    private int centerY = 382;
    private boolean jumped = false;
    private int speedX = 0;
    private int speedY = 1;

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void update() {
        updatePositionX();
        updatePositionY();
        updateJump();
        relocateWhenNecessary();
    }

    public void moveRight() {
        speedX = DEFAULT_NORMAL_SPEED;
    }

    public void moveLeft() {
        speedX = -DEFAULT_NORMAL_SPEED;
    }

    public void stop() {
        speedX = 0;
    }

    public void jump() {
        if (!jumped) {
            speedY = -DEFAULT_JUMP_SPEED;
            jumped = true;
        }
    }

    private void updatePositionX() {
        if (speedX < 0) {
            centerX += speedX;
        } else if (speedX == 0) {
            // do not scroll background
        } else {
            if (centerX <= 150) {
                centerX += speedX;
            } else {
                // scroll background here
            }
        }
    }

    private void updatePositionY() {
        if (centerY + speedY >= 382) {
            centerY = 382;
        } else {
            centerY += speedY;
        }
    }

    private void updateJump() {
        if (jumped) {
            speedY++;
            if (centerY + speedY >= 382) {
                centerY = 382;
                speedY = 0;
                jumped = false;
            }
        }
    }

    private void relocateWhenNecessary() {
        if (centerX + speedX <= 60) {
            centerX = 61;
        }
    }
}
