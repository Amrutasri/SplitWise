import java.util.List;

public class SplitWise {

    private List<Friend> friendList;

    SplitWise(Trip trip) {
        friendList = trip.getFriendList();
    }

    double calculateExpenseOnEach() {
        double totalSpentAmount = 0;
        for(Friend friend : friendList) {
            totalSpentAmount = friend.trackExpense(totalSpentAmount);
        }
        return totalSpentAmount/friendList.size();
    }
}
