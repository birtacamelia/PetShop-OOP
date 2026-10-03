import java.util.Comparator;

public class ComparatorPopularitate implements Comparator<Produs> {
    @Override
    public int compare(Produs p1,Produs p2)
    {
        if (p1.getPopularitate() < p2.getPopularitate())
            return -1;
        else if (p1.getPopularitate() == p2.getPopularitate())
            return 0;
        else
            return 1;
    }
}
