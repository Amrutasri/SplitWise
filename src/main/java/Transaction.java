public class Transaction {

    private double amount;
    private String creditorName;

    Transaction(double amount, String name) {
        this.amount = amount;
        creditorName = name;
    }

    double getAmount() {
        return amount;
    }

    String getCreditorName() {
        return creditorName;
    }
}
