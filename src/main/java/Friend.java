public class Friend {

    private String name;
    private int spentAmount;

    private double amountToRepay = 0;

    Friend(String name, int spentAmount) {
        this.name = name;
        this.spentAmount = spentAmount;
    }

    String getName() {
        return name;
    }

    double getSpentAmount() {
        return spentAmount;
    }

    void setAmountToRepay(double amountToRepay) {
        this.amountToRepay = amountToRepay;
    }

    double getAmountToRepay() {
        return amountToRepay;
    }

    void isValidInput(int spentAmount) throws InvalidInputException {
        if(spentAmount<0) {
            throw new InvalidInputException();
        }
    }
}
