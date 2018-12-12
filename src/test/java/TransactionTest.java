import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    Friend friendA = new Friend("A",100);
    Friend friendB = new Friend("B",40);
    Transaction transaction = new Transaction(30,friendA,friendB);

    @Test
    void shouldReturn40AsAmount() {
        assertEquals(30,transaction.getAmount());
    }

    @Test
    void shouldReturnFriendAAsCreditor() {
        assertEquals(friendA,transaction.getCreditor());
    }

    @Test
    void shouldReturnFriendBAsDebtor() {
        assertEquals(friendB,transaction.getDebtor());
    }

}