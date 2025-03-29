package model.item;

import java.awt.*;

public abstract class Item {

    public String name;
    public int ID;
    public int x;
    public int y;
    public int price;

    public int rarity;
    public Rectangle hitbox;

    public Item(String name, int ID, int price, int rarity){
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.rarity = rarity;
    }

    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
        this.hitbox =new Rectangle(x,y,32,32);
    }
}
