public class Transaction {

    private double amount;
    private Friend creditor;
    private Friend debtor;

    Transaction(double amount, Friend creditor, Friend debtor) {
        this.amount = amount;
        this.creditor = creditor;
        this.debtor = debtor;
    }

    double getAmount() {
        return amount;
    }

    Friend getCreditor() {
        return creditor;
    }

    Friend getDebtor() {
        return debtor;
    }
}
