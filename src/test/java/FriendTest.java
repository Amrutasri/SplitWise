import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendTest {

    Expense expense1 = new Expense(100);
    Expense expense2 = new Expense(40);
    Expense expense3 = new Expense(100);

    @DisplayName("should equal the expense1 which is assigned to the friend.")
    @Test
    void shouldEqualTheExpenseWhichIsAssignedToFriend() {
        Friend friend = new Friend("A",expense1);
        assertEquals(expense1,friend.getExpense());
    }

    @DisplayName("should not equal the expense1 which is not assigned to friend.")
    @Test
    void shouldNotEqualTheExpenseWhichIsNotAssignedToFriend() {
        Friend friend = new Friend("A",expense2);
        assertNotEquals(expense1,friend.getExpense());
    }

    @DisplayName("should equal expense3 which is not assigned to friend and the expense1 assigned to friend where the value is same.")
    @Test
    void shouldEqualTheExpense3WhichIsNotAssignedToFriendAndExpenseAssignedToFriendButValueIsSame() {
        Friend friend = new Friend("A",expense1);
        assertEquals(expense3,friend.getExpense());
    }

}