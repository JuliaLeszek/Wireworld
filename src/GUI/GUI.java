package GUI;

import CA.Automaton;
import CA.Generation;
import CA.Loading;
import CA.Saving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI extends JFrame {

    private JButton startBtn, nextGenBtn, stopBtn, loadBtn, saveBtn, resetBtn;
    private Color btnColor = new Color(63, 82, 176);
    private int btnHeight = 70;
    private int btnWidth = 100;
    private JLabel lblSteps;
    private JTextField inputSteps;
    private Automaton automaton;
    private Generation generationCopy;
    private boolean stopped;
    private int defaultSteps;
    private Board board;
    private final JFileChooser fileChooser = new JFileChooser();


    public GUI() {

        stopped = true;
        defaultSteps = 10;

        Generation gen = new Generation(75, 75);
        automaton = new Automaton(gen);
        generationCopy = gen;
        automaton.setGeneration(gen);


        initializeWindow();
        initializeMenu();
        initializeBoard();

    }

    private void initializeWindow() {
        setSize(900, 700);
        setTitle("WireWorld - Julia Leszek");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    private void initializeMenu() {

        /*przycisk start*/
        startBtn = new JButton("Start");
        startBtn.setBackground(btnColor);
        startBtn.setForeground(Color.white);
        startBtn.setBounds(650, 50, btnWidth, btnHeight);
        startBtn.setFocusPainted(false);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        add(startBtn);

        /*przycisk stop*/
        stopBtn = new JButton("Stop");
        stopBtn.setBackground(btnColor);
        stopBtn.setForeground(Color.white);
        stopBtn.setBounds(760, 50, btnWidth, btnHeight);
        stopBtn.setFocusPainted(false);
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopped = true;
            }
        });
        add(stopBtn);

        /*następna generacja*/
        nextGenBtn = new JButton("Następna generacja");
        nextGenBtn.setBackground(btnColor);
        nextGenBtn.setForeground(Color.white);
        nextGenBtn.setBounds(650, 150, btnWidth * 2 + 10, btnHeight);
        nextGenBtn.setFocusPainted(false);
        nextGenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                automaton.nextGeneration();
                refreshBoard();
            }
        });
        add(nextGenBtn);

        /*przycisk reset*/
        resetBtn = new JButton("Resetuj");
        resetBtn.setBackground(btnColor);
        resetBtn.setForeground(Color.white);
        resetBtn.setBounds(650, 450, btnWidth * 2 + 10, btnHeight);
        resetBtn.setFocusPainted(false);
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopped = true;
                automaton.setGeneration(generationCopy);
                automaton.setNumberOfSteps(defaultSteps);
                inputSteps.setText(String.valueOf(defaultSteps));
                refreshBoard();
            }
        });
        add(resetBtn);

        /*przycisk wczytaj*/
        loadBtn = new JButton("Wczytaj");
        loadBtn.setBackground(btnColor);
        loadBtn.setForeground(Color.white);
        loadBtn.setBounds(650, 550, btnWidth, btnHeight);
        loadBtn.setFocusPainted(false);
        loadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopped= true;
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File picked = fileChooser.getSelectedFile();
                    automaton.setGeneration(Loading.load(picked));
                    refreshBoard();
                }
            }
        });
        add(loadBtn);

        /*przycisk zapisz*/
        saveBtn = new JButton("Zapisz");
        saveBtn.setBackground(btnColor);
        saveBtn.setForeground(Color.white);
        saveBtn.setBounds(760, 550, btnWidth, btnHeight);
        saveBtn.setFocusPainted(false);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopped = true;
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File save = fileChooser.getSelectedFile();
                    Saving.save(automaton.getGeneration(), save);
                }
            }
        });
        add(saveBtn);

        /*liczba krokow*/
        lblSteps = new JLabel("Liczba kroków");
        lblSteps.setBounds(650, 250, 100, 20);
        add(lblSteps);

        /*liczba krokow- pole tekstowe*/
        inputSteps = new JTextField();
        inputSteps.setBounds(820, 250, 40, 20);
        inputSteps.setText(String.valueOf(defaultSteps));
        inputSteps.setHorizontalAlignment(JTextField.CENTER);
        add(inputSteps);
    }


    private void start() {
        if (stopped) {
            stopped = false;
            new Thread() {
                @Override
                public void run() {
                    automaton.setNumberOfSteps(Long.parseLong(inputSteps.getText()));
                    while (automaton.getNumberOfSteps() > 0 && !stopped) {
                        automaton.nextGeneration();
                        inputSteps.setText(String.valueOf(automaton.getNumberOfSteps()));
                        refreshBoard();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }.start();
        }
    }

    private void initializeBoard() {
        board = new Board(automaton.getGeneration());
        board.setBounds(20, 40, 600, 600);
        add(board);
    }

    private void refreshBoard() {
        board.setGeneration(automaton.getGeneration());
        board.repaint();
    }
}
