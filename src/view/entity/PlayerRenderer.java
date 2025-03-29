package view.entity;

import model.entity.Player;
import model.item.Item;
import view.item.ItemRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerRenderer extends EntityRenderer {

    private final Player player;

    public PlayerRenderer(Player player) {
        this.player = player;
        getPlayerImage();
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/back-0.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/back-1.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/front-0.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/front-1.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/right-0.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/right-1.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/left-0.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/left-1.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void render(Graphics2D g2){
        BufferedImage image = null;
        switch (player.direction) {
            case UP :
                if(player.spriteNb==1){ image = up1;}
                else {image = up2 ;}
                break;
            case DOWN :
                if(player.spriteNb==1){ image = down1;}
                else {image = down2 ;}
                break;
            case RIGHT :
                if(player.spriteNb==1){ image = right1;}
                else {image = right2 ;}
                break;
            case LEFT :
                if(player.spriteNb==1){ image = left1;}
                else {image = left2 ;}
                break;
        }
        g2.drawImage(image,player.x,player.y, tileSize, tileSize,null);
        if(visibleHitBox){
            g2.fillRect(player.hitBox.x,player.hitBox.y, player.hitBox.width, player.hitBox.height);
        }

        renderInventory(g2);
    }

    public void renderInventory(Graphics2D g2){
        int inventoryY=40;
        for(Item item : player.playerInventory.getListItem()){
            if(item !=null) {
                ItemRenderer itemR = new ItemRenderer(item);
                g2.drawImage(itemR.texture, 10, inventoryY, 32, 32, null);
            }
            inventoryY+=40;
        }
    }
}
