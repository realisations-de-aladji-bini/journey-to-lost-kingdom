package model;

import controller.GameRunnable;
import model.interactiveObject.InteractiveObject;
import model.item.Item;
import view.Tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Room {
    public Tile[] tilesType;
    final int numberOfTilesType =2; //Number of different type of tiles;

    private final int[][] mapTile;

    public int tileSize;

    public ArrayList<Item> itemInside = new ArrayList<Item>(10);

    public ArrayList<InteractiveObject> interObjectInside = new ArrayList<>(10);

    public Room(GameRunnable gp, String mapName, ArrayList<Item> itemList, ArrayList<InteractiveObject> interObjectList){
        tilesType = new Tile[numberOfTilesType];
        mapTile = new int[gp.maxScreenCol][gp.maxScreenRow];
        tileSize=gp.tileSize;
        loadMap("/map/"+mapName+".txt");
        setItem(itemList);
        setInteractiveObject(interObjectList);
    }

    public void loadMap(String mapPath){
        try {
            InputStream mapFile = Objects.requireNonNull(getClass().getResourceAsStream(mapPath));
            BufferedReader mapBR = new BufferedReader(new InputStreamReader(mapFile));
            int col = 0;
            int row = 0;
            while (col < getRoomSizeCol() && row < getRoomSizeRow()){
                String line = mapBR.readLine();
                while (col < getRoomSizeCol()){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTile[col][row] = num;
                    col++;
                }
                if (col==getRoomSizeCol()){
                    col=0;
                    row++;
                }
            }
            mapBR.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public void setItem(ArrayList<Item> itemList){
        if(itemList != null){
            itemInside.addAll(itemList);
        }
    }

    public void setInteractiveObject(ArrayList<InteractiveObject> interactiveObjectList){
        if(interactiveObjectList != null){
            interObjectInside.addAll(interactiveObjectList);
        }
    }

    public Iterator<Item> getItemInsideIterator() {
        return itemInside.iterator();
    }

    public Iterator<InteractiveObject> getInterObjectInsideIterator() {
        return interObjectInside.iterator();
    }

    public Item removeItem(Item i){
        itemInside.remove(i);
        return i;
    }


    public int[][] getMapTile() {
        return mapTile;
    }

    public Tile[] getTilesType() {
        return tilesType;
    }

    public int getRoomSizeCol(){
        return mapTile.length;
    }

    public int getRoomSizeRow(){
        return mapTile[0].length;
    }



}
