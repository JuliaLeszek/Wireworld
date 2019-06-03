package States;

import java.awt.*;

public interface State {
    public State nextState(int headsNumber);
    public Color getColor();
}
