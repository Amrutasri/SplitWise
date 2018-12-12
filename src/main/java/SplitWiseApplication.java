import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SplitWiseApplication {

    private static InputDriver inputDriver = new InputDriver();
    private static OutputDriver outputDriver = new OutputDriver();

    public static void main(String args[]) {

        outputDriver.print("Enter number of friends ");
        int numberOfFriends = getValidInteger();

        boolean isValid = isValid(numberOfFriends);

        if(isValid) {
            List<Friend> friends = new ArrayList<>(numberOfFriends);

            for (int index = 0; index < numberOfFriends; index++) {
                outputDriver.print("Enter name of friend: ");
                String name = getValidString();
                outputDriver.print("Enter amount spent: ");
                int amountSpent = getValidInteger();
                Friend friend = new Friend(name, amountSpent);
                friends.add(friend);
            }

            Trip trip = new Trip(friends);

            SplitWise splitWise = new SplitWise(trip);
            List<Transaction> transactions = splitWise.settle();

            for (Transaction transaction : transactions) {
                outputDriver.print(transaction.getDebtor().getName());
                outputDriver.print("->");
                outputDriver.print(transaction.getCreditor().getName());
                outputDriver.print(", ");
                outputDriver.print(transaction.getAmount());
                outputDriver.print("\n");
            }
        }
        else {
            outputDriver.print("SplitWise needs minimum of 2 friends. ");
        }
    }

    private static int getValidInteger() {
        boolean isInt = true;
        String input = "";
        int numberOfFriends;
        Pattern pattern = Pattern.compile( ".*[^0-9].*" );
        while (isInt) {
            input = inputDriver.readInputAsString();
            isInt = pattern.matcher(input).matches();
            if (isInt) {
                outputDriver.print("Enter a valid number. ");
            }
        }
        numberOfFriends = Integer.parseInt(input);
        return numberOfFriends;
    }

    private static String getValidString() {
        boolean isString = false;
        String input1 = "";
        Pattern pattern1 = Pattern.compile(".*[^a-z][^A-Z].*");
        while (!(isString)) {
            input1 = inputDriver.readInputAsString();
            isString = pattern1.matcher(input1).matches();
            if(!(isString)) {
                outputDriver.print("Enter a valid name. ");
            }
        }
        return input1;
    }

    private static boolean isValid(int numberOfFriends) {
        return numberOfFriends >= 2;
    }
}
