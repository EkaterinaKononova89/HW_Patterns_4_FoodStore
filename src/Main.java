import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Assortment assortment = new Assortment()
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Сыр сливочный", "Сыробогатов",
                        200, "г", 199.99, 20))
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Масло сливочное 82,5%", "Сыробогатов",
                        175, "г", 179, 30))
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Масло сливочное 72,5%", "Ирбитский молочный завод",
                        180, "г", 149.99, 30))
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Масло сливочное 82,5%", "Ирбитский молочный завод",
                        180, "г", 171.49, 30))
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Молоко 2,5%", "Простоквашино",
                        930, "мл", 79.99, 50))
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Молоко 3,2%", "Ирбитский молочный завод",
                        0.9, "л", 54.99, 50))
                .addProduct(new Product(Category.MILK_CHEESE_EGS, "Сметана 20%", "Простоквашино",
                        300, "г", 160.49, 49))
                .addProduct(new Product(Category.BAKERY_PRODUCTS, "Хлеб крестьянский", "Хлебозавод №7",
                        500, "г", 35, 60))
                .addProduct(new Product(Category.BAKERY_PRODUCTS, "Хлеб бородинский", "СМАК",
                        350, "г", 31.49, 50))
                .addProduct(new Product(Category.BAKERY_PRODUCTS, "Кекс Свердловский", "Реж-хлеб",
                        500, "г", 126.99, 20))
                .addProduct(new Product(Category.FRUITS_VEGETABLES, "Огурцы короткоплодные", "УГМК-Агро",
                        1, "кг", 78, 50))
                .sortList();

        Basket basket = new Basket();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в магазин!");
        System.out.println();

        boolean oder = true;
        while (oder) {
            System.out.println("Для ознакомления с полным списком товаров нажмите '1', для поиска товара по части названия " +
                    "товара/производителя нажмите '2', для фильтрации товара по цене введите '7' . ");                                              // end, filter
            System.out.println("Для добавления в корзину нажмите '3' ");
            System.out.println("* для выхода введите 'end' ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "end":
                    System.out.println("Хорошего дня!");
                    oder = false;
                    break;
                case "1":
                    assortment.toPrint();
                    break;
                case "2":
                    System.out.println("Введите часть названия товара/производителя");
                    String partProductName = scanner.nextLine();
                    assortment.findProduct(partProductName);
                    break;
                case "3":
                    System.out.println("Введите номер товара, который хотите добавить, и через пробел укажите его кол-во ");
                    String indexAndAmountAdd = scanner.nextLine();
                    String[] addToBasket = indexAndAmountAdd.split(" ");
                    int indexOfProductAdd = Integer.parseInt(addToBasket[0]);
                    int amountAdd = Integer.parseInt(addToBasket[1]);
                    basket.addProduct(assortment, indexOfProductAdd, amountAdd);
                    System.out.println("---Для просмотра корзины нажмите '4' ");
                    System.out.println("---Для уменьшения кол-ва товара в корзине нажмите '5' ");
                    System.out.println("---Для оформления заказа нажмите '6' ");
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Ваша корзина:");
                    System.out.println();
                    basket.toPrint();
                    break;
                case "5":
                    System.out.println("Введите номер товара из общего списка, кол-во которого хотите изменить. Через пробел укажите сколько " +
                            "единиц нужно убрать ");
                    String indexAndAmountDel = scanner.nextLine();
                    String[] delFromBasket = indexAndAmountDel.split(" ");
                    int indexOfProductDel = Integer.parseInt(delFromBasket[0]) - 1;
                    int amountDel = Integer.parseInt(delFromBasket[1]);
                    basket.deleteProduct(assortment, indexOfProductDel, amountDel);
                    System.out.println("---Для просмотра корзины нажмите '4' ");
                    System.out.println("---Для добавления товара в корзину нажмите '3' ");
                    System.out.println("---Для оформления заказа нажмите '6' ");
                    System.out.println();
                    break;
                case "6":
                    System.out.println("Successfully");
                    oder = false;
                    break;
                case "7":
                    System.out.println("Введите верхнюю границу цены ");
                    String maxPriceString = scanner.nextLine();
                    int maxPrice = Integer.parseInt(maxPriceString);
                    assortment.priceFilter(maxPrice);
                    break;
                default:
                    System.out.println("Неожиданный ввод");
            }
        }
    }
}