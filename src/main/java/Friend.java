import java.util.Objects;

public class Friend {

    private String name;
    private Expense expense;

    Friend(String name, Expense expense) {
        this.name = name;
        this.expense = expense;
    }

    String getName() {
        return name;
    }

    Expense getExpense() {
        return expense;
    }

    @Override
    public boolean equals(Object object) {
        return object.getClass() == getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(expense);
    }
}
