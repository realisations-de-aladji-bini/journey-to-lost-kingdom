package view.item;

import model.item.Crown;
import model.item.Item;
import model.item.Key;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ItemRenderer {

    private final Item item;

    public BufferedImage texture;

    public ItemRenderer(Item item) {
        this.item=item;
        try {
            if(item instanceof Key){
                texture= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/item/key.png")));
            }
            else if(item instanceof Crown){
                texture= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/item/crown.png")));
            }
            else{
               texture=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TODO.png")));
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void render(Graphics2D g2, int tileSize) {
        g2.drawImage(texture,item.x,item.y,tileSize,tileSize,null);
    }

    public Item getItem() {
        return item;
    }
}
