import CA.Generation;
import Elements.Cell;
import States.Conductor;
import States.Head;
import States.Isolator;
import States.Tail;

public class Main {
    public static void main(String[] args) {

        Generation gen = new Generation(10, 10);
        gen.getCell(5, 5).setState(new Conductor());
        gen.getCell(6, 5).setState(new Tail());
        gen.getCell(7, 5).setState(new Head());
        gen.getCell(8, 5).setState(new Conductor());

        System.out.println("krok 1");
        System.out.println(gen.getCell(5,5).getStateString());
        System.out.println(gen.getCell(6,5).getStateString());
        System.out.println(gen.getCell(7,5).getStateString());
        System.out.println(gen.getCell(8,5).getStateString());
        System.out.println("krok 2");
        System.out.println(gen.getCell(5,5).getState().nextState(gen.getHeadsNumber(5,5)));
        System.out.println(gen.getCell(6,5).getState().nextState(gen.getHeadsNumber(6,5)));
        System.out.println(gen.getCell(7,5).getState().nextState(gen.getHeadsNumber(7,5)));
        System.out.println(gen.getCell(8,5).getState().nextState(gen.getHeadsNumber(8,5)));
    }
}