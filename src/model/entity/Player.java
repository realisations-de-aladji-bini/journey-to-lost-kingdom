package model.entity;

import controller.GameRunnable;
import controller.KeyManager;
import model.Inventory;
import model.RoomManager;
import view.entity.PlayerRenderer;

import java.awt.*;

public class Player extends Entity{

    private final KeyManager keyManager;
    public final Inventory playerInventory = new Inventory();

    private final RoomManager roomManager;

    private final PlayerRenderer playerRenderer;


    public Player(GameRunnable gp, KeyManager km){
        this.roomManager = gp.getRoomManager();
        this.keyManager=km;
        playerRenderer = new PlayerRenderer(this);
        setDefaultValue();
    }



    public void setDefaultValue(){
        //Player default position
        x = 100;
        y = 100;
        speed = 4;
        direction = Direction.DOWN; //To face screen
        hitBox = new Rectangle(x+8,y+8,32,32);

    }

    public void update(){
        if(keyManager.up){
            direction= Direction.UP;
            spriteCounter++;

        }
        if(keyManager.down){
            direction= Direction.DOWN;
            spriteCounter++;

        }
        if(keyManager.right){
            direction= Direction.RIGHT;
            spriteCounter++;

        }
        if(keyManager.left){
            direction= Direction.LEFT;
            spriteCounter++;
        }


        if(spriteCounter > spriteFrame){
            spriteCounter=0;
            spriteNb=(spriteNb+1)%2;
        }

        this.hitBox.x=x+8;
        this.hitBox.y=y+8;



        if(y >= (roomManager.getCurrentRoom().getRoomSizeRow() - 1) * roomManager.getCurrentRoom().tileSize || x >= (roomManager.getCurrentRoom().getRoomSizeCol()- 1) * roomManager.getCurrentRoom().tileSize){
            roomManager.switchRoom(this);
        }

        if(keyManager.up || keyManager.down || keyManager.right || keyManager.left) {
            if (!checkCollision(roomManager.getCurrentRoom()) && !checkCollisionInteractiveObject(roomManager.getCurrentRoom())) {
                switch (direction) {
                    case UP -> y -= speed;
                    case DOWN -> y += speed;
                    case RIGHT -> x += speed;
                    case LEFT -> x -= speed;
                }
            }
        }

        checkItem(roomManager.getCurrentRoom(),playerInventory);

    }

    public void draw(Graphics2D g2){
        playerRenderer.render(g2);
    }

}
