package model.interactiveObject;

import model.entity.Entity;
import model.entity.Player;
import model.item.Item;
import model.item.Key;
import view.interactiveObject.InteractiveObjectRenderer;

public class Chest extends InteractiveObject{
    private Key linkedKey;

    private Item contentItem;

    public Chest(int ID, int x, int y, boolean opened, Key key, Item contentItem) {
        super(ID, x, y);
        setCollision(true);
        setOpened(opened);
        this.renderer=new InteractiveObjectRenderer(this);
        this.linkedKey = key;
        this.contentItem = contentItem;
    }

    public void open(){
        setOpened(true);
    }

    public void close(){
        setOpened(false);
    }


    @Override
    public void interact(Entity entity) {
        if(entity instanceof Player){
            interact((Player) entity);
        }
    }

    public void interact(Player player){
        if(player.playerInventory.getListItem().contains(linkedKey)){
            open();
            if(contentItem!= null){
                player.playerInventory.addItem(contentItem);
                player.playerInventory.removeItem(linkedKey);
                contentItem=null;
            }
        }
    }


    public Chest(int ID, int x, int y) {
        super(ID, x, y);
    }
}
