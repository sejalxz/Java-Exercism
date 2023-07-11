import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PythagoreanTriplet {
    private final int a, b, c;
    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == obj.getClass())
            return this.hashCode() == obj.hashCode();
        return false;
    }
    public static ListWrapper makeTripletsList() {
        return new ListWrapper();
    }
}
class ListWrapper {
    private final List<PythagoreanTriplet> triplets = new ArrayList<>();
    private int total;
    private int maxFactor = Integer.MAX_VALUE;
    public ListWrapper thatSumTo(int total) {
        this.total = total;
        if (maxFactor == Integer.MAX_VALUE) this.maxFactor = total;
        return this;
    }
    public ListWrapper withFactorsLessThanOrEqualTo(int maxFactor) {
        this.maxFactor = maxFactor;
        return this;
    }
    public List<PythagoreanTriplet> build() {
        for (int a = 1; a <= maxFactor; a++) {
            for (int b = a; b <= maxFactor; b++) {
                int c = total - a - b;
                if (c > maxFactor) continue;
                if (isTriplet(a, b, c)) {
                    triplets.add(new PythagoreanTriplet(a, b, c));
                }
            }
        }
        return triplets;
    }
    private boolean isTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}