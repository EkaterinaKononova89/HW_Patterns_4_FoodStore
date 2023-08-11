public enum Category {
    FRUITS_VEGETABLES("ФРУКТЫ И ОВОЩИ"),
    MEAT_PRODUCTS("МЯСНЫЕ ПРОДУКТЫ"),
    FISH("РЫБА И МОРЕПРОДУКТЫ"),
    MILK_CHEESE_EGS("МОЛОЧЫЕ ПРОДУКТЫ, СЫРЫ, ЯЙЦА"),
    PASTA_CEREALS("МАКАРОНЫ И КРУПЫ"),
    BAKERY_PRODUCTS("ХЛЕБОБУЛОЧНЫЕ ИЗДЕЛИЯ"),
    SWEETS("СЛАДОСТИ"),
    FOR_HOME("ТОВАРЫ ДЛЯ ДОМА");

    private String title;

    Category(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}
