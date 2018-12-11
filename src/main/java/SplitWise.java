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

    /*private void assignExpense() {
        for (Friend friend : friends) {
            double spentAmount = friend.getSpentAmount();
            if ((spentAmount>(expenseOnEach))) {
                //spentAmount.setAmountToGetBack(spentAmount-expenseOnEach);
            } else {
                //spentAmount.setAmountToRepay(spentAmount-expenseOnEach);
            }
        }
    }*/

    private void resolve(Friend creditor, double creditorAmountToGetBack) {
        for (Friend debtor : friends) {
            double spentAmount = debtor.getSpentAmount();
            /*double debtorExpenseToRepay = spentAmount.getAmountToRepay();
            if (debtorExpenseToRepay != 0) {
                if (debtorExpenseToRepay == creditorAmountToGetBack) {
                    creditors.add(creditor); debtors.add(debtor);
                    break;
                } else if (!(debtorExpenseToRepay > creditorAmountToGetBack)) {
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    creditors.add(creditor); debtors.add(debtor);
                } else if (debtorExpenseToRepay > creditorAmountToGetBack) {
                    creditors.add(creditor); debtors.add(debtor);
                    spentAmount.setAmountToRepay(spentAmount.subtract(creditorAmountToGetBack));
                    break;
                }
            }*/
        }
    }

    void settle() {
        split();
        for (Friend creditor : friends) {
            double spentAmount = creditor.getSpentAmount();
            if (spentAmount > expenseOnEach) {
                double creditorAmountToGetBack = spentAmount - expenseOnEach;
                resolve(creditor, creditorAmountToGetBack);
            }
        }
    }

    int getDebtorsListSize() {
        return debtors.size();
    }
}
