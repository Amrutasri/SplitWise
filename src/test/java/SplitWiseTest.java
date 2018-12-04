import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SplitWiseTest {

    SplitWise splitWise;

    @BeforeEach
    public void init() {
        Expense expense1 = new Expense(100);
        Friend friend1 = new Friend("A", expense1);
        Expense expense2 = new Expense(40);
        Friend friend2 = new Friend("B",expense2);
        List<Friend> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        Trip trip = new Trip(friendList);
        splitWise = new SplitWise(trip);
    }

    @DisplayName("should be able to calculate expense on each between friends A and B as 70 where A spent 100 and B spent 40")
    @Test
    void shouldCalculateExpenseOnEachBetweenFriendsAandBAs70WhereASpent100andBSpent40() {
        assertEquals(70,splitWise.calculateExpenseOnEach());
    }

}