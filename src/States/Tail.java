package States;

import java.awt.*;

public class Tail implements State {

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public State nextState(int heads){
        return new Conductor();
    }

}
