import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {

    Expense expense1 = new Expense(100);
    Expense expense2 = new Expense(40);
    Expense expense3 = new Expense(100);

    @DisplayName("expense1 should be equal to expense1.")
    @Test
    void expense1shouldEqualExpense1() {
        assertEquals(expense1,expense1);
    }

    @DisplayName("expense1 should not equal expense2 as their values of amountSpent are not equal.")
    @Test
    void expense1ShouldNotEqualExpense2AsTheirValuesOfAmountSpentAreNotEqual() {
        assertNotEquals(expense2,expense1);
    }

    @DisplayName("expense1 should equal 100.")
    @Test
    void expense1ShouldEqual100() {
        assertTrue(expense1.equals(100));
    }

    @DisplayName("expense1 should equal expense3 as their values of amountSpent are equal.")
    @Test
    void expense1ShouldEqualExpense3AsTheirValuesOfAmountSpentAreEqual() {
        assertEquals(expense1,expense3);
    }

    @DisplayName("should equal 100 when amountSpent is 100 and added with 0.")
    @Test
    void shouldEqual100WhenAmountSpentIs100AndAddedWith0() {
        assertEquals(100, expense1.add(0));
    }

    @DisplayName("should not equal 100 when amountSpent is 100 and added with 10.")
    @Test
    void shouldNotEqual100WhenAmountSpentIs100AndAddedWith10() {
        assertNotEquals(100, expense1.add(10));
    }

    @DisplayName("should equal 0 when amountSpent is 100 and subtracted with 100.")
    @Test
    void shouldEqual0WhenAmountSpentIs100AndSubtractedWith100() {
        assertEquals(0,expense3.subtract(100));
    }

    @DisplayName("should return true for expense1 that is 100 greater than 40.")
    @Test
    void shouldReturnTrueForExpense1ThatIs100IsGreaterThan40() {
        assertTrue(expense1.isGreater(40));
    }

    @DisplayName("should return false for expense2 that is 40 and is greater than 100.")
    @Test
    void shouldReturnFalseForExpense2ThatIs40AndIsGreaterThan100() {
        assertFalse(expense2.isGreater(100));
    }

}