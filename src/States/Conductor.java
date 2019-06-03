package States;


import java.awt.*;


public class Conductor implements State {

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public State nextState (int headsNumber) {
        if (headsNumber == 1 || headsNumber == 2) {
            return new Head();
        } else {
            return new Conductor();
        }
    }

}
