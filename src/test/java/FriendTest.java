import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FriendTest {

    Friend friend = new Friend("A", 100);

    @DisplayName("should equal 100 which is assigned to the friend.")
    @Test
    void shouldEqual100WhichIsAssignedToFriend() {

        assertEquals(100,friend.getSpentAmount());
    }

    @DisplayName("should equal name of the friend as A")
    @Test
    void shouldEqualNameOfTheFriendAsA() {
        assertEquals("A",friend.getName());
    }

    @DisplayName("should not equal 100 as 40 is the spent amount assigned.")
    @Test
    void shouldNotEqual100As40IsTheAmountSpentAssigned() {
        assertNotEquals(100,friend.getSpentAmount());
    }

    @DisplayName("should not equal the name B as A is the name assigned.")
    @Test
    void shouldNotEqualTheNameBAsAIsTheNameAssigned() {
        assertNotEquals("B",friend.getName());
    }
}