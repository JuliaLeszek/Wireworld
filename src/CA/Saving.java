package CA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Saving {

    public static void save(Generation generation, File file) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.println(generation.getHeight() + " " + generation.getWidth() + "\n");
            for (int i = 0; i < generation.getHeight(); i++) {
                for (int j = 0; j < generation.getWidth(); j++) {
                    if (!generation.getCell(i, j).getStateString().equals("Isolator")) {
                        writer.println(generation.getCell(i, j).getStateString() + " " + (i + 1) + " " + (j + 1) + "\n");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e + " File " + file + " does not exist!");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
