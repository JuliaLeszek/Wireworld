package Elements;

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
