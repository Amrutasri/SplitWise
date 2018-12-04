import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    Expense expense1 = new Expense(100);
    Friend friend1 = new Friend("A",expense1);
    Expense expense2 = new Expense(40);
    Friend friend2 = new Friend("B",expense2);
    List<Friend> friendList = new ArrayList<>();

    @DisplayName("should return an empty list when friend is not added at all.")
    @Test
    void shouldReturnEmptyListWhenFriendIsNotAddedAtAll() {
        Trip trip = new Trip(friendList);
        assertTrue(trip.getFriendList().isEmpty());
    }

    @DisplayName("The size of the friend list should be 2 when two friends A and B are added.")
    @Test
    void shouldReturnFriendListOfSize2WhenTwoFriendsAandBAreAdded() {
        friendList.add(friend1); friendList.add(friend2);
        Trip trip = new Trip(friendList);
        assertEquals(2,trip.getFriendList().size());
    }

}