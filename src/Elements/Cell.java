package Elements;

import CA.Generation;
import States.Isolator;
import States.State;

public class Cell implements Element {

    private State state;

    /*Konstruktor komórki z określonym stanem*/
    public Cell (State state) {
        this.state = state;
    }

    /*Konstruktor komórki*/
    public Cell () {
        state = new Isolator();
    }

    /* Zwraca następny stan komórki*/
    public void nextState (int headsNumber) {
        state = state.nextState(headsNumber);
    }

    /* */
    @Override
    public void  setElementOnBoard(int x, int y, Generation generation){
        generation.setCellState (x, y, state);
    }


    /*Gettery i Settery*/
    public String getStateString() {
        return state.getClass().getSimpleName();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
