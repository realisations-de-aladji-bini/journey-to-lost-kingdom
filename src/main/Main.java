package main;

import controller.GameRunnable;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Journey to the Lost Kingdom");


        GameRunnable gameRunnable = new GameRunnable();
        window.add(gameRunnable);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gameRunnable.startGameThread();

    }
}
