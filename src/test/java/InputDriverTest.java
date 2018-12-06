import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {

    @DisplayName("should return 15.47 which is double.")
    @Test
    void shouldReturn15Point47WhichIsDouble() {
        setSystemIn("15.47");

        InputDriver inputDriver = new InputDriver();

        assertEquals(15.47,inputDriver.readInputAsDouble());
    }

    @DisplayName("should return InputDriver which is a string.")
    @Test
    void shouldReturnInputDriverWhichIsAString() {
        setSystemIn("InputDriver");

        InputDriver inputDriver = new InputDriver();

        assertEquals("InputDriver",inputDriver.readInputAsString());
    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void setUp() {
        System.setIn(System.in);
    }

}