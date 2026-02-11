package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quizapp.User;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
	
    private User regularUser;
    private User adminUser;
    
    @BeforeEach
    public void setUp() {
        regularUser=new User(1, "john_doe", false);
        adminUser=new User(2, "admin_user", true);
    }
    
    @Test
    public void testRegularUserConstructor() {
        assertEquals(1, regularUser.getUserId());
        assertEquals("john_doe", regularUser.getUsername());
        assertFalse(regularUser.getisAdmin());
    }
    
    @Test
    public void testAdminUserConstructor() {
        assertEquals(2, adminUser.getUserId());
        assertEquals("admin_user", adminUser.getUsername());
        assertTrue(adminUser.getisAdmin());
    }
    
    @Test
    public void testSetUserId() {
        regularUser.setUserId(100);
        assertEquals(100, regularUser.getUserId());
    }
    
    @Test
    public void testSetUsername() {
        regularUser.setUsername("new_username");
        assertEquals("new_username", regularUser.getUsername());
    }
    
    @Test
    public void testSetAdminToTrue() {
        regularUser.setAdmin(true);
        assertTrue(regularUser.getisAdmin());
    }
    
    @Test
    public void testSetAdminToFalse() {
        adminUser.setAdmin(false);
        assertFalse(adminUser.getisAdmin());
    }
    
    @Test
    public void testUserWithEmptyUsername() {
        User emptyUser = new User(3, "", false);
        assertEquals("", emptyUser.getUsername());
    }
    
    @Test
    public void testUserWithNegativeId() {
        User negativeIdUser = new User(-1, "test_user", false);
        assertEquals(-1, negativeIdUser.getUserId());
    }
    
    @Test
    public void testUserWithZeroId() {
        User zeroIdUser = new User(0, "test_user", false);
        assertEquals(0, zeroIdUser.getUserId());
    }
}
