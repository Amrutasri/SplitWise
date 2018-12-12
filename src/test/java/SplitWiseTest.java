import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitWiseTest {

    @Test
    void shouldReturnAnEmptyTransactionListAsAmountSpentByEachFriendIsEqual() {
        Friend friendA = new Friend("A",44);
        Friend friendB = new Friend("B",44);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friendA);
        friendList.add(friendB);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);

        assertTrue(splitWise.settle().isEmpty());
    }

    @Test
    void shouldCalculateAverageAndAddToTransactionsDebtorBHasToPay30ToA() {
        Friend friend1 = new Friend("A", 100);
        Friend friend2 = new Friend("B", 40);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        List<Transaction> output = splitWise.settle();

        List<Transaction> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Transaction(30,friend1,friend2));

        assertEquals(expectedOutput,output);
    }

    @Test
    void shouldCalculateAverageAndAddToTransactionsThatDebtorBHasToPay10ToA_CHasToPay40ToA() {
        Friend friend1 = new Friend("A", 100);
        Friend friend2 = new Friend("B", 40);
        Friend friend3 = new Friend("C", 10);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        List<Transaction> output = splitWise.settle();

        List<Transaction> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Transaction(10,friend1,friend2));
        expectedOutput.add(new Transaction(40,friend1,friend3));

        assertEquals(expectedOutput,output);
    }

    @Test
    void shouldCalculateAverageAndAddToTransactionsThatDebtorAHasToPay10ToD_BHasToPay70ToD_CHasToPay10ToD() {
        Friend friend1 = new Friend("A", 100);
        Friend friend2 = new Friend("B", 40);
        Friend friend3 = new Friend("C", 100);
        Friend friend4 = new Friend("D", 200);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);
        friendList.add(friend4);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        List<Transaction> output = splitWise.settle();

        List<Transaction> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Transaction(10,friend4,friend1));
        expectedOutput.add(new Transaction(70,friend4,friend2));
        expectedOutput.add(new Transaction(10,friend4,friend3));

        assertEquals(expectedOutput,output);

    }
}