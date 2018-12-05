import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendTest {

    Money money1 = new Money(100);
    Money money2 = new Money(40);
    Money money3 = new Money(100);

    @DisplayName("should equal the money1 which is assigned to the friend.")
    @Test
    void shouldEqualTheExpenseWhichIsAssignedToFriend() {
        Friend friend = new Friend("A", money1);
        assertEquals(money1,friend.getMoney());
    }

    @DisplayName("should not equal the money1 which is not assigned to friend.")
    @Test
    void shouldNotEqualTheExpenseWhichIsNotAssignedToFriend() {
        Friend friend = new Friend("A", money2);
        assertNotEquals(money1,friend.getMoney());
    }

    @DisplayName("should equal money3 which is not assigned to friend and the money1 assigned to friend where the value is same.")
    @Test
    void shouldEqualTheExpense3WhichIsNotAssignedToFriendAndExpenseAssignedToFriendButValueIsSame() {
        Friend friend = new Friend("A", money1);
        assertEquals(money3,friend.getMoney());
    }

}