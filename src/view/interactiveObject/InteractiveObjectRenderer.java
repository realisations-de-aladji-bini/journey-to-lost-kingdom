package view.interactiveObject;

import model.interactiveObject.Chest;
import model.interactiveObject.Door;

import model.interactiveObject.InteractiveObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class InteractiveObjectRenderer {

    private final InteractiveObject obj;

    public BufferedImage imageClose;
    public BufferedImage imageOpen;

    public InteractiveObjectRenderer(InteractiveObject obj) {
        this.obj = obj;
        setImage();
    }

    public void setImage(){
        try {
            if( obj instanceof Chest) {
                this.imageClose = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/interactiveObject/chest-close.png")));
                this.imageOpen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/interactiveObject/chest-open.png")));
            }
            if (obj instanceof Door){
                this.imageClose= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/interactiveObject/door-close.png")));
                this.imageOpen= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/interactiveObject/door-open.png")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void render(Graphics2D g2, int tileSize){
        if(obj.isOpen()){
            g2.drawImage(imageOpen,obj.getX(),obj.getY(),tileSize,tileSize,null);
        }
        else{
            g2.drawImage(imageClose,obj.getX(),obj.getY(),tileSize,tileSize,null);
        }
    }
}
