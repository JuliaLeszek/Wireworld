package CA;

import Elements.ElementFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loading {

        public static Generation load(File file) {
            Generation generation = null;
            Scanner in = null;
            String line;
            String[] splited;
            try {
                in = new Scanner(file);
                line = in.nextLine();
                splited = line.split(" ");

                try {
                    generation = new Generation(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
                } catch (NumberFormatException n) {
                    System.err.println(n + " Given data in line " + line + " are not numbers!");
                    generation = new Generation(75, 75);
                } catch (ArrayIndexOutOfBoundsException a) {
                    System.err.println(a + " Too little data in line " + line + ".");
                    generation = new Generation(75, 75);
                }

                while (in.hasNext()) {
                    try {
                        line = in.nextLine();
                        if (line.length() != 0) {
                            splited = line.split("\\s+"); // białe znaki
                            System.out.println(line);
                            //System.out.println(Integer.parseInt(splited[1], 10));
                            generation.setElementOnBoard(Integer.parseInt(splited[1], 10), Integer.parseInt(splited[2], 10), ElementFactory.buildElement(splited[0]));
                        }
                    } catch (NumberFormatException ex) {
                        System.err.println(ex + " Line " + line + " ignored. Given arguments are not digits.");
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.err.println(ex + " Line " + line + " ignored. Too few arguments.");
                    }
                }

            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            } finally {
                if (in != null) {
                    in.close();
                }
            }
            return generation;
        }
}
