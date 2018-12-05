import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitWiseTest {

    @DisplayName("should print friend B gives D -> 5.")
    @Test
    void shouldPrintFriendBGivesD_5() {
        Expense expense1 = new Expense(50);
        Friend friend1 = new Friend("A", expense1);
        Expense expense2 = new Expense(40);
        Friend friend2 = new Friend("B",expense2);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        splitWise.printListOfDebtorsAndCreditors();

        assertEquals(1,splitWise.getDebtorsListSize());
    }

    @DisplayName("should print")
    @Test
    void shouldPrint() {
        Expense expense1 = new Expense(100);
        Friend friend1 = new Friend("A", expense1);
        Expense expense2 = new Expense(40);
        Friend friend2 = new Friend("B",expense2);
        Expense expense3 = new Expense(10);
        Friend friend3 = new Friend("C",expense3);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        splitWise.printListOfDebtorsAndCreditors();

        assertEquals(2,splitWise.getDebtorsListSize());
    }

    @DisplayName("should print friend A gives D -> 10, B gives D -> 70, C gives D -> 10.")
    @Test
    void shouldPrintFriendAGivesD_10AndBGivesD_70AndCGivesD_10() {
        Expense expense1 = new Expense(50);
        Friend friend1 = new Friend("A", expense1);
        Expense expense2 = new Expense(40);
        Friend friend2 = new Friend("B",expense2);
        Expense expense3 = new Expense(150);
        Friend friend3 = new Friend("C",expense3);
        Expense expense4 = new Expense(200);
        Friend friend4 = new Friend("D",expense4);

        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        friendList.add(friend3);
        friendList.add(friend4);

        Trip trip = new Trip(friendList);

        SplitWise splitWise = new SplitWise(trip);
        splitWise.printListOfDebtorsAndCreditors();

        assertEquals(3,splitWise.getDebtorsListSize());
    }
}