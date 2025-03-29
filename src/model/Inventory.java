package model;

import model.item.Item;

import java.util.ArrayList;

public class Inventory {

    public int maxCapacity;

    ArrayList<Item> inventory = new ArrayList<Item>(maxCapacity);

    public void addItem(Item i){
        inventory.add(i);
    }

    public void removeItem(Item i){
        inventory.remove(i);
    }

    public ArrayList<Item> getListItem(){
        return inventory;
    }



}
