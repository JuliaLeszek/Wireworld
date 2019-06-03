package States;

import java.awt.*;

public class Isolator implements State{

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public State nextState(int headsNumber){
        return new Isolator();
    }
}
