import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getCategory().ordinal(), o2.getCategory().ordinal());
    }
}
