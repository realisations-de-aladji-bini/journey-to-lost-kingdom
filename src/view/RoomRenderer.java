package view;

import model.Room;
import model.interactiveObject.InteractiveObject;
import model.item.Item;
import view.item.ItemRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class RoomRenderer {

    private Room room;


    public RoomRenderer(Room room) {
        this.room = room;
        getTileImage();
    }

    public void getTileImage(){
        try{
            room.tilesType[0]= new Tile(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/grass.png"))));
            room.tilesType[1]= new Tile(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/wall.png"))));
            room.tilesType[1].setCollision(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void render(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x =0;
        int y=0;

        while (row < room.getRoomSizeRow()){
            int tileType = room.getMapTile()[col][row];
            g2.drawImage(room.tilesType[tileType].getImage(),x,y,room.tileSize,room.tileSize,null);
            x+= room.tileSize;
            col++;
            if(col >= room.getRoomSizeCol()){
                col=0;
                row++;
                x=0;
                y+=room.tileSize;
            }
        }

        renderItem(g2);
        renderInterObject(g2);
    }

    public void renderItem(Graphics2D g2){
        for(Item item: room.itemInside){
            ItemRenderer ir=new ItemRenderer(item);
            ir.render(g2,room.tileSize);
        }
    }

    public void renderInterObject(Graphics2D g2){
        for(InteractiveObject obj: room.interObjectInside){
            obj.getRenderer().render(g2,room.tileSize);
        }
    }

    public void setRoom(Room room) {
        this.room = room;
        getTileImage();
    }

    public Room getRoom() {
        return room;
    }
}
