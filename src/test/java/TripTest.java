import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    Money money1 = new Money(100);
    Friend friend1 = new Friend("A", money1);
    Money money2 = new Money(40);
    Friend friend2 = new Friend("B", money2);
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