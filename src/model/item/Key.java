package model.item;

public class Key extends Item{
    public Key(String name,int ID){
        super(name,ID,10,1);
    }
    public Key(int ID){
        this("key:"+ID,ID);
    }

}
