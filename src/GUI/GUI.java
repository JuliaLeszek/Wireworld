package GUI;

import CA.Automaton;
import CA.Generation;
import States.Conductor;
import States.Head;
import States.Tail;

import javax.swing.*;

public class GUI extends JFrame {

    private Automaton automaton;
    private Generation generation;
    private Generation generationCopy;
    private boolean stopped;
    private int defaultSteps;

    public GUI() {

        automaton = new Automaton();
        generation = new Generation(75, 75);
        stopped = true;
        defaultSteps = 10;



        initializeWindow();


        automaton.setGeneration(generation);

        generation.getCell(5, 5).setState(new Conductor());
        generation.getCell(6, 5).setState(new Tail());
        generation.getCell(7, 5).setState(new Head());
        generation.getCell(8, 5).setState(new Conductor());
        generation.getCell(9, 5).setState(new Conductor());
        generation.getCell(10, 5).setState(new Conductor());
        generation.getCell(11, 5).setState(new Conductor());
        generation.getCell(12, 5).setState(new Conductor());
        generation.getCell(13, 5).setState(new Conductor());

        generationCopy = generation;

    }

    private void initializeWindow() {
        setSize(900, 700);
        setTitle("WireWorld - Julia Leszek");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
}
