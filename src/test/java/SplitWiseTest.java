import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SplitWiseTest {

    OutputDriver outputDriver = mock(OutputDriver.class);

    @DisplayName("should print friend B gives A -> 5.")
    @Test
    void shouldPrintFriendBGivesD_5() {
        Money money1 = new Money(50);
        Friend friend1 = new Friend("A", money1);
        Money money2 = new Money(40);
        Friend friend2 = new Friend("B", money2);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip,outputDriver);
        splitWise.printFriendsWhoNeedToPayHowMuchToAFriend();

        Mockito.verify(outputDriver).print("B");
        Mockito.verify(outputDriver).print(" -> ");
        Mockito.verify(outputDriver).print("A");
        Mockito.verify(outputDriver).print(" = ");
        Mockito.verify(outputDriver).print(5.0);
    }

    @DisplayName("should print")
    @Test
    void shouldPrint() {
        Money money1 = new Money(100);
        Friend friend1 = new Friend("A", money1);
        Money money2 = new Money(40);
        Friend friend2 = new Friend("B", money2);
        Money money3 = new Money(10);
        Friend friend3 = new Friend("C", money3);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip,outputDriver);
        splitWise.printFriendsWhoNeedToPayHowMuchToAFriend();

        assertEquals(2,splitWise.getDebtorsListSize());
    }

    @DisplayName("should print friend A gives D -> 10, B gives D -> 70, C gives D -> 10.")
    @Test
    void shouldPrintFriendAGivesD_10AndBGivesD_70AndCGivesD_10() {
        Money money1 = new Money(50);
        Friend friend1 = new Friend("A", money1);
        Money money2 = new Money(40);
        Friend friend2 = new Friend("B", money2);
        Money money3 = new Money(150);
        Friend friend3 = new Friend("C", money3);
        Money money4 = new Money(200);
        Friend friend4 = new Friend("D", money4);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);
        friendList.add(friend4);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip,outputDriver);
        splitWise.printFriendsWhoNeedToPayHowMuchToAFriend();

        assertEquals(3,splitWise.getDebtorsListSize());
    }
}