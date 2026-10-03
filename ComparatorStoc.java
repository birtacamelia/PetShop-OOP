import java.util.Comparator;

public class ComparatorStoc implements Comparator<Produs> {
    @Override
    public int compare(Produs p1, Produs p2) {
        if (p1.getStoc() < p2.getStoc())
            return -1;
        else if (p1.getStoc() == p2.getStoc())
            return 0;
        else
            return 1;
    }
}
