import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputDriverTest {


    @DisplayName("should return an integer (in this case 1).")
    @Test
    void shouldReturnAnInteger() {
        setSystemIn("1");

        InputDriver inputDriver = new InputDriver();

        assertEquals(1,inputDriver.readInputAsInteger());
    }
    
    @DisplayName("should return double (in this case 15.47).")
    @Test
    void shouldReturn15Point47WhichIsDouble() {
        setSystemIn("15.47");

        InputDriver inputDriver = new InputDriver();

        assertEquals(15.47,inputDriver.readInputAsDouble());
    }

    @DisplayName("should return a string (in this case 'InputDriver').")
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