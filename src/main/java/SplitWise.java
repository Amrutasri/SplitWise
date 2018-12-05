import java.util.ArrayList;
import java.util.List;

public class SplitWise {

    private List<Friend> friends;
    private List<Friend> creditors;
    private List<Friend> debtors;

    private double expenseOnEach;

    private OutputDriver outputDriver;

    SplitWise(Trip trip, OutputDriver outputDriver) {
        friends = trip.getFriendList();
        this.outputDriver = outputDriver;
        creditors = new ArrayList<>();
        debtors =  new ArrayList<>();
    }

    private void split() {
        double totalSpentAmount = 0;
        for (Friend friend : friends) {
            Money money = friend.getMoney();
            totalSpentAmount = money.add(totalSpentAmount);
        }
        expenseOnEach = totalSpentAmount / friends.size();
    }

    private void assignExpense() {
        for (Friend friend : friends) {
            Money money = friend.getMoney();
            if ((money.isGreater(expenseOnEach))) {
                money.setAmountToGetBack(money.subtract(expenseOnEach));
            } else {
                money.setAmountToRepay(money.subtract(expenseOnEach));
            }
        }
    }

    private void resolve(Friend creditor, double creditorAmountToGetBack) {
        for (Friend debtor : friends) {
            Money debtorMoney = debtor.getMoney();
            double debtorExpenseToRepay = debtorMoney.getAmountToRepay();
            if (debtorExpenseToRepay != 0) {
                if (debtorExpenseToRepay == creditorAmountToGetBack) {
                    creditors.add(creditor); debtors.add(debtor);
                    break;
                } else if (!(debtorExpenseToRepay > creditorAmountToGetBack)) {
                    creditorAmountToGetBack = creditorAmountToGetBack - debtorExpenseToRepay;
                    creditors.add(creditor); debtors.add(debtor);
                } else if (debtorExpenseToRepay > creditorAmountToGetBack) {
                    creditors.add(creditor); debtors.add(debtor);
                    debtorMoney.setAmountToRepay(debtorMoney.subtract(creditorAmountToGetBack));
                    break;
                }
            }
        }
    }

    private void settle() {
        split();
        assignExpense();
        for (Friend creditor : friends) {
            Money creditorMoney = creditor.getMoney();
            if (creditorMoney.getAmountToRepay() == 0) {
                double creditorAmountToGetBack = creditorMoney.getAmountToGetBack();
                resolve(creditor, creditorAmountToGetBack);
            }
        }
    }

    void printFriendsWhoNeedToPayHowMuchToAFriend() {
        settle();
        for(int i=0; i<debtors.size(); i++) {
            outputDriver.print(debtors.get(i).getName());
            outputDriver.print(" -> ");
            outputDriver.print(creditors.get(i).getName());
            outputDriver.print(" = ");
            outputDriver.print(debtors.get(i).getMoney().getAmountToRepay());
            //System.out.println(debtors.get(i).getName() +" -> "+ creditors.get(i).getName() + " = "+ debtors.get(i).getMoney().getAmountToRepay());
        }
    }

    int getDebtorsListSize() {
        return debtors.size();
    }
}
