import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FriendTest {

    Friend friend = new Friend("A", 100);
    Transaction transaction1 = mock(Transaction.class);
    Transaction transaction2 = mock(Transaction.class);

    @BeforeEach
    void init() {
        friend.addTransaction(transaction1);
    }

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

    @DisplayName("should add a Transaction to the list.")
    @Test
    void shouldAddATransactionToTheList() {
        assertTrue(friend.getTransactions().get(0).equals(transaction1));
    }

    @DisplayName("should not return the transaction2 which is not added to the list.")
    @Test
    void shouldNotReturnTheTransaction2WhichIsNotAddedToTheList() {
        assertFalse(friend.getTransactions().get(0).equals(transaction2));
    }
}