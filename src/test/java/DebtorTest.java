import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebtorTest {

    Debtor debtor = new Debtor("A",10);

    @DisplayName("should equal A as the name of the debtor is also A.")
    @Test
    void shouldEqualAasTheNameOfTheDebtor() {
        assertEquals("A",debtor.getName());
    }

    @DisplayName("should not equal a as the name of the debtor is A.")
    @Test
    void shouldNotEqual_a_AsTheNameOfTheDebtor() {
        assertNotEquals("a",debtor.getName());
    }

    @DisplayName("should equal 10 as the debt of Debtor is also 10.")
    @Test
    void shouldEqual10AsTheDebtOfDebtor() {
        assertEquals(10,debtor.getDebt());
    }

    @DisplayName("should not equal 100 as the debt of debtor is 10.")
    @Test
    void shouldNotEqual100AsTheDebtOfDebtorIs10() {
        assertNotEquals(100,debtor.getDebt());
    }

}