import CA.Automaton;
import CA.Generation;
import States.Conductor;
import States.Head;
import States.Tail;

public class Main {
    public static void main(String[] args) {

        Generation gen = new Generation(10, 10);
        Automaton auto = new Automaton(gen);
        gen.getCell(5, 5).setState(new Conductor());
        gen.getCell(6, 5).setState(new Tail());
        gen.getCell(7, 5).setState(new Head());
        gen.getCell(8, 5).setState(new Conductor());

        System.out.println("krok 1");
        System.out.println(gen.getCell(5,5).getStateString());
        System.out.println(gen.getCell(6,5).getStateString());
        System.out.println(gen.getCell(7,5).getStateString());
        System.out.println(gen.getCell(8,5).getStateString());

        auto.nextGeneration();
        gen = auto.getGeneration();

        System.out.println("krok 2");
        System.out.println(gen.getCell(5,5).getStateString());
        System.out.println(gen.getCell(6,5).getStateString());
        System.out.println(gen.getCell(7,5).getStateString());
        System.out.println(gen.getCell(8,5).getStateString());

        System.out.println("krok 3");
        System.out.println((auto.getCommunity()).getCell(5,5).getStateString());
        System.out.println((auto.getCommunity()).getCell(6,5).getStateString());
        System.out.println((auto.getCommunity()).getCell(7,5).getStateString());
        System.out.println((auto.getCommunity()).getCell(8,5).getStateString());
    }
}