import java.util.ArrayList;
import java.util.List;

public class SplitWise {

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
            Expense expense = friend.getExpense();
            totalSpentAmount = expense.add(totalSpentAmount);
        }
        expenseOnEach = totalSpentAmount / friends.size();
    }

    private void assignExpense() {
        for (Friend friend : friends) {
            Expense expense = friend.getExpense();
            if ((expense.isGreater(expenseOnEach))) {
                expense.setAmountToGetBack(expense.subtract(expenseOnEach));
                System.out.println("amount to get back " + expense.getAmountToGetBack());
            } else {
                expense.setAmountToRepay(expense.subtract(expenseOnEach));
                System.out.println("amount to repay " + expense.getAmountToRepay());
            }
        }
    }

    private void resolve(Friend creditor, double creditorAmountToGetBack) {
        System.out.println("CreditorAmountToGetBack = " + creditorAmountToGetBack);
        for (Friend debtor : friends) {
            Expense debtorExpense = debtor.getExpense();
            double debtorExpenseToRepay = debtorExpense.getAmountToRepay();
            if (debtorExpenseToRepay != 0) {
                if (debtorExpenseToRepay == creditorAmountToGetBack) {
                    System.out.println("yes1");
                    creditors.add(creditor); debtors.add(debtor);
                    break;
                } else if (!(debtorExpenseToRepay > creditorAmountToGetBack)) {
                    System.out.println("yes3");
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    creditors.add(creditor); debtors.add(debtor);
                } else if (debtorExpenseToRepay > creditorAmountToGetBack) {
                    System.out.println("yes2");
                    creditors.add(creditor); debtors.add(debtor);
                    debtorExpense.setAmountToRepay(debtorExpense.subtract(creditorAmountToGetBack));
                    break;
                }
            }
        }
    }

    private void settle() {
        split();
        assignExpense();
        for (Friend creditor : friends) {
            Expense creditorExpense = creditor.getExpense();
            if (creditorExpense.getAmountToRepay() == 0) {
                double creditorAmountToGetBack = creditorExpense.getAmountToGetBack();
                resolve(creditor, creditorAmountToGetBack);
            }
        }
    }

    void printListOfDebtorsAndCreditors() {
        settle();
        for(int i=0; i<debtors.size(); i++) {
            System.out.println(debtors.get(i).getName() +" -> "+ creditors.get(i).getName() + " = "+ debtors.get(i).getExpense().getAmountToRepay());
        }
    }

    int getDebtorsListSize() {
        return debtors.size();
    }
}
