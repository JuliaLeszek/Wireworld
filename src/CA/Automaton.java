package CA;

public class Automaton {

    private Generation current;
    private Generation next;
    private long n;

    /*Konstruktor z domyślnymi ustawieniami*/
    public Automaton() {
        current = new Generation(75, 75);
        next = null;
        n = 10;
    }

    /*Konstruktor automatu*/
    public Automaton(Generation generation) {
        current = generation;
        next = null;
        n = 10;
    }

    /*Tworzenie kolejnej generacji*/
    public void nextGeneration() {
        if (n > 0) {
            next = current.nextGeneration();
            Generation temp = current;
            current = next;
            next = temp;
            n--;
        }
    }

    /*Tworzenie kolejnych generacji*/
    public void start () {
        while (n > 0) {
            nextGeneration();
        }
    }

    /*Ustawianie populacji w automacie*/
    public void setGeneration(Generation generation) {
        current = generation;
    }

    /*Zwracanie uchwytu do ustawionego społeczeństwa*/
    public Generation getGeneration() {
        return current;
    }

    /*Ustawianie liczby kroków*/
    public void setNumberOfSteps(long n) {
        this.n = n;
    }

    public long getNumberOfSteps() {
        return n;
    }


}
