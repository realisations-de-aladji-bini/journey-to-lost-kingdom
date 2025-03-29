package model.interactiveObject;

import model.entity.Entity;
import model.entity.Player;
import model.item.Key;
import view.interactiveObject.InteractiveObjectRenderer;

public class Door extends InteractiveObject{


    private Key linkedKey;

    public Door(int ID, int x, int y, boolean opened, Key key) {
        super(ID, x, y);
        setOpened(opened);
        this.setCollision(!opened);
        this.renderer=new InteractiveObjectRenderer(this);
        this.linkedKey = key;
    }

    public void open(){
        setOpened(true);
        this.setCollision(false);
    }

    public void close(){
        setOpened(false);
        this.setCollision(true);
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
            player.playerInventory.removeItem(linkedKey);
        }
    }
}
