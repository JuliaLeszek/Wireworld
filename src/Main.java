import CA.Automaton;
import CA.Generation;
import CA.Saving;
import States.Conductor;
import States.Head;
import States.Tail;

import java.io.File;


public class Main {
    public static void main(String[] args) {

        File plik = new File("koncowaGeneracja.txt");

        Generation gen = new Generation(15, 15);
        Automaton auto = new Automaton(gen);
        gen.getCell(5, 5).setState(new Conductor());
        gen.getCell(6, 5).setState(new Tail());
        gen.getCell(7, 5).setState(new Head());
        gen.getCell(8, 5).setState(new Conductor());
        gen.getCell(9, 5).setState(new Conductor());
        gen.getCell(10, 5).setState(new Conductor());
        gen.getCell(11, 5).setState(new Conductor());
        gen.getCell(12, 5).setState(new Conductor());
        gen.getCell(13, 5).setState(new Conductor());


        for(int i=1; i < 10; i++ ) {

            auto.nextGeneration();
            gen = auto.getGeneration();
            System.out.println("krok " + i);
            System.out.println(gen.getCell(5, 5).getStateString());
            System.out.println(gen.getCell(6, 5).getStateString());
            System.out.println(gen.getCell(7, 5).getStateString());
            System.out.println(gen.getCell(8, 5).getStateString());
            System.out.println(gen.getCell(9, 5).getStateString());
            System.out.println(gen.getCell(10, 5).getStateString());
            System.out.println(gen.getCell(11, 5).getStateString());
            System.out.println(gen.getCell(12, 5).getStateString());
            System.out.println(gen.getCell(13, 5).getStateString());

        }


        Saving.save(gen, plik);

    }
}