import java.util.Objects;

public class Expense {

    private double spentAmount;

    Expense(double spentAmount) {
        this.spentAmount = spentAmount;
    }

    double add(double spentAmount) {
        return this.spentAmount + spentAmount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Expense expense = (Expense) object;
        return Double.compare(expense.spentAmount, spentAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(spentAmount);
    }
}
