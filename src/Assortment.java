import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assortment {
    List<Product> assortment = new ArrayList<>();


    public Assortment addProduct(Product product) {
        assortment.add(product);
        return this;
    }

    public Assortment sortList() {
        assortment = assortment.stream()
                .sorted(new ProductComparator())
                .collect(Collectors.toList());
        return this;
    }

    public void deleteProduct(int number) {
        assortment.remove(number);
    }

    public Product getProduct(int index) {
        return assortment.get(index);
    }


    public void toPrint() {
        System.out.println("Товары, доступные для заказа");
        if (!assortment.isEmpty()) {
            int category = -1;
            for (int i = 0; i < assortment.size(); i++) {
                int categoryCurrent = assortment.get(i).getCategory().ordinal();
                if (categoryCurrent != category) {
                    System.out.println(assortment.get(i).getCategory());
                    category = categoryCurrent;
                }
                System.out.println(" " + (i + 1) + "." + assortment.get(i));
                System.out.println();
            }
        } else {
            System.out.println("Список пуст");
            System.out.println();
        }
    }

    public void findProduct(String partProductName) {
        System.out.println("Поиск товаров, содержащих '" + partProductName + "':");
        findProductByName(partProductName);
        findProductByBrand(partProductName);
    }

    public void findProductByName(String partProductName) {
        List<Product> list = new ArrayList<>();
        System.out.println("Совпадение в названии ТОВАРА:");
        for (int i = 0; i < assortment.size(); i++) {
            if (assortment.get(i).getProductName().toLowerCase().contains(partProductName.toLowerCase()) &&
                    (assortment.get(i).getTotalAmount() != 0)) {
                System.out.println(" " + (i + 1) + "." + assortment.get(i));
                list.add(assortment.get(i));
            }
        }
        if (list.isEmpty()) {
            System.out.println("Совпадений не найдено");
        }
        System.out.println();
    }

    public void findProductByBrand(String partProductName) {
        List<Product> list = new ArrayList<>();
        System.out.println("Совпадение в названии ПРОИЗВОДИТЕЛЯ:");
        for (int i = 0; i < assortment.size(); i++) {
            if (assortment.get(i).getBrandName().toLowerCase().contains(partProductName.toLowerCase()) &&
                    (assortment.get(i).getTotalAmount() != 0)) {
                System.out.println(" " + (i + 1) + "." + assortment.get(i));
                list.add(assortment.get(i));
            }
        }
        if (list.isEmpty()) {
            System.out.println("Совпадений не найдено");
        }
        System.out.println();
    }

    public void priceFilter(int price) {
        List<Product> list = assortment.stream()
                .filter(x -> x.getPrice() <= price)
                .collect(Collectors.toList());
        toPrintHelper(list);
    }

    public void toPrintHelper(List<Product> list) {
        if (!list.isEmpty()) {
            int category = -1;
            for (Product product : list) {
                int categoryCurrent = product.getCategory().ordinal();
                if (categoryCurrent != category) {
                    System.out.println(product.getCategory());
                    category = categoryCurrent;
                }
                for (int j = 0; j < assortment.size(); j++) {
                    if (assortment.get(j).equals(product)) {
                        System.out.println(" " + (j + 1) + "." + product);
                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("Список пуст");
            System.out.println();
        }
    }
}
