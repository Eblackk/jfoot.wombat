package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else {
            this.turnLeft();
        }

        if (isAtRightEdge()) {
            this.turnLeft();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.move();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.turnLeft();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
        }
        
        if (isAtLeftEdge()) {
            this.turnRight();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.move();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.turnRight();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
        }
        if (isAtleftBorder() && isAtTopBorder()) {
            turnRight();
            move();
            turnRight();
        }
    }

    public void turnRight() {
        if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }

    public boolean isAtRightEdge() {
        if (getDirection().equals(EAST) && !canMove()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isAtLeftEdge() {
        if (getDirection().equals(WEST) && !canMove()) {
            return true;
        } else {
            return false;
        }
    }


    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }

    public boolean isAtleftBorder() {
        return getX() == 0;
    }

    public boolean isAtRightBorder() {
        return getX() == 9;
    }

    public boolean isAtTopBorder() {
        return getY() == 0;
    }

    public boolean isATBottomBorder() {
        return getY() == 9;
    }


}




