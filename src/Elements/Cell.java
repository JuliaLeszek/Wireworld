package Elements;

import States.State;

public class Cell implements Element {

    private State state;

    /*Konstruktor komórki z określonym stanem*/
    public Cell (State state) {
        this.state = state;
    }



    /*Gettery i Settery*/
    public String getState() {
        return state.getClass().getSimpleName();
    }

    public void setState(State state) {
        this.state = state;
    }
}
