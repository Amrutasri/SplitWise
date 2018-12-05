import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    Money money1 = new Money(100);
    Money money2 = new Money(40);
    Money money3 = new Money(100);

    @DisplayName("money1 should be equal to money1.")
    @Test
    void expense1shouldEqualExpense1() {
        assertEquals(money1, money1);
    }

    @DisplayName("money1 should not equal money2 as their values of amountSpent are not equal.")
    @Test
    void expense1ShouldNotEqualExpense2AsTheirValuesOfAmountSpentAreNotEqual() {
        assertNotEquals(money2, money1);
    }

    @DisplayName("money1 should equal 100.")
    @Test
    void expense1ShouldEqual100() {
        assertTrue(money1.equals(100));
    }

    @DisplayName("money1 should equal money3 as their values of amountSpent are equal.")
    @Test
    void expense1ShouldEqualExpense3AsTheirValuesOfAmountSpentAreEqual() {
        assertEquals(money1, money3);
    }

    @DisplayName("should equal 100 when amountSpent is 100 and added with 0.")
    @Test
    void shouldEqual100WhenAmountSpentIs100AndAddedWith0() {
        assertEquals(100, money1.add(0));
    }

    @DisplayName("should not equal 100 when amountSpent is 100 and added with 10.")
    @Test
    void shouldNotEqual100WhenAmountSpentIs100AndAddedWith10() {
        assertNotEquals(100, money1.add(10));
    }

    @DisplayName("should equal 0 when amountSpent is 100 and subtracted with 100.")
    @Test
    void shouldEqual0WhenAmountSpentIs100AndSubtractedWith100() {
        assertEquals(0, money3.subtract(100));
    }

    @DisplayName("should return true for money1 that is 100 greater than 40.")
    @Test
    void shouldReturnTrueForExpense1ThatIs100IsGreaterThan40() {
        assertTrue(money1.isGreater(40));
    }

    @DisplayName("should return false for money2 that is 40 and is greater than 100.")
    @Test
    void shouldReturnFalseForExpense2ThatIs40AndIsGreaterThan100() {
        assertFalse(money2.isGreater(100));
    }

}