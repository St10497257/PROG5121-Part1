package prog5121poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login(
                "kyl_1", "Ch&&sec@ke99!",
                "+27838968976", "Kyle", "Smith"
        );

        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login(
                "kyle!!!!!!!", "Ch&&sec@ke99!",
                "+27838968976", "Kyle", "Smith"
        );

        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login(
                "kyl_1", "Ch&&sec@ke99!",
                "+27838968976", "Kyle", "Smith"
        );

        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login(
                "kyl_1", "password",
                "+27838968976", "Kyle", "Smith"
        );

        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login(
                "kyl_1", "Ch&&sec@ke99!",
                "+27838968976", "Kyle", "Smith"
        );

        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login(
                "kyl_1", "Ch&&sec@ke99!",
                "08966553", "Kyle", "Smith"
        );

        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login(
                "kyl_1", "Ch&&sec@ke99!",
                "+27838968976", "Kyle", "Smith"
        );

        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login(
                "kyl_1", "Ch&&sec@ke99!",
                "+27838968976", "Kyle", "Smith"
        );

        assertFalse(login.loginUser("kyl_1", "password"));
    }
}
