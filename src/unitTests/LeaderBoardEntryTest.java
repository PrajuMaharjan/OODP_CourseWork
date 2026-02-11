package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import quizapp.LeaderboardEntry;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class LeaderBoardEntryTest {
    
    private LeaderboardEntry entry1;
    private LeaderboardEntry entry2;
    
    @BeforeEach
    public void setUp() {
        entry1 = new LeaderboardEntry(1, "player1", 100, 5);
        entry2 = new LeaderboardEntry(2, "player2", 85, 3);
    }
    
    @Test
    public void testConstructorFirstPlace() {
        assertEquals(1, entry1.getRank());
        assertEquals("player1", entry1.getUsername());
        assertEquals(100, entry1.getTotalScore());
        assertEquals(5, entry1.getTestsTaken());
    }
    
    @Test
    public void testConstructorSecondPlace() {
        assertEquals(2, entry2.getRank());
        assertEquals("player2", entry2.getUsername());
        assertEquals(85, entry2.getTotalScore());
        assertEquals(3, entry2.getTestsTaken());
    }
    
    @Test
    public void testSetRank() {
        entry1.setRank(10);
        assertEquals(10, entry1.getRank());
    }
    
    @Test
    public void testSetUsername() {
        entry1.setUsername("new_player");
        assertEquals("new_player", entry1.getUsername());
    }
    
    @Test
    public void testSetTotalScore() {
        entry1.setTotalScore(150);
        assertEquals(150, entry1.getTotalScore());
    }
    
    @Test
    public void testSetTestsTaken() {
        entry1.setTestsTaken(10);
        assertEquals(10, entry1.getTestsTaken());
    }
    
    @Test
    public void testLeaderboardEntryWithZeroScore() {
        LeaderboardEntry zeroEntry = new LeaderboardEntry(5, "newbie", 0, 1);
        assertEquals(0, zeroEntry.getTotalScore());
        assertEquals(1, zeroEntry.getTestsTaken());
    }
    
    @Test
    public void testLeaderboardEntryWithHighScore() {
        LeaderboardEntry highEntry = new LeaderboardEntry(1, "expert", 1000, 50);
        assertEquals(1000, highEntry.getTotalScore());
        assertEquals(50, highEntry.getTestsTaken());
    }
    
    @Test
    public void testUpdatingMultipleFields() {
        entry1.setRank(3);
        entry1.setTotalScore(200);
        entry1.setTestsTaken(8);
        
        assertEquals(3, entry1.getRank());
        assertEquals(200, entry1.getTotalScore());
        assertEquals(8, entry1.getTestsTaken());
    }
    
    @Test
    public void testLeaderboardEntryWithEmptyUsername() {
        LeaderboardEntry emptyEntry = new LeaderboardEntry(1, "", 50, 2);
        assertEquals("", emptyEntry.getUsername());
    }
    
    @Test
    public void testLeaderboardEntryWithNegativeRank() {
        LeaderboardEntry negativeEntry = new LeaderboardEntry(-1, "test", 100, 5);
        assertEquals(-1, negativeEntry.getRank());
    }
    
    @Test
    public void testRank10() {
        LeaderboardEntry rank10 = new LeaderboardEntry(10, "player10", 50, 2);
        assertEquals(10, rank10.getRank());
    }
}
