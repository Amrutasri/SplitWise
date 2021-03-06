import java.util.Objects;

public class Money {

    private double spentAmount;
    private double amountToRepay=0;
    private double amountToGetBack=0;

    Money(double spentAmount) {
        this.spentAmount = spentAmount;
    }

    void setAmountToRepay(double amountToRepay) {
        this.amountToRepay = amountToRepay;
    }

    double getAmountToRepay() {
        return amountToRepay;
    }

    void setAmountToGetBack(double amountToGetBack) {
        this.amountToGetBack = amountToGetBack;
    }

    double getAmountToGetBack() {
        return amountToGetBack;
    }

    double add(double amount) {
        return spentAmount + amount;
    }

    boolean isGreater(double amount) {
        return spentAmount > amount;
    }

    boolean equals(double amount) {
        return spentAmount == amount;
    }

    double subtract(double amount) {
        if(isGreater(amount)) {
            return spentAmount - amount;
        }
        return amount - spentAmount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Money money = (Money) object;
        return Double.compare(money.spentAmount, spentAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(spentAmount);
    }
}
