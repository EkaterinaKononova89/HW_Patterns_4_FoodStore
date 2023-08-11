import java.util.HashMap;
import java.util.Map;

public class Basket implements Oderable {
    Map<Integer, Product> basket = new HashMap<>();

    public void addProduct(Assortment assortment, int index, int amount) { // для отмены заказа ввести
        int i = index - 1;
        int totalAmount = assortment.getProduct(i).getTotalAmount();
        if (amount <= totalAmount) {
            if (!basket.isEmpty()) {
                for (Map.Entry<Integer, Product> kv : basket.entrySet()) {
                    if (kv.getValue().equals(assortment.getProduct(i))) {
                        basket.replace(index, basket.get(index), new Product(basket.get(index).getCategory(),
                                basket.get(index).getProductName(), basket.get(index).getBrandName(), basket.get(index).getWeightOrVolume(),
                                basket.get(index).getUnits(), basket.get(index).getPrice(),
                                (basket.get(index).getTotalAmount() + amount)));
                        assortment.getProduct(i).setTotalAmount(totalAmount - amount); // поменяла общее количество доступное для заказа
                        System.out.println("ДОБАВЛЕНО: " + assortment.getProduct(i).getProductName() + ", " +
                                assortment.getProduct(i).getBrandName());
                    }
                }
            }
            Product productInBasket = new Product(assortment.getProduct(i).getCategory(),
                    assortment.getProduct(i).getProductName(), assortment.getProduct(i).getBrandName(),
                    assortment.getProduct(i).getWeightOrVolume(),
                    assortment.getProduct(i).getUnits(), assortment.getProduct(i).getPrice(), amount);
            basket.put(index, productInBasket);
            assortment.getProduct(i).setTotalAmount(totalAmount - amount); // поменяла общее количество доступное для заказа
            System.out.println("ДОБАВЛЕНО: " + assortment.getProduct(i).getProductName() + ", " +
                    assortment.getProduct(i).getBrandName());
        } else {
            System.out.println("Нет такого количества");
        }
    }

    public Basket deleteProduct(Assortment assortment, int index, int amount) {
        int i = index - 1;
        int amountInBasket = basket.get(index).getTotalAmount();
        int totalAmount = assortment.getProduct(i).getTotalAmount();
        if (amount < amountInBasket) {
            basket.get(index).setTotalAmount(amountInBasket - amount);
            assortment.getProduct(i).setTotalAmount(totalAmount + amount);
            System.out.println("КОЛ-ВО ТОВАРА В КОРЗИНЕ УМЕНЬШЕНО: " + assortment.getProduct(i).getProductName() + ", " +
                    assortment.getProduct(i).getBrandName());
        } else if (amount == amountInBasket) {
            basket.remove(index);
            assortment.getProduct(i).setTotalAmount(totalAmount + amount);
            System.out.println("ТОВАР УДАЛЕН ИЗ КОРЗИНЫ: " + assortment.getProduct(i).getProductName() + ", " +
                    assortment.getProduct(i).getBrandName());
        } else {
            System.out.println("СЛИШКОМ БОЛЬШОЕ ЧИСЛО, В КОРЗИНЕ МЕНЬШЕ.");
        }
        return this;
    }

    @Override
    public double totalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Integer, Product> kv : basket.entrySet()) {
            totalPrice += kv.getValue().getPrice() * kv.getValue().getTotalAmount();
        }
        return totalPrice;
    }

    public void toPrint() {
        basket.forEach((k, v) -> System.out.println("\n   " + v + ",               кол-во в корзине: " + v.getTotalAmount()));
        System.out.println();
        System.out.println("                                     ВСЕГО позиций в корзине: " + basket.size());
        System.out.println("                                     ИТОГОВАЯ СУММА КОРЗИНЫ: " + totalPrice() + " руб.");
    }
}

