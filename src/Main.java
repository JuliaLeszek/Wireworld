import Elements.Cell;
import States.Isolator;

public class Main {
    public static void main(String[] args) {

        Cell kom = new Cell(new Isolator());
        System.out.println(kom.getState());
    }
}