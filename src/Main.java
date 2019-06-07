import CA.Automaton;
import CA.Generation;
import CA.Loading;
import CA.Saving;

import java.io.File;


public class Main {
    public static void main(String[] args) {

        File out = new File("koncowaGeneracja.txt");
        File in = new File("wsad.txt");

        Generation gen =  Loading.load(in);
        Automaton auto = new Automaton(gen);



        for(int i=1; i < 3

                ; i++ ) {

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


        Saving.save(gen, out);

    }
}