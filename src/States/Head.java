package States;

import java.awt.*;

public class Head implements State{

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public State nextState(int headsNumber){
        return new Tail();
    }
}
