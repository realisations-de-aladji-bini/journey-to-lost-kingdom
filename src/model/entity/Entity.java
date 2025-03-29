package model.entity;

import model.Inventory;
import model.Room;
import model.interactiveObject.InteractiveObject;
import model.item.Item;

import java.awt.*;
import java.util.Iterator;

public abstract class Entity{

    //Position
    public int x,y;

    //Speed
    public int speed;

    //Sprite
    public int spriteNb = 1; //Witch sprite to use (typically up1 or up2)
    public int spriteCounter = 0; //To know when to switch sprite
    final public int spriteFrame = 10; //Time between each sprite switch

    public enum Direction { UP, DOWN, RIGHT, LEFT}

    public Direction direction;

    public Rectangle hitBox;

    public boolean checkCollision(Room room) {
        int leftCol = (hitBox.x);
        int rightCol = (hitBox.x+ hitBox.width);
        int topRow = (hitBox.y);
        int bottomRow = (hitBox.y+ hitBox.height);

        int tile1=0;
        int tile2=0;
        switch (direction){
            case UP:
                topRow = topRow - speed;
                tile1 = room.getMapTile()[leftCol/ room.tileSize][topRow/ room.tileSize];
                tile2 = room.getMapTile()[rightCol/ room.tileSize][topRow/ room.tileSize];
                break;
            case DOWN:
                bottomRow = bottomRow + speed;
                tile1 = room.getMapTile()[leftCol/ room.tileSize][bottomRow/ room.tileSize];
                tile2 = room.getMapTile()[rightCol/ room.tileSize][bottomRow/ room.tileSize];
                break;
            case RIGHT:
                rightCol = rightCol +speed;
                tile1 = room.getMapTile()[rightCol/ room.tileSize][topRow/ room.tileSize];
                tile2 = room.getMapTile()[rightCol/ room.tileSize][bottomRow/ room.tileSize];
                break;
            case LEFT:
                leftCol = leftCol - speed;
                tile1 = room.getMapTile()[leftCol/ room.tileSize][topRow/ room.tileSize];
                tile2 = room.getMapTile()[leftCol/ room.tileSize][bottomRow/ room.tileSize];
                break;
        }
        return room.getTilesType()[tile1].isCollision() || room.getTilesType()[tile2].isCollision();
    }

    public void checkItem(Room room, Inventory inventory){
        Iterator<Item> it = room.getItemInsideIterator();
        while (it.hasNext()){
            Item item = it.next();
            if(item.hitbox.intersects(hitBox)){
                inventory.addItem(room.removeItem(item));
                break;
            }
        }
    }

    public boolean checkCollisionInteractiveObject(Room room) {
        Iterator<InteractiveObject> it = room.getInterObjectInsideIterator();
        while (it.hasNext()){
            InteractiveObject obj = it.next();
            Rectangle hitBoxAfterMove = checkFutureMovement();
            if(obj.getHitBox().intersects(hitBoxAfterMove)){
                obj.interact(this);
                if(obj.isCollision()){
                    return true;
                }
            }
        }
        return false;
    }

    private Rectangle checkFutureMovement() {
        Rectangle hitBoxAfterMove = new Rectangle(hitBox);
        switch (direction) {
            case UP -> hitBoxAfterMove.y -= speed;
            case DOWN -> hitBoxAfterMove.y += speed;
            case LEFT -> hitBoxAfterMove.x -= speed;
            case RIGHT -> hitBoxAfterMove.x += speed;
        }
        return hitBoxAfterMove;
    }

}
