package CA;

import Elements.Cell;
import Elements.Element;
import Elements.ElementFactory;
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
                generation.setElementOnBoard(i, j, ElementFactory.buildElement(getCell(i, j).getStateString()));
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
                if ("Head".equals(getCell(i, j).getStateString())) {
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
                next.board[i][j].nextState(headsNumber);
            }
        }
        return next;
    }

    /*Dodaj element do tablicy*/
    public void setElementOnBoard  (int i, int j, Element element) {
        element.setElementOnBoard(i,j, this);
    }

    /*Method that sets the state of given cell; i - row, j - col*/
    public void setCellState (int i, int j, State state) {
        if ( i < height && i >= 0 && j < width && j >= 0) {
            board[i][j].setState(state);
        }
    }

    /* Zwracają wymiary generacji*/
    public int getHeight() {
        return height;
    }

    public int getWidth () {
        return width;
    }


}
