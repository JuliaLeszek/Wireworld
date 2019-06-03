package CA;

import Elements.Cell;
import States.Isolator;
import States.State;

public class Generation {
    private Cell[][] board;
    private final int height;
    private final int width;


    /*Konstruktor generacji o określonej wysokości i szerokości*/
    public Generation(int h, int w) {
        height = h;
        width = w;
        board = new Cell[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = new Cell(new Isolator());
            }
        }
    }

    public Generation buildGeneration() {
        Generation generation = new Generation(this.height, this.width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j].setState((getCell(i,j).getState()));
            }
        } return generation;
    }


    /*Wskazanie komórki*/
    public Cell getCell (int i, int j) {
        if (((i >= 0 && i < height) && j >= 0) && j < width) {
            return board[i][j];
        } else {
            return new Cell();
        }
    }

    /*Zliczanie ilości głów*/
    public int getHeadsNumber(int x, int y) {
        int result = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if ("Head".equals(getCell(i, j).getState())) {
                    result++;
                }
            }
        }
        return result;
    }


    /*Zwracanie kolejnej generacji*/
    public Generation nextGeneration() {
        int headsNumber;
        Generation next = buildGeneration();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                headsNumber = getHeadsNumber(i, j);
                next.board[i][j].setState((getCell(i,j).getState()));
            }
        }
        return next;
    }



}
