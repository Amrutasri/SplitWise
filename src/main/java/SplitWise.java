import java.util.ArrayList;
import java.util.List;

class SplitWise {

    private List<Friend> friends;
    private List<Friend> creditors;
    private List<Friend> debtors;

    private double expenseOnEach;

    SplitWise(Trip trip) {
        friends = trip.getFriendList();
        creditors = new ArrayList<>();
        debtors =  new ArrayList<>();
    }

    private void split() {
        double totalSpentAmount = 0;
        for (Friend friend : friends) {
            double spentAmount = friend.getSpentAmount();
            totalSpentAmount = spentAmount + totalSpentAmount;
        }
        expenseOnEach = totalSpentAmount / friends.size();
    }

    private void assignAmountToRepay() {
        for (Friend friend : friends) {
            double spentAmount = friend.getSpentAmount();
            if (spentAmount<expenseOnEach) {
                friend.setAmountToRepay(expenseOnEach-spentAmount);
            }
        }
    }

    private void resolve(Friend creditor, double creditorAmountToGetBack) {
        for (Friend debtor : friends) {
            double debtorExpenseToRepay = debtor.getAmountToRepay();
            if (debtorExpenseToRepay != 0) {
                if (debtorExpenseToRepay == creditorAmountToGetBack) {
                    Transaction transaction = new Transaction(debtorExpenseToRepay,creditor.getName());
                    debtor.addTransaction(transaction);
                    creditorAmountToGetBack = 0;
                    debtor.setAmountToRepay(0);

                }
                else if (debtorExpenseToRepay > creditorAmountToGetBack) {
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    Transaction transaction = new Transaction(creditorAmountToGetBack,creditor.getName());
                    debtor.addTransaction(transaction);
                    debtor.setAmountToRepay(debtorExpenseToRepay-creditorAmountToGetBack);
                }
                else if (debtorExpenseToRepay < creditorAmountToGetBack) {
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    Transaction transaction = new Transaction(debtorExpenseToRepay,creditor.getName());
                    debtor.addTransaction(transaction);
                    debtor.setAmountToRepay(0);
                }
            }
        }
    }

    void settle() {
        split();
        assignAmountToRepay();
        for (Friend creditor : friends) {
            if (creditor.getAmountToRepay() == 0) {
                double creditorAmountToGetBack = creditor.getSpentAmount()-expenseOnEach;
                resolve(creditor, creditorAmountToGetBack);
            }
        }
    }
}
