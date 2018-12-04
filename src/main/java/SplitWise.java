import java.util.List;

public class SplitWise {

    private List<Friend> friendList;
    private Expense expense;

    SplitWise(Trip trip) {
        friendList = trip.getFriendList();
    }

    double calculateExpenseOnEach() {
        double totalSpentAmount = 0;
        for(Friend friend : friendList) {
            expense = friend.getExpense();
            totalSpentAmount = expense.add(totalSpentAmount);
        }
        return totalSpentAmount/friendList.size();
    }
}
