import java.util.ArrayList;
import java.util.List;

public class Friend {

    private String name;
    private double spentAmount;

    private List<Transaction> transactions;

    Friend(String name, double spentAmount) {
        this.name = name;
        this.spentAmount = spentAmount;
        transactions = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    double getSpentAmount() {
        return spentAmount;
    }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    List<Transaction> getTransactions() {
        return transactions;
    }
}
