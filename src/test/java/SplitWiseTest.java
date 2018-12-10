import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SplitWiseTest {

    Transaction transaction = mock(Transaction.class);

    @DisplayName("should print friend B gives A -> 5.")
    @Test
    void shouldPrintFriendBGivesD_5() {
        Friend friend1 = new Friend("A", 100);
        Friend friend2 = new Friend("B", 40);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        splitWise.settle();

        verify(transaction).setCreditAmount(30);
        verify(transaction).setCreditor("A");

    }

    @DisplayName("should print B gives A -> 10 and C gives A -> 40. ")
    @Test
    void shouldPrint() {
        Friend friend1 = new Friend("A", 100);
        Friend friend2 = new Friend("B", 40);
        Friend friend3 = new Friend("C", 10);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        splitWise.settle();

    }

    @DisplayName("should print friend A gives D -> 10, B gives D -> 70, C gives D -> 10.")
    @Test
    void shouldPrintFriendAGivesD_10AndBGivesD_70AndCGivesD_10() {
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
        splitWise.settle();
    }
}