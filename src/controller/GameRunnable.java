package controller;

import model.entity.Player;
import model.Room;
import model.RoomManager;

import javax.swing.*;
import java.awt.*;

public class GameRunnable extends JPanel implements Runnable{


    //Tiles Size
    private final int tileSizeOG = 16; //16x16 tile
    private final int scale = 3;
    public final int tileSize = tileSizeOG * scale; //Soit 48x48 tile

    //Screen Size
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //KeyListener
    KeyManager keyManager = new KeyManager();



    //Background Tiles
    private final RoomManager roomManager = new RoomManager(this);

    public Player player = new Player(this,keyManager);

    //Thread
    Thread gameThread;


    //FPS
    final int FPS = 60;


    public GameRunnable(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyManager);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double delta = 0;
        double interval = (double) 1000000000 /FPS;  //
        long currentTime;
        long lastTime = System.nanoTime();

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) /interval;

            lastTime = currentTime;
            if(delta >= 1 ){
                //System.out.println(delta);
                update();
                repaint();
                delta--;
            }


        }

    }

    public void update(){
        player.update();
    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //Cast g as Graphics2D

        roomManager.draw(g2); //First to be background
        player.draw(g2);

        g2.dispose(); //Memoire
    }

    public RoomManager getRoomManager() {
        return roomManager;
    }

    public Room getRoom(){
        return roomManager.getCurrentRoom();
    }
}

