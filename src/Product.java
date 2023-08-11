import java.util.Objects;

public class Product {
    private final Category category;
    private final String productName;
    private final String brandName;
    private double price;
    private double weightOrVolume;
    private String units;
    private int totalAmount;

    public Product(Category category, String productName, String brandName, double weightOrVolume, String units,
                   double price, int totalAmount) {
        this.category = category;
        this.productName = productName;
        this.brandName = brandName;
        this.weightOrVolume = weightOrVolume;
        this.units = units;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public Category getCategory() {
        return category;
    }

    public double getWeightOrVolume() {
        return weightOrVolume;
    }

    public String getUnits() {
        return units;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int amount) { // предусмотреть случаи отрицательного ввода числа
        this.totalAmount = amount;
    }

    public String toString() {
        return //"Категория: " + this.category +
                "Наименование товара: " + this.productName +
                        ",\n   Производитель: " + this.brandName +
                        ",\n   Цена: " + this.price + " руб. " +
                        ",\n   Вес/объем: " + this.weightOrVolume + " " + this.units;
    }

    @Override
    public boolean equals(Object obj) {
        Product o = (Product) obj;
        return category.equals(category) && productName.equals(o.productName) && brandName.equals(o.brandName) &&
                price == (o.price) && weightOrVolume == (o.weightOrVolume) && units.equals(o.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, productName, brandName, price, weightOrVolume, units);
    }
}
