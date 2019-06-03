package States;

import java.awt.*;

public interface State {
    public State nextState(int heads);
    public Color getColor();
}
