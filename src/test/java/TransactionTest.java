import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TransactionTest {

    Friend friendA = new Friend("A",100);
    Friend friendB = new Friend("B",40);
    Transaction transaction1 = new Transaction(30,friendA,friendB);
    Transaction transaction2 = new Transaction(40,friendA,friendB);
    Transaction transaction3 = new Transaction(30,friendA,friendB);

    @Test
    void shouldReturn40AsAmount() {
        assertEquals(30, transaction1.getAmount());
    }

    @Test
    void shouldReturnFriendAAsCreditor() {
        assertEquals(friendA, transaction1.getCreditor());
    }

    @Test
    void shouldReturnFriendBAsDebtor() {
        assertEquals(friendB, transaction1.getDebtor());
    }

    @Test
    void shouldEqualTransactionItself() {
        assertEquals(transaction1, transaction1);
    }

    @Test
    void shouldEqualTransaction3WhichIsSameAsTransaction() {
        assertEquals(transaction1,transaction3);
    }

    @Test
    void shouldNotEqualTransactionWhereTheAmountIsDifferent() {
        assertNotEquals(transaction1,transaction2);
    }

}