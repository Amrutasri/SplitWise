import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Transaction that = (Transaction) object;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(creditor, that.creditor) &&
                Objects.equals(debtor, that.debtor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, creditor, debtor);
    }
}
