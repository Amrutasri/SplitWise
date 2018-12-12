import java.util.ArrayList;
import java.util.List;

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
            if (debtor.getSpentAmount() < expenseOnEach) {
                debtor.setAmountToRepay(expenseOnEach - debtor.getSpentAmount());
                double debtorExpenseToRepay = debtor.getAmountToRepay();
                if (debtorExpenseToRepay == creditorAmountToGetBack) {
                    transactions.add(new Transaction(debtorExpenseToRepay,creditor,debtor));
                    creditorAmountToGetBack = 0;
                    debtor.setAmountToRepay(0);

                }
                else if (debtorExpenseToRepay > creditorAmountToGetBack) {
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    transactions.add(new Transaction(creditorAmountToGetBack,creditor,debtor));
                    debtor.setAmountToRepay(debtorExpenseToRepay-creditorAmountToGetBack);
                }
                else if (debtorExpenseToRepay < creditorAmountToGetBack) {
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    transactions.add(new Transaction(debtorExpenseToRepay,creditor,debtor));
                    debtor.setAmountToRepay(0);
                }
            }
        }
    }

    void settle() {
        calculateAverageOfSpentAmountOfFriends();
        for (Friend creditor : friends) {
            if (creditor.getSpentAmount() > expenseOnEach) {
                double creditorAmountToGetBack = creditor.getSpentAmount()-expenseOnEach;
                resolve(creditor, creditorAmountToGetBack);
            }
        }
    }
}
