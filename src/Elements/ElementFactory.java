package Elements;

import States.Conductor;
import States.Head;
import States.Isolator;
import States.Tail;

public class ElementFactory {

    public static Element buildElement (String element) {
            switch (element) {
                case "Isolator":
                    return new Cell(new Isolator());
                case "Head":
                    return new Cell(new Head());
                case "Tail":
                    return new Cell(new Tail());
                case "Conductor":
                    return new Cell(new Conductor());
                default:
                    return new Cell(new Isolator());
            }
    }
}
