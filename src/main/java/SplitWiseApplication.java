import java.util.ArrayList;
import java.util.List;

public class SplitWiseApplication {

    public static void main(String args[]) {

        InputDriver inputDriver = new InputDriver();
        OutputDriver outputDriver = new OutputDriver();

        outputDriver.print("Enter number of friends in trip: ");
        int numberOfFriends = inputDriver.readInputAsInteger();

        List<Friend> friends = new ArrayList<>(numberOfFriends);

        for(int index = 0 ; index<numberOfFriends ; index++) {
            outputDriver.print("Enter name of friend: ");
            String name = inputDriver.readInputAsString();
            outputDriver.print("Enter amount spent: ");
            double amountSpent = inputDriver.readInputAsDouble();
            Money money = new Money(amountSpent);
            Friend friend = new Friend(name,money);
            friends.add(friend);
        }

        Trip trip = new Trip(friends);

        SplitWise splitWise = new SplitWise(trip,outputDriver);
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
    }
}
