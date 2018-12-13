import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class SplitWise {

    private List<Friend> friends;
    private List<Transaction> transactions;

    private double expenseOnEach;

    SplitWise(Trip trip) {
        friends = trip.getFriendList();
        transactions = new ArrayList<>();
    }

    private void calculateAverageOfSpentAmountOfFriends() {
        double totalSpentAmount = 0;
        for (Friend friend : friends) {
            double spentAmount = friend.getSpentAmount();
            totalSpentAmount = spentAmount + totalSpentAmount;
        }
        expenseOnEach = totalSpentAmount / friends.size();
    }

    private void resolve(Friend creditor, double creditorAmountToGetBack) {
        for (Friend debtor : friends) {
            if ((debtor.getSpentAmount() < expenseOnEach)&&(creditorAmountToGetBack!=0)) {
                debtor.setAmountToRepay(expenseOnEach - debtor.getSpentAmount());
                double debtorExpenseToRepay = debtor.getAmountToRepay();
                if (debtorExpenseToRepay > creditorAmountToGetBack) {
                    debtorExpenseToRepay = debtorExpenseToRepay - creditorAmountToGetBack;
                    transactions.add(new Transaction(creditorAmountToGetBack,creditor,debtor));
                    debtor.setAmountToRepay(debtorExpenseToRepay-creditorAmountToGetBack);
                    creditorAmountToGetBack = 0;
                }
                else {
                    transactions.add(new Transaction(debtorExpenseToRepay,creditor,debtor));
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    debtor.setAmountToRepay(0);
                }
            }
        }
    }

    List<Transaction> settle() {
        calculateAverageOfSpentAmountOfFriends();
        for (Friend creditor : friends) {
            if (creditor.getSpentAmount() > expenseOnEach) {
                double creditorAmountToGetBack = creditor.getSpentAmount()-expenseOnEach;
                resolve(creditor, creditorAmountToGetBack);
            }
        }
        return transactions;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SplitWise splitWise = (SplitWise) object;
        return Objects.equals(transactions, splitWise.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }
}
