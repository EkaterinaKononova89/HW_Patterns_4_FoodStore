public class Oder {
    private double totalPrice = 0;

    public void sumOfOder(Oderable oderable) {
        totalPrice += oderable.totalPrice();
    }
}
