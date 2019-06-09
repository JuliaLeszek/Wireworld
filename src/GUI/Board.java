package GUI;

import CA.Generation;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Generation generation;
    private int boardHeight = 600;
    private int boardWidth = 600;
    private int squareSize = 10;


    /*konstruktor*/
    public Board (Generation generation) {
        this.generation = generation;
    }

    /*ustawianie generacji przy repaincie*/
    public void setGeneration (Generation generation) {
        this.generation = generation;
    }

    @Override
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);

        squareSize = boardHeight/generation.getHeight();

        /*rysowanie planszy*/
        for (int i = 0; i < generation.getHeight(); i++) {
            for (int j = 0; j < generation.getWidth(); j++) {
                graphics.setColor(generation.getCell(i,j).getColor());
                graphics.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }


        /*rysowanie siatki*/
        graphics.setColor(Color.darkGray);
        for (int i = 0; i < generation.getHeight(); i++) {
            graphics.fillRect(i * squareSize, 0, 1, generation.getHeight() * squareSize);
        }
        for (int i = 0; i < generation.getWidth(); i++) {
            graphics.fillRect(0, i * squareSize, generation.getWidth() * squareSize, 1);
        }

    }
}
