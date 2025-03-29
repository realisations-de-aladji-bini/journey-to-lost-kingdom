package model;

import controller.GameRunnable;
import model.entity.Player;
import model.interactiveObject.Chest;
import model.interactiveObject.Door;
import model.interactiveObject.InteractiveObject;
import model.item.Crown;
import model.item.Item;
import model.item.Key;
import view.RoomRenderer;

import java.awt.*;
import java.util.ArrayList;

public class RoomManager {
    public Room[] rooms;

    private Room currentRoom;

    public RoomRenderer roomRenderer;


    public RoomManager(GameRunnable gameRunnable) {
        rooms=new Room[2];
        //TO MODIFY (json file ?)
        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(new Key(1));
        itemList1.get(0).setPosition(6* gameRunnable.tileSize,14* gameRunnable.tileSize);
        itemList1.add(new Key(2));
        itemList1.get(1).setPosition(4* gameRunnable.tileSize,4* gameRunnable.tileSize);

        ArrayList<InteractiveObject> interObjList1 = new ArrayList<>();
        interObjList1.add(new Door(1, gameRunnable.tileSize,5* gameRunnable.tileSize,false,(Key)itemList1.get(1)));
        interObjList1.add(new Door(2, 11* gameRunnable.tileSize,5* gameRunnable.tileSize,false,(Key)itemList1.get(0)));


        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(new Key(3));
        itemList2.get(0).setPosition(6* gameRunnable.tileSize,14* gameRunnable.tileSize);

        itemList2.add(new Key(4));
        itemList2.get(1).setPosition(4* gameRunnable.tileSize,4* gameRunnable.tileSize);

        ArrayList<InteractiveObject> interObjList2 = new ArrayList<>();
        interObjList2.add(new Chest(1, 12* gameRunnable.tileSize, gameRunnable.tileSize,false,(Key)itemList2.get(0),new Crown("Lost Crown",1)));
        interObjList2.add(new Door(3, 12* gameRunnable.tileSize,5* gameRunnable.tileSize,false,(Key)itemList2.get(1)));


        rooms[0]=new Room(gameRunnable,"testmap",itemList1,interObjList1);
        rooms[1]=new Room(gameRunnable,"testmap2",itemList2,interObjList2);
        currentRoom=rooms[0];
        roomRenderer = new RoomRenderer(currentRoom);
    }

    public void draw(Graphics2D g2) {
        roomRenderer.render(g2);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void switchRoom(Player player) {
        currentRoom=rooms[1]; //A selectionner en fonction de la position du player et de la liste rooms
        roomRenderer.setRoom(currentRoom);
        player.setDefaultValue();
    }

}
