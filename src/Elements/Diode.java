package Elements;

import CA.Generation;
import States.Conductor;

public class Diode implements Element {

    @Override
    public void setElementOnBoard(int i, int j, Generation generation) {
            generation.setCellState(i, j, new Conductor());
            generation.setCellState(i - 1, j, new Conductor());
            generation.setCellState(i - 2, j, new Conductor());
            generation.setCellState(i, j - 1, new Conductor());
            generation.setCellState(i, j + 1, new Conductor());
            generation.setCellState(i + 1, j - 1, new Conductor());
            generation.setCellState(i + 2, j, new Conductor());
            generation.setCellState(i + 1, j + 1, new Conductor());
            generation.setCellState(i + 3, j, new Conductor());
        }
    }

