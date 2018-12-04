public class Friend {

    private String name;
    private Expense expense;

    Friend(String name, Expense expense) {
        this.name = name;
        this.expense = expense;
    }

    double trackExpense(double spentAmount) {
        return expense.add(spentAmount);
    }
}
