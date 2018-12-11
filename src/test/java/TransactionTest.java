import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction transaction = new Transaction(100,"A");

    @DisplayName("should return 100 as the amount.")
    @Test
    void shouldReturn100AsAmount() {
        assertEquals(100,transaction.getAmount());
    }

    @DisplayName("should return A as the name of the creditor.")
    @Test
    void shouldReturnAAsTheNameOfTheCreditor() {
        assertEquals("A",transaction.getCreditorName());
    }

}