package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    //Direction
    public boolean up;
    public boolean down;
    public boolean right;
    public boolean left;

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int pressedKey = keyEvent.getKeyCode();

        switch(pressedKey){
            case KeyEvent.VK_Z, KeyEvent.VK_UP -> up = true;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> down = true;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> right = true;
            case KeyEvent.VK_Q, KeyEvent.VK_LEFT -> left = true;


        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int pressedKey = keyEvent.getKeyCode();

        switch(pressedKey){
            case KeyEvent.VK_Z, KeyEvent.VK_UP -> up = false;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> down = false;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> right = false;
            case KeyEvent.VK_Q, KeyEvent.VK_LEFT -> left = false;

        }

    }
}
