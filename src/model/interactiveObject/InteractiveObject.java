package model.interactiveObject;

import model.entity.Entity;
import view.interactiveObject.InteractiveObjectRenderer;

import java.awt.*;

public abstract class InteractiveObject {
    private int ID;

    private int x;
    private int y;

    private boolean collision = false;

    private Rectangle hitbox;



    private boolean opened = false;



    protected InteractiveObjectRenderer renderer;

    public InteractiveObject(int ID, int x, int y) {
        this.ID = ID;
        setPosition(x,y);
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        this.hitbox=new Rectangle(x-2,y-2,50,50);
    }

    public void setCollision(boolean col){
        this.collision=col;
    }

    public boolean isCollision() {
        return collision;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public InteractiveObjectRenderer getRenderer() {
        return renderer;
    }


    public Rectangle getHitBox() {
        return hitbox;
    }

    public void interact(Entity entity) {
    }

    public boolean isOpen() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
